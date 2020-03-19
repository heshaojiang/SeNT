package cml.task.pm
{
	
	import cml.cmlConnectInfos.vo.CmlConnectInfosVO;
	import cml.task.message.CmlTaskInfosMsg;
	import cml.task.vo.CmlImpRecordsVO;
	import cml.task.vo.CmlTaskInfosVO;
	
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	import mx.controls.List;
	import mx.utils.XMLUtil;
	
	import platform.common.util.DateUtils;
	import platform.common.vo.Page;
	import platform.layer.BasePM;
	import platform.vo.security.UserVo;
	import platform.vo.term.TermInfoVo;
	
	import sent.transmgr.vo.TmlAnalyseVO;
	
	public class CmlTaskInfosPM extends BasePM
	{
		
		[Bindable]
		public var _cmlTaskInfos:CmlTaskInfosVO = new CmlTaskInfosVO();
		[Init]
		public function init():void
		{
			loadPage();	
		}
		//接受下拉机构的值	
		[Bindable]
		public var orgList:Object = new Object();
		[Bindable]
		public var checkResult:int;
		[Bindable]
		public var conn:Object  = new Object();	
		[Bindable]		
		public var page:Page = new Page();
		
		[Bindable]
		
		public var imp_page :Page = new Page();
		
		//绑定user、 tml ，conn page页面数据
		[Bindable]
		public var user_page:Page = new Page();
		[Bindable]
		public var tml_page :Page = new Page();
		[Bindable]
		public var conn_page:Page = new Page();
		[Bindable]	
		public var usr:UserVo = new UserVo();
		
		[Bindable]
		public var tmlInfo:TermInfoVo= new TermInfoVo();
		[Bindable]
		public var cmlConnectInfos:CmlConnectInfosVO =new CmlConnectInfosVO();
		[Bindable]
		public var cmlImpRecords :CmlImpRecordsVO =  new CmlImpRecordsVO();
		
		[Bindable]
		
		public var obj:Object = new Object();
		
		
		
	
		
		//加载主页面
		public function loadPage():void{	 
			var msg:CmlTaskInfosMsg = new CmlTaskInfosMsg();
			msg.type="getCmlTaskInfosPage";
			msg.args["page"] = page;
			msg.args["tmlNum"] = conn.tmlNum;
			msg.args["operatorName"]=conn.operatorName;
			msg.args["startTime"] =conn.startTime;
			msg.args["endTime"] = conn.endTime;
			msg.args["moneySource"]= conn.moneySource;
			sendMessage(msg);
		}
		
		//保存新增的cmlTaskInfos
		
		public function saveCmlTaskInfos(cmlTaskInfos:CmlTaskInfosVO,cmlCo:CmlConnectInfosVO):void{
			
			var msg:CmlTaskInfosMsg = new CmlTaskInfosMsg();
			msg.type="saveCmlTaskInfos";
			msg.args["CmlTaskInfosVO"] = cmlTaskInfos;
			msg.args["cmlConnectionInfo"]= cmlCo;
			sendMessage(msg);
		}
		
		//loadPage的回调函数
		
		[MessageHandler(selector="getCmlTaskInfosPageResult")]
		public function  getCmlTaskInfosPageResult(p_result:CmlTaskInfosMsg):void{
			
			if(p_result ){
				page = p_result.result as Page;
			}
		} 
		
		
		//saveCmlTaskInfos的回调函数
		[MessageHandler(selector="saveCmlTaskInfosResult")]
		public function  saveCmlTaskInfosResult(p_result:CmlTaskInfosMsg):void{
			
			if(p_result ){
				conn.statu =  p_result.result as Number;
			}
			
		}
		[MessageHandler(selector="deleteSelectedTaskResult")]
		public function deleteSelectedTaskResult(r_result:CmlTaskInfosMsg):void{
		 if(r_result){
		  conn.deleteResult = XML(r_result.result);
		 }
		}
		
		public  function getCmlConnectionInfo(connNum:CmlTaskInfosVO):void{
		 var msg:CmlTaskInfosMsg = new CmlTaskInfosMsg();
			 msg.type ="getCmlConnectInfosByConnNum"
			 msg.args["vo"]  =connNum;
			 sendMessage(msg);  
		}
		[MessageHandler(selector="getCmlConnectInfosByConnNumResult")]
		public function getCmlConnectInfosByConnNumResult(result:CmlTaskInfosMsg):void{
			conn.flag = true;
			 if(result){
			  cmlConnectInfos = result.result as CmlConnectInfosVO;
			 }}
		
		//删除
		public function deleteSelectedTask(s_item:ArrayCollection):void{
		 var msg :CmlTaskInfosMsg = new CmlTaskInfosMsg();
		 msg.type="deleteSelectedTask";
		 msg.args["ids"] = s_item;
		 sendMessage(msg);
		}
		
		//修改界面将eratorId 转换成operatorName
		public function getCmlTaskInfosOperatorName(operatoid:String):void{
		var msg:CmlTaskInfosMsg = new CmlTaskInfosMsg();
		msg.type= "getCmlTaskInfosOperatorName";
		msg.args["operatorId"] = operatoid;
		sendMessage(msg);
		}
		
		[MessageHandler(selector="getCmlTaskInfosOperatorNameResult")]
		public function getCmlTaskInfosOperatorNameResult(result :CmlTaskInfosMsg):void{
		if(result){
			usr  =result.result as UserVo;
		}}
		
		//加载选择交接界面 
		
		public function chooseConn():void{
		 var msg:CmlTaskInfosMsg = new CmlTaskInfosMsg();
		 msg.type ="getConnToCmlTaskInfos";
		 msg.args["page"]= conn_page;
		 msg.args["inPerson"] = conn.inPerson;
		 msg.args["commOrg"]= conn.commOrg;
		 msg.args["startTome"]= conn.startTime;
		 msg.args["endTime"] = conn.endTime;
		 sendMessage(msg);
		}
		[MessageHandler(selector="getConnToCmlTaskInfosResult")]
		public function  getConnToCmlTaskInfosResult(conn_result:CmlTaskInfosMsg):void{
			if(conn_result){
				conn_page =conn_result.result  as Page;
			}
			
		} 
		//加载选择人员页面 
		public function chooseUser():void{	
			var msg:CmlTaskInfosMsg = new CmlTaskInfosMsg();
			msg.type ="getUserToCmlTaskInfos";
			msg.args["id"] =_cmlTaskInfos.id;
			msg.args["page"]=user_page;
			msg.args["operatorId"]=conn.name;
			msg.args["startTime"]=conn.bindStart;
			msg.args["endTime"]=conn.bindEnd;
			sendMessage(msg);
		}
		
		[MessageHandler(selector="getUserToCmlTaskInfosResult")]
		public function  getUserToCmlTaskInfosResult(User_result:CmlTaskInfosMsg):void{
			
			if(User_result){
				user_page =User_result.result  as Page;
			}
			
		} 
		
		public function chooseTml():void{
			var msg:CmlTaskInfosMsg = new CmlTaskInfosMsg();
			msg.type ="getTmlToCmlTaskInfos";
			msg.args["id"] =_cmlTaskInfos.id;
			msg.args["page"]=tml_page;
			msg.args["tmlNum"] = conn.tmlNum;
			msg.args["startTime"]=conn.startTime;
			msg.args["endTime"]=conn.endTime;
			sendMessage(msg);
		}
		
		
	
		//回调函数
		[MessageHandler(selector="getTmlToCmlTaskInfosResult")]
		public 	function  getTmlToCmlTaskInfosResult(tml_result:CmlTaskInfosMsg):void{
			if(tml_result){
				tml_page =tml_result.result  as Page;
			}
		} 

		
		//检查时间区间内是否可选
		public function checkOperatorIdAndTml(cmlTaskInfos:CmlTaskInfosVO):void{
			var msg:CmlTaskInfosMsg = new CmlTaskInfosMsg();
			msg.type ="checkOperatorIdAndTml";
			msg.args["id"]= cmlTaskInfos.id;
			msg.args["operatorId"]  =cmlTaskInfos.operatorId;
			msg.args["tmlNum"] = cmlTaskInfos.tmlNum;
			msg.args["bindStart"] =DateUtils.formatDate(cmlTaskInfos.bindStart,"YYYY-MM-DD JJ:NN:SS");
			msg.args["bindEnd"] = DateUtils.formatDate(cmlTaskInfos.bindEnd,"YYYY-MM-DD JJ:NN:SS");
			sendMessage(msg);
		}
		
		
		[MessageHandler(selector="checkOperatorIdAndTmlResult")]
		public function checkOperatorIdAndTmlResult(r_result:CmlTaskInfosMsg):void{
		   if(r_result){
		 
			checkResult=r_result.result as int;
			
		
		   }
		}
		
		
		//进入导入界面 
		
		public function loadImp(cmlTaskInfoImp:CmlTaskInfosVO) :void{
		
			var msg:CmlTaskInfosMsg = new CmlTaskInfosMsg();
			msg.type="loadImp";
			msg.args["cmlTaskInfoImp"] =cmlTaskInfoImp;
			sendMessage(msg);
			
		}
		
		
		public function  importExcelToCmlImpRecords(byte:ArrayCollection,cmlTaskInfos:CmlTaskInfosVO, tmlType:String):void{
		
		 var msg:CmlTaskInfosMsg = new CmlTaskInfosMsg();
		 msg.type = "importExcelForCmlImpRecords";
		 msg.args["byte"] = byte;
		 msg.args["cmlTaskInfos"] = cmlTaskInfos;
		 msg.args["tmlType"] = tmlType;
		 //msg.args["oldName"] = oldName;
		// msg.args["i"] = i;
		 sendMessage(msg);
		}
		
		
		public function checkFile(name:ArrayCollection,taskNum:String):void{
			var msg :CmlTaskInfosMsg = new CmlTaskInfosMsg();
			msg.type ="checkUploadFile";
			msg.args["fileName"] = name;
			msg.args["taskNum"] = taskNum;
		
			sendMessage(msg);
		}

		public function findCmlImpRecordsPage():void{
		 var msg:CmlTaskInfosMsg = new CmlTaskInfosMsg ();
		 msg.type ="findCmlImpRecordsPage";
		 if(null == imp_page){
		  imp_page = new Page();
		 }
		 msg.args["page"] =imp_page;
		 msg.args["taskNum"] =_cmlTaskInfos.taskNum;
		 msg.args["fileName"] =conn.fileName;
		 msg.args["startTime"]= conn.startTime;
		 msg.args["endTime"]= conn.endTime;
		 sendMessage(msg);
		 
		}
		[MessageHandler(selector="findCmlImpRecordsPageResult")]
		public function lookcmlImpRecordsByTask(result:CmlTaskInfosMsg):void{
		
		if(result){
		  imp_page = result.result as Page;
		}
		}
		
		public function parseSent(cmlImptemp:CmlImpRecordsVO,cmlTaskInfos:CmlTaskInfosVO, devMode:String):void{
		 var msg:CmlTaskInfosMsg = new CmlTaskInfosMsg();
		 msg.type = "parseSentForCmlImpRecords";
		msg.args["cmlImpRecords"] = cmlImptemp;
		 msg.args["cmlTaskInfos"] = cmlTaskInfos;
			msg.args["devMode"] =devMode ;
		 sendMessage(msg);
		 
		 
		}
	
    /***/
		
		public function importTask(byte:ByteArray, usercode:String,orgid:String):void{
			var msg:CmlTaskInfosMsg   = new CmlTaskInfosMsg();
			msg.type = "importTask";
			msg.args["byte"] = byte;
			msg.args["usercode"] =usercode;
			msg.args["orgid"] = orgid;
			sendMessage(msg);
		
		
		}
		
		/**更新*/
		
		public function updateImpRecords(cmlImpRecords:CmlImpRecordsVO,cmlTaskinfos:CmlTaskInfosVO,byte :ByteArray,tmltype:String,name:String ):void{
		
		 var msg:CmlTaskInfosMsg  = new CmlTaskInfosMsg();
		 msg.type = "updateImpRecords";
		 msg.args["cmlImpRecords"] = cmlImpRecords;
		 msg.args["cmlTsCmlTaskInfos"] =cmlTaskinfos;
		 msg.args["byte"] = byte;
		 
		 msg.args["name"] = name;
		 msg.args["tmltype"] = tmltype;
		 sendMessage(msg);
		 
		}
		/**
		 * 更新时候检查文件名
		 * */
	/*	public function checkFile(name:ArrayCollection,taskNum:String):void{
			var msg :CmlTaskInfosMsg = new CmlTaskInfosMsg();
			msg.type ="checkUploadFile";
			msg.args["fileName"] = name;
			msg.args["taskNum"] = taskNum;
			
			sendMessage(msg);
		}
*/
		
	 
}
	
}