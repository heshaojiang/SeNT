/**
 * 文件名：TermModelService.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.term.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.exception.AppPlaceHolderException;
import com.grgbanking.exception.SimpleAppException;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.term.dao.TermBrandDao;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.platform.module.term.dao.TermModelDao;
import com.grgbanking.platform.module.term.dao.TermTypeDao;
import com.grgbanking.platform.module.term.entity.TermBrand;
import com.grgbanking.platform.module.term.entity.TermModel;
import com.grgbanking.platform.module.term.entity.TermType;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 终端型号 service<br>
 * 
 * Terminal model Service
 * 
 * @author Jonas
 * 
 */
@Service
@Transactional
public class TermModelService {

	@Autowired
	TermModelDao terminalModelDao;

	@Autowired
	TermBrandDao terminalBrandDao;

	@Autowired
	TermTypeDao terminalTypeDao;
	
	@Autowired
	TermInfoDao terminalInfoDao;

	/**
	 * 保存 终端型号 <br>
	 * 
	 * save terminal model
	 * 
	 * @param terminalModel
	 * @return
	 */
	public boolean saveTerminalModel(Map<String, Object> parameter)
	{
		String id          = StringUtil.trim((String)parameter.get("id"));
		String modelName   = StringUtil.trim((String)parameter.get("modelName"));
		String brandId     = StringUtil.trim((String)parameter.get("brandId"));
		String typeId      = StringUtil.trim((String)parameter.get("typeId"));
		String journalPath = StringUtil.trim((String)parameter.get("journalPath"));
		String status      = StringUtil.trim((String)parameter.get("status"));
		
		if( StringUtil.isBlank(modelName) )
		{
			throw new AppException(MessageKeyConstants.TERM_TERMINAL_MODEL_NAME_NOT_NULL, "Terminal model name can not be left empty. Please input terminal model name and submit again.");
		}
		if( StringUtil.isBlank(brandId) )
		{
			throw new AppException(MessageKeyConstants.TERM_TERMINAL_BRAND_NAME_NOT_NULL, "Terminal brand name can not be left empty. Please input terminal brand name and submit again.");
		}
		if( StringUtil.isBlank(typeId) )
		{
			throw new AppException(MessageKeyConstants.TERM_TERMINAL_TYPE_NOT_NULL, "Terminal type can not be left empty. Please input terminal type and submit again.");
		}
		
		TermModel existedTerminalModel = terminalModelDao.getByModelName(modelName);
		if (existedTerminalModel != null)
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TERM_MODEL_NAME_ALREADY_EXISTS, "term model name[%s] already exists ", modelName);
		}
		
		TermModel termModel = new TermModel();
		termModel.setId(id);
		termModel.setModelName(modelName);
		termModel.setBrandId(brandId);
		termModel.setTypeId(typeId);
		termModel.setJournalPath(journalPath);
		termModel.setStatus(status);

		if( StringUtil.isNotBlank(termModel.getId()))
		{
			throw new SimpleAppException("id is not null.");
		}
		
		terminalModelDao.saveNew(termModel);
		
		return true;
	}

	/**
	 * 删除 终端型号 <br>
	 * 
	 * delete terminal model
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteTerminalModel(String id) {
		validateId(id);
		terminalModelDao.delete(id);
		return true;
	}

	private void validateId(String id) {
		if (!StringUtils.hasText(id)) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}
	}

	/**
	 * 批量删除 终端型号 <br>
	 * 
	 * batch delete terminal model
	 * 
	 * @param ids
	 * @return
	 */
	public boolean batchDelete(Collection<String> ids) {
		if (ids == null || ids.size() == 0) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}

		for (String id : ids) {
			deleteTerminalModel(id);
		}

		return true;
	}

	/**
	 * 更新 终端型号 <br>
	 * 
	 * update terminal model
	 * 
	 * @param terminalModel
	 * @return
	 */
	public boolean updateTerminalModel(Map<String, Object> parameter)
	{
		String id          = StringUtil.trim((String)parameter.get("id"));
		String modelName   = StringUtil.trim((String)parameter.get("modelName"));
		String brandId     = StringUtil.trim((String)parameter.get("brandId"));
		String typeId      = StringUtil.trim((String)parameter.get("typeId"));
		String journalPath = StringUtil.trim((String)parameter.get("journalPath"));
		String status      = StringUtil.trim((String)parameter.get("status"));
		
		if( StringUtil.isBlank(id) )
		{
			throw new SimpleAppException("id is null.");
		}
		if( StringUtil.isBlank(modelName) )
		{
			throw new AppException(MessageKeyConstants.TERM_TERMINAL_MODEL_NAME_NOT_NULL, "Terminal model name can not be left empty. Please input terminal model name and submit again.");
		}
		if( StringUtil.isBlank(brandId) )
		{
			throw new AppException(MessageKeyConstants.TERM_TERMINAL_BRAND_NAME_NOT_NULL, "Terminal brand name can not be left empty. Please input terminal brand name and submit again.");
		}
		if( StringUtil.isBlank(typeId) )
		{
			throw new AppException(MessageKeyConstants.TERM_TERMINAL_TYPE_NOT_NULL, "Terminal type can not be left empty. Please input terminal type and submit again.");
		}

		TermModel existedTerminalModel = terminalModelDao.getByModelName(modelName);
		if( existedTerminalModel!=null )
		{
			if( id.equals(existedTerminalModel.getId())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.TERM_MODEL_NAME_ALREADY_EXISTS, "term model name[%s] already exists ", modelName);
			}
		}
		
		TermModel oldTermModel = terminalModelDao.get(id);
		
		oldTermModel.setModelName(modelName);
		oldTermModel.setBrandId(brandId);
		oldTermModel.setTypeId(typeId);
		oldTermModel.setJournalPath(journalPath);
		oldTermModel.setStatus(status);
		
		//获取终端信息表中该终端型号对应的所有终端信息列表
		terminalInfoDao.updateBrandIdAndTypeIdByModelId(id, brandId, typeId);
		
		return true;
	}

	/**
	 * 根据品牌型号查找分页的终端型号数据<br>
	 * 
	 * get 1 page of terminal model by model name and page information
	 * 
	 * @param page
	 * @param modelName
	 * @return
	 */
	public Page<TermModel> getTermModelPage(final Page<TermModel> page, String modelName)
	{
		return terminalModelDao.getByModelNameFuzzily(page, modelName);
	}

	/**
	 * 根据参数查找分页的终端型号数据<br>
	 * 
	 * get 1 page of terminal model by params and page information
	 * 
	 * @param page
	 * @param params
	 * @return
	 */
	public Page<TermModel> getTermModelPageByParams(final Page<TermModel> page, Map<String, String> params)
	{
		return terminalModelDao.getTermModelPageByParams(page, params);
	}
	
	/**
	 * 根据当前语言获取表单或module的基础数据<br>
	 * 
	 * get init datas by language
	 * 
	 * @return
	 */
	public List<TermBrand> getBrandList()
	{
		List<TermBrand> termBrands = terminalBrandDao.find("from TermBrand tb where tb.status = 'Y' order by tb.code");
		if( termBrands==null )
		{
			termBrands = new ArrayList<TermBrand>();
		}
		return termBrands;
	}

	/**
	 * 根据当前语言获取表单或module的基础数据<br>
	 * 
	 * get init datas by language
	 * 
	 * @return
	 */
	public Map<String, Object> initFormData()
	{
		Map<String, Object> formInitDatas = new HashMap<String, Object>();
		List<TermBrand> termBrands = new ArrayList<TermBrand>();
		List<TermBrand> termBrands2 = terminalBrandDao.find("from TermBrand tb where tb.status = 'Y' order by tb.code");
		if (termBrands2 != null)
		{
			termBrands = termBrands2;
		}
		formInitDatas.put("brandList", termBrands);

		List<TermType> termTypes = new ArrayList<TermType>();
		List<TermType> termTypes2 = terminalTypeDao.find("from TermType tt where tt.status = 'Y' order by tt.code");
		if (termTypes2 != null)
		{
			termTypes = termTypes2;
		}
		formInitDatas.put("typeList", termTypes);
		return formInitDatas;
	}

//	private boolean validateTerminalModel(TermModel terminalModel)
//	{
//		if( terminalModel == null )
//		{
//			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL, "The Input is null. Please check and submit again. ");
//		}
//		if( !StringUtils.hasText(terminalModel.getModelName()) )
//		{
//			throw new AppException(MessageKeyConstants.TERM_TERMINAL_MODEL_NAME_NOT_NULL, "Terminal model name can not be left empty. Please input terminal model name and submit again.");
//		}
//		if( !StringUtils.hasText(terminalModel.getTypeId()) )
//		{
//			throw new AppException(MessageKeyConstants.TERM_TERMINAL_TYPE_NOT_NULL, "Terminal type can not be left empty. Please input terminal type and submit again.");
//		}
//		if( !StringUtils.hasText(terminalModel.getBrandId()) )
//		{
//			throw new AppException(MessageKeyConstants.TERM_TERMINAL_BRAND_NAME_NOT_NULL, "Terminal brand name can not be left empty. Please input terminal brand name and submit again.");
//		}
//
//		return true;
//
//	}

	/**
	 * 获取所有终端型号
	 * 
	 * get all of terminal model
	 * 
	 * @return
	 */
	public List<TermModel> getAllTermModel() {
		return this.terminalModelDao.getAll();
	}

}
