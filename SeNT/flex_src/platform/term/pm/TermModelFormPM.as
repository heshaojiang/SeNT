package platform.term.pm
{
	/*========================================================*/
	/*   Import                                               */
	/*========================================================*/
	
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.constants.LocaleConsts;
	import platform.layer.BasePM;
	import platform.term.message.TermModelMsg;
	import platform.vo.term.TermModelVo;
	import platform.term.constants.TermLocalKeyConsts;
	import platform.constants.OperationConsts;
	
	public class TermModelFormPM  extends BasePM
	{		
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		/**页面菜单vo**/
		[Bindable]
		public var termModel:TermModelVo = new TermModelVo();
		
//		[Bindable]
//		public var brandList:ArrayCollection = new ArrayCollection();
		
		[Bindable]
		public var brandListIncludeEmpty:ArrayCollection = new ArrayCollection();
		
		[Bindable]
		public var typeListIncludeEmpty:ArrayCollection = new ArrayCollection();
		
		/**原来的VO**/
		public var formerVO:TermModelVo;
		
		public function set vo(p_vo:TermModelVo):void
		{
			trace("TermModelFormPM.set vo");
			formerVO = p_vo;
			termModel = ObjectUtil.copy(p_vo) as TermModelVo;
		}
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		
		
		/**
		 * 批量获取下拉数据源
		 **/
		public function initFormData():void
		{
			trace("TermModelFormPM.initFormData");
			var msg:TermModelMsg = new TermModelMsg();
			msg.type = "initFormData";
			sendMessage(msg);
		}
		
		/**
		 * 批量获取下拉数据源的回调函数
		 */		
		[MessageHandler(selector="initFormDataResult")]
		public function initFormDataResultHandler(p_msg:TermModelMsg):void
		{
			trace("TermModelFormPM.initFormDataResultHandler-initFormDataResult");
			var result:Object = p_msg.result;
			
			if(result != null)
			{
				this.brandListIncludeEmpty = result.brandList as ArrayCollection;
				this.typeListIncludeEmpty = result.typeList as ArrayCollection;
			}
			
			if(result == "-1")
			{
				AlertHandler.alert(LocaleConsts.NAME_ALREADY_EXISTED);
			}
		}		

		
		/**
		 * 重置表单
		 * 
		 */		
		public function reset():void
		{
			trace("TermModelFormPM.reset");
			termModel = ObjectUtil.copy(formerVO) as TermModelVo;
		}
		
		/**
		 * 保存菜单
		 */		
		public function save(parameter:Object):void
		{
			trace("TermModelFormPM.save");
			
			//invoke save function
			var msg:TermModelMsg = new TermModelMsg();
			msg.type = "saveTerminalModel";	// java: "updateTerminalModel" or "saveTerminalModel", result: "saveResult"
			msg.args["parameter"] = parameter;
			
			//记录日志
			msg.logFlag = true;
			msg.menuId  = this.menuId;
			msg.operate = (parameter.formType == TermLocalKeyConsts.ADD_TERMMODEL_FORM ?
				OperationConsts.ADD : OperationConsts.EDIT)  ;
			sendMessage(msg);
		}
		
		/**
		 * cancel function
		 * 
		 */		
		public function cancel():void
		{
			trace("TermModelFormPM.cancel");
			formerVO.dgSelected = false;
		}
	}
}