package com.grgbanking.sent.utils.crhUtil;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.grgbanking.sent.transmgr.entity.CmlSentInfo;
import com.grgbanking.sent.utils.fsnUtils.WriteUtil;

public class GenCrh {

	public static void main(String[] args) {

		try {
			// 写文件
			File f = new File("D:\\temp\\aa.CRH");
			// 判断目标文件所在的目录是否存在
			if (!f.getParentFile().exists()) {
				// 如果目标文件所在的目录不存在，则创建父目录
				System.out.println("目标文件所在目录不存在，准备创建它！");
				if (!f.getParentFile().mkdirs()) {
					System.out.println("创建目标文件所在目录失败！");
				} else {
					System.out.println("目录创建成功！");
				}
			}
			// 创建输出流文件对象
			FileOutputStream fos = new FileOutputStream(f);
			// 创建原始数据输出流对象
			DataOutputStream dataOut = new DataOutputStream(fos);
			genCrh("20150318121212", "A01001", "123456", "3", 5, "T", "1", "1",
					"CM400", "00010001", "111", "", dataOut, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void genCrh(String tranDateCrh, String upBankCode,
			String orgCodeCrh, String businessTypeCrh, int seriaNumCrh,
			String isClearCenterCrh, String versionCrh, String machineTypeCrh,
			String termTypeCrh, String termNumCrh, String busRelateInfoCrh,
			String reserveCrh, DataOutputStream out, List<CmlSentInfo> infoLst)
			throws IOException {
		// 1
		int year, month, day, date;
		year = Integer.parseInt(tranDateCrh.substring(0, 4));
		month = Integer.parseInt(tranDateCrh.substring(4, 6));
		day = Integer.parseInt(tranDateCrh.substring(6, 8));
		date = ((year - 1980) << 9) + (month << 5) + day;// 日期
		// int hour, minute, second, time;
		// hour = Integer.parseInt(tranDateCrh.substring(8, 10));
		// minute = Integer.parseInt(tranDateCrh.substring(10, 12));
		// second = Integer.parseInt(tranDateCrh.substring(12, 14));
		// time = (hour << 11) + (minute << 5) + (second >> 1);// 时间
		// int[] tranDateCrhInt = { date, time };
		WriteUtil.writeInt16(date, out);
		// 2
		int upBankCodeLen = upBankCode.length();
		if(upBankCodeLen < 6){
			for(int i=0;i<6-upBankCodeLen;i++){
				upBankCode = upBankCode + "_";
			}
		}
		upBankCode = upBankCode.substring(0, 6);
		out.writeBytes(upBankCode);
		// 3
		int orgCodeLen = orgCodeCrh.length();
		if(orgCodeLen < 6){
			for(int i=0;i<6-orgCodeLen;i++){
				orgCodeCrh = orgCodeCrh + "_";
			}
		}
		orgCodeCrh = orgCodeCrh.substring(0, 6);
		out.writeBytes(orgCodeCrh);
		// 4
		out.writeByte(Integer.parseInt(businessTypeCrh));
		// 5
		WriteUtil.writeInt32(seriaNumCrh, out);
		// 6
		out.write(isClearCenterCrh.toCharArray()[0]);
		// 7
		out.writeByte(Integer.parseInt(versionCrh));
		// 8
		out.writeByte(Integer.parseInt(machineTypeCrh));
		// 9
		if (termTypeCrh.length() < 8) {// "CM400"
			int l = termTypeCrh.length();
			for (int i = 0; i < 8 - l; i++) {
				termTypeCrh = "_" + termTypeCrh;
			}
		}
		char[] termTypeChar = termTypeCrh.substring(0, 8).toCharArray();
		for (char c : termTypeChar) {
			out.write(c);
		}
		// 10
		if (termNumCrh.length() < 10) {
			int l = termNumCrh.length();
			for (int i = 0; i < 10 - l; i++) {
				termNumCrh = "_" + termNumCrh;
			}
		}
		char[] termNumChar = termNumCrh.substring(0, 10).toCharArray();
		for (char c : termNumChar) {
			out.write(c);
		}
		// 11
		if (busRelateInfoCrh.length() < 50) {
			int l = busRelateInfoCrh.length();
			for (int i = 0; i < 50 - l; i++) {
				busRelateInfoCrh = "_" + busRelateInfoCrh;
			}
		}
		char[] busRelateInfoChar = busRelateInfoCrh.substring(0, 50)
				.toCharArray();
		for (char c : busRelateInfoChar) {
			out.write(c);
		}
		// 12
		reserveCrh = "__________";// 10个‘_’字符
		char[] reserveChar = reserveCrh.toCharArray();
		for (char c : reserveChar) {
			out.write(c);
		}
		// 13.冠字号码记录部分
		GenCrhItem(out, infoLst);
	}

	private static void GenCrhItem(DataOutputStream out,
			List<CmlSentInfo> infoLst) throws IOException {

		for (CmlSentInfo info : infoLst) {

			// 1
			// int year, month, day, date;
			int hour, minute, second, time;
			// year = Integer.parseInt(info.getTranDate().substring(0, 4));
			// month = Integer.parseInt(info.getTranDate().substring(4, 6));
			// day = Integer.parseInt(info.getTranDate().substring(6, 8));
			// date = ((year - 1980) << 9) + (month << 5) + day;// 日期
			hour = Integer.parseInt(info.getTranDate().substring(8, 10));
			minute = Integer.parseInt(info.getTranDate().substring(10, 12));
			second = Integer.parseInt(info.getTranDate().substring(12, 14));
			time = (hour << 11) + (minute << 5) + (second >> 1);// 时间
			WriteUtil.writeInt16(time, out);
			// out.writeChar(',');
			out.write(",".toCharArray()[0]);

			char f = 0;
			String sNO = info.getSeriaNo().replace("?", "_").replace("*", "_")
					+f+f;
			char[] sNOChar = sNO.toCharArray();
			for (char c : sNOChar) {
				out.write(c);
			}
			// out.writeChar(',');
			out.write(",".toCharArray()[0]);

			String versionNum = info.getVersionNum();
			if (versionNum.equals("9999")) {
				versionNum = "255";
			}
			// WriteUtil.writeInt16(Integer.parseInt(versionNum), out);
			out.writeByte(Integer.parseInt(versionNum));
			// out.writeChar(',');
			out.write(",".toCharArray()[0]);

			// WriteUtil.writeInt16(Integer.parseInt(info.getDenomination()),
			// out);
			String denom = info.getDenomination();
			//System.out.println(denom);
			if("100".equals(denom)){
				denom = "6";
			}else if("50".equals(denom)){
				denom = "5";
			}else if("20".equals(denom)){
				denom = "4";
			}else if("10".equals(denom)){
				denom = "3";
			}else if("5".equals(denom)){
				denom = "2";
			}else if("1".equals(denom)){
				denom = "1";
			}else{
				denom = "0";
			}
			out.writeByte(Integer.parseInt(denom));
			// out.writeChar(',');
			//out.write(",".toCharArray()[0]);
			byte[] newline = { 0x0D, 0x0A };
			out.write(newline);
		}
	}

	// 转换函数：int -> char[4]
	public static char[] changeIntToCharArr(int intValue) {

		char[] charValue = { '0', '0', '0', '0' };
		char[] param = String.valueOf(intValue).toCharArray();
		for (int i = 0; i < param.length; i++) {
			if (3 - i > -1)
				charValue[3 - i] = param[param.length - 1 - i];
		}
		return charValue;
	}

}
