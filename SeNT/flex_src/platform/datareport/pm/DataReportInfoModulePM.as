package platform.datareport.pm
{
	import flash.external.ExternalInterface;
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.datareport.message.DataReportInfoMsg;
	
	public class DataReportInfoModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		public function loadPage(condition:Object):void{

			
			var msg:DataReportInfoMsg = new DataReportInfoMsg();
			msg.type="getDataReport";
			msg.args["condition"]  = condition;
			sendMessage(msg);
		}
		
		public function exportFile(condition:Object):void
		{
			var msg:DataReportInfoMsg = new DataReportInfoMsg();
			msg.type ="exportDataReport";
			msg.args["condition"]  = condition;
			sendMessage(msg);
		}
		
		[MessageHandler(selector = "exportDataReportResult")]
		public function exportDataReportResultHandler(p_msg:DataReportInfoMsg):void
		{
			if(p_msg.result){
				var fileName:String = p_msg.result.toString();
				ExternalInterface.call("downloadFile",".ImportExcelServlet?fileName="+fileName);
			}
		}

		

	}
}