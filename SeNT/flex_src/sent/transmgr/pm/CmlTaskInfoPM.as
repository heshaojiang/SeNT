package sent.transmgr.pm
{
	import flash.external.ExternalInterface;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.util.StringUtil;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.transmgr.message.CmlTaskInfoMsg;
	import sent.transmgr.vo.CmlTaskInfoVO;
	
	public class CmlTaskInfoPM extends BasePM
	{
		[Bindable]
		public var cmlSentInfoPage:Page=new Page();
		
		[Bindable]
		public var page:Page = new Page();
		
		private var langMgr:LanguageManager = LanguageManager.getInstance();
		
		//交易检索的时间范围参数
		[Bindable]
		public var days:String;
		
		[Bindable]
		public	var cmlTaskInfo:CmlTaskInfoVO=new CmlTaskInfoVO;
		
		[Bindable]
		public var str:String;
		
		[Bindable]
		public var cond:Object = new Object();
		
		[Bindable]
		private var tranId:String;
		
		[Bindable]
		public var tranPage:Page=new Page();
		
//		[Bindable]
//		public var obj:CmlTaskInfoVO=new CmlTaskInfoVO();
		
		/**
		 * 数据类型
		 */
		[Bindable]
		public var seriaimg:String;
		/** 
		 * 初始化参数
		 */
		[Init]
		public function getInitParam():void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type="getInitTimeParam";
			sendMessage(msg);
		}
		/**
		 * 从参数中获得查询限制的天数
		 */
		[MessageHandler(selector="getInitTimeParamResult")]
		public function getInitParamResultHandler(p_msg:CmlTaskInfoMsg):void
		{
			if(p_msg)
			{
				days=p_msg.result as String;
			}
			
		}
		
//		/**
//		 *查看交易对应的冠字号码 
//		 **/
//		public function loadTransBankNotePage():void
//		{
//			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
//			msg.type = "getCmlSentInfosPageByTranId";	// java: "getCmlSentInfosPageByvo", result: "getCmlSentInfosPageByTranIdResult"
//			
//			//tranPage.pageSize=10;
//			
//			msg.args["page"] = tranPage;
//			msg.args["vo"] = obj;
//			
//			sendMessage(msg); 
//		}
		
		
//		//交易检索的时间控制在一天（参数配置中taransDay设置）以内的
//		private function endChange():void
//		{
//			var day:int = int(days);
//			var starDate:Date = cond.startTime;//开始时间
//			var endDate:Date = cond.endTime;//结束时间
//			var num1:Number = endDate.valueOf();//转换成相差毫秒数
//			var num2:Number = starDate.valueOf();
//			var d1Days:int = int(num1/24/60/60/1000);//得到天(24*60*60*1000)一天的毫秒数
//			var d2Days:int = int(num2/24/60/60/1000);
//			var diffDay:int = d1Days-d2Days;//开始时间和结束时间比较
//			
//			if(diffDay>day)
//			{
//				var wrongMsg:String = langMgr.getCommonLanguageMap("Msg")["dateFailMsg"] as String;
//				wrongMsg = StringUtil.replace(wrongMsg, "(?1)", days);
//				AlertHandler.alert(wrongMsg);
//				//AlertHandler.alert("请选择近一天内的时间");
//				return ;
//			} 
//			else
//			{
//				loadByCondition();
//			}
//		}
//		
//		public function loadByCondition():void
//		{
//			str = LanguageManager.getInstance().getCommonLanguageMap("components")["all"] as String ;
//			
//			var msg:CmlTaskInfoMsg=new CmlTaskInfoMsg();
//			msg.type="getCmlTaskInfoPage";
//			msg.args["page"]=page;
//			//msg.args["operatorName"]=cond.operatorName;
//			if(!cmlTaskInfo.pathcode){
//				var userPathCode:String=UserInfoInit.userInfo["orgPathCode"];
//				cmlTaskInfo.pathcode=userPathCode;
//			}
//			
//			msg.args["vo"]=cmlTaskInfo;
//			msg.args["startTime"]=DateFormatter.format(cond.startTime, "YYYY-MM-DD JJ:NN:SS");
//			msg.args["endTime"] = DateFormatter.format(cond.endTime, "YYYY-MM-DD JJ:NN:SS");
//			sendMessage(msg);
//		}
//		
//		/**
//		 * 加载清分任务信息
//		 */
//		public function loadPage():void
//		{
//			//交易检索中，根据参数配置中day来限制查询的时间范围
//			if(cond.startTime!=null){
//				if(cond.endTime==null){
//					cond.endTime=new Date();
//				}
//				endChange();
//			}
//			else{
//				loadByCondition();
//			}
//			
//		}
		
		/**
		 * 清分任务信息返回的结果集
		 */
		[MessageHandler(selector="getCmlTaskInfoPageResult")]
		public function getCmlTaskInfoPageResult(p_msg:CmlTaskInfoMsg):void
		{
			if(p_msg)
			{
				page = p_msg.result as Page;
			}
		}
		
//		/**
//		 * 更新信息后刷新
//		 */
//		[MessageHandler(selector="refreshCmlTaskInfo")]
//		public function refreshTaskInfo(p_msg:CmlTaskInfoMsg):void
//		{
//			loadPage();
//		}
		
		/**
		 * 导出任务信息列表
		 */
		public function exportTaskList():void
		{
			var msg:CmlTaskInfoMsg = new CmlTaskInfoMsg();
			msg.type = "exportTaskList";
			msg.args["page"] = page;
			msg.args["cond"] = cond;
			
			sendMessage(msg);
		}
		
		/**
		 * 导出结果集
		 */		
		[MessageHandler(selector="exportTaskInfoResult")]
		public function exportTaskListResultHandler(p_msg:CmlTaskInfoMsg):void
		{
			//清空已选中行
			if(p_msg.result)
			{
				var fileName:String = p_msg.result.toString();
				ExternalInterface.call("downloadFile",".ImportExcelServlet?fileName=" + fileName);
			}
		}
		
		/**
		 * 
		 */
		public function sendCmlTaskInfoMsg(msg:CmlTaskInfoMsg):void
		{
			trace("CmlTaskInfoPM.sendCmlTaskInfoMsg");
			msg.type = "CmlTaskInfoDelegate:com.grgbanking.sent.transmgr.service.CmlTaskInfoService";
			sendMessage(msg);
		}
	}
}