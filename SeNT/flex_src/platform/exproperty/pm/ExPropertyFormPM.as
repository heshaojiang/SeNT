package platform.exproperty.pm
{
	import mx.utils.ObjectUtil;
	
	import platform.constants.OperationConsts;
	import platform.exproperty.message.ExPropertyMsg;
	import platform.layer.BasePM;
	import platform.vo.exproperty.ExtendPropertyVO;
	
	public class ExPropertyFormPM extends BasePM
	{
		
		[Bindable]
		public var formVo:ExtendPropertyVO = new ExtendPropertyVO();
		
		private var oldVo:ExtendPropertyVO = new ExtendPropertyVO();
		
		public function set vo(p_vo:ExtendPropertyVO):void
		{
			oldVo = p_vo;
			formVo = ObjectUtil.copy(p_vo) as ExtendPropertyVO;
		}
		
		
		/**
		 * 重置表单
		 * 
		 */		
		public function reset():void
		{
			formVo = ObjectUtil.copy(oldVo) as ExtendPropertyVO;
		}
		
		//取消
		public function cancel():void
		{
			oldVo.dgSelected = false;
		}
		
		public function save():void
		{
			var msg:ExPropertyMsg = new ExPropertyMsg();
			msg.type = "save";
			msg.args["vo"] = formVo;
			//记录日志
			msg.logFlag = true;
			msg.menuId = this.menuId;
			msg.operate = OperationConsts.EDIT;
			sendMessage(msg);
		}
	}
}