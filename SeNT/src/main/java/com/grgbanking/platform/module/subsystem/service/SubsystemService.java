/**
 * 文件名：SysSubsystemService.java
 * 创建日期： 2012-4-13
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.subsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.subsystem.dao.SubsystemDao;
import com.grgbanking.platform.module.subsystem.entity.Subsystem;

/**
 * @author yrliang <br>
 *         子系统查询服务类
 */
@Service
public class SubsystemService extends BaseService {
	@Autowired
	SubsystemDao dao;

	public List<Subsystem> getSubsystemList() {
		List<Subsystem> list = dao.find("from Subsystem where status='Y'");

		return list;
	}
}
