package sent.transmgr.pm
{
	
	
	import mx.formatters.DateFormatter;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.LanguageManager;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.transmgr.message.CmlNoteflowInfoMsg;
	import sent.transmgr.message.TransInfoMsg;
	import sent.transmgr.vo.CmlNoteflowInfoVO;
	
	public class CmlNoteflowInfoPM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		
//		//交易检索的时间范围参数
//		[Bindable]
//		public var days:String;
//		
//		[Bindable]
//		private var cmlNoteflowInfo:CmlNoteflowInfoVO;
		
		[Bindable]
		public var condition:Object = new Object();
		
//		private var langMgr:LanguageManager = LanguageManager.getInstance();
//		
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
//		
//		/**
//		 * 从参数中获得查询限制的天数
//		 */
//		[MessageHandler(selector="getInitParamMapResult")]
//		public function getInitParamResultHandler(p_msg:TransInfoMsg):void
//		{
//			if(p_msg){
//			
//				days = p_msg.result as String;
//			}
//		}
		
		/**
		 * 
		 */
		public function getCmlNoteflowInfoPage():void
		{
			var msg:CmlNoteflowInfoMsg = new CmlNoteflowInfoMsg();
			msg.type = "getCmlNoteflowInfoPage";
			msg.args["page"]            = page;
			msg.args["condition"]       = condition;
			sendMessage(msg);
		}
		
		/**
		 * 交易检索返回的结果集
		 * */
		[MessageHandler(selector="getCmlNoteflowInfoPageResult")]
		public function getCmlNoteflowInfoPageResult(p_msg:CmlNoteflowInfoMsg):void
		{
			if(p_msg)
			{
				page = p_msg.result as Page;
			}
		}
		
		/**
		 * 
		 */
		public function sendCmlNoteflowInfoMsg(msg:CmlNoteflowInfoMsg):void
		{
			msg.type = "CmlNoteflowInfoDelegate:com.grgbanking.sent.transmgr.service.CmlNoteflowInfoService";
			sendMessage(msg);
		}
	}
}