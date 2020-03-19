////////////////////////////////////////////////////////////////////////////////
//   Copyright GRGBanking Platform 2011 
//   All rights reserved. 
////////////////////////////////////////////////////////////////////////////////
package platform.term.vo
{
	import platform.vo.ValueObject;
	
	import sent.stride.view.StrideImportForm;

	[Bindable]
	[RemoteClass(alias="com.grgbanking.platform.module.term.entity.NoderInfo")]
	public class NoderInfoVo extends ValueObject
	{
		public static const TABLE_NAME:String = "NODER_INFO";
		
		public var formType:String;//增加属性
		
		public var id:String;
		
		public var orgCode:String ;
		
		public var version:int ;
		
		public var noderIP:String ;
		
		public var runningStatus:String;
		
		public var statusTime:Date;
		
		public var parameter:String;
		
		public var device:String;
		
		public var installDir:String ;
		
		public var midLevelIP:String ;
		
		public var orgName:String ;
		
		public var infoVersion:String ;
		
		public var noderType:String;
		
	}
}