package platform.menu.pm
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.menu.constants.MenuConsts;
	import platform.menu.message.MenuMsg;
	import platform.vo.menu.MenuVo;
	
	public class MenuModulePM extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		//
		/**菜单vo**/
		public var menuVO:MenuVo = new MenuVo();
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
			loadMenuTree();
		}
		
		/**
		 * 
		 */		
		[MessageHandler(selector="mergeMenuResult")]
		public function mergeMenuResult(p_msg:MenuMsg):void
		{
			if(p_msg.result)
				loadMenuTree();
		}
		
		/**
		 * delete menu
		 * */
		public function delMenu(p_arr:Array):void
		{
			if (p_arr.length <= 0){
				AlertHandler.alert(LocaleConsts.NO_SELECTED_RECORD);
				//AlertHandler.error("必须选择至少一项!!!");
				return;
			}
			AlertHandler.confirm(closeHandler, null, LocaleConsts.CONFIRM_DELETE);
			//close handler
			function closeHandler(evt:CloseEvent):void
			{
				if (evt.detail == Alert.YES){
					var msg:MenuMsg = new MenuMsg();
					msg.type = "delete";
					msg.args["delItems"] = DataGridUtil.getPropertys("id", p_arr).source;
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
		public function delBackHandler(p_msg:MenuMsg):void
		{
			if(p_msg.result){
				var str:String = LanguageManager.getInstance().
					getCommonLocleValue("Msg", MenuConsts.IGNORE_ITEMS).toString();
				AlertHandler.alert(p_msg.result + str);
			}
			loadMenuTree();
			loadMenuPage();
		}
		
		/**
		 * 排序后更新
		 * */
		public function batchUpdateMenu(p_Items:ArrayCollection):void
		{
			var msg:MenuMsg = new MenuMsg();
			msg.type = "batchUpdate";
			msg.args["menus"] = p_Items;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = OperationConsts.EDIT;
			sendMessage(msg);
		}
		
		/**
		 * 批量更新结果
		 */		
		[MessageHandler(selector="batchUpdateResult")]
		public function batchUpdateHandler(p_msg:MenuMsg):void
		{
			loadMenuPage();
		}
		
		/**
		 * search Menu Paging
		 * */
		public function loadMenuPage():void
		{
			var msg:MenuMsg = new MenuMsg();
			msg.type = "getMenuPage2";
			msg.args["page"] = page;
			msg.args["parentId"] = menuVO.id;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getPageResult")]
		public function getPageHandler(p_msg:MenuMsg):void
		{
			page = p_msg.result as Page;	//修改页面模型
		}
		
		/**
		 * init module data
		 * */
		public function loadMenuTree():void
		{
			var msg:MenuMsg = new MenuMsg();
			msg.type = "getMenuTree";
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getMenuTreeResult")]
		public function getMenuTreeHandler(p_msg:MenuMsg):void
		{
			treeXml = new XMLList(p_msg.result);
		}
		
		
		/**save success handler**/
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:MenuMsg):void
		{				
			loadMenuTree();
			loadMenuPage();
		}
		
		/**
		 * click menu treeitem
		 * **/
		public function setCurrentSelectedItem(p_obj:Object):void
		{
			var selectedItem:XML = p_obj as XML;
			menuVO.id = selectedItem.@id;
			menuVO.parentId = selectedItem.@parentId;
			menuVO.i18nName = selectedItem.@label;
			menuVO.menuURL = selectedItem.@menuURL;
			menuVO.iconURL = selectedItem.@iconURL;
			menuVO.level = selectedItem.@level;
			menuVO.order = selectedItem.@order;
			//刷新数据
			loadMenuPage();
		}
	}
}