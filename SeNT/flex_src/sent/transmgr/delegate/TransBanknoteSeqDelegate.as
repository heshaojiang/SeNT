package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.TransBanknoteSeqMsg;
	import sent.transmgr.message.TransInfoMsg;
	
	public class TransBanknoteSeqDelegate extends DelegateBase
	{
		/**
		 * 获取交易关联的冠字号码列表
		 * */
		[Command(selector="getTransBanknoteSeqByTranId")]
		public function getTransBanknoteSeqByTranId(p_msg:TransInfoMsg):AsyncToken
		{
			return call("getTransBanknoteSeqByTranId",p_msg.args["page"],p_msg.args["id"],p_msg.args["tranMonthDay"]);
		}
		[CommandResult(selector="getTransBanknoteSeqByTranId")]
		public function getTransBanknoteSeqByTranIdResult(p_result:ResultEvent, trigger:TransInfoMsg):void
		{
			trigger.type = "getTransSEQListResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 查看交易监控对应的冠字号码信息
		 * */
		
			[Command(selector="getTranshourPageBanknoteSeqByTranId")]
			public function getTransHourBanknoteSeqByTranId(p_msg:TransInfoMsg):AsyncToken
			{
				return call("getTransBanknoteSeqByTranId",p_msg.args["page"],p_msg.args["id"],p_msg.args["tranMonthDay"]);
			}
			[CommandResult(selector="getTranshourPageBanknoteSeqByTranId")]
			public function getTransBanknoteHourSeqByTranIdResult(p_result:ResultEvent, trigger:TransInfoMsg):void
			{
				trigger.type = "getTranshourPageBanknoteSeqByTranIdResult";
				trigger.result = p_result.result;
				sendMessage(trigger);
			}
		/**
		 * 获取冠字号码检索中对应的冠字号码列表查询
		* */
			[Command(selector="getTransSeqByTranId")]
			public function getTransSeqByTranId(p_msg:TransBanknoteSeqMsg):AsyncToken
			{
				return call("getTransBanknoteSeqByTranId",p_msg.args["page"],p_msg.args["id"],p_msg.args["tranMonthDay"]);
			}
			[CommandResult(selector="getTransSeqByTranId")]
			public function getTransSeqByTranIdResult(p_result:ResultEvent, trigger:TransBanknoteSeqMsg):void
			{
				trigger.type = "getTransSeqByTranIdResult";
				trigger.result = p_result.result;
				sendMessage(trigger);
			}
		/**
		 * 获取交易关联的冠字号码列表
		 * */
		/*[Command(selector="getTransBanknoteSeqPage")]
		public function getTransBanknoteSeqPage(p_msg:TransBanknoteSeqMsg):AsyncToken
		{
			return call("getTransBanknoteSeqPage", p_msg.args["page"], p_msg.args["vo"], p_msg.args["startTime"], p_msg.args["endTime"], p_msg.args["fuzzyCount"]);
		}
		[CommandResult(selector="getTransBanknoteSeqPage")]
		public function getTransBanknoteSeqPageResult(p_result:ResultEvent, trigger:TransBanknoteSeqMsg):void
		{
			trigger.type = "getTransBanknoteSeqPageResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}*/
		/**
		 * 根据条件参数获取冠字号检索的时间范围
		 */		
		[Command(selector="getInitTansBanknoteParamMap")]
		public function getInitParamMap(msg:TransBanknoteSeqMsg):AsyncToken
		{
			return call("getInitParamMap");
		}
		[CommandResult(selector="getInitTansBanknoteParamMap")]
		public function getInitParamMapResult(p_result:ResultEvent, trigger:TransBanknoteSeqMsg):void
		{
			var msg:TransBanknoteSeqMsg = new TransBanknoteSeqMsg();
			msg.type = "getInitTansBanknoteParamMapResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		/**
		 *查看图片
		 */
		[Command(selector="getTransBanknoteSeqById")]
		public function getTransBanknoteSeqById(p_msg:TransBanknoteSeqMsg):AsyncToken
		{
			return call("getTransBanknoteSeqById", p_msg.args["ids"]);
				
		}
		[CommandResult(selector="getTransBanknoteSeqById")]
		public function getTransBanknoteSeqByIdResult(p_result:ResultEvent, trigger:TransBanknoteSeqMsg):void
		{
			trigger.type = "getTransBanknoteSeqByIdResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/***
		 * 查看图片的配置路径参数
		 * */
		[Command(selector="getImgParmPath")]
		public function getImgParmPath(p_msg:TransBanknoteSeqMsg):AsyncToken
		{
			return call("getImgParmPath");
			
		}
		[CommandResult(selector="getImgParmPath")]
		public function getImgParmPathResult(p_result:ResultEvent, trigger:TransBanknoteSeqMsg):void
		{
			trigger.type = "getImgParmPathResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		[Command(selector="getInitNoteFlag")]
		public function getInitNoteFlags(p_msg:TransBanknoteSeqMsg):AsyncToken
		{
			return call("getNoteFlag");
			
		}
		[CommandResult(selector="getInitNoteFlag")]
		public function getNoteFlagsResult(p_result:ResultEvent, trigger:TransBanknoteSeqMsg):void
		{
			trigger.type = "getInitNoteFlagResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		
		/**
		 * 
		 */		
		[Command(selector="TransBanknoteSeqDelegate:com.grgbanking.sent.transmgr.service.TransBanknoteSeqFuzzyService")]
		public function executeCommandForTransBanknoteSeqMsg(msg:TransBanknoteSeqMsg):AsyncToken
		{
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="TransBanknoteSeqDelegate:com.grgbanking.sent.transmgr.service.TransBanknoteSeqFuzzyService")]
		public function executeCommandForTransBanknoteSeqMsgResultHandler(result:ResultEvent, trigger:TransBanknoteSeqMsg):void
		{
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="TransBanknoteSeqDelegate:com.grgbanking.sent.transmgr.service.TransBanknoteSeqFuzzyService")]
		public function executeCommandForTransBanknoteSeqMsgErrorHandler(fault:FaultEvent, trigger:TransBanknoteSeqMsg):void
		{
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
	}
}