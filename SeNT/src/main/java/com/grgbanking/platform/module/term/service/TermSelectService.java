/**
 * 文件名：TermInfoService.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.term.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.datadir.service.SysDatadirService;
import com.grgbanking.platform.module.exproperty.dao.ExtendPropertyDao;
import com.grgbanking.platform.module.exproperty.entity.ExtendProperty;
import com.grgbanking.platform.module.exproperty.service.ExPropertyService;
import com.grgbanking.platform.module.term.dao.TermBrandDao;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.platform.module.term.dao.TermModelDao;
import com.grgbanking.platform.module.term.dao.TermTypeDao;
import com.grgbanking.platform.module.term.entity.TermBrand;
import com.grgbanking.platform.module.term.entity.TermInfo;
import com.grgbanking.platform.module.term.entity.TermModel;
import com.grgbanking.platform.module.term.entity.TermType;

/**
 * 终端基础信息查询<br>
 * 
 * Terminal basal information Service
 * 
 * @author Lincg
 * 
 */

@Service
@Transactional
@SuppressWarnings( { "unchecked", "rawtypes" })
public class TermSelectService {

	/** 扩展属性 */
	public static Map<String, String> exPropertyMap = new HashMap<String, String>();

	@Autowired
	public void loadExproperty(ExPropertyService service, ExtendPropertyDao exPropertyDao) {
		List<ExtendProperty> exPropertyList = service.getExtendPropertyList(TermInfo.TABLE_NAME);
		for (ExtendProperty ex : exPropertyList) {
			exPropertyMap.put(ex.getPropertyName(), ex.getEntityClassProperty());
		}
	}

	@Autowired
	TermInfoDao terminalInfoDao;

	@Autowired
	TermInfoService terminalInfoService;

	@Autowired
	TermModelDao terminalModelDao;

	@Autowired
	TermBrandDao terminalBrandDao;

	@Autowired
	TermTypeDao terminalTypeDao;

	@Autowired
	SysDatadirService sysDatadirService;

	/**
	 * 校验id是否为空 <br>
	 * 
	 * check whether is it a empty id
	 * 
	 * @param id
	 */
	private void validateId(String id) {
		if (!StringUtils.hasText(id))
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
	}

	public Page<TermInfo> getTermInfoPage(final Page<TermInfo> page, String termCode) {
		return terminalInfoDao.getByTermCodeFuzzily(page, termCode);
	}

	public Page<TermInfo> getTermInfoPageByParams(final Page<TermInfo> page, Map<String, String> params) {
		return terminalInfoDao.getTermInfoPageByParams(page, params);
	}

	public Page<TermInfo> getTermInfoByTermid(final Page<TermInfo> page, Map<String, String> params)
	{
		return terminalInfoDao.getTermInfoByTermid(page, params);
	}

	public Page<TermInfo> getTermInfoByParams(final Page<TermInfo> page, Map<String, String> params) {
		return terminalInfoDao.getTermInfoByParams(page, params);
	}

	public List getTermModelList(String status, String status1) {
		List<TermModel> termModels = terminalModelDao.find("from TermModel tm where tm.status = 'Y' ");

		return termModels;
	}

	/**
	 * 根据当前语言获取表单或module的基础数据<br>
	 * 
	 * get init datas by language
	 * 
	 * @param language
	 * @return
	 */
	public Map<String, Object> getTermInfoFormInitDatas(String language)
	{
		return terminalInfoService.getTermInfoInitDatas(language);
	}

	private boolean validateTerminalInfo(TermInfo terminalInfo) {
		if (terminalInfo == null)
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again. ");

		if (!StringUtils.hasText(terminalInfo.getTermCode()))
			throw new AppException(MessageKeyConstants.TERM_TERMINAL_TERM_CODE_NOT_NULL,
					"Terminal ID can not be left empty. Please input terminal ID and submit again.");
		return true;
	}

	public List getTemModelDatas(Map<String, String> params) {
		List<TermModel> termModels = terminalModelDao.getTermModelListByParams(params);

		return termModels;
	}

	public List getTemTypeDatas(Map<String, String> params) {
		List<TermType> termTypes = terminalTypeDao.getTermTypeListByParams(params);

		return termTypes;
	}

	public List getTemBrandDatas(Map<String, String> params) {
		List<TermBrand> termBrands = terminalBrandDao.getTermBrandListByParams(params);

		return termBrands;
	}

	public int getTemSumDatas(Map<String, String> params) {
		int termSum = terminalInfoDao.getTermSumListByParams(params);

		return termSum;
	}
}
