package sent.transmgr.vo
{
	import platform.vo.ValueObject;
	
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlNoteflowMgrInfo")]
	[Bindable]
	public class CmlNoteflowInfoMgrVO extends ValueObject
	{
//		与数据库对应的部分
		public var id              :String;
		public var journalNo       :String;
		public var termId          :String;
		public var clearingDate    :String;
		public var barcodeFlowNum  :String;
		public var noteCount       :int;   
		public var totalNotes      :int;   
		public var noteType        :String;
		public var barcodeStatus   :String;
		public var followType      :String;
		public var pathCode        :String;
		
//		增加的属性
		public var noteCount1      :int ;
		public var totalNotes1     :int ;
		public var devideAmt       :int ;
		public var holeAmt         :int ;
		public var renHangAmt      :int ;
		public var tmAmt           :int ;
		public var cashEnteAmt     :int ;
		public var total           :int ;
		public var totalCount      :int ;
		public var totalAmt        :int ;
		public var totalDevideAmt  :int ;
		public var totalHoleAmt    :int ;
		public var totalTmAmt      :int ;
		public var totalCashEnteAmt:int ;
	}
}