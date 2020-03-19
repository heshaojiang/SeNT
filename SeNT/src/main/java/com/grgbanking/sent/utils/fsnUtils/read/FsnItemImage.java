package com.grgbanking.sent.utils.fsnUtils.read;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.grgbanking.sent.utils.fsnUtils.WriteUtil;


public class FsnItemImage
{
	public short num;						// 字符数
	public short width;						// 每个图像字符高度和宽度
	public short height;
	public short reserve2;       			// 保留字2
	public byte[] data = new byte[4*32*12];	// 图像冠字号码点阵数据
	
	public static int imageSize()
	{
		return 4*32*12;
	}
	
	public static int size()
	{
		return 	2 + 			// num
				2 + 			// height
				2 + 			// width
				2 + 			// reserve2
				imageSize();	// data
	}
	
	public void read(DataInputStream in) throws IOException
	{
		// num
		num = CppHelper.readShort(in);
		// height
		height = CppHelper.readShort(in);
		// width
		width = CppHelper.readShort(in);
		// reserve2
		reserve2 = CppHelper.readShort(in);
		
		// 根据人行标准，宽度、高度必须为32
		width = 32;
		height = 32;
		
		// data
		in.read(data);
	}
	
	
	public void outputImage(OutputStream out) throws IOException
	{
		int imageSize = height * width * num / 8;
		int fileSize = 14 + 40 + 8 + imageSize;
		
		DataOutputStream dataOut = new DataOutputStream(out);
		
		CppHelper.writeBytes(dataOut, new byte[] { 'B', 'M' }); 		// FileType 位图文件的类型，
		CppHelper.writeInt32(dataOut, fileSize); 						// FileSize 4 位图文件的大小 2-5 字节
		CppHelper.writeInt16(dataOut, 0); 								// Reserved1 2 位图文件保留字 6-7 字节
		CppHelper.writeInt16(dataOut, 0); 								// Reserved2 2 位图文件保留字 (8-9 字节 )
		CppHelper.writeInt32(dataOut, 14 + 40 + 8); 					// BitmapOffset 位图数据的起始位置，以相对于位图 (10-13 字节
		CppHelper.writeInt32(dataOut, 40); 								// Size 2 本结构所占用字节数 (14-17 字节 ) 　
		CppHelper.writeInt32(dataOut, width * num); 					// Width 2 位图的宽度，以像素为单位 (18-21 字节 ) 　
		CppHelper.writeInt32(dataOut, height); 							// Height 位图的高度，以像素为单位 (22-25 字节 ) 级别，
		CppHelper.writeInt16(dataOut, 24); 								// BitsPerPixel 目标设备的级别 26-27 字节
		CppHelper.writeInt16(dataOut, 1); 								// 每个像素所需的位数，必须是 1( 双色 ),(28-29 字节 )
		CppHelper.writeInt32(dataOut, 0); 								// 位图压缩类型，必须是 0(30-33 字节 )
		CppHelper.writeInt32(dataOut, height * width * num / 8); 		// SizeOfBitmap 位图的大小，以字节为单位 (34-37 字节 )
		CppHelper.writeInt32(dataOut, 0); 								// HorzResolution 位图水平分辨率，每米像素数 (38-41 字节 ) 　
		CppHelper.writeInt32(dataOut, 0); 								// VertResolution 位图垂直分辨率，每米像素数 (42-45 字节 ) 　　
		CppHelper.writeInt32(dataOut, 0); 								// ColorsUsed 位图实际使用的颜色表中的颜色数 (46-49 字节 ) 　　
		CppHelper.writeInt32(dataOut, 0); 								// ColorsImportant 位图显示过程中重要的颜色数 (50-53 字节 )
		CppHelper.writeBytes(dataOut, new byte[] { 0, 0, 0, 0, (byte) 255, (byte) 255, (byte) 255, 0 });
		
		byte[] resultImage = new byte[32 * 4 * num];
		
		/*
		for (int k = 0; k < num; k++)
		{
			for (int i = 0; i < 32 * 4; i += 4)
			{
				for (int j = 0; j < 32; j++)
				{
					resultImage[j * 4 * num + k * 4 + (i / 4 / 8)] = (byte) (
						(resultImage[j * 4 * num + k * 4 + (i / 4 / 8)] << 1) | 
						(data[k * 32 * 4 + i + (j / 8)] >> (j % 8)) & 1
					);
				}
			}
		}
		*/
		
		// BMP采用网络字节流格式，需要翻转倒立再合并？
		for(int k = 0; k < num; k++)
		{
			for(int i = 0; i < 32; i++)
			{
				for(int j = 0; j < 32; j++)
				{
					//System.out.println("resultImage["+(j*4*num + k*4 + i/8)+"]" +"= " + 
					//		(resultImage[j*4*num + k*4 + i/8] << 1) + " | "+ "(data["+(k*32*4 + i*4 + (j/8))+"] >>"+ j%8+") & 1 = " +
					//		((resultImage[j*4*num + k*4 + i/8] << 1) | (data[k*32*4 + i*4 + (j/8)] >> j%8) & 1));
					
					resultImage[j*4*num + k*4 + i/8] = 
						(byte)((resultImage[j*4*num + k*4 + i/8] << 1) | (data[k*32*4 + i*4 + (j/8)] >> j%8) & 1);
				}
			}
		}
		
		CppHelper.writeBytes(dataOut, resultImage, 0, imageSize);
	}
	
	public void outputImage(File file) throws IOException
	{
		FileOutputStream fos = null;
		try
		{
			file.getParentFile().mkdirs();
			fos = new FileOutputStream(file);
			this.outputImage(fos);
		}
		finally
		{
			if( fos!=null )
			{
				fos.close();
			}
		}
	}
	
	public BufferedImage getImage()
	{
		try
		{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			outputImage(bos);
			return ImageIO.read(new ByteArrayInputStream(bos.toByteArray()));
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	
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
}
