package platform.notice.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	import platform.notice.message.NoticeInfoMsg;
	import platform.notice.vo.NoticeInfoSmsVO;
	import platform.notice.vo.NoticeInfoVO;
	
	public class NoticeInfoDelegate extends DelegateBase
	{
		[Command(selector="getPageData")]
		public function getPageData(p_msg:NoticeInfoMsg):AsyncToken{
			var noticeType:String = p_msg.args["noticeType"];
			var noticeMethod:String = p_msg.args["noticeMethod"];
			var status:String = p_msg.args["status"];
			var key:String = p_msg.args["key"];
			var startTime:Date = p_msg.args["startTime"];
			var endTime:Date = p_msg.args["endTime"];
			return call("getPageData", p_msg.args["page"], noticeType, noticeMethod, status, key, startTime, endTime);
		}
		[CommandResult(selector="getPageData")]
		public function getPageDataHandler(p_result:ResultEvent, trigger:NoticeInfoMsg):void{
			trigger.type="getPageDataResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		[Command(selector="sendSms")]
		public function sendSms(p_msg:NoticeInfoMsg):AsyncToken{
			var vo:NoticeInfoVO = p_msg.args["vo"];
			return call("sendSms", vo.title, vo.content ,UserInfoInit.userInfo["userName"], vo.sendTime, vo.recipient, vo.note);
		}
		[CommandResult(selector="sendSms")]
		public function sendSmsHandler(p_result:ResultEvent, trigger:NoticeInfoMsg):void{
			trigger.type="sendSmsResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
	}
}