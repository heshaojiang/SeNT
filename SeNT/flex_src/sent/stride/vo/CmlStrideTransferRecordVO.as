////////////////////////////////////////////////////////////////////////////////
//   Copyright GRGBanking Platform 2014 
//   All rights reserved. 
////////////////////////////////////////////////////////////////////////////////
package sent.stride.vo
{
	import platform.vo.ValueObject;

	//如果自动生成注意检查类名是否与后台domain类全路径一致
	[Bindable]
	[RemoteClass(alias="com.grgbanking.sent.stride.entity.StrideTransferRecord")]
	public class CmlStrideTransferRecordVO extends ValueObject
	{
		/* 表单类型 */
		public var formType:String;
		
		/* 唯一标识 */
		public var id:String;
		
																				
		/* C_BAG_CODE:VARCHAR  */
		public var bagCode:String;
		
										
		/* C_FROM_CODE:VARCHAR  */
		public var fromCode:String;
		
										
		/* C_CASH_TYPE:VARCHAR  */
		public var cashType:String;
		
										
		/* C_PATHCODE:VARCHAR  */
		public var pathcode:String;
		
										
		/* C_TRAN_TIME:VARCHAR  */
		public var tranTime:String;
		
										
		/* C_CURRENCY:VARCHAR  */
		public var currency:String;
		
										
		/* I_TD_TRAN_AMT:DECIMAL  */
		public var tdTranAmt:Number;
		
										
		/* C_TRAN_DATE:VARCHAR  */
		public var tranDate:String;
		
										
		/* C_BUSINESS_TYPE:VARCHAR  */
		public var businessType:String;
		
										
		/* I_COUNT:INT  */
		public var count:int;
		
										
		/* C_BANK_CODE:VARCHAR  */
		public var bankCode:String;
		
										
		/* I_VERSION:INT  */
		public var version:int;
		
										
		/* C_RESERVE:VARCHAR  */
		public var reserve:String;
		
				
	}
}