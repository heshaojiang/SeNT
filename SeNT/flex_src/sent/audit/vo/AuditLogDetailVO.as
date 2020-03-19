package sent.audit.vo
{
	
	[RemoteClass(alias="com.grgbanking.sent.audit.entity.AuditLogDetail")]
	[Bindable]
	public class AuditLogDetailVO
	{
		
		public var id:String;
		public var regulation:String;
		public var reguStatus:String;
		public var username:String;
		public var applayDate:Date;
		public var orgid:String;
		public var applyType:String;
		public var applyStatus:String;
		public var dgSelected:Boolean
		public var repeatnum:int;
		public var createname:String;
		public var applyNote:String;
		
	}
}