package com.grgbanking.sent.watch.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.watch.dao.TranCallbackAbnoinfoDao;
import com.grgbanking.sent.watch.entity.TranCallbackAbnoinfo;
/**
 * 回收异常交易监控Service层继承公共的BaseService层
 * @author 广电运通
 * @version 1.0
 */
@Service  
@Transactional  
public class TranCallbackAbnoinfoService extends BaseService {
  @Autowired 
  private TranCallbackAbnoinfoDao   tranCallbackAbnoinfoDao;

  /**
   * 查找  Page<TranCallbackAbnoinfo>
   * @param page page实体
   * @param obj 条件
   * @return Page<TranCallbackAbnoinfo>
   */
 @Transactional(readOnly = true)  
 public  Page<TranCallbackAbnoinfo> getTranCallbackAbnoinfoPage(Page<TranCallbackAbnoinfo> page, Object[] obj){
    String sql="  from TranCallbackAbnoinfo ";
     return tranCallbackAbnoinfoDao.findPage(page, sql);
     }
 /**
  * 查找  List<TranCallbackAbnoinfo>
  * @param obj 条件
  * @return Page<TranCallbackAbnoinfo>
  */
 @Transactional(readOnly = true)  
 public  List<TranCallbackAbnoinfo> getTranCallbackAbnoinfoList(Object[] obj){
    String sql="  from TranCallbackAbnoinfo ";
     return tranCallbackAbnoinfoDao.find(sql);
     }

 /**
  *  根据主键ID查找实体
  *  @param id 主键
  *  @return TranCallbackAbnoinfo
  */
 @Transactional(readOnly = true) 
 public  TranCallbackAbnoinfo getTranCallbackAbnoinfoObject(String id ){
     return   (TranCallbackAbnoinfo)tranCallbackAbnoinfoDao.get(id);
     }
 
 /**
  * 根据 卡号/账号和时间区间  得到异常交易用来显示到页面
  * @param page page实体
  * @param  tran TranCallbackAbnoinfo实体
  * @param  beginDate  开始时间
  * @param  endDate    结束时间
  * @return String
  */
 @Transactional(readOnly =true)
 public Page<TranCallbackAbnoinfo> getTranCallbackAbnoinfoPage(Page<TranCallbackAbnoinfo> page, TranCallbackAbnoinfo tran,String beginDate,String endDate){
	 String sql = " from TranCallbackAbnoinfo tran ";
	 boolean flag = false;
	 String accountNo = tran.getAccountNo();
	 
	 if(accountNo!=null&&!"".equals(accountNo)){
		sql+="where tran.accountNo ='"+accountNo+"' ";
		flag = true;
	 }
	 if(beginDate!=null&&!"".equals(beginDate)){
		 beginDate =DateUtil.dateFormatTohms(beginDate);
		 if(flag){
			sql+="and tran.transDate  >= '"+beginDate+"' "; 
		 }else{
			 sql+="where tran.transDate >='"+beginDate+"' ";
		 }
		 flag =true;
	 }
	 if(endDate!=null&&!"".equals(endDate)){
		 endDate = DateUtil.dateFormatTohms(endDate);
		 if(flag){
			 sql+="and tran.transDate < '"+endDate+"' ";
		 }else{
			 sql+="where tran.transDate  <"+endDate+" '";
		 }
		 flag =true;
	 }
	 sql += "order by tran.transDate  desc ";
	 return tranCallbackAbnoinfoDao.findPage(page, sql);
 }
}
