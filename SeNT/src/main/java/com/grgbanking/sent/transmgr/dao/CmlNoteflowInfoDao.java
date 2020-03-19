package com.grgbanking.sent.transmgr.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowInfo;
import com.grgbanking.sent.utils.CollectionsUtil;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 
 * @author 广电运通
 */
@Repository
public class CmlNoteflowInfoDao extends BaseDao<CmlNoteflowInfo>
{
	
//	TransBanknoteSeqDao transBanknoteSeqDao;
//	
//	TranAbnoinfoDao transAbnoinfoDao;
//	
//	TranCallbackAbnoinfoDao transCallbackAbnoinfoDao;
//	
//	TranEspeciinfoDao tranEspeciinfoDao;
//	/**
//	 * @param date 参数 
//	 * @return boolean
//	 */
//	@SuppressWarnings("finally")
//	public boolean unatureAny( String date ){
//	
//		boolean flag = false;
//		Connection cnn = null;
//		Session session = this.getSessionFactory().openSession();
//		try{
//			cnn = session.connection();
//			CallableStatement cstmt = cnn
//					.prepareCall( "{call unatureAnyAndClearDate(?,?) }" );
//			cstmt.setString( 1, date );
//			cstmt.registerOutParameter( 2, Types.INTEGER );
//			cstmt.execute();
//			int tempFlag = 0;
//			tempFlag = cstmt.getInt( 2 );
//			cnn.commit();
//			if( tempFlag == 1 ){
//				flag = true;
//			}
//		}
//		catch( AppException ee ){
//			try{
//				cnn.rollback();
//			}
//			catch( AppException e2 ){
//				logger.error("",e2);
//			}
//
//		}
//		finally{
//			try{
//				session.close();
//			   }
//			catch( final AppException e ){
//				logger.error("",e);
//			}
//			return flag;
//		}
//	}
//     /**
//      *  @param date 保存时间
//      *  @return list
//      */
//	public List analyseAbnormitRepeat( String date ){
//		List addTransInfoRepList = new ArrayList();
//		try{
//			String strSql = " from TransHourInfo th   " +
//					"where th.repeatNum>0 and th.blNum=0 and th.transCode='DEP' and reserve1='1' and th.createDate<='"
//					+ date + "'";
//			List list = find( strSql );
//			if( list != null && list.size() > 0 ){
//				for( int i = 0; i < list.size(); i++ ){
//					String transId = "";
//					String seq = "";
//					TransHourInfo transHourInfo = ( TransHourInfo ) list
//							.get( i );
//					transId = transHourInfo.getId();
//					String strSubSql = "select distinct seriaNo from TransBanknoteSeq t where tranId='"
//							+ transId
//							+ "'  and noteFlag  ='0' and noteType ='3'";
//					List subList = find( strSubSql );
//					if( subList != null && subList.size() > 0 ){
//						Iterator iterSub = subList.iterator();
//						int k = 0;
//						Integer a= Integer.parseInt("5");
//						while( iterSub.hasNext() && k < a ){
//							Object obj = iterSub.next();
//							if( k == 0 ){
//								seq += obj.toString();
//							}
//							else{
//								seq += "," + obj.toString();
//							}
//							k++;
//						}
//					}
//					TranAbnoinfo tranAbnoinfo = new TranAbnoinfo();
//					tranAbnoinfo.setAccountNo( transHourInfo.getAccountNo() );
//					tranAbnoinfo.setAnyDate( new Date() );
//					tranAbnoinfo.setTransNotenum( transHourInfo.getTransNotenum());
//					tranAbnoinfo.setBlackNotenum( transHourInfo.getBlackNotenum() );
//					tranAbnoinfo.setCallbackNotenum( transHourInfo.getBlackNotenum());
//					tranAbnoinfo.setCreateDate( transHourInfo.getCreateDate() );
//					tranAbnoinfo.setJournalNo( transHourInfo.getJournalNo() );
//					tranAbnoinfo.setNote( seq );
//					tranAbnoinfo.setRegulation( "" );
//					tranAbnoinfo.setRepeatNotenum( transHourInfo.getRepeatNotenum() );
//					tranAbnoinfo.setReserve1( transHourInfo.getReserve1() );
//					tranAbnoinfo.setReserve2( transHourInfo.getReserve2() );
//					tranAbnoinfo.setReserve3( transHourInfo.getReserve3() );
//					tranAbnoinfo.setTermid( transHourInfo.getTermid() );
//					tranAbnoinfo.setTranId( transHourInfo.getId() );
//					tranAbnoinfo.setTransAmt( transHourInfo.getTransAmt() );
//					tranAbnoinfo.setTransCode( transHourInfo.getTransCode() );
//					tranAbnoinfo.setTranMonthDay( transHourInfo.getTranMonthDay() );
//					tranAbnoinfo.setTransOrgid( transHourInfo.getTransOrgid() );
//					tranAbnoinfo.setTransResult( transHourInfo.getTransResult() );
//					tranAbnoinfo.setTransTime( transHourInfo.getTransTime() );
//					
//					addTransInfoRepList.add( tranAbnoinfo );
//				}
//
//			}
//		}
//		catch( AppException e ){
//			logger.error("", e );
//		}
//		return addTransInfoRepList;
//	}
//
//	/**
//	 * 取已知集合中的重号数据封装到另一集合丄1�7
//	 * @param list 已知集合
//	 * @return List 重号集合
//	 */
//	public List analyseAbnormitRepeat( List list ){
//		List addTransInfoRepList = new ArrayList();
//		try{
//			if( list != null && list.size() > 0 )	{
//				for( int i = 0; i < list.size(); i++ ){
//					String transId = "";
//					String seq = "";
//					TransHourInfo transHourInfo = ( TransHourInfo ) list
//							.get( i );
//					if( null != transHourInfo
//							&& transHourInfo.getRepeatNotenum() > 0
//							&& transHourInfo.getBlackNotenum() == 0
//							&& "DEP".equals( transHourInfo.getTransCode() ) ){
//						transId = transHourInfo.getId();
//						String strSubSql = "select distinct seriaNo from TransBanknoteSeqHour t where tranId='"
//								+ transId
//								+ "'  and noteFlag  ='0' and noteType ='3'";
//						List subList = find(
//								strSubSql );
//						if( subList != null && subList.size() > 0 ){
//							Iterator iterSub = subList.iterator();
//							int k = 0;
//							int a =Integer.parseInt("5");
//							while( iterSub.hasNext() && k < a){
//								Object obj = iterSub.next();
//								if( k == 0 ){
//									seq += obj.toString();
//								}
//								else{
//									seq += "," + obj.toString();
//								}
//								k++;
//							}
//						}
//						TranAbnoinfo tranAbnoinfo = new TranAbnoinfo();
//						tranAbnoinfo.setAccountNo( transHourInfo.getAccountNo() );
//						tranAbnoinfo.setAnyDate( new Date() );
//						tranAbnoinfo.setTransNotenum( transHourInfo.getTransNotenum());
//						tranAbnoinfo.setBlackNotenum( transHourInfo.getBlackNotenum() );
//						tranAbnoinfo.setCallbackNotenum( transHourInfo.getCallbackNotenum() );
//						tranAbnoinfo.setCreateDate( transHourInfo.getCreateDate() );
//						tranAbnoinfo.setJournalNo( transHourInfo.getJournalNo() );
//						tranAbnoinfo.setNote( seq );
//						tranAbnoinfo.setRegulation( "" );
//						tranAbnoinfo.setRepeatNotenum( transHourInfo.getRepeatNotenum() );
//						tranAbnoinfo.setReserve1( transHourInfo.getReserve1() );
//						tranAbnoinfo.setReserve2( transHourInfo.getReserve2() );
//						tranAbnoinfo.setReserve3( transHourInfo.getReserve3() );
//						tranAbnoinfo.setTermid( transHourInfo.getTermid() );
//						tranAbnoinfo.setTranId( transHourInfo.getId() );
//						tranAbnoinfo.setTransAmt( transHourInfo.getTransAmt() );
//						tranAbnoinfo.setTransCode( transHourInfo.getTransCode() );
//						tranAbnoinfo.setTranMonthDay( transHourInfo.getTranMonthDay()+transHourInfo.getTransTime());
//						tranAbnoinfo.setTransOrgid( transHourInfo.getTransOrgid() );
//						tranAbnoinfo.setTransResult( transHourInfo.getTransResult() );
//						tranAbnoinfo.setTransTime( transHourInfo.getTransTime() );
//						addTransInfoRepList.add( tranAbnoinfo );
//					}
//				}
//
//			}
//		}
//		catch( AppException e )	{
//			logger.error("", e );
//		}
//		return addTransInfoRepList;
//
//	}
//	/**
//	 * @param date 保存时间
//	 * @return List
//	 */
//	public List analyseAbnormitBlack( String date ){
//		List addTransInfoBlackList = new ArrayList();
//		try{
//			String strSql = "  from TransHourInfo  t1 where blNum >0  and  transCode ='DEP' and reserve1='1' and  createDate <='"
//					+ date + "'";
//			String strBlackSql = "   from BlackRegulation   where regulationStatus ='9' ";
//			List blackList = find( strBlackSql );
//			if( blackList != null && blackList.size() > 0 ){
//				List list = find( strSql );
//				if( list != null && list.size() > 0 ){
//					for( int i = 0; i < list.size(); i++ ){
//						String transId = "";
//						String seq = "";
//						TransHourInfo transHourInfo = ( TransHourInfo ) list
//								.get( i );
//						transId = transHourInfo.getId();
//						boolean tempFlag = false;
//						String blackSeqNote = "";
//						for( int k = 0; k < blackList.size() && !tempFlag; k++ ){
//							if( ( BlackRegulation ) blackList.get( k ) != null ){
//								String blackSeq = ( ( BlackRegulation ) blackList
//										.get( k ) ).getRegulation().toString()
//										.replace( "*", "%" );
//								String strSubSql = " select count(*)  from  TransBanknoteSeqHour    where tranId ='"
//										+ transId
//										+ "' and noteFlag  ='0' and noteType ='201' and seriaNo  like '"
//										+ blackSeq + "'";
//								List subSeqBlack = find( strSubSql );
//								if( subSeqBlack != null
//										&& subSeqBlack.size() > 0
//										&& subSeqBlack.get( 0 ) != null
//										&& ( Integer.parseInt( String.valueOf( subSeqBlack.get( 0 ) ) ) > 0 ) ){
//									tempFlag = true;
//									blackSeqNote = blackSeq.replace( "%", "*" );
//								}
//							}
//						}
//						TranAbnoinfo tranAbnoinfo = new TranAbnoinfo();
//						tranAbnoinfo.setAccountNo( transHourInfo.getAccountNo() );
//						tranAbnoinfo.setAnyDate( new Date() );
//						tranAbnoinfo.setTransNotenum( transHourInfo.getTransNotenum() );
//						tranAbnoinfo.setBlackNotenum( transHourInfo.getBlackNotenum() );
//						tranAbnoinfo.setCallbackNotenum( transHourInfo.getCallbackNotenum());
//						tranAbnoinfo.setCreateDate( transHourInfo.getCreateDate() );
//						tranAbnoinfo.setJournalNo( transHourInfo.getJournalNo() );
//						tranAbnoinfo.setNote( seq );
//						tranAbnoinfo.setRegulation( blackSeqNote );
//						tranAbnoinfo.setRepeatNotenum( transHourInfo.getRepeatNotenum());
//						tranAbnoinfo.setReserve1( transHourInfo.getReserve1() );
//						tranAbnoinfo.setReserve2( transHourInfo.getReserve2() );
//						tranAbnoinfo.setReserve3( transHourInfo.getReserve3() );
//						tranAbnoinfo.setTermid( transHourInfo.getTermid() );
//						tranAbnoinfo.setTranId( transHourInfo.getId() );
//						tranAbnoinfo.setTransAmt( transHourInfo.getTransAmt() );
//						tranAbnoinfo.setTransCode( transHourInfo.getTransCode() );
//						tranAbnoinfo.setTranMonthDay( transHourInfo.getTranMonthDay() );
//						tranAbnoinfo.setTransOrgid( transHourInfo.getTransOrgid() );
//						tranAbnoinfo.setTransResult( transHourInfo.getTransResult() );
//						tranAbnoinfo.setTransTime( transHourInfo.getTransTime() );
//						addTransInfoBlackList.add( tranAbnoinfo );
//					}
//				}
//			}
//
//		}
//		catch( AppException e ){
//			logger.error("", e );
//		}
//		return addTransInfoBlackList;
//	}
//
//	/**
//	 * 对集合中的每条数据进行分析把符合黑明单的数据加到丄1�7集合丄1�7
//	 * @param list  实体集合
//	 * @return List
//	 */
//	public List analyseAbnormitBlack( List list ){
//		List addTransInfoBlackList = new ArrayList();
//		try{
//			String strBlackSql = "   from BlackRegulation   where regulationStatus ='9' ";
//			List blackList = find( strBlackSql );
//			if( blackList != null && blackList.size() > 0 ){
//				if( list != null && list.size() > 0 ){
//					for( int i = 0; i < list.size(); i++ ){
//						String transId = "";
//						String seq = "";
//						TransHourInfo transHourInfo = ( TransHourInfo ) list
//								.get( i );
//						if( null != transHourInfo
//								&& transHourInfo.getBlackNotenum() > 0
//								&& "DEP".equals( transHourInfo.getTransCode() ) ){
//							transId = transHourInfo.getId();
//							boolean tempFlag = false;
//							String blackSeqNote = "";
//							for( int k = 0; k < blackList.size() && !tempFlag; k++ ){
//								if( ( BlackRegulation ) blackList.get( k ) != null ){
//									String blackSeq = ( ( BlackRegulation ) blackList
//											.get( k ) ).getRegulation()
//											.toString().replace( "*", "%" );
//									String strSubSql = " select count(*)  from  TransBanknoteSeqHour    where tranId ='"
//											+ transId
//											+ "' and noteFlag  ='0' and noteType ='201' and seriaNo  like '"
//											+ blackSeq + "'";
//									List subSeqBlack = find(strSubSql );
//									if( subSeqBlack != null&& subSeqBlack.size() > 0&& subSeqBlack.get( 0 ) != null
//											&& ( Integer.parseInt( String.valueOf( subSeqBlack.get( 0 ) ) ) > 0 ) ){
//										tempFlag = true;
//										blackSeqNote = blackSeq.replace( "%","*" );
//									}
//								}
//							}
//
//							TranAbnoinfo tranAbnoinfo = new TranAbnoinfo();
//							tranAbnoinfo.setAccountNo( transHourInfo.getAccountNo() );
//							tranAbnoinfo.setAnyDate( new Date() );
//							tranAbnoinfo.setTransNotenum( transHourInfo.getTransNotenum());
//							tranAbnoinfo.setBlackNotenum( transHourInfo.getBlackNotenum() );
//							tranAbnoinfo.setCallbackNotenum( transHourInfo.getCallbackNotenum());
//							tranAbnoinfo.setCreateDate( transHourInfo.getCreateDate() );
//							tranAbnoinfo.setJournalNo( transHourInfo.getJournalNo() );
//							tranAbnoinfo.setNote( seq );
//							tranAbnoinfo.setRegulation( blackSeqNote );
//							tranAbnoinfo.setRepeatNotenum( transHourInfo.getRepeatNotenum());
//							tranAbnoinfo.setReserve1( transHourInfo.getReserve1() );
//							tranAbnoinfo.setReserve2( transHourInfo.getReserve2() );
//							tranAbnoinfo.setReserve3( transHourInfo.getReserve3() );
//							tranAbnoinfo.setTermid( transHourInfo.getTermid() );
//							tranAbnoinfo.setTranId( transHourInfo.getId() );
//							tranAbnoinfo.setTransAmt( transHourInfo.getTransAmt() );
//							tranAbnoinfo.setTransCode( transHourInfo.getTransCode() );
//							tranAbnoinfo.setTranMonthDay( transHourInfo.getTranMonthDay() );
//							tranAbnoinfo.setTransOrgid( transHourInfo.getTransOrgid() );
//							tranAbnoinfo.setTransResult( transHourInfo.getTransResult() );
//							tranAbnoinfo.setTransTime( transHourInfo.getTransTime() );
//							addTransInfoBlackList.add( tranAbnoinfo );
//						}
//					}
//				}
//			}
//		}
//		catch( AppException e ){
//			logger.error("", e );
//		}
//		return addTransInfoBlackList;
//	}
//
//	/**
//	 * 	// 张数丄1�7致，如果序列号一致不要监控，这里只监控张数一致，序号不一致的数据// 1：张数不丄1�7臄1�7	// 2：张数一致，序列号不丄1�7臄1�7// 3：张数和序号都不丄1�7臄1�7
//	 * @param date 保存时间 
//	 * @return list
//	 */
//	public List analyseAbnormitCallback( String date ){
//		List addTransInfoCallList = new ArrayList();
//		try{String strSql = "  from TransHourInfo  t where  callBackNum >0 and transCode ='CWD' and reserve1='1'  and createDate  <='"+ date + "'";
//			List list = find( strSql );
//			if( list != null && list.size() > 0 ){
//				for( int i = 0; i < list.size(); i++ ){
//					String tranId = "";
//					String callSeq = "";
//					TransHourInfo transHourInfo = ( TransHourInfo ) list.get( i );
//					tranId = transHourInfo.getId();
//			/*		boolean tempFlag = false;*/
//					String strSubSql = " select seriaNo  from  TransBanknoteSeqHour  where tranId='"
//							+ tranId+ "' and noteFlag ='1' and ( seriaNo   not in  (select  seriaNo" +
//									"  from TransBanknoteSeqHour  where  tranId ='"+ 
//									tranId+ "' and noteFlag ='0' ) or seriaNo  is null )";
//					List subListCall = find(strSubSql );	// 张数丄1�7致，分析是否序列号一臄1�7
//					String noteNum = String.valueOf( transHourInfo.getTransNotenum());
//					String callBackNum = String.valueOf( transHourInfo.getCallbackNotenum() );
//					if( noteNum.equals( callBackNum ) ){
//						callSeq = "";
//						if( subListCall != null && subListCall.size() > 0 ){
//							for( int k = 0; k < subListCall.size(); k++ )	{
//								Object obj = subListCall.get( k );
//								if( obj == null || obj.toString().length() == 0 ){
//									callSeq += "-1,";}else{
//									callSeq += obj.toString() + ",";}}
//							TranCallbackAbnoinfo tranCallbackAbnoinfo = new TranCallbackAbnoinfo();
//							tranCallbackAbnoinfo.setAbnoCallbackType( "2" );
//							tranCallbackAbnoinfo.setAccountNo( transHourInfo.getAccountNo() );
//							tranCallbackAbnoinfo.setAnyDate( new Date() );
//							tranCallbackAbnoinfo.setBlackNotenum( transHourInfo.getTransNotenum());
//							tranCallbackAbnoinfo.setCallbackNotenum( transHourInfo.getCallbackNotenum());
//							tranCallbackAbnoinfo.setCreateDate( transHourInfo.getCreateDate() );
//							tranCallbackAbnoinfo.setJournalNo( transHourInfo.getJournalNo() );
//							tranCallbackAbnoinfo.setNote( callSeq );
//							tranCallbackAbnoinfo.setRepeatNotenum( transHourInfo.getRepeatNotenum());
//							tranCallbackAbnoinfo.setReserve1( transHourInfo.getReserve1() );
//							tranCallbackAbnoinfo.setReserve2( transHourInfo.getReserve2() );
//							tranCallbackAbnoinfo.setReserve3( transHourInfo.getReserve3() );
//							tranCallbackAbnoinfo.setTermid( transHourInfo.getTermid() );
//							tranCallbackAbnoinfo.setTranId( transHourInfo.getId() );
//							tranCallbackAbnoinfo.setTransAmt( transHourInfo.getTransAmt() );
//							tranCallbackAbnoinfo.setTransCode( transHourInfo.getTransCode() );
//							tranCallbackAbnoinfo.setTransDate( transHourInfo.getTranMonthDay() );
//							tranCallbackAbnoinfo.setTransNotenum( transHourInfo.getTransNotenum());
//							tranCallbackAbnoinfo.setTransOrgid( transHourInfo.getTransOrgid() );
//							tranCallbackAbnoinfo.setTransResult( transHourInfo.getTransResult() );
//							tranCallbackAbnoinfo.setTransTime( transHourInfo.getTransTime() );
//							addTransInfoCallList.add( tranCallbackAbnoinfo );}}	else{// 回收钞票张数不一臄1�7
//						callSeq = "";
//						String callBackType = "";	// 张数不一致，而且回收的序号也不一臄1�7				
//						if( subListCall != null && subListCall.size() > 0 )	{
//							for( int k = 0; k < subListCall.size(); k++ ){
//								Object obj = subListCall.get( k );
//								if( obj == null || obj.toString().length() == 0 ){
//									callSeq += "-1,";
//								}else{
//									callSeq += obj.toString() + ",";}}
//							callBackType = "3";}else{// 回收张数不一致，但是回收的序列号在交易的序列号中可以找到，这种情况基本上不会出现		
//							callBackType = "1";}
//						TranCallbackAbnoinfo tranCallbackAbnoinfo = new TranCallbackAbnoinfo();
//						tranCallbackAbnoinfo.setAbnoCallbackType( callBackType );
//						tranCallbackAbnoinfo.setAccountNo( transHourInfo.getAccountNo() );
//						tranCallbackAbnoinfo.setAnyDate( new Date() );				
//						tranCallbackAbnoinfo.setBlackNotenum( transHourInfo.getBlackNotenum());
//						tranCallbackAbnoinfo.setCallbackNotenum( transHourInfo.getCallbackNotenum());
//						tranCallbackAbnoinfo.setCreateDate( transHourInfo.getCreateDate() );
//						tranCallbackAbnoinfo.setJournalNo( transHourInfo.getJournalNo() );
//						tranCallbackAbnoinfo.setNote( callSeq );
//						tranCallbackAbnoinfo.setRepeatNotenum( transHourInfo.getRepeatNotenum());
//						tranCallbackAbnoinfo.setReserve1( transHourInfo.getReserve1() );
//						tranCallbackAbnoinfo.setReserve2( transHourInfo.getReserve2() );
//						tranCallbackAbnoinfo.setReserve3( transHourInfo.getReserve3() );
//						tranCallbackAbnoinfo.setTermid( transHourInfo.getTermid() );
//						tranCallbackAbnoinfo.setTranId( transHourInfo.getId() );
//						tranCallbackAbnoinfo.setTransAmt( transHourInfo.getTransAmt() );
//						tranCallbackAbnoinfo.setTransCode( transHourInfo.getTransCode() );
//						tranCallbackAbnoinfo.setTransDate( transHourInfo.getTranMonthDay() );
//						tranCallbackAbnoinfo.setTransNotenum( transHourInfo.getTransNotenum());
//						tranCallbackAbnoinfo.setTransOrgid( transHourInfo.getTransOrgid() );
//						tranCallbackAbnoinfo.setTransResult( transHourInfo.getTransResult() );
//						tranCallbackAbnoinfo.setTransTime( transHourInfo.getTransTime() );
//						addTransInfoCallList.add( tranCallbackAbnoinfo );
//					}}}}catch( AppException e ){
//						logger.error("", e );}
//		return addTransInfoCallList;
//	}
//	/**
//	 * 	// 张数丄1�7致，如果序列号一致不要监控，这里只监控张数一致，序号不一致的数据
//	 *					// 1：张数不丄1�7臄1�7
//	 *					// 2：张数一致，序列号不丄1�7臄1�7
//	 *					// 3：张数和序号都不丄1�7臄1�7
//	 *  @param  list TransHourInfo集合
//	 *  @return List
//	 */
//	public List analyseAbnormitCallback( List list ){
//		List addTransInfoCallList = new ArrayList();
//		try{if( list != null && list.size() > 0 ){
//			for( int i = 0; i < list.size(); i++ ){
//					String tranId = "";
//					String callSeq = "";
//					TransHourInfo transHourInfo = ( TransHourInfo ) list.get( i );
//					if( null != transHourInfo&& transHourInfo.getCallbackNotenum()> 0&& "CWD".equals( transHourInfo.getTransCode() ) ){
//						tranId = transHourInfo.getId();
//						/*boolean tempFlag = false;*/
//						String strSubSql = " select seriaNo  from  TransBanknoteSeqHour  where tranId='"
//								+ tranId+ "' and noteFlag ='1' and ( seriaNo   not in " +
//								" (  select  seriaNo   from TransBanknoteSeqHour  where  tranId ='"
//								+ tranId+ "' and noteFlag ='0' ) or seriaNo  is null )";
//						List subListCall = find(strSubSql );
//						String noteNum = String.valueOf( transHourInfo.getTransNotenum());
//						String callBackNum = String.valueOf( transHourInfo.getCallbackNotenum());
//						if( noteNum.equals( callBackNum ) ){
//							callSeq = "";
//							if( subListCall != null && subListCall.size() > 0 ){
//								for( int k = 0; k < subListCall.size(); k++ ){
//									Object obj = subListCall.get( k );
//									if( obj == null|| obj.toString().length() == 0 ){
//										callSeq += "-1,";}else{
//									callSeq += obj.toString() + ",";}}
//								TranCallbackAbnoinfo tranCallbackAbnoinfo = new TranCallbackAbnoinfo();
//								tranCallbackAbnoinfo.setAbnoCallbackType( "2" );
//								tranCallbackAbnoinfo.setAccountNo( transHourInfo.getAccountNo() );
//								tranCallbackAbnoinfo.setAnyDate( new Date() );
//								// tranCallbackAbnoinfo.setTransNotenum(transHourInfo.getNoteNum());
//								tranCallbackAbnoinfo.setBlackNotenum( transHourInfo.getBlackNotenum() );
//								tranCallbackAbnoinfo.setCallbackNotenum( transHourInfo.getCallbackNotenum() );
//								tranCallbackAbnoinfo.setCreateDate( transHourInfo.getCreateDate() );
//								tranCallbackAbnoinfo.setJournalNo( transHourInfo.getJournalNo() );
//								tranCallbackAbnoinfo.setNote( callSeq );
//								tranCallbackAbnoinfo.setRepeatNotenum( transHourInfo.getRepeatNotenum() );
//								tranCallbackAbnoinfo.setReserve1( transHourInfo.getReserve1() );
//								tranCallbackAbnoinfo.setReserve2( transHourInfo.getReserve2() );
//								tranCallbackAbnoinfo.setReserve3( transHourInfo.getReserve3() );
//								tranCallbackAbnoinfo.setTermid( transHourInfo.getTermid() );
//								tranCallbackAbnoinfo.setTranId( transHourInfo.getId() );
//								tranCallbackAbnoinfo.setTransAmt( transHourInfo.getTransAmt() );
//								tranCallbackAbnoinfo.setTransCode( transHourInfo.getTransCode() );
//								tranCallbackAbnoinfo.setTransDate( transHourInfo.getTranMonthDay()+transHourInfo.getTransTime() );
//								tranCallbackAbnoinfo.setTransNotenum( transHourInfo.getTransNotenum());
//								tranCallbackAbnoinfo.setTransOrgid( transHourInfo.getTransOrgid() );
//								tranCallbackAbnoinfo.setTransResult( transHourInfo.getTransResult() );
//								tranCallbackAbnoinfo.setTransTime( transHourInfo.getTransTime() );
//								addTransInfoCallList.add( tranCallbackAbnoinfo );
//							}
//						}
//						else{// 回收钞票张数不一臄1�7
//							callSeq = "";
//							String callBackType = "";
//							// 张数不一致，而且回收的序号也不一臄1�7
//							if( subListCall != null && subListCall.size() > 0 ){
//								for( int k = 0; k < subListCall.size(); k++ ){
//									Object obj = subListCall.get( k );
//									if( obj == null|| obj.toString().length() == 0 ){
//										callSeq += "-1,";}
//									else{callSeq += obj.toString() + ",";}}
//									callBackType = "3";
//							}else{callBackType = "1";}
//							TranCallbackAbnoinfo tranCallbackAbnoinfo = new TranCallbackAbnoinfo();
//							tranCallbackAbnoinfo.setAbnoCallbackType( callBackType );
//							tranCallbackAbnoinfo.setAccountNo( transHourInfo.getAccountNo() );
//							tranCallbackAbnoinfo.setAnyDate( new Date() );
//							// tranCallbackAbnoinfo.setTransNotenum(transHourInfo.getNoteNum());
//							tranCallbackAbnoinfo.setBlackNotenum( transHourInfo.getBlackNotenum() );
//							tranCallbackAbnoinfo.setCallbackNotenum( transHourInfo.getCallbackNotenum());
//							tranCallbackAbnoinfo.setCreateDate( transHourInfo.getCreateDate() );
//							tranCallbackAbnoinfo.setJournalNo( transHourInfo.getJournalNo() );
//							tranCallbackAbnoinfo.setNote( callSeq );
//							tranCallbackAbnoinfo.setRepeatNotenum( transHourInfo.getRepeatNotenum() );
//							tranCallbackAbnoinfo.setReserve1( transHourInfo.getReserve1() );
//							tranCallbackAbnoinfo.setReserve2( transHourInfo.getReserve2() );
//							tranCallbackAbnoinfo.setReserve3( transHourInfo.getReserve3() );
//							tranCallbackAbnoinfo.setTermid( transHourInfo.getTermid() );
//							tranCallbackAbnoinfo.setTranId( transHourInfo.getId() );
//							tranCallbackAbnoinfo.setTransAmt( transHourInfo.getTransAmt() );
//							tranCallbackAbnoinfo.setTransCode( transHourInfo.getTransCode() );
//							tranCallbackAbnoinfo.setTransDate( transHourInfo.getTranMonthDay() );
//							tranCallbackAbnoinfo.setTransNotenum( transHourInfo.getTransNotenum() );
//							tranCallbackAbnoinfo.setTransOrgid( transHourInfo.getTransOrgid() );
//							tranCallbackAbnoinfo.setTransResult( transHourInfo.getTransResult() );
//							tranCallbackAbnoinfo.setTransTime( transHourInfo.getTransTime() );
//							addTransInfoCallList.add( tranCallbackAbnoinfo );}}}}}
//			catch( AppException e ){
//			logger.error("", e );}
//		return addTransInfoCallList;
//	}
//
//	 /**
//	  * @param date 保存时间
//	  * @return  List
//	  */
//	public List analyseAbnormitEspecial( String date ){
//		List addTransInfoEspecialList = new ArrayList();
//		try{String strEspecialRuleSql = "   from  SpecialRegulation ";
//			String especialOneSeq = "";
//			String especialTwoSeq = "";
//			List especialRuleList = find(strEspecialRuleSql );
//			if( especialRuleList != null && especialRuleList.size() > 0 ){
//				for( int i = 0; i < especialRuleList.size(); i++ ){
//					SpecialRegulation specialRegulation = ( SpecialRegulation ) especialRuleList.get( i );
//					String strEspecialSql = "";
//					// 单规刄1�7
//					if( specialRegulation.getSpecialType() != null
//							&& specialRegulation.getSpecialType().equals( "0" ) ){
//						if( specialRegulation.getRegulation() != null ){
//							especialOneSeq = specialRegulation.getRegulation().replace( "*", "%" );
//						}
//						strEspecialSql = "  from TransHourInfo  t  where   t.reserve1='1' and t.id in( " +
//								" select distinct tbs.tranId  " +" from TransBanknoteSeqHour  tbs    " +
//					"where tbs.seriaNo  like '"+ especialOneSeq+ "' and  tbs.createDate <='"+ date + "')";
//					}else if( specialRegulation.getSpecialType() != null
//							&& specialRegulation.getSpecialType().equals( "1" ) ){
//						// 范围规则
//						if( specialRegulation.getRegulation() != null
//								&& specialRegulation.getRegulation().length() >= Integer.parseInt("21") ){
//							String temp[] = specialRegulation.getRegulation().trim().split( "-" );
//							if( temp.length == 2 ){
//								especialOneSeq = temp[0];
//								especialTwoSeq = temp[1];
//								especialOneSeq = especialOneSeq.replace( "*","%" );
//								especialTwoSeq = especialTwoSeq.replace( "*","%" );
//							}}
//						strEspecialSql = "  from TransHourInfo  t  where  t.reserve1='1' and  " +
//								"t.id in(  select distinct tbs.tranId   from TransBanknoteSeqHour  tbs   " +
//								" where tbs.seriaNo <='"+ especialTwoSeq+ "' and tbs.seriaNo >='"+ especialOneSeq
//								+ "'  and tbs.createDate <='"+ date + "')";
//					}
//
//					if( strEspecialSql.trim().length() > 0 ){
//						List specialList = find(strEspecialSql );
//						for( int k = 0; k < specialList.size(); k++ ){
//							TransHourInfo transHourInfo = ( TransHourInfo ) specialList.get( k );
//							TranEspeciinfo tranEspeciinfo = new TranEspeciinfo();
//							tranEspeciinfo.setAccountNo( transHourInfo.getAccountNo() );
//							tranEspeciinfo.setAnyDate( new Date() );
//							tranEspeciinfo.setBlackNotenum( transHourInfo.getBlackNotenum());
//							tranEspeciinfo.setCallbackNotenum( transHourInfo.getCallbackNotenum());
//							tranEspeciinfo.setCometype( specialRegulation.getSource() );
//							tranEspeciinfo.setCreateDate( transHourInfo.getCreateDate() );
//							tranEspeciinfo.setCurrency( specialRegulation.getMoneyType() );
//							tranEspeciinfo.setDenomination( specialRegulation.getMoneyDenomination() );
//							tranEspeciinfo.setEspeciseq( specialRegulation.getRegulation() );
//							tranEspeciinfo.setJournalNo( transHourInfo.getJournalNo() );
//							tranEspeciinfo.setRepeatNotenum( transHourInfo.getRepeatNotenum());
//							tranEspeciinfo.setReserve1( transHourInfo.getReserve1() );
//							tranEspeciinfo.setReserve2( transHourInfo.getReserve2() );
//							tranEspeciinfo.setReserve3( transHourInfo.getReserve3() );
//							tranEspeciinfo.setResult( specialRegulation.getResult() );
//							tranEspeciinfo.setSequence( "" );
//							tranEspeciinfo.setTermid( transHourInfo.getTermid() );
//							tranEspeciinfo.setTranId( transHourInfo.getId() );
//							tranEspeciinfo.setTransAmt( transHourInfo.getTransAmt() );
//							tranEspeciinfo.setTransCode( transHourInfo.getTransCode() );
//							tranEspeciinfo.setTransDate( transHourInfo.getTranMonthDay() );
//							tranEspeciinfo.setTransNotenum( transHourInfo.getTransNotenum());
//							tranEspeciinfo.setTransOrgid( transHourInfo.getTransOrgid() );
//							tranEspeciinfo.setTransResult( transHourInfo.getTransResult() );
//							tranEspeciinfo.setTransTime( transHourInfo.getTransTime() );
//							tranEspeciinfo.setSpecialId( specialRegulation.getId() );
//							tranEspeciinfo.setNote( specialRegulation.getResult() );
//							addTransInfoEspecialList.add( tranEspeciinfo );
//						}
//
//					}
//				}
//			}
//
//		}
//		catch( AppException e ){
//			logger.error("", e );
//		}
//		return addTransInfoEspecialList;
//	}
//	/**
//	 * @param list 集合
//	 * @return List
//	 * */
//	public List analyseAbnormitEspecial( List list ){
//		List addTransInfoEspecialList = new ArrayList();
//		StringBuffer str=new StringBuffer();
//		TransHourInfo info=null;
//		//循环取出集合中交易信息ID
//		for(int i=0;i<list.size();i++){
//			info=(TransHourInfo)list.get( i );
//			str.append( "'"+info.getId()+"'," );}
//		String strId=str.toString();
//		if(StringUtils.isNotBlank( strId )){
//			strId=strId.substring( 0,strId.length()-1 );
//		}
//		try{
///*			 boolean flag=false;*/
//			String strEspecialRuleSql = "   from  SpecialRegulation ";
//			String especialOneSeq = "";
//			String especialTwoSeq = "";
//			List especialRuleList = find(strEspecialRuleSql );
//			if( especialRuleList != null && especialRuleList.size() > 0 ){
//				for( int i = 0; i < especialRuleList.size(); i++ ){
//					SpecialRegulation specialRegulation = ( SpecialRegulation ) especialRuleList.get( i );
//					String strEspecialSql = "";
//					// 单规刄1�7
//					if( specialRegulation.getSpecialType() != null
//							&& specialRegulation.getSpecialType().equals( "0" ) ){
//						if( specialRegulation.getRegulation() != null ){
//							especialOneSeq = specialRegulation.getRegulation().replace( "*", "%" );
//						}
//						strEspecialSql = "  from TransHourInfo  t  where   t.reserve1='1' and t.id " +
//								"in(  select distinct tbs.tranId   from TransBanknoteSeqHour  tbs    " +
//								"where tbs.seriaNo  like '"+ especialOneSeq+ "' and  tbs.tranId in ("+strId+"))";
//				}
//					else if( specialRegulation.getSpecialType() != null
//							&& specialRegulation.getSpecialType().equals( "1" ) ){
//						// 范围规则
//						if( specialRegulation.getRegulation() != null
//								&& specialRegulation.getRegulation().length() >= Integer.parseInt("21") ){
//							String temp[] = specialRegulation.getRegulation()
//									.trim().split( "-" );
//							if( temp.length == 2 ){
//								especialOneSeq = temp[0];
//								especialTwoSeq = temp[1];
//								especialOneSeq = especialOneSeq.replace( "*","%" );
//								especialTwoSeq = especialTwoSeq.replace( "*","%" );
//							}
//
//						}
//						strEspecialSql = "  from TransHourInfo  t  where  t.reserve1='1' and  t.id in( " +
//								" select distinct tbs.tranId   from TransBanknoteSeqHour  tbs   " +
//								" where tbs.seriaNo <='"+ especialTwoSeq
//								+ "' and tbs.seriaNo >='"+ especialOneSeq+ "'  and tbs.tranId" +
//										" in("+strId+"))";				
//					}
//					if( strEspecialSql.trim().length() > 0 ){
//						List specialList = find(
//								strEspecialSql );
//						for( int k = 0; k < specialList.size(); k++ ){
//							TransHourInfo transHourInfo = ( TransHourInfo ) specialList.get( k );
//							if(null!=transHourInfo){		
//							TranEspeciinfo tranEspeciinfo = new TranEspeciinfo();
//							tranEspeciinfo.setAccountNo( transHourInfo.getAccountNo() );
//							tranEspeciinfo.setAnyDate( new Date() );
//							tranEspeciinfo.setBlackNotenum( transHourInfo.getBlackNotenum());
//							tranEspeciinfo.setCallbackNotenum( transHourInfo.getCallbackNotenum());
//							tranEspeciinfo.setCometype( specialRegulation.getSource() );
//							tranEspeciinfo.setCreateDate( transHourInfo.getCreateDate() );
//							tranEspeciinfo.setCurrency( specialRegulation.getMoneyType() );
//							tranEspeciinfo.setDenomination( specialRegulation.getMoneyDenomination() );
//							tranEspeciinfo.setEspeciseq( specialRegulation.getRegulation() );
//							tranEspeciinfo.setJournalNo( transHourInfo.getJournalNo() );
//							tranEspeciinfo.setRepeatNotenum( transHourInfo.getRepeatNotenum());
//							tranEspeciinfo.setReserve1( transHourInfo.getReserve1() );
//							tranEspeciinfo.setReserve2( transHourInfo.getReserve2() );
//							tranEspeciinfo.setReserve3( transHourInfo.getReserve3() );
//							tranEspeciinfo.setResult( specialRegulation.getResult() );
//							tranEspeciinfo.setSequence( "" );
//							tranEspeciinfo.setTermid( transHourInfo.getTermid() );
//							tranEspeciinfo.setTranId( transHourInfo.getId() );
//							tranEspeciinfo.setTransAmt( transHourInfo.getTransAmt() );
//							tranEspeciinfo.setTransCode( transHourInfo.getTransCode() );
//							tranEspeciinfo.setTransDate( transHourInfo.getTranMonthDay()+transHourInfo.getTermid() );
//							tranEspeciinfo.setTransNotenum( transHourInfo.getTransNotenum());
//							tranEspeciinfo.setTransOrgid( transHourInfo.getTransOrgid() );
//							tranEspeciinfo.setTransResult( transHourInfo.getTransResult() );
//							tranEspeciinfo.setTransTime( transHourInfo.getTransTime() );
//							tranEspeciinfo.setSpecialId( specialRegulation.getId() );
//							tranEspeciinfo.setNote( specialRegulation.getResult() );
//							addTransInfoEspecialList.add( tranEspeciinfo );
//						}
//						}
//					}
//				}
//			}
//
//		}
//		catch( AppException e ){
//			logger.error("", e );
//		}
//		return addTransInfoEspecialList;
//	}
//	/**
//	 * 删除
//	 * @param date   保存时间 
//	 * @return boolean 
//	 */
//	public boolean removeTranHourDate( String date ){
//		boolean flag = false;
//		Session session = this.getSessionFactory().openSession();
//		Connection cnn = session.connection();
//		try{
//			String strInsertTranInfo = " insert into Tran_Info  select * from Trans_Hour_Info" +
//					"  where   reserve1='1' and c_create_Date <='"
//					+ date + "'";
//			String strInsertTranSeq = "insert into Trans_Banknote_Seq   select * from Trans_Banknote_Seq_Hour   where   c_create_Date <='"
//					+ date
//					+ "' and c_tran_Id  in(select c_id  from Trans_Hour_Info  where   reserve1='1' and c_create_Date <='"
//					+ date + "')";
//
//			String strDelTranSeq = "delete Trans_Banknote_Seq_Hour  where  c_create_Date <='"
//					+ date
//					+ "' and c_tran_Id  in(select c_id  from  Trans_Hour_Info  where   reserve1='1' and  c_create_Date  <='"
//					+ date + "')";
//			String strDelInfo = "  delete Trans_Hour_Info   where   reserve1='1' and c_create_Date  <='"
//					+ date + "'";
//			Statement stmt = cnn.createStatement();
//			stmt.execute( strInsertTranInfo );
//			stmt.execute( strInsertTranSeq );
//			stmt.execute( strDelTranSeq );
//			stmt.execute( strDelInfo );
//			cnn.commit();
//			session.close();
//			flag = true;
//		}catch( SQLException e ){
//			logger.error("", e );
//			try{cnn.rollback();
//				cnn.close();
//				session.close();}
//			catch( SQLException ee ){
//				logger.error("", ee );
//			}
//
//		}
//		return flag;
//	}
//   /**
//    *  @param date 保存时间 
//    *  @return boolean
//    * */
////	public boolean removeTranHourDateList( String date )	{
////		boolean flag = false;	
////		// 插入交易信息中的数据
////		List insertTranInfoList = null;
////		// 插入钞票序列号的信息
////		List insertTransBanknoteList = null;
////		/*
////		 * 移出数据的时候，查询已经上传成功的信息�1�7�1�7 插入数据的时候，先插入主交易信息，然后插入序列号信息
////		 * 删除数据的时候，先删除序列号信息，然后在删除主交易信恄1�7
////		 * 
////		 */
////		String insertTranInfoStr = "  from TransHourInfo  where   reserve1='1' and createDate <='"
////				+ date + "'";
////		String insertTransBanknoteStr = " from TransBanknoteSeqHour   where   createDate <='"
////				+ date
////				+ "' and tranId  in(select id  from TransHourInfo  where   reserve1='1' and createDate <='"
////				+ date + "')";
////		String deleteTranInfoHour = "  delete TransHourInfo   where   reserve1='1' and createDate  <='"
////				+ date + "'";
////		String deleteTranBanknoteStr = "delete TransBanknoteSeqHour  where  createDate <='"
////				+ date
////				+ "' and tranId  in(select id  from  TransHourInfo  where   reserve1='1' and  createDate  <='"
////				+ date + "')";
////
////		insertTranInfoList = find(insertTranInfoStr );
////		insertTransBanknoteList = find(insertTransBanknoteStr );
////
////		if( insertTranInfoList != null && insertTranInfoList.size() > 0 ){
////			for( int i = 0; i < insertTranInfoList.size(); i++ ){
////				TransHourInfo transHourInfo = ( TransHourInfo ) insertTranInfoList.get( i );
////				TranInfo tranInfo = new TranInfo();
////				try{
////					BeanUtils.copyProperties( tranInfo, transHourInfo );
////				} catch (IllegalAccessException e) {
////				logger.error("",e);
////				} catch (InvocationTargetException e) {
////					logger.error("",e);
////				}
////
////				this.save( tranInfo );
////
////			}
////		}
////		if( insertTransBanknoteList != null
////				&& insertTransBanknoteList.size() > 0 ){
////			for( int i = 0; i < insertTransBanknoteList.size(); i++ ){
////				TransBanknoteSeq transBanknoteSeq = new TransBanknoteSeq();
////				TransBanknoteSeqHour transBanknoteSeqHour = ( TransBanknoteSeqHour ) insertTransBanknoteList.get( i );
////				try{
////					BeanUtils.copyProperties( transBanknoteSeq,
////							transBanknoteSeqHour );
////				
////				} catch (IllegalAccessException e) {
////				logger.error("",e);
////				} catch (InvocationTargetException e) {
////					logger.error("",e);
////				}
////				transBanknoteSeqDao.save( transBanknoteSeq );
////			}
////		}
//		// 丄1�7定要先删除序列号的信息，在删除交易信恄1�7
//		//this.batchExecute(deleteTranBanknoteStr);
//		//this.batchExecute(deleteTranInfoHour);
////		this.getHibernateTemplate().bulkUpdate( deleteTranBanknoteStr );
////		this.getHibernateTemplate().bulkUpdate( deleteTranInfoHour );
//
//		/*
//	
//		 * session = this.getHibernateTemplate().getSessionFactory()
//		 * .openSession();
//		 * 
//		 * Connection cnn = session.connection(); try { String strInsertTranInfo = "
//		 * insert into Tran_Info select * from Trans_Hour_Info where
//		 * reserve1='1' and c_create_Date <='" + date + "'"; String
//		 * strInsertTranSeq = "insert into Trans_Banknote_Seq select * from
//		 * Trans_Banknote_Seq_Hour where c_create_Date <='" + date + "' and
//		 * c_tran_Id in(select c_id from Trans_Hour_Info where reserve1='1' and
//		 * c_create_Date <='" + date + "')";
//		 * 
//		 * String strDelTranSeq = "delete Trans_Banknote_Seq_Hour where
//		 * c_create_Date <='" + date + "' and c_tran_Id in(select c_id from
//		 * Trans_Hour_Info where reserve1='1' and c_create_Date <='" + date +
//		 * "')"; String strDelInfo = " delete Trans_Hour_Info where reserve1='1'
//		 * and c_create_Date <='" + date + "'";
//		 * 
//		 * Statement stmt = cnn.createStatement();
//		 * stmt.execute(strInsertTranInfo); stmt.execute(strInsertTranSeq);
//		 * stmt.execute(strDelTranSeq); stmt.execute(strDelInfo);
//		 * 
//		 * cnn.commit();
//		 * 
//		 * session.close(); //
//		 * this.getHibernateTemplate().execute(strInsertTranInfo); //
//		 * this.getHibernateTemplate().bulkUpdate(strInsertTranSeq); //
//		 * this.getHibernateTemplate().bulkUpdate(strDelTranSeq); //
//		 * this.getHibernateTemplate().bulkUpdate(strDelInfo); flag = true;
//		
//		return flag;
//	} */
//	/**
//	 * 删除集合中的数据
//	 * @param list  TranHour集合
//	 * @return boolean
//	 */
////	public boolean removeTranHourDateList( List list){
////		boolean flag = false;
////		@SuppressWarnings("unused")
////		String idString=null;
////		try{
////		
////		// 插入钞票序列号的信息
////		List insertTransBanknoteList = null;
////		StringBuffer str=new StringBuffer();
////		//交易信息ID数组
////		String [] idStrings=new String[list.size()];
////		TransHourInfo info=null;
////		//循环取出集合中交易信息ID
////		for(int i=0;i<list.size();i++){
////			info=(TransHourInfo)list.get( i );
////			str.append( "'"+info.getId()+"'," );
////			idStrings[i]=info.getId();
////		}
////		String strId=str.toString();
////		if(StringUtils.isNotBlank( strId )){
////			strId=strId.substring( 0,strId.length()-1 );
////		}
////		//为防止内存溢出每次只查询50条记录，先查出循环次敄1�7
////		String timeSql="select count(*) from TransBanknoteSeqHour   where tranId  in("+strId+")";
////		int count=getPerformTime( timeSql );
////		int start=0;
////		final int l= 50;
////		for(int m=0;m<count;m++){
////			
////			start=m*l;
////			//朄1�7多取50条记彄1�7
////			insertTransBanknoteList =getTransBanknoteSeqHourOnFirstFifty( idStrings,start, l );
////			if( insertTransBanknoteList != null
////					&& insertTransBanknoteList.size() > 0 ){
////				for( int i = 0; i < insertTransBanknoteList.size(); i++ ){
////					TransBanknoteSeq transBanknoteSeq = new TransBanknoteSeq();
////					TransBanknoteSeqHour transBanknoteSeqHour = ( TransBanknoteSeqHour ) insertTransBanknoteList.get( i );
////					try{
////						
////							BeanUtils.copyProperties( transBanknoteSeq,transBanknoteSeqHour );
////					
////						//分析时把交易日期和时间放到一个字段中，便于查评1�7
////						transBanknoteSeq.setTransDate( transBanknoteSeqHour.getTransDate()+transBanknoteSeqHour.getTranTime() );
////						transBanknoteSeqDao.save( transBanknoteSeq );
////						idString=transBanknoteSeq.getId();
////					
////				} catch (IllegalAccessException e) {
////					logger.error("",e);
////				} catch (InvocationTargetException e) {
////				
////					logger.error("",e);
////				}
////			}
////			}
////		}
////		
////		if( list != null && list.size() > 0 ){
////			for( int i = 0; i < list.size(); i++ ){
////				TransHourInfo transHourInfo = ( TransHourInfo ) list.get( i );
////				TranInfo tranInfo = new TranInfo();
////				try{
////					BeanUtils.copyProperties( tranInfo, transHourInfo );
////					//把日期和时间在要析时放到丄1�7个字段中厄1�7
////					tranInfo.setTransDate( transHourInfo.getTransDate()+transHourInfo.getTransTime() );
////					save( tranInfo );
////				} catch (IllegalAccessException e) {
////					logger.error("",e);
////				} catch (InvocationTargetException e) {
////					logger.error("",e);
////				}
////				
////			}
////			//this.getHibernateTemplate().flush();
////		}
////		//删除冠字号信息和交易信息
////		if(StringUtils.isNotBlank( strId )){
////			
////			String deleteTranBanknoteStr = "delete TransBanknoteSeqHour where  tranId  in("+strId+")";
////			String deleteTranInfoHour = "  delete TransHourInfo   where   id in("+strId+")";
////			this.batchExecute(deleteTranBanknoteStr);
////			this.batchExecute(deleteTranInfoHour);
//////			this.getHibernateTemplate().bulkUpdate( deleteTranBanknoteStr );
//////			this.getHibernateTemplate().bulkUpdate( deleteTranInfoHour );
////		}
////		flag=true;	
////		}
////		catch( AppException e ){
////			logger.error("",e);
////		}
////		return flag;
////	}
//	/**
//	 *  @param abnoBlackList  List<TranAbnoinfo>
//	 *  @param abnoRepeatList List<TranAbnoinfo>
//	 *  @param tranCallbackAbnoinfo List<TranCallbackAbnoinfo>
//	 *  @param tranEspeciinfo List<TranEspeciinfo>
//	 *  @return boolean
//	 */
//	public boolean analyseTranDataAdd( List<TranAbnoinfo> abnoBlackList,
//			List<TranAbnoinfo> abnoRepeatList,
//			List<TranCallbackAbnoinfo> tranCallbackAbnoinfo,
//			List<TranEspeciinfo> tranEspeciinfo ){
//		boolean flag = false;
//		int a =Integer.parseInt("50");
//		for( int i = 0; i < abnoBlackList.size(); ++i ){
//			transAbnoinfoDao.save((TranAbnoinfo)abnoBlackList.get(i));
//			if( i % a == 0 ){
//				transAbnoinfoDao.getSession().flush();
//			}
//		}
//		for( int i = 0; i < abnoRepeatList.size(); i++ ){
//			transAbnoinfoDao.save((TranAbnoinfo)abnoRepeatList.get(i));
//			if( i % a == 0 ){
//				transAbnoinfoDao.getSession().flush();
//			}
//		}
//		for( int i = 0; i < tranCallbackAbnoinfo.size(); i++ ){
//			transCallbackAbnoinfoDao.save((TranCallbackAbnoinfo)tranCallbackAbnoinfo.get(i));
//			if( i % a == 0 ){
//				transCallbackAbnoinfoDao.getSession().flush();
//			}
//		}
//		for( int i = 0; i < tranEspeciinfo.size(); i++ ){
//			tranEspeciinfoDao.save((TranEspeciinfo)tranEspeciinfo.get(i));
//			if( i % a == 0 ){
//				tranEspeciinfoDao.getSession().flush();
//			}
//		}
//		flag = true;
//		return flag;
//	}
//
//	/**
//	 * 在要析数据时每次分析50条记录，取共分析的次敄1�7
//	 * 
//	 * @param sql  查询语句
//	 * @return int
//	 */
//	public int getPerformTime( String sql ){
//		int time = 0;
//		final  int a = 50;
//		
//		int count = ( ( Long ) find( sql ).get( 0 ) )
//				.intValue();
//		if( count > 0 ){
//			int div = count / a;
//			int mod = count % a;
//			if( div == 0 ){
//				time = 1;
//			}
//			else{
//				time = ( ( mod == 0 ) ? div : div + 1 );
//			}
//
//		}
//		return time;
//	}
//
//	/**
//	 * 取小于该日期的数据集各1�7
//	 * 
//	 * @param p_date 保存时间
//	 * @param p_page p_page
//	 * @param p_maxsize p_maxsize
//	 * @return list
//	 */
//	public List getTransHourInfoOnFirstFifty( String p_date, int p_page, int p_maxsize ){
////		List list = null;
////		DetachedCriteria sql = null;
////		sql = DetachedCriteria.forClass( TransHourInfo.class );
////		sql.add( Restrictions.eq( "reserve1", "1" ) ).add(
////				Restrictions.le( "createDate", date ) );
////		sql.addOrder( Order.asc( "id" ) );
//		Page<TranInfo> page = new Page<TranInfo>();
//		page.setPageNo(p_page);
//		page.setPageSize(p_maxsize);
//		page.setOrder("asc");
//		page.setOrderBy("id");
//		page = super.findPage(page, Restrictions.eq( "reserve1", "1" ), Restrictions.le( "createDate", p_date ));
//		return page.getResult();
//	}
//	/**
//	 * 分页显示钞票序列号集各1�7
//	 * @param tranIds 关联ID数组
//	 * @param first 弄1�7姄1�7
//	 * @param maxsize 朄1�7大�1�7�1�7
//	 * @return list 
//	 */
//	public List getTransBanknoteSeqHourOnFirstFifty(String []tranIds,int first,int maxsize){
////		List list=null;
////		DetachedCriteria sql=null;     
////		sql=DetachedCriteria.forClass( TransBanknoteSeqHour.class );
////		sql.add( Restrictions.in( "tranId", tranIds ) );
//		Page<TranInfo> page = new Page<TranInfo>();
//		page.setPageNo(first);
//		page.setPageSize(maxsize);
//		page = findPage(page, Restrictions.in( "tranId", tranIds ));
////		list=this.findByCriteria( sql, first, maxsize );
//		return page.getResult();
//	}
//	
//	
//	
//	/**
//	 * 判断是否匹配
//	 * @param patten 匹配字符丄1�7
//	 * @param str 参数
//	 * @return boolean
//	 */
//	public boolean isMatch(String patten,String str){
//		Pattern pattern=Pattern.compile( patten );
//		return pattern.matcher( str ).matches();
//	}
//
//	/**
//	 *  @param list 数据集合
//	 *  @param page  page实体
//	 *  @return page 
//	 */
//	public Page<Object> getPageList(List<Object> list, Page<Object> page) {
//		// Page pageObject = new Page();
//		// pageObject.setPageNo(page.getPageNo());
//		// pageObject.setPageSize(page.getPageSize());
//		// pageObject.setTotalCount(list.size());
//		// pageObject.setResult(list);
//		// return pageObject;
//
//		int recordCount = list.size();
//		int pageNum = page.getPageNo();
//		int pageSize = page.getPageSize();
//		page.setTotalCount(list.size());
//		if (recordCount > 0) {
//			int beginRecordNumOfPage = (pageNum - 1) * pageSize;
//			// 为什么是beginRecordNumOfPage + pageSize而不是beginRecordNumOfPage +
//			// pageSize - 1?
//			// 请看List中subList说明：Returns a view of the portion of this list
//			// between the specified fromIndex, inclusive, and toIndex,
//			// exclusive
//			int endRecordNumOfPage = beginRecordNumOfPage + pageSize;
//			if (endRecordNumOfPage >= recordCount) {
//				endRecordNumOfPage = recordCount;
//			}
//			page.setResult(list.subList(beginRecordNumOfPage,
//					endRecordNumOfPage));
//
//		}
//		return page;
//
//	}
	
	
	public boolean isExistsByBarcodeFlowNum(String barcodeFlowNum)
	{
		String hql = 	" select 1 " +
						" from CmlNoteflowInfo cnf" +
						" where cnf.tdBarcodeFlownum = ?";
		Integer r = this.findUnique(hql, barcodeFlowNum);
		if( r==null )
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean isExistsByBarcodeFlowNumAndFlowStage(String barcodeFlowNum, String flowStage)
	{
		String hql = 	" select 1 " +
						" from CmlNoteflowInfo cnf" +
						" where cnf.tdBarcodeFlownum = ?" +
						" and cnf.flowStage=?";
		Integer r = this.findUnique(hql, barcodeFlowNum, flowStage);
		if( r==null )
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public CmlNoteflowInfo getByBarcodeFlowNum(String barcodeFlowNum)
	{
		String hql = 	" select cnf " +
						" from CmlNoteflowInfo cnf" +
						" where cnf.tdBarcodeFlownum = ?";
		return this.findFirst(hql, barcodeFlowNum);
	}
	
	/**
	 * 根据
	 * 	1. 终端号
	 *  2. 流水号
	 * 进行查询
	 * ByTJ 指 By (T)termId & (J)journalNo
	 */
	@SuppressWarnings("unchecked")
	public Page<CmlNoteflowInfo> getCmlNoteflowInfoPageByTJ(Page page, String termId, String journalNo)
	{
		String hql = 	" select cnf " +
						" from CmlNoteflowInfo cnf" +
						" where cnf.termId = ?" +
						" and cnf.journalNo = ?";
		return this.findPage(page, hql, termId, journalNo);
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Page<CmlNoteflowInfo> queryCmlNoteflowInfoPage(Page page, Map condition)
	{
		String beginTime       = (String)condition.get("startTime");
		String endTime         = (String)condition.get("endTime");
		String barcodeFlowNum  = (String)condition.get("barcodeFlowNum");
		String journalNo       = (String)condition.get("journalNo");
		String flowStage       = (String)condition.get("flowStage");
		String pathCode        = (String)condition.get("pathCode");
		String flag                   = (String)condition.get("flag");
		
		List<Object> parameterList = new ArrayList<Object>();
		
		String hql = 	" select cnf " +
						" from CmlNoteflowInfo cnf" +
						" where 1=1";
		
		// beginTime
		if( StringUtils.isBlank(beginTime) )
		{
			throw new IllegalArgumentException("beginDateString cannot be null.");
		}
		hql += "  and cnf.clearingDate >= ?";
		parameterList.add(beginTime.replace("-", ""));
		
		// endTime
		if( StringUtils.isBlank(endTime) )
		{
			throw new IllegalArgumentException("endDateString cannot be null.");
		}
		hql += "  and cnf.clearingDate <= ?";
		parameterList.add(endTime.replace("-", "")+"240000");
		
		// barcodeFlowNum
		if( StringUtils.isBlank(barcodeFlowNum)==false )
		{
			hql += "  and cnf.tdBarcodeFlownum like ?";
			parameterList.add(barcodeFlowNum+"%");
		}
		
		// journalNo
		if( StringUtils.isBlank(journalNo)==false )
		{
			hql += "  and cnf.journalNo like ?";
			parameterList.add(journalNo);
		}
		
		// orgId
		if( StringUtils.isBlank(pathCode)==false )
		{
			if(null == flag || flag.equals("true")){
				hql += "  and cnf.pathCode like ?";
				parameterList.add(pathCode+"%");
			}else{
				hql += "  and cnf.pathCode = ?";
				parameterList.add(pathCode+"");
			}
		}
		
		// flowStage
		if( StringUtils.isBlank(flowStage)==false )
		{
			hql += "  and cnf.flowStage = ?";
			parameterList.add(flowStage);
		}
		
		hql += " order by cnf.clearingDate desc, cnf.journalNo, cnf.tdBarcodeFlownum desc";
		
		// 开始查询
		return this.findPage(page, hql, parameterList.toArray());
	}
	
	@SuppressWarnings("unchecked")
	public Page<CmlNoteflowInfo> getCmlNoteflowDetailInfosInBoxInfoPageByFlowNum(Page page, String barcodeFlowNum)
	{
		List<Object> parameterList = new ArrayList<Object>();
		
		String[] barcodeFlowNums = barcodeFlowNum.split(",");
		
		
		String hql = 	" select cnf " +
						" from CmlNoteflowInfo cnf" +
						" where cnf.tdBarcodeFlownum in ("+StringUtil.generateMultiPartString("?", barcodeFlowNums.length, ", ")+
		")" +
						" order by cnf.clearingDate desc";
		
		CollectionsUtil.addAll(parameterList, barcodeFlowNums);
		
		return this.findPage(page, hql, parameterList.toArray());
		
	}

}
