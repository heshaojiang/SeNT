package platform.card.pm
{
	import mx.utils.ObjectUtil;
	
	import platform.card.message.CardTypeMsg;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.vo.card.CardTypeVo;

	/**
	 * 继承BasePM以获得sendMessage函数
	 **/
	public class CardTypeFormPM extends BasePM
	{
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/	
		/**Card Type VO**/
		[Bindable]
		public var cardType:CardTypeVo = new CardTypeVo();
		
		/**原来的VO**/
		private var formerVO:CardTypeVo;
		
		public function set vo(p_vo:CardTypeVo):void
		{
			formerVO = p_vo;
			cardType = ObjectUtil.copy(p_vo) as CardTypeVo;
		}
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		/**
		 * Reset Form
		 */
		public function reset():void
		{
			cardType = ObjectUtil.copy(formerVO) as CardTypeVo;
		}
		
		/**
		 * New Card Type
		 */
		public function save():void
		{
			var msg:CardTypeMsg = new CardTypeMsg();
			if(!cardType.id){
				msg.type = "saveCardType";
				msg.operate = OperationConsts.ADD;
			}else{
				msg.type = "updateCardType";
				msg.operate = OperationConsts.EDIT;
			}
			msg.args["data"] = cardType;
			msg.logFlag = true;
			msg.menuId = this.menuId;
			sendMessage(msg);
		}
		
		/**
		 * cancel function
		 * 
		 */		
		public function cancel():void
		{
			formerVO.dgSelected = false;
		}
	}
}