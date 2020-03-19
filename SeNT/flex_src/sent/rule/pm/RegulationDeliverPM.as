package sent.rule.pm
{
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.rule.message.RegulationDeliverMsg;
	import sent.rule.vo.RegulationDeliverVO;
	
	public class RegulationDeliverPM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var regulationDeliver:RegulationDeliverVO = new RegulationDeliverVO();
		
		public function loadPage():void
		{
			var msg:RegulationDeliverMsg = new RegulationDeliverMsg();
			msg.type = "getRegulationDeliverPage";
			msg.args["page"] = page;
			msg.args["regulationDeliverVO"] = regulationDeliver;
			sendMessage(msg);
		}
		
		/**
		 *规则下发详情界面回调函数 
		 */
		[MessageHandler(selector="getRegulationDeliverPageResult")]
		public function getRegulationDeliverPageResult(p_msg:RegulationDeliverMsg):void
		{
			if(p_msg.result)
				page = p_msg.result as Page;
		}
		
	}
}