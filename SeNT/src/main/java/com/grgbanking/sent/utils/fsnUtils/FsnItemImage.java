package com.grgbanking.sent.utils.fsnUtils;

import java.io.DataOutputStream;
import java.io.IOException;

public class FsnItemImage
{
	private int num = 10;						// 字符数
	private int width = 32;						// 每个图像字符高度和宽度
	private int height = 32;
	private int reserve2;       			// 保留字2
	private byte[] data = new byte[4*32*num];	// 图像冠字号码点阵数据
	
	
	public void write(DataOutputStream out) throws IOException
	{
		// num
		WriteUtil.writeInt16(num, out);
		// height
		WriteUtil.writeInt16(height, out);
		// width
		WriteUtil.writeInt16(width, out);
		// reserve2
		WriteUtil.writeInt16(reserve2, out);
		// data
		out.write(data);
	}



	public void setReserve2(int reserve2) {
		this.reserve2 = reserve2;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
}
