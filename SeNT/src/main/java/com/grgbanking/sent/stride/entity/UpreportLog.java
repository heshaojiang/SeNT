
package com.grgbanking.sent.stride.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;


@Entity
@Table(name = "cml_upreport_log")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class UpreportLog extends BaseEntity {

										
	/* cMachineType */
	private String machineType;
					
	/* iCrhCount */
	private Integer crhCount;
					
	/* cDeviceType */
	private String deviceType;
					
	/* cFileName */
	private String fileName;
					
	/* cPathcode */
	private String pathcode;
					
	/* cFromCode */
	private String fromCode;
					
	/* cCashType */
	private String cashType;
					
	/* cTranTime */
	private String tranTime;
					
	/* cBusinessInformation */
	private String businessInformation;
					
	/* cUpreportType */
	private String upreportType;
					
	/* cBusinessType */
	private String businessType;
					
	/* cDeviceCode */
	private String deviceCode;
					
	/* cStartTime */
	private String startTime;
					
	/* iCount */
	private Integer count;
					
	/* iParentId */
	private String parentId;
					
	/* cEndTime */
	private String endTime;
					
	/* cBankCode */
	private String bankCode;
					
	/* iVersion */
	private Integer version;
					
	/* cReserve */
	private String reserve;
	
	private String partMonthday;
	
	@Column(name = "C_MACHINE_TYPE")
	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	@Column(name = "I_CRH_COUNT")
	public Integer getCrhCount() {
		return crhCount;
	}

	public void setCrhCount(Integer crhCount) {
		this.crhCount = crhCount;
	}
	@Column(name = "C_DEVICE_TYPE")
	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	@Column(name = "C_FILE_NAME")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Column(name = "C_PATHCODE")
	public String getPathcode() {
		return pathcode;
	}

	public void setPathcode(String pathcode) {
		this.pathcode = pathcode;
	}
	@Column(name = "C_FROM_CODE")
	public String getFromCode() {
		return fromCode;
	}

	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
	}
	@Column(name = "C_CASH_TYPE")
	public String getCashType() {
		return cashType;
	}

	public void setCashType(String cashType) {
		this.cashType = cashType;
	}
	@Column(name = "C_TRAN_TIME")
	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	@Column(name = "C_BUSINESS_INFORMATION")
	public String getBusinessInformation() {
		return businessInformation;
	}

	public void setBusinessInformation(String businessInformation) {
		this.businessInformation = businessInformation;
	}
	@Column(name = "C_UPREPORT_TYPE")
	public String getUpreportType() {
		return upreportType;
	}

	public void setUpreportType(String upreportType) {
		this.upreportType = upreportType;
	}
	@Column(name = "C_BUSINESS_TYPE")
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	@Column(name = "C_DEVICE_CODE")
	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}	
	@Column(name = "C_START_TIME")
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	@Column(name = "I_COUNT")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	@Column(name = "C_PARENT_ID")
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	@Column(name = "C_END_TIME")
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Column(name = "C_BANK_CODE")
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	@Column(name = "I_VERSION")
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	@Column(name = "C_RESERVE")
	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	@Column(name = "C_PART_MONTHDAY")
	public String getPartMonthday() {
		return partMonthday;
	}

	public void setPartMonthday(String partMonthday) {
		this.partMonthday = partMonthday;
	}
	
												
	

}
