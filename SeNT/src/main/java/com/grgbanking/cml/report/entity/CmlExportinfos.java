package com.grgbanking.cml.report.entity;



import java.io.Serializable;
import java.math.BigDecimal;


public class CmlExportinfos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String pro;
	private BigDecimal Version05;
	private BigDecimal Version99;
	private BigDecimal Passmoney;
	private BigDecimal Atmmoney;
	private BigDecimal Stubbedmoney;
	private BigDecimal Trailmoney;
	private BigDecimal Shadinessmoney;
	private BigDecimal Falsecoinmoney;
	private BigDecimal Tatalmoney;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	public BigDecimal getVersion05() {
		return Version05;
	}
	public void setVersion05(BigDecimal version05) {
		Version05 = version05;
	}
	public BigDecimal getVersion99() {
		return Version99;
	}
	public void setVersion99(BigDecimal version99) {
		Version99 = version99;
	}
	public BigDecimal getPassmoney() {
		return Passmoney;
	}
	public void setPassmoney(BigDecimal passmoney) {
		Passmoney = passmoney;
	}
	public BigDecimal getAtmmoney() {
		return Atmmoney;
	}
	public void setAtmmoney(BigDecimal atmmoney) {
		Atmmoney = atmmoney;
	}
	public BigDecimal getStubbedmoney() {
		return Stubbedmoney;
	}
	public void setStubbedmoney(BigDecimal stubbedmoney) {
		Stubbedmoney = stubbedmoney;
	}
	public BigDecimal getTrailmoney() {
		return Trailmoney;
	}
	public void setTrailmoney(BigDecimal trailmoney) {
		Trailmoney = trailmoney;
	}
	public BigDecimal getShadinessmoney() {
		return Shadinessmoney;
	}
	public void setShadinessmoney(BigDecimal shadinessmoney) {
		Shadinessmoney = shadinessmoney;
	}
	public BigDecimal getFalsecoinmoney() {
		return Falsecoinmoney;
	}
	public void setFalsecoinmoney(BigDecimal falsecoinmoney) {
		Falsecoinmoney = falsecoinmoney;
	}
	public BigDecimal getTatalmoney() {
		return Tatalmoney;
	}
	public void setTatalmoney(BigDecimal tatalmoney) {
		Tatalmoney = tatalmoney;
	}


}

