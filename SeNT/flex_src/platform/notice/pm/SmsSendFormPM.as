// ActionScript file
package platform.notice.pm
{
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.notice.message.NoticeInfoMsg;
	import platform.notice.vo.NoticeInfoVO;
	
	public class SmsSendFormPM extends BasePM
	{
		[Bindable]
		public var vo:NoticeInfoVO = new NoticeInfoVO();
		
		public function saveSms(operation:String):void{
			var msg:NoticeInfoMsg = new NoticeInfoMsg();
			msg.type="sendSms";
			msg.args["vo"] = vo;
			
			msg.logFlag=true;
			msg.menuId = this.menuId;
			msg.operate = operation;
			sendMessage(msg);
		}
		
	}
}