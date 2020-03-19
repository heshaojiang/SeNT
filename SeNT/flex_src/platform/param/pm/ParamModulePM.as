package platform.param.pm
{
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.param.message.ParamMsg;
	import platform.vo.param.ParamVo;

	public class ParamModulePM extends BasePM
	{
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		/**current selected node's data vo**/
		[Bindable]
		public var curNodeData:ParamVo = new ParamVo();
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
		public function init():void
		{
			trace("ParamModulePM.init");
			//loadParamTree();
		}
		
		/**save success handler**/
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:ParamMsg):void
		{
			trace("ParamModulePM.saveBackHandler - saveResult");
			loadParamTree();
			loadParamPage();
		}
		
		/**
		 * delete Parame
		 */
		public function delParam(p_delItems:Array):void
		{
			trace("ParamModulePM.delParam");
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
				if (evt.detail == Alert.YES)
				{
					var msg:ParamMsg = new ParamMsg();
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
		public function delBackHandler(p_msg:ParamMsg):void
		{
			trace("ParamModulePM.delBackHandler - delResult");
//			AlertHandler.alert(LocaleConsts.DELETE_SUCCESS);
			
			loadParamTree();
			loadParamPage();
		}
		
		/**
		 * search Param Paging
		 */
		public function loadParamPage():void
		{
			trace("ParamModulePM.loadParamPage");
			var msg:ParamMsg = new ParamMsg();
			msg.type = "getParamPage";	// java: getParamPage, result: getParamPageResult
			msg.args["page"] = page;
			msg.args["parentId"] = curNodeData.id;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getParamPageResult")]
		public function getPageHandler(p_msg:ParamMsg):void
		{
			trace("ParamModulePM.getPageHandler - getParamPageResult");
			page = p_msg.result as Page;
		}
		
		/**
		 * init module data
		 */
		public function loadParamTree():void
		{
			trace("ParamModulePM.loadParamTree");
			var msg:ParamMsg = new ParamMsg();
			msg.type = "getParamTree";	// java: getParamTree, result: getParamTreeResult
			sendMessage(msg);
		}
		
		/**
		 * 获取树结果集
		 */		
		[MessageHandler(selector="getParamTreeResult")]
		public function getParamTreeHandler(p_msg:ParamMsg):void
		{
			trace("ParamModulePM.getParamTreeHandler - getParamTreeResult");
			treeXml = new XMLList(p_msg.result);
		}
		
		/**
		 * click Parame treeitem
		 */
		public function setCurrentSelectedItem(p_obj:Object):void
		{
			trace("ParamModulePM.setCurrentSelectedItem -> "+p_obj);
			
			var selectedItem:XML = p_obj as XML;
			curNodeData.id       = selectedItem.@id;
			curNodeData.parentid = selectedItem.@parentid;
			curNodeData.value    = selectedItem.@label;
			
			var msg:ParamMsg = new ParamMsg();
			msg.type = "getKeyPath";	// java: getKeyPath, result: getKeyPathResult
			msg.args["parentId"] = curNodeData.id;
			sendMessage(msg);
			
			//刷新数据
			loadParamPage();
		}
	}
}