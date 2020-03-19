package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.TranAbnoinfoBlackModuleMsg;
	
	public class TranAbnoinfoBlackDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="tranAbnoinfoService")]
		public var ro:RemoteObject;
		
		/**语言包**/
		private var langMgr:LanguageManager = LanguageManager.getInstance();
		
		[Init]
		public function init():void
		{
			super._ro = ro;
		}
		
		/**
		 * 根据条件查询黑名单或是重号异常交易信息
		 */		
		[Command(selector="getTranAbnoAnalyseinfoPage")]
		public function getTranAbnoAnalyseinfoPage(msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			trace("TranAbnoinfoBlackDelegate.getTranAbnoAnalyseinfoPage");
			return call("getTranAbnoAnalyseinfoPage", msg.args["page"], msg.args["transab"],msg.args["startTime"],msg.args["endTime"]);
		}
		
		[CommandResult(selector="getTranAbnoAnalyseinfoPage")]
		public function getTranAbnoAnalyseinfoPageResultHandler(p_result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			trace("TranAbnoinfoBlackDelegate.getTranAbnoAnalyseinfoPageResultHandler");
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getTranAbnoAnalyseinfoPageResult"; 
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		[CommandError(selector="getTranAbnoAnalyseinfoPage")]
		public function  getTranAbnoAnalyseinfoPageErrorHandler(p_fault:FaultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			trace("TranAbnoinfoBlackDelegate.getTranAbnoAnalyseinfoPageErrorHandler");
			//todo anything;
		}
		/**
		 * 根据条件查询异常回收交易信息
		 * */
		[Command(selector="getCallBackTranAbnoinfoPage")]
		public function getCallBackTranAbnoinfoPage(msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			return call("getCallBackTranAbnoinfoPage", msg.args["page"], msg.args["transab"],msg.args["startTime"],msg.args["endTime"]);
		}
		[CommandResult(selector="getCallBackTranAbnoinfoPage")]
		public function getCallBackTranAbnoinfoResultHandler(p_result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getCallBackTranAbnoinfoPageResult"; 
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="getCallBackTranAbnoinfoPage")]
		public function  getCallBackTranAbnoinfoPageErrorHandler(p_fault:FaultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			//todo anything;
		}
		/**
		 * 根据条件查询特殊规则交易信息
		 * */
		[Command(selector="getEspecialTranAbnoinfoPage")]
		public function getEspecialTranAbnoinfoPage(msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			return call("getEspecialTranAbnoinfoPage", msg.args["page"], msg.args["transab"],msg.args["startTime"],msg.args["endTime"]);
		}
		[CommandResult(selector="getEspecialTranAbnoinfoPage")]
		public function getEspecialTranAbnoinfoPageResultHandler(p_result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getEspecialTranAbnoinfoPageResult"; 
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="getEspecialTranAbnoinfoPage")]
		public function  getEspecialTranAbnoinfoPageErrorHandler(p_fault:FaultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			//todo anything;
		}
		
		/**
		 * 根据条件查询异常交易卡号信息
		 */		
		[Command(selector="getTranAbnoAnalyseinfoList")]
		public function getTranAbnoAnalyseinfo(msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			return call("getTranAbnoAnalyseinfoList", msg.args["page"], msg.args["transab"],msg.args["startTime"],msg.args["endTime"]);
		}
		[CommandResult(selector="getTranAbnoAnalyseinfoList")]
		public function getTranAbnoAnalyseinfoListResultHandler(p_result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getTranAbnoAnalyseinfoListResult"; 
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="getTranAbnoAnalyseinfoList")]
		public function getTermInfoInitDatasErrorHandler(p_fault:FaultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			//todo anything;
		}
		/**
		 * 根据卡号查询异常交易详细信息
		 */		
		[Command(selector="getTranAbnoinfoAnalyseList")]
		public function getTranAbinfoByAccount(msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			return call("getTranAbnoinfoAnalyseList",msg.args["accountNo"]);
		}
		[CommandResult(selector="getTranAbnoinfoAnalyseList")]
		public function getTranAbinfoByAccountListResultHandler(p_result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getTranAbnoinfoAnalyseListResult"; 
			msg.result = p_result.result;
			sendMessage(msg);
		}	
		/**
		 * 根据条件查询异常交易设备信息
		 * **/
		[Command(selector="getTranAbnoAnalyseinfoByTmlList")]
		public function getTranAbnoAnalyseTmlinfo(msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			return call("getTranAbnoAnalyseinfoByTmlList", msg.args["page"], msg.args["transab"],msg.args["startTime"],msg.args["endTime"]);
		}
		[CommandResult(selector="getTranAbnoAnalyseinfoByTmlList")]
		public function getTranAbnoAnalyseinfoByTmlListResultHandler(p_result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getTranAbnoAnalyseinfoByTmlListResult"; 
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="getTranAbnoAnalyseinfoByTmlList")]
		public function getTranAbnoAnalyseinfoByTmlListDatasErrorHandler(p_fault:FaultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			//todo anything;
		}
		/**
		 * 根据设备编号查询异常交易详细信息
		 */		
		[Command(selector="getTranAbnoinfoAnalyseByTermidList")]
		public function getTranAbinfoByTmlResult(msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			return call("getTranAbnoinfoAnalyseByTermidList",msg.args["termid"]);
		}
		[CommandResult(selector="getTranAbnoinfoAnalyseByTermidList")]
		public function getTranAbnoinfoAnalyseByTermidListResultHandler(p_result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getTranAbnoinfoAnalyseByTermidListResult"; 
			msg.result = p_result.result;
			sendMessage(msg);
		}	
		/**
		 *黑名单交易规则分析
		 * **/
		[Command(selector="getTranAbnoAnalyseinfoByBlReguList")]
		public function getTranAbnoAnalyseinfoByBlReguList(msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			return call("getTranAbnoAnalyseinfoByBlReguList", msg.args["page"], msg.args["transab"],msg.args["startTime"],msg.args["endTime"]);
		}
		[CommandResult(selector="getTranAbnoAnalyseinfoByBlReguList")]
		public function getTranAbnoAnalyseReguListResultHandler(p_result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getTranAbnoAnalyseinfoByBlReguListResult"; 
			msg.result = p_result.result;
			sendMessage(msg);
		}
		[CommandError(selector="getTranAbnoAnalyseinfoByBlReguList")]
		public function getTranAbnoAnalyseReguListDatasErrorHandler(p_fault:FaultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			//todo anything;
		}
		/**
		 * 根据黑名单查询异常交易详细信息
		 */		
		[Command(selector="getTranAbnoinfoAnalyseByBlReguList")]
		public function getTranAbinfoByBlackResult(msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			return call("getTranAbnoinfoAnalyseByBlReguList",msg.args["regulation"]);
		}
		[CommandResult(selector="getTranAbnoinfoAnalyseByBlReguList")]
		public function getTranAbnoinfoAnalyseByBlReguListResultHandler(p_result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getTranAbnoinfoAnalyseByBlReguListResult"; 
			msg.result = p_result.result;
			sendMessage(msg);
		}	
		
		
		[Command(selector="TranAbnoinfoBlackDelegate:com.grgbanking.sent.watch.service.TranAbnoinfoService")]
		public function executeCommandForTranAbnoinfoBlackModuleMsg(msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="TranAbnoinfoBlackDelegate:com.grgbanking.sent.watch.service.TranAbnoinfoService")]
		public function executeCommandForTranAbnoinfoBlackModuleMsgResultHandler(result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="TranAbnoinfoBlackDelegate:com.grgbanking.sent.watch.service.TranAbnoinfoService")]
		public function executeCommandForTranAbnoinfoBlackModuleMsgErrorHandler(fault:FaultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
	}
}