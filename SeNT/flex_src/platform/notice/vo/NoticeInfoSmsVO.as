package platform.notice.vo
{
    [RemoteClass(alias="com.grgbanking.platform.module.notice.entity.NoticeInfoSms")]
    public class NoticeInfoSmsVO
    {
        public var noticeId:String;
        public var mobile:String;
        public var sendDate:Date;
        public var status:String;
        public var id:String;



    }
}