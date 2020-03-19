import platform.vo.ValueObject;

[RemoteClass(alias="com.grgbanking.sent.watch.entity.TransAbnoinfoSeqInfo")]
[Bindable]
public class TransAbnoinfoSeqInfoVO extends ValueObject
{
	public var dgSelected:Boolean;
	public var checkResult:String;
	public var createDate:String;
	public var tranId:String;
	public var noteFlag:String;
	public var noteType:String;
	//	public String id;
	public var termId:String;
	public var journalNo:String;
	public var sequence:String;
	public var currency:String;
	public var denomination:String;
	public var cashBoxId:String;
	public var seriaNo:String;
	public var pictureName:String;
	public var verifyNum:String;
	public var urlName:String;
	public var transDate:String;
	public var transTime:String;
	public var proviceOrgid:String; 
	public var tranMonth:int;
	public var tranDay:int;
	public var versioNum:String;
	public var pathcode:String;
	
}
}