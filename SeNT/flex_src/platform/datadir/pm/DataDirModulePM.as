package platform.datadir.pm
{
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.dataDict.DataDirMsg;
	import platform.layer.BasePM;
	import platform.vo.datadir.DataDirVo;

	
	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class DataDirModulePM extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		/**current selected node's data vo**/
		public var curNodeData:DataDirVo = new DataDirVo();
		
		/****/
		[Bindable]
		public var treeXml:XMLList;
		/****/
		[Bindable]
		public var page:Page = new Page();
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		[Init]
		public function initComplete():void
		{
			trace("DataDirModulePM.initComplete");
			loadDataDirTree();
		}
		
		/**save success handler**/
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:DataDirMsg):void
		{
			trace("DataDirModulePM.saveBackHandler - saveResult");
			loadDataDirTree();
			loadDataDirPage();
		}
		
		/**
		 * delete dataDir
		 * */
		public function delDataDir(p_delItems:Array):void
		{
			trace("DataDirModulePM.delDataDir");
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
					var msg:DataDirMsg = new DataDirMsg();
					msg.type = "delete";
					msg.args["id"] = DataGridUtil.getPropertys("id", p_delItems);
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
		public function delBackHandler(p_msg:DataDirMsg):void
		{
			trace("DataDirModulePM.delBackHandler - delResult");
//			AlertHandler.alert(LocaleConsts.DELETE_SUCCESS);
			
			loadDataDirTree();
			loadDataDirPage();
		}
		
		/**
		 * search DataDir Paging
		 * */
		public function loadDataDirPage():void
		{
			trace("DataDirModulePM.loadDataDirPage");
			var msg:DataDirMsg = new DataDirMsg();
			msg.type = "getDataDirPage";
			msg.args["page"] = page;
			msg.args["parentId"] = curNodeData.id;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getDataDirPageResult")]
		public function getPageHandler(p_msg:DataDirMsg):void
		{
			trace("DataDirModulePM.getPageHandler - getDataDirPageResult");
			page = p_msg.result as Page;
		}
		
		/**
		 * init module data
		 * */
		public function loadDataDirTree():void
		{
			trace("DataDirModulePM.loadDataDirTree");
			var msg:DataDirMsg = new DataDirMsg();
			msg.type = "getDataDirTree";
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getDataDirTreeResult")]
		public function getDataDirTreeHandler(p_msg:DataDirMsg):void
		{
			trace("DataDirModulePM.getDataDirTreeHandler - getDataDirTreeResult");
			treeXml = new XMLList(p_msg.result);
		}
		
		/**
		 * click dataDir treeitem
		 * **/
		public function setCurrentSelectedItem(p_obj:Object):void
		{
			trace("DataDirModulePM.setCurrentSelectedItem");
			var selectedItem:XML = p_obj as XML;
			curNodeData.id = selectedItem.@id;
			curNodeData.parentid = selectedItem.@parentid;
			curNodeData.value = selectedItem.@label;

			curNodeData.order = selectedItem.@order;
			
			//刷新数据
			loadDataDirPage();
		}
	}
}