package sent.transmgr.pm
{
	import platform.layer.BasePM;
	import platform.common.vo.Page;
	import sent.transmgr.message.CashSorterStatisticalReportMsg;
	
	public class CashSorterStatisticalReportPM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		public function sendCashSorterStatisticalReportMsg(p_msg:CashSorterStatisticalReportMsg):void
		{
			p_msg.type = "CashSorterStatisticalReportDelegate:com.grgbanking.sent.transmgr.service.CmlCashStatisticRecordService";
			sendMessage(p_msg);
		}
		
	}
}