package sent.audit.pm
{
	import mx.controls.Alert;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	import platform.layer.MessageBase;
	
	import sent.audit.message.AuditBlackInfoMsg;
	import sent.audit.message.AuditBlackLogMsg;
	import sent.audit.vo.AuditBlackDetailVO;
	import sent.audit.vo.AuditInfoDetailVO;
	import sent.audit.vo.AuditInfoVO;
	import sent.audit.vo.AuditLogVO;
	import sent.rule.message.BlackRegulationMsg;
	import sent.rule.message.NewBlackRegulationMsg;
	import sent.rule.vo.BlackRegulationVO;

	public class AuditBlackInfoModulePM extends BasePM
	{
		
		[Bindable]
		public var page:Page = new Page();
		
		//待审核的条数
		[Bindable]
		public var auditCount:int=0;
		
		//审核结果
		[Bindable]
		public var auditResult:String;
		
		//退回原因
		[Bindable]
		public var rejectReason:String;
		
		[Bindable]
		public var condi:Object = new Object();
		
		[Bindable] 
		public var auditDetailInfo:AuditInfoDetailVO=new AuditInfoDetailVO();
		
		/**
		 * 加载待审核的黑名单列表
		 * */
		public function loadAuditInfoBlackPage():void
		{
			var msg:AuditBlackInfoMsg = new AuditBlackInfoMsg();
			msg.type = "getBlackAuditInfoPage";
			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");	
			msg.args["page"]=page;
			sendMessage(msg);
		}
		/**
		 * 
		 * 获取待审核的黑名单列表信息返回的结果 
		 */
		[MessageHandler(selector="getBlackAuditInfoPageResult")]
		public function loadAuditInfoResult(p_msg:AuditBlackInfoMsg):void{
			if(p_msg)
				page = p_msg.result as Page;
		}

		/**
		 * 审核动作
		 * */
		public function ruditRegulation(p_auditDetail:AuditBlackDetailVO):void
		{
			var blackRule:BlackRegulationVO = new BlackRegulationVO();
			blackRule.id = p_auditDetail.id;
			blackRule.auditId = UserInfoInit.userInfo["userCode"];
			blackRule.auditDate = new Date();
			var msg:AuditBlackInfoMsg = new AuditBlackInfoMsg();
			msg.type = "auditBlackRegulation";
			msg.args["auditResult"]=auditResult;
			msg.args["blackRule"]=blackRule;
			msg.args["rejectReason"]=rejectReason;
			sendMessage(msg);
		}

		/**
		 * 规则审核后回调函数
		 * */
		[MessageHandler(selector="auditBlackRegulationResult")]
		public function auditBlackRegulationResult(p_msg:AuditBlackInfoMsg):void
		{
			if(p_msg.result)
			{
				loadAuditInfoBlackPage();
				var msg:MessageBase;
				
				//刷新黑名单生成界面界面
				msg = new BlackRegulationMsg();
				msg.type = "refreshBlackRegulationStatus";
				sendMessage(msg);
				
				//刷新待审核的规则数量
				var msg3:NewBlackRegulationMsg=new NewBlackRegulationMsg();
				msg3.type="refreshAuditCount";
				sendMessage(msg3);
			}
			
		}
		
		/**
		 *刷新界面
		 */
		[MessageHandler(selector="refreshBlackInfo")]
		public function refreshBlackInfo(p_msg:AuditBlackInfoMsg):void{
			loadAuditInfoBlackPage();
		}
	}
}