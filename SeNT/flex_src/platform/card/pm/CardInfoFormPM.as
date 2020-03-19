package platform.card.pm
{
	import mx.utils.ObjectUtil;
	
	import platform.card.message.CardInfoMsg;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.vo.card.CardInfoVo;

	/**
	 * 继承BasePM以获得sendMessage函数
	 **/
	
	public class CardInfoFormPM extends BasePM
	{
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		
		/**Card Type VO**/
		[Bindable]
		public var cardInfo:CardInfoVo = new CardInfoVo();
		
		/**原VO**/
		private var formerVo:CardInfoVo;
		
		public function set vo(p_vo:CardInfoVo):void
		{
			formerVo = p_vo;
			cardInfo = ObjectUtil.copy(p_vo) as CardInfoVo;
		}
		
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		/**
		 * Reset Form
		 */
		public function reset():void
		{
			cardInfo = ObjectUtil.copy(formerVo) as CardInfoVo;;
		}
		
		/**
		 * New Card Type
		 */
		public function save():void
		{
			var msg:CardInfoMsg = new CardInfoMsg();
			if(!cardInfo.id){
				msg.type = "newCardInfo";
				msg.operate = OperationConsts.ADD;
			}else{
				msg.type = "updateCardInfo";
				msg.operate = OperationConsts.EDIT;
			}
			msg.args["data"] = cardInfo;
			
			msg.logFlag = true;
			msg.menuId = this.menuId;
			
			sendMessage(msg);
		}
		
		/**
		 * 
		 * 
		 */		
		public function cancel():void
		{
			formerVo.dgSelected = false;
		}
	}
}