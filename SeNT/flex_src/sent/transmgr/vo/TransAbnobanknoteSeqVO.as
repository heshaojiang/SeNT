package sent.transmgr.vo
{
	import platform.vo.ValueObject;

	[RemoteClass(alias="com.grgbanking.sent.watch.entity.TransAbnobanknoteSeq")]
	[Bindable]
	public class TransAbnobanknoteSeqVO extends ValueObject
	{
	
		public var tranId:String;
		public var noteFlag:String;
		public var noteType:String;
	    public var  id:String;
		public var termId:String;
		public var journalNo:String;
		public var sequence:String;
		public var currency:String;
		public var denomination:String;
		public var seriaNo:String;
		public var pictureName:String;
		public var tranDate:String;
        public var tranMonthday:String;
		public var versioNum:String;
		public var termType:String;
		public var pathcode:String;/*
		 * private String tranId;
		private String noteFlag;
		private String noteType;
		private String termid;
		private String journalNo;
		private String sequence;
		private String currency;
		private String denomination;
		private String seriaNo;
		private String pictureName;
		private String termType;
		private String transDate;
		private String versioNum;
		private String tranMonthday;
		private String pathcode;
		*/
	}
}