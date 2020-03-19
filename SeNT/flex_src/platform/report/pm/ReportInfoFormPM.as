package platform.report.pm
{
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.report.message.ReportInfoMsg;
	import platform.report.vo.ReportInfoVO;
	
	public class ReportInfoFormPM extends BasePM
	{
		[Bindable]
		public var roleList:ArrayCollection;
		
		private var _vo:ReportInfoVO;
		
		public function set vo(p_vo:ReportInfoVO):void
		{
			_vo = p_vo
		}
		[Bindable]
		public function get vo():ReportInfoVO
		{
			return _vo;
		}
		
		public function loadRoles():void{
			var msg:ReportInfoMsg = new ReportInfoMsg();
			msg.type="loadRoles";
			sendMessage(msg);
		}
		[MessageHandler(selector="loadRolesResult")]
		public function loadRolesHandler(p_msg:ReportInfoMsg):void{
			roleList = p_msg.result as ArrayCollection;
		}
		
		
		public function save():void{
			var msg:ReportInfoMsg = new ReportInfoMsg();
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
		
		public function cancel():void
		{
			_vo.dgSelected = false;
		}
	}
}