package com.grgbanking.sent.watch.entity;

/**
 * AccountAnalyse 自定义实体类
 * 异常卡号交易中所需要的卡实体</br>
 * **/
public class AccountAnalyse {
	private String accountNo;
	private Long count;
	
	/**
	 *Constructor  unUsedField
	 **/
	public AccountAnalyse() {
	 
	}
	/**
	 * @param accountNo 卡号
	 * @param count   次数 </br>
	 **/
	public AccountAnalyse(String accountNo, Long count) {
		this.accountNo = accountNo;
		this.count = count;
	}

	/**
	 * 卡号
	 * @return  accountNo </br>
	 **/
	public String getAccountNo() {
		return accountNo;
	}

	 /**
	  * 卡号
	  * @param  accountNo   </br>
	  **/
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * 次数
	 * @return count </br>
	 **/
	public Long getCount() {
		return count;
	}

	/**
	 * @param count 次数  </br>
	 **/
	public void setCount(Long count) {
		this.count = count;
	}
}
