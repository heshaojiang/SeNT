package com.grgbanking.cml.task.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.cml.task.entity.CmlSentInfos;
import com.grgbanking.platform.core.dao.BaseDao;


/**
 * CmlSentInfosDao 处理冠字号
 */
@Repository
@Transactional
public class CmlSentInfosDao extends BaseDao<CmlSentInfos> {

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean saveEntityCheck(CmlSentInfos obj){	
		try {
			saveNew(obj);
			return true;
		} catch (Exception e) {
			logger.info("导入失败");
			return false;
			// TODO: handle exception
		}
		
		
	}


      
   

 
	}
	
	
		
	


