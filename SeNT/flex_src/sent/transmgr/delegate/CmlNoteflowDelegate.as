package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	import platform.layer.DelegateBase;
	import platform.common.manager.AlertHandler;
	import sent.transmgr.message.CmlNoteflowMsg;
	
	public class CmlNoteflowDelegate extends DelegateBase
	{
		
		/**
		 * 查询ATM加钞历史记录信息
		 */		
		[Command(selector="getCmlNoteflowPage")]
		public function getCmlNoteflowPage(msg:CmlNoteflowMsg):AsyncToken
		{
			trace("CmlNoteflowDelegate.getCmlNoteflowPage");
			return call("getCmlNoteflowPage",msg.args["page"],msg.args["startTime"],msg.args["endTime"],msg.args["vo"]);
			
		}
		
		[CommandResult(selector="getCmlNoteflowPage")]
		public function getCmlNoteflowPageResultHandler(p_result:ResultEvent, trigger:CmlNoteflowMsg):void
		{
			trace("CmlNoteflowDelegate.getCmlNoteflowPageResultHandler");
			var msg:CmlNoteflowMsg = new CmlNoteflowMsg();
			msg.type = "getCmlNoteflowPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 保存ATM加钞数据
		 * */
		[Command(selector="addCmlNoteflow")]
		public function addCmlNoteflow(msg:CmlNoteflowMsg):AsyncToken
		{
			return call("addCmlNoteflow",msg.args["cmlCmlNoteflow"],msg.args["cashNo1"],msg.args["cashNo2"],msg.args["cashNo3"],msg.args["cashNo4"]);
		}
		[CommandResult(selector="addCmlNoteflow")]
		public function addCmlNoteflowHandler(p_result:ResultEvent,trigger:CmlNoteflowMsg):void
		{
			var msg:CmlNoteflowMsg = new CmlNoteflowMsg();
			msg.type = "addCmlNoteflowSuccess";
			msg.result = p_result.result;
			if(p_result.result <= 0) {
				AlertHandler.alert("添加ATM加钞记录失败，未找到对应的钞箱号！");
			}
			else {
				AlertHandler.alert("添加ATM加钞记录成功！");
			}
			sendMessage(msg);
		}

	}
		
	
}