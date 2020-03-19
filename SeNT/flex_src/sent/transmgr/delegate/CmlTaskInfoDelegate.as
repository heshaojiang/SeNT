package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.CmlTaskInfoMsg;
	
	public class CmlTaskInfoDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="cmlTaskInfoService")]
		public var ro:RemoteObject;
		[Init]
		public function init():void
		{
			super._ro = ro;
		}
		/**
		 * Language Manager
		 * */
		private var langMgr:LanguageManager = LanguageManager.getInstance();
		
//		/**
//		 * 显示清分任务信息
//		 */		
//		[Command(selector="getCmlTaskInfoPage")]
//		public function getCmlTaskInfoPage(msg:CmlTaskInfoMsg):AsyncToken
//		{
//			return call("getCmlTaskInfoPage", msg.args["page"],msg.args["vo"],
//				msg.args["startTime"], msg.args["endTime"]);
//		}
//		[CommandResult(selector="getCmlTaskInfoPage")]
//		public function getCmlTaskInfoPageResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
//		{
//			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
//			msg.type = "getCmlTaskInfoPageResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		
		/**
		 * 根据条件查询清分详情
		 */		
		[Command(selector="getCmlTaskDetail")]
		public function getCmlTaskInfoDetail(msg:CmlTaskInfoMsg):AsyncToken
		{
			return call("getCmlTaskDetail", msg.args["taskId"]);
		}
		[CommandResult(selector="getCmlTaskDetail")]
		public function getCmlTaskInfoDetailResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type = "getCmlTaskDetailResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 修改清分任务信息
		 */		
		[Command(selector="editCmlTaskInfo")]
		public function editCmlTaskInfo(msg:CmlTaskInfoMsg):AsyncToken
		{
			return call("editCmlTaskInfo", msg.args["data"]);
		}
		[CommandResult(selector="editCmlTaskInfo")]
		public function editCmlTaskInfoResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type = "editCmlTaskInfoSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 获得所有用户
		 */		
		[Command(selector="loadUsersInfo")]
		public function loadUsersInfo(msg:CmlTaskInfoMsg):AsyncToken
		{
			return call("loadUsers");
		}
		[CommandResult(selector="loadUsersInfo")]
		public function loadUsersInfoResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type = "loadUsersInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 导出任务信息
		 */		
		[Command(selector="exportTaskList")]
		public function exportTaskInfoList(p_msg:CmlTaskInfoMsg):AsyncToken
		{
			return call("exportTaskList",p_msg.args["page"], p_msg.args["cond"],langMgr.currentLanguage);
		}
		[CommandResult(selector="exportTaskList")]
		public function exportTaskInfoListResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type = "exportTaskInfoListResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
//		/**
//		 * 根据任务id查看对应的信息
//		 * */
//		[Command(selector="getTaskInfo")]
//		public function getTaskInfo(p_msg:CmlTaskInfoMsg):AsyncToken
//		{
//			return call("getCmlTaskById",p_msg.args["id"]);
//		}
//		[CommandResult(selector="getTaskInfo")]
//		public function getTaskInfoResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
//		{
//			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
//			msg.type = "getTaskInfoResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		
		/**
		 * 导出excel(最新)
		 * */
		[Command(selector="exportTaskInfo")]
		public function exportTaskInfo(p_msg:CmlTaskInfoMsg):AsyncToken
		{
			return call("report",p_msg.args["vo"],p_msg.args["startTime"],p_msg.args["endTime"]);
			
		}
		[CommandResult(selector="exportTaskInfo")]
		public function exportTaskInfoResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type = "exportTaskInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获取参数配置中的时间范围
		 */
		[Command(selector="getInitTimeParam")]
		public function getInitTimeParam(p_msg:CmlTaskInfoMsg):AsyncToken
		{
			return call("getInitCmlTaskParamMap");
		}
		[CommandResult(selector="getInitTimeParam")]
		public function getInitTimeParamResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type = "getInitTimeParamResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		
		/**
		 * 根据条件查询冠字号码信息
		 */		
		[Command(selector="getCmlSentInfosPageByTranId")]
		public function getCmlSentInfosPageByTranId(msg:CmlTaskInfoMsg):AsyncToken
		{
			return call("getCmlSentInfosPageByvo",msg.args["page"], msg.args["vo"]);
		}
		
		
		
		[CommandResult(selector="getCmlSentInfosPageByTranId")]
		public function getCmlSentInfosByTranIdResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type = "getCmlSentInfosPageByTranIdResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		
		
		/**
		 * 查询所有的操作员信息
		 */		
		/*	[Command(selector="findAllOperatorList")]
		public function findAllOperatorList(msg:CmlTaskInfoMsg):AsyncToken
		{
		return call("findAllOperatorList");
		}
		[CommandResult(selector="findAllOperatorList")]
		public function findAllOperatorListResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
		var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
		msg.type = "findAllOperatorListResult";
		msg.result = p_result.result;
		sendMessage(msg);
		}
		/**
		* 查询所有的终端信息
		*/
		
		/*  [Command(selector="findAllTermList")]
		public function findAllTermList(msg:CmlTaskInfoMsg):AsyncToken
		{
		return call("findAllTermList");
		}
		[CommandResult(selector="findAllTermList")]
		public function findAllTermListResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
		var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
		msg.type = "findAllTermListResult";
		msg.result = p_result.result;
		sendMessage(msg);
		}*/
		/**
		 * 根据机构查找对应的操作员信息
		 */
		
		[Command(selector="findOperatorByOrgList")]
		public function findOperatorByOrgList(msg:CmlTaskInfoMsg):AsyncToken
		{
			return call("findOperatorByOrgList",msg.args["pathCode"]);
		}
		[CommandResult(selector="findOperatorByOrgList")]
		public function findOperatorByOrgListResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type = "findOperatorByOrgListResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 根据机构查找对应的终端信息
		 */
		[Command(selector="findTmlNumByOrgList")]
		public function findTmlNumByOrgList(msg:CmlTaskInfoMsg):AsyncToken
		{
			return call("findTmlNumByOrgList",msg.args["pathCode"]);
		}
		[CommandResult(selector="findTmlNumByOrgList")]
		public function findTmlNumByOrgListResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type = "findTmlNumByOrgListResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 获取操作员所有信息
		 */
		[Command(selector="findOperatorAllList")]
		public function findOperatorAllList(msg:CmlTaskInfoMsg):AsyncToken
		{
			return call("findAllOperatorList");
		}
		[CommandResult(selector="findOperatorAllList")]
		public function findOperatorAllListResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type = "findOperatorAllListResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 * 获取终端所有信息
		 */
		[Command(selector="findAllTermList")]
		public function findTermList(msg:CmlTaskInfoMsg):AsyncToken
		{
			return call("findAllTermList");
		}
		[CommandResult(selector="findAllTermList")]
		public function findTermListResultHandler(p_result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type = "findAllTermListResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/////////////////////////////////////////////////////////////////
		
		/**
		 * 
		 */		
		[Command(selector="CmlTaskInfoDelegate:com.grgbanking.sent.transmgr.service.CmlTaskInfoService")]
		public function executeCommandForCmlTaskInfoMsg(msg:CmlTaskInfoMsg):AsyncToken
		{
			trace("CmlTaskInfoDelegate.executeCommandForCmlTaskInfoMsg")
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="CmlTaskInfoDelegate:com.grgbanking.sent.transmgr.service.CmlTaskInfoService")]
		public function executeCommandForCmlTaskInfoMsgResultHandler(result:ResultEvent, trigger:CmlTaskInfoMsg):void
		{
			trace("CmlTaskInfoDelegate.executeCommandForCmlTaskInfoMsgResultHandler")
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="CmlTaskInfoDelegate:com.grgbanking.sent.transmgr.service.CmlTaskInfoService")]
		public function executeCommandForCmlTaskInfoMsgErrorHandler(fault:FaultEvent, trigger:CmlTaskInfoMsg):void
		{
			trace("CmlTaskInfoDelegate.executeCommandForCmlTaskInfoMsgErrorHandler")
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		/////////////////////////////////////////////////////////////////
	}
}