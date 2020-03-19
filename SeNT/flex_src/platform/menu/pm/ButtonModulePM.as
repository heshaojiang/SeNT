package platform.menu.pm
{
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.menu.message.ButtonMsg;
	import platform.vo.menu.ButtonVo;
	
	public class ButtonModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		public var buttonVO:ButtonVo = new ButtonVo();
		
		public function loadButtonPage(p_subSystem:Object, p_buttonName:String):void
		{
			var msg:ButtonMsg = new ButtonMsg();
			msg.type = "getButtonsByName";
			msg.args["page"] = page;
			msg.args["subSystem"] = p_subSystem;
			msg.args["buttonName"] = p_buttonName;
			sendMessage(msg);
		}		
		[MessageHandler(selector="getButtonsResult")]
		public function getButtonListResult(p_msg:ButtonMsg):void
		{
			if(p_msg.result)
				page = p_msg.result as Page;
		}

		/**
		 * delete menu
		 * */
		public function delButtons(p_arr:Array):void
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
					var msg:ButtonMsg = new ButtonMsg();
					msg.type = "deleteSelect";
					msg.args["delItems"] = DataGridUtil.getPropertys("id", p_arr).source;
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