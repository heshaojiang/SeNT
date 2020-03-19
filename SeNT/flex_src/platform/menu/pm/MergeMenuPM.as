package platform.menu.pm
{
	import mx.collections.ArrayCollection;
	import mx.collections.ICollectionView;
	import mx.collections.IList;
	import mx.collections.XMLListCollection;
	
	import platform.layer.BasePM;
	import platform.menu.message.MenuMsg;
	
	import spark.components.List;
	
	public class MergeMenuPM extends BasePM
	{
		/**本地索引**/
		private var currentIndex:uint = 0;
		/**有改动的菜单**/
		private var addedItems:Array = [];
		/**原菜单列表**/
		[Bindable]
		public var menuInfo:XMLListCollection;
		private var menuInfoBak:XMLListCollection;
		public function set menuInfoArray(p_xmlList:XMLList):void
		{
			menuInfo = new XMLListCollection(new XMLList(p_xmlList.toXMLString()));
			menuInfoBak = new XMLListCollection(new XMLList(p_xmlList.toXMLString()));
		}
		
		/**外部扩展菜单列表**/
		[Bindable]
		public var extendMenuInfo:XMLListCollection;
		private var extendMenuInfoBak:XMLListCollection;
		
		/**
		 * 
		 * 
		 */		
		public function init():void
		{
			currentIndex = 0;
			addedItems = [];
			getExtensionMenu();
		}
		
		/**
		 * 获取扩展菜单
		 * 
		 */		
		public function getExtensionMenu():void
		{
			var msg:MenuMsg = new MenuMsg();
			msg.type = "getExtensionMenu";
			sendMessage(msg);
		}
		[MessageHandler(selector="getExtensionMenuResult")]
		public function getExtensionMenuResult(p_msg:MenuMsg):void
		{
			extendMenuInfo = new XMLListCollection(new XMLList(p_msg.result));
			extendMenuInfoBak = new XMLListCollection(new XMLList(p_msg.result));
		}
		
		/**
		 * 记录拖动的选项
		 * @param p_evt
		 * 
		 */		
		public function recordDropItems(p_items:Array):void
		{
			for(var i:int = 0;i < p_items.length;i++){
				var xml:XML = XML(p_items[i]);
				if(xml && xml.parent())
					setIndex(xml, xml.parent().@id);
			}
			addedItems = addedItems.concat(p_items);
		}
		
		/**
		 * 创建本地索引
		 * @param p_xml
		 * @param p_parentId
		 * 
		 */		
		private function setIndex(p_xml:XML, p_parentId:String):void
		{
			currentIndex ++;
			p_xml.@newId = "C" + currentIndex;
			p_xml.@parentId = p_parentId;
			var xl:XMLList = p_xml.elements("node");
			if(xl.length() > 0){
				for each(var xml:XML in xl)
					setIndex(xml, p_xml.@newId);
			}
		}
		
		/**
		 * 提交更改
		 * 
		 */		
		public function submit():void
		{
			var msg:MenuMsg = new MenuMsg();
			msg.type = "mergeMenu";
			msg.args["xmlList"] = getAllItems(new ArrayCollection(addedItems));
			sendMessage(msg);
		}
		
		private function getAllItems(p_source:ICollectionView):Array
		{
			var arr:Array = [];
			for each(var xml:XML in p_source){
				arr.push({id:xml.@id + "", pid:xml.@parentId + "", nid:xml.@newId + ""});
				var xl:XMLList = xml.elements("node");
				if(xl.length() > 0)
					arr = arr.concat(getAllItems(new XMLListCollection(xl)));
			}
			return arr;
		}
		
		/**
		 * 重置
		 * 
		 */		
		public function reset():void
		{
			currentIndex = 0;
			addedItems = [];
			menuInfo = new XMLListCollection(new XMLList(menuInfoBak.source.toXMLString()));
			extendMenuInfo = new XMLListCollection(new XMLList(extendMenuInfoBak.source.toXMLString()));
		}
	}
}