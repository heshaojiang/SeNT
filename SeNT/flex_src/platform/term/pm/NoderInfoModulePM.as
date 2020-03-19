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
	import platform.term.message.NoderInfoMsg;

	
	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class NoderInfoModulePM extends BasePM
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
		public var noderInfoFormInitDatas:Object = new Object();
		
		[Bindable]
		public var searchBarInitDatas:Object = new Object();
		
		[Init]
		public function init():void
		{
			//loadNoderInfoPage();
			getNoderInfoFormInitDatas();
		}
		
		/**批量获取下拉数据源**/
		public function getNoderInfoFormInitDatas():void
		{
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "getNoderInfoFormInitDatas";
			sendMessage(msg);
		}
		
		/**save success handler**/
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:NoderInfoMsg):void
		{
			loadNoderInfoPage();
		}
		
		/**
		 * delete dataDir
		 * */
		public function delNoderInfo(p_delItems:Array):void
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
					var msg:NoderInfoMsg = new NoderInfoMsg();
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
		public function delBackHandler(p_msg:NoderInfoMsg):void
		{
			loadNoderInfoPage();
		}
		
		/**
		 * search DataDir Paging
		 * */
		public function loadNoderInfoPage():void
		{
			condi["userOrgid"] = UserInfoInit.userInfo["orgId"];
			//orgid
			if(condi["userOrgid"]==null || condi["userOrgid"]==""){
				//condi["userOrgid"] = orgid.selectedValue;
			}
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "getNoderInfoPage";
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
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "exportNoderInfo";
			//msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		
		/**
		 * 同步发送
		 * */
		public function syncSendToSentServerTesttt():void
		{
		
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "syncSendToSentServer";
			//msg.args["page"] = page;
			msg.args["synchType"] = 1;
			sendMessage(msg);
		}
		
		/**
		 * 同步发送的回调函数
		 */		
		[MessageHandler(selector="syncSendToSentServerResult")]
		public function syncSendToSentServeTestttHandler(p_msg:NoderInfoMsg):void
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
		[MessageHandler(selector="getNoderInfoPageResult")]
		public function getPageHandler(p_msg:NoderInfoMsg):void
		{
			page = p_msg.result as Page;
		}
		
		/**
		 * 批量获取下拉数据源的回调函数
		 */		
		[MessageHandler(selector="getNoderInfoFormInitDatasResult")]
		public function getNoderInfoFormInitDatasBackHandler(p_msg:NoderInfoMsg):void
		{
			var result:Object = p_msg.result;
			if(result != null){
				noderInfoFormInitDatas = ObjectUtil.copy(p_msg.result) as Object;
				searchBarInitDatas = result;
			}
			
		}
		
		/**
		 * 导入Excel
		 * @param p_fileData
		 * 
		 */		
		public function importNoderInfoExcel(p_fileData:ByteArray):void
		{
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "importNoderInfoExcel";	// java: "importNoderInfoExcel", result: "importNoderInfoExcelResult"
			msg.args["bytes"] = p_fileData;
			sendMessage(msg);
		}
		
		/**
		 * refresh the layout if it was completed of import some org.
		 */		
		[MessageHandler(selector="importNoderInfoExcelResult")]
		public function importExcelResultHandler(p_msg:NoderInfoMsg):void
		{
			if (p_msg.result)
			{
				var msg:String = LanguageManager.getInstance().getCommonLocleValue("Msg", "importFail").toString();
				AlertHandler.alert(msg + p_msg.result.toString());				
				loadNoderInfoPage();
			}
			else
			{
				AlertHandler.alert(LanguageManager.getInstance().getCommonLocleValue("Msg", "importSuccess").toString());				
				loadNoderInfoPage();
			}
		}
		
		//根据冠字号记录，查询终端设备
		public function getNoderVersionInfoById(p_msg:NoderInfoMsg):void{
			
			p_msg.type = "NoderVersionInfoDelegate:com.grgbanking.platform.module.term.service.NoderVersionInfoService";
			sendMessage(p_msg);
		}
	}
}