/**
 * 文件名：CleanOperLogTask.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.module.log.service.OperLogService;
import com.grgbanking.platform.module.param.service.ParamService;

/**
 * Clean OperLog Task<br>
 * 定义清除历史操作日志的任务
 * 
 * @author yt
 * 
 */
public class CleanOperLogTask {
	private static Logger logger = LoggerFactory.getLogger(CleanOperLogTask.class);

	@Autowired
	OperLogService operLogService;

	@Autowired
	ParamService paramService;

	public void execute() {
		String strDays = paramService.getValueByPath(AppConstants.INTERVALS_CLEAN_OPERLOG);
		int days = AppConstants.DAYS_CLEAN_OPERLOG;
		try {
			days = Integer.parseInt(strDays);
		} catch (NumberFormatException ex) {
			// 此处无需处理异常
			logger.warn("Not set INTERVALS_CLEAN_OPERLOG param!");
		}

		operLogService.batchDelete(days);

		logger.info("CleanOperLogTask executed.");

	}
}
