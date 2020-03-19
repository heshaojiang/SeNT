package com.grgbanking.platform.module.org.entity;

/**
 * 机构VO
 * 
 * @author cwei
 * 
 */
public class OrgInfoVO {

	private String id;// 机构ID
	private String parentId;// 上级机构ID
	private String parentOrgCode;// 上级机构码
	private String orgName;// 机构简称
	private String orgFullName;// 机构全称
	private String orgCode;// 机构码
	private String contact;// 联系人
	private String tel;// 联系电话
	private String address;// 机构地址
	private String status;// 机构状态（有效或无效）
	private String order;// 机构顺序
	private String note;// 备注
	private String level;// 机构层次
	private String pathCode;// 机构查询码
	private String longPan;// 长款挂账账号
	private String shortPan;// 短款挂账账号
	private String loanPan;// 信用卡销账账号
	private String borrowPan;// 借记卡销账账号
	private String f1;//
	private String f2;//
	private String f3;//
	private String f4;//
	private String f5;//
	
	private String finacialCode;// 金融机构代码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgFullName() {
		return orgFullName;
	}

	public void setOrgFullName(String orgFullName) {
		this.orgFullName = orgFullName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPathCode() {
		return pathCode;
	}

	public void setPathCode(String pathCode) {
		this.pathCode = pathCode;
	}

	public String getLongPan() {
		return longPan;
	}

	public void setLongPan(String longPan) {
		this.longPan = longPan;
	}

	public String getShortPan() {
		return shortPan;
	}

	public void setShortPan(String shortPan) {
		this.shortPan = shortPan;
	}

	public String getLoanPan() {
		return loanPan;
	}

	public void setLoanPan(String loanPan) {
		this.loanPan = loanPan;
	}

	public String getBorrowPan() {
		return borrowPan;
	}

	public void setBorrowPan(String borrowPan) {
		this.borrowPan = borrowPan;
	}

	public String getF1() {
		return f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	public String getF2() {
		return f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	public String getF3() {
		return f3;
	}

	public void setF3(String f3) {
		this.f3 = f3;
	}

	public String getF4() {
		return f4;
	}

	public void setF4(String f4) {
		this.f4 = f4;
	}

	public String getF5() {
		return f5;
	}

	public void setF5(String f5) {
		this.f5 = f5;
	}

	public String getParentOrgCode() {
		return parentOrgCode;
	}

	public void setParentOrgCode(String parentOrgCode) {
		this.parentOrgCode = parentOrgCode;
	}

	public String getFinacialCode() {
		return finacialCode;
	}

	public void setFinacialCode(String finacialCode) {
		this.finacialCode = finacialCode;
	}
}
