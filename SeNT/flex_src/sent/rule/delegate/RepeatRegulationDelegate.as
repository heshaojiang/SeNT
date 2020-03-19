package sent.rule.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.rule.message.RepeatRegulationMsg;
	
	public class RepeatRegulationDelegate extends DelegateBase
	{
		/**
		 * 根据条件查询交易监控信息
		 */		
		[Command(selector="getRepeatRegulationPage")]
		public function getRepeatRegulationPage(msg:RepeatRegulationMsg):AsyncToken
		{
			return call("getRepeatRegulationPage", msg.args["page"], msg.args["vo"],  UserInfoInit.userInfo["userCode"]);
		}
		
		[CommandResult(selector="getRepeatRegulationPage")]
		public function getRepeatRegulationPageResultHandler(p_result:ResultEvent, trigger:RepeatRegulationMsg):void
		{
			var msg:RepeatRegulationMsg = new RepeatRegulationMsg();
			msg.type = "getRepeatRegulationPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 重号规则下发之前先更新规则
		 * */
		[Command(selector="updateRepeatRole")]
		public function updateRepeatRole(msg:RepeatRegulationMsg):AsyncToken
		{
			return call("updateBeforeRepeatDeliver", msg.args["repeatList"]);
		}
		[CommandResult(selector="updateRepeatRole")]
		public function updateRepeatRoleResultHandler(p_result:ResultEvent, trigger:RepeatRegulationMsg):void
		{
			var msg:RepeatRegulationMsg= new RepeatRegulationMsg();
			msg.type = "updateRepeatRoleResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 重号规则下发 
		 */
		[Command(selector="repeatDeliver")]
		public function repeatRegulationDeliver(msg:RepeatRegulationMsg):AsyncToken
		{
			return call("deliver", msg.args["repeatList"]);
		}
		[CommandResult(selector="repeatDeliver")]
		public function repeatRegulationDeliverResultHandler(p_result:ResultEvent, trigger:RepeatRegulationMsg):void
		{
			var msg:RepeatRegulationMsg= new RepeatRegulationMsg();
			msg.type = "repeatDeliverResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 增加重号规则下发信息
		 */
		[Command(selector="batchAddRepeatRegulationDeliver")]
		public function batchAddRepeatRegulationDeliver(msg:RepeatRegulationMsg):AsyncToken
		{
			return call("batchAddRegulationDeliver", msg.args["regList"]);
		}
		[CommandResult(selector="batchAddRepeatRegulationDeliver")]
		public function batchAddRepeatRegulationDeliverResultHandler(p_result:ResultEvent, trigger:RepeatRegulationMsg):void
		{
			var msg:RepeatRegulationMsg = new RepeatRegulationMsg();
			msg.type = "batchAddRepeatRegulationDeliverResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 撤销重号规则之前更新规则信息
		 * */
		[Command(selector="updateRepeatRegulatonInfo")]
		public function updateRegulatonInfo(msg:RepeatRegulationMsg):AsyncToken
		{
			return call("updateRegulatonInfo", msg.args["repeatReg"]);
		}
		[CommandResult(selector="updateRepeatRegulatonInfo")]
		public function updateRegulatonInfoHandler(p_result:ResultEvent, trigger:RepeatRegulationMsg):void
		{
			var msg:RepeatRegulationMsg= new RepeatRegulationMsg();
			msg.type = "updateRepeatRegulatonInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 *重号规则撤销 
		 */
		
		[Command(selector="cancelRepeatRegulationDeliver")]
		public function cancelRepeatRegulationDeliver(msg:RepeatRegulationMsg):AsyncToken
		{
			return call("cancleRegu", msg.args["repeatReg"]);
		}
		[CommandResult(selector="cancelRepeatRegulationDeliver")]
		public function cancelRepeatRegulationDeliverResultHandler(p_result:ResultEvent, trigger:RepeatRegulationMsg):void
		{
			var msg:RepeatRegulationMsg = new RepeatRegulationMsg();
			msg.type = "cancelRepeatRegulationDeliverResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 新增重号规则
		 * 
		 */		
		[Command(selector="addRepeatRegulation")]
		public function addRepeatRegulation(msg:RepeatRegulationMsg):AsyncToken
		{
			return call("getNewObject", msg.args["repeatRegulationVO"]);
		}
		[CommandResult(selector="addRepeatRegulation")]
		public function addRepeatRegulationResultHandler(p_result:ResultEvent, trigger:RepeatRegulationMsg):void
		{
			var msg:RepeatRegulationMsg = new RepeatRegulationMsg();
			msg.type = "addRepeatRegulationResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 新增重号规则成功后
		 * 新增审核流程信息和申请信息
		 */		
		[Command(selector="addAuditRepeatRegulation")]
		public function addAuditRepeatRegulation(msg:RepeatRegulationMsg):AsyncToken
		{
			return call("addAuditRepeatRegulation",msg.args["auditInfoVO"], msg.args["auditLogVO"]);
		}
		[CommandResult(selector="addAuditRepeatRegulation")]
		public function addAuditRepeatRegulationResultHandler(p_result:ResultEvent, trigger:RepeatRegulationMsg):void
		{
			var msg:RepeatRegulationMsg = new RepeatRegulationMsg();
			msg.type = "addAuditRepeatRegulationResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}

		
	}
}