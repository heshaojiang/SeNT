// ActionScript file
package platform.sitemsg.pm
{
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.layer.BasePM;
	import platform.sitemsg.message.SiteMsg;
	import platform.sitemsg.vo.NoticeSitemsgVO;
	
	public class WriteLetterFormPM extends BasePM
	{
		[Bindable]
		public var vo:NoticeSitemsgVO = new NoticeSitemsgVO();
		
		[Bindable]
		public var recipients:ArrayCollection;
		
		public function loadRecipient():void{
			var msg:SiteMsg = new SiteMsg();
			msg.type="loadRecipient";
			sendMessage(msg);
		}
		
		[MessageHandler(selector="loadRecipientResult")]
		public function loadRecipientHandler(p_msg:SiteMsg):void{
			recipients = p_msg.result as ArrayCollection;
		}
		
		public function saveLetter(buttonCode:String):void{
			var msg:SiteMsg = new SiteMsg();
			msg.type="saveLetter";
			msg.args["vo"] = vo;
			
			msg.logFlag=true;
			msg.menuId = this.menuId;
			msg.operate = buttonCode;
			sendMessage(msg);
		}
		
	}
}