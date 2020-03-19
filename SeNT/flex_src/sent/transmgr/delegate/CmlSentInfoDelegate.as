package sent.transmgr.delegate
{
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	import sent.transmgr.message.CmlSentInfoMsg;
	
	public class CmlSentInfoDelegate extends DelegateBase
	{
		
//		/**
//		 * 根据条件查询交易监控信息
//		 */		
//		[Command(selector="getCmlTaskById")]
//		public function getCmlTaskById(msg:CmlSentInfoMsg):AsyncToken
//		{
//			return call("getCmlTaskById", msg.args["vo"]);
//		}
//		
//		/**
//		 * 
//		 */
//		[CommandResult(selector="getCmlTaskById")]
//		public function getCmlTaskByIdResultHandler(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
//		{
//			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
//			msg.type = "getCmlTaskByIdResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		
//		/**
//		 *根据id查找对应冠字号图片信息 
//		 * */
//		[Command(selector="getCmlSentPic")]
//		public function getCmlSentPic(msg:CmlSentInfoMsg):AsyncToken
//		{
//			return call("getCmlSentPic", msg.args["id"],msg.args["tranMonthday"]);
//			
//		}
//		
//		/**
//		 * 
//		 */
//		[CommandResult(selector="getCmlSentPic")]
//		public function getCmlSentPicResultHandler(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
//		{
//			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
//			msg.type = "getCmlSentPicResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
//		/**
//		 * 流转信息相关的冠字号码显示
//		 **/
//		[Command(selector="getCmlSentPicByNoteflow")]
//		public function getCmlSentPicByNoteflow(msg:CmlSentInfoMsg):AsyncToken
//		{
//			return call("getCmlSentPic", msg.args["id"],msg.args["tranMonthday"]);
//			
//		}
//		
//		/**
//		 * 
//		 */
//		[CommandResult(selector="getCmlSentPicByNoteflow")]
//		public function getCmlSentPicByNoteflowResultHandler(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
//		{
//			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
//			msg.type = "getCmlSentPicByNoteflowResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
//		/**
//		 * 获得参数配置中图片的路径
//		 */
//		[Command(selector="getCmlImgParmPath")]
//		public function getCmlSentPicParam(msg:CmlSentInfoMsg):AsyncToken
//		{
//			return call("getCmlImgParmPath");
//		}
//		
//		/**
//		 * 
//		 */
//		[CommandResult(selector="getCmlImgParmPath")]
//		public function getCmlImgParmPath(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
//		{
//			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
//			msg.type = "getCmlImgParmPathResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
//		/**
//		 * 根据所选冠字号码显示冠字号信息
//		 * */
//		[Command(selector="getCmlSentInfosById")]
//		public function getCmlSentInfosByIdCommand(msg:CmlSentInfoMsg):AsyncToken
//		{
//			return call("getCmlSentInfosById", msg.args["id"]);
//		}
//		
//		/**
//		 * 
//		 */
//		[CommandResult(selector="getCmlSentInfosById")]
//		public function getCmlSentInfosByIdCommandResult(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
//		{
//			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
//			msg.type = "getCmlSentInfosByIdResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		
		/**
		 * 根据条件获得清分交易的时间参数路径
		 */		
		[Command(selector="getInitCmlParamMap")]
		public function getInitCmlParamMap(msg:CmlSentInfoMsg):AsyncToken
		{
			return call("getInitCmlParamMap");
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="getInitCmlParamMap")]
		public function getInitCmlParamMapResult(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
		{
			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
			msg.type = "getInitCmlParamMapResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		

//		/**
//		 * 根据数据产生方式分别显示数据（0：导入，1：手动2：自动）
//		 */
//		[Command(selector="impCmlSentPic")]
//		public function getCmlImprecorsByTaskId(msg:CmlSentInfoMsg):AsyncToken
//		{
//			return call("getImpCmlsentPic",msg.args["id"]);
//		}
//		
//		/**
//		 * 
//		 */
//		[CommandResult(selector="impCmlSentPic")]
//		public function impCmlSentPicResult(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
//		{
//			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
//			msg.type = "impCmlSentPicResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}

		
//		/**
//		 * 查找导入冠字号的文件信息 
//		 */
//		[Command(selector="getCmlImprecords")]
//		public function getCmlImprecordsByCmlsentInfos(msg:CmlSentInfoMsg):AsyncToken
//		{
//			return call("getCmlImprecords",msg.args["id"]);
//			
//		}
//		
//		/**
//		 * 
//		 */
//		[CommandResult(selector="getCmlImprecords")]
//		public function getCmlImprecordsByCmlsentInfosResult(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
//		{
//			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
//			msg.type = "getCmlImprecordsResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		
//		/**
//		 * 导入冠子号码图片
//		 */
//		[Command(selector="serarchImpCmlsentPic")]
//		public function serarchImpCmlsentPic(msg:CmlSentInfoMsg):AsyncToken
//		{
//			return call("impCmlsentInfoPic",msg.args["id"],msg.args["tranMonthday"]);
//			
//			
//		}
//		
//		/**
//		 * 
//		 */
//		[CommandResult(selector="serarchImpCmlsentPic")]
//		public function impCmlsentPicResult(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
//		{
//			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
//			msg.type = "serarchImpCmlsentPicResult";
//			msg.result = p_result.result;
//			sendMessage(msg);
//		}
		

		
		
		/**
		 * 检查导入的文件是否已经存在
		 */
		[Command(selector="checkFileisExists")]
		public function checkFileisExists(msg:CmlSentInfoMsg):AsyncToken
		{
			trace("CmlSentInfoDellegate.checkFileisExists");
			return call("isExist", msg.args["oldName"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="checkFileisExists")]
		public function checkFileisExistsResult(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
		{
			trace("CmlSentInfoDellegate.checkFileisExistsResult");
			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
			msg.type = "checkFileisExistsResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 解析文件
		 * */
		[Command(selector="importExcelForCML")]
		public function importExcelForCML(msg:CmlSentInfoMsg):AsyncToken
		{
			return call("impCSV",msg.args["data"],msg.args["oldName"],msg.args["termType"],msg.args["pathcode"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="importExcelForCML")]
		public function importExcelForCMLResult(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
		{
			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
			msg.type = "importExcelForCMLResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		/**
		 * 加载冠字号码导入文件信息
		 * */
		[Command(selector="loadCmlImp")]
		public function loadCmlImp(msg:CmlSentInfoMsg):AsyncToken
		{
			return call("loadCmlImp",msg.args["page"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="loadCmlImp")]
		public function loadCmlImpResult(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
		{
			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
			msg.type = "loadCmlImpResult";
			msg.result = p_result.result;
			sendMessage(msg);
		}
		
		
		
		/**
		 * 根据条件查询冠字号码信息
		 */		
		[Command(selector="getCmlSentInfosPageByFlowNum")]
		public function getCmlSentInfosPageByFlowNum(msg:CmlSentInfoMsg):AsyncToken
		{
			return call("getCmlSentInfosPageByFlowNum", msg.args["page"], msg.args["barcodeFlowNum"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="getCmlSentInfosPageByFlowNum")]
		public function getCmlSentInfosPageByFlowNumResultHandler(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
		{
			trigger.type = "getCmlSentInfosPageByFlowNumResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 根据流转条码查看对应流转信息
		 */
		[Command(selector="findNoteflowInfosByBarCodeFlowNum")]
		public function findNoteflowInfosByBarCodeFlowNun(msg:CmlSentInfoMsg):AsyncToken
		{
			
			return call("findNoteflowInfosByBarCodeFlowNun", msg.args["page"], msg.args["barcodeFlowNum"]);
		}
		
		[CommandResult(selector="findNoteflowInfosByBarCodeFlowNum")]
		public function findNoteflowInfosByBarCodeFlowNunResultHandler(p_result:ResultEvent, trigger:CmlSentInfoMsg):void
		{
			
			trigger.type = "findNoteflowInfosByBarCodeFlowNumResult";
			trigger.result = p_result.result;
			sendMessage(trigger);
		}

	
		
		
		/**
		 * 
		 */		
		[Command(selector="CmlSentInfoDelegate:com.grgbanking.sent.transmgr.service.CmlSentInfoService")]
		public function executeCommandForCmlSentInfoMsg(msg:CmlSentInfoMsg):AsyncToken
		{
			trace("CmlSentInfoDelegate.executeCommandForCmlSentInfoMsg");
			return call(msg.args["remoteMethod"], msg.args["methodPrameter"]);
		}
		
		/**
		 * 
		 */
		[CommandResult(selector="CmlSentInfoDelegate:com.grgbanking.sent.transmgr.service.CmlSentInfoService")]
		public function executeCommandForCmlSentInfoMsgResultHandler(result:ResultEvent, trigger:CmlSentInfoMsg):void
		{
			trace("CmlSentInfoDelegate.executeCommandForCmlSentInfoMsgResultHandler");
			trigger.type = trigger.args["resultHandler"];
			trigger.result = result.result;
			sendMessage(trigger);
		}
		
		/**
		 * 
		 */
		[CommandError(selector="CmlSentInfoDelegate:com.grgbanking.sent.transmgr.service.CmlSentInfoService")]
		public function executeCommandForCmlSentInfoMsgErrorHandler(fault:FaultEvent, trigger:CmlSentInfoMsg):void
		{
			trace("CmlSentInfoDelegate.executeCommandForCmlSentInfoMsgErrorHandler");
			trace(fault.message);
			trigger.type = trigger.args["errorHandler"];
			trigger.result = fault.message;
			sendMessage(trigger);
		}
		
	}
}