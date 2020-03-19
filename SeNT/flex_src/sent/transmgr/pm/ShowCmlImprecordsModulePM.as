package sent.transmgr.pm
{
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.transmgr.message.ShowCmlImprecordsMsg;
	import sent.transmgr.vo.CmlImpRecordsVO;
	import sent.transmgr.vo.CmlImprecordsDetailVO;

	public class ShowCmlImprecordsModulePM extends BasePM
	{
		
//		/**原来的VO**/
//		public var formerVO:CmlImprecordsVO;
		
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var impPage:Page = new Page();
		
		public var userPathCode:String;
		
		[Bindable]
		public var newVO:CmlImpRecordsVO = new CmlImpRecordsVO();
		
//		[Bindable]
//		public var cmlImpVO:CmlImprecordsVO=new CmlImprecordsVO();
		
		[Bindable]
		public var cond:Object = new Object();
		
//		[Bindable]
//		public var isUpload:Boolean=false;
		
		[Bindable]
		public var cmlImpDetail:CmlImprecordsDetailVO=new CmlImprecordsDetailVO();
		/**
		 * 文件名称
		 * */
		[Bindable]
		public var oldName:String;
		
//		/**
//		 * 清分冠子号码文件上传的记录数
//		 */
//		[Bindable]
//		public var isShow:Boolean;
		
		
//		public function set vo(p_vo:CmlImprecordsVO):void
//		{
//			formerVO = p_vo;
//			cmlImpVO = ObjectUtil.copy(p_vo) as CmlImprecordsVO;
//			
//		}
		
//		/**
//		 * 分页显示导入的冠字号码信息
//		 */
//		public  function loadImprecordsPage():void
//		{
//			//根据交易冠字号显示
//			var seqMsg:ShowCmlImprecordsMsg = new ShowCmlImprecordsMsg();
//			seqMsg.type = "impfindCmlSentInfo";
//			//impPage.pageSize = 10;
//			seqMsg.args["page"] = impPage;
//			seqMsg.args["vo"] = cmlImpDetail;
//			sendMessage(seqMsg);  
//		} 
//		
//		/**
//		 * 重置表单
//		 */		
//		public function reset():void
//		{
//			cmlImpVO = ObjectUtil.copy(formerVO) as CmlImprecordsVO;
//		}
//	
//		
//		/**
//		 * 加载清分冠字号码导入信息
//		 */
//		public function loadPage():void
//		{
//			userPathCode = UserInfoInit.userInfo["orgPathCode"]
//			var msg:ShowCmlImprecordsMsg = new ShowCmlImprecordsMsg();
//			msg.type = "getCmlImprecordsInfoPage";
//			msg.args["page"] = page;
//			msg.args["vo"] = newVO;
//			msg.args["startTime"] = DateFormatter.format(cond.startTime, "YYYY-MM-DD JJ:NN:SS");
//			msg.args["endTime"] = DateFormatter.format(cond.endTime, "YYYY-MM-DD JJ:NN:SS");
//			sendMessage(msg);
//		}
		
		/**
		 * 清分冠字号码导入信息返回的结果集
		 */
		[MessageHandler(selector="getCmlImprecordsInfoPageResult")]
		public function getCmlImprecordsPageResult(p_msg:ShowCmlImprecordsMsg):void
		{
			trace("ShowCmlImprecordModulePM.getCmlImprecordsPageResult");
			if(p_msg)
			{
				page = p_msg.result as Page; 
//				for(var i:int=0;i<page.totalCount;i++)
//				{
//					var cmlImp:CmlImprecordsVO = new CmlImprecordsVO();
//					cmlImp = page.result[i];
//					if(cmlImp.resovimpRecords>0)
//					{
//						isShow=true;
//					}
//					else
//					{
//						isShow=false;
//					}
//		  		}
		  	}
		}
	}
}