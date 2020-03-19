/**
 * 文件名：CardType.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.card.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * card type<br>
 * 银行卡类型
 * 
 * @author yrliang
 */
@Entity
@Table(name = "CARD_TYPE")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class CardType extends BaseEntity {
	private String orgId;
	private String cardId;
	private String self;
	private String province;
	private String local;

	/**
	 * org id<br>
	 * 机构ID
	 */
	@Column(name = "C_ORGID")
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * card id<br>
	 * 卡标识
	 */
	@Column(name = "C_CARDMARK")
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * self card<br>
	 * 本行卡
	 */
	@Column(name = "C_SELF")
	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	/**
	 * province card<br>
	 * 本省卡
	 */
	@Column(name = "C_PROVINCE")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * local card<br>
	 * 本地卡
	 */
	@Column(name = "C_LOCAL")
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
}
