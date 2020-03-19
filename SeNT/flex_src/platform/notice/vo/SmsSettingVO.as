package platform.notice.vo
{
	import platform.vo.ValueObject;

	[Bindable]
	public class SmsSettingVO extends ValueObject
	{
		public var sendMethod:String;
		public var encoding:String;
		public var comPort:String;
		public var comBaud:String;
		public var manufacturer:String;
		public var model:String;
		public var contentTemplate:String;
		public var serverIP:String;
		public var serverPort:String;
		public var user:String;
		public var password:String;
		public var ftpDir:String;
		public var ftpFileName:String;
		public var dbType:String;
		public var dbSid:String;
		public var sql:String;
		
		
	}
}