package platform.menu.pm
{
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.menu.message.MenuMsg;
	import platform.vo.menu.ButtonVo;
	import platform.vo.menu.MenuVo;
	
	public class SetButtonPM extends BasePM
	{
		[Bindable]
		public var privilegeBtns:ArrayCollection;
		
		/**页面菜单vo**/
		[Bindable]
		public var menu:MenuVo = new MenuVo();
		
		private var formerVo:MenuVo;
		
		public function set vo(p_vo:MenuVo):void
		{
			//import the buttonVo class in this line,it can't remove.
			ButtonVo;
			
			formerVo = p_vo;
			menu = ObjectUtil.copy(p_vo) as MenuVo;
			
			loadMenuButtons();
		}		
		
		/**
		 * 加载菜单按钮
		 * 
		 */		
		public function loadMenuButtons():void
		{
			var msg:MenuMsg = new MenuMsg();
			msg.type = "getMenuButtons";
			msg.args["id"] = menu.id;
			sendMessage(msg);
		}
		[MessageHandler(selector="getMenuButtonsResult")]
		public function getMenuButtonsResult(p_msg:MenuMsg):void
		{
			if (p_msg.result)
				privilegeBtns = p_msg.result as ArrayCollection;
		}

		/**
		 * 设定按钮集合
		 * @param p_selectedItems
		 * @param p_unselectedItems
		 * 
		 */		
		public function saveMenuButtonSetting(p_selectedItems:ArrayCollection, 
										  		p_unselectedItems:ArrayCollection):void
		{
			var msg:MenuMsg = new MenuMsg();
			msg.type = "setMenuButtonsSave";
			msg.args["id"] = menu.id;
			msg.args["selectedItems"] = p_selectedItems;
			msg.args["unselectedItems"] = p_unselectedItems;
			
			//记录日志
			msg.logFlag = true;
			msg.menuId = menu.id;
			msg.operate = OperationConsts.SET_BUTTONS;
			sendMessage(msg);
		}
		
		/**
		 * cancel operation
		 * 
		 */		
		public function cancel():void
		{
			formerVo.dgSelected = false;
		}		
	}
}