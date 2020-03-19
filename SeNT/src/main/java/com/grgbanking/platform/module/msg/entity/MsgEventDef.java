package com.grgbanking.platform.module.msg.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * The persistent class for the MSG_EVENTDEF database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MSG_EVENTDEF")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MsgEventDef extends BaseEntity {

	private String sourceId;

	private String eventType;

	private String informManner;

	private String msgTemplate;

	private String role;

	private String flag;

	private String auto;

	public MsgEventDef() {
	}

	/**
	 * 事件类型
	 */
	@Column(name = "C_EVENTTYPE")
	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * 标识符, 0 是终端， 1是机构
	 */
	@Column(name = "C_FLAG")
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 通知方式， 0 短信， 1 邮件， 2是短信+邮件
	 */
	@Column(name = "C_INFORM_MANNER")
	public String getInformManner() {
		return this.informManner;
	}

	public void setInformManner(String informManner) {
		this.informManner = informManner;
	}

	/**
	 * 通知模板，对应模板表中的主键
	 */
	@Column(name = "C_MSGTEMPLATE")
	public String getMsgTemplate() {
		return this.msgTemplate;
	}

	public void setMsgTemplate(String msgTemplate) {
		this.msgTemplate = msgTemplate;
	}

	/**
	 * 通知角色, 用逗号分开,角色在数据字典表中
	 */
	@Column(name = "C_ROLE")
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * 终端ID 或者 是机构ID
	 */
	@Column(name = "C_SOURCEID")
	public String getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * 是否自动通知， 0 否， 1 是
	 */
	@Column(name = "C_AUTO")
	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

}