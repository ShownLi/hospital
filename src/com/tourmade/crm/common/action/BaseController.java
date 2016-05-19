package com.tourmade.crm.common.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class BaseController {

	protected static final int viewField = 0; // 查看
	protected static final int editField = 1; // 编辑
	protected static final int addField = 2; // 新增
	protected transient Logger logger = Logger.getLogger(getClass());
	protected int curPage = 1; // 分页当前页
	protected int pageSize = 15; // 每页15行

	public HttpServletRequest request;

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		this.setRequest(request);
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 消息提示
	 * 
	 * @param msg
	 *            提示内容
	 * @param type
	 *            提示类型：1成功，2失败
	 */
	protected void setMsg(String msg, String type) {
		request.getSession().setAttribute("message", msg);
		request.getSession().setAttribute("msgtype", type);
	}

	/**
	 * 获得当前页
	 * 
	 * @param request
	 * @return
	 * @author whz
	 */
	protected int getCurPage(HttpServletRequest request) {
		if (request.getParameter("curPage") != null && request.getParameter("curPage").trim().length() > 0) {
			curPage = Integer.valueOf(request.getParameter("curPage"));
		}
		return curPage;
	}

	/**
	 * 获得每页行数
	 * 
	 * @return
	 * @author whz
	 */
	protected int getPageSize(HttpServletRequest request) {
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.valueOf(request.getParameter("pageSize"));
		}
		return pageSize;
	}

	/**
	 * 获得起始行数
	 * 
	 * @return
	 * @author whz
	 */
	protected int getCurRow() {
		return (curPage - 1) * pageSize;
	}

	/**
	 * 传入的参数，找到对应的字典集合，然后存入model里面去
	 * 
	 * @param model
	 * @param paramList
	 * 
	 * @author 薛润佳 2013-8-26
	 */
	protected void setParamToModel(Model model, List<String> paramList) {
		if (paramList != null && paramList.size() != 0) {
			for (int i = 0; i < paramList.size(); i++) {
				String eachParam = paramList.get(i);
				// 把需要的字典集合放入model
				// model里面的Key以传入参数转换为小写的方式来存入（比如：参数为SEX，那么key就是sexs）
				if (eachParam == null || eachParam.trim().length() < 1) {
					continue;// 如果为空，继续循环
				} else {

				}
			}
		}
	}


}
