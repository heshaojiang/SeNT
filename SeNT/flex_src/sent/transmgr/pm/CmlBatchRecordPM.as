package sent.transmgr.pm
{
	
	
	import platform.layer.BasePM;
	
	import sent.transmgr.message.CmlBatchRecordMsg;
	
	public class CmlBatchRecordPM extends BasePM
	{
		
		/**
		 * 
		 */
		public function sendCmlBatchRecordMsg(msg:CmlBatchRecordMsg):void
		{
			trace("CmlBatchRecordPM.sendCmlBatchRecordMsg");
			msg.type = "CmlBatchRecordDelegate:com.grgbanking.sent.transmgr.service.CmlBatchRecordService";
			sendMessage(msg);
		}
		
	}
}