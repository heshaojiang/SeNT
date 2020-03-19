package platform.term.pm
{
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.term.message.TermInfoMsg;

	
	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class TermSelectFormPM extends BasePM
	{
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		
		/****/
		[Bindable]
		public var page:Page = new Page(); 			
		
		[Bindable]
		public var condi:Object = new Object();
		
//		public var termidStr:String;
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
//		[Bindable]
//		public var termInfoFormInitDatas:Object = new Object();
		
		[Bindable]
		public var searchBarInitDatas:Object = new Object();
		
		[Init]
		public function init():void
		{
			trace("TermSelectFormPM.init");
			getTermInfoFormInitDatas();
		}
		
		/**批量获取下拉数据源**/
		public function getTermInfoFormInitDatas():void
		{
			trace("TermSelectFormPM.getTermInfoFormInitDatas");
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoFormInitDatas";
			sendMessage(msg);
		}		
		
		/**
		 * 批量获取下拉数据源的回调函数
		 */		
		[MessageHandler(selector="getTermInfoFormInitDatasResult")]
		public function getTermInfoFormInitDatasResult(p_msg:TermInfoMsg):void
		{
			trace("TermSelectFormPM.getTermInfoFormInitDatasResult");
			var result:Object = p_msg.result;
			if(result != null)
			{
//				termInfoFormInitDatas = ObjectUtil.copy(p_msg.result) as Object;
				searchBarInitDatas = result;
			}
		}
		
		/**
		 * delete dataDir
		 */
		public function delTermInfo(p_delItems:Array):void
		{
			trace("TermSelectFormPM.delTermInfo");
			if (p_delItems.length <= 0)
			{
				AlertHandler.alert(LocaleConsts.NO_SELECTED_RECORD);
				//AlertHandler.error("必须选择至少一项!!!");
				return;
			}
			AlertHandler.confirm(closeHandler, null, LocaleConsts.CONFIRM_DELETE);
			//close handler
			function closeHandler(evt:CloseEvent):void
			{
				if (evt.detail == Alert.YES){
					var msg:TermInfoMsg = new TermInfoMsg();
					msg.type = "delete";
					msg.args["ids"] = DataGridUtil.getPropertys("id", p_delItems);
					//记录日志
					msg.logFlag = true;
					msg.menuId = menuId;
					msg.operate = OperationConsts.DEL;
					sendMessage(msg);
				}
			}
		}

		public function getTermInfo(condition:Object):void
		{
			trace("TermSelectFormPM.getTermInfo");
			
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoByTermid";
			page.pageSize=100000;
			msg.args["page"] = page;
			msg.args["condi"] = condition;
			sendMessage(msg);
		}
		
		
		
		/**
		 *获取页结果集
		 */
		public function loadTermInfoPage():void
		{
			trace("TermSelectFormPM.loadTermInfoPage");
			condi["userOrgid"] = UserInfoInit.userInfo["orgid"];
			
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoPage";
			msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集回调函数
		 */
		[MessageHandler(selector="getTermInfoPageResult")]
		public function getTermInfoPageResult(p_msg:TermInfoMsg):void
		{
			trace("TermSelectFormPM.getTermInfoPageResult");
			page = p_msg.result as Page;
		}
		
		/**
		 *通过终端ID获取终端数据结果集
		 */
		public function getTermInfoByTermid(type:int):void
		{
			trace("TermSelectFormPM.getTermInfoByTermid");
			var msg:TermInfoMsg = new TermInfoMsg();
			if (type==0)
			{
				msg.type = "getTermInfoByTermid";
			}
			else
			{
				msg.type = "getTermInfoBySelTermid";
			}
			page.pageSize=100000;
			msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		
		/**
		 * 通过终端ID获取终端数据结果集回调函数
		 */
		[MessageHandler(selector="getTermInfoByTermidResult")]
		public function getTermInfoByTermidResult(p_msg:TermInfoMsg):void
		{
			trace("TermSelectFormPM.getTermInfoByTermidResult");
			page = p_msg.result as Page;
		}		
		
		
		/**
		 *通过下拉框选择条件获取终端数据结果集
		 */
		public function getTermInfoByParms():void
		{
			trace("TermSelectFormPM.getTermInfoByParms");
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoByParams";
			page.pageSize=100000;
			msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		
		/**
		 * 通过下拉框选择条件获取终端数据结果集回调函数
		 */
		[MessageHandler(selector="getTermInfoByParamsResult")]
		public function getTermInfoByParamsResult(p_msg:TermInfoMsg):void
		{
			trace("TermSelectFormPM.getTermInfoByParamsResult");
			page = p_msg.result as Page;
		}
	}
}
