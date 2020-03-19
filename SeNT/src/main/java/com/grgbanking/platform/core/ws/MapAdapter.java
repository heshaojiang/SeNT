/**
 * 文件名：MapAdapter.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.ws;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author yrliang
 * 
 */
public class MapAdapter extends XmlAdapter<XmlMap, Map<String, Object>> {

	@Override
	public XmlMap marshal(Map<String, Object> map) throws Exception {

		XmlMap convertor = new XmlMap();

		for (Map.Entry<String, Object> entry : map.entrySet()) {

			XmlMap.MapEntry e = new XmlMap.MapEntry(entry);

			convertor.addEntry(e);

		}

		return convertor;

	}

	@Override
	public Map<String, Object> unmarshal(XmlMap map) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>();

		for (XmlMap.MapEntry e : map.getEntries()) {

			result.put(e.getKey(), e.getValue());

		}

		return result;

	}

}
