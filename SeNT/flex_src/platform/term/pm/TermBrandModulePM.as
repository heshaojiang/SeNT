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
	import platform.term.message.TermBrandMsg;
	import platform.vo.term.TermBrandVo;

	
	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class TermBrandModulePM extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		/**current selected node's data vo**/
		public var curNodeData:TermBrandVo = new TermBrandVo();
		
		/****/
		[Bindable]
		public var treeXml:XMLList;
		/****/
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var condi:String = "";
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		[Init]
		public function init():void
		{
			loadTermBrandPage();
		}
		
		/**save success handler**/
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:TermBrandMsg):void
		{
			loadTermBrandPage();
		}
		
		/**
		 * delete dataDir
		 * */
		public function delTermBrand(p_delItems:Array):void
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
					var msg:TermBrandMsg = new TermBrandMsg();
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
		public function delBackHandler(p_msg:TermBrandMsg):void
		{
			AlertHandler.alert(LocaleConsts.DELETE_SUCCESS);
			
//			loadDataDirTree();
			loadTermBrandPage();
		}
		
		/**
		 * search DataDir Paging
		 * */
		public function loadTermBrandPage():void
		{
			var msg:TermBrandMsg = new TermBrandMsg();
			msg.type = "getTermBrandPage";
			msg.args["page"] = page;
			msg.args["brandName"] = condi;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getTermBrandPageResult")]
		public function getPageHandler(p_msg:TermBrandMsg):void
		{
			page = p_msg.result as Page;
		}
		
	}
}