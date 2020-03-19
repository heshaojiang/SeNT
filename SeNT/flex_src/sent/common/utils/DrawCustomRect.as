package sent.common.utils
{
	import flash.events.MouseEvent;
	import flash.text.TextField;
	
	import mx.collections.ArrayCollection;
	import mx.core.UIComponent;
	
	import sent.transmgr.constants.CmlMgrConsts;
	import sent.transmgr.constants.CmlSentInfoConsts;
	
	import spark.components.Group;

	public class DrawCustomRect
	{
		
		private var _groupComponent:Group;
		//private var dicTitleWindow:LoadDataDicts;
		public function DrawCustomRect()
		{
			//dicTitleWindow = new LoadDataDicts();
		}

		public function get groupComponent():Group
		{
			return _groupComponent;
		}
		public function set groupComponent(value:Group):void
		{
			_groupComponent = value;
		}
		
		//========================			
		//交易信息流转图形展示

		public function drawGraphics_tradeInfos(infos:ArrayCollection, dateStr:String):void{
			
			groupComponent.removeAllElements();	//重画前，先删除
			
			if(infos.length<=0)
				return;
			
			groupComponent.height = int(((infos.length-1)/3+1)*100);
			
			var comp:UIComponent = new UIComponent(); 
			for(var i:int=0; i<infos.length; i++)
			{
				var dateFormatStr:String = DateUtils.formatYYYYMMDDHHMISS(infos[i].tranDate);
				//var tranTypeStr:String = this.getTextByKeyOnDataDictPath(infos[i].tranType, CmlSentInfoConsts.TERM_TYPE);
				var tranTypeStr:String = infos[i].tranTypeValue;
				var showMess:String = "交易类型：" + tranTypeStr + "\n终端："+infos[i].termId +
					"\n机构：" + infos[i].orgName + "\n时间："+dateFormatStr ;
				var detailTips:String = showMess +
					"\n操作员：" + infos[i].operatorCode + "\n冠字号数："+infos[i].tranCount+
					"\n交易金额：" + infos[i].tranAmount ;//+ "\n业务类型："+infos[i].operType
				
				//画单个矩形，带有显示信息
				//var rect:RectSprite = drawRectSprite_withTips(showMess,detailTips,i,dateStr);
				var rect:RectSprite = null;
				if(dateStr == infos[i].tranDate){
					rect = drawRectSprite_withTips(showMess,detailTips,i,0xc1e3f7);
				}else{
					rect = drawRectSprite_withTips(showMess,detailTips,i,0xe4ecf5);
				}
				comp.addEventListener(MouseEvent.MOUSE_OVER,rectOverHandler);
				comp.addChild(rect);
				
				if(i > 0)
					drawLineArrowFunc(i);	//画箭线
			}
			groupComponent.addElement(comp);
		}
		//流转信息图形展示
		public function drawGraphics_flowInfos(infos:ArrayCollection, dateStr:String):void{
			
			groupComponent.removeAllElements();	//重画前，先删除
			
			if(infos.length<=0)
				return;
			
			groupComponent.height = int(((infos.length-1)/3+1)*100);
			
			var comp:UIComponent = new UIComponent(); 
			for(var i:int=0; i<infos.length; i++)
			{
				var dateFormatStr:String = DateUtils.formatYYYYMMDDHHMISS(infos[i].date);
				var flowStageStr:String = infos[i].flowStageValue;
				var statusStr:String = infos[i].statusValue;
				var flowDev:String = infos[i].barcode1;
				if(infos[i].barcode2!=null){
					flowDev = infos[i].barcode1+" > > " + infos[i].barcode2;
				}
				
				var flowDevSimple:String = "";
				if(flowDev.length>17){
					flowDevSimple = flowDev.substr(0,17)+"...";
				}else{
					flowDevSimple = flowDev;
				}
				
				var target:String = "钞箱";
				if(flowStageStr=="大额取款"){
					target = "卡号";
				}else if(flowStageStr=="发放柜员"){
					target = "柜员";
				}
				
				var showMess:String = "类型："+flowStageStr + "\n"+target+"："+ flowDevSimple
					+"\n机构："+infos[i].pathCode+"\n时间："+dateFormatStr;
				var detailTips:String = "类型："+flowStageStr + "\n"+target+"："+ flowDev
					+"\n机构："+infos[i].pathCode+"\n时间："+dateFormatStr +
					"\n操作人员："+infos[i].operator + "\n状态："+statusStr + 
					"\n流转条码："+infos[i].barcodeFlowNum;
				
				//画单个矩形，带有显示信息
				var rect:RectSprite = null;
				if(dateStr == infos[i].date){
					rect = drawRectSprite_withTips(showMess,detailTips,i,0xc1e3f7);
				}else{
					rect = drawRectSprite_withTips(showMess,detailTips,i,0xe4ecf5);
				}
				comp.addEventListener(MouseEvent.MOUSE_OVER,rectOverHandler);
				comp.addChild(rect);
				
				if(i > 0)
					drawLineArrowFunc(i);	//画箭线
			}
			groupComponent.addElement(comp);
		}
		//画单个矩形，带有显示信息
		private function drawRectSprite_withTips(showMess:String, detailTips:String, i:int, color:uint):RectSprite{
			
			var hx:int = i%3;
			var hy:int = i/3;
			
			var rectTmp:RectSprite = new RectSprite (showMess, color);
			rectTmp.detailTips = detailTips;
			
			if(hy%2==0){
				rectTmp.x = 10 + hx*200;
				rectTmp.y = 10 + hy*100;
			}else{
				rectTmp.x = 10 + (2-hx)*200;
				rectTmp.y = 10 + hy*100;
			}
			
			return rectTmp;
		}
		//画箭线
		private function drawLineArrowFunc(i:int):void{
			
			var hx:int = i%3;
			var hy:int = i/3;
			var startx:int = 0;
			var starty:int = 0;
			var endx:int = 0;
			var endy:int = 0;
			if(hx!=0){
				starty = 10+40+100*hy;
				endy = 10+40+100*hy;
				if(hy%2==1){
					startx = 10+150+200*(2-hx);
					endx = 10+200*(3-hx);
					//箭头方向从左到右
					//group.addElement(GraphicUtils.performArrowDrawing(endx,endy,startx,starty));
					//从右到左
					groupComponent.addElement(GraphicUtils.performArrowDrawing(startx,starty,endx,endy));
				}else{
					startx = 10+150+200*(hx-1);
					endx = 10+200*hx;
					//group.addElement(GraphicUtils.performArrowDrawing(startx,starty,endx,endy));
					groupComponent.addElement(GraphicUtils.performArrowDrawing(endx,endy,startx,starty));
				}
			}else{
				starty = 10+80+100*(hy-1);
				endy = starty+20;
				if(hy%2==1){
					startx = 10+200*2+75;
					endx = startx;
					//group.addElement(GraphicUtils.performArrowDrawing(startx,starty,endx,endy));
					groupComponent.addElement(GraphicUtils.performArrowDrawing(endx,endy,startx,starty));
				}else{
					startx = 10+75;
					endx = startx;
					//group.addElement(GraphicUtils.performArrowDrawing(startx,starty,endx,endy));
					groupComponent.addElement(GraphicUtils.performArrowDrawing(endx,endy,startx,starty));
				}
			}
		}
		//MouseEvent.MOUSE_OVER事件
		protected function rectOverHandler(event:MouseEvent):void{
			
			var targetObj:Object = event.target;
			var tips:String = "";
			if(targetObj is TextField){
				tips = RectSprite(TextField(targetObj).parent).detailTips;
			}else if(targetObj is RectSprite){
				tips = RectSprite(targetObj).detailTips;
			}
			
			var currObj:UIComponent = event.currentTarget as UIComponent;
			currObj.toolTip = tips;
		}			
		//===============
	}
}