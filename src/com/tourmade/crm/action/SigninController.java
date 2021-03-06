package com.tourmade.crm.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmade.crm.common.Constants;
import com.tourmade.crm.common.action.BaseSimpleFormController;
import com.tourmade.crm.common.model.base.value.baseconfig.Json;
import com.tourmade.crm.entity.User;
import com.tourmade.crm.service.UserService;

@Controller
@RequestMapping("/")
public class SigninController extends BaseSimpleFormController {

	@Autowired
	private UserService service;

	/**
	 * 用户登录（进入登录界面）
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/signin.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String signin(Model model) {
		return "/signin";
	}
	
	/**
	 * 跳转404页面
	 */
	@RequestMapping(value = "/notfound.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String notFonud(Model model) {
		return "/notfound";
	}

	/**
	 * 用户登出
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/signout.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String loginout(HttpSession session, HttpServletRequest request) {
		if (session != null) {
			session.invalidate();
		}

		return "redirect:/signin.html";
	}

	/**
	 * 执行登录操作
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/signin.do")
	@ResponseBody
	public Json dosignin(HttpServletRequest request, HttpSession session, Model model, User user) {
		Json json = new Json();
		if (user.getLoginName() == null || user.getPwd() == null || user.getLoginName().trim().length() < 1
				|| user.getPwd().trim().length() < 1) {
			json.setMsg("用户名或密码为空");
		} else {
			User realUser = service.signin(user);
			if (null != realUser) {
				 
				//将登录者的权限ID和可以访问的URl放在session中
				String roleID = service.permissionCheckRole(realUser.getLoginName());
				String menuId = service.checkButtonId("修改跟单员权限");
				String menuName = service.checkButtonIdExist(menuId,roleID);
				if(!("").equals(menuName) || menuName != null){
					session.setAttribute("buttonId1", menuName);
				}
				
				List<?> url = service.permissionCheckUrl(realUser.getLoginName());
				session.setAttribute("roleID", roleID);
				session.setAttribute("url", url);
				
				json.setSuccess(true);
				json.setMsg("登录成功");
				
				request.getSession().setAttribute(Constants.LOGIN_KEY, realUser);
			} else {
				json.setMsg("用户名或密码错误");
			}
		}
		return json;
	}
}
