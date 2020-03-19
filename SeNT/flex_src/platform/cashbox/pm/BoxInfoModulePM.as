package platform.cashbox.pm
{
	import flash.external.ExternalInterface;
	import flash.utils.ByteArray;
	
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	import mx.utils.ObjectUtil;
	
	import platform.cashbox.message.BoxInfoMsg;
	import platform.cashbox.vo.BoxInfoVO;
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;

	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class BoxInfoModulePM extends BasePM{
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		[Bindable]
		public var page:Page = new Page();
		[Bindable]
		public var condi:Object = new Object();
		[Bindable]
		public var box:BoxInfoVO = new BoxInfoVO();
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		[Bindable]
		public var boxInfoFormInitDatas:Object = new Object();
		
		[Bindable]
		public var searchBarInitDatas:Object = new Object();
		
		
		[Init]
		public function init():void
		{
			//loadBoxInfoPage();
			getBoxInfoFormInitDatas();
		}
	
		/**
		 * delete dataDir
		 * */
		/*
		public function deleteBoxInfo(p_delItems:BoxInfoVO):void
		{
			if(p_delItems == null){
				AlertHandler.alert(LocaleConsts.NO_SELECTED_RECORD);
			}
			AlertHandler.confirm(closeHandler, null, LocaleConsts.CONFIRM_DELETE);
			//close handler
			function closeHandler(evt:CloseEvent):void
			{
				if (evt.detail == Alert.YES){
					var msg:BoxInfoMsg = new BoxInfoMsg();
					msg.type = "deleteBoxInfo";
					msg.args["data"] = 	p_delItems;
					//记录日志
					msg.logFlag = true;
					msg.menuId = menuId;
					msg.operate = OperationConsts.DEL;
					sendMessage(msg);
				}
			}
		}
		*/
		
		public function deleteBoxInfo(p_delItems:Array):void			
		{
			if(!(p_delItems.length>0)){						
				AlertHandler.alert(LocaleConsts.NO_SELECTED_RECORD);					
			}else{					
				AlertHandler.confirm(closeHandler, null, LocaleConsts.CONFIRM_DELETE);				
				//close handler					
				function closeHandler(evt:CloseEvent):void				
				{				
					if (evt.detail == Alert.YES){					
						var msg:BoxInfoMsg = new BoxInfoMsg();					
						msg.type = "deleteBoxInfo";				
						msg.args["ids"] = DataGridUtil.getPropertys("id",p_delItems);					
						//记录日志					
						msg.logFlag = true;					
						msg.menuId = menuId;					
						msg.operate = OperationConsts.DEL;					
						sendMessage(msg);					
					}					
				}
			}
		}
		
		
		/**
		 * 删除返回结果处理函数
		 */		
		
		[MessageHandler(selector="deleteBoxInfoResult")]
		public function delBackHandler(p_msg:BoxInfoMsg):void
		{
			AlertHandler.alert(LocaleConsts.DELETE_SUCCESS);
			
			//			loadDataDirTree();
			loadBoxInfoPage();
		}
		
		/**
		 * search DataDir Paging
		 */
		public function loadBoxInfoPage():void
		{
			condi["userOrgid"] = UserInfoInit.userInfo["orgid"];
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type = "getBoxInfoPage";	// java: "getBoxInfoByParams", result: "getBoxInfoPageResult"
			msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getBoxInfoPageResult")]
		public function getPageHandler(p_msg:BoxInfoMsg):void
		{
			page = p_msg.result as Page;
		}
		
		
		/**
		 * 导入Excel
		 * @param p_fileData
		 * 
		 */		
		public function importExcel(p_fileData:ByteArray):void
		{
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type = "importExcel";
			msg.args["bytes"] = p_fileData;
			sendMessage(msg);
		}
		/**
		 * refresh the layout if it was completed of import.
		 */		
		[MessageHandler(selector="importExcelSuccess")]
		public function importExcelResultHandler(p_msg:BoxInfoMsg):void
		{
			
			if (p_msg.result){
				var msg:String = LanguageManager.getInstance().getCommonLocleValue("Msg", "importSuccess").toString();
				var importresult:Object = p_msg.result;
				AlertHandler.alert(importresult.importedNum+"条记录"+msg+"\r\n"+importresult.errMsg);
				loadBoxInfoPage();
			}else{
				AlertHandler.alert(LanguageManager.getInstance().getCommonLocleValue("Msg", "importSuccess").toString());				
				loadBoxInfoPage();
			}
		}
	
		public function exportFile():void
		{
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type ="exportExcel";
			sendMessage(msg);
		}
		[MessageHandler(selector = "exportExcelResult")]
		public function exportExcelResultHandler(p_msg:BoxInfoMsg):void
		{
			if(p_msg.result){
				var fileName:String = p_msg.result.toString();
				ExternalInterface.call("downloadFile",".ImportExcelServlet?fileName="+fileName);
			}
		}
		
		/**批量获取下拉数据源**/
		public function getBoxInfoFormInitDatas():void
		{
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type = "getBoxInfoFormInitDatas";
			sendMessage(msg);
		}
		/**
		 * 批量获取下拉数据源的回调函数
		 */		
		[MessageHandler(selector="getBoxInfoFormInitDatasResult")]
		public function getBoxInfoFormInitDatasBackHandler(p_msg:BoxInfoMsg):void
		{
			var result:Object = p_msg.result;
			if(result != null){
				boxInfoFormInitDatas = ObjectUtil.copy(p_msg.result) as Object;
				searchBarInitDatas = result;
			}
		}
	
		/**
		 * 
		 * */
		public function getOrgNameAndModelNameByBoxNum(boxNum:String):void
		{
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type = "getOrgNameAndModelNameByBoxNum";	// java: "getOrgNameAndModelNameByBoxNum", result: "getOrgNameAndModelNameByBoxNumResult"
			msg.args["boxNum"] = boxNum;
			sendMessage(msg);
		}
		
		public function restoreBoxFlowStage(updateItem:Object):void			
		{
			AlertHandler.confirm(function(event:CloseEvent):void{
				if (event.detail == Alert.YES)
				{
					var msg:BoxInfoMsg = new BoxInfoMsg();					
					msg.type = "restoreBoxFlowStage";				
					msg.args["boxNum"] = updateItem.boxNum;					
				
					sendMessage(msg);			
				}
			}, null, "confirmRestoreBoxFlowStage");
			
		}
		
		/**
		 * 删除返回结果处理函数
		 */		
		
		[MessageHandler(selector="restoreBoxFlowStageResult")]
		public function restoreBoxFlowStageHandler(p_msg:BoxInfoMsg):void
		{
			AlertHandler.alert("恢复流转状态成功");
			
			//			loadDataDirTree();
			loadBoxInfoPage();
		}
	}
}