package sent.rule.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.constants.OperationConsts;
	import platform.layer.DelegateBase;
	
	import sent.rule.message.BlackRegulationMsg;
	
	public class BlackRegulationDelegate extends DelegateBase
	{
		/**
		 * 根据条件查询黑名单规则信息
		 */		
		[Command(selector="getBlackRegulationPage")]
		public function getBlackRegulationPage(msg:BlackRegulationMsg):AsyncToken
		{
			return call("getBlackRegulationPage", msg.args["page"], msg.args["vo"]);
		}
		[CommandResult(selector="getBlackRegulationPage")]
		public function getBlackRegulationPageResultHandler(p_result:ResultEvent, trigger:BlackRegulationMsg):void
		{
			var msg:BlackRegulationMsg = new BlackRegulationMsg();
			msg.type = "getBlackRegulationPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}

		/**
		 * 新增/编辑  黑名单规则
		 */
		[Command(selector="addBlackRegulation")]
		public function addBlackRegulation(msg:BlackRegulationMsg):AsyncToken
		{
			if(msg.operate == OperationConsts.ADD)
				return call("addBlackRegulation", msg.args["blackRegulationVO"]);
			else
				return call("editBlackRegulation", msg.args["blackRegulationVO"]);
		}
		[CommandResult(selector="addBlackRegulation")]
		public function addBlackRegulationResultHandler(p_result:ResultEvent, trigger:BlackRegulationMsg):void
		{
			var msg:BlackRegulationMsg = new BlackRegulationMsg();
			msg.type = "addBlackRegulationResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 删除黑名单规则
		 */
		[Command(selector="deleteBlackRegulation")]
		public function deleteBlackRegulation(msg:BlackRegulationMsg):AsyncToken
		{
			return call("deleteBlackRegulation", msg.args["ids"]);
		}
		[CommandResult(selector="deleteBlackRegulation")]
		public function deleteBlackRegulationResultHandler(p_result:ResultEvent, trigger:BlackRegulationMsg):void
		{
			var msg:BlackRegulationMsg = new BlackRegulationMsg();
			msg.type = "deleteBlackRegulationResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 添加终端下发记录
		 */
		[Command(selector="addBlackRegulationDeliver")]
		public function addBlackRegulationDeliver(msg:BlackRegulationMsg):AsyncToken
		{
			return call("addBlackRegulationDeliver", msg.args["termStr"], UserInfoInit.userInfo["userCode"]);
		}
		[CommandResult(selector="addBlackRegulationDeliver")]
		public function addBlackRegulationDeliverResultHandler(p_result:ResultEvent, trigger:BlackRegulationMsg):void
		{
			var msg:BlackRegulationMsg = new BlackRegulationMsg();
			msg.type = "addBlackRegulationDeliverResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 
		 */		
		[Command(selector="BlackRegulationDelegate:com.grgbanking.sent.rule.service.BlackRegulationService")]
		public function executeCommandForSyncSendToSentServerMsg(msg:BlackRegulationMsg):AsyncToken
		{
			trace("BlackRegulationDelegate:com.grgbanking.sent.rule.service.BlackRegulationService");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="BlackRegulationDelegate:com.grgbanking.sent.rule.service.BlackRegulationService")]
		public function executeCommandForSyncSendToSentServerMsgResultHandler(result:ResultEvent, trigger:BlackRegulationMsg):void
		{
			trace("BlackRegulationDelegate:com.grgbanking.sent.rule.service.BlackRegulationService");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="BlackRegulationDelegate:com.grgbanking.sent.rule.service.BlackRegulationService")]
		public function executeCommandForSyncSendToSentServerMsgErrorHandler(fault:FaultEvent, trigger:BlackRegulationMsg):void
		{
			trace("BlackRegulationDelegate:com.grgbanking.sent.rule.service.BlackRegulationService");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
	}
}