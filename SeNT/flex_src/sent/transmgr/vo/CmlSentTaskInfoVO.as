package sent.transmgr.vo
{
	import flash.utils.ByteArray;
	
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlSentTaskInfo")]
	[Bindable]
	public class CmlSentTaskInfoVO 
	{
		public var tranId:String;
		public var id:String;
		public var termId:String;
		public var journalNo:String;
		public var sequence:Number;
		public var currency:String;
		public var denomination:String;
		public var cashBoxId:String;
		public var seriaNo:String;
		public var pictureName:String;
		public var verifyNo:String;
		public var urlName:String;
		public var transYear:String;
		public var transTime:String;
		public var checkResult:String;
		public var createDate:String;
		public var noteFlag:String;
		public var noteType:String;
		public var moneyType:String;
		public var impFlag:String;
		public var provinceOrgId:String;
		public var orgId:String;
		public var versionNum:String;
		public var isType:String;
		//终端类型
		public var termType:String;
		//机构的pathCode
		public var pathcode:String;
		public var tranMonthday:String;
		public var  seriaNum:Number;
		public var errorCode:String;
		public var machineSno:String;
		public var seriaSureNo:Number;
		public var seriaImgHeight:Number;
		public var seriaImgWidth:Number;
		public var reserve:String;
		public var reserve2:String;
		public var serialSnseq:Number;
		public var urlFilename:String;
		public var seriaimg:String;
		
		public var dgSelected:Boolean;
		
		public var imageArr:ByteArray;
		public var toatmnum:String;
       // public var transDateTime:String;
	}
}