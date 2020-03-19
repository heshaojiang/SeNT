package com.grgbanking.sent.audit.entity;


/**
 * @author yt
 *
 */
public class AuditInfoDetail {
	private String username;
    private String applyType;
	private String applayDate;
	private String orgName;
	private String applyId;
	
	/**
	 *
	 * ��˼�¼
	 */
	public AuditInfoDetail(){
		
	}
	/**
	 *@param applyType ��������
	 * @param username �û���
	 * @param applayDate ��������
	 * @param orgName �����
	 * @param applyId ����id
	 * */
	public AuditInfoDetail(String username,String applayDate,String applyType,String orgName,String applyId){
		this.username=username;
		this.applyType=applyType;
		this.applayDate=applayDate;
		this.orgName=orgName;
		this.applyId=applyId;
		
		
	}
  /** 
   * @return String
   */
	public String getApplyId() {
		return applyId;
	}
	/**
	 * @param applyId ����id
	 *
	 * */
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	/**
	 * @return String 
	 * */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username �û���
	 * */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return String 
	 * */
	public String getApplyType() {
		return applyType;
	}
	/**
	 * @param applyType ��������
	 * */
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	/**
	 * @return String 
	 * */
	public String getApplayDate() {
		return applayDate;
	}
	/**
	 * @param applayDate ��������
	 * */
	public void setApplayDate(String applayDate) {
		this.applayDate = applayDate;
	}
	/**
	 * @return String 
	 * */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * @param orgName �����
	 * */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
}
