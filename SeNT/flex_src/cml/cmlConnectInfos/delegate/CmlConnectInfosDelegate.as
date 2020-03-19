package cml.cmlConnectInfos.delegate
{
	import cml.cmlConnectInfos.message.CmlConnectInfosMsg;
	
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;

	public class CmlConnectInfosDelegate extends DelegateBase
	{
		/**
		 * 根据条件查询清分交接信息
		 */		
		[Command(selector="getCmlConnectInfosPage")]
		public function getCmlConnectInfosPage(msg:CmlConnectInfosMsg):AsyncToken
		{
			return call("getObjectPage2", msg.args["page"],msg.args["startTime"],msg.args["endTime"], msg.args["vo"]); 
		}
		[CommandResult(selector="getCmlConnectInfosPage")]
		public function getCmlConnectInfosPageResultHandler(p_result:ResultEvent, trigger:CmlConnectInfosMsg):void
		{
			var msg:CmlConnectInfosMsg = new CmlConnectInfosMsg();
			msg.type = "getCmlConnectInfosPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 根据id查询交易清分交接详情
		 */		
		[Command(selector="getCmlConnectInfosObject")]
		public function getObject(msg:CmlConnectInfosMsg):AsyncToken
		{
			return call("getObject", msg.args["id"]); 
		}
		[CommandResult(selector="getCmlConnectInfosObject")]
		public function getObjectResultHandler(p_result:ResultEvent, trigger:CmlConnectInfosMsg):void
		{
			var msg:CmlConnectInfosMsg = new CmlConnectInfosMsg();
			msg.type = "getCmlConnectInfosObjectResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 *新增一条清分交接信息
		 */		
		[Command(selector="addCmlConnectInfosObject")]
		public function addObject(msg:CmlConnectInfosMsg):AsyncToken
		{
			return call("add", msg.args["vo"]); 
		}
		[CommandResult(selector="addCmlConnectInfosObject")]
		public function addObjectHandler(p_result:ResultEvent, trigger:CmlConnectInfosMsg):void
		{
			var msg:CmlConnectInfosMsg = new CmlConnectInfosMsg();
			msg.type = "addCmlConnectInfosObjectSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 *修改一条清分交接信息
		 */		
		[Command(selector="updateCmlConnectInfosObject")]
		public function updateObject(msg:CmlConnectInfosMsg):AsyncToken
		{
			return call("update", msg.args["vo"]); 
		}
		[CommandResult(selector="updateCmlConnectInfosObject")]
		public function updateObjectHandler(p_result:ResultEvent, trigger:CmlConnectInfosMsg):void
		{
			var msg:CmlConnectInfosMsg = new CmlConnectInfosMsg();
			msg.type = "updateCmlConnectInfosObjectSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 *删除一条清分交接信息
		 */		
		[Command(selector="deleteCmlConnectInfosObject")]
		public function deleteObject(msg:CmlConnectInfosMsg):AsyncToken
		{
			return call("delete", msg.args["vo"]); 
		}
		[CommandResult(selector="deleteCmlConnectInfosObject")]
		public function deleteObjectHandler(p_result:ResultEvent, trigger:CmlConnectInfosMsg):void
		{
			var msg:CmlConnectInfosMsg = new CmlConnectInfosMsg();
			msg.type = "deleteCmlConnectInfosSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 查询中操作员信息
		 * */
		[Command(selector="getOperatorPage")]
		public function getOperatorPage(msg:CmlConnectInfosMsg):AsyncToken
		{
			return call("getOperatorPage", msg.args["page"],msg.args["userName"]); 
		}
		[CommandResult(selector="getOperatorPage")]
		public function getOperatorPageHandler(p_result:ResultEvent, trigger:CmlConnectInfosMsg):void
		{
			var msg:CmlConnectInfosMsg = new CmlConnectInfosMsg();
			msg.type = "getOperatorPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
	
	}
}