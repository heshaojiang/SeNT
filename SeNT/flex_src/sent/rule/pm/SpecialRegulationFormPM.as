package sent.rule.pm
{
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.util.ObjectUtils;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	
	import sent.rule.message.SpecialRegulationModuleMsg;
	import sent.rule.vo.SpecialRegulationVO;

	public class SpecialRegulationFormPM extends BasePM
	{
		/**页面菜单vo**/
		[Bindable]
		public var specialRegulationVO:SpecialRegulationVO = new SpecialRegulationVO();
		
		/**原来的VO**/
		public var formerVO:SpecialRegulationVO;
		
		public function set vo(p_vo:SpecialRegulationVO):void
		{
			formerVO = p_vo;
			specialRegulationVO = ObjectUtil.copy(p_vo) as SpecialRegulationVO;
		}
		
		
		/**
		 * 重置表单
		 * 
		 */		
		
		public function reset():void
		{
			specialRegulationVO = ObjectUtil.copy(formerVO) as SpecialRegulationVO;
		}
		
		/**
		 * 保存菜单
		 * 
		 */		
		
		public function save():void
		{
			//invoke save function
			var msg:SpecialRegulationModuleMsg = new SpecialRegulationModuleMsg();
		     //新增特殊规则
			if(!specialRegulationVO.id){
				msg.type = "newSpecialRegulationInfo";
				msg.operate = OperationConsts.ADD;
				var dateStr:String=DateFormatter.format(new Date());
				dateStr=dateStr.substr(0,4)+dateStr.substr(5,2)+dateStr.substr(8,2)+dateStr.substr(11,2)+dateStr.substr(14,2)+dateStr.substr(17,2);
				specialRegulationVO.createDate=dateStr;
			}else{
				//修改特殊规则
				msg.type = "updateSpecialRegulation";
				msg.operate = OperationConsts.EDIT;
			}
			msg.args["data"] = specialRegulationVO;
		
			
			msg.logFlag = true;
			msg.menuId = this.menuId;
			sendMessage(msg);
		}
		
	
		/**
		 * 取消
		 * 
		 */	
		
		public function cancel():void
		{
			formerVO.dgSelected = false;
		}
	}
}