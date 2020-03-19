package com.grgbanking.sent.transmgr.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.transmgr.constants.CmlNoteflowDetailInfoConsts;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowATMAddCashTotalInfoVO;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowATMAddCashVO;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowInfo;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowMgrRow;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowSituationTotalInfoVO;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowSituationVO;
import com.grgbanking.sent.transmgr.entity.TotalInfo;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 
 * @author 广电运通
 */
@Repository
public class CmlNoteflowInfoMgrDao extends BaseDao<CmlNoteflowInfo>
{
	
	@Transactional(readOnly = true)
	public boolean isExistsByBarcodeFlowNum(String barcodeFlowNum)
	{
		String hql = 	" select 1 " +
						" from CmlNoteflowInfo cnf" +
						" where cnf.barcodeFlowNum = ?";
		Integer r = this.findUnique(hql, barcodeFlowNum);
		if( r==null )
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	@Transactional(readOnly = true)
	public CmlNoteflowInfo getByBarcodeFlowNum(String barcodeFlowNum)
	{
		String hql = 	" select cnf " +
						" from CmlNoteflowInfo cnf" +
						" where cnf.barcodeFlowNum = ?";
		return this.findUnique(hql, barcodeFlowNum);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Map<String,Object> getCmlNoteflowInfoMgrPage(Page page, Map condition)
	{
		String beginTimeString = (String)condition.get("startTime");
		String endTimeString   = (String)condition.get("endTime");
		String pathCode        = (String)condition.get("pathCode");
		String sqlCondition = "" ;
		// beginTime
		if( StringUtils.isBlank(beginTimeString) )
		{
			throw new IllegalArgumentException("beginDateString cannot be null.");
		}
		else {
			beginTimeString = beginTimeString.replace("-", "") ;
			sqlCondition += " and nfd.C_DATE >='"+beginTimeString+"' " ;
		}
		// endTime
		if( StringUtils.isBlank(endTimeString) )
		{
			throw new IllegalArgumentException("endDateString cannot be null.");
		}
		else {
			endTimeString = endTimeString.replace("-", "")+"240000" ;
			sqlCondition += " and nfd.C_DATE <='"+endTimeString+"' " ;
		}
		// orgId
		if( StringUtils.isBlank(pathCode)==false )
		{
			sqlCondition += " and nfd.C_PATHCODE like '"+pathCode+"%'";
		}
		String sql =	" select " +
							" t.i_date, " +
							" t.c_flow_stage, " +
							" sum(t.i_totalnotes)" +
						" from ("+
							" select " +
								" substr(nfd.C_DATE, 1, 8) i_date," +
								" nfd.c_flow_stage," +
								" nf.i_totalnotes" +
							" from cml_noteflow_info nf" +
							" join cml_noteflow_detail_info nfd" +
								" on nf.C_TD_BARCODE_FLOWNUM = nfd.c_barcode_flowNum " +
							" where nf.c_clearing_date is not null" +
							" and nfd.c_flow_stage in (" +
								" '"+CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_BUNCH+"', " +		// atm分捆配钞
								" '"+CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_WHOLE_BOX+"', " +	// atm整箱配钞
							//	" '"+CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_KXCASH_BOX+"', " +	// 网点款箱配钞
								" '"+CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_CASH_BAG+"', " +	// 人行钞袋配钞
								" '"+CmlNoteflowDetailInfoConsts.FLOW_STAGE_ATM_ADD_CASH+"', " +		// 离行ATM加钞
								" '"+CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_ATM_ADD_CASH+"'" +	// 在行ATM加钞
							" )" +
							sqlCondition +
						") t "+
						" group by t.i_date, t.c_flow_stage " +
						" order by t.i_date, t.c_flow_stage " ;
		
		// System.out.println("sql = "+sql);
		
		SQLQuery sqlQueryDevide = this.getSession().createSQLQuery(sql);
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Object[]> list = sqlQueryDevide.list();
		Map<String, CmlNoteflowMgrRow> resultMap = new TreeMap<String, CmlNoteflowMgrRow>();
		TotalInfo totalInfo = new TotalInfo() ;
		for( Object[] objs : list )
		{
			String i_date = (String)objs[0];
			String flowStage = (String)objs[1];
			BigDecimal sum = new BigDecimal(objs[2].toString());
			
			CmlNoteflowMgrRow cmlNoteflowMgrRow = resultMap.get(i_date);
			if( cmlNoteflowMgrRow==null )
			{
				cmlNoteflowMgrRow = new CmlNoteflowMgrRow();
				cmlNoteflowMgrRow.iDate = i_date;
				resultMap.put(i_date, cmlNoteflowMgrRow);
			}
			
			if( flowStage.equals(CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_BUNCH) )	// 分捆配钞
			{
				cmlNoteflowMgrRow.cashboxByBunchAmount = sum;
				cmlNoteflowMgrRow.totalNotes = cmlNoteflowMgrRow.totalNotes.add(sum);
				totalInfo.totalAll = totalInfo.totalAll.add(sum);
				totalInfo.totalDistByBunch = totalInfo.totalDistByBunch.add(sum);
			}
			else if( flowStage.equals(CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_WHOLE_BOX) )	// 整箱配钞
			{
				cmlNoteflowMgrRow.cashboxByWholeBoxAmount = sum;
				cmlNoteflowMgrRow.totalNotes = cmlNoteflowMgrRow.totalNotes.add(sum);
				totalInfo.totalAll = totalInfo.totalAll.add(sum);
				totalInfo.totalDistByWholeBox = totalInfo.totalDistByWholeBox.add(sum);
			}
//			else if( flowStage.equals(CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_KXCASH_BOX) )	// （清分中心）款箱配钞
//			{
//				cmlNoteflowMgrRow.kxcashboxAmount = sum;
//				cmlNoteflowMgrRow.totalNotes = cmlNoteflowMgrRow.totalNotes.add(sum);
//				totalInfo.totalAll = totalInfo.totalAll.add(sum);
//				totalInfo.totalDistByKXCashbox = totalInfo.totalDistByKXCashbox.add(sum);
//			}
			else if( flowStage.equals(CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_CASH_BAG) )	// 钞袋配钞
			{
				cmlNoteflowMgrRow.cashbagAmount = sum;
				cmlNoteflowMgrRow.totalNotes = cmlNoteflowMgrRow.totalNotes.add(sum);
				totalInfo.totalAll = totalInfo.totalAll.add(sum);
				totalInfo.totalDistByCashbag = totalInfo.totalDistByCashbag.add(sum);
			}
			else if( flowStage.equals(CmlNoteflowDetailInfoConsts.FLOW_STAGE_ATM_ADD_CASH) )	// ATM加钞
			{
				cmlNoteflowMgrRow.addCashOffBankAmount = sum;
				cmlNoteflowMgrRow.totalNotes = cmlNoteflowMgrRow.totalNotes.add(sum);
				totalInfo.totalAll = totalInfo.totalAll.add(sum);
				totalInfo.totalDistOffBank = totalInfo.totalDistOffBank.add(sum);
			}
			else if( flowStage.equals(CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_ATM_ADD_CASH) )	// 在行ATM加钞
			{
				cmlNoteflowMgrRow.addCashAtBranchAmount = sum;
				cmlNoteflowMgrRow.totalNotes = cmlNoteflowMgrRow.totalNotes.add(sum);
				totalInfo.totalAll = totalInfo.totalAll.add(sum);
				totalInfo.totalDistAtBranch = totalInfo.totalDistAtBranch.add(sum);
			}
		}
		
		result.put("gridResult", new ArrayList<CmlNoteflowMgrRow>(resultMap.values()));
		result.put("totalResult", totalInfo);
		
		return result;

	}
	
	
	/**
	 * 获取网点流转情况统计分页
	 * @param parameter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Map<String,Object> getCmlNoteflowSituationReportPage(Map<String, Object> parameter)
	{		
		logger.info("CmlNoteflowInfoMgrDao.getCmlNoteflowSituationReportPage()");
		
		//Page page = (Page)parameter.get("page");
		Map<String, Object> condition = (Map<String, Object>)parameter.get("condition");
		
		
		String beginTimeString = (String)condition.get("startTime");
		String endTimeString   = (String)condition.get("endTime");
		String pathCode        = (String)condition.get("pathCode");
		String flag		=	(String)condition.get("flag");
		String sqlCondition = "" ;		
	
		if(StringUtils.isBlank(beginTimeString) )
		{
			throw new IllegalArgumentException("清分开始时间不能为空");
		}
		else {
			beginTimeString = beginTimeString.replace("-", "") ;
		}		
		
		if(StringUtils.isBlank(endTimeString) )
		{
			throw new IllegalArgumentException("清分结束时间不能为空");
		} else {
			endTimeString = endTimeString.replace("-", "")+"240000";
		}	
		/*
		if(StringUtils.isNotBlank(pathCode))
		{
			sqlCondition += " and nf.C_PATHCODE like '"+pathCode+"%'";
		}
		
		String sql =	" select nf.C_PATHCODE, substr(nf.C_CLEARING_DATE, 1, 8), sum(nf.I_NOTECOUNT),  sum(nf.I_TOTALNOTES)" +
						" from cml_noteflow_info nf" +
						" where nf.C_CLEARING_DATE is not null" + sqlCondition +
						" group by nf.C_PATHCODE, substr(nf.C_CLEARING_DATE, 1, 8) " +
						" order by nf.C_PATHCODE, substr(nf.C_CLEARING_DATE, 1, 8) " ;*/
		
		//System.out.println("sql = "+sql);
		
		StringBuffer sb = new StringBuffer("select t.c_pathcode,sum(t.i_tran_count) totalCount,sum(t.i_statis_amt) totalMoney,");
		if(DBDialectHelper.isOracle())
			sb.append("to_char(t.d_bind_start,'yyyyMMdd') taskDate ");
		else if(DBDialectHelper.isMySql())
			sb.append("DATE_FORMAT(t.d_bind_start,'%Y%m%d') taskDate ");
		else
			sb.append("DATE_FORMAT(t.d_bind_start,'%Y%m%d') taskDate ");
		sb.append(" from cml_task_infos t where ");
		if(DBDialectHelper.isOracle())
			sb.append("to_char(t.d_bind_start,'yyyyMMdd')>=? and to_char(t.d_bind_start,'yyyyMMddHH24MISS')<=? ");
		else if(DBDialectHelper.isMySql())
			sb.append("DATE_FORMAT(t.d_bind_start,'%Y%m%d')>=? and DATE_FORMAT(t.d_bind_start,'%Y%m%d%H%i%S')<=? ");
		else
			sb.append("DATE_FORMAT(t.d_bind_start,'%Y%m%d')>=? and DATE_FORMAT(t.d_bind_start,'%Y%m%d%H%i%S')<=? ");
			
		SQLQuery sqlQuery = null;
		if(null == flag || flag.equals("true")){
			sb.append("and t.c_pathcode like ? group by t.c_pathcode,t.d_bind_start order by t.d_bind_start");
			
			sqlQuery = this.getSession().createSQLQuery(sb.toString());
			sqlQuery.setString(0, beginTimeString);
			sqlQuery.setString(1, endTimeString);
			sqlQuery.setString(2, pathCode+"%");
			
		}else{
			sb.append("and t.c_pathcode = ? group by t.c_pathcode,t.d_bind_start order by t.d_bind_start");
			sqlQuery = this.getSession().createSQLQuery(sb.toString());
			sqlQuery.setString(0, beginTimeString);
			sqlQuery.setString(1, endTimeString);
			sqlQuery.setString(2, pathCode+"");
		}

		

		
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Object[]> list = sqlQuery.list();
		Map<String, CmlNoteflowSituationVO> resultMap = new TreeMap<String, CmlNoteflowSituationVO>();
		CmlNoteflowSituationTotalInfoVO totalInfo = new CmlNoteflowSituationTotalInfoVO() ;
		
		for( Object[] objs : list )
		{
			String c_pathCode = (String)objs[0];
			String c_date = (String)objs[3];
			//BigDecimal noteCount = new BigDecimal(objs[1].toString());
			//BigDecimal totalNotes = new BigDecimal(objs[2].toString());
			BigDecimal noteCount = new BigDecimal(0);
			BigDecimal totalNotes = new BigDecimal(0);
			if (objs[1] != null)
				noteCount = new BigDecimal(objs[1].toString());
			if (objs[2] != null)
				totalNotes = new BigDecimal(objs[2].toString());
			
			CmlNoteflowSituationVO cmlNoteflowSituationVO = resultMap.get(c_pathCode+c_date);
			if( cmlNoteflowSituationVO==null )
			{
				cmlNoteflowSituationVO = new CmlNoteflowSituationVO();
				
				cmlNoteflowSituationVO.setPathCode(c_pathCode);
				cmlNoteflowSituationVO.setClearingDate(c_date);
				cmlNoteflowSituationVO.setNoteCount(noteCount);
				cmlNoteflowSituationVO.setTotalNotes(totalNotes);
				
				resultMap.put(c_pathCode+c_date, cmlNoteflowSituationVO);
			}else{
				cmlNoteflowSituationVO.setNoteCount(cmlNoteflowSituationVO.getNoteCount().add(noteCount));
				cmlNoteflowSituationVO.setTotalNotes(cmlNoteflowSituationVO.getTotalNotes().add(totalNotes));
			}
			
			totalInfo.setAllNoteCount(totalInfo.getAllNoteCount().add(noteCount));
			totalInfo.setAllTotalNotes(totalInfo.getAllTotalNotes().add(totalNotes));					
		}
		
		result.put("gridResult", new ArrayList<CmlNoteflowSituationVO>(resultMap.values()));
		result.put("totalResult", totalInfo);
		
		return result;
	}
	
	
	/**
	 * 获取ATM配钞统计分页
	 * @param parameter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Map<String,Object> getCmlNoteflowATMAddCashReportPage(Map<String, Object> parameter)
	{		
		logger.info("CmlNoteflowInfoMgrDao.getCmlNoteflowATMAddCashReportPage()");
		
		//Page page = (Page)parameter.get("page");
		Map<String, Object> condition = (Map<String, Object>)parameter.get("condition");
		
		
		String beginTimeString = (String)condition.get("startTime");
		String endTimeString   = (String)condition.get("endTime");
		String pathCode        = (String)condition.get("pathCode");
		String flag		=	(String)condition.get("flag");
		String termId        = (String)condition.get("termId");
	
		// nf.C_CLEARING_DATE
		if(StringUtils.isBlank(beginTimeString) )
		{
			throw new IllegalArgumentException("开始时间不能为空");
		}
		else
		{
			beginTimeString = beginTimeString.replace("-", "") ;
		}		
	
		// nf.C_CLEARING_DATE
		if(StringUtils.isBlank(endTimeString) )
		{
			throw new IllegalArgumentException("结束时间不能为空");
		}
		else
		{
			endTimeString = endTimeString.replace("-", "")+"240000" ;
		}	
		
		
		// nfd.C_BARCODE2
		/*String sql =	" select" +
							" t.C_PATHCODE," +
							" t.ATM_CODE," +
							" t.C_DATE," +
							" sum(t.I_TOTALNOTES)" +
						" from ("+
							" select" +
								" nfd.C_PATHCODE," +
								" nfd.C_BARCODE2 ATM_CODE," +
								" substr(nfd.C_DATE, 1, 8) C_DATE," +
								" nf.I_TOTALNOTES" +
							" from cml_noteflow_info nf" +
							" join cml_noteflow_detail_info nfd" +
								" on nf.C_BARCODE_FLOWNUM = nfd.C_BARCODE_FLOWNUM " +
							" where nf.C_CLEARING_DATE is not null" +
							" and nfd.C_FLOW_STAGE in (" +								
								" '"+CmlNoteflowDetailInfoConsts.FLOW_STAGE_ATM_ADD_CASH+"', " +		// 离行ATM加钞
								" '"+CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_ATM_ADD_CASH+"' " +	// 在行ATM加钞
							" )" +
							sqlCondition +
						") t "+
						" group by t.C_PATHCODE, t.ATM_CODE, t.C_DATE " +
						" order by t.C_PATHCODE, t.ATM_CODE, t.C_DATE " ;
		
		System.out.println("sql = "+sql);*/
		StringBuffer sb = new StringBuffer("select t.c_pathcode, t.c_term_id,t.trandate, sum(t.i_statis_amt) from (");
		sb.append("select l.c_pathcode,l.c_term_id,substr(l.c_tran_time,1,8) trandate,sum(l.i_statis_amt) i_statis_amt from cml_load_notes_record l where ");
		if(null == flag || flag.equals("true")){
			sb.append("substr(l.c_tran_time,1,8)>=? and l.c_tran_time<=? and l.c_pathcode like ?  and l.i_oper_type='0' ");
		}else{
			sb.append("substr(l.c_tran_time,1,8)>=? and l.c_tran_time<=? and l.c_pathcode = ?  and l.i_oper_type='0' ");
		}

		if(!StringUtil.isBlank(termId)){
			sb.append(" and l.c_term_id=? ");
		}
		sb.append(" group by l.c_pathcode,l.c_term_id,l.c_tran_time");
		sb.append(") t group by t.c_pathcode,t.c_term_id,t.trandate order by t.trandate");
		
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sb.toString());
		sqlQuery.setString(0, beginTimeString);
		sqlQuery.setString(1, endTimeString);
		if(null == flag || flag.equals("true")){
			sqlQuery.setString(2, pathCode+"%");
		}else{
			sqlQuery.setString(2, pathCode+"");
		}
		if(!StringUtil.isBlank(termId)){
			sqlQuery.setString(3, termId);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Object[]> list = sqlQuery.list();
		Map<String, CmlNoteflowATMAddCashVO> resultMap = new TreeMap<String, CmlNoteflowATMAddCashVO>();
		CmlNoteflowATMAddCashTotalInfoVO totalInfo = new CmlNoteflowATMAddCashTotalInfoVO() ;
		
		for( Object[] objs : list )
		{
			String c_pathCode = (String)objs[0];
			String c_termId = (String)objs[1];
			String c_date = (String)objs[2];
			//BigDecimal totalNotes = new BigDecimal(objs[3].toString());
			BigDecimal totalNotes = new BigDecimal(0);
			if (objs[3].toString() != null)
				totalNotes = new BigDecimal(objs[3].toString());
			
			CmlNoteflowATMAddCashVO cmlNoteflowATMAddCashVO = resultMap.get(c_pathCode+c_termId+c_date);
			if(cmlNoteflowATMAddCashVO==null ){
				cmlNoteflowATMAddCashVO = new CmlNoteflowATMAddCashVO();
				
				cmlNoteflowATMAddCashVO.setPathCode(c_pathCode);
				cmlNoteflowATMAddCashVO.setTermId(c_termId);
				cmlNoteflowATMAddCashVO.setAddDate(c_date);
				cmlNoteflowATMAddCashVO.setAddCashAtBranchAmount(totalNotes);
				
				resultMap.put(c_pathCode+c_termId+c_date, cmlNoteflowATMAddCashVO);
			}else{
				cmlNoteflowATMAddCashVO.setAddCashAtBranchAmount(cmlNoteflowATMAddCashVO.getAddCashAtBranchAmount().add(totalNotes));
			}
			
			
			totalInfo.setAllAddCashAtBranchAmount(totalInfo.getAllAddCashAtBranchAmount().add(totalNotes));					
		}
		
		result.put("gridResult", new ArrayList<CmlNoteflowATMAddCashVO>(resultMap.values()));
		result.put("totalResult", totalInfo);
		
		return result;
	}
	
}
