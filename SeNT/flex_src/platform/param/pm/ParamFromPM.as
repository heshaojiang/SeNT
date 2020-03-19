package platform.param.pm
{
	/*========================================================*/
	/*   Import                                               */
	/*========================================================*/
	
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.constants.LocaleConsts;
	import platform.layer.BasePM;
	import platform.param.message.ParamMsg;
	import platform.vo.param.ParamVo;

	public class ParamFromPM extends BasePM
	{
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		
		/**页面菜单vo**/
		[Bindable]
		public var param:ParamVo = new ParamVo();
		
		private var formerVo:ParamVo;
		
		public function set vo(p_vo:ParamVo):void
		{
			formerVo = p_vo;
			param = ObjectUtil.copy(p_vo) as ParamVo;
		}
		
		/**
		 * 重置表单
		 */		
		public function reset():void
		{
			param = ObjectUtil.copy(formerVo) as ParamVo;
		}
		
		public function cancel():void
		{
			formerVo.dgSelected = false;
		}
		
		/**
		 * 保存菜单
		 */		
		public function save(p_operateType:String):void
		{			
			var msg:ParamMsg = new ParamMsg();
			msg.type = "save";	// java: "saveParam", result: "saveResult"
			msg.args["data"] = param;
			//记录日志
			msg.logFlag = true;
			msg.menuId = this.menuId;
			msg.operate = p_operateType;
			sendMessage(msg);
		}
		
		/**
		 * 保存后回调函数
		 */		
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:ParamMsg):void
		{
			var result:Object = p_msg.result;
			//已存在
			if(result == "-1")
			{
				AlertHandler.alert(LocaleConsts.NAME_ALREADY_EXISTED);
			}
		}
	}
}