package sent.transmgr.pm
{
	import mx.collections.ArrayCollection;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.common.utils.TestUtils;
	import sent.transmgr.message.TranAbnoinfoBlackModuleMsg;
	import sent.transmgr.vo.TranAbnoinfoVO;

	
	public class TranAbnoinfoBlackModulePM extends BasePM
	{
		
		[Bindable]
		public var page:Page=new Page();
		
		[Bindable]
		public var blackPage:Page=new Page();
		[Bindable]
		public var callBackPage:Page=new Page();
		[Bindable]
		public var specialPage:Page=new Page();
		[Bindable]
		public var blackObj:TranAbnoinfoVO=new TranAbnoinfoVO();
		
		[Bindable]
		public var transab:TranAbnoinfoVO=new TranAbnoinfoVO();
		
		[Bindable]
		public var userPathCode:String=UserInfoInit.userInfo["orgPathCode"];
		[Bindable]
		public var condi:Object = new Object();
		[Bindable]
		public var abnoPage:Page=new Page();
		[Bindable]
		public var tranId:String;
		[Bindable]
		public var tranPage:Page=new Page();
		[Bindable]
		public var pageVO:Page=new Page();
		
		
//		public function loadAbBanknote():void
//		{
//			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
//			msg.type = "getTransAbnobanknoteSeqByTranId";
//			msg.args["page"]=abnoPage;
//			msg.args["tranId"] =tranId;
//			msg.args["transYear"]=;
//			msg.args["tranMonthday"]=;
//			sendMessage(msg);
//		}
		
		
		/**
		 * 加载黑名单或是重号异常交易信息
		 */
		public function loadBlackPage():void
		{ 
			trace("TranAbnoinfoBlackModulePM.loadBlackPage");
			
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getTranAbnoAnalyseinfoPage";	// java: "getTranAbnoAnalyseinfoPage", result: "getTranAbnoAnalyseinfoPageResult"
			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["endTime"]   = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");	
			msg.args["page"]      = page;
			transab.pathcode      = userPathCode;
			msg.args["transab"]   = transab;
			sendMessage(msg);
		}
		
		[MessageHandler(selector="getTranAbnoAnalyseinfoPageResult")]
		public function getTranAbnoAnalyseinfoPageResult(p_msg:TranAbnoinfoBlackModuleMsg):void
		{
			trace("TranAbnoinfoBlackModulePM.getTranAbnoAnalyseinfoPageResult");
			if(p_msg)
			{
				page = p_msg.result as Page; 
			}  	 
		}
	
		/**
		 * 异常回收交易
		 * */
		public function loadCallBack():void{
			
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getCallBackTranAbnoinfoPage";	// java: getCallBackTranAbnoinfoPage, result: getCallBackTranAbnoinfoPageResult
			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");	
			
			msg.args["page"]=page;
			transab.pathcode=userPathCode;
			msg.args["transab"]=transab;
			sendMessage(msg);
		}
		[MessageHandler(selector="getCallBackTranAbnoinfoPageResult")]
		public function loadCallBackResult(p_msg:TranAbnoinfoBlackModuleMsg):void{
			if(p_msg)
				page = p_msg.result as Page; 
			
		}
		
		
		/**
		 * 特殊冠字号码交易
		 */
		public function loadEspecial():void{
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getEspecialTranAbnoinfoPage";	// java: getEspecialTranAbnoinfoPage, result: getEspecialTranAbnoinfoPageResult
			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");	
			
			msg.args["page"]=page;
			transab.pathcode=userPathCode;
			msg.args["transab"]=transab;
			sendMessage(msg);
		}
		[MessageHandler(selector="getEspecialTranAbnoinfoPageResult")]
		public function loadEspecialResult(p_msg:TranAbnoinfoBlackModuleMsg):void{
			if(p_msg)
				page = p_msg.result as Page; 
			
		}
		/**
		 *加载异常交易卡号分析 信息
		 * 
		 * **/
		public function loadAbendAccountPage():void
		{
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getTranAbnoAnalyseinfoList";	// java: getTranAbnoAnalyseinfoList, result: getTranAbnoAnalyseinfoListResult
			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");	
			msg.args["page"]=page;
			transab.pathcode=userPathCode;
			msg.args["transab"]=transab;
			sendMessage(msg);
		}
		[MessageHandler(selector="getTranAbnoAnalyseinfoListResult")]
		public function loadAbnoResult(p_msg:TranAbnoinfoBlackModuleMsg):void{
			if(p_msg)
				page = p_msg.result as Page; 
		}
		/**
		 *加载异常交易设备分析 信息
		 * 
		 * **/
		public function loadAbendTermPage():void
		{
			/*	if(!condi.startTime)
			{
			condi.startTime = DateFormatter.format(new Date(),"YYYY-MM-DD JJ:NN:SS");
			//condi.startTime = condi.startTime+" "+"00:00:00";
			}
			if(!condi.endTime)
			{
			condi.endTime = DateFormatter.format(new Date(),"YYYY-MM-DD JJ:NN:SS");
			//condi.endTime = condi.endTime+" "+"23:59:59";
			}*/
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getTranAbnoAnalyseinfoByTmlList";
			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");	
			
			msg.args["page"]=page;
			transab.pathcode=userPathCode;
			msg.args["transab"]=transab;
			sendMessage(msg);
		}
		[MessageHandler(selector="getTranAbnoAnalyseinfoByTmlListResult")]
		public function loadAbnoTermResult(p_msg:TranAbnoinfoBlackModuleMsg):void{
			if(p_msg)
				page = p_msg.result as Page; 
		}
		
		/**
		 *加载黑名单规则交易分析 信息
		 * 
		 * **/
		public function loadAbendBlackPage():void
		{
			
			var msg:TranAbnoinfoBlackModuleMsg = new TranAbnoinfoBlackModuleMsg();
			msg.type = "getTranAbnoAnalyseinfoByBlReguList";
			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");	
			
			msg.args["page"]=page;
			transab.pathcode=userPathCode;
			msg.args["transab"]=transab;
			sendMessage(msg);
		}
		[MessageHandler(selector="getTranAbnoAnalyseinfoByBlReguListResult")]
		public function loadAbnoBlackResult(p_msg:TranAbnoinfoBlackModuleMsg):void{
			if(p_msg)
				page = p_msg.result as Page; 
		}
		
		/**
		 * 根据交易id查询对应的异常冠字号码信息
		 */
		public function getTransAbnobankNoteSeqByTranId():void
		{
			trace("TranAbnoinfoBlackModulePM.getTransAbnobankNoteSeqByTranId");
			var transMsg:TranAbnoinfoBlackModuleMsg=new TranAbnoinfoBlackModuleMsg();
			transMsg.type="getTransAbnobanknoteSeqByTranId";	// java: getTransAbnobanknoteSeqByTranId, result: getTransAbnobanknoteSeqByTranIdResult
			transMsg.args["tranId"]=blackObj.tranId;
			transMsg.args["page"]=tranPage;
			transMsg.args["tranMothday"]=blackObj.tranMonthday;
			sendMessage(transMsg);
		}
		
		
		public function sendTransAbendaBlackMsg(msg:TranAbnoinfoBlackModuleMsg):void
		{
			msg.type = "TranAbnoinfoBlackDelegate:com.grgbanking.sent.watch.service.TranAbnoinfoService";
			sendMessage(msg);
		}
	}
	}
