package platform.report.vo
{
	import flash.utils.ByteArray;
	
	import platform.vo.ValueObject;

    [RemoteClass(alias="com.grgbanking.platform.module.report.entity.ReportInfo")]
    [Bindable]
    public class ReportInfoVO extends ValueObject
    {
        public var code:int;
        public var createtime:Date;
        public var creater:String;
        public var menuId:String;
        public var note:String;
        public var id:String;
		
		
		public var file:String;
		public var fileData:ByteArray;
		public var menuName:String;
		public var reportName:String;
		public var role:Array;

    }
}