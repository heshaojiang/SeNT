package com.grgbanking.sent.watch.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.sent.watch.entity.TransBanknoteSeqHour;
/**
 * 清分纸币冠字号码监控DAO�� ,继承BaseDao
 * @author 广电运通
 * @version 1.0
 */
@Repository  
@SuppressWarnings("unchecked") 
public class TransBanknoteSeqHourDao extends BaseDao<TransBanknoteSeqHour> {
	/**
	 * 根据TransBanknoteSeqHour主键找到实体中包含的图片路径
	 * @param id 主键
	 * @return picPath
	 */
	public String findPicPath(String id){
		String picPath ="";
		try{
		List  lst = super.find("SELECT urlName FROM TransBanknoteSeqHour WHERE id = ? ", id);
		if(lst.size()>0){
			picPath = lst.get(0).toString();
		}
	    }catch(AppException e){
		 logger.error("", e);

	  }
	    return picPath;
	}
}

