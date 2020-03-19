package platform.sitemsg.vo
{
    [RemoteClass(alias="com.grgbanking.platform.module.notice.entity.NoticeSitemsg")]
	[Bindable]
    public class NoticeSitemsgVO
    {
		public var content:String;
		public var createTime:Date;
		public var noticeId:String;
		public var sender:String;
		public var publishTime:Date;
		public var deleteTag:String;
		public var status:String;
		public var id:String;
		
		/* 用户发现时暂存收件人，瞬态属性 */
		public var userIds:Array;
		public var senderName:String;
		
		/* 阅读时间，用于接受列表显示，瞬态属性 */
		public var readTime:String;
		
		/* 接收人名称，用逗号隔开名字，用于发送列表显示，瞬态属性 */
		public var recipient:String;
		
		public var dgSelected:String;  	//增加的属性

    }
}