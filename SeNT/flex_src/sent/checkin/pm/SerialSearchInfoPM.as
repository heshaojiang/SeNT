package sent.checkin.pm
{
	import platform.layer.BasePM;
	
	import sent.checkin.message.SerialSearchInfoMsg;
	
	public class SerialSearchInfoPM extends BasePM
	{
		/**
		 * 
		 */
		public function sendSerialSearchInfoMsg(msg:SerialSearchInfoMsg):void
		{
			trace("SerialSearchInfoPM.sendSerialSearchInfoMsg.");
			msg.type = "SerialSearchInfoDelegate:com.grgbanking.sent.checkin.service.SerialSearchInfoService";
			sendMessage(msg);
		}
	}
}