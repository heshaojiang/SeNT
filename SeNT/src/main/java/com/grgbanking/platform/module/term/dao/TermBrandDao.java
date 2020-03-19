/**
 * 文件名：ParamDao.java
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
import com.grgbanking.platform.module.term.entity.TermBrand;

/**
 * 终端品牌 Dao<br>
 * 
 * Terminal Brand Dao
 * 
 * @author Jonas
 * 
 */
@Repository
public class TermBrandDao extends BaseDao<TermBrand> {

	private static final String QUERY_BY_TERMINAL_BRANDNAME_FUZZILY = " from TermBrand tb where tb.brandName like '%'||?||'%' ";

	/**
	 * 根据品牌名称查找终端品牌<br>
	 * 
	 * get terminal brand by brand name
	 * 
	 * @param brandName
	 * @return
	 */
	public TermBrand getByBrandName(String brandName) {
		return super.findUniqueBy(AppConstants.TERMINAL_BRANDNAME, brandName);
	}

	/**
	 * 根据品牌名称查找分页的终端品牌数据<br>
	 * 
	 * get 1 page of terminal brand by brand name and page information
	 * 
	 * @param page
	 * @param brandName
	 * @return
	 */
	public Page<TermBrand> getByBrandNameFuzzily(Page<TermBrand> page, String brandName) {
		if (brandName == null || brandName.trim().length() == 0)
			return super.findPage(page);
		return super.findPage(page, QUERY_BY_TERMINAL_BRANDNAME_FUZZILY, brandName);
	}

	/**
	 * 根据参数查找分页的终端品牌数据<br>
	 * 
	 * get 1 page of terminal brand by params and page information
	 * 
	 * @param page
	 * @param brandName
	 * @return
	 */
	public Page<TermBrand> getTermBrandPageByParams(Page<TermBrand> page, Map<String, String> params) {
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(" from TermBrand tb ");
		hql.append(WHERE);
		if (params != null) {
			for (String key : params.keySet()) {
				if (params.get(key) == null) {
					continue;
				}
				String paramValue = params.get(key);
				if (key.equals("brandName") && !paramValue.equals("")) {
					hql.append(" tb.brandName like :brandName and ");
					param.put("brandName", "%" + paramValue + "%");
				} else if (key.equals("companyName")) {
					hql.append(" tb.companyName like :companyName and ");
					param.put("companyName", "%" + paramValue + "%");
				}
			}
		}
		if (hql.toString().endsWith(WHERE)) {
			hql.delete(hql.length() - WHERE.length(), hql.length());
		} else {
			hql.delete(hql.length() - 4, hql.length());
		}
		return super.findPage(page, hql.toString(), param);
	}

	/**
	 * 联动查找终端类型
	 */
	public List<TermBrand> getTermBrandListByParams(Map<String, String> params) {
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(
				" from TermBrand tb1 where tb1.id in(select tm.brandId  from TermBrand tb,TermModel tm,TermType ttt ");
		hql.append(WHERE);
		StringBuffer hqlrn = new StringBuffer(hql);
		StringBuffer hqlModel = new StringBuffer("");
		StringBuffer hqlType = new StringBuffer("");
		if (params != null) {
			for (String key : params.keySet()) {
				if (params.get(key) == null) {
					continue;
				}
				String paramValue = params.get(key);
				if (key.equals("model") && !paramValue.equals("")) {
					hqlModel.append(" tb.id = tm.brandId  and tm.id =:brandId) and ");
					param.put("brandId", paramValue);
				}
				if (key.equals("termType") && !paramValue.equals("")) {
					hqlType.append(" tb.id = tm.brandId and ttt.id = tm.typeId  and tm.typeId =:typeId) and ");
					param.put("typeId", paramValue);
				}
			}
		}
		if (!hqlModel.equals("") && hqlModel.length() != 0) {
			hqlModel.delete(hqlModel.length() - 4, hqlModel.length());
			hql.append(hqlModel);
		} else if (!hqlType.equals("") && hqlType.length() != 0) {
			hqlType.delete(hqlType.length() - 4, hqlType.length());
			hql.append(hqlType);
		} else {
			hql = new StringBuffer(" from TermBrand tb1 ");
		}

		return super.find(hql.toString(), param);
	}

}
