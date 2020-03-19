package platform.term.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.term.constants.TermLocalKeyConsts;
	import platform.term.message.TermInfoMsg;

	public class TermInfoDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="termInfoService")]
		public var ro:RemoteObject;
		
		/**语言包**/
		private var langMgr:LanguageManager = LanguageManager.getInstance();

		[Init]
		public function init():void
		{
			super._ro = ro;
		}
		
		/*****************************************
		 * 异步调用远程接口
		 *****************************************/
		
		/**
		 * 保存
		 */		
		[Command(selector="save")]
		public function saveTermInfo(p_msg:TermInfoMsg):AsyncToken
		{
			if( p_msg.args["data"]["formType"] == TermLocalKeyConsts.UPDATE_TERMINFO_FORM )
			{
				return call("updateTerminalInfo", p_msg.args["data"]);
			}
			return call("saveTerminalInfo", p_msg.args["data"]);
		}
		
		[CommandResult(selector="save")]
		public function saveResultHandler(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="save")]
		public function saveErrorHandler(p_fault:FaultEvent, trigger:TermInfoMsg):void
		{
			//todo anything;
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "saveError";
			msg.result = p_fault.fault;
			sendMessage(msg);
		}
		

		
		[Command(selector="exportTermInfo")]
		public function exportTermInfo(p_msg:TermInfoMsg):AsyncToken
		{
			/*if( p_msg.args["data"]["formType"] == TermLocalKeyConsts.UPDATE_TERMINFO_FORM )
			{
			return call("updateTerminalInfo", p_msg.args["data"]);
			}*/
			return call("exportTermInfo", p_msg.args["condi"]);
		}
		
		[CommandResult(selector="exportTermInfo")]
		public function exportTermInfoResultHandler(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "exportOrgInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 
		 */		
		[Command(selector="getTermInfoFormInitDatas")]
		public function getTermInfoFormInitDatas(p_msg:TermInfoMsg):AsyncToken
		{
			return call("getTermInfoFormInitDatas",langMgr.currentLanguage);
		}
		[CommandResult(selector="getTermInfoFormInitDatas")]
		public function getTermInfoFormInitDatasResultHandler(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoFormInitDatasResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="getTermInfoFormInitDatas")]
		public function getTermInfoFormInitDatasErrorHandler(p_fault:FaultEvent, trigger:TermInfoMsg):void
		{
			//todo anything;
		}
		
		
		/**
		 * 删除 
		 */		
		[Command(selector="delete")]
		public function delTermInfo(p_msg:TermInfoMsg):AsyncToken
		{
			return call("batchDelete", p_msg.args["ids"]);
		}
		[CommandResult(selector="delete")]
		public function delTermInfoResultHandler(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "delResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 刷新获取页面的数据
		 */		
		[Command(selector="getTermInfoPage")]
		public function getTermInfoPage(p_msg:TermInfoMsg):AsyncToken
		{
			return call("getTermInfoPageByParams", p_msg.args["page"], p_msg.args["condi"]);
		}
		[CommandResult(selector="getTermInfoPage")]
		public function getPageResultHandler(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 
		 */
		[Command(selector = "importTermInfoExcel")]
		public function importExcel(p_msg:TermInfoMsg):AsyncToken
		{
			return call("importTermInfoExcel", p_msg.args["bytes"]);
		}
		[CommandResult(selector = "importTermInfoExcel")]
		public function importExcelHandler(p_result:ResultEvent, tigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "importTermInfoExcelResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[Command(selector = "getTermInfoForPrint")]
		public function getTermInfoForPrint(p_msg:TermInfoMsg):AsyncToken
		{
			return call("getTermInfoForPrint", p_msg.args["termCode"]);
		}
		[CommandResult(selector = "getTermInfoForPrint")]
		public function getTermInfoForPrintHandler(p_result:ResultEvent, tigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoForPrintResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		//////////////////////////////////
		
		/**
		 * 
		 */		
		[Command(selector="TermInfoDelegate:com.grgbanking.platform.module.term.service.TermInfoService")]
		public function executeCommandForTermInfoMsg(msg:TermInfoMsg):AsyncToken
		{
			trace("TermInfoDelegate.executeCommandForTermInfoMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="TermInfoDelegate:com.grgbanking.platform.module.term.service.TermInfoService")]
		public function executeCommandForTermInfoMsgCommandResult(result:ResultEvent, trigger:TermInfoMsg):void
		{
			trace("TermInfoDelegate.executeCommandForTermInfoMsgCommandResult");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="TermInfoDelegate:com.grgbanking.platform.module.term.service.TermInfoService")]
		public function executeCommandForTermInfoMsgCommandError(fault:FaultEvent, trigger:TermInfoMsg):void
		{
			trace("TermInfoDelegate.executeCommandForTermInfoMsgCommandError");
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		//////////////////////////////////
	}
}