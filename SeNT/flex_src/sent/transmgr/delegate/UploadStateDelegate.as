package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.UploadStateMsg;
	
	public class UploadStateDelegate extends DelegateBase
	{
		/**
		 * 
		 */		
		[Command(selector="UploadStateDelegate:com.grgbanking.sent.transmgr.service.UploadStateService")]
		public function executeCommandForUploadStateMsg(msg:UploadStateMsg):AsyncToken
		{
			trace("UploadStateDelegate.executeCommandForUploadStateMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="UploadStateDelegate:com.grgbanking.sent.transmgr.service.UploadStateService")]
		public function executeCommandForUploadStateMsgResultHandler(result:ResultEvent, trigger:UploadStateMsg):void
		{
			trace("UploadStateDelegate.executeCommandForUploadStateMsgResultHandler");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="UploadStateDelegate:com.grgbanking.sent.transmgr.service.UploadStateService")]
		public function executeCommandForUploadStateMsgErrorHandler(fault:FaultEvent, trigger:UploadStateMsg):void
		{
			trace("UploadStateDelegate.executeCommandForUploadStateMsgResultHandler");
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
	}
}