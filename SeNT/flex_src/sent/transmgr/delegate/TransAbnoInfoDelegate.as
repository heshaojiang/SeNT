package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.TransAbnoInfoMsg;

	public class TransAbnoInfoDelegate extends DelegateBase
	{
		
		/**
		 * 
		 */		
		[Command(selector="TransAbnoInfoDelegate:com.grgbanking.sent.watch.service.TranAbnoinfoService")]
		public function executeCommandForTransAbnoInfoMsg(msg:TransAbnoInfoMsg):AsyncToken
		{
			trace("TransAbnoInfoDelegate.executeCommandForTransAbnoInfoMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="TransAbnoInfoDelegate:com.grgbanking.sent.watch.service.TranAbnoinfoService")]
		public function executeCommandForTransAbnoInfoMsgResultHandler(result:ResultEvent, trigger:TransAbnoInfoMsg):void
		{
			trace("TransAbnoInfoDelegate.executeCommandForTransAbnoInfoMsgResultHandler");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="TransAbnoInfoDelegate:com.grgbanking.sent.watch.service.TranAbnoinfoService")]
		public function executeCommandForTransAbnoInfoMsgErrorHandler(fault:FaultEvent, trigger:TransAbnoInfoMsg):void
		{
			trace("TransAbnoInfoDelegate.executeCommandForTransAbnoInfoMsgErrorHandler");
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		
	}
}