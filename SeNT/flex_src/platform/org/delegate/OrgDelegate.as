package platform.org.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.AlertHandler;
	import platform.layer.DelegateBase;
	import platform.org.message.OrgMsg;
	
	public class OrgDelegate extends DelegateBase
	{
		
		[Command(selector = "exportOrgInfo")]
		public function exportOrgInfo(p_msg:OrgMsg):AsyncToken
		{
			return call("exportOrgInfo",p_msg.args["orgId"]);
		}
		[CommandResult(selector = "exportOrgInfo")]
		public function exportOrgInfoResultHandler(p_result:ResultEvent, tigger:OrgMsg):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "exportOrgInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * batch delete items
		 * @param orgIds
		 * @param callback  
		 * @return
		 * 
		 */		
		[Command(selector = "batchDelete")]
		public function batchDelete(p_msg:OrgMsg):AsyncToken
		{
			return call("deleteSelected", p_msg.args["ids"]);
		}
		[CommandResult(selector = "batchDelete")]
		public function delResultHandler(p_result:ResultEvent, tigger:OrgMsg):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "orgSaveSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		
		/**
		 * get the org paging infomations
		 * @param page
		 * @param condition
		 * @param callback
		 * @return
		 * 
		 */
		[Command(selector = "getOrgPage")]
		public function getOrgPage(p_msg:OrgMsg):AsyncToken
		{
			return call("getOrgPage", p_msg.args["page"], null, p_msg.args["cond"]);
		}
		[CommandResult(selector = "getOrgPage")]
		public function getOrgPageHandler(p_result:ResultEvent, tigger:OrgMsg):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "getOrgPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * get org tree
		 * @param p_msg
		 * @return
		 * 
		 */		
		[Command(selector = "getOrgTree")]
		public function getOrgTree(p_msg:OrgMsg):AsyncToken
		{
			return call("getOrgTree", UserInfoInit.userInfo["orgId"]);
		}
		[CommandResult(selector = "getOrgTree")]
		public function getOrgTreeHandler(p_result:ResultEvent, tigger:OrgMsg):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "getOrgTreeResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}		
		
		/**
		 * get top org
		 * @return
		 * 
		 */		
		[Command(selector = "getTopOrg")]
		public function getTopOrg(p_msg:OrgMsg):AsyncToken
		{
			return call("getTopOrg");
		}
		[CommandResult(selector = "getTopOrg")]
		public function getTopOrgHandler(p_result:ResultEvent, tigger:OrgMsg):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "getTopOrgResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}		
		
		/**
		 * 
		 * @param p_msg
		 * @return
		 */		
		[Command(selector = "getMaxOrderValue")]
		public function getMaxOrderValue(p_msg:OrgMsg):AsyncToken
		{
			return call("getMaxOrderValue", p_msg.args["parentId"]);
		}
		[CommandResult(selector = "getMaxOrderValue")]
		public function getMaxOrderValueHandler(p_result:ResultEvent, tigger:OrgMsg):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "getMaxOrderValueResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * Create a new org
		 * @param entity
		 * 
		 * */
		[Command(selector = "newOrg")]
		public function newOrg(p_msg:OrgMsg):AsyncToken
		{
			return call("newOrg", p_msg.args["vo"]);
		}
		[CommandResult(selector = "newOrg")]
		public function newOrgHandler(p_result:ResultEvent, tigger:OrgMsg):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "orgSaveSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[CommandError(selector="newOrg")]
		public function newOrgErrorHandler(p_fault:FaultEvent, trigger:OrgMsg):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "orgSaveError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
		
		
		
		/**
		 * 
		 * */
		[Command(selector = "update")]
		public function update(p_msg:OrgMsg):AsyncToken
		{
			return call("update", p_msg.args["vo"]);
		}
		[CommandResult(selector = "update")]
		public function updateHandler(p_result:ResultEvent, tigger:OrgMsg):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "orgSaveSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		[CommandError(selector="update")]
		public function updateErrorHandler(p_fault:FaultEvent, trigger:OrgMsg):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "orgSaveError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
		
		////////////////////
		
		/**
		 * 
		 */
		[Command(selector = "importOrgInfoExcel")]
		public function importOrgInfoExcelCommand(p_msg:OrgMsg):AsyncToken
		{
			return call("importOrgInfoExcel", p_msg.args["bytes"]);
		}
		
		[CommandResult(selector = "importOrgInfoExcel")]
		public function importOrgInfoExcelCommandResult(p_result:ResultEvent, tigger:OrgMsg):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "importOrgInfoExcelResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		///////////////
		
		/**
		 * 
		 * */
		[Command(selector = "getOrgById")]
		public function getOrgById(p_msg:OrgMsg):AsyncToken
		{
			return call("getOrgById", p_msg.args["orgId"]);
		}
		[CommandResult(selector = "getOrgById")]
		public function getOrgByIdHandler(p_result:ResultEvent, tigger:OrgMsg):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "getTopOrgResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	}
}