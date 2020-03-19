package sent.transmgr.constants
{
	public class CmlNoteflowDetailInfoConsts
	{
		public static const FLOW_STAGE_PBOC_CASHBAG_ISSUANCE:String     = "1001"; // 人行下发清分中心
		
		public static const FLOW_STAGE_DIST_BY_BUNCH:String             = "2001"; // ATM分捆配钞
		public static const FLOW_STAGE_DIST_BY_WHOLE_BOX:String         = "2002"; // ATM整箱配钞
		public static const FLOW_STAGE_DELIVER_BY_CASH_BOX:String       = "2003"; // ATM钞箱配送
		public static const FLOW_STAGE_DIST_BY_KXCASH_BOX:String        = "2004"; // 款箱配钞
		public static const FLOW_STAGE_DELIVER_BY_KXCASH_BOX:String     = "2005"; // 款箱配送
		public static const FLOW_STAGE_DIST_BY_CASH_BAG:String          = "2006"; // 人行钞袋配钞
		public static const FLOW_STAGE_DELIVER_BY_CASH_BAG:String       = "2007"; // 人行钞袋配送
		
		public static const FLOW_STAGE_CC_RECEIVE_CASHBOX:String        = "2101"; // ATM钞箱回笼接收
		public static const FLOW_STAGE_CC_RECEIVE_KXCASHBOX:String      = "2103"; // 网点款箱接收
		public static const FLOW_STAGE_CC_RECEIVE_CASHBAG:String        = "2105"; // 人行钞袋接收
		
		//public static const FLOW_STAGE_ATM_ADD_CASH:String              = "3001"; // ATM加钞
		public static const FLOW_STAGE_ATM_CASHBOX_RETURN:String        = "3004"; // ATM钞箱回笼
		
		public static const FLOW_STAGE_BRANCH_RECEIVE_KXCASHBOX:String  = "4001"; // 网点款箱接收
		public static const FLOW_STAGE_BRANCH_LARGE_WITHDRAWAL:String   = "4004"; // 网点大额取款
		public static const FLOW_STAGE_BRANCH_DIST_BY_KXCASH_BOX:String = "4005"; // 网点款箱配钞
		public static const FLOW_STAGE_BRANCH_KXCASHBOX_RETURN:String   = "4006"; // 网点款箱上缴
		public static const FLOW_STAGE_BRANCH_ATM_ADD_CASH:String       = "4007"; // 在行ATM加钞
		public static const FLOW_STAGE_BRANCH_PAY_TO_COUNTER:String     = "4008"; // 支付给柜员
		
		
		//==============专业版流转阶段=================//
		//清分类型
		public static const FLOW_TYPE:String = "SysDatadirMgr.sent.cmlMgr.flowType";
		//流转阶段
		public static const FLOW_STAGE:String = "SysDatadirMgr.sent.cmlMgr.flowStage";
		
		// 所处阶段
		public static const  FLOW_STAGE_INITIAL:String = "0000";//初始状态
		
		public static const  FLOW_STAGE_DIST_BY_CASHBOX:String = "1001";//款箱钞袋配钞
		public static const FLOW_STAGE_DIST_BY_ATMBOX:String = "1002";//ATM钞箱配钞
		
		public static const FLOW_STAGE_ATM_ADD_CASH:String = "2001"; // ATM加钞
		
		public static const FLOW_STAGE_DELIVER_BY_CASH_BOX_INBANK:String = "3001"; // 行内出库
		public static const FLOW_STAGE_DELIVER_BY_CASH_BOX_FOROTHERBANK:String = "3002"; // 同业出库
		public static const FLOW_STAGE_DELIVER_BY_CASH_BOX_BYPBOC:String = "3003"; // 人行出库
		
		public static const FLOW_STAGE_HANG_NEI:String   = "4001"; // 行内入库
		public static const FLOW_STAGE_TONG_YE:String   = "4002"; // 同业入库
		public static const FLOW_STAGE_REN_HANG:String    = "4003"; // 人行入库
		
		public static const FLOW_STAGE_LARGE_WITHDRAW:String    = "5001"; // 大额取款
		public static const FLOW_STAGE_DISTRIBUTE_COUNTER:String    = "5002"; // 放发柜员
	}
}