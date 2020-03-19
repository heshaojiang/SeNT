package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.CmlCounterRecordMsg;
	
	public class CmlCounterRecordDelegate extends DelegateBase
	{
		
		//////////////////////////////////
		
		/**
		 * 
		 */		
		[Command(selector="CmlCounterRecordDelegate:com.grgbanking.sent.transmgr.service.CmlCounterRecordService")]
		public function executeCommandForCmlCounterRecordMsg(msg:CmlCounterRecordMsg):AsyncToken
		{
			trace("CmlCounterRecordDelegate.executeCommandForCmlCounterRecordMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="CmlCounterRecordDelegate:com.grgbanking.sent.transmgr.service.CmlCounterRecordService")]
		public function executeCommandForCmlCounterRecordMsgResultHandler(result:ResultEvent, trigger:CmlCounterRecordMsg):void
		{
			trace("CmlCounterRecordDelegate.executeCommandForCmlCounterRecordMsgResultHandler");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="CmlCounterRecordDelegate:com.grgbanking.sent.transmgr.service.CmlCounterRecordService")]
		public function executeCommandForCmlCounterRecordMsgErrorHandler(fault:FaultEvent, trigger:CmlCounterRecordMsg):void
		{
			trace("CmlCounterRecordDelegate.executeCommandForCmlCounterRecordMsgErrorHandler");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		//////////////////////////////////
	}
}