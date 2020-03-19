/**
 * 文件名：MessageKeyConstants.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.common;

/**
 * i18n key<br>
 * 国际化消息对应的后台key
 * 
 * @author yt
 * 
 */
public class MessageKeyConstants {
	/*
	 * 通用异常Key
	 */
	/** 值未改变 */
	public static final String NO_CHANGE = "platform.noChange";
	/** 未选择记录 */
	public static final String NO_SELECTED_RECORD = "platform.noSelectedRecord";
	/** 输入不能为空 */
	public static final String INPUT_NOT_NULL = "platform.inputNotNull";

	/*
	 * 用户角色管理 1. 用户管理 2. 用户组管理 3. 角色管理
	 */
	// 用户组管理
	public static final String SEC_EXIST_GROUP = "security.existGroup";
	public static final String SEC_GROUP_NAME_NOT_NULL = "security.groupNameNotNull";
	// 权限管理
	public static final String SEC_MENU_NAME_NOT_NULL = "security.menuNameNotNull";
	public static final String SEC_BUTTON_NAME_NOT_NULL = "security.buttonNameNotNull";
	// 角色管理
	public static final String SEC_EXIST_ROLE = "security.existRole";
	public static final String SEC_ROLE_NAME_NOT_NULL = "security.roleNameNotNull";
	public static final String SEC_ROLE_LEVEL_NOT_NULL = "security.roleLevelNotNull";
	public static final String SEC_STATUS_NOT_NULL = "security.statusNotNull";
	// 用户管理
	public static final String SEC_USER_CODE_NOT_NULL = "security.userCodeNotNull";
	public static final String SEC_USER_NAME_NOT_NULL = "security.userNameNotNull";
	public static final String SEC_EXIST_USER = "security.existUser";
	public static final String SEC_OLD_PWD_NOT_NULL = "security.oldPwdNotNull";
	public static final String SEC_NEW_PWD_NOT_NULL = "security.newPwdNotNull";
	public static final String SEC_TWO_NEW_PWD_INCONSISTENT = "security.twoNewPwdInconsistent";
	public static final String SEC_OLD_NEW_CONSISTENT = "security.oldNewInconsistent";
	public static final String SEC_PWD_TOO_SIMPLE = "security.pwdTooSimple";
	public static final String SEC_USER_NOT_FOUND = "security.userNotFound";
	public static final String SEC_INVALID_USER_CODE = "security.invalidUserCode";
	public static final String SEC_INCORRECT_OLD_PWD = "security.incorrectOldPwd";
	public static final String SEC_INCORRECT_USER_IS_LOGIN = "security.userIsLogin";
	// 数据字典管理
	public static final String DATA_DIR_FULL_PATH_NOT_NULL = "datadir.fullPathNotNull";
	public static final String DATA_DIR_EXISTED_KEY = "datadir.existedKey";

	// 菜单管理
	public static final String MENU_EXISTED_BUTTON_NAME = "button.existedButtonName";
	public static final String MENU_EXISTED_MENU_NAME = "menu.existedMenuName";

	// 机构管理
	public static final String ORG_CODE_NOT_NULL = "org.orgCodeNotNull";
	public static final String ORG_NAME_NOT_NULL = "org.orgNameNotNull";
	public static final String ORG_CHILDREN_NOT_NULL = "org.orgChildrenNotNull";
	public static final String ORG_EXISTED_ORGID = "org.existedOrgId";
	public static final String ORG_IMPORT_EXCEL_ERROR = "org.importExcelError";
	/*
	 * 银行卡管理 1. 银行卡信息管理 2. 银行卡类型管理
	 */
	// 银行卡信息管理
	public static final String CARD_EXISTED_CARD_INFO = "card.existedCardInfo";
	public static final String CARD_EXISTED_CARD_TYPE = "card.existedCardType";
	public static final String CARD_ID_NOT_NULL = "card.cardIdNotNull";
	public static final String CARD_NAME_NOT_NULL = "card.cardNameNotNull";
	public static final String CARD_BANK_ID_NOT_NULL = "card.bankIdNotNull";
	public static final String CARD_BANK_NAME_NOT_NULL = "card.bankNameNotNull";
	public static final String CARD_INVALID_ID_LENGTH = "card.invalidIdLength";
	public static final String CARD_INVALID_LENGTH = "card.invalidLength";
	public static final String CARD_APPLY_ATM_NOT_NULL = "card.applyAtmNotNull";
	public static final String CARD_APPLY_POS_NOT_NULL = "card.applyPosNotNull";
	public static final String CARD_TYPE_NOT_NULL = "card.cardTypeNotNull";
	// 银行卡类型管理
	public static final String CARD_ORG_ID_NOT_NULL = "card.orgIdNotNull";
	public static final String CARD_SELF_NOT_NULL = "card.selfNotNull";
	public static final String CARD_PROVINCE_NOT_NULL = "card.provinceNotNull";
	public static final String CARD_LOCAL_NOT_NULL = "card.localNotNull";

	// 区域管理
	public static final String AREA_EXISTED = "area.existed";
	public static final String AREA_CHILDREN_NOT_NULL = "area.childrenNotNull";
	public static final String AREA_PARENT_NOT_NULL = "area.parentNotNull";
	public static final String AREA_NAME_NOT_NULL = "area.areaNameNotNull";

	// 终端设备管理
	public static final String TERM_TERMINAL_TYPE_NOT_NULL       = "term.terminalTypeNotNull";
	public static final String TERM_EXISTED_TERMINAL_TYPE        = "term.existedTerminalType";
	public static final String TERM_EXISTED_TERMINAL_TYPE_NAME   = "term.existedTerminalTypeName";
	public static final String TERM_EXISTED_TERMINAL_TYPE_CODE   = "term.existedTerminalTypeCode";
	public static final String TERM_EXISTED_RESPONSIBLE_PERSON   = "term.existedResponsiblePerson";
	public static final String TERM_TYPE_NAME_NOT_NULL           = "term.terminalTypeNameNotNull";
	public static final String TERM_TERMINAL_BRAND_NAME_NOT_NULL = "term.terminalBrandNameNotNull";
	public static final String TERM_EXISTED_TERMINAL_BRAND_NAME  = "term.existedBrandName";
	public static final String TERM_EXISTED_TERMINAL_BRAND_CODE  = "term.existedBrandCode";
	public static final String TERM_COMPANY_NAME_NOT_NULL        = "term.companyNameNotNull";
	public static final String TERM_COMPANY_ADDRESS_NOT_NULL     = "term.companyAddressNotNull";
	public static final String TERM_TERMINAL_MODEL_NAME_NOT_NULL = "term.terminalModelNameNotNull";
	public static final String TERM_EXISTED_TERMINAL_MODEL_NAME  = "term.existedModelName";
	public static final String TERM_EXISTED_TERMINAL_TERM_CODE   = "term.existedTermCode";
	public static final String TERM_EXISTED_TERMINAL_NODER_CODE   = "term.existedNoderCode";
	public static final String TERM_EXISTED_TERMINAL_NETADDR     = "term.existedNetAddr";
	public static final String TERM_TERMINAL_TERM_CODE_NOT_NULL  = "term.termCodeNotNull";
	public static final String TERM_IMPORT_EXCEL_ERROR           = "term.importExcelError";
	public static final String TERM_MODEL_NAME_ALREADY_EXISTS    = "term.termModelNameAlreadyExists";
	public static final String TERM_IS_SELECT_IN_OTHER_NODER    = "term.termIsSelectInOtherNoder";

	//节点机管理
	
	
	/**
	 * 钞箱状态管理
	 */
	public static final String BOX_NUM_NOT_NULL = "cashbox.boxNumNotNull";
	public static final String BOX_ORG_NOT_EXIST = "cashbox.orgidNotExists";
	public static final String BOX_BOXNUM_EXISTS = "cashbox.boxNumExists";
	public static final String BOX_ORGID_CANNOT_BENULL = "cashbox.orgIdCannotBeNull";
	public static final String BOX_IMPORT_EXCEL_ERROR = "cashbox.importExcelError";
	/**
	 * 日志管理 1. 登陆日志管理 2. 操作日志管理
	 */
	public static final String LOG_USER_ID_NOT_NULL = "log.userIdNotNull";
	public static final String LOG_HOST_IP_NOT_NULL = "log.hostIpNotNull";
	public static final String LOGIN_RESULT_NOT_NULL = "log.loginResultNotNull";
	public static final String LOGIN_LOG_NOT_FOUND = "log.loginLogNotFound";

	public static final String LOG_USER_NAME_NOT_NULL = "log.userNameNotNull";
	public static final String LOG_MENU_NAME_NOT_NULL = "log.menuNameNotNull";

	// 参数管理
	public static final String EXIST_KEY = "param.existKey";
	
	// 交易与冠字号查询
	public static final String TRANS_MGR_TRAN_TIME_CANNOT_BE_NULL        = "transmgr.tranTimeCannotBeNull";
	public static final String TRANS_MGR_TRAN_TIME_FORMAT_WRONG          = "transmgr.tranTimeFormatWrong";
	public static final String TRANS_MGR_FLOW_TIME_CANNOT_BE_NULL        = "transmgr.flowTimeCannotBeNull";
	public static final String TRANS_MGR_FLOW_TIME_FORMAT_WRONG          = "transmgr.flowTimeFormatWrong";
	public static final String TRANS_MGR_QUERY_START_TIME_CANNOT_BE_NULL = "transmgr.queryStartTimeCannotBeNull";
	public static final String TRANS_MGR_QUERY_END_TIME_CANNOT_BE_NULL   = "transmgr.queryEndTimeCannotBeNull";
	public static final String TRANS_MGR_QUERY_TIME_FORMAT_WRONG         = "transmgr.queryTimeFormatWrong";
	public static final String TRANS_MGR_PLEASE_SELECT_QUERY_DATE_WITHIN = "transmgr.pleaseSelectQueryDateWithin";
	public static final String TRANS_MGR_PLEASE_SELECT_QUERY_DATE_WITHIN_FOR_FUZZY_QUERY = "transmgr.pleaseSelectQueryDateWithinForFuzzyQuery";
	public static final String TRAN_MGR_PLEASE_DEFINE_INCOMEPAY_CODE     = "transmgr.pleaseDefineIncomePayCode" ;
	public static final String TRAN_MGR_COUNTER_RECORD_ID_IS_NULL        = "transmgr.counterRecordIdIsNull" ;
	public static final String TRAN_MGR_COUNTER_RECORD_IS_NULL           = "transmgr.counterRecordIsNull" ;
	
	// 冠字号批次管理
	public static final String BATCH_MGR_BATCH_RECORD_NOT_FOUND          = "transmgr.batchRecordNotFound";
	public static final String BATCH_MGR_BATCH_BOUND_ALREADY             = "transmgr.batchBoundAlready";
	public static final String BATCH_MGR_BATCH_BOUND_FAIL                = "transmgr.batchBoundFail";
	public static final String BATCH_MGR_PLEASE_INPUT_ATM_NUM            = "transmgr.pleaseInputAtmNum";
	public static final String BATCH_MGR_PLEASE_INPUT_CASHBOX_NUM        = "transmgr.pleaseInputCashboxNum";
	public static final String BATCH_MGR_PLEASE_SELECT_ATM_TYPE          = "transmgr.pleaseSelectAtmType";
	public static final String BATCH_MGR_PLEASE_INPUT_ACCOUNT            = "transmgr.pleaseInputAccount";
	public static final String BATCH_MGR_PLEASE_INPUT_ID_CARD            = "transmgr.pleaseInputIdCard";
	public static final String BATCH_MGR_PLEASE_INPUT_ACCOUNT_OR_ID_CARD = "transmgr.pleaseInputAccountOrIdCard";
	public static final String BATCH_MGR_PLEASE_SELECT_BUSINESS_TYPE     = "transmgr.pleaseSelectBusinessType";
	
	// 清分流转
	public static final String CML_MGR_FLOWNUM_NOT_EXISTS            = "transmgr.flowNumNotExists";
	public static final String CML_MGR_FLOWNUM_DIST_CASH_ALREADY     = "transmgr.flowNumDistCashAlready";
	public static final String CML_MGR_FLOWNUM_NOT_RECEIVED_YET      = "transmgr.flowNumNotReceivedYet";
	public static final String CML_MGR_FLOWNUM_PAID_ALREADY          = "transmgr.flowNumPaidAlready";
	public static final String CML_MGR_FLOWNUM_FINISHED_ALREADY      = "transmgr.flowNumFinishedAlready";
	public static final String CML_MGR_FLOWNUM_ERROR    			 = "transmgr.flowNumError";
	public static final String CML_MGR_FLOWNUM_DIST_CASH_IN_ATM_BOX  = "transmgr.flowNumDistCashInAtmBox";
	
	public static final String CML_MGR_PLEASE_USE_ATM_CASHBOX        = "transmgr.pleaseUseATMCashBox";
	public static final String CML_MGR_PLEASE_USE_BRANCH_KXCASHBOX   = "transmgr.pleaseUseBranchKXCashBox";
	public static final String CML_MGR_PLEASE_USE_CASHBAG            = "transmgr.pleaseUseATMCashBag";
	
	public static final String CML_MGR_PLEASE_USE_CASHBOX_FOR_DELIVERY   = "transmgr.pleaseUseATMCashBoxForDeleivery";
	public static final String CML_MGR_PLEASE_USE_KXCASHBOX_FOR_DELIVERY = "transmgr.pleaseUseKXCashBoxForDeleivery";
	public static final String CML_MGR_PLEASE_USE_CASHBAG_FOR_DELIVERY   = "transmgr.pleaseUseCashBagForDeleivery";
	
	public static final String CML_MGR_CASHBOX_IS_NOT_EXISTING       = "transmgr.cashboxIsNotExisting";
	public static final String CML_MGR_CASHBOX_IS_NOT_FREE           = "transmgr.cashboxIsNotFree";
	public static final String CML_MGR_CASHBOX_IS_NOT_ENABLE           = "transmgr.cashboxIsNotEnable";
	
	public static final String CML_MGR_IS_NOT_CASHBOX                = "transmgr.isNotCashBox";
	public static final String CML_MGR_IS_NOT_KXCASHBOX              = "transmgr.isNotKXCashBox";
	public static final String CML_MGR_IS_NOT_CASHBAG                = "transmgr.isNotCashBag";
	
	public static final String CML_MGR_CASHBOX_IS_NOT_IN_DIST        = "transmgr.cashboxIsNotInDistribution";
	public static final String CML_MGR_KXCASHBOX_IS_NOT_IN_DIST      = "transmgr.kxcashboxIsNotInDistribution";
	public static final String CML_MGR_CASHBAG_IS_NOT_IN_DIST        = "transmgr.cashbagIsNotInDistribution";
	
	public static final String CML_MGR_CASHBOX_CONTAIN_NOT_FLOWNUM   = "transmgr.cashboxContainNotFlowNum";
	public static final String CML_MGR_KXCASHBOX_CONTAIN_NOT_FLOWNUM = "transmgr.kxcashboxContainNotFlowNum";
	public static final String CML_MGR_CASHBAG_CONTAIN_NOT_FLOWNUM   = "transmgr.cashbagContainNotFlowNum";
	
	public static final String CML_MGR_CASHBOX_IS_NOT_FLOWING        = "transmgr.cashboxIsNotFlowing";
	public static final String CML_MGR_CASHBOX_IS_NOT_IN_ATM         = "transmgr.cashboxIsNotInATM";
	public static final String CML_MGR_CASHBOX_STATUS_IS_NOT_ATM_DELIVERY         = "transmgr.cashboxStatusIsNotATMDelivery";
	
	public static final String CML_MGR_CASHBOX_IS_NOT_IN_DELIVERY    = "transmgr.cashboxIsNotInDelivery";
	public static final String CML_MGR_KXCASHBOX_IS_NOT_IN_DELIVERY  = "transmgr.kxcashboxIsNotInDelivery";
	public static final String CML_MGR_CASHBAG_IS_NOT_IN_DELIVERY    = "transmgr.cashbagIsNotInDelivery";
	
	public static final String CML_MGR_CASHBOX_IS_NOT_IN_RETURN      = "transmgr.cashboxIsNotInDelivery";
	
	public static final String CML_MGR_CASHBOX_CANNOT_ADD_TO_ATM     = "transmgr.cashboxCannotAddToATM";
	public static final String CML_MGR_CASHBOX_FILL_INFO_ATM_ALREADY = "transmgr.cashboxFillIntoATMAlready";
	
	public static final String CML_MGR_ATM_IS_NOT_EXISTING           = "transmgr.atmIsNotExisting";
	
	public static final String CML_MGR_BEGINDATE_CANNOT_BE_GREATER_THAN_ENDDATE   = "transmgr.beginDateCannotBeGreaterThanEndDate";
	public static final String CML_MGR_QUERY_DAYS_INTERVAL_CANNOT_BE_GREATER_THAN = "transmgr.queryDaysIntervalCannotBeGreaterThan";

	// 涉假查询
	public static final String FICI_APPLY_TIME_CANNOT_BE_BLANK       = "faultInfoCheckIn.applyTimeCannotBeBlank";
	public static final String FICI_APPLY_TIME_FORMAT_WRONG          = "faultInfoCheckIn.applyTimeFormatWrong";
	public static final String FICI_WITHDRAWAL_TIME_CANNOT_BE_BLANK  = "faultInfoCheckIn.withdrawalTimeCannotBeBlank";
	public static final String FICI_WITHDRAWAL_TIME_FORMAT_WRONG     = "faultInfoCheckIn.withdrawalTimeFormatWrong";

	//数据备份
	public static final String CML_EXISTED_DATABACKUP_PATH       = "term.existedDataBackupPath";
	public static final String CML_EXISTED_DATABACKUP_PATH_FILE   = "term.existedDataBackupPathFile";
	
	//入库管理
	public static final String CASHBOX_ISNOT_FUNDOUT       = "transmgr.cashboxIsNotFundOut";
	
	public static final String CASHBOX_ISNOT_FLOWING       = "transmgr.cashboxIsNotFlowIng";
	
	public static final String CASHBOX_IS_FUNDIN       = "transmgr.cashboxIsFundIn";
	public static final String BOX_CODE_NOT_EXIST       = "transmgr.orgCodeNotExists";
	
	// 人民币冠字号检索查询
	public static final String FICI_SEARCH_TIME_CANNOT_BE_BLANK       = "serialSearchInfo.searchTimeCannotBeBlank";
	public static final String FICI_SEARCH_TIME_FORMAT_WRONG          = "serialSearchInfo.searchTimeFormatWrong";
	public static final String FICI_RECORD_TIME_CANNOT_BE_BLANK  = "serialSearchInfo.recordTimeCannotBeBlank";
	public static final String FICI_RECORD_TIME_FORMAT_WRONG     = "serialSearchInfo.recordTimeFormatWrong";
	
    public static final String TIMER_DAYS_CANNOT_EXCESS_DAYS             = "transmgr.timerDaysCanNotExcessDays" ;
	public static final String TIMER_DAYS_TO_EXECUTE_EXCESS_DAYS         = "transmgr.timerDaysToExecuteExcessDays" ;

	public static final String ID_CAN_NO_BE_NULL        = "transmgr.idCanNotBeNull" ;
	
	public static final String CANNOT_FIND_EXPORT_TASK   = "transmgr.canNotFindExportTask" ;
	
	public static final String NO_DELETE_RECORD_SELECTED        = "transmgr.noDeleteRecordSelected" ;
	
	public static final String BELONG_ORG_NO_EXIST = "transmgr.noExistOrg";
	
}

















