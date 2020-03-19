package com.grgbanking.sent.transmgr.service;

import java.text.ParseException;
import java.util.Date;

import com.grgbanking.exception.AppPlaceHolderException;
import com.grgbanking.exception.SimpleAppException;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;

public class ServiceValidateHelper
{
	/**
	 * 
	 */
	public static Date validateTranTime(String tranTime, String validFormat)
	{
		if( StringUtil.isBlank(tranTime) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_TRAN_TIME_CANNOT_BE_NULL, "交易开始时间不能为空!");
		}
		Date dStartTime = null;
		try
		{
			dStartTime = DateUtil.parseToDate(tranTime, validFormat);
		}
		catch (ParseException e)
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_TRAN_TIME_FORMAT_WRONG, "交易时间格式不正确["+e.getMessage()+"]");
		}
		return dStartTime;
	}
	
	/**
	 * 
	 */
	public static Date validateFlowTime(String tranTime, String validFormat)
	{
		if( StringUtil.isBlank(tranTime) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_FLOW_TIME_CANNOT_BE_NULL, "流转开始时间不能为空!");
		}
		Date dStartTime = null;
		try
		{
			dStartTime = DateUtil.parseToDate(tranTime, validFormat);
		}
		catch (ParseException e)
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_FLOW_TIME_FORMAT_WRONG, "流转时间格式不正确["+e.getMessage()+"]");
		}
		return dStartTime;
	}

	/**
	 * 
	 */
	public static Date validateQueryStartTime(String startTime, String validFormat)
	{
		if( StringUtil.isBlank(startTime) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_START_TIME_CANNOT_BE_NULL, "查询开始时间不能为空!");
		}
		Date dStartTime = null;
		try
		{
			dStartTime = DateUtil.parseToDate(startTime, validFormat);
		}
		catch (ParseException e)
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG, "查询时间格式不正确["+e.getMessage()+"]");
		}
		return dStartTime;
	}
	
	/**
	 * 
	 */
	public static Date validateQueryEndTime(String endTime, String validFormat)
	{
		if( StringUtil.isBlank(endTime) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_END_TIME_CANNOT_BE_NULL, "查询结束时间不能为空!");
		}
		Date dEndTime = null;
		try
		{
			dEndTime = DateUtil.parseToDate(endTime, validFormat);
		}
		catch (ParseException e)
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG, "查询时间格式不正确["+e.getMessage()+"]");
		}
		return dEndTime;
	}
	
	/**
	 * 
	 */
	public static boolean validateQueryTimeRange(Date dStartTime, Date dEndTime, int days)
	{
		if( dStartTime==null )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_START_TIME_CANNOT_BE_NULL, "查询开始时间不能为空!");
		}
		if( dEndTime==null )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_END_TIME_CANNOT_BE_NULL, "查询结束时间不能为空!");
		}
		if( Math.abs(dEndTime.getTime() - dStartTime.getTime()) >= DateUtil.MILLISECOND_PER_DAY * days )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_PLEASE_SELECT_QUERY_DATE_WITHIN, "请选择[%s]天以内的时间进行查询!", days);
		}
		return true;
	}
	
	
	/**
	 * 
	 */
	public static boolean validateQueryTimeRangeForFuzzyQuery(Date dStartTime, Date dEndTime, int days)
	{
		if( dStartTime==null )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_START_TIME_CANNOT_BE_NULL, "查询开始时间不能为空!");
		}
		if( dEndTime==null )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_END_TIME_CANNOT_BE_NULL, "查询结束时间不能为空!");
		}
		if( Math.abs(dEndTime.getTime() - dStartTime.getTime()) >= DateUtil.MILLISECOND_PER_DAY * days )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_PLEASE_SELECT_QUERY_DATE_WITHIN_FOR_FUZZY_QUERY, "模糊查询时查询范围只能为[%s]天!", days);
		}
		return true;
	}
	
	/**
	 * 
	 */
	public static Date validateApplyTime(String applyTime, String validFormat)
	{
		if( StringUtil.isBlank(applyTime) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_END_TIME_CANNOT_BE_NULL, "申请时间不能为空!");
		}
		Date dEndTime = null;
		try
		{
			dEndTime = DateUtil.parseToDate(applyTime, validFormat);
		}
		catch (ParseException e)
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG, "申请时间格式不正确["+e.getMessage()+"]");
		}
		return dEndTime;
	}
	
	/**
	 * 
	 */
	public static Date validateCommonTime(String applyTime, String validFormat, String blankKey, String formatWrongKey)
	{
		if( StringUtil.isBlank(applyTime) )
		{
			throw new SimpleAppException(blankKey);
		}
		Date dEndTime = null;
		try
		{
			dEndTime = DateUtil.parseToDate(applyTime, validFormat);
		}
		catch (ParseException e)
		{
			throw new SimpleAppException(formatWrongKey);
		}
		return dEndTime;
	}
	
	/**
	 * 跨行导出时捆号不存在情况返回的错误提示信息
	 */
	public static void validateExport(boolean b)
	{
		if( b==false )
		{
			throw new AppPlaceHolderException("导出信息中的捆号不存在，请检查!", "导出信息中的捆号不存在，请检查!");
		}
	}
	
	/**
	 * 生成特定FSN的记录数和
	 */
	public static void validateFSN(String str)
	{
			throw new AppPlaceHolderException(str, str);
	}
	
	/**
	 * 生成特定FSN的设备编号不一致
	 */
	public static void validateTerm(boolean b)
	{
		if( b==false )
		{
			throw new AppPlaceHolderException("导出信息中的文件来自不同的设备，请检查!", "导出信息中的文件来自不同的设备，请检查!");
		}
	}
	
	/**
	 * 生成特定FSN的设备编号不一致
	 */
	public static void validateFile(String str)
	{
			throw new AppPlaceHolderException(str+"文件没有图像信息，请检查", str+"文件没有图像，请检查");
	}
	
	
	/**
	 * 生成特定FSN的原始FSN文件找不到
	 */
	public static void validateNotFound(boolean b)
	{
		if( b==false )
		{
			throw new AppPlaceHolderException("导出信息中的文件找不到，请检查!", "导出信息中的文件找不到，请检查!");
		}
	}
	
}
