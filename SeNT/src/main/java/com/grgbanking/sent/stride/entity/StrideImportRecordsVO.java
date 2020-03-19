package com.grgbanking.sent.stride.entity;

import java.util.ArrayList;
import java.util.List;


public class StrideImportRecordsVO {
	private String id;
	
	private String operateStatus;
					
	private String operaterId;
					
	private String bagCode;
					
	private String uploadTime;
					
	private String parentId;
					
	private Integer fsnCount;
					
	private Integer bagCount;
					
	private String pathcode;
	
	private String fileName;
	
	private String partMonthday;
	
	private String orgId;
	
	private String flag;
	
	private List<StrideImportRecordsVO> children = null;

	public String getOperateStatus() {
		return operateStatus;
	}

	public void setOperateStatus(String operateStatus) {
		this.operateStatus = operateStatus;
	}

	public String getOperaterId() {
		return operaterId;
	}

	public void setOperaterId(String operaterId) {
		this.operaterId = operaterId;
	}

	public String getBagCode() {
		return bagCode;
	}

	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getFsnCount() {
		return fsnCount;
	}

	public void setFsnCount(Integer fsnCount) {
		this.fsnCount = fsnCount;
	}

	public Integer getBagCount() {
		return bagCount;
	}

	public void setBagCount(Integer bagCount) {
		this.bagCount = bagCount;
	}

	public String getPathcode() {
		return pathcode;
	}

	public void setPathcode(String pathcode) {
		this.pathcode = pathcode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPartMonthday() {
		return partMonthday;
	}

	public void setPartMonthday(String partMonthday) {
		this.partMonthday = partMonthday;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public List<StrideImportRecordsVO> getChildren() {
		return children;
	}

	public void setChildren(List<StrideImportRecordsVO> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
