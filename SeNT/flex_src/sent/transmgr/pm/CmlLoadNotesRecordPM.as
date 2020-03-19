package sent.transmgr.pm
{
	
	
	import platform.layer.BasePM;
	
	import sent.transmgr.message.CmlLoadNotesRecordMsg;
	
	public class CmlLoadNotesRecordPM extends BasePM
	{
		
		/**
		 * 
		 */
		public function sendCmlLoadNotesRecordMsg(msg:CmlLoadNotesRecordMsg):void
		{
			msg.type = "CmlLoadNotesRecordDelegate:com.grgbanking.sent.transmgr.service.CmlLoadNotesRecordService";
			sendMessage(msg);
		}
		
	}
}