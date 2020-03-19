/**
 * 文件名：MethodResourceDetailsService.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.service.interfaces;

import java.util.LinkedHashMap;

/**
 * 用来获得方法ResourceDetails的服务接口.
 * 
 * @author yrliang
 * 
 */
public interface IMethodResourceDetailsService {
	/**
	 * 返回方法Map
	 * 
	 * @return LinkedHashMap
	 */
	LinkedHashMap<String, String> getMethodMap();
}
