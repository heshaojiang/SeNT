/**
 * 文件名：UrlResourceDetailsServiceImpl.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.security.service.interfaces.IResourceServiceable;
import com.grgbanking.platform.core.security.vo.ResourceVo;
import com.grgbanking.platform.core.springsecurity.IResourceDetailsService;

/**
 * 从数据库查询URL--授权定义Map的实现类.
 * 
 * @author yrliang
 */
@Transactional(readOnly = true)
public class UrlResourceDetailsServiceImpl implements IResourceDetailsService {

	private IResourceServiceable resourceService;

	/**
	 * @param resourceService
	 *            IResourceServiceable
	 */
	public void setResourceService(IResourceServiceable resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * @see IResourceDetailsService#getRequestMap()
	 * @return 请求资源权限
	 */
	public LinkedHashMap<String, String> getRequestMap() {
		List<ResourceVo> resourceList = resourceService.getUrlResourceWithAuthorities();

		LinkedHashMap<String, String> requestMap = new LinkedHashMap<String, String>(resourceList.size());
		for (ResourceVo resource : resourceList) {
			requestMap.put(resource.getValue(), resource.getAuthNames());
		}
		return requestMap;
	}
}
