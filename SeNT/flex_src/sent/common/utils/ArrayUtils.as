package sent.common.utils
{
	public class ArrayUtils
	{
		public static function getKeyArrLength(p_arr:Array):int
		{
			var count:int = 0;
			for( var i:* in p_arr )
			{
				count ++;
			}
			return count;
		}
		
		public static function getPropertyArray(property:String, arr:Array):Array
		{
			var result:Array = [];
			for each( var item:Object in arr )
			{
				if( item.hasOwnProperty(property) )
				{
					result.push(item[property]);
				}
			}
			return result;
		}
	}
}