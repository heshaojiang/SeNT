package com.grgbanking.sent.stride.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.sent.utils.StringUtil;

public class ZipUtil {

	protected static Logger logger = LoggerFactory.getLogger(ZipUtil.class);

	/**
	 * 压缩
	 * 
	 * @param zipFileName
	 *            压缩产生的zip包文件名--带路径,如果为null或空则默认按文件名生产压缩文件名
	 * @param relativePath
	 *            相对路径，默认为空
	 * @param directory
	 *            文件或目录的绝对路径
	 * @param fileTypes
	 *            [] 压缩文件类型后缀 如:.fsn,.gzh
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void zip(String zipFileName, String relativePath,
			String directory, String[] fileTypes) throws FileNotFoundException,
			IOException {
		String fileName = zipFileName;
		if (fileName == null || fileName.trim().equals("")) {
			File temp = new File(directory);
			if (temp.isDirectory()) {
				fileName = (directory.endsWith(File.separator) ? directory
						: directory + File.separator) + temp.getName() + ".zip";
			} else {
				if (directory.indexOf(".") > 0) {
					fileName = directory.substring(0,
							directory.lastIndexOf("."))
							+ "zip";
				} else {
					fileName = directory + ".zip";
				}
			}
		}
		ZipOutputStream zos = new ZipOutputStream(
				new FileOutputStream(fileName));
		try {
			zip(zos, StringUtil.isBlank(relativePath) ? "" : relativePath,
					directory, fileName, fileTypes);
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (null != zos) {
				zos.close();
			}
		}
	}

	/**
	 * 压缩
	 * 
	 * @param zos
	 *            压缩输出流
	 * @param relativePath
	 *            相对路径
	 * @param absolutPath
	 *            文件或文件夹绝对路径
	 * @param fileZipName
	 *            压缩文件名
	 * @param fileTypes
	 *            TODO
	 * @throws IOException
	 */
	private static void zip(ZipOutputStream zos, String relativePath,
			String absolutPath, String fileZipName, String[] fileTypes)
			throws IOException {
		File file = new File(absolutPath);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				File tempFile = files[i];
				if (tempFile.isDirectory()) {
					String newRelativePath = relativePath + tempFile.getName()
							+ File.separator;
					createZipNode(zos, newRelativePath);
					zip(zos, newRelativePath, tempFile.getPath(), fileZipName,
							fileTypes);
				} else {
					zipFile(zos, tempFile, relativePath, fileTypes);
				}
			}
		} else {
			zipFile(zos, file, relativePath, fileTypes);
		}
	}

	/**
	 * 根据需要打包的文件名集合压缩文件
	 * 
	 * @param zipFileName
	 *            压缩生成文件名
	 * @param toZipFiles
	 *            需要压缩的文件集合
	 * @throws IOException
	 */
	public synchronized static String zip(String zipFileName,
			String[] toZipFiles) throws IOException {
		if (StringUtil.isBlank(zipFileName) || toZipFiles == null
				|| toZipFiles.length == 0)
			return "";
		if (!zipFileName.toLowerCase().endsWith(".zip"))
			zipFileName += ".zip";
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(new FileOutputStream(zipFileName));
			for (int i = 0; i < toZipFiles.length; i++) {
				File file = new File(toZipFiles[i]);
				ZipEntry entry = new ZipEntry(file.getName());
				zos.putNextEntry(entry);
				InputStream is = null;
				try {
					is = new FileInputStream(file);
					int BUFFERSIZE = 2 << 10;
					int length = 0;
					byte[] buffer = new byte[BUFFERSIZE];
					while ((length = is.read(buffer, 0, BUFFERSIZE)) >= 0) {
						zos.write(buffer, 0, length);
					}
					zos.flush();
					zos.closeEntry();
					is.close();
					logger.info(toZipFiles[i] + " 压缩完成");
					// 压缩后删除文件
					File parentFile = file.getParentFile();
					if (file.canRead()) {
						file.delete();
						logger.info(toZipFiles[i] + " 已删除");
					}
					if (parentFile.exists() && parentFile.canWrite()) {
						logger.info(parentFile.getName() + " 已删除");
						parentFile.delete();
					}
				} catch (IOException ex) {
					throw ex;
				} finally {
					if (null != is) {
						is.close();
					}
				}
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if (null != zos) {
				zos.close();
			}
		}
		return zipFileName;
	}

	/**
	 * 压缩文件
	 * 
	 * @param zos
	 *            压缩输出流
	 * @param file
	 *            文件对象
	 * @param relativePath
	 *            相对路径
	 * @param fileTypes
	 *            TODO
	 * @throws IOException
	 */
	private static void zipFile(ZipOutputStream zos, File file,
			String relativePath, String[] fileTypes) throws IOException {
		String fileName = file.getName().toLowerCase();
		if (fileName.endsWith(".zip"))
			return;
		if (fileTypes == null || fileTypes.length == 0)
			return;
		boolean isZip = false;
		for (int i = 0; i < fileTypes.length; i++) {
			String type = StringUtil.isBlank(fileTypes[i]) ? "" : fileTypes[i]
					.trim().toLowerCase();
			if (fileName.endsWith(type)) {
				isZip = true;
				break;
			}
		}
		if (!isZip)
			return;
		ZipEntry entry = new ZipEntry(relativePath + file.getName());
		zos.putNextEntry(entry);
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			int BUFFERSIZE = 2 << 10;
			int length = 0;
			byte[] buffer = new byte[BUFFERSIZE];
			while ((length = is.read(buffer, 0, BUFFERSIZE)) >= 0) {
				zos.write(buffer, 0, length);
			}
			zos.flush();
			zos.closeEntry();
			is.close();
			// 压缩后删除文件
			if (file.canRead())
				file.delete();
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (null != is) {
				is.close();
			}
		}
	}

	/**
	 * 创建目录
	 * 
	 * @param zos
	 *            zip输出流
	 * @param relativePath
	 *            相对路径
	 * @throws IOException
	 */
	private static void createZipNode(ZipOutputStream zos, String relativePath)
			throws IOException {
		ZipEntry zipEntry = new ZipEntry(relativePath);
		zos.putNextEntry(zipEntry);
		zos.closeEntry();
	}

	/**
	 * 解压缩zip包,解压完成后,删除zip文件
	 * 
	 * @param zipFilePath
	 *            zip文件路径
	 * @param targetPath
	 *            解压缩到的位置，如果为null或空字符串则默认解压缩到跟zip包同目录跟zip包同名的文件夹下
	 * @throws IOException
	 */
	public static void unzip(String zipFilePath, String targetPath)
			throws IOException {
		OutputStream os = null;
		InputStream is = null;
		ZipFile zipFile = null;
		try {
			File file = new File(zipFilePath);
			if (!file.exists()) {
				logger.info(zipFilePath + "文件不存在");
				return;
			}
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					unzip(zipFilePath + File.separator + files[i].getName(),
							null);
				}
			} else if (file.isFile()
					&& file.getName().toUpperCase().indexOf(".ZIP") != -1) {
				zipFile = new ZipFile(zipFilePath);
				String directoryPath = "";
				if (null == targetPath || "".equals(targetPath)) {
					directoryPath = zipFilePath.substring(0,
							zipFilePath.lastIndexOf("."));
				} else {
					directoryPath = targetPath;
				}
				Enumeration entryEnum = zipFile.getEntries();
				if (null != entryEnum) {
					ZipEntry zipEntry = null;
					while (entryEnum.hasMoreElements()) {
						zipEntry = (ZipEntry) entryEnum.nextElement();
						if (zipEntry.isDirectory()) {
							directoryPath = directoryPath + File.separator
									+ zipEntry.getName();
							logger.info(directoryPath);
							continue;
						}
						if (zipEntry.getSize() > 0) {
							// 文件
							File targetFile = buildFile(directoryPath
									+ File.separator + zipEntry.getName()
									+ ".tmp", false);
							os = new BufferedOutputStream(new FileOutputStream(
									targetFile));
							is = zipFile.getInputStream(zipEntry);
							byte[] buffer = new byte[4096];
							int readLen = 0;
							while ((readLen = is.read(buffer, 0, 4096)) >= 0) {
								os.write(buffer, 0, readLen);
							}
							os.flush();
							os.close();
							targetFile.renameTo(new File(directoryPath
									+ File.separator + zipEntry.getName()));
						} else {
							// 空目录
							buildFile(
									directoryPath + File.separator
											+ zipEntry.getName(), true);
						}
					}
				}
				if (null != is) {
					is.close();
				}
				if (null != os) {
					os.close();
				}
				if (zipFile != null) {
					zipFile.close();
				}
				File f = new File(zipFilePath);
				if (f.canWrite()) {
					f.delete();
				}
				unzip(directoryPath, null);
			} else {
				logger.info(file.getName() + " 文件跳过");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (null != is) {
				is.close();
			}
			if (null != os) {
				os.close();
			}
			if (null != zipFile) {
				zipFile.close();
			}
		}

	}

	public static File buildFile(String fileName, boolean isDirectory) {
		File target = new File(fileName);
		if (isDirectory) {
			if (!target.exists())
				target.mkdirs();
		} else {
			if (!target.getParentFile().exists()) {
				target.getParentFile().mkdirs();
				target = new File(target.getAbsolutePath());
			}
		}
		return target;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// zip("", "", "E:\\files\\test", new String[]{".xlsx"});
			// unzip("E:\\files\\test.zip", null);

			unzip("D://temp//zz//asdf.zip", "D://temp//zz//");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
