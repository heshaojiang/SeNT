package platform.card.delegate
{
	import platform.layer.DelegateBase;
	
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.card.message.CardTypeMsg;
	import platform.common.manager.LanguageManager;

	public class CardTypeDelegate extends DelegateBase
	{
		/**
		 * Language Manager
		 * */
		private var langMgr:LanguageManager = LanguageManager.getInstance();
		
		/**
		 * Asynchronous call the remote interface
		 **/
		
		/**
		 * New
		 */
		[Command(selector = "saveCardType")]
		public function newCardType(p_msg:CardTypeMsg):AsyncToken
		{
			return call("saveCardType", p_msg.args["data"]);
		}
		[CommandResult(selector = "saveCardType")]
		public function saveResultHandler(p_result:ResultEvent, tigger:CardTypeMsg):void
		{
			var msg:CardTypeMsg = new CardTypeMsg();
			msg.type = "saveCardTypeResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * Batch Delete
		 */
		[Command(selector = "batchDelete")]
		public function delSelectedCardType(p_msg:CardTypeMsg):AsyncToken
		{
			return call("batchDelete", p_msg.args["ids"]);
		}
		[CommandResult(selector = "batchDelete")]
		public function delResultHandler(p_result:ResultEvent, tigger:CardTypeMsg):void
		{
			var msg:CardTypeMsg = new CardTypeMsg();
			msg.type = "saveCardTypeResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * Update
		 */
		[Command(selector = "updateCardType")]
		public function updateCardType(p_msg:CardTypeMsg):AsyncToken
		{
			return call("updateCardType", p_msg.args["data"]);
		}
		[CommandResult(selector = "updateCardType")]
		public function updateResultHandler(p_result:ResultEvent, tigger:CardTypeMsg):void
		{
			var msg:CardTypeMsg = new CardTypeMsg();
			msg.type = "saveCardTypeResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * Search
		 */
		[Command(selector = "searchCardType")]
		public function searchCardType(p_msg:CardTypeMsg):AsyncToken
		{
			return call("searchCardTypeByParams", p_msg.args["page"], p_msg.args["cond"]);
		}
		[CommandResult(selector = "searchCardType")]
		public function searchCardTypeHandler(p_result:ResultEvent, tigger:CardTypeMsg):void
		{
			var msg:CardTypeMsg = new CardTypeMsg();
			msg.type = "searchCardTypeResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * Synchronize
		 */
		[Command(selector = "sychronizeSubOrg")]
		public function sychronizeSubOrg(p_msg:CardTypeMsg):AsyncToken
		{
			return call("sychronizeSubOrg", p_msg.args["orgId"]);
		}
		[CommandResult(selector = "sychronizeSubOrg")]
		public function sychronizeSubOrgHandler(p_result:ResultEvent, tigger:CardTypeMsg):void
		{
			var msg:CardTypeMsg = new CardTypeMsg();
			msg.type = "sychronizeSubOrgResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	}
}