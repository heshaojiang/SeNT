package com.grgbanking.sent.audit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.audit.entity.AuditInfo;
import com.grgbanking.sent.rule.dao.BlackRegulationDao;
import com.grgbanking.sent.rule.dao.RepeatRegulationDao;

/**
 * @author 广电运通
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Repository
public class AuditInfoDao extends BaseDao<AuditInfo> {
	@Autowired
	BlackRegulationDao blackRegulationDao;

	@Autowired
	RepeatRegulationDao repeatRegulationDao;

	/**
	 * @param list 一个集合
	 * @param page 一个page实体
	 * @return page
	 */

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
}
