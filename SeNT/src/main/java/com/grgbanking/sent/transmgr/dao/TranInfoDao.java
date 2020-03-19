package com.grgbanking.sent.transmgr.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.sent.transmgr.entity.TranInfo;
import com.grgbanking.sent.watch.dao.TranAbnoinfoDao;
import com.grgbanking.sent.watch.dao.TranCallbackAbnoinfoDao;
import com.grgbanking.sent.watch.dao.TranEspeciinfoDao;
import com.grgbanking.sent.watch.entity.TranAbnoinfo;
import com.grgbanking.sent.watch.entity.TranCallbackAbnoinfo;
import com.grgbanking.sent.watch.entity.TranEspeciinfo;
/**
 * 清分纸币冠字号码历史记录DAO屄1�7 继承公共的BaseDao屄1�7
 * @author 广电运�1�7�1�7
 */
@SuppressWarnings({"deprecation", "unchecked"})
@Repository
public class TranInfoDao extends BaseDao<TranInfo>{
	
	TransBanknoteSeqDao transBanknoteSeqDao;
	
	TranAbnoinfoDao transAbnoinfoDao;
	
	TranCallbackAbnoinfoDao transCallbackAbnoinfoDao;
	
	TranEspeciinfoDao tranEspeciinfoDao;
	/**
	 * @param date 参数 
	 * @return boolean
	 */
	@SuppressWarnings("finally")
	public boolean unatureAny( String date ){
	
		boolean flag = false;
		Connection cnn = null;
		Session session = this.getSessionFactory().openSession();
		try{
			cnn = session.connection();
			CallableStatement cstmt = cnn
					.prepareCall( "{call unatureAnyAndClearDate(?,?) }" );
			cstmt.setString( 1, date );
			cstmt.registerOutParameter( 2, Types.INTEGER );
			cstmt.execute();
			int tempFlag = 0;
			tempFlag = cstmt.getInt( 2 );
			cnn.commit();
			if( tempFlag == 1 ){
				flag = true;
			}
		}
		catch( AppException ee ){
			try{
				cnn.rollback();
			}
			catch( AppException e2 ){
				logger.error("",e2);
			}

		}
		finally{
			try{
				session.close();
			   }
			catch( final AppException e ){
				logger.error("",e);
			}
			return flag;
		}
	}
    
	/**
	 * 删除
	 * @param date   保存时间 
	 * @return boolean 
	 */
	public boolean removeTranHourDate( String date ){
		boolean flag = false;
		Session session = this.getSessionFactory().openSession();
		Connection cnn = session.connection();
		try{
			String strInsertTranInfo = " insert into Tran_Info  select * from Trans_Hour_Info" +
					"  where   reserve1='1' and c_create_Date <='"
					+ date + "'";
			String strInsertTranSeq = "insert into Trans_Banknote_Seq   select * from Trans_Banknote_Seq_Hour   where   c_create_Date <='"
					+ date
					+ "' and c_tran_Id  in(select c_id  from Trans_Hour_Info  where   reserve1='1' and c_create_Date <='"
					+ date + "')";

			String strDelTranSeq = "delete Trans_Banknote_Seq_Hour  where  c_create_Date <='"
					+ date
					+ "' and c_tran_Id  in(select c_id  from  Trans_Hour_Info  where   reserve1='1' and  c_create_Date  <='"
					+ date + "')";
			String strDelInfo = "  delete Trans_Hour_Info   where   reserve1='1' and c_create_Date  <='"
					+ date + "'";
			Statement stmt = cnn.createStatement();
			stmt.execute( strInsertTranInfo );
			stmt.execute( strInsertTranSeq );
			stmt.execute( strDelTranSeq );
			stmt.execute( strDelInfo );
			cnn.commit();
			session.close();
			flag = true;
		}catch( SQLException e ){
			logger.error("", e );
			try{cnn.rollback();
				cnn.close();
				session.close();}
			catch( SQLException ee ){
				logger.error("", ee );
			}

		}
		return flag;
	}
   /**
    *  @param date 保存时间 
    *  @return boolean
    * */
//	public boolean removeTranHourDateList( String date )	{
//		boolean flag = false;	
//		// 插入交易信息中的数据
//		List insertTranInfoList = null;
//		// 插入钞票序列号的信息
//		List insertTransBanknoteList = null;
//		/*
//		 * 移出数据的时候，查询已经上传成功的信息�1�7�1�7 插入数据的时候，先插入主交易信息，然后插入序列号信息
//		 * 删除数据的时候，先删除序列号信息，然后在删除主交易信恄1�7
//		 * 
//		 */
//		String insertTranInfoStr = "  from TransHourInfo  where   reserve1='1' and createDate <='"
//				+ date + "'";
//		String insertTransBanknoteStr = " from TransBanknoteSeqHour   where   createDate <='"
//				+ date
//				+ "' and tranId  in(select id  from TransHourInfo  where   reserve1='1' and createDate <='"
//				+ date + "')";
//		String deleteTranInfoHour = "  delete TransHourInfo   where   reserve1='1' and createDate  <='"
//				+ date + "'";
//		String deleteTranBanknoteStr = "delete TransBanknoteSeqHour  where  createDate <='"
//				+ date
//				+ "' and tranId  in(select id  from  TransHourInfo  where   reserve1='1' and  createDate  <='"
//				+ date + "')";
//
//		insertTranInfoList = find(insertTranInfoStr );
//		insertTransBanknoteList = find(insertTransBanknoteStr );
//
//		if( insertTranInfoList != null && insertTranInfoList.size() > 0 ){
//			for( int i = 0; i < insertTranInfoList.size(); i++ ){
//				TransHourInfo transHourInfo = ( TransHourInfo ) insertTranInfoList.get( i );
//				TranInfo tranInfo = new TranInfo();
//				try{
//					BeanUtils.copyProperties( tranInfo, transHourInfo );
//				} catch (IllegalAccessException e) {
//				logger.error("",e);
//				} catch (InvocationTargetException e) {
//					logger.error("",e);
//				}
//
//				this.save( tranInfo );
//
//			}
//		}
//		if( insertTransBanknoteList != null
//				&& insertTransBanknoteList.size() > 0 ){
//			for( int i = 0; i < insertTransBanknoteList.size(); i++ ){
//				TransBanknoteSeq transBanknoteSeq = new TransBanknoteSeq();
//				TransBanknoteSeqHour transBanknoteSeqHour = ( TransBanknoteSeqHour ) insertTransBanknoteList.get( i );
//				try{
//					BeanUtils.copyProperties( transBanknoteSeq,
//							transBanknoteSeqHour );
//				
//				} catch (IllegalAccessException e) {
//				logger.error("",e);
//				} catch (InvocationTargetException e) {
//					logger.error("",e);
//				}
//				transBanknoteSeqDao.save( transBanknoteSeq );
//			}
//		}
		// 丄1�7定要先删除序列号的信息，在删除交易信恄1�7
		//this.batchExecute(deleteTranBanknoteStr);
		//this.batchExecute(deleteTranInfoHour);
//		this.getHibernateTemplate().bulkUpdate( deleteTranBanknoteStr );
//		this.getHibernateTemplate().bulkUpdate( deleteTranInfoHour );

		/*
	
		 * session = this.getHibernateTemplate().getSessionFactory()
		 * .openSession();
		 * 
		 * Connection cnn = session.connection(); try { String strInsertTranInfo = "
		 * insert into Tran_Info select * from Trans_Hour_Info where
		 * reserve1='1' and c_create_Date <='" + date + "'"; String
		 * strInsertTranSeq = "insert into Trans_Banknote_Seq select * from
		 * Trans_Banknote_Seq_Hour where c_create_Date <='" + date + "' and
		 * c_tran_Id in(select c_id from Trans_Hour_Info where reserve1='1' and
		 * c_create_Date <='" + date + "')";
		 * 
		 * String strDelTranSeq = "delete Trans_Banknote_Seq_Hour where
		 * c_create_Date <='" + date + "' and c_tran_Id in(select c_id from
		 * Trans_Hour_Info where reserve1='1' and c_create_Date <='" + date +
		 * "')"; String strDelInfo = " delete Trans_Hour_Info where reserve1='1'
		 * and c_create_Date <='" + date + "'";
		 * 
		 * Statement stmt = cnn.createStatement();
		 * stmt.execute(strInsertTranInfo); stmt.execute(strInsertTranSeq);
		 * stmt.execute(strDelTranSeq); stmt.execute(strDelInfo);
		 * 
		 * cnn.commit();
		 * 
		 * session.close(); //
		 * this.getHibernateTemplate().execute(strInsertTranInfo); //
		 * this.getHibernateTemplate().bulkUpdate(strInsertTranSeq); //
		 * this.getHibernateTemplate().bulkUpdate(strDelTranSeq); //
		 * this.getHibernateTemplate().bulkUpdate(strDelInfo); flag = true;
		
		return flag;
	} */
	/**
	 * 删除集合中的数据
	 * @param list  TranHour集合
	 * @return boolean
	 */
//	public boolean removeTranHourDateList( List list){
//		boolean flag = false;
//		@SuppressWarnings("unused")
//		String idString=null;
//		try{
//		
//		// 插入钞票序列号的信息
//		List insertTransBanknoteList = null;
//		StringBuffer str=new StringBuffer();
//		//交易信息ID数组
//		String [] idStrings=new String[list.size()];
//		TransHourInfo info=null;
//		//循环取出集合中交易信息ID
//		for(int i=0;i<list.size();i++){
//			info=(TransHourInfo)list.get( i );
//			str.append( "'"+info.getId()+"'," );
//			idStrings[i]=info.getId();
//		}
//		String strId=str.toString();
//		if(StringUtils.isNotBlank( strId )){
//			strId=strId.substring( 0,strId.length()-1 );
//		}
//		//为防止内存溢出每次只查询50条记录，先查出循环次敄1�7
//		String timeSql="select count(*) from TransBanknoteSeqHour   where tranId  in("+strId+")";
//		int count=getPerformTime( timeSql );
//		int start=0;
//		final int l= 50;
//		for(int m=0;m<count;m++){
//			
//			start=m*l;
//			//朄1�7多取50条记彄1�7
//			insertTransBanknoteList =getTransBanknoteSeqHourOnFirstFifty( idStrings,start, l );
//			if( insertTransBanknoteList != null
//					&& insertTransBanknoteList.size() > 0 ){
//				for( int i = 0; i < insertTransBanknoteList.size(); i++ ){
//					TransBanknoteSeq transBanknoteSeq = new TransBanknoteSeq();
//					TransBanknoteSeqHour transBanknoteSeqHour = ( TransBanknoteSeqHour ) insertTransBanknoteList.get( i );
//					try{
//						
//							BeanUtils.copyProperties( transBanknoteSeq,transBanknoteSeqHour );
//					
//						//分析时把交易日期和时间放到一个字段中，便于查评1�7
//						transBanknoteSeq.setTransDate( transBanknoteSeqHour.getTransDate()+transBanknoteSeqHour.getTranTime() );
//						transBanknoteSeqDao.save( transBanknoteSeq );
//						idString=transBanknoteSeq.getId();
//					
//				} catch (IllegalAccessException e) {
//					logger.error("",e);
//				} catch (InvocationTargetException e) {
//				
//					logger.error("",e);
//				}
//			}
//			}
//		}
//		
//		if( list != null && list.size() > 0 ){
//			for( int i = 0; i < list.size(); i++ ){
//				TransHourInfo transHourInfo = ( TransHourInfo ) list.get( i );
//				TranInfo tranInfo = new TranInfo();
//				try{
//					BeanUtils.copyProperties( tranInfo, transHourInfo );
//					//把日期和时间在要析时放到丄1�7个字段中厄1�7
//					tranInfo.setTransDate( transHourInfo.getTransDate()+transHourInfo.getTransTime() );
//					save( tranInfo );
//				} catch (IllegalAccessException e) {
//					logger.error("",e);
//				} catch (InvocationTargetException e) {
//					logger.error("",e);
//				}
//				
//			}
//			//this.getHibernateTemplate().flush();
//		}
//		//删除冠字号信息和交易信息
//		if(StringUtils.isNotBlank( strId )){
//			
//			String deleteTranBanknoteStr = "delete TransBanknoteSeqHour where  tranId  in("+strId+")";
//			String deleteTranInfoHour = "  delete TransHourInfo   where   id in("+strId+")";
//			this.batchExecute(deleteTranBanknoteStr);
//			this.batchExecute(deleteTranInfoHour);
////			this.getHibernateTemplate().bulkUpdate( deleteTranBanknoteStr );
////			this.getHibernateTemplate().bulkUpdate( deleteTranInfoHour );
//		}
//		flag=true;	
//		}
//		catch( AppException e ){
//			logger.error("",e);
//		}
//		return flag;
//	}
	/**
	 *  @param abnoBlackList  List<TranAbnoinfo>
	 *  @param abnoRepeatList List<TranAbnoinfo>
	 *  @param tranCallbackAbnoinfo List<TranCallbackAbnoinfo>
	 *  @param tranEspeciinfo List<TranEspeciinfo>
	 *  @return boolean
	 */
	public boolean analyseTranDataAdd( List<TranAbnoinfo> abnoBlackList,
			List<TranAbnoinfo> abnoRepeatList,
			List<TranCallbackAbnoinfo> tranCallbackAbnoinfo,
			List<TranEspeciinfo> tranEspeciinfo ){
		boolean flag = false;
		int a =Integer.parseInt("50");
		for( int i = 0; i < abnoBlackList.size(); ++i ){
			transAbnoinfoDao.save((TranAbnoinfo)abnoBlackList.get(i));
			if( i % a == 0 ){
				transAbnoinfoDao.getSession().flush();
			}
		}
		for( int i = 0; i < abnoRepeatList.size(); i++ ){
			transAbnoinfoDao.save((TranAbnoinfo)abnoRepeatList.get(i));
			if( i % a == 0 ){
				transAbnoinfoDao.getSession().flush();
			}
		}
		for( int i = 0; i < tranCallbackAbnoinfo.size(); i++ ){
			transCallbackAbnoinfoDao.save((TranCallbackAbnoinfo)tranCallbackAbnoinfo.get(i));
			if( i % a == 0 ){
				transCallbackAbnoinfoDao.getSession().flush();
			}
		}
		for( int i = 0; i < tranEspeciinfo.size(); i++ ){
			tranEspeciinfoDao.save((TranEspeciinfo)tranEspeciinfo.get(i));
			if( i % a == 0 ){
				tranEspeciinfoDao.getSession().flush();
			}
		}
		flag = true;
		return flag;
	}

	/**
	 * 在要析数据时每次分析50条记录，取共分析的次敄1�7
	 * 
	 * @param sql  查询语句
	 * @return int
	 */
	public int getPerformTime( String sql ){
		int time = 0;
		final  int a = 50;
		
		int count = ( ( Long ) find( sql ).get( 0 ) )
				.intValue();
		if( count > 0 ){
			int div = count / a;
			int mod = count % a;
			if( div == 0 ){
				time = 1;
			}
			else{
				time = ( ( mod == 0 ) ? div : div + 1 );
			}

		}
		return time;
	}

	/**
	 * 取小于该日期的数据集各1�7
	 * 
	 * @param p_date 保存时间
	 * @param p_page p_page
	 * @param p_maxsize p_maxsize
	 * @return list
	 */
	public List getTransHourInfoOnFirstFifty( String p_date, int p_page, int p_maxsize ){
//		List list = null;
//		DetachedCriteria sql = null;
//		sql = DetachedCriteria.forClass( TransHourInfo.class );
//		sql.add( Restrictions.eq( "reserve1", "1" ) ).add(
//				Restrictions.le( "createDate", date ) );
//		sql.addOrder( Order.asc( "id" ) );
		Page<TranInfo> page = new Page<TranInfo>();
		page.setPageNo(p_page);
		page.setPageSize(p_maxsize);
		page.setOrder("asc");
		page.setOrderBy("id");
		page = super.findPage(page, Restrictions.eq( "reserve1", "1" ), Restrictions.le( "createDate", p_date ));
		return page.getResult();
	}
	/**
	 * 分页显示钞票序列号集各1�7
	 * @param tranIds 关联ID数组
	 * @param first 弄1�7姄1�7
	 * @param maxsize 朄1�7大�1�7�1�7
	 * @return list 
	 */
	public List getTransBanknoteSeqHourOnFirstFifty(String []tranIds,int first,int maxsize){
//		List list=null;
//		DetachedCriteria sql=null;     
//		sql=DetachedCriteria.forClass( TransBanknoteSeqHour.class );
//		sql.add( Restrictions.in( "tranId", tranIds ) );
		Page<TranInfo> page = new Page<TranInfo>();
		page.setPageNo(first);
		page.setPageSize(maxsize);
		page = findPage(page, Restrictions.in( "tranId", tranIds ));
//		list=this.findByCriteria( sql, first, maxsize );
		return page.getResult();
	}
	
	
	
	/**
	 * 判断是否匹配
	 * @param patten 匹配字符丄1�7
	 * @param str 参数
	 * @return boolean
	 */
	public boolean isMatch(String patten,String str){
		Pattern pattern=Pattern.compile( patten );
		return pattern.matcher( str ).matches();
	}

	/**
	 *  @param list 数据集合
	 *  @param page  page实体
	 *  @return page 
	 */
	public Page<Object> getPageList(List<Object> list, Page<Object> page) {
		// Page pageObject = new Page();
		// pageObject.setPageNo(page.getPageNo());
		// pageObject.setPageSize(page.getPageSize());
		// pageObject.setTotalCount(list.size());
		// pageObject.setResult(list);
		// return pageObject;

		int recordCount = list.size();
		int pageNum = page.getPageNo();
		int pageSize = page.getPageSize();
		page.setTotalCount(list.size());
		if (recordCount > 0) {
			int beginRecordNumOfPage = (pageNum - 1) * pageSize;
			// 为什么是beginRecordNumOfPage + pageSize而不是beginRecordNumOfPage +
			// pageSize - 1?
			// 请看List中subList说明：Returns a view of the portion of this list
			// between the specified fromIndex, inclusive, and toIndex,
			// exclusive
			int endRecordNumOfPage = beginRecordNumOfPage + pageSize;
			if (endRecordNumOfPage >= recordCount) {
				endRecordNumOfPage = recordCount;
			}
			page.setResult(list.subList(beginRecordNumOfPage,
					endRecordNumOfPage));

		}
		return page;

	}

}
