/**
 * 文件名：TermTypeService.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.term.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.i18n.dao.SysI18nDao;
import com.grgbanking.platform.module.i18n.entity.SysI18n;
import com.grgbanking.platform.module.term.dao.TermTypeDao;
import com.grgbanking.platform.module.term.entity.TermType;

/**
 * 终端类型 service<br>
 * 
 * Terminal type Service
 * 
 * @author Jonas
 * 
 */
@Service
@Transactional
public class TermTypeService {

	@Autowired
	TermTypeDao terminalTypeDao;

	@Autowired
	private SysI18nDao sysI18nDao;

	/**
	 * 保存 终端类型 <br>
	 * 
	 * save terminal type
	 * 
	 * @param ter
	 *            * 保存 终端类型 <br>
	 * 
	 *            save terminal typeminalType
	 * @return
	 */
	public boolean saveTerminalType(TermType terminalType, String language) {
		validateTerminalType(terminalType);

		TermType existedTerminalType = terminalTypeDao.getByType(terminalType.getType());
		if (existedTerminalType != null) {
			throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_TYPE,
					"The Terminal Type has already existed. Please change the Terminal Type and submit again. ");
		}

		try {
			TermType existedTerminalType2 = terminalTypeDao.findUniqueBy("code", terminalType.getCode());
			if (existedTerminalType2 != null) {
				throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_TYPE_CODE,
						"The Terminal Type Code has already existed. Please change the Terminal Type Code and submit again. ");
			}
		} catch (Exception e) {
			throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_TYPE_CODE,
					"The Terminal Type Code has already existed. Please change the Terminal Type Code and submit again. ");
		}

		try {
			TermType existedTerminalType2 = terminalTypeDao.findUniqueBy("typeName", terminalType.getTypeName());
			if (existedTerminalType2 != null) {
				throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_TYPE_NAME,
						"The Terminal Type Name has already existed. Please change the Terminal Type Name and submit again. ");
			}
		} catch (Exception e) {
			throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_TYPE_NAME,
					"The Terminal Type Name has already existed. Please change the Terminal Type Name and submit again. ");
		}

		if (terminalType.getId() == null) {
			terminalTypeDao.save(terminalType);

		} else {
			terminalTypeDao.copyUpdate(terminalType);
		}

		String id = terminalType.getId();
		String name = terminalType.getTypeName();
		SysI18n sysI18n = sysI18nDao.getSysI18n(id, language);
		if (sysI18n == null) {
			sysI18n = new SysI18n();
			sysI18n.setLanguage(language);
			sysI18n.setName(name);
			sysI18n.setReferenceid(id);
		} else {
			sysI18n.setName(name);
		}
		sysI18nDao.save(sysI18n);

		return true;
	}

	/**
	 * 删除 终端类型 <br>
	 * 
	 * delete terminal type
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteTerminalType(String id) {
		validateId(id);
		terminalTypeDao.delete(id);
		return true;
	}

	private void validateId(String id) {
		if (!StringUtils.hasText(id)) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}
	}

	/**
	 * 批量删除 终端类型 <br>
	 * 
	 * batch delete terminal type
	 * 
	 * @param ids
	 * @return
	 */
	public boolean batchDelete(Collection<String> ids) {
		if (ids == null || ids.size() == 0) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}

		for (String id : ids) {
			deleteTerminalType(id);
		}

		return true;
	}

	/**
	 * 更新终端类型 <br>
	 * 
	 * update terminal type
	 * 
	 * @param terminalType
	 * @return
	 */
	public boolean updateTerminalType(TermType terminalType, String language) {
		validateTerminalType(terminalType);
		String newId = terminalType.getId();
		validateId(newId);

		TermType existedTerminalType = terminalTypeDao.getByType(terminalType.getType());

		if (existedTerminalType != null) {
			if (!newId.equals(existedTerminalType.getId())) {
				throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_TYPE,
						"The Terminal Type has already existed. Please change the Terminal Type and submit again. ");
			}
		}

		try {
			TermType existedTerminalType2 = terminalTypeDao.findUniqueBy("code", terminalType.getCode());
			if (existedTerminalType2 != null && !newId.equals(existedTerminalType2.getId())) {
				throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_TYPE_CODE,
						"The Terminal Type Code has already existed. Please change the Terminal Type Code and submit again. ");
			}
		} catch (Exception e) {
			throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_TYPE_CODE,
					"The Terminal Type Code has already existed. Please change the Terminal Type Code and submit again. ");
		}

		try {
			TermType existedTerminalType2 = terminalTypeDao.findUniqueBy("typeName", terminalType.getTypeName());
			if (existedTerminalType2 != null && !newId.equals(existedTerminalType2.getId())) {
				throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_TYPE_NAME,
						"The Terminal Type Name has already existed. Please change the Terminal Type Name and submit again. ");
			}
		} catch (Exception e) {
			throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_TYPE_NAME,
					"The Terminal Type Name has already existed. Please change the Terminal Type Name and submit again. ");
		}

		terminalTypeDao.copyUpdate(terminalType);

		String id = terminalType.getId();
		String name = terminalType.getTypeName();
		SysI18n sysI18n = sysI18nDao.getSysI18n(id, language);
		if (sysI18n == null) {
			sysI18n = new SysI18n();
			sysI18n.setLanguage(language);
			sysI18n.setName(name);
			sysI18n.setReferenceid(id);
		} else {
			sysI18n.setName(name);
		}
		sysI18nDao.save(sysI18n);

		return true;
	}

	/**
	 * 根据类型名称查找分页的终端类型数据<br>
	 * 
	 * get 1 page of terminal type by type name and page information
	 * 
	 * @param page
	 * @param type
	 * @return
	 */
	public Page<TermType> getTermTypePage(final Page<TermType> page, String type, String language) {
		Page<TermType> pageType = terminalTypeDao.getByTypeFuzzily(page, type);

		List<SysI18n> i18nList = sysI18nDao.findBy("language", language);
		for (TermType dir : pageType.getResult()) {
			for (SysI18n i18n : i18nList) {
				if (i18n.getReferenceid() != null && i18n.getName() != null) {
					if (i18n.getReferenceid().equals(dir.getId())) {
						dir.setTypeName(i18n.getName());
					}
				}
			}
		}

		return pageType;
	}

	private boolean validateTerminalType(TermType terminalType) {
		if (terminalType == null) {
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again. ");
		}

		if (!StringUtils.hasText(terminalType.getType())) {
			throw new AppException(MessageKeyConstants.TERM_TERMINAL_TYPE_NOT_NULL,
					"Terminal Type can not be left empty. Please input Terminal Type and submit again.");
		}
		if (!StringUtils.hasText(terminalType.getTypeName())) {
			throw new AppException(MessageKeyConstants.TERM_TYPE_NAME_NOT_NULL,
					"Type Name can not be left empty. Please input type name and submit again.");
		}

		return true;

	}

	/**
	 * 获取所有终端类型
	 * 
	 * get all of terminal type
	 * 
	 * @return
	 */
	public List<TermType> getAllTermType()
	{
		return this.terminalTypeDao.getAll();
	}

}
