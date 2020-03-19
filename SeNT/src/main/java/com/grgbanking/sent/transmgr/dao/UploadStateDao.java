/**
 * 文件名：UploadStateDao.java
 * 创建日期： 2014-7-17
 * Copyright (c) 2014 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间：
 *   修改人：
 *   生成版本：
 *   修改内容：
 */
package com.grgbanking.sent.transmgr.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.transmgr.constants.UploadStateConsts;
import com.grgbanking.sent.transmgr.entity.CmlImprecords;
import com.grgbanking.sent.transmgr.entity.UploadStateDetailInfo;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;

/**
 * @author hjyi
 * 
 */
@SuppressWarnings("unchecked")
@Repository
public class UploadStateDao extends BaseDao<CmlImprecords> {

	/**
	 * 根据查询条件获取网点上传情况
	 * 
	 * @param condition
	 */
	public void getUploadStatePage(Page page, Map<String, Object> condition) {
		String startTime = (String) condition.get("startTime");
		String endTime = (String) condition.get("endTime");
		String pathCode = (String) condition.get("pathCode");
		String flag = (String) condition.get("flag");
		StringBuffer condiSql = new StringBuffer();
		condiSql.append(" C_OPERATER_DATE >= '"
				+ DateUtil.dateFormatTohms(startTime) + "'");
		condiSql.append(" and C_OPERATER_DATE <= '"
				+ DateUtil.dateFormatTohms(endTime) + "'");

		String sql = "";
		String totalSql = "";
		if (StringUtil.isNotBlank(pathCode)) {
			System.out.println(flag);
			if (null == flag || flag.equals("true")) {
				condiSql.append(" and C_PATHCODE like '" + pathCode + "%'");
				 sql = "SELECT C.C_TERM_ID,C.C_PATHCODE, SUM(C.COUNT1), SUM(C.COUNT2) FROM (select a.C_TERM_ID,a.C_PATHCODE,a.count1,b.count2 from ("
						+ "(SELECT C_TERM_ID,C_PATHCODE,count(C_TERM_ID) count1 FROM CML_IMP_RECORDS where C_OPERATE_STATUS != '"
						+ UploadStateConsts.UPLOAD_UNFINISH
						+ "' and "
						+ condiSql.toString()
						+ "group by C_TERM_ID,C_PATHCODE) a "
						+ "left join "
						+ "(SELECT C_TERM_ID,C_PATHCODE,count(C_TERM_ID) count2 FROM cml_imp_records where C_OPERATE_STATUS = '"
						+ UploadStateConsts.UPLOAD_UNFINISH
						+ "' and "
						+ condiSql.toString()
						+ "group by C_TERM_ID,C_PATHCODE) b "
						+ "on a.C_TERM_ID=b.C_TERM_ID)"
						+ "UNION SELECT TI.C_TERMCODE,OI.C_PATHCODE,0,0 FROM TML_INFO TI,ORG_INFO OI WHERE TI.C_ORGID=OI.C_ID AND OI.C_PATHCODE LIKE '"
						+ pathCode + "%') C GROUP BY C.C_TERM_ID,C.C_PATHCODE";
				 		totalSql = "select count(*) from (" + sql + ") c";
			} else {
				condiSql.append(" and C_PATHCODE  = '" + pathCode + "'");
				 sql = "SELECT C.C_TERM_ID,C.C_PATHCODE, SUM(C.COUNT1), SUM(C.COUNT2) FROM (select a.C_TERM_ID,a.C_PATHCODE,a.count1,b.count2 from ("
					+ "(SELECT C_TERM_ID,C_PATHCODE,count(C_TERM_ID) count1 FROM CML_IMP_RECORDS where C_OPERATE_STATUS != '"
					+ UploadStateConsts.UPLOAD_UNFINISH
					+ "' and "
					+ condiSql.toString()
					+ "group by C_TERM_ID,C_PATHCODE) a "
					+ "left join "
					+ "(SELECT C_TERM_ID,C_PATHCODE,count(C_TERM_ID) count2 FROM cml_imp_records where C_OPERATE_STATUS = '"
					+ UploadStateConsts.UPLOAD_UNFINISH
					+ "' and "
					+ condiSql.toString()
					+ "group by C_TERM_ID,C_PATHCODE) b "
					+ "on a.C_TERM_ID=b.C_TERM_ID)"
					+ "UNION SELECT TI.C_TERMCODE,OI.C_PATHCODE,0,0 FROM TML_INFO TI,ORG_INFO OI WHERE TI.C_ORGID=OI.C_ID AND OI.C_PATHCODE = '"
					+ pathCode + "') C GROUP BY C.C_TERM_ID,C.C_PATHCODE";
				 	totalSql = "select count(*) from (" + sql + ") c";
			}
		}
		
		SQLQuery totalQuery = this.getSession().createSQLQuery(totalSql);
		page.setTotalCount(Integer
				.parseInt(totalQuery.list().get(0).toString()));

		int beginRow = (page.getPageNo() - 1) * page.getPageSize();
		int endRow = page.getPageNo() * page.getPageSize();
		sql = getPageSql(sql, beginRow, endRow, page.getPageSize());
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);

		List<UploadStateDetailInfo> queryResult = new ArrayList<UploadStateDetailInfo>();
		List<Object[]> list = sqlQuery.list();
		for (Object[] objs : list) {
			String termId = (String) objs[0];
			if (termId == null || termId == "") // 设备号为空的记录不显示
				continue;

			UploadStateDetailInfo detail = new UploadStateDetailInfo();
			detail.setTermId(termId);
			detail.setOrgId((String) objs[1]);
			int totalCount = Integer.parseInt(objs[2].toString());
			int failureCount = objs[3] == null ? 0 : Integer.parseInt(objs[3]
					.toString());
			int successCount = totalCount - failureCount;
			detail.setSuccessCount(successCount);
			detail.setFailureCount(failureCount);
			queryResult.add(detail);
		}
		page.setResult(queryResult);
	}

	/**
	 * 根据分页获取结果集
	 * 
	 * @param sql
	 * @param begiRow
	 * @param endRow
	 * @return
	 */
	public String getPageSql(String sql, int begiRow, int endRow, int pageSize) {
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
			sqlStr.append(pageSize);
			return sqlStr.toString();
		}
	}

}
