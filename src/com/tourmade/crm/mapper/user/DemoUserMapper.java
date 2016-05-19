package com.tourmade.crm.mapper.user;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoUser;

public interface DemoUserMapper extends BaseMapper {

	public List<DemoUser> queryUser(Map<String, Object> params);

	public long countUser(DemoUser user);

	public void saveUser(DemoUser user);

	public void updateUser(DemoUser user);

	public void deleteUserById(int userid);

	public DemoUser getUserById(int userid);
	
	public DemoUser signin(DemoUser user);

}
