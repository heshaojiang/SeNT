package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.CmlNoteflowInfoMsg;
	
	public class CmlNoteflowInfoDelegate extends DelegateBase
	{
		/**
		 * 根据条件查询交易监控信息
		 */		
		[Command(selector="getCmlNoteflowInfoPage")]
		public function getCmlNoteflowInfoPage(msg:CmlNoteflowInfoMsg):AsyncToken
		{
			trace("CmlNoteflowInfoDelegate.getCmlNoteflowInfoPage");
			return call("getCmlNoteflowInfoPage", msg.args["page"], msg.args["condition"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="getCmlNoteflowInfoPage")]
		public function getCmlNoteflowInfoPageResultHandler(p_result:ResultEvent, trigger:CmlNoteflowInfoMsg):void
		{
			trace("CmlNoteflowInfoDelegate.getCmlNoteflowInfoPageResultHandler");
			var msg:CmlNoteflowInfoMsg = new CmlNoteflowInfoMsg();
			msg.type = "getCmlNoteflowInfoPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		//////////////////////////////////
		
		/**
		 * 
		 */		
		[Command(selector="CmlNoteflowInfoDelegate:com.grgbanking.sent.transmgr.service.CmlNoteflowInfoService")]
		public function executeCommandForCmlNoteflowInfoMsg(msg:CmlNoteflowInfoMsg):AsyncToken
		{
			trace("CmlNoteflowInfoDelegate.executeCommandForCmlNoteflowInfoMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="CmlNoteflowInfoDelegate:com.grgbanking.sent.transmgr.service.CmlNoteflowInfoService")]
		public function executeCommandForCmlNoteflowInfoMsgResultHandler(result:ResultEvent, trigger:CmlNoteflowInfoMsg):void
		{
			trace("CmlNoteflowInfoDelegate.executeCommandForCmlNoteflowInfoMsgResultHandler");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="CmlNoteflowInfoDelegate:com.grgbanking.sent.transmgr.service.CmlNoteflowInfoService")]
		public function executeCommandForCmlNoteflowInfoMsgErrorHandler(fault:FaultEvent, trigger:CmlNoteflowInfoMsg):void
		{
			trace("CmlNoteflowInfoDelegate.executeCommandForCmlNoteflowInfoMsgErrorHandler");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		//////////////////////////////////
	}
}