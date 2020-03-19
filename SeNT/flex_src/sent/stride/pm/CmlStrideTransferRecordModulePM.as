package sent.stride.pm
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import sent.stride.message.CmlStrideTransferRecordMsg;

	
	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class CmlStrideTransferRecordModulePM extends BasePM
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
			loadCmlStrideTransferRecordPage();
			getFormInitDatas();
		}
		
		/**
		 * 批量获取下拉数据源
		 * */
		public function getFormInitDatas():void
		{
			var msg:CmlStrideTransferRecordMsg = new CmlStrideTransferRecordMsg();
			msg.type = "getFormInitDatas";
			sendMessage(msg);
		}
		
		/**
		 * 保存
		 * */
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:CmlStrideTransferRecordMsg):void
		{
			loadCmlStrideTransferRecordPage();
		}
		
		/**
		 * 删除
		 * */
		public function delCmlStrideTransferRecord(p_delItems:Array):void
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
					var msg:CmlStrideTransferRecordMsg = new CmlStrideTransferRecordMsg();
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
		public function delBackHandler(p_msg:CmlStrideTransferRecordMsg):void
		{
			AlertHandler.alert(LocaleConsts.DELETE_SUCCESS);
			
			loadCmlStrideTransferRecordPage();
		}
		
		/**
		 * 加载数据
		 * */
		public function loadCmlStrideTransferRecordPage():void
		{
			var msg:CmlStrideTransferRecordMsg = new CmlStrideTransferRecordMsg();
			msg.type = "getCmlStrideTransferRecordPage";
			msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="getCmlStrideTransferRecordPageResult")]
		public function getPageHandler(p_msg:CmlStrideTransferRecordMsg):void
		{
			page = p_msg.result as Page;
		}
		
		/**
		 * 批量获取下拉数据源的回调函数
		 */		
		[MessageHandler(selector="getFormInitDatasResult")]
		public function getFormInitDatasBackHandler(p_msg:CmlStrideTransferRecordMsg):void
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