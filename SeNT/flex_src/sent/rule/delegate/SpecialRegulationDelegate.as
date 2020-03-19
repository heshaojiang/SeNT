package sent.rule.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.rule.message.SpecialRegulationModuleMsg;

	public class SpecialRegulationDelegate extends DelegateBase
	{
		/**
		 * 根据条件查询交易监控信息
		 */	
		
		[Command(selector="getSpecialRegulationPage")]
		public function getBlackRegulationPage(msg:SpecialRegulationModuleMsg):AsyncToken
		{
			return call("getSpecialRegulationPage", msg.args["page"], msg.args["vo"]);
		}
		[CommandResult(selector="getSpecialRegulationPage")]
		public function getSpecialRegulationPageResultHandler(p_result:ResultEvent, trigger:SpecialRegulationModuleMsg):void
		{
			var msg:SpecialRegulationModuleMsg = new SpecialRegulationModuleMsg();
			msg.type = "getSpecialRegulationPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 新增特殊规则
		 */
		
		[Command(selector = "newSpecialRegulationInfo")]
		public function newSpecialRegulationInfo(p_msg:SpecialRegulationModuleMsg):AsyncToken
		{
			return call("addSpecialRegulation", p_msg.args["data"]);
		}
		[CommandResult(selector = "newSpecialRegulationInfo")]
		public function saveResultHandler(p_result:ResultEvent, tigger:SpecialRegulationModuleMsg):void
		{
			var msg:SpecialRegulationModuleMsg = new SpecialRegulationModuleMsg();
			
			msg.type = "newSpecialRegulationSaveSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 修改特殊规则
		 */
		
		[Command(selector = "updateSpecialRegulation")]
		public function editSpecialRegulationInfo(p_msg:SpecialRegulationModuleMsg):AsyncToken
		{
			return call("updateSpecialRegulation", p_msg.args["data"]);
		}
		[CommandResult(selector = "updateSpecialRegulation")]
		public function saveEditResultHandler(p_result:ResultEvent, tigger:SpecialRegulationModuleMsg):void
		{
			var msg:SpecialRegulationModuleMsg = new SpecialRegulationModuleMsg();
			
			msg.type = "updateSpecialRegulationSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 删除特殊规则
		 */
		
		[Command(selector = "deleteSpecialRegulation")]
		public function delSpecialRegulationInfo(p_msg:SpecialRegulationModuleMsg):AsyncToken
		{
			return call("deleteSpecialRegulations", p_msg.args["ids"]);
		}
		[CommandResult(selector = "deleteSpecialRegulation")]
		public function delResultHandler(p_result:ResultEvent, tigger:SpecialRegulationModuleMsg):void
		{
			var msg:SpecialRegulationModuleMsg = new SpecialRegulationModuleMsg();
			
			msg.type = "deleteSpecialRegulationSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		/**
		 * 查看特殊规则详情
		 */
		
		[Command(selector = "getSpecialRegulationObject")]
		public function getSpecialRegulationObject(p_msg:SpecialRegulationModuleMsg):AsyncToken
		{
			return call("getSpecialRegulationObject", p_msg.args["id"]);
		}
		[CommandResult(selector = "deleteSpecialRegulation")]
		public function getSpecialRegulationObjectResultHandler(p_result:ResultEvent, tigger:SpecialRegulationModuleMsg):void
		{
			var msg:SpecialRegulationModuleMsg = new SpecialRegulationModuleMsg();
			
			msg.type = "getSpecialRegulationObjectResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
	}
}
