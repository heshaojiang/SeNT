/**
 * 文件名：TermBrandService.java
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
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.term.dao.TermBrandDao;
import com.grgbanking.platform.module.term.entity.TermBrand;

/**
 * 终端品牌 service<br>
 * 
 * Terminal Brand Service
 * 
 * @author Jonas
 * 
 */
@Service
@Transactional
public class TermBrandService {

	@Autowired
	TermBrandDao terminalBrandDao;

	/**
	 * 保存 终端品牌 <br>
	 * 
	 * save terminal brand
	 * 
	 * @param terminalBrand
	 *            品牌
	 * @return 是否成功
	 */
	public boolean saveTerminalBrand(TermBrand terminalBrand) {
		validateTerminalBrand(terminalBrand);

		TermBrand existedTerminalBrand = terminalBrandDao.getByBrandName(terminalBrand.getBrandName());
		if (existedTerminalBrand != null) {
			throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_BRAND_NAME,
					"The Terminal Brand has already existed. Please change the Terminal Brand and submit again. ");
		}

		TermBrand existedTerminalBrand2 = terminalBrandDao.findUniqueBy("code", terminalBrand.getCode());
		if (existedTerminalBrand2 != null) {
			throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_BRAND_CODE,
					"The Terminal Brand Code has already existed. Please change the Terminal Brand Code and submit again. ");
		}

		if (terminalBrand.getId() == null) {
			terminalBrandDao.save(terminalBrand);
		} else {
			terminalBrandDao.copyUpdate(terminalBrand);
		}
		return true;
	}

	/**
	 * 删除 终端品牌 <br>
	 * 
	 * delete terminal brand
	 * 
	 * @param id
	 *            id
	 * @return 是否成功
	 */
	public boolean deleteTerminalBrand(String id) {
		validateId(id);
		terminalBrandDao.delete(id);
		return true;
	}

	/**
	 * 校验id是否为空 <br>
	 * 
	 * check whether is it a empty id
	 * 
	 * @param id
	 */
	private void validateId(String id) {
		if (!StringUtils.hasText(id)) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}
	}

	/**
	 * 批量删除 终端品牌 <br>
	 * 
	 * batch delete terminal brand
	 * 
	 * @param ids
	 *            ids
	 * @return 是否成功
	 */
	public boolean batchDelete(Collection<String> ids) {
		if (ids == null || ids.size() == 0) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}

		for (String id : ids) {
			deleteTerminalBrand(id);
		}

		return true;
	}

	/**
	 * 更新 终端品牌 <br>
	 * 
	 * update terminal brand
	 * 
	 * @param terminalBrand
	 *            品牌
	 * @return 是否成功
	 */
	public boolean updateTerminalBrand(TermBrand terminalBrand) {
		validateTerminalBrand(terminalBrand);
		String newId = terminalBrand.getId();
		validateId(newId);

		TermBrand existedTerminalBrand = terminalBrandDao.getByBrandName(terminalBrand.getBrandName());

		if (existedTerminalBrand != null) {
			if (!newId.equals(existedTerminalBrand.getId())) {
				throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_BRAND_NAME,
						"The Brand Name has already existed. Please change the brand Name and submit again. ");
			}
		}

		TermBrand existedTerminalBrand2 = terminalBrandDao.findUniqueBy("code", terminalBrand.getCode());
		if (existedTerminalBrand2 != null) {
			if (!newId.equals(existedTerminalBrand2.getId())) {
				throw new AppException(MessageKeyConstants.TERM_EXISTED_TERMINAL_BRAND_CODE,
						"The Terminal Brand Code has already existed. Please change the Terminal Brand Code and submit again. ");
			}
		}

		terminalBrandDao.copyUpdate(terminalBrand);

		return true;
	}

	/**
	 * 根据品牌名称查找分页的终端品牌数据<br>
	 * 
	 * get 1 page of terminal brand by brand name and page information
	 * 
	 * @param page
	 *            page对象
	 * @param brandName
	 *            品牌
	 * @return Page<TermBrand>
	 */
	public Page<TermBrand> getTermBrandPage(final Page<TermBrand> page, String brandName) {
		return terminalBrandDao.getByBrandNameFuzzily(page, brandName);

	}

	/**
	 * 根据参数查找分页的终端品牌数据<br>
	 * 
	 * get 1 page of terminal brand by params and page information
	 * 
	 * @param page
	 *            页对象
	 * @param params
	 *            参数
	 * @return Page<TermBrand>
	 */
	public Page<TermBrand> getTermBrandPageByParams(final Page<TermBrand> page, Map<String, String> params) {
		return terminalBrandDao.getTermBrandPageByParams(page, params);

	}

	/**
	 * 校验 是否有效的终端品牌 check whether it is a valid terminal brand
	 * 
	 * @param terminalBrand
	 * @return
	 */
	private boolean validateTerminalBrand(TermBrand terminalBrand) {
		if (terminalBrand == null) {
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again. ");
		}

		if (!StringUtils.hasText(terminalBrand.getBrandName())) {
			throw new AppException(MessageKeyConstants.TERM_TERMINAL_BRAND_NAME_NOT_NULL,
					"Terminal brand name can not be left empty. Please input terminal brand name and submit again.");
		}

		if (!StringUtils.hasText(terminalBrand.getCompanyName())) {
			throw new AppException(MessageKeyConstants.TERM_COMPANY_NAME_NOT_NULL,
					"Company name can not be left empty. Please input company name and submit again.");
		}

		return true;

	}

	/**
	 * 获取所有终端品牌
	 * 
	 * get all of terminal brand
	 * 
	 * @return List<TermBrand>
	 */
	public List<TermBrand> getAllTermBrand() {
		return this.terminalBrandDao.getAll();
	}

}
