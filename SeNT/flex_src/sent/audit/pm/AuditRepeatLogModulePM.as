package sent.audit.pm
{
	import platform.common.formatter.DateFormatter;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.audit.message.AuditRepeatLogMsg;
	import sent.audit.vo.AuditLogVO;

	public class AuditRepeatLogModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		[Bindable]
		public var logPage:Page=new Page();
		
		[Bindable]
		public var audit:AuditLogVO=new AuditLogVO();
		
		
		[Bindable]
		public var condi:Object = new Object();
		
		/**
		 *加载规则下发明细
		 * 
		 */
		
		public function loadRepeatAuditLogPage():void
		{
			var msg:AuditRepeatLogMsg = new AuditRepeatLogMsg();
			msg.type = "getRepeatAuditLogPage";
			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");	
			
			msg.args["page"]=page;
			msg.args["vo"]=audit;
			sendMessage(msg);
		}
		
		/**
		 * 
		 *规则下发明细返回的结果 
		 */
		[MessageHandler(selector="getRepeatAuditLogPageResult")]
		public function loadAuditLogResult(p_msg:AuditRepeatLogMsg):void{
			if(p_msg)
				page = p_msg.result as Page; 
		}
		
		/**
		 *规则审核通过 后刷新规则下发明细界面
		 */
		[MessageHandler(selector="refreshRepeatAuditLog")]
		public function auditRegulation(p_msg:AuditRepeatLogMsg):void
		{
			loadRepeatAuditLogPage();
		}
		
		
		
	}
}