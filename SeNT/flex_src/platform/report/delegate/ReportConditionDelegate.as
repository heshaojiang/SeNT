package platform.report.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	import platform.report.message.ReportConditionMsg;
	
	public class ReportConditionDelegate extends DelegateBase
	{
		/**
		 * 获取页信息 
		 */		
		[Command(selector="getPageData")]
		public function getPage(p_msg:ReportConditionMsg):AsyncToken
		{
			return call("getPage", p_msg.args["page"]);
		}
		[CommandResult(selector="getPageData")]
		public function getPageHandler(p_result:ResultEvent, trigger:ReportConditionMsg):void
		{
			trigger.type = "getPageDataResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}

		[Command(selector="save")]
		public function save(p_msg:ReportConditionMsg):AsyncToken{
			return call("save", p_msg.args["vo"]);
		}
		[CommandResult(selector="save")]
		public function saveBackHandler(p_result:ResultEvent, trigger:ReportConditionMsg):void
		{
			trigger.type = "saveResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="delete")]
		public function del(p_msg:ReportConditionMsg):AsyncToken{
			return call("delete", p_msg.args["ids"]);
		}
		[CommandResult(selector="delete")]
		public function deleteHandler(p_result:ResultEvent, trigger:ReportConditionMsg):void{
			trigger.type="deleteResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
	}
}