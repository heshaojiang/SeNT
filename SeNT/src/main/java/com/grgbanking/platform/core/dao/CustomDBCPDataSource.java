/**
 * 文件名：CustomDBCPDataSource.java
 * 创建日期： 2011-12-1
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.dao;

import org.apache.commons.dbcp.BasicDataSource;

import com.grgbanking.platform.core.utils.AESUtil;

/**
 * @author yrliang
 * 
 */
public class CustomDBCPDataSource extends BasicDataSource {

	@Override
	public void setPassword(String password) {
		String decoded = AESUtil.decrypt(password);
		super.setPassword(decoded);
	}
}
