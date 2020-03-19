package platform.security.pm
{
	import mx.collections.ArrayCollection;
	import mx.collections.IList;
	
	import platform.layer.BasePM;
	import platform.security.message.UserMsg;
	import platform.vo.security.UserVo;
	
	public class ConfUserGrpFormPM extends BasePM
	{
		[Bindable]
		public var leftDataProvider:ArrayCollection;
		
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
			getUserGrps();
		}
		
		/**
		 * 
		 * 
		 */		
		public function getUserGrps():void
		{
			var msg:UserMsg = new UserMsg();
			msg.type = "getUserGrps";
			msg.args["id"] = _user.id;
			sendMessage(msg);
		}
		[MessageHandler(selector="getUserGrpsResult")]
		public function getUserGrpsResult(p_msg:UserMsg):void
		{
			var userGrps:Object = p_msg.result;
			rightDataProvider = userGrps.assignedGroupObjects;
			leftDataProvider = userGrps.unassignedGroupObjects;
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
			var msg:UserMsg = new UserMsg();
			msg.type = "configureUserGrp";
			msg.args["id"] = _user.id;
			msg.args["groupIds"] = newGrpIds;
			sendMessage(msg);
		}
	}
}