package platform.security.pm
{
	import mx.collections.ArrayCollection;
	import mx.collections.IList;
	
	import platform.common.manager.AlertHandler;
	import platform.layer.BasePM;
	import platform.security.message.UserMsg;
	import platform.vo.security.UserVo;
	
	public class ConfUserRoleFormPM extends BasePM
	{
		/**
		 * 左列表
		 */		
		[Bindable]
		public var leftDataProvider:ArrayCollection;
		
		/**
		 * 右列表
		 */		
		[Bindable]
		public var rightDataProvider:ArrayCollection;
		
		/**
		 * 用户信息
		 */		
		private var _user:UserVo;
		public function get user():UserVo
		{
			return _user;
		}
		public function set user(value:UserVo):void
		{
			_user = value;
//			AlertHandler.alert("" + value);
			getUserRoles();
		}
		
		/**
		 * 获取用户角色信息
		 * 
		 */		
		public function getUserRoles():void
		{
			var msg:UserMsg = new UserMsg();
			msg.type = "getUserRoles";
			msg.args["id"] = _user.id;
//			msg.args["orgId"] = _user.orgId;
			sendMessage(msg);
		}
		[MessageHandler(selector="getUserRolesResult")]
		public function getUserRolesResult(p_msg:UserMsg):void
		{
			var userRoles:Object = p_msg.result;
			rightDataProvider = userRoles.assignedRoleObjects;
			leftDataProvider = userRoles.unassignedRoleObjects;
		}
		
		/**
		 * 
		 * @param p_selectedItems
		 * 
		 */		
		public function save(p_selectedItems:IList):void
		{
			var newRolesIds:ArrayCollection = new ArrayCollection();
			if (p_selectedItems != null){
				for each (var item:Object in p_selectedItems)
					newRolesIds.addItem(item.id);
			}
			var msg:UserMsg = new UserMsg();
			msg.type = "configureUserRole";
			msg.args["id"] = _user.id;
			msg.args["rolesIds"] = newRolesIds;
			sendMessage(msg);
		}
	}
}