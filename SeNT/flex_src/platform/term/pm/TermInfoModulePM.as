package platform.term.pm
{
	import flash.utils.ByteArray;
	
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.term.message.TermInfoMsg;

	
	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class TermInfoModulePM extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		
		/****/
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var condi:Object = new Object();
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		[Bindable]
		public var termInfoFormInitDatas:Object = new Object();
		
		[Bindable]
		public var searchBarInitDatas:Object = new Object();
		
		[Init]
		public function init():void
		{
			//loadTermInfoPage();
			getTermInfoFormInitDatas();
		}
		
		/**批量获取下拉数据源**/
		public function getTermInfoFormInitDatas():void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoFormInitDatas";
			sendMessage(msg);
		}
		
		/**save success handler**/
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:TermInfoMsg):void
		{
			loadTermInfoPage();
		}
		
		/**
		 * delete dataDir
		 * */
		public function delTermInfo(p_delItems:Array):void
		{
			if (p_delItems.length <= 0){
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
		
		/**
		 * 删除返回结果处理函数
		 */		
		[MessageHandler(selector="delResult")]
		public function delBackHandler(p_msg:TermInfoMsg):void
		{
			loadTermInfoPage();
		}
		
		/**
		 * search DataDir Paging
		 * */
		public function loadTermInfoPage():void
		{
			condi["userOrgid"] = UserInfoInit.userInfo["orgId"];
			//orgid
			if(condi["userOrgid"]==null || condi["userOrgid"]==""){
				//condi["userOrgid"] = orgid.selectedValue;
			}
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoPage";
			msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		
		/**
		 * search DataDir Paging
		 * */
		public function export(isPrintTemplate:int):void
		{
			condi["userOrgid"] = UserInfoInit.userInfo["orgId"];
			condi["isPrintTemplate"] = isPrintTemplate+"";
			//orgid
			if(condi["userOrgid"]==null || condi["userOrgid"]==""){
				//condi["userOrgid"] = orgid.selectedValue;
			}
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "exportTermInfo";
			//msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		
		/**
		 * 同步发送
		 * */
		public function syncSendToSentServerTesttt():void
		{
		
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "syncSendToSentServer";
			//msg.args["page"] = page;
			msg.args["synchType"] = 1;
			sendMessage(msg);
		}
		
		/**
		 * 同步发送的回调函数
		 */		
		[MessageHandler(selector="syncSendToSentServerResult")]
		public function syncSendToSentServeTestttHandler(p_msg:TermInfoMsg):void
		{
			var result:Object = p_msg.result;
			var returnResult:int=1;
			if(result != null){
				returnResult = ObjectUtil.copy(p_msg.result) as int;
				if(returnResult == 2){
					Alert.show("同步失败!");
				}else{
					Alert.show("同步成功!");
				}
			}
			
		}
		
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getTermInfoPageResult")]
		public function getPageHandler(p_msg:TermInfoMsg):void
		{
			page = p_msg.result as Page;
		}
		
		/**
		 * 批量获取下拉数据源的回调函数
		 */		
		[MessageHandler(selector="getTermInfoFormInitDatasResult")]
		public function getTermInfoFormInitDatasBackHandler(p_msg:TermInfoMsg):void
		{
			var result:Object = p_msg.result;
			if(result != null){
				termInfoFormInitDatas = ObjectUtil.copy(p_msg.result) as Object;
				searchBarInitDatas = result;
			}
			
		}
		
		/**
		 * 导入Excel
		 * @param p_fileData
		 * 
		 */		
		public function importTermInfoExcel(p_fileData:ByteArray):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "importTermInfoExcel";	// java: "importTermInfoExcel", result: "importTermInfoExcelResult"
			msg.args["bytes"] = p_fileData;
			sendMessage(msg);
		}
		
		/**
		 * refresh the layout if it was completed of import some org.
		 */		
		[MessageHandler(selector="importTermInfoExcelResult")]
		public function importExcelResultHandler(p_msg:TermInfoMsg):void
		{
			if (p_msg.result)
			{
				var msg:String = LanguageManager.getInstance().getCommonLocleValue("Msg", "importFail").toString();
				AlertHandler.alert(msg + p_msg.result.toString());				
				loadTermInfoPage();
			}
			else
			{
				AlertHandler.alert(LanguageManager.getInstance().getCommonLocleValue("Msg", "importSuccess").toString());				
				loadTermInfoPage();
			}
		}
		
		//根据冠字号记录，查询终端设备
		public function getTermInfoById(p_msg:TermInfoMsg):void{
			
			p_msg.type = "TermInfoDelegate:com.grgbanking.platform.module.term.service.TermInfoService";
			sendMessage(p_msg);
		}
		
		/**
		 * 
		 * */
		public function getTermInfoForPrint(termCode:String):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoForPrint";	
			msg.args["termCode"] = termCode;
			sendMessage(msg);
		}
	}
}