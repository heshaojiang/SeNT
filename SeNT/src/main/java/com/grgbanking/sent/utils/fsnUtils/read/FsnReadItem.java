package com.grgbanking.sent.utils.fsnUtils.read;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import com.grgbanking.sent.utils.fsnUtils.WriteUtil;



public class FsnReadItem
{

	public short date;									//验钞启动日期
	public short time;		  							//验钞启动时间
	public short tfFlag;								//真、假、残和旧币标志
	public short[] errorCode = new short[3];  			//错误码(3个)
	public short[] moneyFlag = new short[4]; 			//货币标志
	public short ver;           						//版本号
	public short valuta;								//币值
	public short charNUM;	  							//冠字号码字符数
	public short[] sNo = new short[12];					//冠字号码
	public short[] machineSNo = new short[24];			//机具编号
	public short reserve1 ;      						//保留字1
	public FsnItemImage imageSNo = null;				//图像冠字号码
	
	public static int sizeWithoutImage()
	{
		return	2 + 				//date = 0;								//验钞启动日期
				2 + 				//time;		  							//验钞启动时间
				2 + 				//tfFlag;								//真、假、残和旧币标志
				2*3 + 				//errorCode = new short[3];  			//错误码(3个)
				2*4 + 				//moneyFlag = new short[4]; 			//货币标志
				2 + 				//ver;           						//版本号
				2 + 				//valuta;								//币值
				2 + 				//charNUM;	  							//冠字号码字符数
				2*12 + 				//sNo = new short[12];					//冠字号码
				2*24 + 				//machineSNo = new short[24];			//机具编号
				2 ; 				//reserve1 ;      						//保留字1
	}
	
	public static int size()
	{
		return	sizeWithoutImage() + 
				FsnItemImage.size();	//imageSNo = new FsnItemImage();	//图像冠字号码
	}
	
	public void read( DataInputStream in, boolean isContainImage ) throws IOException
	{
		// 读 date
		date = CppHelper.readShort(in);
		// 读 time
		time = CppHelper.readShort(in);
		// 读 tfFlag
		tfFlag = CppHelper.readShort(in);
		// 读 errorCode
		for( int i=0; i<errorCode.length; i++ )
		{
			errorCode[i] = CppHelper.readShort(in);
		}
		// 读 moneyFlag
		for( int i=0; i<moneyFlag.length; i++ )
		{
			moneyFlag[i] = CppHelper.readShort(in);
		}
		// 读 ver
		ver = CppHelper.readShort(in);
		// 读 valuta
		valuta = CppHelper.readShort(in);
		// 读 charNUM
		charNUM = CppHelper.readShort(in);
		// 读 sNo
		for( int i=0; i<sNo.length; i++ )
		{
			sNo[i] = CppHelper.readShort(in);
		}
		// 读 machineSNo
		for( int i=0; i<machineSNo.length; i++ )
		{
			machineSNo[i] = CppHelper.readShort(in);
		}
		// 读 reserve1
		reserve1 = CppHelper.readShort(in);
		// imageSNo
		if( isContainImage )
		{
			imageSNo = new FsnItemImage();
			imageSNo.read(in);
		}
	}
	
	public String getDate()
	{
		int day = (this.date & 0x01f);
		int month = (this.date >> 5) & 0x0f;
		int year = (this.date >> 9) + 1980;
		return year+"-"+month+"-"+day;
	}
	
	public String getTime()
	{
		DecimalFormat df = new DecimalFormat("00");
		int second = (this.time & 0x1f) << 1;
		int minute = (this.time >> 5) & 0x3f;
		int hour   = (this.time >> 11);
		return df.format(hour)+":"+df.format(minute)+":"+df.format(second);
	}
	
	public String getSerialNo()
	{
		char[] chars = new char[sNo.length];
		for( int i=0; i<chars.length; i++ )
		{
			chars[i] = (char)sNo[i];
		}
		return new String(chars).trim();
	}
	
	public String getErrorCode()
	{
		StringBuilder sb = new StringBuilder();
		for( int i=0; i<errorCode.length; i++ )
		{
			sb.append(""+errorCode[i]);
			sb.append(",");
		}
		return sb.toString();
	}
	
	
	public String getMoneyFlag()
	{
		char[] chars = new char[moneyFlag.length];
		for( int i=0; i<chars.length; i++ )
		{
			chars[i] = (char)moneyFlag[i];
		}
		return new String(chars).trim();
	}
	
	
	public String getMachineSNo()
	{
		char[] chars = new char[machineSNo.length];
		for( int i=0; i<chars.length; i++ )
		{
			chars[i] = (char)machineSNo[i];
		}
		return new String(chars).trim();
	}
	
	public BufferedImage getImage()
	{
		if( this.imageSNo==null )
		{
			return null;
		}
		else
		{
			return this.imageSNo.getImage();
		}
	}
	
	
	
	public void write( DataOutputStream out, boolean hasImage) throws IOException
	{
		// 写 date
		WriteUtil.writeInt16(date, out);
		// 写 time
		WriteUtil.writeInt16(time, out);
		// 写 tfFlag
		WriteUtil.writeInt16(tfFlag, out);
		// 写 errorCode
		WriteUtil.writeShortArray(errorCode, out);
		// 写 moneyFlag
		WriteUtil.writeShortArray(moneyFlag, out);
		// 写 ver
		WriteUtil.writeInt16(ver, out);
		// 写 valuta
		WriteUtil.writeInt16(valuta, out);
		// 写 charNUM
		WriteUtil.writeInt16(charNUM, out);
		// 写 sNo
		WriteUtil.writeShortArray(sNo, out);
		// 写 machineSNo
		WriteUtil.writeShortArray(machineSNo, out);
		// 写 reserve1
		WriteUtil.writeInt16(reserve1, out);
		
		if (hasImage)
			imageSNo.write(out);
	}
	
}
