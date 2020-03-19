package sent.rule.pm
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.layer.MessageBase;
	
	import sent.audit.message.AuditBlackInfoMsg;
	import sent.audit.message.AuditBlackLogMsg;
	import sent.audit.vo.AuditInfoVO;
	import sent.audit.vo.AuditLogVO;
	import sent.rule.constants.BlackRegulationConsts;
	import sent.rule.message.BlackRegulationMsg;
	import sent.rule.message.NewBlackRegulationMsg;
	import sent.rule.message.RegulationDeliverMsg;
	import sent.rule.vo.BlackRegulationVO;
	
	public class BlackRegulationPM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		[Bindable]
		public var blackPage:Page =new Page();
		[Bindable]
		private var list:Array=new Array();
		[Bindable]
		private var blackId:String;
		[Bindable]
		public var blackRegulationVO:BlackRegulationVO = new BlackRegulationVO();
	
		/**
		 * 返回的数字判断提示信息
		 */
		[Bindable]
		private var num:int;
		/**
		 * 初始化后加载数据
		 */		
		[Init]
		public function init():void
		{
			loadPage();
		}
		
		/**
		 * 加载列表页
		 * 
		 */		
		public function loadPage():void
		{
			var msg:BlackRegulationMsg = new BlackRegulationMsg();
			msg.type = "getBlackRegulationPage";
		    msg.args["vo"] = blackRegulationVO;
			msg.args["page"] = page;
			sendMessage(msg);
		}
		/**
		 * 列表页返回的结果集 
		 */
		[MessageHandler(selector="getBlackRegulationPageResult")]
		public function getBlackRegulationPageResult(p_msg:BlackRegulationMsg):void
		{
			if(p_msg.result)
				page = p_msg.result as Page;
		}
		
		/**
		 * 新增/编辑 完成后回调函数
		 */		
		[MessageHandler(selector="addBlackRegulationResult")]
		public function addAuditBlackRegulationResult(p_msg:BlackRegulationMsg):void
		{
			if(p_msg.result)
			{
				loadPage();
				//刷新规则审核页面
				var msg:MessageBase;
				msg=new AuditBlackInfoMsg();
				msg.type="refreshBlackInfo";
			    sendMessage(msg);
				//刷新待审核的规则数量
				var msg1:NewBlackRegulationMsg=new NewBlackRegulationMsg();
				msg1.type="refreshAuditCount";
				sendMessage(msg1);
			}
		}
		
		/**
		 * 审核完成后刷新界面
		 * */
		[MessageHandler(selector="refreshBlackRegulationStatus")]
		public function refreshRegulationStatus(p_msg:BlackRegulationMsg):void
		{
			loadPage();
		}
		
		/**
		 * 删除黑名单规则
		 * */
		public function deleteBlackRegulation(p_delItems:Array):void
		{
			AlertHandler.confirm(closeHandler, null, LocaleConsts.CONFIRM_DELETE);
			//close handler
			function closeHandler(evt:CloseEvent):void
			{
				if (evt.detail == Alert.YES){
					var msg:BlackRegulationMsg = new BlackRegulationMsg();
					msg.type = "deleteBlackRegulation";
					msg.args["ids"] = DataGridUtil.getPropertys("id", p_delItems); 
					msg.operate = OperationConsts.DEL;
					sendMessage(msg);
				}
			}
		}
		[MessageHandler(selector="deleteBlackRegulationResult")]
		public function delBackHandler(p_msg:BlackRegulationMsg):void
		{
			trace(p_msg.result)
			var blackList:ArrayCollection = p_msg.result as ArrayCollection;
			if(blackList.length == 0){
				AlertHandler.alert(LocaleConsts.DELETE_SUCCESS);
			} else {
				AlertHandler.alert(LanguageManager.getInstance().getExceptionMessage("blackRegulationForm.operSuccess"));
			}
			
			loadPage();
			//刷新规则审核页面
			var msg:MessageBase;
			msg=new AuditBlackInfoMsg();
			msg.type="refreshBlackInfo";
			sendMessage(msg);
			//刷新待审核的规则数量
			var msg1:NewBlackRegulationMsg=new NewBlackRegulationMsg();
			msg1.type="refreshAuditCount";
			sendMessage(msg1);
		}
		
		/**
		 * 添加终端下发记录
		 * */
		public function addBlackRegulationDeliver(p_termStr:String):void{
			var msg:BlackRegulationMsg = new BlackRegulationMsg();
			msg.type = "addBlackRegulationDeliver";
			msg.args["termStr"] = p_termStr; 
			sendMessage(msg);
		}
		
		/**
		 * 下发终端
		 */
		public function syncSendToSentServer(msg:BlackRegulationMsg):void
		{
			msg.type = "BlackRegulationDelegate:com.grgbanking.sent.rule.service.BlackRegulationService";
			sendMessage(msg);
		}
		
	}
}