package com.tourmade.crm.common.framework.constants;


public class UtilConstant {

	/**
	 * ��¼�û�����Session��Key
	 */
	public static final String LOGINUSERKEY = "loginUser";
	/**
	 * ��ҽ����
	 */
	public static final String ZYTZ = "3";

	/**
	 * ��������
	 */
	public static final String XL = "2";

	/**
	 * ����
	 */
	public static final String CG = "1";
	
	/**
	 * 顶级菜单 上级ID
	 */
	public static final String HEALTH_TREE_BASE_PARENTID="0";
	
	/**
	 * 菜单 类型
	 * 0：顶级菜单
	 * 1：子菜单
	 */
	public static final String HEALTH_MENU_TYPE_BASE="0";
	public static final String HEALTH_MENU_TYPE_TREE="1";
	
	/**
	 * 健康管理服务卡前缀 
	 */
	public static final String HEALTH_CUSTCARD_PRE="73";
	public static final String HEALTH_CUSTCARD_TYPE="9";//健康管理服务卡类型
	
	/**
	 *健康管理 检测 虚拟卡号是否在网站绑定 
	 *0：未绑定   1：绑定
	 */
	
	public static final String HEALTH_WEB_CHECKUSER_SUCCESS="0";
	public static final String HEALTH_WEB_CHECKUSER_FAIL="1";
	
	/**
	 * 健康管理 性别
	 * 0：男
	 * 1：女
	 */
	public static final String HEALTH_CUSTOMER_SEX_MAN="男";
	public static final String HEALTH_CUSTOMER_SEX_WOMAN="女";
	public static final String HEALTH_CUSTOMER_TOWEB_SEX_MAN="0";
	public static final String HEALTH_CUSTOMER_TOWEB_SEX_WOMAN="1";
	
	public static final String ONLINEDOCTORMSG_NEW = "1";//新呼叫
	public static final String ONLINEDOCTORMSG_ASSIGN = "2";//已分派
	public static final String ONLINEDOCTORMSG_TREATMENT = "3";//处理中
	public static final String ONLINEDOCTORMSG_CLOSE = "4";//已关闭
	
}
