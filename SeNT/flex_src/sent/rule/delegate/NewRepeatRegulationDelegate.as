package sent.rule.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.rule.message.NewRepeatRegulationMsg;

	public class NewRepeatRegulationDelegate extends DelegateBase
	{
		/**
		 * 查询待审核的黑名单数量
		 * */
		[Command(selector="getRepeatRegulationCount")]
		public function getRepeatRegulationCount(msg:NewRepeatRegulationMsg):AsyncToken
		{
			return call("auditCount");
		}
		[CommandResult(selector="getRepeatRegulationCount")]
		public function getRepeatRegulationCountResultHandler(p_result:ResultEvent, trigger:NewRepeatRegulationMsg):void
		{
			var msg:NewRepeatRegulationMsg = new NewRepeatRegulationMsg();
			msg.type = "getRepeatRegulationCountResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 得到待下发的黑名单规则数量
		 * */
		
		[Command(selector="reliverRepeatRegulationCount")]
		public function reliverRegulationCount(msg:NewRepeatRegulationMsg):AsyncToken
		{
			return call("reliverRegulationCount");
		}
		[CommandResult(selector="reliverRepeatRegulationCount")]
		public function reliverRegulationCountResultHandler(p_result:ResultEvent, trigger:NewRepeatRegulationMsg):void
		{
			var msg:NewRepeatRegulationMsg = new NewRepeatRegulationMsg();
			msg.type = "reliverRepeatRegulationCountResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	
	}
}