package platform.cashbox.vo
{
	import mx.messaging.channels.StreamingAMFChannel;
	
	import platform.vo.ValueObject;

	[RemoteClass(alias="com.grgbanking.platform.module.cashbox.entity.BoxInfo")]
	[Bindable]
	public class BoxInfoVO extends ValueObject
	{
		public var id:String;
		public var orgid:String;
		public var orgName:String;
		public var orgFullName:String;
		public var boxNum:String;
		public var boxStatus:String;
		public var atmModel:String;
		public var atmBoxTypes:String;
		public var boxType:String;
		public var usageStatus:String;
	}
}