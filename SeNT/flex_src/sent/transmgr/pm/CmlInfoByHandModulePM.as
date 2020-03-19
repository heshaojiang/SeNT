package sent.transmgr.pm
{
	import mx.controls.Alert;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.common.utils.DateUtils;
	import sent.transmgr.message.CmlInfoByHandMsg;
	
	public class CmlInfoByHandModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var conditions:Object = new Object();
		
		/**
		 * 查询
		 */
		public function queryData():void
		{
			var msg:CmlInfoByHandMsg = new CmlInfoByHandMsg();
			//获取查询条件部的输入数据，并存放到MSG里面
			msg.args["conditions"] = conditions;
			msg.type = "getListCmlInfoByHand";
			msg.args["page"] = page;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getListCmlInfoByHandResult")]
		public function getPageHandler(p_msg:CmlInfoByHandMsg):void
		{
			page = p_msg.result as Page;
			
		}
		
		/**
		 * 删除手工清分信息请求
		 * @param p_msg
		 * 
		 */
		public function deleteCmlInfoByHand(p_msg:CmlInfoByHandMsg):void{
			var msg:CmlInfoByHandMsg = new CmlInfoByHandMsg();
			msg.type = "deleteCmlInfoByHand";
			msg.args["selectedObj"] = p_msg.args["selectedObj"];
			sendMessage(msg);
		}
		
		/**
		 * 删除手工清分信息的响应
		 * @param p_msg
		 * 
		 */
		[MessageHandler(selector="deleteCmlInfoByHandResult")]
		public function deleteCmlInfoByHandResultHandler(p_msg:CmlInfoByHandMsg):void{
			queryData();
		}
	}
}