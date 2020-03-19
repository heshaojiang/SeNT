/**
 * 文件名：CardTypeDao.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.card.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.card.entity.CardType;

/**
 * card type dao<br>
 * 卡类型DAO
 * 
 * @author yrliang
 */
@Repository
public class CardTypeDao extends BaseDao<CardType> {
	private static final String QUERY_BY_CARD_ID_FUZZILY = " from CardType ct where ct.cardId like '%'||?||'%' ";

	/**
	 * CardId is Unique that save in DB.<br>
	 * 
	 * @param cardId
	 * @return CardType
	 */
	public CardType getByCardId(String cardId) {
		return super.findUniqueBy(AppConstants.CARD_ID, cardId);
	}

	/**
	 * 
	 * @param cardId
	 * @param orgId
	 * @return
	 */
	public CardType getByCardIdInTheSameOrg(String cardId, String orgId) {
		String hql = "from CardType c where c.cardId = ? and c.orgId = ?";
		return super.findUnique(hql, new Object[] { cardId, orgId });
	}

	/**
	 * Search the card type be card id in fuzzy<br>
	 * 根据卡ID模糊查询卡类型
	 * 
	 * @param page
	 * @param cardId
	 * @return Page<CardType>
	 */
	public Page<CardType> getByCardIdFuzzily(Page<CardType> page, String cardId) {
		if (cardId == null || cardId.trim().length() == 0)
			return super.findPage(page);
		return super.findPage(page, QUERY_BY_CARD_ID_FUZZILY, cardId);
	}

	/**
	 * 
	 * query card type according to the parameters of pass on.<br>
	 * 根据传过来的参数查询银行卡类型列表
	 * 
	 * @param page
	 * @param params
	 * @return Page<CardType>
	 */
	public Page<CardType> searchCardTypeByParams(final Page<CardType> page, Map<String, String> params) {
		StringBuffer hql = new StringBuffer(" from CardType ct ");
		Map<String, Object> param = new HashMap<String, Object>();
		if (params != null) {
			hql.append(WHERE);
			for (String key : params.keySet()) {
				if (params.get(key) == null) {
					continue;
				}
				String paramValue = params.get(key);
				if (key.equals("cardId") && !paramValue.equals("")) {
					hql.append(" ct.cardId like :cardId and ");
					param.put("cardId", "%" + paramValue + "%");
				} else if (key.equals("orgid")) {
					hql.append(" (select o.id from OrgInfo o where o.id = ct.orgId ) like :orgId and ");
					param.put("orgId", paramValue + "%");
				} else if (key.equals("userOrgid")) {
					hql.append(" (select o2.id from OrgInfo o2 where o2.id = ct.orgId ) like :userOrgId and ");
					param.put("userOrgId", paramValue + "%");
				}
			}
			if (hql.toString().endsWith(WHERE)) {
				hql.delete(hql.length() - WHERE.length(), hql.length());
			} else {
				hql.delete(hql.length() - 4, hql.length());
			}
		}
		return super.findPage(page, hql.toString(), param);
	}
}
