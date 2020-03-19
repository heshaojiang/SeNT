package platform.security.pm
{
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.constants.OperationConsts;
	import platform.global.AppGlobal;
	import platform.layer.BasePM;
	import platform.security.message.UserMsg;
	import platform.vo.security.UserVo;
	
	public class UserFormPM extends BasePM
	{
		[Bindable]
		public var _user:UserVo;
		
		public var formerVO:UserVo; 
		
		[Bindable]
		public var extendProperties:ArrayCollection;
		
		[Bindable]
		public var userLevels:ArrayCollection;
		
		public function set vo(p_vo:UserVo):void
		{
			formerVO = p_vo;
			_user = ObjectUtil.copy(p_vo) as UserVo;
			if(p_vo)
				extendProperties = AppGlobal.getExtendProperties(p_vo);
			
			getUserLevels();
		}
		
		private function getUserLevels():void
		{
			var msg:UserMsg = new UserMsg();
			msg.type ="getUserLevels";
			msg.args["userCode"] = UserInfoInit.userInfo["userCode"];
			sendMessage(msg);
		}
		
		[MessageHandler(selector="getUserLevelsResult")]
		public function getUserLevelsResult(p_msg:UserMsg):void
		{
			userLevels = p_msg.result as ArrayCollection;
		}
		
		/**
		 * 保存角色
		 * 
		 */		
		public function save():void
		{
			if(!_user.orgId){
				AlertHandler.exception("security.orgNotNull");
				return;
			}
			if(!_user.areaId){
				AlertHandler.exception("security.areaNotNull");
				return;
			}
			var msg:UserMsg = new UserMsg();
			if(!_user.id)
				msg.type = "newUser";
			else
				msg.type = "updateUser";
			msg.args["vo"] = _user;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = _user.id ? OperationConsts.EDIT :
				OperationConsts.ADD;
			sendMessage(msg);
		}		
		
		/**
		 * reset form
		 * 
		 */		
		public function reset():void
		{
			_user = ObjectUtil.copy(formerVO) as UserVo;
		}
		
		public function cancel():void
		{
			formerVO.dgSelected = false;
		} 
	}
}