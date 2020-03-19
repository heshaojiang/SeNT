package sent.transmgr.pm
{
	import flexlib.scheduling.samples.AlternatingHorizontalLinesViewer;
	
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.manager.AlertHandler;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.transmgr.message.CmlNoteflowMsg;
	import sent.transmgr.vo.CmlImprecordsVO;
	import sent.transmgr.vo.CmlNoteflowDetailVO;
	import sent.transmgr.vo.CmlTaskInfoVO;

	public class CmlNoteflowModulePM extends BasePM
	{
		
		/**原来的VO**/
		public var formerVO:CmlNoteflowDetailVO;
		[Bindable]
		public var page:Page = new Page();
		public var userPathCode:String;
		
		[Bindable]
		public var cmlImpVO:CmlNoteflowDetailVO=new CmlNoteflowDetailVO();
		[Bindable]
		public var cond:Object = new Object();
		[Bindable]
		public var tranId:String;
		[Bindable]
		public var obj:CmlNoteflowDetailVO=new CmlNoteflowDetailVO();
		[Bindable]
		public var tranPage:Page=new Page();
		[Bindable]
		public var obj1:CmlTaskInfoVO=new CmlTaskInfoVO();
		/**
		 * 数据类型
		 * */
		[Bindable]
		public var seriaimg:String;
	
		public function set vo(p_vo:CmlNoteflowDetailVO):void
		{
			formerVO = p_vo;
			cmlImpVO = ObjectUtil.copy(p_vo) as CmlNoteflowDetailVO;
			
		}
		
		/**
		 * 重置表单
		 * 
		 */		
		
		public function reset():void
		{
			cmlImpVO = ObjectUtil.copy(formerVO) as CmlNoteflowDetailVO;
		}
		
//		/**
//		 *查看交易对应的冠字号码 
//		 **/
//		public function loadTransBankNotePage():void
//		{
//			var msg:CmlNoteflowMsg = new CmlNoteflowMsg();
//			msg.type ="getCmlSentInfosPageByTranId";
//			tranPage.pageSize=10;
//			msg.args["page"]=tranPage;
//			msg.args["vo"]=obj;
//			sendMessage(msg); 
//		}
		
		/**
		 * 保存数据
		 * */
		public function save(atmNum:String , cashNo1:String , cashNo2:String, cashNo3:String, cashNo4:String, operator:String,pathCode:String):void
		{
			var msg:CmlNoteflowMsg=new CmlNoteflowMsg();
			msg.type="addCmlNoteflow";
			obj.barcode2 = atmNum ;
			obj.operator = operator ;
			obj.pathCode = pathCode ;
			obj.date = (String)(DateFormatter.format(new Date(), "YYYYMMDD JJNNSS"));
			msg.args["cmlCmlNoteflow"]=obj;
			msg.args["cashNo1"] = cashNo1 ;
			msg.args["cashNo2"] = cashNo2 ;
			msg.args["cashNo3"] = cashNo3 ;
			msg.args["cashNo4"] = cashNo4 ;
			sendMessage(msg);
		}
		/**
		 * 加载清分冠字号码导入信息
		 */
		public function loadPage():void
		{
			trace("CmlNoteflowMOdulePM.loadPage");
			var msg:CmlNoteflowMsg=new CmlNoteflowMsg();
			msg.type="getCmlNoteflowPage";
			msg.args["page"]=page;
			msg.args["vo"] = cmlImpVO ;
			msg.args["startTime"]=DateFormatter.format(cond.startTime, "YYYYMMDD JJNNSS");
			msg.args["endTime"] = DateFormatter.format(cond.endTime, "YYYYMMDD JJNNSS");
			//newVO.pathCode=userPathCode;
			sendMessage(msg);
		}
		
		[MessageHandler(selector="addCmlNoteflowSuccess")]
		public function addCmlNoteflowSuccess(p_msg:CmlNoteflowMsg):void 
		{
			if(p_msg) {
				
			}
		}
		/**
		 * 清分冠字号码导入信息返回的结果集
		 */
		[MessageHandler(selector="getCmlNoteflowPageResult")]
		public function getCmlNoteflowPageResult(p_msg:CmlNoteflowMsg):void
		{
			if(p_msg)
				page = p_msg.result as Page; 
		}
		
		
	/**
	 * 刷新主界面
	 * */
//		[MessageHandler(selector="refreshNoteflowPage")]
		public function refreshCmlNoteflowPageResult(p_msg:CmlNoteflowMsg):void
		{
			loadPage();
		}
	}
}