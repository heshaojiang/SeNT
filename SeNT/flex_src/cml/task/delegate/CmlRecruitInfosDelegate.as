package cml.task.delegate
{
	import cml.task.config.CmlRecruitInfosConfig;
	import cml.task.message.CmlRecruitInfosMsg;
	
	import flash.net.sendToURL;
	
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import org.spicefactory.parsley.core.messaging.command.Command;
	
	import platform.layer.DelegateBase;

	public class CmlRecruitInfosDelegate extends DelegateBase
	{
		public function CmlRecruitInfosDelegate()
		{
		}
		
		[Command(selector="getCmlRecruitInfos")]
		public function getCmlRecruitInfos(msg:CmlRecruitInfosMsg):AsyncToken
		{
			return call("getCmlRecruitInfos",msg.args["page"],msg.args["tmlNum"],msg.args["operatorName"],msg.args["startTime"],msg.args["endTime"]);
		}
		
		[CommandResult(selector="getCmlRecruitInfos")]
		public function getCmlRecruitInfosResult(result:ResultEvent,trigger:CmlRecruitInfosMsg):void
		{
			trigger.type="getCmlRecruitInfosResult";
			trigger.result=result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="saveCmlSentInfos")]
		public function saveCmlSentInfos(msg:CmlRecruitInfosMsg):AsyncToken
		{
			return call("saveCmlSentInfos",msg.args["cmlSentInfos"],msg.args["cmlTaskInfos"]);
		}
		
		[CommandResult(selector="saveCmlSentInfos")]
		public function saveCmlSentInfosResult(result:ResultEvent,msg:CmlRecruitInfosMsg):void
		{
			msg.type="saveCmlSentInfoResult";
			msg.result=result.result;
			sendMessage(msg);
		}
		
		[Command(selector="saveCmlTaskInfos")]
		public function saveCmlTaskInfos(msg:CmlRecruitInfosMsg):AsyncToken
		{
			return call("saveCmlTaskInfos",msg.args["cmlTaskInfos"]);
		}
		
		[CommandResult(selector="saveCmlTaskInfos")]
		public function saveCmlTaskInfosResult(result:ResultEvent,msg:CmlRecruitInfosMsg):void
		{
		}
		
		[Command(selector="getBankNotes")]
		public function getBankNotes(msg:CmlRecruitInfosMsg):AsyncToken
		{
			return call("getBankNotes",msg.args["page"],msg.args["tranId"],msg.args["seriaNum"],msg.args["moneyType"]);
		}
		
		[CommandResult(selector="getBankNotes")]
		public function getBankNotesResult(result:ResultEvent,msg:CmlRecruitInfosMsg):void
		{
			msg.type="getBankNotesResult";
			msg.result=result.result;
			sendMessage(msg);
		}
		
		[Command(selector="delBankNote")]
		public function delBankNote(msg:CmlRecruitInfosMsg):AsyncToken
		{
			return call("delBankNote",msg.args["id"]);
		}
		
		[CommandResult(selector="delBankNote")]
		public function delBankNoteResult(result:ResultEvent,msg:CmlRecruitInfosMsg):void
		{
			msg.type="delBankNoteResult";
			sendMessage(msg);
		}
	}
}