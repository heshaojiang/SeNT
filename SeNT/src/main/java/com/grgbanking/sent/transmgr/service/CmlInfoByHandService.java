package com.grgbanking.sent.transmgr.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.security.vo.Loginer;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.sent.transmgr.constants.CmlInfoByHandConsts;
import com.grgbanking.sent.transmgr.dao.CmlInfoByHandDao;
import com.grgbanking.sent.transmgr.entity.CmlInfoByHand;
import com.grgbanking.sent.transmgr.entity.CmlInfoByHandList;
import com.grgbanking.sent.utils.DateUtil;



@Service
@Transactional
public class CmlInfoByHandService extends BaseService{
	@Autowired
	private CmlInfoByHandDao cmlInfoByHandDao;
	
	@Autowired
	private ParamDao paramDao;
	
	@Autowired
	OrgInfoDao orgInfoDao;
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlInfoByHandList> getListCmlInfoByHand(Page<CmlInfoByHand> page, Map<String, String> conditions)
	{
		Page pageInfo = cmlInfoByHandDao.findListByConditions(page, conditions);
		List<Object> tempList = pageInfo.getResult();
	
		List<CmlInfoByHandList> resultList = new ArrayList<CmlInfoByHandList>();
		for (Object item : tempList){
			CmlInfoByHandList row = new CmlInfoByHandList();
			Object[] obj = (Object[])item;
			CmlInfoByHand cmlInfoByHand = (CmlInfoByHand)obj[0];
			row.setCurrency(cmlInfoByHand.getCurrency());
			row.setHundredCount(String.valueOf(cmlInfoByHand.getHundredCount()));
			row.setFiftyCount(String.valueOf(cmlInfoByHand.getFiftyCount()));
			row.setTwentyCount(String.valueOf(cmlInfoByHand.getTwentyCount()));
			row.setTenCount(String.valueOf(cmlInfoByHand.getTenCount()));
			row.setFiveCount(String.valueOf(cmlInfoByHand.getFiveCount()));
			row.setOneCount(String.valueOf(cmlInfoByHand.getOneCount()));
			row.setTdOperator(cmlInfoByHand.getTdOperator());
			row.setPathCode(cmlInfoByHand.getPathCode());
			row.setTranTime(DateUtil.getTimeString(cmlInfoByHand.getTranTime()));
			row.setTranType(cmlInfoByHand.getTranType());
			row.setOrgid(cmlInfoByHand.getOrgid());
			
			row.setId(cmlInfoByHand.getId());
			
			row.setOrgName((String)obj[1]);
			resultList.add(row);
		}
		pageInfo.setResult(resultList);
		return pageInfo;		
	}

	/**
	 * 删除选择的记录
	 * 
	 * @param id
	 */
	public void deleteCmlInfoByHand(ArrayList<String> selectedObj) {
		List<String> idList = (ArrayList<String>) selectedObj;
		for (String id : idList) {
			System.out.println("delete===="+id);
			cmlInfoByHandDao.delete(id);
		}
	}
	/**
	 * 保存数据 <br/>
	 * 
	 */
	public int saveCmlInfoByHand(CmlInfoByHandList cmlInfoByHandVo, String pathCode, int formType) {
		// 取到当前的用户的信息
		Loginer loginer = (Loginer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		String userCode = (String) userInfo.get("userCode");
		// 设置用户信息
		CmlInfoByHand cmlInfoByHand = new CmlInfoByHand();
		cmlInfoByHand.setCurrency("CNY");
		cmlInfoByHand.setHundredCount(new BigDecimal(cmlInfoByHandVo.getHundredCount()));
		cmlInfoByHand.setFiftyCount(new BigDecimal(cmlInfoByHandVo.getFiftyCount()));
		cmlInfoByHand.setTwentyCount(new BigDecimal(cmlInfoByHandVo.getTwentyCount()));
		cmlInfoByHand.setTenCount(new BigDecimal(cmlInfoByHandVo.getTenCount()));
		cmlInfoByHand.setFiveCount(new BigDecimal(cmlInfoByHandVo.getFiveCount()));
		cmlInfoByHand.setOneCount(new BigDecimal(cmlInfoByHandVo.getOneCount()));
		cmlInfoByHand.setTranType(cmlInfoByHandVo.getTranType());
		cmlInfoByHand.setTdOperator(userCode);
		cmlInfoByHand.setPathCode(pathCode);
		cmlInfoByHand.setOrgid(orgInfoDao.getByPathCode(pathCode).getId());
		cmlInfoByHand.setTranTime(DateUtil.getTimeYYYYMMDDHHMMSSString(Calendar.getInstance()
				.getTime()));
		if (formType == CmlInfoByHandConsts.FORM_TYPE_ADD) {
			cmlInfoByHandDao.saveNew(cmlInfoByHand);
			return 1;
			
		}else {
			cmlInfoByHand.setId(cmlInfoByHandVo.getId());
			cmlInfoByHandDao.copyUpdate(cmlInfoByHand);
			return 2;
		}
	}
}
