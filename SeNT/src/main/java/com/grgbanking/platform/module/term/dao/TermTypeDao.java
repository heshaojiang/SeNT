/**
 * 文件名：TermModelDao.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.term.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.term.entity.TermType;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 终端类型Dao<br>
 * 
 * Terminal Type Dao
 * 
 * @author Jonas
 * 
 */
@Repository
public class TermTypeDao extends BaseDao<TermType> {

	private static final String QUERY_BY_TERMINAL_TYPE_FUZZILY = " from TermType tt where tt.type like '%'||?||'%' order by tt.code asc ";
	private static final String QUERY_BY_TERMINAL_TYPE_FUZZILY_ORDER = " from TermType tt  order by tt.code asc ";

	/**
	 * 根据类型名称查找终端类型<br>
	 * 
	 * get terminal type by type name
	 * 
	 * @param type
	 * @return
	 */
	public TermType getByType(String type) {
		return super.findUniqueBy(AppConstants.TERMINAL_TYPE, "%" + type + "%");
	}

	/**
	 * 根据类型名称查找分页的终端类型数据<br>
	 * 
	 * get 1 page of terminal type by type name and page information
	 * 
	 * @param page
	 * @param type
	 * @return
	 */
	public Page<TermType> getByTypeFuzzily(Page<TermType> page, String type) {
		if (type == null || type.trim().length() == 0)
			return super.findPage(page, QUERY_BY_TERMINAL_TYPE_FUZZILY_ORDER);
		return super.findPage(page, QUERY_BY_TERMINAL_TYPE_FUZZILY, type);
	}

	/**
	 * 联动查找终端类型
	 */
	public List<TermType> getTermTypeListByParams(Map<String, String> params) {
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(
				" from TermType tt where tt.id in(select tm.typeId  from TermBrand tb,TermModel tm,TermType ttt ");
		hql.append(WHERE);
		hql.append(" 1 = 1 ");
		StringBuffer hqlrn = new StringBuffer(hql);
		StringBuffer hqlModel = new StringBuffer("");
		StringBuffer hqlBrand = new StringBuffer("");
		
		/*
		if (params != null) {
			for (String key : params.keySet()) {
				if (params.get(key) == null) {
					continue;
				}
				String paramValue = params.get(key);
				if (key.equals("brand") && !paramValue.equals("")) {
					hqlBrand.append(" tb.id = tm.brandId  and tb.id =:brandId) and ");
					param.put("brandId", paramValue);
				}
				if (key.equals("model") && !paramValue.equals("")) {
					hqlModel.append(" ttt.id = tm.typeId  and tm.id =:typeId) and ");
					param.put("typeId", paramValue);
				}
			}
		}
		if (!hqlModel.equals("") && hqlModel.length() != 0) {
			hqlModel.delete(hqlModel.length() - 4, hqlModel.length());
			hql.append(hqlModel);
		} else if (!hqlBrand.equals("") && hqlBrand.length() != 0) {
			hqlBrand.delete(hqlBrand.length() - 4, hqlBrand.length());
			hql.append(hqlBrand);
		} else {
			hql = new StringBuffer(" from TermType tt ");
		}
		*/
		
		if (StringUtil.isNotBlank(params.get("brand"))) {
			hqlBrand.append(" and tb.id = tm.brandId  and tb.id =:brandId ");
			param.put("brandId", params.get("brand"));
			hql.append(hqlBrand);
		}
		
		if (StringUtil.isNotBlank(params.get("model"))) {
			hqlModel.append(" and ttt.id = tm.typeId  and tm.id =:typeId ");
			param.put("typeId", params.get("model"));
			hql.append(hqlModel);
		}
		if (hqlBrand.length() > 0 && hqlModel.length() > 0)
			hql.append(")");
		else
			hql = new StringBuffer(" from TermType tt ");
		
		return super.find(hql.toString(), param);
	}
}
