////////////////////////////////////////////////////////////////////////////////
//   Copyright GRGBanking Platform 2011 
//   All rights reserved. 
////////////////////////////////////////////////////////////////////////////////
package platform.CashSerial.vo
{
	import mx.collections.ArrayCollection;
	
	import platform.vo.ValueObject;
	
	[Bindable]
	[RemoteClass(alias="com.grgbanking.platform.module.cashserial.entity.CashSerialToPBOC")]
	public class CashSerialToPBOCVO extends ValueObject
	{
		
		/*========================================================*/
		/*   Constructor                                          */
		/*========================================================*/
		
		public function CashSerialToPBOCVO()
		{
		}
		
		public static const TABLE_NAME:String = "CASH_SERIAL_UPLOAD_CONFIG";
		public var id:String;
		public var selected:Boolean;	//增加属性
		public var isexitst:Boolean;//增加属性
		public var formType:String;//增加属性
		
		public var serverIp:String;
		public var serverPort:String;
		public var serverUsername:String;
		public var serverPassword:String;
		public var serverType:String;
		public var uploadHz:String;
		public var uploadTime:String;
		public var updateTime:String;
		public var handlePerson:String;
		public var taskStatus:String;
		public var serverName:String;
		public var serverPath:String;
		public var uploadValue:String;
		public var dayBtns:ArrayCollection;
		
	}
}