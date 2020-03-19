package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.events.FaultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.BankSNMarkReportMsg;
	
	public class BankSNMarkReportDelegate extends DelegateBase
	{
		
		
		
		/**
		 * 
		 */		
		[Command(selector="BankSNMarkReportDelegate:com.grgbanking.sent.transmgr.service.BankSNMarkReportService")]
		public function executeCommandForBankSNMarkReportMsg(p_msg:BankSNMarkReportMsg):AsyncToken
		{
			trace("BankSNMarkReportDelegate.BankSNMarkReportDelegate");
			return call(p_msg.args["remoteMethod"], p_msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="BankSNMarkReportDelegate:com.grgbanking.sent.transmgr.service.BankSNMarkReportService")]
		public function executeCommandForBankSNMarkReportMsgResultHandler(p_result:ResultEvent, p_trigger:BankSNMarkReportMsg):void
		{
			trace("BankSNMarkReportDelegate.executeCommandForBankSNMarkReportMsgResultHandler");
			p_trigger.type = p_trigger.args["resultHandler"];
			p_trigger.result = p_result.result;
			sendMessage(p_trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="BankSNMarkReportDelegate:com.grgbanking.sent.transmgr.service.BankSNMarkReportService")]
		public function executeCommandForBankSNMarkReportMsgErrorHandler(fault:FaultEvent, trigger:BankSNMarkReportMsg):void
		{
			trace("BankSNMarkReportDelegate.executeCommandForBankSNMarkReportMsgErrorHandler");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
	}
}