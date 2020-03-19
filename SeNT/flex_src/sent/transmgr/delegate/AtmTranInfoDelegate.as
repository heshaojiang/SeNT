package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.AtmTranInfoMsg;
	
	public class AtmTranInfoDelegate extends DelegateBase
	{
		
		/**
		 * 
		 */		
		[Command(selector="AtmTranInfoDelegate:com.grgbanking.sent.transmgr.service.AtmTranInfoService")]
		public function executeCommandForAtmTranInfoMsg(msg:AtmTranInfoMsg):AsyncToken
		{
			trace("AtmTranInfoDelegate.executeCommandForAtmTranInfoMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="AtmTranInfoDelegate:com.grgbanking.sent.transmgr.service.AtmTranInfoService")]
		public function executeCommandForAtmTranInfoMsgResultHandler(result:ResultEvent, trigger:AtmTranInfoMsg):void
		{
			trace("AtmTranInfoDelegate.executeCommandForAtmTranInfoMsgResultHandler");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="AtmTranInfoDelegate:com.grgbanking.sent.transmgr.service.AtmTranInfoService")]
		public function executeCommandForAtmTranInfoMsgErrorHandler(fault:FaultEvent, trigger:AtmTranInfoMsg):void
		{
			trace("AtmTranInfoDelegate.executeCommandForAtmTranInfoMsgErrorHandler");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
	}
}