package platform.CashSerial.pm
{
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectProxy;
	import mx.utils.ObjectUtil;
	
	import platform.CashSerial.message.CashSerialToPBOCMsg;
	import platform.CashSerial.vo.CashSerialToPBOCVO;
	import platform.CashSerial.vo.SelectDayButtonVo;
	import platform.common.manager.AlertHandler;
	import platform.constants.OperationConsts;
	import platform.global.AppGlobal;
	import platform.layer.BasePM;
	import platform.security.message.UserMsg;

	public class CashSerialToPBOCFormPM extends BasePM
	{
		[Bindable]
		public var cashSerialToPBOCVO:CashSerialToPBOCVO;
		
		public var formerVO:CashSerialToPBOCVO; 
		
		[Bindable]
		public var extendProperties:ArrayCollection;
		
		public var privilegeBtns:ArrayCollection;
		
		
		/**
		 * 列表数据源
		 */		
		[Bindable]
		public var dataSource:ArrayCollection;
		
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
		
		public function set vo(p_vo:CashSerialToPBOCVO):void
		{
			SelectDayButtonVo;
			formerVO = p_vo;
			cashSerialToPBOCVO = ObjectUtil.copy(p_vo) as CashSerialToPBOCVO;
			loadSelectDay();
		}
		
		/**
		 * 加载菜单按钮
		 * 
		 */		
		public function loadSelectDay():void
		{
			var msg:CashSerialToPBOCMsg = new CashSerialToPBOCMsg();
			
			msg.type = "getSelectDay";
			msg.args["vo"] = cashSerialToPBOCVO;
			msg.logFlag = true;
			msg.menuId = menuId;
			msg.operate = OperationConsts.ADD;
			sendMessage(msg);
		}
		[MessageHandler(selector="getSelectDayResult")]
		public function getSelectDayResult(p_msg:CashSerialToPBOCMsg):void
		{
		
			if (p_msg.result)
				cashSerialToPBOCVO.dayBtns = p_msg.result as ArrayCollection;
		}
		
		/**
		 * 保存角色
		 * 
		 */		
		public function save(p_selectedDays:ArrayCollection, 
							 p_unselectedDays:ArrayCollection):void
		{
//			if(!cashSerialToPBOCVO.orgId){
//				AlertHandler.exception("security.orgNotNull");
//				return;
//			}
//			if(!cashSerialToPBOCVO.areaId){
//				AlertHandler.exception("security.areaNotNull");
//				return;
//			}
			var msg:CashSerialToPBOCMsg = new CashSerialToPBOCMsg();
//			if(!cashSerialToPBOCVO.id)
			msg.type = "newCashSerialToPBOC";
//			else
//				msg.type = "updateUser";
			msg.args["vo"] = cashSerialToPBOCVO;
			msg.args["selectedDays"] = p_selectedDays;
			msg.args["unselectedDays"] = p_unselectedDays;
			//记录日志
			msg.logFlag = true;
			msg.menuId = menuId;
		/*	msg.operate = cashSerialToPBOCVO.id ? OperationConsts.EDIT :
				OperationConsts.ADD;*/
			msg.operate = OperationConsts.ADD;
			sendMessage(msg);
		}		
		
		/**
		 * reset form
		 * 
		 */		
		public function reset():void
		{
			cashSerialToPBOCVO = ObjectUtil.copy(formerVO) as CashSerialToPBOCVO;
		}
		
		public function cancel():void
		{
			formerVO.dgSelected = false;
		} 
	}
}