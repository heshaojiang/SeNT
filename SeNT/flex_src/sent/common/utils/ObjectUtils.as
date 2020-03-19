package sent.common.utils
{
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.events.PropertyChangeEvent;
	import mx.utils.ObjectProxy;
	import mx.utils.ObjectUtil;

	public class ObjectUtils
	{
		public static function dispatchAllPropertyChangeEvent(obj:IEventDispatcher):void
		{
			var properties:ArrayCollection = new ArrayCollection();
			var p:String = "";
			for( p in obj )
			{
				if( properties.contains(p) )
				{
					continue;
				}
				properties.addItem(p);
				obj.dispatchEvent(new PropertyChangeEvent(
					PropertyChangeEvent.PROPERTY_CHANGE,
					false,
					false,
					"update",
					p, 
					obj[p],
					obj[p],
					obj)
				);
			}
			var classInfo:Object = ObjectUtil.getClassInfo(obj);
			var arr:Array = classInfo["properties"];
			for each( p in arr )
			{
				if( properties.contains(p) )
				{
					continue;
				}
				properties.addItem(p);
				obj.dispatchEvent(new PropertyChangeEvent(
					PropertyChangeEvent.PROPERTY_CHANGE,
					false,
					false,
					"update",
					p, 
					obj[p],
					obj[p],
					obj)
				);
			}
		}
	}
}