package sent.stride.pm
{
	/*========================================================*/
	/*   Import                                               */
	/*========================================================*/
	
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.layer.BasePM;
	import sent.stride.message.CmlStrideTransferRecordMsg;
	import sent.stride.vo.CmlStrideTransferRecordVO;
	
	public class CmlStrideTransferRecordFormPM  extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		
		/**页面VO**/
		[Bindable]
		public var cmlStrideTransferRecord:CmlStrideTransferRecordVO = new CmlStrideTransferRecordVO();
		
		/**原来的VO**/
		public var formerVO:CmlStrideTransferRecordVO;
		
		public function set vo(p_vo:CmlStrideTransferRecordVO):void
		{
			formerVO = p_vo;
			cmlStrideTransferRecord = ObjectUtil.copy(p_vo) as CmlStrideTransferRecordVO;
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
			cmlStrideTransferRecord = ObjectUtil.copy(formerVO) as CmlStrideTransferRecordVO;
		}
		
		/**
		 * 保存
		 * 
		 */		
		public function save(p_operateType:String):void
		{
			//invoke save function
			var msg:CmlStrideTransferRecordMsg = new CmlStrideTransferRecordMsg();
			msg.type = "save";
			msg.args["data"] = cmlStrideTransferRecord;
			//记录日志
			msg.logFlag = true;
			msg.menuId = this.menuId;
			msg.operate = p_operateType;
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