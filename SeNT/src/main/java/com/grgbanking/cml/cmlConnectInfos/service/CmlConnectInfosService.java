package com.grgbanking.cml.cmlConnectInfos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.cml.cmlConnectInfos.dao.CmlConnectInfosDao;
import com.grgbanking.cml.cmlConnectInfos.entity.CmlConnectInfos;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.DateUtils;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.platform.module.term.entity.TermInfo;



@Service
@Transactional
public class CmlConnectInfosService extends BaseService{
	@Autowired
	CmlConnectInfosDao  cmlConnectInfosDao;
	@Autowired
	UserDao  userDao;
	@Autowired
	OrgInfoDao orgInfoDao;
	/**
	 * @param comeOrg 来源机构
	 *
	 * */
	private String getOrgfloor(final String comeOrg) {
		String orgfloor=null;
		
	String sql = "select pathCode from OrgInfo where id='"+comeOrg+"'";
    if(cmlConnectInfosDao.find(sql).size()>0){
	 orgfloor = (String) cmlConnectInfosDao.find(sql).get(0);
    }	
		return orgfloor;

	}
	public boolean add(CmlConnectInfos cml){
		boolean flag=false;
		
		
		try{
			cml.setConnNum(cmlConnectInfosDao.Genertory());
		
			/*cml.setComeOrg(orgInfoDao.getPathCodeById(cml.getComeOrg()));*/
			cml.setNoAllotMoney(cml.getConnMoney());
			cmlConnectInfosDao.save(cml);
		flag=true;
		}
		catch (NullPointerException e) {
			flag=false;
			logger.error("",e);
		}
		return flag;
	}
	public boolean update(CmlConnectInfos cml){
		boolean flag=false;
		try{
			cmlConnectInfosDao.copyUpdate(cml);
			logger.info(cml.toString());
			flag=true;
		}
		catch (NullPointerException e) {
			flag=false;
			logger.error("",e);
			
		}
		return flag;
	}
	
	
	/**
	 * 批量删除SpecialRegulation
	 * @param sids 主键的数组
	 * @return boolean
	 */
	public boolean delete(String [] sids){
		boolean flag=false;
			if (sids != null) {
				for (int i = 0; i < sids.length; i++) {
					cmlConnectInfosDao.delete(sids[i]);
				}		
			}
	
		return flag;
	}
	@Transactional(readOnly = true)
	public Page getObjectPage2(Page page,String bindStart, String bindEnd,CmlConnectInfos cml) {
		
		List<Object> values =new ArrayList<Object>();
//		private String connNum;
//		private Long connMoney;
//		private String comeOrg;
//		private String toOrg;
//		private String outPerson;
//		private String inPerson;
//		private Date connDate;
//		private Date operateDate;
//		private String operatorId;
//		private Integer moneyboxCount;
//		private String flag;
//		private String connAppeal;
//		private Long noAllotMoney;
//		private String connMemo;
		//u.userName ,c.sourceOrg from CmlTaskInfo c , 
		//User u ,OrgInfo o where c.operatorId=u.userCode and c.sourceOrg = o.id" );

		StringBuffer sql = new StringBuffer(" from CmlConnectInfos cml  where 1=1 ");
		//String sql="from CmlConnectInfos where 1=1";
		if (cml.getComeOrg()!=null && !cml.getComeOrg().equals("")) {
			
			sql.append(" and exists (  select 'X' from OrgInfo o where o.id = cml.comeOrg and  o.pathCode  like ?   )" );
			values.add(orgInfoDao.getPathCodeById(cml.getComeOrg())+"%");
			
		/*	sql.append("  and cml.comeOrg like  ? " );
			values.add(orgInfoDao.getPathCodeById(cml.getComeOrg())+"%");*/

		/*	sql.append("and exists ("
					+ " select  from  OrgInfo where pathCode like '"
					+ getOrgfloor(cml.getComeOrg()) + "%')");
*/
		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(bindStart)) {
			sql.append(" and connDate  >=  ?  " ) ;
			values.add(DateUtils.toDate(bindStart));
			
					

		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(bindEnd)) {
			sql.append(" and connDate <=  ? ");
			values.add(DateUtils.toDate(bindEnd));
			
		}
		/*
		 * sql.append(" and connDate like ('" + connDate + "','yyyy-MM-dd
		 * HH24:mi:ss') ");
		 */
       
		if (cml.getConnMoney()!= null && 0 != cml.getConnMoney().intValue()) {
			sql.append(" and connMoney =  ? ");
			values.add(cml.getConnMoney());
		}
		if (cml.getInPerson()!=null && !cml.getInPerson().equals("")) {
	/*		sql.append("  and inPerson in (select  userCode  from User  where userName like '%"
							+ cml.getInPerson().trim() + "%')");*/
			sql.append(" and exists (  select 'Z' from User u where u.userCode = cml.inPerson and userName like ?   )");
			values.add(cml.getInPerson().trim()+"%");
			
		}
		if (cml.getFlag()!=null && !cml.getFlag().equals("")) {
			sql.append( " and cml.flag = ? ") ;
			values.add(cml.getFlag());
		/*	sql.append(" and flag !='" + cml.getFlag() + "'");*/
		}
	
		sql.append("  order by connNum desc ");
		Page page2 =cmlConnectInfosDao.findPage(page,sql.toString(),values.toArray());
		List lis=page2.getResult();
		
		for(int i=0;i<page2.getTotalCount();i++){
			CmlConnectInfos cmlConnectInfos=(CmlConnectInfos)page2.getResult().get(i);
			String userName=findUserName(cmlConnectInfos.getInPerson());
			cmlConnectInfos.setInPerson(userName);
		}
          return page2;
	 
		
	}
	
	/**
	 * 显示所有清分交接信息
	 * @tml 终端信息
	 * @Page  page 分页 
	 * */
	@Transactional(readOnly = true)
	public Page findCmlInfoPage(TermInfo tml,Page page) {
		String hql = "from TermInfo as tml where tml.termCode like '%"+tml.getTermCode()+"%' and tml.termType like '%"+tml.getTermType().trim()+"%'";
		hql += "  order by tml.termCode desc";


		return page;
	}
	
	/**
	 * 根据型号找到所有设备类型
	 * 
	 * @param model
	 * @return
	 */
	 public List<String> findByDevType(String model){
		 List<String> list=new ArrayList<String>();
		 if(org.springframework.util.StringUtils.hasText(model)){
		 
		 String hql =" select termCode  from TermInfo  where  model = '"+model+"'";
		 list=cmlConnectInfosDao.find(hql);
	    if(list.size()>0) {
	    	return list;
	    }
	    else {
			list=null;
		}
	    
		 }
		 
		 return list;
	 }
	 
		/**
		 * 根据id查询清分交接的信息
		 * */
		@Transactional(readOnly = true)
		public CmlConnectInfos getObject(String id) {
			CmlConnectInfos cmlConnectInfos= (CmlConnectInfos) cmlConnectInfosDao.get(id);
			
			String orgName=findOrgName(cmlConnectInfos.getComeOrg());
			String userName=findUserName(cmlConnectInfos.getInPerson());
			cmlConnectInfos.setComeOrg(orgName);
			cmlConnectInfos.setInPerson(userName);
			return cmlConnectInfos;
		}
		
		/**   找出属于该用户组的员工  **/
		public List<String> getUsrUsrgrp() {
			
			String sql = " select userId from UserGrp where grpId = '8a81da703bb0a8d2013bb0c0931c002d'";
			List<String> userid = userDao.find(sql);

			return userid;
		}
		/**
		 *选择操作员
		 */
		@Transactional(readOnly = true)
		public Page getOperatorPage(Page page,String userName) {
			List<String> userId = getUsrUsrgrp();
			StringBuffer sql = new StringBuffer(" from User where id in(  ");
			for (int i = 0; i < userId.size(); i++) {
				String u = (i == 0 ? "'" + userId.get(i) + "'" : ",'"
						+ userId.get(i) + "'");
				sql.append(u);
			}
			sql.append(" ) "); 
			if (null != userName && !userName.equals("")) {
			
				sql.append(" and userName like '%" + userName + "%'");
			}
			Page  page2=userDao.findPage(page,sql.toString());
			return page2;
		}
	/**
	 * 
	 * 根据用户id查找 name
	 * 
	 * */
		
		public String findUserName(String userCode){
			String hql=" select userName from User where userCode ='"+userCode +"'";
			String userName=null;
			List<String> li=cmlConnectInfosDao.find(hql);
			try
			{
			if(li.size()>0){
				userName=li.get(0);
			}
			}
			catch (NullPointerException e) {
				userName=null;
				logger.error("",e);
				
			}
			
			return userName;
		}
		/**
		 * 
		 * 根据用户id查找orgName
		 * 
		 * */
			
			public String findOrgName(String orgCode){
			
  
				String hql=" select orgName from OrgInfo where id='"+orgCode+"'";
				String orgName=null;
				List<String> li=cmlConnectInfosDao.find(hql);
				try{
				if(li.size()>0){
					orgName=li.get(0);
				}
				}
				catch (NullPointerException e) {
					orgName=null;
					logger.error("",e);
					// TODO: handle exception
				}
				return orgName;
			}
}
