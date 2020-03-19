package sent.transmgr.pm
{
	import mx.collections.ArrayCollection;
	import mx.collections.IList;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.util.StringUtil;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.transmgr.message.TransBanknoteSeqMsg;
	import sent.transmgr.message.TransInfoMsg;
	import sent.transmgr.vo.CmlSentInfoVO;
	import sent.transmgr.vo.TransBanknoteSeqVO;
	import sent.watch.vo.TransBanknoteSeqInfoVO;
	
	public class TransBanknoteSeqPM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var noteFlagResult :IList;
		[Bindable]
		public var transVO:CmlSentInfoVO=new CmlSentInfoVO();
		
//		/**
//		 * 冠字号码分页
//		 */
//		 [Bindable]
//		 public var transPage:Page=new Page();
		 
		private var langMgr:LanguageManager = LanguageManager.getInstance();
		/**
		 * 参数配置中的时间间隔
		 * */
		[Bindable]
		public var days:String;
		
//		[Bindable]
//		public var transBanknoteSeqVO:CmlSentInfoVO=new CmlSentInfoVO();
		
		[Bindable]
		public var fuzzyEnabled:Boolean;
		
		[Bindable]
		public var condi:Object = new Object();
		
		[Bindable]
		public var tranPage:Page=new Page();
		/** 
		 * 初始化参数
		 * */
		[Init]
		public function getInitParam():void
		{
			var msg:TransBanknoteSeqMsg = new TransBanknoteSeqMsg();
			msg.type="getInitTansBanknoteParamMap";
			sendMessage(msg);
		 //	var msg2:TransBanknoteSeqMsg = new TransBanknoteSeqMsg();
		//	msg2.type="getInitNoteFlag";
	   //   sendMessage(msg2);
		}
		
		
		
		[MessageHandler(selector="getInitNoteFlagResult")]
		public function getInitNoteFlagHandler(r_msg:TransBanknoteSeqMsg):void
		{
			
			if(r_msg){
				noteFlagResult =r_msg.result as IList;
			}
		}
		/**
		 * 从参数中获得查询限制的天数
		 * */
		[MessageHandler(selector="getInitTansBanknoteParamMapResult")]
		public function getInitParamResultHandler(p_msg:TransBanknoteSeqMsg):void
		{
			if(p_msg){
				
				days=p_msg.result as String;
			}
			
		}
		
//		public function loadByCondition():void
//		{
//			var msg:TransBanknoteSeqMsg = new TransBanknoteSeqMsg();
//			msg.type = "getTransBanknoteSeqPage";
//			msg.args["page"] = page;
//			if( !transBanknoteSeqVO.pathcode )
//			{
//				var userPathCode:String = UserInfoInit.userInfo["orgPathCode"];
//				transBanknoteSeqVO.pathcode = userPathCode;
//			}
//			
//			msg.args["vo"] = transBanknoteSeqVO;
//			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
//			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");
//			
//			sendMessage(msg);
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
//		
//			if(diffDay>day){
//				var wrongMsg:String = langMgr.getCommonLanguageMap("Msg")["dateFailMsg"] as String;
//				wrongMsg = StringUtil.replace(wrongMsg, "(?1)", days);
//				AlertHandler.alert(wrongMsg);
//				//AlertHandler.alert("请选择近一天内的时间");
//				return ;
//			} 
//			
//			else{
//				loadByCondition();
//			}
//		}
//		
//		/**
//		 * 加载数据
//		 * 
//		 */		
//		public function loadPage():void
//		{
//		
//			//冠字号码输入不得少于10位
//			var seriaNo:String=transBanknoteSeqVO.seriaNo;
//			//交易检索中，根据参数配置中day来限制查询的时间范围
//			//输入时间和冠子号
//			if(transBanknoteSeqVO.seriaNo!=null&&transBanknoteSeqVO.seriaNo!=""&&condi.startTime!=null&&condi.startTime!="")
//				
//			{
//				if(condi.endTime==null)
//				{
//					condi.endTime=new Date();
//				}
//				var day:int=int(days);
//				var starDate:Date=condi.startTime;//开始时间
//				var endDate:Date=condi.endTime;//结束时间
//				var num1:Number=endDate.valueOf();//转换成相差毫秒数
//				var num2:Number=starDate.valueOf();
//				var d1Days:int=int(num1/24/60/60/1000);//得到天(24*60*60*1000)一天的毫秒数
//				var d2Days:int=int(num2/24/60/60/1000);
//				var diffDay:int=d1Days-d2Days;//开始时间和结束时间比较
//				
//				if(diffDay>day)
//				{
//					var wrongMsg:String = langMgr.getCommonLanguageMap("Msg")["dateFailMsg"] as String;
//					wrongMsg = StringUtil.replace(wrongMsg, "(?1)", days);
//					AlertHandler.alert(wrongMsg);
//					
//				} 
//					//endChange();
//					
//				/*else if(seriaNo.length!=10)
//				{
//					AlertHandler.alert("seriaNoNotice");
//					
//				}
//				else{
//					loadByCondition();
//				}*/
//				loadByCondition();
//			}
//				//只有时间条件查询
//			else if(condi.startTime!=null&&condi.startTime!=""){
//				if(condi.endTime==null){
//					condi.endTime=new Date();
//				}
//				endChange();
//			}
//				//输入冠子号码的查询
//			else if(transBanknoteSeqVO.seriaNo!=null&&transBanknoteSeqVO.seriaNo!=""){
//				/*if(seriaNo.length!=10)
//				{
//					AlertHandler.alert("seriaNoNotice");
//					return;
//				}
//				else
//				{
//					loadByCondition();
//				}*/
//				loadByCondition();
//			}	
//				
//				//不输入任何条件的默认查询
//			else{
//				loadByCondition();
//			}
//		}
		
		/**
		 * 冠字号码列表
		 * */
		[MessageHandler(selector="getTransBanknoteSeqPageResult")]
		public function getTransBanknoteSeqPageResult(p_msg:TransBanknoteSeqMsg):void
		{
			if(p_msg.result)
				page = p_msg.result as Page;
   		}
		
		/**
		 * 根据交易id查询冠字号码检索对应的冠字号码列表
		 */
		public function loadTransBanknote():void
		{
			var msg:TransBanknoteSeqMsg=new TransBanknoteSeqMsg();
			msg.type="getTransSeqByTranId";	// java: "getTransBanknoteSeqByTranId", result: "getTransSeqByTranIdResult"
			//transPage.pageSize=8;
			msg.args["page"] = tranPage;
			msg.args["id"] = transVO.tranId;
		    msg.args["tranMonthDay"] = transVO.tranDate.substr(4,4);
			sendMessage(msg);
		}
		
		
		public function sendTransBanknoteSeqMsg(msg:TransBanknoteSeqMsg):void
		{
			msg.type = "TransBanknoteSeqDelegate:com.grgbanking.sent.transmgr.service.TransBanknoteSeqFuzzyService";
			sendMessage(msg);
		}
	}	
}
