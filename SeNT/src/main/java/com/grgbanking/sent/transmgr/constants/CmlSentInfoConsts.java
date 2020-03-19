package com.grgbanking.sent.transmgr.constants;

public class CmlSentInfoConsts
{

	public static final String TERM_TYPE_CML_TASK_INFO         = "0";	// 清分交易
	public static final String TERM_TYPE_ATM_TRAN_INFO         = "1";	// ATM交易
	public static final String TERM_TYPE_CML_IMPORT_RECORD     = "2";	// 手动导入
	//public static final String TERM_TYPE_CML_BATCH_RECORD      = "3";	// 大额取款
	public static final String TERM_TYPE_CML_FLOWNUM_RECORD      = "3";	// 现金流转交易
	public static final String TERM_TYPE_CML_LOAD_NOTES_RECORD = "4";	// ATM加钞/清机交易
	public static final String TERM_TYPE_CML_COUNTER_RECORD    = "5";	// 柜面交易
	
	//返回码
	public static final int REQUEST_IMG_RETCODE_SUCCESS = 0;  //远程请求获取FSN图像成功返回码
	public static final int REQUEST_IMG_RETCODE_IOERR = -1;   //远程请求获取FSN图像IO异常
	public static final int REQUEST_IMG_RETCODE_FAILE = 1;    //远程请求获取FSN图像失败
	public static final int REQUEST_IMG_RETCODE_STILL_DOING = 11; //正在处理中
	public static final int REQUEST_IMG_RETCODE_FINISH = 10;//处理完成
	public static final int REQUEST_IMG_RETCODE_OUTTIME = 99;//处理超时
	
	//数据库状态码
	public static final String NO_FSNIMG_CODE = "45"; //没有冠字号图像的IMAGETYPE值（日表）
	public static final String STILL_DOING = "0";     //仍在处理中（导入表）
	public static final String DONE = "1";     //已处理（导入表）
	public static final String START = "";     //初始状态（导入表）
	
	//农信级别
	public static final String NEED="0";//需要远程获取冠字号图像
	public static final String NO_NEED="1";//不需要远程获取冠字号图像
}
