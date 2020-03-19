/**
 * 文件名：GrgImprovedNamingStrategy.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.hibernate.cfg;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.cfg.NamingStrategy;

/**
 * Hibernate工程实体和数据表映射策略.
 * 
 * @author yrliang
 * 
 */
public class GrgImprovedNamingStrategy extends ImprovedNamingStrategy implements NamingStrategy {

	/**
	 * 列表和表名转化为大写
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String columnName(String columnName) {
		return super.columnName(columnName).toUpperCase();
	}

	@Override
	public String tableName(String tableName) {
		return super.tableName(tableName).toUpperCase();
	}

}
