/**
 * 文件名：CmlStrideTransferRecordDao.java
 * 创建日期： 2014-05-12
 * Copyright (c) 2011-2013 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.sent.stride.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.stride.entity.StrideTransferRecord;

/**
 * 实体信息Dao<br>
 * 
 * StrideTransferRecordDao
 * 
 * @author  code auto generated
 * 
 */
@Repository
public class StrideTransferRecordDao extends BaseDao<StrideTransferRecord> {

	
	/**
	 * 根据实体属性查询实体信息
	 * 
	 * @param fieldName 属性名称
	 * @param value 参数值
	 * @return
	 */
	public StrideTransferRecord getByField(String fieldName, String value) {
		return super.findFirstBy(fieldName, value);
	}

	/**
	 * 根据参数查找分页的实体数据
	 * 
	 * @param page
	 * @param params
	 * @return
	 */
	public Page<StrideTransferRecord> getCmlStrideTransferRecordPageByParams(Page<StrideTransferRecord> page,
			Map<String, String> params) {
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(" from StrideTransferRecord tb ");
		if (params != null) {
			hql.append(WHERE);
			for (String key : params.keySet()) {
				if (params.get(key) == null) {
					continue;
				}
				//请按实际需要修改查询条件
				String paramValue = params.get(key);
				if (!paramValue.equals("")) {
					hql.append(" tb."+key+" like :"+paramValue+" and ");
					param.put("key", "%" + paramValue + "%");
				}
			}
			if (hql.toString().endsWith(WHERE)) {
				hql.delete(hql.length() - WHERE.length(), hql.length());
			} else {
				hql.delete(hql.length() - 4, hql.length());
			}
		}
		return super.findPage(page, hql.toString(), param);
	}

}
