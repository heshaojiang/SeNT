package com.grgbanking.cml.report.service;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.cml.report.dao.CmlReportDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.sent.transmgr.dao.CmlTaskInfoDao;
import com.grgbanking.sent.transmgr.entity.CmlTaskInfo;
import com.grgbanking.sent.utils.DateUtil;

import flex.messaging.FlexContext;

@Service
@Transactional
public class CmlExportinfoService extends BaseService {

	@Autowired
	CmlReportDao cmlReportDao;
	@Autowired
	CmlTaskInfoDao cmlTaskInfoDao;
	@Autowired
	UserDao userDao;
	@Autowired 
	ParamDao paramDao;
	final String[] field = {"falseCoinMoney", "atmMoney", "passMoney", "stubbedMoney", "shadinessMoney", "trailMoney", "totalMoney" };

	public Page getTaskInfoPageByOperator(Page page, String operatorname,
			String startTime, String endTime) throws IllegalArgumentException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		StringBuffer hql = new StringBuffer();
		hql.append(" select  r.operatorId ");
		for (int i = 0; i < field.length; i++) {
			String temp = " ,SUM(" + "r."+field[i] + ") ";
			hql.append(temp);
		}
		//hql.append(" from CmlReport r  where 1=1 ");
		hql.append(" from CmlTaskInfo r  where 1=1 ");
		if (org.apache.commons.lang.StringUtils.isNotBlank(operatorname)) {
//			hql
//					.append("  and  exists (Select 'X' from User u  where r.operatorId = u.userCode  and  u.userName like  '%"
//							+ operatorname + "%') ");
			//ֱ��д���ø��û������
			hql.append(" and  r.operatorId like '"+operatorname+"%'");
		}
		if (null!=startTime && !startTime.equals("")) {
			hql.append(" and r.operateDate >=to_date('" + startTime
					+ "','yyyy-MM-dd HH24:mi:ss') ");
		}
		if (null!=endTime && !endTime.equals("")) {
			hql.append(" and r.operateDate <=to_date('" + endTime
					+ "','yyyy-MM-dd HH24:mi:ss ') ");
		}
		hql.append("  group by r.operatorId");
		
		 List<Object> list = cmlTaskInfoDao.find(hql.toString());
		 //分页
	     Page pageObject=getPageList(list,page);
	     //得到每一页的结果集
	     List<Object> objList = pageObject.getResult();
	     List<CmlTaskInfo> resuList = new ArrayList<CmlTaskInfo>();
	 	//将结果集重新封装
	for (int i = 0; i < objList.size(); i++) {
		Object[] obj = (Object[]) objList.get(i);
		
		CmlTaskInfo rc = new CmlTaskInfo();
		//try {		
			//rc.setOperatorId(userDao.getByUserCode(obj[0].toString()).getUserName());
	//	} catch (Exception e) {
			//rc.setOperatorId("XXX");	
	//	}
		if(null!=obj[0]&&!obj[0].equals("")){
	rc.setTdOperatorId(obj[0].toString().trim());
		}
		else{
			obj[0]="";
			rc.setTdOperatorId(obj[0].toString().trim());
		}
		Class<?> cc = CmlTaskInfo.class;
		for (int j = 0; j < field.length; j++) {
			cc.getDeclaredMethod( 
					"set" + field[j].substring(0, 1).toUpperCase()
							+ field[j].substring(1), float.class).invoke(rc,null == obj[j + 1] ? 0.0f : new Float(obj[j + 1]
							.toString()));
		}
		resuList.add(rc);
		
	
	}
	
	page.setResult(resuList);

	return page;

		// TODO: handle exception
	}
		
@Transactional(readOnly = true)
public Page getPageList(List list, Page page) {
	return cmlTaskInfoDao.getPageList(list, page);
}
	
	
	public String exportCmlReportOperator( String operatorname, String startTime, String endTime)
	{
		HttpServletResponse rep = FlexContext.getHttpResponse();
		HttpServletRequest req = FlexContext.getHttpRequest();
		HSSFWorkbook hssf = new HSSFWorkbook();
		String fileName = null;
		FileOutputStream fo = null;
		InputStream inputStream = null;
		final String[] headerTitle = { "清分员", "流通币金额", "ATM金额", "残损币金额", "伪钞金额", "可疑钞金额", "假币金额", "清分总金额" };
		List lists = cmlReportDao.getListByOperator(field, operatorname, startTime, endTime);

		try
		{
			HSSFSheet sheet = hssf.createSheet("BY Opeaator");
			HSSFRow row;
			String text = "";
			row = sheet.createRow(0);
			for( int i = 0 ; i < headerTitle.length ; i++ )
			{
				HSSFCell cell = row.createCell((short) i);
				text = headerTitle[i];
				cell.setCellValue(text);
			}
			for( int i = 0 ; i < lists.size() ; i++ )
			{
				row = sheet.createRow(i + 1);
				Object[] obj = (Object[]) lists.get(i);

				for( int j = 0 ; j < obj.length ; j++ )
				{

					if( null == obj[j] )
					{
						text = "X";
					}
					else
					{
						text = obj[j].toString().trim();
					}
					HSSFCell cell = row.createCell((short) j);
					cell.setCellValue(text);
				}
			}
			row = sheet.createRow(lists.size() + 1);
			HSSFCell cell = row.createCell(1);

			fileName = "CmlReportOperator_" + DateUtil.getTimeYYYYMMDDHHMMSSString(new Date()) + ".xls";
			File f = new File(fileName);
			String filePath = req.getSession().getServletContext().getRealPath("/") + File.separator + "exportFile" + File.separator + fileName;
			fo = new FileOutputStream(filePath);
			hssf.write(fo);
		}
		catch( IOException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fo.close();
				fo.flush();

			}
			catch( IOException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fileName;
	} 

}
