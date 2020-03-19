package platform.term.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.term.constants.TermLocalKeyConsts;
	import platform.term.message.TermTypeMsg;

	public class TermTypeDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="termTypeService")]
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
		public function saveTermType(p_msg:TermTypeMsg):AsyncToken
		{
			if(p_msg.args["data"]["formType"] == TermLocalKeyConsts.UPDATE_TERMTYPE_FORM){
				return call("updateTerminalType", p_msg.args["data"], langMgr.currentLanguage);
			}
			return call("saveTerminalType", p_msg.args["data"], langMgr.currentLanguage);
		}
		[CommandResult(selector="save")]
		public function saveResultHandler(p_result:ResultEvent, trigger:TermTypeMsg):void
		{
			var msg:TermTypeMsg = new TermTypeMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="save")]
		public function saveErrorHandler(p_fault:FaultEvent, trigger:TermTypeMsg):void
		{
			//todo anything;
			var msg:TermTypeMsg = new TermTypeMsg();
			msg.type = "saveError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
		
		/**
		 * 删除 
		 */		
		[Command(selector="delete")]
		public function delTermType(p_msg:TermTypeMsg):AsyncToken
		{
			return call("batchDelete", p_msg.args["ids"]); 
		}
		[CommandResult(selector="delete")]
		public function delTermTypeResultHandler(p_result:ResultEvent, trigger:TermTypeMsg):void
		{
			var msg:TermTypeMsg = new TermTypeMsg();
			msg.type = "delResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 刷新获取页面的数据
		 */		
		[Command(selector="getTermTypePage")]
		public function getTermTypePage(p_msg:TermTypeMsg):AsyncToken
		{
			return call("getTermTypePage", p_msg.args["page"], p_msg.args["type"], langMgr.currentLanguage);
		}
		[CommandResult(selector="getTermTypePage")]
		public function getPageResultHandler(p_result:ResultEvent, trigger:TermTypeMsg):void
		{
			var msg:TermTypeMsg = new TermTypeMsg();
			msg.type = "getTermTypePageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	}
}