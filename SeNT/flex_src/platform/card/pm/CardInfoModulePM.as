package platform.card.pm
{
	import platform.card.message.CardInfoMsg;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;

	/**
	 * 继承BasePM以获得sendMessage函数
	 **/
	public class CardInfoModulePM extends BasePM
	{
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
				
		[Bindable]
		public var page:Page = new Page();
		/**搜索条件**/
		[Bindable]
		public var cond:String = "";
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		[Init]
		public function initComplete():void
		{
			searchCardInfo();
		}
		
		/**
		 * 
		 * 
		 */		
		public function searchCardInfo():void
		{
			page = new Page();
			searchCardInfoByPage();
		}
		
		/**
		 * Search card type
		 */
		public function searchCardInfoByPage():void
		{
			var msg:CardInfoMsg = new CardInfoMsg();
			msg.type = "searchCardInfo";
			msg.args["page"] = page;
			msg.args["cardId"] = cond;
			sendMessage(msg);
		}
		
		/**
		 * Batch delete card types
		 * 
		 */		
		public function delCardInfo(p_delItems:Array):void
		{
			var msg:CardInfoMsg = new CardInfoMsg();
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
		[MessageHandler(selector="searchCardInfoResult")]
		public function getCardInfoHandler(p_msg:CardInfoMsg):void
		{
			page = p_msg.result as Page;
		}
		
		/**
		 * 
		 */
		[MessageHandler(selector="cardInfoSaveSuccess")]
		public function newCardInfoResult(p_msg:CardInfoMsg):void
		{
			if(p_msg.result)
				searchCardInfo();
		}
	}
}