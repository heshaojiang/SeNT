package sent.stride.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.common.util.TestUtils;
	import platform.layer.DelegateBase;
	import platform.common.manager.AlertHandler;
	import sent.stride.constants.CmlStrideTransferRecordLocalKeyConsts;
	import sent.stride.message.CmlStrideTransferRecordMsg;

	public class CmlStrideTransferRecordDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="cmlStrideTransferRecordService")]
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
		public function saveCmlStrideTransferRecord(p_msg:CmlStrideTransferRecordMsg):AsyncToken
		{
			// AlertHandler.alert("deleagte method incoming...");
			if(p_msg.args["data"]["formType"] == CmlStrideTransferRecordLocalKeyConsts.UPDATE_FORM){
				return call("updateCmlStrideTransferRecord", p_msg.args["data"]);
			}
			return call("saveCmlStrideTransferRecord", p_msg.args["data"]);
		}
		
		/**
		 * 保存返回成功结果处理函数
		 */
		[CommandResult(selector="save")]
		public function saveResultHandler(p_result:ResultEvent, trigger:CmlStrideTransferRecordMsg):void
		{
			var msg:CmlStrideTransferRecordMsg = new CmlStrideTransferRecordMsg();
			msg.type = "saveResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 保存返回失败结果处理函数
		 */ 
		[CommandError(selector="save")]
		public function saveErrorHandler(p_fault:FaultEvent, trigger:CmlStrideTransferRecordMsg):void
		{
			//todo anything;
			// AlertHandler.alert("todo anything where error return...");
		}
		
		/**
		 * 获取下拉框的数据源
		 */		
		[Command(selector="getFormInitDatas")]
		public function getFormInitDatas(p_msg:CmlStrideTransferRecordMsg):AsyncToken
		{
			return call("getFormInitDatas");
		}
		
		/**
		 * 获取下拉框的数据源 返回成功结果处理函数
		 */ 
		[CommandResult(selector="getFormInitDatas")]
		public function getFormInitDatasResultHandler(p_result:ResultEvent, trigger:CmlStrideTransferRecordMsg):void
		{
			var msg:CmlStrideTransferRecordMsg = new CmlStrideTransferRecordMsg();
			msg.type = "getFormInitDatasResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取下拉框的数据源 返回失败结果处理函数
		 */ 
		[CommandError(selector="getFormInitDatas")]
		public function getFormInitDatasErrorHandler(p_fault:FaultEvent, trigger:CmlStrideTransferRecordMsg):void
		{
			//todo anything;
		}
		
		/**
		 * 删除 
		 */		
		[Command(selector="delete")]
		public function delCmlStrideTransferRecord(p_msg:CmlStrideTransferRecordMsg):AsyncToken
		{
			return call("batchDelete", p_msg.args["ids"]);
		}
		
		/**
		 * 删除  返回成功结果处理函数
		 */ 
		[CommandResult(selector="delete")]
		public function delCmlStrideTransferRecordResultHandler(p_result:ResultEvent, trigger:CmlStrideTransferRecordMsg):void
		{
			var msg:CmlStrideTransferRecordMsg = new CmlStrideTransferRecordMsg();
			msg.type = "delResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 刷新获取页面的数据
		 */		
		[Command(selector="getCmlStrideTransferRecordPage")]
		public function getCmlStrideTransferRecordPage(p_msg:CmlStrideTransferRecordMsg):AsyncToken
		{
			return call("getCmlStrideTransferRecordPageByParams", p_msg.args["page"], p_msg.args["condi"]);
		}
		
		/**
		 * 刷新获取页面的数据 返回成功结果处理函数
		 */ 
		[CommandResult(selector="getCmlStrideTransferRecordPage")]
		public function getPageResultHandler(p_result:ResultEvent, trigger:CmlStrideTransferRecordMsg):void
		{
			var msg:CmlStrideTransferRecordMsg = new CmlStrideTransferRecordMsg();
			msg.type = "getCmlStrideTransferRecordPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	}
}