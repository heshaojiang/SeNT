package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import org.spicefactory.parsley.core.messaging.command.Command;
	import org.spicefactory.parsley.core.messaging.impl.Selector;
	
	import platform.layer.DelegateBase;
	
	import sent.common.utils.TestUtils;
	import sent.transmgr.message.CmlNoteflowDetailInfoMsg;
	
	public class CmlNoteflowDetailInfoDelegate extends DelegateBase
	{
		/**
		 * 
		 */		
		[Command(selector="getCmlNoteflowDetailInfosPageByFlowNum")]
		public function getCmlNoteflowDetailInfosPageByFlowNum(msg:CmlNoteflowDetailInfoMsg):AsyncToken
		{
			return call("getCmlNoteflowDetailInfosPageByFlowNum", msg.args["page"], msg.args["barcodeFlowNum"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="getCmlNoteflowDetailInfosPageByFlowNum")]
		public function getCmlNoteflowDetailInfosPageByFlowNumResultHandler(p_result:ResultEvent, trigger:CmlNoteflowDetailInfoMsg):void
		{
			trigger.type = "getCmlNoteflowDetailInfosPageByFlowNumResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
	
		/**
		 */		
		[Command(selector="queryCmlNoteflowDetailInfoPage")]
		public function queryCmlNoteflowDetailInfoPage(msg:CmlNoteflowDetailInfoMsg):AsyncToken
		{
			return call("queryCmlNoteflowDetailInfoPage", msg.args["page"], msg.args["condition"]);
		}
		
		/**		  
		 */
		[CommandResult(selector="queryCmlNoteflowDetailInfoPage")]
		public function queryCmlNoteflowDetailInfoPageResultHandler(p_result:ResultEvent, trigger:CmlNoteflowDetailInfoMsg):void
       {
		trigger.type = "queryCmlNoteflowDetailInfoPageResult";
		trigger.result = p_result.result;
		sendMessage(trigger);
		}
		
		
		
		
		
		
		
		
		
		
		
		////////////////////////////////////////////
		
		/**
		 * 
		 */		
		[Command(selector="CmlNoteflowDetailInfoDelegate:com.grgbanking.sent.transmgr.service.CmlNoteflowDetailInfoService")]
		public function executeCommandForCmlNoteflowDetailInfoMsg(msg:CmlNoteflowDetailInfoMsg):AsyncToken
		{
			trace("CmlNoteflowDetailInfoDelegate.executeCommandForCmlNoteflowDetailInfoMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="CmlNoteflowDetailInfoDelegate:com.grgbanking.sent.transmgr.service.CmlNoteflowDetailInfoService")]
		public function executeCommandForCmlNoteflowDetailInfoMsgResultHandler(result:ResultEvent, trigger:CmlNoteflowDetailInfoMsg):void
		{
			trace("CmlNoteflowDetailInfoDelegate.executeCommandForCmlNoteflowDetailInfoMsgResultHandler");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="CmlNoteflowDetailInfoDelegate:com.grgbanking.sent.transmgr.service.CmlNoteflowDetailInfoService")]
		public function executeCommandForCmlNoteflowDetailInfoMsgErrorHandler(fault:FaultEvent, trigger:CmlNoteflowDetailInfoMsg):void
		{
			trace("CmlNoteflowDetailInfoDelegate.executeCommandForCmlNoteflowDetailInfoMsgErrorHandler");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		///////////////////////////////
		
		
		
		
		
		
		
		
		
		
		
		
		
//		[Command(selector="getCashBackInfo")]
//		public function getCashBackInfo(msg:CmlNoteflowDetailInfoMsg):AsyncToken
//		{
//			return call("getCashBackInfo",msg.args["page"],msg.args["condition"]);
//		}
//		[CommandResult(selector="getCashBackInfo")]
//		public function getCashBackInfoResult(p_result:ResultEvent,trigger:CmlNoteflowDetailInfoMsg):void
//		{
//			var msg:CmlNoteflowDetailInfoMsg = new CmlNoteflowDetailInfoMsg();
//			msg.type = "getCashBackInfoResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
//		
//		[Command(selector="cashIn")]
//		public function cashIn(msg:CmlNoteflowDetailInfoMsg):AsyncToken
//		{
//			return call("cashIn",msg.args["type"],msg.args["condi"]);
//		}
//		[CommandResult(selector="cashIn")]
//		public function cashInResult(p_result:ResultEvent,trigger:CmlNoteflowDetailInfoMsg):void
//		{
//			var msg:CmlNoteflowDetailInfoMsg = new CmlNoteflowDetailInfoMsg();
//			msg.type = "cashInResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
//		
//		[Command(selector="getInfo")]
//		public function getInfo(msg:CmlNoteflowDetailInfoMsg):AsyncToken
//		{
//			return call("getInfo",msg.args["condi"]);
//		}
//		[CommandResult(selector="getInfo")]
//		public function getInfoResult(p_result:ResultEvent,trigger:CmlNoteflowDetailInfoMsg):void
//		{
//			var msg:CmlNoteflowDetailInfoMsg = new CmlNoteflowDetailInfoMsg();
//			msg.type = "getInfoResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		
		//////////////////////////////////
	}
}