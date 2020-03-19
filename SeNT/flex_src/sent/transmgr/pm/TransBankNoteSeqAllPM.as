package sent.transmgr.pm
{
	import platform.common.formatter.DateFormatter;
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.util.StringUtil;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.transmgr.message.TransBankNoteSeqAllMsg;
	import sent.transmgr.vo.CmlSentInfoVO;

	public class TransBankNoteSeqAllPM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var atmTransPage:Page=new Page();
		
		private var langMgr:LanguageManager = LanguageManager.getInstance();
		
		/**
		 * 参数配置中的时间间隔
		 * */
		[Bindable]
		public var days:String;
		
		[Bindable]
		public var cmlSentInfo:CmlSentInfoVO=new CmlSentInfoVO();//冠字号码信息
		
		[Bindable]
		public var fuzzyEnabled:Boolean;
		
//		[Bindable]
//		public var transBankNoteSeqAllVO:CmlSentInfoVO=new CmlSentInfoVO();
		
//		[Bindable]
//		public var condi:Object = new Object();
		
		/** 
		 * 初始化参数
		 */
		[Init]
		public function getInitParam():void
		{
			trace("TransBankNoteSeqAllPM.getInitParam");
			var msg:TransBankNoteSeqAllMsg = new TransBankNoteSeqAllMsg();
			msg.type="getInitParamMap";
			sendMessage(msg);
		}
		
//		public function loadByCondition():void
//		{
//			var msg:TransBankNoteSeqAllMsg = new TransBankNoteSeqAllMsg();
//			msg.type = "getTransBankNoteSeqAllPage";
//			msg.args["page"] = page;
//			if( !transBankNoteSeqAllVO.pathcode )
//			{
//				var userPathCode:String = UserInfoInit.userInfo["orgPathCode"];
//				transBankNoteSeqAllVO.pathcode = userPathCode;
//			}
//			msg.args["vo"] = transBankNoteSeqAllVO;
//			msg.args["startTime"] = DateFormatter.format(condi.startTime, "YYYY-MM-DD JJ:NN:SS");
//			msg.args["endTime"] = DateFormatter.format(condi.endTime, "YYYY-MM-DD JJ:NN:SS");
//			
//			sendMessage(msg);
//		}
		
		/**
		 * 从参数中获得查询限制的天数
		 */
		[MessageHandler(selector="getInitParamMapResult")]
		public function getInitParamResultHandler(p_msg:TransBankNoteSeqAllMsg):void
		{
			trace("TransBankNoteSeqAllPM.getInitParamResultHandler");
			if(p_msg)
			{
				days=p_msg.result as String;
			}
		}
		
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
//			if(diffDay>day)
//			{
//				var wrongMsg:String = langMgr.getCommonLanguageMap("Msg")["dateFailMsg"] as String;
//				wrongMsg = StringUtil.replace(wrongMsg, "(?1)", days);
//				AlertHandler.alert(wrongMsg);
//				return ;
//			} 
//			else
//			{
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
//			//冠字号码输入不得少于10位
//			var seriaNo:String = transBankNoteSeqAllVO.seriaNo;
//			//交易检索中，根据参数配置中day来限制查询的时间范围
//			//输入时间和冠子号
//			if( transBankNoteSeqAllVO.seriaNo!=null && 
//				transBankNoteSeqAllVO.seriaNo!="" && 
//				condi.startTime!=null && 
//				condi.startTime!="" )
//			{
//				if( condi.endTime==null )
//				{
//					condi.endTime = new Date();
//				}
//				var day:int = int(days);
//				var starDate:Date = condi.startTime;		//开始时间
//				var endDate:Date = condi.endTime;			//结束时间
//				var num1:Number = endDate.valueOf();		//转换成相差毫秒数
//				var num2:Number = starDate.valueOf();
//				var d1Days:int = int(num1/24/60/60/1000);	//得到天(24*60*60*1000)一天的毫秒数
//				var d2Days:int = int(num2/24/60/60/1000);
//				var diffDay:int = d1Days-d2Days;			//开始时间和结束时间比较
//				
//				if(diffDay>day)
//				{
//					var wrongMsg:String = langMgr.getCommonLanguageMap("Msg")["dateFailMsg"] as String;
//					wrongMsg = StringUtil.replace(wrongMsg, "(?1)", days);
//					AlertHandler.alert(wrongMsg);
//				} 
//				else if( seriaNo.length!=10 )
//				{
//					AlertHandler.alert("seriaNoNotice");
//				}
//				else
//				{
//					loadByCondition();
//				}
//			}
//			//只有时间条件查询
//			else if(condi.startTime!=null&&condi.startTime!="")
//			{
//				if(condi.endTime==null)
//				{
//					condi.endTime=new Date();
//				}
//				endChange();
//			}
//		    //输入冠子号码的查询
//			else if(transBankNoteSeqAllVO.seriaNo!=null&&transBankNoteSeqAllVO.seriaNo!="")
//			{
//				if(seriaNo.length!=10)
//				{
//					AlertHandler.alert("seriaNoNotice");
//					return;
//				}
//				else
//				{
//					loadByCondition();
//				}
//			}	
//			//不输入任何条件的默认查询
//			else
//			{
//				loadByCondition();
//			}
//		}
			
		
		[MessageHandler(selector="getTransBankNoteSeqAllPageResult")]
		public function getTransBanknoteSeqPageResult(p_msg:TransBankNoteSeqAllMsg):void
		{
			trace("TransBankNoteSeqAllPM.getTransBanknoteSeqPageResult-getTransBankNoteSeqAllPageResult");
			if(p_msg.result)
			{
				page = p_msg.result as Page;
			}
		}
		
//		/**
//		 * 加载一笔交易的所有冠字号码列表
//		 * */
//		public function getTransAllBankNote():void
//		{
//			trace("TransBankNoteSeqAllPM.getTransAllBankNote");
//			var seqMsg:TransBankNoteSeqAllMsg= new TransBankNoteSeqAllMsg();
//			seqMsg.type = "getTransAllBanknoteSeqByTranId";		// java: "getTransAllBanknoteSeqByTranId", result: "getTransAllBanknoteSeqByTranIdResult"
//			seqMsg.args["id"] = cmlSentInfo.tranId;
//			seqMsg.args["page"] = atmTransPage;
//			seqMsg.args["tranMonthDay"] = cmlSentInfo.tranDate.substr(4,4);
//			sendMessage(seqMsg);
//		}
		
		public function sendTransBankNoteSeqAllMsg(msg:TransBankNoteSeqAllMsg):void
		{
			msg.type = "TransBankNoteSeqAllDelegate:com.grgbanking.sent.transmgr.service.TransBankNoteSeqAllService";
			sendMessage(msg);
		}
		
	}
}