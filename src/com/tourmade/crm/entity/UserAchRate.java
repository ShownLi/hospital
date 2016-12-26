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
	private String percentJan_T;
	private String percentJan_TR;
	private String percentJan_TM;
	/**
	 * 二月份
	 */
	private String percentFeb;
	private String percentFeb_T;
	private String percentFeb_TR;
	private String percentFeb_TM;
	/**
	 * 三月份
	 */
	private String percentMar;
	private String percentMar_T;
	private String percentMar_TR;
	private String percentMar_TM;
	/**
	 * 四月份
	 */
	private String percentApr;
	private String percentApr_T;
	private String percentApr_TR;
	private String percentApr_TM;
	/**
	 * 五月份
	 */
	private String percentMay;
	private String percentMay_T;
	private String percentMay_TR;
	private String percentMay_TM;
	/**
	 * 六月份
	 */
	private String percentJun;
	private String percentJun_T;
	private String percentJun_TR;
	private String percentJun_TM;
	/**
	 * 七月份
	 */
	private String percentJul;
	private String percentJul_T;
	private String percentJul_TR;
	private String percentJul_TM;
	/**
	 * 八月份
	 */
	private String percentAug;
	private String percentAug_T;
	private String percentAug_TR;
	private String percentAug_TM;
	/**
	 * 九月份
	 */
	private String percentSep;
	private String percentSep_T;
	private String percentSep_TR;
	private String percentSep_TM;
	/**
	 * 十月份
	 */
	private String percentOct;
	private String percentOct_T;
	private String percentOct_TR;
	private String percentOct_TM;
	/**
	 * 十一月份
	 */
	private String percentNov;
	private String percentNov_T;
	private String percentNov_TR;
	private String percentNov_TM;
	/**
	 * 十二月份
	 */
	private String percentDec;
	private String percentDec_T;
	private String percentDec_TR;
	private String percentDec_TM;
	
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
	public String getPercentJan_T() {
		return percentJan_T;
	}
	public void setPercentJan_T(String percentJan_T) {
		this.percentJan_T = percentJan_T;
	}
	public String getPercentFeb_T() {
		return percentFeb_T;
	}
	public void setPercentFeb_T(String percentFeb_T) {
		this.percentFeb_T = percentFeb_T;
	}
	public String getPercentMar_T() {
		return percentMar_T;
	}
	public void setPercentMar_T(String percentMar_T) {
		this.percentMar_T = percentMar_T;
	}
	public String getPercentApr_T() {
		return percentApr_T;
	}
	public void setPercentApr_T(String percentApr_T) {
		this.percentApr_T = percentApr_T;
	}
	public String getPercentMay_T() {
		return percentMay_T;
	}
	public void setPercentMay_T(String percentMay_T) {
		this.percentMay_T = percentMay_T;
	}
	public String getPercentJun_T() {
		return percentJun_T;
	}
	public void setPercentJun_T(String percentJun_T) {
		this.percentJun_T = percentJun_T;
	}
	public String getPercentJul_T() {
		return percentJul_T;
	}
	public void setPercentJul_T(String percentJul_T) {
		this.percentJul_T = percentJul_T;
	}
	public String getPercentAug_T() {
		return percentAug_T;
	}
	public void setPercentAug_T(String percentAug_T) {
		this.percentAug_T = percentAug_T;
	}
	public String getPercentSep_T() {
		return percentSep_T;
	}
	public void setPercentSep_T(String percentSep_T) {
		this.percentSep_T = percentSep_T;
	}
	public String getPercentOct_T() {
		return percentOct_T;
	}
	public void setPercentOct_T(String percentOct_T) {
		this.percentOct_T = percentOct_T;
	}
	public String getPercentNov_T() {
		return percentNov_T;
	}
	public void setPercentNov_T(String percentNov_T) {
		this.percentNov_T = percentNov_T;
	}
	public String getPercentDec_T() {
		return percentDec_T;
	}
	public void setPercentDec_T(String percentDec_T) {
		this.percentDec_T = percentDec_T;
	}
	public String getPercentJan_TR() {
		return percentJan_TR;
	}
	public void setPercentJan_TR(String percentJan_TR) {
		this.percentJan_TR = percentJan_TR;
	}
	public String getPercentFeb_TR() {
		return percentFeb_TR;
	}
	public void setPercentFeb_TR(String percentFeb_TR) {
		this.percentFeb_TR = percentFeb_TR;
	}
	public String getPercentMar_TR() {
		return percentMar_TR;
	}
	public void setPercentMar_TR(String percentMar_TR) {
		this.percentMar_TR = percentMar_TR;
	}
	public String getPercentApr_TR() {
		return percentApr_TR;
	}
	public void setPercentApr_TR(String percentApr_TR) {
		this.percentApr_TR = percentApr_TR;
	}
	public String getPercentMay_TR() {
		return percentMay_TR;
	}
	public void setPercentMay_TR(String percentMay_TR) {
		this.percentMay_TR = percentMay_TR;
	}
	public String getPercentJun_TR() {
		return percentJun_TR;
	}
	public void setPercentJun_TR(String percentJun_TR) {
		this.percentJun_TR = percentJun_TR;
	}
	public String getPercentJul_TR() {
		return percentJul_TR;
	}
	public void setPercentJul_TR(String percentJul_TR) {
		this.percentJul_TR = percentJul_TR;
	}
	public String getPercentAug_TR() {
		return percentAug_TR;
	}
	public void setPercentAug_TR(String percentAug_TR) {
		this.percentAug_TR = percentAug_TR;
	}
	public String getPercentSep_TR() {
		return percentSep_TR;
	}
	public void setPercentSep_TR(String percentSep_TR) {
		this.percentSep_TR = percentSep_TR;
	}
	public String getPercentOct_TR() {
		return percentOct_TR;
	}
	public void setPercentOct_TR(String percentOct_TR) {
		this.percentOct_TR = percentOct_TR;
	}
	public String getPercentNov_TR() {
		return percentNov_TR;
	}
	public void setPercentNov_TR(String percentNov_TR) {
		this.percentNov_TR = percentNov_TR;
	}
	public String getPercentDec_TR() {
		return percentDec_TR;
	}
	public void setPercentDec_TR(String percentDec_TR) {
		this.percentDec_TR = percentDec_TR;
	}
	public String getPercentJan_TM() {
		return percentJan_TM;
	}
	public void setPercentJan_TM(String percentJan_TM) {
		this.percentJan_TM = percentJan_TM;
	}
	public String getPercentFeb_TM() {
		return percentFeb_TM;
	}
	public void setPercentFeb_TM(String percentFeb_TM) {
		this.percentFeb_TM = percentFeb_TM;
	}
	public String getPercentMar_TM() {
		return percentMar_TM;
	}
	public void setPercentMar_TM(String percentMar_TM) {
		this.percentMar_TM = percentMar_TM;
	}
	public String getPercentApr_TM() {
		return percentApr_TM;
	}
	public void setPercentApr_TM(String percentApr_TM) {
		this.percentApr_TM = percentApr_TM;
	}
	public String getPercentMay_TM() {
		return percentMay_TM;
	}
	public void setPercentMay_TM(String percentMay_TM) {
		this.percentMay_TM = percentMay_TM;
	}
	public String getPercentJun_TM() {
		return percentJun_TM;
	}
	public void setPercentJun_TM(String percentJun_TM) {
		this.percentJun_TM = percentJun_TM;
	}
	public String getPercentJul_TM() {
		return percentJul_TM;
	}
	public void setPercentJul_TM(String percentJul_TM) {
		this.percentJul_TM = percentJul_TM;
	}
	public String getPercentAug_TM() {
		return percentAug_TM;
	}
	public void setPercentAug_TM(String percentAug_TM) {
		this.percentAug_TM = percentAug_TM;
	}
	public String getPercentSep_TM() {
		return percentSep_TM;
	}
	public void setPercentSep_TM(String percentSep_TM) {
		this.percentSep_TM = percentSep_TM;
	}
	public String getPercentOct_TM() {
		return percentOct_TM;
	}
	public void setPercentOct_TM(String percentOct_TM) {
		this.percentOct_TM = percentOct_TM;
	}
	public String getPercentNov_TM() {
		return percentNov_TM;
	}
	public void setPercentNov_TM(String percentNov_TM) {
		this.percentNov_TM = percentNov_TM;
	}
	public String getPercentDec_TM() {
		return percentDec_TM;
	}
	public void setPercentDec_TM(String percentDec_TM) {
		this.percentDec_TM = percentDec_TM;
	}
	@Override
	public String toString() {
		return "UserAchRate [userName=" + userName + ", code=" + code + ", percentJan=" + percentJan + ", percentJan_T="
				+ percentJan_T + ", percentJan_TR=" + percentJan_TR + ", percentJan_TM=" + percentJan_TM
				+ ", percentFeb=" + percentFeb + ", percentFeb_T=" + percentFeb_T + ", percentFeb_TR=" + percentFeb_TR
				+ ", percentFeb_TM=" + percentFeb_TM + ", percentMar=" + percentMar + ", percentMar_T=" + percentMar_T
				+ ", percentMar_TR=" + percentMar_TR + ", percentMar_TM=" + percentMar_TM + ", percentApr=" + percentApr
				+ ", percentApr_T=" + percentApr_T + ", percentApr_TR=" + percentApr_TR + ", percentApr_TM="
				+ percentApr_TM + ", percentMay=" + percentMay + ", percentMay_T=" + percentMay_T + ", percentMay_TR="
				+ percentMay_TR + ", percentMay_TM=" + percentMay_TM + ", percentJun=" + percentJun + ", percentJun_T="
				+ percentJun_T + ", percentJun_TR=" + percentJun_TR + ", percentJun_TM=" + percentJun_TM
				+ ", percentJul=" + percentJul + ", percentJul_T=" + percentJul_T + ", percentJul_TR=" + percentJul_TR
				+ ", percentJul_TM=" + percentJul_TM + ", percentAug=" + percentAug + ", percentAug_T=" + percentAug_T
				+ ", percentAug_TR=" + percentAug_TR + ", percentAug_TM=" + percentAug_TM + ", percentSep=" + percentSep
				+ ", percentSep_T=" + percentSep_T + ", percentSep_TR=" + percentSep_TR + ", percentSep_TM="
				+ percentSep_TM + ", percentOct=" + percentOct + ", percentOct_T=" + percentOct_T + ", percentOct_TR="
				+ percentOct_TR + ", percentOct_TM=" + percentOct_TM + ", percentNov=" + percentNov + ", percentNov_T="
				+ percentNov_T + ", percentNov_TR=" + percentNov_TR + ", percentNov_TM=" + percentNov_TM
				+ ", percentDec=" + percentDec + ", percentDec_T=" + percentDec_T + ", percentDec_TR=" + percentDec_TR
				+ ", percentDec_TM=" + percentDec_TM + "]";
	}
}
