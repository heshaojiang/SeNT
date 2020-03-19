package sent.transmgr.vo
{
	import platform.vo.ValueObject;
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.TranInfo")]
	[Bindable]
	public class TransInfoVO extends ValueObject
	{
		
        public var id:String ;
		public var transCode:String;
		public var transOrgid:String;
		public var termId:String;
		public var uploadStatus:String;
		public var accountNo:String;
		public var journalNo:String;
		public var transAmt:Number;
		public var statisAtm:Number;
		
		/** 新增字段 */
		public var tranDate:String;
		public var tranTime:String;
		public var transNotenum:Number; // 交易张数
		public var blackNotenum:Number; // 黑名单张�?�?
		public var repeatNotenum:Number; // 重号张数
		public var callbackNotenum:Number;// 回收张数
    
		public var transResult:String; //交易结果
		
		public var reserve1:String;
	
		

		public var tranMonthday:String;
	
		public var pathcode:String;
		//public var transDateTime:String;
		
		
		
	}
}