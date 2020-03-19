/**
 * 文件名：CardTypeService.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.card.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.utils.BeanCommonUtils;
import com.grgbanking.platform.module.card.dao.CardTypeDao;
import com.grgbanking.platform.module.card.entity.CardType;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;

/**
 * card type service<br>
 * 银行卡类型服务类
 * 
 * @author yrliang
 */
@Service
@Transactional
public class CardTypeService {
	@Autowired
	CardTypeDao cardTypeDao;

	@Autowired
	OrgInfoDao orgInfodao;

	/**
	 * create a new card type<br>
	 * 创建一个新的银行卡类型
	 * 
	 * @param cardType
	 *            卡类型
	 * @return boolean
	 */
	public boolean saveCardType(CardType cardType) {
		validateCardType(cardType);

		if (cardType.getId() != null) {
			cardType.setId(null);
		}

		CardType existedCardType = cardTypeDao.getByCardIdInTheSameOrg(cardType.getCardId(), cardType.getOrgId());

		if (existedCardType != null) {
			throw new AppException(MessageKeyConstants.CARD_EXISTED_CARD_TYPE,
					"The Card Type has already existed. Please change the Card Id and submit again. ");
		}

		cardTypeDao.saveNew(cardType);

		return true;
	}

	/**
	 * Delete one card type record<br>
	 * 删除一条银行卡类型纪录
	 * 
	 * @param id
	 *            卡id
	 * @return boolean
	 */
	public boolean deleteCardType(String id) {
		validateId(id);

		cardTypeDao.delete(id);

		return true;
	}

	/**
	 * Batch delete the card type records<br>
	 * 删除一条或多条银行卡类型纪录
	 * 
	 * @param ids
	 *            卡ids
	 * @return boolean
	 */
	public boolean batchDelete(Collection<String> ids) {
		if (ids == null || ids.size() == 0) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}

		for (String id : ids) {
			deleteCardType(id);
		}

		return true;
	}

	/**
	 * Update the selected card type<br>
	 * 更新选中的纪录
	 * 
	 * @param cardType
	 *            卡类型
	 * @return boolean
	 */
	public boolean updateCardType(CardType cardType) {
		validateCardType(cardType);
		String newId = cardType.getId();
		validateId(newId);

		CardType existedCardType = cardTypeDao.getByCardIdInTheSameOrg(cardType.getCardId(), cardType.getOrgId());

		if (existedCardType != null && !newId.equals(existedCardType.getId())) {
			throw new AppException(MessageKeyConstants.CARD_EXISTED_CARD_TYPE,
					"The Card Type has already existed. Please change the Card Id and submit again. ");
		} else if (existedCardType != null && BeanCommonUtils.compareValue(cardType, existedCardType)) {
			return true;
		}

		cardTypeDao.copyUpdate(cardType);

		return true;
	}

	/**
	 * Search the card type by card id in fuzzy<br>
	 * 根据银行卡ID模糊查询卡类型
	 * 
	 * @param page
	 *            页
	 * @param cardId
	 *            cardId
	 * @return Page<CardType>
	 */
	public Page<CardType> searchCardType(final Page<CardType> page, String cardId) {
		return cardTypeDao.getByCardIdFuzzily(page, cardId);
	}

	/**
	 * 
	 * search Card Type By Params<br>
	 * 根据传过来的参数查询银行卡类型列表
	 * 
	 * @param page
	 *            页
	 * @param params
	 *            参数
	 * @return Page<CardType>
	 */
	public Page<CardType> searchCardTypeByParams(final Page<CardType> page, Map<String, String> params) {
		return cardTypeDao.searchCardTypeByParams(page, params);
	}

	/**
	 * Validate the c_id when edit the record<br>
	 * 当编辑一条纪录时校验ID
	 * 
	 * @param id
	 * @return boolean
	 */
	private boolean validateId(String id) {
		if (!StringUtils.hasText(id)) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}

		return true;
	}

	/**
	 * Validate the submit form of CardType<br>
	 * 校验提交表单的数据
	 * 
	 * @param cardType
	 * @return boolean
	 */
	private boolean validateCardType(CardType cardType) {
		if (cardType == null) {
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again. ");
		}

		if (!StringUtils.hasText(cardType.getOrgId())) {
			throw new AppException(MessageKeyConstants.CARD_ORG_ID_NOT_NULL,
					"Org can not be left empty. Please select org and submit again.");
		}
		if (!StringUtils.hasText(cardType.getCardId())) {
			throw new AppException(MessageKeyConstants.CARD_ID_NOT_NULL,
					"Card Id can not be left empty. Please input card id and submit again.");
		}
		if (!StringUtils.hasText(cardType.getSelf())) {
			throw new AppException(MessageKeyConstants.CARD_SELF_NOT_NULL,
					"Self can not be left empty. Please input self and submit again.");
		}
		if (!StringUtils.hasText(cardType.getProvince())) {
			throw new AppException(MessageKeyConstants.CARD_PROVINCE_NOT_NULL,
					"Province can not be left empty. Please input Province and submit again.");
		}
		if (!StringUtils.hasText(cardType.getLocal())) {
			throw new AppException(MessageKeyConstants.CARD_LOCAL_NOT_NULL,
					"Local can not be left empty. Please input Local and submit again.");
		}

		return true;
	}

	/**
	 * 
	 * @param orgId
	 *            机构id
	 * @return 成功
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public boolean sychronizeSubOrg(String orgId) {
		List<CardType> typeList = cardTypeDao.findBy("orgId", orgId);
		List<OrgInfo> subList = orgInfodao.getLeavesByParentId(orgId);

		for (OrgInfo sub : subList) {
			for (CardType type : typeList) {
				CardType orgin = cardTypeDao.getByCardIdInTheSameOrg(type.getCardId(), sub.getId());
				if (orgin == null) {
					CardType newType = new CardType();
					newType.setCardId(type.getCardId());
					newType.setOrgId(sub.getId());
					newType.setLocal(type.getLocal());
					newType.setProvince(type.getProvince());
					newType.setSelf(type.getSelf());

					saveNew(newType);
				} else {
					orgin.setLocal(type.getLocal());
					orgin.setProvince(type.getProvince());
					orgin.setSelf(type.getSelf());
				}
			}
		}
		return true;
	}

	/**
	 * 新增
	 * 
	 * @param cardType
	 *            卡类型
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveNew(CardType cardType) {
		cardTypeDao.saveNew(cardType);
	}

}
