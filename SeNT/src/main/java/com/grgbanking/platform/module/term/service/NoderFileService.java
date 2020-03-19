/**
 * 文件名：TermInfoService.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.term.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.term.constans.TermInfoConsts;
import com.grgbanking.platform.module.term.dao.NoderFileDao;
import com.grgbanking.platform.module.term.dao.NoderVersionInfoDao;
import com.grgbanking.platform.module.term.entity.NoderFile;
import com.grgbanking.platform.module.term.entity.NoderVersionInfo;
import com.grgbanking.platform.module.term.entity.TermBrand;
import com.grgbanking.platform.module.term.entity.TermModel;
import com.grgbanking.platform.module.term.entity.TermType;
/**
 * 终端基础信息 service<br>
 * 
 * Terminal basal information Service
 * 
 * 
 * @author Jonas
 * 
 */
@Service
@Transactional
@SuppressWarnings( { "unchecked", "rawtypes" })
// @WebService(endpointInterface =
// "com.grgbanking.platform.module.term.service.wsinterface.INoderInfoService")
public class NoderFileService {
	private static Logger logger = LoggerFactory
			.getLogger(NoderVersionInfoService.class);
	/** 扩展属性
	public static Map<String, String> exPropertyMap = new HashMap<String, String>();

	@Autowired
	public void loadExproperty(ExPropertyService service,
			ExtendPropertyDao exPropertyDao) {
		List<ExtendProperty> exPropertyList = service
				.getExtendPropertyList(NoderInfo.TABLE_NAME);
		for (ExtendProperty ex : exPropertyList) {
			exPropertyMap
					.put(ex.getPropertyName(), ex.getEntityClassProperty());
		}
	}
 */
	@Autowired
	NoderFileDao noderFileDao ;
	@Autowired
	ParamDao paramDao;

	private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat TIMEFORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@Transactional
	public Page<NoderFile> getNoderFilePageByParams(final Page<NoderFile> page,
			Map<String, Object> params) {
		return noderFileDao.getNoderFilePageByParams(page, params) ;
	}
	
	
	/**
	 * 登记节点机文件下载请求信息 <br>
	 * 
	 * @param ids
	 * @return
	 */
	public boolean save(String fileType,String noderId,Object tranData,String orgCode) throws Exception{
		String content = tranData.toString();
		if(fileType.equals(TermInfoConsts.NODER_FILE_TYPE_LOG)){
			content = tranData.toString().replaceAll("-", "");
		}else{
			content = tranData.toString();
		}
		NoderFile noderFile = null;
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("fileType", fileType);
		params.put("noderId", noderId);
		params.put("tranData", content);
		List<NoderFile> noderFiles = noderFileDao.getNoderFileListByParams(params);
		if(noderFiles.size()>0){
			noderFile = noderFiles.get(0);
		}else{
			noderFile = new NoderFile();
		}
		noderFile.setFileType(fileType);
		noderFile.setNoderId(noderId);
		noderFile.setOperDate(new Date());
		noderFile.setOrgCode(orgCode);
		noderFile.setTranData(content);
		noderFile.setStatus(TermInfoConsts.NODER_FILE_STATUS_INIT);
		noderFileDao.save(noderFile);
		return true;
	}
	
	/**
	 * 获取当前文件记录的上传状态情况
	 * @param fileType
	 * @param noderId
	 * @param tranData
	 * @return 返回：0-初始状态； 1-获取文件成功； 2-获取文件失败； 3-获取文件处理中 ；
	 */
	public String checkNoderFileUpload(String fileType,String noderId,String tranData) {
		String result = noderFileDao.getNoderLogFileStatus(noderId,tranData,fileType);
		return result;
	}

	public boolean updateNoderFileUpload(NoderFile noderFile) {
		noderFile.setStatus(TermInfoConsts.NODER_FILE_STATUS_INIT);
		noderFileDao.update(noderFile);
		return true;
	}
	
	public NoderFile findFileByFileId(String fileId){
		return noderFileDao.findUniqueBy("id", fileId);
	}
	
	public String exportNoderFile(String fileId){
		NoderFile noderFile = findFileByFileId(fileId);
		File file = new File(noderFile.getFileName());
		if(!file.exists()){
			return "noFile";
		}else{
			return noderFile.getFileName();
		}
		
	}
	
}
