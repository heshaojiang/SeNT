package sent.transmgr.pm
{
	import platform.common.formatter.DateFormatter;
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.util.StringUtil;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.transmgr.message.TransInfoMsg;
	import sent.transmgr.vo.CmlSentInfoVO;
	import sent.transmgr.vo.TransInfoVO;
	import sent.watch.vo.TransBanknoteSeqInfoVO;
	import sent.watch.vo.TransHourInfoVO;
	
	public class TransInfoPM extends BasePM
	{
//		[Bindable]
//		public var page:Page = new Page();
		
//		//交易检索的时间范围参数
//		[Bindable]
//		public var days:String;
		
//		[Bindable]
//		public var transInfo:TransInfoVO=new TransInfoVO();
		
//		[Bindable]
//		public var id:String;
		
//		[Bindable]
//		public var tranvo:TransInfoVO = new TransInfoVO();
		
//		[Bindable]
//		public var condi:Object = new Object();
		
//		//判断时间是否符合要求
//		[Bindable]
//		public var flag:Boolean=false;
		
//		private var langMgr:LanguageManager = LanguageManager.getInstance();
		
//		[Bindable]
//		public var tranPage:Page=new Page();
		
//		[Bindable]
//		public var hoursPage:Page=new Page();
		
//		[Bindable]
//		public var tranId:String;
		
//		[Bindable]
//		public var transVO:CmlSentInfoVO=new CmlSentInfoVO();
		
//		[Bindable]
//		public var transHourVo:TransInfoVO=new TransInfoVO();
		
//		/**
//		 * 冠字号码分页
//		 */
//		[Bindable]
//		public var transPage:Page=new Page();
		
//		/**
//		 * 交易检索查看冠字号码信息
//		 */
//		public function loadTransBank():void
//		{
//			var msg:TransInfoMsg = new TransInfoMsg();
//			msg.type = "getTransBanknoteSeqByTranId";	// java: "getTransBanknoteSeqByTranId", result: "getTransSEQListResult"
//			//tranPage.pageSize=10;
//			msg.args["page"]=tranPage;
//			msg.args["id"] = id;
//		
//			msg.args["tranMonthDay"]=tranvo.tranDate.substr(4,4);
//			sendMessage(msg);
//		}
		
//		/** 
//		 * 初始化参数
//		 */
//		[Init]
//		public function getInitParam():void
//		{
//			var msg:TransInfoMsg = new TransInfoMsg();
//			msg.type = "getInitParamMap";
//			sendMessage(msg);
//		}
		
//		/**
//		 * 从参数中获得查询限制的天数
//		 */
//		[MessageHandler(selector="getInitParamMapResult")]
//		public function getInitParamResultHandler(p_msg:TransInfoMsg):void
//		{
//			if( p_msg )
//			{
//				days=p_msg.result as String;
//			}
//		}
//		
//		/**
//		 * 获取交易监控列表信息
//		 * */
//		public function getTransHourInfoPage():void
//		{
//			var msg:TransInfoMsg = new TransInfoMsg();
//			msg.type="getTransHourInfoPage";
//			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
//			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");
//			msg.args["page"] = page;
//			if( !transInfo.pathcode )
//			{
//				var userPathCode:String=UserInfoInit.userInfo["orgPathCode"];
//				transInfo.pathcode=userPathCode;
//			}
//			msg.args["transHourInfo"] = transInfo;
//			sendMessage(msg);
//		}
//		
//		/**
//		 * 实时交易监控查看冠字号码信息
//		 * */
//		public function loadTransHourPage():void
//		{
//			var msg:TransInfoMsg = new TransInfoMsg();
//			msg.type = "getTransHourBankNote";
//			//hoursPage.pageSize=10;
//			msg.args["page"]=hoursPage;
//			msg.args["id"] = transHourVo.id;
//			msg.args["tranMonthDay"]=transHourVo.tranDate.substr(4,4);
//			sendMessage(msg);
//		}
//		
//		/**
//		/**交易监控返回的结果集*/
//		[MessageHandler(selector="getTransHourInfoPageResult")]
//		public function getTransHourInfoPageResult(p_msg:TransInfoMsg):void
//		{
//			if(p_msg)
//				page = p_msg.result as Page; 
//			
//		}
//		
//		//交易检索的时间控制在一天（参数配置中taransDay设置）以内的
//		private function endChange():void
//		{
//			var day:int=int(days);
//			var starDate:Date=condi.startTime;//开始时间
//			var endDate:Date=condi.endTime;//结束时间
//			var num1:Number=endDate.valueOf();//转换成相差毫秒数
//			var num2:Number=starDate.valueOf();
//			var d1Days:int=int(num1/24/60/60/1000);//得到天(24*60*60*1000)一天的毫秒数
//			var d2Days:int=int(num2/24/60/60/1000);
//			var diffDay:int=d1Days-d2Days;//开始时间和结束时间比较
//			if(diffDay>day){
//				var wrongMsg:String = langMgr.getCommonLanguageMap("Msg")["dateFailMsg"] as String;
//				wrongMsg = StringUtil.replace(wrongMsg, "(?1)", days);
//				AlertHandler.alert(wrongMsg);
//				//AlertHandler.alert("请选择近一天内的时间");
//				return;
//			} 
//			else{
//				loadByTime();
//			}
//		}
//		public function loadByTime():void
//		{
//			
//			var msg:TransInfoMsg = new TransInfoMsg();
//			msg.type="getTranInfoPage";
//			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
//			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");
//			msg.args["page"] = page;
//			if(!transInfo.pathcode)
//			{
//				var userPathCode:String = UserInfoInit.userInfo["orgPathCode"];
//			    transInfo.pathcode = userPathCode;
//			}
//			msg.args["transInfo"] = transInfo;
//			sendMessage(msg);
//		}
//		
//	
//		/**
//		 * 获取交易检索列表信息
//		 */
//		public function getTransInfoPage():void
//		{
//			//交易检索中，根据参数配置中day来限制查询的时间范围
//			if(condi.startTime!=null){
//				if(condi.endTime==null){
//					condi.endTime=new Date();
//				}
//				endChange();
//			}
//			else{
//				loadByTime();
//			}
//		}
//		/**
//		 * 交易检索返回的结果集
//		 * */
//		[MessageHandler(selector="getTranInfoPageResult")]
//		public function getTranInfoPageResult(p_msg:TransInfoMsg):void
//		{
//			if(p_msg)
//				page = p_msg.result as Page;  
//			
//		}
		
		////////////////////////////
		
		/**
		 * 通用方法
		 */
		public function sendTransInfoMsg(msg:TransInfoMsg):void
		{
			trace("TransInfoPM.sendTransInfoMsg");
			msg.type = "TransInfoDelegate:com.grgbanking.sent.transmgr.service.TranInfoService";
			sendMessage(msg);
		}
		
		///////////////////////
	}
}