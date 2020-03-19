package sent.audit.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.audit.message.AuditBlackInfoMsg;
	


	public class AuditBlackInfoDelegate extends DelegateBase
	{
		/**
		 * 申请信息列表
		 * */
		[Command(selector="getBlackAuditInfoPage")]
		public function getBlackAuditInfoPage(p_msg:AuditBlackInfoMsg):AsyncToken
		{
			return call("getBlackAuditInfoPage", p_msg.args["page"],p_msg.args["startTime"],p_msg.args["endTime"]);
		}
		[CommandResult(selector="getBlackAuditInfoPage")]
		public function getBlackAuditInfoPageHandleResult(p_result:ResultEvent, trigger:AuditBlackInfoMsg):void
		{
			trigger.type = "getBlackAuditInfoPageResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 根据申请id查找对应的黑名单规则信息
		 */
		[Command(selector="getBlackRegulationByApplyId")]
		public function getBlackRegulationByApplyId(p_msg:AuditBlackInfoMsg):AsyncToken
		{
			return call("getBlackRegulationByRegulation", p_msg.args["applyId"]);
		}
		[CommandResult(selector="getBlackRegulationByApplyId")]
		public function getBlackRegulationByApplyResult(p_result:ResultEvent, trigger:AuditBlackInfoMsg):void
		{
			trigger.type = "getBlackRegulationByApplyIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		
		
		/**记录审核流程
		 * 
		 */
		[Command(selector="addBlackAuditLog")]
		public function addAuditLog(p_msg:AuditBlackInfoMsg):AsyncToken
		{
			return call("addAuditLog", p_msg.args["auditLogVO"]);
		}
		[CommandResult(selector="addBlackAuditLog")]
		public function addAuditLogSuccess(p_result:ResultEvent, trigger:AuditBlackInfoMsg):void
		{
			trigger.type = "addBlackAuditLogSuccess";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		
		[Command(selector="getBlackAuditLogByApplyId")]
		public function getAuditLogByApplyfId(p_msg:AuditBlackInfoMsg):AsyncToken
		{
			return call("getAuditLogByApplyId", p_msg.args["applyId"]);
		}
		[CommandResult(selector="getBlackAuditLogByApplyId")]
		public function getAuditLogResult(p_result:ResultEvent, trigger:AuditBlackInfoMsg):void
		{
			trigger.type = "getBlackAuditLogByApplyIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 黑名单对应的申请信息
		 */
		[Command(selector="getBlackAuditInfo")]
		public function getAuditInfoByApplyId(p_msg:AuditBlackInfoMsg):AsyncToken
		{
			return call("getAuditInfo", p_msg.args["applyId"]);
		}
		[CommandResult(selector="getBlackAuditInfo")]
		public function getAuditInfoByApplyIdResult(p_result:ResultEvent, trigger:AuditBlackInfoMsg):void
		{
			trigger.type ="getBlackAuditInfoResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 审核黑名单
		 * */
		[Command(selector="auditBlackRegulation")]
		public function auditBlackRegulation(p_msg:AuditBlackInfoMsg):AsyncToken
		{
			return call("auditBlackRegulation", p_msg.args["blackRule"],p_msg.args["auditResult"],p_msg.args["rejectReason"]);
		}
		[CommandResult(selector="auditBlackRegulation")]
		public function auditBlackRegulationResult(p_result:ResultEvent, trigger:AuditBlackInfoMsg):void
		{
			trigger.type = "auditBlackRegulationResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
	}
}