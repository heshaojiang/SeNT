package cml.report.pm
{
	
	
	import cml.report.message.CmlReportOperatorMsg;
	import cml.report.vo.CmlReportOperatorVO;
	
	import flash.events.Event;
	import flash.external.ExternalInterface;
	import flash.net.FileReference;
	
	import mx.messaging.channels.StreamingAMFChannel;
	import mx.rpc.events.ResultEvent;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	public class CmlReportOperatorModulePM extends BasePM
	{	
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public  var cmlReportOperator:CmlReportOperatorVO = new CmlReportOperatorVO();
		
		[Bindable]
		public var cond:Object = new Object();
		
	
		public function loadPage():void
		{
				var msg:CmlReportOperatorMsg = new CmlReportOperatorMsg();
				msg.type = "getCmlReportOperatorPage";
				msg.args["pro"]  = cond.pro;
				msg.args["startTime"] = cond.startTime;
				msg.args["endTime"] =cond.endTime;
				msg.args["page"] =page;
				sendMessage(msg);
		}
		[MessageHandler(selector="getCmlReportOperatorPageResult")]
		public function getCmlReportOperatorPageResult(p_msg:CmlReportOperatorMsg):void{
			if(p_msg.result){
				page = p_msg.result as Page;
			}
			
		}
		
		[MessageHandler(selector="exportCmlReportOperatorResult")]
		public function exportCmlReportOperatorResult(p_msg:CmlReportOperatorMsg):void{
			if(p_msg.result){
				var  filaName:String    = p_msg.result.toString();
				ExternalInterface.call("downloadFile",".ImportExcelServlet?fileName=" + filaName);
			}
			
		}
		

		}
		
	}
