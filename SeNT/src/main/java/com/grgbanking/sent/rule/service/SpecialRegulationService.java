package com.grgbanking.sent.rule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.sent.rule.dao.SpecialRegulationDao;
import com.grgbanking.sent.rule.entity.SpecialRegulation;

/**
 * 特殊规则Service 继承BaseService
 * @author 广电运通 
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class SpecialRegulationService extends BaseService {
	@Autowired
	private SpecialRegulationDao specialRegulationDao;
	/**
	 * 新增一条 SpecialRegulation数据
	 * @param obj  BlackRegulation实体
	 * @return boolean
	 */
	public boolean addSpecialRegulation(SpecialRegulation obj) {
		boolean flag = false;
		try {
			specialRegulationDao.saveNew(obj);
			flag = true;
		} catch (AppException e) {
			flag = false;
			logger.error("",e);
		}
		return flag;
	}
	/**
	 * 删除一条 SpecialRegulation数据
	 * @param obj  BlackRegulation实体
	 * @return boolean
	 */
	public boolean deleteSpecialRegulation(SpecialRegulation obj) {
		boolean flag = false;
		try {
			specialRegulationDao.delete(obj
					.getId());
			flag = true;
		} catch (AppException e) {
			logger.error("",e);
		}
		return flag;
	}

	/**
	 * 批量删除SpecialRegulation
	 * @param sids 主键的数组
	 * @return boolean
	 */
	public boolean deleteSpecialRegulations(String [] sids){
		boolean flag=false;
			if (sids != null) {
				for (int i = 0; i < sids.length; i++) {
					specialRegulationDao.delete(sids[i]);
				}		
			}
	
		return flag;
	}
	/**
	 * 更新SpecialRegulation数据
	 * @param obj SpecialRegulation实体
	 * @return boolean
	 */
	public boolean updateSpecialRegulation(SpecialRegulation obj) {
		boolean flag = false;
		try {
			specialRegulationDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("",e);
			throw new NullPointerException();
		}
		return flag;
	}
    /**
     * 查询 SpecialRegulation数据显示
     * @param page  page实体
     * @param obj 查询条件
     * @param pageNum 页数
     * @param pageSize 页面大小
     * @return  page
     */
	@Transactional(readOnly = true)
	public Page getSpecialRegulationPage(Page page, Object[] obj, int pageNum, int pageSize) {
		String sql = "  from SpecialRegulation ";
		return specialRegulationDao.findPage(page, sql);
	}
    /**
     * 查询  SpecialRegulation数据
     * @param obj  条件 
     * @return List 
     */
	@Transactional(readOnly = true)
	public List getSpecialRegulationList(Object[] obj) {
		String sql = "  from SpecialRegulation ";
		return specialRegulationDao.find(sql);
	}
    /**
     * 根据主键ID查询 SpecialRegulation
     * @param id 主键ID
     * @return SpecialRegulation
     */
	@Transactional(readOnly = true)
	public SpecialRegulation getSpecialRegulationObject(String id) {
		return (SpecialRegulation) specialRegulationDao.get(id);
	}
	/**
	 * 根据规则、来源对specialRegulation进行查询显示
	 * @param page page实体 
	 * @param specialRegulation 实体
	 * @return Page
	 */
	@Transactional(readOnly = true)
	public Page getSpecialRegulationPage(Page page, SpecialRegulation specialRegulation) {
		String sql = " from SpecialRegulation s ";
		boolean flag = false;
		String source = specialRegulation.getSource();
		String regulation =specialRegulation.getRegulation();
		if (source != null && !"".equals(source)) {
			if (flag) {
				sql += " and s.source ='" + source + "'";
			} else {
				sql += " where s.source='" + source + "'";
			}
			flag=true;
		}
		if(regulation !=null && !"".equals(regulation)){
			if(flag){
				
				sql += " and s.regulation like'%" +regulation +"%'";
			}
			else{
				sql +="where s.regulation like'%" +regulation +"%'";
			}
			flag=true;
		}
		sql += "order by s.createDate desc";
		return specialRegulationDao.findPage(page, sql);
	}
	
	
}
