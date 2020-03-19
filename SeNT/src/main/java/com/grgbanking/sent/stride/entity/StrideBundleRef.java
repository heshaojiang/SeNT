
package com.grgbanking.sent.stride.entity;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.core.entity.BaseEntity;


@Entity
@Table(name = "cml_stride_bundle_ref")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class StrideBundleRef extends BaseEntity {

										
	/* C_BAG_CODE */
	private String bagCode;
					
	/* C_BUNDLE_CODE */
	private String bundleCode;
	
	@Column(name = "C_BAG_CODE")
	public String getBagCode() {
		return bagCode;
	}

	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}
	@Column(name = "C_BUNDLE_CODE")
	public String getBundleCode() {
		return bundleCode;
	}

	public void setBundleCode(String bundleCode) {
		this.bundleCode = bundleCode;
	}
					

}
