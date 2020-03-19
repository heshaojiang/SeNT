package sent.audit.vo
{
	import platform.vo.ValueObject;
	
	[RemoteClass(alias="com.grgbanking.sent.audit.entity.AuditLog")]
	[Bindable]
	public class AuditLogVO extends ValueObject
	{
		public var id:String;
		public var applyId:String;
		public var userid:String;
		public var username:String;
		public var applayDate:Date;
		public var orgid:String;
		public var applyType:String;
		public var applyStatus:String;
		public var applyResult:String;
		public var applyNote:String;
	}
}