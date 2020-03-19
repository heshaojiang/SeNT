package cml.report.pm
{
	import cml.report.message.CmlReportMsg;
	import cml.report.message.CmlReportTmlMsg;
	
	
	import flash.external.ExternalInterface;
	
	import mx.collections.ArrayCollection;
	
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	public class CmlReportTmlMoudlePM extends BasePM
	{
		
		
		
		
		[Bindable]
		public var conn:Object = new Object();
		
		
		
		[Bindable]
		public var termmodelList:ArrayCollection = new ArrayCollection();
		
		
		[Bindable]
		public var page:Page = new Page();
		
		
		public function loadPage():void{
			var msg:CmlReportTmlMsg  = new CmlReportTmlMsg();
			msg.type = "getCmlReportPage";
			msg.args["page"]  = page;
			msg.args["startTime"] = conn.startTime;
			msg.args["endTime"] =conn.endTime;
			msg.args["tmlNum"] = conn.tmlNum;
			msg.args["devModule"] = conn.devModule;
			sendMessage(msg);
			
		}
		[init]
		public function getTermailByType():void{
			var msg:CmlReportMsg = new CmlReportMsg();
			msg.type= "findByTermtype";
			msg.args["termtype"]= "1";
			sendMessage(msg);
			
		}
		
		
		[MessageHandler(selector="getCmlReportPageResult")]
		public function getCmlReportOperatorPageResult(p_msg:CmlReportTmlMsg):void{
			if(p_msg.result){
				page = p_msg.result as Page;
			}
			
		}
		
		[MessageHandler(selector="findByTermtypeResult")]
		public function getfindByTermtypeResult(p_msg:CmlReportTmlMsg):void{
			if(p_msg.result){
				termmodelList = p_msg.result as ArrayCollection;
			}
			
		}
		//返回文件名，调用service 进行文件处理
		[MessageHandler(selector="cmlreportResult")]
		public function exportCmlReportOperatorResult(p_msg:CmlReportTmlMsg):void{
			if(p_msg.result){
				var  filaName:String    = p_msg.result.toString();
				ExternalInterface.call("downloadFile",".ImportExcelServlet?fileName=" + filaName);
			}
			
		}
		
		
	}
}