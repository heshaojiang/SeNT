package sent.transmgr.pm
{
	
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	
	import platform.common.manager.LanguageManager;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.transmgr.message.CmlSentInfoMsg;
	import sent.transmgr.vo.CmlSentInfoVO;

	
	public class CmlSentInfoPM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var cmlImpSentPage:Page=new Page();
		
		[Bindable]
		public var oldName:String;
		
//		[Bindable]
//		public var cmlSentInfoVO:CmlSentInfoVO=new CmlSentInfoVO();
		
		//交易检索的时间范围参数
		[Bindable]
		public var days:String;
		
		[Bindable]
		public var dataProvider:ArrayCollection;
		
//		[Bindable]
//		public var cond:Object = new Object();
		
//		[Bindable]
//		public var condition:Object = new Object();
		
		/**
		 * 流转信息分页对象
		 * */
		[Bindable]
		public var cmlNoteflowPage:Page=new Page();
		
		/**
		 * 冠字号码对象
		 * */
		[Bindable]
		public var cmlSentVO:CmlSentInfoVO=new CmlSentInfoVO();
		
		[Bindable]
		public var fuzzyEnabled:Boolean;
		
		private var langMgr:LanguageManager = LanguageManager.getInstance();
		
		/** 
		 * 初始化参数
		 * */
		[Init]
		public function getInitParam():void
		{
			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
			msg.type="getInitCmlParamMap";
			sendMessage(msg);
		}
		
		/**
		 * 从参数中获得查询限制的天数
		 * */
		[MessageHandler(selector="getInitCmlParamMapResult")]
		public function getInitParamResultHandler(p_msg:CmlSentInfoMsg):void
		{
			if(p_msg)
			{
				days=p_msg.result as String;
			}
		}
		
		/**
		 * 查询出流转条码信息
		 * */
		public function loadCmlNoteFlowPage():void{
			var msg:CmlSentInfoMsg=new CmlSentInfoMsg();
			msg.type="findNoteflowInfosByBarCodeFlowNum";
			cmlNoteflowPage.pageSize=10;
			msg.args["page"]=cmlNoteflowPage;
			msg.args["barcodeFlowNum"]=cmlSentVO.barcodeFlowNum;
			sendMessage(msg);
		}
		
		
//		/**
//		 *根据交易id查询清分冠字号码列表
//		 */
//		//交易检索的时间控制在一天（参数配置中taransDay设置）以内的
//		private function endChange():void{
//			var day:int=int(days);
//			var starDate:Date=cond.startTime;//开始时间
//			var endDate:Date=cond.endTime;//结束时间
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
//		
//		
//		public function loadByCondition():void
//		{
//		
//			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
//			msg.type = "getCmlSentInfoPage";
//			msg.args["page"] = page;
//			if(!cmlSentInfoVO.pathcode){
//				var userPathCode:String=UserInfoInit.userInfo["orgPathCode"];
//				//msg.args["seriaNo"] = cond.seriaNo;
//				cmlSentInfoVO.pathcode=userPathCode;
//			}
//			
//			msg.args["cmlSentTaskInfo"]=cmlSentInfoVO;
//			msg.args["operatorId"]=cond.operatorId;
//			msg.args["startTime"] = DateFormatter.format(cond.startTime, "YYYY-MM-DD JJ:NN:SS");
//			msg.args["endTime"] = DateFormatter.format(cond.endTime, "YYYY-MM-DD JJ:NN:SS");
//			sendMessage(msg);
//			
//		}
//		/**
//		 * 加载列表
//		 * 
//		 */		
//		public function loadPage():void
//		{
//			//交易检索中，根据参数配置中day来限制查询的时间范围
//			
//			//冠字号码输入不得少于10位
//			/*var seriaNo:String=cmlSentInfoVO.seriaNo;*/
//			//交易检索中，根据参数配置中day来限制查询的时间范围
//			//输入时间和冠子号
//			/*if(cmlSentInfoVO.seriaNo!=null&&cmlSentInfoVO.seriaNo!=""&&cond.startTime!=null&&cond.startTime!="")
//				
//			{
//				if(cond.endTime==null)
//				{
//					cond.endTime=new Date();
//				}
//				var day:int=int(days);
//				var starDate:Date=cond.startTime;//开始时间
//				var endDate:Date=cond.endTime;//结束时间
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
//				else if(seriaNo.length!=10)
//				{
//					AlertHandler.alert("seriaNoNotice");
//					
//				}
//				else{
//					loadByCondition();
//				}
//			}
//				//只有时间条件查询
//			else if(cond.startTime!=null&&cond.startTime!=""){
//				if(cond.endTime==null){
//					cond.endTime=new Date();
//				}
//				endChange();
//			}
//				//输入冠子号码的查询
//			else if(cmlSentInfoVO.seriaNo!=null&&cmlSentInfoVO.seriaNo!=""){
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
//				
//				//不输入任何条件的默认查询
//			else{
//				loadByCondition();
//			}
//			*/
//			
//		}
		
		[MessageHandler(selector="getCmlSentInfoPageResult")]
		public function getCmlSentInfoPageResult(p_msg:CmlSentInfoMsg):void
		{
			/*if(p_msg)
				page = p_msg.result as Page;*/ 
			/*if(cmlSentTaskInfoVO.seriaNo!=null && cmlSentTaskInfoVO.seriaNo!="" && page.totalCount==0) 
			{
			AlertHandler.alert("noSeriaNo");
			}
			if(cond.startTime!=null && cond.startTime!="" && page.totalCount==0)
			{
			AlertHandler.alert("noTransData");
			}*/
			
		}
		
		/**
		 * 查看文件是否已经存在
		 */
		public function checkFile(oldName:String):void
		{
			trace("CmlSentInfoPM.checkFile");
			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
			msg.type = "checkFileisExists";
			msg.args["oldName"] = oldName;
			sendMessage(msg);
		}
		
		/**
		 * 解析文件
		 * */
		public function importExcelToCmlImpRecords(data:ByteArray,oldName:String,termType:String,pathCode:String):void{
			var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
			msg.type = "importExcelForCML";
			msg.args["data"]=data;
			msg.args["oldName"] = oldName;
			msg.args["termType"] = termType;
			msg.args["pathcode"]=pathCode;
			sendMessage(msg);
		}
		
		/**
		 * 加载导入的文件信息
		 * 
		 */
		 public function loadImpPage():void{
			 var msg:CmlSentInfoMsg=new CmlSentInfoMsg();
			 cmlImpSentPage.pageSize=10;
			 msg.args["page"]=cmlImpSentPage;
			 msg.type="loadCmlImp";
			 sendMessage(msg);
		 }
		 
		 
		 /**
		  *
		  */
		 public function getCmlSentInfosPageByFlowNum(barcodeFlowNum:String, page:Page):void
		 {
			 trace("CmlSentInfoPM.getCmlSentInfosPageByFlowNum");
			 var msg:CmlSentInfoMsg = new CmlSentInfoMsg();
			 msg.type = "getCmlSentInfosPageByFlowNum";	// java: "getCmlSentInfosPageByFlowNum", result: "getCmlSentInfosPageByFlowNumResult"
			 msg.args["page"] = page;
			 msg.args["barcodeFlowNum"] = barcodeFlowNum;
			 sendMessage(msg); 
		 }
		 
		 
		 public function sendCmlSentInfoMsg(msg:CmlSentInfoMsg):void
		 {
			 msg.type = "CmlSentInfoDelegate:com.grgbanking.sent.transmgr.service.CmlSentInfoService";
			 sendMessage(msg);
		 }
	}
}





