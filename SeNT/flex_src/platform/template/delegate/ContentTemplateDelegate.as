package platform.template.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.template.message.ContentTemplateMsg;
	
	public class ContentTemplateDelegate extends DelegateBase
	{
		/**
		 * 获取页信息 
		 */		
		[Command(selector="getPageData")]
		public function getPageByType(p_msg:ContentTemplateMsg):AsyncToken
		{
			return call("getPageByType", p_msg.args["page"], p_msg.args["type"]);
		}
		[CommandResult(selector="getPageData")]
		public function getPageByTypeHandler(p_result:ResultEvent, trigger:ContentTemplateMsg):void
		{
			trigger.type = "getPageDataResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="save")]
		public function save(p_msg:ContentTemplateMsg):AsyncToken{
			return call("save", p_msg.args["vo"]);
		}
		[CommandResult(selector="save")]
		public function saveBackHandler(p_result:ResultEvent, trigger:ContentTemplateMsg):void
		{
			trigger.type = "saveResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="delete")]
		public function del(p_msg:ContentTemplateMsg):AsyncToken{
			return call("delete", p_msg.args["ids"]);
		}
		[CommandResult(selector="delete")]
		public function deleteHandler(p_result:ResultEvent, trigger:ContentTemplateMsg):void{
			trigger.type="deleteResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
	}
}