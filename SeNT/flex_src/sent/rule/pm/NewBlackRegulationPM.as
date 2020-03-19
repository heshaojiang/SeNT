package sent.rule.pm
{
	import platform.layer.BasePM;
	
	import sent.rule.message.NewBlackRegulationMsg;

	public class NewBlackRegulationPM extends BasePM
	{
		/**
		 * 待审核的黑名单条数
		 * */
		[Bindable]
		public var auditCount:int=0;
		
		/**
		 * 初始化后加载数据
		 */		
		[Init]
		public function init():void
		{
			loadAuditCount();
		}
		/**
		 * 初始化数据
		 * 
		 */		
		public function loadAuditCount():void
		{
			var msg:NewBlackRegulationMsg = new NewBlackRegulationMsg();
			msg.type = "getBlackRegulationCount";
			sendMessage(msg);
			
		}
		/**
		 *列表页返回的结果集 
		 */
		[MessageHandler(selector="getBlackRegulationCountResult")]
		public function getBlackRegulationCountResult(p_msg:NewBlackRegulationMsg):void
		{
			if(p_msg.result!=null){
				auditCount=p_msg.result as int;
			}
		}
		
		/**
		 * 刷新待审核的黑名单规则数量
		 */
		[MessageHandler(selector="refreshAuditCount")]
		public function getBlackRegulationAudit(p_msg:NewBlackRegulationMsg):void
		{
		  loadAuditCount();
		}
		
	}
}