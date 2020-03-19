/**
 * 文件名：CardInfoDao.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.card.dao;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.card.entity.CardInfo;

/**
 * card information dao<br>
 * 卡信息DAO
 * 
 * @author yrliang
 */
@Repository
public class CardInfoDao extends BaseDao<CardInfo> {
	private static final String QUERY_BY_CARD_ID_FUZZILY = " from CardInfo ci where ci.cardId like '%'||?||'%' ";

	/**
	 * Get the card info by card id, card id is unique<br>
	 * 根据卡标识获取卡信息
	 * 
	 * @param cardId
	 * @return
	 */
	public CardInfo getByCardId(String cardId) {
		return super.findUniqueBy(AppConstants.CARD_ID, cardId);
	}

	/**
	 * Search the card info by card id fuzzy<br>
	 * 根据卡标识模糊查询卡信息
	 * 
	 * @param page
	 * @param cardId
	 * @return
	 */
	public Page<CardInfo> getByCardIdFuzzily(Page<CardInfo> page, String cardId) {
		if (cardId == null || cardId.trim().length() == 0) {
			return super.findPage(page);
		}
		return super.findPage(page, QUERY_BY_CARD_ID_FUZZILY, cardId);
	}
}
