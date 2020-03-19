package platform.org.pm
{
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.constants.OperationConsts;
	import platform.global.AppGlobal;
	import platform.layer.BasePM;
	import platform.org.message.OrgMsg;
	import platform.vo.org.OrgVo;
	
	public class OrgFormPM extends BasePM
	{		
		private var formerVO:OrgVo;
		
		[Bindable]
		public var orgInfo:OrgVo = new OrgVo();
		
		[Bindable]
		public var extendProperties:ArrayCollection;
		
		public function set vo(p_vo:OrgVo):void
		{
			formerVO = p_vo;
			orgInfo = ObjectUtil.copy(p_vo) as OrgVo;
			if(p_vo)
				extendProperties = AppGlobal.getExtendProperties(p_vo);
		}
		
		/**
		 * 
		 * @param p_type
		 * 
		 */		
		public function update(p_type:String):void
		{
			/*if(!orgInfo.areaId){
				AlertHandler.exception("org.areaNotNull");
				return;
			}*/
			var msg:OrgMsg = new OrgMsg();
			msg.type = p_type;
			msg.args["vo"] = orgInfo;
			//记录日志
			msg.logFlag = true;
			msg.menuId = this.menuId;
			if(p_type == "newOrg")
				msg.operate = OperationConsts.ADD;
			else if(p_type == "update")
				msg.operate = OperationConsts.EDIT;
			sendMessage(msg);
		}
		
		/**
		 * get max order
		 * 
		 */		
		public function getMaxOrder():void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "getMaxOrderValue";
			msg.args["parentId"] = orgInfo.parentId;
			sendMessage(msg);
		}
		[MessageHandler(selector="getMaxOrderValueResult")]
		public function getMaxOrderValueHandler(p_msg:OrgMsg):void
		{
			if(p_msg.result != null){
				orgInfo.order = int(p_msg.result);
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
			orgInfo = ObjectUtil.copy(formerVO) as OrgVo;
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