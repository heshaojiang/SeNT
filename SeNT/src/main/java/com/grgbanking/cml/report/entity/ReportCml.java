package com.grgbanking.cml.report.entity;


import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;
/**
 * ��ֽ�����Ϣ
 * @author �����ͨ
 * @version 1.0
 * **/

@SuppressWarnings("serial")
@Entity
@Table(name = "CML_TASK_INFOS")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class ReportCml extends BaseEntity {
	private String connId;
	private String transResult;
	private String orgId;
	private String tmlNum;
	private String sourceOrg;
	private String boxNum;
	private String barInfo;
	private float beforeCount;

	private float version05;
	private float version99;

	private Date bindStart;
	private Date bindEnd;
	private String operatorId;
	private String journalNo;
	private String taskNum;
	private float totalMoney;
	private String rotoCashType;
	private float atmMoney;
	private float passMoney;
	private float stubbedMoney;
	private float shadinessMoney;
	private float trailMoney;
	private float falseCoinMoney;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	/**
	 * ���캯��
	 * */
	public ReportCml(){
		
	}
		/**
		 * @param tmlNum �ն˱��
		 * @param shadinessMoney ���ɳ����
		 * @param beforeCount Ԥ��ֽ��
		 * @param trailMoney β�����
		 * @param atmMoney atm�����
		 * @param version05 05��
		 * @param version99 99��
		 * @param totalMoney �ܽ��
		 * @param passMoney ��ͨ���
		 * @param stubbedMoney ����ҽ��
		 * @param falseCoinMoney α�����
		 **/
	public ReportCml(String tmlNum,float shadinessMoney,float beforeCount,float trailMoney,float atmMoney,
			float version05,float falseCoinMoney,float version99,float totalMoney,float passMoney,float stubbedMoney){
		this.tmlNum=tmlNum;
		this.falseCoinMoney=falseCoinMoney;
		this.version05=version05;
		this.version99=version99;
		this.trailMoney=trailMoney;
		this.trailMoney=trailMoney;
		this.atmMoney=atmMoney;
		this.passMoney=passMoney;
		this.totalMoney=totalMoney;
		this.falseCoinMoney=falseCoinMoney;
	    this.stubbedMoney=stubbedMoney;
		
	}
	/**
	 * 
	 * @return float
	 * */
	public float getVersion05() {
		return version05;
	}
	
	/**
	 * @param version05  05��
	 * **/
	public void setVersion05(float version05) {
		this.version05 = version05;
	}
	/**
	 * @return float 
	 * */
	public float getVersion99() {
		return version99;
	}
	/**
	 * @param version99 99��
	 * */
	public void setVersion99(float version99) {
		this.version99 = version99;
	}
	private Date operateDate;
	//private Timestamp operateDate;
	private String memo;
	//���pathCode
	private String pathcode;
	/**
	 * @return String
	 * */
	@Column(name = "C_PATHCODE")
	public String getPathcode() {
		return pathcode;
	}
	/**
	 * @param pathcode ���pathcode
	 * */
	public void setPathcode(String pathcode) {
		this.pathcode = pathcode;
	}
	
	/**
	 * ����������ϢID
	 * @return  connId</br>
	 **/
	@Column(name = "C_CONN_ID")
	public String getConnId(){
		return this.connId;
	}
	/**
	 * @param  connId ����������ϢID</br>
	 **/
	public void setConnId(String connId){
		this.connId = connId;
	}
	/**
	 * ��ֽ��
	 * @return  transResult</br>
	 **/
	
	@Column(name = "C_TRANS_RESULT")
	public String getTransResult(){
		return this.transResult;
	}
	/**
	 * @param  transResult ��ֽ��</br>
	 **/
	public void setTransResult(String transResult){
		this.transResult = transResult;
	}
	/**
	 * ������
	 * @return  orgId</br>
	 **/
	@Column(name = "C_ORG_ID")
	public String getOrgId(){
		return this.orgId;
	}
	/**
	 * @param  orgId  ������</br>
	 **/
	public void setOrgId(String orgId){
		this.orgId = orgId;
	}
	/**
	 * �ն˱��
	 * @return tmlNum</br>
	 * **/
	@Column(name = "C_TML_NUM")
	public String getTmlNum(){
		return this.tmlNum;
	}
	/**
	 * @param  tmlNum  �ն˱��</br>
	 **/
	public void setTmlNum(String tmlNum){
		this.tmlNum = tmlNum;
	}
	
	 /**
	  * ��Ʊ��Դ��
	  * @return sourceOrg</br>
	  **/
	@Column(name = "C_SOURCE_ORG")
	public String getSourceOrg(){
		return this.sourceOrg;
	}
	/**
	 * @param  sourceOrg  ��Ʊ��Դ��</br>
	 **/
 
	public void setSourceOrg(String sourceOrg){
		this.sourceOrg = sourceOrg;
	}
	 /**
	  * ������
	  * @return boxNum</br>
	  **/
	@Column(name = "C_BOX_NUM")
	public String getBoxNum(){
		return this.boxNum;
	}
	/**
	 * @param  boxNum  ������</br>
	 **/
	public void setBoxNum(String boxNum){
		this.boxNum = boxNum;
	}
	
	 /**
	  * ������Ϣ
	  * @return barInfo</br>
	  **/
	@Column(name = "C_BAR_INFO")
	public String getBarInfo(){
		return this.barInfo;
	}
	/**
	 * @param barInfo ������Ϣ</br>
	 **/
	public void setBarInfo(String barInfo){
		this.barInfo = barInfo;
	}
	
	 /**
	  * Ԥ��ֽ��
	  * @return beforeCount</br>
	  **/
	@Column(name = "I_BEFORE_COUNT")
	public Float getBeforeCount(){
		return this.beforeCount;
	}
	/**
	 * @param beforeCount  Ԥ��ֽ��</br>
	 **/
	public void setBeforeCount(float beforeCount){
		this.beforeCount = beforeCount;
	}
	 /**
	  * �󶨿�ʼʱ��
	  * @return bindStart </br>
	  **/
	@Column(name = "D_BIND_START")
	public Date getBindStart(){
		return this.bindStart;
	}
	/**
	 * @param  bindStart �󶨿�ʼʱ��</br>
	 **/
	public void setBindStart(Date bindStart){
		this.bindStart = bindStart;
	}
	 /**
	  * ����ʱ��
	  * @return bindEnd </br>
	  **/
	@Column(name = "D_BIND_END")
	public Date getBindEnd(){
		return this.bindEnd;
	}	
	/**
	 * @param  bindEnd ����ʱ��</br>
	 **/
	public void setBindEnd(Date bindEnd){
		this.bindEnd = bindEnd;
	}
	
	 /**
	  * ���Ա
	  * @return operatorId </br>
	  **/
	@Column(name = "C_OPERATOR_ID")
	public String getOperatorId(){
		return this.operatorId;
	}
	/**
	 * @param  operatorId  ���Ա</br>
	 **/
	public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	}
	/**
	 * �����ˮ��
	 * @return journalNo</br>
	 **/
	
	@Column(name = "C_JOURNAL_NO")
	public String getJournalNo(){
		return this.journalNo;
	}
	/**
	 *  @param journalNo  �����ˮ��</br>
	 **/
	public void setJournalNo(String journalNo){
		this.journalNo = journalNo;
	}
	/**
	 *  ������
	 *  @return taskNum</br>
	 **/
	@Column(name = "C_TASK_NUM")
	public String getTaskNum(){
		return this.taskNum;
	}
	/**
	 * @param  taskNum  ������</br>
	 **/
	public void setTaskNum(String taskNum){
		this.taskNum = taskNum;
	}
	
	/**
	 * ����ܽ��
	 * @return totalMoney</br>
	 **/
	@Column(name = "I_TATAL_MONEY")
	public float getTotalMoney(){
		return this.totalMoney;
	}
	/**
	 * @param  totalMoney ����ܽ��</br>
	 **/
	public void setTotalMoney(float totalMoney){
		this.totalMoney = totalMoney;
	}
	/**
	 * �������
	 * @return rotoCashType</br>
	 **/
	@Column(name = "C_ROTOCASH_TYPE")
	public String getRotoCashType(){
		return this.rotoCashType;
	}
	/**
	 * @param  rotoCashType �������</br>
	 **/
	public void setRotoCashType(String rotoCashType){
		this.rotoCashType = rotoCashType;
	}
	/**
	 * ATM���
	 * @return  atmMoney</br>
	 **/
	@Column(name = "I_ATM_MONEY")
	public float getAtmMoney(){
		return this.atmMoney;
	}
	/**
	 * @param  atmMoney ATM���</br>
	 **/
	public void setAtmMoney(float atmMoney){
		this.atmMoney = atmMoney;
	}
	/**
	 * ��ͨ�ҽ��
	 * @return passMoney</br>
	 **/
	@Column(name = "I_PASS_MONEY")
	public float getPassMoney(){
		return this.passMoney;
	}
	/**
	 * @param  passMoney ��ͨ�ҽ��</br>
	 **/
	public void setPassMoney(float passMoney){
		this.passMoney = passMoney;
	}
	/**
	 * ����ҽ��
	 * @return stubbedMoney</br>
	 **/
	@Column(name = "I_STUBBED_MONEY")
	public float getStubbedMoney(){
		return this.stubbedMoney;
	}
	/**
	 * @param  stubbedMoney ����ҽ��</br>
	 **/
	public void setStubbedMoney(float stubbedMoney){
		this.stubbedMoney = stubbedMoney;
	}
	/**
	 * ���ɳ����
	 * @return shadinessMoney</br>
	 **/
	@Column(name = "I_SHADINESS_MONEY")
	public float getShadinessMoney(){
		return this.shadinessMoney;
	}
	/**
	 * @param  shadinessMoney ����ҽ��</br>
	 **/
	public void setShadinessMoney(float shadinessMoney){
		this.shadinessMoney = shadinessMoney;
	}
	/**
	 * β�����
	 * @return trailMoney</br>
	 **/
	
	@Column(name = "I_TRAIL_MONEY")
	public float getTrailMoney(){
		return this.trailMoney;
	}
	/**
	 * @param trailMoney  β�����</br>
	 **/
	public void setTrailMoney(float trailMoney){
		this.trailMoney = trailMoney;
	}
	/**
	 * α��
	 * @return falseCoinMoney</br>
	 **/
	@Column(name = "I_FALSECOIN_MONEY")
	public float getFalseCoinMoney(){
		return this.falseCoinMoney;
	}
	/**
	 * @param falseCoinMoney  α��</br>
	 **/
	public void setFalseCoinMoney(float falseCoinMoney){
		this.falseCoinMoney = falseCoinMoney;
	}
	/**
	 * ��չ1
	 * @return reserve1</br>
	 **/
	@Column(name = "C_RESERVE1")
	public String getReserve1(){
		return this.reserve1;
	}
	/**
	 * @param  reserve1 ��չ1</br>
	 **/
	public void setReserve1(String reserve1){
		this.reserve1 = reserve1;
	}
	/**
	 * ��չ2
	 * @return reserve2</br>
	 **/
	@Column(name = "C_RESERVE2")
	public String getReserve2(){
		return this.reserve2;
	}
	/**
	 * @param  reserve2 ��չ2</br>
	 **/
	public void setReserve2(String reserve2){
		this.reserve2 = reserve2;
	}
	/**
	 * ��չ3
	 * @return reserve3</br>
	 **/
	
	@Column(name = "C_RESERVE3")
	public String getReserve3(){
		return this.reserve3;
	}
	/**
	 * @param  reserve3 ��չ3</br>
	 **/
	public void setReserve3(String reserve3){
		this.reserve3 = reserve3;
	}
	/**
	 *  ¼������ 
	 *  @return operateDate</br>
	 **/
	@Column(name = "D_OPERATE_DATE")
	public Date getOperateDate(){
		return this.operateDate;
	}
	/**
	 * @param  operateDate ¼������ </br>
	 **/
	
	public void setOperateDate(Date operateDate){
		this.operateDate = operateDate;
	}
	/**
	 *  ��ע
	 *  @return memo</br>
	 **/
	@Column(name = "C_MEMO")
	public String getMemo(){
		return this.memo;
	}
	/**
	 *  ��ע
	 *  @param  memo ��ע</br>
	 **/
	public void setMemo(String memo){
		this.memo = memo;
	}
}
