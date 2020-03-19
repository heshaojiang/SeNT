/**
 * 文件名：BoxDao.java
 * 
 */
package com.grgbanking.platform.module.cashbox.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.cashbox.entity.BoxInfo;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.term.dao.TermModelDao;

@Repository
public class BoxInfoDao extends BaseDao<BoxInfo>{

	Page<BoxInfo> page;
	@Autowired
	OrgInfoDao orgInfoDao;
	@Autowired
	TermModelDao termModelDao;
	
	/**
	 * 根据钞箱编号查找钞箱
	 * @param boxNum 钞箱编号
	 * @return list 所找到的钞箱信息
	 */
	public BoxInfo getBoxByBoxNum(String boxNum){
		//String hql=" select new BoxInfo(boxInfo.id, orgInfo.orgName, boxInfo.boxNum, boxInfo.status) from BoxInfo boxInfo,OrgInfo orgInfo where boxInfo.boxNum = '"+boxNum+"' and boxInfo.orgid=orgInfo.orgCode";
		return super.findUniqueBy("boxNum", boxNum);
	}
	
	/**
	 * 根据钞箱编号查找钞箱
	 * @param boxNum 钞箱编号
	 * @return list 所找到的钞箱信息
	 */
	public BoxInfo getByBoxNum(String boxNum)
	{
		return super.findFirstBy("boxNum", boxNum);
	}
	
	/**
	 * 将钞箱对应的机构id和atm型号id转为对应的具体机构名称和型号
	 * @param boxNum
	 * @return
	 */
//	public String[] getOrgNameAndModelNameByBoxNum(String boxNum){
//		//根据钞箱号从钞箱表中获取钞箱信息
//		BoxInfo boxInfo = super.findUniqueBy("boxNum", boxNum);
//		//根据钞箱对应将机构id从机构表中获取机构名称
//		String a = orgInfoDao.get(boxInfo.getOrgid()).getOrgName().toString();
//		//根据钞箱对应atm型号id从终端型号表中获取终端型号名
//		String b = termModelDao.get(boxInfo.getAtmModel()).getModelName().toString();
//		String[] s = {a,b};
//		return s;
//	}
	
	/**
	 * 根据钞箱所属机构查找钞箱
	 * @param orgid 钞箱所属机构id
	 * @return list 所找到的机构下的所有钞箱信息列表
	 */
	public List<BoxInfo> getBoxInfoByOrgid(String orgid){
		String hql = " select new BoxInfo(boxInfo.id, orgInfo.orgName, boxInfo.boxNum, boxInfo.boxStatus,boxInfo.atmModel,boxInfo.atmBoxTypes,boxInfo.boxType,boxInfo.usageStatus) from BoxInfo boxInfo,OrgInfo orgInfo where boxInfo.orgid = '"+orgid+"' and boxInfo.orgid=orgInfo.id";
		List<BoxInfo> list=super.find(hql.toString());
		return list;
	}
	/**
	 * 根据参数查找分页的钞箱数据
	 * @param page 页对象
	 * @param params 条件参数
	 * @return Page<BoxInfo>
	 */
	public Page<BoxInfo> getBoxInfoByParams(Page<BoxInfo> page, Map<String ,String> params){
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("select new BoxInfo(boxInfo.id, boxInfo.orgid, boxInfo.boxNum, boxInfo.boxStatus, boxInfo.atmModel, boxInfo.atmBoxTypes,boxInfo.boxType,boxInfo.usageStatus) from BoxInfo boxInfo,OrgInfo orgInfo where 1=1 and boxInfo.orgid = orgInfo.id");
		
		String flag = (String) params.get("flag");
		
		for(String key : params.keySet()){
			if(params.get(key) == null){
				continue;
			}
			String paramValue = params.get(key);
			
			if(key.equals("orgId")){
				if(null == flag || flag.equals("true")){
					String pathCode = orgInfoDao.getPathCodeById(paramValue);
					hql.append(" and orgInfo.pathCode like '" + pathCode + "%'");
				}else{
					String pathCode = orgInfoDao.getPathCodeById(paramValue);
					hql.append(" and orgInfo.pathCode = '" + pathCode + "'");
				}
			}else if(key.equals("boxNum")&&!paramValue.equals("")){
				hql.append(" and boxInfo.boxNum like '%"+ paramValue + "%'");
			}else if(key.equals("atmModel")&&!paramValue.equals("")){
				hql.append(" and boxInfo.atmModel = '"+paramValue+"'");
			}else if(key.equals("atmBoxType")&&!paramValue.equals("")){
				hql.append(" and boxInfo.atmBoxTypes = '"+paramValue+"'");
			}else if(key.equals("boxType")&&!paramValue.equals("")){
				hql.append(" and boxInfo.boxType = '"+paramValue+"'");
			}
		}
		
		hql.append(" order by boxInfo.boxNum asc");
		Page<BoxInfo> page4=super.findPage(page, hql.toString(), param);
		
		return page4;
	}
}