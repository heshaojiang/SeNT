/**
 * 文件名：OperLogService.java
 * 创建日期： 2012-3-31
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.log.service;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.FlexContextUtils;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.log.dao.OperLogDao;
import com.grgbanking.platform.module.log.entity.OperLog;

/**
 * operation log service<br>
 * 操作日志管理服务类
 * 
 * @author yrliang
 */
@Service
@Transactional
public class OperLogService extends BaseService {
	@Autowired
	OperLogDao operLogDao;

	/**
	 * save a new Operation Log <br>
	 * 新增一个操作日志记录
	 * 
	 * @param operLog
	 * @return boolean
	 */
	public boolean newOperLog(OperLog operLog) {
		validateOperLog(operLog);

		String clientIp = FlexContextUtils.getClientIp();
		operLog.setHostIp(clientIp);
		operLog.setLogTime(new Date());

		operLogDao.save(operLog);

		logger.info("userCode:[{}]  menuId:[{}]  operation:[{}]", new Object[] { operLog.getUserId(),
				operLog.getMenuName(), operLog.getOperName() });
		return true;
	}

	/**
	 * Delete Operate log<br>
	 * 删除一个操作日志
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteOperLog(String id) {
		validateId(id);

		operLogDao.delete(id);

		return true;
	}

	/**
	 * House Keeping: Batch delete the operate logs<br>
	 * 批量删除操作日志
	 * 
	 * @param ids
	 * @return
	 */
	public boolean batchDelete(Collection<String> ids) {
		if (ids == null || ids.size() == 0) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}

		for (String id : ids) {
			deleteOperLog(id);
		}

		return true;
	}

	/**
	 * House keeping: Batch delete operate logs xx days ago<br>
	 * 删除最近天数的操作日志
	 * 
	 * @param ids
	 * @return
	 */
	public void batchDelete(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -days);
		operLogDao.deleteBeforeDate(cal.getTime());
	}

	/**
	 * query the Operation Log by user id and page object <br>
	 * 根据查询条件、语种，分页查询操作日志记录
	 * 
	 * @param page
	 * @param userId
	 * @return Page<OperLog>
	 * @Exception 异常对象 <br>
	 */
	@SuppressWarnings("unchecked")
	public Page<Map<String, Object>> searchOperLog(Page<Map<String, Object>> page, Map<String, Object> cond,
			String language) {
		return operLogDao.getByParams(page, cond, language);
		// Page<Object[]> target = new Page<Object[]>();
		// target.setAutoCount(page.isAutoCount());
		// if (page.getOrder() != null) {
		// target.setOrder(page.getOrder());
		// }
		// if (page.getOrderBy() != null) {
		// target.setOrderBy(page.getOrderBy());
		// }
		// target.setPageNo(page.getPageNo());
		// target.setPageSize(page.getPageSize());
		// target.setTotalCount(page.getTotalCount());
		// target.setResult(new ArrayList<Object[]>());
		// Page<Object[]> p = operLogDao.getByParams(target, cond, language);
		//
		// List<Map<String,Object>> resuluts = new
		// ArrayList<Map<String,Object>>();
		// for (Object[] objs : p.getResult()) {
		// Map<String,Object> maps = new HashMap<String,Object>();
		// OperLog o = (OperLog) objs[0];
		// maps.put("id", o.getId());
		// maps.put("userId", o.getUserId());
		// maps.put("userName", o.getUserName());
		// maps.put("hostIp", o.getHostIp());
		// maps.put("logTime", o.getLogTime());
		// maps.put("menuName", ((SysI18n) objs[1]).getName());
		// maps.put("operName", o.getOperName());
		// maps.put("note", o.getNote());
		// resuluts.add(maps);
		// }
		//
		// page.setAutoCount(p.isAutoCount());
		// if (p.getOrder() != null) {
		// page.setOrder(p.getOrder());
		// }
		// if (p.getOrderBy() != null) {
		// page.setOrderBy(p.getOrderBy());
		// }
		// page.setPageNo(p.getPageNo());
		// page.setPageSize(p.getPageSize());
		// page.setTotalCount(p.getTotalCount());
		//
		// page.setResult(resuluts);
		// return page;
		// return operLogDao.getByUserIdFuzzily(page, userId);
	}

	/**
	 * Validate the primary key
	 * 
	 * @param id
	 * @return
	 */
	private boolean validateId(String id) {
		if (!StringUtils.hasText(id)) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}

		return true;
	}

	/**
	 * 日期：Jun 15, 2011<br>
	 * 版本：V1.0<br>
	 * 描述：validateOperLog(Validate the operlog form) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：Jun 15, 2011 11:01:07 PM <br>
	 * 创建人 Vinson<br>
	 * ===============================================<br>
	 * 修改日期：Jun 15, 2011<br>
	 * 修改人 Vinson<br>
	 * 修改描述 validateOperLog(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param operLog
	 * @return boolean
	 * @Exception 异常对象 <br>
	 */
	private boolean validateOperLog(OperLog operLog) {
		if (operLog == null) {
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again.");
		}

		if (!StringUtils.hasText(operLog.getUserId())) {
			throw new AppException(MessageKeyConstants.LOG_USER_ID_NOT_NULL, "The User Id is null.");
		}
		if (!StringUtils.hasText(operLog.getUserName())) {
			throw new AppException(MessageKeyConstants.LOG_USER_NAME_NOT_NULL, "The User Name is null.");
		}
		// if (!StringUtils.hasText(operLog.getHostIp()))
		// throw new AppException(MessageKeyConstants.HOST_IP_NOT_NULL,
		// "The Host Ip is null");
		// if (operLog.getLogTime() == null)
		// throw new AppException(MessageKeyConstants.LOG_TIME_NOT_NULL,
		// "The Log Time is null");
		if (!StringUtils.hasText(operLog.getMenuName())) {
			throw new AppException(MessageKeyConstants.LOG_MENU_NAME_NOT_NULL, "The Menu Name is null");
		}

		return true;
	}
}
