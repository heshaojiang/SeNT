package sent.audit.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.audit.message.AuditRepeatInfoMsg;

	public class AuditRepeatInfoDelegate extends DelegateBase
	{
		/**
		 * 申请信息列表
		 * */
		[Command(selector="getRepeatAuditInfoPage")]
		public function getRepeatAuditInfoPage(p_msg:AuditRepeatInfoMsg):AsyncToken
		{
			return call("getRepeatAuditInfoPage", p_msg.args["page"],p_msg.args["vo"],p_msg.args["startTime"],p_msg.args["endTime"]);
		}
		[CommandResult(selector="getRepeatAuditInfoPage")]
		public function getRepeatAuditInfoPageHandleResult(p_result:ResultEvent, trigger:AuditRepeatInfoMsg):void
		{
			trigger.type = "getRepeatAuditInfoPageResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
	
		
	
		
		/**
		 * 查看重号规则信息
		 */
		[Command(selector="getRepeatRegulationByApplyId")]
		public function getRepeatRegulationByApplyId(p_msg:AuditRepeatInfoMsg):AsyncToken
		{
			return call("getRepeatRegulation", p_msg.args["applyId"]);
		}
		[CommandResult(selector="getRepeatRegulationByApplyId")]
		public function getRepeatRegulationByApplyIdResult(p_result:ResultEvent, trigger:AuditRepeatInfoMsg):void
		{
			trigger.type = "getRepeatRegulationByApplyIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		/**
		 * 申请信息
		 */
		
		[Command(selector="getRepeatAuditInfo")]
		public function getAuditInfoByApplyId(p_msg:AuditRepeatInfoMsg):AsyncToken
		{
			return call("getAuditInfo", p_msg.args["applyId"]);
		}
		[CommandResult(selector="getRepeatAuditInfo")]
		public function getAuditInfoByApplyIdResult(p_result:ResultEvent, trigger:AuditRepeatInfoMsg):void
		{
			trigger.type ="getRepeatAuditInfoResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		/**
		 *重号规则审核拒回 更改其状态
		 * 
		 */
		[Command(selector="updateRepeatRegulation")]
		public function updateRepeatRegulation(p_msg:AuditRepeatInfoMsg):AsyncToken
		{
			return call("updateRepeatRegulationStatus", p_msg.args["applyId"]);
		}
		[CommandResult(selector="updateRepeatRegulation")]
		public function updateRepeatRegulationResult(p_result:ResultEvent, trigger:AuditRepeatInfoMsg):void
		{
			trigger.type = "updateRepeatRegulationResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		
		/**记录审核流程
		 * 
		 */
		[Command(selector="addRepeatAuditLog")]
		public function addAuditLog(p_msg:AuditRepeatInfoMsg):AsyncToken
		{
			return call("addAuditLog", p_msg.args["auditLogVO"]);
		}
		[CommandResult(selector="addRepeatAuditLog")]
		public function addAuditLogSuccess(p_result:ResultEvent, trigger:AuditRepeatInfoMsg):void
		{
			trigger.type = "addRepeatAuditLogSuccess";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		
		[Command(selector="getRepeatAuditLogByApplyId")]
		public function getAuditLogByApplyfId(p_msg:AuditRepeatInfoMsg):AsyncToken
		{
			return call("getAuditLogByApplyId", p_msg.args["applyId"]);
		}
		[CommandResult(selector="getRepeatAuditLogByApplyId")]
		public function getAuditLogResult(p_result:ResultEvent, trigger:AuditRepeatInfoMsg):void
		{
			trigger.type = "getRepeatAuditLogByApplyIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		/**
		 *重号规则的审核通过后更改对应的状态
		 */
		
		[Command(selector="updateRepeatRegulationByApplyId")]
		public function updateRepeatStatus(p_msg:AuditRepeatInfoMsg):AsyncToken
		{
			return call("updateRepeatRegulationByApplyId", p_msg.args["applyId"],p_msg.args["regulationStatus"],p_msg.args["reguStatus"]);
		}
		[CommandResult(selector="updateRepeatRegulationByApplyId")]
		public function updateRepeatRegulationByApplyIdResult(p_result:ResultEvent, trigger:AuditRepeatInfoMsg):void
		{
			trigger.type = "updateRepeatRegulationByApplyIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
	}
}