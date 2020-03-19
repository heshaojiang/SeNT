package com.grgbanking.sent.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ResultBMP {

	private static int FSN_HEAD_LENGTH = 32;

	private static int[] Machine_CONTENT = { 2, 2, 2, 6, 8, 2, 2, 2, 24, 48, 2 };
	
	private static int[] IMAGE_CONTETN = {2, 2, 2, 2 };

	private static int IMAGE_SIZE = 1536; 
	
	private static int SIGN_SIZE = 1644;
	private DataInputStream in;

	private DataOutputStream out;
	
	private int index;

	public ResultBMP(InputStream in, OutputStream out ,int index) throws IOException {

		this.in = new DataInputStream(in);
		this.out = new DataOutputStream(out); 
		this.index = index;
		write();
	}

	public void writeBytes(byte[] b, int off, int len) throws IOException {
		out.write(b);
	}

	public void writeInt16(int x) throws IOException {
		out.writeShort((x & 0xFF) << 8 | (x & 0xFF00) >>> 8);
	}

	public void writeInt32(int x) throws IOException {
		out.writeInt((x & 0xFF) << 24 | (x & 0xFF00) << 8
				| (x & 0xFF0000) >>> 8 | (x & 0xFF000000) >>> 24);
	}

	/**
	 * 在字节数组offset的位置读取两个字节转为short类型返回，往前读取
	 */
	public static short constructShort(byte[] in, int offset) {

		short ret = (short) ((short) in[offset + 1] & 0xff);

		ret = (short) ((ret << 8) | (short) ((short) in[offset + 0] & 0xff));

		return (ret);

	}

	/**
	 * 在字节数组start的位置读取4个字节转为int类型返回,往回读取
	 */
	public static int constructInt(byte[] bi, int start) {

		return (((int) bi[start] & 0xff) << 24)
				| (((int) bi[start - 1] & 0xff) << 16)
				| (((int) bi[start - 2] & 0xff) << 8) | (int) bi[start - 3]
				& 0xff;
	}

	public synchronized void write() throws IOException {
		int num, width, height,fileSize ,imageSize;
		if (null != in) {
		
			in.skip(FSN_HEAD_LENGTH + index * SIGN_SIZE);
			/*	in.skip(FSN_HEAD_LENGTH );*/
		
			
	
			List<byte[]> res = new ArrayList<byte[]>();
			for (int i = 0; i < Machine_CONTENT.length; i++) {
				byte[] temp = new byte[Machine_CONTENT[i]];
				in.read(temp);
				res.add(temp);

			}
			
			int[] result = new int[IMAGE_CONTETN.length];
			for (int i = 0; i < IMAGE_CONTETN.length; i++) {
				byte[] tempbyte = new byte[IMAGE_CONTETN[i]];
				in.read(tempbyte);
				result[i] = constructShort(tempbyte, 0);

			}
			num = result[0];
			//width = result[1] * num;
			//height = result[2];
			width = 32;
			height = 32;
			imageSize = height * 4 * num;
			fileSize = 14 + 40 + imageSize  + 8;
			writeBytes(new byte[] { 'B', 'M' }, 0, 2); // FileType 位图文件的类型，
			// 0-1字节
			writeInt32(fileSize); // FileSize 4 位图文件的大小 2-5 字节
			writeInt16(0); // Reserved1 2 位图文件保留字 6-7 字节
			writeInt16(0); // Reserved2 2 位图文件保留字 (8-9 字节 )
			writeInt32(14 + 40 + 8); // BitmapOffset 位图数据的起始位置，以相对于位图 (10-13 字节
			// )
			writeInt32(40); // Size 2 本结构所占用字节数 (14-17 字节 ) 　
			writeInt32(width * num); // Width 2 位图的宽度，以像素为单位 (18-21 字节 ) 　
			writeInt32(height); // Height 　位图的高度，以像素为单位 (22-25 字节 ) 级别，
			writeInt16(24); // BitsPerPixel 目标设备的级别 26-27 字节
			writeInt16(1); // 每个像素所需的位数，必须是 1( 双色 ),(28-29 字节 )
			writeInt32(0); // 位图压缩类型，必须是 0(30-33 字节 )
			writeInt32(imageSize); // SizeOfBitmap 位图的大小，以字节为单位 (34-37 字节 )
			writeInt32(0); // HorzResolution 位图水平分辨率，每米像素数 (38-41 字节 ) 　
			writeInt32(0); // VertResolution 位图垂直分辨率，每米像素数 (42-45 字节 ) 　　
			writeInt32(0); // ColorsUsed 位图实际使用的颜色表中的颜色数 (46-49 字节 ) 　　
			writeInt32(0); // ColorsImportant 位图显示过程中重要的颜色数 (50-53 字节 )
			writeBytes(new byte[] { 0, 0, 0, 0, (byte) 255, (byte) 255,
					(byte) 255, 0 }, 0, 8);
			byte[] image = new byte[IMAGE_SIZE];
			in.read(image);
			byte[] resultImage = new byte[32 * 4 *num];
			for (int k = 0; k < num ; k++) {
				for (int i = 0; i < 32 * 4 ; i += 4) {
					for (int j = 0; j < 32; j++) {
						resultImage[j * 4 * num + k*4 + (i /4/ 8)] = (byte) ((resultImage[j * 4 * num + k*4
								+ (i / 4/8)] << 1) | (image[k*32*4 + i + ( j / 8)] >> (j % 8)) & 1);
					}
				}
				}
				writeBytes(resultImage, 0, imageSize);
				in.close();
				out.flush();
				out.close();
	
		}

	}
	public static void main(String[] args)  throws IOException{
		 
		 
		 Long begin = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			 File f =new File("d:\\20130226_72172111_CNYGZHM.FSN");
			 	for (int  j= 0;  j< 10; j++) {
			 			FileInputStream  		in = new FileInputStream(f);
			 			FileOutputStream out =new FileOutputStream("D:\\temp\\temp"+j+i+".bmp");	
					    ResultBMP  b2  = new ResultBMP(in,out, j+i);
			
			 				 
					
			 	} 
			
			
		} 
			
		/*	ResultBMP  b2  =
				new ResultBMP(new FileInputStream("E:\\fsn\\CNYGZHM.FSN"),
						new FileOutputStream("D:\\temp\\temp"+i+".bmp"), i);
			 */
			Long between = System.currentTimeMillis() - begin;
			System.out.println(between);
			
		} 
		
		
		
	
		
	 
		
	}

