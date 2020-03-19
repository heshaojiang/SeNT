/**
 * 文件名：CustomBasicDataSource.java
 * 创建日期： 2012-8-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author yrliang
 * 
 */
public class CustomBasicDataSource extends BasicDataSource {
	@Override
	public void setPassword(String password) {
		super.setPassword(AESUtil.decrypt(password));
	}

}
