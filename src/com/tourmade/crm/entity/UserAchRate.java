package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 跟单员成交率统计实例
 * @author fjw
 *
 */
public class UserAchRate extends BaseBean<UserAchRate>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8977175772849253126L;
	/**
	 * 跟单员
	 */
	private String userName;
	/**
	 * 代码
	 */
	private String code;
	/**
	 * 一月份
	 */
	private String percentJan;
	/**
	 * 二月份
	 */
	private String percentFeb;
	/**
	 * 三月份
	 */
	private String percentMar;
	/**
	 * 四月份
	 */
	private String percentApr;
	/**
	 * 五月份
	 */
	private String percentMay;
	/**
	 * 六月份
	 */
	private String percentJun;
	/**
	 * 七月份
	 */
	private String percentJul;
	/**
	 * 八月份
	 */
	private String percentAug;
	/**
	 * 九月份
	 */
	private String percentSep;
	/**
	 * 十月份
	 */
	private String percentOct;
	/**
	 * 十一月份
	 */
	private String percentNov;
	/**
	 * 十二月份
	 */
	private String percentDec;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPercentJan() {
		return percentJan;
	}
	public void setPercentJan(String percentJan) {
		this.percentJan = percentJan;
	}
	public String getPercentFeb() {
		return percentFeb;
	}
	public void setPercentFeb(String percentFeb) {
		this.percentFeb = percentFeb;
	}
	public String getPercentMar() {
		return percentMar;
	}
	public void setPercentMar(String percentMar) {
		this.percentMar = percentMar;
	}
	public String getPercentApr() {
		return percentApr;
	}
	public void setPercentApr(String percentApr) {
		this.percentApr = percentApr;
	}
	public String getPercentMay() {
		return percentMay;
	}
	public void setPercentMay(String percentMay) {
		this.percentMay = percentMay;
	}
	public String getPercentJun() {
		return percentJun;
	}
	public void setPercentJun(String percentJun) {
		this.percentJun = percentJun;
	}
	public String getPercentJul() {
		return percentJul;
	}
	public void setPercentJul(String percentJul) {
		this.percentJul = percentJul;
	}
	public String getPercentAug() {
		return percentAug;
	}
	public void setPercentAug(String percentAug) {
		this.percentAug = percentAug;
	}
	public String getPercentSep() {
		return percentSep;
	}
	public void setPercentSep(String percentSep) {
		this.percentSep = percentSep;
	}
	public String getPercentOct() {
		return percentOct;
	}
	public void setPercentOct(String percentOct) {
		this.percentOct = percentOct;
	}
	public String getPercentNov() {
		return percentNov;
	}
	public void setPercentNov(String percentNov) {
		this.percentNov = percentNov;
	}
	public String getPercentDec() {
		return percentDec;
	}
	public void setPercentDec(String percentDec) {
		this.percentDec = percentDec;
	}
	public UserAchRate(String userName, String percentJan, String percentFeb, String percentMar, String percentApr,
			String percentMay, String percentJun, String percentJul, String percentAug, String percentSep,
			String percentOct, String percentNov, String percentDec) {
		super();
		this.userName = userName;
		this.percentJan = percentJan;
		this.percentFeb = percentFeb;
		this.percentMar = percentMar;
		this.percentApr = percentApr;
		this.percentMay = percentMay;
		this.percentJun = percentJun;
		this.percentJul = percentJul;
		this.percentAug = percentAug;
		this.percentSep = percentSep;
		this.percentOct = percentOct;
		this.percentNov = percentNov;
		this.percentDec = percentDec;
	}
	public UserAchRate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserAchRate [userName=" + userName + ", code=" + code + ", percentJan=" + percentJan + ", percentFeb="
				+ percentFeb + ", percentMar=" + percentMar + ", percentApr=" + percentApr + ", percentMay="
				+ percentMay + ", percentJun=" + percentJun + ", percentJul=" + percentJul + ", percentAug="
				+ percentAug + ", percentSep=" + percentSep + ", percentOct=" + percentOct + ", percentNov="
				+ percentNov + ", percentDec=" + percentDec + "]";
	}
	@Override
	public String toCSVString() {
		String temp=userName.contains(",")? "\""+userName+"\"":userName;
		return 	temp+ ","  + percentJan + "," + percentFeb + "," + percentMar + "," + percentApr
				+ "," + percentMay + "," + percentJun + "," + percentJul + "," + percentAug + "," + percentSep
				+ "," + percentOct + "," + percentNov + "," + percentDec;
	}
}
