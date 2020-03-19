package sent.audit.vo
{
	import platform.vo.ValueObject;
	
	[RemoteClass(alias="com.grgbanking.sent.audit.entity.AuditInfo")]
	[Bindable]
	public class AuditInfoVO extends ValueObject
	{
		public var auditStatus:String;
		public var orgId:String;
		public var applyName:String;
		public var applayDate:String;
		public var applytyp:String;
		public var id:String;
		public var applyId:String;
		
	}
}