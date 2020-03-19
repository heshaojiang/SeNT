package platform.term.pm
{
	import platform.layer.BasePM;
	import platform.term.message.NoderInfoMsg;

	
	public class NoderInfoPM extends BasePM
	{
		
		
		
		////////////////////////////////////
		
		/**
		 * 通用方法
		 */
		public function sendNoderInfoMsg(msg:NoderInfoMsg):void
		{
			trace("NoderInfoPM.sendNoderInfoMsg");
			msg.type = "NoderInfoDelegate:com.grgbanking.platform.module.term.service.NoderInfoService";
			sendMessage(msg);
		}
		
		/////////////////////////////////////
		
		
		
		
	}
}