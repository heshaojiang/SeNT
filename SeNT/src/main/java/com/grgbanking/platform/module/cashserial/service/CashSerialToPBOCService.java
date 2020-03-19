/** 
 * 
 * Copyright:   Copyright (c) 2011 
 * Company:     GRGBanking
 * @author:     VZ
 * Create at:   2011-4-12
 * 
 * Modification History: 
 * Date         Author      Description 
 * -----------  ---------   ---------------------------------------- 
 * 2011-4-12	VZ			Initial Create
 */

package com.grgbanking.platform.module.cashserial.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.springsecurity.SpringSecurityUtils;
import com.grgbanking.platform.module.cashserial.constants.CashSerialToPBOCConsts;
import com.grgbanking.platform.module.cashserial.dao.CashSerialToPBOCDao;
import com.grgbanking.platform.module.cashserial.entity.CashSerialToPBOC;
import com.grgbanking.platform.module.cashserial.entity.SelectDayButton;


/**
 * User Management service<br>
 * 用户管理服务类.
 * 
 * @author vinson
 */
@Service
@Transactional
public class CashSerialToPBOCService extends BaseService
{
	

	
	@Autowired
	CashSerialToPBOCDao cashSerialToPBOCDao;

	
	
	
	public Page<CashSerialToPBOC> getCashSerialToPBOCPage(final Page<CashSerialToPBOC> page, Map<String, String> filterParamMap)
	{
		if( filterParamMap == null )
		{
			filterParamMap = new HashMap<String, String>();
		}
		page.setOrderBy("updateTime");
		Page<CashSerialToPBOC> resultPage = cashSerialToPBOCDao.getCashSerialToPBOCPage(page, filterParamMap);
		return resultPage;
	}
	
	
	public boolean newCashSerialToPBOC(CashSerialToPBOC cashSerialToPBOC,List<SelectDayButton> selectedList, List<SelectDayButton> disSelectedList)
	{
		if(selectedList!=null && selectedList.size()>0){
		StringBuffer binaryStr = new StringBuffer();
		
		String uploadHz = cashSerialToPBOC.getUploadHz();	    
	    int allDay = 0;
		if(CashSerialToPBOCConsts.UPDATE_CONFIG_CYCLE_DAY.equals(uploadHz)){
			allDay = 0;
		}else if(CashSerialToPBOCConsts.UPDATE_CONFIG_CYCLE_WEEK.equals(uploadHz)){
			allDay = 7;
		}else if(CashSerialToPBOCConsts.UPDATE_CONFIG_CYCLE_MONTH.equals(uploadHz)){
			allDay = 31;
		}
		for(int i=allDay;i>0;i--){
		boolean checked = false;
			
			for (SelectDayButton btn : selectedList)
			{
				if(btn.getOrder()==i&&btn.getChecked()){
					checked = true;
					binaryStr.append("1");
					break;
				}
			}
		
		if(!checked){
			binaryStr.append("0");
		}
		}
		BigInteger decimalStr= new BigInteger(binaryStr.toString(),2);
		cashSerialToPBOC.setUploadValue(Integer.parseInt(decimalStr.toString()));
		}
		
		String uploadUsername = SpringSecurityUtils.getCurrentUserName();
		cashSerialToPBOC.setHandlePerson(uploadUsername);
		
		cashSerialToPBOCDao.save(cashSerialToPBOC);
		return true;
	}
		
	
	/**
	 * get selected day<br>
	 * 查询选择的日期
	 * 
	 * @param
	 * @return
	 */
	public List<SelectDayButton> getSelectDay(CashSerialToPBOC cashSerialToPBOC) {
		
		List<SelectDayButton> allButton = new ArrayList<SelectDayButton>();
		String uploadHz = cashSerialToPBOC.getUploadHz();
		
		int uploadValue = cashSerialToPBOC.getUploadValue();
		
	    
	    char[] binaryArray = Integer.toBinaryString(uploadValue).toCharArray();
	    
	    int allDay = 0;
		if(CashSerialToPBOCConsts.UPDATE_CONFIG_CYCLE_DAY.equals(uploadHz)){
			allDay = 0;
		}else if(CashSerialToPBOCConsts.UPDATE_CONFIG_CYCLE_WEEK.equals(uploadHz)){
			allDay = 7;
		}else if(CashSerialToPBOCConsts.UPDATE_CONFIG_CYCLE_MONTH.equals(uploadHz)){
			allDay = 31;
		}
		
		
		boolean setChecked = false;
		
		if(cashSerialToPBOC.getId()!=null && cashSerialToPBOC.getId()!=""){
		CashSerialToPBOC cashSerial = cashSerialToPBOCDao.getByKey(cashSerialToPBOC.getId());
		if(cashSerialToPBOC.getUploadHz().equals(cashSerial.getUploadHz())){
			setChecked = true;
		}
		}
		
	    
		
		String dayNames[] = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
		
		for(int i=1;i<=allDay;i++){ 
			SelectDayButton selectDayButton = new SelectDayButton();
			selectDayButton.setButtonType("button");
			selectDayButton.setButtonCode("day"+i);
			if(allDay==7){
			selectDayButton.setI18nName(dayNames[i-1]);
			}else{
				selectDayButton.setI18nName(i+"号");
			}
			selectDayButton.setSubSystem("SubSystem");
			if(setChecked && uploadValue!=0 && binaryArray.length>=i && binaryArray[binaryArray.length-i]=='1'){
			selectDayButton.setChecked(true);
			}else{
				selectDayButton.setChecked(false);
			}
			selectDayButton.setIconURL(null);
			selectDayButton.setOrder(i);
			
			allButton.add(selectDayButton);
		}
		
		return allButton;
	}
	
	/**
	 * delete the selected CashSerialToPBOC sets
	 * 
	 * add by hqjie
	 * 
	 * @param args
	 * @return void
	 * */
	public void deleteSelectedCashSerialToPBOC(String[] args) {
		if (null != args && args.length > 0) {
			for (String arg : args) {
				CashSerialToPBOC user = cashSerialToPBOCDao.getByKey(arg);
				cashSerialToPBOCDao.delete(user);
			}
		}
	}
	


}
