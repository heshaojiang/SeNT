package platform.cashbox.pm
{
	import mx.utils.ObjectUtil;
	
	import platform.cashbox.message.BoxInfoMsg;
	import platform.cashbox.vo.BoxInfoVO;
	import platform.common.manager.AlertHandler;
	import platform.constants.LocaleConsts;
	import platform.layer.BasePM;

	public class BoxInfoFormPM extends BasePM
	{
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		/**页面菜单vo**/
		
		[Bindable]
		public var boxInfoVO:BoxInfoVO = new BoxInfoVO();
		
		[Bindable]
		public var boxInfoFormInitDatas:Object = new Object();
		
		public var temp_boxNum : String ;
		public var temp_orgid : String;
		public var temp_status : String;
		public var temp_atmModel:String;
		public var temp_atmBoxtype:String;
		public var temp_boxType:String;
		
		/**原来的VO**/
		public var formerVO:BoxInfoVO;
		
		public function set vo(p_vo:BoxInfoVO):void
		{
			formerVO = p_vo;
			boxInfoVO = ObjectUtil.copy(p_vo) as BoxInfoVO;
			temp_boxNum = boxInfoVO.boxNum;
			temp_orgid = boxInfoVO.orgid;
			temp_boxType = boxInfoVO.boxType;
			temp_status = boxInfoVO.boxStatus;	
			temp_atmModel = boxInfoVO.atmModel;
			temp_atmBoxtype = boxInfoVO.atmBoxTypes;
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
			boxInfoVO = ObjectUtil.copy(formerVO) as BoxInfoVO;
		}
		
		/**
		 * 保存菜单
		 * 
		 */		
		public function save(p_operateType:String):void
		{
			//invoke save function
			var msg:BoxInfoMsg = new BoxInfoMsg();
			if(boxInfoVO.boxNum != temp_boxNum){		//若修改了钞箱号，则msg参数值为1，表示钞箱号有变化，反之则msg参数change的值为0
				msg.type = "saveBoxInfo";
				msg.args["data"] = boxInfoVO;
				msg.args["change"]=true;
				//记录日志
				msg.logFlag = true;
				msg.menuId = this.menuId;
				msg.operate = p_operateType;
				sendMessage(msg);
			}else{
				msg.type = "saveBoxInfo";
				msg.args["data"] = boxInfoVO;
				msg.args["change"]=false;
				//记录日志
				msg.logFlag = true;
				msg.menuId = this.menuId;
				msg.operate = p_operateType;
				sendMessage(msg);
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