package sent.watch.vo
{
	import sent.watch.vo.TransBanknoteSeqHourVO;
	
	[RemoteClass(alias="com.grgbanking.sent.watch.entity.TransBanknoteSeqInfo")]
	[Bindable]
	public class TransBanknoteSeqInfoVO 
	{
		public var dgSelected:Boolean;
		public var checkResult:String;
		public var createDate:String;
		public var tranId:String;
		public var noteFlag:String;
		public var noteType:String;
		public var id:String;
		public var termId:String;
		public var journalNo:String;
		public var sequence:int;
		public var currency:String;
		public var denomination:String;
		public var cashBoxId:String;
		public var seriaNo:String;
		public var pictureName:String;
		public var verifyNo:String;
		public var urlName:String;
		public var transDate:String;
		public var transTime:String;
		//版本
		public var versionNum:String;
		//分行号
		public var provinceOrgId:String;
		//交易月份
		public var tranMonthDay:String ;
		//交易日
		public var transYear:String;
		//终端类型
		public var termType:String;
		//用于区分的类型
		public var isType:String;
		//机构的pathcode
		public var pathcode:String;
		//public var transDateTime:String;
	}
}