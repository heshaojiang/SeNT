/**
 * 文件名：CmlStrideImportRecordsService.java
 * 创建日期： 2014-05-12
 * Copyright (c) 2011-2013 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.sent.stride.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.security.vo.Loginer;
import com.grgbanking.platform.core.springsecurity.SpringSecurityUtils;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.sent.stride.dao.StrideBundleRefDao;
import com.grgbanking.sent.stride.dao.StrideImportRecordsDao;
import com.grgbanking.sent.stride.dao.StrideTransferRecordDao;
import com.grgbanking.sent.stride.entity.StrideBundleRef;
import com.grgbanking.sent.stride.entity.StrideImportRecords;
import com.grgbanking.sent.stride.entity.StrideTransferRecord;
import com.grgbanking.sent.stride.utils.StrideZipFsnContent;
import com.grgbanking.sent.stride.utils.StrideZipFsnContentUtil;
import com.grgbanking.sent.transmgr.service.ServiceValidateHelper;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 实体信息 service<br>
 * 
 * CmlStrideImportRecordsDao
 * 
 * @author  code auto generated
 * 
 */
@Service
@Transactional
public class StrideImportRecordsService {
	protected static Logger logger = LoggerFactory.getLogger(StrideImportRecordsService.class);

	@Autowired
	StrideImportRecordsDao entityDao;
	@Autowired
	StrideTransferRecordDao strideTransferRecordDao;
	@Autowired
	StrideBundleRefDao strideBundleRefDao;
	@Autowired
	OrgInfoDao orgDao ;
	
	/**
	 * @param contents
	 */
	public void saveImport(List<StrideZipFsnContent> contents){
        User currentUser = SpringSecurityUtils.getCurrentUser();
        if (null == currentUser){
        	logger.info("用户没有登录");
        	return ;
        }
		Loginer loginerInfo = (Loginer) currentUser;
		//有二个AppConstants!!!!!!贵平台真TM乱!!!!!
		String orgId = (String)loginerInfo.getUserInfo().get(com.grgbanking.platform.common.Constants.AppConstants.ORG_ID) ;
		OrgInfo oi = orgDao.get(orgId) ;
		String pathCode = oi.getPathCode();
		
		if(contents.isEmpty()){
			logger.info("zip文件没有合法文件可解释");
			return ;
		}
		StrideZipFsnContent temp = contents.get(0);
		String parentId = "0";
		StrideImportRecords importRecord = null;
		if(StringUtil.isNotBlank(temp.getParentFileName())){
			importRecord = new StrideImportRecords();
			importRecord.setParentId("0");
			String parentFileName = temp.getParentFileName();
			int a = parentFileName.indexOf(File.separator);
			if(a!=-1){
				parentFileName = parentFileName.substring(0, a)+".zip";
			}
			importRecord.setFileName(parentFileName);
			importRecord.setUploadTime(DateUtil.getTimeYYYYMMDDHHMMSSString(new Date()));
			importRecord.setOperaterId(loginerInfo.getUsername());
			importRecord.setOperateStatus("1");
			String[] s = temp.getParentFileName().split("_");
			if(s.length==3)
				importRecord.setBagCount(Integer.parseInt(s[1]));
			else
				importRecord.setBagCount(contents.size());
			importRecord.setFsnCount(0);
			importRecord.setPartMonthday(importRecord.getUploadTime().substring(4, 8));
			importRecord.setPathcode(pathCode);
			parentId = (String)entityDao.saveEntity(importRecord);
		}
		
		for (Iterator iterator = contents.iterator(); iterator.hasNext();) {
			StrideZipFsnContent content = (StrideZipFsnContent) iterator.next();
			
			StrideImportRecords imp = new StrideImportRecords();
			imp.setParentId(parentId);
			imp.setFileName(content.getFileName());
			imp.setUploadTime(importRecord==null?DateUtil.getTimeYYYYMMDDHHMMSSString(new Date()):importRecord.getUploadTime());
			imp.setOperaterId(loginerInfo.getUsername());
			imp.setOperateStatus("1");
			imp.setBagCount(1);
			imp.setFsnCount(content.getBundles().size());
			imp.setPartMonthday(imp.getUploadTime().substring(4, 8));
			imp.setPathcode(pathCode);
			imp.setBagCode(content.getBagCode());
			String id = (String)entityDao.saveEntity(imp);
			
			StrideTransferRecord record = new StrideTransferRecord(content,pathCode);
			//record.setId(id);有bagCode关联
			strideTransferRecordDao.saveEntity(record);
			
			StrideBundleRef[] refs = new StrideBundleRef[content.getBundles().size()];
			int i=0;
			for (Iterator iterator2 = content.getBundles().iterator(); iterator2.hasNext();) {
				String s = (String) iterator2.next();
				String[] str = s.split("_");
				StrideBundleRef bundleRef = new StrideBundleRef();
				bundleRef.setBagCode(content.getBagCode());
				bundleRef.setBundleCode(str[0]);
				refs[i++] = bundleRef;
			}
			strideBundleRefDao.batchSave(refs);
		}
	}
	
	/**
	 * 跨行导出
	 * @param toBankCode 报送银行编码
	 * @param bagCode 包号
	 * @param rfid RFID
	 * @param bundleCodes 捆号字符串
	 * @return
	 */
	public int saveStrideExport(String toBankCode,String bagCode,String rfid,String bundleCodes){
		logger.info("toBankCode="+toBankCode+" bagCode="+bagCode+" rfid="+rfid+" bundleCodes="+bundleCodes);
		if(StringUtil.isBlank(bagCode) || StringUtil.isBlank(bundleCodes) || StringUtil.isBlank(toBankCode)) return 0;
		String[] bundles = bundleCodes.split(",");
		List<String[]> dirs = this.entityDao.getFsnsDirByBundles(bundles);
		
		if(dirs.size()==0){
			logger.info("不存在对应捆号的FSN文件:"+bundleCodes);
			ServiceValidateHelper
			.validateExport(false);
			return 0;
		}
		StrideZipFsnContent content = new StrideZipFsnContent();
		content.setTranTime(dirs.get(0)[0]);
		content.setBankCode(toBankCode);
		User currentUser = SpringSecurityUtils.getCurrentUser();
        if (null == currentUser){
        	logger.info("用户没有登录");
        	return 0;
        }
		Loginer loginer = (Loginer) currentUser;
		Map<String,Object> userInfo =  loginer.getUserInfo() ;
//		Set<String> keys= userInfo.keySet() ;
//		for(String key : keys) {
//			System.out.println("-----------------------------------"+key+"="+userInfo.get(key));
//		}
		String orgId = (String)userInfo.get(com.grgbanking.platform.common.Constants.AppConstants.ORG_ID) ;
		OrgInfo oi = orgDao.get(orgId) ;
		String finacialCode = oi.getFinacialCode();
		String pathCode = oi.getPathCode();
		if(StringUtil.isBlank(finacialCode)) {
			finacialCode = oi.getOrgCode() ;
		}
		content.setFromCode(finacialCode);
		content.setBusinessType("3");
		content.setCount(dirs.size());
		content.setCashType("T");
		content.setVersion(1);
		content.setBagCode(bagCode);
		String version = dirs.get(0)[1].split("_")[0];
		String currency = "";
		if("10".equals(version)){
			currency = dirs.get(0)[1].split("_")[7].split("\\+")[0];
		}else{
			currency = dirs.get(0)[1].split("_")[1];
		}
		content.setCurrency(currency);
		content.setReserve("0");
		//复制FSN文件
		int count = 0;
		try {
			count = StrideZipFsnContentUtil.copyAndZip(dirs, bagCode, content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//保存 跨行调款交易信息表
		StrideTransferRecord record = new StrideTransferRecord(content,pathCode);
		strideTransferRecordDao.saveEntity(record);
		//保存 跨行调款导入导出信息表
		StrideImportRecords imp = new StrideImportRecords();
		imp.setParentId("0");
		imp.setFileName(content.getFileName());
		imp.setUploadTime(DateUtil.getTimeYYYYMMDDHHMMSSString(new Date()));
		imp.setOperaterId(loginer.getUsername());
		imp.setOperateStatus("0");//导出
		imp.setBagCount(1);
		imp.setFsnCount(content.getCount());
		imp.setPartMonthday(imp.getUploadTime().substring(4, 8));
		imp.setPathcode(pathCode);
		imp.setBagCode(content.getBagCode());
		String id = (String)entityDao.saveEntity(imp);
		StrideBundleRef[] refs = new StrideBundleRef[dirs.size()];
		for (int i = 0; i < dirs.size(); i++) {
			StrideBundleRef bundleRef = new StrideBundleRef();
			bundleRef.setBagCode(content.getBagCode());
			bundleRef.setBundleCode(dirs.get(i)[2]);
			refs[i] = bundleRef;
		}
		strideBundleRefDao.batchSave(refs);
		logger.info("扫描捆数:"+bundles.length+" 数据库返回个数:"+dirs.size()+" FSN打包成功个数:"+count);
		return count;
	}
	
	/**
	 * 保存下载的打包记录及更新压缩的父子关系
	 * @param fileName 下载文件名
	 * @param ids 压缩的zip文件ID数组
	 */
	public void saveZipDownLoad(String fileName,String[] ids){
		User currentUser = SpringSecurityUtils.getCurrentUser();
        if (null == currentUser){
        	logger.info("用户没有登录");
        	return ;
        }
        if(ids.length==1){
        	updateParentId("0", "3", ids);
        	return;
        }
		Loginer loginerInfo = (Loginer) currentUser;
		String pathCode = orgDao.getPathCodeById((String)loginerInfo.getUserInfo().get(com.grgbanking.platform.common.Constants.AppConstants.ORG_ID)) ;
		StrideImportRecords imp = new StrideImportRecords();
		imp.setParentId("0");
		imp.setFileName(fileName);
		imp.setUploadTime(DateUtil.getTimeYYYYMMDDHHMMSSString(new Date()));
		imp.setOperaterId(loginerInfo.getUsername());
		imp.setOperateStatus("3");//已下载
		imp.setBagCount(ids.length);
		imp.setFsnCount(0);
		imp.setPartMonthday(imp.getUploadTime().substring(4, 8));
		imp.setPathcode(pathCode);
		imp.setBagCode("---");
		String id = (String)entityDao.saveEntity(imp);
		updateParentId(id, "2", ids);
	}
	
	public int updateParentId(String parentId,String status,String[] ids){
		if(ids==null || ids.length==0)return 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			sb.append("'").append(ids[i]).append("'").append(",");
		}
		String hql = "update StrideImportRecords set parentId=?,operateStatus=? where id in ("+sb.substring(0, sb.length()-1)+")";
		return this.entityDao.executeUpdate(hql, parentId,status);
	}
	
	public void savedStrideDownload(List<StrideImportRecords> ids){
		logger.info("ids.size="+ids.size());
	}
	
	public String save(StrideImportRecords entity){
		return entityDao.saveEntity(entity).toString();
	}

	/**
	 * 保存 实体信息
	 * 
	 * @param entity
	 * @return
	 */
	public boolean saveCmlStrideImportRecords(StrideImportRecords entity) {
		
		
		validateCmlStrideImportRecords(entity);

/*		StrideImportRecords existedCmlStrideImportRecords = entityDao
				.getByAccount(entity.getcAccount());
		if (existedCmlStrideImportRecords != null) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.STUDENT_EXISTED_STUDENT_INFO_ACCOUNT,
					"账号[%s]已经存在",entity.getcAccount());
		}*/

		if (entity.getId() == null) {
			entityDao.save(entity);
		} else {
			entityDao.copyUpdate(entity);
		}
		return true;
	}

	/**
	 * 删除 实体信息
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteCmlStrideImportRecords(String id) {
		validateId(id);
		entityDao.delete(id);
		return true;
	}

	/**
	 * 校验该记录是否存在
	 * 
	 * @param id
	 */
	private void validateId(String id) {
		if (!StringUtils.hasText(id)) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD,
					"No record is selected. ");
		}
	}

	/**
	 * 批量删除实体信息
	 * 
	 * @param ids
	 * @return
	 */
	public boolean batchDelete(Collection<String> ids) {
		if (ids == null || ids.size() == 0) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD,
					"No record is selected. ");
		}

		
		
		for (String id : ids) {
			deleteCmlStrideImportRecords(id);
		}

		return true;
	}

	/**
	 * 更新 实体信息
	 * 
	 * @param entity
	 * @return
	 */
	public boolean updateCmlStrideImportRecords(StrideImportRecords entity) {

		String id = entity.getId();

		validateCmlStrideImportRecords(entity);
		validateId(id);

		//根据实际情况修改更新实体
		entityDao.copyUpdate(entity);

		return true;
	}

	/**
	 * 根据参数查找分页的实体数据
	 * 
	 * @param page
	 * @param params
	 * @return
	 */
	public Page<StrideImportRecords> getCmlStrideImportRecordsPageByParams(
			final Page<StrideImportRecords> page, Map<String, String> params,String start, String end) {
		Page<StrideImportRecords> pages = entityDao.getStrideImportRecordsPage(page, params,start,end);
		List<StrideImportRecords> item = entityDao.getStrideImportRecordsByRecordsJt(pages.getResult());
		Set<String> set = new HashSet<String>();
		for (int i=0;i<item.size();i++) {
			StrideImportRecords record = (StrideImportRecords) item.get(i);
			if(set.contains(record.getId()))continue;
			for (Iterator iterator = pages.getResult().iterator(); iterator.hasNext();) {
				StrideImportRecords strideImportRecords = (StrideImportRecords) iterator.next();
				if(record.getParentId().equals(strideImportRecords.getId())){
					if(strideImportRecords.getChildren()==null)
						strideImportRecords.setChildren(new ArrayList<StrideImportRecords>());
					strideImportRecords.getChildren().add(record);
					strideImportRecords.setFsnCount(record.getFsnCount());
					set.add(record.getId());
					item.remove(i);
					i--;
					break;
				}
			}
		}
		List<StrideImportRecords> strideImportRecordList = pages.getResult() ;
		if(strideImportRecordList != null && strideImportRecordList.size() > 0) {
			for(StrideImportRecords strideImportRecord : strideImportRecordList) {
				StrideTransferRecord strideTransferRecord = strideTransferRecordDao.getByField("bagCode", strideImportRecord.getBagCode()) ;
				if(strideTransferRecord != null) {
				strideImportRecord.setBankCode(strideTransferRecord.getBankCode()) ;
				strideImportRecord.setFromCode(strideTransferRecord.getFromCode()) ;
				OrgInfo oi = orgDao.getByOrgCode(strideTransferRecord.getFromCode()) ;
				if(oi != null ) {
					strideImportRecord.setOrgName(oi.getOrgName()) ;
				}
				}
			}
		}
		return pages;
	}

	/**
	 * 根据当前语言获取表单或module的基础数据
	 * 
	 * @return
	 */
	public Map<String, Object> getFormInitDatas() {
		Map<String, Object> formInitDatas = new HashMap<String, Object>();
		
		formInitDatas.put("bagCode", UUID.randomUUID().toString().replaceAll("-", ""));
		
		return formInitDatas;
	}

	/**
	 * 校验实体信息
	 * 
	 * @param entity
	 * @return
	 */
	private boolean validateCmlStrideImportRecords(StrideImportRecords entity) {
		if (entity == null) {
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"实体信息为空");
		}


		return true;

	}

	/**
	 * 获取 所有实体信息
	 * 
	 * @return
	 */
	public List<StrideImportRecords> getAllCmlStrideImportRecords() {
		return this.entityDao.getAll();
	}

}
