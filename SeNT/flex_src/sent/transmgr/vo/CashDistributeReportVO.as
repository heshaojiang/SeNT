package sent.transmgr.vo
{
	/**
	 * 现金清分统计报表VO
	 */
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlStatisticRecord")]
	[Bindable]
	public class CashDistributeReportVO
	{
		public function CashDistributeReportVO()
		{
		}
		
		/** 所属机构名称 */
		public var orgName:String;
		
		/** 所有的完整钞金额数 */
		public var sumCashAmountFull:String;
		
		/** 所有的残旧钞金额数 */
		public var sumCashAmountOld:String;
		
		/** 清分机清分的100/50币种的完整钞金额数 */
		private var sumCash100AmountFull:String;
		
		/** 清分机清分的20/10币种的完整钞金额数 */
		private var sumCash20AmountFull:String;
		
		/** 清分机清分的5/1币种的完整钞金额数 */
		private var sumCash5AmountFull:String;
		
		/** 清分机清分的100/50币种的残旧钞金额数 */
		private var sumCash100AmountOld:String;
		
		/** 清分机清分的20/10币种的残旧钞金额数 */
		private var sumCash20AmountOld:String;
		
		/** 清分机清分的5/1币种的残旧钞金额数 */
		private var sumCash5AmountOld:String;
		
		/** 清分机清分的完整钞金额总数 */
		private var sumDistrCashAmountFull:String;
		
		/** 清分机清分的残旧钞金额总数 */
		private var sumDistrCashAmountOld:String;
	}
}