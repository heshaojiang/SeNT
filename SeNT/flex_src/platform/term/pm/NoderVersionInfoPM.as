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
	import platform.term.message.NoderVersionInfoMsg;
	import platform.term.vo.NoderVersionInfoVo;
	
	import sent.common.utils.TestUtils;

;

	
	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class NoderVersionInfoPM extends BasePM
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
		public var noderVersionInfo:NoderVersionInfoVo ;
		
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
			//loadNoderInfoPage();
			loadNoderVersionInfoPage();
			getnoderVersionInfoFormInitDatas();
		}
		
		/**批量获取下拉数据源**/
		public function getnoderVersionInfoFormInitDatas():void
		{
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "getNoderVersionInfoFormInitDatas";
			sendMessage(msg);
			
		}
		
		public function auditRegulation(noderVersionInfo:NoderVersionInfoVo):void
		{
			trace("NoderVersionInfoPM.auditRegulation") ;
			this.noderVersionInfo = noderVersionInfo ;
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			noderVersionInfo.checkUserId = UserInfoInit.userInfo["id"];
			msg.type = "auditRegulation";
			msg.args["data"] = noderVersionInfo;
			/*msg.logFlag = true;*/
			msg.menuId = this.menuId;
			sendMessage(msg);
			
		}
		/**save success handler**/
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:NoderVersionInfoMsg):void
		{
			loadNoderVersionInfoPage();
		}
		
		/**
		 * delete dataDir
		 * */
		public function delNoderVersionInfo(p_delItems:Array):void
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
					var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
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
		public function delBackHandler(p_msg:NoderVersionInfoMsg):void
		{
			loadNoderVersionInfoPage();
			getnoderVersionInfoFormInitDatas();
		}
		
		/**
		 * search DataDir Paging
		 * */
		public function loadNoderVersionInfoPage():void
		{
			condi["userOrgid"] = UserInfoInit.userInfo["orgId"];
			//orgid
			if(condi["userOrgid"]==null || condi["userOrgid"]==""){
				//condi["userOrgid"] = orgid.selectedValue;
			}
			//TestUtils.printObject(condi) ;
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "getNoderVersionInfoPage";
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
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "exportNoderVersionInfo";
			//msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		
		/**
		 * 同步发送
		 * */
		public function syncSendToSentServerTesttt():void
		{
		
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "syncSendToSentServer";
			//msg.args["page"] = page;
			msg.args["synchType"] = 1;
			sendMessage(msg);
		}
		
		/**
		 * 同步发送的回调函数
		 */		
		[MessageHandler(selector="syncSendToSentServerResult")]
		public function syncSendToSentServeTestttHandler(p_msg:NoderVersionInfoMsg):void
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
		[MessageHandler(selector="getNoderVersionInfoPageResult")]
		public function getPageHandler(p_msg:NoderVersionInfoMsg):void
		{
			page = p_msg.result as Page;
		}
		
		/**
		 * 批量获取下拉数据源的回调函数
		 */		
		[MessageHandler(selector="getNoderVersionInfoFormInitDatasResult")]
		public function getnoderVersionInfoFormInitDatasBackHandler(p_msg:NoderVersionInfoMsg):void
		{
			trace("NoderVersionInfoPM.getnoderVersionInfoFormInitDatasBackHandler") ;
			var result:Object = p_msg.result;
			
			if(result != null){
				noderVersionInfoFormInitDatas = ObjectUtil.copy(p_msg.result) as Object;
				searchBarInitDatas = result;
			}
			
		}
		
		/**
		 * 导入Excel
		 * @param p_fileData
		 * 
		 */		
		public function importNoderVersionInfoExcel(p_fileData:ByteArray):void
		{
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "importNoderVersionInfoExcel";	// java: "importNoderVersionInfoExcel", result: "importNoderVersionInfoExcelResult"
			msg.args["bytes"] = p_fileData;
			sendMessage(msg);
		}
		
		/**
		 * refresh the layout if it was completed of import some org.
		 */		
		[MessageHandler(selector="importNoderVersionInfoExcelResult")]
		public function importExcelResultHandler(p_msg:NoderVersionInfoMsg):void
		{
			if (p_msg.result)
			{
				var msg:String = LanguageManager.getInstance().getCommonLocleValue("Msg", "importFail").toString();
				AlertHandler.alert(msg + p_msg.result.toString());				
				loadNoderVersionInfoPage();
			}
			else
			{
				AlertHandler.alert(LanguageManager.getInstance().getCommonLocleValue("Msg", "importSuccess").toString());				
				loadNoderVersionInfoPage();
			}
		}
		
		/**
		 * refresh the layout if it was completed of import some org.
		 */		
		[MessageHandler(selector="auditRegulationResult")]
		public function auditRegulationResult(p_msg:NoderVersionInfoMsg):void
		{
				AlertHandler.alert(LanguageManager.getInstance().getCommonLocleValue("Msg", "auditSuccess").toString());				
				loadNoderVersionInfoPage();
		}
		
		[MessageHandler(selector="auditRegulationError")]
		public function auditRegulationError(p_msg:NoderVersionInfoMsg):void
		{
			AlertHandler.alert(LanguageManager.getInstance().getCommonLocleValue("Msg", "auditError").toString());				
			loadNoderVersionInfoPage();
		}
		//根据冠字号记录，查询终端设备
		public function getNoderVersionInfoById(p_msg:NoderVersionInfoMsg):void{
			
			p_msg.type = "NoderVersionInfoDelegate:com.grgbanking.platform.module.term.service.NoderVersionInfoService";
			sendMessage(p_msg);
		}
	}
}