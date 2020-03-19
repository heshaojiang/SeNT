////////////////////////////////////////////////////////////////////////////////
//   Copyright GRGBanking Platform 2014 
//   All rights reserved. 
////////////////////////////////////////////////////////////////////////////////
package sent.stride.vo
{
	import mx.collections.ArrayCollection;
	
	import platform.vo.ValueObject;

	//如果自动生成注意检查类名是否与后台domain类全路径一致
	[Bindable]
	[RemoteClass(alias="com.grgbanking.sent.stride.entity.StrideImportRecords")]
	public class CmlStrideImportRecordsVO extends ValueObject
	{
		public var selected:Boolean;
		/* 表单类型 */
		public var formType:String;
		
		/* 唯一标识 */
		public var id:String;
		
																				
		/* C_OPERATE_STATUS:VARCHAR  */
		public var operateStatus:String;
		
										
		/* C_OPERATER_ID:VARCHAR  */
		public var operaterId:String;
		
										
		/* C_BAG_CODE:VARCHAR  */
		public var bagCode:String;
		
										
		/* C_UPLOAD_TIME:VARCHAR  */
		public var uploadTime:String;
		
										
		/* C_FILE_NAME:VARCHAR  */
		public var fileName:String;
		
										
		/* I_PARENT_ID:INT  */
		public var parentId:int;
		
										
		/* I_FSN_COUNT:INT  */
		public var fsnCount:int;
		
										
		/* I_BAG_COUNT:INT  */
		public var bagCount:int;
		
										
		/* C_PATHCODE:VARCHAR  */
		public var pathcode:String;
		
		public var orgId:String;
		
		public var children:ArrayCollection;
		public var orgName:String;
		
		public var bankCode:String;
		public var fromCode:String;
		
				
	}
}