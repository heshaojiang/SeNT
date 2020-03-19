package com.grgbanking.cml.report.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.grgbanking.cml.report.entity.ReportCml;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;

import flex.messaging.io.ArrayList;
/**
 * 清分交易信息DAO层 继承公共的BaseDao层
 * @author 广电运通
 */
@Repository
public class ReportCmlDao extends BaseDao<ReportCml> {
	final int no3=3;
	final int no4=4;
	final int no5=5;
	final int no6=6;
	final int no7=7;
	final int no8=8;
	final int no9=9;
	final int no10=10;
	final int no11=11;
	final int no12=12;
	/**
	 * @param list 一个集合
	 * @param page 一个page实体
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
			// 为什么是beginRecordNumOfPage + pageSize而不是beginRecordNumOfPage +
			// pageSize - 1?
			// 请看List中subList说明：Returns a view of the portion of this list
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
	 *根据条件查询出所有的list
	 *@param tmlNum tmlNum
	 *@param operatorName operatorName
	 *@param startDate startDate
	 *@param endDate endDate
	 *@return  List<CmlTaskInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<ReportCml> getObjectList(String tmlNum,  String operatorName, String startDate, String endDate){
		// sql语句进行拼装
		StringBuffer sql = new StringBuffer(" select c.tmlNum,u.userName,c.bindStart,c.beforeCount,c.atmMoney,c.passMoney,c.stubbedMoney," +
				"c.shadinessMoney,c.trailMoney," +
		"c.falseCoinMoney ,c.totalMoney ,c.id, c.operatorId  from CmlTaskInfo c , User u where c.operatorId=u.userCode " );
		if (StringUtils.hasText(tmlNum)) {
			sql.append(" and  c.tmlNum like '%" + tmlNum.trim() + "%'");
		}
//		if (StringUtils.hasText(orgFloor)) {
//			sql.append("   and sourceOrg in (" + " select orgid from  OrgInfo where orgfloor like '%" + orgFloor + "%')");
//		}
		if (StringUtils.hasText(operatorName)) {
			sql.append("  and c.operatorId in (select  u.userCode  from User u  where  u.userName like '%" + operatorName.trim() + "%')");
		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(startDate)) {
			sql.append(" and c.operateDate >=to_date('" + startDate + "','yyyy-MM-dd ') ");

		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(endDate)) {
			sql.append(" and c.operateDate <=to_date('" + endDate + "','yyyy-MM-dd ') ");
		}
		sql.append(" order by c.taskNum desc");

	List<Object[]> ll =  super.find(sql.toString());
    List<ReportCml> result  = new ArrayList();
	for(Object[] obj : ll){
		ReportCml ad =new ReportCml();
		if(obj[0]!=null&&!"".equals(obj[0].toString())){
			ad.setTmlNum(obj[0].toString());
	  	}
		if(obj[1]!=null&&!"".equals(obj[1].toString())){
			ad.setVersion05((float)Integer.parseInt(obj[1].toString()));
		}
		if(obj[2]!=null&&!"".equals(obj[2].toString())){
			ad.setAtmMoney((float)Integer.parseInt(obj[2].toString()));
		
		}
		if(obj[no3]!=null&&!"".equals(obj[no3].toString())){
			ad.setBeforeCount((float)Integer.parseInt(obj[no3].toString()));
		}
		if(obj[no4]!=null&&!"".equals(obj[no4].toString())){
			ad.setAtmMoney((float)Integer.parseInt(obj[no4].toString()));
		}
		if(obj[no5]!=null&&!"".equals(obj[no5].toString())){
			ad.setPassMoney((float)Integer.parseInt(obj[no5].toString()));
		}
		if(obj[no6]!=null&&!"".equals(obj[no6].toString())){
			ad.setStubbedMoney((float)Integer.parseInt(obj[no6].toString()));
		}
		if(obj[no7]!=null&&!"".equals(obj[no7].toString())){
			ad.setShadinessMoney((float)Integer.parseInt(obj[no7].toString()));
		}
		if(obj[no8]!=null&&!"".equals(obj[no8].toString())){
			ad.setTrailMoney((float)Integer.parseInt(obj[no8].toString()));
		}
		if(obj[no9]!=null&&!"".equals(obj[no9].toString())){
			ad.setFalseCoinMoney((float)Integer.parseInt(obj[no9].toString()));
		}
		result.add(ad);
		}

	return result ;
	}
	/**
	 * @param   field  需要进行合计的字段
	 * @param   tmlNum tmlNum
	 * @param startDate startDate
	 * @param  endDate endDate
	 * @return  Object[]
	 */
	public Object[] getSUMList(String[] field, String tmlNum, String startDate, String endDate){
		// sql语句进行拼装
	
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select ");
		for (int i = 0; i < field.length; i++) {
			String temp = i == 0 ? "SUM(" + field[0] + ")" : " , SUM(" + field[i] + ")";
			sql.append(temp);
		}
		sql.append(" from CmlTaskInfo c ");

		if (StringUtils.hasText(tmlNum)) {
			sql.append(" and  c.tmlNum like '%" + tmlNum.trim() + "%'");
		}
//		if (StringUtils.hasText(orgFloor)) {
//			sql.append("   and sourceOrg in (" + " select orgid from  OrgInfo where orgfloor like '%" + orgFloor + "%')");
//		}
//		if (StringUtils.hasText(operatorName)) {
//			sql.append("  and c.operatorId in (select  u.userCode  from User u where u.userName like '%" + operatorName.trim() + "%')");
//		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(startDate)) {
			sql.append(" and c.bindStart >=to_date('" + startDate + "','yyyy-MM-dd ')");

		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(endDate)) {
			sql.append(" and c.bindStart <=to_date('" + endDate + "','yyyy-MM-dd ')");
		}
       
		Object[] result = null;
		
			result   = findUnique(sql.toString());

        	 
		 return result;

	
     

}
}
