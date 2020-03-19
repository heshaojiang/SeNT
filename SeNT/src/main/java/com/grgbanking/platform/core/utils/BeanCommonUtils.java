/**
 * 文件名：BeanCommonUtils.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * This is Utils & Tools class which contains the common methods that facilitate
 * coding efficiency
 * 
 * @author SONY
 */
public class BeanCommonUtils {
	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(BeanCommonUtils.class);

	/**
	 * Compare each field value in the two Objects
	 * 
	 * <P>
	 * Return true only if the two object has same class type and all the fields
	 * value are the same, false otherwise
	 * 
	 * <P>
	 * NOTE: This method is only suitable for the comparison between two
	 * Instants of same class
	 * 
	 * @param source
	 * @param target
	 * @return true - only if the two object has same class type and all the
	 *         fields value are the same false - Otherwise
	 */
	public static boolean compareValue(Object source, Object target) {
		boolean result = true;

		// return false if any one of the Object is null
		if (source == null || target == null) {
			return false;
		}

		// This method is only suitable for the same class comparison
		if (!source.getClass().equals(target.getClass())) {
			return false;
		}

		PropertyDescriptor[] srcPds = BeanUtils.getPropertyDescriptors(source.getClass());
		// PropertyDescriptor[] targetPds =
		// BeanUtils.getPropertyDescriptors(to.getClass());
		if (srcPds != null) {
			try {
				for (PropertyDescriptor descriptor : srcPds) {
					Object srcValue = descriptor.getReadMethod().invoke(source, new Object[0]);
					Object targetValue = descriptor.getReadMethod().invoke(target, new Object[0]);

					if (srcValue == null && targetValue == null) {
						continue;
					} else if (srcValue != null && srcValue.equals(targetValue)) {
						continue;
					} else {
						result = false;
						break;
					}
				}
			} catch (IllegalArgumentException e) {
				logger.error("IllegalArgumentException occur. ", e);
			} catch (IllegalAccessException e) {
				logger.error("IllegalAccessException occur. ", e);
			} catch (InvocationTargetException e) {
				logger.error("InvocationTargetException occur. ", e);
			}
		}

		return result;
	}

}
