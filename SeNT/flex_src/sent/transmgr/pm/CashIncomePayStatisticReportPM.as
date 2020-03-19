package sent.transmgr.pm
{
	import platform.layer.BasePM;
	import platform.common.vo.Page;
	import sent.transmgr.message.CashIncomePayStatictisReportMsg;
	
	public class CashIncomePayStatisticReportPM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		public function sendCashIncomePayStatictisReportMsg(p_msg:CashIncomePayStatictisReportMsg):void
		{
			p_msg.type = "CashIncomePayStatictisRepoetDelegate:com.grgbanking.sent.transmgr.service.CashIncomePayStatisticReportService";
			sendMessage(p_msg);
		}	
			
		}
	
}