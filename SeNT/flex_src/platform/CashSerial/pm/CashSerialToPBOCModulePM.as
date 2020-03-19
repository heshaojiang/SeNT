package platform.CashSerial.pm
{
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	
	import platform.CashSerial.message.CashSerialToPBOCMsg;
	import platform.common.manager.AlertHandler;
	import platform.common.vo.Page;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.security.message.UserMsg;
	
	public class CashSerialToPBOCModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		[Init]
		public function init():void
		{
			trace("CashSerialToPBOCModule.init");
			//getUserPage();
		}
		
		public function importUserInfoExcel(p_fileData:ByteArray):void
		{
			var msg:UserMsg = new UserMsg();
			msg.type = "importUserInfoExcel";
			msg.args["bytes"] = p_fileData;
			sendMessage(msg);
		}
		
		public function export(p_cond:Object = null):void
		{
			/*condi["userOrgid"] = UserInfoInit.userInfo["orgId"];
			//orgid
			if(condi["userOrgid"]==null || condi["userOrgid"]==""){
				//condi["userOrgid"] = orgid.selectedValue;
			}
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "exportTermInfo";
			//msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);*/
			
			var msg:UserMsg = new UserMsg();
			msg.type = "exportUserInfo";	// java: "getUserPage", result: "getUserPageResult"
			// msg.args["page"] = page;
			msg.args["condition"] = p_cond;
			sendMessage(msg);
		}
		
		public function getCashSerialToPBOCPage(p_cond:Object = null):void
		{
			var msg:CashSerialToPBOCMsg = new CashSerialToPBOCMsg();
			msg.type = "getCashSerialToPBOCPage";
			msg.args["page"] = page;
			msg.args["condition"] = p_cond;
			sendMessage(msg);
		}
		
		[MessageHandler(selector="getUserPageResult")]
		public function getUserPageResult(p_msg:UserMsg):void
		{
			trace("CashSerialToPBOCModule.getUserPageResult - getUserPageResult");
			page = p_msg.result as Page;
		}
		
		public function batchDelete(p_arr:ArrayCollection):void
		{
			trace("CashSerialToPBOCModule.deleteSelectedCashSerialToPBOC");
			var msg:CashSerialToPBOCMsg = new CashSerialToPBOCMsg();
			msg.type = "deleteSelectedCashSerialToPBOC";
			msg.args["ids"] = p_arr;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = OperationConsts.DEL;
			sendMessage(msg);
		}
		
		public function resetPassword(p_id:String):void
		{
			trace("CashSerialToPBOCModule.resetPassword");
			var msg:UserMsg = new UserMsg();
			msg.type = "resetPassword";
			msg.args["id"] = p_id;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = OperationConsts.RESET_PASSWORD;
			sendMessage(msg);
		}
		
	
	}
}