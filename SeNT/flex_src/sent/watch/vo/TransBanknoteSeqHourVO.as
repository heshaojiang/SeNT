package sent.watch.vo
{
	import platform.vo.ValueObject;
	
	[RemoteClass(alias="com.grgbanking.sent.watch.entity.TransBanknoteSeqHour")]
	[Bindable]
	public class TransBanknoteSeqHourVO extends ValueObject
	{
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
		public var tranTime:String;
		//版本
		public var versionNum:String;
		//分行号
		public var provinceOrgId:String;
		//交易月份
		public var tranMonth:int;
		//交易日
		public var tranDay:int;
	    //终端类型
		public var termType:String;
		public var pathcode:String;
	}
}