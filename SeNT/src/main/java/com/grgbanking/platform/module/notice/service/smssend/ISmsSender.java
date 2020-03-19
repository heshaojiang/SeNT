/**
 * 文件名：ISmsSender.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.service.smssend;

import java.util.List;

import com.grgbanking.platform.module.notice.vo.SmsVo;

/**
 * @author yrliang
 * 
 */
public interface ISmsSender {
	public void sender(List<SmsVo> smsVo);
}
