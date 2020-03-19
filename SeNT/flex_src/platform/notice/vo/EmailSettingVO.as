package platform.notice.vo
{
	import platform.vo.ValueObject;

	[Bindable]
	public class EmailSettingVO
	{
		public var encoding:String;
		public var serverName:String;
		public var user:String;
		public var password:String;
		public var from:String;
		
		public function fill(p_obj:*):void
		{
			for(var i:String in p_obj){
				if(this.hasOwnProperty(i))
					this[i] = p_obj[i];
			}
		}
	}
}