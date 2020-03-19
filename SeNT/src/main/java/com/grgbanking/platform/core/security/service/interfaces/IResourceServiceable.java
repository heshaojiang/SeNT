/**
 * 文件名：ResourceServiceable.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.service.interfaces;

import java.util.List;

import com.grgbanking.platform.core.security.vo.ResourceVo;

/**
 * 受保护资源对象的泛型DAO.
 * 
 * @author yrliang
 */
public interface IResourceServiceable {
	/**
	 * 查询URL类型的资源并预加载可访问该资源的授权信息.
	 * 
	 * @return 资源列表
	 */
	List<ResourceVo> getUrlResourceWithAuthorities();

	/**
	 * 查询URL类型的资源并预加载可访问该资源的授权信息.
	 * 
	 * @return 资源和权限列表
	 */
	List<ResourceVo> getMethodResourceWithAuthorities();

	/**
	 * 查询URL类型的资源并预加载可访问该资源的授权信息.
	 * 
	 * @param loginName
	 *            登录账号
	 * @return 用户有权访问的资源
	 */
	List<ResourceVo> getResourcesOfUser(String loginName);

}
