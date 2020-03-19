/**
 * 文件名：TestServiceImpl.java
 * 创建日期： 2012-6-19
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.testmodule.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.platform.module.term.entity.TermInfo;

/**
 * @author yrliang
 * 
 */
@WebService(endpointInterface = "com.grgbanking.platform.module.testmodule.ws.ITestService")
@Service
@Transactional(readOnly = true)
public class TestServiceImpl implements ITestService {
	@Autowired
	TermInfoDao terminalInfoDao;

	public TermInfo getTermInfo(String id) {
		return terminalInfoDao.get(id);
	}

	public List<String> getList() {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");

		return list;
	}

	public Map<String, Integer> getMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("aaa", 100);
		map.put("bbb", 200);
		return map;
	}

	public List<TermInfo> getTermInfoList(String termCode) {
		List<TermInfo> list = new ArrayList<TermInfo>();
		TermInfo t = new TermInfo();
		t.setNetAddr("10.1.12.22");
		t.setTermCode("ttt");

		TermInfo z = new TermInfo();
		z.setNetAddr("10.1.12.23");
		z.setTermCode("zzz");

		list.add(t);
		list.add(z);

		return list;
	}
}
