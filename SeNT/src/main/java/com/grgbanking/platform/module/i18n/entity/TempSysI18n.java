package com.grgbanking.platform.module.i18n.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * TEMP_MENU_I18N entity<br>
 * 外部菜单临时表实体类
 * 
 * @author yt
 * 
 */
@Entity
@Table(name = "MENU_INFO_ALL_I18N")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class TempSysI18n extends BaseEntity {
	private String language;
	private String name;
	private String referenceid;

	/**
	 * language(zh_CN, en_US etc.)<br>
	 * 语言
	 */
	@Column(name = "C_LANGUAGE")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * i18n string<br>
	 * 国际化资源串
	 */
	@Column(name = "C_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * reference temp menu id<br>
	 * 引用菜单临时表的id
	 */
	@Column(name = "C_REFERENCEID")
	public String getReferenceid() {
		return referenceid;
	}

	public void setReferenceid(String referenceid) {
		this.referenceid = referenceid;
	}
}
