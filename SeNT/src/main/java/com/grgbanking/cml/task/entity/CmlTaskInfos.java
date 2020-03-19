package com.grgbanking.cml.task.entity;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;
/**
 * 清分交易信息
 * @author 广电运通
 * @version 1.0
 * **/

@SuppressWarnings("serial")
@Entity
@Table(name = "CML_TASK_INFOS")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class CmlTaskInfos extends BaseEntity {
	private String connId;
	private String transResult;
	private String orgId;
	private String tmlNum;
	private String sourceOrg;
	private String boxNum;
	private String barInfo;
	private BigDecimal beforeCount;
	private Date bindStart;
	private Date bindEnd;
	private String operatorId;
	private String journalNo;
	private String taskNum;
	private BigDecimal totalMoney;
	private String rotoCashType;
	private BigDecimal atmMoney;
	private BigDecimal passMoney;
	private BigDecimal stubbedMoney;
	private BigDecimal shadinessMoney;
	private BigDecimal trailMoney;
	private BigDecimal falseCoinMoney;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private Date operateDate;
	//private Timestamp operateDate;
	private String memo;
	//机构的pathCode
	private String pathcode;
	
	private BigDecimal version05;
	private BigDecimal version99;
	/**
	 * @return String
	 * */
	@Column(name = "C_PATHCODE")
	public String getPathcode() {
		return pathcode;
	}
	/**
	 * @param pathcode 机构的pathcode
	 * */
	public void setPathcode(String pathcode) {
		this.pathcode = pathcode;
	}
	
	/**
	 * 所属交接信息ID
	 * @return  connId</br>
	 **/
	@Column(name = "C_CONN_ID")
	public String getConnId(){
		return this.connId;
	}
	/**
	 * @param  connId 所属交接信息ID</br>
	 **/
	public void setConnId(String connId){
		this.connId = connId;
	}
	/**
	 * 清分结果
	 * @return  transResult</br>
	 **/
	
	@Column(name = "C_TRANS_RESULT")
	public String getTransResult(){
		return this.transResult;
	}
	/**
	 * @param  transResult 清分结果</br>
	 **/
	public void setTransResult(String transResult){
		this.transResult = transResult;
	}
	/**
	 * 所属机构
	 * @return  orgId</br>
	 **/
	@Column(name = "C_ORG_ID")
	public String getOrgId(){
		return this.orgId;
	}
	/**
	 * @param  orgId  所属机构</br>
	 **/
	public void setOrgId(String orgId){
		this.orgId = orgId;
	}
	/**
	 * 终端编号
	 * @return tmlNum</br>
	 * **/
	@Column(name = "C_TML_NUM")
	public String getTmlNum(){
		return this.tmlNum;
	}
	/**
	 * @param  tmlNum  终端编号</br>
	 **/
	public void setTmlNum(String tmlNum){
		this.tmlNum = tmlNum;
	}
	
	 /**
	  * 钞票来源机构
	  * @return sourceOrg</br>
	  **/
	@Column(name = "C_SOURCE_ORG")
	public String getSourceOrg(){
		return this.sourceOrg;
	}
	/**
	 * @param  sourceOrg  钞票来源机构</br>
	 **/
 
	public void setSourceOrg(String sourceOrg){
		this.sourceOrg = sourceOrg;
	}
	 /**
	  * 款箱编号
	  * @return boxNum</br>
	  **/
	@Column(name = "C_BOX_NUM")
	public String getBoxNum(){
		return this.boxNum;
	}
	/**
	 * @param  boxNum  款箱编号</br>
	 **/
	public void setBoxNum(String boxNum){
		this.boxNum = boxNum;
	}
	
	 /**
	  * 腰条信息
	  * @return barInfo</br>
	  **/
	@Column(name = "C_BAR_INFO")
	public String getBarInfo(){
		return this.barInfo;
	}
	/**
	 * @param barInfo 腰条信息</br>
	 **/
	public void setBarInfo(String barInfo){
		this.barInfo = barInfo;
	}
	
	 /**
	  * 预清分金额
	  * @return beforeCount</br>
	  **/
	@Column(name = "I_BEFORE_COUNT")
	public BigDecimal getBeforeCount(){
		return this.beforeCount;
	}
	/**
	 * @param beforeCount  预清分金额</br>
	 **/
	public void setBeforeCount(BigDecimal beforeCount){
		this.beforeCount = beforeCount;
	}
	 /**
	  * 绑定开始时间
	  * @return bindStart </br>
	  **/
	@Column(name = "D_BIND_START")
	public Date getBindStart(){
		return this.bindStart;
	}
	/**
	 * @param  bindStart 绑定开始时间</br>
	 **/
	public void setBindStart(Date bindStart){
		this.bindStart = bindStart;
	}
	 /**
	  * 结束时间
	  * @return bindEnd </br>
	  **/
	@Column(name = "D_BIND_END")
	public Date getBindEnd(){
		return this.bindEnd;
	}	
	/**
	 * @param  bindEnd 结束时间</br>
	 **/
	public void setBindEnd(Date bindEnd){
		this.bindEnd = bindEnd;
	}
	
	 /**
	  * 清分员
	  * @return operatorId </br>
	  **/
	@Column(name = "C_OPERATOR_ID")
	public String getOperatorId(){
		return this.operatorId;
	}
	/**
	 * @param  operatorId  清分员</br>
	 **/
	public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	}
	/**
	 * 清分流水号
	 * @return journalNo</br>
	 **/
	
	@Column(name = "C_JOURNAL_NO")
	public String getJournalNo(){
		return this.journalNo;
	}
	/**
	 *  @param journalNo  清分流水号</br>
	 **/
	public void setJournalNo(String journalNo){
		this.journalNo = journalNo;
	}
	/**
	 *  任务编号
	 *  @return taskNum</br>
	 **/
	@Column(name = "C_TASK_NUM")
	public String getTaskNum(){
		return this.taskNum;
	}
	/**
	 * @param  taskNum  任务编号</br>
	 **/
	public void setTaskNum(String taskNum){
		this.taskNum = taskNum;
	}
	
	/**
	 * 清分总金额
	 * @return totalMoney</br>
	 **/
	@Column(name = "I_TATAL_MONEY")
	public BigDecimal getTotalMoney(){
		return this.totalMoney;
	}
	/**
	 * @param  totalMoney 清分总金额</br>
	 **/
	public void setTotalMoney(BigDecimal totalMoney){
		this.totalMoney = totalMoney;
	}
	/**
	 * 清分类型
	 * @return rotoCashType</br>
	 **/
	@Column(name = "C_ROTOCASH_TYPE")
	public String getRotoCashType(){
		return this.rotoCashType;
	}
	/**
	 * @param  rotoCashType 清分类型</br>
	 **/
	public void setRotoCashType(String rotoCashType){
		this.rotoCashType = rotoCashType;
	}
	/**
	 * ATM金额
	 * @return  atmMoney</br>
	 **/
	@Column(name = "I_ATM_MONEY")
	public BigDecimal getAtmMoney(){
		return this.atmMoney;
	}
	/**
	 * @param  atmMoney ATM金额</br>
	 **/
	public void setAtmMoney(BigDecimal atmMoney){
		this.atmMoney = atmMoney;
	}
	/**
	 * 流通币金额
	 * @return passMoney</br>
	 **/
	@Column(name = "I_PASS_MONEY")
	public BigDecimal getPassMoney(){
		return this.passMoney;
	}
	/**
	 * @param  passMoney 流通币金额</br>
	 **/
	public void setPassMoney(BigDecimal passMoney){
		this.passMoney = passMoney;
	}
	/**
	 * 残损币金额
	 * @return stubbedMoney</br>
	 **/
	@Column(name = "I_STUBBED_MONEY")
	public BigDecimal getStubbedMoney(){
		return this.stubbedMoney;
	}
	/**
	 * @param  stubbedMoney 残损币金额</br>
	 **/
	public void setStubbedMoney(BigDecimal stubbedMoney){
		this.stubbedMoney = stubbedMoney;
	}
	/**
	 * 可疑钞金额
	 * @return shadinessMoney</br>
	 **/
	@Column(name = "I_SHADINESS_MONEY")
	public BigDecimal getShadinessMoney(){
		return this.shadinessMoney;
	}
	/**
	 * @param  shadinessMoney 残损币金额</br>
	 **/
	public void setShadinessMoney(BigDecimal shadinessMoney){
		this.shadinessMoney = shadinessMoney;
	}
	/**
	 * 尾钞金额
	 * @return trailMoney</br>
	 **/
	
	@Column(name = "I_TRAIL_MONEY")
	public BigDecimal getTrailMoney(){
		return this.trailMoney;
	}
	/**
	 * @param trailMoney  尾钞金额</br>
	 **/
	public void setTrailMoney(BigDecimal trailMoney){
		this.trailMoney = trailMoney;
	}
	/**
	 * 伪钞
	 * @return falseCoinMoney</br>
	 **/
	@Column(name = "I_FALSECOIN_MONEY")
	public BigDecimal getFalseCoinMoney(){
		return this.falseCoinMoney;
	}
	/**
	 * @param falseCoinMoney  伪钞</br>
	 **/
	public void setFalseCoinMoney(BigDecimal falseCoinMoney){
		this.falseCoinMoney = falseCoinMoney;
	}
	/**
	 * 扩展1
	 * @return reserve1</br>
	 **/
	@Column(name = "C_RESERVE1")
	public String getReserve1(){
		return this.reserve1;
	}
	/**
	 * @param  reserve1 扩展1</br>
	 **/
	public void setReserve1(String reserve1){
		this.reserve1 = reserve1;
	}
	/**
	 * 扩展2
	 * @return reserve2</br>
	 **/
	@Column(name = "C_RESERVE2")
	public String getReserve2(){
		return this.reserve2;
	}
	/**
	 * @param  reserve2 扩展2</br>
	 **/
	public void setReserve2(String reserve2){
		this.reserve2 = reserve2;
	}
	/**
	 * 扩展3
	 * @return reserve3</br>
	 **/
	
	@Column(name = "C_RESERVE3")
	public String getReserve3(){
		return this.reserve3;
	}
	/**
	 * @param  reserve3 扩展3</br>
	 **/
	public void setReserve3(String reserve3){
		this.reserve3 = reserve3;
	}
	/**
	 *  录入日期 
	 *  @return operateDate</br>
	 **/
	@Column(name = "D_OPERATE_DATE")
	public Date getOperateDate(){
		return this.operateDate;
	}
	/**
	 * @param  operateDate 录入日期 </br>
	 **/
	
	public void setOperateDate(Date operateDate){
		this.operateDate = operateDate;
	}
	/**
	 *  备注
	 *  @return memo</br>
	 **/
	@Column(name = "C_MEMO")
	public String getMemo(){
		return this.memo;
	}
	/**
	 *  备注
	 *  @param  memo 备注</br>
	 **/
	public void setMemo(String memo){
		this.memo = memo;
	}
	
	@Column(name = "I_VERSION_05")
	public BigDecimal getVersion05() {
		return version05;
	}

	public void setVersion05(BigDecimal version05) {
		this.version05 = version05;
	}

	@Column(name = "I_VERSION_99")
	public BigDecimal getVersion99() {
		return version99;
	}

	public void setVersion99(BigDecimal version99) {
		this.version99 = version99;
	}
}
