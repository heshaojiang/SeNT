package sent.transmgr.vo
{
	import platform.vo.ValueObject;
	
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlNoteflowDetailInfo")]
	[Bindable]
	public class CmlNoteflowDetailInfoVO extends ValueObject
	{
		// { 跟数据库对应的属性
		public var id            :String;
		public var barcodeFlowNum:String;
		public var barcode1      :String;
		public var barcode2      :String;
		public var flowStage     :String;
		public var status        :String;
		public var operator      :String;
		public var date          :String;
		public var pathCode      :String;
		// } 跟数据库对应的属性
		
		// { 额外的属性
		public var cmlNoteflowInfoId:String;
		public var journalNo     :String;
		public var termId        :String;
		public var clearingDate  :String;
		public var noteCount     :int;   
		public var totalNotes    :int;   
		public var noteType      :String;
		public var barcodeStatus :String;
		public var baseFlowStage :String;
		
		public var orgid:String;
		public var boxNum:String;
		public var boxStatus:String;
		public var atmModel:String;
		public var atmBoxTypes:String;
		public var boxType:String;
		public var usageStatus:String;
		
		public var flowStageValue:String;
		public var statusValue:String;
	}
}