package sent.rule.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.rule.message.RegulationDeliverMsg;
	
	public class RegulationDeliverDelegate extends DelegateBase
	{
		/**
		 * 根据条件查询交易监控信息
		 */		
		[Command(selector="getRegulationDeliverPage")]
		public function getRegulationDeliverPage(msg:RegulationDeliverMsg):AsyncToken
		{
			return call("getRegulationDeliverPage", msg.args["page"], msg.args["regulationDeliverVO"]);
		}
		[CommandResult(selector="getRegulationDeliverPage")]
		public function getRegulationDeliverPageResultHandler(p_result:ResultEvent, trigger:RegulationDeliverMsg):void
		{
			var msg:RegulationDeliverMsg = new RegulationDeliverMsg();
			msg.type = "getRegulationDeliverPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 *规则下发详情 
		 **/
		[Command(selector="getRegulationDeliverByApplyId")]
		public function getRegulationDeliverByApplyfId(p_msg:RegulationDeliverMsg):AsyncToken
		{
			return call("getRegulationDeliverPage",p_msg.args["page"], p_msg.args["applyId"]);
		}
		[CommandResult(selector="getRegulationDeliverByApplyId")]
		public function getRegulationDeliverByApplyIdResult(p_result:ResultEvent, trigger:RegulationDeliverMsg):void
		{
			trigger.type = "getRegulationDeliverByApplyIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		/**
		 * 根据条件查询规则下发信息
		 */		
		[Command(selector="getRegulationDeliverListByApplyId")]
		public function getRegulationDeliverListByApplyId(msg:RegulationDeliverMsg):AsyncToken
		{
			return call("getRegulationDeliverPage",msg.args["page"],msg.args["applyId"]);
		}
		[CommandResult(selector="getRegulationDeliverListByApplyId")]
		public function getRegulationDeliverListByApplyIdResultHandler(p_result:ResultEvent, trigger:RegulationDeliverMsg):void
		{
			var msg:RegulationDeliverMsg = new RegulationDeliverMsg();
			msg.type = "getRegulationDeliverListByApplyIdResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 根据黑名单规则id获取终端字符串
		 */		
		[Command(selector="getTermStrByApplyId")]
		public function getTermStrByApplyId(msg:RegulationDeliverMsg):AsyncToken
		{
			return call("getTermStrByApplyId",msg.args["applyId"]);
		}
		[CommandResult(selector="getTermStrByApplyId")]
		public function getTermStrByApplyIdResultHandler(p_result:ResultEvent, trigger:RegulationDeliverMsg):void
		{
			var msg:RegulationDeliverMsg = new RegulationDeliverMsg();
			msg.type = "getTermStrByApplyIdResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	
	}
}