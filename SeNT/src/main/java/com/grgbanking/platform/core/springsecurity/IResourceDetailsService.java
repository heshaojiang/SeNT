/**
 * 文件名：ResourceDetailsService.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.springsecurity;

import java.util.LinkedHashMap;

/**
 * RequestMap生成接口,由用户自行实现从数据库或其它地方查询URL-授权关系定义.
 * 
 * @author calvin
 */
public interface IResourceDetailsService {

	/**
	 * 返回带顺序的URL-授权关系Map, key为受保护的URL, value为能访问该URL的授权名称列表,以','分隔.
	 * 
	 * @return 授权关系Map
	 */
	LinkedHashMap<String, String> getRequestMap();
}
