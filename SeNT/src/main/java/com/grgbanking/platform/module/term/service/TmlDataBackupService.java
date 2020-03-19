package com.grgbanking.platform.module.term.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.jasper.logging.Logger;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.term.dao.TmlDataBackupDao;
import com.grgbanking.platform.module.term.entity.TermType;
import com.grgbanking.platform.module.term.entity.TmlDataBackup;
import com.grgbanking.sent.transmgr.dao.CmlSentInfoJDBCForMySqlDao;
import com.grgbanking.sent.transmgr.dao.CmlSentInfoJDBCForOracleDao;
import com.grgbanking.sent.utils.DateUtil;
/**
 * @file com.grgbanking.platform.module.term.service.TmlDataBackupService.java
 * @Description: 
 * @version 1.0
 * @author Norman_chang
 * @since 2014-6-18 上午10:05:59
*/
@Service
@Transactional
public class TmlDataBackupService {

	@Autowired
	TmlDataBackupDao tmlDataBackupDao;
    /**
     * 
     * @Description: 
     * @param tmlDataBackup
     * @param language
     * @return
     * @author Norman_chang
     * @since 2014-6-18 上午10:29:02
     */
	public boolean saveTmlDataBackup(TmlDataBackup tmlDataBackup, String language) {
		File file=null;
		tmlDataBackup.setCreateDate(DateUtil.getTimeString(new Date()));
		TmlDataBackup vo=tmlDataBackupDao.getByPath(tmlDataBackup.getPath());
		if(vo!=null){
			throw new AppException(MessageKeyConstants.CML_EXISTED_DATABACKUP_PATH,
			"The directory has already used. Please change the directory and submit again. ");
		}else{
			file=new File(tmlDataBackup.getPath());
			if(!file.exists()||!file.isDirectory()){
				throw new AppException(MessageKeyConstants.CML_EXISTED_DATABACKUP_PATH_FILE,
				"The directory does not exist. Please change the directory ");
			}
		}
		
		if (tmlDataBackup.getId() == null) {
			tmlDataBackupDao.save(tmlDataBackup);
		} else {
			tmlDataBackupDao.copyUpdate(tmlDataBackup);
		}

		return true;
	}
    /**
     * 
     * @Description: 
     * @param id
     * @return
     * @author Norman_chang
     * @since 2014-6-18 上午10:28:57
     */
	public boolean deleteTmlDataBackup(String id) {
		validateId(id);
		tmlDataBackupDao.delete(id);
		return true;
	}

	private void validateId(String id) {
		if (!StringUtils.hasText(id)) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}
	}
    /**
     * 
     * @Description: 
     * @param ids
     * @return
     * @author Norman_chang
     * @since 2014-6-18 上午10:28:51
     */
	public boolean batchDelete(Collection<String> ids) {
		if (ids == null || ids.size() == 0) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}

		for (String id : ids) {
			deleteTmlDataBackup(id);
		}

		return true;
	}
	/**
	 *
	 * @Description: 
	 * @param tmlDataBackup
	 * @return
	 * @author Norman_chang
	 * @since 2014-6-18 上午10:30:42
	 */
	public boolean updateTmlDataBackup(TmlDataBackup tmlDataBackup) {
		String newId = tmlDataBackup.getId();
		validateId(newId);
		tmlDataBackupDao.copyUpdate(tmlDataBackup);
		return true;
	}
    /**
     * 
     * @Description: 
     * @param page
     * @return
     * @author Norman_chang
     * @since 2014-6-18 上午10:28:34
     */
	public Page<TmlDataBackup> getTmlDataBackupPage(final Page<TmlDataBackup> page,String path) {
		Page<TmlDataBackup> pageType = tmlDataBackupDao.getByPath(page,path);
		return pageType;
	}
	
	public List<TmlDataBackup> getAllDataBackup()
	{
		return this.tmlDataBackupDao.getAll();
	}
	
	public void execute(){
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("MMdd");
		String mkDate=sdf.format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, -90);
		String tarDate=sdf2.format(cal.getTime());
		
		StringBuilder str=new StringBuilder(" ");
		if (DBDialectHelper.isOracle()) {
			str.append(" exp feelview/feelview file=/tmp/cml_sent_his_back.exp  tables=cml_sent_infos_his_");
			str.append(tarDate);
			str.append(" ; ");
		} else if (DBDialectHelper.isMySql()) {
			str.append(" mysqldump  -ufeelview -pfeelview -Bfeelview --tablecml_sent_infos_his_ ");
			str.append(tarDate);
			str.append(" > /tmp/cml_sent_his_back.exp ");
		}
		try {
			Runtime rt = Runtime.getRuntime();
			rt.exec("cmd /c" + str.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		File srcFile=new File("/tmp/cml_sent_his_back.exp");
		
		File destDir=null;
		List<TmlDataBackup> TmlDataBackups=getAllDataBackup();
		for(TmlDataBackup vo:TmlDataBackups){ 
			destDir=new File(vo.getPath()+"/"+mkDate+"/");
			if(!destDir.exists()){
				destDir.mkdirs();
			}
			try {
				FileUtils.copyFileToDirectory(srcFile, destDir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		srcFile.delete();
	}

}
