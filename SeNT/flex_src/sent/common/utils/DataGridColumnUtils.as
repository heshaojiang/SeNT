package sent.common.utils
{
	import platform.component.controls.DataGridColumn;

	public class DataGridColumnUtils
	{
		
		public static function formatYYYYMMDD(item:Object, column:DataGridColumn):String
		{
			var value:String = item[column.dataField];
			if( value==null )
			{
				return null;
			}
			return DateUtils.formatYYYYMMDD(value);
		}
		
		public static function formatYYYYMMDDHHMISS(item:Object, column:DataGridColumn):String
		{
			var value:String = item[column.dataField];
			if( value==null )
			{
				return null;
			}
			return DateUtils.formatYYYYMMDDHHMISS(value);
		}
		
		public static function formatDate(item:Object, column:DataGridColumn):String
		{
			var value:Date = item[column.dataField];
			if( value==null )
			{
				return null;
			}
			return DateUtils.formatDate(value);
		}
		
		public static function formatDateToYYYYMMDD(item:Object, column:DataGridColumn):String
		{
			var value:Date = item[column.dataField];
			if( value==null )
			{
				return null;
			}
			return DateUtils.formatDate(value,"YYYY-MM-DD");
		}
		
		public static function formatDateToYYYYMMDDHHMISS(item:Object, column:DataGridColumn):String
		{
			var value:Date = item[column.dataField];
			if( value==null )
			{
				return null;
			}
			return DateUtils.formatDate(value,"YYYY-MM-DD JJ:NN:SS");
		}
		
		
		
	}
}