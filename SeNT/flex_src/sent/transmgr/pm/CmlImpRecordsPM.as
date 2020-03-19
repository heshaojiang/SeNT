package sent.transmgr.pm
{
	import platform.layer.BasePM;
	
	import sent.transmgr.message.CmlImprecordMsg;

	public class CmlImpRecordsPM extends BasePM
	{
		
		/**
		 * 
		 */
		public function sendCmlImprecordMsg(msg:CmlImprecordMsg):void
		{
			msg.type = "CmlImprecordsDelegate:com.grgbanking.sent.transmgr.service.CmlImprecordsService";
			sendMessage(msg);
		}
	}
}