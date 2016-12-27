package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class AgencyAchievementStats extends BaseBean<Agency>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private String agencyName;
	
	private String percentjan;
	
	private String percentfeb;
	
	private String percentmar;
	
	private String percentapr;
	
	private String percentmay;
	
	private String percentjun;
	
	private String percentjul;
	
	private String percentaug;
	
	private String percentsep;
	
	private String percentoct;
	
	private String percentnov;
	
	private String percentdece;
	
	private String searchStartTime;
	
	private String searchEndTime;

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getPercentjan() {
		return percentjan;
	}

	public void setPercentjan(String percentjan) {
		this.percentjan = percentjan;
	}

	public String getPercentfeb() {
		return percentfeb;
	}

	public void setPercentfeb(String percentfeb) {
		this.percentfeb = percentfeb;
	}

	public String getPercentmar() {
		return percentmar;
	}

	public void setPercentmar(String percentmar) {
		this.percentmar = percentmar;
	}

	public String getPercentapr() {
		return percentapr;
	}

	public void setPercentapr(String percentapr) {
		this.percentapr = percentapr;
	}

	public String getPercentmay() {
		return percentmay;
	}

	public void setPercentmay(String percentmay) {
		this.percentmay = percentmay;
	}

	public String getPercentjun() {
		return percentjun;
	}

	public void setPercentjun(String percentjun) {
		this.percentjun = percentjun;
	}

	public String getPercentjul() {
		return percentjul;
	}

	public void setPercentjul(String percentjul) {
		this.percentjul = percentjul;
	}

	public String getPercentaug() {
		return percentaug;
	}

	public void setPercentaug(String percentaug) {
		this.percentaug = percentaug;
	}

	public String getPercentsep() {
		return percentsep;
	}

	public void setPercentsep(String percentsep) {
		this.percentsep = percentsep;
	}

	public String getPercentoct() {
		return percentoct;
	}

	public void setPercentoct(String percentoct) {
		this.percentoct = percentoct;
	}

	public String getPercentnov() {
		return percentnov;
	}

	public void setPercentnov(String percentnov) {
		this.percentnov = percentnov;
	}

	public String getPercentdece() {
		return percentdece;
	}

	public void setPercentdece(String percentdece) {
		this.percentdece = percentdece;
	}

	public String getSearchStartTime() {
		return searchStartTime;
	}

	public void setSearchStartTime(String searchStartTime) {
		this.searchStartTime = searchStartTime;
	}

	public String getSearchEndTime() {
		return searchEndTime;
	}

	public void setSearchEndTime(String searchEndTime) {
		this.searchEndTime = searchEndTime;
	}

	@Override
	public String toString() {
		return "AgencyAchievementStats [agencyName=" + agencyName + ", percentjan=" + percentjan + ", percentfeb="
				+ percentfeb + ", percentmar=" + percentmar + ", percentapr=" + percentapr + ", percentmay="
				+ percentmay + ", percentjun=" + percentjun + ", percentjul=" + percentjul + ", percentaug="
				+ percentaug + ", percentsep=" + percentsep + ", percentoct=" + percentoct + ", percentnov="
				+ percentnov + ", percentdece=" + percentdece + ", searchStartTime=" + searchStartTime
				+ ", searchEndTime=" + searchEndTime + "]";
	}
	@Override
	public String toCSVString() {
		return agencyName + ", " + percentjan + ", " + percentfeb + ", " + percentmar + ", " + percentapr + ", "
				+ percentmay + ", " + percentjun + ", " + percentjul + ", " + percentaug + ", " + percentsep + ", "
				+ percentoct + ", " + percentnov + ", " + percentdece ;
	}
}
