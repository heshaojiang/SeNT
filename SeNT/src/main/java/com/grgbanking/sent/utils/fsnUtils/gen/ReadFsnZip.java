package com.grgbanking.sent.utils.fsnUtils.gen;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.grgbanking.sent.utils.fsnUtils.read.FsnReadItem;


public class ReadFsnZip {

	private static int BUFFER_SIZE = 2048;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			// readZipFile("D:\\MyFSN\\20140801110435.zip");
			// readZipFile("D:\\MyFSN\\20140802110648.zip");
			// readZipFile("D:\\MyFSN\\20140807110800.zip");

			/*
			long fsize = -1;
			fsize = getFileSizes(new File("D:\\MyFSN\\20140801110435.fsn"));
			System.out.println(fsize);

			fsize = getFileSizes(new File("D:\\MyFSN\\20140802110648.fsn"));
			System.out.println(fsize);

			fsize = getFileSizes(new File("D:\\MyFSN\\20140805110733.fsn"));
			System.out.println(fsize);

			fsize = getFileSizes(new File("D:\\MyFSN\\20140806110749.fsn"));
			System.out.println(fsize);
			*/
			
			//unzipFilesToPath("D:\\MyFSN\\20140810113920.zip", "D:\\MyFSN\\aa\\");
			
			long btime = System.currentTimeMillis();
			
			//byte[] b = readFsnImg("D:\\MyFSN\\20140806110749.fsn", 1);
			byte[] b = readZipImg("D:\\MyFSN\\20140701135337.zip", 999990);
			
			System.out.println("used time: " + (System.currentTimeMillis() - btime) );
			
			ByteArrayInputStream bis = new ByteArrayInputStream(b);
			DataInputStream dis = new DataInputStream(bis);
			FsnReadItem item = new FsnReadItem();
			item.read(dis, true);
			System.out.println(item.getSerialNo());

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void readZipFile(String file) throws Exception {
		ZipFile zf = new ZipFile(file);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ZipInputStream zin = new ZipInputStream(in);
		ZipEntry ze;
		while ((ze = zin.getNextEntry()) != null) {
			if (ze.isDirectory()) {
				// System.out.print("directory - " + ze.getName() + " : "
				// + ze.getSize() + " bytes");
				// System.out.println();
			} else {
				long size = ze.getSize();
				System.out.println("file - " + ze.getName() + " : " + size
						+ " bytes");
				if (size > 0) {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(zf.getInputStream(ze)));
					String line;
					while ((line = br.readLine()) != null) {
						System.out.println(line);
					}
					br.close();
				}
			}
		}
		zin.closeEntry();
	}

	/**
	 * Unzip files to path.
	 * 
	 * @param zipFileName
	 *            the zip file name
	 * @param fileExtractPath
	 *            the file extract path
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void unzipFilesToPath(final String zipFileName,
			final String fileExtractPath) throws IOException {

		final FileInputStream fis = new FileInputStream(zipFileName);
		final ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
		try {
			ZipEntry entry;

			while ((entry = zis.getNextEntry()) != null) {
				int count;
				byte[] data = new byte[BUFFER_SIZE];
				final FileOutputStream fos = new FileOutputStream(fileExtractPath + entry.getName());
				final BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER_SIZE);
				while ((count = zis.read(data, 0, BUFFER_SIZE)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
		} finally {
			fis.close();
			zis.close();
		}

	}
	
	
	public static byte[] readFsnImg(String fsnPath, long index) throws Exception {
		
		long seek = 32 + 1644 * (index-1);
		byte[] b = new byte[1644];;
		RandomAccessFile file = new RandomAccessFile(fsnPath, "r");
		file.seek(seek);// 把文件指针位置设置到文件起始处
		file.readFully(b);
		
		return b;
	}
	
	
	public static byte[] readZipImg(String zipPath, int index) throws Exception {
		
		int seek = 32 + 1644 * (index-1);
		byte[] b = new byte[1644];
		
		FileInputStream fis = new FileInputStream(zipPath);
		//ZipInputStream zis = new ZipInputStream(fis);
		ZipInputStream zis = new MyZipInputStream(new BufferedInputStream(fis));
		
		try {
			ZipEntry entry;
			//while ((entry = zis.getNextEntry()) != null) {
			if ((entry = zis.getNextEntry()) != null) {
				zis.skip(seek);
				zis.read(b, 0, 1644);
				
				/*
				RandomAccessFile  rf = new RandomAccessFile("D:\\MyFSN\\20140701135337.fsn", "r");
				rf.seek(seek);
				rf.read(b, 0, 1644);
				rf.close();
				*/
			}
		} finally {
			fis.close();
			zis.close();
		}
		
		return b;
	}
	

	/**
	 * 取得文件大小
	 * 
	 * @param f
	 * @return
	 * @throws Exception
	 */
	public static long getFileSizes(File f) throws Exception {
		long s = 0;
		if (f.exists()) {
			FileInputStream fis = null;
			fis = new FileInputStream(f);
			s = fis.available();
		} else {
			f.createNewFile();
			System.out.println("文件不存在");
		}
		return s;
	}

}
