package platform.sitemsg.pm
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
	import platform.sitemsg.message.SiteMsg;

	public class SiteMsgModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		public function loadReceivedMsg(p_content:String, startTime:Date, endTime:Date):void{
			var p_page:Page = ObjectUtil.copy(page) as Page;
			p_page.result = null;
			
			var msg:SiteMsg = new SiteMsg();
			msg.type = "getReceivedMsg";
			msg.args["page"] = p_page;
			msg.args["content"]=p_content;
			msg.args["startTime"]=startTime;
			msg.args["endTime"]=endTime;
			sendMessage(msg);
		}
		[MessageHandler(selector = "getReceivedMsgResult")]
		public function loadReceivedMsgResult(p_msg:SiteMsg):void{
			if(p_msg)
				page = p_msg.result as Page; 
		}
		
		public function loadSentMsg(p_content:String, startTime:Date, endTime:Date):void{
			var p_page:Page = ObjectUtil.copy(page) as Page;
			p_page.result = null;
			
			var msg:SiteMsg = new SiteMsg();
			msg.type = "getSentMsg";
			msg.args["page"] = p_page;
			msg.args["content"]=p_content;
			msg.args["startTime"]=startTime;
			msg.args["endTime"]=endTime;
			sendMessage(msg);
		}
		[MessageHandler(selector = "getSentMsgResult")]
		public function loadSentMsgResult(p_msg:SiteMsg):void{
			if(p_msg)
				page = p_msg.result as Page; 
		}
		
		/**
		 * delete received message
		 * */
		public function delReceivedMsgs(p_arr:Array):void
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
					var msg:SiteMsg = new SiteMsg();
					msg.type = "delReceivedMsgs";
					msg.args["ids"] = DataGridUtil.getPropertys("id", p_arr).source;
					//记录日志
					msg.logFlag = true;
					msg.menuId = menuId;
					msg.operate = OperationConsts.DEL;
					sendMessage(msg);
				}
			}
		}	
		
		/**
		 * delete sent message
		 * */
		public function delSentMsgs(p_arr:Array):void
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
					var msg:SiteMsg = new SiteMsg();
					msg.type = "delSentMsgs";
					msg.args["ids"] = DataGridUtil.getPropertys("id", p_arr).source;
					//记录日志
					msg.logFlag = true;
					msg.menuId = menuId;
					msg.operate = OperationConsts.DEL;
					sendMessage(msg);
				}
			}
		}	
		
		public function markReaded(buttonCode:String, p_siteMsgId:String):void{
			var msg:SiteMsg = new SiteMsg();
			msg.type = "markReaded";
			msg.args["siteMsgId"] = p_siteMsgId;
			
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = buttonCode;
			sendMessage(msg);
		}
		
	}
}