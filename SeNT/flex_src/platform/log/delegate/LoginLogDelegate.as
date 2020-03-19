package platform.log.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	import platform.log.LogMessage;
	import platform.services.GRGRemoteObject;
	
	public class LoginLogDelegate extends platform.layer.DelegateBase
	{
		[Inject(id="loginLogService")]
		public var logService:GRGRemoteObject;
		
		/**初始化完成后设置父类remote object**/
		[Init]
		public function setRemoteObject():void
		{
			super._ro = logService;
		}
		
		/**
		 * 查询日志
		 */		
		[Command(selector="searchLoginLog")]
		public function searchOperLog(p_msg:LogMessage):AsyncToken
		{
			return call("searchLoginLog", p_msg.args["page"], p_msg.args["cond"]);
		}
		[CommandResult(selector="searchLoginLog")]
		public function searchOperLogResult(p_result:ResultEvent, p_trigger:LogMessage):void
		{
			var msg:LogMessage = new LogMessage();
			msg.type = "searchLoginLogsResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		/**
		 * 删除日志
		 */		
		[Command(selector="delLoginLogs")]
		public function delLogs(p_msg:LogMessage):AsyncToken
		{
			//TODO
			return call("batchDelete", p_msg.args["ids"]);;
		}
		[CommandResult(selector="delLoginLogs")]
		public function delLogsResult(p_result:ResultEvent, p_trigger:LogMessage):void
		{
			var logMsg:LogMessage = new LogMessage();
			logMsg.type = "delLoginLogSuccess";
			logMsg.result = p_result.result;
			sendMessage(logMsg);
		}
	}
}