package sent.transmgr.vo
{
	import platform.vo.ValueObject;
	
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.TranDetailInfo")]
	[Bindable]
	public class TranDetailInfo extends ValueObject
	{
		public function TranDetailInfo()
		{
			super();
		}
		
		public var tranDate:String;	//交易时间
		public var termCode:String;	//终端号
		public var orgName:String;	//机构名称
		public var tranType:String;	//交易类型
		public var operatorCode:String;	//操作员
		public var tranCount:Number;	//冠字号数
		public var tranAmount:Number;	//交易金额
		public var operType:String;	//业务类型
	}
}