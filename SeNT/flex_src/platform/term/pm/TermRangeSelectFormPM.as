package platform.term.pm
{
	import flash.utils.ByteArray;
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	import mx.utils.ObjectUtil;
	import mx.utils.StringUtil;
	import platform.common.manager.LanguageManager;
	import platform.common.manager.AlertHandler;
	import platform.common.util.DataGridUtil;
	import platform.common.vo.Page;
	import platform.constants.LocaleConsts;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.term.message.TermInfoMsg;
	
	
	/**
	 * 继承BasePM以获得sendMessage函数
	 * */
	public class TermRangeSelectFormPM extends BasePM
	{
		/*========================================================*/
		/*   Property                                             */
		/*========================================================*/
		
		/****/
		[Bindable]
		public var page:Page = new Page(); 			
		
		[Bindable]
		public var condi:Object = new Object();
		public var termidStr:String;
		public var suum:int;
		/*========================================================*/
		/*   Function                                             */
		/*========================================================*/
		
		[Bindable]
		public var termInfoFormInitDatas:Object = new Object();
		
		[Bindable]
		public var searchBarInitDatas:Object = new Object();
		
		[Init]
		public function init():void
		{
			//loadTermInfoPage();
			getTermInfoFormInitDatas();
		}
		
		/**批量获取下拉数据源**/
		public function getTermInfoFormInitDatas():void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoFormInitDatas";
			sendMessage(msg);
		}		
		/**
		 * 批量获取下拉数据源的回调函数
		 */		
		[MessageHandler(selector="getTermInfoFormInitDatasResult")]
		public function getTermInfoFormInitDatasBackHandler(p_msg:TermInfoMsg):void
		{
			var result:Object = p_msg.result;
			if(result != null){
				termInfoFormInitDatas = ObjectUtil.copy(p_msg.result) as Object;
				searchBarInitDatas = result;
			}
			sendInitDatasMsg();
		}
		
		
		public function sendInitDatasMsg():void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "sendInitDatasMsg";
			sendMessage(msg);
		}	
		
		/**
		 * delete dataDir
		 * */
		public function delTermInfo(p_delItems:Array):void
		{
			if (p_delItems.length <= 0){
				AlertHandler.alert(LocaleConsts.NO_SELECTED_RECORD);
				//AlertHandler.error("必须选择至少一项!!!");
				return;
			}
			AlertHandler.confirm(closeHandler, null, LocaleConsts.CONFIRM_DELETE);
			//close handler
			function closeHandler(evt:CloseEvent):void
			{
				if (evt.detail == Alert.YES){
					var msg:TermInfoMsg = new TermInfoMsg();
					msg.type = "delete";
					msg.args["ids"] = DataGridUtil.getPropertys("id", p_delItems);
					//记录日志
					msg.logFlag = true;
					msg.menuId = menuId;
					msg.operate = OperationConsts.DEL;
					sendMessage(msg);
				}
			}
		}
		
		public function getTermInfo(type:int):void
		{
			var termstr:String="";
			termstr = StringUtil.trim(termidStr);
			
			if (termstr!=null && termstr.length>0)
			{
				var pattern:RegExp = /[;\s]{1,}/g;				
				termstr=termstr.replace(pattern,",");
				pattern = /,{1,}/g; 
				termstr="'"+termstr.replace(pattern,"','")+"'";								
				
				condi.termCode=termstr;
				getTermInfoByTermid(type);
			}
			else
			{
				getTermInfoByParms();
			}
		}
		
		
		/**
		 *获取页结果集
		 */
		public function loadTermInfoPage():void
		{
			condi["userOrgid"] = UserInfoInit.userInfo["orgid"];
			
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoPage";
			msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		/**
		 * 获取页结果集回调函数
		 */
		[MessageHandler(selector="getTermInfoPageResult")]
		public function getPageHandler(p_msg:TermInfoMsg):void
		{
			page = p_msg.result as Page;
		}
		
		
		/**
		 *通过终端ID获取终端数据结果集
		 */
		public function getTermInfoByTermid(type:int):void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			if (type==0)
				msg.type = "getTermInfoByTermid";
			else
				msg.type = "getTermInfoBySelTermid";
			page.pageSize=2000;
			msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		/**
		 * 通过终端ID获取终端数据结果集回调函数
		 */
		[MessageHandler(selector="getTermInfoByTermidResult")]
		public function getByTermidHandler(p_msg:TermInfoMsg):void
		{
			page = p_msg.result as Page;
		}		
		
		
		/**
		 *通过下拉框选择条件获取终端数据结果集
		 */
		public function getTermInfoByParms():void
		{
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTermInfoByParams";
			page.pageSize=2000;
			msg.args["page"] = page;
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		/**
		 * 通过下拉框选择条件获取终端数据结果集回调函数
		 */
		[MessageHandler(selector="getTermInfoByParamsResult")]
		public function getByParmsHandler(p_msg:TermInfoMsg):void
		{
			page = p_msg.result as Page;
		}
		
		/**获取终端型号和设备类型下拉数据**/
		public function getTemTypeDatas(type:String):void
		{		
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTemTypeDatas";
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		[MessageHandler(selector="getTemTypeDatasResult")]
		public function getTemTypeDatasResult(p_msg:TermInfoMsg):void
		{
			searchBarInitDatas.typeList = p_msg.result;
		}
		/**获取设备类型下拉数据**/
		public function getTemModelDatas(model:String):void
		{
			
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTemModelDatas";
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		[MessageHandler(selector="getTemModelDatasResult")]
		public function getTemModelDatasResult(p_msg:TermInfoMsg):void
		{
			searchBarInitDatas.modelList = p_msg.result;
		}
		/**获取品牌下拉数据**/
		public function getTemBrandDatas(brand:String):void
		{
			
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTemBrandDatas";
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		[MessageHandler(selector="getTemBrandDatasResult")]
		public function getTemBrandDatasResult(p_msg:TermInfoMsg):void
		{
			searchBarInitDatas.brandList = p_msg.result;
		}
		/**获取品牌下拉数据**/
		public function getTemSumDatas():void
		{
			
			var msg:TermInfoMsg = new TermInfoMsg();
			msg.type = "getTemSumDatas";
			msg.args["condi"] = condi;
			sendMessage(msg);
		}
		[MessageHandler(selector="getTemSumDatasResult")]
		public function getTemSumDatasResult(p_msg:TermInfoMsg):void
		{
			//condi["sum"] = p_msg.result;
			suum = p_msg.result as int;
			
			//AlertHandler.alert(LanguageManager.getInstance().getCommonLocleValue("Msg","termSum").toString()+telnum.toString());
		
		}
	}
}
