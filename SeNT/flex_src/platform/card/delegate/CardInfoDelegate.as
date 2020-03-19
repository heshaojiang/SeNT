package platform.card.delegate
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.card.message.CardInfoMsg;
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;

	public class CardInfoDelegate extends DelegateBase
	{
		/**
		 * Inject the remote service
		 **/
		[Inject(id="cardInfoService")]
		public var ro:RemoteObject;
		
		/**
		 * Language Manager
		 * */
		private var langMgr:LanguageManager = LanguageManager.getInstance();
		
		[Init]
		public function init():void
		{
			super._ro = ro;
		}
		
		/**
		 * Asynchronous call the remote interface
		 **/
		
		/**
		 * New
		 */
		[Command(selector = "newCardInfo")]
		public function newCardInfo(p_msg:CardInfoMsg):AsyncToken
		{
			return call("newCardInfo", p_msg.args["data"]);
		}
		[CommandResult(selector = "newCardInfo")]
		public function saveResultHandler(p_result:ResultEvent, tigger:CardInfoMsg):void
		{
			var msg:CardInfoMsg = new CardInfoMsg();
			msg.type = "cardInfoSaveSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * Batch Delete
		 */
		[Command(selector = "batchDelete")]
		public function delSelectedCardInfo(p_msg:CardInfoMsg):AsyncToken
		{
			return call("batchDelete", p_msg.args["ids"]);
		}
		[CommandResult(selector = "batchDelete")]
		public function delResultHandler(p_result:ResultEvent, tigger:CardInfoMsg):void
		{
			var msg:CardInfoMsg = new CardInfoMsg();
			msg.type = "cardInfoSaveSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * Update
		 */
		[Command(selector = "updateCardInfo")]
		public function updateCardInfo(p_msg:CardInfoMsg):AsyncToken
		{
			return call("updateCardInfo", p_msg.args["data"]);
		}
		[CommandResult(selector = "updateCardInfo")]
		public function updateResultHandler(p_result:ResultEvent, tigger:CardInfoMsg):void
		{
			var msg:CardInfoMsg = new CardInfoMsg();
			msg.type = "cardInfoSaveSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * Search
		 */
		[Command(selector = "searchCardInfo")]
		public function searchCardInfo(p_msg:CardInfoMsg):AsyncToken
		{
			return call("searchCardInfo", p_msg.args["page"], p_msg.args["cardId"]);
		}
		[CommandResult(selector = "searchCardInfo")]
		public function searchCardInfoHandler(p_result:ResultEvent, tigger:CardInfoMsg):void
		{
			var msg:CardInfoMsg = new CardInfoMsg();
			msg.type = "searchCardInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	}
}