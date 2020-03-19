package cml.report.delegate
{
	import cml.report.message.CmlReportOperatorMsg;
	import cml.report.message.CmlReportTmlMsg;
	
	import flash.external.ExternalInterface;
	
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;

	public class CmlReportTmlDelegate extends DelegateBase
	{
		[Command(selector="getCmlReportPage")]
		public function getCmlReportPage(p_msg:CmlReportTmlMsg):AsyncToken
		{
			//return call("getCmlReportPage", p_msg.args["page"],p_msg.args["vo"],p_msg.args["startTime"],p_msg.args["endTime"]);
			return call("getCmlReportPage", p_msg.args["page"],p_msg.args["tmlNum"],p_msg.args["startTime"],p_msg.args["endTime"],p_msg.args["devmodule"]);
		}
		[CommandResult(selector="getCmlReportPage")]
		public function getCmlReportPageResult(p_result:ResultEvent, trigger:CmlReportTmlMsg):void
		{
			trigger.type = "getCmlReportPageResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 根据类型查找对应的型号
		 * */
		[Command(selector="findByTermtype")]
		public function findByTermtype(p_msg:CmlReportTmlMsg):AsyncToken
		{
			return call("findByTermtype", p_msg.args["termtype"]);
		}
		[CommandResult(selector="findByTermtype")]
		public function findByTermtypeResult(p_result:ResultEvent, trigger:CmlReportTmlMsg):void
		{
			trigger.type = "findByTermtypeResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 导出EXCEL
		 * */
		
		[Command(selector="cmlreport")]
		public function cmlreport(p_msg:CmlReportTmlMsg):AsyncToken
		{
			return call("cmlreport", p_msg.args["tmlNum"],p_msg.args["startDate"],p_msg.args["endDate"]);
		}
		[CommandResult(selector="cmlreport")]
		public function cmlreportResult(p_result:ResultEvent, trigger:CmlReportTmlMsg):void
		{
			trigger.type = "cmlreportResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
	}
	
}
