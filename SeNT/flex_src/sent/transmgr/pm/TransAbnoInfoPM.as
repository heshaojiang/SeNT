package sent.transmgr.pm
{
	import platform.layer.BasePM;
	
	import sent.transmgr.message.TransAbnoInfoMsg;

	
	public class TransAbnoInfoPM extends BasePM
	{
		
		/**
		 * 
		 */
		public function sendTransAbnoInfoMsg(msg:TransAbnoInfoMsg):void
		{
			msg.type = "TransAbnoInfoDelegate:com.grgbanking.sent.watch.service.TranAbnoinfoService";
			sendMessage(msg);
		}
		
		
	}
}
