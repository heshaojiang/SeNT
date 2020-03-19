package sent.checkin.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.checkin.message.FaultInfoCheckInMsg;
	
	
	public class FaultInfoCheckInDelegate extends DelegateBase
	{
		/**
		 * 
		 */		
		[Command(selector="FaultInfoCheckInDelegate:com.grgbanking.sent.checkin.service.FaultInfoCheckInService")]
		public function executeCommandForInfoCheckInMsg(msg:FaultInfoCheckInMsg):AsyncToken
		{
			trace("FaultInfoCheckInDelegate.executeCommandForInfoCheckInMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="FaultInfoCheckInDelegate:com.grgbanking.sent.checkin.service.FaultInfoCheckInService")]
		public function executeCommandForInfoCheckInMsgCommandResult(result:ResultEvent, trigger:FaultInfoCheckInMsg):void
		{
			trace("FaultInfoCheckInDelegate.executeCommandForInfoCheckInMsgCommandResult");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="FaultInfoCheckInDelegate:com.grgbanking.sent.checkin.service.FaultInfoCheckInService")]
		public function executeCommandForInfoCheckInMsgCommandError(fault:FaultEvent, trigger:FaultInfoCheckInMsg):void
		{
			trace("FaultInfoCheckInDelegate.executeCommandForInfoCheckInMsgCommandError");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		///////////////////////////////

	
	}
}