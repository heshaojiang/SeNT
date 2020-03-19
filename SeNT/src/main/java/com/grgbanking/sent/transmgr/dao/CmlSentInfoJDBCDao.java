/**
 * 文件名：CmlSentInfoJDBCDao.java
 * 创建日期：2013-10-17
 * Copyright (c) 2011-2013 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间:
 *   修改内容：
 */
package com.grgbanking.sent.transmgr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.grgbanking.platform.core.dao.BaseJDBCDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.checkin.entity.CmlSentInfoStatisVO;
import com.grgbanking.sent.transmgr.entity.CmlSentInfo;

/**
 * 纸币冠字号码JDBC DAO
 * 
 * @author lwgang
 */
public abstract class CmlSentInfoJDBCDao extends BaseJDBCDao
{
	
	/**
	 * 
	 */
	protected void setFieldValue(ResultSet rs, CmlSentInfo cmlSentInfo) throws SQLException
	{
		cmlSentInfo.setId(rs.getString("I_ID"));
		cmlSentInfo.setTranId(rs.getString("C_TRAN_ID"));
		cmlSentInfo.setTermId(rs.getString("C_TERM_ID"));
		cmlSentInfo.setJournalNo(rs.getString("C_JOURNAL_NO"));
		cmlSentInfo.setImageType(rs.getString("C_IMAGE_TYPE"));
		cmlSentInfo.setSequence(rs.getInt("I_SEQUENCE"));
		//cmlSentInfo.setFileName(rs.getString("C_FILENAME"));
		cmlSentInfo.setBarcodeFlowNum(rs.getString("C_BARCODE_FLOWNUM"));
		cmlSentInfo.setNoteFlag(rs.getString("C_NOTE_FLAG"));
		cmlSentInfo.setNoteType(rs.getString("C_NOTE_TYPE"));
		cmlSentInfo.setCurrency(rs.getString("C_CURRENCY"));
		cmlSentInfo.setDenomination(rs.getString("C_DENOMINATION"));
		cmlSentInfo.setVersionNum(rs.getString("C_VERSION_NUM"));
		cmlSentInfo.setSeriaNo(rs.getString("C_SERIA_NO"));
		cmlSentInfo.setTranDate(rs.getString("C_TRAN_DATE"));
		cmlSentInfo.setTranMonthday(rs.getString("C_TRAN_MONTHDAY"));
		cmlSentInfo.setTermType(rs.getString("C_TERM_TYPE"));
		cmlSentInfo.setPathcode(rs.getString("C_PATHCODE"));
		cmlSentInfo.setMachinesno(rs.getString("C_MACHINESNO"));
		cmlSentInfo.setReserve(rs.getString("C_RESERVE"));
		cmlSentInfo.setMachineType(rs.getString("C_MACHINE_TYPE")) ;
		cmlSentInfo.setType(rs.getString("C_TYPE")) ;
		cmlSentInfo.setMoneyType(rs.getString("C_MONEY_TYPE")) ;
	}
	
	/**
	 * 查看冠字号数据分页
	 */
	public abstract List<CmlSentInfo> getCmlSentInfoList(Map<String, Object> condition);
	
	/**
	 * 查看冠字号数据分页
	 */
	public abstract Page<CmlSentInfo> getCmlSentInfoPage(Map<String, Object> parameter);
	
//	/**
//	 * 根据ID获取冠字号信息
//	 */
//	public abstract CmlSentInfo getCmlSentInfosByIdFromTable(Map<String, Object> parameter);
	
	/**
	 * 根据ID获取冠字号信息
	 */
	public abstract CmlSentInfo getCmlSentInfosByIdFromTable(String id, String fromTableName);
	
//	/**
//	 * 根据业务流转码获取冠字号分页
//	 */
//	public abstract Page<CmlSentInfo> getCmlSentInfosByBarcodeFlowNumFromTable(Map<String, Object> parameter);
//	
//	/**
//	 * 根据交易ID获取冠字号分页
//	 */
//	public abstract Page<CmlSentInfo> getCmlSentInfosByTranIdFromTable(Map<String, Object> parameter);
	
	/**
	 * 从today表和MMDD表中取数据
	 */
	public abstract Page<CmlSentInfo> getCmlSentInfoPageFromTodayAndMMDDTable(Map<String, Object> parameter);
	
	public abstract List<CmlSentInfo> getAllCmlSentInfoFromTodayAndMMDDTable(Map<String, Object> condition);
		
	/**
	 * 根据c_id修改c_image_type字段和c_file_name字段
	 */
	public abstract int updateImageInfo(CmlSentInfo cmlSentInfo);
	
	public abstract Page<CmlSentInfo> getCmlSentInfoForPage(Map<String, Object> parameter);

	/**
	 * 根据冠字号码和表名获得冠字号列表
	 * @return
	 */
	public abstract List<CmlSentInfo> getCmlSentInfosByNOAndTableName(String serialNO,
			String tableName) ;
	/**
	 * 根据交易ID和表名获得冠字号列表
	 * @return
	 */
	public abstract List<CmlSentInfo> getCmlSentInfosByTranIDAndTableName(String tranID,
			String tableName) ;
		
	
	/**
	 * 查看90天内同一冠字号的最新信息（人民币冠字号检索登记）
	 */
	public abstract CmlSentInfoStatisVO getCmlSentSearchInfoForVO(Map<String, Object> parameter);
	
}












