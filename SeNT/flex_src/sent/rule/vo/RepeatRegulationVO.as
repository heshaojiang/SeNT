package sent.rule.vo
{
	import platform.vo.ValueObject;
	
	[RemoteClass(alias="com.grgbanking.sent.rule.entity.RepeatRegulation")]
	[Bindable]
	public class RepeatRegulationVO extends ValueObject
	{
		public var id:String;
		public var repeatnum:int;
		public var dealwithMode:String;
		public var logMode:String;
		public var creenMode:String;
		public var enterAccountMode:String;
		public var regulationStatus:String;
		public var termtype:String;
		public var createDate:Date;
		public var createName:String;
		public var reversionDate:Date;
		public var reversionName:String;
		public var applyId:String;
		public var model:String;
		// 新增字段
		public var termNum:int;
		
		//规则下发状态
		public var reguStatus:String;
	}
}