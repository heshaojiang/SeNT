package com.grgbanking.sent.common.Constants;

/**
 * @author yt
 * 参数
 */
public class AppConstants{

//	/**
//	 * 测试清分图片路径（发布的路径） 
//	 */
//	public static final String PIC_PATH = "param.sent.ImagePath.NewImagePath";
	
	/**
	 * 图片路径（访问服务器本地文件）
	 */
	public static final String IMAGE_PATH = "param.sent.ImagePath.ImageRootPath";

	/**
	 * 当前银行名称
	 */
	public static final String CURRENT_BANK = "param.sent.SystemManager.currentBank";
	
	/**
	 * 系统 ip
	 */
	public static final String SERVER_IP = "param.sent.SystemManager.ServerIp";
	
	/**
	 * 系统port
	 */
	public static final String SERVER_PORT = "param.sent.SystemManager.ServerPort";
	
	/**
	 * 系统deskey
	 */
	public static final String DESKEY = "param.sent.SystemManager.deskey";
	
	/**
	 * 系统deskeyExist
	 */
	public static final String DESKEY_EXIST = "param.sent.SystemManager.deskeyExist";
	
	/**
	 * 系统timeout
	 */
	public static final String TIMEOUT = "param.sent.SystemManager.timeout";
	
	/**
	 * 系统远程获取冠字号图像timeout
	 */
	public static final String TIMEOUTFREQUESTIMG = "param.sent.SystemManager.timeoutfrequestimg";
	
    /**
     *交易检索的查询的时间范围
     */
	public static final String TRANS_DAY= "param.sent.TransManager.transDay";
	
	/**
     * 清分交易检索的时间范围
     */
	public static final String CML_TRANSDAY="param.sent.TransManager.cmlTransDay";
	
	/**
     * 冠字号码检索结果最大的显示条数
     */
	public static final String CML_QUERY_MAX_ROWS = "param.sent.TransManager.CmlQueryMaxRows";
	
	/**
     * 人民币冠字号检索登记查询天数范围
     */
	public static final String SERIAL_SEARCH_QUERY_DAYS = "param.sent.TransManager.SerialSearchQueryDays";
	
	/**
     * 冠字号码检索结果最大的显示条数
     */
	public static final String CML_SEQ_EXPORT_MAX_ROWS = "param.sent.TransManager.CmlSeqExportMaxRows";
	/**
	 * 冠字号码追踪检索的时间范围
	 */
	public static final String SENT_ALLDAY="param.sent.TransManager.sentAllDay";
	
	/**
	 * 冠字号码追踪模糊检索的时间范围
	 */
	public static final String SENT_ALLDAY_FOR_FUZZY_QUERY="param.sent.TransManager.sentAllDayForFuzzyQuery";
	
	/**
	 * 节点机离线时间设置
	 */
	public static final String NODER_OFF_LINE_TIME="param.sent.TransManager.noderOffLineTime";
	
	/**
	 * 节点机离线时间设置
	 */
	public static final String BOX_QRCODE_RPINT_SWITCH="param.sent.TransManager.boxQRCodePrintSwitch";
	
	/**
	 * 文件上传的服务器ip
	 */
	public static final String FILEUPLOAD_SERVERIP="param.sent.SystemManager.fileUploadServerIp";
	
	/**
	 * 文件上传的服务器端口
	 */
	public static final String FILEUPLOAD_SERVERPORT="param.sent.SystemManager.fileUploadServerPort";
	
	public static final String NOTE_TYPE_LIST="param.sent.SysDatadirMgr.sent.transMgr.noteType";
	
	/**
	 * FSN的路径
	 */
	public static final String FSN_PICPATH="param.sent.fsnPath.fsnRootPath.fsnPath";
	
	/**
	 * 跨行调款zip文件路径
	 */
	public static final String FSN_STRIDE_PATH="param.sent.fsnPath.fsnRootPath.fsnStridePath";
	
	
	/**
	 * 手工导入FSN文件路径
	 */
	public static final String IMPORT_FSN_PATH="param.sent.fsnPath.fsnRootPath.fsnImportPath";
	
	
	/**
	 * 跨行调款打包zip临时目录
	 */
	public static final String FSN_STRIDE_PATHTEMP_FOR_ZIP = "param.sent.fsnPath.fsnRootPath.fsnStridePathTempForZip";
	
	/**
	 * 是否可查看清分中心的数据
	 */
	public static final String Can_QXZX ="param.sent.TransManager.YesOrNoZx";
	
	/**
	 * 清分中心id
	 */
	public static final String QFZX_PATHCODE= "param.sent.TransManager.QfZxId";
	
	/**
	 * 自动上传的一个FSN文件包含的冠字号码数量
	 */
	public static final String CMLSENT_RECORDS="param.sent.fsnPath.cmlSentRecords";
	
	/** 数据字典清分管理->清分纸币类型path */
	public static final String MONEY_TYPE_PATH  = "SysDatadirMgr.sent.cmlMgr.moneyType";
	
	/** 数据字典清分管理->清分纸币币种path */
	public static final String CURRENCY_PATH  = "SysDatadirMgr.sent.cmlMgr.currency";
	
	/** 数据字典清分管理->纸币版别path */
	public static final String VERSION_NUM_PATH  = "SysDatadirMgr.sent.cmlMgr.versionNum";
	
	/**设备类型 */
	public static final String TERMTYPE_PATH = "SysDatadirMgr.sent.cmlMgr.termType";
	
	/**机具类型 */
	public static final String MACHINETYPE_PATH = "SysDatadirMgr.javapt.term.machineType";
	/**钞票类别 */
	public static final String CASHTYPE_PATH = "SysDatadirMgr.sent.cmlMgr.cashType";
	
	public static final String DEVICETYPE_PATH = "SysDatadirMgr.sent.cmlMgr.machineType";
	
	/**业务类型*/
	public static final String TRANTYPE_PATH = "SysDatadirMgr.sent.cmlMgr.tranType";
	
	/**ATM交易业务类型*/
	public static final String ATMTRANBUSINESS_PATH = "SysDatadirMgr.sent.transMgr.transCode";
	
	/**清分交易业务类型*/
	public static final String CLEARINGTRANBUSINESS_PATH = "SysDatadirMgr.sent.cmlMgr.cmlType";
	
	/**atm加钞交易业务类型*/
	public static final String ADDCASHBUSINESS_PATH = "SysDatadirMgr.sent.transMgr.addCashATMType";
	
	/**柜面交易业务类型*/
	public static final String COUNTERBUSINESS_PATH = "SysDatadirMgr.sent.transMgr.cmlCounterRecordBusinessType";
	
	/**ATM交易信息是否可以打印开关(on-打开;其他-关闭)*/
	public static final String PRINT_SWITCH = "param.sent.TransManager.atmTranPrintSwitch";
	
	/**ATM交易信息是否可以打印开关(on-打开;其他-关闭)*/
	public static final String BARCODE_FLOW_NUMBER_LENGTH = "param.sent.TransManager.barcodeFlowNumLength";
	
	/** 上传人行金融机构编码   */
	public static final String UPPERSON_BANK_CODE = "param.sent.SystemManager.currentBankCode" ;
	
	/** CRH文件生成路径  */
	public static final String CRH_GENERAL_PATH = "param.sent.fsnPath.upPersonCrhPath" ;
	
	/**  生成文件格式  */
	public static final String UPLOAD_POC_FORMAT = "param.sent.SystemManager.uploadPocFormat" ;
	
	/** 导出文件最大执行次数  */
	public static final String UPLOAD_EXECUTE_TIMES = "param.sent.SystemManager.exportMaxExecuteTimes" ;
	
	/**  手动添加导出任务执行开关   */
	 public static final String UPLOAD_EXECUTE_SWITCH = "param.sent.SystemManager.exportTaskSwitch" ;
	
	/** 最大待执行任务数量  */
	public static final String MAX_TASK_TO_EXECUTE = "param.sent.TransManager.TaskMaxValue" ;
	 
	
//	/**证明资料类型**/
//	public static final String CERTI_TYPE = "SysDatadirMgr.sent.infoCheckInMgr.certificateType";
//	/**取款方式**/
//    public static final String GET_TYPE = "SysDatadirMgr.sent.infoCheckInMgr.getType";
//	/**查询阶段**/
//	public static final String SEARCH_AGAIN = "SysDatadirMgr.sent.infoCheckInMgr.searchAgain";
	/**轮询等待次数*/
	public static final String SENT_IMG_TIMES="param.sent.SystemManager.sentImgTimes";
	/**轮询等待秒数*/
	public static final String SENT_IMG_SLEEPTIME="param.sent.SystemManager.sentImgSleepTime";
	/**农商级别*/
	public static final String IS_REQUEST_FSN_IMG="param.sent.SystemManager.isRequestFsnImg";

	/** 上传人行银行代码  */
	public static final String UP_PERSON_BANK_CODE = "param.sent.SystemManager.currentBankCode" ;
	
	/**  CRH文件保存路径   */
	public static final String CRH_FILE_PATH = "param.sent.fsnPath.upPersonCrhPath" ;
	
	/** 清分中心机构号  */
	public static final String CLEAR_CENTER_ORGCODE = "param.sent.SystemManager.clearCenterOrgCode" ;
	
	public static final String EXPORT_UPPERSON_FILE_ORGCODE="param.sent.SystemManager.exportUpPersonFileOrg";
	
	/**   异地支行机构号  **/
	public static final String REMOTE_ORGCODE="SysDatadirMgr.sent.transMgr.remoteOrgCode";
	
	/** 自动上传人行标志  **/
	public static final String AUTO_UPLOAD_FLAG="param.sent.SystemManager.autoUploadFlag";

	/** 自动上传跨行调款文件标志  **/
	public static final String AUTO_UPLOAD_STRIDE_FLAG="param.sent.SystemManager.autoUploadStrideFlag";

} 
