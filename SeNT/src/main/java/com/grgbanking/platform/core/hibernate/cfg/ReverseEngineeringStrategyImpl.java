/**
 * 文件名：ReverseEngineeringStrategyImpl.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.hibernate.cfg;

import org.hibernate.cfg.reveng.DefaultReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hibernate反向工程实体和数据表映射策略.
 * 
 * @author yrliang
 * 
 */
public class ReverseEngineeringStrategyImpl extends DelegatingReverseEngineeringStrategy {

	// @Override
	// public String tableToClassName(TableIdentifier table) {
	// // TODO Auto-generated method stub
	// int _index = table.getName().indexOf("_");
	// String pre = table.getName().substring(0, _index);
	//
	// // String packageName = settings.getDefaultPackageName();
	//
	// return super.tableToClassName(table).substring(5 + pre.length());
	// }
	/**
	 * 构造函数
	 */
	public ReverseEngineeringStrategyImpl() {
		super(new DefaultReverseEngineeringStrategy());
	}

	/**
	 * 构造函数
	 * 
	 * @param strategy
	 *            ReverseEngineeringStrategy
	 */
	public ReverseEngineeringStrategyImpl(ReverseEngineeringStrategy strategy) {
		super(strategy);
	}

	@Override
	/**
	 * @param talbe 表定义对象
	 * @param column 列名
	 * @return 属性名
	 */
	public String columnToPropertyName(TableIdentifier table, String column) {
		Logger logger = LoggerFactory.getLogger(getClass());
		logger.warn("#field[" + column + "] transfer to UpperCamelCase: {}", super.columnToPropertyName(table, column
				.substring(2)));

		// return
		// StringUtils.uncapitalize(ReverseEngineeringStrategyUtil.toUpperCamelCase(column).substring(1));
		// String columnName = super.columnToPropertyName(table, column);
		// return
		// StringUtils.uncapitalize(ReverseEngineeringStrategyUtil.toUpperCamelCase(column.substring(1)));

		return super.columnToPropertyName(table, column.substring(2));

	}
}
