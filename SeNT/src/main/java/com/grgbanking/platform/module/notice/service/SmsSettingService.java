/**
 * 文件名：NoticeTask.java
 * 创建日期： 2012-4-23
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.utils.ReflectionUtils;
import com.grgbanking.platform.module.notice.vo.SmsSettingVo;
import com.grgbanking.platform.module.param.entity.Param;
import com.grgbanking.platform.module.param.service.ParamService;

/**
 * @author yrliang
 * 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SmsSettingService {

	@Autowired
	ParamService paramService;

	public SmsSettingVo loadSmsSettingVo() {
		SmsSettingVo vo = new SmsSettingVo();

		Param param = paramService.getParamByPath(AppConstants.SMS_SETTING_PATH);
		List<Param> list = paramService.getParamChildlist(param.getId());
		for (Param p : list) {
			ReflectionUtils.setFieldValue(vo, p.getKey(), p.getValue());
		}
		return vo;
	}

	public String getSendMethodSetting() {
		Param param = paramService.getParamByPath(AppConstants.SMS_SETTING_SENDMETHOD_PATH);
		return param.getValue();
	}
}
