package platform.security.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.security.message.RoleMsg;
	
	public class RoleDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="roleService")]
		public var ro:RemoteObject;
		
		/**语言包**/
		private var langMgr:LanguageManager = LanguageManager.getInstance();
		
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
		[Command(selector="getRoleGrps")]
		public function getRoleGrps(p_msg:RoleMsg):AsyncToken
		{
			return call("getRoleGrps", p_msg.args["id"]);
		}
		[CommandResult(selector="getRoleGrps")]
		public function getRoleGrpsResult(p_result:ResultEvent, trigger:RoleMsg):void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "getRoleGrpsResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="configureRoleGrp")]
		public function configureRoleGrp(p_msg:RoleMsg):AsyncToken
		{
			return call("configureRoleGrp", p_msg.args["id"], p_msg.args["groupIds"]);
		}
		[CommandResult(selector="configureRoleGrp")]
		public function configureRoleGrpResult(p_result:ResultEvent, trigger:RoleMsg):void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "configureRoleGrpResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="getRolePriviInfo")]
		public function getRolePriviInfo(p_msg:RoleMsg):AsyncToken
		{
			return call("getRolePriviInfo", p_msg.args["id"], langMgr.currentLanguage);
		}
		[CommandResult(selector="getRolePriviInfo")]
		public function getRolePriviInfoResult(p_result:ResultEvent, trigger:RoleMsg):void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "getRolePriviInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="configureRolePrivi")]
		public function configureRolePrivi(p_msg:RoleMsg):AsyncToken
		{
			return call("configureRolePrivi", p_msg.args["id"], p_msg.args["priviIds"]);
		}
		[CommandResult(selector="configureRolePrivi")]
		public function configureRolePriviResult(p_result:ResultEvent, trigger:RoleMsg):void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "configureRolePriviResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="getRoleUsers")]
		public function getRoleUsers(p_msg:RoleMsg):AsyncToken
		{
			return call("getRoleUsers", p_msg.args["id"]);
		}
		[CommandResult(selector="getRoleUsers")]
		public function getRoleUsersResult(p_result:ResultEvent, trigger:RoleMsg):void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "getRoleUsersResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="configureRoleUser")]
		public function configureRoleUser(p_msg:RoleMsg):AsyncToken
		{
			return call("configureRoleUser", p_msg.args["id"], p_msg.args["userIds"]);
		}
		[CommandResult(selector="configureRoleUser")]
		public function configureRoleUserResult(p_result:ResultEvent, trigger:RoleMsg):void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "configureRoleUserResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="getRolePage")]
		public function getRolePage(p_msg:RoleMsg):AsyncToken
		{
			return call("getRolePage", p_msg.args["page"], p_msg.args["condition"]);
		}
		[CommandResult(selector="getRolePage")]
		public function getRolePageResult(p_result:ResultEvent, trigger:RoleMsg):void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "getRolePageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="deleteSelected")]
		public function deleteSelected(p_msg:RoleMsg):AsyncToken
		{
			return call("deleteSelected", p_msg.args["ids"]);
		}
		[CommandResult(selector="deleteSelected")]
		public function deleteSelectedResult(p_result:ResultEvent, trigger:RoleMsg):void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "deleteSelectedResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="getRoleLevels")]
		public function getRoleLevels(p_msg:RoleMsg):AsyncToken
		{
			return call("getRoleLevels", langMgr.currentLanguage);
		}
		[CommandResult(selector="getRoleLevels")]
		public function getRoleLevelsResult(p_result:ResultEvent, trigger:RoleMsg):void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "getRoleLevelsResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="saveRole")]
		public function save(p_msg:RoleMsg):AsyncToken
		{
			return call("save", p_msg.args["vo"]);
		}
		[CommandResult(selector="saveRole")]
		public function saveResult(p_result:ResultEvent, trigger:RoleMsg):void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "saveRoleResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[CommandError(selector="saveRole")]
		public function saveErrorHandler(p_fault:FaultEvent, trigger:RoleMsg):void
		{
			//todo anything;
			var msg:RoleMsg = new RoleMsg();
			msg.type = "saveError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
	}
}