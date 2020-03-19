package sent.checkin.pm
{		
	import platform.layer.BasePM;
	
	import sent.checkin.message.FaultInfoCheckInMsg;

	public class FaultInfoCheckInPM extends BasePM
	{
		 /**
		  * 
		  */
		 public function sendFaultInfoCheckInMsg(msg:FaultInfoCheckInMsg):void
		 {
			 trace("FaultInfoCheckInPM.sendFaultInfoCheckInMsg.");
			 msg.type = "FaultInfoCheckInDelegate:com.grgbanking.sent.checkin.service.FaultInfoCheckInService";
			 sendMessage(msg);
		 }
		 
	}
}





