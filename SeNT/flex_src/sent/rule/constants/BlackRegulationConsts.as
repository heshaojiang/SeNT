package sent.rule.constants
{
	public class BlackRegulationConsts
	{
		//币种SysDatadirMgr.sent.ruleMgr.currency
		public static const MONEY_TYPE:String = "SysDatadirMgr.sent.ruleMgr.currency";
		//面额
		public static const MONEY_DENOMINATION:String ="SysDatadirMgr.sent.ruleMgr.moneyDenomination";
		
		//规则状态
		public static const RULE_STATUS:String ="SysDatadirMgr.sent.ruleMgr.ruleStatus";
		
	   //新增黑名单规则的KEY
		public static const addBlackRegulation:String ="addBlackRegulation";
	
		/**
		 * 新增
		 * */
		public static const ADD_RULE:String ="addRule";
		
		/**
		 * 编辑
		 * */
		public static const EDIT_RULE:String ="editRule";
		
		/**
		 * 规则状态--申请中
		 * */
		public static const RULESTATUS_APPLY:int = 1;
		
		/**
		 * 规则状态--已通过
		 * */
		public static const RULESTATUS_PASS:int = 2;
		
		/**
		 * 规则状态--已拒绝
		 * */
		public static const RULESTATUS_REFUSE:int = 3;
		
		/**
		 * 规则状态--删除中
		 * */
		public static const RULESTATUS_DELETE:int = 4;
		
	}
}