package com.grgbanking.cml.report.entity;


/**
 * 清分任务信息
 * **/
/**
 * @author yt
 *
 */
public class CmlReportDetail {
    
	
	
	private String id;
	private String tmlNum;
	private float sumVersion05;
	private float sumVersion99;
	private float sumPassmoney;
	private float sumAtmmoney;
	private float sumStubbedmoney;
	private float sumTrailmoney;
	private float sumShadinessmoney;
	private float sumFalsecoinmoney;
	private float sumTatalmoney;
   /**
    * @param id 标识符
    * @param tmlNum 终端编号
    * @param sumVersion05 05版
    * @param sumVersion99 99版
    * @param sumPassmoney 流通总金额
    * @param  sumAtmmoney atm总金额
    * @param sumStubbedmoney 残损币总金额
    * @param sumTrailmoney 尾钞金额
    * @param sumShadinessmoney 可疑钞金额
    * @param sumFalsecoinmoney 假币金额
    * @param sumTatalmoney 清分总金额
    * */
	public CmlReportDetail(String id, String tmlNum, float sumVersion05,
			float sumVersion99, float sumPassmoney,
			float sumAtmmoney, float sumStubbedmoney,
			float sumTrailmoney, float sumShadinessmoney,
			float sumFalsecoinmoney, float sumTatalmoney) {
		this.id = id;
		this.tmlNum = tmlNum;
		this.sumVersion05 = sumVersion05;
		this.sumVersion99 = sumVersion99;
		this.sumPassmoney = sumPassmoney;
		this.sumAtmmoney = sumAtmmoney;
		this.sumStubbedmoney = sumStubbedmoney;
		this.sumTrailmoney = sumTrailmoney;
		this.sumShadinessmoney = sumShadinessmoney;
		this.sumFalsecoinmoney = sumFalsecoinmoney;
		this.sumTatalmoney = sumTatalmoney;
	}
   /**
    * @return String 终端编号
    * */
	public String getTmlNum() {
		return tmlNum;
	}

    /**
     * @param tmlNum  终端编号
     * 
     * */
	public void setTmlNum(String tmlNum) {
		this.tmlNum = tmlNum;
	}
	/**
	 * 标识
	 * @return String
	 * 
	 * */
	public String getId() {
		return id;
	}
    /**
     * @param id 标识
     * */
	public void setId(String id) {
		this.id = id;
	}

	/***
	 * @return Float 
	 * 
	 * */

	public Float getSumVersion05() {
		return sumVersion05;
	}
  /**
   * @param sumVersion05 05版
   * */
	public void setSumVersion05(float sumVersion05) {
		this.sumVersion05 = sumVersion05;
	}
   /**
    * @return Float 浮点型
    * */
	public Float getSumVersion99() {
		return sumVersion99;
	}
  /**
   * @param sumVersion99 99版
   * */
	public void setSumVersion99(float sumVersion99) {
		this.sumVersion99 = sumVersion99;
	}
    /**
     * @return Float
     * */
	public Float getSumPassmoney() {
		return sumPassmoney;
	}
     /**
      * @param sumPassmoney 流通币金额
      * */
	public void setSumPassmoney(float sumPassmoney) {
		this.sumPassmoney = sumPassmoney;
	}
     /**
      * @return float 
      * */
	public float getSumAtmmoney() {
		return sumAtmmoney;
	}
    /**
     * @param sumAtmmoney  atm金额
     * */
	public void setSumAtmmoney(float sumAtmmoney) {
		this.sumAtmmoney = sumAtmmoney;
	}
    /**
     * @return float 
     * */
	public float getSumStubbedmoney() {
		return sumStubbedmoney;
	}
    /**
     * @param sumStubbedmoney 残损币金额
     * */
	public void setSumStubbedmoney(float sumStubbedmoney) {
		this.sumStubbedmoney = sumStubbedmoney;
	}
    /**
     * 
     * @return Float 
     * */
	public Float getSumTrailmoney() {
		return sumTrailmoney;
	}
	/**
     * @param sumTrailmoney 尾钞金额
     * */
	public void setSumTrailmoney(float sumTrailmoney) {
		this.sumTrailmoney = sumTrailmoney;
	}
	 /**
     * 
     * @return Float 
     * */
	public Float getSumShadinessmoney() {
		return sumShadinessmoney;
	}
	/**
     * @param sumShadinessmoney 尾钞金额
     * */
	public void setSumShadinessmoney(float sumShadinessmoney) {
		this.sumShadinessmoney = sumShadinessmoney;
	}
	 /**
     * 
     * @return Float 
     * */
	public Float getSumFalsecoinmoney() {
		return sumFalsecoinmoney;
	}
	/**
     * @param sumFalsecoinmoney 尾钞金额
     * */
	public void setSumFalsecoinmoney(float sumFalsecoinmoney) {
		this.sumFalsecoinmoney = sumFalsecoinmoney;
	}
	 /**
     * 
     * @return Float 
     * */
	public Float getSumTatalmoney() {
		return sumTatalmoney;
	}
	/**
     * @param sumTatalmoney 尾钞金额
     * */
	public void setSumTatalmoney(float sumTatalmoney) {
		this.sumTatalmoney = sumTatalmoney;
	}

	
}
