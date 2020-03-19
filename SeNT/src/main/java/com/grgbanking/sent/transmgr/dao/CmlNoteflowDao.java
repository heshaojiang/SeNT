package com.grgbanking.sent.transmgr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowDetailInfo;
/**
 * @author 骞跨數杩愰????
 * 
 */

	@Repository
	public class CmlNoteflowDao extends BaseDao<CmlNoteflowDetailInfo> {
		@Transactional(readOnly = true)
		public int addNoteflow(List<CmlNoteflowDetailInfo> cfs){
			CmlNoteflowDetailInfo cf = null ;
			int updateNum = 0 ;
			for(int i = 0 ; i < cfs.size() ; i ++){
				cf = new CmlNoteflowDetailInfo() ;
				cf = cfs.get(i) ;
				String bf = cf.getBarcodeFlowNum().trim() ;
				String sql = "update CmlNoteflowDetailInfo cf set cf.status='1' where cf.barcodeFlowNum='"+bf+"'" ;
				saveNew(cf) ;
				executeUpdate(sql) ;
				updateNum = i+1 ;
			}
			return updateNum ;
		}
}
