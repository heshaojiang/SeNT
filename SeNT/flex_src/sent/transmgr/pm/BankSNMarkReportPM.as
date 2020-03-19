package sent.transmgr.pm
{
	
	
	
	import platform.layer.BasePM;
	import sent.transmgr.message.BankSNMarkReportMsg;
	
	public class BankSNMarkReportPM extends BasePM
	{
		
		public function sendBankSNMarkReportMsg(p_msg:BankSNMarkReportMsg):void
		{
			p_msg.type = "BankSNMarkReportDelegate:com.grgbanking.sent.transmgr.service.BankSNMarkReportService";
			sendMessage(p_msg);
		}
		
	}
}