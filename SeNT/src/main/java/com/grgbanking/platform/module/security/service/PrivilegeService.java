/** 
 * 
 * Copyright:   Copyright (c) 2011 
 * Company:     GRGBanking
 * @author:     VZ
 * Create at:   2011-4-18
 * 
 * Modification History: 
 * Date         Author      Description 
 * -----------  ---------   ---------------------------------------- 
 * 2011-4-18		VZ			Initial Create
 */

package com.grgbanking.platform.module.security.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.security.dao.PrivilegeDao;
import com.grgbanking.platform.module.security.entity.Privilege;

/**
 * Privilege Management service<br>
 * 权限管理服务类.
 * 
 * @author vinson
 */
@Service
@Transactional
public class PrivilegeService extends BaseService {
	/**
	 * Use spring's dependency injection facilities
	 */
	@Autowired
	PrivilegeDao privilegeDao;

	/**
	 * Search Privilege by privilege name
	 * 
	 * @param page
	 * @param filterParamMap
	 * @return
	 */
	public Page<Privilege> searchPrivilege(final Page<Privilege> page, HashMap<String, String> propertyFilterMap) {
		if (propertyFilterMap == null) {
			propertyFilterMap = new HashMap<String, String>();
		}
		Page<Privilege> pagedir = privilegeDao.findPage(page, propertyFilterMap);
		return pagedir;
	}

	/**
	 * Create a new Privilege
	 * 
	 * @param privilege
	 * @return
	 */
	public boolean newPrivilege(Privilege privilege) {
		validatePrivilege(privilege);

		// The Id should be null when create a new record
		if (privilege.getId() != null) {
			privilege.setId(null);
		}

		privilegeDao.save(privilege);

		return true;
	}

	/**
	 * Update a record
	 * 
	 * @param privilege
	 * @return
	 */
	public boolean updatePrivilege(Privilege privilege) {
		validatePrivilege(privilege);
		String privilegeId = privilege.getId();
		validatePrivilegeId(privilegeId);

		privilegeDao.copyUpdate(privilege);

		return true;
	}

	/**
	 * Delete a record by Privilege Id
	 * 
	 * @param privilegeId
	 * @return
	 */
	public boolean deletePrivilege(String privilegeId) {
		validatePrivilegeId(privilegeId);

		privilegeDao.delete(privilegeId);

		return true;
	}

	/**
	 * Validate Privilege Id
	 * 
	 * @param privilegeId
	 */
	private void validatePrivilegeId(String privilegeId) {
		if (!StringUtils.hasText(privilegeId)) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}
	}

	/**
	 * Validate Privilege
	 * 
	 * @param privilege
	 * @return
	 */
	private boolean validatePrivilege(Privilege privilege) {
		if (privilege == null) {
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again. ");
		}

		if (!StringUtils.hasText(privilege.getMenuId())) {
			throw new AppException(MessageKeyConstants.SEC_MENU_NAME_NOT_NULL,
					"Menu Name can not be left empty. Please input Menu Name and submit again. ");
		}
		if (!StringUtils.hasText(privilege.getButtonId())) {
			throw new AppException(MessageKeyConstants.SEC_BUTTON_NAME_NOT_NULL,
					"Button Name can not be left empty. Please input Button Name and submit again. ");
		}

		return true;
	}
}
