
package com.grgbanking.sent.stride.entity;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.core.entity.BaseEntity;


@Entity
@Table(name = "cml_stride_rfid_ref")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class StrideRfidRef extends BaseEntity {

										
	/* C_BAG_CODE */
	private String bagCode;
					
	/* C_RFID_CODE */
	private String rfidCode;
	
	@Column(name = "C_BAG_CODE")
	public String getBagCode() {
		return bagCode;
	}

	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}
	@Column(name = "C_RFID_CODE")
	public String getRfidCode() {
		return rfidCode;
	}
	
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
					

}
