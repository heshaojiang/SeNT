/** 
 * 
 * Copyright:   Copyright (c) 2011 
 * Company:     GRGBanking
 * @author:     VZ
 * Create at:   2011-4-12
 * 
 * Modification History: 
 * Date         Author      Description 
 * -----------  ---------   ---------------------------------------- 
 * 2011-4-12	VZ			Initial Create
 */

package com.grgbanking.platform.module.security.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.exception.SimpleAppException;
import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.exception.SysException;
import com.grgbanking.platform.core.security.service.Des;
import com.grgbanking.platform.core.security.service.interfaces.IUserService;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.springsecurity.SpringSecurityUtils;
import com.grgbanking.platform.core.utils.AppCoreConstants;
import com.grgbanking.platform.core.utils.DateUtils;
import com.grgbanking.platform.core.utils.ImportExcelUtil;
import com.grgbanking.platform.core.utils.MD5Util;
import com.grgbanking.platform.core.utils.RegExpUtils;
import com.grgbanking.platform.module.area.dao.AreaDao;
import com.grgbanking.platform.module.area.entity.Area;
import com.grgbanking.platform.module.area.service.AreaService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.datadir.service.SysDatadirService;
import com.grgbanking.platform.module.exproperty.dao.ExtendPropertyDao;
import com.grgbanking.platform.module.exproperty.entity.ExtendProperty;
import com.grgbanking.platform.module.exproperty.service.ExPropertyService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.platform.module.security.dao.UserGrpDao;
import com.grgbanking.platform.module.security.dao.UserRoleDao;
import com.grgbanking.platform.module.security.entity.Group;
import com.grgbanking.platform.module.security.entity.Role;
import com.grgbanking.platform.module.security.entity.User;
import com.grgbanking.platform.module.security.entity.UserGrp;
import com.grgbanking.platform.module.security.entity.UserRole;
import com.grgbanking.platform.module.term.entity.TermBrand;
import com.grgbanking.platform.module.term.entity.TermModel;
import com.grgbanking.platform.module.term.entity.TermType;
import com.grgbanking.platform.module.term.service.TermBrandService;
import com.grgbanking.platform.module.term.service.TermModelService;
import com.grgbanking.platform.module.term.service.TermTypeService;
import com.grgbanking.sent.utils.POIUtils;


import flex.messaging.FlexContext;

/**
 * User Management service<br>
 * 用户管理服务类.
 * 
 * @author vinson
 */
@Service
@Transactional
public class UserService extends BaseService implements IUserService
{
	
	
	@Autowired
	TermModelService termModelService;
	@Autowired
	TermBrandService termBrandService;
	@Autowired
	TermTypeService termTypeService;
	@Autowired
	AreaService areaService;
	
	/** 扩展属性 */
	public static Map<String, String> exPropertyMap = new HashMap<String, String>();

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public String importUserInfoExcel(byte[] file) {
		List<User> importList = new ArrayList<User>();

		InputStream is = new ByteArrayInputStream(file);

		HSSFWorkbook wb;
		try {
			wb = new HSSFWorkbook(is);
			importList = ImportExcelUtil.importExcel(wb, 10, User.class);
		} catch (Exception e) {
			logger.error("读取excel内容出错。", e);
			return "excel内容格式错误,导入失败,请检查!";
			// throw new RuntimeException(e);
		}

		String rootAreaId = areaDao.getByParentId2(
				areaDao.getRootArea().getId()).get(0).getId();
		// String rootOrgId =
		// orgInfoDao.getByParentId2(orgInfoDao.getRootOrg().getId()).get(0).getId();
		for (User user : importList) {

			if (user.getUserName() == null) {
				throw new SimpleAppException("用户姓名为空，不能导入");
			}
			if (user.getUserCode() == null) {
				throw new SimpleAppException("用户姓名\"" + user.getUserName()
						+ "的用户账号不能为空");
			}
			if (user.getOrgId() == null) {
				throw new SimpleAppException("用户姓名\"" + user.getUserName()
						+ "的机构号不能为空");
			}
			OrgInfo org = orgInfoDao.getByOrgCode(user.getOrgId());
			if (org == null) {
				org = orgInfoDao
						.getByParentId2(orgInfoDao.getRootOrg().getId()).get(0);
			}

			user.setOrgId(org.getId());
			user.setAreaId(rootAreaId);
			user.setPosLevel("0");
			user.setPosType("0");
			user.setStatus("Y");
			user.setMultiOnline("Y");
			user.setLoginFailCount(0);
			user.setLoginPwd(AppCoreConstants.DEFAULT_PWD);
			user.setCreateTime(new Date());
			String resultCode = save(user);

			// 为用户分配角色
//			Collection<String> coll = new ArrayList<String>();
//			coll.add("ff80808146361ac201463748b313001c");
//			configureUserRole(user.getId(), coll);
			
			if ("-1".equals(resultCode)) {
				return user.getUserCode() + "已经存在，该条数据及以下数据未导入。";
			}
		}

		return "导入成功";
	}
	
	
	
	@Autowired
	public void loadExproperty(ExPropertyService service, ExtendPropertyDao exPropertyDao)
	{
		List<ExtendProperty> exPropertyList = service.getExtendPropertyList(User.TABLE_NAME);
		for (ExtendProperty ex : exPropertyList)
		{
			exPropertyMap.put(ex.getPropertyName(), ex.getEntityClassProperty());
		}
	}

	/**
	 * Use spring's dependency injection facilities
	 */
	@Autowired
	private UserDao userDao;

	@Autowired
	private UserGrpDao userGrpDao;

	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private OrgInfoDao orgInfoDao;
	
	@Autowired
	private AreaDao areaDao;
	
	@Autowired
	private ParamDao paramDao;

	@Autowired
	SysDatadirService sysDatadirService;

	@SuppressWarnings("unchecked")
	
	// @Override
	@Transactional(readOnly = true)
	public Map<String, Object> getUserInfoByUserCode(String userCode)
	{
		if( !StringUtils.hasText(userCode) )
		{
			throw new AppException(MessageKeyConstants.SEC_USER_CODE_NOT_NULL, "User Code can not be left empty. Please input User Code and submit again. ");
		}

		User user = userDao.getByUserCode(userCode);
		
		//用户密码错误次数提醒
		if(user==null){
			Des desObj = new Des();
			userCode = desObj.strDec(userCode, "0123456789", null, null);
			user = userDao.getByUserCode(userCode);
		}
		

		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			result = BeanUtils.describe(user);
			// 因为经过describe后日期类型的数据会转换成字符串，所以此处将user传入，以保留最原始数据
			// added by hhquan start
			result.put(AppConstants.USER_BASE_INFO, user);
			// added by hhquan end
			if( user != null )
			{
				// 设置权限
				Map<String, Object> priviMap = retrieveUserPrivilege(user.getId());
				result.putAll(priviMap);

				// 设置父机构
				OrgInfo org = orgInfoDao.get(user.getOrgId());
				if( org != null )
				{
					result.put(AppConstants.ORG_ID, org.getId());
					result.put(AppConstants.ORG_CODE, org.getOrgCode());
					result.put(AppConstants.ORG_NAME, org.getOrgName());
					result.put(AppConstants.ORG_FULL_NAME, org.getOrgFullName());
					result.put(AppConstants.ORG_PARENT_ID, org.getParentId());
					result.put(AppConstants.ORG_PATH_CODE, org.getPathCode());
					result.put(AppConstants.ORG_FINACIAL_CODE, org.getFinacialCode());
				}

				// 设置账号过期
				if( user.getInvalidDate() != null && new Date().after(user.getInvalidDate()) )
				{
					result.put(AppConstants.ACCOUNT_EXPIRED, AppCoreConstants.YES);
				}

				// 设置密码过期提醒时间
				result.put(AppConstants.PASSWORD_REMIND_DAYS, paramDao.getValueByPath(AppConstants.PASSWORD_REMIND_DAYS_PATH));

				// 设置用户前台会话超时时间
				result.put(AppConstants.FLEX_TIMEOUT, paramDao.getValueByPath(AppConstants.FLEX_TIMEOUT_PATH));
			}
		}
		catch( IllegalAccessException e )
		{
			throw new SysException("IllegalAccessException occur while describe the User bean to Map.", e);
		}
		catch( InvocationTargetException e )
		{
			throw new SysException("InvocationTargetException occur while describe the User bean to Map.", e);
		}
		catch( NoSuchMethodException e )
		{
			throw new SysException("NoSuchMethodException occur while describe the User bean to Map.", e);
		}

		return result;
	}

	/**
	 * Get the User Groups, Roles, Privileges
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true)
	private Map<String, Object> retrieveUserPrivilege(String userId)
	{
		// Retrieve the group ids, role ids, privilege ids from view "UserInfo"
		// by user id
		// Collection<Object> userInfoList =
		// userDao.getUserInfoByUserId(userId);
		//
		// List<String> grpIds = new ArrayList<String>();
		// List<String> roleIds = new ArrayList<String>();
		// List<String> priviIds = new ArrayList<String>();
		//
		// for (Iterator<Object> it = userInfoList.iterator(); it.hasNext();) {
		// /*
		// * o[0] - user id o[1] - group id o[2] - role id o[3] - privilege id
		// */
		// Object[] o = (Object[]) it.next();
		//
		// String grpId = (String) o[1];
		// String roleId = (String) o[2];
		// String priviId = (String) o[3];
		//
		// if (!grpIds.contains(grpId)) {
		// grpIds.add(grpId);
		// }
		// if (!roleIds.contains(roleId)) {
		// roleIds.add(roleId);
		// }
		// if (!priviIds.contains(priviId)) {
		// priviIds.add(priviId);
		// }
		// }
		//
		Map<String, Object> priviMap = new HashMap<String, Object>();

		// 设置用户有操作权限的按钮
		Map<Object, List<Object>> menuButtonMap = new HashMap<Object, List<Object>>();
		List<Object[]> buttons = userDao.getButtonsOfUser(userId);
		for( Object[] one : buttons )
		{
			if( menuButtonMap.get(one[0]) == null )
			{	// 菜单对应 buttons集合不存在
				List<Object> list = new ArrayList<Object>();
				list.add(one[1]); // 添加button到buttons
				menuButtonMap.put(one[0], list);
			}
			else
			{
				List<Object> list = (menuButtonMap.get(one[0]));
				list.add(one[1]);
			}
		}
		priviMap.put(AppConstants.PRIVI_BUTTONS, menuButtonMap);

		// 设置用户有操作权限的图标按钮
		Map<Object, List<Object>> menuIconsMap = new HashMap<Object, List<Object>>();
		List<Object[]> icons = userDao.getIconsOfUser(userId);
		for( Object[] one : icons )
		{
			if( menuIconsMap.get(one[0]) == null )
			{	// 菜单对应 buttons集合不存在
				List<Object> list = new ArrayList<Object>();
				list.add(one[1]); // 添加button到buttons
				menuIconsMap.put(one[0], list);
			}
			else
			{
				List<Object> list = (menuIconsMap.get(one[0]));
				list.add(one[1]);
			}
		}
		priviMap.put(AppConstants.PRIVI_ICONS, menuIconsMap);

		// 设置用户的权限的列表
		Map<Object, List<Object>> privisMap = new HashMap<Object, List<Object>>();
		List<Object[]> privis = userDao.getPrivisOfUser(userId);
		for( Object[] one : privis )
		{
			if( privisMap.get(one[0]) == null )
			{	// 菜单对应 buttons集合不存在
				List<Object> list = new ArrayList<Object>();
				list.add(one[1]); // 添加button到buttons
				privisMap.put(one[0], list);
			}
			else
			{
				List<Object> list = (privisMap.get(one[0]));
				list.add(one[1]);
			}
		}
		priviMap.put(AppConstants.PRIVI_PRIVIS, privisMap);

		return priviMap;
	}

	/**
	 * Create a new User by Admin
	 * 
	 * @param user
	 * @return
	 */

	public boolean newUser(User user)
	{
		validateUser(user);

		// The Id should be null when create a new record
		if (user.getId() != null)
		{
			user.setId(null);
		}

		String userCode = user.getUserCode();
		User existUser = userDao.getByUserCode(userCode);
		if (existUser != null)
		{
			throw new AppException(MessageKeyConstants.SEC_EXIST_USER, "The User Code has already existed. Please change a new User Code and submit again. ");
		}

		/*
		 * Use default password when initially create and user must change the
		 * original password when first login
		 */

		// TODO Do not append password suffix in Phase I
		// user.setLoginPwd(MD5Util.stringToMD5(user.getUserCode() +
		// AppCoreConstants.PWD_SUFFIX));
		// user.setLoginPwd(MD5Util.stringToMD5(AppCoreConstants.DEFAULT_PWD +
		// AppCoreConstants.PWD_SUFFIX));
		user.setLoginPwd(MD5Util.stringToMD5(AppCoreConstants.DEFAULT_PWD));
		user.setCreateTime(new Date());
		userDao.save(user);

		return true;
	}

	/**
	 * Update an existed User
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user)
	{
		// Id can not be null when update a user.
		String id = user.getId();
		validateUser(user);
		validateId(id);

		String userCode = user.getUserCode();
		User existUser = userDao.getByUserCode(userCode);
		if (existUser != null && !id.equals(existUser.getId()))
		{
			throw new AppException(MessageKeyConstants.SEC_EXIST_USER, "The User Code already existed. Please change the User Code and submit again.");
		}
			
		if( "Y".equals(user.getStatus()) )
		{
			user.setLoginFailCount(0);
		}
		
		userDao.copyUpdate(user, new String[] { AppCoreConstants.LOGIN_PWD });

		return true;
	}

	/**
	 * Delete a User
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteUser(String id)
	{
		validateId(id);

		// Need to delete the related records in the related tables
		User user = userDao.getByKey(id);
		String userId = user.getUserCode();

		deleteUserGrp(userId);
		deleteUserRole(userId);
		userDao.delete(id);

		return true;
	}

	/**
	 * Delete the User Group relationship by user id
	 * 
	 * @param userId
	 */
	private void deleteUserGrp(String userId)
	{
		if (!StringUtils.hasText(userId))
			// throw new SysException("User Id is null. ");
			throw new SysException("User Id is null. ");

		userGrpDao.deleteByUserId(userId);
	}

	/**
	 * Delete the User Role relationship by user id
	 * 
	 * @param userId
	 */
	private void deleteUserRole(String userId)
	{
		if (!StringUtils.hasText(userId))
		{
			// throw new SysException("User Id is null. ");
			throw new SysException("User Id is null. ");
		}

		userRoleDao.deleteByUserId(userId);
	}

	/**
	 * Search User match by the input keyword
	 * 
	 * @param page
	 * @param filterParamMap
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public Page<User> searchUserByUserName(final Page page, String userName, Map propertyFilterMap)
	{
		if (propertyFilterMap == null)
		{
			propertyFilterMap = new HashMap<String, String>();
		}
		propertyFilterMap.put("LIKES_userName", userName);
		page.setOrderBy("id");
		Page<User> pageUser = userDao.findPage(page, propertyFilterMap);
		return pageUser;
	}

	/**
	 * 
	 * @param page
	 * @param filterParamMap
	 * @return
	 */
	public Page<User> getUserPage(final Page<User> page, Map<String, String> filterParamMap)
	{
		if( filterParamMap == null )
		{
			filterParamMap = new HashMap<String, String>();
		}
		page.setOrderBy("id");
		Page<User> pageUser = userDao.getUserPage(page, filterParamMap);
		return pageUser;
	}
	
	public String exportUserInfo(Map<String, String> filterParamMap)
	{
		List<User> users = userDao.getUserPageForExport(filterParamMap);
		
		ArrayList<Object[]> dataList = new ArrayList<Object[]>();
		HttpServletRequest request = FlexContext.getHttpRequest();

		String fileName = UUID.randomUUID() + "User.xls";
		String filePath = request.getSession().getServletContext().getRealPath(
				"")
				+ File.separator + "exportFile" + File.separator + fileName;// 导出文件路径
		String modelName = request.getSession().getServletContext()
				.getRealPath("")
				+ File.separator
				+ "exportFile"
				+ File.separator + "User1.xls";// 文件模板路径
		
		Object[] row;
		List<OrgInfo> orgInfos = orgInfoDao.getAll();
		List<TermModel> termModels = termModelService.getAllTermModel();
		List<TermBrand> termBrands = termBrandService.getAllTermBrand();
		List<TermType> termTypes = termTypeService.getAllTermType();
		List<Area> areas = areaService.getAllArea();
		for (int i = 0; i < users.size(); i++) {
			row = new Object[7];
			User user = (User) users.get(i);
			row[0] = user.getUserName();
			row[1] = user.getUserCode();
			
			for (OrgInfo orgInfo : orgInfos) {
				if(orgInfo.getId().equals(user.getOrgId())) {
					row[2] = orgInfo.getOrgName();
					break;
				}
			}
			row[3] = user.getTel() == null ? "" : user.getTel();
			row[4] = user.getEmail() == null ? "" : user.getEmail();
			
			for (Area area : areas) {
				if (area.getId().equals(user.getAreaId())) {
					row[5] = area.getAreaName();
					break;
				}
			}
			
			row[6] = user.getStatus().equals("Y") ? "启用" : "禁用";
			dataList.add(row);
		}
		String fileUrl = POIUtils.makeExcelFile(dataList, modelName, filePath);
		return fileName;
	}
	
	public String makeExcelFile(ArrayList dataList, String modelName,
			String filePath) {
		HSSFWorkbook templatewb = null;
		int perSize = 7000;
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					modelName));
			templatewb = new HSSFWorkbook(fs);
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}
		try {
			int sheetNo = dataList.size() % perSize > 0 ? dataList.size()
					/ perSize + 1 : dataList.size() / perSize;
			for (int sheet = 0; sheet < sheetNo; sheet++) {
				HSSFSheet tosheet = templatewb.getSheetAt(sheet);

				// data row
				int size = dataList.size();
				HSSFRow templateRow = tosheet.getRow(1);
				HSSFCellStyle[] styles = new HSSFCellStyle[templateRow
						.getPhysicalNumberOfCells()];
				for (int i = 0; i < templateRow.getPhysicalNumberOfCells(); i++) {
					styles[i] = templateRow.getCell(i).getCellStyle();
				}
				int rowSize = (sheet + 1) * perSize > size ? size : (sheet + 1)
						* perSize;
				for (int rowId = sheet * perSize; rowId < rowSize; rowId++) {

					Object[] valueList = (Object[]) dataList.get(rowId);
					HSSFRow hssfRow = tosheet.createRow(rowId + 2);
					for (int columnId = 0; columnId < (0 + valueList.length); columnId++) {
						String dataValue = String.valueOf(valueList[columnId]);

						HSSFCell cell = hssfRow.createCell(columnId);

						cell.setCellValue(dataValue);

					}
				}
			}
			// write data to new file
			OutputStream os = new FileOutputStream(new File(filePath));
			templatewb.write(os);
			os.flush();
			os.close();
		} catch (OutOfMemoryError e) {
			logger.error("Data Exceeded!", e);
			return null;
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}
		return filePath;

	}

	/**
	 * Change the password, and the password should be encrypt before save into
	 * DB
	 * 
	 * @param id
	 * @param oldPwd
	 * @param newPwd1
	 * @param newPwd2
	 * @return
	 */
	public boolean changePassword(String id, String oldPwd, String newPwd1, String newPwd2)
	{
		validateId(id);

		if (!StringUtils.hasText(oldPwd))
			throw new AppException(MessageKeyConstants.SEC_OLD_PWD_NOT_NULL,
					"Old password can not be left empty. Please input old password and submit again. ");
		if (!StringUtils.hasText(newPwd1) || !StringUtils.hasText(newPwd2))
			throw new AppException(MessageKeyConstants.SEC_NEW_PWD_NOT_NULL,
					"New password can not be left empty. Please input new password and submit again. ");
		// Check whether the two new passwords that user input are match
		if (!newPwd1.equals(newPwd2))
			throw new AppException(MessageKeyConstants.SEC_TWO_NEW_PWD_INCONSISTENT,
					"The Two New Password Inconsistent!");
		// Check is the password match the naming pattern, e.g. "abc123"
//		if (!RegExpUtils.parsePassword(newPwd1))
//			throw new AppException(MessageKeyConstants.SEC_PWD_TOO_SIMPLE,
//					"The password is too simple. It must be contain with a-Z, 0-9 and the length can not be less that 6 or more than 32.");

		User user = userDao.getByKey(id);

		if (user == null)
			throw new AppException(MessageKeyConstants.SEC_USER_NOT_FOUND, "The user is not found. ");

		// TODO Do not append password suffix in Phase I
		// if (!MD5Util.stringToMD5(oldPwd +
		// AppCoreConstants.PWD_SUFFIX).equals(user.getLoginPwd()))
		if (!oldPwd.equals(user.getLoginPwd()))
			throw new AppException(MessageKeyConstants.SEC_INCORRECT_OLD_PWD, "The old password is incorrect.");

		user.setLoginPwd(newPwd1);

		user.setPwInvalidDate(resetInvalidDate());

		return true;
	}

	/**
	 * Reset the password to default value "111111"
	 * 
	 * @param id
	 * @return
	 */
	public boolean resetPassword(String id) {
		validateId(id);
		User user = userDao.getByKey(id);
		// TODO Do not append password suffix in Phase I
		// user.setLoginPwd(MD5Util.stringToMD5(AppCoreConstants.DEFAULT_PWD +
		// AppCoreConstants.PWD_SUFFIX));
		user.setLoginPwd(MD5Util.stringToMD5(AppCoreConstants.DEFAULT_PWD));
		userDao.save(user);
		return true;
	}

	/**
	 * Enable the user that is disabled
	 * 
	 * @param id
	 * @return
	 */
	public boolean enableUser(String id) {
		validateId(id);

		User user = userDao.getByKey(id);
		user.setStatus(AppCoreConstants.STATUS_ENABLE);

		return true;
	}

	/**
	 * Disable the user
	 * 
	 * @param id
	 * @return
	 */
	public boolean disableUser(String id) {
		validateId(id);

		User user = userDao.getByKey(id);
		user.setStatus(AppCoreConstants.STATUS_DISABLE);

		return true;
	}

	/**
	 * Disable the user by userCode
	 * 
	 * @param userCode
	 * @return
	 */
	public boolean disableUserByUserCode(String userCode) {
		if (!StringUtils.hasText(userCode))
			throw new SysException("Can not get the userCode from front end.");

		if(!userCode.equalsIgnoreCase("admin")) {
			userDao.getByUserCode(userCode).setStatus(AppCoreConstants.STATUS_DISABLE);
		}

		return true;
	}

	/**
	 * increment Login Fail Count
	 * 
	 * @param userCode
	 * @return
	 */
	public synchronized int incrementLoginFailCount(String userCode) {
		if (!StringUtils.hasText(userCode))
			throw new SysException("Can not get the userCode from front end.");

		User user = userDao.getByUserCode(userCode);

		if(userCode.equalsIgnoreCase("admin")) {
			user.setLoginFailCount(0);
		} else {
			user.setLoginFailCount(user.getLoginFailCount() == null ? 0 : user.getLoginFailCount() + 1);
		}

		return user.getLoginFailCount();
	}

	/**
	 * set login fail count to zero and save login time;
	 * 
	 * @param userCode
	 * @return
	 */
	public synchronized void clearLoginFailCount(String userCode) {
		if (!StringUtils.hasText(userCode))
			throw new SysException("Can not get the userCode from front end.");

		User user = userDao.getByUserCode(userCode);
		user.setLoginFailCount(0);
		user.setLastLoginTime(new Date());
		user.setLoginTotal(user.getLoginTotal() + 1);
	}

	/**
	 * Configure the Home Page for user
	 * 
	 * @param homePage
	 * @return
	 */
	public boolean configureHomePage(String homePage) {
		// TODO Insert the implement coding here
		// Need to add a new column in User table in order to store the Home
		// Page URL

		return false;
	}

	/**
	 * Configure the User Group relationship
	 * 
	 * @param userId
	 * @param newGrpIds
	 */
	public boolean configureUserGrp(String userId, Collection<String> newGrpIds) {
		validateId(userId);

		// Delete original User Group relationship
		userGrpDao.deleteByUserId(userId);

		// Insert new User Group relationship into table
		for (String grpId : newGrpIds) {
			UserGrp userGrp = new UserGrp();
			userGrp.setUserId(userId);
			userGrp.setGrpId(grpId);

			userGrpDao.save(userGrp);
		}

		return true;
	}

	/**
	 * Get the Groups by User/ Id
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map getUserGrps(String userId) {
		Collection assignedGroupList = userGrpDao.getAssignedGroups(userId);
		Collection assignedGroupObjects = new ArrayList();
		constructGroupObjects(assignedGroupList, assignedGroupObjects);

		Collection unassignedGroupList = userGrpDao.getUnassignedGroups(userId);
		Collection unassignedGroupObjects = new ArrayList();
		constructGroupObjects(unassignedGroupList, unassignedGroupObjects);

		Map userGrps = new HashMap();
		userGrps.put("assignedGroupObjects", assignedGroupObjects);
		userGrps.put("unassignedGroupObjects", unassignedGroupObjects);

		return userGrps;
	}

	/**
	 * Construct the Group Object List
	 * 
	 * @param groupList
	 * @param groupObjects
	 */
	@SuppressWarnings("unchecked")
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
	 * Configure the User Role relationship
	 * 
	 * @param userId
	 * @param newRoleIds
	 */
	public boolean configureUserRole(String userId, Collection<String> newRoleIds) {
		validateId(userId);

		// Delete original User Group relationship
		userRoleDao.deleteByUserId(userId);

		// Insert new User Group relationship into table
		for (String roleId : newRoleIds) {
			UserRole userRole = new UserRole();
			userRole.setUserId(userId);
			userRole.setRoleId(roleId);

			userRoleDao.save(userRole);
		}

		return true;
	}

	/**
	 * Get the roles by user id
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public Map getUserRoles(String userId) {
		// Get the assigned Role List
		System.out.println("=================================");
		Collection assignedRoleList = userRoleDao.getAssignedRoles(userId);
		Collection assignedRoleObjects = new ArrayList();
		// Construct the Assigned Role Object List
		constructRoleObjects(assignedRoleList, assignedRoleObjects);

		// Get the unassigned Role List
		Collection unassignedRoleList = userRoleDao.getUnassignedRoles(userId);
		Collection unassignedRoleObjects = new ArrayList();
		// Construct the unassigned Role Object List
		constructRoleObjects(unassignedRoleList, unassignedRoleObjects);

		Map userRoles = new HashMap();
		userRoles.put("assignedRoleObjects", assignedRoleObjects);
		userRoles.put("unassignedRoleObjects", unassignedRoleObjects);
		System.out.println(unassignedRoleObjects);
		return userRoles;
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
	 * When user change or reset password the invalid date is automatically
	 * extend for 3 Month
	 * 
	 * @return
	 */
	private Date resetInvalidDate() {
		int days = 90;
		String validDay = paramDao.getValueByPath(AppConstants.PASSWORD_VALID_DAYS_PATH);
		try {
			days = Integer.parseInt(validDay);
		} catch (NumberFormatException e) {
			logger.error("Param [" + AppConstants.PASSWORD_VALID_DAYS_PATH + "] was set errror!");
		}
		Date invalidDate = new Date();
		invalidDate = DateUtils.dateIncreaseByDay(invalidDate, days);

		return invalidDate;
	}

	/**
	 * Validate the Primary Key (id)
	 * 
	 * @param id
	 * @return
	 */
	private boolean validateId(String id) {
		if (!StringUtils.hasText(id))
			// logger.error("The Primary Key (Id) does not submited from front end, please check the submit form.");
			// throw new SysException("No record has been selected. ");
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD,
					"The Primary Key (Id) does not submited from front end, please check the submit form.");

		return true;
	}

	/**
	 * Validate the User object that submitted from front end
	 * 
	 * @param user
	 * @return
	 */
	private boolean validateUser(User user) {
		if (user == null)
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again. ");

		if (!StringUtils.hasText(user.getUserCode()))
			throw new AppException(MessageKeyConstants.SEC_USER_CODE_NOT_NULL,
					"User Code can not be left empty. Please input User Code and submit again. ");
		if (!StringUtils.hasText(user.getUserName()))
			throw new AppException(MessageKeyConstants.SEC_USER_NAME_NOT_NULL,
					"User Name can not be left empty. Please input User Name and submit again. ");
		/*
		 * if (!StringUtils.hasText(user.getOrgId())) throw new
		 * AppException(MessageKeyConstants.ORG_NAME_NOT_NULL,
		 * "Organization Name can not be left empty. Please input Organization Name and submit again."
		 * ); if (!StringUtils.hasText(user.getAreaId())) throw new
		 * AppException(MessageKeyConstants.AREA_NAME_NOT_NULL,
		 * "Area Name can not be left empty. Please input Area Name and submit again. "
		 * ); if (!StringUtils.hasText(user.getWorkId())) throw new
		 * AppException(MessageKeyConstants.WORK_ID_NOT_NULL,
		 * "Work Id can not be left empty. Please input Work Id and submit again. "
		 * ); if (!StringUtils.hasText(user.getDepartment())) throw new
		 * AppException(MessageKeyConstants.DEPARTMENT_NOT_NULL,
		 * "Department can not be left empty. Please input Department and submit again. "
		 * );
		 */
		// if (!StringUtils.hasText(user.getTel()))
		// throw new
		// SysException("Telephone Number can not be left empty. Please input Telephone Number and submit again. ");
		// if (!StringUtils.hasText(user.getMobile()))
		// throw new
		// SysException("Mobile Number can not be left empty. Please input Mobile Number and submit again. ");
		// if (!StringUtils.hasText(user.getEmail()))
		// throw new
		// SysException("Email Address can not be left empty. Please input Email Address and submit again. ");
		// if (!StringUtils.hasText(user.getLoginPwd()))
		// throw new
		// SysException("Login Password can not be left empty. Please input Login Password and submit again. ");
		// if (!StringUtils.hasText(user.getCardId()))
		// throw new
		// SysException("Card Id can not be left empty. Please input Card Id and submit again. ");
		// if (!StringUtils.hasText(user.getInvalidDate()))
		// throw new
		// SysException("Invalid Date can not be left empty. Please input Invalid Date and submit again. ");
		/*
		 * if (!StringUtils.hasText(user.getPosLevel())) throw new
		 * AppException(MessageKeyConstants.POSITION_LEVEL_NOT_NULL,
		 * "Position Level can not be left empty. Please input Position Level and submit again. "
		 * ); if (!StringUtils.hasText(user.getPosType())) throw new
		 * AppException(MessageKeyConstants.POSITION_TYPE_NOT_NULL,
		 * "Position Type can not be left empty. Please input Position Type and submit again. "
		 * );
		 */
		// if (!StringUtils.hasText(user.getAppCode()))
		// throw new
		// SysException("Application Code can not be left empty. Please input Application Code and submit again. ");
		if (!StringUtils.hasText(user.getStatus()))
			throw new AppException(MessageKeyConstants.SEC_STATUS_NOT_NULL,
					"Status can not be left empty. Please input Status and submit again. ");
			// if (!StringUtils.hasText(user.getOrder()))
			// throw new
			// SysException("Order not be left empty. Please input Order and submit again. ");
			// if (!StringUtils.hasText(user.getAdminOrgId()))
			// throw new
			// SysException("Admin Organization Id not be left empty. Please input Admin Organization Id and submit again. ");
			// if (!StringUtils.hasText(user.getMultiOnline()))
			// throw new
			// SysException("Multi Online be left empty. Please input Multi Online and submit again. ");

		if (!RegExpUtils.parseUserId(user.getUserCode()))
			throw new AppException(MessageKeyConstants.SEC_INVALID_USER_CODE,
					"Invalid user code. The user code should be construct with a-z, A-Z, 0-9 and _, "
							+ "and the length can not be less than 3 or more than 16.");

		return true;
	}

	/**
	 * save the user when add new user or update user when false return 0 when
	 * success return -1
	 * 
	 * add by hy
	 * 
	 * @param entity
	 * @return String
	 * */

	public String save(User entity) {
		if ("0".equals(userDao.checkAddUser(entity))) {
			if (entity.getAreaId() == null) {
				entity.setAreaId(areaDao.getRootArea().getId());
			}
			if (entity.getOrgId() == null) {
				entity.setOrgId(areaDao.getRootArea().getId());
			}
			entity.setLoginPwd(MD5Util.stringToMD5(entity.getLoginPwd().toString()));
			if(entity.getUserCode().equalsIgnoreCase("admin")) {
				entity.setLoginFailCount(0);
			}
			userDao.save(entity);
			return "0";
		} else
			return "-1";
	}

	/**
	 * delete the selected User sets
	 * 
	 * add by haoyuan
	 * 
	 * @param args
	 * @return void
	 * */
	public void deleteSelected(String[] args) {
		if (null != args && args.length > 0) {
			for (String arg : args) {
				User user = userDao.getByKey(arg);
				if(user.getUserCode().equals(SpringSecurityUtils.getCurrentUserName())){
					throw new AppException(MessageKeyConstants.SEC_INCORRECT_USER_IS_LOGIN,
					"can not delete the login user ");
				}
			}
			for (String arg : args) {
				User user = userDao.getByKey(arg);
				userDao.delete(user);
			}
		}
	}

	/**
	 * 
	 * 日期：2011-5-3<br>
	 * 版本：V1.0<br>
	 * 描述：searchUserByCondition(通过用户名与机构Id查找对应的user信息) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-5-3 下午01:50:04 <br>
	 * 创建人 Administrator<br>
	 * ===============================================<br>
	 * 修改日期：2011-5-3<br>
	 * 修改人 Administrator<br>
	 * 修改描述 searchUserByCondition(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param page
	 * @param userName
	 * @param orgCode
	 * @return Page<User>
	 * @Exception 异常对象 <br>
	 */
	@SuppressWarnings( { "unchecked", "rawtypes", "null" })
	public Page<User> searchUserByCondition(final Page page, String userName, String orgCode) {
		String hql = null;
		hql += " from User u where 1 = 1";
		if (userName != null && !userName.equals("")) {
			hql += " and u.userName like '%" + userName + "%' ";
		}
		if (orgCode != null && orgCode.equals("")) {
			hql += " and (select o.orgCode from OrgInfo o where o.id = u.orgId ) like '" + orgCode + "%' ";
		}
		hql += " order by model.id ";

		return userDao.findPage(page, hql, new Object[] {});
	}

	@SuppressWarnings( { "rawtypes", "unchecked" })
	public Map<String, List> getInitFormDatas(String language) {
		Map<String, List> formDatas = new HashMap<String, List>();

		List<Object[]> posLevelList = sysDatadirService.getDatadirChildrenByPath(AppConstants.USERPOSLEVELMANAGER_PATH,
				language);
		formDatas.put("posLevelList", posLevelList);

		List<Object[]> posTypeList = sysDatadirService.getDatadirChildrenByPath(AppConstants.USERPOSTYPEMANAGER_PATH,
				language);
		formDatas.put("posTypeList", posTypeList);

		return formDatas;
	}

	/**
	 * 获取所有的用户信息
	 * 
	 * @return
	 */
	public List<User> getAllUserInfo() {
		List<User> list = userDao.getAll();
		return list;
	}
	
	public List getUserLevels(String userCode) {
		User user = userDao.getByUserCode(userCode);
		String f1 = user.getF1();
		List<Object[]> roleLevelsList = sysDatadirService.getDatadirChildrenByPath(AppConstants.USERROLEMANAGER_PATH,
				"zh_CN");
		if (f1 != null) {
			if (f1.equals("2")) { // 一级分行
				roleLevelsList.remove(0);
			} else if (f1.equals("3")) { // 二级分行
				roleLevelsList.remove(0);
				roleLevelsList.remove(0);
			} else if (f1.equals("4")) {  // 支行
				roleLevelsList.remove(0);
				roleLevelsList.remove(0);
				roleLevelsList.remove(0);
			} else if (f1.equals("5")) { // 网点
				roleLevelsList.remove(0);
				roleLevelsList.remove(0);
				roleLevelsList.remove(0);
				roleLevelsList.remove(0);
			}
		}
		return roleLevelsList;
	}
	
	public boolean changePwd(String id,String oldPwd,String newPwd){
		validateId(id);

		if (!StringUtils.hasText(oldPwd))
			throw new AppException(MessageKeyConstants.SEC_OLD_PWD_NOT_NULL,
					"Old password can not be left empty. Please input old password and submit again. ");
		
		User user = userDao.getByKey(id);

		if (user == null)
			throw new AppException(MessageKeyConstants.SEC_USER_NOT_FOUND, "The user is not found. ");

		if (!oldPwd.equals(user.getLoginPwd()))
			throw new AppException(MessageKeyConstants.SEC_INCORRECT_OLD_PWD, "The old password is incorrect.");

		user.setLoginPwd(newPwd);

		user.setPwInvalidDate(resetInvalidDate());

		return true;
	}
}
