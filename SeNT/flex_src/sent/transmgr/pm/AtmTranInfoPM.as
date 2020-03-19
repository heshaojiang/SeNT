package sent.transmgr.pm
{
	
	import platform.layer.BasePM;
	
	import sent.transmgr.message.AtmTranInfoMsg;

	
	public class AtmTranInfoPM extends BasePM
	{
		
		public function sendAtmTranInfoMsg(msg:AtmTranInfoMsg):void
		{
			trace("AtmTranInfoPM.sendAtmTranInfoMsg");
			msg.type = "AtmTranInfoDelegate:com.grgbanking.sent.transmgr.service.AtmTranInfoService";
			sendMessage(msg);
		}
		
	}
}





