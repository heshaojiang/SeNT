package com.grgbanking.cml.task.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.cml.cmlConnectInfos.entity.CmlConnectInfos;
import com.grgbanking.cml.task.entity.CmlTaskInfos;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.utils.DateUtils;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.security.entity.User;
import com.grgbanking.platform.module.term.entity.TermInfo;

@Repository
public class CmlTaskInfosDao  extends BaseDao{

	
	@Autowired
		CmlImpRecordsDao cmlImpRecordsDao;
	@Autowired
	CmlSentInfosDao cmlSentInfosDao;
	@Autowired
	OrgInfoDao orgInfoDao;
	
	
	/**
	 * @param page 页面参数
	 * @param tmlnum 设备编号
	 * @param operatorName 操作人员
	 * @param moneySource  来源机构
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return Page 实体页 
	 * 
	 */
	
 
	//查询出page页
	public Page<CmlTaskInfos> getCmlTaskInfosPage(Page page,String tmlNum, 
				String operatorName,String moneySource,
				String startTime,String endTime){
		Page result  = new Page();
		List<Object> values= new ArrayList<Object>();
	
		StringBuffer sql = new StringBuffer(" from CmlTaskInfos cml  where 1=1"  );
		if( null != tmlNum && !"".equals(tmlNum.trim())  ){
			 sql.append( " and tmlNum  like  ? ");	
			 values.add("%"+tmlNum+"%");
		}
		if(null != operatorName && !"".equals(operatorName.trim()) ) {
			
			sql.append("  and  exists (Select 'X' from User u  where cml.operatorId = u.userCode  and  u.userName like  ? ) ");
			values.add("%"+operatorName+"%");
		}
		if(null !=moneySource && !"".equals(moneySource.trim())  ){
			
			sql.append("  and exists ( select 'Z' from OrgInfo o where  cml.pathcode = o.pathCode and o.pathCode like   ?  ) ");
			values.add(orgInfoDao.get(moneySource).getPathCode()+"%");	
		}
	
		if(null !=startTime  && !"".equals(startTime.trim())){
			sql.append( " and  cml.operateDate  >= TO_DATE(? ,'yyyy-MM-dd HH24:mi:ss')");
			values.add(startTime);
			
		}
		if(null !=endTime && !"".equals(endTime.trim())){
			sql.append( " and  cml.operateDate  <=TO_DATE(? ,'yyyy-MM-dd HH24:mi:ss')");
			values.add(endTime);	
		}
		if(values.size() >  0){

		result=  findPage(page, sql.toString(),values.toArray());
	
		}
		else{
			result = findPage(page, sql.toString());
	
		}
	
	
			return result;
	}
	//根据任务安排的时间刷选出可选的人员
	public Page<User> getUserToCmlTaskInfos(Page<User> page,String id, String operatorName,String startTime, String endTime) {
		StringBuffer hql = new StringBuffer(" from User  u where 1=1");
		List<Object> values = new ArrayList<Object>();
		int i = 0;
		 if( null != id){
			 if(!"".equals(id.trim())){ 
				  hql.append(" or  exists ( select 'X' from CmlTaskInfos cm where u.userCode = cm.operatorId and cm.id = ? ) ");				  
				 values.add(id);
			 } 
		 }
		 if(null != operatorName){
			 if(!"".equals(operatorName.trim())){
				 hql.append( " and  exists ( select 'K' from CmlTaskInfos  cmmm where u.userCode  = cmmm.operatorId  and u.userName like ? )  ");
				 values.add("%"+operatorName+"%");
			 }
		 }

	 if(null != startTime){
		 if(!"".equals(startTime.trim())){
			 i++;
		 }
	 }
	 if(null != endTime){
		 if(!"".equals(endTime.trim())){
			 i =i+2;
			 }
	 }
	 //两个时间存在单一存在 ，保证绑定时间前后都不相等即可，两个时间都存在 调用between函数进行计算 
	 switch (i) {
	case 0:
		break;
	case 1:
		 hql.append(" and not exists ( select 'V' from CmlTaskInfos  cml where u.userCode  = cml.operatorId  ");
		 hql.append(" and cml.bindStart != TO_DATE(? ,'yyyy-MM-dd HH24:mi:ss') " );
		 values.add(startTime);
		 hql.append(" and cml.bindEnd != TO_DATE(?,'yyyy-MM-dd HH24:mi:ss')) ");
		 values.add(startTime);
		
		break;
		
	case 2:
		 hql.append(" and not exists ( select 'B' from CmlTaskInfos  cml where u.userCode  = cml.operatorId  ");
		 hql.append(" and cml.bindStart != TO_DATE(? ,'yyyy-MM-dd HH24:mi:ss') " );
		 values.add(endTime);
		 hql.append(" and cml.bindEnd != TO_DATE(?,'yyyy-MM-dd HH24:mi:ss')) ");
		 values.add(endTime);
		
		break;
	case 3:
		 hql.append(" and not exists ( select 'N' from CmlTaskInfos  cml where u.userCode  = cml.operatorId ");
		 hql.append(" and ( cml.bindStart between( TO_DATE(? ,'yyyy-MM-dd HH24:mi:ss'))  " );
		 values.add(startTime);
		 hql.append(" and  TO_DATE(?,'yyyy-MM-dd HH24:mi:ss') ");
		 values.add(endTime);
		 hql.append(" or ( cml.bindEnd between (TO_DATE(? ,'yyyy-MM-dd HH24:mi:ss')) " );
		 values.add(startTime);
		 hql.append(" and  TO_DATE(?,'yyyy-MM-dd HH24:mi:ss'))))  ");
		 values.add(endTime);
		 break;
	default:
		break;
	}
	 System.out.println(hql.toString());
		return super.findPage(page, hql.toString(),values.toArray());
	}

	//根据任务安排的时间刷选出可选的设备
	public Page<TermInfo> getTermToCmlTaskInfos(Page<TermInfo> page,String id,String tmlNum,String startTime, String endTime){
	
		int i = 0;
		StringBuffer hql = new StringBuffer(" from TermInfo t where 1=1");
		List<Object> values = new ArrayList<Object>();
		 if( null != id){
			 if(!"".equals(id.trim())){ 
				  hql.append(" or   exists ( select 'X' from CmlTaskInfos cm where cm.tmlNum = t.termCode and cm.id = ? ) ");				  
				 values.add(id);
			 }  
		}	 
		 if(null != tmlNum){
			 if(!"".equals(tmlNum)){
				 hql.append(" and   exists ( select 'Z' from  TermInfo ter  where ter.id= t.id and ter.termCode like  ? ) ");
				 values.add("%"+tmlNum+"%"); 
			 }
		 }
	 if(null != startTime){
		 if(!"".equals(startTime.trim())){
			i++;
		 }
	 }
	 if(null != endTime){
		 if(!"".equals(endTime.trim())){
		   i = i+2;
		 }
	 }
	 switch (i) {
		case 0:
			break;
		case 1:
			 hql.append(" and not exists ( select 'V' from CmlTaskInfos  cml where  t.termCode = cml.tmlNum  ");
			 hql.append(" and cml.bindStart != TO_DATE(? ,'yyyy-MM-dd HH24:mi:ss') " );
			 values.add(startTime);
			 hql.append(" and cml.bindEnd != TO_DATE(?,'yyyy-MM-dd HH24:mi:ss')) ");
			 values.add(startTime);
			
			break;
			
		case 2:
			 hql.append(" and not exists ( select 'B' from CmlTaskInfos  cml where  t.termCode = cml.tmlNum  ");
			 hql.append(" and cml.bindStart != TO_DATE(? ,'yyyy-MM-dd HH24:mi:ss') " );
			 values.add(endTime);
			 hql.append(" and cml.bindEnd != TO_DATE(?,'yyyy-MM-dd HH24:mi:ss')) ");
			 values.add(endTime);
			
			break;
		case 3:
			 hql.append(" and not exists ( select 'N' from CmlTaskInfos  cml where t.termCode = cml.tmlNum ");
			 hql.append(" and ( cml.bindStart between( TO_DATE(? ,'yyyy-MM-dd HH24:mi:ss'))  " );
			 values.add(startTime);
			 hql.append(" and  TO_DATE(?,'yyyy-MM-dd HH24:mi:ss') ");
			 values.add(endTime);
			 hql.append(" or ( cml.bindEnd between (TO_DATE(? ,'yyyy-MM-dd HH24:mi:ss')) " );
			 values.add(startTime);
			 hql.append(" and  TO_DATE(?,'yyyy-MM-dd HH24:mi:ss'))))  ");
			 values.add(endTime);
			break ; 
		default:
			break;
		}
	 System.out.println(hql.toString());
	 return  findPage(page,hql.toString(), values.toArray());
		
	}

	/**
	 * 保存数据时候，查看是否与系统内已有的设备，人时间产生冲突
	 * id判断是新增还是修改时候 
	 */
	
	public int  checkOpaertorIdAndTmlNum(String id,String operatorId, String tmlNum, String startTime,String endTime){
		List<Object > values = new ArrayList<Object>();
		StringBuffer hql  =new StringBuffer( " select count(*) from CmlTaskInfos cml where 1=1 ");
		 if( null != id){
			 if(!"".equals(id.trim())){ 
				  hql.append(" and not exists ( select 'X' from CmlTaskInfos cm where cml.id = cm.id and cm.id = ? ) ");				  
				 values.add(id);
			 } 
		 }	 
		 /**
		  * 
 select count(*) from cml_task_infos cml where 1=1  and cml.c_operator_id ='develop' 
and ((cml.d_bind_start  between (to_date('2013-02-27 14:13:14','yyyy-MM-dd HH24:mi:ss'))
and  to_date('2013-02-28 14:13:16','yyyy-MM-dd HH24:mi:ss'))  
 or  ( cml.c_operator_id ='develop' and cml.d_bind_end between (to_date('2013-02-27 14:13:14','yyyy-MM-dd HH24:mi:ss'))
and  to_date('2013-02-28 14:13:16','yyyy-MM-dd HH24:mi:ss') ))
		  * 
		  * */
		 if(null != operatorId){
			 if(!"".equals(operatorId.trim())){
				 hql.append(" and cml.operatorId = ? ");	
				 values.add(operatorId);
				 hql.append("  and ((cml.bindStart  between (to_date(?,'yyyy-MM-dd HH24:mi:ss')) and  to_date(?,'yyyy-MM-dd HH24:mi:ss'))  ");
				 values.add(startTime);
				 values.add(endTime);
				 hql.append("  or (cml.bindEnd between (to_date(?,'yyyy-MM-dd HH24:mi:ss')) and  to_date(?,'yyyy-MM-dd HH24:mi:ss'))) ");
				 values.add(startTime);
				 values.add(endTime);
			 }
		 }
		 if(null != tmlNum){ 
			 if(!"".equals(tmlNum.trim())){
				 hql.append(" and cml.tmlNum = ? ");
				 values.add(tmlNum);
				 hql.append("  and ((cml.bindStart  between (to_date(?,'yyyy-MM-dd HH24:mi:ss')) and  to_date(?,'yyyy-MM-dd HH24:mi:ss'))  ");
				 values.add(startTime);
				 values.add(endTime);
				 hql.append("  or (cml.bindEnd between (to_date(?,'yyyy-MM-dd HH24:mi:ss')) and  to_date(?,'yyyy-MM-dd HH24:mi:ss'))) ");
				 values.add(startTime);
				 values.add(endTime);
				
			 }
		 }
 try {
	return Integer.parseInt (findUnique(hql.toString(), values.toArray()).toString());
} catch (Exception e) {
	e.printStackTrace();
	// TODO: handle exception
}
return 0;

}
	/** 自动生成主键策略  原子锁操作 * */

	public  String Genertory(String example) {
	
	 Lock lock = new ReentrantLock();
	 lock.lock();
	 String result = null;
	 try {
		String sql = " select max(taskNum)  from  CmlTaskInfos  where  taskNum like '"
				+ example + "_" + "%'";
		List find = find(sql);
		List<String> l = find;
		String value = l.get(0);
		if (value != null) {
			int ss = value.indexOf("_");
			if(ss!= -1){
			result = String.valueOf(Long.parseLong(value.replace('_', '0')) + 1);
			result = result.substring(0, ss) + "_" + result.substring(ss+1,result.length());
	}
		
			return result;
		} else {
			StringBuffer temp = new StringBuffer();
			for (int i = 0; i < 4; i++) {
				int u = (i == 3 ? 1 : 0);
				temp.append(u);
			}
			result = example + "_" + temp.toString();
		}
		}finally{
			lock.unlock();
			
		}
		return result;
		}

	public Page<CmlConnectInfos> findTConnToCmlTaskInfos(
			Page<CmlConnectInfos> page, String inPerson,String comeOrg,String bindStart, String bindEnd) {
				StringBuffer sql = new StringBuffer(" from CmlConnectInfos cml  where cml.flag != '2' ");
				if (null != comeOrg) {
					if(!"".equals(comeOrg.trim())){
						comeOrg =orgInfoDao.get(comeOrg).getOrgCode();
					sql.append( " and exists ( select 'Z' from OrgInfo o where  cml.comeOrg = o.pathCode and o.pathCode like  '"+comeOrg+"%'  ) ");

				}
				if (null !=bindStart  ) {
					if(!"".equals(bindStart.trim())){
						DateUtils.toDate(bindStart);
					sql.append(" and connDate  >= to_date('" + bindStart
							+ "','yyyy-MM-dd HH24:mi:ss') ");
					}

				}
				if (null != bindEnd){			
					if(!"".equals(bindEnd.trim()))
					sql.append(" and connDate <= to_date('" + bindEnd
							+ "','yyyy-MM-dd HH24:mi:ss') ");
				}
				/*
				 * sql.append(" and connDate like ('" + connDate + "','yyyy-MM-dd
				 * HH24:mi:ss') ");
				 */
				if(null != inPerson){
					 if(!"".equals(inPerson.trim())){ 
						 sql.append( " and exists ( select 'F' from User  u where u.userCode = cml.inPerson  and  u.userName like '"+inPerson+"%' )");
					 }
				   }
				}	
			logger.info(sql.toString());
				return findPage(page, sql.toString());
			}

	
   public boolean checkTaskCanDelteByImp(String taskNum){
	   return Integer.parseInt(findUnique(" select count(*) from CmlTaskInfos task where exists ( select 'Z' from CmlImpRecords imp" +
	   		" where imp.taskId = task.taskNum and  task.taskNum = '"+taskNum+"' ) ").toString()) > 0 ? false : true;
	   
   }
   
   public void delete(String taskNum){

	   String sql = " delete from CmlTaskInfos where taskNum = '"+taskNum+"'" ;
	   super.executeUpdate(sql);
	   
   }
   public CmlTaskInfos getCmlTaskInfosByTmlNum(String taskNum){
	   String sql = " from CmlTaskInfos where taskNum = '"+taskNum+"'";
	  return  (CmlTaskInfos) findUnique(sql);
	   
	   
   }
   public CmlTaskInfos getCmlTaskInfosByTaskNum(String taskNum){
	   String sql = " from CmlTaskInfos where taskNum = '"+taskNum+"'";
	  return  (CmlTaskInfos) findUnique(sql);
	   
	   
   }
   public CmlTaskInfos getCmlTaskInfosById(String id){
	   String sql = " from CmlTaskInfos  cml where cml.id =  ? ";
	  return  (CmlTaskInfos) findUnique(sql,new String[]{id});
	   
	   
   }
public void updateObject(CmlTaskInfos cmlTaskInfos) {
	Lock  lock = new ReentrantLock();
	try {
		lock.lock();
		if( null != cmlTaskInfos){	
			super.save(cmlTaskInfos);
			}
	} finally{
	lock.unlock();	
		
	}
	}

	// TODO Auto-generated method stub
	

public static List parseCsvForInputStream(java.io.InputStream in)
{
	throw new RuntimeException("*****************************");
//	List count = new ArrayList();
//	String[] str = {};
//	com.csvreader.CsvReader reader = null;
//	try {
//		reader = new com.csvreader.CsvReader(in, ',', Charset.forName("GBK"));
//
//		while (reader.readRecord()) {
//			str = reader.getValues();
//			if (str != null && str.length > 0) {
//				if (str[0] != null && !"".equals(str[0].trim())) {
//					count.add(str);
//				}
//			}
//		}
//	
//		return count;
//
//	} catch (Exception e) {
//		e.printStackTrace();
//	
//		return null;
//
//	} finally {
//		reader.close();
//	}
}



/**解析任务 */


   public CmlTaskInfos parseTaskInfos(final byte[] datas,String usercode,String orgid){
	  CmlTaskInfos cmlTaskInfos = null;
	  ByteArrayInputStream in  = null;
	  try {
		  	in = new ByteArrayInputStream(datas);
		  	List l = parseCsvForInputStream(in);
	
		  	String[] temp =  (String[])l.get(1);
		  	if ( null != getCmlTaskInfosByTaskNum(temp[18])) {
		  	}else{
		 cmlTaskInfos  = new CmlTaskInfos();
		 cmlTaskInfos.setOperatorId(usercode);
		 cmlTaskInfos.setOrgId(orgid);
		 cmlTaskInfos.setPathcode(orgInfoDao.get(orgid).getPathCode());
		 if (!"".equals(temp[3].trim())) {
		cmlTaskInfos.setBoxNum(temp[3]);
		 }
		 cmlTaskInfos.setTmlNum(temp[0].toString());
	if (!"".equals(temp[4].toString().trim())) {
		cmlTaskInfos.setBeforeCount(new BigDecimal(temp[4]));
	}
	if (!"".equals(temp[5].toString().trim())) {
		cmlTaskInfos.setBindStart(DateUtils.toDate(temp[5]));
	}
	if (!"".equals(temp[6].toString().trim())) {
		cmlTaskInfos.setBindEnd(DateUtils.toDate(temp[6]));
	}
	if (!"".equals(temp[7].toString().trim())) {
		cmlTaskInfos.setMemo(temp[7].toString());
	}
	if (!"".equals(temp[9].toString().trim())) {
		cmlTaskInfos.setAtmMoney(new BigDecimal(temp[9]));
	}
	if (!"".equals(temp[10].toString().trim())) {
		cmlTaskInfos.setPassMoney(new BigDecimal(temp[10]));
	}
	if (!"".equals(temp[11].toString().trim())) {
		cmlTaskInfos.setStubbedMoney(new BigDecimal(temp[11]));
	}
	if (!"".equals(temp[12].toString().trim())) {
		cmlTaskInfos.setTrailMoney(new BigDecimal(temp[12]));
	}
	if (!"".equals(temp[13].toString().trim())) {
		cmlTaskInfos.setShadinessMoney(new BigDecimal(temp[13]));
	}
	if (!"".equals(temp[14].toString().trim())) {
		cmlTaskInfos.setFalseCoinMoney(new BigDecimal(temp[14]));
	}
	if (!"".equals(temp[15].toString().trim())) {
		cmlTaskInfos.setTotalMoney(new BigDecimal(temp[15]));
	}
	cmlTaskInfos.setOperateDate(new Date());


	if (!"".equals(temp[17].toString().trim())) {
		cmlTaskInfos.setTransResult(temp[17]);
	}
	if (!"".equals(temp[18].toString().trim())) {
		cmlTaskInfos.setTaskNum(temp[18].toString());
	}
		saveNew(cmlTaskInfos);
		
	}
	} catch (Exception e) {
		e.printStackTrace();
	
		// TODO: handle exception
	}finally{
		 try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
	
	return cmlTaskInfos;
	   
   }
  
}
