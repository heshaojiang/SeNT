/**
 * 文件名：CmlStrideTransferRecordService.java
 * 创建日期： 2014-05-12
 * Copyright (c) 2011-2013 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.sent.stride.service;

import java.util.Collection;
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
import com.grgbanking.sent.stride.dao.StrideTransferRecordDao;
import com.grgbanking.sent.stride.entity.StrideTransferRecord;

/**
 * 实体信息 service<br>
 * 
 * StrideTransferRecordDao
 * 
 * @author  code auto generated
 * 
 */
@Service
@Transactional
public class StrideTransferRecordService {

	@Autowired
	StrideTransferRecordDao entityDao;

	/**
	 * 保存 实体信息
	 * 
	 * @param entity
	 * @return
	 */
	public boolean saveCmlStrideTransferRecord(StrideTransferRecord entity) {
		
		
		validateCmlStrideTransferRecord(entity);

/*		StrideTransferRecord existedCmlStrideTransferRecord = entityDao
				.getByAccount(entity.getcAccount());
		if (existedCmlStrideTransferRecord != null) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.STUDENT_EXISTED_STUDENT_INFO_ACCOUNT,
					"账号[%s]已经存在",entity.getcAccount());
		}*/

		if (entity.getId() == null) {
			entityDao.save(entity);
		} else {
			entityDao.copyUpdate(entity);
		}
		return true;
	}

	/**
	 * 删除 实体信息
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteCmlStrideTransferRecord(String id) {
		validateId(id);
		entityDao.delete(id);
		return true;
	}

	/**
	 * 校验该记录是否存在
	 * 
	 * @param id
	 */
	private void validateId(String id) {
		if (!StringUtils.hasText(id)) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD,
					"No record is selected. ");
		}
	}

	/**
	 * 批量删除实体信息
	 * 
	 * @param ids
	 * @return
	 */
	public boolean batchDelete(Collection<String> ids) {
		if (ids == null || ids.size() == 0) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD,
					"No record is selected. ");
		}

		
		
		for (String id : ids) {
			deleteCmlStrideTransferRecord(id);
		}

		return true;
	}

	/**
	 * 更新 实体信息
	 * 
	 * @param entity
	 * @return
	 */
	public boolean updateCmlStrideTransferRecord(StrideTransferRecord entity) {

		String id = entity.getId();

		validateCmlStrideTransferRecord(entity);
		validateId(id);

		//根据实际情况修改更新实体
		entityDao.copyUpdate(entity);

		return true;
	}

	/**
	 * 根据参数查找分页的实体数据
	 * 
	 * @param page
	 * @param params
	 * @return
	 */
	public Page<StrideTransferRecord> getCmlStrideTransferRecordPageByParams(
			final Page<StrideTransferRecord> page, Map<String, String> params) {
		return entityDao.getCmlStrideTransferRecordPageByParams(page, params);

	}

	/**
	 * 根据当前语言获取表单或module的基础数据
	 * 
	 * @return
	 */
	public Map<String, Object> getFormInitDatas() {
		Map<String, Object> formInitDatas = new HashMap<String, Object>();
		
		
		return formInitDatas;
	}

	/**
	 * 校验实体信息
	 * 
	 * @param entity
	 * @return
	 */
	private boolean validateCmlStrideTransferRecord(StrideTransferRecord entity) {
		if (entity == null) {
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"实体信息为空");
		}


		return true;

	}

	/**
	 * 获取 所有实体信息
	 * 
	 * @return
	 */
	public List<StrideTransferRecord> getAllCmlStrideTransferRecord() {
		return this.entityDao.getAll();
	}

}
