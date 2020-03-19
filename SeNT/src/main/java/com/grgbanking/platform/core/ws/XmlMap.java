/**
 * 文件名：MapConvertor.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author yrliang
 * 
 */
@XmlType(name = "MapConvertor")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlMap {

	private List<MapEntry> entries = new ArrayList<MapEntry>();

	/**
	 * @param entry
	 *            MapEntry
	 */
	public void addEntry(MapEntry entry) {

		entries.add(entry);

	}

	/**
	 * yrliang Map实体
	 */
	public static class MapEntry {

		/**
		 * 构造函数
		 */
		public MapEntry() {

			super();

		}

		/**
		 * 构造函数
		 * 
		 * @param entry
		 *            Map.Entry
		 */

		public MapEntry(Map.Entry<String, Object> entry) {

			super();

			this.key = entry.getKey();

			this.value = entry.getValue();

		}

		/**
		 * 构造函数
		 * 
		 * @param key
		 *            键
		 * @param value
		 *            值
		 */

		public MapEntry(String key, Object value) {

			super();

			this.key = key;

			this.value = value;
		}

		private String key;

		private Object value;

		/**
		 * @return 键
		 */
		public String getKey() {

			return key;

		}

		/**
		 * @param key
		 *            键
		 */
		public void setKey(String key) {

			this.key = key;

		}

		/**
		 * @return 值
		 */
		public Object getValue() {

			return value;

		}

		/**
		 * @param value
		 *            值
		 */
		public void setValue(Object value) {

			this.value = value;

		}

	}

	/**
	 * @return List<MapEntry>
	 */
	public List<MapEntry> getEntries() {

		return entries;

	}

}
