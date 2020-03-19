package sent.transmgr.pm
{
	import platform.layer.BasePM;
	import platform.common.vo.Page;
	import sent.transmgr.message.CashDistributeReportMsg;
	
	/**
	 * 现金清分统计报表PM
	 */
	public class CashDistributeReportPM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var conditions:Object = new Object();
		
		/**
		 * 查询现金清分情况
		 */
		public function queryData():void
		{
			var msg:CashDistributeReportMsg = new CashDistributeReportMsg();
			//获取查询条件部的输入数据，并存放到MSG里面
			msg.args["conditions"] = conditions;
			msg.type = "getCmlStatisticRecordReport";
			msg.args["page"] = page;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getCmlStatisticRecordReportResult")]
		public function getCmlStatisticRecordHandler(p_msg:CashDistributeReportMsg):void
		{
			page = p_msg.result as Page;
		}
	}
}