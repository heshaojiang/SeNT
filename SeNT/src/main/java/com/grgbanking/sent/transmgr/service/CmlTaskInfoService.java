package com.grgbanking.sent.transmgr.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.exception.AppPlaceHolderException;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.platform.module.security.entity.User;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.transmgr.dao.CmlSentInfoDao;
import com.grgbanking.sent.transmgr.dao.CmlTaskInfoDao;
import com.grgbanking.sent.transmgr.entity.CmlSentInfo;
import com.grgbanking.sent.transmgr.entity.CmlTaskInfo;
import com.grgbanking.sent.transmgr.entity.CmlTaskInfoDetail;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StreamUtil;
import com.grgbanking.sent.utils.StringUtil;

import flex.messaging.FlexContext;

/**
 * 
 */
@Service
@Transactional
public class CmlTaskInfoService extends BaseService
{
	@Autowired
	CmlTaskInfoDao cmlTaskInfoDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrgInfoDao orgInfoDao;
	
	@Autowired
	ParamDao paramDao;

	@Autowired
	CmlSentInfoDao cmlSentInfoDao;
	
	//String dialect=springService.getHibernateDialect();
	
	final int no3 = 3;
	final int no4 = 4;
	final int no5 = 5;
	final int no6 = 6;
	final int no7 = 7;
	final int no8 = 8;
	final int no9 = 9;
	final int no10 = 10;
	final int no11 = 11;
	final int no12 = 12;
	final String[] field = {"termId","bindStart","statisAmt" };
			
	
	/**
	 * ??????? TranInfo???
	 * 
	 * @param cmlTaskInfo
	 *            TranInfo???
	 * @return boolean
	 */
	public boolean editCmlTaskInfo(CmlTaskInfo cmlTaskInfo)
	{
		String hql = 	" update CmlTaskInfo tsk set" +
							" tsk.termId=?," +
							
							" tsk.statisAmt=?" +
						" where tsk.id = ?";
		
		Object[] parameters = new Object[]{ 
			cmlTaskInfo.getTermId(), 
			cmlTaskInfo.getStatisAmt(), 
			cmlTaskInfo.getId() 
		};
		
		cmlTaskInfoDao.executeUpdate(hql, parameters);
		
		//cmlTaskInfoDao.copyUpdate(obj);
		return true;
	}

	/**
	 * ???????id???????????????
	 * 
	 * @param id
	 *            ??????
	 * @return CmlTaskInfo
	 * */
	@Transactional(readOnly = true)
	public CmlTaskInfo getCmlTaskInfo(String id) {
		return cmlTaskInfoDao.get(id);
	}

	/**
	 * ????????????????
	 * 
	 * @param page
	 *            ??????
	 * @param beginDateString
	 *            ??????
	 * @param endDateString
	 *            ???????
	 * @return Page
	 * @param cml
	 *            ?????????????
	 * */
	@Transactional(readOnly = true)
	public Page getCmlTaskInfoPage(Map parameter)
	{
		Page page = (Page)parameter.get("page");
		Map<Object, String> condition = (Map<Object, String>)parameter.get("condition");
		
		String startTime = StringUtil.trim(condition.get("startTime"));
		String endTime = StringUtil.trim(condition.get("endTime"));
		String termId = StringUtil.trim(condition.get("termId"));
		String pathCode = StringUtil.trim(condition.get("pathCode"));
		String flag=(String)condition.get("flag");
		String operatorId = StringUtil.trim(condition.get("operatorId"));
		
		int day = Integer.parseInt(paramDao.getValueByPath(AppConstants.CML_TRANSDAY));
		
		if( StringUtil.isBlank(startTime) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_START_TIME_CANNOT_BE_NULL, "查询开始时间不能为空!");
		}
		
		if( StringUtil.isBlank(endTime) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_END_TIME_CANNOT_BE_NULL, "查询结束时间不能为空!");
		}
		
		Date dStartTime = null;
		Date dEndTime = null;
		try
		{
			dStartTime = DateUtil.parseToDate(startTime, "yyyy-MM-dd HH:mm:ss");
			dEndTime = DateUtil.parseToDate(endTime, "yyyy-MM-dd HH:mm:ss");
		}
		catch (ParseException e)
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG, "查询时间格式不正确["+e.getMessage()+"]");
		}
		
		//转化为两位的月份
		String mothStart_ = dStartTime.getMonth()<9?"0"+(dStartTime.getMonth()+1):(dStartTime.getMonth()+1)+"";
		String mothEnd_ = dEndTime.getMonth()<9?"0"+(dEndTime.getMonth()+1):(dEndTime.getMonth()+1)+"";
		//转化为两位的日期　统一格式
		String dayStart = dStartTime.getDate()<=9?"0"+dStartTime.getDate():dStartTime.getDate()+"";
		String dayEnd = dEndTime.getDate()<=9?"0"+dEndTime.getDate():dEndTime.getDate()+"";
		StringBuffer sb = new StringBuffer("");
		//拼接sql,分为跨年与不跨年
		if(dStartTime.getYear() == dEndTime.getYear())
		{
		sb.append("   c.partMonthday>='").append(mothStart_).append(dayStart);
		sb.append("' and c.partMonthday<='").append(mothEnd_).append(dayEnd).append("'");
		}else if(dStartTime.getYear() < dEndTime.getYear()){
		sb.append("   ( c.partMonthday>='").append(mothStart_).append(dayStart);
		sb.append("' or c.partMonthday<='").append(mothEnd_).append(dayEnd).append("')");
		}else
		{
		throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG, "查询时间格式不正确：结束时间大于开始时间");
		}
		
		if( Math.abs(dEndTime.getTime() - dStartTime.getTime()) >= DateUtil.MILLISECOND_PER_DAY*day )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_PLEASE_SELECT_QUERY_DATE_WITHIN, "请选择[%s]天以内的时间进行查询!", day);
		}
		
		List<Object> sqlParam = new ArrayList<Object>();
		String hql = 	" from CmlTaskInfo c" +
						" where "+sb.toString()+" and c.bindStart >= ?" +
						" and c.bindStart <= ?";
		
		sqlParam.add(dStartTime);
		sqlParam.add(dEndTime);
		
		if( StringUtil.isNotBlank(pathCode) )
		{
			if(null == flag || flag.equals("true")){
				hql += " and c.pathcode like ?";
				sqlParam.add(pathCode+"%");
			}else{
				hql += " and c.pathcode = ?";
				sqlParam.add(pathCode+"");
			}
		}
		if( StringUtil.isNotBlank(operatorId) )
		{
			hql += " and c.tdOperatorId like ?";
			sqlParam.add(operatorId);
		}
		if( StringUtil.isNotBlank(termId) )
		{
			hql += " and c.termId = ?";
			sqlParam.add(termId);
		}
		
		hql += " order by c.bindStart desc";

		return cmlTaskInfoDao.findPage(page, hql, sqlParam.toArray());
	}

	/**
	 * getInitCmlParamMap ??????ￄ1�7�1�7�1�7�1�7???
	 * 
	 * @return String ?????????????????ￄ1�7�1�7�1�7�1�7
	 * */
	public String getInitCmlTaskParamMap() {
		return paramDao.getValueByPath((AppConstants.CML_TRANSDAY));
	}

	
	/**
	 * ???List???Page
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

	// public List<Object[]> geterrListByParams(Map<String, Object> params) {
	// return getTaskListByParams(params);
	// }
	/**
	 *???id?????????????
	 * 
	 * @param id
	 *            ???
	 *@return ??????
	 */
	@Transactional(readOnly = true)
	public CmlTaskInfo getCmlSentObject(String id) {
		return (CmlTaskInfo) cmlTaskInfoDao.get(id);
	}

	/**
	 * ??????????
	 * 
	 * @param page
	 * @param userId
	 * @return List<User>
	 */
	public List<User> loadUsers() {

		return userDao.getAll();
	}

	
	public String report(CmlTaskInfo cml, String startDate, String endDate)
	{
		List<CmlTaskInfoDetail> list = getObjectList(cml, startDate, endDate);

		String[] sumField = { "beforeAmt", "statisAmt" };
		
		Object[] sumObj = getSUMList(sumField, cml, startDate, endDate);

		return exportExcel(list, sumObj);
	}

	/**
	 * 导出Excel
	 * @return String
	 * @param list 任务详细信息列表
	 * @param sumObj  合计的列
	 * 
	 */
	public String exportExcel(List<CmlTaskInfoDetail> list, Object[] sumObj)
	{
		String filename = "CmlSentTaskinfos.xls";
		HttpServletRequest req = FlexContext.getHttpRequest();
		String realPath = req.getSession().getServletContext().getRealPath("") + "/report/report.xls";
		HSSFWorkbook templatewb = null;
		OutputStream out = null;
		try
		{
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(realPath));
			templatewb = new HSSFWorkbook(fs, true);
			
			HSSFSheet sheet = templatewb.getSheetAt(0);
			for( int rowid = 0 ; rowid < list.size() ; rowid++ )
			{
				CmlTaskInfoDetail t = list.get(rowid);
				Class<? extends CmlTaskInfoDetail> bean = t.getClass();
				Row row = sheet.createRow(rowid + 1);
				String[] fields = { "termId", "uid", "tranDate", "beforeAmt", "statisAmt" };

				for( int column = 1 ; column < fields.length + 1 ; column++ )
				{
					String value = "";
					String field = fields[column - 1];
					Field field2 = bean.getDeclaredField(field);
					String name = field2.getName();
					String prefix = name.substring(0, 1);
					name = "get" + prefix.toUpperCase() + name.substring(1);
					Method method = bean.getDeclaredMethod(name);
					Object obj = method.invoke(t);
					if( obj instanceof Date )
					{
						value = obj.toString().substring(0, obj.toString().lastIndexOf("."));
					}
					else if( obj instanceof Number )
					{
						java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0.00");
						value = df.format(obj);
					}
					else if( null == obj )
					{
						value = "\\";
					}
					else
					{
						value = obj.toString();
					}
					Cell label1 = row.createCell(column);
					label1.setCellValue(value);
				}
				Cell laCel2 = row.createCell(0);
				laCel2.setCellValue(String.valueOf(rowid + 1));
			}
			
			String value = "总计:";
			Row row2 = sheet.createRow(list.size() + 1);
			final int cellCount = 3;
			final int colunmCount = 4;
			String countValue = "";
			if( null != sumObj )
			{
				row2.createCell(cellCount).setCellValue(value);
				for( int countColumn = colunmCount ; countColumn < sumObj.length + colunmCount ; countColumn++ )
				{
					Object obj1 = sumObj[(countColumn - colunmCount)];
					if( null != obj1 )
					{
						java.text.DecimalFormat df = new java.text.DecimalFormat("###,##0.00");
						countValue = df.format(obj1);
					}
					else
					{
						countValue = "0.00";
					}
					Cell label1 = row2.createCell(countColumn);
					label1.setCellValue(countValue);
				}
			}
			String filePath = req.getSession().getServletContext().getRealPath("") + "/exportFile/" + filename;
			File outFile = new File(filePath);
			logger.info("outFile = "+outFile.getAbsolutePath());
			out = new FileOutputStream(outFile);
			templatewb.write(out);
		}
		catch (IOException e)
		{
			logger.error("", e);
		}
		catch (NoSuchFieldException e)
		{
			logger.error("", e);
		}
		catch (NoSuchMethodException e)
		{
			logger.error("", e);
		}
		catch (InvocationTargetException e)
		{
			logger.error("", e);
		}
		catch (IllegalAccessException e)
		{
			logger.error("", e);
		}
		catch (SecurityException e)
		{
			logger.error("", e);
		}
		finally
		{
			StreamUtil.close(out);
		}
		return filename;
	}

	
	/**
	 * 
	 */
	@Transactional(readOnly = true)
	public Page getCmlSentInfosPageByvo(Page page, CmlTaskInfo cmlTaskInfo)
	{
		String hql = 	" select csi" +
						" from CmlSentInfo csi" +
						" where csi.tranId='" + cmlTaskInfo.getId() + "'" +
						" order by csi.sequence asc";

		Page page2 = cmlSentInfoDao.findPage(page, hql);

		return page2;
	}
	
	/**
	 * ��ѯ���еĲ���Ա
	 */
	@Transactional(readOnly = true)
	public List findAllOperatorList()
	{
		String hql = "select cml.tdOperatorId  from CmlTaskInfo cml group by cml.tdOperatorId";
		List li = new ArrayList();
		List<Map> list = new ArrayList<Map>();
		try
		{
			li = cmlTaskInfoDao.find(hql);

			for( int i = 0 ; i < li.size() ; i++ )
			{
				String oper = (String) li.get(i);
				Map<String, String> m = new HashMap<String, String>();
				m.put("key", oper);
				list.add(m);
			}
		}
		catch( AppException e )
		{
			list = null;
			logger.error("", e);
		}
		return list;
	}

	/**
	 * ��ѯ���е��ն�
	 * */
	@Transactional(readOnly = true)
	public List findAllTermList()
	{
		String hql = "select cml.termId  from CmlTaskInfo cml group by cml.termId ";
		List li = new ArrayList();
		List<Map> newList = new ArrayList<Map>();
		try
		{
			li = cmlTaskInfoDao.find(hql);
			for( int i = 0 ; i < li.size() ; i++ )
			{
				String temrm = (String) li.get(i);
				Map<String, String> m = new HashMap<String, String>();
				m.put("key", temrm);
				newList.add(m);
			}
		}
		catch( AppException e )
		{
			newList = null;
			logger.error("", e);
		}
		return newList;
	}

	
	
	/**
	 * ��ݻ��ѯ��Ӧ�Ĳ���Ա
	 * */
	@Transactional(readOnly = true)
	public List findOperatorByOrgList(String pathCode){
	String hql="select cml.tdOperatorId  from CmlTaskInfo cml where cml.pathcode like '"+orgInfoDao.getPathCodeById(pathCode)+"%' group by cml.tdOperatorId";
		//hql+=" and cml.pathcode like '"+orgInfoDao.getPathCodeById(pathCode)+"%'";
		List li=new ArrayList();
		List<Map> list=new ArrayList<Map>();
		try {
		   li=cmlTaskInfoDao.find(hql);
		 
	   for(int i=0;i<li.size();i++){
			String oper= (String)li.get(i);
			  Map<String, String> m = new HashMap<String, String>();
			  m.put("key", oper);
			  list.add(m);
	   }
		} 
	    catch(AppException e){
		     list=null;
			logger.error("",e);
	}
			return list;
	}
	
	/**
	 * ��ݻ��ѯ��Ӧ���ն�
	 * */
	@Transactional(readOnly = true)
	public List findTmlNumByOrgList(String pathCode){
		String hql="select cml.termId from CmlTaskInfo cml where cml.pathcode like '"+orgInfoDao.getPathCodeById(pathCode)+"%' group by cml.termId";
		List li=new ArrayList();
		List<Map> newList=new ArrayList<Map>();
		try {
		    li=cmlTaskInfoDao.find(hql);
		    for(int i=0;i<li.size();i++){
		    	String temrm=(String)li.get(i);
		    	Map<String,String> m=new HashMap<String, String>();
		    	m.put("key",temrm);
		    	newList.add(m);
		    }
		}
		  catch(AppException e){
			  newList=null;
			  logger.error("",e);
		}
		   return newList;
	}
	/**
	 *���������ѯ�����е�list
	 *@param termId
	 *@param operatorName operatorName
	 *@param startDate startDate
	 *@param endDate endDate
	 *@return  List<CmlTaskInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<CmlTaskInfoDetail> getObjectList(CmlTaskInfo cml, String startDate, String endDate)
	{
		StringBuffer sql = new StringBuffer(" select" +
												" c.termId," +
												" c.bindStart," +
												" c.beforeAmt," +
												" c.statisAmt," +
												" c.id," +
												" c.tdOperatorId" +
											" from CmlTaskInfo c" +
											" where 1=1" );
	
		if( null != cml.getTermId() && !cml.getTermId().equals("") )
		{
			sql.append(" and  c.termId ='" + cml.getTermId().trim() + "'");
		}
		if( null != cml.getPathcode() && !cml.getPathcode().equals("") )
		{
			sql.append(" and  c.pathcode like '" + orgInfoDao.getPathCodeById(cml.getPathcode()) + "%'");
		}
		if( null != cml.getTdOperatorId() && !cml.getTdOperatorId().equals("") )
		{
			sql.append(" and c.tdOperatorId like '" + cml.getTdOperatorId() + "%'");
		}
		if( startDate != null && !startDate.equals("") )
		{
			sql.append(" and c.bindStart>=TO_DATE('" + startDate + "' ,'yyyy-MM-dd HH24:mi:ss')");
		}
		if( endDate != null && !endDate.equals("") )
		{
			sql.append(" and c.bindStart<=TO_DATE('" + endDate + "' ,'yyyy-MM-dd HH24:mi:ss')");
		}
       
		sql.append(" order by c.bindStart desc");

		List<Object[]> ll = cmlTaskInfoDao.find(sql.toString());
		List<CmlTaskInfoDetail> result = new ArrayList();
		for( Object[] obj : ll )
		{
			CmlTaskInfoDetail ad = new CmlTaskInfoDetail();
			if( obj[0] != null && !"".equals(obj[0].toString()) )
			{
				ad.setTermId(obj[0].toString().trim());
			}
			if( obj[1] != null && !"".equals(obj[1].toString()) )
			{
				ad.setOperateDate((Date) obj[1]);
			}
			if( obj[2] != null && !"".equals(obj[2].toString()) )
			{
				ad.setBeforeCount(Float.parseFloat(obj[2].toString()));
			}
			if( obj[3] != null && !"".equals(obj[3].toString()) )
			{
				ad.setStatisAmt(Float.parseFloat(obj[3].toString().trim()));
			}
			if( obj[4] != null && !"".equals(obj[4].toString()) )
			{
				ad.setId(obj[4].toString().trim());
			}
			if( obj[5] != null && !"".equals(obj[5].toString()) )
			{
				ad.setUid(obj[5].toString().trim());
			}

			result.add(ad);
		}

		return result ;
	}
	
	
	/**
	 * @param   field  ��Ҫ���кϼƵ��ֶ�
	 * @param   termId
	 * @param startDate startDate
	 * @param  endDate endDate
	 * @return  Object[]
	 */
	public Object[] getSUMList(String[] field, CmlTaskInfo cml, String startDate, String endDate)
	{
		StringBuffer sql = new StringBuffer();

		sql.append(" select ");
		for (int i = 0; i < field.length; i++)
		{
			String temp = i == 0 ? "SUM(" + field[0] + ")" : " , SUM(" + field[i] + ")";
			sql.append(temp);
		}
		sql.append(" from CmlTaskInfo c  where 1=1");
		if (null != cml.getTermId() && !cml.getTermId().equals(""))
		{
			sql.append(" and  c.termId ='" + cml.getTermId().trim() + "'");
		}
		if (null != cml.getPathcode() && !cml.getPathcode().equals(""))
		{
			sql.append(" and  c.pathcode like '" + orgInfoDao.getPathCodeById(cml.getPathcode()) + "%'");
		}
		if (null != cml.getTdOperatorId() && !cml.getTdOperatorId().equals(""))
		{
			sql.append(" and c.tdOperatorId like '" + cml.getTdOperatorId() + "%'");
		}

		if (startDate != null && !startDate.equals(""))
		{
			sql.append(" and c.bindStart >=TO_DATE('" + startDate + "','yyyy-MM-dd HH24:mi:ss')");
		}
		if (endDate != null && !endDate.equals(""))
		{
			sql.append(" and c.bindStart<=TO_DATE('" + endDate + "','yyyy-MM-dd HH24:mi:ss')");
		}
		Object[] result = null;
		result = cmlTaskInfoDao.findUnique(sql.toString());
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public CmlTaskInfo getCmlTaskInfoDetailById(String id)
	{	
		CmlTaskInfo cmlTaskInfo = cmlTaskInfoDao.get(id);
		if( cmlTaskInfo==null )
		{
			return cmlTaskInfo;
		}
		
		String pathCode = cmlTaskInfo.getPathcode();
		if( pathCode==null )
		{
			return cmlTaskInfo;
		}
		
		OrgInfo orgInfo = orgInfoDao.getByPathCode(pathCode);
		if( orgInfo==null )
		{
			return cmlTaskInfo;
		}
		cmlTaskInfo.setOrgCode(orgInfo.getOrgCode());
		cmlTaskInfo.setPathCodeName(orgInfo.getOrgName());
		cmlTaskInfo.setPathCodeFullName(orgInfo.getOrgFullName());
		cmlTaskInfo.setFinacialCode(orgInfo.getFinacialCode());
		OrgInfo bankInfo = null;
		if( pathCode.length()<=15 ){
			//return cmlTaskInfo;
			bankInfo = orgInfo;
		}else{
			bankInfo = orgInfoDao.getByPathCode(pathCode.substring(0, 15));
		}
		
		if( bankInfo==null ){
			return cmlTaskInfo;
		}
		cmlTaskInfo.setBankName(bankInfo.getOrgName());
		cmlTaskInfo.setBankFullName(bankInfo.getOrgFullName());
		
		return cmlTaskInfo;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlSentInfo> getCmlSentInfosPageByTranId(Map parameter)
	{
		Page page = (Page)parameter.get("page");
		String tranId = (String)parameter.get("tranId");
		
		
		String hql = 	" select csi" +
						" from CmlSentInfo csi" +
						" where csi.tranId = ?" +
						" order by csi.sequence asc";

		Page<CmlSentInfo> page2 = cmlSentInfoDao.findPage(page, hql, tranId);

		return page2;
	}
	
}
	
