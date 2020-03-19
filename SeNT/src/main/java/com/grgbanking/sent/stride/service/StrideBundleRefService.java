package com.grgbanking.sent.stride.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.sent.stride.dao.StrideBundleRefDao;
import com.grgbanking.sent.stride.entity.StrideBundleRef;

@Service
@Transactional
public class StrideBundleRefService {

	@Autowired
	private StrideBundleRefDao strideBundleRefDao;
	
	public void save(StrideBundleRef ref){
		strideBundleRefDao.saveStrideBundleRef(ref);
	}
	
	public void batchSave(StrideBundleRef[] refs){
		strideBundleRefDao.batchSave(refs);
	}

}
