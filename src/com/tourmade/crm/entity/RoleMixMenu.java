package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 角色关联菜单类
 * @author lxy
 *
 */
public class RoleMixMenu extends BaseBean<RoleMixMenu>{

	private static final long serialVersionUID = 8141876345433539394L;

	private Integer role_id;
	
	private Integer menu_id;

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	@Override
	public String toString() {
		return "RoleMixMenu [role_id=" + role_id + ", menu_id=" + menu_id + "]";
	}
}
