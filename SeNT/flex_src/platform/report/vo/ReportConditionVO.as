package platform.report.vo
{
	import platform.vo.ValueObject;

    [RemoteClass(alias="com.grgbanking.platform.module.report.entity.ReportCondition")]
    [Bindable]
    public class ReportConditionVO extends ValueObject
    {
        public var name:String;
        public var service:String;
		public var method:String;
        public var control:String;
        public var paramDatatype:String;
        public var remark:String;
        public var id:String;
		public var key:String;
		public var label:String;
	
    }
}