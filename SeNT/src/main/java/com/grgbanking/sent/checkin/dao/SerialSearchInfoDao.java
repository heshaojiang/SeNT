package com.grgbanking.sent.checkin.dao;
/**
 * @author whxing
 * 人民币冠字号码检索登记Dao
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.checkin.entity.SerialSearchInfo;
import com.grgbanking.sent.utils.StringUtil;

@Repository
public class SerialSearchInfoDao extends BaseDao<SerialSearchInfo>{
	
	public Page<SerialSearchInfo> querySerialSearchInfoPage(
			Page<SerialSearchInfo> page, Map<String, Object> condition)
			throws Exception 
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				Date realST = sdf.parse(StringUtil.trim(condition.get("startTime"))
						+ "000000");
				Date realET = sdf.parse(StringUtil.trim(condition.get("endTime"))
						+ "000000");
				String serialNo = StringUtil.trim(condition.get("serialNo"));
				String hql = " select fici from SerialSearchInfo fici where 1=1";
				List<Object> parameterList = new ArrayList<Object>();
		
				// startTime
				if (realST != null && !"".equals(realST)) {
					hql += " and fici.searchDate >= ?";
					parameterList.add(realST);
				}
				// endTime
				if (realET != null && !"".equals(realET)) {
					hql += " and fici.searchDate <= ?";
					// parameterList.add(endTime + "240000");
					parameterList.add(realET);
				}
				// pathCode
				if (StringUtil.isNotBlank(serialNo)) {
					hql += " and fici.serialNo like ?";
					parameterList.add(serialNo);
				}
				hql += " order by fici.searchDate desc";
		
				return this.findPage(page, hql, parameterList.toArray());
			}

}
