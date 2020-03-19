package platform.term.pm
{
	/*========================================================*/
	/*   Import                                               */
	/*========================================================*/
	
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.constants.LocaleConsts;
	import platform.layer.BasePM;
	import platform.term.message.TermBrandMsg;
	import platform.vo.term.TermBrandVo;
	
	public class TermBrandFormPM  extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		/**页面菜单vo**/
		[Bindable]
		public var termBrand:TermBrandVo = new TermBrandVo();
		
		/**原来的VO**/
		public var formerVO:TermBrandVo;
		
		public function set vo(p_vo:TermBrandVo):void
		{
			formerVO = p_vo;
			termBrand = ObjectUtil.copy(formerVO) as TermBrandVo;
		}
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		/**
		 * 重置表单
		 * 
		 */		
		public function reset():void
		{
			termBrand = ObjectUtil.copy(formerVO) as TermBrandVo;
//			ReflectUtil.setControllValue(form, termBrand);
		}
		
		/**
		 * 保存菜单
		 * 
		 */		
		public function save(p_operateType:String):void
		{
//			termBrand.status="Y";
			//invoke save function
			var msg:TermBrandMsg = new TermBrandMsg();
			msg.type = "save";
			msg.args["data"] = termBrand;
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
		public function saveBackHandler(p_msg:TermBrandMsg):void
		{
			var result:Object = p_msg.result;
			//已存在
			if(result == "-1"){
				AlertHandler.alert(LocaleConsts.NAME_ALREADY_EXISTED);
			}
		}
		
		
		/**
		 * cancel function
		 * 
		 */		
		public function cancel():void
		{
			formerVO.dgSelected = false;
		}
		
	}
}