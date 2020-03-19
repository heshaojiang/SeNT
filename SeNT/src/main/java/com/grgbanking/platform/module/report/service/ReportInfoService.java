/**
 * 文件名：ReportConditionService.java
 * 创建日期： 2012-5-28
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.report.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.SysException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.DeCompressUtil;
import com.grgbanking.platform.core.utils.FileUtil;
import com.grgbanking.platform.module.param.service.ParamService;
import com.grgbanking.platform.module.report.ReportConstants;
import com.grgbanking.platform.module.report.dao.ReportInfoDao;
import com.grgbanking.platform.module.report.dao.ReportParamDao;
import com.grgbanking.platform.module.report.entity.ReportInfo;
import com.grgbanking.platform.module.security.dao.RoleDao;
import com.grgbanking.platform.module.security.entity.Role;

/**
 * @author yrliang
 * 
 */
@Service
@Transactional
public class ReportInfoService extends BaseService {
	@Autowired
	ReportInfoDao dao;

	@Autowired
	ReportParamDao paramDao;

	@Autowired
	RoleDao roleDao;

	private String reportPath;
	private String zipFileTempPath;

	@Autowired
	public void init(ParamService service) {
		reportPath = service.getValueByPath(ReportConstants.REPORT_PATH);
		zipFileTempPath = service
				.getValueByPath(ReportConstants.ZIP_FILE_TEMP_PATH);
	}

	/**
	 * 根据模板类型查询
	 * 
	 * @param page
	 * @param type
	 * @return
	 */
	public Page<ReportInfo> getPage(final Page<ReportInfo> page, String code) {

		Map<String, Object> propertyFilterMap = new HashMap<String, Object>();
		if (code != null && code.length() > 0) {
			propertyFilterMap.put("EQI_code", code);
		}
		// page.setOrder(Page.ASC);
		Page<ReportInfo> returnPage = dao.findPageNew(page, propertyFilterMap);

		return returnPage;

	}

	/**
	 * 加载用户信息
	 * 
	 * @param page
	 * @param userId
	 * @return
	 */
	public List<Role> loadRoles() {
		return roleDao.getAll();
	}

	/**
	 * 保存
	 * 
	 * @param page
	 * @param userId
	 * @return
	 */

	public void save(ReportInfo entity, String fileName, byte[] fileData,
			String[] roles) {
		int code = entity.getCode();
		boolean hasInitSql = false;

		// 保存上传的文件
		if (fileName.indexOf(".zip") != -1) {
			fileName = zipFileTempPath + "/" + code + ".zip";
		} else {
			fileName = reportPath + "/" + code + ".jasper";
		}
		File file = new File(fileName);

		try {
			FileOutputStream fos = new FileOutputStream(file);
			for (byte b : fileData) {
				fos.write(b);
			}
			fos.close();
		} catch (FileNotFoundException e) {
			throw new SysException("upload report file error!", e);
		} catch (IOException e) {
			throw new SysException("upload report file error!", e);
		}

		// 如果是zip文件进行解压
		if (fileName.indexOf(".zip") != -1) {
			// zip解压
			try {
				DeCompressUtil.deCompress(fileName, zipFileTempPath + "/"
						+ code);
			} catch (Exception ex) {
				throw new SysException("unzip " + fileName
						+ " error when upload report file!", ex);
			}

			//
			File dir = new File(zipFileTempPath + "/" + code);
			for (String s : dir.list()) {
				// copy报表文件
				if (s.indexOf(".jasper") != -1) {
					try {
						FileUtil.copyFile(new File(s), new File(reportPath
								+ "/" + code + ".jasper"));
					} catch (IOException e) {
						throw new SysException("copy jasper file to "
								+ reportPath + " error!", e);
					}
				}

				// copy资源文件
				if (s.indexOf(".properties") != -1) {
					try {
						FileUtil.copyFile(new File(s), new File(reportPath
								+ "/" + code + ".properties"));
					} catch (IOException e) {
						throw new SysException("copy properties file to "
								+ reportPath + " error!", e);
					}
				}

				// 执行sql
				if (s.indexOf(".sql") != -1) {
					if (entity.getId() != null) {
						paramDao.executeUpdate(
								"delete from ReportParam where reportId=?",
								entity.getId());
					}
					try {
						File sqlFile = new File(s);
						FileInputStream fis = new FileInputStream(sqlFile);
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(fis));

						String line = reader.readLine();
						while (line != null) {
							if (line.trim().length() > 0) {
								hasInitSql = true;
								// 执行sql
							}
							line = reader.readLine();
						}
					} catch (IOException e) {
						throw new SysException("exeute init sql error!", e);
					}
				}

				// 从报表提取参数
				if (hasInitSql == false) {

				}
			}
		}

		//
		dao.save(entity);
	}

	/**
	 * 删除
	 * 
	 * @param ids
	 */
	public void delete(String[] ids) {
		for (String id : ids) {
			dao.delete(id);
		}
	}
}
