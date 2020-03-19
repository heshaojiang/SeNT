/**
 * 文件名：RandomGenerator.java
 * 创建日期： 2012-6-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

/**
 * 产生随机数.
 * 
 * @author SONY
 */
public class RandomGenerator {
	/**
	 * 
	 * 创建一个新的实例 RandomGenerator.
	 * 
	 */
	public RandomGenerator() {
	}

	/**
	 * 
	 * 日期：2011-6-30<br>
	 * 版本：V1.0<br>
	 * 描述：randomPassword(创建随机密码) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-6-30 上午11:45:53 <br>
	 * 创建人 yt<br>
	 * ===============================================<br>
	 * 修改日期：2011-6-30<br>
	 * 修改人 yt<br>
	 * 修改描述 randomPassword(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @return String
	 * @Exception 异常对象 <br>
	 */
	public static String randomPassword() {
		return randomString(6);
	}

	/**
	 * 
	 * 日期：2011-6-30<br>
	 * 版本：V1.0<br>
	 * 描述：randomString(创建随机字符串) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-6-30 上午11:46:53 <br>
	 * 创建人 yt<br>
	 * ===============================================<br>
	 * 修改日期：2011-6-30<br>
	 * 修改人 yt<br>
	 * 修改描述 randomString(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param length
	 *            字符串长度
	 * @return String
	 * @Exception 异常对象 <br>
	 */
	public static String randomString(int length) {
		return randomString(length, true);
	}

	/**
	 * 
	 * 日期：2011-6-30<br>
	 * 版本：V1.0<br>
	 * 描述：randomString(创建包含数字的随机字符串) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-6-30 上午11:46:53 <br>
	 * 创建人 yt<br>
	 * ===============================================<br>
	 * 修改日期：2011-6-30<br>
	 * 修改人 yt<br>
	 * 修改描述 randomString(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param length
	 *            字符串长度
	 * @param includeNumbers
	 *            随机字符串中包含数字
	 * @return String
	 * @Exception 异常对象 <br>
	 */
	public static String randomString(int length, boolean includeNumbers) {
		StringBuffer b = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			if (includeNumbers) {
				b.append(randomCharacter());
			} else {
				b.append(randomAlpha());
			}
		}
		return b.toString();
	}

	/**
	 * 
	 * 日期：2011-6-30<br>
	 * 版本：V1.0<br>
	 * 描述：randomCharacter(创建随机字符) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-6-30 上午11:48:30 <br>
	 * 创建人 yt<br>
	 * ===============================================<br>
	 * 修改日期：2011-6-30<br>
	 * 修改人 yt<br>
	 * 修改描述 randomCharacter(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @return char
	 * @Exception 异常对象 <br>
	 */
	public static char randomCharacter() {
		int i = (int) (Math.random() * 3D);
		if (i < 2) {
			return randomAlpha();
		} else {
			return randomDigit();
		}
	}

	/**
	 * 
	 * 日期：2011-6-30<br>
	 * 版本：V1.0<br>
	 * 描述：randomAlpha(创建随见字母) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-6-30 上午11:48:48 <br>
	 * 创建人 yt<br>
	 * ===============================================<br>
	 * 修改日期：2011-6-30<br>
	 * 修改人 yt<br>
	 * 修改描述 randomAlpha(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @return char
	 * @Exception 异常对象 <br>
	 */
	public static char randomAlpha() {
		int i = (int) (Math.random() * 52D);
		if (i > 25) {
			return (char) ((97 + i) - 26);
		} else {
			return (char) (65 + i);
		}
	}

	/**
	 * 
	 * 日期：2011-6-30<br>
	 * 版本：V1.0<br>
	 * 描述：randomDigit(创建随机数字) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-6-30 上午11:49:05 <br>
	 * 创建人 yt<br>
	 * ===============================================<br>
	 * 修改日期：2011-6-30<br>
	 * 修改人 yt<br>
	 * 修改描述 randomDigit(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @return char
	 * @Exception 异常对象 <br>
	 */
	public static char randomDigit() {
		int i = (int) (Math.random() * 10D);
		return (char) (48 + i);
	}
}
