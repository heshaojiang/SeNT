package com.grgbanking.sent.transmgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.SysException;
import com.grgbanking.sent.checkin.entity.SmsSerialStatis;
import com.grgbanking.sent.transmgr.entity.CmlSentInfo;

/**
 * 清分纸币冠字号码DAO层 继承公共的BaseDao层
 * @author 广电运通
 */
@Repository
public class CmlSentInfoDao extends BaseDao<CmlSentInfo>
{

	public Page<CmlSentInfo> getPageByTranId(Page<CmlSentInfo> page, String tranId)
	{
		String hql = "select csi from CmlSentInfo csi where csi.tranId=?";
		return this.findPage(page, hql, tranId);
	}
	
	public int updateTermTypeByTranId(String tranId, String termType)
	{
		String hql = "update CmlSentInfo csi set csi.termType=? where csi.tranId=?";
		return this.executeUpdate(hql, termType, tranId);
	}
	
	//判断
	public String getStatus(String tranId) throws Exception{
		String sql = "select c_getimage_falg from CML_IMP_RECORDS where C_ID=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			Session session = this.getSessionFactory().openSession();
			conn = session.connection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tranId);
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString(1);
			}else{
				return "";
			}
		}catch (Exception e1) {
			throw new SysException(e1);
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
		
	}
}
