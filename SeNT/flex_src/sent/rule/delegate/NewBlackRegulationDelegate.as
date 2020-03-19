package sent.rule.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.rule.message.NewBlackRegulationMsg;

	public class NewBlackRegulationDelegate extends DelegateBase
	{
		/**
		 * 查询待审核的黑名单数量
		 * */
		[Command(selector="getBlackRegulationCount")]
		public function getBlackRegulationCount(msg:NewBlackRegulationMsg):AsyncToken
		{
			return call("auditCount");
		}
		[CommandResult(selector="getBlackRegulationCount")]
		public function getBlackRegulationCountResultHandler(p_result:ResultEvent, trigger:NewBlackRegulationMsg):void
		{
			var msg:NewBlackRegulationMsg = new NewBlackRegulationMsg();
			msg.type = "getBlackRegulationCountResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 得到待下发的黑名单规则数量
		 * */
		
		[Command(selector="reliverRegulationCount")]
		public function reliverRegulationCount(msg:NewBlackRegulationMsg):AsyncToken
		{
			return call("reliverRegulationCount", UserInfoInit.userInfo["userCode"]);
		}
		[CommandResult(selector="reliverRegulationCount")]
		public function reliverRegulationCountResultHandler(p_result:ResultEvent, trigger:NewBlackRegulationMsg):void
		{
			var msg:NewBlackRegulationMsg = new NewBlackRegulationMsg();
			msg.type = "reliverRegulationCountResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	}
}