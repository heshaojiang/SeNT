package sent.rule.pm
{
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.layer.BasePM;
	
	import sent.audit.vo.AuditInfoVO;
	import sent.audit.vo.AuditLogVO;
	import sent.rule.constants.BlackRegulationConsts;
	import sent.rule.message.BlackRegulationMsg;
	import sent.rule.message.RegulationDeliverMsg;
	import sent.rule.vo.BlackRegulationVO;
	import sent.rule.vo.RegulationDeliverVO;
	
	public class BlackRegulationFormPM extends BasePM
	{
		/**
		 * 黑名单规则对象
		 * */
		[Bindable]
		public var blackRegulation:BlackRegulationVO = new BlackRegulationVO();
		
		/**
		 * 规则当前状态
		 * */
		public var reguStatus:String;
		
		/**
		 * 当前已选中的终端
		 * */
		[Bindable]
		public var tmpstr:String;
		
		/**原来的VO**/
		public var formerVO:BlackRegulationVO;
		public var former:BlackRegulationVO;
		
		public function set vo(p_vo:BlackRegulationVO):void
		{
			formerVO = p_vo;
			blackRegulation = ObjectUtil.copy(p_vo) as BlackRegulationVO;
			former = ObjectUtil.copy(p_vo) as BlackRegulationVO;
		}
		
		/**
		 * 新增/编辑 提交数据
		 * */
		public function submit(p_operateType:String):void
		{
			//设置规则审核状态为"1.申请中"
			blackRegulation.ruleStatus = BlackRegulationConsts.RULESTATUS_APPLY;
			blackRegulation.applyDate = new Date();
			blackRegulation.applyId = UserInfoInit.userInfo["userCode"];
			blackRegulation.applyOrgId = UserInfoInit.userInfo["orgId"];
			
			var msg:BlackRegulationMsg = new BlackRegulationMsg();
			msg.type = "addBlackRegulation";
			msg.args["blackRegulationVO"] = blackRegulation;
			msg.operate = p_operateType;
			sendMessage(msg);
		}
	
	}
}