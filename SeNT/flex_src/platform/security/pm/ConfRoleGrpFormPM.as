package platform.security.pm
{
	import mx.collections.ArrayCollection;
	import mx.collections.IList;
	
	import platform.layer.BasePM;
	import platform.security.message.RoleMsg;
	import platform.vo.security.RoleVo;
	
	public class ConfRoleGrpFormPM extends BasePM
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
			getRoleGrps();
		}
		
		/**
		 * 
		 * 
		 */		
		public function getRoleGrps():void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "getRoleGrps";
			msg.args["id"] = _role.id;
			sendMessage(msg);
		}
		[MessageHandler(selector="getRoleGrpsResult")]
		public function getRoleGrpsResult(p_msg:RoleMsg):void
		{
			var roleGrps:Object = p_msg.result;
			rightDataProvider = roleGrps.assignedGroupObjects;
			leftDataProvider = roleGrps.unassignedGroupObjects;
		}
		
		/**
		 * 
		 * @param p_selectedItems
		 * 
		 */		
		public function save(p_selectedItems:IList):void
		{
			var newGrpIds:ArrayCollection = new ArrayCollection();
			if (p_selectedItems != null){
				for each (var item:Object in p_selectedItems)
					newGrpIds.addItem(item.id);
			}
			var msg:RoleMsg = new RoleMsg();
			msg.type = "configureRoleGrp";
			msg.args["id"] = _role.id;
			msg.args["groupIds"] = newGrpIds;
			sendMessage(msg);
		}
	}
}