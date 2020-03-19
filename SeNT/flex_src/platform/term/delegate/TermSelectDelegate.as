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

	public class TermSelectDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="termSelectService")]
		public var ro:RemoteObject;
		
		/**语言包**/
		private var langMgr:LanguageManager = LanguageManager.getInstance();

		[Init]
		public function init():void
		{
			super._ro = ro;
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
		 * 通过终端ID获取终端数据
		 */
		[Command(selector="getTermInfoByTermid")]
		[Command(selector="getTermInfoBySelTermid")]
		public function getTermInfoByTermid(p_msg:TermInfoMsg):AsyncToken
		{
			return call("getTermInfoByTermid", p_msg.args["page"], p_msg.args["condi"]);
		}
		
		[CommandResult(selector="getTermInfoByTermid")]		
		public function getTermInfoByTermidCommandResult(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoByTermidResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[CommandResult(selector="getTermInfoBySelTermid")]
		public function getTermInfoBySelTermidCommandResult(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoBySelTermidResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		/**
		 * 通过下拉框选择条件获取终端数据
		 */
		[Command(selector="getTermInfoByParams")]
		public function getTermInfoByParms(p_msg:TermInfoMsg):AsyncToken
		{
			return call("getTermInfoByParams", p_msg.args["page"], p_msg.args["condi"]);
		}
		[CommandResult(selector="getTermInfoByParams")]
		public function getTermInfoByParamsCommandResult(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoByParamsResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	}
}
