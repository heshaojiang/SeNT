package sent.transmgr.pm
{
	import mx.controls.Alert;
	import mx.utils.ObjectUtil;
	
	import platform.common.manager.AlertHandler;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	
	import sent.common.utils.DateUtils;
	import sent.transmgr.constants.CmlInfoByHandConsts;
	import sent.transmgr.message.CmlInfoByHandMsg;
	import sent.transmgr.vo.CmlInfoByHandVO;

	public class CmlInfoByHandFormPM extends BasePM
	{
		/**父页面VO**/
		[Bindable]
		public var superVO:CmlInfoByHandVO = new CmlInfoByHandVO();
		
		/**子页面VO**/
		[Bindable]
		public var childrenVO:CmlInfoByHandVO = new CmlInfoByHandVO();
		
		/**翻页信息**/
		[Bindable]
		public var page:Page = new Page();
		
		[Bindable]
		public var conditions:Object = new Object();
		
	
		
		
		/**
		 * 将父窗体的值对象传递到子窗体 
		 */
		public function set vo(p_vo:CmlInfoByHandVO):void
		{
			superVO = p_vo;
			childrenVO = ObjectUtil.copy(p_vo) as CmlInfoByHandVO;
		}
		
		/**
		 * 保存信息的请求
		 * @param p_formType
		 * 
		 */
		public function save(p_formType:int):void
		{
			var msg:CmlInfoByHandMsg = new CmlInfoByHandMsg();
			msg.type = "saveCmlInfoByHand";
			msg.args["cmlInfoByHand"] = childrenVO;
		
			msg.args["pathCode"] = conditions["pathCode"];
			msg.args["formType"] = p_formType;
			sendMessage(msg);
		}
	}
}