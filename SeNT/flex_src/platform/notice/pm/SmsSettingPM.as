// ActionScript file
package platform.notice.pm
{
	import platform.layer.BasePM;
	import platform.notice.message.SmsSettingMsg;
	import platform.notice.vo.SmsSettingVO;
	
	public class SmsSettingPM extends BasePM
	{
		[Bindable]
		public var vo:SmsSettingVO = new SmsSettingVO();
		
		public function save():void{
			var msg:SmsSettingMsg = new SmsSettingMsg();
			msg.type = "save";
			msg.args["vo"] = vo;
			
			//记录日志
			msg.logFlag = true;
			msg.menuId = this.menuId;
			msg.operate = "smsSetting";
			sendMessage(msg);
		}
		
		public function loadSmsSetting():void{
			var msg:SmsSettingMsg = new SmsSettingMsg();
			msg.type = "loadSmsSetting";
			sendMessage(msg);
		}
		
		[MessageHandler(selector="loadSmsSettingResult")]
		public function loadSmsSettingHandler(p_msg:SmsSettingMsg):void{
			vo.fill(p_msg.result);
		}
	}
}