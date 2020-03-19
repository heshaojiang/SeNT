package platform.notice.vo
{
    [RemoteClass(alias="com.grgbanking.platform.module.notice.entity.NoticeInfo")]
	[Bindable]
    public class NoticeInfoVO
    {
        public var content:String;
        public var title:String;
        public var sender:String;
        public var sendTime:Date;
        public var recipient:String;
        public var status:String;
        public var noticeMethod:String;
        public var note:String;
        public var dispatchId:String;
        public var email:String;
        public var id:String;
		public var noticeType:String;
		
		public var dgSelected:String;	//增加的属性



    }
}