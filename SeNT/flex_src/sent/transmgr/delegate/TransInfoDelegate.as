package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.TransInfoMsg;
	
	public class TransInfoDelegate extends DelegateBase
	{
//		/**
//		 * 根据条件查询交易监控信息
//		 */		
//		[Command(selector="getTranInfoPage")]
//		public function getTranInfoPage(msg:TransInfoMsg):AsyncToken
//		{
//			return call("getTranInfoPage", msg.args["page"], msg.args["transInfo"], 
//				msg.args["startTime"], msg.args["endTime"]);
//		}
//		
//		/**
//		 * 
//		 */
//		[CommandResult(selector="getTranInfoPage")]
//		public function getTranInfoPageResultHandler(p_result:ResultEvent, trigger:TransInfoMsg):void
//		{
//			var msg:TransInfoMsg = new TransInfoMsg();
//			msg.type = "getTranInfoPageResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		
		/**
		 * 根据条件查询交易监控信息
		 */		
		[Command(selector="getTranInfoObject")]
		public function getTranInfoObject(msg:TransInfoMsg):AsyncToken
		{
			return call("getTranInfoObject", msg.args["id"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="getTranInfoObject")]
		public function getTranInfoObjectResult(p_result:ResultEvent, trigger:TransInfoMsg):void
		{
			var msg:TransInfoMsg = new TransInfoMsg();
			msg.type = "getTranInfoObjectResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 根据条件参数路径取值
		 */		
		[Command(selector="getInitParamMap")]
		public function getInitParamMap(msg:TransInfoMsg):AsyncToken
		{
			return call("getInitParamMap");
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="getInitParamMap")]
		public function getInitParamMapResult(p_result:ResultEvent, trigger:TransInfoMsg):void
		{
			var msg:TransInfoMsg = new TransInfoMsg();
			msg.type = "getInitParamMapResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		//////////////////////////////////
		
		/**
		 * 通用方法
		 */		
		[Command(selector="TransInfoDelegate:com.grgbanking.sent.transmgr.service.TranInfoService")]
		public function executeCommandForTransInfoMsg(msg:TransInfoMsg):AsyncToken
		{
			trace("TransInfoDelegate.executeCommandForTransInfoMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 通用方法
		 */
		[CommandResult(selector="TransInfoDelegate:com.grgbanking.sent.transmgr.service.TranInfoService")]
		public function executeCommandForTransInfoMsgResultHandler(result:ResultEvent, trigger:TransInfoMsg):void
		{
			trace("TransInfoDelegate.executeCommandForTransInfoMsgResultHandler");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 通用方法
		 */
		[CommandError(selector="TransInfoDelegate:com.grgbanking.sent.transmgr.service.TranInfoService")]
		public function executeCommandForTransInfoMsgErrorHandler(fault:FaultEvent, trigger:TransInfoMsg):void
		{
			trace("TransInfoDelegate.executeCommandForTransInfoMsgErrorHandler");
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		//////////////////////////////////
	}
}