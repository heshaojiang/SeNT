package platform.template.pm
{
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.template.message.ContentTemplateMsg;
	
	public class ContentTemplateModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		public function loadPage(type:String):void{
			var p_page:Page = ObjectUtil.copy(page) as Page;
			p_page.result = null;
			
			var msg:ContentTemplateMsg = new ContentTemplateMsg();
			msg.type="getPageData";
			msg.args["page"] = p_page;
			msg.args["type"] = type;
			sendMessage(msg);
		}
		[MessageHandler(selector="getPageDataResult")]
		public function loadPageResult(p_msg:ContentTemplateMsg):void{
			if(p_msg.result)
				page = p_msg.result as Page;
		}
		
		/**
		 * delete received message
		 * */
		public function del(p_arr:Array):void
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
					var msg:ContentTemplateMsg = new ContentTemplateMsg();
					msg.type = "delete";
					msg.args["ids"] = DataGridUtil.getPropertys("id", p_arr).source;
					//记录日志
					msg.logFlag = true;
					msg.menuId = menuId;
					msg.operate = OperationConsts.DEL;
					sendMessage(msg);
				}
			}
		}	
	}
}