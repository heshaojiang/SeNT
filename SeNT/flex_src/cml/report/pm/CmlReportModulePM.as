package cml.report.pm
{
	import cml.report.message.CmlReportMsg;
	
	import flash.external.ExternalInterface;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.transmgr.vo.CmlTaskInfoVO;

	public class CmlReportModulePM extends BasePM
	{
		[Bindable]
		public var cond:Object = new Object();
		[Bindable]
		public var page:Page = new Page();
		/**
		 * atm编号
		 * */
		[Bindable]
		public  var toatmnum:String;
		[Bindable]
		public var reportPage:Page=new Page();
		[Bindable]
		public  var cmlTask:CmlTaskInfoVO = new CmlTaskInfoVO();
		/**
		 * 加载ATM清分数据
		 * */
		public function loadPage():void
		{
			var msg:CmlReportMsg = new CmlReportMsg();
			msg.type = "findATMReportPage";
			msg.args["page"]=page;
			msg.args["toatmnum"]= cond.toatmnum;
			msg.args["startTime"] = DateFormatter.format(cond.startTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["endTime"] =DateFormatter.format(cond.endTime, "YYYY-MM-DD JJ:NN:SS");
			sendMessage(msg);
		}
		/**
		 * 加载ATM清分数据的回调函数
		 * */
		[MessageHandler(selector="findATMReportPageResult")]
		public function findATMReportPageResult(p_msg:CmlReportMsg):void{
			if(p_msg.result){
				page = p_msg.result as Page;
			}
			
		}
		/**
		 * 导出ATM清分数据
		 * */
		[MessageHandler(selector="exportATMResult")]
		public function exportATMResult(p_msg:CmlReportMsg):void{
			if(p_msg.result){
				var  filaName:String  = p_msg.result.toString();
				ExternalInterface.call("downloadFile",".ImportExcelServlet?fileName=" + filaName);
			}
			
		}
		/**
		 * 对应的交易的所有导入信息
		 * */
		public function loadReportAtm():void
		{
			//根据交易冠字号显示
			var seqMsg:CmlReportMsg = new CmlReportMsg();
			seqMsg.type = "getAllATMInfo";
			reportPage.pageSize=10;
			seqMsg.args["page"] = reportPage;
			seqMsg.args["toatmnum"]=toatmnum;
			sendMessage(seqMsg); 
		}
		/**
		 * 对应的交易的所有导入信息的回调函数
		 * */
		[MessageHandler(selector="getAllATMInfoResult")]
		public function getAllTranResult(p_msg:CmlReportMsg):void
		{
			if(p_msg.result)
				reportPage = p_msg.result as Page;
			
		}
	}
}