package platform.log.pm
{
	import platform.layer.BasePM;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.log.LogMessage;

	/**
	 * 继承BasePM以获得sendMessage函数
	 **/
	public class LoginLogModulePM extends BasePM
	{
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		
		[Bindable]
		public var page:Page = new Page();
		
		/**搜索条件**/
		[Bindable]
		public var cond:Object = new Object();
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		[Init]
		public function initComplete():void
		{
			searchLoginLogs();
		}
		
		/**
		 * Search card type
		 */
		public function searchLoginLogs():void
		{
			//cond["currentUserId"] = UserInfoInit.userInfo["id"];
			var msg:LogMessage = new LogMessage();
			msg.type = "searchLoginLog";	// java: "searchLoginLog", result: "searchLoginLogsResult"
			msg.args["page"] = page;
			msg.args["cond"] = cond;
			sendMessage(msg);
		}
		
		/**
		 * Batch delete card types
		 * 
		 */		
		public function delLogs(p_delItems:Array):void
		{
			var msg:LogMessage = new LogMessage();
			msg.type = "delLoginLogs";
			msg.args["ids"] = DataGridUtil.getPropertys("id", p_delItems).source;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="searchLoginLogsResult")]
		public function getLogsHandler(p_msg:LogMessage):void
		{
			page = p_msg.result as Page;
		}
		
		/**
		 * 
		 */		
		[MessageHandler(selector="delLoginLogSuccess")]
		public function delLogSuccess(p_msg:LogMessage):void
		{
			if(p_msg.result)
				searchLoginLogs();
		}
	}
}