package cml.task.delegate
{

	import cml.task.message.CmlTaskInfosMsg;
	
	import mx.rpc.AsyncToken;
	import mx.rpc.events.ResultEvent;
	
	import platform.layer.DelegateBase;
	
	public class CmlTaskInfosDelegate extends DelegateBase
	{
		//去后台查找数据
		[Command(selector="getCmlTaskInfosPage")]
		public function getPageByCmlTaskInfos(msg:CmlTaskInfosMsg):AsyncToken{
		
		return  call("findCmlTaskInfosPage",msg.args["page"],msg.args["tmlNum"],msg.args["operatorName"],
			msg.args["moneySource"],msg.args["startTime"],msg.args["endTime"]);
		}
		
		[CommandResult(selector="getCmlTaskInfosPage")]
		public function getPageByCmlTaskInfosHandler(p_result:ResultEvent,tiggler:CmlTaskInfosMsg):void{
			tiggler.type="getCmlTaskInfosPageResult";
			tiggler.result = p_result.result;
			sendMessage(tiggler);
		
		}
		
		//选择单个交接 
		[Command(selector="getCmlConnectInfosByConnNum")]
		public function getCmlConnectInfosByConnNum(msg:CmlTaskInfosMsg):AsyncToken{
			return call("getCmlConnectInfosByConnNum",  msg.args["vo"]);
		
		}
		[CommandResult(selector="getCmlConnectInfosByConnNum")]
		public function getCmlConnectInfosByConnNumHandler(r_result:ResultEvent,tiggler:CmlTaskInfosMsg):void{
		     tiggler.type= "getCmlConnectInfosByConnNumResult";
			 tiggler.result =r_result.result;
			 sendMessage(tiggler);
			 
		}
		
           //保存数据 
		[Command(selector="saveCmlTaskInfos")]
		public function saveCmlTaskInfos(msg:CmlTaskInfosMsg):AsyncToken{
			
			return  call("SaveCmlTaskInfos",msg.args["CmlTaskInfosVO"],msg.args["cmlConnectionInfo"]);
		}
		[CommandResult(selector="saveCmlTaskInfos")]
		public function saveCmlTaskInfosHandler(p_result:ResultEvent,tiggler:CmlTaskInfosMsg):void{
			tiggler.type="saveCmlTaskInfosResult";
			tiggler.result = p_result.result;
			sendMessage(tiggler);
			
		}
		//删除数据 
		[Command(selector="deleteSelectedTask")]
		public  function deleteSelectedTask(msg:CmlTaskInfosMsg):AsyncToken{
			return call("deleteSelectedTask",msg.args["ids"]);
		}
		[CommandResult(selector="deleteSelectedTask")]
		public function deleteSelectedTaskHandler(r_result:ResultEvent, tiggler:CmlTaskInfosMsg):void{
				tiggler.type="deleteSelectedTaskResult";
				tiggler.result = r_result.result;	
				sendMessage(tiggler);
		}
		
		//选择用户 
		[Command(selector="getUserToCmlTaskInfos")]
		public function getUserToCmlTaskInfos(msg:CmlTaskInfosMsg):AsyncToken{

		 return call("findUserToCmlTaskInfos",msg.args["page"],msg.args["id"],msg.args["operatorId"],msg.args["startTime"],msg.args["endTime"])
		}
		[CommandResult(selector="getUserToCmlTaskInfos")]
		public function getUserToCmlTaskInfosHandler(User_result:ResultEvent,tiggler:CmlTaskInfosMsg):void{
		 tiggler.type ="getUserToCmlTaskInfosResult";
		 tiggler.result = User_result.result ;
		 sendMessage(tiggler);
		 
		}
		
		
		//选择设备
		[Command(selector="getTmlToCmlTaskInfos")]
		
		public function getTmlToCmlTaskInfos(msg:CmlTaskInfosMsg):AsyncToken{
		
		return call("findTermInfoToCmlTaskInfos",msg.args["page"],msg.args["id"],msg.args["tmlNum"],msg.args["startTime"], msg.args["endTime"]);
		}
		[CommandResult(selector="getTmlToCmlTaskInfos")]
		public function getTmlToCmlTaskInfosHandler(tml_result:ResultEvent,tiggler:CmlTaskInfosMsg):void{
		
			tiggler.type= "getTmlToCmlTaskInfosResult";
			tiggler.result = tml_result.result;
			sendMessage(tiggler);
			
		}
		//选择交接
		[Command(selector="getConnToCmlTaskInfos")]
	   public function getConnToCmlTaskInfos(msg:CmlTaskInfosMsg):AsyncToken{
	    return call("findConnectToCmlTaskInfos",msg.args["page"],msg.args["inPerson"], msg.args["commOrg"],msg.args["startTime"], msg.args["endTime"]);
	   }
	   [CommandResult(selector="getConnToCmlTaskInfos")]
	   public function getConnToCmlTaskInfosHandler(conn_result:ResultEvent,tiggler:CmlTaskInfosMsg):void{
		   tiggler.type="getConnToCmlTaskInfosResult";
		   tiggler.result = conn_result.result;
		   sendMessage(tiggler);
	   }
	   [Command(selector="getCmlTaskInfosOperatorName")]  
	   public function getCmlTaskInfosOperatorName(msg:CmlTaskInfosMsg):AsyncToken{
	   
	   return call("getCmlTaskInfosOperatorName",msg.args["operatorId"]);
	   
	   }
	   [CommandResult(selector="getCmlTaskInfosOperatorName")]  
	   public function getCmlTaskInfosOperatorNameHandler(result:ResultEvent,tiggler:CmlTaskInfosMsg):void{
		   tiggler.type="getCmlTaskInfosOperatorNameResult";
		   tiggler.result = result.result;
		   sendMessage(tiggler);
	   }
	   
		
	   //检查是否可用 
	   [Command(selector="checkOperatorIdAndTml")]  
	  public function checkOperatorIdAndTml(msg:CmlTaskInfosMsg):AsyncToken{
	 		 return call("checkOperatorIdAndTmlNum",msg.args["id"],
				 msg.args["operatorId"], msg.args["tmlNum"],msg.args["bindStart"],msg.args["bindEnd"]);
	  }
	  [CommandResult(selector="checkOperatorIdAndTml")]  
	  public function checkOperatorIdAndTmlHandler(result:ResultEvent,tiggler:CmlTaskInfosMsg):void{
	   tiggler.type = "checkOperatorIdAndTmlResult";
	   tiggler.result = result.result;
	   sendMessage(tiggler);

	  }
	  
	  [Command(selector="loadImp")]
	 public function loadImp(msg:CmlTaskInfosMsg):AsyncToken{
		 
		 return call("loadImp",msg.args["cmlTaskInfoImp"]);
		 
	 
	 
	 }
	 [CommandResult(selector="loadImp")]
	public function loadImpHandler(result:ResultEvent,tiggler:CmlTaskInfosMsg):void{
	
	 tiggler.type="loadImpResult";
	 tiggler.result =result.result;
	 sendMessage(tiggler);
	 
	}
	
	//
	
	[Command(selector="importExcelForCmlImpRecords")]
	public  function importExcelForCmlImpRecords(msg:CmlTaskInfosMsg):AsyncToken{
		return call("ImpRecords", msg.args["byte"],msg.args["cmlTaskInfos"], msg.args["tmlType"]);
//		return call("ImpRecords", msg.args["byte"],msg.args["cmlTaskInfos"], msg.args["tmlType"],msg.args["oldName"],msg.args["i"]);
	}
	
	
	[CommandResult(selector="importExcelForCmlImpRecords")]
	public function importExcelForCmlImpRecordsHandler(result :ResultEvent,tiggler:CmlTaskInfosMsg):void{
	  tiggler.type = "importExcelForCmlImpRecordsResult";
	  tiggler.result = result.result;
	  sendMessage(tiggler);
	}
	
	//检查上传文件
	[Command(selector="checkUploadFile")]
	public function checkUploadFile(msg:CmlTaskInfosMsg):AsyncToken{
		return call("checkFileName",msg.args["fileName"],msg.args["taskNum"]);
	// return call("checkFileName",msg.args["fileName"],msg.args["taskNum"],msg.args["oldname"],msg.args["i"]);
	}
	[CommandResult(selector="checkUploadFile")]
	public function checkUploadFileHandler(result:ResultEvent ,tiggler:CmlTaskInfosMsg):void{
	 tiggler.type = "checkUploadFileResult";
	 tiggler.result = result.result;
	 sendMessage(tiggler);
	}
	
	[Command(selector="findCmlImpRecordsPage")]
	
	public function findCmlImpRecordsPage(msg:CmlTaskInfosMsg):AsyncToken{
	
	 return call("findCmlImpRecordsPageForTask", msg.args["page"], msg.args["taskNum"], msg.args["fileName"],msg.args["startTime"],msg.args["endTime"]);

	}
	[CommandResult(selector="findCmlImpRecordsPage")]
	public function findCmlImpRecordsPageHandler(result:ResultEvent,tiggler:CmlTaskInfosMsg):void{
		
		tiggler.type="findCmlImpRecordsPageResult";
		tiggler.result = result.result;
		sendMessage(tiggler);
		
	}
	/**
	  解析*/
	[Command(selector="parseSentForCmlImpRecords")]
	public function parseSentForCmlImpRecords(msg:CmlTaskInfosMsg):AsyncToken{
	 return call("returnCmlImpRecords",	msg.args["cmlImpRecords"] ,msg.args["cmlTaskInfos"], msg.args["devMode"])
	}
	[CommandResult(selector="parseSentForCmlImpRecords")]
	public function parseSentForCmlImpRecordsHandler( result :ResultEvent ,tiggler:CmlTaskInfosMsg ):void{
	tiggler.type = "parseSentForCmlImpRecordsResult";
	tiggler.result =result.result;
	sendMessage(tiggler);
	}
	
	/**导入任务*/
	[Command(selector="importTask")]
 public function importTask(msg:CmlTaskInfosMsg):AsyncToken{
 
 
   return call("importTask",msg.args["byte"],msg.args["usercode"] , msg.args["orgid"] );
 }	
 [CommandResult(selector="importTask")]
 
 public function importTaskHandler(result:ResultEvent,tiggler:CmlTaskInfosMsg):void {
 
  tiggler.type = "importTaskResult";
  tiggler.result = result.result;
  sendMessage(tiggler);
 }

 
 [Command(selector="updateImpRecords")] 
 public function updateImpRecords(msg:CmlTaskInfosMsg):AsyncToken{
 
 return call("updateImpRecords",msg.args["cmlImpRecords"],msg.args["cmlTsCmlTaskInfos"],msg.args["byte"], msg.args["name"],msg.args["tmltype"]);
 }
 
 [CommandResult(selector="updateImpRecords")]
 
 public function updateImpRecordsHandler(r_result:ResultEvent, tiggler:CmlTaskInfosMsg):void{
 
  tiggler.type = "updateImpRecordsResult";
  tiggler.result = r_result.result;
  sendMessage(tiggler);
 }
 [Command(selector="checkAgainFile")] 
 public function checkAgainFile(msg:CmlTaskInfosMsg):AsyncToken{
	  return call("checkFileName",msg.args["name"],  msg.args["taskNum"],  msg.args["oldName"]);
	  
 }
 [CommandResult(selector="checkAgainFile")]
 
 public function checkAgainFileHandler(result:ResultEvent,tiggler:CmlTaskInfosMsg):void{
   tiggler.type="checkAgainFileResult";
   tiggler.result = result.result;
   sendMessage(tiggler);
 }
}
}