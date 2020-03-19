package cml.cmlConnectInfos.pm
{
	import cml.cmlConnectInfos.message.CmlConnectInfosMsg;
	import cml.cmlConnectInfos.view.CmlConnectInfosForm;
	import cml.cmlConnectInfos.vo.CmlConnectInfosVO;
	
	import mx.utils.ObjectUtil;
	
	import platform.common.vo.Page;
	import platform.constants.OperationConsts;
	import platform.layer.BasePM;
	import platform.vo.security.UserVo;

	public class CmlConnectInfosFormPM extends BasePM
	{
		
		/**页面菜单vo**/
		[Bindable]
		public var cmlConnectInfos:CmlConnectInfosVO = new CmlConnectInfosVO();
		[Bindable]
		public var page:Page = new Page();
		[Bindable]
		public var condi:Object = new Object();
		[Bindable]
		public var perstr:String;
		
		[Bindable]
		public var user:UserVo;
		/**
		 * 初始化后加载数据
		 */		
		[Init]
		public function init():void
		{
			loadPage();
		}
	     
		/**原来的VO**/
		public var formerVO:CmlConnectInfosVO;
		
		public function set vo(p_vo:CmlConnectInfosVO):void
		{
			formerVO = p_vo;
			cmlConnectInfos = ObjectUtil.copy(p_vo) as CmlConnectInfosVO;
		}
		
		
		/**
		 * 重置表单
		 * 
		 */		
		
		public function reset():void
		{
			cmlConnectInfos = ObjectUtil.copy(formerVO) as CmlConnectInfosVO;
		}
		
		/**
		 * 保存菜单
		 * 
		 */		
		
		public function save():void
		{
			//invoke save function
			var msg:CmlConnectInfosMsg = new CmlConnectInfosMsg();
			//新增一条清分交接信息
			if(!cmlConnectInfos.id){
				msg.type = "addCmlConnectInfosObject";
				cmlConnectInfos.inPerson=user.userCode;
				msg.operate = OperationConsts.ADD;
				/*var dateStr:String=DateFormatter.format(new Date());
				dateStr=dateStr.substr(0,4)+dateStr.substr(5,2)+dateStr.substr(8,2)+dateStr.substr(11,2)+dateStr.substr(14,2)+dateStr.substr(17,2);
				cmlConnectInfos.createDate=dateStr;*/
			}else{
				//修改一条清分交接信息
				msg.type = "updateCmlConnectInfosObject";
				msg.operate = OperationConsts.EDIT;
			}
		
			msg.args["vo"] = cmlConnectInfos;
			
			
			msg.logFlag = true;
			msg.menuId = this.menuId;
			sendMessage(msg);
		}
		
		
		/**
		 * 取消
		 * 
		 */	
		
		public function cancel():void
		{
			formerVO.dgSelected = false;
		}
		
		
		/**
		 * 加载列表页 
		 */		
		
		public function loadPage():void
		{
			var msg:CmlConnectInfosMsg= new CmlConnectInfosMsg();
			msg.type = "getOperatorPage";
			msg.args["userName"]= condi.userName;
			msg.args["page"] = page;
			sendMessage(msg);
		}
		
		/**
		 * 清分员
		 */
		
		[MessageHandler(selector="getOperatorPageResult")]
		public function getUserNamePageResult(p_msg:CmlConnectInfosMsg):void
		{
			if(p_msg)
				page = p_msg.result as Page;
		}
	
	}
	}
