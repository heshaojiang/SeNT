package sent.common.utils
{
	import flash.geom.Point;
	import flash.text.StaticText;
	
	import mx.core.UIComponent;

	public class GraphicUtils
	{
		public function GraphicUtils()
		{
		}
		
		//public static var arrow:UIComponent=new UIComponent();  
		
		  /**
		    * 画箭头 
		    * ---▲
		    * @param start  开始节点
		    * @param end    结束节点
		    * @param color  线条颜色
		    * @param alpha  透明度
		    * @param radius  箭头的大小
		    * 
		    */
		  public static function drawArrow(start:Point,end:Point,color:uint=0x000000,alpha:Number=1,
										   radius:Number=8.5):UIComponent{			   
			   var arrowTmp:UIComponent=new UIComponent();  
			   var z:Number=Math.sqrt((end.x - start.x) * (end.x - start.x) 
				   + (end.y - start.y) * (end.y - start.y));
			   var angle:Number=Math.atan2(end.y - start.y, end.x - start.x);
			   var exAngle:Number=Math.PI * 4.8 / 4;
			   var p1:Point=Point.polar(z, angle);
			   var p2:Point=Point.polar(radius, angle + exAngle);
			   var p3:Point=Point.polar(radius, angle - exAngle);
			   p1.offset(start.x, start.y);
			   p2.offset(p1.x, p1.y);
			   p3.offset(p1.x, p1.y);
			   if(alpha>1) alpha=1;
			   else if(alpha<0) alpha=0;
			   arrowTmp.graphics.beginFill(color,alpha);
			   arrowTmp.graphics.moveTo(p1.x, p1.y);
			   arrowTmp.graphics.lineTo(p2.x, p2.y);
			   arrowTmp.graphics.lineTo(p3.x, p3.y);
			   arrowTmp.graphics.lineTo(p1.x, p1.y);
			   arrowTmp.graphics.endFill();
			
			   return arrowTmp;
		  }
		
		  /**
		    *  画箭头方法
		    *  →
		    * @param x1  开始节点x轴坐标
		    * @param y1  开始节点y轴坐标
		    * @param x2  结束节点x轴坐标
		    * @param y2  结束节点y轴坐标
		    * @param lineThickness 线条的粗细
		    * @param color  线条的颜色
		    * @param alpha  透明度
		    * 
		    */ 
		  public static function performArrowDrawing(x1:Number, y1:Number, x2:Number, y2:Number, 
													 lineThickness:Number=1, color:uint=0x000000, alpha:Number=1):UIComponent{
			var arrowTmp:UIComponent=new UIComponent();     
			arrowTmp.graphics.lineStyle(lineThickness, color, alpha);
			var arrowHeight:Number = 10;
			var arrowWidth:Number = 7;
			var angle:Number = Math.atan2(y2-y1, x2-x1);
			arrowTmp.graphics.moveTo(x2-arrowHeight*Math.cos(angle)-arrowWidth*Math.sin(angle),
				    y2-arrowHeight*Math.sin(angle)+arrowWidth*Math.cos(angle));
			arrowTmp.graphics.lineTo(x2, y2);
			arrowTmp.graphics.lineTo(x2-arrowHeight*Math.cos(angle)+arrowWidth*Math.sin(angle), 
				    y2-arrowHeight*Math.sin(angle)-arrowWidth*Math.cos(angle));			
			
			arrowTmp.graphics.moveTo(x1, y1);
			arrowTmp.graphics.lineTo(x2, y2);
			
			return arrowTmp;
		  }
	}
}