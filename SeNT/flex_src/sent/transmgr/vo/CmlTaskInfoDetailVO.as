package sent.transmgr.vo
{
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlTaskInfoDetail")]
	[Bindable]
	public class CmlTaskInfoDetailVO
	{
		public var dgSelected:Boolean;
		public var termId:String;
		public var userName:String;
		public var bindStart:Date;
		public var beforeCount:int;
	
	
		public var totalMoney:int;
		public var orgName:String;
		public var id:String;
		public var oid:String;
		public var uid:String;
		public var pathcode:String;
		
	}
}