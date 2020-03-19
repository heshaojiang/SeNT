package platform.security.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.security.message.UserMsg;
	
	public class UserDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="userService")]
		public var ro:RemoteObject;
		
		[Command(selector = "importUserInfoExcel")]
		public function importExcel(p_msg:UserMsg):AsyncToken
		{
			return call("importUserInfoExcel", p_msg.args["bytes"]);
		}
		[CommandResult(selector = "importUserInfoExcel")]
		public function importExcelHandler(p_result:ResultEvent, tigger:UserMsg):void
		{
			var msg:UserMsg = new UserMsg();
			msg.type = "importUserInfoExcelResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[Init]
		public function init():void
		{
			super._ro = ro;
		}
		
		/*****************************************
		 * 异步调用远程接口
		 *****************************************/
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="getUserRoles")]
		public function getUserRoles(p_msg:UserMsg):AsyncToken
		{
			trace("UserDelegate.getUserRoles - getUserRoles");
			return call("getUserRoles", p_msg.args["id"]);
		}
		[CommandResult(selector="getUserRoles")]
		public function getUserRolesResult(p_result:ResultEvent, trigger:UserMsg):void
		{
			trace("UserDelegate.getUserRolesResult - getUserRoles");
			var msg:UserMsg = new UserMsg();
			msg.type = "getUserRolesResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="configureUserRole")]
		public function configureUserRole(p_msg:UserMsg):AsyncToken
		{
			trace("UserDelegate.configureUserRole - configureUserRole");
			return call("configureUserRole", p_msg.args["id"], p_msg.args["rolesIds"]);
		}
		[CommandResult(selector="configureUserRole")]
		public function configureUserRoleResult(p_result:ResultEvent, trigger:UserMsg):void
		{
			trace("UserDelegate.configureUserRoleResult - configureUserRole");
			var msg:UserMsg = new UserMsg();
			msg.type = "configureUserRoleResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户群组列表
		 */		
		[Command(selector="getUserGrps")]
		public function getUserGrps(p_msg:UserMsg):AsyncToken
		{
			trace("UserDelegate.getUserGrps - getUserGrps");
			return call("getUserGrps", p_msg.args["id"]);
		}
		[CommandResult(selector="getUserGrps")]
		public function getUserGrpsResult(p_result:ResultEvent, trigger:UserMsg):void
		{
			trace("UserDelegate.getUserGrpsResult - getUserGrps");
			var msg:UserMsg = new UserMsg();
			msg.type = "getUserGrpsResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户群组列表
		 */		
		[Command(selector="configureUserGrp")]
		public function configureUserGrp(p_msg:UserMsg):AsyncToken
		{
			trace("UserDelegate.configureUserGrp - configureUserGrp");
			return call("configureUserGrp", p_msg.args["id"], p_msg.args["groupIds"]);
		}
		[CommandResult(selector="configureUserGrp")]
		public function configureUserGrpResult(p_result:ResultEvent, trigger:UserMsg):void
		{
			trace("UserDelegate.configureUserGrpResult - configureUserGrp");
			var msg:UserMsg = new UserMsg();
			msg.type = "configureUserGrpResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户群组列表
		 */		
		[Command(selector="deleteSelected")]
		public function deleteSelected(p_msg:UserMsg):AsyncToken
		{
			trace("UserDelegate.deleteSelected - deleteSelected");
			return call("deleteSelected", p_msg.args["ids"]);
		}
		[CommandResult(selector="deleteSelected")]
		public function deleteSelectedResult(p_result:ResultEvent, trigger:UserMsg):void
		{
			trace("UserDelegate.deleteSelectedResult - deleteSelected");
			var msg:UserMsg = new UserMsg();
			msg.type = "deleteSelectedResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户群组列表
		 */		
		[Command(selector="resetPassword")]
		public function resetPassword(p_msg:UserMsg):AsyncToken
		{
			trace("UserDelegate.resetPassword - resetPassword");
			return call("resetPassword", p_msg.args["id"]);
		}
		[CommandResult(selector="resetPassword")]
		public function resetPasswordResult(p_result:ResultEvent, trigger:UserMsg):void
		{
			trace("UserDelegate.resetPasswordResult - resetPassword");
			var msg:UserMsg = new UserMsg();
			msg.type = "resetPasswordResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="getUserPage")]
		public function getUserPage(p_msg:UserMsg):AsyncToken
		{
			trace("UserDelegate.getUserPage - getUserPage");
			return call("getUserPage", p_msg.args["page"], p_msg.args["condition"]);
		}
		[CommandResult(selector="getUserPage")]
		public function getUserPageResult(p_result:ResultEvent, trigger:UserMsg):void
		{
			trace("UserDelegate.getUserPageResult - getUserPage");
			var msg:UserMsg = new UserMsg();
			msg.type = "getUserPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="exportUserInfo")]
		public function exportUserInfo(p_msg:UserMsg):AsyncToken
		{
			return call("exportUserInfo", p_msg.args["condition"]);
		}
		
		[CommandResult(selector="exportUserInfo")]
		public function exportUserInfoResult(p_result:ResultEvent, trigger:UserMsg):void
		{
			var msg:UserMsg = new UserMsg();
			msg.type = "exportUserInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="newUser")]
		public function newUser(p_msg:UserMsg):AsyncToken
		{
			trace("UserDelegate.newUser - newUser");
			return call("newUser", p_msg.args["vo"]);
		}
		[CommandResult(selector="newUser")]
		public function newUserResult(p_result:ResultEvent, trigger:UserMsg):void
		{
			trace("UserDelegate.newUserResult - newUser");
			var msg:UserMsg = new UserMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[CommandError(selector="newUser")]
		public function newUserError(p_fault:FaultEvent, trigger:UserMsg):void
		{
			var msg:UserMsg = new UserMsg();
			msg.type = "saveError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="updateUser")]
		public function updateUser(p_msg:UserMsg):AsyncToken
		{
			trace("UserDelegate.updateUser - updateUser");
			return call("updateUser", p_msg.args["vo"]);
		}
		[CommandResult(selector="updateUser")]
		public function updateUserResult(p_result:ResultEvent, trigger:UserMsg):void
		{
			trace("UserDelegate.updateUserResult - updateUser");
			var msg:UserMsg = new UserMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[CommandError(selector="updateUser")]
		public function updateUserError(p_fault:FaultEvent, trigger:UserMsg):void
		{
			var msg:UserMsg = new UserMsg();
			msg.type = "saveError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
		
		[Command(selector="getUserLevels")]
		public function getUserLevels(p_msg:UserMsg):AsyncToken
		{
			return call("getUserLevels",p_msg.args["userCode"]);
		}
		[CommandResult(selector="getUserLevels")]
		public function getUserLevelsResult(p_result:ResultEvent, trigger:UserMsg):void
		{
			var msg:UserMsg = new UserMsg();
			msg.type = "getUserLevelsResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[Command(selector="changePwd")]
		public function changePwd(p_msg:UserMsg):AsyncToken
		{
			trace("UserDelegate.changePwd - changePwd");
			return call("changePwd", p_msg.args["id"],p_msg.args["oldPwd"],p_msg.args["newPwd"]);
		}
		[CommandResult(selector="changePwd")]
		public function changePwdResult(p_result:ResultEvent, trigger:UserMsg):void
		{
			trace("UserDelegate.changePwdResult - changePwd");
			var msg:UserMsg = new UserMsg();
			msg.type = "changePwdResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
	}
}