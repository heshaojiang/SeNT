package com.grgbanking.sent.rule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.sent.rule.dao.BlackRegulationDao;
import com.grgbanking.sent.rule.dao.RegulationDeliverDao;
import com.grgbanking.sent.rule.dao.RepeatRegulationDao;
import com.grgbanking.sent.rule.entity.BlackRegulation;
import com.grgbanking.sent.rule.entity.RegulationDeliver;
import com.grgbanking.sent.rule.entity.RepeatRegulation;
import com.grgbanking.sent.utils.Transfer;
/**
 * 规则下发表终端明细Service继承BaseService
 * @author 广电运通
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class RegulationDeliverService extends BaseService {
	@Autowired
	private RegulationDeliverDao regulationDeliverDao;
	
	@Autowired
	BlackRegulationDao blackRegulationDao;
	
	@Autowired
	RepeatRegulationDao repeatRegulationDao;
	@Autowired
	Transfer transfer;
	/**
	 * 新增一条RegulationDeliver数据
	 * @param  obj RegulationDeliver实体
	 * @return boolean
	 */
	public boolean addRegulationDeliver(RegulationDeliver obj) {
		boolean flag = false;
		try {
			regulationDeliverDao.saveNew(obj);
			flag = true;
		} catch (AppException e) {
			flag = false;
			logger.error("",e);
		}
		return flag;
	}
    /**
     * 删除一条 RegulationDeliver数据
     * @param obj RegulationDeliver实体
     * @return boolean
     */
	public boolean deleteRegulationDeliver(RegulationDeliver obj) {
		boolean flag = false;
		try {
			regulationDeliverDao.delete(obj
					.getId());
			flag = true;
		} catch (AppException e) {
			logger.error("",e);
		}
		return flag;
	}
	/**
	 * 更新一条RegulationDeliver数据
	 * @param obj RegulationDeliver实体
	 * @return boolean
	 */
	public boolean updateRegulationDeliver(RegulationDeliver obj) {
		boolean flag = false;
		try {
			regulationDeliverDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("",e);
			throw new NullPointerException();
		}
		return flag;
	}
	
	/**
	 * 根据黑名单规则id获取终端字符串
	 * @param applyId
	 * @return
	 */
	public String getTermStrByApplyId(String applyId) {
		String termStr = "";
		String sql = " from RegulationDeliver o where o.applyId='" + applyId + "'";
		List<RegulationDeliver> list=regulationDeliverDao.find(sql);
		if(list != null && list.size() > 0){
			for(int i = 0; i < list.size(); i++){
				if(i == list.size() - 1)
					termStr += list.get(i).getTermid();
				else
					termStr += list.get(i).getTermid() + ",";
			}
		}
		return termStr;
	}
	
	/**
	 * 根据主键ID 查询RegulationDeliver实体
	 * @param id 主键ID
	 * @return RegulationDeliver
	 */
	@Transactional(readOnly = true)
	public RegulationDeliver getRegulationDeliverObject(String id) {
		return (RegulationDeliver) regulationDeliverDao.get(id);
	}
	/**
	 * 根据申请编号查询RegulationDeliver数据
	 * @param applyId 申请编号 
	 * @return   List<RegulationDeliver>
	 */
	@Transactional(readOnly = true)
	public List<RegulationDeliver> getRegulationDeliListByApplyId(String applyId) {
		String sql = " from RegulationDeliver o where o.applyId='" + applyId
				+ "'";
		return regulationDeliverDao.find(sql);
	}
	
	
	/**
	 * 根据申请编号查询RegulationDeliver数据
	 * @param applyId 申请编号 
	 * @return   List<RegulationDeliver>
	 */
	@Transactional(readOnly = true)
	public List<RegulationDeliver> getRegulationDeliverNewListByApplyId(
			String applyId) {
		String sql = " from RegulationDeliver o where o.applyId='" + applyId
				+ "'";
		List<RegulationDeliver> li=regulationDeliverDao.find(sql);
		return li;
	}
	/**
	 * 根据终端编号得到规则下发列表，并按照规则版本排序
	 * @param termid 终端编号
	 * @return  List<RegulationDeliver>
	 */
	@Transactional(readOnly = true)
	public List<RegulationDeliver> getRegulationDeliverListByTermid(
			String termid) {
		String sql = " from RegulationDeliver o where o.termid='" + termid
				+ "' and o.version!=null order by o.version desc";
		return regulationDeliverDao.find(sql);
	}
	
	/**
	 * 批量增加规则下发数据
	 * @param regList 规则下发数据
	 * @return boolean
	 */
	public boolean batchAddRegulationDeliver(List<RegulationDeliver> regList){
		for(RegulationDeliver reg : regList){
			regulationDeliverDao.saveNew(reg);
		}
		return true;
	}

	/**
	 * 根据申请编号取黑名单规则信息，申请编号对应黑名单主键ID
	 * @param applyIds 申请编号
	 * @return List<BlackRegulation>
	 */
	@Transactional(readOnly = true)
	public List<BlackRegulation> getBlackRegulationByApplyId(String applyIds) {  
		String hql = " from BlackRegulation blackRegulation where blackRegulation.id='"
				+ applyIds + "'";
	   return blackRegulationDao.find(hql);
	}
	/**
	 * 根据申请编号取黑名单规则信息，申请编号对应黑名单主键ID
	 * @param applyIds 申请编号
	 * @return BlackRegulation
	 */
	@Transactional(readOnly = true)
	public BlackRegulation getBlackRegulationByApplyId2(String applyIds) {
		BlackRegulation obj=null;
		String hql = " from BlackRegulation blackRegulation where blackRegulation.id='"+ applyIds + "'";
	   List<BlackRegulation> list= blackRegulationDao.find(hql);
	   if(null!=list&&list.size()>0) {
		   obj=list.get(0);
	   }
	   return obj;
	}
	/**
	 * 根据申请 编号取重号信息，申请编号对应重号信息规则的主键ID
	 * @param applyIds 申请编号
	 * @return List<RepeatRegulation>
	 */
	public List<RepeatRegulation> getRepeatRegulationByApplyId(String applyIds){
		String hql = " from RepeatRegulation repeatRegulation where repeatRegulation.id='"
				+ applyIds + "'";
		return repeatRegulationDao.find(hql);
	}
	/**
	 * 根据申请 编号取重号信息，申请编号对应重号信息规则的主键ID
	 * @param applyIds 申请编号
	 * @return RepeatRegulation
	 */
	public RepeatRegulation getRepeatRegulationByApplyId2(String applyIds){
		RepeatRegulation obj=null;
		String hql = " from RepeatRegulation repeatRegulation where repeatRegulation.id='"+ applyIds + "'";
		List<RepeatRegulation> list= repeatRegulationDao.find(hql);
		if(null!=list&&list.size()>0){
			obj=list.get(0);
		}
		return obj;
	}
	/**
	 * 更改黑名单信息
	 * @param obj BlackRegulation实体
	 * @return boolean
	 */
	public boolean updateBlackRegulation(BlackRegulation obj){
		boolean flag = false;
		try {
			blackRegulationDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("",e);
			throw new NullPointerException();
		}
		return flag;
	}
	/**
	 * 更改重号信息
	 * @param obj RepeatRegulation实体
	 * @return  boolean
	 */
	public boolean updateRepeatRegulation(RepeatRegulation obj) {
		boolean flag = false;
		try {
			repeatRegulationDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			
			logger.error("",e);
			throw new NullPointerException();
		}
		return flag;
	}

	/**
	 * 规则下发
     * @param applyIds 申请编号ID组成的字符串，多个ID中间以“，”分隔
	 * @return 
	 * 1:请选 择待下发的规则   （目前前台已经处理，这里只接收待下发的规则）
	 * 2:已通知服务器端下发规则，但由于网络原因，STS端将会在网络恢复之后将规则下发到ATMC端
	 * 3:下发成功
	 * @throws Exception 
	 */
//	public int deliver(String[] applyIds) throws Exception {
//		logger.info("flagxx：");
//		int flag=1;
//	//	RegulationDeliver regulationDeliver = new RegulationDeliver();
//		//regulationDeliver.setApplyId(applyid);
//		int iCount = 0;
//		String[] rdids =applyIds;
//		String[] ids = new String[rdids.length];
//		//黑名单对象信息
//		BlackRegulation blRegu=null;
//		//重号规则对象信息
//		RepeatRegulation reRegu=null;
//		if (rdids != null){
//			//判断规则是否全为待下发的规则，否则不能下发
////			for (int i = 0; i < rdids.length; i++) {
////				//取该申请编号ID下的终端下发明细集合
////				List<RegulationDeliver> rdList = getRegulationDeliverNewListByApplyId(rdids[i]);
////				if (rdList != null && rdList.size() != 0) {
////					//取规则类型 1“黑名单” 2为重号
////					String reguType = rdList.get(0).getType();
////					if (reguType.equals("1")) {
////						 blRegu = getBlackRegulationByApplyId2(rdids[i]);
////						if (null!=blRegu && blRegu.getReguStatus() != null&& !(blRegu.getReguStatus().equals("1"))){
////							//返回1请选择待下发的规则
////							flag=1;
////							return flag;}} else {
////						 reRegu = getRepeatRegulationByApplyId2(rdids[i]);
////						if (null!=reRegu && reRegu.getReguStatus() != null&& !(reRegu.getReguStatus().equals("1"))){
////							flag=1;
////							return flag;}}} else {
////								return 1;}	}
//			for (int i = 0; i < rdids.length; i++) {
//				//取该规则要下发的终端明细规则信息并修改其状态与规则
//				List<RegulationDeliver> rdList = getRegulationDeliverNewListByApplyId(rdids[i]);
//				 blRegu = getBlackRegulationByApplyId2(rdids[i]);
//				 reRegu = getRepeatRegulationByApplyId2(rdids[i]);
//				if (rdList != null && rdList.size() != 0) {
//					String reguType = rdList.get(0).getType();
//					for (int j = 0; j < rdList.size(); j++){
//						RegulationDeliver temp = rdList.get(j);
//						updateRole(blRegu, reRegu, temp);	}
//					ids[iCount++] = rdids[i] + "|" + reguType; // 记录规则类型	
//				}}}
//        // 更新规则下发状态
//		for (int i = 0; i < ids.length; i++) {
//			if (ids[i] != null && !ids[i].equals("")){
//				int index = ids[i].indexOf("|");
//				// 1为黑名单规则
//				if ((ids[i].substring(index + 1)).equals("1")){
//					// 得到黑名单规则
//					 blRegu = getBlackRegulationByApplyId2(ids[i].substring(0, index)); 
//					 if(null!=blRegu) {
//						// 已下发
//						 blRegu.setReguStatus("2"); 
//						 updateBlackRegulation(blRegu); }
//				} else if ((ids[i].substring(index + 1)).equals("2")) {
//					// 得到重号规则
//					 reRegu = getRepeatRegulationByApplyId2(ids[i].substring(0, index));
//					 if(null!=reRegu) {
//						// 已下发
//						 reRegu.setReguStatus("2"); 
//						 updateRepeatRegulation(reRegu); }}
//			} else {flag=1;
//			return flag;}}
//	// 发送报文到STS端，通知规则下发,当前时间精确到毫秒数，并得到后12位做为消息序列号
//		final int a = 13;
//		String messageNo = (System.currentTimeMillis() + "").substring(1,a); 
//		try {R2001Msg rmsg = new R2001Msg();
//			rmsg = getReturnPack(messageNo);
//			if (rmsg != null) {} else {
//				flag=2;
//				return flag;}
//		} catch (ConnectException e) {
//			flag=2;
//			return flag;
//		} catch (AppException e) {
//			flag=2;		
//			return flag;}
//		final int b = 3;	
//		flag=b;
//		logger.info("flagyy："+flag);
//		return flag;}
//	/**
//	 * 改更规则，把新规则加入下发明细中去(取该终端最后一个版本规则并加入新规则拼接成串更新到规则中去)
//	 * @param blObj 黑名单信息
//	 * @param reObj 重号信息
//	 * @param deObj 下发明细信息
//	 */
//	public void updateRole(BlackRegulation blObj, RepeatRegulation reObj, RegulationDeliver deObj){
//		//重组规则 
//		String str_date = DateUtil.getTimeYYYYMMDDHHMMSSString(new Date());
//		String str_version = "v_" + Long.toString(System.currentTimeMillis());
//		// 黑名单规则
//		StringBuffer blackRegu = new StringBuffer();
//		if ( null!=blObj ){
//			blackRegu.append(blObj.getMoneyType()); // 币种
//			blackRegu.append(blObj.getMoneyDenomination()); // 面额
//			blackRegu.append(blObj.getRegulation()); // 规则
//		} else {
//			blackRegu.append("0000");
//		}
//		// 重号规则
//		StringBuffer repeatRegu = new StringBuffer();
//		if ( null!=reObj ){
//			repeatRegu.append(reObj.getRepeatnum() + ","+ reObj.getDealwithMode() + "," +
//			reObj.getLogMode() + ","+ reObj.getCreenMode() + "," + reObj.getEnterAccountMode());
//		} else {
//			repeatRegu.append("0000");
//		}//取该终端以往下发规则明细并按版本倒序排序
//			List<RegulationDeliver> rdList =getRegulationDeliverListByTermid(deObj.getTermid());
//			if (rdList != null && rdList.size() != 0&&StringUtils.isNotBlank(rdList.get(0).getRole())){
//				deObj.setRole(rdList.get(0).getRole());
//			} else {
//				deObj.setRole("0000|0000");
//			}
//			deObj.setNote(deObj.getRole());
//			deObj.setDate(str_date);
//			// 待下发状态
//			deObj.setStatus("1"); 
//			deObj.setVersion(str_version);
//
//			String role_str = deObj.getRole();
//			int index = role_str.indexOf("|");
//			String bl_str = role_str.substring(0, index);
//			//拼接新规则，把新规则与最后一个版本规则拼接到一起
//			if (!bl_str.equals("0000")) {
//				if (!blackRegu.toString().equals("0000")) {
//					bl_str += "," + blackRegu.toString();
//				}
//			} else {
//				bl_str = blackRegu.toString();
//			}
//			String re_str = role_str.substring(index + 1);
//			if(re_str.equals("0000") || !repeatRegu.toString().equals("0000")) {
//				re_str = repeatRegu.toString();
//			}
//			deObj.setRole(bl_str + "|" + re_str);
//
//			updateRegulationDeliver(deObj);
//		
//	}
//	
//	private R2001Msg getReturnPack(String messageNo) throws Exception {
//		S2001Msg smsg = new S2001Msg();
//		smsg.setMessageno(messageNo);
//		// String time = DateUtil.sdf_yyyyMMddHHmmss.format(new Date());
//		// smsg.setTxdate(time.substring(0, 8));
//		// smsg.setTxtime(time.substring(8));
//
//		byte[] returnpack = null;
//		byte[] sendpack = smsg.packMessage();
//
//		// 发送报文，并等待获取返回报文
//		//Transfer Transfer = new Transfer();
//		transfer.init();
//		returnpack = transfer.sendPack(sendpack);
//
//		if (returnpack == null) {
//			return null;
//		} else {
//			R2001Msg rmsg = new R2001Msg();
//			rmsg.unpackMessage(returnpack);
//			return rmsg;
//		}
//	}
//	
//	/**
//	 * 对指定ApplyId的规则进行撤销
//	 * @param str_applyId 指定的下发规则
//	 * @return  int  1:请选择已经下发的规则进行取消2:请选择已下发的规则进行撤销3:操作失败4:撤销成功		
//	 * @throws Exception  异常
//	 */
//	public int cancleRegu(String str_applyId)  throws Exception{
//		RegulationDeliver regulationDeliver = new RegulationDeliver();
//		int flag=1;
//		final  int  a = 3;
//		final int b  =13;
//		regulationDeliver.setApplyId(str_applyId);
//		String str_type = "1"; 
//		if (org.apache.commons.lang.StringUtils.isNotBlank(str_applyId)){
//			List<RegulationDeliver> rdList = getRegulationDeliverListByApplyId(str_applyId);
//			String str_date = DateUtil.getTimeYYYYMMDDHHMMSSString(new Date());
//			String str_version = "v_"+ Long.toString(System.currentTimeMillis());
//			if (rdList != null && rdList.size() != 0){
//				RegulationDeliver first = rdList.get(0);
//				String str_status = null;
//				String str_rule = null;
//				str_type = first.getType();
//				if (str_type.equals("1")) {
//					BlackRegulation blObj = getBlackRegulationByApplyId2(str_applyId);
//					str_status = blObj.getReguStatus();
//					str_rule = blObj.getMoneyType()+ blObj.getMoneyDenomination()+ blObj.getRegulation();
//				} else {RepeatRegulation reObj = getRepeatRegulationByApplyId2(str_applyId);
//						str_status = reObj.getReguStatus();}
//				if (str_status != null && !str_status .equals("2")) {
//					flag=1;
//					return flag;}
//				String str_rule1=null;
//				String str_bl1=null;
//				for (int j = 0; j < rdList.size(); j++){
//					RegulationDeliver temp = rdList.get(j);
//					temp.setStatus("1");
//					temp.setNote(temp.getRole());
//					 // 得到最新下发的
//					RegulationDeliver last = getRegulationDeliverListByTermid(temp.getTermid()).get(0);
//					StringBuffer strBuffer = new StringBuffer();
//					String str_role = last.getRole();
//					int index = str_role.indexOf("|");
//					String str_bl = str_role.substring(0, index);
//					if (str_type.equals("1")) {
//						String[] arr_bl = str_bl.split(",");
//						if (arr_bl.length == 1){
//							strBuffer.append("0000");
//						} else{if (str_bl.indexOf(str_rule + ",") != -1){
//								str_bl1=str_bl.replaceAll( "\\*", "#" );
//								str_rule1=str_rule.replaceAll( "\\*", "#" );
//								str_bl1=str_bl1.replaceAll( str_rule1+",", "" );
//								str_bl1=str_bl1.replaceAll( "#", "\\*" );
//								//strBuffer.append(str_bl.replaceAll(str_rule+ ",", ""));
//								strBuffer.append( str_bl1 );
//							} else {str_bl1=str_bl.replaceAll( "\\*", "#" );
//								str_rule1=str_rule.replaceAll( "\\*", "#" );
//								str_bl1=str_bl1.replaceAll( ","+str_rule1, "" );
//								str_bl1=str_bl1.replaceAll( "#", "\\*" );
//								strBuffer.append( str_bl1 );}}
//						strBuffer.append(str_role.substring(index));} else {
//						 // 撤销重号规则
//						strBuffer.append(str_bl + "|0000");}
//					temp.setRole(strBuffer.toString());
//					temp.setDate(str_date);
//					temp.setVersion(str_version);
//					updateRegulationDeliver(temp);}} else {
//				flag=2;
//				return flag;}
//		} else {
//			flag=a;
//			return flag;
//		}if (str_type.equals("1")) {
//			blackRegulationDao.delete(str_applyId);
//		} else{
//			repeatRegulationDao.delete(str_applyId);}
//		// 发送报文到STS端，通知规则下发,当前时间精确到毫秒数，并得到后12位做为消息序列号
//		String messageNo = (System.currentTimeMillis() + "").substring(1,b); 
//		try {R2001Msg rmsg = new R2001Msg();
//			rmsg = getReturnPack(messageNo);
//		if (rmsg != null){
//		}else {
//				flag=a;
//				return a;}
//} catch (ConnectException e) {
//			flag=a;
//			return flag;
//	} catch (AppException e) {
//			logger.error("", e);
//		}
//	final int c  = 4;        
//	return c;
//	}
}

