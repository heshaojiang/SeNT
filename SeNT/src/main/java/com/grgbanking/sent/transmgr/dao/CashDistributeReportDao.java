/**
 * 文件名：CashDistributeReportDao.java
 * 创建日期： 2014-09-30
 * Copyright (c)  广电运通
 * All rights reserved.
 */
package com.grgbanking.sent.transmgr.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.sent.transmgr.entity.CmlStatisticRecord;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 现金清分统计报表DAO
 * 
 * @author zzhui1
 * 
 */
@Repository
public class CashDistributeReportDao extends BaseDao<CmlStatisticRecord>
{
	/**
	 * 查询各个银行经过清分机清分的交易金额
	 * @param pPathCode 机构ID
	 * @param pBeginTime 查询开始时间
	 * @param pEndTime 查询结束时间
	 * @return 交易金额List数据
	 */
	public List getCashDistrubuteAmount(String pPathCode, String pBeginTime, String pEndTime){
		List<String> parameterList = new ArrayList<String>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append(" CSR.C_DENOMINATION  ");
		sql.append(",SUM( CSR.I_TRAN_TRUECOUNT * CSR.C_DENOMINATION )  ");
		sql.append(",SUM(( CSR.I_TRAN_SUSPECCOUNT + CSR.I_TRAN_OLDCOUNT) * CSR.C_DENOMINATION )  ");
		sql.append("FROM ");
		sql.append("CML_STATISTIC_RECORD CSR ");
		sql.append("INNER JOIN TML_INFO TML ON CSR.C_TERM_CODE = TML.C_TERMCODE ");
		sql.append("WHERE ");
		sql.append("CSR.C_CURRENCY =  'CNY' ");
		sql.append("AND TML.C_MACHINE_TYPE =  '0' ");
		if (StringUtil.isNotBlank(pPathCode)) {
			parameterList.add(pPathCode);
			sql.append("AND CSR.C_PATHCODE = ? ");
		}
		// 开始时间
		if (StringUtil.isNotBlank(pBeginTime)) {			
			parameterList.add(pBeginTime);
			sql.append("AND CSR.C_TRAN_TIME >=  ? ");
		}
		// 结束时间
		if (StringUtil.isNotBlank(pEndTime)) {
			parameterList.add(pEndTime);
			sql.append("AND CSR.C_TRAN_TIME <=  ? ");
		}
		sql.append("GROUP BY ");
		sql.append("CSR.C_DENOMINATION");
		
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sql.toString());
		if (StringUtil.isNotBlank(pPathCode)) {
			sqlQuery.setString(0, pPathCode);
		}
		if (StringUtil.isNotBlank(pBeginTime)) {
			sqlQuery.setString(1, pBeginTime);
		}
		if (StringUtil.isNotBlank(pEndTime)) {
			sqlQuery.setString(2, pEndTime);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		List<Object[]> list = sqlQuery.list();
		return list;
	}
	
	/**
	 * 查询各个银行机构所有交易类型的金额
	 * @param pPathCode 机构ID
	 * @param pBeginTime 查询开始时间
	 * @param pEndTime 查询结束时间
	 * @return 交易金额List数据
	 */
	public List getCashAmountSummary(String pPathCode,String flag, String pBeginTime, String pEndTime){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("SUM(CSR.I_TRAN_TRUECOUNT * CSR.C_DENOMINATION) AS SUM1 ");
		sql.append(",SUM( (CSR.I_TRAN_SUSPECCOUNT + CSR.I_TRAN_OLDCOUNT ) * CSR.C_DENOMINATION ) AS SUM2 ");
		sql.append(",CSR.C_PATHCODE  ");
		//sql.append(",ORG.C_ORGNAME  ");
		sql.append("FROM ");
		sql.append("CML_STATISTIC_RECORD CSR ");
		sql.append("INNER JOIN ORG_INFO ORG ON CSR.C_PATHCODE = ORG.C_PATHCODE ");
		sql.append("WHERE CSR.C_CURRENCY =  'CNY' ");
		List<String> parameterList = new ArrayList<String>();
		if (StringUtil.isNotBlank(pPathCode)) {
			if(null == flag || flag.equals("true")){
				parameterList.add(pPathCode);
				sql.append("AND CSR.C_PATHCODE LIKE ? ");
			}else{
				parameterList.add(pPathCode);
				sql.append("AND CSR.C_PATHCODE = ? ");
			}
		}
		// 开始时间
		if (StringUtil.isNotBlank(pBeginTime)) {			
			parameterList.add(pBeginTime);
			sql.append("AND CSR.C_TRAN_TIME >=  ? ");
		}
		// 结束时间
		if (StringUtil.isNotBlank(pEndTime)) {
			parameterList.add(pEndTime);
			sql.append("AND CSR.C_TRAN_TIME <=  ? ");
		}
		sql.append("GROUP BY ");
		sql.append("CSR.C_PATHCODE");
		
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sql.toString());
		if (StringUtil.isNotBlank(pPathCode)) {
			if(null == flag || flag.equals("true")){
				sqlQuery.setString(0, pPathCode + "%");
			}else{
				sqlQuery.setString(0, pPathCode + "");
			}
		}
		if (StringUtil.isNotBlank(pBeginTime)) {
			sqlQuery.setString(1, pBeginTime);
		}
		if (StringUtil.isNotBlank(pEndTime)) {
			sqlQuery.setString(2, pEndTime);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		List<Object[]> list = sqlQuery.list();
		return list;
	}
}