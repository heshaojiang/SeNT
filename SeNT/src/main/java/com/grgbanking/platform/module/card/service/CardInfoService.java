/**
 * 文件名：CardType.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.card.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.utils.BeanCommonUtils;
import com.grgbanking.platform.module.card.dao.CardInfoDao;
import com.grgbanking.platform.module.card.entity.CardInfo;
import com.grgbanking.platform.module.common.MessageKeyConstants;

/**
 * card information service<br>
 * 银行卡信息服务类
 * 
 * @author yrliang
 */
@Service
@Transactional
public class CardInfoService {
	@Autowired
	CardInfoDao cardInfoDao;

	/**
	 * Create a new Card Info record<br>
	 * 创建新的银行卡纪录
	 * 
	 * @param cardInfo
	 * @return boolean
	 */
	public boolean newCardInfo(CardInfo cardInfo) {
		validateCardInfo(cardInfo);

		if (cardInfo.getId() != null) {
			cardInfo.setId(null);
		}

		CardInfo existedCardInfo = cardInfoDao.getByCardId(cardInfo.getCardId());
		if (existedCardInfo != null) {
			throw new AppException(MessageKeyConstants.CARD_EXISTED_CARD_INFO,
					"The Card Info has already existed. Please change the Card Id and submit again. ");
		}

		cardInfoDao.save(cardInfo);

		return true;
	}

	/**
	 * Delete the selected card info<br>
	 * 删除选中的单条纪录
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean deleteCardInfo(String id) {
		validateId(id);

		cardInfoDao.delete(id);

		return true;
	}

	/**
	 * Batch delete the selected card info(s)<br>
	 * 删除一条或多条已选中的纪录
	 * 
	 * @param ids
	 * @return boolean
	 */
	public boolean batchDelete(Collection<String> ids) {
		if (ids == null || ids.size() == 0) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");
		}

		for (String id : ids) {
			deleteCardInfo(id);
		}

		return true;
	}

	/**
	 * Update the selected card info<br>
	 * 更新选中的卡信息纪录
	 * 
	 * @param cardInfo
	 * @return boolean
	 */
	public boolean updateCardInfo(CardInfo cardInfo) {
		validateCardInfo(cardInfo);
		String newId = cardInfo.getId();
		validateId(newId);

		CardInfo existedCardInfo = cardInfoDao.getByCardId(cardInfo.getCardId());
		if (existedCardInfo != null && !newId.equals(existedCardInfo.getId())) {
			throw new AppException(MessageKeyConstants.CARD_EXISTED_CARD_INFO,
					"The Card info has already existed. Please change the Card Id and submit again. ");
		} else if (existedCardInfo != null && BeanCommonUtils.compareValue(cardInfo, existedCardInfo)) {
			// update nothing when the card info has no change.
			return true;
		}
		// throw new AppException(MessageKeyConstants.NO_CHANGE,
		// "No change is made.");
		cardInfoDao.copyUpdate(cardInfo);

		return true;
	}

	/**
	 * Search card info by card id in fuzzy<br>
	 * 根据卡ID模糊查询银行卡信息
	 * 
	 * @param page
	 * @param cardId
	 * @return Page<CardInfo>
	 */
	public Page<CardInfo> searchCardInfo(final Page<CardInfo> page, String cardId) {
		return cardInfoDao.getByCardIdFuzzily(page, cardId);
	}

	/**
	 * Validate the c_id when edit the record<br>
	 * 更新纪录时校验ID
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
	 * Validate the submit form of Card Info<br>
	 * 验证提交的表单信息
	 * 
	 * @param cardInfo
	 * @return boolean
	 */
	private boolean validateCardInfo(CardInfo cardInfo) {
		if (cardInfo == null) {
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again. ");
		}

		if (!StringUtils.hasText(cardInfo.getCardId())) {
			throw new AppException(MessageKeyConstants.CARD_ID_NOT_NULL,
					"Card Id can not be left empty. Please input card id and submit again.");
		}
		if (!StringUtils.hasText(cardInfo.getCardName())) {
			throw new AppException(MessageKeyConstants.CARD_NAME_NOT_NULL,
					"Card Name can not be left empty. Please input card name and submit again.");
		}
		if (!StringUtils.hasText(cardInfo.getBankId())) {
			throw new AppException(MessageKeyConstants.CARD_BANK_ID_NOT_NULL,
					"Bank Id can not be left empty. Please input bank id and submit again.");
		}
		if (!StringUtils.hasText(cardInfo.getBankName())) {
			throw new AppException(MessageKeyConstants.CARD_BANK_NAME_NOT_NULL,
					"Bank Name can not be left empty. Please input bank name and submit again.");
		}
		if (cardInfo.getIdLength() <= 0) {
			throw new AppException(MessageKeyConstants.CARD_INVALID_ID_LENGTH,
					"Id length can not be ZERO. Please change id length and submit again.");
		}
		if (cardInfo.getLength() <= 3) {
			throw new AppException(MessageKeyConstants.CARD_INVALID_LENGTH,
					"Length can not be ZERO. Please change length and submit again.");
		}
		if (!StringUtils.hasText(cardInfo.getApplyATM())) {
			throw new AppException(MessageKeyConstants.CARD_APPLY_ATM_NOT_NULL,
					"Apply ATM can not be left empty. Please select apply ATM and submit again.");
		}
		if (!StringUtils.hasText(cardInfo.getApplyPOS())) {
			throw new AppException(MessageKeyConstants.CARD_APPLY_POS_NOT_NULL,
					"Apply POS can not be left empty. Please select apply POS and submit again.");
		}
		if (!StringUtils.hasText(cardInfo.getCardType())) {
			throw new AppException(MessageKeyConstants.CARD_TYPE_NOT_NULL,
					"Card Type can not be left empty. Please select card type and submit again.");
		}

		return true;
	}
}
