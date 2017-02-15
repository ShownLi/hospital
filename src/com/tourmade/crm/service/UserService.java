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
import com.tourmade.crm.entity.User;
import com.tourmade.crm.mapper.user.UserMapper;

@Service
@Transactional(readOnly = false)
public class UserService extends BaseService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 查询用户数据，分页展示
	 * 
	 * @param user
	 * @param ph
	 * @param request
	 */
	public QueryResult<User> queryUser(User user, PageHelper ph, HttpServletRequest request) {

		QueryResult<User> result = new QueryResult<User>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		String seachValue = ph.getSearch().get("value");
		
		if (null != seachValue && !"".equals(seachValue)) {
			if (null == user) {
				user = new User();
			}
			user.setSeachValue(seachValue);
		}
			
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		List<User> data = userMapper.queryUser(map);
		long count = userMapper.countUser(user);
		
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
	 * 校验按钮权限名称为此的menuId
	 * 
	 */
	public String checkButtonId(String menuName){
		String buttonId = userMapper.checkButtonId(menuName);
		return buttonId;
	}
	
	/**
	 * 校验校验按钮权限是否存在
	 * 
	 */
	public String checkButtonIdExist(String menuId, String roleId){
		String IdExist = userMapper.checkButtonIdExist(menuId, roleId);
		return IdExist;
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
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	public int saveUser(User user) {

		try {
			user.setPwd(MD5(user.getPwd()));
			userMapper.saveUser(user);
		} catch (Exception e) {
			logger.error("UserService.saveUser() --> " + user + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return user.getUserId();
	}

	/**
	 * 根据主键获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(int userId) {
		User user = null;
		try {
			user = userMapper.getUserById(userId);
		} catch (Exception e) {
			logger.error("UserService.getUserById() --> " + userId + "-->" + e.getMessage());
			user = null;
		}
		return user;
	}

	/**
	 * 更新用户信息(不修改密码)
	 * 
	 * @param user
	 * @return  把userMapper改成了动态SQL  zyy 10-19
	 */
	public void updateUser(User user) {
		try {
//			User oldUser = userMapper.getUserById(user.getUserId());
			if(null !=user.getPwd() && !"".equals(user.getPwd())){
				user.setPwd(MD5(user.getPwd()));
				userMapper.updateUser(user);
			}else{
				userMapper.updateUser(user);
			}

		} catch (Exception e) {
			logger.error("UserService.updateUser() --> " + user + "-->" + e.getMessage());
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
	 * 根据客人id获取角色名称
	 */
	public String getRoleNameById(int userId) {
		String result = userMapper.getRoleNameById(userId);
		return result ;
	}
	
	/**
	 * 获取角色权限列表
	 * @return
	 */
	public List<EntityList> getUserRoles() {
		
		List<EntityList> result = userMapper.getUserRoles();
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
