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
	import platform.term.message.NoderVersionInfoMsg;
	import platform.term.vo.NoderVersionInfoVo;
	
	import sent.common.utils.TestUtils;
	
	public class NoderVersionInfoFormPM  extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		/**页面菜单vo**/
		[Bindable]
		public var noderVersionInfo:NoderVersionInfoVo = new NoderVersionInfoVo();
		
		/**原来的VO**/
		public var formerVO:NoderVersionInfoVo;
		
		[Bindable]
		public var extendProperties:ArrayCollection;
		
		
		public function set vo(p_vo:NoderVersionInfoVo):void
		{
			formerVO = p_vo;
			noderVersionInfo = ObjectUtil.copy(p_vo) as NoderVersionInfoVo;
			/*if(p_vo)
				extendProperties = AppGlobal.getExtendProperties(p_vo);*/
		}
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		[Bindable]
		public var noderVersionInfoFormInitDatas:Object = new Object();
		
		[Init]
		public function init():void
		{
			getnoderVersionInfoFormInitDatas();
		}
		
		/**批量获取下拉数据源**/
		public function getnoderVersionInfoFormInitDatas():void
		{
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			msg.type = "getNoderVersionInfoFormInitDatas";
			sendMessage(msg);
		}
		
		/**
		 * 批量获取下拉数据源的回调函数
		 */		
		[MessageHandler(selector="getNoderVersionInfoFormInitDatasResult")]
		public function getnoderVersionInfoFormInitDatasBackHandler(p_msg:NoderVersionInfoMsg):void
		{
			var result:Object = p_msg.result;
			if(result != null){
				noderVersionInfoFormInitDatas = ObjectUtil.copy(p_msg.result) as Object;
			}
		}
		
		/**
		 * 重置表单
		 * 
		 */		
		public function reset():void
		{
			noderVersionInfo = ObjectUtil.copy(formerVO) as NoderVersionInfoVo;
//			ReflectUtil.setControllValue(form, termInfo);
		}
		
		/**
		 * 保存菜单
		 * 
		 */		
		public function save(p_operateType:String):void
		{

			/*if(!noderVersionInfo.areaId)
			{
				AlertHandler.exception("term.areaNotNull");
				return;
			}*/
//			if(!noderVersionInfo.orgId)
//			{
//				AlertHandler.exception("term.orgNotNull");
//				return;
//			}
			var msg:NoderVersionInfoMsg = new NoderVersionInfoMsg();
			noderVersionInfo.createUserId = UserInfoInit.userInfo["id"];
			msg.type = "save";
			msg.args["data"] = noderVersionInfo;
			msg.logFlag = true;
			msg.menuId = this.menuId;
			msg.operate = p_operateType;
			sendMessage(msg);
		}
		
		/**
		 * 保存后回调函数
		 */		
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:NoderVersionInfoMsg):void
		{
			//sent.common.utils.TestUtils.printObject(p_msg) ;
			AlertHandler.alert("操作成功！") ;
			getnoderVersionInfoFormInitDatas();
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