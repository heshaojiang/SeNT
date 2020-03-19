package sent.rule.pm
{
	import platform.layer.BasePM;
	
	import sent.rule.message.NewRepeatRegulationMsg;

	public class NewRepeatRegulationPM extends BasePM
	{
		/**
		 * 待审核的黑名单条数
		 * */
		[Bindable]
		public var auditCount:int=0;
		
		/**
		 * 待下发的黑名单条数
		 * */
		[Bindable]
		public var reliverCount:int=0;
		
		/**
		 * 初始化后加载数据
		 */		
		[Init]
		public function init():void
		{
			loadAuditCount();
			loadDeliverCount();
		}
		/**
		 * 初始化数据
		 * 
		 */		
		public function loadAuditCount():void
		{
			var msg:NewRepeatRegulationMsg = new NewRepeatRegulationMsg();
			msg.type = "getRepeatRegulationCount";
			sendMessage(msg);
			
		}
		/**
		 *列表页返回的结果集 
		 */
		[MessageHandler(selector="getRepeatRegulationCountResult")]
		public function getRepeatRegulationCountResult(p_msg:NewRepeatRegulationMsg):void
		{
			if(p_msg.result!=null){
				
				auditCount=p_msg.result as int;
			}
		}
		
		/**
		 * 初始化数据
		 * 
		 */		
		public function loadDeliverCount():void
		{
			var msg:NewRepeatRegulationMsg = new NewRepeatRegulationMsg();
			msg.type = "reliverRepeatRegulationCount";
			sendMessage(msg);
			
		}
		/**
		 *初始化黑名单规则下发的数量
		 */
		[MessageHandler(selector="reliverRepeatRegulationCountResult")]
		public function getRepeatRegulationDeliverResult(p_msg:NewRepeatRegulationMsg):void
		{
			if(p_msg.result!=null)
				reliverCount=p_msg.result as int;
		}
		
		/**
		 * 刷新待审核的黑名单规则数量
		 */
		[MessageHandler(selector="refreshRepeatAuditCount")]
		public function getRepeatRegulationAudit(p_msg:NewRepeatRegulationMsg):void
		{
			loadAuditCount();
		}
		
		/**
		 * 刷新待下发的黑名单规则数量
		 */
		[MessageHandler(selector="refreshRepeatDeliverCount")]
		public function getRepeatRegulationDeliver(p_msg:NewRepeatRegulationMsg):void
		{
			loadDeliverCount();
		}
	  }
	}
