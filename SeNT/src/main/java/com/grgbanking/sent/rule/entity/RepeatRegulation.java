package com.grgbanking.sent.rule.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 重号规则
 * @author 广电运通
 * @version :1.0
 */

@SuppressWarnings("serial")
@Entity
//@Table(name = "REPEAT_REGULATION")
@Table(name = "REPEAT_REGULATION")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class RepeatRegulation extends BaseEntity {
//	private String id;
	private Integer repeatnum;
	private String dealwithMode;
	private String logMode;
	private String creenMode;
	private String enterAccountMode;
	private String regulationStatus;
	private String termtype;
	private Date createDate;
	private String createName;
	private Date reversionDate;
	private String reversionName;
	private String applyId;
	private String model;
	// 新增字段
	private int termNum;
	
	//规则下发状态
	private String reguStatus;
	/**
	 * 规则下发状态
	 * @return reguStatus</br>
	 */
	@Column(name = "C_REGU_STATUS")
	public String getReguStatus() {
		return reguStatus;
	}
	/**
	 * @param reguStatus  规则下发状态    </br>     
	 */
	public void setReguStatus(String reguStatus) {
		this.reguStatus = reguStatus;
	}
	/**
	 * Constructor</br>
	 */
	public RepeatRegulation() {
	}

//	@Id
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
//	@Column(name = "C_ID", unique = true, nullable = false)
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
	/**
	 * 最多重复张数
	 * @return repeatnum</br>
	 */
	@Column(name = "I_REPEATNUM")
	public Integer getRepeatnum() {
		return repeatnum;
	}
	/**
	 * @param repeatnum  最多重复张数    </br>     
	 */
	public void setRepeatnum(Integer repeatnum) {
		this.repeatnum = repeatnum;
	}
	/**
	 * 处理方式
	 * @return dealwithMode</br>
	 */
	@Column(name = "C_DEALWITH_MODE")
	public String getDealwithMode() {
		return dealwithMode;
	}
	/**
	 * @param dealwithMode  处理方式    </br>     
	 */
	public void setDealwithMode(String dealwithMode) {
		this.dealwithMode = dealwithMode;
	}
	/**
	 * 是否记录流水
	 * @return logMode</br>
	 */
	@Column(name = "C_LOG_MODE")
	public String getLogMode() {
		return logMode;
	}
	/**
	 * @param logMode 是否记录流水   </br>     
	 */
	public void setLogMode(String logMode) {
		this.logMode = logMode;
	}
	/**
	 * 屏幕提示
	 * @return creenMode</br>
	 */

	@Column(name = "C_CREEN_MODE")
	public String getCreenMode() {
		return creenMode;
	}
	/**
	 * @param creenMode 屏幕提示   </br>     
	 */
	public void setCreenMode(String creenMode) {
		this.creenMode = creenMode;
	}
	/**
	 * 入账方式
	 * @return enterAccountMode</br>
	 */

	@Column(name = "C_ENTER_ACCOUNT_MODE")
	public String getEnterAccountMode() {
		return enterAccountMode;
	}
	/**
	 * @param enterAccountMode 入账方式   </br>     
	 */
	public void setEnterAccountMode(String enterAccountMode) {
		this.enterAccountMode = enterAccountMode;
	}
	/**
	 *	规则状态
	 * @return regulationStatus</br>
	 */
	@Column(name = "C_REGULATION_STATUS")
	public String getRegulationStatus() {
		return regulationStatus;
	}
	/**
	 * @param regulationStatus 规则状态  </br>     
	 */
	public void setRegulationStatus(String regulationStatus) {
		this.regulationStatus = regulationStatus;
	}
	/**
	 *	设备种类
	 * @return termtype</br>
	 */
	@Column(name = "C_TERMTYPE")
	public String getTermtype() {
		return termtype;
	}
	/**
	 * @param termtype 设备种类 </br>     
	 */
	public void setTermtype(String termtype) {
		this.termtype = termtype;
	}
	/**
	 *	创建时间
	 * @return createDate</br>
	 */
	@Column(name = "D_CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate 创建时间 </br>     
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 *	业务人员
	 * @return createName</br>
	 */
	@Column(name = "C_CREATE_NAME")
	public String getCreateName() {
		return createName;
	}
	/**
	 * @param createName 业务人员 </br>     
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	/**
	 *	批复时间
	 * @return reversionDate</br>
	 */
	@Column(name = "D_REVERSION_DATE")
	public Date getReversionDate() {
		return reversionDate;
	}
	/**
	 * @param reversionDate 批复时间 </br>     
	 */
	public void setReversionDate(Date reversionDate) {
		this.reversionDate = reversionDate;
	}
	/**
	 *	批复人员
	 * @return reversionName</br>
	 */
	@Column(name = "C_REVERSION_NAME")
	public String getReversionName() {
		return reversionName;
	}
	/**
	 * @param reversionName 批复人员 </br>     
	 */

	public void setReversionName(String reversionName) {
		this.reversionName = reversionName;
	}
	/**
	 *	申请编号
	 * @return applyId</br>
	 */
	@Column(name = "C_APPLY_ID")
	public String getApplyId() {
		return applyId;
	}
	/**
	 * @param applyId 申请编号 </br>     
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	/**
	 *	设备型号
	 * @return model</br>
	 */
	@Column(name = "C_MODEL")
	public String getModel() {
		return model;
	}
	/**
	 * @param model 设备型号</br>     
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 *	升级终端数量
	 * @return termNum</br>
	 */
	@Column(name = "I_TERM_NUM")
	public int getTermNum() {
		return termNum;
	}
	/**
	 * @param termNum 升级终端数量</br>     
	 */
	public void setTermNum(int termNum) {
		this.termNum = termNum;
	}
}
