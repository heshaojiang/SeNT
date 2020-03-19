/**
 * 文件名：IMessage.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.exception;

/**
 * 类描述：实现该接口的类必须提供国际化语言串对应的key<br>
 * 
 * @author yrliang
 */
public interface IMessage {

	/**
	 * 
	 * 日期：2011-5-23<br>
	 * 版本：V1.0<br>
	 * 描述：getMsgKey(返回国际化语言传对应的key) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-5-23 下午01:51:19 <br>
	 * 创建人 yt<br>
	 * ===============================================<br>
	 * 修改日期：2011-5-23<br>
	 * 修改人 yt<br>
	 * 修改描述 getMsgKey(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @return String
	 * @Exception 异常对象 <br>
	 */
	String getMsgKey();
}
