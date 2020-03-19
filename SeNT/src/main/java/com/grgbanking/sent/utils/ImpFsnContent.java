package com.grgbanking.sent.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.grgbanking.sent.transmgr.entity.CmlSentInfo;


public class ImpFsnContent
{  
	//包含冠字号码信息
	public int date;//验钞启动日期 
	public int time;//验钞启动时间  
	public int tfFlag;//真、假、残和旧币标志 
	public int []errorCode = new int[3];	//错误码(3个) 
	public int [] moneyFlag = new int [3];//货币标志 
	public int ver;//版别号 
	public int valuta;//币值  
	public int charNUM;//冠字号码字符数 
	public int sNo[] = new int [12];//冠字号码 
	public int machineSNo[] = new int [24];//机具编号 
	public int reserve1 ;//保留字1
  
	public DataOutputStream out;
	
	public void writeInt16(int x) throws IOException
	{
		out.writeShort((x & 0xFF) << 8 | (x & 0xFF00) >>> 8);
	}

	// 写入int整数
	public void writeInt32(int x) throws IOException
	{
		out.writeInt((x & 0xFF) << 24 | (x & 0xFF00) << 8 | (x & 0xFF0000) >>> 8 | (x & 0xFF000000) >>> 24);
	}

	// 写入int数组
	public void writeIntArr16(int x[]) throws IOException
	{
		for( int i = 0 ; i < x.length ; i++ )
		{
			int a = x[i];
			writeInt16(a);
		}
	}

	public ImpFsnContent(OutputStream out)
	{
		this.out = new DataOutputStream(out);
	}

	public ImpFsnContent()
	{

	}

	/**
	 * 记录写入FSN文件
	 * @param cmlList   要写入FSN文件的记录列表
	 * @throws IOException
	 */
	public void expFsn(List<CmlSentInfo> cmlList) throws IOException
	{
		int count = 0;
		for( int t = 0 ; t < cmlList.size() ; t++ )
		{
			CmlSentInfo cml = cmlList.get(t);
			String tranDate    = cml.getTranDate();
			String tranYear    = tranDate.substring(0, 4);// 交易的年
			String tranMothday = cml.getTranMonthday();// 交易的月日
			String transMonth  = tranMothday.substring(0, 2);// 截取交易的月
			String tranDay     = tranMothday.substring(2, 4);// 截取交易的日

			ImpFsnContent impFsn = new ImpFsnContent();// fsn文件的内容
			int year  = Integer.parseInt(tranYear);
			int month = Integer.parseInt(transMonth);
			int day   = Integer.parseInt(tranDay);
			int date  = ((year - 1980) << 9) | (month << 5) | day;// fsn文件内容的日期
			impFsn.date = date;

			String transTime  = tranDate.substring(8, 14);
			String transHour  = transTime.substring(0, 2);
			String transMin   = transTime.substring(2, 4);
			String tranSecond = transTime.substring(4, 6);
			int hour   = Integer.parseInt(transHour);
			int minute = Integer.parseInt(transMin);
			int second = Integer.parseInt(tranSecond);
			int time = (hour << 11) | (minute << 5) | (second >> 1);// fsn文件内容的时间
			impFsn.time = time;

			int tfFlag = 0;
			if( null != cml.getNoteType() && !cml.getNoteType().equals("") )
			{
				tfFlag = Integer.parseInt(cml.getNoteType());
			}
			impFsn.tfFlag = tfFlag;// 真、假、残和旧币标志

			int errorCode[] = { 0, 0, 0 };// 错误码(3个)
			impFsn.errorCode = errorCode;

			int moneyFlag[] = { 67, 78, 89, 0 };// 货币标志
			impFsn.moneyFlag = moneyFlag;

			int ver = 0;
			if( null != cml.getVersionNum() && !"".equals(cml.getVersionNum()) )
			{
				ver = Integer.parseInt(cml.getVersionNum()); // 版别号
			}
			impFsn.ver = ver;

			int valuta = 0;
			if( null != cml.getDenomination() && !cml.getDenomination().equals("") )
			{
				valuta = Integer.parseInt(cml.getDenomination());// 币值
			}
			impFsn.valuta = valuta;

			int seriaNum = 0;
			String seriaNo = "";
			if( null != cml.getSeriaNo() && !cml.getSeriaNo().equals("") )
			{
				seriaNum = cml.getSeriaNo().length();// 冠字号码字符数
				seriaNo = cml.getSeriaNo();
			}
			impFsn.charNUM = seriaNum;// 冠字号码字符数

			int serNo[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };//
			// 遍历12个冠字号码对应的字符
			for( int j = 0 ; j < seriaNo.length() ; j++ )
			{// 最多12位
				char d = seriaNo.charAt(j);
				serNo[j] = d + 0;// 转成ascll
			}
			impFsn.sNo = serNo;// 冠字号码

			// 机具编号
			String machNo = "";
			if( null != cml.getTermId() && !"".equals(cml.getTermId()) )
			{
				machNo = cml.getTermId();
				int machinSNo[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				for( int k = 0 ; k < machNo.length() ; k++ )
				{// 必须24位
					char c = machNo.charAt(k);
					machinSNo[k] = c + 0;// 机具编号
				}
				impFsn.machineSNo = machinSNo;
			}

			impFsn.reserve1 = Integer.parseInt(cml.getReserve());
			
			writeInt16(impFsn.date);
			writeInt16(impFsn.time);
			writeInt16(impFsn.tfFlag);
			writeIntArr16(impFsn.errorCode);
			writeIntArr16(impFsn.moneyFlag);
			writeInt16(impFsn.ver);
			writeInt16(impFsn.valuta);
			writeInt16(impFsn.charNUM);
			writeIntArr16(impFsn.sNo);
			writeIntArr16(impFsn.machineSNo);
			writeInt16(impFsn.reserve1);
			
			count++;
		}
	}
}

