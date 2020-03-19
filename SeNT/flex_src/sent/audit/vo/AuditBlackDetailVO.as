package sent.audit.vo
{
	import platform.vo.ValueObject;

	[RemoteClass(alias="com.grgbanking.sent.audit.entity.AuditBlackDetail")]
	[Bindable]
	public class AuditBlackDetailVO extends ValueObject
	{
			public var id:String;
		 	public var applyId:String;
			public var applyOrgName:String;
			public var regulation:String;
			public var applyDate:Date;
			public var ruleStatus:int;
	}
}