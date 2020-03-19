/** 
 * 
 * Copyright:   Copyright (c) 2011 
 * Company:     GRGBanking
 * @author:     VZ
 * Create at:   2011-4-11
 * 
 * Modification History: 
 * Date         Author      Description 
 * -----------  ---------   ---------------------------------------- 
 * 2011-4-11	VZ			Initial Create
 * 10 May 2011	VZ			Add method getRolePriviInfo() for Role Privilege Configuration
 */

package com.grgbanking.platform.module.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.XmlUtil;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.datadir.service.SysDatadirService;
import com.grgbanking.platform.module.security.dao.GrpRoleDao;
import com.grgbanking.platform.module.security.dao.RoleDao;
import com.grgbanking.platform.module.security.dao.RolePriviDao;
import com.grgbanking.platform.module.security.dao.UserRoleDao;
import com.grgbanking.platform.module.security.entity.Group;
import com.grgbanking.platform.module.security.entity.GrpRole;
import com.grgbanking.platform.module.security.entity.Role;
import com.grgbanking.platform.module.security.entity.RolePrivi;
import com.grgbanking.platform.module.security.entity.RolePriviInfo;
import com.grgbanking.platform.module.security.entity.User;
import com.grgbanking.platform.module.security.entity.UserRole;

/**
 * Role Management service<br>
 * 角色管理服务类.
 * 
 * @author vinson
 */
@Service
@Transactional
public class RoleService extends BaseService {
	/**
	 * Use spring's dependency injection facilities
	 */
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private GrpRoleDao grpRoleDao;

	@Autowired
	private RolePriviDao rolePriviDao;

	@Autowired
	private UserRoleDao userRoleDao;

	@Autowired
	SysDatadirService sysDatadirService;

	/**
	 * Get all the roles by search criteria where match by Role Id or Role Name
	 * 
	 * @param page
	 * @param filterParamMap
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Role> searchRole(final Page<Role> page, HashMap<String, String> propertyFilterMap) {
		if (propertyFilterMap == null) {
			propertyFilterMap = new HashMap<String, String>();
		}
		page.setOrderBy(AppConstants.ROLE_NAME);
		page.setOrder(Page.ASC);
		return roleDao.findPage(page, propertyFilterMap);
	}

	/**
	 * Create a new role
	 * 
	 * @param role
	 * @return
	 */
	public boolean newRole(Role role) {
		validateRole(role);

		// The Id should be null when create a new record
		if (role.getId() != null) {
			role.setId(null);
		}

		String roleName = role.getRoleName();

		Role existRole = roleDao.getByRoleName(roleName);

		/**
		 * Check to avoid the new created Role Id or Role Name duplicate with
		 * exist one
		 */
		if (existRole != null) {
			throw new AppException(MessageKeyConstants.SEC_EXIST_ROLE,
					"The Role Name already existed. Please change the Role Name and submit again.");
		}

		roleDao.save(role);

		return true;
	}

	/**
	 * Update an existed role
	 * 
	 * @param role
	 * @return
	 */
	public boolean updateRole(Role role) {
		validateRole(role);

		String roleId = role.getId();
		String roleName = role.getRoleName();

		validateRoleId(roleId);

		Role existRole = roleDao.getByRoleName(roleName);
		/**
		 * Update the role only when no duplicated Role Name
		 */
		if (existRole != null && !roleId.equals(existRole.getId())) {
			throw new AppException(MessageKeyConstants.SEC_EXIST_ROLE,
					"The Role Name already existed. Please change the Role Name and submit again.");
		}

		roleDao.copyUpdate(role);

		return true;
	}

	/**
	 * Delete a role
	 * 
	 * @param roleId
	 * @return
	 */
	public boolean deleteRole(String roleId) {
		validateRoleId(roleId);

		// Need to delete the related records in the related tables
		deleteGrpRole(roleId);
		deleteRolePrivi(roleId);
		deleteUserRole(roleId);
		roleDao.delete(roleId);

		return true;
	}

	/**
	 * Delete the Group Role relationship by role id
	 * 
	 * @param roleId
	 */
	private void deleteGrpRole(String roleId) {
		validateRoleId(roleId);

		grpRoleDao.deleteByRoleId(roleId);
	}

	/**
	 * Delete the Role Privilege relationship by role id
	 * 
	 * @param roleId
	 */
	private void deleteRolePrivi(String roleId) {
		validateRoleId(roleId);

		rolePriviDao.deleteByRoleId(roleId);
	}

	/**
	 * Delete the User Role relationship by role id
	 * 
	 * @param roleId
	 */
	private void deleteUserRole(String roleId) {
		validateRoleId(roleId);

		userRoleDao.deleteByRoleId(roleId);
	}

	/**
	 * Configure the Role Privilege relationship
	 * 
	 * @param roleId
	 * @param newPriviIds
	 */
	public boolean configureRolePrivi(String roleId, Collection<String> newPriviIds) {
		validateRoleId(roleId);

		// Delete the original Role Privilege relationship
		rolePriviDao.deleteByRoleId(roleId);

		// Insert the new Role Privilege relationship into table
		if (newPriviIds != null && newPriviIds.size() > 0) {
			for (String priviId : newPriviIds) {
				RolePrivi rolePrivi = new RolePrivi();
				rolePrivi.setRoleId(roleId);
				rolePrivi.setPriviId(priviId);

				rolePriviDao.save(rolePrivi);
			}
		}

		return true;
	}

	/**
	 * VZ 20110510 Get the given role's assigned and unassigned privilege info
	 * 
	 * @param roleId
	 * @return
	 */
	public String getRolePriviInfo(String roleId, String language) {
		validateRoleId(roleId);

		List<RolePriviInfo> rolePriviInfos = roleDao.getRolePriviInfo(language);
		Collection<String> assignedPrivis = rolePriviDao.getPrivisByRoleId(roleId);

		for (RolePriviInfo rolePriviInfo : rolePriviInfos) {
			String privi = rolePriviInfo.getId();
			for (String assignedPrivi : assignedPrivis) {
				if (privi.equals(assignedPrivi)) {
					rolePriviInfo.setSelected(true);
				}
			}
		}

		RolePriviInfo root = roleDao.getRoot(language);
		String[] fields = { AppConstants.ID, AppConstants.PARENT_ID, AppConstants.PARENT_NAME, AppConstants.CHILD_ID,
				AppConstants.CHILD_NAME, AppConstants.IS_BUTTON, AppConstants.SELECTED };

		String result = XmlUtil.genreatorTreeXml(root, AppConstants.CHILD_ID, AppConstants.CHILD_NAME,
				AppConstants.PARENT_ID, fields, rolePriviInfos);
		return result;
	}

	/**
	 * Configure the Role User relationship
	 * 
	 * @param roleId
	 * @param newUserIds
	 */
	public boolean configureRoleUser(String roleId, Collection<String> newUserIds) {
		validateRoleId(roleId);

		// Delete the original Role User relationship
		userRoleDao.deleteByRoleId(roleId);

		// Insert the new Role User relationship into table
		if (newUserIds != null && newUserIds.size() > 0) {
			for (String userId : newUserIds) {
				UserRole userRole = new UserRole();
				userRole.setRoleId(roleId);
				userRole.setUserId(userId);

				userRoleDao.save(userRole);
			}
		}

		return true;
	}

	/**
	 * Get the Users by Role Id
	 * 
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public Map getRoleUsers(String roleId) {
		// Get the assigned user list
		Collection assignedUserList = userRoleDao.getAssignedUsers(roleId);
		Collection assignedUserObjects = new ArrayList();
		constructUserObjects(assignedUserList, assignedUserObjects);

		Collection unassignedUserList = userRoleDao.getUnassignedUsers(roleId);
		Collection unassignedUserObjects = new ArrayList();
		constructUserObjects(unassignedUserList, unassignedUserObjects);

		Map roleUsers = new HashMap();
		roleUsers.put("assignedUserObjects", assignedUserObjects);
		roleUsers.put("unassignedUserObjects", unassignedUserObjects);

		return roleUsers;
	}

	/**
	 * Construct the User Object List
	 * 
	 * @param userList
	 * @param userObjects
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	private void constructUserObjects(Collection userList, Collection userObjects) {
		if (userList != null) {
			for (Iterator it = userList.iterator(); it.hasNext();) {
				Object[] o = (Object[]) it.next();
				String id = (String) o[0];
				String userName = (String) o[1];

				User user = new User();
				user.setId(id);
				user.setUserName(userName);

				userObjects.add(user);
			}
		}
	}

	/**
	 * Configure the Role Group relationship
	 * 
	 * @param roleId
	 * @param newGrpIds
	 */
	public boolean configureRoleGrp(String roleId, Collection<String> newGrpIds) {
		validateRoleId(roleId);

		// Delete the original Role Group relationship
		grpRoleDao.deleteByRoleId(roleId);

		// Insert the new Role Group relationship into table
		if (newGrpIds != null && newGrpIds.size() > 0) {
			for (String grpId : newGrpIds) {
				GrpRole grpRole = new GrpRole();
				grpRole.setRoleId(roleId);
				grpRole.setGrpId(grpId);

				grpRoleDao.save(grpRole);
			}
		}

		return true;
	}

	/**
	 * Get the Users by Role Id
	 * 
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public Map getRoleGrps(String roleId) {
		// Get the assigned user list
		Collection assignedGroupList = grpRoleDao.getAssignedGroups(roleId);
		Collection assignedGroupObjects = new ArrayList();
		constructGroupObjects(assignedGroupList, assignedGroupObjects);

		Collection unassignedGroupList = grpRoleDao.getUnassignedGroups(roleId);
		Collection unassignedGroupObjects = new ArrayList();
		constructGroupObjects(unassignedGroupList, unassignedGroupObjects);

		Map roleGrps = new HashMap();
		roleGrps.put("assignedGroupObjects", assignedGroupObjects);
		roleGrps.put("unassignedGroupObjects", unassignedGroupObjects);

		return roleGrps;
	}

	/**
	 * Construct the Group Object List
	 * 
	 * @param groupList
	 * @param groupObjects
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	private void constructGroupObjects(Collection groupList, Collection groupObjects) {
		if (groupList != null) {
			for (Iterator it = groupList.iterator(); it.hasNext();) {
				Object[] o = (Object[]) it.next();
				String id = (String) o[0];
				String grpName = (String) o[1];

				Group group = new Group();
				group.setId(id);
				group.setGrpName(grpName);

				groupObjects.add(group);
			}
		}
	}

	/**
	 * Validate the Role Id
	 * 
	 * @param roleId
	 */
	private void validateRoleId(String roleId) {
		if (!StringUtils.hasText(roleId)) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record has been selected. ");
		}
	}

	/**
	 * Validate the Role object that submitted from front end
	 * 
	 * @param role
	 * @return
	 */
	private boolean validateRole(Role role) {
		if (role == null) {
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again. ");
		}
		// if (!StringUtils.hasText(role.getId()))
		// throw new
		// SysException("Role Id can not be left empty. Please input Role Id and submit again. ");
		if (!StringUtils.hasText(role.getRoleName())) {
			throw new AppException(MessageKeyConstants.SEC_ROLE_NAME_NOT_NULL,
					"Role Name can not be left empty. Please input Role Name and submit again. ");
		}
		if (!StringUtils.hasText(role.getRoleLevel())) {
			throw new AppException(MessageKeyConstants.SEC_ROLE_LEVEL_NOT_NULL,
					"Role Level can not be left empty. Please select Role Level and submit again. ");
		}
		if (!StringUtils.hasText(role.getStatus())) {
			throw new AppException(MessageKeyConstants.SEC_STATUS_NOT_NULL,
					"Status can not be left empty. Please select Status and submit again. ");
		}

		return true;
	}

	/**
	 * 
	 * 日期：2011-5-4<br>
	 * 版本：V1.0<br>
	 * 描述：getRolePage(这里用一句话描述这个方法的作用) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-5-4 上午11:34:24 <br>
	 * 创建人 hyuan<br>
	 * ===============================================<br>
	 * 修改日期：2011-5-4<br>
	 * 修改人 Administrator<br>
	 * 修改描述 getRolePage(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param page
	 * @param filterParamMap
	 * @return Page<Role>
	 * @Exception 异常对象 <br>
	 */
	public Page<Role> getRolePage(final Page<Role> page, Map<String, String> propertyFilterMap) {
		if (propertyFilterMap == null) {
			propertyFilterMap = new HashMap<String, String>();
		}
		Page<Role> pagedir = roleDao.findPage(page, propertyFilterMap);
		return pagedir;

	}

	/**
	 * 
	 * 日期：2011-5-4<br>
	 * 版本：V1.0<br>
	 * 描述：deleteSelected(这里用一句话描述这个方法的作用) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-5-4 上午11:58:55 <br>
	 * 创建人 haoyuan<br>
	 * ===============================================<br>
	 * 修改日期：2011-5-4<br>
	 * 修改人 haoyuan<br>
	 * 修改描述 deleteSelected(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param args
	 *            void
	 * @Exception 异常对象 <br>
	 */
	public void deleteSelected(String[] args) {
		if (null != args && args.length > 0) {
			for (String arg : args) {
				Role role = roleDao.getByKey(arg);
				roleDao.delete(role);
			}
		}
	}

	/**
	 * 
	 * 日期：2011-5-4<br>
	 * 版本：V1.0<br>
	 * 描述：save(这里用一句话描述这个方法的作用) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-5-4 下午01:28:09 <br>
	 * 创建人 haoyuan<br>
	 * ===============================================<br>
	 * 修改日期：2011-5-4<br>
	 * 修改人 haoyuan<br>
	 * 修改描述 save(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param entity
	 * @return String
	 * @Exception 异常对象 <br>
	 */
	public String save(Role entity) {
		if ("0".equals(roleDao.checkAddRole(entity))) {
			roleDao.save(entity);
			return "0";
		} else {
			return "-1";
		}
	}

	/**
	 * 
	 * 日期：2011-5-4<br>
	 * 版本：V1.0<br>
	 * 描述：searchByRoleName(这里用一句话描述这个方法的作用) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-5-4 下午03:14:18 <br>
	 * 创建人 haoyuan<br>
	 * ===============================================<br>
	 * 修改日期：2011-5-4<br>
	 * 修改人 haoyuan<br>
	 * 修改描述 searchByRoleName(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param page
	 * @param roleName
	 * @param filterParamMap
	 * @return Page<Role>
	 * @Exception 异常对象 <br>
	 */
	@SuppressWarnings( { "rawtypes", "unchecked" })
	public Page<Role> searchByRoleName(final Page page, String roleName, Map propertyFilterMap) {
		if (propertyFilterMap == null) {
			propertyFilterMap = new HashMap<String, String>();
		}
		propertyFilterMap.put("LIKES_roleName", roleName);
		page.setOrderBy("id");
		Page<Role> pageRole = roleDao.findPage(page, propertyFilterMap);
		return pageRole;
	}

	/**
	 * 
	 * 日期：Aug 8, 2011<br>
	 * 版本：V1.0<br>
	 * 描述：getRoleLevels(这里用一句话描述这个方法的作用) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：Aug 8, 2011 2:04:05 PM <br>
	 * 创建人 Jonas<br>
	 * ===============================================<br>
	 * 修改日期：Aug 8, 2011<br>
	 * 修改人 Jonas<br>
	 * 修改描述 getRoleLevels(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param language
	 * @return List
	 * @Exception 异常对象 <br>
	 */
	@SuppressWarnings( { "rawtypes", "unchecked" })
	public List getRoleLevels(String language) {
		List<Object[]> roleLevelsList = sysDatadirService.getDatadirChildrenByPath(AppConstants.USERROLEMANAGER_PATH,
				language);
		return roleLevelsList;
	}

}
