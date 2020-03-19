package platform.area.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.area.message.AreaMsg;
	import platform.layer.DelegateBase;
	
	public class AreaDelegate extends DelegateBase
	{
		/**
		 * Inject the remote service
		 **/
		[Inject(id="areaService")]
		public var ro:RemoteObject;
		
		[Init]
		public function init():void
		{
			super._ro = ro;
		}
		
		/**
		 * batch delete items
		 * @param areaIds
		 * @param callback
		 * @return
		 * 
		 */		
		[Command(selector = "batchDelete")]
		public function batchDelete(p_msg:AreaMsg):AsyncToken
		{
			return call("batchDelete", p_msg.args["ids"]);
		}
		[CommandResult(selector = "batchDelete")]
		public function delResultHandler(p_result:ResultEvent, tigger:AreaMsg):void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "areaSaveSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * get the area paging infomations
		 * @param page
		 * @param condition
		 * @param callback
		 * @return
		 * 
		 */
		[Command(selector = "getAreaPage")]
		public function getAreaPage(p_msg:AreaMsg):AsyncToken
		{
			return call("getAreaPage", p_msg.args["page"], null, p_msg.args["cond"]);
		}
		[CommandResult(selector = "getAreaPage")]
		public function getAreaPageHandler(p_result:ResultEvent, tigger:AreaMsg):void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "getAreaPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * get area tree
		 * @param p_msg
		 * @return
		 * 
		 */		
		[Command(selector = "getAreaTree")]
		public function getAreaTree(p_msg:AreaMsg):AsyncToken
		{
			return call("getAreaTree", UserInfoInit.userInfo["areaId"]);
		}
		[CommandResult(selector = "getAreaTree")]
		public function getAreaTreeHandler(p_result:ResultEvent, tigger:AreaMsg):void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "getAreaTreeResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}		
		
		/**
		 * get area
		 * @return
		 * 
		 */		
		[Command(selector = "getAreaById")]
		public function getAreaById(p_msg:AreaMsg):AsyncToken
		{
			return call("getArea", p_msg.args["areaId"]);
		}
		[CommandResult(selector = "getAreaById")]
		public function getAreaByIdResultHandler(p_result:ResultEvent, tigger:AreaMsg):void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "getAreaByIdResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}		
		
		/**
		 * 
		 * @param p_msg
		 * @return
		 */		
		[Command(selector = "getMaxOrderValue")]
		public function getMaxOrderValue(p_msg:AreaMsg):AsyncToken
		{
			return call("getMaxOrderValue", p_msg.args["parentId"]);
		}
		[CommandResult(selector = "getMaxOrderValue")]
		public function getMaxOrderValueHandler(p_result:ResultEvent, tigger:AreaMsg):void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "getMaxOrderValueResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * Create a new area
		 * @param entity
		 * 
		 * */
		[Command(selector = "newArea")]
		public function newArea(p_msg:AreaMsg):AsyncToken
		{
			return call("newArea", p_msg.args["vo"]);
		}
		[CommandResult(selector = "newArea")]
		public function newAreaHandler(p_result:ResultEvent, tigger:AreaMsg):void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "refreshAreaList";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[CommandError(selector="newArea")]
		public function newAreaErrorHandler(p_fault:FaultEvent, trigger:AreaMsg):void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "saveError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
		
		/**
		 *  Update an existed area
		 * */
		[Command(selector = "updateArea")]
		public function updateArea(p_msg:AreaMsg):AsyncToken
		{
			return call("updateArea", p_msg.args["vo"]);
		}
		[CommandResult(selector = "updateArea")]
		public function updateAreaHandler(p_result:ResultEvent, tigger:AreaMsg):void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "refreshAreaList";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[CommandError(selector="updateArea")]
		public function updateAreaErrorHandler(p_fault:FaultEvent, trigger:AreaMsg):void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "saveError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
		
		/**
		 * 
		 * */
		[Command(selector = "update")]
		public function update(p_msg:AreaMsg):AsyncToken
		{
			return call("update", p_msg.args["vo"]);
		}
		[CommandResult(selector = "update")]
		public function updateHandler(p_result:ResultEvent, tigger:AreaMsg):void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "updateResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * find by userName
		 * */
		[Command(selector = "searchAreaByAreaName")]
		public function searchAreaByAreaName(p_msg:AreaMsg):AsyncToken
		{
			return call("searchAreaByAreaName", p_msg.args["page"], p_msg.args["areaName"]);
		}
		[CommandResult(selector = "searchAreaByAreaName")]
		public function searchAreaByAreaNameHandler(p_result:ResultEvent, tigger:AreaMsg):void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "searchAreaByAreaNameResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	}
}