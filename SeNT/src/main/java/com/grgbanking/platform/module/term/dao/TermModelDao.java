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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.term.entity.TermModel;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 终端型号Dao<br>
 * 
 * Terminal Model Dao
 * 
 * @author Jonas
 * 
 */
@Repository
public class TermModelDao extends BaseDao<TermModel> {

	private static final String QUERY_BY_TERMINAL_MODELNAME_FUZZILY = " from TermModel tm where tm.modelName like '%'||?||'%' ";

	/**
	 * 根据型号名称查找终端型号<br>
	 * 
	 * get terminal model by model name
	 * 
	 * 
	 * @param modelName
	 * @return
	 */
	public TermModel getByModelName(String modelName) {
		return super.findUniqueBy(AppConstants.TERMINAL_MODELNAME, modelName);
	}

	/**
	 * 根据品牌型号查找分页的终端型号数据<br>
	 * 
	 * get 1 page of terminal model by model name and page information
	 * 
	 * @param page
	 * @param modelName
	 * @return
	 */
	public Page<TermModel> getByModelNameFuzzily(Page<TermModel> page, String modelName) {
		if (modelName == null || modelName.trim().length() == 0)
			return super.findPage(page);
		return super.findPage(page, QUERY_BY_TERMINAL_MODELNAME_FUZZILY, modelName);
	}

	/**
	 * 
	 * 根据参数查找分页的终端型号数据<br>
	 * 
	 * get 1 page of terminal model by params and page information
	 * 
	 * @param page
	 * @param params
	 * @return
	 */
	public Page<TermModel> getTermModelPageByParams(Page<TermModel> page, Map<String, String> params)
	{
		String modelName = StringUtil.trim(params.get("modelName"));
		String brandId = StringUtil.trim(params.get("brandId"));
		
		StringBuffer hql = new StringBuffer(
				" select tm" +
				" from TermModel tm" +
				" left outer join tm.brand tb" +
				" left outer join tm.type tt" +
				" where 1=1"
		);
		List<Object> parameters = new ArrayList<Object>();
		
		if( modelName.equals("")==false )
		{
			hql.append(" and tm.modelName like ?");
			parameters.add("%" + modelName + "%");
		}
		
		if( brandId.equals("")==false )
		{
			hql.append(" and tm.brand.id = ? ");
			parameters.add(brandId);
		}
		
		return super.findPage(page, hql.toString(), parameters.toArray());
	}

	/**
	 * 联动查找设备型号
	 */
	public List<TermModel> getTermModelListByParams(Map<String, String> params) {
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(" from TermModel tm ");
		if (params != null) {
			hql.append(WHERE);
			for (String key : params.keySet()) {
				if (params.get(key) == null) {
					continue;
				}
				String paramValue = params.get(key);
				if (key.equals("brand") && !paramValue.equals("")) {
					hql.append(" tm.brandId =:brandId and ");
					param.put("brandId", paramValue);
				}
				if (key.equals("termType") && !paramValue.equals("")) {
					hql.append("  tm.typeId =:typeId and ");
					param.put("typeId", paramValue);
				}
			}
			if (hql.toString().endsWith(WHERE)) {
				hql.delete(hql.length() - WHERE.length(), hql.length());
			} else {
				hql.delete(hql.length() - 4, hql.length());
			}
		}
		return super.find(hql.toString(), param);
	}
}
