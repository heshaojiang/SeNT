package platform.template.vo
{
	import platform.vo.ValueObject;

    [RemoteClass(alias="com.grgbanking.platform.module.template.entity.ContentTemplate")]
    [Bindable]
	public class ContentTemplateVO extends ValueObject
    {
        public var name:String;
        public var type:String;
        public var text:String;
        public var note:String;
        public var id:String;
    }
}