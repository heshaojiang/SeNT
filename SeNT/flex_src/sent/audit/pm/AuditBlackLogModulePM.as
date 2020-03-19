package sent.audit.pm
{
	import platform.common.formatter.DateFormatter;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.audit.message.AuditBlackLogMsg;
	import sent.audit.vo.AuditLogVO;

	public class AuditBlackLogModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		[Bindable]
		public var logPage:Page=new Page();
		
		[Bindable]
		public var condi:Object = new Object();
		
		/**
		 *加载规则下发明细
		 * 
		 */
		public function loadAuditBlackLogPage():void
		{
			var msg:AuditBlackLogMsg = new AuditBlackLogMsg();
			msg.type = "getAuditBlackLogPage";
			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["deliverStatus"] = condi.deliverStatus;
			msg.args["page"]=page;
			sendMessage(msg);
		}
		
		/**
		 * 
		 *规则下发明细返回的结果 
		 */
		[MessageHandler(selector="getAuditBlackLogPageResult")]
		public function loadAuditLogResult(p_msg:AuditBlackLogMsg):void{
			if(p_msg)
				page = p_msg.result as Page; 
		}
		
		/**
		 *规则审核通过 后刷新规则下发明细界面
		 */
		[MessageHandler(selector="refreshBlackAuditLog")]
		public function auditRegulation(p_msg:AuditBlackLogMsg):void
		{
			loadAuditBlackLogPage();
		}
		
		
	}
}