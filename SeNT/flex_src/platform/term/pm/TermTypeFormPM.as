package platform.term.pm
{
	/*========================================================*/
	/*   Import                                               */
	/*========================================================*/
	
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.constants.LocaleConsts;
	import platform.layer.BasePM;
	import platform.term.message.TermTypeMsg;
	import platform.vo.term.TermTypeVo;
	
	public class TermTypeFormPM  extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		/**页面菜单vo**/
		[Bindable]
		public var termType:TermTypeVo = new TermTypeVo();
		
		/**原来的VO**/
		public var formerVO:TermTypeVo;
		
		public function set vo(p_vo:TermTypeVo):void
		{
			formerVO = p_vo;
			termType = ObjectUtil.copy(p_vo) as TermTypeVo;
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
			termType = ObjectUtil.copy(formerVO) as TermTypeVo;
		}
		
		/**
		 * 保存菜单
		 * 
		 */		
		public function save(p_operateType:String):void
		{
			//invoke save function
			var msg:TermTypeMsg = new TermTypeMsg();
			msg.type = "save";
			msg.args["data"] = termType;
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
		public function saveBackHandler(p_msg:TermTypeMsg):void
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