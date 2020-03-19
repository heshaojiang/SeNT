package platform.datareport.delegate
{
	import flash.utils.ByteArray;
	
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	import platform.datareport.message.DataReportInfoMsg;
	
	public class DataReportInfoDelegate extends DelegateBase
	{
		/**
		 * 获取页信息 
		 */		
		[Command(selector="getDataReport")]
		public function getPage(p_msg:DataReportInfoMsg):AsyncToken
		{
			return call("getDataReport",p_msg.args["condition"]);
		}
		[CommandResult(selector="getDataReport")]
		public function getPageHandler(p_result:ResultEvent, trigger:DataReportInfoMsg):void
		{
			trigger.type = "getDataReportResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="exportDataReport")]
		public function exportExcel(p_msg:DataReportInfoMsg):AsyncToken
		{
			return call("exportDataReport",p_msg.args["condition"]);
		}
		[CommandResult(selector="exportDataReport")]
		public function exportDataReportHandler(p_result:ResultEvent, trigger:DataReportInfoMsg):void
		{
			trigger.type = "exportDataReportResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}

	}
	
}