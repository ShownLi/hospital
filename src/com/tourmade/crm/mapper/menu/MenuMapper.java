package com.tourmade.crm.mapper.menu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Menu;
import com.tourmade.crm.entity.Role;
import com.tourmade.crm.entity.RoleMixMenu;

public interface MenuMapper extends BaseMapper {

	public List<Menu> queryMenu(Map<String, Object> params);

	public long countMenu(Menu menu);

	public void saveMenu(Menu menu);
	
	public void saveRole(String name);
	
	public void saveRoleAllotMenu(Role role);

	public void updateMenu(Menu menu);
	
	public void updateRole(Role role);
	
	public void deleteRoleAllotMenu(int menuId);

	public Menu getMenuById(int menuId);
	
	public Role getRoleById(int role_id);
	
	public Role getRoleByName(String name);
	
	public List<?> checkMenuHaveRole(int menuid);
	
	public void deleteMenuById(int menuid);
	
	public void deleteRoleById(int roleid);
	
	public List<?> checkRoleHaveUser(int roleid);
	
	public List<?> getMenuIdByRoleId(int role_id);
	
	public List<Role> queryRole(Map<String, Object> params);
	
	public long countRole(Role role);
	
	public List<EntityList> getMenuCategory();
	
	public List<EntityList> getParameterInfo(String domain);
	
	public String validate(@Param("table")String table, @Param("field")String field, 
			@Param("filter_field")String filter_field, @Param("filter_name")String filter_name,
			@Param("name")String name);
}
