package platform.security.pm
{
	import mx.collections.ArrayCollection;
	
	import platform.common.vo.Page;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.security.message.GroupMsg;
	
	public class GroupModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		[Init]
		public function init():void
		{
			//loadGroupPage();
		}
		
		public function loadGroupPage(p_cond:String = null):void
		{
			var msg:GroupMsg = new GroupMsg();
			msg.type = "searchGroup";
			msg.args["page"] = page;
			msg.args["condition"] = p_cond;
			sendMessage(msg);
		}
		[MessageHandler(selector="searchGroupResult")]
		public function searchGroupResult(p_msg:GroupMsg):void
		{
			page = p_msg.result as Page;
		}
		
		public function batchDelete(p_arr:ArrayCollection):void
		{
			var msg:GroupMsg = new GroupMsg();
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