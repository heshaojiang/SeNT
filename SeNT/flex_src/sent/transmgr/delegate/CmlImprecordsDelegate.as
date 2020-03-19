package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.CmlImprecordMsg;
	
	public class CmlImprecordsDelegate extends DelegateBase
	{
		/**
		 * 清分冠字号码的导入信息
		 */		
		[Command(selector="getCmlImprecoredsPage")]
		public function getCmlImprecordsPage(msg:CmlImprecordMsg):AsyncToken
		{
			trace("CmlImprecordsDelegate.getCmlImprecordsPage");
			return call("getCmlImprecoredsPage",msg.args["page"],msg.args["vo"],msg.args["startTime"],msg.args["endTime"]);
			
		}
		[CommandResult(selector="getCmlImprecoredsPage")]
		public function getCmlImprecoredsPageResultHandler(p_result:ResultEvent, trigger:CmlImprecordMsg):void
		{
			trace("CmlImprecordsDelegate.getCmlImprecoredsPageResultHandler");
			var msg:CmlImprecordMsg = new CmlImprecordMsg();
			msg.type = "getCmlImprecoredsPageResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 保存数据
		 * */
		[Command(selector="addCmlImprecord")]
		public function addCmlImprecord(msg:CmlImprecordMsg):AsyncToken
		{
			trace("CmlImprecordsDelegate.addCmlImprecord");
			return call("addCmlImprecord",msg.args["cmlImprecords"]);
		}
		
		[CommandResult(selector="addCmlImprecord")]
		public function addCmlImprecordHandler(p_result:ResultEvent,trigger:CmlImprecordMsg):void
		{
			trace("CmlImprecordsDelegate.addCmlImprecordHandler");
			var msg:CmlImprecordMsg = new CmlImprecordMsg();
			msg.type = "addCmlImprecordSuccess";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 获得服务器ip和端口号
		 */
		[Command(selector="findServerInfo")]
		public function findServerInfo(msg:CmlImprecordMsg):AsyncToken
		{
			return call("findServerInfo");
		}
		
		[CommandResult(selector="findServerInfo")]
		public function findServerInfoHandler(p_result:ResultEvent,trigger:CmlImprecordMsg):void
		{
			var msg:CmlImprecordMsg = new CmlImprecordMsg();
			msg.type = "findServerInfoResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
//		/**
//		 * 文件上传成功后更改上传状态
//		 * */
//		[Command(selector="updateUploadStatus")]
//		public function updateUploadStatus(msg:CmlImprecordMsg):AsyncToken
//		{
//			trace("CmlImprecordsDelegate.updateUploadStatus");
//			return call("updateUploadStatus", msg.args["vo"]);
//		}
//		
//		[CommandResult(selector="updateUploadStatus")]
//		public function updateUploadStatusHandler(p_result:ResultEvent, trigger:CmlImprecordMsg):void
//		{
//			trace("CmlImprecordsDelegate.updateUploadStatusHandler");
//			var msg:CmlImprecordMsg = new CmlImprecordMsg();
//			msg.type = "updateUploadStatusSuccess";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}

		
//		/**
//		 * 查找对应的文件是否已经上传
//		 */
//		[Command(selector="findCmlImprecordsByName")]
//		public function findCmlImprecordsByName(msg:CmlImprecordMsg):AsyncToken
//		{
//			trace("CmlImprecordsDelegate.findCmlImprecordsByName");
//			return call("findCmlImprecordsByName",msg.args["fileName"]);
//		}
//		
//		[CommandResult(selector="findCmlImprecordsByName")]
//		public function findCmlImprecordsByNameHandler(p_result:ResultEvent,trigger:CmlImprecordMsg):void
//		{
//			trace("CmlImprecordsDelegate.findCmlImprecordsByNameHandler");
//			var msg:CmlImprecordMsg = new CmlImprecordMsg();
//			msg.type = "findCmlImprecordsByNameResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
//		
//		[CommandError(selector="findCmlImprecordsByName")]
//		public function findCmlImprecordsByNameErrorHandler(p_result:FaultEvent, trigger:CmlImprecordMsg):void
//		{
//			trace("CmlImprecordsDelegate.findCmlImprecordsByNameErrorHandler");
//			TestUtils.printObject(p_result);
//		}
		
//		/**
//		 * 根据用户名称查找用户id
//		 */
//		[Command(selector="findUserCode")]
//		public function findUserCode(msg:CmlImprecordMsg):AsyncToken
//		{
//			return call("findUserCode",msg.args["userName"]);
//		}
//		[CommandResult(selector="findUserCode")]
//		public function findUserCodeHandler(p_result:ResultEvent,trigger:CmlImprecordMsg):void
//		{
//			var msg:CmlImprecordMsg = new CmlImprecordMsg();
//			msg.type = "findUserCodeSuccess";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}

		/**
		 * 获得fsn图片上传路径
		 */
		[Command(selector="findFsnPic")]
		public function findFsnPath(msg:CmlImprecordMsg):AsyncToken
		{
			return call("findFsnPic");
		}
		[CommandResult(selector="findFsnPic")]
		public function findFsnPathHandler(p_result:ResultEvent,trigger:CmlImprecordMsg):void
		{
			var msg:CmlImprecordMsg = new CmlImprecordMsg();
			msg.type = "findFsnPicResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
//		
//		/**
//		 * 获得pathcode值
//		 * */
//		[Command(selector="findPathCode")]
//		public function findPathCode(msg:CmlImprecordMsg):AsyncToken
//		{
//			return call("findPathCode",msg.args["orgId"]);
//		}
//		
//		[CommandResult(selector="findPathCode")]
//		public function findPathCodeHandler(p_result:ResultEvent,trigger:CmlImprecordMsg):void
//		{
//			var msg:CmlImprecordMsg = new CmlImprecordMsg();
//			msg.type = "findPathCodeSuccess";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
//		
//		
//		
//		/**
//		 * 判断终端编号是否存在，然后上传
//		 */
//		[Command(selector="findTermCode")]
//		public function findTermCode(msg:CmlImprecordMsg):AsyncToken
//		{
//			return call("findTermCode",msg.args["termNum"]);
//		}
//		
//		[CommandResult(selector="findTermCode")]
//		public function findTermCodeHandler(p_result:ResultEvent,trigger:CmlImprecordMsg):void
//		{
//			var msg:CmlImprecordMsg = new CmlImprecordMsg();
//			msg.type = "findTermCodeSuccess";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		
//		/**
//		 * 根据上传文件名称查找对应的清分冠字号码信息
//		 * */
//		[Command(selector="findCmlSentInfo")]
//		public function findCmlSentInfo(msg:CmlImprecordMsg):AsyncToken
//		{
//			return call("findCmlSentInfo",msg.args["page"],msg.args["fileName"]);
//		}
//		[CommandResult(selector="findCmlSentInfo")]
//		public function findCmlSentInfoHandler(p_result:ResultEvent,trigger:CmlImprecordMsg):void
//		{
//			var msg:CmlImprecordMsg = new CmlImprecordMsg();
//			msg.type = "findCmlSentInfoResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		
		//////////////////////////////////
		
		/**
		 * 
		 */		
		[Command(selector="CmlImprecordsDelegate:com.grgbanking.sent.transmgr.service.CmlImprecordsService")]
		public function executeCommandForCmlImprecordMsg(msg:CmlImprecordMsg):AsyncToken
		{
			trace("CmlImprecordsDelegate.executeCommandForCmlImprecordMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="CmlImprecordsDelegate:com.grgbanking.sent.transmgr.service.CmlImprecordsService")]
		public function executeCommandForCmlImprecordMsgResultHandler(result:ResultEvent, trigger:CmlImprecordMsg):void
		{
			trace("CmlImprecordsDelegate.executeCommandForCmlImprecordMsgResultHandler");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="CmlImprecordsDelegate:com.grgbanking.sent.transmgr.service.CmlImprecordsService")]
		public function executeCommandForCmlImprecordMsgErrorHandler(fault:FaultEvent, trigger:CmlImprecordMsg):void
		{
			trace("CmlImprecordsDelegate.executeCommandForCmlImprecordMsgErrorHandler");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
		//////////////////////////////////
	}
}