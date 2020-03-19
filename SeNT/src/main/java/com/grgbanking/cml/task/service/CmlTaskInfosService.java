package com.grgbanking.cml.task.service;



import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.cml.cmlConnectInfos.dao.CmlConnectInfosDao;
import com.grgbanking.cml.cmlConnectInfos.entity.CmlConnectInfos;
import com.grgbanking.cml.task.dao.CmlImpRecordsDao;
import com.grgbanking.cml.task.dao.CmlTaskInfosDao;
import com.grgbanking.cml.task.entity.CmlImpRecords;
import com.grgbanking.cml.task.entity.CmlTaskInfos;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.platform.module.security.entity.User;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.platform.module.term.dao.TermModelDao;
import com.grgbanking.platform.module.term.entity.TermInfo;

import flex.messaging.FlexContext;

@Service
@Transactional
public class CmlTaskInfosService extends BaseService {

	@Autowired
	CmlTaskInfosDao cmlTaskInfosDao;

	@Autowired
	OrgInfoDao orgInfoDao;

	@Autowired
	UserDao userDao;
	@Autowired
	CmlConnectInfosDao cmlConnectInfosDao;
	
	@Autowired
	TermInfoDao termInfoDao;
	@Autowired
	
	CmlImpRecordsDao cmlImpRecordsDao;
	@Autowired 
	CmlSentInfosService cmlSentInfosService;
	@Autowired
	
	TermModelDao termModelDao;
 
	/**
	 * 
	 * 根据条件查询结果
	 * @param page page实体
	 * @param  tmlNum 设备编号
	 * @param operatorName 操作员 
	 * 
	 * 
	 * */
	public  Page<CmlTaskInfos> findCmlTaskInfosPage(Page page, String tmlNum,
			String operatorName, String moneySource, String startTime,
			String endTime) {
		try {
			page = cmlTaskInfosDao.getCmlTaskInfosPage(page, tmlNum,
					operatorName, moneySource, startTime, endTime);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return page; 

	}

	// 保存数据
	
	/**
	 * 修改了交接的就产生更新两个交接实体
	 * 
	 */
	public int SaveCmlTaskInfos(CmlTaskInfos cmlTaskInfos,CmlConnectInfos cmlConnectInfos) {
		int result = 0;
		try {
			if(cmlTaskInfos.getId() == null){
				 cmlTaskInfos.setTaskNum(cmlTaskInfosDao.Genertory(cmlTaskInfos.getConnId()));
				 cmlTaskInfos.setPathcode(orgInfoDao.getPathCodeById(cmlTaskInfos.getOrgId()));
			}
			cmlTaskInfos.setOperateDate(new java.util.Date());
             if(!cmlConnectInfos.getConnNum().equals(cmlTaskInfos.getConnId())) {
            	 cmlTaskInfos.setTaskNum(cmlTaskInfosDao.Genertory(cmlTaskInfos.getConnId()));
            	 CmlConnectInfos cmlConnectInfos2 = cmlConnectInfosDao.getCmlConnectInfosByConnNum(cmlTaskInfos.getConnId());
            	 cmlConnectInfos2.setNoAllotMoney(cmlConnectInfos2.getNoAllotMoney().subtract(cmlTaskInfos.getBeforeCount()));
            	 cmlConnectInfosDao.update(cmlConnectInfos2);
            	 cmlConnectInfosDao.update(cmlConnectInfos); 
             } else{
            	 cmlConnectInfos.setNoAllotMoney(cmlConnectInfos.getNoAllotMoney().subtract(cmlTaskInfos.getBeforeCount())  );
            	 cmlConnectInfosDao.update(cmlConnectInfos);
             } 
             	cmlTaskInfosDao.save(cmlTaskInfos);
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 查询清分交接
	
	@Transactional(readOnly = true)
	public Page<CmlConnectInfos> findConnectToCmlTaskInfos(
			Page<CmlConnectInfos> page, String inPerson, String commOrg,
			String startTime, String endTime) {

		Page<CmlConnectInfos> ConnectInfos = new Page<CmlConnectInfos>();
		try {
		
			ConnectInfos = cmlTaskInfosDao.findTConnToCmlTaskInfos(page,
					inPerson, commOrg, startTime, endTime);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return ConnectInfos;

	}

	// 转换usercode 转 username
	public User getCmlTaskInfosOperatorName(String usercode) {
		return userDao.getByUserCode(usercode);
	}

	// 根据时间查询可用的人
	@Transactional(readOnly = true)
	public Page<User> findUserToCmlTaskInfos(Page<User> page, String id,
			String operatorName, String startTime, String endTime) {

		Page<User> users = new Page<User>();
		try {
			users = cmlTaskInfosDao.getUserToCmlTaskInfos(page, id,
					operatorName, startTime, endTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;

	}
	@Transactional(readOnly = true)
	public Page<TermInfo> findTermInfoToCmlTaskInfos(Page<TermInfo> page,
			String id, String tmlNum, String startTime, String endTime) {
		Page<TermInfo> TermInfos = new Page<TermInfo>();
		try {
			TermInfos = cmlTaskInfosDao.getTermToCmlTaskInfos(page, id, tmlNum,
					startTime, endTime);
		} catch (NullPointerException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return TermInfos;

	}

	// 删除
	public  Map deleteSelectedTask(String[] ids) {
	   Map result = new HashMap< String ,String >();
		try {
			if (ids.length > 0) {
				for (String id : ids) {
					if (null != id) {
						if (!"".equals(id)) {
							if (cmlTaskInfosDao.checkTaskCanDelteByImp(id)) {
								CmlTaskInfos cml =cmlTaskInfosDao.getCmlTaskInfosByTmlNum(id);
								if(null != cml.getConnId()){ 
								cmlConnectInfosDao.update(getCmlConnectInfosByConnNum(cml));
								}
								cmlTaskInfosDao.delete(id);
								if( null ==result.get("success")){
									result.put("success", id);	
								} else{
									result.put("success", result.get("success") + ","+ id);	
								}
								
							} else {
								if( null ==result.get("error")){
									result.put("error", id);
									
								} else{
									result.put("error", result.get("error") + ","+ id);
									
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
		
 return result;
	}

	// 验证人和设备在该时间段可用
	@Transactional(readOnly = true)
	public int checkOperatorIdAndTmlNum(String id, String operatorId,
			String tmlNum, String startTime, String endTime) {
		int result =  1;
		result += cmlTaskInfosDao.checkOpaertorIdAndTmlNum(id, operatorId,
				null, startTime, endTime) > 0 ? 2 :0;		
		result +=  cmlTaskInfosDao.checkOpaertorIdAndTmlNum(id, null, tmlNum,
				startTime, endTime) > 0 ?  3 : 0;
		return result;
		
	}

	//根据交接编号 得到 
	@Transactional(readOnly = true)
	public CmlConnectInfos getCmlConnectInfosByConnNum(CmlTaskInfos vo) {
		    
			CmlConnectInfos cmc=cmlConnectInfosDao.getCmlConnectInfosByConnNum(vo.getConnId());
			
			 if(null !=cmc)
				 cmc.setNoAllotMoney(cmc.getNoAllotMoney().add(vo.getBeforeCount()));
			return cmc;
	}
	@Transactional(readOnly = true)
	public Map<String,String> loadImp(CmlTaskInfos vo){
		Map<String ,String> result= new HashMap<String, String>();
	    
		try {
			try {
				String operatorName = userDao.getByUserCode(vo.getOperatorId()).getUserName();
				result.put("operatorName", operatorName);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				String orgInfoName = ((OrgInfo)orgInfoDao.findUnique("from OrgInfo where id ='"+vo.getOrgId()+"'")).getOrgName();
				result.put("orgInfoName", orgInfoName);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
			 String tmlType = 	termModelDao.get(termInfoDao.getByTermCode(vo.getTmlNum()).getModel()).getModelName();
			 result.put("tmlType", tmlType);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
		/*	result.put("operatorName", userDao.getByUserCode(vo.getOperatorId()).getUserName());
		    result.put("orgInfoName",((OrgInfo)orgInfoDao.findUnique("from OrgInfo where pathCode ='"+vo.getOrgId()+"'")).getOrgName());
		    result.put("tmlType",null ==termModelDao.get(termInfoDao.getByTermCode(vo.getTmlNum()).getModel()).getModelName() ? null: termModelDao.get(termInfoDao.getByTermCode(vo.getTmlNum()).getModel()).getModelName() );*/
		} catch (Exception e) {
			logger.error("",e);
			// TODO: handle exception
		}
	    return result;
		
		
	}
	
	/**
	 *  @param data 数据
	 *  @param  vo CmlTaskInfos
	 *  @param devMode 设备型号
	 *  @return List<CmlImpRecords>
	 * 
	 */
	
	
	public List<CmlImpRecords> ImpRecords(List<Object[]> data, CmlTaskInfos vo, String devMode)
	{

		List<CmlImpRecords> result = new LinkedList<CmlImpRecords>();
		for( int i = 0 ; i < data.size() ; i++ )
		{
			Object[] temp = data.get(i);

			byte[] da = (byte[]) temp[0];
			String oldname = temp[1].toString();
			Integer j = Integer.parseInt(temp[2].toString());
			result.add(ImpRecords(da, vo, devMode, oldname, j));

		}

		return result;

	}

	public CmlImpRecords ImpRecords(byte[] datas, CmlTaskInfos vo, String devMode, String oldName, int i)
	{
		boolean flag = false;

		final String pathcode = vo.getPathcode();
		CmlImpRecords cmlImpRecords = new CmlImpRecords();
		cmlImpRecords.setTaskId(vo.getTaskNum());
		cmlImpRecords.setTmlNum(vo.getTmlNum());
		cmlImpRecords.setImpDate(new Date());
		cmlImpRecords.setOperaterId(vo.getOperatorId());
		String filePath = cmlImpRecordsDao.CreatefilePath(vo.getTmlNum());
		String newName = cmlImpRecordsDao.GenertoryFileName(vo.getTmlNum(), vo.getTaskNum(), oldName, 0);
		String url = cmlImpRecordsDao.upload(datas, filePath, oldName, newName);
		cmlImpRecords.setNewName(newName);
		cmlImpRecords.setOldName(oldName);
		cmlImpRecords.setFileDir(url);

		url = FlexContext.getServletContext().getRealPath(File.separator + url);
		if( i > 0 )
		{
			vo = cmlTaskInfosDao.getCmlTaskInfosById(vo.getId());
		}
		synchronized (vo)
		{
			if( null == devMode )
			{
				cmlImpRecords.setOperateStatus("1");
				cmlImpRecords.setTaskId(vo.getTaskNum());
				saveCmlImpRecords(cmlImpRecords);
				return cmlImpRecords;
			}
			if( devMode.trim().equals("CM2000") )
			{
				flag = cmlSentInfosService.addALlCmlSentInfosByCM2000(vo, url, cmlImpRecords.getOldName(), pathcode);
			}
			else if( devMode.trim().equals("UW500") )
			{
				flag = cmlSentInfosService.addALlCmlSentInfosByUW500(vo, url, pathcode);
			}
			else if( devMode.trim().equals("CM400") )
			{
				flag = cmlSentInfosService.addALlCmlSentInfosByCM400(vo, url, pathcode);
			}
			else
			{
				flag = false;

			}
		}

		if( flag )
		{
			cmlImpRecords.setOperateStatus("0");
		}
		else
		{
			cmlImpRecords.setOperateStatus("1");
		}
		saveCmlImpRecords(cmlImpRecords);

		return cmlImpRecords;
}
	
/*	public CmlImpRecords  returnCmlImpRecords(CmlImpRecords cmlImpRecords, CmlTaskInfos cmlTaskInfos,String devMode){
		boolean  flag = false;
		try {
		String  url = FlexContext.getServletContext().getRealPath(File.separator+cmlImpRecords.getFileDir());
		
		 cmlTaskInfos = cmlTaskInfosDao.getCmlTaskInfosByTmlNum(cmlTaskInfos.getTaskNum());
		flag =	cmlSentInfosService.addALlCmlSentInfosByCM2000(cmlTaskInfos, url, cmlImpRecords.getOldName()) ;
		if(flag) {
			cmlImpRecords.setOperateStatus("0");
		  cmlImpRecordsDao.save(cmlImpRecords);
		}else{
		
		}
		

			
		} catch (Exception e) {
			logger.error("",e);
			// TODO: handle exception
		}
	
	  return cmlImpRecords;
	}
	*/
	
	public  List checkFileName(List<Object[]> arrmap,String taskNum){
	
	LinkedList result = new LinkedList();
		for (int i = 0; i < arrmap.size(); i++) {
				Object[] str = arrmap.get(i);
				String oldName = null;
				if( null != str[2]){
				 oldName = str[2].toString();
				}
                 int a = checkFileName(str[1].toString(),taskNum,oldName);
                  if(a > 0){
                	 result.add(str[0]);
                  }
                 }
		return result;
		}
		

	
	
	public   int checkFileName(String  fileName ,String taskNum ,String oldName ){
		List<String> args = new ArrayList<String>();
		StringBuffer sql =new StringBuffer( "select  count(*) from   CmlImpRecords cmlImp where cmlImp.taskId =  ? and cmlImp.oldName  = ?  ");
		args.add(taskNum);
		args.add(fileName);
		if( null != oldName&& !"".equals(oldName.trim())){
			sql.append(" and  not exists ( select 'Z' from CmlImpRecords cmlImp2  where cmlImp2.id =cmlImp.id and cmlImp2.oldName = ? ) ");
			args.add(oldName);	
		}
			int b =	Integer.parseInt(cmlImpRecordsDao.findUnique(sql.toString(), args.toArray()).toString()) ;
			return b;
		}
	
	
	
	
	public Page<CmlImpRecords> findCmlImpRecordsPageForTask( Page<CmlImpRecords> page,String taskNum,String fileName,String beginTime,String endTime){
		
		Page<CmlImpRecords> result = new Page<CmlImpRecords>();
		try {
			result = cmlImpRecordsDao.findCmlImpRecordsPageForTask(page,  taskNum, fileName, beginTime, endTime);
		} catch (Exception e) {
			throw new RuntimeException("查询错误 ，请重新再试");
			// TODO: handle exception
		}
		
		
		
		return result;
		
	}
	
	
	/**根据文件导入任务*/
	public CmlTaskInfos importTask(final byte[] datas,String usercoed,String orgid){
		return cmlTaskInfosDao.parseTaskInfos(datas,usercoed,orgid);	 
	}
	
	/**重新更新导入*/
	
	public CmlImpRecords updateImpRecords(CmlImpRecords cmlImpRecords, CmlTaskInfos cmlTsCmlTaskInfos, byte[] datas, String name, String tmltype)
	{
		boolean flag = false;
		cmlImpRecordsDao.upload(datas, cmlImpRecords.getFileDir().substring(0, cmlImpRecords.getFileDir().lastIndexOf(File.separator)), name, cmlImpRecords.getNewName());
		String url = FlexContext.getServletContext().getRealPath(File.separator) + cmlImpRecords.getFileDir();
		final String pathCode = cmlTsCmlTaskInfos.getPathcode();
		synchronized (cmlTsCmlTaskInfos)
		{
			if( null != tmltype )
			{
				if( tmltype.trim().equals("CM2000") )
				{
					flag = cmlSentInfosService.addALlCmlSentInfosByCM2000(cmlTsCmlTaskInfos, url, cmlImpRecords.getOldName(), pathCode);
				}
				else if( tmltype.trim().equals("UW500") )
				{
					flag = cmlSentInfosService.addALlCmlSentInfosByUW500(cmlTsCmlTaskInfos, url, pathCode);
				}
				else if( tmltype.trim().equals("CM400") )
				{
					flag = cmlSentInfosService.addALlCmlSentInfosByCM400(cmlTsCmlTaskInfos, url, pathCode);
				}
				else
				{
					flag = false;
				}
			}
			else
			{
				flag = false;
			}
		}
		cmlImpRecords.setOldName(name);
		if( flag )
		{
			cmlImpRecords.setOperateStatus("0");
		}
		else
		{
			cmlImpRecords.setOperateStatus("1");
		}
		cmlImpRecordsDao.copyUpdate(cmlImpRecords);
		return cmlImpRecords;
	}
	
	public void saveCmlImpRecords(CmlImpRecords cmlImpRecords){
		 try {
			 cmlImpRecordsDao.save(cmlImpRecords);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	}

		
		
		
		
	
	

