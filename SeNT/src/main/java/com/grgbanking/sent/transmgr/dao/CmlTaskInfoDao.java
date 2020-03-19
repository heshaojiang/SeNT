package com.grgbanking.sent.transmgr.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.transmgr.entity.CmlTaskInfo;
/**
 * ��ֽ�����ϢDAO�� �̳й�����BaseDao��
 * @author �����ͨ
 */
@Repository
public class CmlTaskInfoDao extends BaseDao<CmlTaskInfo> {
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
	 * @param list һ������
	 * @param page һ��pageʵ��
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

  
}
