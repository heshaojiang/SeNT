/**
 * 文件名：User.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */

package com.grgbanking.platform.module.security.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;
import com.grgbanking.platform.core.utils.ReflectionUtils;
import com.grgbanking.platform.module.security.service.UserService;

/**
 * user entity<br>
 * 用户实体
 * 
 * @author vinson
 * 
 */
@Entity
// Table definition
@Table(name = User.TABLE_NAME)
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class User extends BaseEntity {
	/** 表名 */
	public static final String TABLE_NAME = "USR_USER";

	private String userCode;
	private String userName;
	private String orgId;
	private String areaId;
	private String workId;
	private String department;
	private String tel;
	private String mobile;
	private String email;
	private String loginPwd;
	private Date createTime;
	private String defaultModule;
	private Date updateDate;
	private Date invalidDate;
	private Date pwInvalidDate;
	private String status;
	private String logined;
	private Integer loginFailCount;
	private String multiOnline;
	private Date lastLoginTime;
	private int loginTotal;

	// 以下扩展字段
	private String cardId;
	private String posLevel;
	private String posType;
	private String ip;
	private String tellerGroup;
	private String tailBoxNo;

	private String f1;
	private String f2;
	private String f3;
	private String f4;
	private String f5;
	private String f6;
	private String f7;

	/**
	 * @return the createTime
	 */
	@Column(name = "D_CREATETIME")
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the pwInvalidDate
	 */
	@Column(name = "D_PWINVALIDDATE")
	public Date getPwInvalidDate() {
		return pwInvalidDate;
	}

	/**
	 * @param pwInvalidDate
	 *            the pwInvalidDate to set
	 */
	public void setPwInvalidDate(Date pwInvalidDate) {
		this.pwInvalidDate = pwInvalidDate;
	}

	/**
	 * @return the logined
	 */
	@Column(name = "C_LOGINED")
	public String getLogined() {
		return logined;
	}

	/**
	 * @param logined
	 *            the logined to set
	 */
	public void setLogined(String logined) {
		this.logined = logined;
	}

	/**
	 * @return the lastLoginTime
	 */
	@Column(name = "D_LASTLOGINTIME")
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime
	 *            the lastLoginTime to set
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return the loginTotal
	 */
	@Column(name = "I_LOGIN_TOTAL")
	public int getLoginTotal() {
		return loginTotal;
	}

	/**
	 * @param loginTotal
	 *            the loginTotal to set
	 */
	public void setLoginTotal(int loginTotal) {
		this.loginTotal = loginTotal;
	}

	/**
	 * @return the ip
	 */
	@Column(name = "C_IP")
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the tellerGroup
	 */
	@Column(name = "C_TELLER_GROUP")
	public String getTellerGroup() {
		return tellerGroup;
	}

	/**
	 * @param tellerGroup
	 *            the tellerGroup to set
	 */
	public void setTellerGroup(String tellerGroup) {
		this.tellerGroup = tellerGroup;
	}

	/**
	 * @return the tailBoxNo
	 */
	@Column(name = "C_TAILBOX_NO")
	public String getTailBoxNo() {
		return tailBoxNo;
	}

	/**
	 * @param tailBoxNo
	 *            the tailBoxNo to set
	 */
	public void setTailBoxNo(String tailBoxNo) {
		this.tailBoxNo = tailBoxNo;
	}

	@Column(name = "I_LOGINFAIL_COUNT")
	public Integer getLoginFailCount() {
		return loginFailCount;
	}

	public void setLoginFailCount(Integer loginFailCount) {
		this.loginFailCount = loginFailCount;
	}

	// Unique and not null
	@Column(name = "C_USERCODE", nullable = false, unique = true)
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "C_USERNAME", nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "C_ORGID", nullable = true)
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@Column(name = "C_AREAID", nullable = true)
	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	@Column(name = "C_WORKCODE")
	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	@Column(name = "C_DEPARTMENT")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "C_TEL")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "C_MOBILE")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "C_EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "C_LOGIN_PWD")
	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	@Column(name = "C_IDNO")
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	@Column(name = "D_INVALIDDATE")
	public Date getInvalidDate() {
		return invalidDate;
	}

	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}

	@Column(name = "C_POSLEVEL")
	public String getPosLevel() {
		return posLevel;
	}

	public void setPosLevel(String posLevel) {
		this.posLevel = posLevel;
	}

	@Column(name = "C_POSTYPE")
	public String getPosType() {
		return posType;
	}

	public void setPosType(String posType) {
		this.posType = posType;
	}

	// @Column(name = "I_ORDER")
	// public int getOrder() {
	// return order;
	// }

	// public void setOrder(int order) {
	// this.order = order;
	// }

	// @Column(name = "C_ADMIN_ORGID")
	// public String getAdminOrgId() {
	// return adminOrgId;
	// }
	//
	// public void setAdminOrgId(String adminOrgId) {
	// this.adminOrgId = adminOrgId;
	// }

	@Column(name = "C_MULTI_ONLINE")
	public String getMultiOnline() {
		return multiOnline;
	}

	public void setMultiOnline(String multiOnline) {
		this.multiOnline = multiOnline;
	}

	@Column(name = "C_STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "D_UPDATEDATE")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "C_DEFAULT_MODULE")
	public String getDefaultModule() {
		return defaultModule;
	}

	public void setDefaultModule(String defaultModule) {
		this.defaultModule = defaultModule;
	}

	@Column(name = "F1")
	public String getF1() {
		return this.f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	@Column(name = "F2")
	public String getF2() {
		return this.f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	@Column(name = "F3")
	public String getF3() {
		return this.f3;
	}

	public void setF3(String f3) {
		this.f3 = f3;
	}

	@Column(name = "F4")
	public String getF4() {
		return this.f4;
	}

	public void setF4(String f4) {
		this.f4 = f4;
	}

	@Column(name = "F5")
	public String getF5() {
		return this.f5;
	}

	public void setF5(String f5) {
		this.f5 = f5;
	}

	@Column(name = "F6")
	public String getF6() {
		return this.f6;
	}

	public void setF6(String f6) {
		this.f6 = f6;
	}

	@Column(name = "F7")
	public String getF7() {
		return this.f7;
	}

	public void setF7(String f7) {
		this.f7 = f7;
	}

	public String getExPropertyValue(String propertyName) {
		String entityClassProperty = UserService.exPropertyMap.get(propertyName);

		Object value = ReflectionUtils.getFieldValue(this, entityClassProperty);
		if (value == null) {
			return null;
		}
		return value.toString();
	}
}
