package sent.common.utils
{
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import platform.common.vo.Page;

	public class TestUtils
	{
		public static function printPage(page:Page):void
		{
			trace("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{printPage");
			if( page!=null )
			{
				var classInfo:Object = ObjectUtil.getClassInfo(page);
				var arr:Array = classInfo["properties"];
				trace("    >>>>class properties")
				var p:String;
				for each( p in arr )
				{
					trace("    ["+p+"]=["+page[p]+"]");
				}
				trace("    >>>>dynamic properties")
				for( p in page )
				{
					trace("    ["+p+"]=["+page[p]+"]");
				}
				printArray(page.result.source)
			}
			else
			{
				trace("    ::::::::null");
			}
			trace("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}printPage");
		}
		
		public static function printArrayCollection(arrc:ArrayCollection):void
		{
			trace("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{printArrayCollection");
			if( arrc!=null )
			{
				trace("    ::::::::length : "+arrc.length);
				for( var i:int=0; i<arrc.length; i++ )
				{
					trace("    ::::::index : "+i);
					var item:Object = arrc.getItemAt(i);
					printObject(item);
				}
			}
			else
			{
				trace("    ::::::::null");
			}
			trace("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}printArrayCollection");
		}
		
		public static function printArray(arr:Array):void
		{
			trace("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{printArray");
			if( arr!=null )
			{
				trace("    ::::::::length : "+arr.length);
				for( var i:int=0; i<arr.length; i++ )
				{
					trace("    ::::::index : "+i);
					var item:Object = arr[i];
					printObject(item);
				}
			}
			else
			{
				trace("    ::::::::null");
			}
			trace("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}printArray");
		}
		
	
		public static function printObject(obj:Object):void
		{
			trace("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{printObject");
			if( obj!=null )
			{
				var classInfo:Object = ObjectUtil.getClassInfo(obj);
				trace("    ::::type name : "+classInfo.name)
				trace("    native value : "+obj);
				var arr:Array = classInfo["properties"];
				trace("    ::class properties")
				var p:String;
				for each( p in arr )
				{
					trace("    ["+p+"]=["+obj[p]+"]");
				}
				trace("    ::dynamic properties")
				for( p in obj )
				{
					trace("    ["+p+"]=["+obj[p]+"]");
				}
			}
			else
			{
				trace("    ::::::::null");
			}
			trace("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}printObject");
		}
		
	}
}