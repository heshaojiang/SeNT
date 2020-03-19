package platform.term.pm
{
	import platform.layer.BasePM;
	import platform.term.message.TermInfoMsg;

	
	public class TermInfoPM extends BasePM
	{
		
		
		
		////////////////////////////////////
		
		/**
		 * 通用方法
		 */
		public function sendTermInfoMsg(msg:TermInfoMsg):void
		{
			trace("TermInfoPM.sendTermInfoMsg");
			msg.type = "TermInfoDelegate:com.grgbanking.platform.module.term.service.TermInfoService";
			sendMessage(msg);
		}
		
		/////////////////////////////////////
		
		
		
		
	}
}