/**
 * 文件名：CmlStrideImportRecordsDao.java
 * 创建日期： 2014-05-12
 * Copyright (c) 2011-2013 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.sent.stride.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.stride.entity.StrideImportRecords;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;


/**
 * 实体信息Dao<br>
 * 
 * CmlStrideImportRecordsDao
 * 
 * @author  code auto generated
 * 
 */
@Repository
public class StrideImportRecordsDao extends BaseDao<StrideImportRecords> {
	
	@Autowired
	private JdbcTemplate jt;
	/**
	 * 根据实体属性查询实体信息
	 * 
	 * @param fieldName 属性名称
	 * @param value 参数值
	 * @return
	 */
	public StrideImportRecords getByField(String fieldName, String value) {
		return super.findUniqueBy(fieldName, value);
	}
	
	/**
	 * 根据参数查找分页的实体数据
	 * 
	 * @param page
	 * @param params
	 * @return
	 */
	public Page<StrideImportRecords> getStrideImportRecordsPage(Page<StrideImportRecords> page,
			Map<String, String> params,String start,String end){
		StringBuffer sql = new StringBuffer(" FROM CML_STRIDE_IMPORT_RECORDS R,ORG_INFO I WHERE R.C_PATHCODE=I.C_PATHCODE ");
		sql.append("AND R.C_PARENT_ID='0' AND I.C_ID=? AND R.C_UPLOAD_TIME>=? AND R.C_UPLOAD_TIME<? ");
		
		return this.paginationHelper.fetchPage("SELECT COUNT(1) "+sql.toString(), "SELECT R.*,I.C_ORGNAME,I.C_ID AS ORG_ID "+sql.toString()+" ORDER BY C_UPLOAD_TIME DESC", new Object[]{params.get("orgId"),start,end}, page.getPageNo(), page.getPageSize(), new ParameterizedRowMapper<StrideImportRecords>() {
			@Override
			public StrideImportRecords mapRow(ResultSet rs, int arg1)
					throws SQLException {
				StrideImportRecords vo = new StrideImportRecords();
				vo.setId(rs.getString("C_ID"));
				vo.setBagCode(StringUtil.isBlank(rs.getString("C_BAG_CODE"))?"---":rs.getString("C_BAG_CODE"));
				vo.setBagCount(rs.getInt("I_BAG_COUNT"));
				vo.setFileName(rs.getString("C_FILE_NAME"));
				vo.setOperaterId(rs.getString("C_OPERATER_ID"));
				vo.setOperateStatus(getStatus(rs.getString("C_OPERATE_STATUS")));
				vo.setFsnCount(rs.getInt("I_FSN_COUNT"));
				vo.setOrgName(rs.getString("C_ORGNAME"));
				vo.setParentId(rs.getString("C_PARENT_ID"));
				vo.setUploadTime(DateUtil.getTimeString(rs.getString("C_UPLOAD_TIME")));
				vo.setPathcode(rs.getString("C_PATHCODE")) ;
				/////////////////////////////////////////////////////////
//				vo.setId(rs.getString("C_ID"));
//				vo.setBagCode(StringUtil.isBlank(rs.getString("C_BAG_CODE"))?"---":rs.getString("C_BAG_CODE"));
//				vo.setBagCount(rs.getInt("I_BAG_COUNT"));
//				vo.setFileName(rs.getString("C_FILE_NAME"));
//				vo.setOperaterId(rs.getString("C_OPERATER_ID"));
//				vo.setOperateStatus(getStatus(rs.getString("C_OPERATE_STATUS")));
//				vo.setFsnCount(rs.getInt("I_FSN_COUNT"));
//				vo.setParentId(rs.getString("C_PARENT_ID"));
//				vo.setUploadTime(DateUtil.getTimeString(rs.getString("C_UPLOAD_TIME")));
//				vo.setBankCode(rs.getString("C_BANK_CODE"));
//				vo.setFromCode(rs.getString("C_FROM_CODE"));
//				vo.setParentId(rs.getString("C_PARENT_ID")) ;
//				vo.setPartMonthday(rs.getString("C_PART_MONTHDAY")) ;
//				vo.setPathcode(rs.getString("C_PATHCODE")) ;
				//////////////////////////////////////////////////////////
				return vo;
			}
		});
	}
	
	private static String getStatus(String status){
		if(StringUtil.isBlank(status)) return "--";
		char key = status.trim().charAt(0);
		switch (key) {
		case '0':
			return "导出";
		case '1':
			return "导入";
		case '2':
			return "已打包";
		case '3':
			return "已下载";
		default:
			return "--";
		}
	}
	
	public List<StrideImportRecords> getStrideImportRecordsByRecordsJt(List<StrideImportRecords> records){
		if(records==null || records.isEmpty())return new ArrayList<StrideImportRecords>();
		StringBuffer sb = new StringBuffer();
		for (Iterator<StrideImportRecords> iterator = records.iterator(); iterator.hasNext();) {
			StrideImportRecords re = iterator.next();
			sb.append("'").append(re.getId()).append("'").append(",");
		}
		return paginationHelper.findListByJdbcTemplate("SELECT I.*,T.C_BANK_CODE,T.C_FROM_CODE FROM CML_STRIDE_IMPORT_RECORDS I,CML_STRIDE_TRANSFER_RECORD T  WHERE I.C_BAG_CODE=T.C_BAG_CODE AND I.C_PARENT_ID IN ("+sb.substring(0, sb.length()-1)+")", 
				new ParameterizedRowMapper<StrideImportRecords>(){
			@Override
			public StrideImportRecords mapRow(ResultSet rs, int arg1)
					throws SQLException {
				StrideImportRecords vo = new StrideImportRecords();
				vo.setId(rs.getString("C_ID"));
				vo.setBagCode(rs.getString("C_BAG_CODE"));
				vo.setBagCount(rs.getInt("I_BAG_COUNT"));
				vo.setFileName(rs.getString("C_FILE_NAME"));
				vo.setOperaterId(rs.getString("C_OPERATER_ID"));
				vo.setOperateStatus(getStatus(rs.getString("C_OPERATE_STATUS")));
				vo.setFsnCount(rs.getInt("I_FSN_COUNT"));
				vo.setParentId(rs.getString("C_PARENT_ID"));
				vo.setUploadTime(DateUtil.getTimeString(rs.getString("C_UPLOAD_TIME")));
//				vo.setBankCode(rs.getString("C_BANK_CODE"));
//				vo.setFromCode(rs.getString("C_FROM_CODE"));
//				vo.setParentId(rs.getString("C_PARENT_ID")) ;
//				vo.setPartMonthday(rs.getString("C_PART_MONTHDAY")) ;
				vo.setPathcode(rs.getString("C_PATHCODE")) ;
				return vo;
			}
		});
	}
	
	/**
	 * @param ids
	 * @return
	 */
	public List<StrideImportRecords> getStrideImportRecordsByRecords(List<StrideImportRecords> records) {
		if(records==null || records.isEmpty())return new ArrayList<StrideImportRecords>();
		StringBuffer sb = new StringBuffer();
		for (Iterator<StrideImportRecords> iterator = records.iterator(); iterator.hasNext();) {
			StrideImportRecords re = iterator.next();
			sb.append("'").append(re.getId()).append("'").append(",");
		}
		return super.find("from StrideImportRecords tb where tb.parentId in(?)", sb.substring(0, sb.length()-1));
	}
	
	/**
	 * @param ids
	 * @return
	 */
	public List<StrideImportRecords> getStrideImportRecordsByIds(List<String> ids) {
		if(ids==null || ids.isEmpty())return new ArrayList<StrideImportRecords>();
		StringBuffer sb = new StringBuffer();
		for (Iterator<String> iterator = ids.iterator(); iterator.hasNext();) {
			String id = iterator.next();
			sb.append("'").append(id).append("'").append(",");
		}
		return super.find("from StrideImportRecords tb where tb.parentId in(?)", sb.substring(0, sb.length()-1));
	}
	
	/**
	 * 根据参数查找分页的实体数据
	 * 
	 * @param page
	 * @param params
	 * @return
	 */
	public Page<StrideImportRecords> getCmlStrideImportRecordsPageByParams(Page<StrideImportRecords> page,
			Map<String, String> params) {
		params.remove("orgId");
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(" from StrideImportRecords tb ");
		if (params != null) {
			hql.append(WHERE);
			for (String key : params.keySet()) {
				if (params.get(key) == null) {
					continue;
				}
				//请按实际需要修改查询条件
				String paramValue = params.get(key);
				if (!paramValue.equals("")) {
					hql.append(" tb."+key+" like :"+paramValue+" and ");
					param.put("key", "%" + paramValue + "%");
				}
			}
			if (hql.toString().endsWith(WHERE)) {
				hql.delete(hql.length() - WHERE.length(), hql.length());
			} else {
				hql.delete(hql.length() - 4, hql.length());
			}
		}
		return super.findPage(page, hql.toString(), param);
	}
	
	@SuppressWarnings("unchecked")
	public List<String[]> getFsnsDirByBundles(final String[] bundles){
		/*if(bundles==null || bundles.length==0)return new ArrayList<String[]>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bundles.length; i++) {
			sb.append("'").append(bundles[i]).append("'").append(",");
		}
		String sql = "SELECT C_OPERATER_DATE,C_FILE_NAME,C_TRAN_DATE,C_TERM_ID FROM CML_IMP_RECORDS WHERE C_ID IN (SELECT C_ID FROM CML_NOTEFLOW_INFO WHERE C_TD_BARCODE_FLOWNUM IN ("+sb.substring(0, sb.length()-1)+"))";
		return jt.query(sql,new RowMapper() {
			@Override
			public String[] mapRow(final ResultSet rs, final int arg1) throws SQLException {
				String[] str = new String[5];
				str[0] = rs.getString("C_OPERATER_DATE");
				str[1] = rs.getString("C_FILE_NAME");
				str[2] = bundles[arg1];
				str[3] = rs.getString("C_TRAN_DATE");
				str[4] = rs.getString("C_TERM_ID");
				return str;
			}
		});*/
		
		List<String[]> dirLst = new ArrayList<String[]>();
		if(bundles==null || bundles.length==0)
			return dirLst;
		for(final String flowNum:bundles){
			String singlesql = "SELECT C_OPERATER_DATE,C_FILE_NAME,C_TRAN_DATE,C_TERM_ID FROM CML_IMP_RECORDS WHERE C_ID IN (SELECT C_ID FROM CML_NOTEFLOW_INFO WHERE C_TD_BARCODE_FLOWNUM = '" + flowNum + "')";
			
			List<Object> strArrLst = jt.query(singlesql,new RowMapper() {
				@Override
				public String[] mapRow(final ResultSet rs, final int arg1) throws SQLException {
					String[] str = new String[5];
					str[0] = rs.getString("C_OPERATER_DATE");
					str[1] = rs.getString("C_FILE_NAME");
					str[2] = flowNum;
					str[3] = rs.getString("C_TRAN_DATE");
					str[4] = rs.getString("C_TERM_ID");
					return str;
				}
			});
			
			if(strArrLst.size()>0){
				dirLst.add((String[]) strArrLst.get(0));
			}
		}		
		return dirLst;
	}
	
	
	
}
