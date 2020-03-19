package com.grgbanking.sent.stride.dao;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.sent.stride.entity.StrideBundleRef;
@Repository
public class StrideBundleRefDao extends BaseDao<StrideBundleRef> {

	public void saveStrideBundleRef(StrideBundleRef ref){
		save(ref);
	}
	
	public void batchSave(StrideBundleRef[] refs){
		for (int i = 0; i < refs.length; i++) {
			save(refs[i]);
		}
	}
}
