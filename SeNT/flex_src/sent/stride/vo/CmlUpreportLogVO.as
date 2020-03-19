////////////////////////////////////////////////////////////////////////////////
//   Copyright GRGBanking Platform 2014 
//   All rights reserved. 
////////////////////////////////////////////////////////////////////////////////
package sent.stride.vo
{
	import platform.vo.ValueObject;

	//如果自动生成注意检查类名是否与后台domain类全路径一致
	[Bindable]
	[RemoteClass(alias="com.grgbanking.sent.stride.entity.UpreportLog")]
	public class CmlUpreportLogVO extends ValueObject
	{
		/* 表单类型 */
		public var formType:String;
		
		/* 唯一标识 */
		public var id:String;
		
																				
		/* C_MACHINE_TYPE:VARCHAR  */
		public var machineType:String;
		
										
		/* I_CRH_COUNT:INT  */
		public var crhCount:int;
		
										
		/* C_DEVICE_TYPE:VARCHAR  */
		public var deviceType:String;
		
										
		/* C_FILE_NAME:VARCHAR  */
		public var fileName:String;
		
										
		/* C_PATHCODE:VARCHAR  */
		public var pathcode:String;
		
										
		/* C_FROM_CODE:VARCHAR  */
		public var fromCode:String;
		
										
		/* C_CASH_TYPE:VARCHAR  */
		public var cashType:String;
		
										
		/* C_TRAN_TIME:VARCHAR  */
		public var tranTime:String;
		
										
		/* C_BUSINESS_INFORMATION:VARCHAR  */
		public var businessInformation:String;
		
										
		/* C_UPREPORT_TYPE:VARCHAR  */
		public var upreportType:String;
		
										
		/* C_BUSINESS_TYPE:VARCHAR  */
		public var businessType:String;
		
										
		/* C_DEVICE_CODE:VARCHAR  */
		public var deviceCode:String;
		
										
		/* C_START_TIME:VARCHAR  */
		public var startTime:String;
		
										
		/* I_COUNT:INT  */
		public var count:int;
		
										
		/* I_PARENT_ID:INT  */
		public var parentId:int;
		
										
		/* C_END_TIME:VARCHAR  */
		public var endTime:String;
		
										
		/* C_BANK_CODE:VARCHAR  */
		public var bankCode:String;
		
										
		/* I_VERSION:INT  */
		public var version:int;
		
										
		/* C_RESERVE:VARCHAR  */
		public var reserve:String;
		
				
	}
}