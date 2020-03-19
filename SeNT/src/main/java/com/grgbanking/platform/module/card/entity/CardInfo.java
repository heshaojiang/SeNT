/**
 * 文件名：CardInfo.java
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
 * card information <br/>
 * 银行卡信息
 * 
 * @author Vinson
 * 
 */
@Entity
@Table(name = "CARD_INFO")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class CardInfo extends BaseEntity {
	private String cardId;
	private String cardName;
	private String bankId;
	private String bankName;
	private int idLength;
	private int length;
	private String applyATM;
	private String applyPOS;
	private String cardType;

	/**
	 * card id<br>
	 * 银行卡ID
	 */
	@Column(name = "C_CARDMARK")
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * card name<br/>
	 * 银行卡名称
	 */
	@Column(name = "C_CARDNAME")
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	/**
	 * bank id<br>
	 * 银行ID
	 */
	@Column(name = "C_BANKCODE")
	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	/**
	 * bank name<br>
	 * 银行名称
	 */
	@Column(name = "C_BANKNAME")
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * card id length<br>
	 * 卡标识长度
	 */
	@Column(name = "I_IDLENGTH")
	public int getIdLength() {
		return idLength;
	}

	public void setIdLength(int idLength) {
		this.idLength = idLength;
	}

	/**
	 * card length<br>
	 * 卡长度
	 */
	@Column(name = "I_LENGTH")
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * apply ATM<br>
	 * 是否适用于ATM
	 */
	@Column(name = "C_APPLYATM")
	public String getApplyATM() {
		return applyATM;
	}

	public void setApplyATM(String applyATM) {
		this.applyATM = applyATM;
	}

	/**
	 * apply pos<br>
	 * 是否适用于POS
	 */
	@Column(name = "C_APPLYPOS")
	public String getApplyPOS() {
		return applyPOS;
	}

	public void setApplyPOS(String applyPOS) {
		this.applyPOS = applyPOS;
	}

	/**
	 * card type<br>
	 * 卡类型
	 */
	@Column(name = "C_CARDTYPE")
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}
