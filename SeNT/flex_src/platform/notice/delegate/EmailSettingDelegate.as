package platform.notice.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.common.manager.AlertHandler;
	import platform.layer.DelegateBase;
	import platform.notice.message.EmailSettingMsg;
	
	public class EmailSettingDelegate extends DelegateBase
	{
		[Command(selector="save")]
		public function save(p_msg:EmailSettingMsg):AsyncToken{
			return call("saveEmailSetting", p_msg.args["vo"]);
		}
		[CommandResult(selector="save")]
		public function saveHandler(p_result:ResultEvent, trigger:EmailSettingMsg):void{
			AlertHandler.alert("saveSuccess");
		}
		
		[Command(selector="loadEmailSetting")]
		public function getPageBy(p_msg:EmailSettingMsg):AsyncToken{
			return call("loadEmailSetting");
		}
		[CommandResult(selector="loadEmailSetting")]
		public function loadSuccessHandler(p_result:ResultEvent, trigger:EmailSettingMsg):void{
			trigger.type="loadEmailSettingResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
	}
}