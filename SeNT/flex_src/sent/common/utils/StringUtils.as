package sent.common.utils
{
	import platform.common.util.StringUtil;

	public class StringUtils
	{
		
		public static function trim(input:String):String
		{
			return StringUtil.trim(input);
		}
		
		public static function beginsWith(input:String, prefix:String):Boolean
		{
			return StringUtil.beginsWith(input, prefix);
		}
		
		public static function startsWith(input:String, prefix:String):Boolean
		{
			return StringUtil.beginsWith(input, prefix);
		}
		
		public static function endsWith(input:String, suffix:String):Boolean
		{
			return StringUtil.endsWith(input, suffix);
		}
		
		public static function substr(input:String, start:Number, len:Number):String
		{
			if( input==null )
			{
				return null;
			}
			return input.substr(start, len);
		}
		
		public static function substring(input:String, start:Number, end:Number):String
		{
			if( input==null )
			{
				return null;
			}
			return input.substring(start, end);
		}
		
		public static function isBlank(input:String):Boolean
		{
			if( input==null )
			{
				return true;
			}
			return trim(input)=="";
		}
		
		public static function isNotBlank(input:String):Boolean
		{
			return !isBlank(input);
		}
		
	}
}