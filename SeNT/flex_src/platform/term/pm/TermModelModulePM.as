package platform.term.pm
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.term.message.TermModelMsg;
	

	
	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class TermModelModulePM extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var condi:Object = new Object;
		
//		[Bindable]
//		public var brandList:ArrayCollection = new ArrayCollection();
		
		[Bindable]
		public var brandIdListForModule:ArrayCollection = new ArrayCollection();
		
//		[Bindable]
//		public var typeList:ArrayCollection = new ArrayCollection();
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		[Init]
		public function init():void
		{
			trace("TermModelModulePM.init");
			loadTermModelPage();
			//getFormInitDatas();
			getBrandList();
		}
		
		/**
		 * 
		 */
		public function getBrandList():void
		{
			trace("TermModelModulePM.getBrandList");
			var msg:TermModelMsg = new TermModelMsg();
			msg.type = "getBrandList";
			sendMessage(msg);
		}
		
		[MessageHandler(selector="getBrandListResult")]
		public function getBrandListResult(msg:TermModelMsg):void
		{
			trace("TermModelModulePM.getBrandListResult");
			var result:Object = msg.result;
			if( result != null )
			{
				this.brandIdListForModule = ObjectUtil.copy(result) as ArrayCollection;
			}
		}

		
		/**save success handler**/
		[MessageHandler(selector="saveResult")]
		public function saveResultHandler(p_msg:TermModelMsg):void
		{
			trace("TermModelModulePM.saveResultHandler-saveResult");
			loadTermModelPage();
		}
		
		/**
		 * delete dataDir
		 * */
		public function delTermModel(p_delItems:Array):void
		{
			trace("TermModelModulePM.delTermModel");
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
					var msg:TermModelMsg = new TermModelMsg();
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
		public function delBackHandler(p_msg:TermModelMsg):void
		{
			trace("TermModelModulePM.delBackHandler-delResult");
			AlertHandler.alert(LocaleConsts.DELETE_SUCCESS);
			
			loadTermModelPage();
		}
		
		/**
		 * search DataDir Paging
		 * */
		public function loadTermModelPage():void
		{
			trace("TermModelModulePM.loadTermModelPage");
			var msg:TermModelMsg = new TermModelMsg();
			msg.type = "getTermModelPage";
			msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getTermModelPageResult")]
		public function getPageHandler(p_msg:TermModelMsg):void
		{
			trace("TermModelModulePM.getPageHandler-getTermModelPageResult");
			page = p_msg.result as Page;
		}
		
	}
}