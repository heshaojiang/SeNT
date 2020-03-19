package sent.transmgr.vo 
{
	import flash.utils.ByteArray;
	
	import platform.vo.ValueObject;
	
	[RemoteClass(alias="com.grgbanking.sent.transmgr.entity.CmlSentInfo")]
	[Bindable]
	public class CmlSentInfoVO extends ValueObject
	{	
		// { 跟数据库对应的属性
        public var id:String;
		public var tranId:String ;
		public var termId:String;
		public var journalNo:String;
		public var imageType:String;
		public var sequence:int;
		public var fileName:String;
		public var barcodeFlowNum:String;
		public var denomination:String;
		public var noteFlag:String;
		public var noteType:String;
		public var currency:String;
		public var versionNum:String;
		public var seriaNo:String;
		public var errorCode:String;
		public var reserve:String;
		public var tranDate:String;
		public var tranMonthday:String;
		public var termType:String;
		public var pathcode:String;
	    public var machinesno:String;
		public var type:String;
		public var machineType:String ;
		public var moneyType:String;
		
		// } 跟数据库对应的属性
		
		// { 额外的属性
		public var orgName:String;
		public var orgFullName:String;
		public var typeName:String;
		public var businessTypeDesc:String;
		public var imageArr:ByteArray;
		public var fullUrl:String;
		public var fromTableName:String;
		public var width:Number;
		public var height:Number;
		public var registerInDoubtRecord:Boolean;
		public var currentBank:String;
		public var orgNameFinanceCode:String;
		
	}
	
}