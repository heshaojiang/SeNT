/**
 * 文件名：SysDatadir.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.datadir.entity;

/** 
 * 
 * Copyright:   Copyright (c) 2011 
 * Company:     GRGBanking
 * @author:     HY
 * Create at:   2011-4-25
 * 
 * Modification History: 
 * Date         Author      Description 
 * -----------  ---------   ---------------------------------------- 
 * 2011-4-25	HY			Initial Create
 */
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * SysDatadir 数据字典实体类
 * 
 * @author yrliang
 */
@Entity
@Table(name = "SYS_DATADIR")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class SysDatadir extends BaseEntity {

	private String parentid;
	private String key;
	private String value;
	private Integer order;
	private String noteEn; // display by english
	private String status;

	public SysDatadir() {
	}

	public SysDatadir(String id, String parentid, String key, String value, int order, String noteEn, String status) {
		this.setId(id);
		this.parentid = parentid;
		this.key = key;
		this.value = value;
		this.order = order;
		this.noteEn = noteEn;
		this.status = status;
	}

	/**
	 * 排序编号
	 */
	@Column(name = "I_ORDER")
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * 父id
	 */
	@Column(name = "C_PARENTID")
	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	/**
	 * 数据字典名称（从sys_i18n取得的Transient属性）
	 */
	@Transient
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 备注
	 */
	@Column(name = "C_NOTE_EN")
	public String getNoteEn() {
		return this.noteEn;
	}

	public void setNoteEn(String noteEn) {
		this.noteEn = noteEn;
	}

	/**
	 * 数据字典key
	 */
	@Column(name = "C_KEY")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 状态:启动/禁用
	 */
	@Column(name = "C_STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
