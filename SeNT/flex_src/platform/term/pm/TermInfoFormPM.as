package platform.term.pm
{
	/*========================================================*/
	/*   Import                                               */
	/*========================================================*/
	
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.global.AppGlobal;
	import platform.layer.BasePM;
	import platform.term.message.TermInfoMsg;
	import platform.vo.term.TermInfoVo;
	
	public class TermInfoFormPM  extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		/**页面菜单vo**/
		[Bindable]
		public var termInfo:TermInfoVo = new TermInfoVo();
		
		/**原来的VO**/
		public var formerVO:TermInfoVo;
		
		[Bindable]
		public var extendProperties:ArrayCollection;
		
		
		public function set vo(p_vo:TermInfoVo):void
		{
			formerVO = p_vo;
			termInfo = ObjectUtil.copy(p_vo) as TermInfoVo;
			if(p_vo)
				extendProperties = AppGlobal.getExtendProperties(p_vo);
		}
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		[Bindable]
		public var termInfoFormInitDatas:Object = new Object();
		
		[Init]
		public function init():void
		{
			getTermInfoFormInitDatas();
		}
		
		/**批量获取下拉数据源**/
		public function getTermInfoFormInitDatas():void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoFormInitDatas";
			sendMessage(msg);
		}
		
		/**
		 * 批量获取下拉数据源的回调函数
		 */		
		[MessageHandler(selector="getTermInfoFormInitDatasResult")]
		public function getTermInfoFormInitDatasBackHandler(p_msg:TermInfoMsg):void
		{
			var result:Object = p_msg.result;
			if(result != null){
				termInfoFormInitDatas = ObjectUtil.copy(p_msg.result) as Object;
			}
			
		}
		
		/**
		 * 重置表单
		 * 
		 */		
		public function reset():void
		{
			termInfo = ObjectUtil.copy(formerVO) as TermInfoVo;
//			ReflectUtil.setControllValue(form, termInfo);
		}
		
		/**
		 * 保存菜单
		 * 
		 */		
		public function save(p_operateType:String):void
		{
			if(!termInfo.model)
			{
				AlertHandler.exception("term.modelNotNull");
				return;
			}
			if(!termInfo.areaId)
			{
				AlertHandler.exception("term.areaNotNull");
				return;
			}
			if(!termInfo.orgId)
			{
				AlertHandler.exception("term.orgNotNull");
				return;
			}
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "save";
			msg.args["data"] = termInfo;
			msg.logFlag = true;
			msg.menuId = this.menuId;
			msg.operate = p_operateType;
			sendMessage(msg);
		}
		
		/**
		 * 保存后回调函数
		 */		
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:TermInfoMsg):void
		{
			
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