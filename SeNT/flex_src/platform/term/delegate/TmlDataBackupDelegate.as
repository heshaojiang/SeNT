package platform.term.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	import platform.term.constants.TermLocalKeyConsts;
	import platform.term.message.TmlDataBackupMsg;

	public class TmlDataBackupDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="tmlDataBackupService")]
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
		public function saveTmlDataBackup(p_msg:TmlDataBackupMsg):AsyncToken
		{
			/*if(p_msg.args["data"]["formType"] == TermLocalKeyConsts.UPDATE_TERMINFO_FORM){
				return call("updateTmlDataBackup", p_msg.args["data"], langMgr.currentLanguage);
			}*/
			return call("saveTmlDataBackup", p_msg.args["data"], langMgr.currentLanguage);
		}
		[CommandResult(selector="save")]
		public function saveResultHandler(p_result:ResultEvent, trigger:TmlDataBackupMsg):void
		{
			var msg:TmlDataBackupMsg = new TmlDataBackupMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="save")]
		public function saveErrorHandler(p_fault:FaultEvent, trigger:TmlDataBackupMsg):void
		{
			//todo anything;
		}
		
		/**
		 * 删除 
		 */		
		[Command(selector="delete")]
		public function delTmlDataBackup(p_msg:TmlDataBackupMsg):AsyncToken
		{
			return call("batchDelete", p_msg.args["ids"]); 
		}
		[CommandResult(selector="delete")]
		public function delTmlDataBackupResultHandler(p_result:ResultEvent, trigger:TmlDataBackupMsg):void
		{
			var msg:TmlDataBackupMsg = new TmlDataBackupMsg();
			msg.type = "delResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 刷新获取页面的数据
		 */		
		[Command(selector="getTmlDataBackupPage")]
		public function getTmlDataBackupPage(p_msg:TmlDataBackupMsg):AsyncToken
		{
			return call("getTmlDataBackupPage", p_msg.args["page"], p_msg.args["path"]);
		}
		[CommandResult(selector="getTmlDataBackupPage")]
		public function getPageResultHandler(p_result:ResultEvent, trigger:TmlDataBackupMsg):void
		{
			var msg:TmlDataBackupMsg = new TmlDataBackupMsg();
			msg.type = "getTmlDataBackupPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	}
}