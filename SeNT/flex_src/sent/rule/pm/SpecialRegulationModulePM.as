package sent.rule.pm
{
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	
	import sent.rule.message.SpecialRegulationModuleMsg;
	import sent.rule.vo.SpecialRegulationVO;

	public class SpecialRegulationModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var specialRegulationVO:SpecialRegulationVO = new SpecialRegulationVO();
		
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
		 */		
		
		public function loadPage():void
		{
			var msg:SpecialRegulationModuleMsg = new SpecialRegulationModuleMsg();
			msg.type = "getSpecialRegulationPage";
			msg.args["vo"]= specialRegulationVO;
			msg.args["page"] = page;
			sendMessage(msg);
		}
		
		/**
		 * 特殊规则
		*/
		
		[MessageHandler(selector="getSpecialRegulationPageResult")]
		public function getSpecialRegulationPageResult(p_msg:SpecialRegulationModuleMsg):void
		{
			if(p_msg.result)
				page = p_msg.result as Page;
		}
		
		/**
		 * 删除特殊规则 
		*/
		
		public function delRegulation(p_delItems:Array):void
		{
			if(p_delItems.length <= 0){
				AlertHandler.alert(LocaleConsts.NO_SELECTED_RECORD);
				return;
			}
			AlertHandler.confirm(closeHandler,null,LocaleConsts.CONFIRM_DELETE);
			function closeHandler(evt:CloseEvent):void
			{
			if (evt.detail == Alert.YES){
			var msg:SpecialRegulationModuleMsg= new SpecialRegulationModuleMsg();
			msg.type = "deleteSpecialRegulation";
			msg.args["ids"] = DataGridUtil.getPropertys("id", p_delItems).source;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = OperationConsts.DEL;
			sendMessage(msg);
		     }
			}
		}
		
		/**
		 * 新增返回的结果
		 */
		
		[MessageHandler(selector="newSpecialRegulationSaveSuccess")]
		public function newRegulationResult(p_msg:SpecialRegulationModuleMsg):void
		{
			if(p_msg.result)
				init();
		}
		
		/**
		 * 修改返回的结果
		 */
		
		[MessageHandler(selector="updateSpecialRegulationSuccess")]
		public function editRegulationResult(p_msg:SpecialRegulationModuleMsg):void
		{
			if(p_msg.result)
				init();
		}
		
		/**
		 * 删除返回的结果
		 */
		
		[MessageHandler(selector="deleteSpecialRegulationSuccess")]
		public function delRegulationResult(p_msg:SpecialRegulationModuleMsg):void
		{
				init();
		}
		
	}
}