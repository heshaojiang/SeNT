package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.TransInfoMsg;
	
	public class TransHourInfoDelegate extends DelegateBase
	{
//		/**
//		 * 根据条件查询交易监控信息
//		 */		
//		[Command(selector="getTransHourInfoPage")]
//		public function getTransHourInfoPage(msg:TransInfoMsg):AsyncToken
//		{
//			return call("getTransHourInfoPage", msg.args["page"], msg.args["transHourInfo"], 
//				msg.args["startTime"], msg.args["endTime"]);
//		}
//		[CommandResult(selector="getTransHourInfoPage")]
//		public function getTransHourInfoPageResultHandler(p_result:ResultEvent, trigger:TransInfoMsg):void
//		{
//			var msg:TransInfoMsg = new TransInfoMsg();
//			msg.type = "getTransHourInfoPageResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		
	}
}