/** 
 * 
 * Copyright:   Copyright (c) 2011 
 * Company:     GRGBanking
 * @author:     VZ
 * Create at:   2011-4-14
 * 
 * Modification History: 
 * Date         Author      Description 
 * -----------  ---------   ---------------------------------------- 
 * 2011-4-14	VZ			Initial Create
 */

package com.grgbanking.platform.module.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.security.dao.GroupDao;
import com.grgbanking.platform.module.security.dao.GrpRoleDao;
import com.grgbanking.platform.module.security.dao.UserGrpDao;
import com.grgbanking.platform.module.security.entity.Group;
import com.grgbanking.platform.module.security.entity.GrpRole;
import com.grgbanking.platform.module.security.entity.Role;
import com.grgbanking.platform.module.security.entity.User;
import com.grgbanking.platform.module.security.entity.UserGrp;

/**
 * User Group Management service<br>
 * 用户组管理服务类.
 * 
 * @author vinson
 */
@Service
@Transactional
public class GroupService extends BaseService {
	/**
	 * Use spring's dependency injection facilities
	 */
	@Autowired
	GroupDao groupDao;
	@Autowired
	GrpRoleDao grpRoleDao;
	@Autowired
	UserGrpDao userGrpDao;

	/**
	 * Get the Group by search criteria where match by Group Name Fuzzily
	 * 
	 * @param page
	 * @param grpName
	 * @return
	 */
	public Page<Group> searchGroup(final Page<Group> page, final String grpName) {
		return groupDao.getByGrpNameFuzzily(page, grpName);
	}

	/**
	 * Create a new Group
	 * 
	 * @param group
	 * @return
	 */
	public boolean newGroup(Group group) {
		validateGroup(group);

		// The Id should be null when create a new record
		if (group.getId() != null) {
			group.setId(null);
		}

		String grpName = group.getGrpName();
		Group existGroup = groupDao.getByGrpName(grpName);

		if (existGroup != null) {
			throw new AppException(MessageKeyConstants.SEC_EXIST_GROUP,
					"The Group Name has already existed. Please change the Group Name and submit again. ");
		}

		groupDao.save(group);

		return true;
	}

	/**
	 * Update the Group
	 * 
	 * @param group
	 * @return
	 */
	public boolean updateGroup(Group group) {
		validateGroup(group);
		String groupId = group.getId();
		validateGroupId(groupId);

		String grpName = group.getGrpName();
		Group existGroup = groupDao.getByGrpName(grpName);

		if (existGroup != null && !groupId.equals(existGroup.getId())) {
			throw new AppException(MessageKeyConstants.SEC_EXIST_GROUP,
					"The Group Name already existed. Please change the Group Name and submit again.");
		}
		groupDao.copyUpdate(group);

		return true;
	}

	/**
	 * Delete the Group by Group Id
	 * 
	 * @param groupId
	 * @return
	 */
	public boolean deleteGroup(String groupId) {
		validateGroupId(groupId);

		// Need to delete the related records in the related tables
		deleteGrpRole(groupId);
		deleteUserGrp(groupId);
		groupDao.delete(groupId);

		return true;
	}

	/**
	 * Batch delete a group list
	 * 
	 * @param groupIds
	 * @return
	 */
	public boolean batchDelete(Collection<String> groupIds) {
		if (groupIds == null || groupIds.size() == 0) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}

		for (String groupId : groupIds) {
			deleteGroup(groupId);
		}

		return true;
	}

	/**
	 * Delete the Group Role relationship by group id
	 * 
	 * @param groupId
	 */
	private void deleteGrpRole(String groupId) {
		validateGroupId(groupId);

		grpRoleDao.deleteByGrpId(groupId);
	}

	/**
	 * Delete the User Group relationship by group id
	 * 
	 * @param groupId
	 */
	private void deleteUserGrp(String groupId) {
		validateGroupId(groupId);

		userGrpDao.deleteByGrpId(groupId);
	}

	/**
	 * Configure the Group Role relationship
	 * 
	 * @param groupId
	 * @param newRoleIds
	 * @return
	 */
	public boolean configureGrpRole(String groupId, Collection<String> newRoleIds) {
		validateGroupId(groupId);

		// Delete original Group Role relationship
		grpRoleDao.deleteByGrpId(groupId);

		// Insert new Group Role relationship into table
		for (String roleId : newRoleIds) {
			GrpRole grpRole = new GrpRole();
			grpRole.setGrpId(groupId);
			grpRole.setRoleId(roleId);

			grpRoleDao.save(grpRole);
		}

		return true;
	}

	/**
	 * Get the roles by group id
	 * 
	 * @param grpId
	 * @return
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public Map getGrpRoles(String grpId) {
		// Get the assigned Role List
		Collection assignedRoleList = grpRoleDao.getAssignedRoles(grpId);
		Collection assignedRoleObjects = new ArrayList();
		// Construct the Assigned Role Object List
		constructRoleObjects(assignedRoleList, assignedRoleObjects);

		// Get the unassigned Role List
		Collection unassignedRoleList = grpRoleDao.getUnassignedRoles(grpId);
		Collection unassignedRoleObjects = new ArrayList();
		// Construct the unassigned Role Object List
		constructRoleObjects(unassignedRoleList, unassignedRoleObjects);

		Map grpRoles = new HashMap();
		grpRoles.put("assignedRoleObjects", assignedRoleObjects);
		grpRoles.put("unassignedRoleObjects", unassignedRoleObjects);

		return grpRoles;
	}

	/**
	 * Construct the Role Object List
	 * 
	 * @param roleList
	 * @param roleObjects
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	private void constructRoleObjects(Collection roleList, Collection roleObjects) {
		if (roleList != null) {
			for (Iterator it = roleList.iterator(); it.hasNext();) {
				Object[] o = (Object[]) it.next();
				String id = (String) o[0];
				String roleName = (String) o[1];

				Role role = new Role();
				role.setId(id);
				role.setRoleName(roleName);

				roleObjects.add(role);
			}
		}
	}

	/**
	 * Configure the Group User relationship
	 * 
	 * @param groupId
	 * @param newUserIds
	 * @return
	 */
	public boolean configureGrpUser(String groupId, Collection<String> newUserIds) {
		validateGroupId(groupId);

		// Delete original Group User relationship
		userGrpDao.deleteByGrpId(groupId);

		// Insert new Group User relationship into table
		for (String userId : newUserIds) {
			UserGrp userGrp = new UserGrp();
			userGrp.setGrpId(groupId);
			userGrp.setUserId(userId);

			userGrpDao.save(userGrp);
		}

		return true;
	}

	/**
	 * Get the Users by Group Id
	 * 
	 * @param grpId
	 * @return
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public Map getGrpUsers(String grpId) {
		// Get the assigned user list
		Collection assignedUserList = userGrpDao.getAssignedUsers(grpId);
		Collection assignedUserObjects = new ArrayList();
		// Construct the unassigned Role Object List
		constructUserObjects(assignedUserList, assignedUserObjects);

		// Get the unassigned user list
		Collection unassignedUserList = userGrpDao.getUnassignedUsers(grpId);
		Collection unassignedUserObjects = new ArrayList();
		// Construct the unassigned Role Object List
		constructUserObjects(unassignedUserList, unassignedUserObjects);

		Map grpUsers = new HashMap();
		grpUsers.put("assignedUserObjects", assignedUserObjects);
		grpUsers.put("unassignedUserObjects", unassignedUserObjects);

		return grpUsers;
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
	 * Validate Group Id
	 * 
	 * @param groupId
	 */
	private void validateGroupId(String groupId) {
		if (!StringUtils.hasText(groupId)) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}
	}

	/**
	 * Validate Group
	 * 
	 * @param group
	 * @return
	 */
	private boolean validateGroup(Group group) {
		if (group == null) {
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again. ");
		}

		if (!StringUtils.hasText(group.getGrpName())) {
			throw new AppException(MessageKeyConstants.SEC_GROUP_NAME_NOT_NULL,
					"Group Name can not be left empty. Please input Group Name and submit again. ");
		}
		if (!StringUtils.hasText(group.getStatus())) {
			throw new AppException(MessageKeyConstants.SEC_STATUS_NOT_NULL,
					"Group Status can not be left empty. Please select Group Status and submit again. ");
		}

		return true;
	}
}
