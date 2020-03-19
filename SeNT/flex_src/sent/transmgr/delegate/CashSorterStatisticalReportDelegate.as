package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.events.FaultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.CashSorterStatisticalReportMsg;
	
	public class CashSorterStatisticalReportDelegate extends DelegateBase
	{
		
		/**
		 * 
		 */		
		[Command(selector="CashSorterStatisticalReportDelegate:com.grgbanking.sent.transmgr.service.CmlCashStatisticRecordService")]
		public function executeCommandForCashSorterStatisticalReportMsg(p_msg:CashSorterStatisticalReportMsg):AsyncToken
		{
			trace("CashSorterStatisticalReportDelegate.executeCommandForCashSorterStatisticalReportMsg");
			return call(p_msg.args["remoteMethod"], p_msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="CashSorterStatisticalReportDelegate:com.grgbanking.sent.transmgr.service.CmlCashStatisticRecordService")]
		public function executeCommandForCashSorterStatisticalReportMsgResultHandler(p_result:ResultEvent, p_trigger:CashSorterStatisticalReportMsg):void
		{
			trace("CashSorterStatisticalReportDelegate.executeCommandForCashSorterStatisticalReportMsgResultHandler");
			p_trigger.type = p_trigger.args["resultHandler"];
			p_trigger.result = p_result.result;
			sendMessage(p_trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="CashSorterStatisticalReportDelegate:com.grgbanking.sent.transmgr.service.CmlCashStatisticRecordService")]
		public function executeCommandForCashSorterStatisticalReportMsgErrorHandler(fault:FaultEvent, trigger:CashSorterStatisticalReportMsg):void
		{
			trace("CashSorterStatisticalReportDelegate.executeCommandForCashSorterStatisticalReportMsgErrorHandler");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
	}
}