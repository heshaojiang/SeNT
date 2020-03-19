package sent.audit.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.audit.message.AuditBlackLogMsg;
	import sent.audit.message.AuditRepeatLogMsg;

	public class AuditRepeatLogDelegate extends DelegateBase
	{
		
		/**
		 * 审核流程信息
		 * */
		[Command(selector="getRepeatAuditLogPage")]
		public function getAuditLogPage(p_msg:AuditRepeatLogMsg):AsyncToken
		{
			return call("getRepeatAuditLogPage", p_msg.args["page"],p_msg.args["vo"],p_msg.args["startTime"],p_msg.args["endTime"]);
		}
		[CommandResult(selector="getRepeatAuditLogPage")]
		public function getAuditLogPageResult(p_result:ResultEvent, trigger:AuditRepeatLogMsg):void
		{
			trigger.type = "getRepeatAuditLogPageResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		/**
		 *规则下发详情 
		 **/
		[Command(selector="getRepeatRegulationDeliverByApplyId")]
		public function getRegulationDeliverByApplyfId(p_msg:AuditRepeatLogMsg):AsyncToken
		{
			return call("getRegulationDeliverPage",p_msg.args["page"], p_msg.args["applyId"]);
		}
		[CommandResult(selector="getRepeatRegulationDeliverByApplyId")]
		public function getRegulationDeliverByApplyIdResult(p_result:ResultEvent, trigger:AuditRepeatLogMsg):void
		{
			trigger.type = "getRepeatRegulationDeliverByApplyIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 申请信息
		 */
		
		[Command(selector="getRepeatAuditInfo")]
		public function getAuditInfoByApplyId(p_msg:AuditRepeatLogMsg):AsyncToken
		{
			return call("getAuditInfo", p_msg.args["applyId"]);
		}
		[CommandResult(selector="getRepeatAuditInfo")]
		public function getAuditInfoByApplyIdResult(p_result:ResultEvent, trigger:AuditRepeatLogMsg):void
		{
			trigger.type ="getRepeatAuditInfoResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 查看重号规则信息
		 */
		[Command(selector="getRepeatRegulationByApplyId")]
		public function getRepeatRegulationByApplyId(p_msg:AuditRepeatLogMsg):AsyncToken
		{
			return call("getRepeatRegulation", p_msg.args["applyId"]);
		}
		[CommandResult(selector="getRepeatRegulationByApplyId")]
		public function getRepeatRegulationByApplyIdResult(p_result:ResultEvent, trigger:AuditRepeatLogMsg):void
		{
			trigger.type = "getRepeatRegulationByApplyIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		
		
	}
}