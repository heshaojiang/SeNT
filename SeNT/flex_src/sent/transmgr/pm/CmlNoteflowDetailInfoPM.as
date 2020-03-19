package sent.transmgr.pm
{
	
	
	import mx.events.CloseEvent;
	import mx.utils.ObjectUtil;
	
	import org.spicefactory.parsley.core.messaging.impl.Selector;
	import org.spicefactory.parsley.core.messaging.receiver.impl.MessageHandler;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.layer.BasePM;
	
	import sent.transmgr.message.CmlNoteflowDetailInfoMsg;
	import sent.transmgr.vo.CmlNoteflowDetailInfoVO;
	import sent.transmgr.vo.CmlNoteflowDetailVO;
	
	public class CmlNoteflowDetailInfoPM extends BasePM
	{
		
		[Bindable]
		public var cmlNoteflowDetailInfo:CmlNoteflowDetailInfoVO;
		
		////////////////////////
		
		[Bindable]
		public var condition:Object = new Object();
		
		[Bindable]
		public var page:Page = new Page();
		
		////////////////////////
		
		private var langMgr:LanguageManager = LanguageManager.getInstance();
		
		/**
		 * 
		 */
		public function getCmlNoteflowDetailInfosPageByFlowNum(noteflowDetailPage:Page, barcodeFlowNum:String):void
		{
			var msg:CmlNoteflowDetailInfoMsg = new CmlNoteflowDetailInfoMsg();
			msg.type = "getCmlNoteflowDetailInfosPageByFlowNum";	// java: "getCmlNoteflowDetailInfosPageByFlowNum", result: "getCmlNoteflowDetailInfosPageByFlowNumResult"
			msg.args["page"]            = noteflowDetailPage;
			msg.args["barcodeFlowNum"]  = barcodeFlowNum;
			sendMessage(msg);
		}
		
//		/**
//		 * 
//		 */
		public function queryCmlNoteflowDetailInfoPage(noteflowDetailPage:Page, condition:Object):void
		{
		    var msg:CmlNoteflowDetailInfoMsg = new CmlNoteflowDetailInfoMsg();
		     msg.type = "queryCmlNoteflowDetailInfoPage";
			msg.args["page"]       = noteflowDetailPage;
			msg.args["condition"]  = condition;
		   sendMessage(msg);
	}
		
		/**
		 * 
		 */
		public function sendCmlNoteflowDetailInfoMsg(msg:CmlNoteflowDetailInfoMsg):void
		{
			msg.type = "CmlNoteflowDetailInfoDelegate:com.grgbanking.sent.transmgr.service.CmlNoteflowDetailInfoService";
			sendMessage(msg);
		}
		
		////////////////////////
		
//		public function getCashBackInfo():void
//		{
//			var msg:CmlNoteflowDetailInfoMsg = new CmlNoteflowDetailInfoMsg();
//			msg.type = "getCashBackInfo";
//			condition.intime=DateFormatter.format(condition.intime, "YYYYMMDDJJNNSS");
//			condition.inendtime=DateFormatter.format(condition.inendtime, "YYYYMMDDJJNNSS");
//			msg.args["condition"] = condition;
//			msg.args["page"] = page;
//			sendMessage(msg);
//		}
//		
//		[MessageHandler(selector="getCashBackInfoResult")]
//		public function getCashBackInfoResult(msg:CmlNoteflowDetailInfoMsg):void
//		{
//			page = msg.result as Page;
//		}
//		
//		public function cashIn(intype:String,boxNum:String):void
//		{
//			var msg:CmlNoteflowDetailInfoMsg=new CmlNoteflowDetailInfoMsg();
//			msg.type = "cashIn";
//			msg.args["type"] = intype;
//			msg.args["condi"] = boxNum;
//			sendMessage(msg);
//		}
//		
//		public function getInfo(boxNum:String):void
//		{
//			var msg:CmlNoteflowDetailInfoMsg = new CmlNoteflowDetailInfoMsg();
//			msg.type = "getInfo";
//			msg.args["condi"] = boxNum;
//			sendMessage(msg);
//		}
		
		//////////////////////////////////
		
	}
}