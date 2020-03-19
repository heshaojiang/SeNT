package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.CmlLoadNotesRecordMsg;
	
	public class CmlLoadNotesRecordDelegate extends DelegateBase
	{
		
		//////////////////////////////////
		
		/**
		 * 
		 */		
		[Command(selector="CmlLoadNotesRecordDelegate:com.grgbanking.sent.transmgr.service.CmlLoadNotesRecordService")]
		public function executeCommandForCmlLoadNotesRecordMsg(msg:CmlLoadNotesRecordMsg):AsyncToken
		{
			trace("CmlLoadNotesRecordDelegate.executeCommandForCmlLoadNotesRecordMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="CmlLoadNotesRecordDelegate:com.grgbanking.sent.transmgr.service.CmlLoadNotesRecordService")]
		public function executeCommandForCmlLoadNotesRecordMsgResultHandler(result:ResultEvent, trigger:CmlLoadNotesRecordMsg):void
		{
			trace("CmlLoadNotesRecordDelegate.executeCommandForCmlLoadNotesRecordMsgResultHandler");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="CmlLoadNotesRecordDelegate:com.grgbanking.sent.transmgr.service.CmlLoadNotesRecordService")]
		public function executeCommandForCmlLoadNotesRecordMsgErrorHandler(fault:FaultEvent, trigger:CmlLoadNotesRecordMsg):void
		{
			trace("CmlLoadNotesRecordDelegate.executeCommandForCmlLoadNotesRecordMsgErrorHandler");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		//////////////////////////////////
	}
}