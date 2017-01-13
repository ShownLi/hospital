package com.tourmade.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.xerces.internal.xinclude.MultipleScopeNamespaceSupport;
import com.tourmade.crm.common.action.BaseSimpleFormController;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.framework.util.JSONUtilS;
import com.tourmade.crm.common.model.base.value.baseconfig.Json;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Menu;
import com.tourmade.crm.entity.Role;
import com.tourmade.crm.entity.RoleMixMenu;
import com.tourmade.crm.entity.User;
import com.tourmade.crm.service.MenuService;
import com.tourmade.crm.service.UserService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseSimpleFormController {

	@Autowired
	private UserService service;
	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/allot.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String allot(Model model) {
		List<EntityList> roleList = service.getUserRoles();
		JSONArray roleResult = JSONArray.fromObject(roleList);
		model.addAttribute("roleResult", roleResult);
		return "/menu/allot";
	}
	
	//权限列表
	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		return "/menu/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, Menu menu, PageHelper page) {
		QueryResult<Menu> pageResult = menuService.queryMenu(menu, page, request);
		String result = JSONUtilS.object2json(pageResult);
		return result;
	}
	
	//角色列表
	@RequestMapping(value = "/rolelist.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String roleList(Model model) {
		return "/menu/rolelist";
	}
	
	@RequestMapping(value = "/rolelist.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryRole(HttpServletRequest request, HttpSession session, Model model, Role role, PageHelper page) {
		QueryResult<Role> pageResult = menuService.queryRole(role, page, request);
		String result = JSONUtilS.object2json(pageResult);
		return result;
	}
	
	//添加角色界面
	@RequestMapping(value = "/addrole.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String addRole(HttpSession session, Model model, String id, Menu menu, HttpServletRequest request, PageHelper page) {
		
		//根据用户角色id获取所分配权限页面信息
		String roleId = (String) session.getAttribute("roleID");
		QueryResult<Menu> menuMessageList = menuService.getMenuMessage(Integer.parseInt(roleId),menu, page, request);
		JSONArray menuMessageResult = JSONArray.fromObject(menuMessageList);
		model.addAttribute("menuMessage", menuMessageResult);
		
		return "/menu/addrole";
	}
	
	//添加角色后给角色分配权限
	@RequestMapping(value = "/addrole.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public Json addRole(HttpServletRequest request, HttpSession session, Model model, String f, Role role, PageHelper page) {
		Json json = new Json();	
		Role role1 = new Role();
		
		try {
			String[] menuStr = f.split(",");
			
			for(int i=0; i<menuStr.length; i++){
				String[] rmenuStr = menuStr[i].split(" ");
				role1.setRole_id(Integer.parseInt(rmenuStr[0])); 
				role1.setMenu_id(Integer.parseInt(rmenuStr[1]));
				menuService.saveRoleAllotMenu(role1);
			}
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("MenuController.addRole() --> " + f + "\n" + e.getMessage());
		}
		return json;
	}
	
	//仅添加角色
	@RequestMapping(value = "/addroleonly.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public Role addRoleOnly(HttpServletRequest request, HttpSession session, Model model, String name, Role role, PageHelper page) {
		String roleID = null;
		Role role2 = new Role();
		try {
			menuService.saveRole(name);
			role2 = menuService.getRoleByName(name);
			roleID = role2.getRole_id().toString();
			model.addAttribute("roleID",roleID);
		} catch (Exception e) {
			logger.error("MenuController.addRoleOnly() --> " + name + "\n" + e.getMessage());
		}
		return role2;
	}
	
	//角色编辑界面
	@RequestMapping(value = "/roleedit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String roleEdit(Model model, String id) {
		if (null != id && !"".equals(id)) {
			int role_id = Integer.parseInt(id);
			Role role = menuService.getRoleById(role_id);
			model.addAttribute("role",role);
			
			//根据角色获取已分配权限
			List<?> menu = menuService.getMenuIdByRoleId(role.getRole_id());
			model.addAttribute("menuList",menu);
		}	
		
		return "/menu/roleedit";
	}
	
	//编辑角色，给角色分配权限
	@RequestMapping(value = "/roleedit.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public Json doAllot(HttpServletRequest request, HttpSession session, Model model, String f, PageHelper page) {
		Json json = new Json();	
		Role role = new Role();
		try {
			String[] menuStr = f.split(",");
			String roleid = menuStr[0].split(" ")[0];
			
			if(("").equals(roleid)||roleid!=null){
				menuService.deleteRoleAllotMenu(Integer.parseInt(roleid));
				
				for(int i=0; i<menuStr.length; i++){
					String[] rmenuStr = menuStr[i].split(" ");
					role.setRole_id(Integer.parseInt(rmenuStr[0])); 
					role.setMenu_id(Integer.parseInt(rmenuStr[1]));
					String roleName = rmenuStr[2]; 
					role.setRole_name(roleName);
					menuService.saveRoleAllotMenu(role);
					menuService.updateRoleName(role);
				}
				json.setSuccess(true);
			}else{
				for(int i=0; i<menuStr.length; i++){
					String[] rmenuStr = menuStr[i].split(" ");
					role.setRole_id(Integer.parseInt(rmenuStr[0])); 
					role.setMenu_id(Integer.parseInt(rmenuStr[1]));
					String roleName = rmenuStr[2]; 
					role.setRole_name(roleName);
					menuService.saveRoleAllotMenu(role);
					menuService.updateRoleName(role);
				}
				json.setSuccess(true);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("MenuController.doAllot() --> " + f + "\n" + e.getMessage());
		}
		return json;
	}
	
	//添加权限界面
	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		List<EntityList> menuCategoryList = menuService.getMenuCategory();
		JSONArray menuCategoryResult = JSONArray.fromObject(menuCategoryList);
		model.addAttribute("menuCategory", menuCategoryResult);
		return "/menu/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Menu menu) {

		Json json = new Json();		
		try {
			menuService.saveMenu(menu);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("MenuController.doAdd() --> " + menu.toString() + "\n" + e.getMessage());
		}
		return json;
	}

	//权限编辑界面
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		List<EntityList> roleList = service.getUserRoles();
		List<EntityList> menuCategoryList = menuService.getMenuCategory();
		JSONArray roleResult = JSONArray.fromObject(roleList);
		JSONArray menuCategoryResult = JSONArray.fromObject(menuCategoryList);
		model.addAttribute("role_id", roleResult);
		model.addAttribute("menuCategory", menuCategoryResult);
		
		if (null != id && !"".equals(id)) {
			int menuId = Integer.parseInt(id);
			Menu menu = menuService.getMenuById(menuId);
			model.addAttribute("menu",menu);
		}	
		
		return "/menu/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, Menu menu) {

		Json json = new Json();
		
		try {
			menuService.updateMenu(menu);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("MenuController.doEdit() --> " + menu.toString() + "\n" + e.getMessage());
		}
		
		return json;
	}
	
	//校验权限是否已经分配角色
	@RequestMapping(value = "/checkDel.do")
	@ResponseBody
	public Json doCheckDel(HttpServletRequest request, HttpSession session, Model model, String id) {
		
		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int menuid = Integer.parseInt(id);
				List<?> menu = menuService.checkMenuHaveRole(menuid);
				if(menu.size()!=0){
					json.setSuccess(true);
				}else{
					json.setSuccess(false);
				}
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("MenuController.doCheckDel() --> " + id + "\n" + e.getMessage());
		}		
		return json;
	}
	
	//删除权限即菜单表
	@RequestMapping(value = "/delmenu.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id) {

		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int menuid = Integer.parseInt(id);
				menuService.deleteMenuById(menuid);
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("MenuController.doDel() --> " + id + "\n" + e.getMessage());
		}		
		return json;
	}
	
	@RequestMapping(value = "/delrole.do")
	@ResponseBody
	public Json delRole(HttpServletRequest request, HttpSession session, Model model, String id) {
		
		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int roleid = Integer.parseInt(id);
				menuService.deleteRoleById(roleid);
				menuService.deleteRoleAllotMenu(roleid);
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("MenuController.delRole() --> " + id + "\n" + e.getMessage());
		}		
		return json;
	}
	
	//校验角色是否被用户分配
	@RequestMapping(value = "/checkdelrole.do")
	@ResponseBody
	public Json checkDelRole(HttpServletRequest request, HttpSession session, Model model, String id) {
		
		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int roleid = Integer.parseInt(id);
				List<?> role = menuService.checkRoleHaveUser(roleid);
				if(!role.contains(null)){
					json.setSuccess(true);
				}else{
					json.setSuccess(false);
				}
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("MenuController.checkDelRole() --> " + id + "\n" + e.getMessage());
		}		
		return json;
	}
}
