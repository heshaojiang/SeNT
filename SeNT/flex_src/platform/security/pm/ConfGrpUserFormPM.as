package platform.security.pm
{
	import mx.collections.ArrayCollection;
	import mx.collections.IList;
	
	import platform.layer.BasePM;
	import platform.security.message.GroupMsg;
	import platform.vo.security.GroupVo;
	
	public class ConfGrpUserFormPM extends BasePM
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
			getGrpUsers();
		}
		
		/**
		 * 
		 * 
		 */		
		public function getGrpUsers():void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "getGrpUsers";
			msg.args["id"] = _group.id;
			sendMessage(msg);
		}
		[MessageHandler(selector="getGrpUsersResult")]
		public function getGrpUsersResult(p_msg:GroupMsg):void
		{
			var grpUsers:Object = p_msg.result;
			rightDataProvider = grpUsers.assignedUserObjects;
			leftDataProvider = grpUsers.unassignedUserObjects;
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
			var msg:GroupMsg = new GroupMsg();
			msg.type = "configureGrpUser";
			msg.args["id"] = _group.id;
			msg.args["userIds"] = newUserIds;
			sendMessage(msg);
		}
	}
}