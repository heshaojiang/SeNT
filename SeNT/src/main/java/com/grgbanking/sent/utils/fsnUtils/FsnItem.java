package com.grgbanking.sent.utils.fsnUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class FsnItem
{
	
	//包含冠字号码信息
	private int date;//验钞启动日期 
	private int time;//验钞启动时间  
	private int tfFlag;//真、假、残和旧币标志 
	private int []errorCode = new int[3];	//错误码(3个) 
	private int [] moneyFlag = new int [4];//货币标志 
	private int ver;//版别号 
	private int valuta;//币值  
	private int charNUM;//冠字号码字符数 
	private int sNo[] = new int [12];//冠字号码 
	private int machineSNo[] = new int [24];//机具编号 
	private int reserve1 ;//保留字1
	public FsnItemImage imageSNo = null;				//图像冠字号码
	
	
	public void write( DataOutputStream out, boolean hasImage) throws IOException
	{
		// 写 date
		WriteUtil.writeInt16(date, out);
		// 写 time
		WriteUtil.writeInt16(time, out);
		// 写 tfFlag
		WriteUtil.writeInt16(tfFlag, out);
		// 写 errorCode
		WriteUtil.writeInt16Array(errorCode, out);
		// 写 moneyFlag
		WriteUtil.writeInt16Array(moneyFlag, out);
		// 写 ver
		WriteUtil.writeInt16(ver, out);
		// 写 valuta
		WriteUtil.writeInt16(valuta, out);
		// 写 charNUM
		WriteUtil.writeInt16(charNUM, out);
		// 写 sNo
		WriteUtil.writeInt16Array(sNo, out);
		// 写 machineSNo
		WriteUtil.writeInt16Array(machineSNo, out);
		// 写 reserve1
		WriteUtil.writeInt16(reserve1, out);
		
		if (hasImage)
			imageSNo.write(out);
	}

	
	public void writeTXT(DataOutputStream outTXT, int index, String zipFileName) throws IOException {
		
		outTXT.write((this.getDateStr() + this.getTimeStr()).getBytes());
		outTXT.write(',');
		outTXT.write((""+this.tfFlag).getBytes());
		outTXT.write(',');
		outTXT.write(this.getErrorCodeStr().getBytes());
		outTXT.write(',');
		outTXT.write("CNY".getBytes());
		outTXT.write(',');
		outTXT.write((""+this.ver).getBytes());
		outTXT.write(',');
		outTXT.write((""+this.valuta).getBytes());
		outTXT.write(',');
		outTXT.write(this.getSerialNoStr().getBytes());
		outTXT.write(',');
		outTXT.write(this.getMachineSNoStr().getBytes());
		outTXT.write(',');
		outTXT.write(("/FSNData/20140802/fsn/"+ zipFileName).getBytes());
		outTXT.write(',');
		outTXT.write((""+index).getBytes());
		outTXT.write("\n".getBytes());
	}
	
	
	public void setDate(int date) {
		this.date = date;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setTfFlag(int tfFlag) {
		this.tfFlag = tfFlag;
	}

	public void setErrorCode(int[] errorCode) {
		this.errorCode = errorCode;
	}

	public void setMoneyFlag(int[] moneyFlag) {
		this.moneyFlag = moneyFlag;
	}

	public void setVer(int ver) {
		this.ver = ver;
	}

	public void setValuta(int valuta) {
		this.valuta = valuta;
	}

	public void setCharNUM(int charNUM) {
		this.charNUM = charNUM;
	}

	public void setsNo(int[] sNo) {
		this.sNo = sNo;
	}

	public void setMachineSNo(int[] machineSNo) {
		this.machineSNo = machineSNo;
	}

	public void setReserve1(int reserve1) {
		this.reserve1 = reserve1;
	}

	public void setImageSNo(FsnItemImage imageSNo) {
		this.imageSNo = imageSNo;
	}
	
	
	
	public String getDateStr() {
		int day = (this.date & 0x01f);
		int month = (this.date >> 5) & 0x0f;
		int year = (this.date >> 9) + 1980;
		//return year+"-"+month+"-"+day;
		return WriteUtil.df.format(year)+""+WriteUtil.df.format(month)+""+WriteUtil.df.format(day);
	}
	
	public String getTimeStr() {
		int second = (this.time & 0x1f) << 1;
		int minute = (this.time >> 5) & 0x3f;
		int hour   = (this.time >> 11);
//		return df.format(hour)+":"+df.format(minute)+":"+df.format(second);
		return WriteUtil.df.format(Math.abs(hour))+""+WriteUtil.df.format(minute)+""+WriteUtil.df.format(second);
	}
	
	public String getSerialNoStr() {
		char[] chars = new char[this.sNo.length];
		for( int i=0; i<chars.length; i++ ) {
			chars[i] = (char)this.sNo[i];
		}
		return new String(chars).trim();
	}
	
	public String getErrorCodeStr() {
		StringBuilder sb = new StringBuilder();
		for( int i=0; i<this.errorCode.length; i++ ) {
			sb.append(""+this.errorCode[i]);
			sb.append(";");
		}
		String codeStr = sb.toString();
		return codeStr.substring(0, codeStr.length()-1);
	}
	
	
	public String getMoneyFlagStr() {
		char[] chars = new char[moneyFlag.length];
		for( int i=0; i<chars.length; i++ ) {
			chars[i] = (char)moneyFlag[i];
		}
		return new String(chars).trim();
	}
	
	
	public String getMachineSNoStr() {
		char[] chars = new char[this.machineSNo.length];
		for( int i=0; i<chars.length; i++ ) {
			chars[i] = (char)this.machineSNo[i];
		}
		return new String(chars).trim();
	}
}
