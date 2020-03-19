/**
 * 文件名：CustomDriverManagerConnectionProvider.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.hibernate;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.hibernate.connection.DriverManagerConnectionProvider;

import com.grgbanking.platform.core.utils.AESUtil;

/**
 * 修改hibernate连接密码为加密方式
 * 
 * @author yrliang
 * 
 */
public class CustomDriverManagerConnectionProvider extends DriverManagerConnectionProvider {
	/**
	 * 构造函数
	 */
	public CustomDriverManagerConnectionProvider() {
		super();
	}

	@Override
	public void configure(Properties props) {
		// String user = props.getProperty(Environment.USER);
		String psw = props.getProperty(Environment.PASS);
		// String url = props.getProperty(Environment.URL);
		// props.setProperty(Environment.USER, SecUtil.decrypt(user));
		props.setProperty(Environment.PASS, AESUtil.decrypt(psw));
		// props.setProperty(Environment.URL,SecUtil.decrypt(url));
		super.configure(props);
	}
}
