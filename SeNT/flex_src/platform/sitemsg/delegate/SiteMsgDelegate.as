package platform.sitemsg.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	import platform.sitemsg.message.SiteMsg;
	
	public class SiteMsgDelegate extends DelegateBase
	{
		[Command(selector="getReceivedMsg")]
		public function getReceivedMsg(p_msg:SiteMsg):AsyncToken{
			return call("getReceivedMsgByPage", p_msg.args["page"], UserInfoInit.userInfo["id"], p_msg.args["content"], p_msg.args["startTime"], p_msg.args["endTime"]);
		}
		[CommandResult(selector="getReceivedMsg")]
		public function getReceivedMsgHandler(p_result:ResultEvent, trigger:SiteMsg):void{
			trigger.type="getReceivedMsgResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="loadRecipient")]
		public function loadRecipient(p_msg:SiteMsg):AsyncToken{
			return call("loadRecipient");
		}
		[CommandResult(selector="loadRecipient")]
		public function loadRecipientHandler(p_result:ResultEvent, trigger:SiteMsg):void{
			trigger.type="loadRecipientResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="saveLetter")]
		public function saveLetter(p_msg:SiteMsg):AsyncToken{
			return call("saveLetter", p_msg.args["vo"]);
		}
		[CommandResult(selector="saveLetter")]
		public function saveLetterHandler(p_result:ResultEvent, trigger:SiteMsg):void{
			trigger.type="saveLetterResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="delReceivedMsgs")]
		public function delReceivedMsgs(p_msg:SiteMsg):AsyncToken{
			return call("delReceivedMsgs", UserInfoInit.userInfo["id"], p_msg.args["ids"]);
		}
		[CommandResult(selector="delReceivedMsgs")]
		public function delReceivedMsgsHandler(p_result:ResultEvent, trigger:SiteMsg):void{
			trigger.type="delReceivedMsgsResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="markReaded")]
		public function markReaded(p_msg:SiteMsg):AsyncToken{
			return call("markReaded", UserInfoInit.userInfo["id"], p_msg.args["siteMsgId"]);
		}
		[CommandResult(selector="markReaded")]
		public function markReadedHandler(p_result:ResultEvent, trigger:SiteMsg):void{
			trigger.type="markReadedResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/* SentMsg */
		[Command(selector="getSentMsg")]
		public function getSentMsg(p_msg:SiteMsg):AsyncToken{
			return call("getSentMsgByPage", p_msg.args["page"], UserInfoInit.userInfo["id"], p_msg.args["content"], p_msg.args["startTime"], p_msg.args["endTime"]);
		}
		[CommandResult(selector="getSentMsg")]
		public function getSentMsgHandler(p_result:ResultEvent, trigger:SiteMsg):void{
			trigger.type="getSentMsgResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}

		[Command(selector="delSentMsgs")]
		public function delSentMsgs(p_msg:SiteMsg):AsyncToken{
			return call("delSentMsgs", p_msg.args["ids"]);
		}
		[CommandResult(selector="delSentMsgs")]
		public function delSentMsgsHandler(p_result:ResultEvent, trigger:SiteMsg):void{
			trigger.type="delSentMsgsResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}

		[Command(selector="loadDetail")]
		public function loadDetail(p_msg:SiteMsg):AsyncToken{
			return call("loadDetail", p_msg.args["siteMsgId"]);
		}
		[CommandResult(selector="loadDetail")]
		public function loadDetailHandler(p_result:ResultEvent, trigger:SiteMsg):void{
			trigger.type="loadDetailResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
	}
}