package com.tourmade.crm.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("rootPath", this.getRootPath(request));
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

	/**
	 * 获取rootPath
	 * 
	 * @return
	 */
	protected String getRootPath(ServletRequest request) {
		HttpServletRequest r = (HttpServletRequest) request;
		String path = r.getContextPath();
		String basePath = r.getScheme() + "://" + r.getServerName() + ":" + r.getServerPort() + path + "/";
		return basePath;
	}

}
