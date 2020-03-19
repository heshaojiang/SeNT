package sent.rule.pm
{
	import mx.collections.ArrayCollection;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	import platform.layer.MessageBase;
	
	import sent.audit.message.AuditRepeatInfoMsg;
	import sent.rule.message.NewRepeatRegulationMsg;
	import sent.rule.message.RegulationDeliverMsg;
	import sent.rule.message.RepeatRegulationMsg;
	import sent.rule.vo.RepeatRegulationVO;
	
	public class RepeatRegulationPM extends BasePM
	{
		[Bindable]
		public var repeatList:Array=new Array();
		[Bindable]
		public var page:Page = new Page();
		/**
		 * 重号规则的规则下发详情
		 * */
		[Bindable]
		public var repeatPage:Page=new Page();
		private var num:int;
		[Bindable]
		private var repeatId:String;
		[Bindable]
		public var repeatRegulationVO:RepeatRegulationVO = new RepeatRegulationVO();
		
		/**
		 * 初始化后加载数据
		 */		
		[Init]
		public function init():void
		{
			loadPage();
		}
		
		public function loadPage():void
		{
			var msg:RepeatRegulationMsg = new RepeatRegulationMsg();
			msg.type = "getRepeatRegulationPage";	// java: "getRepeatRegulationPage", result: "getRepeatRegulationPageResult"
		    if(repeatRegulationVO.reguStatus==null)
			{
				//默认重号规则的规则下发状态为"1"，待下发
				repeatRegulationVO.reguStatus="1";
			}
			msg.args["vo"] = repeatRegulationVO;
			msg.args["page"] = page;
			sendMessage(msg);
		}
		[MessageHandler(selector="getRepeatRegulationPageResult")]
		public function getRepeatRegulationPageResult(p_msg:RepeatRegulationMsg):void
		{
			if(p_msg.result)
				page = p_msg.result as Page;
		}
		
		/**
		 * 重号规则下发
		 * */
		public function deviceRepeat(p_source:Array):void
		{
			var msg:RepeatRegulationMsg =new RepeatRegulationMsg();
			msg.type="updateRepeatRole";	// java: "updateBeforeRepeatDeliver", result: "updateRepeatRoleResult"
		    msg.args["repeatList"]=DataGridUtil.getPropertys("id", p_source).source;	
			sendMessage(msg);
			
		}
		/**
		 * 更新规则后的回调函数（下发规则）
		 * */
		[MessageHandler(selector="updateRepeatRoleResult")]
		public function updateRepeatRoleResult(p_msg:RepeatRegulationMsg):void
		{
			if(p_msg.result)
			{
				repeatList=p_msg.result as Array;
				var msg:RepeatRegulationMsg = new RepeatRegulationMsg();
				msg.type = "repeatDeliver";	// java: "deliver", result: "repeatDeliverResult"
				msg.args["repeatList"] =repeatList ;
				msg.logFlag = true;
				msg.menuId = menuId;
				sendMessage(msg);
			}
		}
		
		/**
		 * 重号规则下发返回值
		 */
		[MessageHandler(selector="repeatDeliverResult")]
		public function repeatRegulationDeliverResult(p_msg:RepeatRegulationMsg):void
		{
			if(p_msg.result)
			{
				//返回值
				
				loadPage();
				var msg:MessageBase;
				//刷新规则下发详情界面
				msg=new RegulationDeliverMsg();
				msg.type="refreshRegulationDeliver";
				sendMessage(msg);
				//刷新待下发的数量
				var msg1:NewRepeatRegulationMsg=new NewRepeatRegulationMsg();
				msg1.type="refreshRepeatDeliverCount";
				sendMessage(msg1);
				num=p_msg.result as int;
				switch(num)
				{
					case 1:	
						AlertHandler.alert("chooseDeliver");
						break;
					case 2:
						AlertHandler.alert("deliverDetail");
						break;
					case 3:
						AlertHandler.alert("deliverSuccess");
						break;
					
				}
				
			}
			
		}
		
		/**
		 * 重号规则撤消先更新规则信息
		 */
		public function cancelRegulation(p_item:RepeatRegulationVO):void
		{
			var msg:RepeatRegulationMsg=new RepeatRegulationMsg();
			msg.type="updateRepeatRegulatonInfo";	// java: "updateRegulatonInfo", result: "updateRepeatRegulatonInfoResult"
			msg.args["repeatReg"]=p_item.id;
			repeatId=p_item.id;
			msg.operate = "updateRepeatRegulatonInfo";
			msg.logFlag = true;
			msg.menuId = menuId;
			sendMessage(msg);
		}
		
		/**
		 * 重号规则撤销先更新规则信息的回调函数
		 * */
		[MessageHandler(selector="updateRepeatRegulatonInfoResult")]
		public function updateRepeatRegulation(p_msg:RepeatRegulationMsg):void
		{
			if(p_msg.result)
			{
				var msg:RepeatRegulationMsg = new RepeatRegulationMsg();
				msg.type = "cancelRepeatRegulationDeliver";
				msg.args["repeatReg"] = repeatId;
				//记录日志
				msg.operate = "cancelRepeatRegulationDeliver";
				msg.logFlag = true;
				msg.menuId = menuId;
				sendMessage(msg);
			}
		}
		
		/**
		 * 撤销重号规则
		 * 
		 */
		[MessageHandler(selector="cancelRepeatRegulationDeliverResult")]
		public function cancelRepeatRegulationDeliverResult(p_msg:RepeatRegulationMsg):void
		{
			if(p_msg.result)
			{
				num=p_msg.result as int;
				switch(num)
				{
					case 1:
						AlertHandler.alert("chooseResovkDelivered");
						break;
					case 2:
						AlertHandler.alert("chooseCancelDelivered");
						break;
					case 3://操作失败
						AlertHandler.alert("cancelFail");
						break;
					case 4://撤销成功
						AlertHandler.alert("cancelSuccess");
						break;
				}
				loadPage();
				var msg:MessageBase;
				//刷新规则下发详情界面
				msg=new RegulationDeliverMsg();
				msg.type="refreshRegulationDeliver";
				sendMessage(msg);
				//刷新待下发的数量
				var msg1:NewRepeatRegulationMsg=new NewRepeatRegulationMsg();
				msg1.type="refreshRepeatDeliverCount";
				sendMessage(msg1);
				num=p_msg.result as int;
				
			}
		}
		
		/**重号规则审核后回调函数*/
		[MessageHandler(selector="addAuditRepeatRegulationResult")]
		public function addAuditRepeatRegulationResult(p_msg:RepeatRegulationMsg):void
		{
			if(p_msg.result)
			{
				
				var msg:MessageBase;
				msg=new AuditRepeatInfoMsg();
				msg.type="refreshRepeatInfo";
				sendMessage(msg);
				
				//刷新待审核的规则数量
				var msg1:NewRepeatRegulationMsg=new NewRepeatRegulationMsg();
				msg1.type="refreshRepeatAuditCount";
				sendMessage(msg1);
				loadPage();
			}
				
		}
		
		/**
		 * 添加重号列表回调函数
		 */		
		/*[MessageHandler(selector="batchAddRegulationDeliverResult")]
		public function addRegulationDeliverResult(p_msg:RepeatRegulationMsg):void
		{
			if(p_msg.result)
			{
			  loadPage();
			}
		}*/
		
		/**
         *审核完重号规则以后刷新重号规则界面
		 */
		 [MessageHandler(selector="refreshRepeatRegulationStatus")]
		public function refreshRepeatRegulationStatus(p_msg:RepeatRegulationMsg):void
		{
			loadPage();
		}
	}
}