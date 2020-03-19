package com.grgbanking.platform.module.cashserial.entity;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.grgbanking.platform.core.entity.BaseEntity;
import com.grgbanking.platform.core.utils.ReflectionUtils;
import com.grgbanking.platform.module.security.service.UserService;

@Entity
@Table(name = CashSerialToPBOC.TABLE_NAME)
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class CashSerialToPBOC extends BaseEntity {
	/** 表名 */
	public static final String TABLE_NAME = "SMS_SERIAL_UPLOAD_CONFIG";

	private String serverIp;
	private String serverPort;
	private String serverUsername;
	private String serverPassword;
	private String serverType;
	private String uploadHz;
	private String uploadTime;
	private String updateTime;
	private String handlePerson;
	private String taskStatus;
	private String serverName;
	private String serverPath;
	private int uploadValue;
	
	
	@Column(name = "C_SERVER_IP")
	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	
	@Column(name = "C_SERVER_PORT")
	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	@Column(name = "C_SERVER_USERNAME")
	public String getServerUsername() {
		return serverUsername;
	}

	public void setServerUsername(String serverUsername) {
		this.serverUsername = serverUsername;
	}

	@Column(name = "C_SERVER_PASSWORD")
	public String getServerPassword() {
		return serverPassword;
	}

	public void setServerPassword(String serverPassword) {
		this.serverPassword = serverPassword;
	}

	@Column(name = "C_SERVER_TYPE")
	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	@Column(name = "C_CYCLE_TYPE")
	public String getUploadHz() {
		return uploadHz;
	}

	public void setUploadHz(String uploadHz) {
		this.uploadHz = uploadHz;
	}

	@Column(name = "C_START_TIME")
	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Column(name = "C_UPDATE_TIME")
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "C_UPDATE_ID")
	public String getHandlePerson() {
		return handlePerson;
	}

	public void setHandlePerson(String handlePerson) {
		this.handlePerson = handlePerson;
	}

	@Column(name = "C_STATUS")
	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	@Column(name = "C_NAME")
	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	@Column(name = "C_SERVER_PATH")
	public String getServerPath() {
		return serverPath;
	}

	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}

	@Column(name = "C_CYCLE_VALUE")
	public int getUploadValue() {
		return uploadValue;
	}

	public void setUploadValue(int uploadValue) {
		this.uploadValue = uploadValue;
	}

	public static String getTableName() {
		return TABLE_NAME;
	}

	public String getExPropertyValue(String propertyName) {
		String entityClassProperty = UserService.exPropertyMap.get(propertyName);

		Object value = ReflectionUtils.getFieldValue(this, entityClassProperty);
		if (value == null) {
			return null;
		}
		return value.toString();
	}
}
