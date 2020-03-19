package platform.cashbox.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.cashbox.message.BoxInfoMsg;
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	
	public class BoxInfoDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="boxInfoService")]
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
		
		[Command(selector="saveBoxInfo")]
		public function saveBoxInfo(p_msg:BoxInfoMsg):AsyncToken
		{
			return call("saveBoxInfo", p_msg.args["data"], p_msg.args["change"]);
		}
		[CommandResult(selector="saveBoxInfo")]
		public function saveResultHandler(p_result:ResultEvent, trigger:BoxInfoMsg):void
		{
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type = "saveBoxInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="save")]
		public function saveErrorHandler(p_fault:FaultEvent, trigger:BoxInfoMsg):void
		{
			//todo anything;
		}
		
		/**
		 * 删除 
		 */		
		
		[Command(selector="deleteBoxInfo")]
		public function delBoxInfo(p_msg:BoxInfoMsg):AsyncToken
		{
			return call("deleteBoxInfo", p_msg.args["ids"]);
		}
		[CommandResult(selector="deleteBoxInfo")]
		public function delBoxInfoResultHandler(p_result:ResultEvent, trigger:BoxInfoMsg):void
		{
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type = "deleteBoxInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 刷新获取页面的数据
		 */		
		[Command(selector="getBoxInfoPage")]
		public function getBoxInfoByParams(p_msg:BoxInfoMsg):AsyncToken
		{
			return call("getBoxInfoByParams", p_msg.args["page"], p_msg.args["condi"]);
		}
		[CommandResult(selector="getBoxInfoPage")]
		public function getPageResultHandler(p_result:ResultEvent, trigger:BoxInfoMsg):void
		{
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type = "getBoxInfoPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 
		 * */
		[Command(selector = "importExcel")]
		public function importExcel(p_msg:BoxInfoMsg):AsyncToken
		{
			return call("importExcel", p_msg.args["bytes"]);
		}
		[CommandResult(selector = "importExcel")]
		public function importExcelHandler(p_result:ResultEvent, tigger:BoxInfoMsg):void
		{
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type = "importExcelSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[Command(selector="exportExcel")]
		public function exportExcel(p_msg:BoxInfoMsg):AsyncToken
		{
			return call("exportExcel");
		}
		
		[CommandResult(selector="exportExcel")]
		public function exportExcelHandler(p_result:ResultEvent, trigger:BoxInfoMsg):void 									  
		{
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type = "exportExcelResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 
		 */		
		[Command(selector="getBoxInfoFormInitDatas")]
		public function getBoxInfoFormInitDatas(p_msg:BoxInfoMsg):AsyncToken
		{
			return call("getBoxInfoFormInitDatas",langMgr.currentLanguage);
		}
		[CommandResult(selector="getBoxInfoFormInitDatas")]
		public function getBoxInfoFormInitDatasResultHandler(p_result:ResultEvent, trigger:BoxInfoMsg):void
		{
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type = "getBoxInfoFormInitDatasResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="getBoxInfoFormInitDatas")]
		public function getBoxInfoFormInitDatasErrorHandler(p_fault:FaultEvent, trigger:BoxInfoMsg):void
		{
			//todo anything;
		}
		/**
		 * 打印输出时输出具体的机构名以及atm型号
		 * */
		[Command(selector="getOrgNameAndModelNameByBoxNum")]
		public function getOrgNameAndModelNameById(p_msg:BoxInfoMsg):AsyncToken
		{
			return call("getOrgNameAndModelNameByBoxNum",p_msg.args["boxNum"]);
		}
		[CommandResult(selector="getOrgNameAndModelNameByBoxNum")]
		public function getOrgNameAndModelNameByIdResultHandler(p_result:ResultEvent,trigger:BoxInfoMsg):void
		{
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type = "getOrgNameAndModelNameByBoxNumResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 恢复钞箱流转状态为初始状态
		 * */
		[Command(selector="restoreBoxFlowStage")]
		public function restoreBoxFlowStage(p_msg:BoxInfoMsg):AsyncToken
		{
			return call("restoreBoxFlowStage",p_msg.args["boxNum"]);
		}
		[CommandResult(selector="restoreBoxFlowStage")]
		public function restoreBoxFlowStageResultHandler(p_result:ResultEvent,trigger:BoxInfoMsg):void
		{
			var msg:BoxInfoMsg = new BoxInfoMsg();
			msg.type = "restoreBoxFlowStageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		////////////////////////////////////////////
		// 公用方法
		
		/**
		 * 
		 */		
		[Command(selector="BoxInfoDelegate:com.grgbanking.platform.module.cashbox.service.BoxInfoService")]
		public function executeCommandForBoxInfoMsg(msg:BoxInfoMsg):AsyncToken
		{
			trace("BoxInfoDelegate.executeCommandForBoxInfoMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="BoxInfoDelegate:com.grgbanking.platform.module.cashbox.service.BoxInfoService")]
		public function executeCommandForBoxInfoMsgResultHandler(result:ResultEvent, trigger:BoxInfoMsg):void
		{
			trace("BoxInfoDelegate.executeCommandForBoxInfoMsgResultHandler");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="BoxInfoDelegate:com.grgbanking.platform.module.cashbox.service.BoxInfoService")]
		public function executeCommandForBoxInfoMsgErrorHandler(fault:FaultEvent, trigger:BoxInfoMsg):void
		{
			trace("BoxInfoDelegate.executeCommandForBoxInfoMsgErrorHandler");
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		///////////////////////////////////////////////////
	}
}