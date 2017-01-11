package com.tourmade.crm.service;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourmade.crm.common.framework.BaseService;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Menu;
import com.tourmade.crm.entity.Role;
import com.tourmade.crm.entity.RoleMixMenu;
import com.tourmade.crm.entity.User;
import com.tourmade.crm.mapper.menu.MenuMapper;
import com.tourmade.crm.mapper.user.UserMapper;

@Service
@Transactional(readOnly = false)
public class MenuService extends BaseService {

	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private UserMapper userMapper;

	/**
	 * 菜单列表，分页展示
	 * 
	 * @param menu
	 * @param ph
	 * @param request
	 */
	public QueryResult<Menu> queryMenu(Menu menu, PageHelper ph, HttpServletRequest request) {

		QueryResult<Menu> result = new QueryResult<Menu>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		String seachValue = ph.getSearch().get("value");
		
		if (null != seachValue && !"".equals(seachValue)) {
			if (null == menu) {
				menu = new Menu();
			}
			menu.setSeachValue(seachValue);
		}
			
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		List<Menu> data = menuMapper.queryMenu(map);
		long count = menuMapper.countMenu(menu);
		
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);

		return result;
	}

	/**
	 * 权限检验，根据用户登录名获取角色ID
	 * 
	 */
	public String permissionCheckRole(String username){
		String role = userMapper.permissionCheckRole(username);
		return role;
	}
	
	/**
	 * 权限检验，根据用户登录名可以访问的URL
	 * 
	 */
	public List<?> permissionCheckUrl(String username){
		List<?> urlList = userMapper.permissionCheckUrl(username);
		return urlList;
	}
	
	/**
	 * 新增菜单
	 * 
	 * @param menu
	 * @return
	 */
	public int saveMenu(Menu menu) {

		try {
			menuMapper.saveMenu(menu);
		} catch (Exception e) {
			logger.error("MenuService.saveMenu() --> " + menu + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return menu.getMenuID();
	}
	
	/**
	 * 角色分配权限界面
	 * 
	 * @param menu
	 * @return
	 */
	public int saveRoleAllotMenu(Role role) {
		
		try {
			menuMapper.saveRoleAllotMenu(role);
		} catch (Exception e) {
			logger.error("MenuService.saveRoleAllotMenu() --> " + role + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return role.getMenu_id();
	}

	/**
	 * 根据主键获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public Menu getMenuById(int menuID) {
		Menu menu = null;
		try {
			menu = menuMapper.getMenuById(menuID);
		} catch (Exception e) {
			logger.error("MenuService.getMenuById() --> " + menuID + "-->" + e.getMessage());
			menu = null;
		}
		return menu;
	}

	/**
	 * 
	 */
	public void updateMenu(Menu menu) {
		try {
			menuMapper.updateMenu(menu);
		} catch (Exception e) {
			logger.error("MenuService.updateMenu() --> " + menu + "-->" + e.getMessage());
		}

	}

	/**
	 * 删除用户（假删除）
	 * 
	 * @param userid
	 * @return
	 */
	public void deleteUserById(int userId) {
		try {
			userMapper.deleteUserById(userId);
		} catch (Exception e) {
			logger.error("UserService.deleteUserById() --> " + userId + "-->" + e.getMessage());
		}
	}

	/**
	 * 登录（验证登录名、密码）
	 * 
	 * @param user
	 * @return
	 */
	public User signin(User user) {

		User u = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] md5 = md.digest(user.getPwd().getBytes());
			
			StringBuffer md5StrBuff = new StringBuffer(); 
			
	        for (int i = 0; i < md5.length; i++) {  
	            if (Integer.toHexString(0xFF & md5[i]).length() == 1){  
	                md5StrBuff.append("0").append(  
	                        Integer.toHexString(0xFF & md5[i]));  
	            }else{  
	                md5StrBuff.append(Integer.toHexString(0xFF & md5[i]));  
	            }  
	        }
			user.setPwd(md5StrBuff.toString());
			u = userMapper.signin(user);
		} catch (Exception e) {
			logger.error("UserService.signin() --> " + user + "-->" + e.getMessage());
			u = null;
		}

		return u;
	}

	/**
	 * 验证字段是否重复
	 * 
	 * @param 
	 * @return
	 */
	public String Validate(String table, String field, String filter_field, String filter_name, String name) {
		
		String result = userMapper.validate(table, field, filter_field, filter_name, name);
		return result ;
	}
	
	/**
	 * 获取菜单所属权限
	 * @return
	 */
	public List<EntityList> getMenuCategory() {
		List<EntityList> result = menuMapper.getMenuCategory();
		return result ;
	}
	
	/**
	 * 根据作用域获得参数
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> userinfo = null;
		try {
			userinfo = userMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("CaseService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			userinfo = null;
		}
		return userinfo;
	}
	
	/**
	 * 根据角色ID获取可以访问权限界面ID
	 * @param role_id
	 * @return
	 */
	public List<?> getMenuIdByRoleId(int role_id){
		List<?> result = menuMapper.getMenuIdByRoleId(role_id);
		return result ;
	}
	
	/**
	 * 获取角色列表
	 * @return
	 */
	public QueryResult<Role> queryRole(Role role, PageHelper ph, HttpServletRequest request){
		
		QueryResult<Role> result = new QueryResult<Role>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		String seachValue = ph.getSearch().get("value");
		
		if (null != seachValue && !"".equals(seachValue)) {
			if (null == role) {
				role = new Role();
			}
			role.setSeachValue(seachValue);
		}
			
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		List<Role> data = menuMapper.queryRole(map);
		long count = menuMapper.countRole(role);
		
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
		
		return result ;
	}
	
	/**
	 * 根据主键获取角色信息
	 * 
	 * @param role_id
	 * @return
	 */
	public Role getRoleById(int role_id) {
		Role role = null;
		try {
			role = menuMapper.getRoleById(role_id);
		} catch (Exception e) {
			logger.error("RoleService.getRoleById() --> " + role_id + "-->" + e.getMessage());
			role = null;
		}
		return role;
	}
	
	/**
	 * 新增角色
	 * 
	 * @param role
	 * @return
	 */
	public void saveRole(String name) {

		try {
			menuMapper.saveRole(name);
		} catch (Exception e) {
			logger.error("MenuService.saveRole() --> " + name + "-->" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据名称获取ID
	 * 
	 * @param role
	 * @return
	 */
	public Role getRoleByName(String name) {
		Role role = null;
		try {
			role = menuMapper.getRoleByName(name);
		} catch (Exception e) {
			logger.error("MenuService.getRoleByName() --> " + name + "-->" + e.getMessage());
			e.printStackTrace();
		}
		return role;
	}
	
	/**
	 * 更新角色
	 */
	public void updateRole(Role role) {
		try {
			menuMapper.saveRoleAllotMenu(role);
		} catch (Exception e) {
			logger.error("MenuService.updateRole() --> " + role + "-->" + e.getMessage());
		}
	}
	
	/**
	 * 删除角色权限
	 */
	public void deleteRoleAllotMenu(int menuID) {
		try {
			menuMapper.deleteRoleAllotMenu(menuID);
		} catch (Exception e) {
			logger.error("MenuService.deleteMenuById() --> " + menuID + "-->" + e.getMessage());
		}
	}
	
	/**
	 * 更新角色姓名
	 */
	public void updateRoleName(Role role) {
		try {
			menuMapper.updateRole(role);
		} catch (Exception e) {
			logger.error("MenuService.updateRole() --> " + role + "-->" + e.getMessage());
		}
	}
	
	/**
	 * 判断权限是否被角色分配
	 */
	public List<?> checkMenuHaveRole(int menuid) {
		try {
			
			List<?> menulist = menuMapper.checkMenuHaveRole(menuid);
			return menulist;
		} catch (Exception e) {
			logger.error("MenuService.checkMenuHaveRole() --> " + menuid + "-->" + e.getMessage());
		}
		return null;
	}
	
	/**
	 * 删除权限即菜单表（假删除）
	 */
	public void deleteMenuById(int menuid) {
		try {
			menuMapper.deleteMenuById(menuid);
		} catch (Exception e) {
			logger.error("MenuService.deleteMenuById() --> " + menuid + "-->" + e.getMessage());
		}
	}
	
	/**
	 * 判断角色是否被用户分配
	 */
	public List<?> checkRoleHaveUser(int roleid) {
		try {
			
			List<?> rolelist = menuMapper.checkRoleHaveUser(roleid);
			return rolelist;
		} catch (Exception e) {
			logger.error("MenuService.checkRoleHaveUser() --> " + roleid + "-->" + e.getMessage());
		}
		return null;
	}
	
	/**
	 * 删除角色（假删除）
	 */
	public void deleteRoleById(int roleid) {
		try {
			menuMapper.deleteRoleById(roleid);
		} catch (Exception e) {
			logger.error("MenuService.deleteRoleById() --> " + roleid + "-->" + e.getMessage());
		}
	}
	
	public String MD5(String pwd) {
		StringBuffer md5StrBuff = new StringBuffer(); 
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5 = md.digest(pwd.getBytes());
	        for (int i = 0; i < md5.length; i++) {  
	            if (Integer.toHexString(0xFF & md5[i]).length() == 1){  
	                md5StrBuff.append("0").append(  
	                        Integer.toHexString(0xFF & md5[i]));  
	            }else{  
	                md5StrBuff.append(Integer.toHexString(0xFF & md5[i]));  
	            }  
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return md5StrBuff.toString();		
	}
}
