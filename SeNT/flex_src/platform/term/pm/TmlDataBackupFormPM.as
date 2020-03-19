package platform.term.pm
{
	/*========================================================*/
	/*   Import                                               */
	/*========================================================*/
	
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.constants.LocaleConsts;
	import platform.layer.BasePM;
	import platform.term.constants.TermLocalKeyConsts;
	import platform.term.message.TmlDataBackupMsg;
	import platform.term.vo.TmlDataBackupVo;
	
	public class TmlDataBackupFormPM  extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		/**页面菜单vo**/
		[Bindable]
		public var tmldatabackup:TmlDataBackupVo = new TmlDataBackupVo();
		
		/**原来的VO**/
		public var formerVO:TmlDataBackupVo;
		
		public function set vo(p_vo:TmlDataBackupVo):void
		{
			formerVO = p_vo;
			tmldatabackup = ObjectUtil.copy(p_vo) as TmlDataBackupVo;
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
			tmldatabackup = ObjectUtil.copy(formerVO) as TmlDataBackupVo;
		}
		
		/**
		 * 保存菜单
		 * 
		 */		
		public function save(p_operateType:String):void
		{
			//invoke save function
			var msg:TmlDataBackupMsg = new TmlDataBackupMsg();
			msg.type = "save";
			msg.args["data"] = tmldatabackup;
			//msg.args["data"]["formType"] = TermLocalKeyConsts.UPDATE_TERMINFO_FORM;
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
		public function saveBackHandler(p_msg:TmlDataBackupMsg):void
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