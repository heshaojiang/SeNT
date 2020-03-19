package com.grgbanking.cml.report.entity;


/**
 * ���������Ϣ
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
    * @param id ��ʶ��
    * @param tmlNum �ն˱��
    * @param sumVersion05 05��
    * @param sumVersion99 99��
    * @param sumPassmoney ��ͨ�ܽ��
    * @param  sumAtmmoney atm�ܽ��
    * @param sumStubbedmoney ������ܽ��
    * @param sumTrailmoney β�����
    * @param sumShadinessmoney ���ɳ����
    * @param sumFalsecoinmoney �ٱҽ��
    * @param sumTatalmoney ����ܽ��
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
    * @return String �ն˱��
    * */
	public String getTmlNum() {
		return tmlNum;
	}

    /**
     * @param tmlNum  �ն˱��
     * 
     * */
	public void setTmlNum(String tmlNum) {
		this.tmlNum = tmlNum;
	}
	/**
	 * ��ʶ
	 * @return String
	 * 
	 * */
	public String getId() {
		return id;
	}
    /**
     * @param id ��ʶ
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
   * @param sumVersion05 05��
   * */
	public void setSumVersion05(float sumVersion05) {
		this.sumVersion05 = sumVersion05;
	}
   /**
    * @return Float ������
    * */
	public Float getSumVersion99() {
		return sumVersion99;
	}
  /**
   * @param sumVersion99 99��
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
      * @param sumPassmoney ��ͨ�ҽ��
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
     * @param sumAtmmoney  atm���
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
     * @param sumStubbedmoney ����ҽ��
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
     * @param sumTrailmoney β�����
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
     * @param sumShadinessmoney β�����
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
     * @param sumFalsecoinmoney β�����
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
     * @param sumTatalmoney β�����
     * */
	public void setSumTatalmoney(float sumTatalmoney) {
		this.sumTatalmoney = sumTatalmoney;
	}

	
}
