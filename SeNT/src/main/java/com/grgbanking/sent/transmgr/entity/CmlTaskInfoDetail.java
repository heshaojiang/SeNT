package com.grgbanking.sent.transmgr.entity;

import java.util.Date;



/**
 * ���������Ϣ
 * **/
public class CmlTaskInfoDetail {
    
	private String id;
	/**
	 * ����id
	 * @return String 
	 * */
	public String getId() {
		return id;
	}
	/**
	 * @param id ����id
	 * */
	public void setId(String id) {
		this.id = id;
	}
	private String termId;
	private String userName;
	//private String operateDate;
	private Date operateDate;
	private float beforeCount;
	private float atmMoney;
	private float passMoney;
	private float stubbedMoney;
	private float shadinessMoney;
	private float trailMoney;
	private float falseCoinMoney;
	private float statisAmt;
	private String toatmnum;
	public String getToatmnum() {
		return toatmnum;
	}
	public void setToatmnum(String toatmnum) {
		this.toatmnum = toatmnum;
	}
	private String orgName;
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	private String uid;
	private float version05;
	private float version99;
	public float getVersion05() {
		return version05;
	}
	public void setVersion05(float version05) {
		this.version05 = version05;
	}
	public float getVersion99() {
		return version99;
	}
	public void setVersion99(float version99) {
		this.version99 = version99;
	}
	//private String oid;
	/**
	 * @return String 
	 * */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid �û����
	 * */
	public void setUid(String uid) {
		this.uid = uid;
	}
//	public String getOid() {
//		return oid;
//	}
//	public void setOid(String oid) {
//		this.oid = oid;
//	}
	/**
	 * ���캯��
	 * */
	public CmlTaskInfoDetail(){
		
	}
  
	/**
	 * select c.tmlNum,u.userName,c.bindStart,c.beforeCount,c.atmMoney,c.passMoney,c.stubbedMoney,
	 * c.shadinessMoney,c.trailMoney," +
		"c.falseCoinMoney ,c.totalMoney ,o.orgName ,c.id, u.userName ,c.sourceOrg
	 * 
	 */
	/**
	 * @param tmlNum �ն˱��
	 * @param  userName ����Ա 
	 * @param  bindStart ��ֿ�ʼʱ��
	 * @param beforeCount Ԥ��ֽ��
	 * @param atmMoney  ATM���
	 * @param passMoney ��ͨ�ҽ��
	 * @param stubbedMoney ����ҽ��
	 * @param shadinessMoney ���ɳ����
	 * @param trailMoney  α�����
	 * @param falseCoinMoney �ٱҽ��
	 * @param totalMoney �ܽ��
	 * @param id �����ʶ
	 * @param uid �û����
	 * */
	public CmlTaskInfoDetail(String termId,String userName,Date bindStart,float beforeCount,float atmMoney,float passMoney,
			float stubbedMoney,float shadinessMoney,float trailMoney,float falseCoinMoney
			,float statisAmt,String id,String uid,String orgName,String toatmnum){
	
		this.termId=termId;
		this.userName=userName;
		this.beforeCount=beforeCount;
		this.atmMoney=atmMoney;
		this.passMoney=passMoney;
		this.stubbedMoney=stubbedMoney;
		this.shadinessMoney=shadinessMoney;
		this.trailMoney=trailMoney;
		this.falseCoinMoney=falseCoinMoney;
		this.statisAmt=statisAmt;
		this.operateDate=bindStart;
		this.orgName=orgName;
		this.id=id;
     	this.uid=uid;
     	this.toatmnum=toatmnum;
//		this.oid=oid;
	
	}
	
//	public String getOrgName() {
//		return orgName;
//	}
//	public void setOrgName(String orgName) {
//		this.orgName = orgName;
//	}
	/**
	 * @return String  �ն˱��
	 *
	 */
	public String getTermId() {
		return termId;
	}
	/**
	 * @param termId
	 * 
	 * */
	public void setTermId(String termId) {
		this.termId = termId;
	}
	/**
	 * @return String �û����
	 * 
	 * */
	public String getUserName() {
		return userName;
	}
	/**
	 * @return Date ʱ��
	 * */
	
	
	/**
	 * @param userName �û����
	 * 
	 * */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	/**
	 *@return  Integer Ԥ��ֽ��
	 * */
	public float getBeforeCount() {
		return beforeCount;
	}
	/**
	 * @param beforeCount Ԥ��ֽ��
	 * */
	public void setBeforeCount(float beforeCount) {
		this.beforeCount = beforeCount;
	}
	/**
	 * @return atmMoney ATM���
	 * */
	public float getAtmMoney() {
		return atmMoney;
	}
	/**
	 * @param atmMoney ATM���
	 * */
	public void setAtmMoney(float atmMoney) {
		this.atmMoney = atmMoney;
	}
	/***
	 * @return Integer ��ͨ���
	 * */
	public float getPassMoney() {
		return passMoney;
	}
	/**
	 * @param passMoney ��ͨ���
	 * */
	public void setPassMoney(float passMoney) {
		this.passMoney = passMoney;
	}
	/**
	 * @return Integer  ����ҽ��
	 * 
	 * */
	public float getStubbedMoney() {
		return stubbedMoney;
	}
	/**
	 *@param stubbedMoney ���ɳ����
	 * */
	public void setStubbedMoney(float stubbedMoney) {
		this.stubbedMoney = stubbedMoney;
	}
	/**
	 * @return Integer ���ɳ����
	 * */
	public float getShadinessMoney() {
		return shadinessMoney;
	}
	/**
	 * 
	 * @param shadinessMoney ���ɳ����
	 * */
	public void setShadinessMoney(float shadinessMoney) {
		this.shadinessMoney = shadinessMoney;
	}
	/**
	 * @return Integer α�����
	 * */
	public float getTrailMoney() {
		return trailMoney;
	}
	/**
	 * @param trailMoney α�����
	 * */
	public void setTrailMoney(float trailMoney) {
		this.trailMoney = trailMoney;
	}
	/**
	 * @return Integer �ٳ����
	 * */
	public float getFalseCoinMoney() {
		return falseCoinMoney;
	}
	/**
	 * @param falseCoinMoney �ٳ����
	 * */
	public void setFalseCoinMoney(float falseCoinMoney) {
		this.falseCoinMoney = falseCoinMoney;
	}
	/**
	 * @return Integer �ܽ��
	 * 
	 * */
	public float getStatisAmt() {
		return statisAmt;
	}
	/**
	 * @param totalMoney �ܽ��
	 * 
	 * */
	public void setStatisAmt(float statisAmt) {
		this.statisAmt = statisAmt;
	}
	
	
}
