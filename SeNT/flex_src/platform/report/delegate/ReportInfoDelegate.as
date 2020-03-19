package platform.report.delegate
{
	import flash.utils.ByteArray;
	
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	import platform.report.message.ReportInfoMsg;
	
	public class ReportInfoDelegate extends DelegateBase
	{
		/**
		 * 获取页信息 
		 */		
		[Command(selector="getPageData")]
		public function getPage(p_msg:ReportInfoMsg):AsyncToken
		{
			return call("getPage", p_msg.args["page"], p_msg.args["code"]);
		}
		[CommandResult(selector="getPageData")]
		public function getPageHandler(p_result:ResultEvent, trigger:ReportInfoMsg):void
		{
			trigger.type = "getPageDataResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}

		[Command(selector="loadRoles")]
		public function loadRoles(p_msg:ReportInfoMsg):AsyncToken{
			return call("loadRoles");
		}
		[CommandResult(selector="loadRoles")]
		public function loadRolesHandler(p_result:ResultEvent, trigger:ReportInfoMsg):void{
			trigger.type="loadRolesResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="save")]
		public function save(p_msg:ReportInfoMsg):AsyncToken{
			var file:String = p_msg.args["vo"].file as String;
			var fileData:ByteArray = p_msg.args["vo"].fileData as ByteArray;
			var role:Array = p_msg.args["vo"].role as Array;
			
			return call("save", p_msg.args["vo"], file, fileData, role);
		}
		[CommandResult(selector="save")]
		public function saveBackHandler(p_result:ResultEvent, trigger:ReportInfoMsg):void
		{
			trigger.type = "saveResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="delete")]
		public function del(p_msg:ReportInfoMsg):AsyncToken{
			return call("delete", p_msg.args["ids"]);
		}
		[CommandResult(selector="delete")]
		public function deleteHandler(p_result:ResultEvent, trigger:ReportInfoMsg):void{
			trigger.type="deleteResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
	}
}