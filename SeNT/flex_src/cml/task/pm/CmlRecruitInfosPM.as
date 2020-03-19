package cml.task.pm
{
	import cml.task.message.CmlRecruitInfosMsg;
	import cml.task.vo.CmlSentInfosVO;
	import cml.task.vo.CmlTaskInfosVO;
	
	import org.spicefactory.parsley.core.messaging.Message;
	
	import platform.common.vo.Page;
	import platform.component.controls.MsgTip;
	import platform.layer.BasePM;

	public class CmlRecruitInfosPM extends BasePM
	{
		public function CmlRecruitInfosPM()
		{
		}
		
		[Bindable]
		public var condi:Object=new Object();
		
		[Bindable]
		public var page:Page=new Page();
		
		[Bindable]
		public var bankNotesResult:Page=new Page();
		
		[Bindable]
		public var cmlTaskInfos:CmlTaskInfosVO=new CmlTaskInfosVO();
		
		[Bindable]
		public var cmlSentInfos:CmlSentInfosVO=new CmlSentInfosVO();
		
		public function getCmlRecruitInfos():void
		{
			var msg:CmlRecruitInfosMsg=new CmlRecruitInfosMsg();
			msg.type="getCmlRecruitInfos";
			msg.args["page"]=page;
			msg.args["tmlNum"]=condi.tmlNum;
			msg.args["operatorName"]=condi.operatorName;
			msg.args["startTime"]=condi.startTime;
			msg.args["endTime"]=condi.endTime;
			sendMessage(msg);
		}
		
		[MessageHandler(selector="getCmlRecruitInfosResult")]
		public function getCmlRecruitInfosResult(msg:CmlRecruitInfosMsg):void
		{
			if(msg)
				page=msg.result as Page;
		}
		
		public function saveCmlTaskInfos(cmlTaskInfos:CmlTaskInfosVO):void
		{
			var msg:CmlRecruitInfosMsg=new CmlRecruitInfosMsg();
			msg.type="saveCmlTaskInfos";
			msg.args["cmlTaskInfos"]=cmlTaskInfos;
			sendMessage(msg);
		}
		
		public function getBankNotes():void
		{
			var msg:CmlRecruitInfosMsg=new CmlRecruitInfosMsg();
			msg.type="getBankNotes";
			msg.args["page"]=bankNotesResult;
			msg.args["seriaNum"]=condi.seriaNum;
			msg.args["tranId"]=cmlTaskInfos.id;
			msg.args["moneyType"]=condi.moneyType;
			sendMessage(msg);
		}
		
		[MessageHandler(selector="getBankNotesResult")]
		public function getBankNotesResult(msg:CmlRecruitInfosMsg):void
		{
			if(msg)
				bankNotesResult=msg.result as Page;
		}
		
		public function delBankNote(id:String):void
		{
			var msg:CmlRecruitInfosMsg=new CmlRecruitInfosMsg();
			msg.type="delBankNote";
			msg.args["id"]=id;
			sendMessage(msg);
		}
		
		public function saveCmlSentInfos():void
		{
			var msg:CmlRecruitInfosMsg=new CmlRecruitInfosMsg();
			msg.type="saveCmlSentInfos";
			msg.args["cmlSentInfos"]=cmlSentInfos;
			msg.args["cmlTaskInfos"]=cmlTaskInfos;
			sendMessage(msg);
		}
		

	}
}