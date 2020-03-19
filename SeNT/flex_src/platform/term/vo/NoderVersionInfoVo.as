////////////////////////////////////////////////////////////////////////////////
//   Copyright GRGBanking Platform 2011 
//   All rights reserved. 
////////////////////////////////////////////////////////////////////////////////
package platform.term.vo
{
	import platform.vo.ValueObject;
	
	/*import sent.stride.view.StrideImportForm;*/

	[Bindable]
	[RemoteClass(alias="com.grgbanking.platform.module.term.entity.NoderVersionInfo")]
	public class NoderVersionInfoVo extends ValueObject
	{
		public static const TABLE_NAME:String = "NODER_VERSION_INFO";
		
		public var id:String;
		
		public var orgCode:String ;
		
		public var version:String ;
		
		public var packageName:String ;
		
		public var relayVersion:String ;
		
		public var status:String ;
		
		public var createTime:Date;
		
		public var createUserId:String;
		
		public var createUserCode:String;//增加属性
		
		public var checkTime:Date ;  //18620518133
		
		public var checkUserId:String;
		
		public var checkUserCode:String;//增加属性
		
		public var checkNotice:String;
		
		public var remark:String;
		
		public var formType:String;//增加属性
		
		public var orgName:String;//增加属性
		
		public var noderType:String;
		
	}
}