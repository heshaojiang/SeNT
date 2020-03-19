/**
 * 文件名：MethodResourceDetailsServiceImpl.java
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

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.security.service.interfaces.IMethodResourceDetailsService;
import com.grgbanking.platform.core.security.service.interfaces.IResourceServiceable;
import com.grgbanking.platform.core.security.vo.ResourceVo;

/**
 * 从数据库查询method resoure授权定义Map的实现类.
 * 
 * @author yrliang
 */
@Service
@Transactional(readOnly = true)
public class MethodResourceDetailsServiceImpl implements IMethodResourceDetailsService {

	private IResourceServiceable resourceService;

	/**
	 * 返回方法Map
	 * 
	 * @return LinkedHashMap
	 */
	public LinkedHashMap<String, String> getMethodMap() {
		List<ResourceVo> resourceList = resourceService.getMethodResourceWithAuthorities();

		LinkedHashMap<String, String> requestMap = new LinkedHashMap<String, String>(resourceList.size());
		for (ResourceVo resource : resourceList) {
			requestMap.put(resource.getValue(), resource.getAuthNames());
		}
		return requestMap;
	}

	/**
	 * @param resourceService
	 *            IResourceServiceable
	 */
	public void setResourceService(IResourceServiceable resourceService) {
		this.resourceService = resourceService;
	}
}
