package sent.transmgr.pm
{
	
	
	import platform.layer.BasePM;
	
	import sent.transmgr.message.CmlCounterRecordMsg;
	import sent.transmgr.message.CmlLoadNotesRecordMsg;
	
	public class CmlCounterRecordPM extends BasePM
	{
		
		/**
		 * 
		 */
		public function sendCmlCounterRecordMsg(msg:CmlCounterRecordMsg):void
		{
			trace("CmlCounterRecordPM.sendCmlCounterRecordMsg");
			msg.type = "CmlCounterRecordDelegate:com.grgbanking.sent.transmgr.service.CmlCounterRecordService";
			sendMessage(msg);
		}
		
	}
}