package com.grgbanking.sent.watch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.watch.dao.TranAbnoinfoDao;
import com.grgbanking.sent.watch.entity.AccountAnalyse;
import com.grgbanking.sent.watch.entity.RegulationAnalyse;
import com.grgbanking.sent.watch.entity.TmlAnalyse;
import com.grgbanking.sent.watch.entity.TranAbnoinfo;

/**
 * 异常交易监控Service层继承公共的BaseService层
 * 
 * @author 广电运通
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class TranAbnoinfoService extends BaseService
{
	@Autowired
	OrgInfoDao orgInfoDao;
	
	@Autowired
	private TranAbnoinfoDao tranAbnoinfoDao;

	/**
	 * 异常回收
	 * 
	 * @param page
	 *            实体
	 * @param tranAbnoinfo
	 *            注入的参数
	 * @return Page
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 */
	@Transactional(readOnly = true)
	public Page getCallBackTranAbnoinfoPage(Page page, TranAbnoinfo tranAbnoinfo, String beginDate, String endDate)
	{
		StringBuffer hql = new StringBuffer("from TranAbnoinfo trans where trans.abnoType='3' and trans.anyDate is not null");

		List values = new ArrayList();

		if( beginDate != null && !beginDate.equals("") )
		{
			beginDate = DateUtil.dateFormatTohms(beginDate);
			hql.append(" and trans.tranDate >= ? ");
			values.add(beginDate);
		}
		if( endDate != null && !endDate.equals("") )
		{
			endDate = DateUtil.dateFormatTohms(endDate);
			hql.append(" and trans.tranDate <= ? ");
			values.add(endDate);
		}

		String accountNo = tranAbnoinfo.getAccountNo();
		if( accountNo != null && !accountNo.equals("") )
		{
			hql.append(" and trans.accountNo = ? ");
			values.add(accountNo);

		}
		if( tranAbnoinfo.getPathcode() != null && !tranAbnoinfo.getPathcode().equals("") )
		{
			hql.append(" and trans.pathcode like  ? ");
			values.add(tranAbnoinfo.getPathcode() + "%");
		}

		hql.append(" order by trans.tranDate desc ");

		Page p = new Page();
		p = tranAbnoinfoDao.findPage(page, hql.toString(), values.toArray());
		return p;
	}

	/**
	 * 特殊冠 字号
	 * 
	 * @param page
	 *            实体
	 * @param tranAbnoinfo
	 *            注入的参数
	 * @return Page
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 */
	@Transactional(readOnly = true)
	public Page getEspecialTranAbnoinfoPage(Page page, TranAbnoinfo tranAbnoinfo, String beginDate, String endDate)
	{
		List values = new ArrayList();

		StringBuffer hql = new StringBuffer("from TranAbnoinfo trans where trans.abnoType='4' and trans.anyDate is not null");

		if( beginDate != null && !beginDate.equals("") )
		{
			beginDate = DateUtil.dateFormatTohms(beginDate);
			hql.append(" and trans.tranDate >= ? ");
			values.add(beginDate);
		}
		if( endDate != null && !endDate.equals("") )
		{
			endDate = DateUtil.dateFormatTohms(endDate);
			hql.append(" and trans.tranDate <= ? ");
			values.add(endDate);
		}

		String accountNo = tranAbnoinfo.getAccountNo();
		if( accountNo != null && !accountNo.equals("") )
		{
			hql.append(" and trans.accountNo = ? ");
			values.add(accountNo);

		}
		if( tranAbnoinfo.getPathcode() != null && !tranAbnoinfo.getPathcode().equals("") )
		{

			hql.append(" and trans.pathcode like   ?  ");
			values.add(tranAbnoinfo.getPathcode() + "%");

		}
		// OperatorTime(values, hql, beginDate, endDate);
		Page pageObject = new Page();
		pageObject = tranAbnoinfoDao.findPage(page, hql.toString(), values.toArray());
		return pageObject;
	}

	/**
	 * 根据查询语句查找一个集合
	 * 
	 * @param obj
	 *            注入的参数
	 * @return page
	 */

	@Transactional(readOnly = true)
	public List getTranAbnoinfoList(Object[] obj)
	{
		String sql = "  from TranAbnoinfo ";
		return tranAbnoinfoDao.find(sql);
	}

	/**
	 * 根据ID主键找出一个实体
	 * 
	 * @param id
	 *            TranAbnoinfo的主键
	 * @return TranAbnoinfo
	 */
	@Transactional(readOnly = true)
	public TranAbnoinfo getTranAbnoinfoObject(String id)
	{
		return (TranAbnoinfo) tranAbnoinfoDao.get(id);
	}

	/**
	 * 黑名单或重号交易
	 * 
	 * @param page
	 *            page实体
	 * @param tranAbnoinfo
	 *            tranAbnoinfo实体
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return Page
	 */
	@Transactional(readOnly = true)
	public Page getTranAbnoAnalyseinfoPage(Page page, TranAbnoinfo tranAbnoinfo, String beginDate, String endDate)
	{
		List values = new ArrayList();

		StringBuffer hql = new StringBuffer(
				" select trans" + 
				" from TranAbnoinfo trans" + 
				" where ( trans.abnoType='1' or trans.abnoType='2' )" + 	// 黑名单、重号
				" and trans.anyDate is not null"
				);

		if( StringUtils.isBlank(beginDate) == false )
		{
			beginDate = DateUtil.dateFormatTohms(beginDate);
			hql.append(" and trans.tranDate >= ? ");
			values.add(beginDate);
		}
		if( StringUtils.isBlank(endDate) == false )
		{
			endDate = DateUtil.dateFormatTohms(endDate);
			hql.append(" and trans.tranDate <= ? ");
			values.add(endDate);
		}
		if( StringUtils.isBlank(tranAbnoinfo.getAccountNo()) == false )
		{
			hql.append(" and trans.accountNo = ? ");
			values.add(tranAbnoinfo.getAccountNo());
		}
		if( StringUtils.isBlank(tranAbnoinfo.getPathcode()) == false )
		{
			hql.append(" and trans.pathcode like  ? ");
			values.add(tranAbnoinfo.getPathcode() + "%");
		}

		hql.append(" order by trans.tranDate desc ");

		return tranAbnoinfoDao.findPage(page, hql.toString(), values.toArray());
	}

	/**
	 * 根据 卡号/账号及时间区间 得到异常交易，并进行分组，得到每个卡号/账号异常交易次数
	 * 
	 * @param page
	 *            page实体
	 * @param tranAbnoinfo
	 *            tranAbnoinfo实体
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return Page
	 */
	@Transactional(readOnly = true)
	public Page getTranAbnoAnalyseinfoList(Page page, TranAbnoinfo tranAbnoinfo, String beginDate, String endDate)
	{
		List values = new ArrayList();

		StringBuffer hql = new StringBuffer("select trans.accountNo, count(*) from TranAbnoinfo trans where 1=1");

		if( beginDate != null && !beginDate.equals("") )
		{
			beginDate = DateUtil.dateFormatTohms(beginDate);
			hql.append(" and trans.tranDate >= ? ");
			values.add(beginDate);
		}
		if( endDate != null && !endDate.equals("") )
		{
			endDate = DateUtil.dateFormatTohms(endDate);
			hql.append(" and trans.tranDate <= ? ");
			values.add(endDate);
		}
		if( tranAbnoinfo.getAccountNo() != null && !tranAbnoinfo.getAccountNo().equals("") )
		{
			hql.append(" and trans.accountNo = ? ");
			values.add(tranAbnoinfo.getAccountNo());
		}
		// OperatorTime(values, hql, beginDate, endDate);
		if( tranAbnoinfo.getPathcode() != null && !tranAbnoinfo.getPathcode().equals("") )
		{
			hql.append(" and trans.pathcode like  ?  ");
			values.add(tranAbnoinfo.getPathcode() + "%");
		}
		hql.append(" group by trans.accountNo");
		List<Object> list = tranAbnoinfoDao.find(hql.toString(), values.toArray());
		// 分页
		Page pageObject = getPageList(list, page);
		// 得到每一页的结果集
		List<Object> objList = pageObject.getResult();
		List<AccountAnalyse> accountList = new ArrayList<AccountAnalyse>();
		// 将结果集重新封装
		for( int i = 0 ; i < objList.size() ; i++ )
		{
			AccountAnalyse acAnalyse = new AccountAnalyse();
			Object[] tmp = (Object[]) objList.get(i);

			if( tmp != null && tmp.length >= 2 )
			{
				if( tmp[0] != null && !"".equals(tmp[0].toString()) )
				{
					acAnalyse.setAccountNo(tmp[0].toString());
				}
				if( tmp[1] != null && !"".equals(tmp[1].toString()) )
				{
					acAnalyse.setCount((Long) tmp[1]);
				}
				accountList.add(acAnalyse);
			}

		}
		page.setResult(accountList);

		return page;
	}

	/**
	 * 根据 卡号/账号及时间区间得到异常交易列表
	 * 
	 * @param str_accountNo
	 *            组成卡号和时间区间的字符串 用"|"进行分割
	 * @return List<TranAbnoinfo>
	 * @author Yondy Chow
	 */
	@Transactional(readOnly = true)
	public List<TranAbnoinfo> getTranAbnoinfoAnalyseList(String str_accountNo)
	{

		int firstIndex = str_accountNo.indexOf("|");
		int lastIndex = str_accountNo.lastIndexOf("|");
		String accountNo = str_accountNo.substring(0, firstIndex);
		List values = new ArrayList();
		StringBuffer hql = new StringBuffer(" from TranAbnoinfo trans where trans.accountNo=? ");
		values.add(accountNo);

		String beginDate = str_accountNo.substring(firstIndex + 1, lastIndex);

		if( beginDate != null && !beginDate.equals("") )
		{
			beginDate = DateUtil.dateFormatTohms(beginDate);
			hql.append(" and trans.tranDate >= ? ");
			values.add(beginDate);
		}
		String endDate = str_accountNo.substring(lastIndex + 1);
		if( endDate != null && !endDate.equals("") )
		{
			endDate = DateUtil.dateFormatTohms(endDate);
			hql.append(" and trans.tranDate <= ? ");
			values.add(endDate);
		}
		
		hql.append(" order by trans.tranDate desc ");
		
		// OperatorTime(values, hql, beginDate, endDate);
		// hql.append(
		// " order by trans.transYear desc, trans.tranMonthDay desc,trans.transTime desc ");

		return tranAbnoinfoDao.find(hql.toString(), values.toArray());
	}

	/**
	 * 根据 终端编号 及时间区间 得到异常交易，并进行分组，得到每台终端异常交易次数
	 * 
	 * @param page
	 *            page实体
	 * @param tranAbnoinfo
	 *            TranAbnoinfo实体
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return Page
	 * @author Yondy Chow
	 */
	@Transactional(readOnly = true)
	public Page getTranAbnoAnalyseinfoByTmlList(Page page, TranAbnoinfo tranAbnoinfo, String beginDate, String endDate)
	{
		List values = new ArrayList();

		StringBuffer hql = new StringBuffer("select trans.termid, count(*) from TranAbnoinfo trans where 1=1");

		if( beginDate != null && !beginDate.equals("") )
		{
			beginDate = DateUtil.dateFormatTohms(beginDate);
			hql.append(" and trans.tranDate >= ? ");
			values.add(beginDate);
		}
		if( endDate != null && !endDate.equals("") )
		{
			endDate = DateUtil.dateFormatTohms(endDate);
			hql.append(" and trans.tranDate <= ? ");
			values.add(endDate);
		}
		String termid = tranAbnoinfo.getTermid();
		if( termid != null && !termid.equals("") )
		{

			hql.append(" and trans.termid= ?  ");
			values.add(termid);
		}
		// OperatorTime(values, hql, beginDate, endDate);
		if( tranAbnoinfo.getPathcode() != null && !tranAbnoinfo.getPathcode().equals("") )
		{

			hql.append(" and trans.pathcode like  ?  ");
			values.add(tranAbnoinfo.getPathcode() + "%");

		}
		hql.append("  group by trans.termid ");
		List<Object> list = tranAbnoinfoDao.find(hql.toString(), values.toArray());
		// 分页
		Page pageObject = getPageList(list, page);
		// 得到每一页的结果集
		List<Object> objList = pageObject.getResult();
		List<TmlAnalyse> termList = new ArrayList<TmlAnalyse>();
		// 将结果集重新封装
		for( int i = 0 ; i < objList.size() ; i++ )
		{
			TmlAnalyse teAnalyse = new TmlAnalyse();
			Object[] tmp = (Object[]) objList.get(i);

			if( tmp != null && tmp.length >= 2 )
			{
				if( tmp[0] != null && !"".equals(tmp[0].toString()) )
				{
					teAnalyse.setTermid(tmp[0].toString());
				}
				if( tmp[1] != null && !"".equals(tmp[1].toString()) )
				{
					teAnalyse.setCount((Long) tmp[1]);
				}
				termList.add(teAnalyse);
			}

		}
		page.setResult(termList);

		return page;
	}

	/**
	 * 根据 终端编号 得到异常交易列表
	 * 
	 * @param str_termid
	 *            终端编号
	 * @return List<TranAbnoinfo>
	 * @author Yondy Chow
	 */
	@Transactional(readOnly = true)
	public List<TranAbnoinfo> getTranAbnoinfoAnalyseByTermidList(String str_termid)
	{
		int firstIndex = str_termid.indexOf("|");
		int lastIndex = str_termid.lastIndexOf("|");

		String termid = str_termid.substring(0, firstIndex);
		List values = new ArrayList();

		StringBuffer hql = new StringBuffer("from TranAbnoinfo trans where trans.termid= ? ");
		values.add(termid);

		String beginDate = str_termid.substring(firstIndex + 1, lastIndex);
		if( beginDate != null && !beginDate.equals("") )
		{
			beginDate = DateUtil.dateFormatTohms(beginDate);
			hql.append(" and trans.tranDate >= ? ");
			values.add(beginDate);
		}

		String endDate = str_termid.substring(lastIndex + 1);
		if( endDate != null && !endDate.equals("") )
		{
			endDate = DateUtil.dateFormatTohms(endDate);
			hql.append(" and trans.tranDate <= ? ");
			values.add(endDate);
		}

		hql.append(" order by trans.tranDate desc");

		return tranAbnoinfoDao.find(hql.toString(), values.toArray());
	}

	/**
	 * 根据 违反规则 得到异常交易，并进行分组，得到异常交易次数
	 * 
	 * @param tranAbnoinfo
	 *            tranAbnoinfo实体
	 * @param page
	 *            page实体
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return Page
	 */
	@Transactional(readOnly = true)
	public Page getTranAbnoAnalyseinfoByBlReguList(Map<String, Object> parameter)
	{
		List values = new ArrayList();
		String beginDate = (String) parameter.get("beginDate");
		String endDate = (String) parameter.get("endDate");
		Page page = (Page) parameter.get("page");
		StringBuffer hql = new StringBuffer("select trans.regulation, count(*) from TranAbnoinfo trans  where trans.blackNotenum>0");

		if( beginDate != null && !beginDate.equals("") )
		{
			beginDate = DateUtil.dateFormatTohms(beginDate);
			hql.append(" and trans.tranDate >= ? ");
			values.add(beginDate);
		}
		if( endDate != null && !endDate.equals("") )
		{
			endDate = DateUtil.dateFormatTohms(endDate);
			hql.append(" and trans.tranDate <= ? ");
			values.add(endDate);
		}
		String regulation = (String) parameter.get("regulation");
		if( regulation != null && !regulation.equals("") )
		{
			if( DBDialectHelper.isOracle() )
			{
				hql.append(" and trans.regulation like ?  ");
				values.add(regulation+"%");
			}
			else
			{
				hql.append(" and trans.regulation like ? ");
				values.add(regulation+"%");
			}
		}
		// OperatorTime(values, hql, beginDate, endDate);
		String pathCode = (String) parameter.get("pathCode");
		if( pathCode != null && !pathCode.equals("") )
		{
			hql.append(" and trans.pathcode like ? ");
			values.add(pathCode + "%");
		}
		hql.append(" group by trans.regulation");
		List<Object> list = tranAbnoinfoDao.find(hql.toString(), values.toArray());
		// 分页
		Page pageObject = getPageList(list, page);
		// 得到每一页的结果集
		List<Object[]> objList = pageObject.getResult();
		List<RegulationAnalyse> termList = new ArrayList<RegulationAnalyse>();
		// 将结果集重新封装
		for( int i = 0 ; i < objList.size() ; i++ )
		{
			RegulationAnalyse reAnalyse = new RegulationAnalyse();
			Object[] tmp = (Object[]) objList.get(i);
			if( tmp != null && tmp.length >= 2 )
			{
				if( tmp[0] != null && !"".equals(tmp[0].toString()) )
				{
					reAnalyse.setRegulation(tmp[0].toString());
				}
				if( tmp[1] != null && !"".equals(tmp[1].toString()) )
				{
					reAnalyse.setCount((Long) tmp[1]);
				}
				termList.add(reAnalyse);
			}

		}
		page.setResult(termList);
		return page;
	}

	/**
	 * 根据 违反规则 和时间区间 得到异常交易列表
	 * 
	 * @param str_blRegu
	 *            违反规则和时间区间的的字符串
	 * @return List<TranAbnoinfo>
	 * @author Yondy Chow
	 */
	@Transactional(readOnly = true)
	public List<TranAbnoinfo> getTranAbnoinfoAnalyseByBlReguList(String str_blRegu)
	{
		int firstIndex = str_blRegu.indexOf("|");
		int lastIndex = str_blRegu.lastIndexOf("|");
		String blRegu = str_blRegu.substring(0, firstIndex);

		List values = new ArrayList();
		StringBuffer hql = new StringBuffer("from TranAbnoinfo trans where trans.regulation= ? ");
		values.add(blRegu);

		String beginDate = str_blRegu.substring(firstIndex + 1, lastIndex);
		if( beginDate != null && !beginDate.equals("") )
		{
			beginDate = DateUtil.dateFormatTohms(beginDate);
			hql.append(" and trans.tranDate >= ? ");
			values.add(beginDate);
		}

		String endDate = str_blRegu.substring(lastIndex + 1);
		if( endDate != null && !endDate.equals("") )
		{
			endDate = DateUtil.dateFormatTohms(endDate);
			hql.append(" and trans.tranDate <= ? ");
			values.add(endDate);
		}
		
		hql.append(" order by trans.tranDate desc");

		return tranAbnoinfoDao.find(hql.toString(), values.toArray());
	}

	/**
	 * 通过List得到Page
	 * 
	 * @param list
	 *            集合
	 * @param page
	 *            页实体
	 * @return page
	 */
	@Transactional(readOnly = true)
	public Page getPageList(List list, Page page)
	{
		return tranAbnoinfoDao.getPageList(list, page);
	}
	
	/**
	 * 通过List得到Page
	 * 
	 * @param list
	 *            集合
	 * @param page
	 *            页实体
	 * @return page
	 */
	@Transactional(readOnly = true)
	public TranAbnoinfo getTransAbnoInfoDetailById(String tranId)
	{
		TranAbnoinfo tranAbnoinfo = tranAbnoinfoDao.getByTranId(tranId);
		if( tranAbnoinfo==null )
		{
			return tranAbnoinfo;
		}
		
		String orgId = tranAbnoinfo.getTransOrgid();
		if( orgId==null )
		{
			return tranAbnoinfo;
		}
		
		OrgInfo orgInfo = orgInfoDao.get(orgId);
		if( orgInfo==null )
		{
			return tranAbnoinfo;
		}
		tranAbnoinfo.setTransOrgName(orgInfo.getOrgName());
		tranAbnoinfo.setTransOrgFullName(orgInfo.getOrgFullName());
		
		return tranAbnoinfo;
	}

}















