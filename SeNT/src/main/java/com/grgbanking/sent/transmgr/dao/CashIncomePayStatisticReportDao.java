package com.grgbanking.sent.transmgr.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.sent.transmgr.entity.CashIncomePayStatisticReportVO;

import freemarker.template.SimpleDate;
@Repository
public class CashIncomePayStatisticReportDao extends BaseDao<Object>{
	
	@Autowired
	OrgInfoDao orgInfoDao; 
	
	private static CashIncomePayStatisticReportVO  cashIncomePayVO = new CashIncomePayStatisticReportVO() ;
	
	public Map<String,Object> getCashIncomePayStatisticReport(Map<String, Object> parameter){
		
		logger.info("CashIncomePayStatisticReportDao.getCashIncomePayStatisticReport()");
		
		Map<String, Object> condition = (Map<String, Object>)parameter.get("condition");
		
		String beginTimeString = (String)condition.get("startTime");
		String endTimeString   = (String)condition.get("endTime");
		String pathCode        = (String)condition.get("pathCode");
		String flag=(String)condition.get("flag");
//		String startMonthDay = "";
//		String endMonthDay = "";
		if(StringUtils.isBlank(beginTimeString) )
		{
			throw new IllegalArgumentException("查询开始时间不能为空");
		}
		else {
			beginTimeString = beginTimeString.replace("-", "") ;
			beginTimeString =beginTimeString.substring(0, 8);
//			startMonthDay = beginTimeString.substring(4, 8);
		}		
		
		if(StringUtils.isBlank(endTimeString) )
		{
			throw new IllegalArgumentException("查询结束时间不能为空");
		} else {
			endTimeString = endTimeString.replace("-", "");
			endTimeString =endTimeString.substring(0, 8);
//			endMonthDay = endTimeString.substring(4, 8);
		}
		StringBuffer quartersb = new StringBuffer("select t.C_DENOMINATION,t.C_TERM_CODE,t.C_TERM_TYPE,t.I_TRAN_TRUECOUNT,t.I_TRAN_SUSPECCOUNT,t.I_TRAN_OLDCOUNT");
		quartersb.append(" from cml_statistic_record t where ");
		quartersb.append("t.C_TRAN_TIME>=? and t.C_TRAN_TIME<=? ");
		if(null == flag || flag.equals("true")){
			quartersb.append("and t.c_pathcode like ? ");
		}else{
			quartersb.append("and t.c_pathcode = ? ");
		}

		SQLQuery quartersql = this.getSession().createSQLQuery(quartersb.toString());
		quartersql.setString(0, beginTimeString+"000000");
		quartersql.setString(1, endTimeString+"240000");
		if(null == flag || flag.equals("true")){
			quartersql.setString(2, pathCode+"%");
		}else{
			quartersql.setString(2, pathCode+"");
		}

		List<Object[]> quarterlist = quartersql.list();
		CashIncomePayStatisticReportByResultList(quarterlist);
		
	    StringBuffer byhandsb = new StringBuffer("select t.I_HUNDRED_COUNT ,t.I_FIFTY_COUNT" +
		",t.I_TWENTY_COUNT ,t.I_TEN_COUNT ,t.I_FIVE_COUNT ,t.I_ONE_COUNT ,t.C_TRAN_TYPE");
	    byhandsb.append(" from cml_info_byhand t where ");
	    byhandsb.append("t.C_TRAN_TIME>=? and t.C_TRAN_TIME<=? ");
	    if(null == flag || flag.equals("true")){
		    byhandsb.append("and t.c_pathcode like ? ");
	    }else{
		    byhandsb.append("and t.c_pathcode = ? ");
	    }

	    SQLQuery byhandsql = this.getSession().createSQLQuery(byhandsb.toString());
	    byhandsql.setString(0, beginTimeString+"000000");
	    byhandsql.setString(1, endTimeString+"240000");
	    if(null == flag || flag.equals("true")){
		    byhandsql.setString(2, pathCode+"%");
	    }else{
		    byhandsql.setString(2, pathCode+"");
	    }

	    List<Object[]> byhandlist = byhandsql.list();
	    CashIncomePayStatisticReportByhandList(byhandlist);
	    OrgInfo orgInfo = new OrgInfo();
	    orgInfo = orgInfoDao.getByPathCode(pathCode);
	    cashIncomePayVO.setBank(orgInfo.getOrgName());
	    Map<String, Object> result = new HashMap<String, Object>();
		result.put("gridResult", cashIncomePayVO);	
		return result;
	}
	
	/**
	 * 根据查询结果统计
	 * @param list
	 * @param TranType
	 */
	
	protected void CashIncomePayStatisticReportByResultList(List<Object[]> list)
	{
		//收入
		BigDecimal incomeHundredCount = new BigDecimal(0);
		BigDecimal incomeFiftyCount = new BigDecimal(0);
		BigDecimal incomeTewentyCount = new BigDecimal(0);
		BigDecimal incomeTenCount = new BigDecimal(0);
		BigDecimal incomeFiveCount = new BigDecimal(0);
		BigDecimal incomeOneCount = new BigDecimal(0);
		BigDecimal incomeCount = new BigDecimal(0);
		//付出
		BigDecimal payHundredCount = new BigDecimal(0);
		BigDecimal payFiftyCount = new BigDecimal(0);
		BigDecimal payTewentyCount = new BigDecimal(0);
		BigDecimal payTenCount = new BigDecimal(0);
		BigDecimal payFiveCount = new BigDecimal(0);
		BigDecimal payOneCount = new BigDecimal(0);
		BigDecimal payCount = new BigDecimal(0);
		

		
		for( Object[] objs : list )
		{
			String tranType = (String)objs[2];
			
			
			int denomination = 0;
			BigDecimal tranTrueCount = new BigDecimal(0);
			BigDecimal tranSuspecCount = new BigDecimal(0);
			BigDecimal tranOldCount = new BigDecimal(0);
			if (!StringUtils.isBlank((String)objs[0])){
				denomination = Integer.parseInt((String)objs[0]);
			}
			tranTrueCount = (BigDecimal) objs[3];
			tranSuspecCount = (BigDecimal) objs[4];
			tranOldCount = (BigDecimal) objs[5];
			BigDecimal tranCount = tranTrueCount.add(tranSuspecCount).add(tranOldCount);
			if (StringUtils.isBlank(tranType)==false) {
				if ("1".equals(tranType)||"5".equals(tranType)) {
					switch (denomination) {
					case 100:
						incomeHundredCount=incomeHundredCount.add(tranCount);
						break;
					case 50:
						incomeFiftyCount=incomeFiftyCount.add(tranCount);
						break;
					case 20:
						incomeTewentyCount=incomeTewentyCount.add(tranCount);
						break;
					case 10:
						incomeTenCount=incomeTenCount.add(tranCount);
						break;
					case 5:
						incomeFiveCount=incomeFiveCount.add(tranCount);
						break;
					case 1:
						incomeOneCount=incomeOneCount.add(tranCount);
						break;
	
					default:
						break;
					}
				}
				if ("6".equals(tranType)||"7".equals(tranType)) {
					switch (denomination) {
					case 100:
						payHundredCount=payHundredCount.add(tranCount);
						break;
					case 50:
						payFiftyCount=payFiftyCount.add(tranCount);
						break;
					case 20:
						payTewentyCount=payTewentyCount.add(tranCount);
						break;
					case 10:
						payTenCount=payTenCount.add(tranCount);
						break;
					case 5:
						payFiveCount=payFiveCount.add(tranCount);
						break;
					case 1:
						payOneCount=payOneCount.add(tranCount);
						break;
	
					default:
						break;
					}
					
				}
			}
		}
		 //100 50 合计
		payHundredCount = payHundredCount.multiply(new BigDecimal(100))
		.add(payFiftyCount.multiply(new BigDecimal(50)));
		cashIncomePayVO.setSorterBig(payHundredCount.toString());
		//20 10 合计
		payTewentyCount = payTewentyCount.multiply(new BigDecimal(20))
		.add(payTenCount.multiply(new BigDecimal(10)));
		cashIncomePayVO.setSorterMiddle(payTewentyCount.toString());
		//5 1 合计
		payFiveCount = payFiveCount.multiply(new BigDecimal(50))
		.add(payOneCount.multiply(new BigDecimal(1)));
		cashIncomePayVO.setSorterSmall(payFiveCount.toString());
		//付出合计
		payCount = payHundredCount.add(payTewentyCount).add(payFiveCount);
		cashIncomePayVO.setSorterCount(payCount.toString());
//		cashIncomePayVO.setByHandBig(incomeHundredCount.add(incomeFiftyCount).toString());
//		cashIncomePayVO.setByHandMiddle(incomeTewentyCount.add(incomeTenCount).toString());
//		cashIncomePayVO.setByHandSmall(incomeFiveCount.add(incomeOneCount).toString());
//		cashIncomePayVO.setByHandCount(incomeHundredCount.add(incomeTewentyCount).add(incomeFiveCount).toString());
//		cashIncomePayVO.setCashPayCount(cashPayCount)
		//收入合计
		incomeCount = incomeHundredCount.multiply(new BigDecimal(100))
		.add(incomeFiftyCount.multiply(new BigDecimal(50)))
		.add(incomeTewentyCount.multiply(new BigDecimal(20)))
		.add(incomeTenCount.multiply(new BigDecimal(10)))
		.add(incomeFiveCount.multiply(new BigDecimal(5)))
		.add(incomeOneCount.multiply(new BigDecimal(1)));
		cashIncomePayVO.setIncomeCount(incomeCount.toString());
		//		payCount = payHundredCount.add(payFiftyCount).add(payTewentyCount).add(payTenCount).add(payFiveCount).add(payOneCount);
	}
	
	protected void CashIncomePayStatisticReportByhandList(List<Object[]> list){
		
		BigDecimal hundredCount = new BigDecimal(0); 
		BigDecimal fiftyCount = new BigDecimal(0); 
		BigDecimal twentyCount = new BigDecimal(0); 
		BigDecimal tenCount = new BigDecimal(0); 
		BigDecimal fiveCount = new BigDecimal(0); 
		BigDecimal oneCount = new BigDecimal(0); 
		BigDecimal count = new BigDecimal(0);
		
		//收入
		BigDecimal incomeHundredCount = new BigDecimal(0);
		BigDecimal incomeFiftyCount = new BigDecimal(0);
		BigDecimal incomeTwentyCount = new BigDecimal(0);
		BigDecimal incomeTenCount = new BigDecimal(0);
		BigDecimal incomeFiveCount = new BigDecimal(0);
		BigDecimal incomeOneCount = new BigDecimal(0);
		BigDecimal incomeCount = new BigDecimal(0);
		//付出
		BigDecimal payHundredCount = new BigDecimal(0);
		BigDecimal payFiftyCount = new BigDecimal(0);
		BigDecimal payTewentyCount = new BigDecimal(0);
		BigDecimal payTenCount = new BigDecimal(0);
		BigDecimal payFiveCount = new BigDecimal(0);
		BigDecimal payOneCount = new BigDecimal(0);
		BigDecimal payCount = new BigDecimal(0);
		
		
		String tranType = "";
		for( Object[] objs : list )
		{
			hundredCount = (BigDecimal) objs[0];
		     fiftyCount = (BigDecimal) objs[1];
		     twentyCount = (BigDecimal) objs[2];
		     tenCount = (BigDecimal) objs[3];
		     fiveCount = (BigDecimal) objs[4];
		     oneCount = (BigDecimal) objs[5];
		     tranType = (String)objs[6];
			if(StringUtils.isBlank(tranType)==false){
				if ("1".equals(tranType)||"5".equals(tranType)||"8".equals(tranType)) {
					incomeHundredCount=incomeHundredCount.add(hundredCount);
					incomeFiftyCount=incomeFiftyCount.add(fiftyCount);
					incomeTwentyCount=incomeTwentyCount.add(twentyCount);
					incomeTenCount = incomeTenCount.add(tenCount);
					incomeFiveCount = incomeFiveCount.add(fiveCount);
					incomeOneCount = incomeOneCount.add(oneCount);
					
						
				}
				if ("6".equals(tranType)||"7".equals(tranType)) {
					payHundredCount=payHundredCount.add(hundredCount);
					payFiftyCount=payFiftyCount.add(fiftyCount);
					payTewentyCount=payTewentyCount.add(twentyCount);
					payTenCount = payTenCount.add(tenCount);
					payFiveCount = payFiveCount.add(fiveCount);
					payOneCount = payOneCount.add(oneCount);
				}
			}
		}
		
		    //100 50 合计
			payHundredCount = payHundredCount.multiply(new BigDecimal(100))
			.add(payFiftyCount.multiply(new BigDecimal(50)));
			cashIncomePayVO.setByHandBig(payHundredCount.toString());
			//20 10 合计
			payTewentyCount = payTewentyCount.multiply(new BigDecimal(20))
			.add(payTenCount.multiply(new BigDecimal(10)));
			cashIncomePayVO.setByHandMiddle(payTewentyCount.toString());
			//5 1 合计
			payFiveCount = payFiveCount.multiply(new BigDecimal(50))
			.add(payOneCount.multiply(new BigDecimal(1)));
			cashIncomePayVO.setByHandSmall(payFiveCount.toString());
			//付出合计
			payCount = payHundredCount.add(payTewentyCount).add(payFiveCount);
			cashIncomePayVO.setByHandCount(payCount.toString());
			BigDecimal cashPayCount = new BigDecimal(cashIncomePayVO.getSorterCount());
			cashPayCount = cashPayCount.add(payCount);
			cashIncomePayVO.setCashPayCount(cashPayCount.toString());
			//收入合计
			incomeCount = incomeHundredCount.multiply(new BigDecimal(100))
			.add(incomeFiftyCount.multiply(new BigDecimal(50)))
			.add(incomeTwentyCount.multiply(new BigDecimal(20)))
			.add(incomeTenCount.multiply(new BigDecimal(10)))
			.add(incomeFiveCount.multiply(new BigDecimal(5)))
			.add(incomeOneCount.multiply(new BigDecimal(1)));
			BigDecimal incomeCountf = new BigDecimal(cashIncomePayVO.getIncomeCount());
			
			cashIncomePayVO.setIncomeCount(incomeCountf.add(incomeCount).toString());
}
}
