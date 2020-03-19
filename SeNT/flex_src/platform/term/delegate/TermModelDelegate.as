package platform.term.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.term.constants.TermLocalKeyConsts;
	import platform.term.message.TermModelMsg;

	public class TermModelDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="termModelService")]
		public var ro:RemoteObject;
		
		/**语言包**/
		private var langMgr:LanguageManager = LanguageManager.getInstance();

		[Init]
		public function init():void
		{
			trace("TermModelDelegate.init");
			super._ro = ro;
		}
		
		/*****************************************
		 * 异步调用远程接口
		 *****************************************/
		
		/**
		 * 保存
		 */		
		[Command(selector="saveTerminalModel")]
		public function saveTerminalModelCommand(p_msg:TermModelMsg):AsyncToken
		{
			trace("TermModelDelegate.saveTerminalModelCommand");
			if( p_msg.args["parameter"]["formType"] == TermLocalKeyConsts.UPDATE_TERMMODEL_FORM )
			{
				return call("updateTerminalModel", p_msg.args["parameter"]);
			}
			else
			{
				return call("saveTerminalModel", p_msg.args["parameter"]);
			}
		}
		
		[CommandResult(selector="saveTerminalModel")]
		public function saveTerminalModelCommandResult(p_result:ResultEvent, trigger:TermModelMsg):void
		{
			trace("TermModelDelegate.saveTerminalModelCommandResult");
			var msg:TermModelMsg = new TermModelMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[CommandError(selector="saveTerminalModel")]
		public function saveTerminalModelCommandError(p_fault:FaultEvent, trigger:TermModelMsg):void
		{
			trace("TermModelDelegate.saveTerminalModelCommandError");
			var msg:TermModelMsg = new TermModelMsg();
			msg.type = "saveError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
		
		///////////////////////////////
		
		/**
		 * 
		 */		
		[Command(selector="getBrandList")]
		public function getBrandListCommand(p_msg:TermModelMsg):AsyncToken
		{
			trace("TermModelDelegate.getBrandListCommand-getBrandList");
			return call("getBrandList");
		}
		
		/**
		 * 
		 */	
		[CommandResult(selector="getBrandList")]
		public function getBrandListCommandResult(p_result:ResultEvent, trigger:TermModelMsg):void
		{
			trace("TermModelDelegate.getBrandListCommandResult-getBrandList");
			var msg:TermModelMsg = new TermModelMsg();
			msg.type = "getBrandListResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 
		 */	
		[CommandError(selector="getBrandList")]
		public function getBrandListCommandError(p_fault:FaultEvent, trigger:TermModelMsg):void
		{
			trace("TermModelDelegate.getBrandListCommandError-getBrandList");
		}
		
		/////////////////////////////////////////
		
		/**
		 * 
		 */		
		[Command(selector="initFormData")]
		public function initFormData(p_msg:TermModelMsg):AsyncToken
		{
			trace("TermModelDelegate.initFormData-initFormData");
			return call("initFormData");
		}
		
		/**
		 * 
		 */	
		[CommandResult(selector="initFormData")]
		public function initFormDataCommandResult(p_result:ResultEvent, trigger:TermModelMsg):void
		{
			trace("TermModelDelegate.initFormDataCommandResult-initFormData");
			var msg:TermModelMsg = new TermModelMsg();
			msg.type = "initFormDataResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 
		 */	
		[CommandError(selector="initFormData")]
		public function initFormDataCommandError(p_fault:FaultEvent, trigger:TermModelMsg):void
		{
			trace("TermModelDelegate.initFormDataCommandError-initFormData");
		}
		
		///////////////////////////////
		
		/**
		 * 删除 
		 */		
		[Command(selector="delete")]
		public function delTermModel(p_msg:TermModelMsg):AsyncToken
		{
			trace("TermModelDelegate.delTermModel-delete");
			return call("batchDelete", p_msg.args["ids"]); 
		}
		
		[CommandResult(selector="delete")]
		public function delTermModelResultHandler(p_result:ResultEvent, trigger:TermModelMsg):void
		{
			trace("TermModelDelegate.delTermModelResultHandler-delete");
			var msg:TermModelMsg = new TermModelMsg();
			msg.type = "delResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 刷新获取页面的数据
		 */		
		[Command(selector="getTermModelPage")]
		public function getTermModelPage(p_msg:TermModelMsg):AsyncToken
		{
			trace("TermModelDelegate.getTermModelPage-getTermModelPage");
			return call("getTermModelPageByParams", p_msg.args["page"], p_msg.args["condi"]);
		}
		
		[CommandResult(selector="getTermModelPage")]
		public function getTermModelPageCommandResult(p_result:ResultEvent, trigger:TermModelMsg):void
		{
			trace("TermModelDelegate.getTermModelPageCommandResult-getTermModelPage");
			var msg:TermModelMsg = new TermModelMsg();
			msg.type = "getTermModelPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[CommandError(selector="getTermModelPage")]
		public function getTermModelPageCommandError(p_result:ResultEvent, trigger:TermModelMsg):void
		{
			trace("TermModelDelegate.getTermModelPageCommandError-getTermModelPage");
		}
		
	}
	
	
	
	
	
}













