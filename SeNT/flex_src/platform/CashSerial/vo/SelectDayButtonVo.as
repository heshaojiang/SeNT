package platform.CashSerial.vo
{
	import platform.vo.ValueObject;

	[Bindable]
	[RemoteClass(alias="com.grgbanking.platform.module.cashserial.entity.SelectDayButton")]
	public class SelectDayButtonVo extends ValueObject
	{
		public function SelectDayButtonVo()
		{
		}
		
		/*========================================================*/
		/*   Property   
		/*		public var name:String;
		//public var buttonName:String;
		/*========================================================*/
		
		public var bname:String;//增加属性		
		public var isexitst:Boolean;//增加属性
		public var id:String;
		public var buttonCode:String;		
//		public var noteEn:String;
		public var checked:Boolean;
		public var i18nName:String;
		public var buttonType:String;
		public var order:Number = 1;
		public var subSystem:String;
		public var iconURL:String;
	}
}