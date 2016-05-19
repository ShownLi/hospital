package com.tourmade.crm.common.framework.constants;



public class HealthInterveneUtilConstant {

	/**
	 * 健康干预 方式 
	 * 1：APP下推
	 * 2：短信干预
	 * 4：邮件干预
	 */
	public static final String HEALTHPLAT_INTERVENE_APP="1";
	public static final String HEALTHPLAT_INTERVENE_EMAIL="4";
	public static final String HEALTHPLAT_INTERVENE_SMS="2";
	
	/**
	 * 健康干预类型
	 * 0： 监测干预
	 * 1： 人员干预
	 */
	public static final String HEALTHPLAT_INTERVENE_TYPE_PERSON="1";
	public static final String HEALTHPLAT_INTERVENE_TYPE_DATA="0";
	
	
	/**
	 * 干预发送状态
	 * 0： 成功
	 * 1： 失败
	 */
	public static final String HEALTHPLAT_INTERVENE_SUCCESS="0";
	public static final String HEALTHPLAT_INTERVENE_FAIL="1";
	
	/**
	 * 健康管理用户客户号前缀
	 */
	public static final String HEALTH_CUST_CODE_PRE="HM";
	
	/**
	 * 健康管理用户来源类型
	 */
	public static final String HEALTH_CUST_SRC="4";//体检中心
	
	/**
	 * 健康管理对应云平台用户类型
	 */
	public static final String HEALTH_CUST_TYPE_PERSON="0";//0：个人/集团客户
	
	/**
	 * 健康管理用户 对应云平台用户数据状态
	 */
	public static final String HEALTH_CUST_STATUS_NORMAL="0";//正常
	public static final String HEALTH_CUST_STATUS_UNNORMAL="1";//不正常
	
	/**
	 * 健康管理用户对应云平台，账户锁定状态
	 * 
	 */
	public static final String HEALTH_CUST_ACCOUNT_LOCK_NO="0";//未锁
	public static final String HEALTH_CUST_ACCOUNT_LOCK_YES="1";// 已锁
	
	/**
	 * 健康管理机构在云平台中的类型
	 */
	public static final String HEALTH_ORG_TYPE="1";//健康管理机构对应云平台机构类型---渠道
	public static final String HEALTH_ORG_STATUS_NORMAL="0";//机构 状态 0: 正常  
	public static final String HEALTH_ORG_CHANNEL_TYPE_TJ="3";//渠道类型  3：体检中心
	public static final String HEATLH_ORG_CHANNEL_MARKTYPE_HOSPITAL="0";//渠道开设类型--医疗机构开设

	/**
	 * 健康管理企业计费方案--计费周期 
	 */
	public static final String HEALTH_ORG_BILLWAY_CYCLE0="0";
	
	/**
	 * 健康管理用户-服务标识类型
	 */
	public static final String HEATLH_USER_SERVICEFLAGTYPE_VIRTUALCARD="1";//服务卡号 
	
	/**
	 * app用户状态
	 * 0:无效    1:有效
	 */
	public static final String HEALTH_APP_USER_STATUS_NORMAL="1";
	public static final String HEALTH_APP_USER_STATUS_UNNORMAL="0";
	
}
