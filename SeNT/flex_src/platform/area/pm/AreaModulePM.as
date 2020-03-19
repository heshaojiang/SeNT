package platform.area.pm
{
	import mx.collections.ArrayCollection;
	
	import platform.area.message.AreaMsg;
	import platform.common.vo.Page;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.vo.area.AreaVo;
	
	public class AreaModulePM extends BasePM
	{
		[Bindable]
		public var treeXml:XMLList;
		
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var vo:AreaVo = new AreaVo();
		
		public var currentLevel:uint;
		
		[Init]
		public function initialed():void
		{
			loadAreaTree();
		}
		
		public function areaTreeItemClickHandler(p_item:XML):void
		{
			var selectedItem:XML = p_item;
			vo.id = selectedItem.@id;
			vo.areaName = selectedItem.@areaName;
			vo.level = selectedItem.@level;
			currentLevel = parseInt(vo.level) + 1;
			loadAreaPage();
		}
		
		/**
		 * load pageing infomation
		 * 
		 */		
		public function loadAreaPage():void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "getAreaPage";
			msg.args["page"] = page;
			msg.args["cond"] = vo.id;
			sendMessage(msg);
		}
		
		[MessageHandler(selector="getAreaPageResult")]
		public function getAreaPage(p_msg:AreaMsg):void
		{
			if(p_msg.result)
				page = p_msg.result as Page;
		}
		
		/**
		 * delete items
		 * @param p_ids
		 * 
		 */		
		public function batchDelete(p_ids:ArrayCollection):void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "batchDelete";
			msg.args["ids"] = p_ids;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = OperationConsts.DEL;
			sendMessage(msg);
		}
		[MessageHandler(selector="areaSaveSuccess")]
		public function deleteCallback(p_msg:AreaMsg):void
		{
			loadAreaTree();
			loadAreaPage();
		}
		
		/**
		 * load left tree
		 * 
		 */		
		public function loadAreaTree():void
		{
			//init menu tree data
			var msg:AreaMsg = new AreaMsg();
			msg.type = "getAreaTree";
			sendMessage(msg);
		}
		[MessageHandler(selector="getAreaTreeResult")]
		public function loadAreaTreeCallback(p_msg:AreaMsg):void
		{
			treeXml = new XMLList(p_msg.result as String);
		}
		
		/**
		 * refresh the layout when it add a new area is successed.
		 */		
		[MessageHandler(selector="refreshAreaList")]
		public function saveResultHandler(p_msg:AreaMsg):void
		{
			if (p_msg.result){
				loadAreaPage();
				loadAreaTree();
			}
		}
		
		/**
		 * 编辑顶级区域
		 * 
		 */		
		public function editTopArea():void
		{
			var msg:AreaMsg = new AreaMsg();
			msg.type = "getAreaById";
			msg.args["areaId"] = String(treeXml.@id);
			sendMessage(msg);
		}
	}
}