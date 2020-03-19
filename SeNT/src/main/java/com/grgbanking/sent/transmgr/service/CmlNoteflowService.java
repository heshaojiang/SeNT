package com.grgbanking.sent.transmgr.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.SpringService;
import com.grgbanking.sent.transmgr.dao.CmlNoteflowDao;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowDetailInfo;



/****
 * @author �1�7�1�7�1�7�1�7�0�11�1�771�1�71�1�777�1�71�1�771�1�71�1�777
 *
 */
@Service
@Transactional
public class CmlNoteflowService extends BaseService{
	@Autowired
	CmlNoteflowDao cmlNoteflowDao ;
   @Autowired 
   SpringService springService;
	
	/**
	 * �1�7�1�7�0�0�1�7�1�7�0�9�1�7�1�7�0�0�1�7�1�7�1�7�1�7�҄1�7
	 * @param page �0�6�1�7�1�7
	 * @param beginDateString �0�71�1�71�1�777�0�3�0�2�1�71�1�71�1�777
	 * @param endDateString �1�7�1�7�1�7�1�7�0�2�1�7�1�7
	 * @param fuzzyCount �0�0�1�7�1�71�1�71�1�777�1�7�1�7�1�7�1�7�˄1�7�1�7
	 * @param cml �1�7�1�7�0�9�1�7�1�7�0�0�1�7�1�7�1�7�1�7�1�7�0�4
	 * @return �1�7�1�7�0�7�1�7�1�7�1�7�1�7
	 */
   
   @Transactional(readOnly = true)
   public Page getCmlNoteflowPage(Page page,String begDate , String endDate ,CmlNoteflowDetailInfo cnfs)
   {
	   System.out.println("CmlNoteflowService.getCmlNoteflowPage()");
        String sql = "" ;
        String sqlCondition = "" ;
        if(cnfs != null && cnfs.getBarcode1() != null && !"".equals(cnfs.getBarcode1())){
        	sqlCondition += " and cnf.barcode1='"+cnfs.getBarcode1()+"' " ;
        }
        if(cnfs != null && cnfs.getBarcode2() != null && !"".equals(cnfs.getBarcode2())){
        	sqlCondition += " and cnf.barcode2='"+cnfs.getBarcode2()+"' " ;
        }
        if(cnfs != null && cnfs.getOperator() != null && !"".equals(cnfs.getOperator())) {
        	sqlCondition += " and cnf.operator ='"+cnfs.getOperator()+"' " ;
        }
        if(cnfs != null && cnfs.getPathCode() != null && !"".equals(cnfs.getPathCode())) {
        	sqlCondition += " and cnf.pathCode ='"+cnfs.getPathCode()+"' " ;
        }
		if(begDate==null ||endDate ==null ||"".equals(begDate)||"".equals(endDate)) {
			sql += "from CmlNoteflowDetailInfo cnf where cnf.status='1' and cnf.barcode2 != null "+sqlCondition ;
		}
		else {
			sql += "from CmlNoteflowDetailInfo cnf where cnf.status='1'and cnf.barcode2 != null and cnf.date > '"+begDate+"' and cnf.date < '"+endDate+"'"+sqlCondition ;
		}
	   Page<CmlNoteflowDetailInfo> notePage = cmlNoteflowDao.findPage(page, sql.toString()) ;
	   
	   
	   List resultTmp=notePage.getResult();
		List<CmlNoteflowDetailInfo> li=new ArrayList<CmlNoteflowDetailInfo>();
		CmlNoteflowDetailInfo dnf = null ;
		for (int i = 0 ; i < resultTmp.size() ; i ++) {
			dnf = new CmlNoteflowDetailInfo() ;
			dnf = (CmlNoteflowDetailInfo)resultTmp.get(i) ;
			String initDate = dnf.getDate() ;
			String formatDate = null ;
			if(initDate!=null && initDate.length()== 15) {
				formatDate = initDate.substring(0,4)+"-"+initDate.substring(4,6)+"-"+initDate.substring(6,8)+
				" "+initDate.substring(9,11)+":"+initDate.substring(11,13)+":"+initDate.substring(13,15) ;
			}
			CmlNoteflowDetailInfo cml = new CmlNoteflowDetailInfo() ;
			cml.setId(dnf.getId()) ;
			cml.setBarcode1(dnf.getBarcode1()) ;
			cml.setBarcode2(dnf.getBarcode2()) ;
			cml.setBarcodeFlowNum(dnf.getBarcodeFlowNum()) ;
			cml.setFlowStage(dnf.getFlowStage()) ;
			cml.setStatus(dnf.getStatus());
			cml.setOperator(dnf.getOperator());
			cml.setDate(formatDate);
			cml.setPathCode(dnf.getPathCode());
			
			li.add(cml);
		}
		
		page.setResult(li);
	   return notePage ;
   }
   
   public int addCmlNoteflow(CmlNoteflowDetailInfo obj,String cashBox1,String cashBox2,String cashBox3,String cashBox4) {
		List<CmlNoteflowDetailInfo> cfs = new ArrayList<CmlNoteflowDetailInfo>() ;
		String[] cashBoxes = new String[]{cashBox1,cashBox2,cashBox3,cashBox4} ;
		for(String cashBox:cashBoxes) {
			if(cashBox !=null && !cashBox.equals("")) {
				List<String> li=new ArrayList<String>();
				String hql = "select cnf.barcodeFlowNum from CmlNoteflowDetailInfo cnf where cnf.status='0' and cnf.barcode1 ='"+cashBox+"'" ;
				
				li = cmlNoteflowDao.find(hql) ;
				CmlNoteflowDetailInfo cf = null ;
				for(int i = 0 ; i < li.size() ; i ++){
				   Date dt = new Date() ;
				   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmmss") ;
				   String now = sdf.format(dt) ;
				   cf = new CmlNoteflowDetailInfo() ;
				   cf.setBarcode1(cashBox) ;
				   cf.setBarcode2(obj.getBarcode2()) ;
				   cf.setBarcodeFlowNum(li.get(i)) ;
				   cf.setDate(now) ;
				   cf.setOperator(obj.getOperator()) ;
				   cf.setPathCode(obj.getPathCode()) ;
				   cf.setStatus("1") ;
				   cf.setFlowStage("1");
				   cfs.add(cf) ;
			}
		}
		}
		return cmlNoteflowDao.addNoteflow(cfs) ;
	}
}

 
