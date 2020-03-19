package sent.common.utils
{
	import mx.formatters.DateFormatter;

	public class DateUtils
	{
		
		public static const MILLISECOND_PER_DAY:int = 1000*60*60*24;	// 一天的毫钞数
		
		/**
		 * 创建一个时间对象，
		 * @param day: 距离当天的天数间隔
		 */
		public static function createDate(day:Number=0, format:String=null):Date
		{
			var date:Date = new Date();
			date.time = date.time + MILLISECOND_PER_DAY*day;
			return cutDate(date, format);
		}
		
		/**
		 * 对一个时间对象的时间进行加减，单位为天
		 * @param day: 距离当天的天数间隔
		 */
		public static function addDate(date:Date, day:Number=0):Date
		{
			date.time = date.time + MILLISECOND_PER_DAY*day;
			return date;
		}
	
	
		/**
		 * 将MMDD的格式转化为MM-DD
		 */
		public static function formatMMDD(dateString:String):String
		{
			if( dateString==null )
			{
				return "";
			}
			if( dateString.length<8 )
			{
				return dateString;
			}
			var mm:String = dateString.substring(0, 2);
			var dd:String = dateString.substring(2, 4);
			return mm + "-" + dd;
		}

		/**
		 * 将YYYYMMDD的格式转化为YYYY-MM-DD
		 */
		public static function formatYYYYMMDD(dateString:String):String
		{
			if( dateString==null )
			{
				return "";
			}
			if( dateString.length<8 )
			{
				return dateString;
			}
			var yyyy:String = dateString.substring(0, 4);
			var mm:String = dateString.substring(4, 6);
			var dd:String = dateString.substring(6, 8);
			return yyyy + "-" + mm + "-" + dd;
		}
		
		/**
		 * 将 YYYYMMDDHHMISS 的格式转化为 YYYY-MM-DD HH:MI:SS
		 */
		public static function formatYYYYMMDDHHMISS(dateString:String):String
		{
			if( dateString==null )
			{
				return "";
			}
			if( dateString.length<14 )
			{
				return dateString;
			}
			var yyyy:String = dateString.substring(0, 4);
			var mm:String = dateString.substring(4, 6);
			var dd:String = dateString.substring(6, 8);
			var hh:String = dateString.substring(8, 10);
			var mi:String = dateString.substring(10, 12);
			var ss:String = dateString.substring(12, 14);
			return yyyy + "-" + mm + "-" + dd + " " + hh + ":" + mi + ":" + ss;
		}		

		/**
		 * 将日期字符串（YYYY-MM-DD HH:MM:SS）转化成日期类型
		 **/ 
		public static function parseToDate(dateString:String):Date
		{
			return DateFormatter.parseDateString(dateString);
		}
		
		/**
		 * 输入日期，转化为特定格式字符串
		 **/		
		public static function formatDate(date:Date, format:String="YYYY-MM-DD JJ:NN:SS"):String
		{
			/*if( format==null )
			{
				format = "YYYY-MM-DD JJ:NN:SS";
			}*/
			var df:DateFormatter = new DateFormatter();
			df.formatString = format;
			return df.format(date);
		}
		
		/**
		 *  要求输入的日期字符串格式是YYYY-MM-DD HH:MM:SS，转化成特定格式字符串
		 */ 
		public static function formatTo(dateString:String, format:String="YYYY-MM-DD JJ:NN:SS"):String
		{
			if( format==null )
			{
				format = "YYYY-MM-DD JJ:NN:SS";
			}
			return formatDate(parseToDate(dateString), format);
		}
		
		/**
		 *  要求输入的日期字符串格式是 YYYYMMDDHHMISS，转化成特定格式字符串
		 */ 
		public static function formatYYYYMMDDHHMISSTo(dateString:String, format:String="YYYY-MM-DD JJ:NN:SS"):String
		{
			if( format==null )
			{
				format = "YYYY-MM-DD JJ:NN:SS";
			}
			
			return formatTo(formatYYYYMMDD(dateString),format);
		}
		
		/**
		 * 
		 */
		public static function cutDate(date:Date, format:String):Date
		{
			if( format=="yyyy" )
			{
				return new Date(date.fullYear, 1, 1);
			}
			else if( format=="yyyyMM" )
			{
				return new Date(date.fullYear, date.month, 1);
			}
			else if( format=="yyyyMMdd" )
			{
				return new Date(date.fullYear, date.month, date.date);
			}
			else if( format=="yyyyMMddHH" )
			{
				return new Date(date.fullYear, date.month, date.date, date.hours);
			}
			else if( format=="yyyyMMddHHmm" )
			{
				return new Date(date.fullYear, date.month, date.date, date.hours);
			}
			else if( format=="yyyyMMddHHmm" )
			{
				return new Date(date.fullYear, date.month, date.date, date.hours, date.minutes);
			}
			else if( format=="yyyyMMddHHmmss" )
			{
				return new Date(date.fullYear, date.month, date.date, date.hours, date.minutes, date.seconds);
			}
			else if( format=="yyyyMMddHHmmssSSS" )
			{
				return new Date(date.fullYear, date.month, date.date, date.hours, date.minutes, date.seconds, date.milliseconds);
			}
			else
			{
				var d:Date = new Date();
				d.time = date.time;
				return d;
			}
		}
	}
}
