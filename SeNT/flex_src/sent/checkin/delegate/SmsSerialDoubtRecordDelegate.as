package sent.checkin.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.checkin.message.FaultInfoCheckInMsg;
	
	
	public class SmsSerialDoubtRecordDelegate extends DelegateBase
	{
		/**
		 * 
		 */		
		[Command(selector="SmsSerialDoubtRecordDelegate:com.grgbanking.sent.checkin.service.SmsSerialDoubtRecordService")]
		public function executeCommandForInfoCheckInMsg(msg:FaultInfoCheckInMsg):AsyncToken
		{
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="SmsSerialDoubtRecordDelegate:com.grgbanking.sent.checkin.service.SmsSerialDoubtRecordService")]
		public function executeCommandForInfoCheckInMsgCommandResult(result:ResultEvent, trigger:FaultInfoCheckInMsg):void
		{
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="SmsSerialDoubtRecordDelegate:com.grgbanking.sent.checkin.service.SmsSerialDoubtRecordService")]
		public function executeCommandForInfoCheckInMsgCommandError(fault:FaultEvent, trigger:FaultInfoCheckInMsg):void
		{
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		///////////////////////////////

	
	}
}