package cml.report.delegate
{
	import cml.report.message.CmlReportMsg;
	import cml.report.view.CmlReportModule;
	
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;

	public class CmlReportDelegate extends DelegateBase
	{
		//去后台查找数据
		[Command(selector="findATMReportPage")]
		public function findATMReportPage(msg:CmlReportMsg):AsyncToken
		{
			return call("findATMReportPage", msg.args["page"],msg.args["toatmnum"],msg.args["startTime"], msg.args["endTime"]);
				
		}
		
		[CommandResult(selector="findATMReportPage")]
		public function findATMReportPageHandler(p_result:ResultEvent ,tiggler:CmlReportMsg):void
		{
			tiggler.type = "findATMReportPageResult";
			tiggler.result = p_result.result;
			sendMessage(tiggler);	
		}
		
		//导出数据
		[Command(selector="exportATM")]
		public function exportATM(msg:CmlReportMsg):AsyncToken
		{
			return call("exportATM",msg.args["toatmnum"],msg.args["startTime"], msg.args["endTime"]);
				
		}
		
		[CommandResult(selector="exportATM")]
		public function exportATMHandler(p_result:ResultEvent ,tiggler:CmlReportMsg):void
		{
			tiggler.type = "exportATMResult";
			tiggler.result = p_result.result;
			sendMessage(tiggler);	
		}
		/**
		 * 导出的atm所有信
		 * */
		[Command(selector="getAllATMInfo")]
		public function getAllATMInfo(msg:CmlReportMsg):AsyncToken
		{
			return call("getAllATMInfo",msg.args["page"], msg.args["toatmnum"]);
			
		}
		[CommandResult(selector="getAllATMInfo")]
		public function getAllATMInfoHandler(p_result:ResultEvent ,tiggler:CmlReportMsg):void
		{
			tiggler.type = "getAllATMInfoResult";
			tiggler.result = p_result.result;
			sendMessage(tiggler);	
		}
	}
}