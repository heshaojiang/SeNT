package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.TransInfoMsg;
	
	public class TransBanknoteSeqHourDelegate extends DelegateBase
	{
		/**
		 * 根据交易信息查找对应的冠字号码信息
		 * */
		[Command(selector="getTransHourBankNote")]
		public function getTransHourBankNote(msg:TransInfoMsg):AsyncToken
		{
			return call("getTransBanknoteSeqHourByTranId", msg.args["page"], msg.args["id"], 
				 msg.args["tranMonthDay"]);
		}
		[CommandResult(selector="getTransHourBankNote")]
		public function getTransHourBankNoteResultHandler(p_result:ResultEvent, trigger:TransInfoMsg):void
		{
			var msg:TransInfoMsg = new TransInfoMsg();
			msg.type = "getTransHourBankNoteResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	}
}