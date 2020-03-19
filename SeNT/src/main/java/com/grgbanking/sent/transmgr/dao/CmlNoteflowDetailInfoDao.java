package com.grgbanking.sent.transmgr.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.transmgr.constants.CmlNoteflowDetailInfoConsts;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowDetailInfo;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowDetailInfoExt;
import com.grgbanking.sent.utils.ArrayUtil;
import com.grgbanking.sent.utils.CollectionsUtil;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 
 * @author 广电运通
 */
@Repository
public class CmlNoteflowDetailInfoDao extends BaseDao<CmlNoteflowDetailInfo>
{
	
	
	public CmlNoteflowDetailInfo getOneFlowingLatestAddCashRecordByCashboxNum(String cashboxNum)
	{
		String hql = 	" select cnfd " +
						" from CmlNoteflowDetailInfo cnfd" +
						" where cnfd.status = ?" +
						" and cnfd.flowStage in (?, ?)" +
						" and cnfd.barcode1 = ?" +
						" order by cnfd.date desc";
		return this.findFirst(hql, 
				CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED,
				CmlNoteflowDetailInfoConsts.FLOW_STAGE_ATM_ADD_CASH,		// atm加钞
				CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_ATM_ADD_CASH,	// 在行atm加钞
				cashboxNum);
	}
	
	@SuppressWarnings("unchecked")
	public Page<CmlNoteflowDetailInfo> getCmlNoteflowDetailInfosPageByFlowNum(Page page, String barcodeFlowNum)
	{
		String hql = 	" select cnfd " +
						" from CmlNoteflowDetailInfo cnfd" +
						" where cnfd.barcodeFlowNum = ?" +
						" order by cnfd.date desc";
		
		return this.findPage(page, hql, barcodeFlowNum);
	}
	
	
	
	
	/**
	 * get One CmlNoteflowDetailInfo by barcodeFlowNum and flowStages
	 */
	public CmlNoteflowDetailInfo getOneCmlNoteflowDetailInfoByBFNAndFSS(String barcodeFlowNum, String[] flowStages)
	{
		if( flowStages==null || flowStages.length==0 )
		{
			return null;
		}
		
		String hql = 	" select cnfd " +
						" from CmlNoteflowDetailInfo cnfd" +
						" where cnfd.barcodeFlowNum = ?" +
						" and cnfd.flowStage in ("+StringUtil.generateMultiPartString("?", flowStages.length, ", ")+")" +
						" order by cnfd.date desc";
		
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(barcodeFlowNum);
		CollectionsUtil.addAll(parameters, flowStages);
		
		return this.findFirst(hql, parameters.toArray());
	}
	
	/**
	 * 根据钞箱号找到这个钞箱所有的流转信息
	 */
	@SuppressWarnings("unchecked")
	public Page<CmlNoteflowDetailInfo> getAllFlowDetailInfoByCashboxNum(Page page, String cashboxNum)
	{
		String hql = 	" select cnfd " +
						" from CmlNoteflowDetailInfo cnfd" +
						" where cnfd.barcode1 = ?" +
						" order by cnfd.date desc";
		return this.findPage(page, hql, cashboxNum );
	}
	
	
//	/**
//	 * 
//	 */
//	public List<CmlNoteflowDetailInfo> getFlowingBunchesListByCashboxNum(String cashboxNum)
//	{
//		// 先找出最新的一次流转
//		String hql =	" select cnfd " +
//						" from CmlNoteflowDetailInfo cnfd" +
//						" where cnfd.status = ?" +				// 表示当前正在流转当中的
//						" and cnfd.barcode1 = ?" +
//						" and cnfd.flowStage in (?, ?, ?, ?, ?)" +
//						" order by cnfd.date desc";
//		
//		CmlNoteflowDetailInfo cnfd = this.findFirst(hql, 
//													CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED, 					// 表示当前正在流转当中的
//													cashboxNum,
//													CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_BUNCH,				// atm分捆配钞
//													CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_WHOLE_BOX,			// atm整箱配钞
//													CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_KXCASH_BOX,			// (清分中心)款箱配钞
//													CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_CASH_BAG,			// 人行钞袋配钞
//													CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_DIST_BY_KXCASH_BOX	// (网点)款箱配钞
//													);
//		// 如果找不到，返回一个空列表对象
//		if( cnfd==null )
//		{
//			return new ArrayList<CmlNoteflowDetailInfo>();
//		}
//		
//		// 根据最新的一次流转信息，找出对应的所有条码
//		hql = 	" select cnfd " +
//				" from CmlNoteflowDetailInfo cnfd" +
//				" where cnfd.status = ?" +				// 表示当前正在流转当中的
//				" and cnfd.barcode1 = ?" +
//				" and cnfd.flowStage = ?" +
//				" and cnfd.date = ?";
//		return this.find(hql, 
//						CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED, 
//						cashboxNum,
//						cnfd.getFlowStage(),
//						cnfd.getDate()
//						);
//	}
	
//	/**
//	 * 
//	 */
//	public List<CmlNoteflowDetailInfo> getFlowingListByCashboxNumAndFlowStage(String cashboxNum, String flowStage)
//	{
//		// 先找出最新的一次流转
//		String hql =	" select cnfd " +
//						" from CmlNoteflowDetailInfo cnfd" +
//						" where cnfd.status = ?" +				// 表示当前正在流转当中的
//						" and cnfd.barcode1 = ?" +
//						" and cnfd.flowStage = ?" +
//						" order by cnfd.date desc";
//		
//		CmlNoteflowDetailInfo cnfd = this.findFirst(hql, 
//													CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED,	// 表示当前正在流转当中的
//													cashboxNum,
//													flowStage											// atm分捆配钞
//													);
//		// 如果找不到，返回一个空列表对象
//		if( cnfd==null )
//		{
//			return new ArrayList<CmlNoteflowDetailInfo>();
//		}
//		
//		// 根据最新的一次流转信息，找出对应的所有条码
//		hql = 	" select cnfd " +
//				" from CmlNoteflowDetailInfo cnfd" +
//				" where cnfd.status = ?" +				// 表示当前正在流转当中的
//				" and cnfd.barcode1 = ?" +
//				" and cnfd.flowStage = ?" +
//				" and cnfd.date = ?";
//		return this.find(hql, 
//						CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED, 
//						cashboxNum,
//						cnfd.getFlowStage(),
//						cnfd.getDate()
//						);
//	}
	
//	/**
//	 * 
//	 */
//	public List<CmlNoteflowDetailInfo> getFlowingListByCashboxNumAndFlowStages(String cashboxNum, String[] flowStages)
//	{
//		if( flowStages==null || flowStages.length==0 )
//		{
//			throw new IllegalArgumentException("flowStages is empty. flowStages = "+flowStages);
//		}
//		
//		// 先找出最新的一次流转
//		String hql =	" select cnfd " +
//						" from CmlNoteflowDetailInfo cnfd" +
//						" where cnfd.status = ?" +				// 表示当前正在流转当中的
//						" and cnfd.barcode1 = ?" +
//						" and cnfd.flowStage in ("+StringUtil.generateMultiPartString("?", flowStages.length, ", ")+")" +
//						" order by cnfd.date desc";
//		
//		List<Object> parameters = new ArrayList<Object>();
//		parameters.add(CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED);
//		parameters.add(cashboxNum);
//		CollectionsUtil.addAll(parameters, flowStages);
//		
//		CmlNoteflowDetailInfo cnfd = this.findFirst(hql, parameters.toArray());
//		
//		// 如果找不到，返回一个空列表对象
//		if( cnfd==null )
//		{
//			return new ArrayList<CmlNoteflowDetailInfo>();
//		}
//		
//		// 根据最新的一次流转信息，找出对应的所有条码
//		hql = 	" select cnfd " +
//				" from CmlNoteflowDetailInfo cnfd" +
//				" where cnfd.status = ?" +				// 表示当前正在流转当中的
//				" and cnfd.barcode1 = ?" +
//				" and cnfd.flowStage = ?" +
//				" and cnfd.date = ?";
//		return this.find(hql, 
//						CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED, 
//						cashboxNum,
//						cnfd.getFlowStage(),
//						cnfd.getDate()
//						);
//	}
	
	
	
	/**
	 * 
	 */
	public List<CmlNoteflowDetailInfo> getFlowDetailListByCashboxNumAndFlowStages(String cashboxNum, String[] flowStages)
	{
		if( flowStages==null || flowStages.length==0 )
		{
			throw new IllegalArgumentException("flowStages is empty. flowStages = "+flowStages);
		}
		
		// 根据流转状态找出上一环节流转的流转记录
		String hql =	" select cnfd " +
						" from CmlNoteflowDetailInfo cnfd" +
						" where cnfd.status = ?" +				// 表示当前正在流转当中的
						" and cnfd.barcode1 = ?" +
						" and cnfd.flowStage in ("+StringUtil.generateMultiPartString("?", flowStages.length, ", ")+")" +
						" order by cnfd.date desc";
		
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED);
		parameters.add(cashboxNum);
		CollectionsUtil.addAll(parameters, flowStages);
		
		return this.find(hql, parameters.toArray());
		
	}
	
	
	/**
	 * 
	 */
	public CmlNoteflowDetailInfo getReturningCashboxBox(String cashboxNum)
	{
		String hql = 	" select cnfd " +
						" from CmlNoteflowDetailInfo cnfd" +
						" where cnfd.flowStage = ?" +			// ATM钞箱回笼
						" and cnfd.status = ?" +				// 尚未结束的
						" and cnfd.barcode1 = ?" +				// 钞箱号
						" order by cnfd.date desc";				
		return this.findFirst(hql, 
				CmlNoteflowDetailInfoConsts.FLOW_STAGE_ATM_CASHBOX_RETURN,
				CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED,
				cashboxNum
				);
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Page queryATMAddCashInfoPage(Page page, Map condition)
	{
		String flowStage      = (String)condition.get("flowStage");
		String startTime      = (String)condition.get("startTime");
		String endTime        = (String)condition.get("endTime");
		String cashboxNum     = (String)condition.get("cashboxNum");
		String atmNun         = (String)condition.get("atmNun");
		String operator       = (String)condition.get("operator");
		String pathCode       = (String)condition.get("pathCode");
		
		List<Object> parameterList = new ArrayList<Object>();
		
		String hql = 	" select new CmlNoteflowDetailInfo(" +
							" cnfd, " +
							//" cnf.followType," +
							" cnf.termId," +
							" cnf.journalNo," +
							" cnf.clearingDate," +
							" cnf.totalNotes" +
							" )" +
						" from CmlNoteflowDetailInfo cnfd," +
						"      CmlNoteflowInfo cnf" +
						" where cnfd.barcodeFlowNum = cnf.barcodeFlowNum";
		
		// beginTime
		if( StringUtils.isBlank(startTime) )
		{
			throw new IllegalArgumentException("startTime cannot be null.");
		}
		hql += "  and cnf.clearingDate >= ?";
		parameterList.add(startTime.replace("-", ""));
		
		// endTime
		if( StringUtils.isBlank(endTime) )
		{
			throw new IllegalArgumentException("endTime cannot be null.");
		}
		hql += "  and cnf.clearingDate <= ?";
		parameterList.add(endTime.replace("-", "")+"240000");
		
		// detailType
		if( StringUtils.isBlank(flowStage)==false )
		{
			hql += " and cnfd.flowStage = ?";
			parameterList.add(flowStage);
		}
		
		// cashboxNum
		if( StringUtils.isBlank(cashboxNum)==false )
		{
			hql += " and cnfd.barcode1 = ?";
			parameterList.add(cashboxNum);
		}
		
		// atmNun
		if( StringUtils.isBlank(atmNun)==false )
		{
			hql += " and cnfd.barcode2 = ?";
			parameterList.add(atmNun);
		}
		
		// operator
		if( StringUtils.isBlank(operator)==false )
		{
			hql += " and cnfd.operator = ?";
			parameterList.add(operator);
		}
		
		//pathCode
		if( StringUtils.isBlank(pathCode)==false )
		{
			hql += " and cnfd.pathCode like ?";
			parameterList.add(pathCode+"%");
		}
		
		hql += " order by cnfd.date desc, cnfd.barcodeFlowNum";
		
		Page page2 =  this.findPage(page, hql, parameterList.toArray());
		return page2;
	}
	
	/**
	 * 
	 */
	/*@SuppressWarnings("unchecked")
	public Page queryCmlNoteflowDetailInfoPage(Page page, Map condition)
	{
		String[] flowStage    = ArrayUtil.toStringArray((Object[])condition.get("flowStage"));
		String startTime      = (String)condition.get("startTime");
		String endTime        = (String)condition.get("endTime");
		String barcodeFlowNum = (String)condition.get("barcodeFlowNum");
		String cashboxNum     = (String)condition.get("cashboxNum");
		String atmNum         = (String)condition.get("atmNum");
		String operator       = (String)condition.get("operator");
		String pathCode       = (String)condition.get("pathCode");
		
		List<Object> parameterList = new ArrayList<Object>();
		
		String hql = 	" select new CmlNoteflowDetailInfoExt(" +
							" cnfd, " +
							" cnf.clearingDate" +
							" )" +
						" from CmlNoteflowDetailInfoExt cnfd" +
						" left outer join cnfd.cmlNoteflowInfo cnf" +
						" where 1=1";
		


		// startTime
		if( StringUtils.isBlank(startTime) )
		{
			throw new IllegalArgumentException("startTime cannot be null.");
		}
		hql += "  and cnfd.date >= ?";
		parameterList.add(startTime.replace("-", "")+"000000");
		
		// endTime
		if( StringUtils.isBlank(endTime) )
		{
			throw new IllegalArgumentException("endTime cannot be null.");
		}
		hql += "  and cnfd.date <= ?";
		parameterList.add(endTime.replace("-", "")+"240000");
		
		// flowStage
		if( ArrayUtil.isBlank(flowStage)==false )
		{
			hql += " and cnfd.flowStage in ("+StringUtil.generateMultiPartString("?", flowStage.length, ", ")+")";
			CollectionsUtil.addAll(parameterList, flowStage);
		}
		
		// barcodeFlowNum
		if( StringUtils.isBlank(barcodeFlowNum)==false )
		{
			hql += " and cnf.tdBarcodeFlownum = ?";
			parameterList.add(barcodeFlowNum);
		}
		
		// cashboxNum
		if( StringUtils.isBlank(cashboxNum)==false )
		{
			hql += " and cnfd.barcode1 like ?";
			parameterList.add("%" + cashboxNum + "%");
		}
		
		// atmNum
		if( StringUtils.isBlank(atmNum)==false )
		{
			hql += " and cnfd.barcode2 = ?";
			parameterList.add(atmNum);
		}
		
		// operator
		if( StringUtils.isBlank(operator)==false )
		{
			hql += " and cnfd.operator = ?";
			parameterList.add(operator);
		}
		
		//pathCode
		if( StringUtils.isBlank(pathCode)==false )
		{
			hql += " and cnfd.pathCode like ?";
			parameterList.add(pathCode+"%");
		}
		
		//c.c_id in (select min(c2.c_id) from cml_noteflow_detail_info c2 group by c2.c_barcode1)
		if( ArrayUtil.isBlank(flowStage)==false )
		{
			hql+=" and cnfd.id in (" +
					"select max (cnfd2.id) from CmlNoteflowDetailInfoExt cnfd2 " +
					"where cnfd2.flowStage in ("+
					StringUtil.generateMultiPartString("?", flowStage.length, ", ")+
					") group by cnfd2.barcode1,cnfd2.date)";
			CollectionsUtil.addAll(parameterList, flowStage);
			
		}
		hql += " order by cnfd.date desc, cnfd.barcode1 asc, cnfd.barcode2 asc";//, cnf.tdBarcodeFlownum
		
		Page page2 =  this.findPage(page, hql, parameterList.toArray());
		
		List<CmlNoteflowDetailInfoExt> infoLst = page2.getResult();

		for (int i=0;i<infoLst.size();i++) {
			CmlNoteflowDetailInfoExt info = infoLst.get(i);
			info.setStatisAmt(BigDecimal.valueOf(getNoteflowAmt(info.getBarcode1(),info.getDate())));
			info.setBarcodeFlowNum(getNoteflowBarCodeFlowNums(info.getBarcode1(),info.getDate()));
			//大额取款屏蔽卡号
			if(info!=null && CmlNoteflowDetailInfoConsts.FLOW_STAGE_LARGE_WITHDRAW.equals(info.getFlowStage()) && info.getBarcode1()!=null && info.getBarcode1().length()>3){
				info.setBarcode1(info.getBarcode1().substring(0, info.getBarcode1().length()-4)+"***"+info.getBarcode1().substring(info.getBarcode1().length()-1));
			}
		}
		page2.setResult(infoLst);
		
		return page2;
	}*/
	
	
	@SuppressWarnings("unchecked")
	public Page queryCmlNoteflowDetailInfoPage(Page page, Map condition)
	{
		String[] flowStage    = ArrayUtil.toStringArray((Object[])condition.get("flowStage"));
		String startTime      = (String)condition.get("startTime");
		String endTime        = (String)condition.get("endTime");
		String barcodeFlowNum = (String)condition.get("barcodeFlowNum");
		String cashboxNum     = (String)condition.get("cashboxNum");
		String atmNum         = (String)condition.get("atmNum");
		String operator       = (String)condition.get("operator");
		String pathCode       = (String)condition.get("pathCode");
		String flag=(String)condition.get("flag");
		
		List<Object> parameterList = new ArrayList<Object>();
		
//		String hql = 	" select new CmlNoteflowDetailInfoExt(" +
//							" cnfd, " +
//							" cnf.clearingDate" +
//							" )" +
//						" from CmlNoteflowDetailInfoExt cnfd" +
//						" left outer join cnfd.cmlNoteflowInfo cnf" +
//						" where 1=1";
		
		String hql = "select new CmlNoteflowDetailInfoExt( cnfd, cnf.clearingDate ) from CmlNoteflowDetailInfoExt cnfd" +
				" left outer join cnfd.cmlNoteflowInfo cnf" ;

		//c.c_id in (select min(c2.c_id) from cml_noteflow_detail_info c2 group by c2.c_barcode1)
//		if (ArrayUtil.isBlank(flowStage) == false) {
//			hql += " join ("
//					+ "select max(cnfd2.id) id from CmlNoteflowDetailInfoExt cnfd2 "
//					+ "where cnfd2.flowStage in ("
//					+ StringUtil.generateMultiPartString("?", flowStage.length,
//							", ") + ") group by cnfd2.barcode1,cnfd2.date) cnfd3"
//							+" on cnfd.id =cnfd3.id";
//			CollectionsUtil.addAll(parameterList, flowStage);
//		}
		
		hql +=" where 1=1 ";
		
		// startTime
		if( StringUtils.isBlank(startTime) )
		{
			throw new IllegalArgumentException("startTime cannot be null.");
		}
		hql += "  and cnfd.date >= ?";
		parameterList.add(startTime.replace("-", "")+"000000");
		
		// endTime
		if( StringUtils.isBlank(endTime) )
		{
			throw new IllegalArgumentException("endTime cannot be null.");
		}
		hql += "  and cnfd.date <= ?";
		parameterList.add(endTime.replace("-", "")+"240000");
		
		// flowStage
		if( ArrayUtil.isBlank(flowStage)==false )
		{
			hql += " and cnfd.flowStage in ("+StringUtil.generateMultiPartString("?", flowStage.length, ", ")+")";
			CollectionsUtil.addAll(parameterList, flowStage);
		}
		
		// barcodeFlowNum
		if( StringUtils.isBlank(barcodeFlowNum)==false )
		{
			hql += " and cnf.tdBarcodeFlownum = ?";
			parameterList.add(barcodeFlowNum);
		}
		
		// cashboxNum
		if( StringUtils.isBlank(cashboxNum)==false )
		{
			hql += " and cnfd.barcode1 like ?";
			parameterList.add("%" + cashboxNum + "%");
		}
		
		// atmNum
		if( StringUtils.isBlank(atmNum)==false )
		{
			hql += " and cnfd.barcode2 = ?";
			parameterList.add(atmNum);
		}
		
		// operator
		if( StringUtils.isBlank(operator)==false )
		{
			hql += " and cnfd.operator = ?";
			parameterList.add(operator);
		}
		
		//pathCode
		if( StringUtils.isBlank(pathCode)==false )
		{
			if(null == flag || flag.equals("true")){
				hql += " and cnfd.pathCode like ?";
				parameterList.add(pathCode+"%");
			}else{
				hql += " and cnfd.pathCode = ?";
				parameterList.add(pathCode+"");
			}
		}
		
		String ids = getMaxId(flowStage);
		if (ArrayUtil.isBlank(flowStage) == false && !"".equals(ids)) {
			hql += " and cnfd.id in ("+ids+")";
//			CollectionsUtil.addAll(parameterList, flowStage);
		}
		
		hql += " order by cnfd.date desc, cnfd.barcode1 asc, cnfd.barcode2 asc";//, cnf.tdBarcodeFlownum
		
		Page page2 =  this.findPage(page, hql, parameterList.toArray());
		
		List<CmlNoteflowDetailInfoExt> infoLst = page2.getResult();

		for (int i=0;i<infoLst.size();i++) {
			CmlNoteflowDetailInfoExt info = infoLst.get(i);
			String barCodeFlowNums = getNoteflowBarCodeFlowNums(info.getBarcode1(),info.getDate());
			info.setBarcodeFlowNum(barCodeFlowNums);
			String barCodeFlowNumsParam = "'"+barCodeFlowNums.replace(",", "','")+"'";
			info.setStatisAmt(BigDecimal.valueOf(getNoteflowAmt(barCodeFlowNumsParam)));
			
		}
		page2.setResult(infoLst);
		
		return page2;
	}
	
	
	public Integer getNoteflowAmt(String param){
		Session session = this.getSessionFactory().openSession();
		Connection cnn = session.connection();
		ResultSet rs=null;
		int amt = 0;
		try{
			String getNoteflowAmtSql = "select sum(cni.i_statis_amt) from cml_noteflow_info cni where cni.c_td_barcode_flownum in ("+param+")";
			Statement stmt = cnn.createStatement();
			rs = stmt.executeQuery(getNoteflowAmtSql);
			  while(rs.next()){
				  if(rs.getString(1)!=null && rs.getString(1)!=""){
				  amt = Integer.parseInt(rs.getString(1));
				  }
		          
		         }
			  if(!cnn.getAutoCommit()){
			cnn.commit();
			  }
			session.close();
		}catch( SQLException e ){
			logger.error("", e );
			try{cnn.rollback();
				cnn.close();
				session.close();}
			catch( SQLException ee ){
				logger.error("", ee );
			}

		}
		return amt;
	}
	
	private String getMaxId(String[] flowStage){
		Session session = this.getSessionFactory().openSession();
		Connection cnn = session.connection();
		String ids = "";
		ResultSet rs=null;
		String param = "";
		for(int i=0;i<flowStage.length;i++){
			if(i!=0){
				param += "','";
			}else {
				param +="'";
			}
			param +=flowStage[i];
			if(i==flowStage.length-1){
				param += "'";
			}
		}
		if("".equals(param)){
			return "";
		}
		try{
			String getNoteflowAmtSql = "select  max(cndi.C_ID)  from CML_NOTEFLOW_DETAIL_INFO cndi  where cndi.C_FLOW_STAGE in ( "+ param+" )  group by cndi.C_BARCODE1 , cndi.C_DATE";
			Statement stmt = cnn.createStatement();
			rs = stmt.executeQuery(getNoteflowAmtSql);
			
			  while(rs.next()){
		           ids = ids +"'"+ rs.getString(1) + "',";
		          
		         }
			  if(ids!=""){
				  ids = ids.substring(0, ids.length()-1);
			  }
			  if(!cnn.getAutoCommit()){
			cnn.commit();
			  }
			session.close();
		}catch( SQLException e ){
			logger.error("", e );
			try{cnn.rollback();
				cnn.close();
				session.close();}
			catch( SQLException ee ){
				logger.error("", ee );
			}

		}
		return ids;
	}
	
	
	public Integer getNoteflowAmt( String boxNum , String date){
		Session session = this.getSessionFactory().openSession();
		Connection cnn = session.connection();
		ResultSet rs=null;
		int amt = 0;
		try{
			String getNoteflowAmtSql = "select sum(cni.i_statis_amt) from cml_noteflow_info cni where cni.c_td_barcode_flownum in (select cndi.c_barcode_flownum from cml_noteflow_detail_info cndi where cndi.c_barcode1='"+boxNum+"' and cndi.c_date='"+date+"')";
			Statement stmt = cnn.createStatement();
			rs = stmt.executeQuery(getNoteflowAmtSql);
			  while(rs.next()){
				  if(rs.getString(1)!=null && rs.getString(1)!=""){
				  amt = Integer.parseInt(rs.getString(1));
				  }
		          
		         }
			  if(!cnn.getAutoCommit()){
			cnn.commit();
			  }
			session.close();
		}catch( SQLException e ){
			logger.error("", e );
			try{cnn.rollback();
				cnn.close();
				session.close();}
			catch( SQLException ee ){
				logger.error("", ee );
			}

		}
		return amt;
	}
	
	public String getNoteflowBarCodeFlowNums( String boxNum ,String date){
		Session session = this.getSessionFactory().openSession();
		Connection cnn = session.connection();
		String barCodeFlowNums = "";
		ResultSet rs=null;
		try{
			String getNoteflowAmtSql = "select cndi.c_barcode_flownum from cml_noteflow_detail_info cndi where cndi.c_barcode1='"+boxNum+"' and cndi.c_date='"+date+"'";
			Statement stmt = cnn.createStatement();
			rs = stmt.executeQuery(getNoteflowAmtSql);
			
			  while(rs.next()){
		           barCodeFlowNums = barCodeFlowNums + rs.getString(1) + ",";
		          
		         }
			  if(barCodeFlowNums!=""){
			  barCodeFlowNums = barCodeFlowNums.substring(0, barCodeFlowNums.length()-1);
			  }
			  if(!cnn.getAutoCommit()){
			cnn.commit();
			  }
			session.close();
		}catch( SQLException e ){
			logger.error("", e );
			try{cnn.rollback();
				cnn.close();
				session.close();}
			catch( SQLException ee ){
				logger.error("", ee );
			}

		}
		return barCodeFlowNums;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Page queryCmlNoteflowDetailInfoPageAndBoxInfo(Page page, Map condition)
	{
		String[] flowStage    = ArrayUtil.toStringArray((Object[])condition.get("flowStage"));
		String startTime      = (String)condition.get("startTime");
		String endTime        = (String)condition.get("endTime");
		String barcodeFlowNum = (String)condition.get("barcodeFlowNum");
		String cashboxNum     = (String)condition.get("cashboxNum");
		String atmNum         = (String)condition.get("atmNum");
		String operator       = (String)condition.get("operator");
		String pathCode       = (String)condition.get("pathCode");
		
		List<Object> parameterList = new ArrayList<Object>();
		
		String hql = 	//" select cnfd" +//,count(distinct cnfd.barcode1)
						" select new CmlNoteflowDetailInfoExt(" +
						" cnfd, " +
						" cnf.clearingDate" +
						" )" +
						" from CmlNoteflowDetailInfoExt cnfd" +
						" left outer join cnfd.cmlNoteflowInfo cnf" +
						" where 1=1";
		
		
		
		
		hql += " and cnfd.id in (select min(cc.id) from CmlNoteflowDetailInfoExt cc group by cc.barcode1, cc.flowStage)";
		
		// startTime
		if( StringUtils.isBlank(startTime) )
		{
			throw new IllegalArgumentException("startTime cannot be null.");
		}
		hql += "  and cnfd.date >= ?";
		parameterList.add(startTime.replace("-", "")+"000000");
		
		// endTime
		if( StringUtils.isBlank(endTime) )
		{
			throw new IllegalArgumentException("endTime cannot be null.");
		}
		hql += "  and cnfd.date <= ?";
		parameterList.add(endTime.replace("-", "")+"240000");
		
		// flowStage
		if( ArrayUtil.isBlank(flowStage)==false )
		{
			hql += " and cnfd.flowStage in ("+StringUtil.generateMultiPartString("?", flowStage.length, ", ")+")";
			CollectionsUtil.addAll(parameterList, flowStage);
		}
		
		// barcodeFlowNum
		if( StringUtils.isBlank(barcodeFlowNum)==false )
		{
			hql += " and cnf.tdBarcodeFlownum = ?";
			parameterList.add(barcodeFlowNum);
		}
		
		// cashboxNum
		if( StringUtils.isBlank(cashboxNum)==false )
		{
			hql += " and cnfd.barcode1 = ?";
			parameterList.add(cashboxNum);
		}
		
		// atmNum
		if( StringUtils.isBlank(atmNum)==false )
		{
			hql += " and cnfd.barcode2 = ?";
			parameterList.add(atmNum);
		}
		
		// operator
		if( StringUtils.isBlank(operator)==false )
		{
			hql += " and cnfd.operator = ?";
			parameterList.add(operator);
		}
		
		//pathCode
		if( StringUtils.isBlank(pathCode)==false )
		{
			hql += " and cnfd.pathCode like ?";
			parameterList.add(pathCode+"%");
		}

		//hql += " GROUP BY cnfd.barcode1";
		hql += " order by cnfd.date desc, cnfd.barcode1 asc, cnfd.barcode2 asc";
		
		Page page2 =  this.findPage(page, hql, parameterList.toArray());
		
		List<CmlNoteflowDetailInfoExt> infoLst = page2.getResult();

		for (int i=0;i<infoLst.size();i++) {
			CmlNoteflowDetailInfoExt info = infoLst.get(i);
			info.setStatisAmt(BigDecimal.valueOf(getNoteflowAmt(info.getBarcode1(),info.getDate())));
			info.setBarcodeFlowNum(getNoteflowBarCodeFlowNums(info.getBarcode1(),info.getDate()));
			
		}
		page2.setResult(infoLst);
		
		return page2;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Page queryOperDetailInfoPage(Page page, Map condition)
	{
		String flowStage      = (String)condition.get("flowStage");
		String startTime      = (String)condition.get("startTime");
		String endTime        = (String)condition.get("endTime");
		String barcodeFlowNum = (String)condition.get("barcodeFlowNum");
		String cardNum        = (String)condition.get("cardNum");
		//String followType     = (String)condition.get("followType");
		String pathCode       = (String)condition.get("pathCode");
		
		List<Object> parameterList = new ArrayList<Object>();
		
		String hql = 	" select new CmlNoteflowDetailInfo(" +
							" cnfd, " +
							" cnf.followType," +
							" cnf.termId," +
							" cnf.journalNo," +
							" cnf.clearingDate," +
							" cnf.totalNotes" +
							" )" +
						" from CmlNoteflowDetailInfo cnfd," +
						"      CmlNoteflowInfo cnf" +
						" where cnfd.barcodeFlowNum = cnf.barcodeFlowNum";
		
		// beginTime
		if( StringUtils.isBlank(startTime) )
		{
			throw new IllegalArgumentException("startTime cannot be null.");
		}
		hql += "  and cnfd.date >= ?";
		parameterList.add(startTime.replace("-", ""));
		
		// endTime
		if( StringUtils.isBlank(endTime) )
		{
			throw new IllegalArgumentException("endTime cannot be null.");
		}
		hql += "  and cnfd.date <= ?";
		parameterList.add(endTime.replace("-", "")+"240000");
		
		// flowStage
		if( StringUtils.isBlank(flowStage)==false )
		{
			hql += " and cnfd.flowStage = ?";
			parameterList.add(flowStage);
		}
		
		// barcodeFlowNum
		if( StringUtils.isBlank(barcodeFlowNum)==false )
		{
			hql += " and cnfd.barcodeFlowNum = ?";
			parameterList.add(barcodeFlowNum);
		}
		
		// cashboxNum
		if( StringUtils.isBlank(cardNum)==false )
		{
			hql += " and cnfd.barcode1 = ?";
			parameterList.add(cardNum);
		}
		
		// pathCode
		if( StringUtils.isBlank(pathCode)==false )
		{
			hql += " and cnfd.pathCode like ?";
			parameterList.add(pathCode+"%");
		}
		
		hql += " order by cnfd.date desc, cnfd.barcodeFlowNum desc";
		
		Page page2 =  this.findPage(page, hql, parameterList.toArray());
		return page2;
	}
	
	/**
	 * 
	 */
	public int updateDetailStatusByBarcodeFlowNum(String barcodeFlowNum, String status)
	{
		String hql = "update CmlNoteflowDetailInfo cnfd set cnfd.status=? where cnfd.barcodeFlowNum=?";
		return this.executeUpdate(hql, status, barcodeFlowNum);
	}
	
	/**
	 * 
	 */
	public CmlNoteflowDetailInfo getLatestNoteflowDetailByBarcodeFlowNum(String barcodeFlowNum)
	{
		String hql = 	" select cnfd from CmlNoteflowDetailInfo cnfd" +
						" where cnfd.barcodeFlowNum = ?" +
						" order by cnfd.date desc";
		return this.findFirst(hql, barcodeFlowNum);
	}
	
	
	/**
	 * 此方法可以用于查找当前某个钞箱是否已经装入atm，比如：
	 * barcode1填钞箱号
	 * type填1(钞箱号与ATM号绑定)
	 * status填0(未完成)
	 */
	public CmlNoteflowDetailInfo getDetailInfoByB1TS(String barcode1, String type, String status)
	{
		String hql = 	" select cnfd from CmlNoteflowDetailInfo cnfd" +
						" where cnfd.barcode1 = ?" +
						" and cnfd.type = ?" +
						" and cnfd.status = ?";
		return this.findFirst(hql, barcode1, type, status);
	}
	
}
