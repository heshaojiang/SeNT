package platform.report.pm
{
	import mx.utils.ObjectUtil;
	
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.report.message.ReportConditionMsg;
	import platform.report.vo.ReportConditionVO;
	
	public class ReportConditionFormPM extends BasePM
	{
		private var _vo:ReportConditionVO;
		private var oldVo:ReportConditionVO;
		
		public function set vo(p_vo:ReportConditionVO):void
		{
			//oldVo = p_vo;
			_vo = p_vo
			//ObjectUtil.copy(p_vo) as ReportConditionVO;
		}
		[Bindable]
		public function get vo():ReportConditionVO
		{
			return _vo;
		}
		
		public function save():void{
			var msg:ReportConditionMsg = new ReportConditionMsg();
			msg.type="save";
			msg.args["vo"] = _vo;
			
			msg.logFlag=true;
			msg.menuId = this.menuId;
			if(_vo.id==null || _vo.id=="")
				msg.operate = OperationConsts.ADD;
			else
				msg.operate = OperationConsts.EDIT;
			sendMessage(msg);
		}
		
		/**
		 * 重置表单
		 * 
		 */		
		public function reset():void
		{
			_vo = ObjectUtil.copy(oldVo) as ReportConditionVO;
		}
		
		public function cancel():void
		{
			_vo.dgSelected = false;
		}
	}
}