package sent.transmgr.vo
{
	import platform.vo.ValueObject;
	
	import sent.watch.vo.TransBanknoteSeqHourVO;

	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.TransBankNoteSeqAll")]
	[Bindable]
	public class TransBankNoteSeqAllVO 	
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
		public var transYear:String;
		public var tranTime:String;
		//版本
		public var versionNum:String;
		//分行号
		public var provinceOrgId:String;
	
		//交易
		public var tranMonthday:String;
		//终端类型
		public var termType:String;
		//用于区分的类型
		public var isType:String;
		
		//机构的pathCode
		public var pathcode:String;
		public var typeFlag:String;
		public var seriaimgFlag:String;
		//public var transDateTime:String;
		
		
	}
}