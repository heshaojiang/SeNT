package sent.transmgr.vo
{
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlNoteflowDetailInfo")]
	[Bindable]
	public class CmlNoteflowDetailVO 
	{
		public var id:String;
		public var barcodeFlowNum:String;
		public var barcode1:String ;
		public var barcode2:String;
		public var type:String;
		public var status:String;
		public var operator:String;
		public var date:String;
		public var pathCode:String;
		public var receivePathCode:String;
	}
}