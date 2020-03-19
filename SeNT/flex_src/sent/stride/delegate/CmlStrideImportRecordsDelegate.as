package sent.stride.delegate
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	
	import sent.stride.constants.CmlStrideImportRecordsLocalKeyConsts;
	import sent.stride.message.CmlStrideImportRecordsMsg;

	public class CmlStrideImportRecordsDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="cmlStrideImportRecordsService")]
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
		[Command(selector="saveStrideExport")]
		public function saveStrideExport(p_msg:CmlStrideImportRecordsMsg):AsyncToken
		{
			return call("saveStrideExport",p_msg.args["toBankCode"],p_msg.args["bagCode"],p_msg.args["rfid"],p_msg.args["bundleCodes"]);
		}
		
		/**
		 * 保存返回成功结果处理函数
		 */
		[CommandResult(selector="saveStrideExport")]
		public function saveResultHandler(p_result:ResultEvent, trigger:CmlStrideImportRecordsMsg):void
		{
			var msg:CmlStrideImportRecordsMsg = new CmlStrideImportRecordsMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 保存返回失败结果处理函数
		 */ 
		[CommandError(selector="saveStrideExport")]
		public function saveErrorHandler(p_fault:FaultEvent, trigger:CmlStrideImportRecordsMsg):void
		{
			//todo anything;
			// AlertHandler.alert("todo anything where error return...");
		}
		
		[Command(selector="savedStrideDownload")]
		public function savedStrideDownload(p_msg:CmlStrideImportRecordsMsg):AsyncToken
		{
			return call("savedStrideDownload",p_msg.args["arr"]);
		}
		
		/**
		 * 获取下拉框的数据源
		 */		
		[Command(selector="getFormInitDatas")]
		public function getFormInitDatas(p_msg:CmlStrideImportRecordsMsg):AsyncToken
		{
			return call("getFormInitDatas");
		}
		
		/**
		 * 获取下拉框的数据源 返回成功结果处理函数
		 */ 
		[CommandResult(selector="getFormInitDatas")]
		public function getFormInitDatasResultHandler(p_result:ResultEvent, trigger:CmlStrideImportRecordsMsg):void
		{
			var msg:CmlStrideImportRecordsMsg = new CmlStrideImportRecordsMsg();
			msg.type = "getFormInitDatasResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取下拉框的数据源 返回失败结果处理函数
		 */ 
		[CommandError(selector="getFormInitDatas")]
		public function getFormInitDatasErrorHandler(p_fault:FaultEvent, trigger:CmlStrideImportRecordsMsg):void
		{
			//todo anything;
		}
		
		/**
		 * 删除 
		 */		
		[Command(selector="delete")]
		public function delCmlStrideImportRecords(p_msg:CmlStrideImportRecordsMsg):AsyncToken
		{
			return call("batchDelete", p_msg.args["ids"]);
		}
		
		/**
		 * 删除  返回成功结果处理函数
		 */ 
		[CommandResult(selector="delete")]
		public function delCmlStrideImportRecordsResultHandler(p_result:ResultEvent, trigger:CmlStrideImportRecordsMsg):void
		{
			var msg:CmlStrideImportRecordsMsg = new CmlStrideImportRecordsMsg();
			msg.type = "delResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 刷新获取页面的数据
		 */		
		[Command(selector="getCmlStrideImportRecordsPage")]
		public function getCmlStrideImportRecordsPage(p_msg:CmlStrideImportRecordsMsg):AsyncToken
		{
			return call("getCmlStrideImportRecordsPageByParams", p_msg.args["page"], p_msg.args["condi"],p_msg.args["startTime"],p_msg.args["endTime"]);
		}
		
		/**
		 * 刷新获取页面的数据 返回成功结果处理函数
		 */ 
		[CommandResult(selector="getCmlStrideImportRecordsPage")]
		public function getPageResultHandler(p_result:ResultEvent, trigger:CmlStrideImportRecordsMsg):void
		{
			var msg:CmlStrideImportRecordsMsg = new CmlStrideImportRecordsMsg();
			msg.type = "getCmlStrideImportRecordsPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
	}
}