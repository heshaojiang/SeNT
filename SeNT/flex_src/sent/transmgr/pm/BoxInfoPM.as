package sent.transmgr.pm
{
	
	
	import platform.cashbox.message.BoxInfoMsg;
	import platform.layer.BasePM;
	
	public class BoxInfoPM extends BasePM
	{
		
		/**
		 * 
		 */
		public function sendBoxInfoMsg(msg:BoxInfoMsg):void
		{
			trace("BoxInfoPM.sendBoxInfoMsg");
			msg.type = "BoxInfoDelegate:com.grgbanking.platform.module.cashbox.service.BoxInfoService";
			sendMessage(msg);
		}
		
		
	}
}