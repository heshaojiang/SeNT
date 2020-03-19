package platform.report.vo
{
    [RemoteClass(alias="com.grgbanking.platform.module.report.entity.ReportParam")]
    [Bindable]
    public class ReportParamVO extends ValueObject
    {
        public var method:String;
        public var defaultValue:String;
        public var reportId:String;
        public var paramName:String;
        public var datatype:String;
        public var inputType:String;
        public var paramDatatype:String;
        public var remark:String;
        public var service:String;
        public var id:String;

    }
}