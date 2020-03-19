package sent.transmgr.pm
{
	
	
	import mx.formatters.DateFormatter;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.LanguageManager;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	import platform.common.util.StringUtil;
	import platform.common.manager.AlertHandler;
	
	import sent.transmgr.message.CmlNoteflowInfoMgrMsg;
	import sent.transmgr.message.TransInfoMsg;
	import sent.transmgr.vo.CmlNoteflowInfoMgrVO;
	
	public class CmlNoteflowInfoMgrPM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		//交易检索的时间范围参数
		[Bindable]
		public var days:String;
		//[Bindable]
		//public var transInfo:TransInfoVO;
		[Bindable]
		public var cmlNoteflowInfo:CmlNoteflowInfoMgrVO;
//		[Bindable]
//		public var id:String;
//		[Bindable]
//		public var tranvo:TransInfoVO=new TransInfoVO();
		
		[Bindable]
		public var condition:Object = new Object();
		
//		//判断时间是否符合要求
//		[Bindable]
//		public var flag:Boolean=false;
		
		private var langMgr:LanguageManager = LanguageManager.getInstance();
//		[Bindable]
//		public var tranPage:Page=new Page();
//		[Bindable]
//		public var hoursPage:Page=new Page();
//		[Bindable]
//		public var tranId:String;
//		[Bindable]
//		public var transVO:TransBanknoteSeqInfoVO=new TransBanknoteSeqInfoVO();
//		[Bindable]
//		public var transHourVo:TransHourInfoVO=new TransHourInfoVO();
//		/**
//		 * 冠字号码分页
//		 */
//		[Bindable]
//		public var transPage:Page=new Page();
//		
//		/**
//		 * 交易检索查看冠字号码信息
//		 * */
//		public function loadTransBank():void
//		{
//			var msg:TransInfoMsg = new TransInfoMsg();
//			msg.type = "getTransBanknoteSeqByTranId";
//			tranPage.pageSize=10;
//			msg.args["page"]=tranPage;
//			msg.args["id"] = id;
//			msg.args["transYear"]=tranvo.transYear;
//			msg.args["tranMonthDay"]=tranvo.tranMonthDay;
//			sendMessage(msg);
//		}
		
		/** 
		 * 初始化参数
		 */
		[Init]
		public function getInitParam():void
		{
			var msg:TransInfoMsg = new TransInfoMsg();
			msg.type = "getInitParamMap";
			sendMessage(msg);
		}
		
		/**
		 * 从参数中获得查询限制的天数
		 */
		[MessageHandler(selector="getInitParamMapResult")]
		public function getInitParamResultHandler(p_msg:TransInfoMsg):void
		{
			if(p_msg){
			
				days = p_msg.result as String;
			}
		}
				
	
		/**
		 * 获取交易检索列表信息
		 */
		//public function getTransInfoPage():void
		public function getCmlNoteflowInfoMgrPage():void
		{
			
			var msg:CmlNoteflowInfoMgrMsg = new CmlNoteflowInfoMgrMsg();
			msg.type = "getCmlNoteflowInfoMgrPage";			// java: "getCmlNoteflowInfoMgrPage", result: "getCmlNoteflowInfoMgrPageResult"
			msg.args["page"]            = page;
			msg.args["condition"]       = condition;
			sendMessage(msg);
			
		}
		
		public function sendCmlNoteflowInfoMgrMsg(p_msg:CmlNoteflowInfoMgrMsg):void
		{
			p_msg.type = "CmlNoteflowInfoMgrDelegate:com.grgbanking.sent.transmgr.service.CmlNoteflowInfoMgrService";
			sendMessage(p_msg);
		}
		
	}
}