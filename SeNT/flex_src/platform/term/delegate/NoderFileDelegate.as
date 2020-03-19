package platform.term.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.term.constants.TermLocalKeyConsts;
	import platform.term.message.NoderFileMsg;
	
	public class NoderFileDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="noderFileService")]
		public var ro:RemoteObject;
		
		/**语言包**/
		private var langMgr:LanguageManager = LanguageManager.getInstance();
		
		[Init]
		public function init():void
		{
			super._ro = ro;
		}
		
		public function NoderFileDelegate()
		{
			super();
		}
		
		/*****************************************
		 * 异步调用远程接口
		 *****************************************/
		
		/**
		 *查询 
		 */
		[Command(selector="getNoderFilePage")]
		public function getNoderFilePage(p_msg:NoderFileMsg):AsyncToken
		{
			return call("getNoderFilePageByParams", p_msg.args["page"], p_msg.args["condi"]);
		}
		
		[CommandResult(selector="getNoderFilePage")]
		public function saveResultHandler(p_result:ResultEvent, trigger:NoderFileMsg):void
		{
			var msg:NoderFileMsg = new NoderFileMsg();
			msg.type = "getNoderFilePageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[Command(selector="exportNoderFile")]
		public function exportNoderVersionInfo(p_msg:NoderFileMsg):AsyncToken
		{
			/*if( p_msg.args["data"]["formType"] == NoderLocalKeyConsts.UPDATE_TERMINFO_FORM )
			{
			return call("updateNoderinalInfo", p_msg.args["data"]);
			}*/
			return call("exportNoderFile", p_msg.args["fileId"]);
		}
		
		[CommandResult(selector="exportNoderFile")]
		public function exportNoderVersionInfoResultHandler(p_result:ResultEvent, trigger:NoderFileMsg):void
		{
			var msg:NoderFileMsg = new NoderFileMsg();
			msg.type = "exportNoderFileResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 *判断文件是否存在
		 */
		[Command(selector="checkNoderFileUpload")]
		public function checkNoderFileUpload(p_msg:NoderFileMsg):AsyncToken
		{
			return call("checkNoderFileUpload", p_msg.args["fileType"], p_msg.args["noderId"], p_msg.args["tranData"]);
		}
		
		[CommandResult(selector="checkNoderFileUpload")]
		public function checkNoderFileUploadHandler(p_result:ResultEvent, trigger:NoderFileMsg):void
		{
			var msg:NoderFileMsg = new NoderFileMsg();
			msg.type = "checkNoderFileUploadResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 *申请远程获取文件
		 */
		[Command(selector="save")]
		public function save(p_msg:NoderFileMsg):AsyncToken
		{
			return call("save", p_msg.args["fileType"], p_msg.args["noderId"], p_msg.args["tranData"],p_msg.args["orgCode"]);
		}
		
		[CommandResult(selector="save")]
		public function saveHandler(p_result:ResultEvent, trigger:NoderFileMsg):void
		{
			var msg:NoderFileMsg = new NoderFileMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
	}
}