package sent.transmgr.delegate
{
	import flexlib.scheduling.samples.AlternatingHorizontalLinesViewer;
	
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.CmlInfoByHandMsg;

	public class CmlInfoByHandDelegate extends DelegateBase
	{
		/**远程服务**/
		[Inject(id="cmlInfoByHandService")]
		public var ro:RemoteObject;
		
		/**
		 * 初始化，注入到基类
		 * 
		 */
		[Init]
		public function init():void
		{
			super._ro = ro;
		}
		
		/** 
		 * 获取手工清分数据的请求
		 * 异步调用
		 */
		[Command(selector="getListCmlInfoByHand")]
		public function getListCmlInfoByHand(p_msg:CmlInfoByHandMsg):AsyncToken
		{
			return call("getListCmlInfoByHand", p_msg.args["page"], p_msg.args["conditions"]);
		}
		
		/** 
		 * 获取手工清分数据的响应
		 * 
		 **/
		[CommandResult(selector="getListCmlInfoByHand")] 
		public function getListCmlInfoByHandResultHandler(p_result:ResultEvent, 
																trigger:CmlInfoByHandMsg):void
		{
			var msg:CmlInfoByHandMsg = new CmlInfoByHandMsg();
			msg.type = "getListCmlInfoByHandResult";
			msg.result= p_result.result;
			sendMessage(msg);
			
		}
		
		/** 
		 * 保存请求
		 * 
		 **/
		[Command(selector="saveCmlInfoByHand")]
		public function saveCmlInfoByHand(p_msg:CmlInfoByHandMsg):AsyncToken
		{
			return call("saveCmlInfoByHand", p_msg.args["cmlInfoByHand"], p_msg.args["pathCode"],p_msg.args["formType"]);
		}
		
		/** 
		 * 保存的反应
		 * 
		 **/
		[CommandResult(selector="saveCmlInfoByHand")]
		public function saveCmlInfoByHandResultHandler(p_result:ResultEvent, trigger:CmlInfoByHandMsg):void
		{
			var msg:CmlInfoByHandMsg = new CmlInfoByHandMsg();
			msg.type = "saveCmlInfoByHandResult";
			msg.result= p_result.result;
			sendMessage(msg);
		}
		
		[CommandError(selector="saveCmlInfoByHand")]
		public function saveCmlInfoByHandErrorHandler(p_fault:FaultEvent, trigger:CmlInfoByHandMsg):void
		{
			var msg:CmlInfoByHandMsg = new CmlInfoByHandMsg();
			msg.type = "saveCmlInfoByHandError";
			msg.result = p_fault.message;
			sendMessage(msg);
		}
		
		/** 
		 * 删除请求
		 * 
		 **/
		[Command(selector="deleteCmlInfoByHand")]
		public function deleteCmlInfoByHand(p_msg:CmlInfoByHandMsg):AsyncToken
		{
			return call("deleteCmlInfoByHand", p_msg.args["selectedObj"]);
		}
		
		/** 
		 * 删除
		 * 
		 **/
		[CommandResult(selector="deleteCmlInfoByHand")]
		public function deleteCmlInfoByHandResultHandler(p_result:ResultEvent, trigger:CmlInfoByHandMsg):void
		{
			var msg:CmlInfoByHandMsg = new CmlInfoByHandMsg();
			msg.type = "deleteCmlInfoByHandResult";
			msg.result= p_result.result;
			sendMessage(msg);
		}
		
		
	}
}