package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.TranAbnoinfoBlackModuleMsg;

	public class TransAbnobanknoteSeqDelegate extends DelegateBase
	{
		/**
		 * 获取异常交易关联的冠字号码列表
		 * */
		[Command(selector="getTransAbnobanknoteSeqByTranId")]
		public function getTransAbnobanknoteSeqByTranId(p_msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			trace("TransAbnobanknoteSeqDelegate.getTransAbnobanknoteSeqByTranId");
			return call("getTransAbnobanknoteSeqByTranId",p_msg.args["page"], p_msg.args["tranId"],p_msg.args["tranMothday"]);
		}
		
		[CommandResult(selector="getTransAbnobanknoteSeqByTranId")]
		public function getTransAbnobanknoteSeqByTranIdResultHandler(p_result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			trace("TransAbnobanknoteSeqDelegate.getTransAbnobanknoteSeqByTranIdResultHandler");
			trigger.type = "getTransAbnobanknoteSeqByTranIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		/**
		 * 查询异常交易冠字号对应的图片
		 */
		[Command(selector="getTransAbnobanknoteSeqById")]
		public function getTransAbnobanknoteSeqById(p_msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			return call("getTransAbnobanknoteSeqById", p_msg.args["ids"]);
		}
		[CommandResult(selector="getTransAbnobanknoteSeqById")]
		public function getTransAbnobanknoteSeqByIdResult(p_result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			trigger.type = "getTransAbnobanknoteSeqByIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		/**
		 * 根据条件参数获取冠字号检索的时间范围
		 */		
		[Command(selector="getAbImgParmPath")]
		public function getInitParamMap(msg:TranAbnoinfoBlackModuleMsg):AsyncToken
		{
			return call("getImgParmPath");
		}
		[CommandResult(selector="getAbImgParmPath")]
		public function getInitParamMapResult(p_result:ResultEvent, trigger:TranAbnoinfoBlackModuleMsg):void
		{
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getAbImgParmPathResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
	}
}