package platform.menu.pm
{
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.StringUtil;
	import platform.layer.BasePM;
	import platform.menu.constants.MenuExceptionKeyConsts;
	import platform.menu.message.ButtonMsg;
	import platform.vo.menu.ButtonVo;
	
	public class ButtonFormPM extends BasePM
	{
		/**页面菜单vo**/
		[Bindable]
		public var buttonInfo:ButtonVo = new ButtonVo();
		
		private var formerVo:ButtonVo;
		
		public function set vo(p_vo:ButtonVo):void
		{
			formerVo = p_vo;
			buttonInfo = ObjectUtil.copy(p_vo) as ButtonVo;
		}
		
		public function setFromVoOrder(p_order:int):void{
			formerVo.order = p_order;
		}
		
		public function getMaxOrderValue():void
		{
			var msg:ButtonMsg = new ButtonMsg();
			msg.type = "getMaxOrderValue";
			sendMessage(msg);
		}
		
		/**
		* 重置表单
		* 
		*/		
		public function reset():void
		{
			buttonInfo = ObjectUtil.copy(formerVo) as ButtonVo;
		}
		
		public function cancel():void
		{
			formerVo.dgSelected = false;
		}
		
		
		public function save(p_operateType:String):void
		{
			if(!buttonInfo)return;
			if (!buttonInfo.i18nName)
			{
				AlertHandler.exception(MenuExceptionKeyConsts.BUTTON_NAME_NOTNULL);
				return;
			}
			buttonInfo.i18nName = StringUtil.trim(buttonInfo.i18nName);
			if(!buttonInfo.buttonType)
				buttonInfo.buttonType = "button";
			if(buttonInfo.buttonType != "icon")
				buttonInfo.iconURL = "";
			//invoke save function
			
			var msg:ButtonMsg = new ButtonMsg();
			msg.type = "save";
			msg.args["button"] = buttonInfo;
			//记录日志
			msg.logFlag = true;
			msg.menuId = this.menuId;
			msg.operate = p_operateType;
			sendMessage(msg);
		}
		
	}
}