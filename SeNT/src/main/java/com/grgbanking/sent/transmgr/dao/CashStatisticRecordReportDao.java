package com.grgbanking.sent.transmgr.dao;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.platform.module.term.entity.TermInfo;
import com.grgbanking.sent.transmgr.entity.CashStatisticRecordReportVO;

@Repository
public class CashStatisticRecordReportDao extends BaseDao<Object> {
	
	@Autowired
	TermInfoDao terminalInfoDao;
	
	
	private static CashStatisticRecordReportVO CashHundredVO = new CashStatisticRecordReportVO();
	private static CashStatisticRecordReportVO CashFiftyVO = new CashStatisticRecordReportVO();
	private static CashStatisticRecordReportVO CashTewentyVO = new CashStatisticRecordReportVO();
	private static CashStatisticRecordReportVO CashTenVO = new CashStatisticRecordReportVO();
	private static CashStatisticRecordReportVO CashFiveVO = new CashStatisticRecordReportVO();
	private static CashStatisticRecordReportVO CashOneVO = new CashStatisticRecordReportVO();
	private static CashStatisticRecordReportVO CashStatisticVO = new CashStatisticRecordReportVO();
	/**
	 * 获取网点流转情况统计分页
	 * @param parameter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Map<String,Object> getCashStatisticRecordReport(Map<String, Object> parameter)
	{		
		logger.info("CashStatisticRecordReportDao.getCmlNoteflowSituationReportPage()");
		String endTimeStr = "";
		String beginTimeStr = "";
		int seasonType = 0;
		Map<String, Object> condition = (Map<String, Object>)parameter.get("condition");
		
		String season =(String)condition.get("seasonType");
		if (null!=season) {
			seasonType = Integer.parseInt(season);
		}
		else{
			throw new IllegalArgumentException("选择季度不能为空");
		}
		String pathCode        = (String)condition.get("pathCode");
		String flag=(String)condition.get("flag");
		//获取本年度，手工清分表查询需要用
		Calendar c=Calendar.getInstance(); 
		c.setTime(new Date());   
     	int year = c.get(c.YEAR);
     	String yearStr = String.valueOf(year);
//		if(null==seasonType )
//		{
//			throw new IllegalArgumentException("时间不能为空");
//		}
//		else
//		{
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			try {
//				todayTime = sdf.parse(todayString);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//		c.setTime(todayTime);   
//		int month=c.get(c.MONTH)+1;  
//     	int year = c.get(c.YEAR);
//		String yearStr = String.valueOf(year);
		
//		if(StringUtils.isBlank(beginTimeString) )
//		{
//			throw new IllegalArgumentException("清分开始时间不能为空");
//		}
//		else {
//			beginTimeString = beginTimeString.replace("-", "") ;
//		}		
		switch (seasonType) {
		case 1:
			beginTimeStr = "0101";
			endTimeStr = "0331";
			break;
		case 2:
			beginTimeStr = "0401";
			endTimeStr = "0630";
			break;
		case 3:
			beginTimeStr = "0701";
			endTimeStr = "0930";
			break;
		case 4:
			beginTimeStr = "1001";
			endTimeStr = "1231";
			break;

		default:
			break;
		}
		//机械清分
		/**
		 * 季度查询
		 */
		StringBuffer quartersb = new StringBuffer("select t.C_DENOMINATION,t.C_TERM_CODE,t.I_TRAN_TRUECOUNT*t.C_DENOMINATION,t.I_TRAN_SUSPECCOUNT*t.C_DENOMINATION,t.I_TRAN_OLDCOUNT*t.C_DENOMINATION");
		quartersb.append(" from cml_statistic_record t where ");
		quartersb.append("t.C_PART_MONTHDAY>=? and t.C_PART_MONTHDAY<=? ");
		if(null == flag || flag.equals("true")){
			quartersb.append("and t.c_pathcode like ? ");
		}else{
			quartersb.append("and t.c_pathcode = ? ");
		}

		SQLQuery quartersql = this.getSession().createSQLQuery(quartersb.toString());
		quartersql.setString(0, beginTimeStr);
		quartersql.setString(1, endTimeStr);
		if(null == flag || flag.equals("true")){
			quartersql.setString(2, pathCode+"%");
		}else{
			quartersql.setString(2, pathCode+"");
		}

		List<Object[]> quarterlist = quartersql.list();
	    CashStatisticRecordReportByResultList(quarterlist,0);
		/**
		 * 年度查询
		 */
		StringBuffer annualSb = new StringBuffer("select t.C_DENOMINATION,t.C_TERM_CODE,t.I_TRAN_TRUECOUNT*t.C_DENOMINATION,t.I_TRAN_SUSPECCOUNT*t.C_DENOMINATION,t.I_TRAN_OLDCOUNT*t.C_DENOMINATION");
		annualSb.append(" from cml_statistic_record t where ");
		annualSb.append("t.C_PART_MONTHDAY>=? and t.C_PART_MONTHDAY<=? ");
		if(null == flag || flag.equals("true")){
			annualSb.append("and t.c_pathcode like ? ");
		}else{
			annualSb.append("and t.c_pathcode = ? ");
		}

		SQLQuery annualSql = this.getSession().createSQLQuery(annualSb.toString());
		annualSql.setString(0, "0101");
		annualSql.setString(1, "1231");
		if(null == flag || flag.equals("true")){
			annualSql.setString(2, pathCode+"%");
		}else{
			annualSql.setString(2, pathCode+"");
		}

		List<Object[]> annualList = annualSql.list();
	    CashStatisticRecordReportByResultList(annualList,1);
	    
	    //手工清分季度
	    StringBuffer byhandsb = new StringBuffer("select sum(t.I_HUNDRED_COUNT)*100 hundredCount,sum(t.I_FIFTY_COUNT)*50 fiftyCount" +
	    		",sum(t.I_TWENTY_COUNT)*20 twentyCount,sum(t.I_TEN_COUNT)*10 tenCount,sum(t.I_FIVE_COUNT)*5 fiveCount,sum(t.I_ONE_COUNT)*1 oneCount");
	    byhandsb.append(" from cml_info_byhand t where ");
	    byhandsb.append("t.C_TRAN_TIME>=? and t.C_TRAN_TIME<=? ");
	    if(null == flag || flag.equals("true")){
		    byhandsb.append("and t.c_pathcode like ?  group by 't.c_pathcode%'");
	    }else{
		    byhandsb.append("and t.c_pathcode = ?  group by 't.c_pathcode%'");
	    }

		SQLQuery byhandsql = this.getSession().createSQLQuery(byhandsb.toString());
		byhandsql.setString(0, yearStr+beginTimeStr+"000000");
		byhandsql.setString(1, yearStr+endTimeStr+"240000");
		if(null == flag || flag.equals("true")){
			byhandsql.setString(2, pathCode+"%");
		}else{
			byhandsql.setString(2, pathCode+"");
		}

		List<Object[]> byhandlist = byhandsql.list();
		CashStatisticRecordReportByhandList(byhandlist,0);
		
	    //手工清分年度
	    StringBuffer byhandAnnualsb = new StringBuffer("select sum(t.I_HUNDRED_COUNT)*100 hundredCount,sum(t.I_FIFTY_COUNT)*50 fiftyCount" +
	    		",sum(t.I_TWENTY_COUNT)*20 twentyCount,sum(t.I_TEN_COUNT)*10 tenCount,sum(t.I_FIVE_COUNT)*5 fiveCount,sum(t.I_ONE_COUNT)*1 oneCount");
	    byhandAnnualsb.append(" from cml_info_byhand t where ");
	    byhandAnnualsb.append("t.C_TRAN_TIME>=? and t.C_TRAN_TIME<=? ");
	    if(null == flag || flag.equals("true")){
		    byhandAnnualsb.append("and t.c_pathcode like ? group by 't.c_pathcode%'");
	    }else{
		    byhandAnnualsb.append("and t.c_pathcode = ? group by 't.c_pathcode%'");
	    }

		SQLQuery byhandAnnualsql = this.getSession().createSQLQuery(byhandAnnualsb.toString());
		byhandAnnualsql.setString(0, yearStr+"0101000000");
		byhandAnnualsql.setString(1, yearStr+"1231240000");
		if(null == flag || flag.equals("true")){
			byhandAnnualsql.setString(2, pathCode+"%");
		}else{
			byhandAnnualsql.setString(2, pathCode+"");
		}

		List<Object[]> byhandAnnuallist = byhandAnnualsql.list();		
		CashStatisticRecordReportByhandList(byhandAnnuallist,1);
		
		//机械清分月度小结
		CashHundredVO.setClearingQuarter(new BigDecimal(CashHundredVO.getCollectQuarter())
		.add(new BigDecimal(CashHundredVO.getBranchQuarter())).toString());
		CashFiftyVO.setClearingQuarter(new BigDecimal(CashFiftyVO.getCollectQuarter())
		.add(new BigDecimal(CashFiftyVO.getBranchQuarter())).toString());
		CashTewentyVO.setClearingQuarter(new BigDecimal(CashTewentyVO.getCollectQuarter())
		.add(new BigDecimal(CashTewentyVO.getBranchQuarter())).toString());
		CashTenVO.setClearingQuarter(new BigDecimal(CashTenVO.getCollectQuarter())
		.add(new BigDecimal(CashTenVO.getBranchQuarter())).toString());
		CashFiveVO.setClearingQuarter(new BigDecimal(CashFiveVO.getCollectQuarter())
		.add(new BigDecimal(CashFiveVO.getBranchQuarter())).toString());
		CashOneVO.setClearingQuarter(new BigDecimal(CashOneVO.getCollectQuarter())
		.add(new BigDecimal(CashOneVO.getBranchQuarter())).toString());
		CashStatisticVO.setClearingQuarter(new BigDecimal(CashStatisticVO.getCollectQuarter())
		.add(new BigDecimal(CashStatisticVO.getBranchQuarter())).toString());
		
		//机械清分年度小结
		CashHundredVO.setClearingAnnual(new BigDecimal(CashHundredVO.getCollectAnnual())
		.add(new BigDecimal(CashHundredVO.getBranchAnnual())).toString());
		CashFiftyVO.setClearingAnnual(new BigDecimal(CashFiftyVO.getCollectAnnual())
		.add(new BigDecimal(CashFiftyVO.getBranchAnnual())).toString());
		CashTewentyVO.setClearingAnnual(new BigDecimal(CashTewentyVO.getCollectAnnual())
		.add(new BigDecimal(CashTewentyVO.getBranchAnnual())).toString());
		CashTenVO.setClearingAnnual(new BigDecimal(CashTenVO.getCollectAnnual())
		.add(new BigDecimal(CashTenVO.getBranchAnnual())).toString());
		CashFiveVO.setClearingAnnual(new BigDecimal(CashFiveVO.getCollectAnnual())
		.add(new BigDecimal(CashFiveVO.getBranchAnnual())).toString());
		CashOneVO.setClearingAnnual(new BigDecimal(CashOneVO.getCollectAnnual())
		.add(new BigDecimal(CashOneVO.getBranchAnnual())).toString());
		CashStatisticVO.setClearingAnnual(new BigDecimal(CashStatisticVO.getCollectAnnual())
		.add(new BigDecimal(CashStatisticVO.getBranchAnnual())).toString());
		
		//总清分月度小结
		CashHundredVO.setAllQuarter(new BigDecimal(CashHundredVO.getClearingQuarter())
		.add(new BigDecimal(CashHundredVO.getByHandQuarter())).toString());
		CashFiftyVO.setAllQuarter(new BigDecimal(CashFiftyVO.getClearingQuarter())
		.add(new BigDecimal(CashFiftyVO.getByHandQuarter())).toString());
		CashTewentyVO.setAllQuarter(new BigDecimal(CashTewentyVO.getClearingQuarter())
		.add(new BigDecimal(CashTewentyVO.getByHandQuarter())).toString());
		CashTenVO.setAllQuarter(new BigDecimal(CashTenVO.getClearingQuarter())
		.add(new BigDecimal(CashTenVO.getByHandQuarter())).toString());
		CashFiveVO.setAllQuarter(new BigDecimal(CashFiveVO.getClearingQuarter())
		.add(new BigDecimal(CashFiveVO.getByHandQuarter())).toString());
		CashOneVO.setAllQuarter(new BigDecimal(CashOneVO.getClearingQuarter())
		.add(new BigDecimal(CashOneVO.getByHandQuarter())).toString());
		CashStatisticVO.setAllQuarter(new BigDecimal(CashStatisticVO.getClearingQuarter())
		.add(new BigDecimal(CashStatisticVO.getByHandQuarter())).toString());
		
		
		//总清分年度小结
		CashHundredVO.setAllAnnual(new BigDecimal(CashHundredVO.getClearingAnnual())
		.add(new BigDecimal(CashHundredVO.getByHandAnnual())).toString());
		CashFiftyVO.setAllAnnual(new BigDecimal(CashFiftyVO.getClearingAnnual())
		.add(new BigDecimal(CashFiftyVO.getByHandAnnual())).toString());
		CashTewentyVO.setAllAnnual(new BigDecimal(CashTewentyVO.getClearingAnnual())
		.add(new BigDecimal(CashTewentyVO.getByHandAnnual())).toString());
		CashTenVO.setAllAnnual(new BigDecimal(CashTenVO.getClearingAnnual())
		.add(new BigDecimal(CashTenVO.getByHandAnnual())).toString());
		CashFiveVO.setAllAnnual(new BigDecimal(CashFiveVO.getClearingAnnual())
		.add(new BigDecimal(CashFiveVO.getByHandAnnual())).toString());
		CashOneVO.setAllAnnual(new BigDecimal(CashOneVO.getClearingAnnual())
		.add(new BigDecimal(CashOneVO.getByHandAnnual())).toString());
		CashStatisticVO.setAllAnnual(new BigDecimal(CashStatisticVO.getClearingAnnual())
		.add(new BigDecimal(CashStatisticVO.getByHandAnnual())).toString());
		
	    
		List<CashStatisticRecordReportVO> resultList = new ArrayList<CashStatisticRecordReportVO>();
		CashHundredVO.setDenomination("100元");
		CashHundredVO.setCollectPercent(new BigDecimal(CashHundredVO.getCollectAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashHundredVO.getCollectQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashHundredVO.getCollectAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashHundredVO.setBranchPercent(new BigDecimal(CashHundredVO.getBranchAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashHundredVO.getBranchQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashHundredVO.getBranchAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashHundredVO.setByHandPercent(new BigDecimal(CashHundredVO.getByHandAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashHundredVO.getByHandQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashHundredVO.getByHandAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashHundredVO.setClearingPercent(new BigDecimal(CashHundredVO.getClearingAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashHundredVO.getClearingQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashHundredVO.getClearingAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		
		CashFiftyVO.setDenomination("50元");
		CashFiftyVO.setCollectPercent(new BigDecimal(CashFiftyVO.getCollectAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashFiftyVO.getCollectQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashFiftyVO.getCollectAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashFiftyVO.setBranchPercent(new BigDecimal(CashFiftyVO.getBranchAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashFiftyVO.getBranchQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashFiftyVO.getBranchAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashFiftyVO.setByHandPercent(new BigDecimal(CashFiftyVO.getByHandAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashFiftyVO.getByHandQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashFiftyVO.getByHandAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashFiftyVO.setClearingPercent(new BigDecimal(CashFiftyVO.getClearingAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashFiftyVO.getClearingQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashFiftyVO.getClearingAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		
		CashTewentyVO.setDenomination("20元");
		CashTewentyVO.setCollectPercent(new BigDecimal(CashTewentyVO.getCollectAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashTewentyVO.getCollectQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashTewentyVO.getCollectAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashTewentyVO.setBranchPercent(new BigDecimal(CashTewentyVO.getBranchAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashTewentyVO.getBranchQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashTewentyVO.getBranchAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashTewentyVO.setByHandPercent(new BigDecimal(CashTewentyVO.getByHandAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashTewentyVO.getByHandQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashTewentyVO.getByHandAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashTewentyVO.setClearingPercent(new BigDecimal(CashTewentyVO.getClearingAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashTewentyVO.getClearingQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashTewentyVO.getClearingAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		
		CashTenVO.setDenomination("10元");
		CashTenVO.setCollectPercent(new BigDecimal(CashTenVO.getCollectAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashTenVO.getCollectQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashTenVO.getCollectAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashTenVO.setBranchPercent(new BigDecimal(CashTenVO.getBranchAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashTenVO.getBranchQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashTenVO.getBranchAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashTenVO.setByHandPercent(new BigDecimal(CashTenVO.getByHandAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashTenVO.getByHandQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashTenVO.getByHandAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashTenVO.setClearingPercent(new BigDecimal(CashTenVO.getClearingAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashTenVO.getClearingQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashTenVO.getClearingAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		
		CashFiveVO.setDenomination("5元");
		CashFiveVO.setCollectPercent(new BigDecimal(CashFiveVO.getCollectAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashFiveVO.getCollectQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashFiveVO.getCollectAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashFiveVO.setBranchPercent(new BigDecimal(CashFiveVO.getBranchAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashFiveVO.getBranchQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashFiveVO.getBranchAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashFiveVO.setByHandPercent(new BigDecimal(CashFiveVO.getByHandAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashFiveVO.getByHandQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashFiveVO.getByHandAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashFiveVO.setClearingPercent(new BigDecimal(CashFiveVO.getClearingAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashFiveVO.getClearingQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashFiveVO.getClearingAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		
		CashOneVO.setDenomination("1元");
		CashOneVO.setCollectPercent(new BigDecimal(CashOneVO.getCollectAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashOneVO.getCollectQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashOneVO.getCollectAnnual()), 1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashOneVO.setBranchPercent(new BigDecimal(CashOneVO.getBranchAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashOneVO.getBranchQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashOneVO.getBranchAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashOneVO.setByHandPercent(new BigDecimal(CashOneVO.getByHandAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashOneVO.getByHandQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashOneVO.getByHandAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashOneVO.setClearingPercent(new BigDecimal(CashOneVO.getClearingAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashOneVO.getClearingQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashOneVO.getClearingAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		
		CashStatisticVO.setDenomination("合计");
		CashStatisticVO.setCollectPercent(new BigDecimal(CashStatisticVO.getCollectAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashStatisticVO.getCollectQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashStatisticVO.getCollectAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashStatisticVO.setBranchPercent(new BigDecimal(CashStatisticVO.getBranchAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashStatisticVO.getBranchQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashStatisticVO.getBranchAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashStatisticVO.setByHandPercent(new BigDecimal(CashStatisticVO.getByHandAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashStatisticVO.getByHandQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashStatisticVO.getByHandAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		CashStatisticVO.setClearingPercent(new BigDecimal(CashStatisticVO.getClearingAnnual()).equals(BigDecimal.ZERO)?"0.0":new BigDecimal(CashStatisticVO.getClearingQuarter()).multiply(new BigDecimal("100")).divide(
				new BigDecimal(CashStatisticVO.getClearingAnnual()), 
				1,BigDecimal.ROUND_HALF_DOWN).toString());
		
		
		resultList.add(CashHundredVO);
		resultList.add(CashFiftyVO);
		resultList.add(CashTewentyVO);
		resultList.add(CashTenVO);
		resultList.add(CashFiveVO);
		resultList.add(CashOneVO);
		resultList.add(CashStatisticVO);
	    
			
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("gridResult", resultList);	
		return result;
	}
/**
 * 根据机械查询结果统计查询信息
 * @param list
 * @return
 */
	protected void CashStatisticRecordReportByResultList(List<Object[]> list,int queryType)
	{
		//集中清分
		BigDecimal collectHundredCount = new BigDecimal(0);
		BigDecimal collectFiftyCount = new BigDecimal(0);
		BigDecimal collectTewentyCount = new BigDecimal(0);
		BigDecimal collectTenCount = new BigDecimal(0);
		BigDecimal collectFiveCount = new BigDecimal(0);
		BigDecimal collectOneCount = new BigDecimal(0);
		BigDecimal collectCount = new BigDecimal(0);
		//网点或手工清分
		BigDecimal branchHundredCount = new BigDecimal(0);
		BigDecimal branchFiftyCount = new BigDecimal(0);
		BigDecimal branchTewentyCount = new BigDecimal(0);
		BigDecimal branchTenCount = new BigDecimal(0);
		BigDecimal branchFiveCount = new BigDecimal(0);
		BigDecimal branchOneCount = new BigDecimal(0);
		BigDecimal branchCount = new BigDecimal(0);//季度统计
		

		
		for( Object[] objs : list )
		{
			String termCode = (String)objs[1];
			int denomination = 0;
			BigDecimal tranTrueCount = new BigDecimal(0);
			BigDecimal tranSuspecCount = new BigDecimal(0);
			BigDecimal tranOldCount = new BigDecimal(0);
			if (!StringUtils.isBlank((String)objs[0])){
				denomination = Integer.parseInt((String)objs[0]);
			}
				tranTrueCount = new BigDecimal(objs[2].toString());
				tranSuspecCount = new BigDecimal(objs[3].toString());
				tranOldCount = new BigDecimal(objs[4].toString());
			
			
			BigDecimal tranCount = tranTrueCount.add(tranSuspecCount).add(tranOldCount);
			TermInfo termInfo = terminalInfoDao.getByTermCode(termCode);
			String machineType ="";
			if (null!=termInfo) {
				machineType = termInfo.getMachineType();
			}
			
			if (StringUtils.isBlank(machineType)==false&&"0".equals(machineType)) {
				switch (denomination) {
				case 100:
					collectHundredCount=collectHundredCount.add(tranCount);
					break;
				case 50:
					collectFiftyCount=collectFiftyCount.add(tranCount);
					break;
				case 20:
					collectTewentyCount=collectTewentyCount.add(tranCount);
					break;
				case 10:
					collectTenCount=collectTenCount.add(tranCount);
					break;
				case 5:
					collectFiveCount=collectFiveCount.add(tranCount);
					break;
				case 1:
					collectOneCount=collectOneCount.add(tranCount);
					break;

				default:
					break;
				}
			}
			else {
				
				switch (denomination) {
				case 100:
					branchHundredCount=branchHundredCount.add(tranCount);
					break;
				case 50:
					branchFiftyCount=branchFiftyCount.add(tranCount);
					break;
				case 20:
					branchTewentyCount=branchTewentyCount.add(tranCount);
					break;
				case 10:
					branchTenCount=branchTenCount.add(tranCount);
					break;
				case 5:
					branchFiveCount=branchFiveCount.add(tranCount);
					break;
				case 1:
					branchOneCount=branchOneCount.add(tranCount);
					break;

				default:
					break;
				}
				
			}
		}
		collectCount = collectHundredCount.add(collectFiftyCount).add(collectTewentyCount).add(collectTenCount).add(collectFiveCount).add(collectOneCount);
		branchCount = branchHundredCount.add(branchFiftyCount).add(branchTewentyCount).add(branchTenCount).add(branchFiveCount).add(branchOneCount);
		    if (queryType==0) {
//				cashStatisticRecordReport.setQuarterHundredCount(hundredCount.toString());
//				cashStatisticRecordReport.setQuarterFiftyCount(fiftyCount.toString());
//				cashStatisticRecordReport.setQuarterTewentyCount(tewentyCount.toString());
//				cashStatisticRecordReport.setQuarterTenCount(tenCount.toString());
//				cashStatisticRecordReport.setQuarterFiveCount(fiveCount.toString());
//				cashStatisticRecordReport.setQuarterOneCount(oneCount.toString());
//				cashStatisticRecordReport.setQuarterCount(count.toString());
				CashHundredVO.setCollectQuarter(collectHundredCount.toString());
				CashHundredVO.setBranchQuarter(branchHundredCount.toString());
				CashFiftyVO.setCollectQuarter(collectFiftyCount.toString());
				CashFiftyVO.setBranchQuarter(branchFiftyCount.toString());
				CashTewentyVO.setCollectQuarter(collectTewentyCount.toString());
				CashTewentyVO.setBranchQuarter(branchTewentyCount.toString());
				CashTenVO.setCollectQuarter(collectTenCount.toString());
				CashTenVO.setBranchQuarter(branchTenCount.toString());
				CashFiveVO.setCollectQuarter(collectFiveCount.toString());
				CashFiveVO.setBranchQuarter(branchFiveCount.toString());
				CashOneVO.setCollectQuarter(collectOneCount.toString());
				CashOneVO.setBranchQuarter(branchOneCount.toString());
				CashStatisticVO.setCollectQuarter(collectCount.toString());
				CashStatisticVO.setBranchQuarter(branchCount.toString());
		    }else{
				CashHundredVO.setCollectAnnual(collectHundredCount.toString());
				CashHundredVO.setBranchAnnual(branchHundredCount.toString());
				CashFiftyVO.setCollectAnnual(collectFiftyCount.toString());
				CashFiftyVO.setBranchAnnual(branchFiftyCount.toString());
				CashTewentyVO.setCollectAnnual(collectTewentyCount.toString());
				CashTewentyVO.setBranchAnnual(branchTewentyCount.toString());
				CashTenVO.setCollectAnnual(collectTenCount.toString());
				CashTenVO.setBranchAnnual(branchTenCount.toString());
				CashFiveVO.setCollectAnnual(collectFiveCount.toString());
				CashFiveVO.setBranchAnnual(branchFiveCount.toString());
				CashOneVO.setCollectAnnual(collectOneCount.toString());
				CashOneVO.setBranchAnnual(branchOneCount.toString());
				CashStatisticVO.setCollectAnnual(collectCount.toString());
				CashStatisticVO.setBranchAnnual(branchCount.toString());
		    }
		
	}
/**
 * 
 */
	protected void CashStatisticRecordReportByhandList(List<Object[]> list,int queryType){
		
			BigDecimal hundredCount = new BigDecimal(0); 
			BigDecimal fiftyCount = new BigDecimal(0); 
			BigDecimal twentyCount = new BigDecimal(0); 
			BigDecimal tenCount = new BigDecimal(0); 
			BigDecimal fiveCount = new BigDecimal(0); 
			BigDecimal oneCount = new BigDecimal(0); 
			BigDecimal count = new BigDecimal(0); 
			
			if(list.size()!=0){
		     Object[] objs = list.get(0);
		     hundredCount = (BigDecimal) objs[0];
		     fiftyCount = (BigDecimal) objs[1];
		     twentyCount = (BigDecimal) objs[2];
		     tenCount = (BigDecimal) objs[3];
		     fiveCount = (BigDecimal) objs[4];
		     oneCount = (BigDecimal) objs[5];
			}
			count = hundredCount.add(fiftyCount).add(twentyCount).add(tenCount).add(fiveCount).add(oneCount);
		   if (queryType==0) {
				CashHundredVO.setByHandQuarter(hundredCount.toString());
				CashFiftyVO.setByHandQuarter(fiftyCount.toString());
				CashTewentyVO.setByHandQuarter(twentyCount.toString());
				CashTenVO.setByHandQuarter(tenCount.toString());
				CashFiveVO.setByHandQuarter(fiveCount.toString());
				CashOneVO.setByHandQuarter(oneCount.toString());
				CashStatisticVO.setByHandQuarter(count.toString());
		    }else{
		    	CashHundredVO.setByHandAnnual(hundredCount.toString());
				CashFiftyVO.setByHandAnnual(fiftyCount.toString());
				CashTewentyVO.setByHandAnnual(twentyCount.toString());
				CashTenVO.setByHandAnnual(tenCount.toString());
				CashFiveVO.setByHandAnnual(fiveCount.toString());
				CashOneVO.setByHandAnnual(oneCount.toString());
				CashStatisticVO.setByHandAnnual(count.toString());
		    }
		
		
	}
	
}
