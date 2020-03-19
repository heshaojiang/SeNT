package sent.transmgr.vo
{
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlUpPersonExportRecord")]
	[Bindable]
	public class CmlUpPersonExportRecordVO 
	{
		public var id:String;
		public var  filePath :String;
		public var  fileName:String;
		public var  status:String;
		public var  startTime:String;
		public var  endTime:String;
		public var  exportDate:String;
		public var  errMsg:String;
		public var  fileBelongFlag:String;
		public var fileUploadOrg:String ;  // �ϱ����
		public var fileUploadOrgName:String; // �ϱ�����
		public var autoUploadStatus:String;
		public var dgSelected:Boolean = false;
	}
}