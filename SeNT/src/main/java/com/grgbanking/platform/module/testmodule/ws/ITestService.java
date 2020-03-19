/**
 * 文件名：ITestService.java
 * 创建日期： 2012-6-19
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.testmodule.ws;

import java.util.List;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.grgbanking.platform.core.ws.MapAdapter;
import com.grgbanking.platform.module.term.entity.TermInfo;

/**
 * @author yrliang
 * 
 */
@WebService
public interface ITestService {
	TermInfo getTermInfo(@WebParam(name = "termId") String id);

	List<String> getList();

	@XmlJavaTypeAdapter(MapAdapter.class)
	Map<String, Integer> getMap();

	List<TermInfo> getTermInfoList(@WebParam(name = "termCode") String termCode);
}
