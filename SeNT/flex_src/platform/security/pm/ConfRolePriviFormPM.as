package platform.security.pm
{
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectProxy;
	import mx.utils.ObjectUtil;
	
	import platform.component.renderer.CheckBoxHeaderRenderer;
	import platform.component.renderer.CheckBoxItemRenderer;
	import platform.layer.BasePM;
	import platform.security.message.RoleMsg;
	import platform.vo.security.RoleVo;
	
	public class ConfRolePriviFormPM extends BasePM
	{
		/**
		 * 所有生成的权限按钮列表
		 */		
		private var items:Array = [];
		public var checkBoxRows:Array = [];
		/**
		 * 
		 */		
//		[Bindable]
		public var treeXml:XMLList;
		
		/**
		 * 列表数据源
		 */		
		[Bindable]
		public var dataSource:ArrayCollection;
		
		/**
		 * 角色对象
		 */		
		private var _role:RoleVo;
		public function get role():RoleVo
		{
			return _role;
		}
		public function set role(value:RoleVo):void
		{
			_role = ObjectUtil.copy(value) as RoleVo;
			getRolePriviInfo();
		}
		
		/**
		 * 
		 * 
		 */		
		public function getRolePriviInfo():void
		{
			var msg:RoleMsg = new RoleMsg();
			msg.type = "getRolePriviInfo";
			msg.args["id"] = _role.id;
			sendMessage(msg);
		}
		[MessageHandler(selector="getRolePriviInfoResult")]
		public function getRolePriviInfoResult(p_msg:RoleMsg):void
		{
			treeXml = new XMLList(p_msg.result);
			
			items = [];
			checkBoxRows = [];
			dataSource = new ArrayCollection(analystData("", treeXml[0]));
			
			/**
			 * 分析数据
			 * 
			 */	
			function analystData(p_str:String, p_xl:XML):Array
			{
				var fullArr:Array = [];
				var xl:XMLList = p_xl.elements("node");
				for each(var xml:XML in xl){
					if(xml.hasComplexContent()){
						fullArr = fullArr.concat(analystData(p_str + " " + xml.@label, xml));
					}else{
						if(String(xml.@isButton) == "0"){
							var obj:Object = getRow(String(xml.@id), String(xml.@label), p_str);
							obj.dgSelected = String(xml.@selected) == "true" ? true : false;
							obj.parentId = xml.@parentId;
							fullArr.push(obj);
							continue;
						}else if(!items[xml.@parentId]){
							items[xml.@parentId] = new ArrayCollection();
							fullArr.push(getRow(String(xml.@parentId), String(xml.@parentName), 
								p_str, items[xml.@parentId] as ArrayCollection));
						}
						if(String(xml.@isButton) == "1"){
							var btn:Object = {};
							btn.id = String(xml.@id);
							btn.i18nName = String(xml.@label);
							btn.selected = String(xml.@selected) == "true" ? true : false;
							btn.parentId = String(xml.@parentId);
							items[xml.@parentId].addItem(new ObjectProxy(btn));
							if(!btn.selected)
								checkBoxRows[xml.@parentId].dgSelected = false;
						}
					}
				}
				return fullArr;
			}
			
			function getRow(p_id:String, p_name:String, p_path:String, p_btnList:ArrayCollection = null):ObjectProxy
			{
				var obj:Object = {};
				obj.id = p_id;
				obj.fullPath = p_path;
				obj.dgSelected = true;
				obj.moduleName = p_name;
				obj.privilegeBtns = p_btnList;
				checkBoxRows[p_id] = obj;
				return new ObjectProxy(obj);
			}
		}
		
		/**
		 * 点击全选按钮
		 * @param p_evt
		 * 
		 */		
		public function headerRelease(p_evt:Event):void
		{
			var target:CheckBoxHeaderRenderer = p_evt.target as CheckBoxHeaderRenderer;
			for each(var arrCol:ArrayCollection in items){
				if(!arrCol)continue;
				for(var i:int = 0;i < arrCol.length;i++){
					var obj:Object = arrCol.getItemAt(i);
					obj.selected = target.selected;
				}
			}
		}
		
		/**
		 * 多选框选中事件
		 * @param p_evt
		 * 
		 */		
		public function checkBoxChange(p_evt:Event):void
		{
			var target:CheckBoxItemRenderer = p_evt.target as CheckBoxItemRenderer;
			if(!items[target.data.id])return;
			var arrCol:ArrayCollection = items[target.data.id] as ArrayCollection;
			for(var i:int = 0;i < arrCol.length;i++){
				var obj:Object = arrCol.getItemAt(i);
				obj.selected = target.selected;
			}
		}
		
		/**
		 * 
		 * @param p_selectedItems
		 * 
		 */		
		public function save():void
		{
			var newPriviIds:Array = [];
//			for each (var node:XML in treeXml..node){
//				if (node.@selected == true)
//					newPriviIds.addItem(node.@id.toString());
//			}
			for each(var arrCol:ArrayCollection in items){
				if(!arrCol)continue;
				for(var i:int = 0;i < arrCol.length;i++){
					var obj:Object = arrCol.getItemAt(i);
					if(obj.selected){
						newPriviIds.push(obj.id);
						findParent(obj.parentId);
					}
				}
			}
			//无按钮的菜单
			for each(var item:Object in checkBoxRows){
				if(!item)continue;
				if(!item.privilegeBtns && item.dgSelected){
					newPriviIds.push(item.id);
					findParent(item.parentId);
				}
			}
			var msg:RoleMsg = new RoleMsg();
			msg.type = "configureRolePrivi";
			msg.args["id"] = _role.id;
			msg.args["priviIds"] = new ArrayCollection(newPriviIds);
			sendMessage(msg);
			
			function findParent(p_parentId:String):void
			{
				var xl:XMLList = XML(treeXml[0])..node.(@childId == p_parentId);
				if(xl.length() > 0){
					if(newPriviIds.indexOf(String(xl[0].@id)) < 0)
						newPriviIds.push(String(xl[0].@id));
					if(String(xl[0].@parentId) != "0")
						findParent(String(xl[0].@parentId));
				}
			}
		}
	}
}