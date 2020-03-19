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
	
	public class TermRangeSelectDelegate extends DelegateBase
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
		public function getByTermidResultHandler(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoByTermidResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandResult(selector="getTermInfoBySelTermid")]
		public function getBySelTermidResultHandler(p_result:ResultEvent, trigger:TermInfoMsg):void
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
		public function getByParmsResultHandler(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoByParamsResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取终端型号
		 */
		[Command(selector="getTemModelDatas")]
		public function getTemModelDatas(p_msg:TermInfoMsg):AsyncToken
		{
			return call("getTemModelDatas", p_msg.args["condi"]);
		}
		[CommandResult(selector="getTemModelDatas")]
		public function getTemModelResultHandler(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTemModelDatasResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取设备类型 
		 */
		[Command(selector="getTemTypeDatas")]
		public function getTemTypeDatas(p_msg:TermInfoMsg):AsyncToken
		{
			return call("getTemTypeDatas", p_msg.args["condi"]);
		}
		[CommandResult(selector="getTemTypeDatas")]
		public function getTemTypeResultHandler(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTemTypeDatasResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 获取品牌类型 
		 */
		[Command(selector="getTemBrandDatas")]
		public function getTemBrandDatas(p_msg:TermInfoMsg):AsyncToken
		{
			return call("getTemBrandDatas", p_msg.args["condi"]);
		}
		[CommandResult(selector="getTemBrandDatas")]
		public function getTemBrandResultHandler(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTemBrandDatasResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 获取所选终端总数
		 */
		[Command(selector="getTemSumDatas")]
		public function getTemSumDatas(p_msg:TermInfoMsg):AsyncToken
		{
			return call("getTemSumDatas", p_msg.args["condi"]);
		}
		[CommandResult(selector="getTemSumDatas")]
		public function getTemSumResultHandler(p_result:ResultEvent, trigger:TermInfoMsg):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTemSumDatasResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	}
}
