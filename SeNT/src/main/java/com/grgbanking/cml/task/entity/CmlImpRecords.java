package com.grgbanking.cml.task.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;
@SuppressWarnings("serial")
@Entity
@Table(name = "CML_IMP_RECORDS")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class CmlImpRecords extends BaseEntity {
	private String tmlNum;
	  /** 任务编号 **/
	  private String taskId;
	  /** 新文件名 **/
	  private String newName;
	  /** 原文件名 **/
	  private String oldName;
	  /** 操作员ID **/
	  private String operaterId;
	  /** 导入状态 **/
	  private String operateStatus;
	  /** 文件路径 **/
	  private String fileDir;
	  /** 导入时间 **/
	  private Date impDate;
	  
	  @Column(name = "C_TERMID")
	  public String getTmlNum() {
	    return tmlNum;
	   }
	  public void setTmlNum(String tmlNum){
	    this.tmlNum = tmlNum; 
	   }
	  @Column(name = "C_TASK_ID")
	  public String getTaskId() {
	    return taskId;
	   }
	  public void setTaskId(String taskId){
	    this.taskId = taskId; 
	   }
	  @Column(name = "C_NEW_NAME")
	  public String getNewName() {
	    return newName;
	   }
	  public void setNewName(String newName){
	    this.newName = newName; 
	   }
	  @Column(name = "C_OLD_NAME")
	  public String getOldName() {
	    return oldName;
	   }
	  public void setOldName(String oldName){
	    this.oldName = oldName; 
	   }
	  @Column(name = "C_OPERATER_ID")
	  public String getOperaterId() {
	    return operaterId;
	   }
	  public void setOperaterId(String operaterId){
	    this.operaterId = operaterId; 
	   }
	  @Column(name = "C_OPERATE_STATUS")
	  public String getOperateStatus() {
	    return operateStatus;
	   }
	  public void setOperateStatus(String operateStatus){
	    this.operateStatus = operateStatus; 
	   }
	  @Column(name = "C_FILE_DIR")
	  public String getFileDir() {
	    return fileDir;
	   }
	  public void setFileDir(String fileDir){
	    this.fileDir = fileDir; 
	   }
	  @Column(name = "D_IMP_DATE")
	  public Date getImpDate() {
	    return impDate;
	   }
	  public void setImpDate(Date impDate){
	    this.impDate = impDate; 
	   }

	               
	  
	  
	  
}
