package platform.exproperty.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.common.manager.LanguageManager;
	import platform.exproperty.message.ExPropertyMsg;
	import platform.layer.DelegateBase;
	import platform.vo.exproperty.ExtendPropertyVO;

	public class ExPropertyDelegate extends DelegateBase
	{
		/**
		 * 获取页信息 
		 */		
		[Command(selector="getPageData")]
		public function getPageByTableName(p_msg:ExPropertyMsg):AsyncToken
		{
			return call("getPageByTableName", p_msg.args["page"], p_msg.args["table"], LanguageManager.getInstance().currentLanguage);
		}
		[CommandResult(selector="getPageData")]
		public function getPageByTableNameHandler(p_result:ResultEvent, trigger:ExPropertyMsg):void
		{
			trigger.type = "getPageDataResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="save")]
		public function save(p_msg:ExPropertyMsg):AsyncToken{
			return call("save", p_msg.args["vo"], LanguageManager.getInstance().currentLanguage);
		}
		[CommandResult(selector="save")]
		public function saveBackHandler(p_result:ResultEvent, trigger:ExPropertyMsg):void
		{
			trigger.type = "saveResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
	}
}