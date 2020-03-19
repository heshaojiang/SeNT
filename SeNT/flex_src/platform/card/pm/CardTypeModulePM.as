package platform.card.pm
{
	import platform.card.message.CardTypeMsg;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.org.message.OrgMsg;

	/**
	 * 继承BasePM以获得sendMessage函数
	 **/
	public class CardTypeModulePM extends BasePM
	{
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		[Bindable]
		public var treeXml:XMLList;
		
		[Bindable]
		public var page:Page = new Page();
		
		/**搜索条件**/
		[Bindable]
		public var cond:Object = new Object();
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		[Init]
		public function init():void
		{
			loadOrgTree();
		}
		
		/**
		 * 点击机构树查询数据
		 * @param p_item
		 * 
		 */		
		public function orgTreeItemClickHandler(p_item:XML):void
		{
			cond.orgid = String(p_item.@id);
			loadCardTypePage();
		}
		
		/**
		 * Load card type
		 */
		public function loadCardTypePage():void
		{
			cond["userOrgid"] = UserInfoInit.userInfo["orgid"];
			
			var msg:CardTypeMsg = new CardTypeMsg();
			msg.type = "searchCardType";
			msg.args["page"] = page;
			msg.args["cond"] = cond;
			sendMessage(msg);
		}
		
		/**
		 * Batch delete card types
		 * 
		 */		
		public function delCardType(p_delItems:Array):void
		{
			var msg:CardTypeMsg = new CardTypeMsg();
			msg.type = "batchDelete";
			msg.args["ids"] = DataGridUtil.getPropertys("id", p_delItems).source;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = OperationConsts.DEL;
			sendMessage(msg);
		}
		
		/**
		 * 获取页结果集
		 */		
		[MessageHandler(selector="searchCardTypeResult")]
		public function getCardTypeHandler(p_msg:CardTypeMsg):void
		{
			page = p_msg.result as Page;
		}
		
		/**
		 * 创建卡类型
		 */		
		[MessageHandler(selector="saveCardTypeResult")]
		public function newCardTypeResult(p_msg:CardTypeMsg):void
		{
			if(p_msg.result)
				loadCardTypePage();
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
			//获取卡信息
			if(treeXml && treeXml.length() > 0){
				cond.orgid = String(XML(treeXml[0]).@id);
				loadCardTypePage();
			}
		}
		
		/**
		 * 同步子机构
		 * 
		 */		
		public function synchronizeSubOrg(operate:String):void
		{
			var msg:CardTypeMsg = new CardTypeMsg();
			msg.type = "sychronizeSubOrg";
			msg.args["orgId"] = cond.orgid;
			
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = operate;
			sendMessage(msg);
		}
		[MessageHandler(selector="sychronizeSubOrgResult")]
		public function sychronizeSubOrgResult(p_msg:CardTypeMsg):void
		{
			if(p_msg.result)
				loadCardTypePage();
		}
	}
}