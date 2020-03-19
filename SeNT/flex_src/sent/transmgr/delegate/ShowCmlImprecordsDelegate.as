package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.ShowCmlImprecordsMsg;

	public class ShowCmlImprecordsDelegate extends DelegateBase
	{
//		/**
//		 * 清分冠字号码的导入信息
//		 */		
//		[Command(selector="getCmlImprecordsInfoPage")]
//		public function getCmlImprecordsPage(msg:ShowCmlImprecordsMsg):AsyncToken
//		{
//			trace("ShowCmlImprecordsDelegate.getCmlImprecordsPage");
//			return call("getCmlImprecordsInfoPage",msg.args["page"],msg.args["vo"],msg.args["startTime"],msg.args["endTime"]);
//			
//		}
//		
//		/**
//		 * 
//		 */
//		[CommandResult(selector="getCmlImprecordsInfoPage")]
//		public function getCmlImprecoredsPageResultHandler(p_result:ResultEvent, trigger:ShowCmlImprecordsMsg):void
//		{
//			trace("ShowCmlImprecordsDelegate.getCmlImprecoredsPageResultHandler");
//			var msg:ShowCmlImprecordsMsg = new ShowCmlImprecordsMsg();
//			msg.type = "getCmlImprecordsInfoPageResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		
//		/**
//		 * 根据上传文件名称查找对应的清分冠字号码信息
//		 */
//		[Command(selector="impfindCmlSentInfo")]
//		public function findCmlSentInfo(msg:ShowCmlImprecordsMsg):AsyncToken
//		{
//			trace("ShowCmlImprecordsDelegate.findCmlSentInfo");
//			return call("findCmlSentInfo", msg.args["page"], msg.args["vo"]);
//		}
//		
//		[CommandResult(selector="impfindCmlSentInfo")]
//		public function findCmlSentInfoHandler(p_result:ResultEvent,trigger:ShowCmlImprecordsMsg):void
//		{
//			trace("ShowCmlImprecordsDelegate.findCmlSentInfoHandler");
//			var msg:ShowCmlImprecordsMsg = new ShowCmlImprecordsMsg();
//			msg.type = "impfindCmlSentInfoResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		
	}
}