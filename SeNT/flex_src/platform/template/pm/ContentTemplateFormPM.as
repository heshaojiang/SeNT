package platform.template.pm
{
	import platform.layer.BasePM;
	import platform.template.message.ContentTemplateMsg;
	import platform.template.view.ContentTemplateModule;
	import platform.template.vo.ContentTemplateVO;
	
	public class ContentTemplateFormPM extends BasePM
	{
		[Bindable]
		public var vo:ContentTemplateVO = new ContentTemplateVO();
		
		public function save(operation:String):void{
			var msg:ContentTemplateMsg = new ContentTemplateMsg();
			msg.type="save";
			msg.args["vo"] = vo;
			
			msg.logFlag=true;
			msg.menuId = this.menuId;
			msg.operate = operation;
			sendMessage(msg);
		}
		
		public function cancel():void
		{
			vo.dgSelected = false;
		}
	}
}