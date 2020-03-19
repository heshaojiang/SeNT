package sent.transmgr.pm
{
	import platform.layer.BasePM;
	
	import sent.transmgr.message.UploadStateMsg;
	
	public class UploadStatePM extends BasePM
	{

		public function sendUploadStateMsg(msg:UploadStateMsg):void
		{
			msg.type = "UploadStateDelegate:com.grgbanking.sent.transmgr.service.UploadStateService";
			sendMessage(msg);
		}
	}
}