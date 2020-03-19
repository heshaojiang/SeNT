/**
 * 文件名：ExtendPropertyDao.java
 * 创建日期： 2012-3-30
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.exproperty.dao;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.exproperty.entity.ExtendProperty;
import com.grgbanking.platform.module.exproperty.exception.ExPropertyException;

/**
 * @author yrliang <br>
 *         扩展属性配置Dao
 */
@Repository
@Transactional
public class ExtendPropertyDao extends BaseDao<ExtendProperty> {
	public String getFieldName(String tableName, String property) {
		try {
			ExtendProperty exProperty = this.findUnique("from ExtendProperty where table=? and  propertyName=?",
					new Object[] { tableName, property });
			String fieldName = exProperty.getFieldName();
			if (fieldName == null)
				throw new ExPropertyException(
						"The value of column C_FIELD_NAME is null in table EXTEND_PROPERTY with C_PROPERTY IS "
								+ tableName + " AN C_TABLE IS " + property);
			if (!fieldName.startsWith("F"))
				throw new ExPropertyException(
						"The value of column C_FIELD_NAME is not right in table EXTEND_PROPERTY with C_PROPERTY IS "
								+ tableName + " AN C_TABLE IS " + property);

			return exProperty.getFieldName();
		} catch (HibernateException ex) {
			throw new ExPropertyException("Can not found this C_PROPERTY_NAME it's value is " + property
					+ " in table EXTEND_PROPERTY with C_TABLE is " + tableName, ex);
		}  
	}
}
