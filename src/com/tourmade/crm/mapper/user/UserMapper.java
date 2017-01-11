package com.tourmade.crm.mapper.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.User;

public interface UserMapper extends BaseMapper {

	public List<User> queryUser(Map<String, Object> params);

	public long countUser(User user);

	public void saveUser(User user);

	public void updateUser(User user);

	public void deleteUserById(int userId);

	public User getUserById(int userId);
	
	public String getRoleNameByid(int userId);
	
	public User signin(User user);
	
	public List<?> permissionCheckUrl(String username);
	
	public String permissionCheckRole(String username);
	
	public List<EntityList> getParameterInfo(String domain);
	
	public List<EntityList> getUserRoles();
	
	public String validate(@Param("table")String table, @Param("field")String field, 
			@Param("filter_field")String filter_field, @Param("filter_name")String filter_name,
			@Param("name")String name);

}
