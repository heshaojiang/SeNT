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
	import platform.term.message.NoderInfoMsg;
	import platform.term.vo.NoderInfoVo;
	import sent.common.utils.StringUtils;
	
	public class NoderInfoFormPM  extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		/**页面菜单vo**/
		[Bindable]
		public var noderInfo:NoderInfoVo = new NoderInfoVo();
		
		/**原来的VO**/
		public var formerVO:NoderInfoVo;
		
		[Bindable]
		public var extendProperties:ArrayCollection;
		
		public var uploadStarttime:String;
		
		public var uploadEndtime:String;
		
		public var bandwidth:String;
		
		
		public function set vo(p_vo:NoderInfoVo):void
		{
			formerVO = p_vo;
			noderInfo = ObjectUtil.copy(p_vo) as NoderInfoVo;
			/*if(p_vo)
				extendProperties = AppGlobal.getExtendProperties(p_vo);*/
		}
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		[Bindable]
		public var noderInfoFormInitDatas:Object = new Object();
		
		[Init]
		public function init():void
		{
			getNoderInfoFormInitDatas();
		}
		
		/**批量获取下拉数据源**/
		public function getNoderInfoFormInitDatas():void
		{
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "getNoderInfoFormInitDatas";
			sendMessage(msg);
		}
		
		/**
		 * 批量获取下拉数据源的回调函数
		 */		
		[MessageHandler(selector="getNoderInfoFormInitDatasResult")]
		public function getNoderInfoFormInitDatasBackHandler(p_msg:NoderInfoMsg):void
		{
			var result:Object = p_msg.result;
			if(result != null){
				noderInfoFormInitDatas = ObjectUtil.copy(p_msg.result) as Object;
			}
			
		}
		
		/**
		 * 重置表单
		 * 
		 */		
		public function reset():void
		{
			noderInfo = ObjectUtil.copy(formerVO) as NoderInfoVo;
//			ReflectUtil.setControllValue(form, termInfo);
		}
		
		/**
		 * 保存菜单
		 * 
		 */		
		public function save(p_operateType:String):void
		{

			/*if(!noderInfo.areaId)
			{
				AlertHandler.exception("term.areaNotNull");
				return;
			}*/
//			if(!noderInfo.orgId)
//			{
//				AlertHandler.exception("term.orgNotNull");
//				return;
//			}
			var msg:NoderInfoMsg = new NoderInfoMsg();
			msg.type = "save";
			var params:String = "uploadtime:"+uploadStarttime+"-"+uploadEndtime+",";
			if(StringUtils.isNotBlank(bandwidth)){
				params += "bandwidth:"+bandwidth;
			}
			noderInfo.parameter = params;
			msg.args["data"] = noderInfo;
			msg.logFlag = true;
			msg.menuId = this.menuId;
			msg.operate = p_operateType;
			sendMessage(msg);
		}
		
		/**
		 * 保存后回调函数
		 */		
		[MessageHandler(selector="saveResult")]
		public function saveBackHandler(p_msg:NoderInfoMsg):void
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