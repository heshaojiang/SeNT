package sent.rule.vo
{
	import platform.vo.ValueObject;
	
	import sent.transmgr.vo.TransInfoVO;
	
	[RemoteClass(alias="com.grgbanking.sent.rule.entity.SpecialRegulation")]
	[Bindable]
	public class SpecialRegulationVO extends ValueObject
	{
	    public var id:String;
     	public var applyId:String;
		public var orgid:String;
		public var moneyType:String;
		public var moneyDenomination:String;
		public var regulation:String;
		public var source:String;
		public var result:String;
		public var createDate:String;
		public var createName:String;
		public var specialType:String;
	}
}