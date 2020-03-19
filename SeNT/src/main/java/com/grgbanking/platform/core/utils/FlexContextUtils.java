/**
 * 文件名：FlexContextUtils.java
 * 创建日期： 2012-5-30
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import javax.servlet.http.HttpServletRequest;

import flex.messaging.FlexContext;

/**
 * 项目名称：platform<br>
 * 包名：com.grgbanking.platform.core.utils <br>
 * 类名称：FlexContextUtils <br>
 * 类描述：简单描述该类的主要功能<br>
 ****************************************************** <br>
 * 主要方法：<br>
 * 描述各个方法用途 <br>
 * 描述各个方法用途 <br>
 ****************************************************** <br>
 * 作者：Vinson <br>
 * 创建日期：Jun 16, 2011 <br>
 * 公司：GRGBanking <br>
 * 版本：V1.0<br>
 ******************************************************* <br>
 * 修改人：Vinson <br>
 * 修改时间：Jun 16, 2011 3:57:57 PM <br>
 * 修改原因： 描述修改原因和用途<br>
 * 
 * @author SONY
 */
public class FlexContextUtils {

	/**
	 * 日期：Jun 16, 2011<br>
	 * 版本：V1.0<br>
	 * 描述：getClientIp(Get HttpRequest from the FlexContext and return the client
	 * IP address) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：Jun 16, 2011 3:21:35 PM <br>
	 * 创建人 Vinson<br>
	 * ===============================================<br>
	 * 修改日期：Jun 16, 2011<br>
	 * 修改人 Vinson<br>
	 * 修改描述 getClientIp(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @return String
	 * @Exception 异常对象 <br>
	 */
	public static String getClientIp() {
		HttpServletRequest request = FlexContext.getHttpRequest();
		String clientIp = null;
		if (request != null) {
			clientIp = FlexContext.getHttpRequest().getRemoteAddr();
		}

		return clientIp;
	}
}
