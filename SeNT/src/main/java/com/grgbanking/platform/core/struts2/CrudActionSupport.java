/**
 * 文件名：CrudActionSupport.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.struts2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * Struts2中典型CRUD Action的抽象基类.
 * 
 * 主要定义了对Preparable,ModelDriven接口的使用,以及CRUD函数和返回值的命名.
 * 
 * @param <T>
 *            CRUDAction所管理的对象类型.
 * 
 * @author yrliang
 */
@SuppressWarnings("serial")
public abstract class CrudActionSupport<T> extends ActionSupport implements ModelDriven<T>, Preparable {

	/**
	 * 进行增删改操作后,以redirect方式重新打开action默认页的result名.
	 */
	public static final String RELOAD = "reload";
	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Action函数, 默认的action函数, 默认调用list()函数.
	 * 
	 * @return result名
	 */
	@Override
	public String execute() {
		return list();
	}

	// -- CRUD Action函数 --//
	/**
	 * Action函数,显示Entity列表界面. 建议return SUCCESS.
	 * 
	 * @return result名
	 */
	public abstract String list();

	/**
	 * Action函数,显示新增或修改Entity界面. 建议return INPUT.
	 * 
	 * @return result名
	 */
	@Override
	public abstract String input();

	/**
	 * Action函数,新增或修改Entity. 建议return RELOAD.
	 * 
	 * @return result名
	 */
	public abstract String save();

	/**
	 * Action函数,删除Entity. 建议return RELOAD.
	 * 
	 * @return result名
	 */
	public abstract String delete();

	// -- Preparable函数 --//
	/**
	 * 实现空的prepare()函数,屏蔽所有Action函数公共的二次绑定.
	 */
	public void prepare() {
	}

	/**
	 * 在input()前执行二次绑定.
	 */
	public void prepareInput() {
		prepareModel();
	}

	/**
	 * 在save()前执行二次绑定.
	 */
	public void prepareSave() {
		prepareModel();
	}

	/**
	 * 等同于prepare()的内部函数,供prepardMethodName()函数调用.
	 */
	protected abstract void prepareModel();
}
