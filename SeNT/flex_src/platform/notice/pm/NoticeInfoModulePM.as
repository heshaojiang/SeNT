package platform.notice.pm
{
	import mx.utils.ObjectUtil;
	
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	import platform.notice.message.NoticeInfoMsg;

	public class NoticeInfoModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		public function loadPage(noticeType:String, noticeMethod:String, status:String, key:String, startTime:Date, endTime:Date):void{
			var msg:NoticeInfoMsg = new NoticeInfoMsg();
			msg.type = "getPageData";
			msg.args["page"] = ObjectUtil.copy(page) as Page;
			msg.args["noticeType"] = noticeType;
			msg.args["noticeMethod"] = noticeMethod;
			msg.args["status"] = status;
			msg.args["key"] = key;
			msg.args["startTime"]=startTime;
			msg.args["endTime"]=endTime;
			sendMessage(msg);
		}
		[MessageHandler(selector = "getPageDataResult")]
		public function loadPageResult(p_msg:NoticeInfoMsg):void{
			if(p_msg)
				page = p_msg.result as Page; 
		}
	}
}