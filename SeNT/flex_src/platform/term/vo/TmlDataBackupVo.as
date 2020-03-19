package platform.term.vo
{
	import mx.messaging.channels.StreamingAMFChannel;
	
	import platform.vo.ValueObject;

	[RemoteClass(alias="com.grgbanking.platform.module.term.entity.TmlDataBackup")]
	[Bindable]
	public class TmlDataBackupVo extends ValueObject
	{
		public var id:String;
		public var path:String;
		public var createDate:String;
		public var comm:String;
	}
}