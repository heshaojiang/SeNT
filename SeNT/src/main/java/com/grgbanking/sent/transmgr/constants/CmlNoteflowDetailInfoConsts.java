package com.grgbanking.sent.transmgr.constants;

public class CmlNoteflowDetailInfoConsts
{

//	// { 这些以后需要删除
//	public static final String TYPE_BINDING_CASHBUNCH_TO_CASHBOX                  = "0";		// 0：捆钞与钞箱绑定                           条码1存放钞箱号(ATM分捆配钞第1步)
//	public static final String TYPE_BINDING_CASHBOX_TO_ATM                        = "1";		// 1：钞箱号与ATM号绑定                   条码1放钞箱号，条码2放ATM号(ATM分捆配钞,ATM整箱配钞聚道,在行ATM加钞渠道 第2步)
//	public static final String TYPE_BINDING_CASHBUNCH_TO_RFID                     = "2";		// 2：捆钞与RFID捆绑                           条码1放RFID(人行上缴配钞渠道,这时把流转状态置为1结束)
//	public static final String TYPE_BINDING_CASHBUNCH_TO_CARD_LARGE_WITHDRAWAL    = "3";		// 3：捆钞与大额取款时卡号绑定   条码1存放卡号(网点大额配钞渠道)
//	public static final String TYPE_BINDING_CASHBUNCH_TO_CASHBOX_IN_LIB           = "4";		// 4：捆钞与入库时款箱号绑定        条码1存放款箱号(现金中心入库配钞渠道，相当于网点上交第1步)
//	public static final String TYPE_BINDING_CASHBUNCH_TO_CASHBOX_OUT_LIB          = "5";		// 5：捆钞与出库时款箱号绑定        条码1存放款箱号(现金中心出库配钞渠道 现金中心流出第1步)
//	public static final String TYPE_BINDING_FLOWNUM_TO_CASHBOX_ZHATM              = "6";		// 6：钞箱条码与钞箱号绑定             条码1存放钞箱号(ATM整箱配钞聚道、在行ATM加钞1步)
//	public static final String TYPE_BINDING_CASHBUNCH_TO_CASHBOX_IN_LIB_SCAN      = "7";		// 7：入库款箱号扫描                           条码1存放款箱号(现金中心入库配钞渠道，对应网点上交第2步)
//	public static final String TYPE_BINDING_CASHBUNCH_TO_CASHBOX_OUT_LIB_SCAN     = "8";		// 8：出库款箱号扫描                           条码1存放款箱号(现金中心出库配钞渠道 ，对应到网点第2步)
//	// } 这些以后需要删除
	
	public static final String FLOW_STAGE_INITIALIZATION            = "0000";	// 初始状态
	public static final String FLOW_STAGE_DIST_BY_BUNCH             = "2001";	// ATM分捆配钞
	public static final String FLOW_STAGE_DIST_BY_WHOLE_BOX         = "2002";	// ATM整箱配钞
	public static final String FLOW_STAGE_DELIVERY_CASH_BOX         = "2003";	// ATM钞箱配送
	//public static final String FLOW_STAGE_DIST_BY_KXCASH_BOX        = "2004";	// 款箱配钞
	public static final String FLOW_STAGE_DELIVERY_KXCASH_BOX       = "2005";	// 款箱配送
	public static final String FLOW_STAGE_DIST_BY_CASH_BAG          = "2006";	// 人行钞袋配钞
	public static final String FLOW_STAGE_DELIVERY_CASH_BAG         = "2007";	// 人行钞袋配送
	public static final String FLOW_STAGE_CC_RECEIVE_CASHBOX        = "2101"; 	// ATM钞箱回笼接收
	public static final String FLOW_STAGE_CC_RECEIVE_KXCASHBOX      = "2103"; 	// 网点款箱接收
	public static final String FLOW_STAGE_CC_RECEIVE_CASHBAG        = "2105"; 	// 人行钞代接收
	//public static final String FLOW_STAGE_ATM_ADD_CASH              = "3001";	// 离行ATM加钞
	public static final String FLOW_STAGE_ATM_CASHBOX_RETURN        = "3004";	// ATM钞箱回笼
	public static final String FLOW_STAGE_BRANCH_RECEIVE_KXCASHBOX  = "4001"; 	// 网点款箱接收
	public static final String FLOW_STAGE_BRANCH_LARGE_WITHDRAWAL   = "4004"; 	// 网点大额取款
	public static final String FLOW_STAGE_BRANCH_DIST_BY_KXCASH_BOX = "4005"; 	// 网点款箱配钞
	public static final String FLOW_STAGE_BRANCH_KXCASHBOX_RETURN   = "4006"; 	// 网点款箱上缴
	public static final String FLOW_STAGE_BRANCH_ATM_ADD_CASH       = "4007"; 	// 在行ATM加钞
	public static final String FLOW_STAGE_BRANCH_PAY_TO_COUNTER     = "4008"; 	// 交付给柜员
	
	/**
	 * 专业版修改的常量定义
	 */
	public static final String FLOW_STAGE_INITIAL = "0000";//初始状态
	
	public static final String FLOW_STAGE_DIST_BY_CASHBOX = "1001";//款箱钞袋配钞
	public static final String FLOW_STAGE_DIST_BY_ATMBOX = "1002";//ATM钞箱配钞
	
	public static final String FLOW_STAGE_ATM_ADD_CASH = "2001"; // ATM加钞
	
	public static final String FLOW_STAGE_DELIVER_BY_CASH_BOX_INBANK = "3001"; // 行内出库
	public static final String FLOW_STAGE_DELIVER_BY_CASH_BOX_FOROTHERBANK = "3002"; // 同业出库
	public static final String FLOW_STAGE_DELIVER_BY_CASH_BOX_BYPBOC = "3003"; // 人行出库
	
	public static final String FLOW_STAGE_HANG_NEI   = "4001"; // 行内入库
	public static final String FLOW_STAGE_TONG_YE    = "4002"; // 同业入库
	public static final String FLOW_STAGE_REN_HANG   = "4003"; // 人行入库
	
	public static final String FLOW_STAGE_LARGE_WITHDRAW = "5001"; //大额取款
	
	public static final String STATUS_NOT_FINISHED = "0";
	public static final String STATUS_FINISHED     = "1";
	
	public static final String BOX_INFO_INITIAL = "0000";//初始状态
	public static final String BOX_INFO_STATUS_ENBALE = "Y";//启用状态
}
