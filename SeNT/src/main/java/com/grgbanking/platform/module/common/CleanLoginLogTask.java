/**
 * 文件名：CleanLoginLogTask.java
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
import com.grgbanking.platform.module.log.service.LoginLogService;
import com.grgbanking.platform.module.param.service.ParamService;

/**
 * Clean LoginLog Task<br>
 * 定义清除历史登录日志的任务
 * 
 * @author yt
 * 
 */
public class CleanLoginLogTask {
	private static Logger logger = LoggerFactory.getLogger(CleanLoginLogTask.class);

	@Autowired
	LoginLogService loginLogService;

	@Autowired
	ParamService paramService;

	public void execute() {
		String strDays = paramService.getValueByPath(AppConstants.INTERVALS_CLEAN_LOGINLOG);
		int days = AppConstants.DAYS_CLEAN_LOGINLOG;
		try {
			days = Integer.parseInt(strDays);
		} catch (NumberFormatException ex) {
			// 此处无需处理异常
			logger.warn("Not set INTERVALS_CLEAN_LOGINLOG param!");
		}

		loginLogService.batchDelete(days);

		logger.info("CleanLoginLogTask executed.");

	}
}
