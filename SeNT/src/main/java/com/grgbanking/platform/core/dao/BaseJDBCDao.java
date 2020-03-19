package com.grgbanking.platform.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.grgbanking.platform.core.exception.SysException;
import com.grgbanking.platform.core.spring.SpringContextHolder;
import com.grgbanking.platform.core.utils.SqlHelper;
import com.mysql.jdbc.JDBC4PreparedStatement;

public abstract class BaseJDBCDao
{
	/* 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	private DataSource dataSource;
	
	
	/* 数据库连接池 */
	private Connection connection = null;
	
	
	public DataSource getDataSource()
	{
		if( dataSource==null )
		{
			ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
			dataSource = (DataSource) applicationContext.getBean("dataSource");
		}
		return dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	public Connection getConnection() throws SQLException
	{
		if( connection==null )
		{
			connection = this.getDataSource().getConnection();
		}
		return connection;
	}

	public void setConnection(Connection connection)
	{
		this.connection = connection;
	}
	
	/**
	 * 关闭connection，关闭之后设为null是为了下次getConnection()的时候可以获取到新的connection
	 */
	public void closeConnection()
	{
		if( connection != null )
		{
			try
			{
				connection.close();
				connection = null;
			}
			catch (SQLException e)
			{
				throw new SysException(e);
			}
		}
	}
	
	/**
	 * 关闭ResultSet
	 */
	public void closeResultSet(ResultSet rs)
	{
		try
		{
			if( rs!=null )
			{
				rs.close();
			}
		}
		catch (SQLException e)
		{
			throw new SysException(e);
		}
	}
	
	/**
	 * 关闭PreparedStatement
	 */
	public void closePreparedStatement(PreparedStatement ps)
	{
		try
		{
			if( ps!=null )
			{
				ps.close();
			}
		}
		catch (SQLException e)
		{
			throw new SysException(e);
		}
	}
	
	/**
	 * 前参数置进PreparedStatement里面
	 */
	public void setParameters(PreparedStatement ps, Object[] sqlParams) throws SQLException
	{
		for( int i=0; i<sqlParams.length; i++ )
		{
			ps.setObject(i+1, sqlParams[i]);
		}
	}
	
	/**
	 * 执行一个查询语句，返回查询到的数据的第一行数据
	 */
	public <X> X fetchUnique(String sql, Object[] sqlParams, RowMapper<X> rowMapper) throws SQLException
	{
		logger.debug("BaseJDBCDao.fetchUnique() -> sql : " + sql);
		sql = SqlHelper.limitRows(sql, 1);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			ps = this.getConnection().prepareStatement(sql);
			
			// mysql快速返回
			if( ps instanceof JDBC4PreparedStatement )
			{
				((JDBC4PreparedStatement) ps).enableStreamingResults();
			}
			
			this.setParameters(ps, sqlParams);
			rs = ps.executeQuery();
			if( rs.next() )
			{
				return rowMapper.mapRow(rs);
			}
			return null;
		}
		finally
		{
			this.closeResultSet(rs);
			this.closePreparedStatement(ps);
			this.closeConnection();
		}
	}
	
	/**
	 * 执行一个查询的语句，返回查询出来的所有数据，数据返回之前必须经过rowMapper进行封装
	 */
	public int executeUpdate(String sql, Object[] sqlParams) throws SQLException
	{
		logger.debug("BaseJDBCDao.executeUpdate() -> sql : " + sql);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			ps = this.getConnection().prepareStatement(sql);
			this.setParameters(ps, sqlParams);
			return ps.executeUpdate();
		}
		finally
		{
			this.closeResultSet(rs);
			this.closePreparedStatement(ps);
			this.closeConnection();
		}
	}
	
	/**
	 * @param sqlArr: 多个sql
	 * @param sqlParams: 做为参数传给每一个sql
	 */
	public int[] executeUpdates(String[] sqlArr, Object[] sqlParams) throws SQLException
	{
		int[] result = new int[sqlArr.length];
		for( int i=0; i<sqlArr.length; i++ )
		{
			String sql = sqlArr[i];
			result[i] = this.executeUpdate(sql, sqlParams);
		}
		return result;
	}
	
	/**
	 * 执行一个查询的语句，返回查询出来的所有数据，数据返回之前必须经过rowMapper进行封装
	 */
	public <X> List<X> executeQuery(String sql, Object[] sqlParams, RowMapper<X> rowMapper) throws SQLException
	{
		List<X> result = new ArrayList<X>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			ps = this.getConnection().prepareStatement(sql);
			
			// mysql快速返回
			if( ps instanceof JDBC4PreparedStatement )
			{
				((JDBC4PreparedStatement) ps).enableStreamingResults();
			}
			
			this.setParameters(ps, sqlParams);
			rs = ps.executeQuery();
			while( rs.next() )
			{
				result.add(rowMapper.mapRow(rs));
			}
		}
		finally
		{
			this.closeResultSet(rs);
			this.closePreparedStatement(ps);
			this.closeConnection();
		}
		return result;
	}
	
	
	/**
	 * @param needSkip:      读取之前需要跳过的行数
	 * @param needFetchRows: 跳过skip行之后需要读取的行数
	 * @param allNeedPass:   总共需要跳过以及读取的行数, 必须大于或等于 needSkip + needFetchRows
	 * 
	 * @return
	 * 如果返回的是Integer类型，表示跳过了这个行数以后没有数据可以获取
	 * 如果返回的是List类型，表示跳过了指定的行数开始获取到的数据
	 */
	public <X> QueryResult<X> fectchMultiSqlData(String[] sqlArray, Object[] sqlParams, int needSkip, int needFetchRows, int allNeedPass, RowMapper<X> rowMapper) throws SQLException
	{
		logger.info("BaseJDBCDao.fectchMultiSqlData()");
		
		if( needSkip<0 )
		{
			throw new IllegalArgumentException("needSkip["+needSkip+"] cannot be less than 0.");
		}
		
		if( needFetchRows<=0 )
		{
			throw new IllegalArgumentException("needFetchRows["+needFetchRows+"] cannot be equal to or less than 0.");
		}
		
		if( allNeedPass < needSkip + needFetchRows )
		{
			throw new IllegalArgumentException("allNeedPass["+allNeedPass+"] should not be less than the sum of needSkip["+needSkip+"] and needFetchRows["+needFetchRows+"].");
		}
		
		QueryResult<X> result = new QueryResult<X>();
		
		int remainNeedSkip = needSkip;				// 剩下需要跳过的行数
		int remainNeedFetchRows = needFetchRows;	// 剩下需要读取的行数
		int remainNeedPass = allNeedPass;
		
		for( String sql : sqlArray )
		{
			if( remainNeedPass<=0 )
			{
				break;
			}
			
			if( remainNeedFetchRows>0 )
			{
				// 还有数据需要读取
				QueryResult<X> queryResult = fectchData(sql, sqlParams, remainNeedSkip, remainNeedFetchRows, allNeedPass, rowMapper);
				logger.info("跳过["+queryResult.preSkipRows+"]行");
				logger.info("读取["+queryResult.result.size()+"]行数据");
				logger.info("再跳过["+queryResult.postSkipRows+"]行");
				
				result.preSkipRows += queryResult.preSkipRows;
				result.result.addAll(queryResult.result);
				result.postSkipRows += queryResult.postSkipRows;
				
				remainNeedSkip      = needSkip - result.preSkipRows;
				remainNeedFetchRows = needFetchRows - result.result.size();
				remainNeedPass      = allNeedPass - result.getTotalRows();
			}
			else
			{
				// 已经没有表需要读取，只需要跳过剩下的行数
				int thisSkipNum = skipData(sql, sqlParams, remainNeedPass);
				logger.info("跳过["+thisSkipNum+"]行");
				result.postSkipRows += thisSkipNum;
				remainNeedPass -= thisSkipNum;
			}
		}
		
		return result;
		
	}

	/**
	 * @param needSkip:      读取之前需要跳过的行数
	 * @param needFetchRows: 跳过needSkip行之后需要读取的行数
	 * @param allNeedPass:   总共需要跳过以及读取的行数, 必须大于或等于 needSkip + needFetchRows
	 * 
	 * @return
	 * 如果返回的是Integer类型，表示跳过了这个行数以后没有数据可以获取
	 * 如果返回的是List类型，表示跳过了指定的行数开始获取到的数据
	 */
	public <X> QueryResult<X> fectchData(String sql, Object[] sqlParams, int needSkip, int needFetchRows, int allNeedPass, RowMapper<X> rowMapper) throws SQLException
	{
		sql = SqlHelper.limitRows(sql, allNeedPass);
		logger.info("BaseJDBCDao.fectchData()");
		logger.info("查询sql : "+sql);
		
		QueryResult<X> result = new QueryResult<X>();
		
		List<X> list = new ArrayList<X>();
		
		if( needSkip<0 )
		{
			throw new IllegalArgumentException("needSkip["+needSkip+"] cannot be less than 0.");
		}
		
		if( needFetchRows<=0 )
		{
			throw new IllegalArgumentException("needFetchRows["+needFetchRows+"] cannot be equal to or less than 0.");
		}
		
		if( allNeedPass < needSkip + needFetchRows )
		{
			throw new IllegalArgumentException("allNeedPass["+allNeedPass+"] should not be less than the sum of needSkip["+needSkip+"] and needFetchRows["+needFetchRows+"].");
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			ps = this.getConnection().prepareStatement(sql);
			
			// mysql快速返回
			if( ps instanceof JDBC4PreparedStatement )
			{
				((JDBC4PreparedStatement) ps).enableStreamingResults();
			}
			
			this.setParameters(ps, sqlParams);
			
			rs = ps.executeQuery();
			
			// 查询之前的跳行
			if( needSkip>0 )
			{
				int skipCnt = skip(rs, needSkip);	// 跳行，如果返回的行数小于needSkip，表示已经到了
				result.preSkipRows = skipCnt;
				if( skipCnt<needSkip )
				{
					return result;
				}
			}
			
			// 获取数据
			boolean reachEnd = false;	// 是否已经到了末尾
			for( int i=0; i<needFetchRows; i++ )
			{
				if( rs.next() )
				{
					list.add(rowMapper.mapRow(rs));
				}
				else
				{
					reachEnd = true;	// 已经到了末尾
					break;
				}
			}
			result.result = list;
			
			// 获取数据之后的跳行
			if( reachEnd==false )
			{
				// 还没有到数据的末尾, 继续跳行
				int remainNeedToPass = allNeedPass - result.preSkipRows - result.result.size();
				int postSkipCnt = skip(rs, remainNeedToPass);	// postSkipCnt有可能小于remainNeedToPass
				result.postSkipRows = postSkipCnt;
			}
			else
			{
				result.postSkipRows = 0;
			}
		}
		finally
		{
			this.closeResultSet(rs);
			this.closePreparedStatement(ps);
			this.closeConnection();
		}
		
		return result;
	}
	
	/**
	 * @param needSkip: 需要跳过的行数
	 * @return:	返回跳过的行数，这个数有可能小于needSkip
	 */
	public Integer skipData(String sql, Object[] sqlParams, int needSkip) throws SQLException
	{
		sql = SqlHelper.limitRows(sql, needSkip);
		logger.info("BaseJDBCDao.skipData()");
		logger.info("查询sql : "+sql);
		
		if( needSkip<0 )
		{
			throw new IllegalArgumentException("needSkip["+needSkip+"] cannot be less than 0.");
		}
		
		int skipNum = 0;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			ps = this.getConnection().prepareStatement(sql);
			
			// mysql快速返回
			if( ps instanceof JDBC4PreparedStatement )
			{
				((JDBC4PreparedStatement) ps).enableStreamingResults();
			}
			
			this.setParameters(ps, sqlParams);
			
			rs = ps.executeQuery();
			
			skipNum = skip(rs, needSkip);	// 跳行，如果返回的行数小于needSkip，表示已经到了
		}
		finally
		{
			this.closeResultSet(rs);
			this.closePreparedStatement(ps);
			this.closeConnection();
		}
		
		return skipNum;
	}
	
	/**
	 * 返回跳过的行数
	 */
	public int skip(ResultSet rs , int skip) throws SQLException
	{
		int skipCnt = 0;
		while( skipCnt < skip )
		{
			if( rs.next() )
			{
				skipCnt++;
			}
			else
			{
				break;
			}
		}
		return skipCnt;
	}
	
	/**
	 * 查询返回的结果
	 */
	public static class QueryResult<X>
	{
		public int preSkipRows = 0;					// 读取数据之前跳过的行数
		public List<X> result = new ArrayList<X>();
		public int postSkipRows = 0;				// 读取数据之后跳过的行数
		
		public int getTotalRows()
		{
			return preSkipRows + result.size() + postSkipRows;
		}
	}
	
	/**
	 * 
	 */
	public static interface RowMapper<T>
	{
		public T mapRow(ResultSet rs) throws SQLException;
	}
	
}
