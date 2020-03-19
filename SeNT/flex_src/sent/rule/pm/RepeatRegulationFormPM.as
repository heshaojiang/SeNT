package sent.rule.pm
{
	import mx.collections.ArrayCollection;
	import mx.utils.UIDUtil;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.vo.security.UserVo;
	
	import sent.audit.vo.AuditInfoVO;
	import sent.audit.vo.AuditLogVO;
	import sent.rule.message.RegulationDeliverMsg;
	import sent.rule.message.RepeatRegulationMsg;
	import sent.rule.vo.RegulationDeliverVO;
	import sent.rule.vo.RepeatRegulationVO;
	
	public class RepeatRegulationFormPM extends BasePM
	{
		/**
		 * 重号规则对象
		 * */
		[Bindable]
		public var repeatRegulation:RepeatRegulationVO = new RepeatRegulationVO();
		
		/**
		 * 当前选中的用户
		 * */
		public var currentSelectedUser:UserVo;
		
		/**
		 * 当前已选中的终端
		 * */
		[Bindable]
		public var tmpstr:String;
		
		/**
		 * 提交数据
		 * */
		public function submit():void
		{
	
			var termIds:Array = tmpstr.split(",");
			repeatRegulation.regulationStatus = "0";
			repeatRegulation.createDate = new Date();
			repeatRegulation.createName = UserInfoInit.userInfo["userCode"];
			repeatRegulation.reguStatus = "0";//"0";//测试时为了查看到列表信息，直接将状态写成1，正式运行时，要改回0
			repeatRegulation.termNum = termIds.length;
			//增加默认值
			repeatRegulation.creenMode="1";
			repeatRegulation.logMode="1";
			repeatRegulation.enterAccountMode="1";
			var msg:RepeatRegulationMsg = new RepeatRegulationMsg();
			msg.type = "addRepeatRegulation";
			msg.args["repeatRegulationVO"] = repeatRegulation;;
			//记录日志
			msg.operate = OperationConsts.ADD;
			msg.logFlag = true;
			msg.menuId = menuId;
			sendMessage(msg);
		
		}
		
		/**
		 * 新增重号规则成功后添加审核流程和申请信息
		 */
		[MessageHandler(selector="addRepeatRegulationResult")]
		public function addRepeatRegulationResult(p_msg:RepeatRegulationMsg):void
		{
			if(p_msg.result){
				AlertHandler.alert(LanguageManager.getInstance().getExceptionMessage("alertMessage.regulationAddSuccess"));
				repeatRegulation=p_msg.result as RepeatRegulationVO;
				var auditInfo:AuditInfoVO = new AuditInfoVO();
				auditInfo.applyId =repeatRegulation.id;
				auditInfo.applayDate = DateFormatter.format(repeatRegulation.createDate, "YYYYMMDDJJNNSS");
				auditInfo.applyName = repeatRegulation.createName;
				auditInfo.applytyp = "2";//重号规则是2
				auditInfo.auditStatus = "1";
				auditInfo.orgId = UserInfoInit.userInfo["orgId"];
				
				var auditLog:AuditLogVO = new AuditLogVO();
				auditLog.applayDate = repeatRegulation.createDate;
				auditLog.applyId = repeatRegulation.id;
				auditLog.applyStatus = "1";
				auditLog.applyType = "2";//重号规则是2
				auditLog.userid = UserInfoInit.userInfo["userCode"];
				auditLog.username = UserInfoInit.userInfo["userName"];
				auditLog.orgid = UserInfoInit.userInfo["orgId"];
				
				
				var msg:RepeatRegulationMsg = new RepeatRegulationMsg();
				msg.type = "addAuditRepeatRegulation";
				msg.args["auditInfoVO"] = auditInfo;
				msg.args["auditLogVO"] = auditLog;
				//记录日志
				msg.operate = OperationConsts.ADD;
				msg.logFlag = true;
				msg.menuId = menuId;
				sendMessage(msg);
				
				//添加规则下发列表
				var termIds:Array = tmpstr.split(",");
				var regList:ArrayCollection = new ArrayCollection();
				for(var i:int = 0;i < termIds.length;i++){
					var regulationDeliverVO:RegulationDeliverVO = new RegulationDeliverVO();
					regulationDeliverVO.applyId = repeatRegulation.id;
					regulationDeliverVO.status = "0";
					regulationDeliverVO.type = "2";//重号规则是2
					regulationDeliverVO.termid = termIds[i];
					regList.addItem(regulationDeliverVO);
				}
				var regMsg:RepeatRegulationMsg = new RepeatRegulationMsg ();
				regMsg.type = "batchAddRepeatRegulationDeliver";
				regMsg.args["regList"] = regList;
				sendMessage(regMsg);
			}
		}
	}
}