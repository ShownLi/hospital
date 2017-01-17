package com.tourmade.crm.common.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tourmade.crm.common.Constants;
import com.tourmade.crm.entity.User;

/**
 * 权限拦截器
 * 
 * @author 刘杰
 * 
 */
@Controller
public class SecurityInterceptor implements HandlerInterceptor {

	protected Logger logger = Logger.getLogger(getClass());

	private List<String> excludeUrls;// 不需要拦截的资源

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 完成页面的render后调用
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {

	}

	/**
	 * 在调用controller具体方法后拦截
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在调用controller具体方法前拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		HttpSession session = ((HttpServletRequest) request).getSession();
		String url = requestUri.substring(contextPath.length());

		logger.debug("---->> your location is:  " + url);
		// 如果要访问的资源是不需要验证的
		if (url.indexOf("/assets/") > -1) {
			return true;
		}

		// 不验证排除列表的url
		if (this.excludeUrls.contains(url)) {
			return true;
		}

		User userInfo = (User) request.getSession().getAttribute(Constants.LOGIN_KEY);

		if (userInfo == null) {
			response.sendRedirect(contextPath + "/signin.html");
			return false;
		}
		else{
			if(!((List<String>) session.getAttribute("url")).contains(requestUri)){
				
				if(request.getRequestURI().equals("/TmCRM/signin.html") || 
						request.getRequestURI().equals("/TmCRM//main.html") || 
						request.getRequestURI().equals("/TmCRM/signout.html") ||
						request.getRequestURI().equals("/TmCRM/notfound.html")){
					return true;
				}else{
					response.sendRedirect(contextPath + "/notfound.html");
					return false;
				}

			}
			else{
				return true;
			}
		}
//		return true;
	}
}
