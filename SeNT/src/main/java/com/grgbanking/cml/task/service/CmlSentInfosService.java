package com.grgbanking.cml.task.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.cml.task.dao.CmlImpRecordsDao;
import com.grgbanking.cml.task.dao.CmlSentInfosDao;
import com.grgbanking.cml.task.dao.CmlTaskInfosDao;
import com.grgbanking.cml.task.entity.CmlSentInfos;
import com.grgbanking.cml.task.entity.CmlTaskInfos;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.sent.utils.DateUtil;

@Service
@Transactional
public class CmlSentInfosService extends BaseService {
	@Autowired
	CmlSentInfosDao cmlSentInfosDao;
	@Autowired
	CmlTaskInfosDao cmlTaskInfosDao;
	
	@Autowired
	CmlImpRecordsDao cmlImpRecordsDao;

	
	private static final Integer[]  checkModCM2000= {8,1,0,4,1,1,10,11,1};
 
	private static final Integer[] checkModUW500= {3,1,4,10,0,3};

	private static final Integer[] checkModCM400 = {8,0,2,1,1,10,0,0,9,0,1,0,0,0,0,0,0,0,14,0,1,4};

	public void addObjectByImport(CmlSentInfos cmlSentInfos) throws SQLException{
		 cmlSentInfosDao.save(cmlSentInfos);	
	}
	/**
	  *CM2000
	  *
	  */
	@Transactional
	public  boolean addALlCmlSentInfosByCM2000(CmlTaskInfos cmlTaskInfos,String url, String fileName, String pathcode)
	{
		boolean falg = false;

		try
		{
			String sourceOrg = cmlTaskInfos.getOrgId();
			String taskId = cmlTaskInfos.getTaskNum();
			String tmlNum = cmlTaskInfos.getTmlNum();

			String Tid = cmlTaskInfos.getId();
			Date dd = new Date();
			String s = DateUtil.getyyyyMMddDate(dd).substring(0, 4);
			String transDate = s + fileName.substring(1, 5);
			// 计算当次导入得到的ATM币数量
			Integer A = 0;
			// 计算当次导入得到的流通钞数量
			Integer B = 0;
			// 计算当次得到的回笼钞数量
			Integer C = 0;
			List list = cmlImpRecordsDao.parseCsv(url);
			for( int j = 1 ; j < list.size() ; j++ )
			{
				String[] entity = (String[]) list.get(j);
				/*
				 * if(j == 1){ falg = checkMod(checkModCM2000, entity); }
				 */

				if( entity[4].equals("0") )
				{
					A += Integer.parseInt(entity[3]);
				}
				else if( entity[4].equals("1") )
				{
					B += Integer.parseInt(entity[3]);
				}
				else if( entity[4].equals("2") )
				{
					C++;
				}
				CmlSentInfos cmlSentInfos = new CmlSentInfos();
				cmlSentInfos.setPathcode(pathcode);
				cmlSentInfos.setImpFlag("0");
				cmlSentInfos.setTermId(tmlNum);
				cmlSentInfos.setOrgId(sourceOrg);
				cmlSentInfos.setMoneyType(entity[5]);
				cmlSentInfos.setImpFlag("0");
				cmlSentInfos.setNoteType(entity[8]);
				cmlSentInfos.setDenomination(entity[3]);
				cmlSentInfos.setTranId(Tid);
				cmlSentInfos.setSeriaNo(entity[6]);
				cmlSentInfos.setTranYear(transDate.substring(0, 4));
				cmlSentInfos.setTranMonthday(transDate.substring(4, 8));
				cmlSentInfos.setTranTime(entity[0].replace(":", ""));
				cmlSentInfos.setMoneyType(entity[1]);
				cmlSentInfos.setCreateDate(DateUtil.getyyyyMMddDate(new Date()));
				falg = cmlSentInfosDao.saveEntityCheck(cmlSentInfos);
				if( !falg )
				{
					break;

				}
				;
			}

			if( falg )
			{
				if( cmlTaskInfos.getAtmMoney() == null )
				{
					cmlTaskInfos.setAtmMoney(new BigDecimal(A));
				}
				else
				{
					cmlTaskInfos.setAtmMoney((cmlTaskInfos.getAtmMoney()).add(new BigDecimal(A)));
				}
				if( cmlTaskInfos.getPassMoney() == null )
				{
					cmlTaskInfos.setPassMoney(new BigDecimal(B));
				}
				else
				{
					cmlTaskInfos.setPassMoney((cmlTaskInfos.getPassMoney()).add(new BigDecimal(B)));
				}
				Integer count = A + B + C;
				if( cmlTaskInfos.getTotalMoney() == null )
				{
					cmlTaskInfos.setTotalMoney(new BigDecimal(count));
				}
				else
				{
					cmlTaskInfos.setTotalMoney((cmlTaskInfos.getTotalMoney()).add(new BigDecimal(count)));
				}

				cmlTaskInfosDao.updateObject(cmlTaskInfos);
				falg = true;
			}

		}
		catch( Exception e )
		{
			falg = false;
		}
		return falg;
	}

	/**
	 * UW500解析方式
	 */
	public synchronized boolean addALlCmlSentInfosByUW500(CmlTaskInfos cmlTaskInfos,String url
			,String pathcode) {
		// 计算当次导入得到的ATM币数量
		Integer A = 0;
		// 计算当次导入得到的流通钞数量
		String sourceOrg= cmlTaskInfos.getOrgId();
		String taskId =cmlTaskInfos.getTaskNum();
		String tmlNum = cmlTaskInfos.getTmlNum();
		String Tid = cmlTaskInfos.getId();
		boolean falg = false;
		try {
			List list = cmlImpRecordsDao.parseCsv(url);
			String[] a = (String[]) list.get(0);
			String[] result = a[0].split(" ");
			String setTranTime = result[1].replace(":", "");
			String setTranDate = result[0].replace("-", "");
			String result1 = "";
			if (setTranDate.length() == 7) {
				result1 = setTranDate.substring(0, 4) + "0"
						+ setTranDate.substring(4, 7);
			} else {
				result1 = setTranDate;
			}
			
			for (int j = 2; j < list.size(); j++) {
				String[] entity = (String[]) list.get(j);
				
			/*	if(j  == 2){
				
					falg =checkMod(checkModUW500, entity);
					
						
					
				}*/
				
				CmlSentInfos cmlSentInfos = new CmlSentInfos();
					cmlSentInfos.setMoneyType("0");
					cmlSentInfos.setPathcode(pathcode);
					cmlSentInfos.setTermId(tmlNum);
					cmlSentInfos.setImpFlag("0");
					cmlSentInfos.setOrgId(sourceOrg);
					A += Integer.parseInt(entity[2].substring(0, 3));
					cmlSentInfos.setImpFlag("0");
					cmlSentInfos.setSeriaNo(entity[3]);
					cmlSentInfos.setDenomination("0"+ entity[2].substring(0, entity[2].length() - 1));
					cmlSentInfos.setTranId(Tid);
				
					cmlSentInfos.setTranYear(result1.substring(0,4));
					cmlSentInfos.setTranMonthday(result1.substring(4,8));
					cmlSentInfos.setTranTime(setTranTime);
					cmlSentInfos.setUrlName(entity[5]);
					cmlSentInfos.setCreateDate(DateUtil.getyyyyMMddDate(new Date()));
					falg = cmlSentInfosDao.saveEntityCheck(cmlSentInfos);
					if(!falg){
						break;
					}
					}
			
			if (falg){
			
			
			// 对任务进行修改修改其ATM币
			if (cmlTaskInfos.getAtmMoney() == null) {
				cmlTaskInfos.setAtmMoney(new BigDecimal(A));

			} else {
				cmlTaskInfos.setAtmMoney((cmlTaskInfos.getAtmMoney())
						.add(new BigDecimal(A)));
			}
			// 总金额进行修改

			if (cmlTaskInfos.getTotalMoney() == null) {
				cmlTaskInfos.setTotalMoney(new BigDecimal(A));

			} else {
				cmlTaskInfos.setTotalMoney((cmlTaskInfos.getTotalMoney())
						.add(new BigDecimal(A)));
			}
             try {
            	 synchronized (cmlTaskInfos) {
            		 cmlTaskInfosDao.updateObject(cmlTaskInfos);
				}
            	
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			falg = true;
			}
		} catch (Exception e) {

			falg = false;

			// TODO: handle exception
		}
		return falg;

	}
	@Transactional
	public synchronized boolean addALlCmlSentInfosByCM400(CmlTaskInfos cmlTaskInfos,String url,String pathCode) {

		String sourceOrg= cmlTaskInfos.getOrgId();
		String taskId =cmlTaskInfos.getTaskNum();
		String tmlNum = cmlTaskInfos.getTmlNum();
		
		String Tid = cmlTaskInfos.getId();
		Integer A = 0;
		Integer B = 0;

		boolean falg = false;
		try {
			List list = cmlImpRecordsDao.parseCsv(url);
			for (int j = 1; j < list.size(); j++) {
				String[] entity = (String[]) list.get(j);
				
			
				CmlSentInfos cmlSentInfos = new CmlSentInfos();
				cmlSentInfos.setPathcode(pathCode);
				cmlSentInfos.setTranId(Tid);
				cmlSentInfos.setTranTime(entity[0].toString().replace(":", ""));
				cmlSentInfos.setDenomination("0" + entity[2]);
				cmlSentInfos.setMoneyType(entity[3]);
				cmlSentInfos.setSeriaNo(entity[5]);
				cmlSentInfos.setTermId(entity[8]);
				cmlSentInfos.setJournalNo(entity[9]);
				cmlSentInfos.setNoteFlag(entity[11]);
				cmlSentInfos.setNoteType(entity[12]);
				cmlSentInfos.setCurrency(entity[13]);
				cmlSentInfos.setCashBoxId(entity[14]);
				cmlSentInfos.setPictureName(entity[15]);
				cmlSentInfos.setVerifyNo(entity[16]);
				cmlSentInfos.setUrlName(entity[17]);
				if (!"".equals(entity[18])) {
				cmlSentInfos.setTranYear(entity[18].substring(0, 4));
				cmlSentInfos.setTranMonthday(entity[18].substring(4,8));
				cmlSentInfos.setCheckResult(entity[19]);
				cmlSentInfos.setImpFlag(entity[20]);
/*
				if (entity[21].toString().substring(0, 2).equals("05")) {
					A += Integer.parseInt(entity[2]);
				}
				if (entity[21].toString().substring(0, 2).equals("99")) {
					B += Integer.parseInt(entity[2]);
				}*/
				cmlSentInfos.setVerifyNo(entity[21]);

				cmlSentInfos.setImpFlag("0");

				cmlSentInfos.setCreateDate(DateUtil.getyyyyMMddDate(new Date()));
		
				 if(j == 1){
					 
					 falg =cmlSentInfosDao.saveEntityCheck(cmlSentInfos);
				 }else{
				 save(cmlSentInfos);
				 }
				if(!falg){		
					break;
				}
			}
			}	
			if(falg){
			if (cmlTaskInfos.getVersion05() == null) {
				cmlTaskInfos.setVersion05(new BigDecimal(A));
			} else {
				cmlTaskInfos.setVersion05(cmlTaskInfos.getVersion05().add(
						new BigDecimal(A)));
			}
			if (cmlTaskInfos.getVersion99() == null) {
				cmlTaskInfos.setVersion99(new BigDecimal(B));
			} else {
				cmlTaskInfos.setVersion99(cmlTaskInfos.getVersion99().add(
						new BigDecimal(B)));
			}
			
			
			

			cmlTaskInfosDao.updateObject(cmlTaskInfos);
	
			falg = true;
			}
		} catch (Exception e) {
		
			falg = false;

			// TODO: handle exception
		}
		return falg;

	}
	
	/**
	 *  判断是否存在冠子号码
	 *  @param tranid tranid
	 *  @return boolean
	 **/
	public boolean getObjByTaskNum(String tranid) {
		String sql = " select count(*)  from CmlSentInfos where tranId = '" + tranid + "'";
		return Integer.parseInt(cmlSentInfosDao.findUnique(sql).toString()) > 0 ? true
				: false;

	}
	public void save(CmlSentInfos cmlSentInfos){
		 cmlSentInfosDao.save(cmlSentInfos);
		
	}

	/**
	 * @param checkL 模板字段最大长度
	 * @param entity 用来比较的解析数据 
	 * @return boolean 
	 * 
	 * */
	public boolean checkMod(Integer[] checkL, String[] entity){
		boolean result = false;	
		 if(checkL.length == entity.length){  
			  for (int i = 0; i < checkL.length; i++) {
				  if(checkL[i] == entity[i].trim().length()){
					  result = true;
				  }else{
					  result = false;
					  break;
					
				  }
			  }
		 }
		return  result;
	}
	

}
