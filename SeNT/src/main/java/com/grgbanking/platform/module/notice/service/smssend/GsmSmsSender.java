/**
 * 文件名：GsmSmsSender.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.service.smssend;

import java.util.List;

import com.grgbanking.platform.core.sms.GSMSmsUtil;
import com.grgbanking.platform.module.notice.vo.SmsVo;

/**
 * @author yrliang
 * 
 */
public class GsmSmsSender extends AbstractSmsSender {
	private boolean started = false; // 是否已启动

	private String manufacturer; // 制造商
	private String model; // modem 型号
	private Integer[] bauds;// 波特率

	public GsmSmsSender() {
		super();

		//		manufacturer = setting.getManufacturer();
		//		model = setting.getModel();
		//
		//		String comBaud = setting.getComBaud();
		//		List<Integer> list = new ArrayList<Integer>();
		//		for (String s : comBaud.split(",")) {
		//			int intBaud;
		//			try {
		//				intBaud = Integer.valueOf(s.trim());
		//				list.add(intBaud);
		//			} catch (NumberFormatException ex) {
		//				logger.error(
		//						"Param 'param.javapt.smsSetting.comBaud' set error!",
		//						ex);
		//			}
		//		}
		//		bauds = list.toArray(new Integer[0]);
	}

	/**
	 * 
	 * @param smsVo
	 * @return 成功或失败
	 */
	public void sender(List<SmsVo> list) {
		if (!started) {
			GSMSmsUtil.startService(setting);
			started = true;
		}
		for(SmsVo sms : list) {
			try {
				String newStr = new String(super.getContent(sms).getBytes(), setting.getEncoding());
				//				byte[] bytes = newStr.getBytes(setting.getEncoding());
				boolean result = GSMSmsUtil.sendMessage(sms.getMobile(), newStr);
				sms.setSucc(result);
			} catch(Exception e) {
				logger.error("Send message error, error!", e);
			}
		}

	}
}
