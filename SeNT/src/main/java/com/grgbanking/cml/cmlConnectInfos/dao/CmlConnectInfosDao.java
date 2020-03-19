package com.grgbanking.cml.cmlConnectInfos.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.grgbanking.cml.cmlConnectInfos.entity.CmlConnectInfos;
import com.grgbanking.platform.core.dao.BaseDao;

/**
 * @author 广电运通
 *
 */
@Repository

public class CmlConnectInfosDao extends BaseDao<CmlConnectInfos>{
	
	public CmlConnectInfos getCmlConnectInfosByConnNum(String connNum){
		/*String sql = " from  CmlConnectInfos   where   = ? " ; **/
		if( null !=connNum && !"".endsWith(connNum.trim())){
		return	 findUniqueBy("connNum", connNum);	
		}else {
			return null;
		}
		}

	
	public void save(CmlConnectInfos obj){

		BigDecimal bb = new BigDecimal("0");
		if (obj.getNoAllotMoney().compareTo(bb) == 0) {
			obj.setFlag("2");
		} else if (obj.getConnMoney().compareTo(obj.getNoAllotMoney()) == 0) {
			obj.setFlag("0");
		} else {
			obj.setFlag("1");

		}
		super.save(obj);
		
	}
	
	public void update(final CmlConnectInfos entity) {
		Assert.notNull(entity, "entity不能为空");
		save(entity);
		logger.debug("save entity: {}", entity);
	}


	
	public synchronized String Genertory() {
		String result = null;
	SimpleDateFormat df =new SimpleDateFormat("yyyyMMdd");
	
		String tt = df.format(new Date());
		String sql = " select max(connNum)  from  CmlConnectInfos  where  connNum like ? " ;
	
		
		try {
			String value = 	super.findUnique(sql,new String[]{tt+"%"}).toString();
			
			if (value != null) {
				result = String.valueOf(Long.parseLong(value) + 1);
			}
			

		} catch (NullPointerException e) {
			StringBuffer temp = new StringBuffer();
			for (int i = 0; i < 5; i++) {
				int u = (i == 4 ? 1 : 0);
				temp.append(u);
			}
			result = tt + temp.toString();
			
			// TODO: handle exception
		}
	
	
			
	
		logger.info(result);
		return result;

	}
}
