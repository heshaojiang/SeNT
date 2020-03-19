package platform.security.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.security.message.GroupMsg;
	
	public class GroupDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="groupService")]
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
		[Command(selector="getGrpUsers")]
		public function getGrpUsers(p_msg:GroupMsg):AsyncToken
		{
			return call("getGrpUsers", p_msg.args["id"]);
		}
		[CommandResult(selector="getGrpUsers")]
		public function getGrpUsersResult(p_result:ResultEvent, trigger:GroupMsg):void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "getGrpUsersResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="configureGrpUser")]
		public function configureGrpUser(p_msg:GroupMsg):AsyncToken
		{
			return call("configureGrpUser", p_msg.args["id"], p_msg.args["userIds"]);
		}
		[CommandResult(selector="configureGrpUser")]
		public function configureGrpUserResult(p_result:ResultEvent, trigger:GroupMsg):void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "configureGrpUserResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="getGrpRoles")]
		public function getGrpRoles(p_msg:GroupMsg):AsyncToken
		{
			return call("getGrpRoles", p_msg.args["id"]);
		}
		[CommandResult(selector="getGrpRoles")]
		public function getGrpRolesResult(p_result:ResultEvent, trigger:GroupMsg):void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "getGrpRolesResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="configureGrpRole")]
		public function configureGrpRole(p_msg:GroupMsg):AsyncToken
		{
			return call("configureGrpRole", p_msg.args["id"], p_msg.args["roleIds"]);
		}
		[CommandResult(selector="configureGrpRole")]
		public function configureGrpRoleResult(p_result:ResultEvent, trigger:GroupMsg):void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "configureGrpRoleResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="searchGroup")]
		public function searchGroup(p_msg:GroupMsg):AsyncToken
		{
			return call("searchGroup", p_msg.args["page"], p_msg.args["condition"]);
		}
		[CommandResult(selector="searchGroup")]
		public function searchGroupResult(p_result:ResultEvent, trigger:GroupMsg):void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "searchGroupResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="deleteSelected")]
		public function deleteSelected(p_msg:GroupMsg):AsyncToken
		{
			return call("batchDelete", p_msg.args["ids"]);
		}
		[CommandResult(selector="deleteSelected")]
		public function deleteSelectedResult(p_result:ResultEvent, trigger:GroupMsg):void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "deleteSelectedResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="newGroup")]
		public function newGroup(p_msg:GroupMsg):AsyncToken
		{
			return call("newGroup", p_msg.args["vo"]);
		}
		[CommandResult(selector="newGroup")]
		public function newGroupResult(p_result:ResultEvent, trigger:GroupMsg):void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[CommandError(selector="newGroup")]
		public function newGroupError(p_fault:FaultEvent, trigger:GroupMsg):void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "saveError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
		
		
		/**
		 * 获取用户角色列表
		 */		
		[Command(selector="updateGroup")]
		public function updateGroup(p_msg:GroupMsg):AsyncToken
		{
			return call("updateGroup", p_msg.args["vo"]);
		}
		[CommandResult(selector="updateGroup")]
		public function updateGroupResult(p_result:ResultEvent, trigger:GroupMsg):void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[CommandError(selector="updateGroup")]
		public function updateGroupError(p_fault:FaultEvent, trigger:GroupMsg):void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "saveError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
	}
}