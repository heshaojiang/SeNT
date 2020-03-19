package sent.transmgr.vo
{
	import platform.vo.ValueObject;
	
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlImprecords")]
	[Bindable]
	public class CmlImpRecordsVO extends ValueObject
	{
		// { 跟数据库一一对应的属性 
		public var id:String;
		public var termId:String;
		public var fileName:String;
		public var oldFileName:String;
		public var operaterId:String;
		public var operateStatus:String;
		public var seriaimgFlag:String;
		public var seriaNum:int;
		public var operaterDate:String;
		public var pathcode:String;
		public var resovimpRecords:int;
		public var tranMonthDay:String;
		public var jourNo:String;
		public var getImageFlag:String;
		public var sourceIp:String;
		public var uploadFlag:String;
		
		// } 跟数据库一一对应的属性 
		
		// { 额外的属性
		public var bankingOrgCode:String;//金融机构代码
		public var orgCode:String;
		public var pathCodeName:String;
		public var pathCodeFullName:String;
		public var bankName:String;
		public var bankFullName:String;
		public var termTypeDesc:String;
		// } 额外的属性 
	}
}


