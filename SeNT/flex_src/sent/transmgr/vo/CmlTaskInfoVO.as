package sent.transmgr.vo
{
	import platform.vo.ValueObject;
	
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlTaskInfo")]
	[Bindable]
	public class CmlTaskInfoVO extends ValueObject
	{
		public var id:String;
		public var termId:String;
		public var beforeAmt:Number;
		public var bindStart:Date;
		public var bindEnd:Date;	
		public var journalNo:String;
		public var statisAmt:Number;	
		public var transResult:String;
		public var rotoCashType:String;
		public var uploadFlag:String;
		public var tranDate:String;
		public var partMonthday:String;
		public var pathcode:String;
		public var tranCount:Number;
		
		public var reserve1:String;
		public var tdSourceOrgid:String;
		public var tdDestOrgid:String;
		public var tdOperatorId:String;
		public var tdReserve:String;
		
		// { 额外的属性
		public var atmNum:String;
		public var boxNum:String;
		public var boxCount:Number;
		public var orgCode:String;
		public var pathCodeName:String;
		public var pathCodeFullName:String;
		public var bankName:String;
		public var bankFullName:String;
		public var finacialCode:String;
	}
}