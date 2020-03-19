/**
 * 文件名：TermInfoDao.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.term.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.term.constans.TermInfoConsts;
import com.grgbanking.platform.module.term.entity.NoderFile;
import com.grgbanking.platform.module.term.entity.NoderInfo;
import com.grgbanking.platform.module.term.entity.TermInfo;
import com.grgbanking.sent.utils.CollectionsUtil;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 终端基础信息 Dao<br>
 * 
 * Terminal basal information Dao
 * 
 * @author Jonas
 * 
 */
@Repository
public class NoderFileDao extends BaseDao<NoderFile>
{
	@Autowired
	private OrgInfoDao orgDao;
	
	@Autowired
	private TermModelDao termModelDao;
	
	@Autowired
	private TermInfoDao termInfoDao ;
	
	@Autowired
	private TermTypeDao termTypeDao;
	
	@Autowired
	private ParamDao paramDao;
	
	private static final String QUERY_BY_TERMINAL_TERMCODE_FUZZILY = " from NoderFile tm where tm.termCode like ? ";

	/**
	 * 根据终端编号查找终端<br>
	 * 
	 * get terminal by terminal code
	 * 
	 * @param termCode
	 *            终端编码
	 * @return NoderInfo
	 */
	public NoderFile getByNoderIp(String nodeIp) {
		//return super.findUniqueBy(AppConstants.TERMINAL_TERMCODE, termCode);
		return super.findFirstBy(AppConstants.NODER_IP, nodeIp);
	}
	
	/**
	 * 判断节点机日志文件是否已经获取成功过
	 * @param noderFile
	 * @return
	 */
	public String getNoderLogFileStatus(String noderId,String tranData,String fileType)
	{
		
		String hql = "from NoderFile tm where tm.noderId = ? and tm.tranData=? and tm.fileType=?";
		List<NoderFile> noderFiles = this.find(hql, noderId,tranData,fileType);
		if(noderFiles.size()<=0){
			return TermInfoConsts.NODER_FILE_STATUS_INIT;
		}else{
			return noderFiles.get(0).getStatus();
		}
	}
	

	/**
	 * 根据终端编号查找分页的终端数据<br>
	 * 
	 * get 1 page of terminal by terminal code and page information
	 * 
	 * @param page
	 *            页对象
	 * @param termCode
	 *            终端编码
	 * @return Page<NoderInfo>
	 */
	public Page<NoderFile> getByTermCodeFuzzily(Page<NoderFile> page, String termCode) {
		if (termCode == null || termCode.trim().length() == 0)
			return super.findPage(page);
		return super.findPage(page, QUERY_BY_TERMINAL_TERMCODE_FUZZILY, "%" + termCode + "%");
	}

	/**
	 * 根据参数查找分页的终端数据<br>
	 * 
	 * get 1 page of terminal by params and page information
	 * 
	 * @param page
	 *            页对象
	 * @param params
	 *            条件参数
	 * @return Page<NoderInfo>
	 */
	public Page<NoderFile> getNoderFilePageByParams(Page<NoderFile> page, Map<String, Object> params) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(" from NoderFile tm ");
		hql.append(WHERE);
		for (String key : params.keySet()) {
			if(key.equals("endDate") || key.equals("startDate")){
				continue;
			}
			if (params.get(key) == null) {
				continue;
			}
			String paramValue = (String) params.get(key);
			if (key.equals("noderId") && !paramValue.equals("")) {
				hql.append(" tm.noderId =:noderId and ");
				param.put("noderId", paramValue);
			} 
			else if (key.equals("orgCode") && !paramValue.equals("")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" tm.orgCode in (select oi.orgCode from OrgInfo oi where oi.pathCode like :orgPathCode) and") ;
				param.put("orgPathCode", pathCode + "%");
			} 
			else if (key.equals("orgId") && !paramValue.equals("")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" tm.orgCode in (select oi.orgCode from OrgInfo oi where oi.pathCode like :orgPathCode) and") ;
				param.put("orgPathCode", pathCode + "%");
			} 
			else if (key.equals("fileType") && !paramValue.equals("")) {
				hql.append(" tm.fileType =:fileType and ") ;
				param.put("fileType", paramValue);
			} 
			else if (key.equals("status") && !paramValue.equals("") && paramValue!=null) {
				hql.append(" tm.status =:status and ");
				param.put("status", paramValue);
			}
		}
		
		if(DBDialectHelper.isOracle()){
			hql.append(" to_char(tm.operDate,'yyyyMMdd') >=:startDate and ");
			hql.append(" to_char(tm.operDate,'yyyyMMdd') <=:endDate and ");
		}
		else if(DBDialectHelper.isMySql()){
			hql.append(" DATE_FORMAT(tm.operDate,'%Y%m%d') >=:startDate and ");
			hql.append(" DATE_FORMAT(tm.operDate,'%Y%m%d') <=:endDate and ");
		}
		else{
			hql.append(" DATE_FORMAT(tm.operDate,'%Y%m%d') >=:startDate and ");
			hql.append(" DATE_FORMAT(tm.operDate,'%Y%m%d') <=:endDate and ");
		}
		
		param.put("startDate", new SimpleDateFormat("yyyyMMdd").format((Date) params.get("startDate")));
		param.put("endDate", new SimpleDateFormat("yyyyMMdd").format((Date) params.get("endDate")));
		
		
		if (hql.toString().endsWith(WHERE)) {
			hql.delete(hql.length() - WHERE.length(), hql.length());
		} else {
			hql.delete(hql.length() - 4, hql.length());
		}

//		hql.append(" order by tm.termCode asc ");
		return super.findPage(page, hql.toString(), param);
	}
	
	public List<NoderFile> getNoderFileListByParams(Map<String, Object> params) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(" from NoderFile tm ");
		hql.append(WHERE);
		for (String key : params.keySet()) {
			if(key.equals("endDate") || key.equals("startDate")){
				continue;
			}
			if (params.get(key) == null) {
				continue;
			}
			String paramValue = (String) params.get(key);
			if (key.equals("noderId") && !paramValue.equals("")) {
				hql.append(" tm.noderId =:noderId and ");
				param.put("noderId", paramValue);
			} 
//			else if (key.equals("orgCode") && !paramValue.equals("")) {
//				String pathCode = orgDao.getPathCodeById(paramValue);
//				hql.append(" tm.orgCode in (select oi.orgCode from OrgInfo oi where oi.pathCode like :orgPathCode) and") ;
//				param.put("orgPathCode", pathCode + "%");
//			} 
			else if (key.equals("orgId") && !paramValue.equals("")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" tm.orgCode in (select oi.orgCode from OrgInfo oi where oi.pathCode like :orgPathCode) and") ;
				param.put("orgPathCode", pathCode + "%");
			} 
			else if (key.equals("fileType") && !paramValue.equals("")) {
				hql.append(" tm.fileType =:fileType and ") ;
				param.put("fileType", paramValue);
			} 
			else if (key.equals("status") && !paramValue.equals("") && paramValue!=null) {
				hql.append(" tm.status =:status and ");
				param.put("status", paramValue);
			}
			else if (key.equals("tranData") && !paramValue.equals("") && paramValue!=null) {
				hql.append(" tm.tranData =:tranData and ");
				param.put("tranData", paramValue);
			}
		}
		
		if(param.containsKey("startDate")&&param.containsKey("endDate")){
			if(DBDialectHelper.isOracle()){
				hql.append(" to_char(tm.operDate,'yyyyMMdd') >=:startDate and ");
				hql.append(" to_char(tm.operDate,'yyyyMMdd') <=:endDate and ");
			}
			else if(DBDialectHelper.isMySql()){
				hql.append(" DATE_FORMAT(tm.operDate,'%Y%m%d') >=:startDate and ");
				hql.append(" DATE_FORMAT(tm.operDate,'%Y%m%d') <=:endDate and ");
			}
			else{
				hql.append(" DATE_FORMAT(tm.operDate,'%Y%m%d') >=:startDate and ");
				hql.append(" DATE_FORMAT(tm.operDate,'%Y%m%d') <=:endDate and ");
			}
			
			param.put("startDate", new SimpleDateFormat("yyyyMMdd").format((Date) params.get("startDate")));
			param.put("endDate", new SimpleDateFormat("yyyyMMdd").format((Date) params.get("endDate")));
		}
		
		if (hql.toString().endsWith(WHERE)) {
			hql.delete(hql.length() - WHERE.length(), hql.length());
		} else {
			hql.delete(hql.length() - 4, hql.length());
		}

//		hql.append(" order by tm.termCode asc ");
		return super.findPage(hql.toString(), param);
	}

}






