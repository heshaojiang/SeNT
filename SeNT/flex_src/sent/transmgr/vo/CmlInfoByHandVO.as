package sent.transmgr.vo
{
	import platform.vo.ValueObject;
	/**
	 * 手动清分表
	 */
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlInfoByHandList")]
	[Bindable]
	public class CmlInfoByHandVO extends ValueObject
	{
			public var id:String;	
			/** 表单类型 */
		    public var formType:int;
			
			public var orgid:String;
			/** 机构名称 */
			public var orgName:String;
	
	         /** 币种 */
			public var currency:String;
			/**  一百元张数*/
			public var hundredCount:String;
			/** 五十元张数  */
			public var fiftyCount:String;
			/**  二十元张数*/
			public var twentyCount:String;
			/** 十元张数 */
			public var tenCount:String;
			/** 五元张数*/
			public var fiveCount:String;
			/** 一元张数 */
			public var oneCount:String;
			/** 操作人 */
			public var tdOperator:String;
			/** 数据权限控制 */
			public var pathCode:String;
			/** 操作时间 */
			public var tranTime:String;
			/**  交易类型*/
			public var tranType:String;
	
	}
}