package platform.log.pm
{
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	
	import platform.common.util.DataGridUtil;
	import platform.common.util.ObjectUtils;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	import platform.log.LogMessage;

	/**
	 * 继承BasePM以获得sendMessage函数
	 **/
	public class OperationLogModulePM extends BasePM
	{
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		
		[Bindable]
		public var page:Page = new Page();
		
		/**搜索条件**/
		[Bindable]
		public var cond:Object = new Object();
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		[Init]
		public function initComplete():void
		{
			searchOperationLogs();
		}
		
		/**
		 * Search card type
		 */
		public function searchOperationLogs():void
		{
			cond["currentUserId"] = UserInfoInit.userInfo["id"];
			
			var msg:LogMessage = new LogMessage();
			msg.type = "searchOperLog";
			msg.args["page"] = page;
			msg.args["cond"] = cond;
			sendMessage(msg);
		}
		
		/**
		 * Batch delete card types
		 * 
		 */		
		public function delLogs(p_delIds:Array):void
		{
			var msg:LogMessage = new LogMessage();
			msg.type = "delOperationLogs";
			msg.args["ids"] = p_delIds;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="searchOperLogResult")]
		public function getLogsHandler(p_msg:LogMessage):void
		{
			var _page:Page = p_msg.result as Page;
			if(_page.result){
				var arrCollection:ArrayCollection = _page.result;
				var nCollection:ArrayCollection = new ArrayCollection();
				for(var i:int = 0;i < arrCollection.length;i++){
					var nObj:Object = {};
					var obj:Object = arrCollection.getItemAt(i);
					ObjectUtils.copyPropertiesToObject(obj.o, nObj);
					ObjectUtils.copyPropertiesToObject(obj.m, nObj, ["id"]);
					nCollection.addItem(nObj);
				}
				_page.result = nCollection;
			}
			page = _page;
		}
		
		/**
		 * 
		 */		
		[MessageHandler(selector="delOperationLogsSuccess")]
		public function delLogSuccess(p_msg:LogMessage):void
		{
			if(p_msg.result)
				searchOperationLogs();
		}
	}
}