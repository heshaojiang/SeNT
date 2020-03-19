package cml.report.delegate
{
	import cml.report.message.CmlReportOperatorMsg;
	
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	import flash.external.ExternalInterface;
	public class CmlReportOperatorDelegate extends DelegateBase
	{
		
		//去后台查找数据
		[Command(selector="getCmlReportOperatorPage")]
		public function getCmlReportOperatorPage(msg:CmlReportOperatorMsg):AsyncToken
		{
			return call("getTaskInfoPageByOperator", msg.args["page"],msg.args["pro"],
				msg.args["startTime"], msg.args["endTime"]);
		}
		
		[CommandResult(selector="getCmlReportOperatorPage")]
		public function getCmlReportOperatorPageHandler(p_result:ResultEvent ,tiggler:CmlReportOperatorMsg):void
		{
			tiggler.type = "getCmlReportOperatorPageResult";
			tiggler.result = p_result.result;
			sendMessage(tiggler);	
		}
		
		//到后台导出
		
		[Command(selector="exportCmlReportOperator")]
		public function exportCmlReportOperator(msg:CmlReportOperatorMsg):AsyncToken
		{
			return call("exportCmlReportOperator",msg.args["pro"],
				msg.args["startTime"], msg.args["endTime"]);
		}
		
		[CommandResult(selector="exportCmlReportOperator")]
		public function exportCmlReportOperatorHandler(p_result:ResultEvent ,tiggler:CmlReportOperatorMsg):void
		{
			tiggler.type = "exportCmlReportOperatorResult";
			tiggler.result = p_result.result;
			sendMessage(tiggler);	
		}
	}
}