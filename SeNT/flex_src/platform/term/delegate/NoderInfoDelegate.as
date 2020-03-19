package platform.term.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.term.constants.TermLocalKeyConsts;
	import platform.term.message.NoderInfoMsg;

	public class NoderInfoDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="noderInfoService")]
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
		public function saveNoderInfo(p_msg:NoderInfoMsg):AsyncToken
		{
			if( p_msg.args["data"]["formType"] == TermLocalKeyConsts.UPDATE_TERMINFO_FORM )
			{
				return call("updateNoderinalInfo", p_msg.args["data"]);
			}
			return call("saveNoderinalInfo", p_msg.args["data"]);
		}
		
		[CommandResult(selector="save")]
		public function saveResultHandler(p_result:ResultEvent, trigger:NoderInfoMsg):void
		{
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="save")]
		public function saveErrorHandler(p_fault:FaultEvent, trigger:NoderInfoMsg):void
		{
			//todo anything;
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "saveError";
			msg.result = p_fault.fault;
			sendMessage(msg);
		}
		

		
		[Command(selector="exportNoderInfo")]
		public function exportNoderInfo(p_msg:NoderInfoMsg):AsyncToken
		{
			/*if( p_msg.args["data"]["formType"] == NoderLocalKeyConsts.UPDATE_TERMINFO_FORM )
			{
			return call("updateNoderinalInfo", p_msg.args["data"]);
			}*/
			return call("exportNoderInfo", p_msg.args["condi"]);
		}
		
		[CommandResult(selector="exportNoderInfo")]
		public function exportNoderInfoResultHandler(p_result:ResultEvent, trigger:NoderInfoMsg):void
		{
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "exportOrgInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 
		 */		
		[Command(selector="getNoderInfoFormInitDatas")]
		public function getNoderInfoFormInitDatas(p_msg:NoderInfoMsg):AsyncToken
		{
			return call("getNoderInfoFormInitDatas",langMgr.currentLanguage);
		}
		[CommandResult(selector="getNoderInfoFormInitDatas")]
		public function getNoderInfoFormInitDatasResultHandler(p_result:ResultEvent, trigger:NoderInfoMsg):void
		{
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "getNoderInfoFormInitDatasResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="getNoderInfoFormInitDatas")]
		public function getNoderInfoFormInitDatasErrorHandler(p_fault:FaultEvent, trigger:NoderInfoMsg):void
		{
			//todo anything;
		}
		
		
		/**
		 * 删除 
		 */		
		[Command(selector="delete")]
		public function delNoderInfo(p_msg:NoderInfoMsg):AsyncToken
		{
			return call("batchDelete", p_msg.args["ids"]);
		}
		[CommandResult(selector="delete")]
		public function delNoderInfoResultHandler(p_result:ResultEvent, trigger:NoderInfoMsg):void
		{
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "delResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 刷新获取页面的数据
		 */		
		[Command(selector="getNoderInfoPage")]
		public function getNoderInfoPage(p_msg:NoderInfoMsg):AsyncToken
		{
			return call("getNoderInfoPageByParams", p_msg.args["page"], p_msg.args["condi"]);
		}
		[CommandResult(selector="getNoderInfoPage")]
		public function getPageResultHandler(p_result:ResultEvent, trigger:NoderInfoMsg):void
		{
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "getNoderInfoPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 
		 */
		[Command(selector = "importNoderInfoExcel")]
		public function importExcel(p_msg:NoderInfoMsg):AsyncToken
		{
			return call("importNoderInfoExcel", p_msg.args["bytes"]);
		}
		[CommandResult(selector = "importNoderInfoExcel")]
		public function importExcelHandler(p_result:ResultEvent, tigger:NoderInfoMsg):void
		{
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "importNoderInfoExcelResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		//////////////////////////////////
		
		/**
		 * 
		 */		
		[Command(selector="NoderInfoDelegate:com.grgbanking.platform.module.term.service.NoderInfoService")]
		public function executeCommandForNoderInfoMsg(msg:NoderInfoMsg):AsyncToken
		{
			trace("NoderInfoDelegate.executeCommandForNoderInfoMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="NoderInfoDelegate:com.grgbanking.platform.module.term.service.NoderInfoService")]
		public function executeCommandForNoderInfoMsgCommandResult(result:ResultEvent, trigger:NoderInfoMsg):void
		{
			trace("NoderInfoDelegate.executeCommandForNoderInfoMsgCommandResult");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="NoderInfoDelegate:com.grgbanking.platform.module.term.service.NoderInfoService")]
		public function executeCommandForNoderInfoMsgCommandError(fault:FaultEvent, trigger:NoderInfoMsg):void
		{
			trace("NoderInfoDelegate.executeCommandForNoderInfoMsgCommandError");
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		//////////////////////////////////
	}
}