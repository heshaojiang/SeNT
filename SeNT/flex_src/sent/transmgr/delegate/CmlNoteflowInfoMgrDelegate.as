package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.events.FaultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.CmlNoteflowInfoMgrMsg;
	
	public class CmlNoteflowInfoMgrDelegate extends DelegateBase
	{
		/**
		 * 根据条件查询交易监控信息
		 */		
		[Command(selector="getCmlNoteflowInfoMgrPage")]
		public function getCmlNoteflowInfoMgrPage(msg:CmlNoteflowInfoMgrMsg):AsyncToken
		{
			trace("CmlNoteflowInfoMgrDelegate.getCmlNoteflowInfoMgrPage");
			return call("getCmlNoteflowInfoMgrPage", msg.args["page"], msg.args["condition"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="getCmlNoteflowInfoMgrPage")]
		public function getCmlNoteflowInfoMgrPageResultHandler(p_result:ResultEvent, trigger:CmlNoteflowInfoMgrMsg):void
		{
			trace("CmlNoteflowInfoMgrDelegate.getCmlNoteflowInfoMgrPageResultHandler");
			var msg:CmlNoteflowInfoMgrMsg = new CmlNoteflowInfoMgrMsg();
			msg.type = "getCmlNoteflowInfoMgrPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		/**
		 * 
		 */		
		[Command(selector="CmlNoteflowInfoMgrDelegate:com.grgbanking.sent.transmgr.service.CmlNoteflowInfoMgrService")]
		public function executeCommandForCmlSentInfoMsg(p_msg:CmlNoteflowInfoMgrMsg):AsyncToken
		{
			trace("CmlNoteflowInfoMgrDelegate.CmlNoteflowInfoMgrDelegate");
			return call(p_msg.args["remoteMethod"], p_msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="CmlNoteflowInfoMgrDelegate:com.grgbanking.sent.transmgr.service.CmlNoteflowInfoMgrService")]
		public function executeCommandForCmlSentInfoMsgResultHandler(p_result:ResultEvent, p_trigger:CmlNoteflowInfoMgrMsg):void
		{
			trace("CmlNoteflowInfoMgrDelegate.executeCommandForCmlSentInfoMsgResultHandler");
			p_trigger.type = p_trigger.args["resultHandler"];
			p_trigger.result = p_result.result;
			sendMessage(p_trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="CmlNoteflowInfoMgrDelegate:com.grgbanking.sent.transmgr.service.CmlNoteflowInfoMgrService")]
		public function executeCommandForCmlSentInfoMsgErrorHandler(fault:FaultEvent, trigger:CmlNoteflowInfoMgrMsg):void
		{
			trace("CmlNoteflowInfoMgrDelegate.executeCommandForCmlSentInfoMsgErrorHandler");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
	}
}