package sent.transmgr.vo
{
	import platform.vo.ValueObject;

	[RemoteClass(alias="com.grgbanking.sent.watch.entity.TranAbnoinfo")]
	[Bindable]
	public class TranAbnoinfoVO extends ValueObject
	{
		
		public var tranMonthday:String;
		public var id:String;
		public var tranId:String;
		public var transCode:String;
		public var transOrgid:String;
		public var termId:String;
		public var tranDate:String;
		public var accountNo:String ;
		public var journalNo:String ;
		public var transAmt:int;
		public var transResult:String ;
		public var transNotenum:int;
		public var blackNotenum:int;
		public var callbackNotenum:int;
		public var repeatNotenum:int;
		public var reserve1:String;
		public var reserve2:String;
		public var reserve3:String;
		public var regulation:String;
		public var abnoType:String;
		public var abnoCallbackType:String;
		public var outCount:int;
		public var inCount:int;
		public var especiseq:String;
		public var especiseqRegulation:String;
		public var cometype:String;
		public var result:String;
		public var note:String;
		public var createDate:String;
		public var anyDate:Date;
		public var pathcode:String;
		public var transOrgName:String;
		public var transOrgFullName:String;
	}
}