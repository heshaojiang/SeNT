package sent.rule.vo
{
	import platform.vo.ValueObject;
	
	[RemoteClass(alias="com.grgbanking.sent.rule.entity.BlackRegulation")]
	[Bindable]
	public class BlackRegulationVO extends ValueObject
	{
		public var id:String;
		public var applyId:String;
		public var applyOrgId:String;
		public var applyDate:Date;
		public var ruleType:int;
		public var ruleStatus:int;
		public var noteType:String;
		public var denomination:String;
		public var regulation:String;
		public var auditDate:Date;
		public var auditId:String;
		public var rejectReason:String;
	}
}