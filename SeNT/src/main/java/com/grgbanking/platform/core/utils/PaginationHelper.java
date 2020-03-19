package com.grgbanking.platform.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.Page;

@SuppressWarnings("unchecked")
@Repository
public class PaginationHelper<E> {

	@Autowired
	@Qualifier("jdbcTemplate")
	JdbcTemplate jt;

	/*
	 * private static PaginationHelper INSTANCE = null;
	 * 
	 * public static PaginationHelper getInstance() { if(INSTANCE == null) {
	 * INSTANCE = new PaginationHelper(); } return INSTANCE; }
	 */

	private static void reportConn(BasicDataSource basicDataSource) {
		// ("连接数[active:idle]-["
		// + basicDataSource.getNumActive() + ":"
		// + basicDataSource.getNumIdle() + "]");

	}

	/**
	 * <Description>:
	 * 
	 * @param jt
	 *            Spring JDBCTemplate
	 * @param sqlCountRows
	 *            查询所有结果的查询语句
	 * @param sqlFetchRows
	 *            查询语句 sql
	 * @param args
	 *            参数集
	 * @param pageNo
	 *            第几页
	 * @param pageSize
	 *            第页展示的记录数
	 * @param rowMapper
	 *            RowMapper
	 * @return
	 */
	public Page<E> fetchPage(final String sqlCountRows, final String sqlFetchRows, final Object args[],
			final int pageNo, final int pageSize, final ParameterizedRowMapper<E> rowMapper) {
		// determine how many rows are available
		final Page<E> page = new Page<E>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		if (!("AddCashCount").equals(sqlCountRows)
				&& !("DeviceStopCount").equals(sqlCountRows)) {
			final int totalCount = jt.queryForInt(sqlCountRows, args);

			// calculate the number of pages
			// create the page object
			page.setTotalCount(totalCount);

			// 判断如果输入的页面数大于总的记录数时，刚把页面数设置为最大面
			if (pageNo * pageSize > totalCount) {
				page.setPageNo((int) page.getTotalPages());
			}
		}
		String databaseType = PropertiesUtils.queryDatabaseType();
		Integer pageStart = ((pageNo - 1) * pageSize);
		Integer pageEnd = pageNo * pageSize;
		//final int totalCount = jt.queryForInt(sqlCountRows, args);

		// calculate the number of pages
		// create the page object
		List<E> list = null;

		if ("oracle".equals(databaseType)) { // Oracle
			String sql = "select * from ( select tb.*,rownum num from (" + sqlFetchRows + ") tb where rownum<="
					+ pageEnd + ") where num>" + pageStart;
			list = jt.query(sql, args, rowMapper);
			page.setResult(list);
		} else if ("sybase".equals(databaseType)) { // sybase
		//			String sql = "select top " + pageSize + " from ( select top " + pageSize * pageNo + " from (" + sqlFetchRows + ") sybasesql ) sybasesql2";
		//			list = jt.query(sql, args, rowMapper);
		//			page.setResult(list);

						// 先取到结果集
			list = jt.query(sqlFetchRows, args, rowMapper);
			int list_size = list.size();
			// 从列表中取出指定区间的数据
			List<E> list2 = new ArrayList<E>();
			if(pageEnd > list_size) {
				pageEnd = list_size;
			}
			for(int i = pageStart; i < pageEnd; i++) {
				list2.add(list.get(i));
			}
			// 设定到结果集
			page.setResult(list2);
		} else if ("mysql".equals(databaseType)) { // mysql
			String sql = "select * from (" + sqlFetchRows + ") b limit " + pageStart + "," + pageEnd + "";
			list = jt.query(sql, args, rowMapper);
			page.setResult(list);
		} else if ("db2".equals(databaseType)) { // db2
			String sql = "SELECT * FROM(SELECT B.*, ROWNUMBER() OVER() AS RN FROM (" + sqlFetchRows
					+ ") AS B)AS A WHERE A.RN BETWEEN " + pageStart + " AND " + pageEnd;
			list = jt.query(sql, args, rowMapper);
			page.setResult(list);
		} else if ("sqlserver".equals(databaseType)) { // sqlserver
			String sql = "select top " + (pageEnd - pageStart) + " * from (" + sqlFetchRows
					+ ") t88 where t88.C_ID not in(select top " + pageStart + " t99.c_id from (" + sqlFetchRows
					+ ") t99)";
			list = jt.query(sql, args, rowMapper);
			page.setResult(list);
		} else if ("informix".equals(databaseType)) { // informix
			String sql = "SELECT SKIP " + pageStart + " FIRST " + (pageEnd - pageStart) + " * FROM (" + sqlFetchRows
					+ ") t";
			list = jt.query(sql, args, rowMapper);
			page.setResult(list);
		}
		// 此处修改只因为(加钞事件查询和停机事件统计)中统计总数有误,如果其他页面调用此方法也出现相同问题，可用相同方法setTotalCount(list.size())
		// if (("AddCashCount").equals(sqlCountRows)
		// || ("DeviceStopCount").equals(sqlCountRows)) {
		// // 判断如果输入的页面数大于总的记录数时，刚把页面数设置为最大面
		// if (pageNo * pageSize > list.size()) {
		// page.setPageNo((int) page.getTotalPages());
		// }
		// }
		return page;
	}

	// 不带参数的查询
	public List<E> findListByJdbcTemplate(String sql, RowMapper mapper) {
		return jt.query(sql, mapper);
	}

	// 带参数查询
	public List<E> findListByJdbcTemplate(String sql, Object[] list, RowMapper mapper) {
		return jt.query(sql, list, mapper);
	}

	// 不带对象转换的查询
	public List<Object[]> findListByJdbcTemplate(String sql) {
		return jt.queryForList(sql);
	}

	public int[] batchUpdate(String sql, BatchPreparedStatementSetter setter) {
		int[] batchUpdate = jt.batchUpdate(sql, setter);
		return batchUpdate;
	}

	// 不带对象转换的查询
	public int findIntForJdbcTemplate(String sql) {
		return jt.queryForInt(sql);
	}

	// 不带对象转换的查询
	public int findIntForJdbcTemplate(String sql, Object[] args) {
		return jt.queryForInt(sql, args);
	}

}