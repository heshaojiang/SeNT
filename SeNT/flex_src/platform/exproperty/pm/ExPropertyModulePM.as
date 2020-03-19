package platform.exproperty.pm
{
	import mx.utils.ObjectUtil;
	
	import platform.common.vo.Page;
	import platform.constants.OperationConsts;
	import platform.exproperty.message.ExPropertyMsg;
	import platform.layer.BasePM;
	import platform.vo.exproperty.ExtendPropertyVO;
	
	public class ExPropertyModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		public function loadPage(table:String):void{
			var p_page:Page = ObjectUtil.copy(page) as Page;
			p_page.result = null;
			
			var msg:ExPropertyMsg = new ExPropertyMsg();
			msg.type="getPageData";
			msg.args["page"] = p_page;
			msg.args["table"] = table;
			sendMessage(msg);
		}
		[MessageHandler(selector="getPageDataResult")]
		public function loadPageResult(p_msg:ExPropertyMsg):void{
			if(p_msg.result)
				page = p_msg.result as Page;
		}
		
		
	}
}