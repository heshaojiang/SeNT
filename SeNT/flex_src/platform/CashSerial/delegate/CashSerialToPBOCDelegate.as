package platform.CashSerial.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.CashSerial.message.CashSerialToPBOCMsg;
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.security.message.UserMsg;
	
	public class CashSerialToPBOCDelegate extends DelegateBase
	{
		[Inject(id="cashSerialToPBOCService")]
		public var ro:RemoteObject;
		
		[Init]
		public function init():void
		{
			super._ro = ro;
		}
		
		
		
		
		
		
		
		
		
		[Command(selector="newCashSerialToPBOC")]
		public function newCashSerialToPBOC(p_msg:CashSerialToPBOCMsg):AsyncToken
		{
			return call("newCashSerialToPBOC", p_msg.args["vo"],p_msg.args["selectedDays"],p_msg.args["unselectedDays"]);
		}
		
		[CommandResult(selector="newCashSerialToPBOC")]
		public function newCashSerialToPBOCResult(p_result:ResultEvent, trigger:CashSerialToPBOCMsg):void
		{
			var msg:CashSerialToPBOCMsg = new CashSerialToPBOCMsg();
			msg.type = "newCashSerialToPBOCResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		
		[Command(selector="getSelectDay")]
		public function getSelectDay(p_msg:CashSerialToPBOCMsg):AsyncToken
		{
			return call("getSelectDay", p_msg.args["vo"]);
		}
		
		[CommandResult(selector="getSelectDay")]
		public function getSelectDayResult(p_result:ResultEvent, trigger:CashSerialToPBOCMsg):void
		{
			var msg:CashSerialToPBOCMsg = new CashSerialToPBOCMsg();
			msg.type = "getSelectDayResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		[Command(selector="deleteSelectedCashSerialToPBOC")]
		public function deleteSelectedCashSerialToPBOC(p_msg:CashSerialToPBOCMsg):AsyncToken
		{
			return call("deleteSelectedCashSerialToPBOC", p_msg.args["ids"]);
		}
		
		[CommandResult(selector="deleteSelectedCashSerialToPBOC")]
		public function deleteSelectedCashSerialToPBOCResult(p_result:ResultEvent, trigger:CashSerialToPBOCMsg):void
		{
			var msg:CashSerialToPBOCMsg = new CashSerialToPBOCMsg();
			msg.type = "deleteSelectedCashSerialToPBOCResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		
		
		
		
		[Command(selector="getCashSerialToPBOCPage")]
		public function getCashSerialToPBOCPage(p_msg:CashSerialToPBOCMsg):AsyncToken
		{
			return call("getCashSerialToPBOCPage", p_msg.args["page"], p_msg.args["condition"]);
		}
		
		[CommandResult(selector="getCashSerialToPBOCPage")]
		public function getCashSerialToPBOCPageResult(p_result:ResultEvent, trigger:CashSerialToPBOCMsg):void
		{
			var msg:CashSerialToPBOCMsg = new CashSerialToPBOCMsg();
			msg.type = "getCashSerialToPBOCPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		
		
		
	}
		
		
		
		
	
}