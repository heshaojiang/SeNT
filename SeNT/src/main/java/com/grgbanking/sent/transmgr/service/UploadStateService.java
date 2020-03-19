/**
 * 文件名：UploadStateService.java
 * 创建日期： 2014-7-16
 * Copyright (c) 2014 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间：
 *   修改人：
 *   生成版本：
 *   修改内容：
 */
package com.grgbanking.sent.transmgr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.sent.transmgr.dao.UploadStateDao;
import com.grgbanking.sent.transmgr.entity.UploadStateDetailInfo;

/**
 * @author hjyi
 * 
 */
@SuppressWarnings("unchecked")
@Service
public class UploadStateService extends BaseService {

	@Autowired
	private UploadStateDao uploadStateDao;
	
	@Autowired
	private OrgInfoDao orgInfoDao;
	
	public Page getUploadStatePage(Map<String, Object> parameter) {
		Page page = (Page)parameter.get("page");
		Map<String, Object> condition = (Map<String, Object>) parameter.get("condition");
		uploadStateDao.getUploadStatePage(page, condition);
		
		List<UploadStateDetailInfo> resultTemp = (List<UploadStateDetailInfo>)page.getResult();
		List<OrgInfo> orgList = orgInfoDao.getAll();
		for(UploadStateDetailInfo detail : resultTemp){
			for(OrgInfo orgInfo : orgList){
				if(detail.getOrgId().equals(orgInfo.getPathCode())){
					detail.setOrgName(orgInfo.getOrgName());
					break;
				}
			}
			
			if(detail.getOrgName() == null || detail.getOrgName() == ""){
				detail.setOrgName(AppConstants.ORG_CHINA_ORGNAME);// 默认值，与系统其他地方一致
			}
		}
		return page;
	}

}
