package com.grgbanking.sent.stride.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.core.spring.SpringContextHolder;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;

public class StrideZipFsnContentUtil {
	protected static Logger logger = LoggerFactory
			.getLogger(StrideZipFsnContentUtil.class);

	public static String STRIDE_PATH = "";
	public static String STRIDE_PATH_TEMP= "";
	public static String FSN_PATH = "";
	
	public static String STRIDE_PATH_DEFUALT = "/home/feel/SeNT/FsnfileUpload/stride/";
	public static String STRIDE_PATH_TEMP_DEFUALT= "/home/feel/SeNT/FsnfileUpload/strideTemp/";
	public static String FSN_PATH_DEFUALT = "/home/feel/SeNT/ImageUpload/";

	/**
	 * 根据日期字符串删除文件夹
	 * 
	 * @param date
	 * @return
	 */
	public synchronized static boolean deleteDir(String date) {
		File f = new File(getStridePathTemp() + date);
		if (!f.canWrite()) {
			logger.info("文件没有删除权限!");
			return false;
		}
		if (!f.exists())
			return false;
		return f.delete();
	}

	/**
	 * 根据当前时间生成文件夹
	 * 
	 * @return String 时间字符串 如果创建失败返回null
	 */
	public synchronized static String createDirByNow() throws IOException{
		Date d = new Date();
		File f = new File(getStridePathTemp() + d.toString());
		if (f.exists()) {
			return d.toString();
		} else {
			try {
				f.createNewFile();
				return d.toString();
			} catch (IOException e) {
				throw e;
			}
		}
	}
	
	
	
	/**
	 * 复制一个包号下所有FSN文件
	 * @param files FSN文件数组 files[0]:日期  files[1]:FSN文件名  files[2]:捆号
	 * @param bagCode 包号 
	 * @return 复制成功个数
	 */
	public static int copyFsns(String[][] files,String bagCode){
		int success=0;
		for (int i = 0; i < files.length; i++) {
			String[] file = files[i];
			try {
				if(copyFsn(file[1], file[2]+""+file[0]+".fsn",bagCode))
					success++;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	/**
	 * 复制一个包号下所有FSN文件
	 * @param files FSN文件数组 files[0]:日期  files[1]:FSN文件名  files[2]:捆号  files[3]:年月日  files[4]:机具编号
	 * @param bagCode 包号 
	 * @return 复制成功个数
	 */
	public static int copyFsns(List<String[]> files,String bagCode) throws IOException{
		int success=0;
		for (int i = 0; i < files.size(); i++) {
			String[] file = files.get(i);
			try {
				if(copyFsn(file[3]+File.separator+file[4]+File.separator+file[1], file[2]+"_"+file[0]+".fsn",bagCode))
					success++;
			} catch (FileNotFoundException e) {
				throw e;
			} catch (IOException e) {
				throw e;
			}
		}
		return success;
	}
	
	/**
	 * 复制并压缩FSN文件
	 * @param files FSN文件数组 files[0]:日期  files[1]:FSN文件名  files[2]:捆号  files[3]:年月日  files[4]:机具编号
	 * @param bagCode 包号
	 * @return 成功FSN文件个数
	 */
	public static int copyAndZip(List<String[]> files,String bagCode,StrideZipFsnContent content) throws IOException{
		int count = copyFsns(files, bagCode);
		try {
			//生成GZH文件
			write(content);
			//压缩打包
			ZipUtil.zip(getStridePathTemp()+bagCode+File.separator+content.getBankCode()+"_"+bagCode+"_"+content.getTranTime()+".zip", null, getStridePathTemp()+bagCode, new String[]{".fsn",".gzh"});
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		return count;
	}
	
	/**
	 * 下载跨地导入的zip文件
	 * @param files 需要压缩的zip文件名集合
	 * @return zip包绝对路径
	 */
	public static String downLoadZip(String[] files,String date) throws IOException{
		if(files==null || files.length==0)return null;
		//需要打包的zip路径数组
		//String[] dirFiles = new String[files.length];
		List<String> dirFiles = new ArrayList<String>();
		String path = getStridePathTemp();
		String bankCode = "";//报送银行编码
		for (int i = 0; i < files.length; i++) {
			if(StringUtil.isBlank(files[i]))
				continue;
			String[] f = files[i].split("_");
			if(f.length!=3){
				logger.info(files[i]+"文件名有误");
				continue;
			}
			if(bankCode==""){
				bankCode = f[0];
			}
			dirFiles.add(path+f[1]+File.separator+files[i]);
		}
		if(dirFiles.isEmpty())return null;
//		Date date = new Date();
		String[] zipFiles = new String[dirFiles.size()];
		String zipFileName = null;
		try {
//			zipFileName = ZipUtil.zip(path+bankCode+"_"+dirFiles.size()+"_"+DateUtil.getTimeYYYYMMDDHHMMSSString(date)+".zip", dirFiles.toArray(zipFiles));
			zipFileName = ZipUtil.zip(path+bankCode+"_"+dirFiles.size()+"_"+date+".zip", dirFiles.toArray(zipFiles));
			logger.info(zipFileName+"文件压缩完成");
		} catch (IOException e) {
			throw e;
		}
		return zipFileName;
	}
	

	/**
	 * 拷贝FSN文件
	 * 
	 * @param fromFileName
	 *            复制文件名
	 * @param toFileName
	 *            粘贴文件名
	 * @param bagCode 包号        
	 * @return boolean
	 */
	public static synchronized boolean copyFsn(String fromFileName, String toFileName,String bagCode) throws FileNotFoundException,IOException{
		if (StringUtil.isBlank(fromFileName)
				|| !fromFileName.toLowerCase().endsWith(".fsn"))
			return false;
		if (StringUtil.isBlank(toFileName)) {
			toFileName = fromFileName;
		}
		if (!toFileName.toLowerCase().endsWith(".fsn")) {
			toFileName += ".fsn";
		}
		File fromFile = new File(getFsnPath()+fromFileName);
		File toFile = ZipUtil.buildFile(getStridePathTemp()+bagCode+File.separator+toFileName, false);

		if (!fromFile.exists()) {
			logger.info(fromFileName + "文件不存在!");
			return false;
		}
		if (!fromFile.canRead()) {
			logger.info(fromFileName + "文件没有读取权限不存在!");
			return false;
		}
		boolean isSuccess = false;
		if (!toFile.exists()) {
			try {
				isSuccess = toFile.createNewFile();
			} catch (IOException e) {
				throw e;
			}
		}

		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel fin = null;
		FileChannel fout = null;

		try {
			fi = new FileInputStream(fromFile);
			fo = new FileOutputStream(toFile);
			fin = fi.getChannel();
			fout = fo.getChannel();
			fin.transferTo(0, fin.size(), fout);
			isSuccess = true;
		} catch (FileNotFoundException e) {
			isSuccess = false;
			throw e;
		} catch (IOException e) {
			isSuccess = false;
			throw e;
		} finally {
			if(fout!=null) fout.close();
			if(fin!=null) fin.close();
			if(fo!=null) fo.close();
			if(fi!=null) fi.close();
		}
		return isSuccess;
	}
	
	

	/**
	 * 生成GZH文件
	 */
	public static void write(StrideZipFsnContent content) throws IOException{
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			File file = new File(getStridePathTemp()+ content.getBagCode()+ File.separator + content.getBankCode() + "_"
					+ content.getBagCode() + "_" + content.getTranTime() + ".GZH");
			if (!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(content.toString());
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if(bw != null)
					bw.close();
				if(fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取文件进行解释入库
	 * @param parentDir dirName的父目录,非递归调用时,该参数为null 
	 * @param dirName 上传文件名,即是上传zip文件名,解释后生成的文件夹
	 * @param contents 数据返回集合
	 */
	public static StrideZipFsnContent read(String parentDir,String dirName,List<StrideZipFsnContent> contents) throws IOException{
		FileReader fr = null;
		BufferedReader br = null;
		StrideZipFsnContent content = null;
		File file = new File(getStridePath()+(StringUtil.isBlank(parentDir)?"":parentDir+File.separator)+dirName);
		if(file.exists()){
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				File f = files[i];
				if(f.isDirectory()){
					content = read((StringUtil.isBlank(parentDir)?"":parentDir+File.separator)+dirName,f.getName(),contents);
					/*if(content!=null){
						contents.add(content);
					}*/
				}else{
					if(f.isFile() && "GZH".equals(f.getName().substring(f.getName().lastIndexOf(".")+1).toUpperCase())){
						try {
							fr = new FileReader(f);
							br = new BufferedReader(fr);
							String s = br.readLine();
							if(StringUtil.isBlank(s))
								return content;
							String[] str = s.split(StrideZipFsnContent.POINT);
							if(str.length!=10){
								logger.info("GZH文件文件不合法");
								return content;
							}
							if(content==null){
								content = new StrideZipFsnContent(str[0],str[1],str[2],str[3],Integer.parseInt(str[4]),str[5],Integer.parseInt(str[6]),str[7],str[8],str[9]);
								contents.add(content);
							}else{
								//content = new StrideZipFsnContent(str[0],str[1],str[2],str[3],Integer.parseInt(str[4]),str[5],Integer.parseInt(str[6]),str[7],str[8],str[9]);
								content.setTranTime(str[0]);
								content.setBankCode(str[1]);
								content.setFromCode(str[2]);
								content.setBusinessType(str[3]);
								content.setCount(Integer.parseInt(str[4]));
								content.setCashType(str[5]);
								content.setVersion(Integer.parseInt(str[6]));
								content.setBagCode(str[7]);
								content.setCurrency(str[8]);
								content.setReserve(str[9]);
							}
							if(StringUtil.isNotBlank(parentDir)){
								content.setParentFileName(parentDir+".zip");
							}
							content.setFileName(dirName+".zip");
						} catch (FileNotFoundException e) {
							throw e;
						}finally{
							try {
								if(br!=null)
									br.close();
								if(fr!=null)
									fr.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}else if(f.isFile() && "FSN".equals(f.getName().substring(f.getName().lastIndexOf(".")+1).toUpperCase())){
						//FSN文件
						//bundles.add(f.getName());
						if(content!=null)
							content.getBundles().add(f.getName());
						else{
							content = new StrideZipFsnContent();
							contents.add(content);
							content.getBundles().add(f.getName());
						}
					}else{
						logger.info("非法文件");
					}
				}
			}
		}
		return content;
	}
	
	/**
	 * 返回存放跨行调款zip文件路径
	 * @return
	 */
	public static String getStridePath(){
		if(StringUtil.isBlank(STRIDE_PATH)){
			ParamDao paramDao = SpringContextHolder.getBean("paramDao");
			String temp = paramDao.getValueByPathWithException(AppConstants.FSN_STRIDE_PATH);
			STRIDE_PATH = StringUtil.isBlank(temp)?STRIDE_PATH_DEFUALT:temp;
			STRIDE_PATH = STRIDE_PATH.endsWith(File.separator) ? STRIDE_PATH : STRIDE_PATH + File.separator;
			ZipUtil.buildFile(STRIDE_PATH, true);
		}
		return STRIDE_PATH;
	}

	/**
	 * 返回打包FSN临时目录
	 * @return
	 */
	public static String getStridePathTemp() {
		if(StringUtil.isBlank(STRIDE_PATH_TEMP)){
			ParamDao paramDao = SpringContextHolder.getBean("paramDao");
			String temp = paramDao.getValueByPathWithException(AppConstants.FSN_STRIDE_PATHTEMP_FOR_ZIP);
			STRIDE_PATH_TEMP = StringUtil.isBlank(temp)?STRIDE_PATH_TEMP_DEFUALT:temp;
			STRIDE_PATH_TEMP = STRIDE_PATH_TEMP.endsWith(File.separator) ? STRIDE_PATH_TEMP : STRIDE_PATH_TEMP + File.separator;
			ZipUtil.buildFile(STRIDE_PATH_TEMP, true);
		}
		return STRIDE_PATH_TEMP;
	}
	
	/**
	 * 返回存放FSN文件目录
	 * @return
	 */
	public static String getFsnPath(){
		if(StringUtil.isBlank(FSN_PATH)){
			ParamDao paramDao = SpringContextHolder.getBean("paramDao");
			String temp = paramDao.getValueByPathWithException(AppConstants.FSN_PICPATH);
			FSN_PATH = StringUtil.isBlank(temp)?FSN_PATH_DEFUALT:temp;
			FSN_PATH = FSN_PATH.endsWith(File.separator) ? FSN_PATH : FSN_PATH + File.separator;
		}
		return FSN_PATH;
	}
	
	/**
	 * zip文件导入接口
	 * @param name zip文件名
	 * @throws IOException
	 */
	public static List<StrideZipFsnContent> importZip(String name) throws IOException{
		String path = getStridePath();
		ZipUtil.unzip(path+name, null);
        String dir = name.substring(0,name.lastIndexOf("."));
        File file = new File(path+dir);
        if(file.isDirectory()){
     	   File[] files = file.listFiles();
     	   if(files.length>0){
     		   for (int i = 0; i < files.length; i++) {
     			   File s = files[i];
     			   if(s.getName().lastIndexOf(".zip")!=-1){
     				   ZipUtil.unzip(path+dir+File.separator+s.getName(), null);
     			   }
     		   }
     	   }
        }
        List<StrideZipFsnContent> contents = new ArrayList<StrideZipFsnContent>();
        read(null,dir,contents);
        logger.info("文件中包个数:"+contents.size());
        return contents;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		StrideZipFsnContent zip = new StrideZipFsnContent("20150306115056",
//				"54543", "34656565", "24545", 6, "4546rfgfg", 1, "dgdg",
//				"re", "rteff");
//		try {
//			//write(zip);
////			downLoadZip(new String[]{"55555_8ce689d00573427ca8fc068b3faef475_20150306115056.zip"});
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
