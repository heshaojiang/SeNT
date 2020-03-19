package com.grgbanking.cml.report.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.cml.report.dao.CmlReportDao;
import com.grgbanking.cml.report.entity.CmlReport;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.platform.module.security.entity.User;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.transmgr.dao.CmlTaskInfoDao;
import com.grgbanking.sent.transmgr.entity.CmlTaskInfo;
import com.grgbanking.sent.transmgr.entity.CmlTaskInfoDetail;
import com.grgbanking.sent.utils.DateUtil;

import flex.messaging.FlexContext;


/**
 * @author yt
 *
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class CmlReportService extends BaseService{
	@Autowired
	CmlReportDao cmlReportDao;
	@Autowired
	CmlTaskInfoDao cmlTaskInfoDao;
	@Autowired
	UserDao userDao;
    @Autowired 
    OrgInfoDao orgInfoDao;
    @Autowired
    TermInfoDao termInfoDao;
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
	final String[] field = {"falseCoinMoney",
			"atmMoney", "passMoney", "stubbedMoney", "shadinessMoney",
			"trailMoney", "totalMoney" };

	/**
	 * �������id���Ҷ�Ӧ��������Ϣ
	 * @param id ������
	 * @return CmlTaskInfo
	 * */
	@Transactional(readOnly = true)
	public CmlReport getReportCmlo(String id){
		return cmlReportDao.get(id);
	}

	/**
	 * ����ͺ��ҵ������豸���
	 * @param model �豸�ͺ�
	 * @return List<String>
	 * **/
	 public List<String>  findByDevModle(String model){
		 if(StringUtils.hasText(model)){
		 String hql ="   select  termcode  from TermInfo  where  modle = '"+model+"'";
	 return termInfoDao.find(hql);
		 }else {
			 return null;
		 }
		 }
	/**
	 * ��������ҵ������豸���ͺ�
	 * @param termtype �豸����
	 * @return List<String>
	 */
	 public List<String>  findByTermtype(String termtype){
		 if(StringUtils.hasText(termtype)){
		 String hql ="   select  model  from TermInfo  where  termtype = '"+termtype+"'";
		 	return termInfoDao.find(hql);
		 }else {
			 return null;
		 }
		 }
	/**
	 * ��ҳ��ʾ����豸��Ϣ
	 * @param page ��ҳʵ��
	 * @param beginDateString ��ʼʱ��
	 * @param endDateString ����ʱ��
	 * @return Page 
	 * @param cml ��������ʵ����
	 * @param devModle �豸�ͺ�
	 * */
	@Transactional(readOnly = true)
	public Page getCmlReportPage(Page page,String termId,String beginDateString, String endDateString,String devModle)
	{
		throw new RuntimeException("*****************************");

//	    StringBuffer  hql= new StringBuffer();
//	 
//		hql.append(" select  r.tmlNum ");
//		for (int i = 0; i < field.length; i++) {
//			String temp = " ,SUM(" + "r."+field[i] + ") ";
//			hql.append(temp);
//		}
//		hql.append(" from CmlTaskInfo r  where 1=1 ");
//		 // ������豸����ڣ���ֱ�Ӳ��豸������û���豸��ž͸���豸�ͺŽ��в�ѯ
//		  if(StringUtils.hasText(tmlNum)){
//		    	 if(StringUtils.hasText(devModle)){
//		    		 hql.append(" and  exists  ( select 'X' from TermInfo t  where t.termCode = r.tmlNum and t.modle = '"+devModle+"'");
//		    		} else{
//		    			hql.append(" and r.tmlNum='"+tmlNum+"'");
//		    	 }
//		    }
//		
//		if (org.apache.commons.lang.StringUtils.isNotBlank(beginDateString)) {
//			hql.append(" and r.operateDate >=to_date('" + beginDateString
//					+ "','yyyy-MM-dd HH24:mi:ss') ");
//		}
//		if (org.apache.commons.lang.StringUtils.isNotBlank(endDateString)) {
//			hql.append(" and r.operateDate <=to_date('" + endDateString
//					+ "','yyyy-MM-dd HH24:mi:ss') ");
//		}
//		hql.append("  group by r.tmlNum");
//		 List<Object> list = cmlTaskInfoDao.find(hql.toString());
//		 //分页
//	     Page pageObject=getPageList(list,page);
//	     //得到每一页的结果集
//	     List<Object> objList = pageObject.getResult();
//	     List<CmlTaskInfo> resuList = new ArrayList<CmlTaskInfo>();
//	 	//将结果集重新封装
//			
//	for (int i = 0; i < objList.size(); i++) {
//		Object[] obj = (Object[]) objList.get(i);
//		CmlTaskInfo rc = new CmlTaskInfo();
//	rc.setTmlNum(obj[0].toString().trim());
//	rc.setFalseCoinMoney(Float.parseFloat(obj[1].toString()));
//	rc.setAtmMoney(Float.parseFloat(obj[2].toString()));
//	rc.setPassMoney(Float.parseFloat(obj[3].toString()));
//	rc.setStubbedMoney(Float.parseFloat(obj[4].toString()));
//	rc.setShadinessMoney(Float.parseFloat(obj[5].toString()));
//	rc.setTrailMoney(Float.parseFloat(obj[6].toString()));
//	rc.setTotalMoney(Float.parseFloat(obj[7].toString()));
//		resuList.add(rc);
//
//	}
//	page.setResult(resuList);
//	return page;	
		
		
	}
	
	/**
	 * ���·�װһ���µ������б�
	 * @return List<CmlTaskInfoDetail>������������
	 * @param ll  �����б�
	 * */
	public List<CmlReport> changeReportCml(List<Object[]> ll) {
		List<CmlReport> result =new ArrayList<CmlReport>();
		final int arrLength=13;
		
	for (int i = 0; i < ll.size(); i++) {
			Object[] obj = (Object[])ll.get(i);
			CmlReport ad = new CmlReport();
			if(obj!=null&&obj.length>=arrLength){		
  	if(obj[0]!=null&&!"".equals(obj[0].toString())){
		ad.setTmlNum(obj[0].toString());
  	}
	if(obj[1]!=null&&!"".equals(obj[1].toString())){
		ad.setVersion05((float)Integer.parseInt(obj[1].toString()));
	}
	if(obj[2]!=null&&!"".equals(obj[2].toString())){
		ad.setAtmMoney((float)Integer.parseInt(obj[2].toString()));
	
	}
//	if(obj[no3]!=null&&!"".equals(obj[no3].toString())){
//		ad.setBeforeCount((float)Integer.parseInt(obj[no3].toString()));
//	}
	if(obj[no3]!=null&&!"".equals(obj[no3].toString())){
		ad.setAtmMoney((float)Integer.parseInt(obj[no3].toString()));
	}
	if(obj[no4]!=null&&!"".equals(obj[no4].toString())){
		ad.setPassMoney((float)Integer.parseInt(obj[no4].toString()));
	}
	if(obj[no5]!=null&&!"".equals(obj[no5].toString())){
		ad.setStubbedMoney((float)Integer.parseInt(obj[no5].toString()));
	}
	if(obj[no6]!=null&&!"".equals(obj[no6].toString())){
		ad.setShadinessMoney((float)Integer.parseInt(obj[no6].toString()));
	}
	if(obj[no7]!=null&&!"".equals(obj[no7].toString())){
		ad.setTrailMoney((float)Integer.parseInt(obj[no7].toString()));
	}
	if(obj[no8]!=null&&!"".equals(obj[no8].toString())){
		ad.setFalseCoinMoney((float)Integer.parseInt(obj[no8].toString()));
	}
	
		result.add(ad);
          
	 }
	}
		return result;
	}
	/**
	 * ��ҳ��ʾ���������Ϣ
	 * @param page ��ҳʵ��
	 * @param beginDateString ��ʼʱ��
	 * @param endDateString ����ʱ��
	 * @return Page 
	 * @param cml ��������ʵ����
	 * */
	@Transactional(readOnly = true)
	public Page getCmlTaskInfoPage(Page page,CmlTaskInfo cml,String beginDateString, String endDateString){

   String  sql= " select c.termId,u.userName,c.bindStart,c.beforeCount,c.atmMoney,c.passMoney,c.stubbedMoney,c.shadinessMoney,c.trailMoney," +
	 "c.falseCoinMoney ,c.totalMoney ,c.id,c.operatorId from CmlTaskInfo c , User u where u.userCode=c.operatorId";
		        
		if (beginDateString != null && !beginDateString.equals("")) {
		
			sql += " and c.bindStart>=TO_DATE('" +beginDateString+"' ,'yyyy-MM-dd HH24:mi:ss')";
		}
		if (endDateString != null && !endDateString.equals("")) {
		
			sql += " and c.bindStart<=TO_DATE('" +endDateString+"' ,'yyyy-MM-dd HH24:mi:ss')";
		}
      if(cml.getTermId()!=null&&!cml.getTermId().equals("")){
    	 sql +=" and c.termId='"+ cml.getTermId().trim() + "'";					
       }
 	  if(cml.getPathcode()!=null && !cml.getPathcode().equals("")){
		 sql+= " and c.pathcode like '" + cml.getPathcode()+ "%'";
    	}
     sql +=" order by c.bindStart desc";
     
		List<Object[]> list =cmlTaskInfoDao.find(sql);		
		// ��ҳ
		Page pageObject=change(list)==null ?  new Page() : getPageList(change(list), page);

		// �õ�ÿһҳ�Ľ��
 		return pageObject;
}
	
	/**
	 * ��ݲ���·��ȡֵ
	 * @return String �����ֽ��׼�����ʱ�䷶Χ
	 * */
	public String getInitCmlTaskParamMap(){
		 return paramDao.getValueByPath((AppConstants.CML_TRANSDAY));
	}
	/**
	 * ���·�װһ���µ������б�
	 * @return List<CmlTaskInfoDetail>������������
	 * @param ll  �����б�
	 * */
	public List<CmlTaskInfoDetail> change(List<Object[]> ll) {
		List<CmlTaskInfoDetail> result =new ArrayList<CmlTaskInfoDetail>();
		final int arrLength=13;
		
	for (int i = 0; i < ll.size(); i++) {
			Object[] obj = (Object[])ll.get(i);
			CmlTaskInfoDetail ad = new CmlTaskInfoDetail();
			
			if(obj!=null&&obj.length>=arrLength){		
  	if(obj[0]!=null&&!"".equals(obj[0].toString())){
		ad.setTermId(obj[0].toString());
  	}
	if(obj[1]!=null&&!"".equals(obj[1].toString())){
		ad.setUserName(obj[1].toString());
	}
	if(obj[2]!=null&&!"".equals(obj[2].toString())){
		ad.setOperateDate((Date)obj[2]);
	}
	if(obj[no3]!=null&&!"".equals(obj[no3].toString())){
		ad.setBeforeCount(Integer.parseInt(obj[no3].toString()));
	}
	if(obj[no4]!=null&&!"".equals(obj[no4].toString())){
		ad.setAtmMoney(Integer.parseInt(obj[no4].toString()));
	}
	if(obj[no5]!=null&&!"".equals(obj[no5].toString())){
		ad.setPassMoney(Integer.parseInt(obj[no5].toString()));
	}
	if(obj[no6]!=null&&!"".equals(obj[no6].toString())){
		ad.setStubbedMoney(Integer.parseInt(obj[no6].toString()));
	}
	if(obj[no7]!=null&&!"".equals(obj[no7].toString())){
		ad.setShadinessMoney(Integer.parseInt(obj[no7].toString()));
	}
	if(obj[no8]!=null&&!"".equals(obj[no8].toString())){
		ad.setTrailMoney(Integer.parseInt(obj[no8].toString()));
	}
	if(obj[no9]!=null&&!"".equals(obj[no9].toString())){
		ad.setFalseCoinMoney(Integer.parseInt(obj[no9].toString()));
	}
	if(obj[no10]!=null&&!"".equals(obj[no10].toString())){
		ad.setStatisAmt(Integer.parseInt(obj[no10].toString()));
	}
	if(obj[no11]!=null&&!"".equals(obj[no11].toString())){
		ad.setId(obj[no11].toString());
	}
	if(obj[no12]!=null&&!"".equals(obj[no12].toString())){
	    ad.setUid(obj[no12].toString());
	}
//	c
		result.add(ad);
          
	 }
	}
		return result;
	}
		
	 
	/**
	 * ͨ��List�õ�Page
	 * 
	 * @param list
	 *            List
	 * @param page
	 *            Page
	 * @return Page
	 */
	@Transactional(readOnly = true)
	public Page getPageList(List list, Page page) {
		return cmlTaskInfoDao.getPageList(list, page);
	}

	/**
	 *���id��ȡ���������Ϣ
	 *@param id ���
	 *@return �����Ϣ
	 */
	@Transactional(readOnly = true)
	public CmlReport getCmlSentObject(String id) {
		return (CmlReport) cmlReportDao.get(id);
	}

	
	  /**
	 *���������ѯ�����е�list
	 *@param tmlNum tmlNum
	 *@param operatorName operatorName
	 *@param startDate startDate
	 *@param endDate endDate
	 *@return  List<CmlTaskInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<CmlTaskInfo> getObjectList(String termId,String model, String startDate, String endDate){
		// sql������ƴװ
		   StringBuffer  sql= new StringBuffer("from CmlTaskInfo where 1=1");
		   // ������豸����ڣ���ֱ�Ӳ��豸������û���豸��ž͸���豸�ͺŽ��в�ѯ
		      if(StringUtils.hasText(termId)){
		      	 if(StringUtils.hasText(model)){
		      			List<String> cd = findByDevModle(model);
		      			if(!org.springframework.util.CollectionUtils.isEmpty(cd)){
		      				sql.append(" and termId in ( ");
		      				for (int i = 0; i < cd.size(); i++) {
		      					String temp = (i == 0 ? "'" + cd.get(i) + "'" : ",'"
		      						+ cd.get(i) + "'");
		      					sql.append(temp);
		      				}
		      			}
		      		}
		      	 else{
		      		 sql.append(" and termId='"+termId+"'");
		      	 }
		      }
		  	 	if (startDate != null && !endDate.equals("")) {
		  		
		  			sql.append(" and bindStart>=TO_DATE('" +startDate+"' ,'yyyy-MM-dd HH24:mi:ss')");
		  		}
		  		if (endDate != null && !endDate.equals("")) {
		  		
		  			sql.append(" and bindStart<=TO_DATE('" +endDate+"' ,'yyyy-MM-dd HH24:mi:ss')");
		  		}
//		     
//		   	  if(cml.getPathcode()!=null && !cml.getPathcode().equals("")){
//		  		 sql.append(" and c.pathcode like '" + cml.getPathcode()+ "%'");
//		      	}
		         sql.append(" order by bindStart desc");
		       
		  		List<CmlTaskInfo> list =cmlTaskInfoDao.find(sql.toString());	

	   return list ;
	}
	/**
	 * �����û���Ϣ
	 * 
	 * @param page
	 * @param userId
	 * @return List<User>
	 */
	public List<User> loadUsers() {
		
		return userDao.getAll();
	}
	
	/**
	 * @param   field  ��Ҫ���кϼƵ��ֶ�
	 * @param   tmlNum tmlNum
	 * @param startDate startDate
	 * @param  endDate endDate
	 * @param model �ͺ�
	 * @return  Object[]
	 */
	public Object[] getSUMList(String[] field, String termId,String model, String startDate, String endDate){
		// sql������ƴװ
	
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select ");
		for (int i = 0; i < field.length; i++) {
			String temp = i == 0 ? "SUM(" + field[0] + ")" : " , SUM(" + field[i] + ")";
			sql.append(temp);
		}
		sql.append(" from CmlTaskInfo c ");

		if(StringUtils.hasText(termId)){
	      	 if(StringUtils.hasText(model)){
	      			List<String> cd = findByDevModle(model);
	      			if(!org.springframework.util.CollectionUtils.isEmpty(cd)){
	      				sql.append(" and termId in ( ");
	      				for (int i = 0; i < cd.size(); i++) {
	      					String temp = (i == 0 ? "'" + cd.get(i) + "'" : ",'"
	      						+ cd.get(i) + "'");
	      					sql.append(temp);
	      				}
	      			}
	      		}
	      	 else{
	      		 sql.append(" and termId='"+termId+"'");
	      	 }
	      }

		if (org.apache.commons.lang.StringUtils.isNotBlank(startDate)) {
			sql.append(" and c.bindStart >=to_date('" + startDate + "','yyyy-MM-dd HH24:mi:ss')");

		}
		if (org.apache.commons.lang.StringUtils.isNotBlank(endDate)) {
			sql.append(" and c.bindStart <=to_date('" + endDate + "','yyyy-MM-dd HH24:mi:ss')");
		}
       
		Object[] result = null;
		
			result   = cmlTaskInfoDao.findUnique(sql.toString());

        	 
		 return result;

	
     

}
/**
 * ����excel
 * @param tmlNum �ն˱��
 * @param startDate ��ʼʱ��
 * @param endDate ����ʱ��
 * @param devmodel �ն��ͺ�
 * @return String 
 * */
public String cmlreport(String termId,String startDate,String endDate){
	HttpServletResponse rep =	 FlexContext.getHttpResponse() ;
	HttpServletRequest req = FlexContext.getHttpRequest();
	HSSFWorkbook hssf = new HSSFWorkbook();
	String fileName =null;
	FileOutputStream fo= null;
	InputStream inputStream = null;
	// ������������һ�ű�	
//	final String[] headerTitle = {"tmlNum", "version05", "version99", "falseCoinMoney",
//			"atmMoney", "passMoney", "stubbedMoney", "shadinessMoney",
//			"trailMoney", "totalMoney" };
	final String[] headerTitle = {"终端编号", "流通币金额",
			"ATM金额", "残损币金额", "伪钞金额", "可疑钞票金额",
			"假币金额", "清分总金额�" };
	List lists = cmlReportDao.getListByTml(field,termId,startDate,endDate);	
	
	try {
	HSSFSheet sheet = hssf.createSheet("BY Opeaator");
	HSSFRow row;
	String text = "";
	row = sheet.createRow(0);
	for (int i = 0; i < headerTitle.length; i++) {
		HSSFCell cell = row.createCell((short) i);
		text = headerTitle[i];
		cell.setCellValue(text);
	}
	for (int i = 0; i < lists.size(); i++) {
		row = sheet.createRow(i + 1);
	Object[] obj = (Object[]) lists.get(i);

		for (int j = 0; j < obj.length; j++) {
		
			if (null == obj[j]) {
				text = "X";
			} else {
				text = obj[j].toString().trim();
			}
			HSSFCell cell = row.createCell((short) j);
			cell.setCellValue(text);
		}
	}
	row = sheet.createRow(lists.size() +1);
	HSSFCell cell = row.createCell( 1);
	

	fileName= "CmlReportTml_"+DateUtil.getTimeYYYYMMDDHHMMSSString(new Date())+".xls"; 
	File f = new File(fileName);
	String filePath = req.getSession().getServletContext()
	.getRealPath("/")
	+ File.separator + "exportFile" + File.separator + fileName;
	fo = new FileOutputStream(filePath);
	hssf.write(fo);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			fo.close();
			fo.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return fileName;
} 
	
	
	/**
	 * ����Excel
	 * @return String
	 * @param list ������ϸ��Ϣ�б�
	 * @param sumObj  �ϼƵ���
	 * 
	 * */
	public String exportExcel(List<CmlTaskInfo> list ,Object[] sumObj){
		String filename ="";
		HttpServletRequest req =FlexContext.getHttpRequest();
		 final String filepath = "/report/report.xls";
		String realPath =req.getSession().getServletContext().getRealPath("") + filepath;
		HSSFWorkbook templatewb = null;
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(realPath));
			templatewb = new HSSFWorkbook(fs,true);
		} catch (IOException ex) {
			logger.error("", ex);
		}
		try{
		filename =  "CmlSentTaskinfos"+".xls";
		String filePath = req.getSession().getServletContext()
		.getRealPath("")
		+ File.separator + "exportFile" + File.separator + filename;// �����ļ�·��	
		HSSFSheet sheet = templatewb.getSheetAt(0);		
		for (int rowid = 0; rowid < list.size(); rowid++) {
			CmlTaskInfo t = list.get(rowid);
			Class<? extends CmlTaskInfo> bean = t.getClass();
			Row row = sheet.createRow(rowid+1);
			//ָ���е������������
			String[] fields = {"tmlNum", "userName", "bindStart",
					"beforeCount", "passMoney", "atmMoney", "stubbedMoney",
					"trailMoney", "shadinessMoney", "falseCoinMoney", "totalMoney" };
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
				} else if (obj instanceof Integer) {
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
		 * sumField ��Ҫ�ϼƵ� Field
		 * �ϼƸ��fields ��Ӧ���в�ѯ��д 
		 */
		String value = "合计:";							
		//���趨�ܼ���֮ǰ��ݵļ��  +1 ?
		Row row2 = sheet.createRow(list.size()+1);
		//������ı���ʼд�ϼ�����
		final int cellCount=2;
		final int colunmCount=4;
		String countValue = "";
		 logger.info("check sumObject()" + (null != sumObj));
		if(null != sumObj){
			row2.createCell(cellCount).setCellValue(value);
		for (int countColumn = colunmCount; countColumn < sumObj.length + colunmCount; countColumn++) {
			Object obj1 = sumObj[(countColumn - colunmCount)];
			if(null !=obj1 ){
				java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0.00");
				countValue = df.format(obj1);
			}else{
				countValue = "0.00";
			}
			Cell  label1 = row2.createCell(countColumn);
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
	
	 /***
	  * @param  list ����������б�
	  * @param sumObj �ϼ�
	  * @return String
	  * */
	public String exportReportCmlExcel(List<CmlTaskInfo> list ,Object[] sumObj){
		String filename ="";
		HttpServletRequest req =FlexContext.getHttpRequest();
		 final String filepath = "/report/report.xls";
      String realPath =req.getSession().getServletContext().getRealPath("") + filepath;
		HSSFWorkbook templatewb = null;
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(realPath));
			templatewb = new HSSFWorkbook(fs,true);
		} catch (IOException ex) {
			logger.error("", ex);
		}
		try{
			
		filename = DateUtil.getTimeYYYYMMDDHHMMSSString(new Date())+".xls"; 
		String filePath = req.getSession().getServletContext()
		.getRealPath("/")
		+ File.separator + "exportFile" + File.separator + filename;// �����ļ�·��	
		HSSFSheet sheet = templatewb.getSheetAt(0);		
		for (int rowid = 0; rowid < list.size(); rowid++) {
			CmlTaskInfo t = list.get(rowid);
			Class<? extends CmlTaskInfo> bean = t.getClass();
			Row row = sheet.createRow(rowid+1);
			//ָ���е������������
		 String[] fields = {"tmlNum", "version05", "version99",
					 "passMoney", "atmMoney", "stubbedMoney",
					"trailMoney", "shadinessMoney", "falseCoinMoney", "totalMoney"};
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
				} else if (obj instanceof Integer) {
					java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0.00");
					value = df.format(obj);
				} else if(null== obj) {
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
		 * sumField ��Ҫ�ϼƵ� Field
		 * �ϼƸ��fields ��Ӧ���в�ѯ��д 
		 */
		String value = "合计:";							
		//���趨�ܼ���֮ǰ��ݵļ��  +1 ?
		Row row2 = sheet.createRow(list.size()+1);
		//������ı���ʼд�ϼ�����
		final int cellCount=3;
		final int colunmCount=4;
		String countValue = "";
		 logger.info("check sumObject()" + (null != sumObj));
		if(null != sumObj){
			row2.createCell(cellCount).setCellValue(value);
		for (int countColumn = colunmCount; countColumn < sumObj.length + colunmCount; countColumn++) {
			Object obj1 = sumObj[(countColumn - colunmCount)];
			if(null !=obj1 ){
				java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0.00");
				countValue = df.format(obj1);
			}else{
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
}

