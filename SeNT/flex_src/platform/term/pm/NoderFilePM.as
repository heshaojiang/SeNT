package platform.term.pm
{
	import flash.utils.ByteArray;
	
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	import mx.utils.ObjectUtil;
	
	import org.idmedia.as3commons.util.HashMap;
	import org.idmedia.as3commons.util.Map;
	
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.term.vo.NoderFileVo;
	import platform.term.vo.NoderInfoVo;
	import platform.term.message.NoderFileMsg;
	
	
	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class NoderFilePM extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		
		/****/
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var condi:Object = new Object();
		
		[Bindable]
		public var noderFileVo:NoderFileVo ;
		
		[Bindable]
		public var noderInfoVo:NoderInfoVo ;
		
		public var createTimeString:String ;
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		[Bindable]
		public var noderVersionInfoFormInitDatas:Object = new Object();
		
		[Bindable]
		public var searchBarInitDatas:Object = new Object();
		
		[Init]
		public function init():void
		{
			//			getTermInfoFormInitDatas();
		}
		
		public function set vo(p_vo:NoderInfoVo):void
		{
			noderInfoVo = ObjectUtil.copy(p_vo) as NoderInfoVo;
		}
		
		public function get vo():NoderInfoVo{
			return noderInfoVo;
		}
		
		//		/**批量获取下拉数据源**/
		//		public function getTermInfoFormInitDatas():void
		//		{
		//			var msg:NoderFileMsg = new NoderFileMsg();
		//			msg.type = "getTermInfoFormInitDatas";
		//			sendMessage(msg);
		//		}
		//		
		//		
		//		public function save(noderFileVo:NoderFileVo):void
		//		{
		//			trace("NoderFilePM.save") ;
		//			this.noderFileVo = noderFileVo ;
		//			var msg:NoderFileMsg = new NoderFileMsg();
		//			noderFileVo.checkUserId = UserInfoInit.userInfo["id"];
		//			msg.type = "auditRegulation";
		//			msg.args["data"] = noderVersionInfo;
		//			/*msg.logFlag = true;*/
		//			msg.menuId = this.menuId;
		//			sendMessage(msg);
		//			
		//		}
		//		/**save success handler**/
		//		[MessageHandler(selector="saveResult")]
		//		public function saveBackHandler(p_msg:NoderFileMsg):void
		//		{
		//			loadNoderFilePage();
		//		}
		
		
		
		
	}
}