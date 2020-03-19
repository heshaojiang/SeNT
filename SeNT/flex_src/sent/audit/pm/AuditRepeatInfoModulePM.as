package sent.audit.pm
{
	import platform.common.formatter.DateFormatter;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	import platform.layer.MessageBase;
	
	import sent.audit.message.AuditRepeatInfoMsg;
	import sent.audit.message.AuditRepeatLogMsg;
	import sent.audit.vo.AuditInfoDetailVO;
	import sent.audit.vo.AuditInfoVO;
	import sent.audit.vo.AuditLogVO;
	import sent.rule.message.NewRepeatRegulationMsg;
	import sent.rule.message.RepeatRegulationMsg;

	public class AuditRepeatInfoModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var audit:AuditInfoVO=new AuditInfoVO();
		//待审核的条数
		[Bindable]
		public var auditCount:int=0;
		//审核流程信息
		[Bindable]
		public var auditLog:AuditLogVO=new AuditLogVO();
		[Bindable]
		public var condi:Object = new Object();
		
		[Bindable] 
		public var auditDetailInfo:AuditInfoDetailVO=new AuditInfoDetailVO();
		/**
		 *加载规则审核信息
		 * 
		 */
		
		
		public function loadAuditInfoRepeatPage():void
		{
			/*	if(!condi.startTime)
			{
			condi.startTime = DateFormatter.format(new Date(),"YYYY-MM-DD JJ:NN:SS");
			//condi.startTime = condi.startTime+" "+"00:00:00";
			}
			if(!condi.endTime)
			{
			condi.endTime = DateFormatter.format(new Date(),"YYYY-MM-DD JJ:NN:SS");
			//condi.endTime = condi.endTime+" "+"23:59:59";
			}*/
			var msg:AuditRepeatInfoMsg = new AuditRepeatInfoMsg();
			msg.type = "getRepeatAuditInfoPage";
			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");	
			
			msg.args["page"]=page;
			msg.args["vo"]=audit;
			sendMessage(msg);
		}
		
		/**
		 * 
		 *规则审核信息返回的结果 
		 */
		[MessageHandler(selector="getRepeatAuditInfoPageResult")]
		public function loadAuditInfoResult(p_msg:AuditRepeatInfoMsg):void{
			if(p_msg)
				page = p_msg.result as Page; 
			// auditCount=page.totalCount;
		}
		/**
		 * 查看申请信息
		 */
		[MessageHandler(selector="getRepeatAuditInfoResult")]
		public function getAuditInfoResult(p_msg:AuditRepeatInfoMsg):void
		{
			if(p_msg.result)
				audit = p_msg.result as AuditInfoVO;
		}
		/**
		 * 审核（通过）
		 */
		public function ruditRegulation(auditDetail:AuditInfoDetailVO):void
		{
			auditDetailInfo=auditDetail;
			var msg:AuditRepeatInfoMsg=new AuditRepeatInfoMsg();
			if(auditLog.applyResult=="Y")
			{
				auditLog.applayDate=new Date();
				var msg1:AuditRepeatInfoMsg=new AuditRepeatInfoMsg();
				msg1.type="updateRepeatRegulationByApplyId";
				msg1.args["applyId"]=auditDetail.applyId;
				msg1.args["regulationStatus"]='9';
				msg1.args["reguStatus"]='1';
				//记录日志
				msg1.logFlag = true;
				msg1.menuId = this.menuId;
				sendMessage(msg1);
				
			}
			//重号规则审核拒回的操作
			else if(auditLog.applyResult=="N")
			{    
				auditLog.applayDate = new Date();
				var msg3:AuditRepeatInfoMsg = new AuditRepeatInfoMsg();
				msg3.type="updateRepeatRegulation";	// java: "updateRepeatRegulationStatus", result: "updateRepeatRegulationResult"
				msg3.args["applyId"]=auditDetail.applyId;
				//修改规则状态
				msg3.args["regulationStatus"]='0';
				//记录日志
				msg3.logFlag = true;
				msg3.menuId = this.menuId;
				sendMessage(msg3);
			}
		}
	
		/**
		 * 重号规则审核通过后的操作
		 */
		[MessageHandler(selector="updateRepeatRegulationByApplyIdResult")]
		public function getRepeatByApplyIdResult(p_msg:AuditRepeatInfoMsg):void
		{
			var msg:MessageBase;
			//var msg1:MessageBase;
			if(p_msg.result)
			{
				loadAuditInfoRepeatPage();
				//刷新重号规则界面
				msg = new AuditRepeatInfoMsg();
				msg.type="refreshRepeatRegulationStatus";
				sendMessage(msg);
				//刷新规则下发明细界面
				msg=new AuditRepeatLogMsg();
				msg.type="refreshRepeatAuditLog";
				sendMessage(msg);
				
				//新增重号规则对应的审核流程信息。
				var msg2:AuditRepeatInfoMsg=new AuditRepeatInfoMsg();
				msg2.type="addRepeatAuditLog";
				auditLog.applyId=auditDetailInfo.applyId;	
				auditLog.userid = UserInfoInit.userInfo["userCode"];
				auditLog.username = UserInfoInit.userInfo["userName"];
				auditLog.orgid = UserInfoInit.userInfo["orgId"];
				
				auditLog.applyType="2";
				auditLog.applyResult="9";
				auditLog.applyStatus="9";
				msg2.args["auditLogVO"]=auditLog;
				sendMessage(msg2);
				//刷新待审核的规则数量
				var msg1:NewRepeatRegulationMsg=new NewRepeatRegulationMsg();
				msg1.type="refreshRepeatAuditCount";
				sendMessage(msg1);
				//刷新待下发的黑名单规则
				var msg3:NewRepeatRegulationMsg=new NewRepeatRegulationMsg();
				msg3.type="refreshRepeatDeliverCount";
				sendMessage(msg3);
				
			}
		}
		/**
		 * 重号规则拒回后的操作
		 */
		[MessageHandler(selector="updateRepeatRegulationResult")]
		public function getRepeatStaByApplyIdResult(p_msg:AuditRepeatInfoMsg):void
		{
			if(p_msg.result)
			{
				var msg:MessageBase;
				loadAuditInfoRepeatPage();
				//刷新重号规则界面
				msg = new RepeatRegulationMsg();
				msg.type="refreshRepeatRegulationStatus";
				sendMessage(msg);
				//刷新规则下发明细界面
				msg=new AuditRepeatLogMsg();
				msg.type="refreshRepeatAuditLog";
				sendMessage(msg);
				//新增审核日志
				var msg2:AuditRepeatInfoMsg=new AuditRepeatInfoMsg();
				msg2.type="addRepeatAuditLog";
				auditLog.applyId=auditDetailInfo.applyId;
				auditLog.userid = UserInfoInit.userInfo["userCode"];
				auditLog.username = UserInfoInit.userInfo["userName"];
				auditLog.orgid = UserInfoInit.userInfo["orgId"];
				
				auditLog.applyType="2";
				auditLog.applyResult="0";
				auditLog.applyStatus="0";
				msg2.args["auditLogVO"]=auditLog;
				sendMessage(msg2);
				//刷新待审核的规则数量
				var msg1:NewRepeatRegulationMsg=new NewRepeatRegulationMsg();
				msg1.type="refreshRepeatAuditCount";
				sendMessage(msg1);
				//刷新待下发的黑名单规则
				var msg3:NewRepeatRegulationMsg=new NewRepeatRegulationMsg();
				msg3.type="refreshRepeatDeliverCount";
				sendMessage(msg3);
			}
		}	
		
		
		/**
		 * 新增审核流程信息返回结果
		 */
		[MessageHandler(selector="addRepeatAuditLogSuccess")]
		public function addAuditInfoResult(p_msg:AuditRepeatInfoMsg):void
		{
			if(p_msg.result){
				var msg1:MessageBase;
				msg1=new AuditRepeatLogMsg();
				msg1.type="refreshRepeatAuditLog";
				sendMessage(msg1);
			}
			
	}
		/**
		 *刷新界面
		 */
		[MessageHandler(selector="refreshRepeatInfo")]
		public function refreshBlackInfo(p_msg:AuditRepeatInfoMsg):void{
			loadAuditInfoRepeatPage();
		}
	}
}