package sent.checkin.pm
{		
	import platform.layer.BasePM;
	
	import sent.checkin.message.SmsSerialDoubtMsg;
	

	public class SmsSerialDoubtPM extends BasePM
	{
		 /**
		  * 
		  */
		 public function sendFaultInfoCheckInMsg(msg:SmsSerialDoubtMsg):void
		 {
			 msg.type = "SmsSerialDoubtRecordDelegate:com.grgbanking.sent.checkin.service.SmsSerialDoubtRecordService";
			 sendMessage(msg);
		 }
		 
	}
}





