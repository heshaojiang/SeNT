package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.TransBankNoteSeqAllMsg;

	public class TransBankNoteSeqAllDelegate extends DelegateBase
	{
		
//		/**
//		 * 获取冠字号码追踪列表
//		 */
//		[Command(selector="getTransBankNoteSeqAllPage")]
//		public function getTransBankNoteSeqAll(p_msg:TransBankNoteSeqAllMsg):AsyncToken
//		{
//			trace("TransBankNoteSeqAllDelegate.getTransBankNoteSeqAll-getTransBankNoteSeqAllPage");
//			return call("getTransBankNoteSeqAllPage",  p_msg.args["page"], p_msg.args["vo"], p_msg.args["startTime"], p_msg.args["endTime"], p_msg.args["fuzzyCount"]);
//		}
//		
//		/**
//		 * 
//		 */
//		[CommandResult(selector="getTransBankNoteSeqAllPage")]
//		public function getTransBankNoteSeqAllResult(p_result:ResultEvent,trigger:TransBankNoteSeqAllMsg):void
//		{
//			trace("TransBankNoteSeqAllDelegate.getTransBankNoteSeqAllResult-getTransBankNoteSeqAllPage");
//			trigger.type = "getTransBankNoteSeqAllPageResult";
//			trigger.result = p_result.result;
//			sendMessage(trigger);
//		}
		
		/**
		 * 根据条件参数获取冠字号检索的时间范围
		 */		
		[Command(selector="getInitParamMap")]
		public function getInitParamMap(msg:TransBankNoteSeqAllMsg):AsyncToken
		{
			trace("TransBankNoteSeqAllDelegate.getInitParamMap-getInitParamMap");
			return call("getInitParamMap");
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="getInitParamMap")]
		public function getInitParamMapResult(p_result:ResultEvent, trigger:TransBankNoteSeqAllMsg):void
		{
			trace("TransBankNoteSeqAllDelegate.getInitParamMapResult-getInitParamMap");
			var msg:TransBankNoteSeqAllMsg = new TransBankNoteSeqAllMsg();
			msg.type = "getInitParamMapResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	
	
//		/**
//		 * 获取冠字号码列表
//		 */
//		[Command(selector="getTransAllBanknoteSeqByTranId")]
//		public function getTransAllBanknoteSeqByTranId(p_msg:TransBankNoteSeqAllMsg):AsyncToken
//		{
//			trace("TransBankNoteSeqAllDelegate.getTransAllBanknoteSeqByTranId-getTransAllBanknoteSeqByTranId");
//			return call("getTransAllBanknoteSeqByTranId",p_msg.args["page"],p_msg.args["id"],p_msg.args["tranMonthDay"]);
//		}
//		
//		/**
//		 * 
//		 */
//		[CommandResult(selector="getTransAllBanknoteSeqByTranId")]
//		public function getTransAllBanknoteSeqByTranIdResult(p_result:ResultEvent, trigger:TransBankNoteSeqAllMsg):void
//		{
//			trace("TransBankNoteSeqAllDelegate.getTransAllBanknoteSeqByTranIdResult-getTransAllBanknoteSeqByTranId");
//			trigger.type = "getTransAllBanknoteSeqByTranIdResult";
//			trigger.result = p_result.result;
//			sendMessage(trigger);
//		}
		
		
		/**
		 * 
		 */		
		[Command(selector="TransBankNoteSeqAllDelegate:com.grgbanking.sent.transmgr.service.TransBankNoteSeqAllService")]
		public function executeCommandForTransBanknoteSeqAllMsg(msg:TransBankNoteSeqAllMsg):AsyncToken
		{
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="TransBankNoteSeqAllDelegate:com.grgbanking.sent.transmgr.service.TransBankNoteSeqAllService")]
		public function executeCommandForTransBanknoteSeqAllMsgResultHandler(result:ResultEvent, trigger:TransBankNoteSeqAllMsg):void
		{
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="TransBankNoteSeqAllDelegate:com.grgbanking.sent.transmgr.service.TransBankNoteSeqAllService")]
		public function executeCommandForTransBanknoteSeqAllMsgErrorHandler(fault:FaultEvent, trigger:TransBankNoteSeqAllMsg):void
		{
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
	}
}