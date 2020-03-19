package sent.transmgr.pm
{
	import mx.utils.ObjectUtil;
	
	import platform.common.formatter.DateFormatter;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.transmgr.message.CmlImprecordMsg;
	import sent.transmgr.vo.CmlImpRecordsVO;
	import sent.transmgr.vo.CmlImprecordsDetailVO;

	public class CmlImprecordModulePM extends BasePM
	{
		
		/**原来的VO**/
		public var formerVO:CmlImprecordsDetailVO;
		
		[Bindable]
		public var page:Page = new Page();
		
		public var userPathCode:String;
		
		[Bindable]
		public var newVO:CmlImpRecordsVO = new CmlImpRecordsVO();
		
		[Bindable]
		public var cmlImpVO:CmlImprecordsDetailVO = new CmlImprecordsDetailVO();
		
		[Bindable]
		public var cond:Object = new Object();
		
		//[Bindable]
		//public var isUpload:Boolean=false;
	
		public function set vo(p_vo:CmlImprecordsDetailVO):void
		{
			formerVO = p_vo;
			cmlImpVO = ObjectUtil.copy(p_vo) as CmlImprecordsDetailVO;
		}
		
		/**
		 * 重置表单
		 */		
		public function reset():void
		{
			cmlImpVO = ObjectUtil.copy(formerVO) as CmlImprecordsDetailVO;
		}
		
		
		/**
		 * 保存数据
		 * */
		public function addCmlImprecord(vo:CmlImprecordsDetailVO):void
		{
			trace("CmlImprecordModule.addCmlImprecord");
			var msg:CmlImprecordMsg = new CmlImprecordMsg();
			msg.type = "addCmlImprecord";	// java: "addCmlImprecord", result: "addCmlImprecordSuccess"
			msg.args["cmlImprecords"] = vo;
			sendMessage(msg);
		}
		
		
		/**
		 * 加载清分冠字号码导入信息
		 */
		public function loadPage():void
		{
			trace("CmlImprecordModulePM.loadPage");
			userPathCode = UserInfoInit.userInfo["orgPathCode"]
		
			var msg:CmlImprecordMsg = new CmlImprecordMsg();
			msg.type = "getCmlImprecoredsPage";		// java: "getCmlImprecoredsPage", result: "getCmlImprecoredsPageResult"
			msg.args["page"] = page;
			msg.args["vo"] = newVO;
			msg.args["startTime"] = DateFormatter.format(cond.startTime, "YYYY-MM-DD JJ:NN:SS");
			msg.args["endTime"] = DateFormatter.format(cond.endTime, "YYYY-MM-DD JJ:NN:SS");
			sendMessage(msg);
		}
		
		/**
		 * 清分冠字号码导入信息返回的结果集
		 */
		[MessageHandler(selector="getCmlImprecoredsPageResult")]
		public function getCmlImprecordsPageResult(p_msg:CmlImprecordMsg):void
		{
			trace("CmlImprecordModulePM.getCmlImprecordsPageResult");
			if(p_msg)
			{
				page = p_msg.result as Page;
			}
		}
		
		
	/**
	 * 刷新主界面
	 * */
		[MessageHandler(selector="refreshCmlImprecordsPage")]
		public function refreshCmlImprecordsPageResult(p_msg:CmlImprecordMsg):void
		{
			loadPage();
		}
		
		
		
		
		
		
		
		
		
	}
}