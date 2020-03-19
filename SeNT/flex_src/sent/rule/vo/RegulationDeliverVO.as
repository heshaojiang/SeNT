package sent.rule.vo
{
	import platform.vo.ValueObject;
	
	[RemoteClass(alias="com.grgbanking.sent.rule.entity.RegulationDeliver")]
	[Bindable]
	public class RegulationDeliverVO extends ValueObject
	{
		public var id:String;
		public var termid:String;
		public var role:String;
		public var version:String;
		public var date:String;
		public var status:String;
		public var applyId:String;
		// 规则类型
		public var type:String;
		// 规则下发时间
		public var deliverDate:String;
		
		// 备份撤销前的规则
		public var note:String;
	}
}