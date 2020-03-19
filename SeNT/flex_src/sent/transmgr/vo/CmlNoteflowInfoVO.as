package sent.transmgr.vo
{
	import platform.vo.ValueObject;
	
	//[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.TranInfo")]
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlNoteflowInfo")]
	[Bindable]
	public class CmlNoteflowInfoVO extends ValueObject
	{
		
		public var id            :String;
		public var journalNo     :String;
		public var termId        :String;
		public var clearingDate  :String;
		//public var barcodeFlowNum:String;
		public var noteCount     :int;   
		//public var totalNotes    :int;
		public var statisAmt:Number;
		public var noteType      :String;
		public var barcodeStatus :String;
		public var flowStage     :String;
		public var pathCode      :String;
		
		public var  tdBarcodeFlownum:String;
		public var  tdOperatorId:String;
		public var  tdReserve:String;
	}
}