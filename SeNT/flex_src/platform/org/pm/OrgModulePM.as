package platform.org.pm
{
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	
	import platform.common.manager.AlertHandler;
	import platform.common.manager.LanguageManager;
	import platform.common.vo.Page;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.org.message.OrgMsg;
	import platform.vo.org.OrgVo;
	import mx.utils.ObjectUtil;
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	
	public class OrgModulePM extends BasePM
	{
		[Bindable]
		public var treeXml:XMLList;
		
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var vo:OrgVo = new OrgVo();
		
		public var currentLevel:uint;
		
		[Init]
		public function initialed():void
		{
			loadOrgTree();
		}
		
		public function orgTreeItemClickHandler(p_item:XML):void
		{
			var selectedItem:XML = p_item;
			vo.id = selectedItem.@id;
			vo.orgName = selectedItem.@orgName;
			vo.level = selectedItem.@level;
			currentLevel = parseInt(vo.level) + 1;
			loadOrgPage();
		}
		
		/**
		 * load pageing infomation
		 * 
		 */		
		public function loadOrgPage():void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "getOrgPage";
			msg.args["page"] = page;
			msg.args["cond"] = vo.id ? vo.id : "-1";
			sendMessage(msg);
		}
		
		[MessageHandler(selector="getOrgPageResult")]
		public function getOrgPage(p_msg:OrgMsg):void
		{
			if(p_msg.result)
				page = p_msg.result as Page;
		}
		
		/**
		 * delete items
		 * @param p_ids
		 */		
		public function batchDelete(p_ids:ArrayCollection):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "batchDelete";	// java: deleteSelected, result: orgSaveSuccess
			msg.args["ids"] = p_ids;
			
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = OperationConsts.DEL;
			sendMessage(msg);
		}
		[MessageHandler(selector="orgSaveSuccess")]
		public function deleteCallback(p_msg:OrgMsg):void
		{
			loadOrgTree();
			loadOrgPage();
		}
		
		/**
		 * load left tree
		 * 
		 */		
		public function loadOrgTree():void
		{
			//init menu tree data
			var msg:OrgMsg = new OrgMsg();
			msg.type = "getOrgTree";
			sendMessage(msg);
		}
		[MessageHandler(selector="getOrgTreeResult")]
		public function loadorgTreeCallback(p_msg:OrgMsg):void
		{
			treeXml = new XMLList(p_msg.result as String);
		}
		
		/**
		 * refresh the layout when it add a new org successed.
		 */		
		[MessageHandler(selector="newOrgResult")]
		public function saveResultHandler(p_msg:OrgMsg):void
		{
			if (p_msg.result){
				loadOrgPage();
				loadOrgTree();
			}
		}
		
		///////////////////////////
		
		/**
		 * 导入Excel
		 * @param p_fileData
		 */		
		public function importOrgInfoExcel(p_fileData:ByteArray):void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "importOrgInfoExcel";	// java: importOrgInfoExcel, result: importOrgInfoExcelResult
			msg.args["bytes"] = p_fileData;
			sendMessage(msg);
		}
		
		/**
		 * refresh the layout if it was completed of import some org.
		 */		
		[MessageHandler(selector="importOrgInfoExcelResult")]
		public function importExcelResultHandler(p_msg:OrgMsg):void
		{
			var msg:String = "";
			
			if (p_msg.result){
				msg = LanguageManager.getInstance().getCommonLocleValue("Msg", "importFail").toString();
			}else{
				msg = LanguageManager.getInstance().getCommonLocleValue("Msg", "importSuccess").toString();
			}
			
			AlertHandler.alert(msg + p_msg.result.toString());
			loadOrgPage();
			loadOrgTree();
		}
		
		/////////////////////
		
		/**
		 * 编辑顶级机构
		 * 
		 */		
		public function editTopOrg():void
		{
			var msg:OrgMsg = new OrgMsg();
			msg.type = "getOrgById";
			msg.args["orgId"] = String(treeXml.@id);
			sendMessage(msg);
		}
		
		
	}
}