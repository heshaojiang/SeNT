package platform.security.pm
{
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.security.message.RoleMsg;
	import platform.vo.security.RoleVo;
	
	public class RoleFormPM extends BasePM
	{
		[Bindable]
		public var roleLevels:ArrayCollection;
		
		[Bindable]
		public var _role:RoleVo;
		
		public var formerVO:RoleVo;
		
		public function set vo(p_vo:RoleVo):void
		{
			formerVO = p_vo;
			_role = ObjectUtil.copy(p_vo) as RoleVo;
			getRoleLevels();
		}
		
		/**
		 * 获取角色列表
		 * 
		 */		
		private function getRoleLevels():void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type ="getRoleLevels";
			sendMessage(msg);
		}
		[MessageHandler(selector="getRoleLevelsResult")]
		public function getRoleLevelsResult(p_msg:RoleMsg):void
		{
			roleLevels = p_msg.result as ArrayCollection;
		}
		
		/**
		 * 保存角色
		 * 
		 */		
		public function save():void
		{
			if (_role.roleName == ""){
				AlertHandler.exception("security.roleNameNotNull");
				return;
			}
			var msg:RoleMsg = new RoleMsg();
			msg.type = "saveRole";
			msg.args["vo"] = _role;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = _role.id ? OperationConsts.EDIT :
				OperationConsts.ADD;
			sendMessage(msg);
		}
		
		/**
		 * reset form
		 * 
		 */		
		public function reset():void
		{
			_role = ObjectUtil.copy(formerVO) as RoleVo;
		}
		
		public function cancel():void
		{
			formerVO.dgSelected = false;
		}
	}
}