package cml.cmlConnectInfos.vo
{
	import platform.vo.ValueObject;

	[RemoteClass(alias="com.grgbanking.cml.cmlConnectInfos.entity.CmlConnectInfos")]
	[Bindable]
	public class CmlConnectInfosVO extends ValueObject
	{
		public var id:String;
		public  var connNum:String;
		public  var connMoney:Number;
		public  var comeOrg:String;
		public var toOrg:String;
		public var outPerson:String;
		public var inPerson:String;
		public var connDate:Date;
		public var operateDate:Date;
		public  var operatorId:String;
		public var moneyboxCount:Number;
		public var flag:String;
		public var connAppeal:String;
		public var noAllotMoney:Number;
		public var connMemo:String;
	}
}