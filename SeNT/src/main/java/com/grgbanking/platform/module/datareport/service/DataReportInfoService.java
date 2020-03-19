/**
 * 文件名：ReportConditionService.java
 * 创建日期： 2012-5-28
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.datareport.service;

import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.datareport.dao.DataReportInfoDao;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import flex.messaging.FlexContext;

/**
 * @author yrliang
 * 
 */
@Service
@Transactional
public class DataReportInfoService extends BaseDao<Object>{

	@Autowired
	OrgInfoDao orgInfoDao;

	@Autowired
	private DataReportInfoDao dataReportInfoDao;
	
	
	/**
	 * 根据配置查询统计数据
	 * 
	 * @param page
	 * @param type
	 * @return
	 */
	public Map<String, List<?>> getDataReport(Map condition) {

		String orgId      = (String)condition.get("orgId");
		if( StringUtils.isBlank(orgId)==false && condition.containsKey("pathCode")==false )
		{
			condition.put("pathCode", orgInfoDao.getPathCodeById(orgId));
		}
		Map<String, List<?>> rsMap = dataReportInfoDao.queryDataReport(condition);
		
		return rsMap;

	}
	
	
	public String exportDataReport(Map condition){
		return dataReportInfoDao.exportDataReport(condition);

	}
	
}
