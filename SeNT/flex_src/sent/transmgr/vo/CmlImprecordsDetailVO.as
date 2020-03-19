package sent.transmgr.vo
{
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlImprecordsDetail")]
	[Bindable]
	public class CmlImprecordsDetailVO 
	{
		public var id:String;
		public var  termId :String;
		public var  fileName:String;
		public var  oldFileName:String;
		public var  operaterId:String;
		public var  operateStatus:String;
		public var  seriaimgFlag:String;
		public var  seriaNum:int;
		public var  operaterDate:String;
		public var  pathcode:String;
		//public var  resovimpRecords:Number;
		public var  tranMonthDay:String;
		public var  jourNo:String;
		public var  orgName:String;
		public var dgSelected:Boolean=false;
		public var tradeDate:String;
		public var businessData1:String;
		public var businessData2:String;
		public var orgCode:String;
		public var getImageFlag:String;
		public var sourceIp:String;
		public var uploadFlag:String;
		
	}
}