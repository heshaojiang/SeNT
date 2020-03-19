package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.CmlBatchRecordMsg;
	
	public class CmlBatchRecordDelegate extends DelegateBase
	{
		
		//////////////////////////////////
		
		/**
		 * 
		 */		
		[Command(selector="CmlBatchRecordDelegate:com.grgbanking.sent.transmgr.service.CmlBatchRecordService")]
		public function executeCommandForCmlBatchRecordMsg(msg:CmlBatchRecordMsg):AsyncToken
		{
			trace("CmlBatchRecordDelegate.executeCommandForCmlBatchRecordMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="CmlBatchRecordDelegate:com.grgbanking.sent.transmgr.service.CmlBatchRecordService")]
		public function executeCommandForCmlBatchRecordMsgResultHandler(result:ResultEvent, trigger:CmlBatchRecordMsg):void
		{
			trace("CmlBatchRecordDelegate.executeCommandForCmlBatchRecordMsgResultHandler");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="CmlBatchRecordDelegate:com.grgbanking.sent.transmgr.service.CmlBatchRecordService")]
		public function executeCommandForCmlBatchRecordMsgErrorHandler(fault:FaultEvent, trigger:CmlBatchRecordMsg):void
		{
			trace("CmlBatchRecordDelegate.executeCommandForCmlBatchRecordMsgErrorHandler");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		//////////////////////////////////
	}
}