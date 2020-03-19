package platform.security.pm
{
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	
	import platform.common.manager.AlertHandler;
	import platform.common.vo.Page;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.security.message.UserMsg;
	
	public class UserModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		[Init]
		public function init():void
		{
			trace("UserModule.init");
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
		
		public function getUserPage(p_cond:Object = null):void
		{
			trace("UserModule.getUserPage");
			var msg:UserMsg = new UserMsg();
			msg.type = "getUserPage";	// java: "getUserPage", result: "getUserPageResult"
			msg.args["page"] = page;
			msg.args["condition"] = p_cond;
			sendMessage(msg);
		}
		
		[MessageHandler(selector="getUserPageResult")]
		public function getUserPageResult(p_msg:UserMsg):void
		{
			trace("UserModule.getUserPageResult - getUserPageResult");
			page = p_msg.result as Page;
		}
		
		public function batchDelete(p_arr:ArrayCollection):void
		{
			trace("UserModule.batchDelete");
			var msg:UserMsg = new UserMsg();
			msg.type = "deleteSelected";
			msg.args["ids"] = p_arr;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = OperationConsts.DEL;
			sendMessage(msg);
		}
		
		public function resetPassword(p_id:String):void
		{
			trace("UserModule.resetPassword");
			var msg:UserMsg = new UserMsg();
			msg.type = "resetPassword";
			msg.args["id"] = p_id;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = OperationConsts.RESET_PASSWORD;
			sendMessage(msg);
		}
		
		public function changePwd(p_id:String,oldPwd:String,newPwd:String):void
		{
			trace("UserModule.changePwd");
			var msg:UserMsg = new UserMsg();
			msg.type = "changePwd";
			msg.args["id"] = p_id;
			msg.args["oldPwd"] = oldPwd;
			msg.args["newPwd"] = newPwd;
			sendMessage(msg);
		}
	}
}