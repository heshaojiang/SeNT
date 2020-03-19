package com.grgbanking.cml.report.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.cml.report.dao.ReportCmlDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.sent.transmgr.dao.CmlTaskInfoDao;
import com.grgbanking.sent.transmgr.entity.CmlTaskInfo;
import com.grgbanking.sent.utils.DateUtil;

import flex.messaging.FlexContext;


/**
 * @author yt
 *
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class ReportCmlService extends BaseService{
	@Autowired
	ReportCmlDao reportDao;
	@Autowired
	UserDao userDao;
    @Autowired 
    OrgInfoDao orgInfoDao;
    @Autowired
    CmlTaskInfoDao cmlTaskInfoDao;
    @Autowired 
    ParamDao paramDao;
    final int no3=3;
	final int no4=4;
	final int no5=5;
	final int no6=6;
	final int no7=7;
	final int no8=8;
	final int no9=9;
	final int no10=10;
	final int no11=11;
	final int no12=12;
	
	
	final String[] field = {"atmMoney", "passMoney","totalMoney"};
		
/**
 *导出ATM 
 */
	@Transactional(readOnly = true)
	public Page findATMReportPage(Page page,String toatmnum,String beginDateString,String endDateString)throws IllegalArgumentException,
	SecurityException, IllegalAccessException,
	InvocationTargetException, NoSuchMethodException
	{
		throw new RuntimeException("*****************************");
//	      StringBuffer hql = new StringBuffer();
//	      
//			hql.append(" select  r.toatmnum,count(*) ");
//			for (int i = 0; i < field.length; i++) {
//				String temp = " ,SUM(" + "r."+field[i] + ") ";
//				hql.append(temp);
//			}
//			hql.append(" from CmlTaskInfo r where r.toatmnum !=null");
//			if (org.apache.commons.lang.StringUtils.isNotBlank(toatmnum)) {
//
//				hql.append(" and r.toatmnum = '"+toatmnum+"'");
//			}
//			 
//			if (org.apache.commons.lang.StringUtils.isNotBlank(beginDateString)) {
//				hql.append(" and r.bindStart >=to_date('" + beginDateString
//						+ "','yyyy-MM-dd HH24:mi:ss') ");
//			}
//			if (org.apache.commons.lang.StringUtils.isNotBlank(endDateString)) {
//				hql.append(" and r.bindStart <=to_date('" + endDateString
//						+ "','yyyy-MM-dd HH24:mi:ss') ");
//			}
//			hql.append("  group by  r.toatmnum");
//			
//			 List<Object> list = cmlTaskInfoDao.find(hql.toString());
//			 //分页
//		     Page pageObject=getPageList(list,page);
//		     //得到每一页的结果集
//		     List<Object> objList = pageObject.getResult();
//		     List<CmlTaskInfo> resuList = new ArrayList<CmlTaskInfo>();
//		 	//将结果集重新封装
//		for (int i = 0; i < objList.size(); i++) {
//			Object[] obj = (Object[]) objList.get(i);
//			
//			CmlTaskInfo rc = new CmlTaskInfo();
//
//			if(obj[0]!=null && !obj[0].equals("")){
//		   rc.setToatmnum(obj[0].toString().trim());
//			}
//			else{
//				obj[0]="";
//				rc.setToatmnum(obj[0].toString().trim());
//			}
//		  if(obj[1]!=null && !obj[1].equals("")){
//			  rc.setBoxCount(Integer.parseInt(obj[1].toString().trim()));
//		  }
//		  else{
//			  obj[1]="";
//			  rc.setBoxCount(Integer.parseInt(obj[1].toString().trim()));
//		  }
//		  if(StringUtils.isNotBlank(obj[2].toString())){
//			  rc.setAtmMoney(Float.parseFloat(obj[2].toString()));
//		  }
//		  if(StringUtils.isNotBlank(obj[3].toString())){
//			  rc.setPassMoney(Float.parseFloat(obj[3].toString()));
//		  }
//		  if(StringUtils.isNotBlank(obj[4].toString())){
//			  rc.setTotalMoney(Float.parseFloat(obj[4].toString()));
//		  }
////			Class<?> cc = CmlTaskInfo.class;
////			for (int j = 0; j < field.length; j++) {
////				cc.getDeclaredMethod( 
////						"set" + field[j].substring(0, 1).toUpperCase()
////								+ field[j].substring(1), float.class).invoke(rc,null == obj[j + 1] ? 0.0f : new Float(obj[j + 1]
////								.toString()));
////			}
//		
//			resuList.add(rc);
//			
//		
//		}
//		
//		page.setResult(resuList);
//
//		return page;
//
//			// TODO: handle exception
		
	}

	 
	/**
	 * 通过List得到Page
	 * 
	 * @param list
	 *            List
	 * @param page
	 *            Page
	 * @return Page
	 */
	@Transactional(readOnly = true)
	public Page getPageList(List list, Page page) {
		return reportDao.getPageList(list, page);
	}


	

	/**
	 * 导出Excel
	 * @return String
	 * @param list 任务详细信息列表
	 * @param sumObj  合计的列
	 * 
	 * */
	public String exportATMExcel(List<CmlTaskInfo> list ,Object[] sumObj){
		String filename ="";
		HttpServletRequest req =FlexContext.getHttpRequest();
		 final String filepath = "/report/reportATM.xls";
		String realPath =req.getSession().getServletContext().getRealPath("") + filepath;
		HSSFWorkbook templatewb = null;
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(realPath));
			templatewb = new HSSFWorkbook(fs,true);
		} catch (IOException ex) {
			logger.error("", ex);
		}
		try{
		filename =  "exportATM_"+DateUtil.getTimeYYYYMMDDHHMMSSString(new Date())+".xls"; 
		String filePath = req.getSession().getServletContext()
		.getRealPath("")
		+ File.separator + "exportFile" + File.separator + filename;// 导出文件路径	
		HSSFSheet sheet = templatewb.getSheetAt(0);		
		for (int rowid = 0; rowid < list.size(); rowid++) {
			CmlTaskInfo t = list.get(rowid);
			Class<? extends CmlTaskInfo> bean = t.getClass();
			Row row = sheet.createRow(rowid+1);
			//指定列的排序从左至右
		 String[] fields = {"toatmnum", "boxCount", "atmMoney",
					"passMoney", "totalMoney"};
			for (int column = 1; column < fields.length + 1; column++) {
				String value = "";
				String field = fields[column - 1];
				Field field2 = bean.getDeclaredField(field);
				String name = field2.getName();
				String prefix = name.substring(0, 1);
				name = "get" + prefix.toUpperCase() + name.substring(1);
				Method method = bean.getDeclaredMethod(name);
				Object obj = method.invoke(t);
				if (obj instanceof Date) {
					value = obj.toString().substring(0,
							obj.toString().lastIndexOf("."));
				} else if (obj instanceof Float) {
					java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0.00");
					value = df.format(obj);
				} else if( null== obj  ) {
					value = "\\";
				}else{
					value =obj.toString();	
				}
				Cell  label1 = row.createCell(column);
				label1.setCellValue(value);
			}
			Cell laCel2= row.createCell(0);
			laCel2.setCellValue(String.valueOf(rowid+1));
		}
		/**
		 * sumField 需要合计的 Field
		 * 合计根据fields 对应进行查询读写 
		 */
		String value = "总计:";							
		//可设定总计与之前数据的间距  +1 ?
		Row row2 = sheet.createRow(list.size()+1);
		//第二个文本框开始写合计两字
		final int cellCount=0;
		final int colunmCount=3;
		String countValue = "";
		 //.info("check sumObject()" + (null != sumObj));
		if(null != sumObj){
			row2.createCell(cellCount).setCellValue(value);
		for (int countColumn = colunmCount; countColumn < sumObj.length + colunmCount; countColumn++) {
			Object obj1 = sumObj[(countColumn - colunmCount)];
		if(null !=obj1 ){
			java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0.00");
			countValue = df.format(obj1);
		}
			else{
				countValue = "0.00";
			}
			Cell  label1 = row2.createCell(countColumn);
			logger.info("count value is " + value);
			label1.setCellValue(countValue);
		}
		}
		OutputStream out = new FileOutputStream(new File(filePath));
		templatewb.write(out);
		out.flush();
	    out.close();
	 } catch (IOException e) {
       logger.error("",e);
	 }catch(NoSuchFieldException e){
		 logger.error("",e);
		}catch (NoSuchMethodException e) {
			 logger.error("",e);
		}catch (InvocationTargetException e) {
			 logger.error("",e);
		}catch (IllegalAccessException e) {
			 logger.error("",e);
		}
		catch (SecurityException e) {
			 logger.error("",e);
		}
		return filename;
	}	

	
	/**
	 * @param   field  ��Ҫ���кϼƵ��ֶ�
	 * @param   tmlNum tmlNum
	 * @param startDate startDate
	 * @param  endDate endDate
	 * @return  Object[]
	 */

	public Object[] getSUMList(String[] field, String atmNum, String startDate, String endDate){

      StringBuffer sql = new StringBuffer();

		sql.append(" select  ");
		
		for (int i = 0; i < field.length; i++) {
			String temp = i == 0 ? "SUM(" +"c."+ field[0] + ")" : " , SUM(" +"c."+ field[i] +")";
			sql.append(temp);
		}
		sql.append(" from CmlTaskInfo c  where c.toatmnum !=null");
	

		if (StringUtils.isNotBlank(atmNum)) {
			sql.append(" and  c.toatmnum ='" + atmNum.trim() + "'");
		}
	
		if (startDate!=null&&!startDate.equals("")) {
			sql.append(" and c.bindStart >=TO_DATE('" + startDate + "','yyyy-MM-dd HH24:mi:ss')");

		}
		
		if (endDate!=null&&!endDate.equals("")) {
		
			sql.append(" and c.bindStart<=TO_DATE('" + endDate + "','yyyy-MM-dd HH24:mi:ss')");

		}
		
		Object[] object = null;
		
 			object   = cmlTaskInfoDao.findUnique(sql.toString());

	   return object ;
        	 
		 
}
	
	/**
	 * ATM清分加钞
	 * */
	@SuppressWarnings("unchecked")
	public List<CmlTaskInfo> getObjectList(String toatmnum,String startDate, String endDate)
	{
		throw new RuntimeException("*****************************");
//		  StringBuffer hql = new StringBuffer();
//		hql.append(" select  c.toatmnum,count(*) ");
//		for (int i = 0; i < field.length; i++) {
//			String temp = " ,SUM(" + "c."+field[i] + ") ";
//			hql.append(temp);
//		}
//		hql.append(" from CmlTaskInfo c where c.toatmnum !=null");
//	  if(StringUtils.isNotBlank(toatmnum)){
//	 	 hql.append(" and c.toatmnum='"+toatmnum+"'");
//	  }
//	
//	if (startDate != null && !startDate.equals("")) {
//		//oracle中的
//			hql.append(" and c.bindStart>=TO_DATE('" +startDate+"' ,'yyyy-MM-dd HH24:mi:ss')");
//		}
//		if (endDate != null && !endDate.equals("")) {
//		
//			hql.append( " and c.bindStart<=TO_DATE('" +endDate+"' ,'yyyy-MM-dd HH24:mi:ss')");
//		}
//
//
//		hql.append("  group by  c.toatmnum");
//	List<Object[]> ll =cmlTaskInfoDao.find(hql.toString());
//  List<CmlTaskInfo> result  = new ArrayList();
//	for(Object[] obj : ll){
//		CmlTaskInfo ad =new CmlTaskInfo();
//	  	if(obj[0]!=null&&!"".equals(obj[0].toString())){
//			ad.setToatmnum(obj[0].toString().trim());
//	  	}
//	  	else{
//	  		obj[0]="";
//	  		ad.setToatmnum(obj[0].toString().trim());
//	  	}
//		if(obj[1]!=null&&!"".equals(obj[1].toString())){
//			ad.setBoxCount(Integer.parseInt(obj[1].toString().trim()));
//		}
//		else{
//			obj[1]=0;
//			ad.setBoxCount(Integer.parseInt(obj[1].toString().trim()));
//		}
//		if(obj[2]!=null&&!"".equals(obj[2].toString())){
//			ad.setAtmMoney(Float.parseFloat(obj[2].toString().trim()));
//		}
//		if(obj[no3]!=null&&!"".equals(obj[no3].toString())){
//			ad.setPassMoney(Float.parseFloat(obj[no3].toString().trim()));
//		}
//		if(obj[no4]!=null&&!"".equals(obj[no4].toString())){
//			ad.setTotalMoney(Float.parseFloat(obj[no4].toString().trim()));
//		}
//		
//		result.add(ad);
//		}
//
//	   return result ;
//	
		
	}
	
	/**导出ATM清分加钞*/
	public String exportATM(String atmNum,String startTime, String endTime){
		List<CmlTaskInfo> list = getObjectList(atmNum, startTime, endTime);
				

		String[] sumField = {"atmMoney","passMoney","totalMoney"};
			
		Object[] sumObj = getSUMList(sumField,atmNum,
				startTime, endTime);

		return exportATMExcel(list, sumObj);
	}
	/**
	 * 对应ATM的所有信息
	 * */
	@Transactional(readOnly = true)
	public Page getAllATMInfo(Page page,String toatmnum)
	{
		throw new RuntimeException("*****************************");
//		String hql=" select c.toatmnum,c.atmMoney,c.passMoney,c.totalMoney,c.boxNum from CmlTaskInfo c where  c.toatmnum='"+toatmnum+"'";
//	
//		List<Object[]> list =cmlTaskInfoDao.find(hql);
//		Page pageObject=getPageList(list, page);
//		List<Object> objList=pageObject.getResult();
//	    List<CmlTaskInfo> result  = new ArrayList();
//		for(int i=0;i<objList.size();i++){
//			Object[] obj=(Object[]) objList.get(i);
//			CmlTaskInfo ad =new CmlTaskInfo();
//		  	if(obj[0]!=null&&!obj[0].equals("")){
//	               ad.setToatmnum(obj[0].toString());
//	          }
//		  	else{
//		  		obj[0]="";
//		  		 ad.setToatmnum(obj[0].toString());
//		  	}
//		  	
//		  	if(StringUtils.isNotBlank(obj[1].toString())){
//		  		ad.setAtmMoney(Float.parseFloat(obj[1].toString()));
//		  	}
//		  	if(StringUtils.isNotBlank(obj[2].toString())){
//		  		ad.setPassMoney(Float.parseFloat(obj[2].toString()));
//		  	}
//		  	if((StringUtils.isNotBlank(obj[3].toString()))){
//		  		ad.setTotalMoney(Float.parseFloat(obj[3].toString()));
//		  	}
//		  	if(obj[4]!=null &&!obj[4].equals("")){
//		  		ad.setBoxNum(obj[4].toString());
//		  	}
//		  	else{
//		  		obj[4]="";
//		  		ad.setBoxNum(obj[4].toString());
//		  	}
//		  	result.add(ad);
//		}
//
//		page.setResult(result);
//		return page;
	}
}

