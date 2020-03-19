package sent.checkin.pm
{
	import platform.layer.BasePM;
	
	public class PenaltyInfoPrintFormPM extends BasePM
	{
		public function PenaltyInfoPrintFormPM()
		{
			super();
		}
		
		//根据冠字号记录，查询终端设备
		public function queryPenaltyTerm(termId:String):void{
			
			var msg:PenaltyInfoPrintMsg = new PenaltyInfoPrintMsg();
			msg.type = "PenaltyInfoPrintFormPM_queryPenaltyTerm";
			msg.args["termId"] = termId;
			//记录日志
			/*msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = vo.id ? OperationConsts.EDIT :
				OperationConsts.ADD;*/
			sendMessage(msg);
		}
	}
}