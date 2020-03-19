package cml.cmlConnectInfos.pm
{
	import cml.cmlConnectInfos.message.CmlConnectInfosMsg;
	import cml.cmlConnectInfos.vo.CmlConnectInfosVO;
	
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;

	public class CmlConnectInfosModulePM extends BasePM
	{
		[Bindable]
		public var page:Page = new Page();
		[Bindable]
		public var cmlConnectInfos:CmlConnectInfosVO=new CmlConnectInfosVO();
		/**
		 * 是否被分配任务
		 * */
		[Bindable]
		public var isOfered:Boolean;
	
		[Bindable]
		public var userName:String;
		[Bindable]
		public var cond:Object = new Object();
		/**
		 * 初始化后加载数据
		 */		
		[Init]
		public function init():void
		{
			loadPage();
		}
		/*public funciton transUser():void
		{
			 	var msg:CmlConnectInfosMsg=new CmlConnectInfosMsg();
			msg.type="getUserNameByUserCode";
			msg.args["userCode"]=vo.inPerson;
			sendMessage(msg);
			if(pm.userName)
			{
			vo.inPerson=pm.userName;
			
			} 
		}*/
		/**
		 * 加载列表页
		 * 
		 */		
		public function loadPage():void
		{
			var msg:CmlConnectInfosMsg = new CmlConnectInfosMsg();
			msg.type = "getCmlConnectInfosPage";
		    msg.args["startTime"]=cond.startTime;
		    msg.args["endTime"]=cond.endTime;
			msg.args["vo"]=cmlConnectInfos;
			msg.args["page"]=page;
			sendMessage(msg);
			
		}
		/**
		 *列表页返回的结果集 
		 */
		[MessageHandler(selector="getCmlConnectInfosPageResult")]
		public function getCmlConnectInfosResult(p_msg:CmlConnectInfosMsg):void
		{
			if(p_msg)
			{
				for(var i:int=0;i<page.totalCount;i++)
				{
					var cmlConn:CmlConnectInfosVO=new CmlConnectInfosVO();
					cmlConn=page.result[i];
				/*	var msg:CmlConnectInfosMsg=new CmlConnectInfosMsg();
					msg.type="getUserNameByUserCode";
					msg.args["userCode"]=cmlConn.inPerson;
					sendMessage(msg);
					if(userName)
					{
						page.result[i].inPerson=userName;
					}*/
					if(cmlConn.flag=="0")
					{
						isOfered=true;
					}
					else
					{
						isOfered=false;	 
					}
				
				}
				page = p_msg.result as Page;
			}
		}
		
		/**
		 * 删除特殊规则 
		 */
		
		public function delCmlConnectInfos(p_delItems:Array):void
		{
			if(p_delItems.length <= 0){
				AlertHandler.alert(LocaleConsts.NO_SELECTED_RECORD);
				return;
			}
			AlertHandler.confirm(closeHandler,null,LocaleConsts.CONFIRM_DELETE);
		
     	  function closeHandler(evt:CloseEvent):void
			{
				if (evt.detail == Alert.YES){
					var msg:CmlConnectInfosMsg= new CmlConnectInfosMsg();
					msg.type = "deleteCmlConnectInfosObject";
					msg.args["ids"] = DataGridUtil.getPropertys("id", p_delItems).source;
					//记录日志
					msg.logFlag = true;
					msg.menuId = menuId;
					msg.operate = OperationConsts.DEL;
					sendMessage(msg);
				}
			}
		
		}
		/**
		 * 新增返回的结果
		 */
		
		[MessageHandler(selector="addCmlConnectInfosObjectSuccess")]
		public function newCmlConnectInfosResult(p_msg:CmlConnectInfosMsg):void
		{
			if(p_msg.result)
				init();
		}
		
		/**
		 * 修改返回的结果
		 */
		
		[MessageHandler(selector="updateCmlConnectInfosObjectSuccess")]
		public function editCmlConnectInfosResult(p_msg:CmlConnectInfosMsg):void
		{
			if(p_msg.result)
				init();
		}
		
		/**
		 * 删除返回的结果
		 */
		
		[MessageHandler(selector="deleteCmlConnectInfosSuccess")]
		public function delCmlConnectInfosResult(p_msg:CmlConnectInfosMsg):void
		{
			if(p_msg)
			init();
		}
		
	
		
		/*[MessageHandler(selector="getUserNameByUserCodeResult")]
		public function getUserNameByUserCodeResult(p_msg:CmlConnectInfosMsg):void
		{
			if(p_msg)
				userName=p_msg.result[0] as String;
		}*/
		
	}
}
