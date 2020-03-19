package com.grgbanking.cml.report.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.cml.report.entity.CmlReport;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.param.dao.ParamDao;

/**
 * 
 */
@Repository
public class CmlReportDao extends BaseDao<CmlReport> {

	// ��1�1�77Ҫ�ϼƵ� �ֶ�
@Autowired
ParamDao paramDao;
	/**
	 * private float version05; private float version99; private float
	 * totalMoney; private float atmMoney; private float passMoney; private
	 * float stubbedMoney; private float shadinessMoney; private float
	 * trailMoney; private float falseCoinMoney;
	 * 
	 * */
	final int no3 = 3;
	final int no4 = 4;
	final int no5 = 5;
	final int no6 = 6;
	final int no7 = 7;
	final int no8 = 8;
	final int no9 = 9;
	final int no10 = 10;
	final int no11 = 11;
	final int no12 = 12;

	/**
	 * @param list
	 *            �A1�1�77������1�1�77
	 * @param page
	 *            �A1�1�77��pageʵ��
	 * @return page
	 */

	@SuppressWarnings("unchecked")
	public Page getPageList(List list, Page page) {
		int recordCount = list.size();
		int pageNum = page.getPageNo();
		int pageSize = page.getPageSize();
		page.setTotalCount(list.size());
		if (recordCount > 0) {
			int beginRecordNumOfPage = (pageNum - 1) * pageSize;
			// Ϊʲô��beginRecordNumOfPage + pageSize����beginRecordNumOfPage +
			// pageSize - 1?
			// �뿴List��subList˵����Returns a view of the portion of this list
			// between the specified fromIndex, inclusive, and toIndex,
			// exclusive
			int endRecordNumOfPage = beginRecordNumOfPage + pageSize;
			if (endRecordNumOfPage >= recordCount) {
				endRecordNumOfPage = recordCount;
			}
			page.setResult(list.subList(beginRecordNumOfPage,
					endRecordNumOfPage));

		}
		return page;

	}

	/**
	 *���������ѯ�����е�list
	 * 
	 * @param tmlNum
	 *            tmlNum
	 *@param operatorName
	 *            operatorName
	 *@param startDate
	 *            startDate
	 *@param endDate
	 *            endDate
	 *@return List<CmlTaskInfo>
	 */
	/*@SuppressWarnings("unchecked")
	public List<CmlReport> getObjectList(String tmlNum, String operatorName,
			String startDate, String endDate) {
		// sql������ƴװ
		StringBuffer sql = new StringBuffer(
				" select c.tmlNum,u.userName,c.bindStart,c.beforeCount,"
						+ "c.totalMoney  from CmlTaskInfo c , User u where c.operatorId=u.userCode ");
		if (StringUtils.hasText(tmlNum)) {
			sql.append(" and  c.tmlNum like '%" + tmlNum.trim() + "%'");
		}
		// if (StringUtils.hasText(orgFloor)) {
		// sql.append("   and sourceOrg in (" +
		// " select orgid from  OrgInfo where orgfloor like '%" + orgFloor +
		// "%')");
		// }
		if (StringUtils.hasText(operatorName)) {
			sql
					.append("  and c.operatorId in (select  u.userCode  from User u  where  u.userName like '%"
							+ operatorName.trim() + "%')");
		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(startDate)) {
			sql.append(" and c.operateDate >=to_date('" + startDate
					+ "','yyyy-MM-dd HH24:mi:ss') ");

		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(endDate)) {
			sql.append(" and c.operateDate <=to_date('" + endDate
					+ "','yyyy-MM-dd HH24:mi:ss') ");
		}
		sql.append(" order by c.taskNum desc");

		List<Object[]> ll = super.find(sql.toString());
		List<CmlReport> result = new ArrayList();
		for (Object[] obj : ll) {
			CmlReport ad = new CmlReport();
			if (obj[0] != null && !"".equals(obj[0].toString())) {
				ad.setTmlNum(obj[0].toString());
			}
			if (obj[1] != null && !"".equals(obj[1].toString())) {
				ad.setVersion05((float) Integer.parseInt(obj[1].toString()));
			}
			if (obj[2] != null && !"".equals(obj[2].toString())) {
				ad.setAtmMoney((float) Integer.parseInt(obj[2].toString()));

			}
			if (obj[no3] != null && !"".equals(obj[no3].toString())) {
				ad
						.setBeforeCount((float) Integer.parseInt(obj[no3]
								.toString()));
			}
			if (obj[no4] != null && !"".equals(obj[no4].toString())) {
				ad.setAtmMoney((float) Integer.parseInt(obj[no4].toString()));
			}
			if (obj[no5] != null && !"".equals(obj[no5].toString())) {
				ad.setPassMoney((float) Integer.parseInt(obj[no5].toString()));
			}
			if (obj[no6] != null && !"".equals(obj[no6].toString())) {
				ad.setStubbedMoney((float) Integer
						.parseInt(obj[no6].toString()));
			}
			if (obj[no7] != null && !"".equals(obj[no7].toString())) {
				ad.setShadinessMoney((float) Integer.parseInt(obj[no7]
						.toString()));
			}
			if (obj[no8] != null && !"".equals(obj[no8].toString())) {
				ad.setTrailMoney((float) Integer.parseInt(obj[no8].toString()));
			}
			if (obj[no9] != null && !"".equals(obj[no9].toString())) {
				ad.setFalseCoinMoney((float) Integer.parseInt(obj[no9]
						.toString()));
			}
			result.add(ad);
		}

		return result;
	}*/

//	/**
//	 * @param field
//	 *            ��1�1�77Ҫ���кϼƵ��ֶ�
//	 * @param tmlNum
//	 *            tmlNum
//	 * @param startDate
//	 *            startDate
//	 * @param endDate
//	 *            endDate
//	 * @return Object[]
//	 */
//	public Object[] getSUMList(String[] field, String tmlNum, String startDate, String endDate)
//	{
//
//		StringBuffer sql = new StringBuffer();
//
//		sql.append(" select ");
//		for( int i = 0 ; i < field.length ; i++ )
//		{
//			String temp = i == 0 ? "SUM(" + field[0] + ")" : " , SUM(" + field[i] + ")";
//			sql.append(temp);
//		}
//		sql.append(" from CmlTaskInfo c ");
//
//		if( StringUtils.hasText(tmlNum) )
//		{
//			sql.append(" and  c.tmlNum = '" + tmlNum.trim() + "'");
//		}
//		if( org.apache.commons.lang.StringUtils.isNotBlank(startDate) )
//		{
//			sql.append(" and c.bindStart >=to_date('" + startDate + "','yyyy-MM-dd HH24:mi:ss')");
//
//		}
//		if( org.apache.commons.lang.StringUtils.isNotBlank(endDate) )
//		{
//			sql.append(" and c.bindStart <=to_date('" + endDate + "','yyyy-MM-dd HH24:mi:ss')");
//		}
//
//		Object[] result = null;
//
//		result = findUnique(sql.toString());
//
//		return result;
//
//	}

	public String HqlByOperator(final String[] fieldCount, String operatorname,
			String startTime, String endTime) {
		StringBuffer hql = new StringBuffer();
		hql.append(" select  r.operatorId ");
		for (int i = 0; i < fieldCount.length; i++) {
			String temp = " ,SUM(" +"r."+ fieldCount[i] + ") ";
			hql.append(temp);
		}
		//hql.append(" from CmlReport r  where 1=1 ");
		hql.append(" from CmlTaskInfo r  where 1=1 ");
		if (org.apache.commons.lang.StringUtils.isNotBlank(operatorname)) {
//			hql
//					.append("  and  exists (Select 'X' from User u  where r.operatorId = u.userCode  and  u.userName like  '%"
//							+ operatorname + "%') ");
			hql.append(" and r.operatorId like '"+operatorname+"%'");
		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(startTime)) {
			hql.append(" and r.operateDate >=to_date('" + startTime
					+ "','yyyy-MM-dd HH24:mi:ss') ");
		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(endTime)) {
			hql.append(" and r.operateDate <=to_date('" + endTime
					+ "','yyyy-MM-dd HH24:mi:ss') ");
		}
		hql.append(" group by r.operatorId ");

		return hql.toString();

	}

	// ��݁{1�1�77 ���з�ҳ ��ѯͳ��
	public Page findPageByOperator(final String[] fieldCount, Page page,
			String operatorname, String startTime, String endTime) {
		
		
		return this.findPage(page, HqlByOperator(fieldCount, operatorname,
				startTime, endTime));

	}

	protected long countHqlResult(String hql, Object[] values) {
		int index = hql.indexOf(" from ");
		int end = hql.indexOf("group by");
		String sql = null;
		if (end != -1) {
			String temp = hql.substring(end + 8);
			sql = "select sum(count (distinct " + temp + "))  "
					+ hql.substring(index);
		} else {
			sql = " select count(*)  " + hql.substring(index);
		}
		long result = Long.parseLong(find(sql, values).get(0).toString());
		return result;
	}

	public List getListByOperator(final String[] fieldCount, String operatorname, String startTime, String endTime)
	{
		StringBuffer hql = new StringBuffer();
		hql.append(" select  r.operatorId ");
		for( int i = 0 ; i < fieldCount.length ; i++ )
		{
			String temp = " ,SUM(" + "r." + fieldCount[i] + ") ";
			hql.append(temp);
		}
		hql.append(" from CmlTaskInfo r  where 1=1 ");
		if( org.apache.commons.lang.StringUtils.isNotBlank(operatorname) )
		{
			hql.append(" and r.operatorId  like '" + operatorname + "%'");
		}
		if( org.apache.commons.lang.StringUtils.isNotBlank(startTime) )
		{
			hql.append(" and r.operateDate >=to_date('" + startTime + "','yyyy-MM-dd HH24:mi:ss') ");
		}
		if( org.apache.commons.lang.StringUtils.isNotBlank(endTime) )
		{
			hql.append(" and r.operateDate <=to_date('" + endTime + "','yyyy-MM-dd HH24:mi:ss') ");
		}
		hql.append(" group by r.operatorId ");
		List list = super.find(HqlByOperator(fieldCount, operatorname, startTime, endTime));
		return list;

	}
/**
 * ��ѯ�ն˱��
 * */
	public List getListByTml(final String[] fieldCount,
			String tmlNum, String startTime, String endTime) {
		StringBuffer hql = new StringBuffer();
   hql.append(" select  r.tmlNum ");
		for (int i = 0; i < fieldCount.length; i++) {
			String temp = " ,SUM(" +"r."+ fieldCount[i] + ") ";
			hql.append(temp);
		}
		//hql.append(" from CmlReport r  where 1=1 ");
		hql.append(" from CmlTaskInfo r  where 1=1 ");
		if (org.apache.commons.lang.StringUtils.isNotBlank(tmlNum)) {
//			hql
//					.append("  and  exists (Select 'X' from User u  where r.operatorId = u.userCode  and  u.userName like  '%"
//							+ operatorname + "%') ");
			hql.append(" and r.tmlNum like '"+tmlNum+"%'");
		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(startTime)) {
			hql.append(" and r.operateDate >=to_date('" + startTime
					+ "','yyyy-MM-dd HH24:mi:ss') ");
		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(endTime)) {
			hql.append(" and r.operateDate <=to_date('" + endTime
					+ "','yyyy-MM-dd HH24:mi:ss') ");
		}
		hql.append(" group by r.tmlNum ");
		List list=super.find(HqlByTml(fieldCount, tmlNum, startTime,
				endTime));
		return list;

	}
	/**
	 * ��ѯ�ն�
	 * */
	public String HqlByTml(final String[] fieldCount, String tmlNum,
			String startTime, String endTime) {
		StringBuffer hql = new StringBuffer();
		hql.append(" select  r.tmlNum");
		for (int i = 0; i < fieldCount.length; i++) {
			String temp = " ,SUM(" +"r."+ fieldCount[i] + ") ";
			hql.append(temp);
		}
		//hql.append(" from CmlReport r  where 1=1 ");
		hql.append(" from CmlTaskInfo r  where 1=1 ");
		if (org.apache.commons.lang.StringUtils.isNotBlank(tmlNum)) {
//			hql
//					.append("  and  exists (Select 'X' from User u  where r.operatorId = u.userCode  and  u.userName like  '%"
//							+ operatorname + "%') ");
			hql.append(" and r.tmlNum like '"+tmlNum+"%'");
		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(startTime)) {
			hql.append(" and r.operateDate >=to_date('" + startTime
					+ "','yyyy-MM-dd HH24:mi:ss') ");
		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(endTime)) {
			hql.append(" and r.operateDate <=to_date('" + endTime
					+ "','yyyy-MM-dd HH24:mi:ss') ");
		}
		hql.append(" group by r.tmlNum ");

		return hql.toString();

	}
}
