package sent.stride.pm
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	import mx.utils.ObjectUtil;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	
	import sent.stride.message.CmlStrideImportRecordsMsg;

	
	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class CmlStrideImportRecordsModulePM extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var condi:Object = new Object;
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		/**
		 * 初始化
		 * */
		[Init]
		public function init():void
		{
			//loadCmlStrideImportRecordsPage();
			//getFormInitDatas();
		}
		
		public function savedStrideDownload(arr:Array):void{
			var msg:CmlStrideImportRecordsMsg = new CmlStrideImportRecordsMsg();
			msg.type = "savedStrideDownload";
			msg.args["arr"] = arr;
			sendMessage(msg);
		}
		
		/**
		 * 批量获取下拉数据源
		 * */
		public function getFormInitDatas():void
		{
			var msg:CmlStrideImportRecordsMsg = new CmlStrideImportRecordsMsg();
			msg.type = "getFormInitDatas";
			sendMessage(msg);
		}
		
		/**
		 * 保存
		 * */
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:CmlStrideImportRecordsMsg):void
		{
			loadCmlStrideImportRecordsPage();
		}
		
		/**
		 * 删除
		 * */
		public function delCmlStrideImportRecords(p_delItems:Array):void
		{
			if (p_delItems.length <= 0){
				AlertHandler.alert(LocaleConsts.NO_SELECTED_RECORD);
				return;
			}
			AlertHandler.confirm(closeHandler, null, LocaleConsts.CONFIRM_DELETE);
			//close handler
			function closeHandler(evt:CloseEvent):void
			{
				if (evt.detail == Alert.YES){
					var msg:CmlStrideImportRecordsMsg = new CmlStrideImportRecordsMsg();
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
		public function delBackHandler(p_msg:CmlStrideImportRecordsMsg):void
		{
			AlertHandler.alert(LocaleConsts.DELETE_SUCCESS);
			
			loadCmlStrideImportRecordsPage();
		}
		
		/**
		 * 加载数据
		 * */
		public function loadCmlStrideImportRecordsPage():void
		{
			if(condi.startTime==null || condi.endTime==null)return;
			var msg:CmlStrideImportRecordsMsg = new CmlStrideImportRecordsMsg();
			msg.type = "getCmlStrideImportRecordsPage";
			msg.args["page"] = page;
			msg.args["condi"] = condi;
			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYYMMDDJJNNSS");
			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYYMMDDJJNNSS");
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getCmlStrideImportRecordsPageResult")]
		public function getPageHandler(p_msg:CmlStrideImportRecordsMsg):void
		{
			page = p_msg.result as Page;
		}
		
		/**
		 * 批量获取下拉数据源的回调函数
		 */		
		[MessageHandler(selector="getFormInitDatasResult")]
		public function getFormInitDatasBackHandler(p_msg:CmlStrideImportRecordsMsg):void
		{
			var result:Object = p_msg.result;
			//已存在
			var obj:Object = ObjectUtil.copy(result);
			if(result != null){
				
			}
			
			if(result == "-1"){
				AlertHandler.alert(LocaleConsts.NAME_ALREADY_EXISTED);
			}
		}		
	}
}