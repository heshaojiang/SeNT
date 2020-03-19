package com.grgbanking.sent.watch.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.watch.entity.TranAbnoinfo;

/**
 * 异常交易监控DAO层 继承公共的BaseDao层
 * 
 * @author 广电运通
 */
@Repository
public class TranAbnoinfoDao extends BaseDao<TranAbnoinfo>
{
	/**
	 * @param list
	 *            数据集合
	 * @param page
	 *            page实体
	 * @return page
	 */
	public Page<Object> getPageList(List<Object> list, Page<Object> page)
	{

		int recordCount = list.size();
		int pageNum = page.getPageNo();
		int pageSize = page.getPageSize();
		
		page.setTotalCount(list.size());
		
		if (recordCount > 0)
		{
			int beginRecordNumOfPage = (pageNum - 1) * pageSize;
			// 为什么是beginRecordNumOfPage + pageSize而不是beginRecordNumOfPage +
			// pageSize - 1?
			// 请看List中subList说明：Returns a view of the portion of this list
			// between the specified fromIndex, inclusive, and toIndex,
			// exclusive
			int endRecordNumOfPage = beginRecordNumOfPage + pageSize;
			if (endRecordNumOfPage >= recordCount)
			{
				endRecordNumOfPage = recordCount;
			}
			page.setResult(list.subList(beginRecordNumOfPage, endRecordNumOfPage));

		}
		return page;

	}
	
	
	public TranAbnoinfo getByTranId(String tranId)
	{
		String hql = "select ta from TranAbnoinfo ta where ta.tranId=?";
		return this.findFirst(hql, tranId);
	}
}
