package sent.common.utils
{
	/**
	 *画一个圆角矩形为背景的显示框
	 * 
	 **/	
	import flash.display.Sprite;
	import flash.text.TextField;

	public class RectSprite extends Sprite
	{
		private var _label:TextField;
		private var _detailInfo:Object;//departed
		private var _detailTips:String;
		
		public function RectSprite(labelName:String, color:uint) {
			//以下四行使用Sprite内的graphics对象画一个圆角矩形背景
			this.graphics.lineStyle(1, 0x000000);
			this.graphics.beginFill(color);
			this.graphics.drawRoundRect(0,0,150,80,10,10);
			this.graphics.endFill();
			//生成文本框，并将labelName用html设成15号粗体			
			_label = new TextField();
			_label.htmlText = "<font size='12' color='#2784cc'>"+labelName+"</font>";
			_label.selectable = false;
			_label.autoSize = "left";
			//将文本框加入RectSprite对象的显示列表
			addChild(_label);
		}
		
		public function get detailInfo():Object
		{
			return _detailInfo;
		}
		
		public function set detailInfo(value:Object):void
		{
			_detailInfo = value;
		}

		public function get detailTips():String
		{
			return _detailTips;
		}

		public function set detailTips(value:String):void
		{
			_detailTips = value;
		}

		
	}
}