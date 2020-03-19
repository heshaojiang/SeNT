package com.grgbanking.sent.watch.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.SysException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.R2002Msg;
import com.grgbanking.sent.utils.S2002Msg;
import com.grgbanking.sent.utils.StringUtil;
import com.grgbanking.sent.utils.Transfer;
import com.grgbanking.sent.watch.dao.TransAbnobanknoteSeqDao;
import com.grgbanking.sent.watch.entity.TransAbnobanknoteSeq;

/**
 * 异常交易冠字号码Service继承BaseService
 * 
 * @author 广电运通
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class TransAbnobanknoteSeqService extends BaseService
{
	@Autowired
	private TransAbnobanknoteSeqDao transAbnobanknoteSeqDao;
	
	@Autowired
	private Transfer transfer;
	
	@Autowired
	private ParamDao paramDao;

//	/**
//	 * 保存一个TransAbnobanknoteSeq实体
//	 * 
//	 * @param obj
//	 *            TransAbnobanknoteSeq实体
//	 * @return boolean
//	 */
//	public boolean addTransAbnobanknoteSeq(TransAbnobanknoteSeq obj)
//	{
//		boolean flag = false;
//		try
//		{
//			transAbnobanknoteSeqDao.saveNew(obj);
//
//			flag = true;
//		}
//		catch( AppException e )
//		{
//			flag = false;
//
//			logger.error("", e);
//		}
//		return flag;
//	}

//	/**
//	 * 根据id删除一个TransAbnobanknoteSeq实体
//	 * 
//	 * @param obj
//	 *            TransAbnobanknoteSeq实体
//	 * @return boolean
//	 */
//	public boolean deleteTransAbnobanknoteSeq(TransAbnobanknoteSeq obj)
//	{
//		boolean flag = false;
//		try
//		{
//			transAbnobanknoteSeqDao.delete(obj.getId());
//			flag = true;
//		}
//		catch( AppException e )
//		{
//			logger.error("", e);
//		}
//		return flag;
//	}

//	/**
//	 * 更新一个TransAbnobanknoteSeq实体
//	 * 
//	 * @param obj
//	 *            TransAbnobanknoteSeq实体
//	 * @return boolean
//	 */
//	public boolean updateTransAbnobanknoteSeq(TransAbnobanknoteSeq obj)
//	{
//		boolean flag = false;
//		try
//		{
//			transAbnobanknoteSeqDao.copyUpdate(obj);
//			flag = true;
//		}
//		catch( AppException e )
//		{
//
//			logger.error("", e);
//			throw new NullPointerException();
//		}
//		return flag;
//	}

	/**
	 * 根据冠字号码查询 TransAbnobanknoteSeq数据并进行显示
	 * 
	 * @param page
	 *            page实体
	 * @param trans
	 *            TransAbnobanknoteSeq实体
	 * @param beginDateString
	 *            开始时间
	 * @param endDateString
	 *            结束时间
	 * @return page
	 */
	@Transactional(readOnly = true)
	public Page getTransAbnobanknoteSeqPage(Page page, TransAbnobanknoteSeq trans, String beginDateString, String endDateString)
	{
		String sql = "  from TransAbnobanknoteSeq as trans where 1=1";

		if( beginDateString != null && !beginDateString.equals("") )
		{
			beginDateString = DateUtil.dateFormatTohms(beginDateString);
		}

		if( endDateString != null && !endDateString.equals("") )
		{
			endDateString = DateUtil.dateFormatTohms(endDateString);
		}
		if( trans.getSeriaNo() != null && !trans.getSeriaNo().equals("") )
		{
			if( DBDialectHelper.isOracle() )
			{
				sql += " and trans.seriaNo like '" + trans.getSeriaNo().trim() + "%'";
			}
			else
			{
				sql += " and trans.seriaNo like '" + trans.getSeriaNo().trim() + "%'";
			}
		}
		if( trans.getTermid() != null && !"".equals(trans.getTermid()) )
		{

			sql += " and trans.termid='" + trans.getTermid() + "'";

		}
		if( beginDateString != null && !beginDateString.equals("") )
		{
			sql += " and trans.transDate||tran.transTime>='" + beginDateString + "'";
		}
		if( endDateString != null && !endDateString.equals("") )
		{

			sql += " and trans.transDate||tran.transTime<='" + endDateString + "'";
		}
		sql += "  order by trans.transDate||tran.transTime desc";

		return transAbnobanknoteSeqDao.findPage(page, sql);
	}

//	/**
//	 * 查询 TransAbnobanknoteSeq的集合数据
//	 * 
//	 * @param obj
//	 *            参数
//	 * @return list
//	 */
//	@Transactional(readOnly = true)
//	public List getTransAbnobanknoteSeqList(Object[] obj)
//	{
//		String sql = "  from TransAbnobanknoteSeq ";
//		return transAbnobanknoteSeqDao.find(sql);
//	}
//
//	/**
//	 * 查询关联id 和纸币标识为0的TransAbnobanknoteSeq数据
//	 * 
//	 * @param transid
//	 *            关联ID
//	 * @return list
//	 */
//	@Transactional(readOnly = true)
//	public List getTransAbnobanknoteSeqIdListFlag1(String transid)
//	{
//		String hql = " select t.id from TransAbnobanknoteSeq t where t.tranId ='" + transid + "' and t.noteFlag ='0'";
//		return transAbnobanknoteSeqDao.find(hql);
//	}
//
//	/**
//	 * 查询关联id 和纸币标识为1的TransAbnobanknoteSeq数据
//	 * 
//	 * @param transid
//	 *            关联ID
//	 * @return list
//	 */
//	@Transactional(readOnly = true)
//	public List getTransAbnobanknoteSeqIdListFlag2(String transid)
//	{
//		String hql = " select t.id from TransAbnobanknoteSeq t where t.tranId ='" + transid + "' and t.noteFlag ='1' ";
//		return transAbnobanknoteSeqDao.find(hql);
//	}
//
//	/**
//	 * 查询关联id 和纸币标识为4的TransAbnobanknoteSeq数据
//	 * 
//	 * @param transid
//	 *            关联ID
//	 * @return list
//	 */
//	@Transactional(readOnly = true)
//	public List transAbnobanknoteSeqDao(String transid)
//	{
//		String hql = " select t.id from TransAbnobanknoteSeq t where t.tranId ='" + transid + "' and t.noteFlag ='4' ";
//		return transAbnobanknoteSeqDao.find(hql);
//	}
//
//	/**
//	 * 查询关联id 和纸币标识为5的TransAbnobanknoteSeq数据
//	 * 
//	 * @param transid
//	 *            关联ID
//	 * @return list
//	 */
//	@Transactional(readOnly = true)
//	public List getTransAbnobanknoteSeqIdListFlag4(String transid)
//	{
//		String hql = " select t.id from TransAbnobanknoteSeq t where t.tranId ='" + transid + "' and t.noteFlag ='5' ";
//		return transAbnobanknoteSeqDao.find(hql);
//	}
//
//	/**
//	 * 根据主键查找TransAbnobanknoteSeq实体
//	 * 
//	 * @param id
//	 *            主键
//	 * @return TransAbnobanknoteSeq
//	 */
//	@Transactional(readOnly = true)
//	private TransAbnobanknoteSeq getTransAbnobanknoteSeqObject(String id)
//	{
//		return (TransAbnobanknoteSeq) transAbnobanknoteSeqDao.get(id);
//	}

	/**
	 * 根据关联ID查询 TransAbnobanknoteSeq集合数据
	 * 
	 * @param tranId
	 *            关联ID
	 * @return List<TransAbnobanknoteSeq>
	 */
	@Transactional(readOnly = true)
	public Page<TransAbnobanknoteSeq> getTransAbnobanknoteSeqByTranId(Page<TransAbnobanknoteSeq> page, String tranId, String transMonthday)
	{
		String sql = 	" select t" + 
						" from TransAbnobanknoteSeq t" + 
						" where t.tranId = ?" + 
						" order by t.tranDate desc";

		Page<TransAbnobanknoteSeq> pageObject = transAbnobanknoteSeqDao.findPage(page, sql, tranId);
		
		fetchSerialNoImagesForPage(pageObject);
		
		return pageObject;
	}
	
//	/**
//	 * 根据id查找对应的图片
//	 * 
//	 * @param id
//	 *            TransAbnobanknoteSeq实体主键
//	 * @return picpath
//	 */
//	@Transactional(readOnly = true)
//	public String findPicPath(String id)
//	{
//		String picPath = "";
//		try
//		{
//			List lst = transAbnobanknoteSeqDao.find("SELECT urlName FROM TransAbnobanknoteSeq WHERE id = ? ", id);
//			if( lst.size() > 0 )
//			{
//				picPath = lst.get(0).toString();
//			}
//		}
//		catch( AppException e )
//		{
//			logger.error("", e);
//
//		}
//		return picPath;
//	}

	/**
	 * 获得图片的配置路径
	 * 
	 * @return String 图片的参数配置路径
	 * */
	public String getImgParmPath()
	{
		return paramDao.getValueByPath(AppConstants.IMAGE_PATH);
	}

//	/**
//	 *根据异常冠字号码表进行赋值
//	 * 
//	 * @param trans
//	 *            异常冠字号码表
//	 *@return TransAbnoinfoSeqInfo
//	 * */
//	private TransAbnoinfoSeqInfo findTransAbnoinfoSeqInfo(TransAbnobanknoteSeq trans)
//	{
//		String imgPath = getImgParmPath();
//		TransAbnoinfoSeqInfo seqInfo = new TransAbnoinfoSeqInfo();
//		seqInfo.setId(trans.getId());
//		seqInfo.setSeriaNo(trans.getSeriaNo());
//		String termid = trans.getTermid();
//		String fileDir = trans.getTranDate().substring(0, 8);
//		seqInfo.setPictureName(imgPath + trans.getPictureName());
//		seqInfo.setDenomination(trans.getDenomination());
//		seqInfo.setCurrency(trans.getCurrency());
//		seqInfo.setNoteFlag(trans.getNoteFlag());
//		seqInfo.setNoteType(trans.getNoteType());
//		return seqInfo;
//	}
//
//	public List getTransAbnobanknoteSeqById(String ids) throws Exception
//	{
//		return getTransAbPicPath(ids);
//	}
//
//	/**
//	 * 查看交易冠子号码对应的图片
//	 * 
//	 * @param ids
//	 *            参数
//	 * @return List
//	 * @throws Exception
//	 *             报文异常
//	 */
//	private List getTransAbPicPath(String ids) throws Exception
//	{
//		List<TransAbnoinfoSeqInfo> objList = new ArrayList<TransAbnoinfoSeqInfo>();
//		boolean flag = false;
//		try
//		{
//			String[] arrStr = ids.split(",");
//			for( int i = 0 ; i < arrStr.length ; i++ )
//			{
//				TransAbnoinfoSeqInfo seq = new TransAbnoinfoSeqInfo();
//				String id = arrStr[i];
//				if( id == "" )
//				{
//					continue;
//				}
//				TransAbnobanknoteSeq obj = getTransAbnobanknoteSeqObject(id);
//				if( obj != null )
//				{
//					// String picPath = obj.getPictureName();
//					// System.out.println("picPath = "+picPath);
//					// if( picPath==null )
//					// {
//					// picPath = "";
//					// }
//					// int s = picPath.indexOf("_");
//					// final int a = 13;
//
//					String imgType = obj.getImageType();
//					// 数据库中没有图片路径，向TST发送报文//证明没有上传图片
//					if( imgType != null && imgType.equals("3") )
//					{
//						// String messageNo = String.valueOf(new
//						// Date().getTime()).substring(1, a); //
//						// 截取后12位作为message的编号
//						String messageNo = String.valueOf(new Date().getTime()).substring(1, 13);
//						R2002Msg rmsg = new R2002Msg();
//						rmsg = getReturnPack(obj, messageNo);
//						if( rmsg != null )
//						{// 请求成功
//							if( rmsg.getMessageno().equals(messageNo) )
//							{
//								// 判断接收的message标号与发送的是否一致
//								String returnPicPath = rmsg.getFilepath();
//								int f = returnPicPath.indexOf("/");
//								if( f != -1 )
//								{
//									// 格式00001042/20130618/183943_1180_1_005.bmp
//									if( returnPicPath != null && !returnPicPath.equals("") )
//									{
//										obj.setPictureName(returnPicPath);
//										obj.setImageType("4");
//
//										flag = updateTransAbnobanknoteSeq(obj);// 更新数据库记录
//										seq = findTransAbnoinfoSeqInfo(obj);
//										objList.add(seq);
//										if( flag )
//										{
//											logger.info(obj.getTermid());
//										}
//										else
//										{
//											try
//											{
//												logger.info(obj.getTermid());
//											}
//											catch( AppException e )
//											{
//												logger.error("", e);
//											}
//										}
//									}// 返回图片路径则重新复杂，更新数据库
//									else
//									{
//										seq = findTransAbnoinfoSeqInfo(obj);
//										objList.add(seq);
//
//									}
//								}// 请求成功
//								else
//								{
//									seq = findTransAbnoinfoSeqInfo(obj);
//									objList.add(seq);
//								}
//							}
//							else
//							{
//								seq = findTransAbnoinfoSeqInfo(obj);
//								objList.add(seq);
//							}// 响应超时(rmsg=null)
//						}
//					}
//					else
//					{
//						seq = findTransAbnoinfoSeqInfo(obj);
//						objList.add(seq);
//
//					}// 数据库中有图片路径
//				}
//			}
//			// 删除数据库中的空格
//			for( int i = 0 ; i < objList.size() ; i++ )
//			{
//				if( objList.get(i).getCheckResult() != null )
//				{
//					objList.get(i).setCheckResult(objList.get(i).getCheckResult().trim());
//				}
//				if( objList.get(i).getNoteType() != null )
//				{
//					objList.get(i).setNoteType(objList.get(i).getNoteType().trim());
//				}
//				if( objList.get(i).getNoteFlag() != null )
//				{
//					objList.get(i).setNoteFlag(objList.get(i).getNoteFlag().trim());
//				}
//				if( objList.get(i).getCurrency() != null )
//				{
//					objList.get(i).setCurrency(objList.get(i).getCurrency().trim());
//				}
//
//			}
//		}
//		catch( AppException e )
//		{
//			logger.error("", e);
//		}
//
//		return objList;
//	}
//
//	/**
//	 * @param obj
//	 *            TransAbnobanknoteSeq实体
//	 * @param messageNo
//	 *            时间码
//	 * @return R2002Msg
//	 */
//	public R2002Msg getReturnPack(TransAbnobanknoteSeq obj, String messageNo)
//	{
//		S2002Msg smsg = new S2002Msg();
//
//		smsg.setCheckcode("00");// 校验码
//		smsg.setDevid(obj.getTermid());// ATM终端号
//		smsg.setMessageno(messageNo);// 时间码
//		String picName = obj.getPictureName();
//		String tranDate = obj.getTranDate().substring(0, 8);
//		smsg.setPicturename(tranDate + "/" + picName);
//
//		byte[] returnpack = null;
//		byte[] sendpack = smsg.packMessage();
//		// 报文发送，并等待获取返回报文
//
//		transfer.init();
//		try
//		{
//			returnpack = transfer.sendPack(sendpack);
//		}
//		catch( IOException e )
//		{
//			logger.error("", e);
//			returnpack = null;
//		}
//
//		if( returnpack == null )
//		{
//			return null;
//		}
//		else
//		{
//			R2002Msg rmsg = new R2002Msg();
//			rmsg.unpackMessage(returnpack);
//			return rmsg;
//		}
//	}
	
	/**
	 * 
	 */
	private void fetchSerialNoImagesForPage(Page<TransAbnobanknoteSeq> page)
	{
		fetchSerialNoImagesForList(page.getResult());
	}
	
	/**
	 * 
	 */
	private void fetchSerialNoImagesForList(List<TransAbnobanknoteSeq> seqList)
	{
		String imagePath   = paramDao.getValueByPathWithException(AppConstants.IMAGE_PATH);	// 获取atm图片的主目录
		
		boolean isConnectFail = false;
		for( TransAbnobanknoteSeq cmlSentInfo : seqList )
		{
			String imageType = cmlSentInfo.getImageType();
			if( "0".equals(imageType) )
			{
				generateImageForMessage(cmlSentInfo, "No image.", 320, 32);
			}
			else if( "3".equals(imageType) )
			{
				// 3表示atm还没有查看过图片，需要后台提取
				// 其它厂商的机器，暂时定为类型3，做法与atm类似
				try
				{
					if( isConnectFail==false )
					{
						// 发消息到SeNTServer获取atm冠字号图片
						fetchAtmImageFile(cmlSentInfo, imagePath);
					}
				}
				catch (IOException e)
				{
					logger.error("获取ATM图片失败", e);
					isConnectFail = true;
				}
				// 
				if( isConnectFail )
				{
					generateImageForMessage(cmlSentInfo, "IOException: connect server fail.", 320, 32);
				}
			}
			else if( "4".equals(imageType) )
			{
				// 直接拼接url
				if( StringUtil.isBlank(cmlSentInfo.getPictureName()) )
				{
					generateImageForMessage(cmlSentInfo, "File name is empty.", 320, 32);
				}
				else
				{
					cmlSentInfo.setFullUrl(concatImageFullUrl(imagePath, cmlSentInfo.getPictureName()));
				}
			}
			else
			{
				// 错误的情况
				generateImageForMessage(cmlSentInfo, "wrong image type ["+imageType+"].", 320, 32);
			}
		}
	}
	
	/**
	 * 
	 */
	private void generateImageForMessage(TransAbnobanknoteSeq cmlSentInfo, String message, int width, int height)
	{
		try
		{
			if( StringUtil.isBlank(message) )
			{
				message = "No Image.";
			}
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics g = img.getGraphics();
			Font font = new Font("TimesRoman", Font.PLAIN, 16);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString(message, 5, 16);
			g.dispose();
			ImageIO.write(img, "jpg", out);
			
			cmlSentInfo.setImageArr(out.toByteArray());
			cmlSentInfo.setWidth(width);
			cmlSentInfo.setHeight(height);
		}
		catch (IOException e)
		{
			throw new SysException(e);
		}
	}
	
	
	/**
	 * 发送消息到SeNTServer获取ATM的图片
	 */
	private void fetchAtmImageFile(TransAbnobanknoteSeq cmlSentInfo, String imagePath) throws IOException
	{
		String imgType = cmlSentInfo.getImageType();
		
		// 3表示atm还没有查看过图片，需要后台提取
		// 其它厂商的机器，暂时定为类型3，做法与atm类似
		if( "3".equals(imgType)==false )
		{
			generateImageForMessage(cmlSentInfo, "Wrong image type["+imgType+"].", 320, 32);
			return ;
		}
		
		String messageNo = String.valueOf(new Date().getTime()).substring(1, 13);
		R2002Msg rmsg = getReturnPack(cmlSentInfo, messageNo);
		if( rmsg==null )
		{
			generateImageForMessage(cmlSentInfo, "Return message is null.", 320, 32);
			return ;
		}
		
		if( StringUtil.trim(rmsg.getRetcode()).equals("0")==false )	// 0表示成功
		{
			generateImageForMessage(cmlSentInfo, "Return code is ["+rmsg.getRetcode()+"].", 320, 32);
			return ;
		}

		if( rmsg.getMessageno().equals(messageNo)==false )
		{
			generateImageForMessage(cmlSentInfo, "Message No is ["+rmsg.getMessageno()+"].", 320, 32);
			return ;
		}

		String returnPicPath = rmsg.getFilepath();
		if( StringUtil.isBlank(returnPicPath) )
		{
			generateImageForMessage(cmlSentInfo, "Wrong Picturn Path ["+returnPicPath+"].", 320, 32);
			return ;
		}
		
		cmlSentInfo.setFullUrl(concatImageFullUrl(imagePath, returnPicPath));
		cmlSentInfo.setPictureName(returnPicPath);
		cmlSentInfo.setImageType("4");
		
		return ;
	}
	
	private R2002Msg getReturnPack(TransAbnobanknoteSeq seq, String messageNo) throws IOException
	{
		S2002Msg smsg = new S2002Msg();

		smsg.setCheckcode("00");
		smsg.setDevid(seq.getTermid());
		smsg.setMessageno(messageNo);
		
		String picName = seq.getPictureName();
		String tranDate = seq.getTranDate().substring(0, 8);

		smsg.setPicturename(tranDate + "/" + picName);

		byte[] returnpack = null;
		byte[] sendpack = smsg.packMessage();

		transfer.init();
		returnpack = transfer.sendPack(sendpack);

		if (returnpack == null)
		{
			return null;
		}
		else
		{
			R2002Msg rmsg = new R2002Msg();
			rmsg.unpackMessage(returnpack);
			return rmsg;
		}
	}
	
	private String concatImageFullUrl(String imagePath, String fileName)
	{
		fileName = fileName.replace("\\", "/");
		if( fileName.startsWith("/") )
		{
			fileName = fileName.substring(1);
		}
		
		imagePath = imagePath.replace("\\", "/");
		if( imagePath.endsWith("/")==false )
		{
			imagePath += "/";
		}
		return imagePath + fileName;
	}
}
