package sent.transmgr.delegate
{
	import platform.layer.DelegateBase;
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	import sent.transmgr.message.CashDistributeReportMsg;
	/**
	 * 现金清分统计报表
	 */
	public class CashDistributeReportDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="cashDistributeReportService")]
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
		 * 获取现金清分情况的请求
		 * 异步调用
		 */
		[Command(selector="getCmlStatisticRecordReport")]
		public function getCmlStatisticRecordReport(p_msg:CashDistributeReportMsg):AsyncToken
		{
			return call("getCmlStatisticRecordReport", p_msg.args["page"], p_msg.args["conditions"]);
		}
		
		/** 
		 * 获取现金清分情况的响应
		 * 
		 **/
		[CommandResult(selector="getCmlStatisticRecordReport")] 
		public function getCmlStatisticRecordReportResultHandler(p_result:ResultEvent, 
			trigger:CashDistributeReportMsg):void
		{
			var msg:CashDistributeReportMsg = new CashDistributeReportMsg();
			msg.type = "getCmlStatisticRecordReportResult";
			msg.result= p_result.result;
			sendMessage(msg);
		}
	}
}