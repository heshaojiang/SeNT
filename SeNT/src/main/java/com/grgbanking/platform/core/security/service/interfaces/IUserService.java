/**
 * 文件名：IUserService.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.service.interfaces;

import java.util.Map;

/**
 * 获取用户信息服务接口
 * 
 * @author yrliang
 * 
 */
public interface IUserService {
	/**
	 * Get the User Detail Info by User Code
	 * 
	 * @param userCode
	 *            用户代码
	 * @return Map 用户信息
	 */
	Map<String, Object> getUserInfoByUserCode(String userCode);
}
