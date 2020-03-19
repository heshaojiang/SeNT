////////////////////////////////////////////////////////////////////////////////
//   Copyright GRGBanking Platform 2011 
//   All rights reserved. 
////////////////////////////////////////////////////////////////////////////////
package platform.term.vo
{
	import platform.vo.ValueObject;
	
	import sent.stride.view.StrideImportForm;

	[Bindable]
	[RemoteClass(alias="com.grgbanking.platform.module.term.entity.NoderFile")]
	public class NoderFileVo extends ValueObject
	{
		public static const TABLE_NAME:String = "NODER_FILE";
		
		public var formType:String;//增加属性
		
		public var id:String;
		
		public var noderId:String ;
		
		public var orgCode:String ;
		
		public var fileType:String ;
		
		public var tranData:String;
		
		public var operDate:Date;
		
		public var fileName:String;
		
		public var status:String;
		
		public var midLevelIP:String ;
		
	}
}