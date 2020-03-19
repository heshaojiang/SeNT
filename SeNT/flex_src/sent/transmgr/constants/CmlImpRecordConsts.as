package sent.transmgr.constants
{
	public class CmlImpRecordConsts 
	{
		//字号码文件上传的lacale key
		public static const UPLOAD_SENTINFO:String = "uploadSentInfo";
		public static const CONFIRM_CANCEL:String = "confirmCancel" ;
		public static const CONFIRM_EXPORT:String = "confirmExecuteExportNow" ;
		//上传状态
		public static const UPLOAD_STATUS:String="SysDatadirMgr.sent.cmlMgr.fileUploadStatus";
		//获取图像标识
		public static const GET_IMAGE_FLAG:String = "SysDatadirMgr.sent.transMgr.getImageFlag" ;
		//上传服务器标识
		public static const UPLOAD_FLAG:String = "SysDatadirMgr.sent.transMgr.uploadFlag" ;
		// 上报人行文件类型
		public static const EXPORT_FILE_TYPE:String = "SysDatadirMgr.sent.transMgr.exportFileType";
		// 自动上报状态
		public static const AUTO_UPLOAD_STATUS:String = "SysDatadirMgr.sent.transMgr.autoUploadStatus";
		//文件导出任务执行结果 
		public static const UPLOAD_TASK_EXECUTE_RESULT:String="SysDatadirMgr.sent.transMgr.uploadTaskExecuteResult";
		// 文件导出任务未执行
		public static const UPLOAD_TASK_EXECUTE_UNDO:String = "0" ;
		//文件上传人行任务执行方式
		public static const UPPERSON_TASK_EXE_TYPE:String = "SysDatadirMgr.sent.transMgr.upPersonTaskExecuteType" ;
		
		public static const UPPERSON_TASK_EXE_AUTO:String = "0" ;  // 自动执行文件上传人行任务自动执行
		
		public static const UPPERSON_TASK_EXE_HAND:String = "1" ;  // 手动执行文件上传人行任务
		
	}
}