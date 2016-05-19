package com.tourmade.crm.common.framework.exception;

import javax.servlet.http.HttpSession;

public class AlreadyOnLineException extends Exception{
	private String operCode;
	private HttpSession session;
	private  boolean existSameUserSession;
	
	public AlreadyOnLineException(String operCode, HttpSession session){
		super("[user:"+operCode+"] already Login!");
		this.session = session;
		existSameUserSession = false;
	}
	
	public AlreadyOnLineException(String operCode, HttpSession session, boolean existSameUserSession){
		this(operCode, session);
		this.existSameUserSession = existSameUserSession;
	}

	public String getOperCode() {
		return operCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public boolean isExistSameUserSession() {
		return existSameUserSession;
	}

	public void setExistSameUserSession(boolean existSameUserSession) {
		this.existSameUserSession = existSameUserSession;
	}
}
