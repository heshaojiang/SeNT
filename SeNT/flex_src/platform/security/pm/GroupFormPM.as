package platform.security.pm
{
	import mx.utils.ObjectUtil;
	
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.security.message.GroupMsg;
	import platform.vo.security.GroupVo;
	
	public class GroupFormPM extends BasePM
	{		
		[Bindable]
		public var _group:GroupVo;
		
		public var formerVO:GroupVo;
		
		public function set vo(p_vo:GroupVo):void
		{
			formerVO = p_vo;
			_group = ObjectUtil.copy(p_vo) as GroupVo;
		}
		
		/**
		 * 保存角色
		 * 
		 */		
		public function save():void
		{
			var msg:GroupMsg = new GroupMsg();
			if(!_group.id)
				msg.type = "newGroup";
			else
				msg.type = "updateGroup";
			msg.args["vo"] = _group;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = _group.id ? OperationConsts.EDIT :
				OperationConsts.ADD;
			sendMessage(msg);
		}
		
		/**
		 * reset form
		 * 
		 */		
		public function reset():void
		{
			_group = ObjectUtil.copy(formerVO) as GroupVo;
		}
		
		public function cancel():void
		{
			formerVO.dgSelected = false;
		}
	}
}