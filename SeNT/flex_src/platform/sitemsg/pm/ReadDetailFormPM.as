// ActionScript file
package platform.sitemsg.pm
{
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.sitemsg.message.SiteMsg;
	import platform.sitemsg.vo.NoticeSitemsgVO;
	
	public class ReadDetailFormPM extends BasePM
	{
		[Bindable]
		public var vo:NoticeSitemsgVO = new NoticeSitemsgVO();
		
		[Bindable]
		public var details:ArrayCollection;
		
		public function loadDetail():void{
			var msg:SiteMsg = new SiteMsg();
			msg.type="loadDetail";
			msg.args["siteMsgId"] = vo.id;
			sendMessage(msg);
		}
		
		[MessageHandler(selector="loadDetailResult")]
		public function loadDetailHandler(p_msg:SiteMsg):void{
			details = p_msg.result as ArrayCollection;
		}
		
	}
}