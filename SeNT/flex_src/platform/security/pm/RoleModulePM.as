package platform.security.pm
{
	import mx.collections.ArrayCollection;
	
	import platform.common.util.StringUtil;
	import platform.common.vo.Page;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.security.message.RoleMsg;
	
	public class RoleModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		[Init]
		public function init():void
		{
			getRolePage();
		}
		
		public function getRolePage(p_cond:String = null):void
		{
			var condition:Object = {};
			if(StringUtil.trim(p_cond) != "")
				condition["LIKES_roleName"] = StringUtil.trim(p_cond);
			var msg:RoleMsg = new RoleMsg();
			msg.type = "getRolePage";
			msg.args["page"] = page;
			msg.args["condition"] = condition;
			sendMessage(msg);
		}
		[MessageHandler(selector="getRolePageResult")]
		public function getRolePageResult(p_msg:RoleMsg):void
		{
			page = p_msg.result as Page;
		}
		
		public function batchDelete(p_arr:ArrayCollection):void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "deleteSelected";
			msg.args["ids"] = p_arr;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = OperationConsts.DEL;
			sendMessage(msg);
		}
	}
}