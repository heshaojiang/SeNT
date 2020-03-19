package com.grgbanking.sent.watch.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.watch.dao.TranEspeciinfoDao;
import com.grgbanking.sent.watch.entity.TranEspeciinfo;
 
/**
 * 特殊冠字号码信息Service继承BaseService 
 * @author 广电运通
 * @version 1.0
 */

@Service  
@Transactional  
public class TranEspeciinfoService   extends BaseService {
  @Autowired 
  private TranEspeciinfoDao   tranEspeciinfoDao;
/**
 *  根据条件查询出相应的信息进行显示
 *  @param page page实体
 *  @param obj 相应的数组参数
 *  @return page
 */
 @Transactional(readOnly = true)  
 public  Page<TranEspeciinfo> getTranEspeciinfoPage(Page<TranEspeciinfo> page, Object[] obj){
    String sql="  from TranEspeciinfo ";
     return tranEspeciinfoDao.findPage(page, sql);
     }
/**
 * 根据条件查询数据集合
 * @param obj 查询条件
 * @return list 数据集合  
 */
 @Transactional(readOnly = true)  
 public  List<TranEspeciinfo> getTranEspeciinfoList(Object[] obj){
    String sql="  from TranEspeciinfo ";
     return tranEspeciinfoDao.find(sql);
     }

 /**
  *  根据id查找一个实体
  *  @param id 实体主键
  *  @return TranEspeciinfo 实体
  */
 @Transactional(readOnly = true) 
 public  TranEspeciinfo getTranEspeciinfoObject(String id ){
     return   (TranEspeciinfo)tranEspeciinfoDao.get(id);
     }
 /**
  * 根据规则 ，银行卡号/帐号，来源类型对特殊冠字号进行查询显示
  * @param  page  page实体
  * @param 	tranEs  实体 
  * @param 	beginDate  开始时间
  * @param 	endDate  结束时间
  * @return  Page<TranEspeciinfo> 
  */
 @Transactional(readOnly = true)
 public Page<TranEspeciinfo>   getTranEspeciinfoPage(Page<TranEspeciinfo> page, TranEspeciinfo tranEs, String beginDate,String endDate){
	 String sql =" from TranEspeciinfo tran ";
	 boolean flag = false;
	 String accountNo = tranEs.getAccountNo();
	 String cometype = tranEs.getCometype();
	 String especiseq = tranEs.getEspeciseq();
	 if(accountNo!=null&&!"".equals(accountNo)){
		 sql+=" where tran.accountNo ='"+accountNo+"' ";
		 flag = true;
	 }
	 if(cometype!=null&&!"".equals(cometype)){
		 if(flag){
			 sql+="and tran.cometype= '"+cometype+"' ";
		 }else{
			 sql+="where tran.cometype= '"+cometype+"' ";
		 }
		 flag =true;
	 }
	 if(especiseq!=null&&!"".equals(especiseq)){
		 if(flag){
			 sql+="and tran.especiseq ='"+especiseq+"' ";
		 }else{
			 sql+="where tran.especiseq ='"+especiseq+"' ";
		 }
		 flag =true;
	 }
	 if(beginDate!=null&&!"".equals(beginDate)){
		 beginDate = DateUtil.dateFormatTohms(beginDate);
		 if(flag){
			 sql+="and tran.transDate  >= '"+beginDate+"' ";
		 }else{
			 sql+="where tran.transDate  >= '"+beginDate+"' ";
		 }
		 flag =true;
	 }
	 if(endDate!=null&&!"".equals(endDate)){
		 endDate = DateUtil.dateFormatTohms(endDate);
		 if(flag){
			 sql+="and tran.transDate  < '"+endDate+"' ";
		 }else{
			 sql+="where tran.transDate  <'"+endDate+"' ";
		 }
		 flag =true;
		 sql += "order by tran.transDate  desc ";
	 }
	 return tranEspeciinfoDao.findPage(page, sql);
 }
}
