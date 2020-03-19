package platform.report.vo
{
    [RemoteClass(alias="com.grgbanking.platform.module.report.entity.ReportUpload")]
    [Bindable]
    public class ReportUploadVO extends ValueObject
    {
        public var reportId:String;
        public var uploadtime:Date;
        public var uploader:String;
        public var uploadfile:String;
        public var id:String;

    }
}