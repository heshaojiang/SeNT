// ActionScript file
package platform.notice.pm
{
	import platform.layer.BasePM;
	import platform.notice.message.EmailSettingMsg;
	import platform.notice.vo.EmailSettingVO;
	
	public class EmailSettingPM extends BasePM
	{
		[Bindable]
		public var vo:EmailSettingVO = new EmailSettingVO();
		
		public function save():void{
			var msg:EmailSettingMsg = new EmailSettingMsg();
			msg.type = "save";
			msg.args["vo"] = vo;
			
			//记录日志
			msg.logFlag = true;
			msg.menuId = this.menuId;
			msg.operate = "emailSetting";
			sendMessage(msg);
		}
		
		public function loadEmailSetting():void{
			var msg:EmailSettingMsg = new EmailSettingMsg();
			msg.type = "loadEmailSetting";
			sendMessage(msg);
		}
		
		[MessageHandler(selector="loadEmailSettingResult")]
		public function loadEmailSettingHandler(p_msg:EmailSettingMsg):void{
			vo.fill(p_msg.result);
		}
	}
}