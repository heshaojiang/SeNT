package platform.area.pm
{
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.area.message.AreaMsg;
	import platform.constants.OperationConsts;
	import platform.global.AppGlobal;
	import platform.layer.BasePM;
	import platform.layer.PollingMessage;
	import platform.vo.area.AreaVo;
	
	public class AreaFormPM extends BasePM
	{		
		private var formerVO:AreaVo;
		
		[Bindable]
		public var areaInfo:AreaVo = new AreaVo();
		
		[Bindable]
		public var extendProperties:ArrayCollection;
		
		public function set vo(p_vo:AreaVo):void
		{
			formerVO = p_vo;
			areaInfo = ObjectUtil.copy(p_vo) as AreaVo;
			if(p_vo)
				extendProperties = AppGlobal.getExtendProperties(p_vo);
		}		
		
		public function save():void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.args["vo"] = areaInfo;
			if(!areaInfo.id){
				msg.type = "newArea";
				msg.operate = OperationConsts.ADD;
			}else{
				msg.type = "updateArea";
				msg.operate = OperationConsts.EDIT;
			}
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;				
			sendMessage(msg);
		}
		
		/**
		 * get max order
		 * 
		 */		
		public function getMaxOrder():void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "getMaxOrderValue";
			msg.args["parentId"] = areaInfo.parentId;
			sendMessage(msg);
		}
		[MessageHandler(selector="getMaxOrderValueResult")]
		public function getMaxOrderValueHandler(p_msg:AreaMsg):void
		{
			if(p_msg.result != null){
				areaInfo.order = int(p_msg.result);
//				order.value = event.result as Number;
				formerVO.order = int(p_msg.result);
			}
		}
		
		/**
		 * reset form
		 * 
		 */		
		public function reset():void
		{
			areaInfo = ObjectUtil.copy(formerVO) as AreaVo;
		}
		
		/**
		 * cancel operation
		 * 
		 */		
		public function cancel():void
		{
			formerVO.dgSelected = false;
		}
	}
}