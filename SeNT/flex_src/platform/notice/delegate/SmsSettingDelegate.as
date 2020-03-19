package platform.notice.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.common.manager.AlertHandler;
	import platform.layer.DelegateBase;
	import platform.notice.message.SmsSettingMsg;
	
	public class SmsSettingDelegate extends DelegateBase
	{
		[Command(selector="save")]
		public function save(p_msg:SmsSettingMsg):AsyncToken{
			return call("saveSmsSetting", p_msg.args["vo"]);
		}
		[CommandResult(selector="save")]
		public function saveHandler(p_result:ResultEvent, trigger:SmsSettingMsg):void{
			AlertHandler.alert("saveSuccess");
		}
		
		[Command(selector="loadSmsSetting")]
		public function getPageBy(p_msg:SmsSettingMsg):AsyncToken{
			return call("loadSmsSetting");
		}
		[CommandResult(selector="loadSmsSetting")]
		public function loadSuccessHandler(p_result:ResultEvent, trigger:SmsSettingMsg):void{
			trigger.type="loadSmsSettingResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
	
	}
}