package platform.term.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.term.constants.TermLocalKeyConsts;
	import platform.term.message.TermBrandMsg;

	public class TermBrandDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="termBrandService")]
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
		public function saveTermBrand(p_msg:TermBrandMsg):AsyncToken
		{
			if(p_msg.args["data"]["formType"] == TermLocalKeyConsts.UPDATE_TERMBRAND_FORM){
				return call("updateTerminalBrand", p_msg.args["data"]);
			}
			return call("saveTerminalBrand", p_msg.args["data"]);
		}
		[CommandResult(selector="save")]
		public function saveResultHandler(p_result:ResultEvent, trigger:TermBrandMsg):void
		{
			var msg:TermBrandMsg = new TermBrandMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="save")]
		public function saveErrorHandler(p_fault:FaultEvent, trigger:TermBrandMsg):void
		{
			//todo anything;
			var msg:TermBrandMsg = new TermBrandMsg();
			msg.type = "saveError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
		
		/**
		 * 删除 
		 */		
		[Command(selector="delete")]
		public function delTermBrand(p_msg:TermBrandMsg):AsyncToken
		{
			return call("batchDelete", p_msg.args["ids"]); 
		}
		[CommandResult(selector="delete")]
		public function delTermBrandResultHandler(p_result:ResultEvent, trigger:TermBrandMsg):void
		{
			var msg:TermBrandMsg = new TermBrandMsg();
			msg.type = "delResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 刷新获取页面的数据
		 */		
		[Command(selector="getTermBrandPage")]
		public function getTermBrandPage(p_msg:TermBrandMsg):AsyncToken
		{
			return call("getTermBrandPage", p_msg.args["page"], p_msg.args["brandName"]);
		}
		[CommandResult(selector="getTermBrandPage")]
		public function getPageResultHandler(p_result:ResultEvent, trigger:TermBrandMsg):void
		{
			var msg:TermBrandMsg = new TermBrandMsg();
			msg.type = "getTermBrandPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
	}
}