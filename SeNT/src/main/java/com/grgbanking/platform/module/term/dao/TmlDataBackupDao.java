package com.grgbanking.platform.module.term.dao;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.term.entity.TmlDataBackup;

/**
 * @file com.grgbanking.platform.module.term.dao.TmlDataBackupDao.java
 * @Description: 
 * @version 1.0
 * @author Norman_chang
 * @since 2014-6-18 上午09:59:50
*/
@Repository
public class TmlDataBackupDao extends BaseDao<TmlDataBackup> {

	private static final String QUERY_ALL = " from TmlDataBackup tt order by tt.createDate asc ";
	private static final String QUERY_BY_PATH = " from TmlDataBackup tt where tt.path like ? order by tt.createDate asc ";
	
	public Page<TmlDataBackup> getList(Page<TmlDataBackup> page) {
		return super.findPage(page, QUERY_ALL);
	}
	
	public Page<TmlDataBackup> getByPath(Page<TmlDataBackup> page, String path) {
		if (path == null || path.trim().length() == 0)
			return super.findPage(page, QUERY_ALL);
		return super.findPage(page, QUERY_BY_PATH, path);
	}
	
	public TmlDataBackup getByPath(String path) {
		return super.findUniqueBy("path", "%" + path + "%");
	}
	
}
