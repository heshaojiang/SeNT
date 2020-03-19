package com.grgbanking.sent.checkin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.SysException;
import com.grgbanking.platform.core.utils.SqlUtil;
import com.grgbanking.sent.checkin.entity.SmsSerialDoubtRecord;
import com.grgbanking.sent.checkin.entity.SmsSerialStatis;
import com.grgbanking.sent.utils.StringUtil;

@Repository
public class SmsSerialDoubtRecordDao extends BaseDao<SmsSerialDoubtRecord> {

	public Page<SmsSerialDoubtRecord> queryFaultCheckInInfoPage(
			Page<SmsSerialDoubtRecord> page, Map<String, Object> condition)
			throws Exception {
		// String startTime = StringUtil.trim(condition.get("startTime"));
		// String endTime = StringUtil.trim(condition.get("endTime"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date realST = sdf.parse(StringUtil.trim(condition.get("startTime"))
				+ "000000");
		Date realET = sdf.parse(StringUtil.trim(condition.get("endTime"))
				+ "000000");
		//Date realST = new Date(startTime.getTime() - 24 * 60 * 60 * 1000);// 减一天！！
		//Date realET = new Date(endTime.getTime() - 24 * 60 * 60 * 1000);
		String pathCode = StringUtil.trim(condition.get("pathCode"));
		String registionType = StringUtil.trim(condition.get("registionType"));
		String seriaNO = StringUtil.trim(condition.get("querySeriaNo"));
		
		String hql = " select fici from SmsSerialDoubtRecord fici where 1=1";
		List<Object> parameterList = new ArrayList<Object>();

		// startTime
		if (realST != null && !"".equals(realST)) {
			hql += " and fici.applyDate >= ?";
			parameterList.add(realST);
		}
		// endTime
		if (realET != null && !"".equals(realET)) {
			hql += " and fici.applyDate <= ?";
			// parameterList.add(endTime + "240000");
			parameterList.add(realET);
		}
		// pathCode
		if (StringUtil.isNotBlank(pathCode)) {
			hql += " and fici.orgPathCode like ?";
			parameterList.add(pathCode + "%");
		}
		// registionType
		if (StringUtil.isNotBlank(registionType)) {
			hql += " and fici.registionType = ?";
			parameterList.add(Integer.parseInt(registionType));
		}
		// seriaNO
		if (StringUtil.isNotBlank(seriaNO)) {
			hql += " and fici.seriaNO like ?";
			parameterList.add(seriaNO + "%");
		}
		
		hql += " order by fici.applyDate desc";

		return this.findPage(page, hql, parameterList.toArray());
	}

	public Page querySerialStatisPage2(Page page, Map<String, Object> condition)
			throws Exception {
		// String startTime = StringUtil.trim(condition.get("startTime"));
		// String endTime = StringUtil.trim(condition.get("endTime"));

		// String hql = " select fici from SmsSerialDoubtRecord fici where 1=1";
		/*
		 * String hql =
		 * "SELECT  tmp1.orgName sOrgName, tmp1.serialResult sSerialResult, " +
		 * "tmp2.sumNum sQueryCount, tmp1.countNum sHasPaid1, " +
		 * "(tmp2.sumNum-tmp1.countNum) sHasPaid2 FROM ( SELECT s1.id, " +
		 * "s1.orgName,s1.serialResult,tmp.countNum,s1.applyDate,s1.orgPathCode FROM SmsSerialDoubtRecord s1, "
		 * +
		 * "( SELECT MIN(s2.id) minID,COUNT(s2.id) countNum FROM SmsSerialDoubtRecord s2 "
		 * +
		 * "GROUP BY s2.orgName, s2.serialResult ) tmp WHERE s1.id=tmp.minID ) tmp1, "
		 * +
		 * "( SELECT MIN(s2.id) minID,COUNT(s2.id) sumNum FROM SmsSerialDoubtRecord s2 "
		 * + "GROUP BY s2.orgName ) tmp2 WHERE tmp1.id=tmp2.minID ";
		 */
		/*
		 * String hql =
		 * "SELECT  tmp1.s1ORGNAME sOrgName, tmp1.s1SERAILRESULT sSerialResult, "
		 * +
		 * "tmp2.sumNum sQueryCount, tmp1.TMPCOUNTNUM hasPaid1, (tmp2.sumNum-tmp1.TMPCOUNTNUM) "
		 * +
		 * "hasPaid1 FROM ( SELECT s1.C_ID s1CID,s1.C_ORG_NAME s1ORGNAME,s1.I_SERIAL_RESULT s1SERAILRESULT,tmp.countNum TMPCOUNTNUM FROM "
		 * +
		 * "sms_serial_doubt_record s1,( SELECT MIN(s2.C_ID) minID,COUNT(s2.C_ID) countNum"
		 * +
		 * " FROM sms_serial_doubt_record s2 GROUP BY s2.C_ORG_NAME, s2.I_SERIAL_RESULT ) tmp "
		 * +
		 * "WHERE s1.C_ID=tmp.minID ) tmp1,( SELECT MIN(s2.C_ID) minID,COUNT(s2.C_ID) sumNum "
		 * +
		 * "FROM sms_serial_doubt_record s2 GROUP BY s2.C_ORG_NAME ) tmp2 WHERE "
		 * + "tmp1.s1CID=tmp2.minID ";
		 */
		//List<Object> parameterList = new ArrayList<Object>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//		Date realST = sdf.parse(StringUtil.trim(condition.get("startTime"))
//				+ "000000");
//		Date realET = sdf.parse(StringUtil.trim(condition.get("endTime"))
//				+ "000000");
//		String start = StringUtil.trim(condition.get("startTime"));
//		String end = StringUtil.trim(condition.get("endTime"));
		
		/*String pathCode = StringUtil.trim(condition.get("pathCode"));
		// startTime
		if (start != null && !"".equals(start)) {
			sql += " and tmp1.s1APPLYDATE >= '"+start+"'";
			//parameterList.add(realST);
		}
		// endTime
		if (end != null && !"".equals(end)) {
			sql += " and tmp1.s1APPLYDATE <= '"+end+"'"; 
			//parameterList.add(endTime + "240000");
			//parameterList.add(realET);
		}
		// pathCode
		if (StringUtil.isNotBlank(pathCode)) {
			sql += " and tmp1.s1PATHCODE like '"+pathCode+"%'";
			//parameterList.add(pathCode + "%");
		}
		//sql += " order by tmp1.s1APPLYDATE desc";*/

		String start = StringUtil.trim(condition.get("startTime"));
		String end = StringUtil.trim(condition.get("endTime"));
		String pathCode = StringUtil.trim(condition.get("pathCode"));
		String commCondition = "";
		// startTime
		if (start != null && !"".equals(start)) {
			String startSql = SqlUtil.sqlStrToDate(start, "yyyy-MM-dd");
			commCondition += " where s2.D_APPLY_DATE >= "+startSql;
			//parameterList.add(realST);
		}
		// endTime
		if (end != null && !"".equals(end)) {
			String endSql = SqlUtil.sqlStrToDate(end, "yyyy-MM-dd");
			commCondition += " and s2.D_APPLY_DATE <= "+endSql; 
			//parameterList.add(endTime + "240000");
			//parameterList.add(realET);
		}
		// pathCode
		if (StringUtil.isNotBlank(pathCode)) {
			commCondition += " and s2.C_ORG_PATHCODE like '"+pathCode+"%'";
			//parameterList.add(pathCode + "%");
		}
		

		String sql = "SELECT  tmp1.s1ORGNAME sOrgName, tmp1.s1SERAILRESULT sSerialResult, "
				+ "tmp2.sumNum sQueryCount, tmp1.TMPCOUNTNUM hasPaid1, (tmp2.sumNum-tmp1.TMPCOUNTNUM) "
				+ "hasPaid2 FROM ( SELECT s1.C_ID s1CID,s1.C_ORG_NAME s1ORGNAME,s1.I_SERIAL_RESULT s1SERAILRESULT," 
				+ " s1.D_APPLY_DATE s1APPLYDATE, s1.C_ORG_PATHCODE s1PATHCODE, tmp.countNum TMPCOUNTNUM FROM "
				+ "sms_serial_doubt_record s1,( SELECT MIN(s2.C_ID) minID,COUNT(s2.C_ID) countNum"
				+ " FROM sms_serial_doubt_record s2 " + commCondition
				+ "GROUP BY s2.C_ORG_NAME, s2.I_SERIAL_RESULT ) tmp "
				+ "WHERE s1.C_ID=tmp.minID ) tmp1,( SELECT MIN(s2.C_ID) minID,COUNT(s2.C_ID) sumNum "
				+ "FROM sms_serial_doubt_record s2 " + commCondition
				+ "GROUP BY s2.C_ORG_NAME ) tmp2 WHERE tmp1.s1CID=tmp2.minID ";

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection cnn = null;
		ArrayList<SmsSerialStatis> smsLst = new ArrayList<SmsSerialStatis>();
		try {
			Session session = this.getSessionFactory().openSession();
			cnn = session.connection();
			ps = cnn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				SmsSerialStatis smsStatis = new SmsSerialStatis();
				smsStatis.setsOrgName(rs.getString("sOrgName"));
				//smsStatis.setsSerialResult(rs.getInt("sSerialResult"));				
				smsStatis.setsQueryCount(rs.getInt("sQueryCount"));
				int srInt = rs.getInt("sSerialResult");
				if(srInt==1){
					smsStatis.setHasPaid1(rs.getInt("hasPaid1"));//已付出假币数
					smsStatis.setHasPaid2(rs.getInt("hasPaid2"));//未付出假币数
				}else{
					smsStatis.setHasPaid1(rs.getInt("hasPaid2"));//已付出假币数
					smsStatis.setHasPaid2(rs.getInt("hasPaid1"));//未付出假币数
				}

				smsLst.add(smsStatis);
			}
		} catch (Exception e1) {
			throw new SysException(e1);
		} finally {
			rs.close();
			ps.close();
			cnn.close();
		}

		page.setResult(smsLst);
		return page;
	}

	public Page querySerialStatisPage(Page page, Map<String, Object> condition)
			throws Exception {

		String start = StringUtil.trim(condition.get("startTime"));
		String end = StringUtil.trim(condition.get("endTime"));
		String pathCode = StringUtil.trim(condition.get("pathCode"));
		String commCondition = "";
		// startTime
		if (start != null && !"".equals(start)) {
			String startSql = SqlUtil.sqlStrToDate(start, "yyyy-MM-dd");
			commCondition += " where s2.D_APPLY_DATE >= "+startSql;
			//parameterList.add(realST);
		}
		// endTime
		if (end != null && !"".equals(end)) {
			String endSql = SqlUtil.sqlStrToDate(end, "yyyy-MM-dd");
			commCondition += " and s2.D_APPLY_DATE <= "+endSql; 
			//parameterList.add(endTime + "240000");
			//parameterList.add(realET);
		}
		// pathCode
		if (StringUtil.isNotBlank(pathCode)) {
			commCondition += " and s2.C_ORG_PATHCODE like '"+pathCode+"%' ";
			//parameterList.add(pathCode + "%");
		}	

		String sql = "SELECT tmp1.s1ORGNAME, tmp1.s1SERAILRESULT, "
				+ "tmp2.sumNum, tmp1.TMPCOUNTNUM, (tmp2.sumNum-tmp1.TMPCOUNTNUM) "
				+ "FROM (SELECT s1.C_ID s1CID, s1.C_ORG_NAME s1ORGNAME, s1.I_SERIAL_RESULT s1SERAILRESULT, " 
				+ "s1.D_APPLY_DATE s1APPLYDATE, s1.C_ORG_PATHCODE s1PATHCODE, tmp.countNum TMPCOUNTNUM FROM "
				+ "sms_serial_doubt_record s1, (SELECT MIN(s2.C_ID) minID, COUNT(s2.C_ID) countNum "
				+ "FROM sms_serial_doubt_record s2 " + commCondition
				+ "GROUP BY s2.C_ORG_NAME, s2.I_SERIAL_RESULT) tmp "
				+ "WHERE s1.C_ID=tmp.minID) tmp1,(SELECT MIN(s2.C_ID) minID, COUNT(s2.C_ID) sumNum "
				+ "FROM sms_serial_doubt_record s2 " + commCondition
				+ "GROUP BY s2.C_ORG_NAME) tmp2 WHERE tmp1.s1CID=tmp2.minID";

//		String totalSql = "select count(*) from ("+sql+") tmp";
//		SQLQuery totalQuery = this.getSession().createSQLQuery(totalSql);
//		page.setTotalCount(Integer.parseInt(totalQuery.list().get(0).toString()));
		
		//int beginRow=(page.getPageNo() - 1) * page.getPageSize();
		//int endRow=page.getPageNo()* page.getPageSize();
		//sql = getPageSql(sql, beginRow, endRow);
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
		
		List<SmsSerialStatis> smsLst = new ArrayList<SmsSerialStatis>();
		List<Object[]> list = sqlQuery.list();
		for( Object[] objs : list )
		{
			SmsSerialStatis smsStatis = new SmsSerialStatis();
			smsStatis.setsOrgName((String)objs[0]);
			//smsStatis.setsSerialResult(((BigDecimal)objs[1]).intValue());
			//java.math.BigInteger cannot be cast to java.math.BigDecimal
			smsStatis.setsQueryCount(Integer.parseInt(objs[2].toString()));
			int srInt = Integer.parseInt(objs[1].toString());
			if(srInt==1){
				smsStatis.setHasPaid1(Integer.parseInt(objs[3].toString()));//已付出假币数
				smsStatis.setHasPaid2(Integer.parseInt(objs[4].toString()));//未付出假币数
			}else{
				smsStatis.setHasPaid1(Integer.parseInt(objs[4].toString()));//已付出假币数
				smsStatis.setHasPaid2(Integer.parseInt(objs[3].toString()));//未付出假币数
			}
			
			smsLst.add(smsStatis);
		}
		page.setResult(smsLst);
		return page;
	}

	/**
	 * 根据分页获取结果集
	 * 
	 * @param sql
	 * @param begiRow
	 * @param endRow
	 * @return
	 */
	public String getPageSql(String sql, int begiRow, int endRow) {
		StringBuilder sqlStr = new StringBuilder(" ");
		if (DBDialectHelper.isOracle()) {
			sqlStr.append(" SELECT * FROM (SELECT r.*, ROWNUM rn FROM ( ");
			sqlStr.append(sql);
			sqlStr.append(" ) r WHERE ROWNUM <= ");
			sqlStr.append(endRow);
			sqlStr.append(" ) WHERE rn > ");
			sqlStr.append(begiRow);

			return sqlStr.toString();
		} else {
			sqlStr.append(sql);
			sqlStr.append(" limit ");
			sqlStr.append(begiRow);
			sqlStr.append(",");
			sqlStr.append(endRow);
			return sqlStr.toString();
		}
	}
	
	/**
	 * 通过冠字号码查询对应的涉假信息
	 * 
	 * @param seriaNO 冠字号码
	 * @return
	 */
	public SmsSerialDoubtRecord queryByseriaNO(String seriaNO){
		List<SmsSerialDoubtRecord> result = this.find("from SmsSerialDoubtRecord where seriaNO = '" + seriaNO + "'");
		if(result != null && result.size() > 0)
			return result.get(0);
		return null;
	}
	
	/**
	 * 通过冠字号码查询对应的所有涉假信息
	 * @param seriaNO
	 * @return
	 */
	public List<SmsSerialDoubtRecord> queryListByseriaNO(String seriaNO){
		List<SmsSerialDoubtRecord> result = this.find("from SmsSerialDoubtRecord where seriaNO = '" + seriaNO + "'");
		return result;
	}
	
	public SmsSerialDoubtRecord queryAgainByseriaNO(String seriaNO){
		List<SmsSerialDoubtRecord> result = this.find("from SmsSerialDoubtRecord where seriaNO = '" + seriaNO + "' and registionType = '1'");
		if(result != null && result.size() > 0)
			return result.get(0);
		return null;
	}
}
