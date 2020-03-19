package sent.audit.vo
{
	[RemoteClass(alias="com.grgbanking.sent.audit.entity.AuditInfoDetail")]
	[Bindable]
	public class AuditInfoDetailVO
	{
		 	public var username:String;
			public var applyType:String;
			public var applayDate:String;
			public var orgName:String;
			public var applyId:String;
			public var dgSelected:Boolean;
	}
}