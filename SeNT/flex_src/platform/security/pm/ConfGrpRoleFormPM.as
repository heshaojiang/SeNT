package platform.security.pm
{
	import mx.collections.ArrayCollection;
	import mx.collections.IList;
	
	import platform.layer.BasePM;
	import platform.security.message.GroupMsg;
	import platform.vo.security.GroupVo;
	
	public class ConfGrpRoleFormPM extends BasePM
	{
		[Bindable]
		public var leftDataProvider:ArrayCollection;
		
		[Bindable]
		public var rightDataProvider:ArrayCollection;
		
		private var _group:GroupVo;
		public function get group():GroupVo
		{
			return _group;
		}
		public function set group(value:GroupVo):void
		{
			_group = value;
			getGrpRoles();
		}
		
		/**
		 * 
		 * 
		 */		
		public function getGrpRoles():void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "getGrpRoles";
			msg.args["id"] = _group.id;
			sendMessage(msg);
		}
		[MessageHandler(selector="getGrpRolesResult")]
		public function getGrpRolesResult(p_msg:GroupMsg):void
		{
			var grpRoles:Object = p_msg.result;
			rightDataProvider = grpRoles.assignedRoleObjects;
			leftDataProvider = grpRoles.unassignedRoleObjects;
		}
		
		/**
		 * 
		 * @param p_selectedItems
		 * 
		 */		
		public function save(p_selectedItems:IList):void
		{
			var newRoleIds:ArrayCollection = new ArrayCollection();
			if (p_selectedItems != null){
				for each (var item:Object in p_selectedItems)
				newRoleIds.addItem(item.id);
			}
			var msg:GroupMsg = new GroupMsg();
			msg.type = "configureGrpRole";
			msg.args["id"] = _group.id;
			msg.args["roleIds"] = newRoleIds;
			sendMessage(msg);
		}
	}
}