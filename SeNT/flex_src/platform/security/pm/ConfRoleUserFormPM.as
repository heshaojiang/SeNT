package platform.security.pm
{
	import mx.collections.ArrayCollection;
	import mx.collections.IList;
	
	import platform.layer.BasePM;
	import platform.security.message.RoleMsg;
	import platform.vo.security.RoleVo;
	
	public class ConfRoleUserFormPM extends BasePM
	{
		[Bindable]
		public var leftDataProvider:ArrayCollection;
		
		[Bindable]
		public var rightDataProvider:ArrayCollection;
		
		private var _role:RoleVo;
		public function get role():RoleVo
		{
			return _role;
		}
		public function set role(value:RoleVo):void
		{
			_role = value;
			getRoleUsers();
		}
		
		/**
		 * 
		 * 
		 */		
		public function getRoleUsers():void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "getRoleUsers";
			msg.args["id"] = _role.id;
			sendMessage(msg);
		}
		[MessageHandler(selector="getRoleUsersResult")]
		public function getRoleUsersResult(p_msg:RoleMsg):void
		{
			var roleGrps:Object = p_msg.result;
			rightDataProvider = roleGrps.assignedUserObjects;
			leftDataProvider = roleGrps.unassignedUserObjects;
		}
		
		/**
		 * 
		 * @param p_selectedItems
		 * 
		 */		
		public function save(p_selectedItems:IList):void
		{
			var newUserIds:ArrayCollection = new ArrayCollection();
			if (p_selectedItems != null){
				for each (var item:Object in p_selectedItems)
					newUserIds.addItem(item.id);
			}
			var msg:RoleMsg = new RoleMsg();
			msg.type = "configureRoleUser";
			msg.args["id"] = _role.id;
			msg.args["userIds"] = newUserIds;
			sendMessage(msg);
		}
	}
}