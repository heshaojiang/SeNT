package cml.task.vo
{
	import platform.vo.ValueObject;
	[RemoteClass(alias="com.grgbanking.cml.task.entity.CmlSentInfos")]
	public class CmlSentInfosVO extends ValueObject
	{
		public var id:String;
		public var termid:String;
		public  var journalNo:String;
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
		public var checkResult:String;
		public var createDate:String;
		public var tranId:String;
		public var noteFlag:String;
		public var noteType:String;
		public var moneyType:String;
		public var impFlag:String;
		public var provinceOrgid:String;
		public var orgid:String;
	}
}