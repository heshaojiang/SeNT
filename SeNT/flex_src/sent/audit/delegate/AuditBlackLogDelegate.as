package sent.audit.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.audit.message.AuditBlackLogMsg;

	public class AuditBlackLogDelegate extends DelegateBase
	{
		/**
		 * 加载规则下发明细
		 * */
		[Command(selector="getAuditBlackLogPage")]
		public function getAuditLogPage(p_msg:AuditBlackLogMsg):AsyncToken
		{
			return call("getBlackAuditLogPage",p_msg.args["page"],p_msg.args["deliverStatus"],p_msg.args["startTime"],p_msg.args["endTime"]);
		}
		[CommandResult(selector="getAuditBlackLogPage")]
		public function getAuditLogPageResult(p_result:ResultEvent, trigger:AuditBlackLogMsg):void
		{
			trigger.type = "getAuditBlackLogPageResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 根据申请id查找对应的黑名单规则信息
		 */
		[Command(selector="getBlackRegulationByApplyId")]
		public function getBlackRegulationByApplyId(p_msg:AuditBlackLogMsg):AsyncToken
		{
			return call("getBlackRegulationByRegulation", p_msg.args["applyId"]);
		}
		[CommandResult(selector="getBlackRegulationByApplyId")]
		public function getBlackRegulationByApplyResult(p_result:ResultEvent, trigger:AuditBlackLogMsg):void
		{
			trigger.type = "getBlackRegulationByApplyIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/**
		 *规则下发详情 
		 **/
		[Command(selector="getBlackRegulationDeliverByApplyId")]
		public function getRegulationDeliverByApplyfId(p_msg:AuditBlackLogMsg):AsyncToken
		{
			return call("getRegulationDeliverPage",p_msg.args["page"], p_msg.args["applyId"]);
		}
		[CommandResult(selector="getBlackRegulationDeliverByApplyId")]
		public function getRegulationDeliverByApplyIdResult(p_result:ResultEvent, trigger:AuditBlackLogMsg):void
		{
			trigger.type = "getBlackRegulationDeliverByApplyIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 申请信息
		 */
		
		[Command(selector="getAuditBlackInfo")]
		public function getAuditInfoByApplyId(p_msg:AuditBlackLogMsg):AsyncToken
		{
			return call("getAuditInfo", p_msg.args["applyId"]);
		}
		[CommandResult(selector="getAuditBlackInfo")]
		public function getAuditInfoByApplyIdResult(p_result:ResultEvent, trigger:AuditBlackLogMsg):void
		{
			trigger.type ="getAuditBlackInfoResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		
		
		
		
	}
}