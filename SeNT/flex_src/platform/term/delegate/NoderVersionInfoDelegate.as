package platform.term.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.term.constants.TermLocalKeyConsts;
	import platform.term.message.NoderVersionInfoMsg;

	public class NoderVersionInfoDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="noderVersionInfoService")]
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
		
		[Command(selector="auditRegulation")]
		public function auditRegulation(p_msg:NoderVersionInfoMsg):AsyncToken
		{
			return call("auditRegulation", p_msg.args["data"]);
		}
		
		[CommandResult(selector="auditRegulation")]
		public function auditRegulationHandler(p_result:ResultEvent, trigger:NoderVersionInfoMsg):void
		{
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "auditRegulationResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="auditRegulation")]
		public function auditRegulationErrorHandler(p_fault:FaultEvent, trigger:NoderVersionInfoMsg):void
		{
			//todo anything;
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "auditRegulationError";
			msg.result = p_fault.fault;
			sendMessage(msg);
		}
		
		/**
		 * 保存
		 */		
		[Command(selector="save")]
		public function saveNoderVersionInfo(p_msg:NoderVersionInfoMsg):AsyncToken
		{
			if( p_msg.args["data"]["formType"] == TermLocalKeyConsts.UPDATE_TERMINFO_FORM )
			{
				return call("updateNoderinalInfo", p_msg.args["data"]);
			}
			return call("saveNoderinalInfo", p_msg.args["data"]);
		}
		
		[CommandResult(selector="save")]
		public function saveResultHandler(p_result:ResultEvent, trigger:NoderVersionInfoMsg):void
		{
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="save")]
		public function saveErrorHandler(p_fault:FaultEvent, trigger:NoderVersionInfoMsg):void
		{
			//todo anything;
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "saveError";
			msg.result = p_fault.fault;
			sendMessage(msg);
		}
		

		
		[Command(selector="exportNoderVersionInfo")]
		public function exportNoderVersionInfo(p_msg:NoderVersionInfoMsg):AsyncToken
		{
			/*if( p_msg.args["data"]["formType"] == NoderLocalKeyConsts.UPDATE_TERMINFO_FORM )
			{
			return call("updateNoderinalInfo", p_msg.args["data"]);
			}*/
			return call("exportNoderVersionInfo", p_msg.args["condi"]);
		}
		
		[CommandResult(selector="exportNoderVersionInfo")]
		public function exportNoderVersionInfoResultHandler(p_result:ResultEvent, trigger:NoderVersionInfoMsg):void
		{
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "exportOrgInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 
		 */	
		[Command(selector="getNoderVersionInfoFormInitDatas")]
		public function getNoderVersionInfoFormInitDatas(p_msg:NoderVersionInfoMsg):AsyncToken
		{
			trace("NoderVersionInfoDelegate.getNoderVersionInfoFormInitDatas") ;
			return call("getNoderVersionInfoFormInitDatas",langMgr.currentLanguage);
		}
		[CommandResult(selector="getNoderVersionInfoFormInitDatas")]
		public function getNoderVersionInfoFormInitDatasResultHandler(p_result:ResultEvent, trigger:NoderVersionInfoMsg):void
		{
			trace("NoderVersionInfoDelegate.getNoderVersionInfoFormInitDatasResultHandler") ;
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "getNoderVersionInfoFormInitDatasResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="getNoderVersionInfoFormInitDatas")]
		public function getNoderVersionInfoFormInitDatasErrorHandler(p_fault:FaultEvent, trigger:NoderVersionInfoMsg):void
		{
			//todo anything;
		}
		
		
		/**
		 * 删除 
		 */		
		[Command(selector="delete")]
		public function delNoderVersionInfo(p_msg:NoderVersionInfoMsg):AsyncToken
		{
			return call("batchDelete", p_msg.args["ids"]);
		}
		[CommandResult(selector="delete")]
		public function delNoderVersionInfoResultHandler(p_result:ResultEvent, trigger:NoderVersionInfoMsg):void
		{
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "delResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 刷新获取页面的数据
		 */		
		[Command(selector="getNoderVersionInfoPage")]
		public function getNoderVersionInfoPage(p_msg:NoderVersionInfoMsg):AsyncToken
		{
			return call("getNoderVersionInfoPageByParams", p_msg.args["page"], p_msg.args["condi"]);
		}
		[CommandResult(selector="getNoderVersionInfoPage")]
		public function getPageResultHandler(p_result:ResultEvent, trigger:NoderVersionInfoMsg):void
		{
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "getNoderVersionInfoPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 
		 */
		[Command(selector = "importNoderVersionInfoExcel")]
		public function importExcel(p_msg:NoderVersionInfoMsg):AsyncToken
		{
			return call("importNoderVersionInfoExcel", p_msg.args["bytes"]);
		}
		[CommandResult(selector = "importNoderVersionInfoExcel")]
		public function importExcelHandler(p_result:ResultEvent, tigger:NoderVersionInfoMsg):void
		{
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "importNoderVersionInfoExcelResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		//////////////////////////////////
		
		/**
		 * 
		 */		
		[Command(selector="NoderVersionInfoDelegate:com.grgbanking.platform.module.term.service.noderVersionInfoService")]
		public function executeCommandForNoderVersionInfoMsg(msg:NoderVersionInfoMsg):AsyncToken
		{
			trace("NoderVersionInfoDelegate.executeCommandForNoderVersionInfoMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="NoderVersionInfoDelegate:com.grgbanking.platform.module.term.service.noderVersionInfoService")]
		public function executeCommandForNoderVersionInfoMsgCommandResult(result:ResultEvent, trigger:NoderVersionInfoMsg):void
		{
			trace("NoderVersionInfoDelegate.executeCommandForNoderVersionInfoMsgCommandResult");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="NoderVersionInfoDelegate:com.grgbanking.platform.module.term.service.noderVersionInfoService")]
		public function executeCommandForNoderVersionInfoMsgCommandError(fault:FaultEvent, trigger:NoderVersionInfoMsg):void
		{
			trace("NoderVersionInfoDelegate.executeCommandForNoderVersionInfoMsgCommandError");
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		//////////////////////////////////
	}
}