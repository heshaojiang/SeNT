package sent.transmgr.pm
{
	import cml.task.vo.CmlTaskInfosVO;
	
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.common.util.DateUtils;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.vo.security.UserVo;
	
	import sent.transmgr.message.CmlSentInfoMsg;
	import sent.transmgr.message.CmlTaskInfoMsg;
	import sent.transmgr.vo.CmlTaskInfoDetailVO;
	import sent.transmgr.vo.CmlTaskInfoVO;

	public class CmlTaskInfoFormPM  extends BasePM
	{
		[Bindable]
		public var userName:String;
		[Bindable]
		public var org:String;
		[Bindable]
		public var usersList:ArrayCollection;
		/**
		 * 页面对象
		 * 清分任务对象
		 * */
		[Bindable]
		public var cmlTaskInfoVO:CmlTaskInfoDetailVO = new CmlTaskInfoDetailVO();
		
		/**原来的VO**/
		public var formerVO:CmlTaskInfoDetailVO;
		
		public function set vo(p_vo:CmlTaskInfoDetailVO):void
		{
			formerVO = p_vo;
			cmlTaskInfoVO = ObjectUtil.copy(p_vo) as CmlTaskInfoDetailVO;
		}
		public function loadUsersInfo():void{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type="loadUsersInfo";
			sendMessage(msg);
		}
		
		[MessageHandler(selector="loadUsersInfoResult")]
		public function loadRecipientHandler(p_msg:CmlTaskInfoMsg):void{
			usersList = p_msg.result as ArrayCollection;
		}
		
		/**
		 * 重置表单
		 * 
		 */		
		
		public function reset():void
		{
			cmlTaskInfoVO = ObjectUtil.copy(formerVO) as CmlTaskInfoDetailVO;
		}
		/**
		 * 取消
		 * 
		 */	
		
		public function cancel():void
		{
			formerVO.dgSelected = false;
		}
		/**
		 * 保存菜单
		 * 
		 */		
		
		public function save(_cml:CmlTaskInfoVO):void
		{
			//invoke save function
			var msg:CmlTaskInfoMsg= new CmlTaskInfoMsg();
				//修改清分任务
			msg.type = "editCmlTaskInfo";
			msg.operate = OperationConsts.EDIT;
		
			msg.args["data"] = _cml;
			msg.logFlag = true;
			msg.menuId = this.menuId;
			sendMessage(msg);
		}
		
	}
}