package platform.datadir.pm
{
	/*========================================================*/
	/*   Import                                               */
	/*========================================================*/
	
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.constants.LocaleConsts;
	import platform.dataDict.DataDirMsg;
	import platform.layer.BasePM;
	import platform.vo.datadir.DataDirVo;
	
	public class DataDirFormPM  extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		/**页面菜单vo**/
		[Bindable]
		public var datadir:DataDirVo = new DataDirVo();
		
		private var formerVo:DataDirVo;
		
		public function set vo(p_vo:DataDirVo):void
		{
			formerVo = p_vo;
			datadir = ObjectUtil.copy(p_vo) as DataDirVo;
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
			datadir = ObjectUtil.copy(formerVo) as DataDirVo;
		}
		
		public function cancel():void
		{
			formerVo.dgSelected = false;
		}
		
		/**
		 * 保存菜单
		 * 
		 */		
		public function save(p_operateType:String):void
		{
			datadir.status="Y";
			var msg:DataDirMsg = new DataDirMsg();
			msg.type = "save";	// java: saveSysDatadir, result: saveResult
			msg.args["data"] = datadir;
			
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
		public function saveBackHandler(p_msg:DataDirMsg):void
		{
			var result:Object = p_msg.result;
			if(result == "-1")
			{
				AlertHandler.alert(LocaleConsts.NAME_ALREADY_EXISTED);
			}
		}
	}
}