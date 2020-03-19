package platform.menu.pm
{
	/*========================================================*/
	/*   Import                                               */
	/*========================================================*/
	
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.util.StringUtil;
	import platform.layer.BasePM;
	import platform.layer.IMessage;
	import platform.menu.constants.MenuExceptionKeyConsts;
	import platform.menu.message.MenuMsg;
	import platform.vo.menu.MenuVo;
	
	public class MenuFormPM extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		
		/**页面菜单vo**/
		[Bindable]
		public var menu:MenuVo = new MenuVo();
		
		private var formerVo:MenuVo;
		
		public function set vo(p_vo:MenuVo):void
		{
			formerVo = p_vo;
			menu = ObjectUtil.copy(p_vo) as MenuVo;
		}
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		public function getMaxOrderValue():void
		{
			var msg:IMessage = new MenuMsg();
			msg.type = "getMaxOrderValue";
			msg.args["parentId"] = menu.parentId;
			sendMessage(msg);
		}
		
		/**
		 * 重置表单
		 * 
		 */		
		public function reset():void
		{
			menu = ObjectUtil.copy(formerVo) as MenuVo;
		}
		
		public function setFromVoOrder(p_order:int):void{
			formerVo.order = p_order;
		}
		
		public function cancel():void
		{
			formerVo.dgSelected = false;
		}
		
		/**
		 * 保存菜单
		 * 
		 */		
		public function save(p_operateType:String):void
		{
			//menu name can not be null.
			menu.i18nName = StringUtil.trim(menu.i18nName);
			if (!menu.i18nName)
			{
				AlertHandler.exception(MenuExceptionKeyConsts.MENU_NAME_NOTNULL);
				return;
			}
			if (menu.menuURL && menu.menuURL.toString().search("'") != -1)
			{
				AlertHandler.exception(MenuExceptionKeyConsts.MENU_URL_VALIDATE);
				return;
			}
			//invoke save function
			
			var msg:IMessage = new MenuMsg();
			msg.type = "save";
			msg.args["menu"] = menu;
			msg.language = LanguageManager.getInstance().currentLanguage;
			
			//记录日志
			msg.logFlag = true;
			msg.menuId = this.menuId;
			msg.operate = p_operateType;
			sendMessage(msg);
		}
		
	}
}