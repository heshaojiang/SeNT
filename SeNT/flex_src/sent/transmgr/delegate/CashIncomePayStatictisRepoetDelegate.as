package sent.transmgr.delegate
{
	import platform.layer.DelegateBase;
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	import sent.transmgr.message.CashIncomePayStatictisReportMsg;
	
	public class CashIncomePayStatictisRepoetDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="cashIncomePayStatisticReportService")]
		public var ro:RemoteObject;
		
		/**
		 * 初始化，注入到基类
		 * 
		 */
		[Init]
		public function init():void
		{
			super._ro = ro;
		}
		/**
		 * 
		 */		
		[Command(selector="CashIncomePayStatictisRepoetDelegate:com.grgbanking.sent.transmgr.service.CashIncomePayStatisticReportService")]
		public function executeCommandForCashIncomePayStatictisReportMsg(p_msg:CashIncomePayStatictisReportMsg):AsyncToken
		{
			trace("CashIncomePayStatictisRepoetDelegate.executeCommandForCashIncomePayStatictisReportMsg");
			return call(p_msg.args["remoteMethod"], p_msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="CashIncomePayStatictisRepoetDelegate:com.grgbanking.sent.transmgr.service.CashIncomePayStatisticReportService")]
		public function executeCommandForCashIncomePayStatictisRepoetResultHandler(p_result:ResultEvent, p_trigger:CashIncomePayStatictisReportMsg):void
		{
			trace("CashIncomePayStatictisRepoetDelegate.executeCommandForCashIncomePayStatictisRepoetResultHandler");
			p_trigger.type = p_trigger.args["resultHandler"];
			p_trigger.result = p_result.result;
			sendMessage(p_trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="CashIncomePayStatictisRepoetDelegate:com.grgbanking.sent.transmgr.service.CashIncomePayStatisticReportService")]
		public function executeCommandForCashIncomePayStatictisRepoetErrorHandler(fault:FaultEvent, trigger:CashIncomePayStatictisReportMsg):void
		{
			trace("CashIncomePayStatictisRepoetDelegate.executeCommandForCashIncomePayStatictisRepoetErrorHandler");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
	
	}
}