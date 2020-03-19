package cml.report.vo
{

	
	import platform.common.vo.BaseVo;

	
	[RemoteClass(alias="com.grgbanking.cml.report.entity.CmlReport")]
	[Bindable]
	public class CmlReportOperatorVO extends BaseVo
	{
		public var id:String;
		public var connId:String;
		public var transResult:String;
	    public var orgId:String;
	 	public var tmlNum:String;
	    public var sourceOrg:String;
	 
		public var boxNum:String;
		public var barInfo:String;
		public var beforeCount:Number;
	 	public var version05:Number;
		public var version99:Number;

		
		public var bindStart:String;
		public var bindEnd:String;
		public var operatorId:String;
		
	   	public var journalNo:String;
	   	public var taskNum:String;
	   	public var totalMoney:String;   
	  	public var rotoCashType:String;
	  	public var atmMoney:Number;
	  	public var passMoney:Number;
	  	public var stubbedMoney:Number;
	  	public var shadinessMoney:Number;
	  	public var trailMoney:Number;
	  	public var falseCoinMoney:Number;
	  	public var reserve1:String;
	  	public var reserve2:String;
	  	public var reserve3:String;


	}
}