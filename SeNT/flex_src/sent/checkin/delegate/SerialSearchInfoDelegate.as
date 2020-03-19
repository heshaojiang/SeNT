package sent.checkin.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.checkin.message.SerialSearchInfoMsg;
	
	public class SerialSearchInfoDelegate extends DelegateBase
	{
		/**
		 * 
		 */		
		[Command(selector="SerialSearchInfoDelegate:com.grgbanking.sent.checkin.service.SerialSearchInfoService")]
		public function executeCommandForSerialSearchInfoMsg(msg:SerialSearchInfoMsg):AsyncToken
		{
			trace("SerialSearchInfoDelegate.executeCommandForSerialSearchInfoMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="SerialSearchInfoDelegate:com.grgbanking.sent.checkin.service.SerialSearchInfoService")]
		public function executeCommandForSerialSearchInfoMsgCommandResult(result:ResultEvent, trigger:SerialSearchInfoMsg):void
		{
			trace("SerialSearchInfoDelegate.executeCommandForSerialSearchInfoMsgCommandResult");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="SerialSearchInfoDelegate:com.grgbanking.sent.checkin.service.SerialSearchInfoService")]
		public function executeCommandForSerialSearchInfoMsgCommandError(fault:FaultEvent, trigger:SerialSearchInfoMsg):void
		{
			trace("SerialSearchInfoDelegate.executeCommandForSerialSearchInfoMsgCommandError");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		///////////////////////////////

	}
}