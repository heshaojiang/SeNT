package sent.stride.pm
{
	/*========================================================*/
	/*   Import                                               */
	/*========================================================*/
	
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.layer.BasePM;
	
	import sent.stride.message.CmlStrideImportRecordsMsg;
	import sent.stride.vo.CmlStrideImportRecordsVO;
	
	public class CmlStrideImportRecordsFormPM  extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		
		/**页面VO**/
		[Bindable]
		public var cmlStrideImportRecords:CmlStrideImportRecordsVO = new CmlStrideImportRecordsVO();
		
		/**原来的VO**/
		public var formerVO:CmlStrideImportRecordsVO;
		
		public function set vo(p_vo:CmlStrideImportRecordsVO):void
		{
			formerVO = p_vo;
			cmlStrideImportRecords = ObjectUtil.copy(p_vo) as CmlStrideImportRecordsVO;
		}
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
				
		/**
		 * 重置
		 * 
		 */		
		public function reset():void
		{
			cmlStrideImportRecords = ObjectUtil.copy(formerVO) as CmlStrideImportRecordsVO;
		}
		
		/**
		 * 保存
		 * 
		 */		
		public function saveStrideExport(toBankCode:String,bagCode:String,rfid:String,bundleCodes:String):void
		{
			//invoke save function
			var msg:CmlStrideImportRecordsMsg = new CmlStrideImportRecordsMsg();
			msg.type = "saveStrideExport";
			msg.args["toBankCode"] = toBankCode;
			msg.args["bagCode"] = bagCode;
			msg.args["rfid"] = rfid;
			msg.args["bundleCodes"] = bundleCodes;
			sendMessage(msg);
		}
		
		public function getBagCode():void
		{
			//invoke save function
			var msg:CmlStrideImportRecordsMsg = new CmlStrideImportRecordsMsg();
			msg.type = "getFormInitDatas";
			msg.args["data"] = cmlStrideImportRecords;
			//记录日志
			sendMessage(msg);
		}
		
		
		/**
		 * 取消
		 * 
		 */		
		public function cancel():void
		{
			formerVO.dgSelected = false;
		}
	}
}