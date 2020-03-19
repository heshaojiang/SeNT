package sent.stride.pm
{
	/*========================================================*/
	/*   Import                                               */
	/*========================================================*/
	
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.layer.BasePM;
	import sent.stride.message.CmlUpreportLogMsg;
	import sent.stride.vo.CmlUpreportLogVO;
	
	public class CmlUpreportLogFormPM  extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		
		/**页面VO**/
		[Bindable]
		public var cmlUpreportLog:CmlUpreportLogVO = new CmlUpreportLogVO();
		
		/**原来的VO**/
		public var formerVO:CmlUpreportLogVO;
		
		public function set vo(p_vo:CmlUpreportLogVO):void
		{
			formerVO = p_vo;
			cmlUpreportLog = ObjectUtil.copy(p_vo) as CmlUpreportLogVO;
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
			cmlUpreportLog = ObjectUtil.copy(formerVO) as CmlUpreportLogVO;
		}
		
		/**
		 * 保存
		 * 
		 */		
		public function save(p_operateType:String):void
		{
			//invoke save function
			var msg:CmlUpreportLogMsg = new CmlUpreportLogMsg();
			msg.type = "save";
			msg.args["data"] = cmlUpreportLog;
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