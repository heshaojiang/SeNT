package platform.term.pm
{
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.term.message.TmlDataBackupMsg;

	
	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class TmlDataBackupModulePM extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		[Bindable]
		public var page:Page = new Page();
		
		[Binadble]
		public var condi:String = "";
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		[Init]
		public function init():void
		{
			loadTmlDataBackupPage();
		}
		
		/**save success handler**/
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:TmlDataBackupMsg):void
		{
			loadTmlDataBackupPage();
		}
		
		/**
		 * delete dataDir
		 * */
		public function delTermType(p_delItems:Array):void
		{
			if (p_delItems.length <= 0){
				AlertHandler.alert(LocaleConsts.NO_SELECTED_RECORD);
				//AlertHandler.error("必须选择至少一项!!!");
				return;
			}
			AlertHandler.confirm(closeHandler, null, LocaleConsts.CONFIRM_DELETE);
			//close handler
			function closeHandler(evt:CloseEvent):void
			{
				if (evt.detail == Alert.YES){
					var msg:TmlDataBackupMsg = new TmlDataBackupMsg();
					msg.type = "delete";
					msg.args["ids"] = DataGridUtil.getPropertys("id", p_delItems); 
					//记录日志
					msg.logFlag = true;
					msg.menuId = menuId;
					msg.operate = OperationConsts.DEL;
					sendMessage(msg);
				}
			}
		}
		
		/**
		 * 删除返回结果处理函数
		 */		
		[MessageHandler(selector="delResult")]
		public function delBackHandler(p_msg:TmlDataBackupMsg):void
		{
			AlertHandler.alert(LocaleConsts.DELETE_SUCCESS);
			
			loadTmlDataBackupPage();
		}
		
		/**
		 * search DataDir Paging
		 * */
		public function loadTmlDataBackupPage(p_type:String = null):void
		{
			var msg:TmlDataBackupMsg = new TmlDataBackupMsg();
			msg.type = "getTmlDataBackupPage";
			msg.args["page"] = page;
			msg.args["path"] = condi;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getTmlDataBackupPageResult")]
		public function getPageHandler(p_msg:TmlDataBackupMsg):void
		{
			page = p_msg.result as Page;
		}
	}
}