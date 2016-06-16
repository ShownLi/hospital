package com.tourmade.crm.service;

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
import com.tourmade.crm.mapper.user.DemoUserMapper;
import com.tourmade.crm.model.DemoUser;

@Service
@Transactional(readOnly = false)
public class UserService extends BaseService {

	@Autowired
	private DemoUserMapper userMapper;

	/**
	 * 查询用户数据，分页展示
	 * 
	 * @param user
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoUser> queryUser(DemoUser user, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoUser> r = new QueryResult<DemoUser>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(ph);
		
		String seachValue = ph.getSearch().get("value");
		
		if (null != seachValue && !"".equals(seachValue)) {
			if (null == user) {
				user = new DemoUser();
			}
			user.setSeachValue(seachValue);
		}
			
		
		
		map.put("pojo", user);
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoUser> data = userMapper.queryUser(map);
		long count = userMapper.countUser(user);
		
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);

		return r;
	}

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	public int saveUser(DemoUser user) {
		// user.setPwd("123456");
		// user.setPwd(MD5.MD5Encode("123456"));
		try {
			userMapper.saveUser(user);
		} catch (Exception e) {
			logger.error("UserService.saveUser() --> " + user + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return user.getUserid();
	}

	/**
	 * 根据主键获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public DemoUser getUserById(int id) {
		DemoUser r = null;
		try {
			r = userMapper.getUserById(id);
		} catch (Exception e) {
			logger.error("UserService.getUserById() --> " + id + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}

	/**
	 * 更新用户信息(不修改密码)
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(DemoUser user) {

		boolean r = false;

		try {
			DemoUser u = userMapper.getUserById(user.getUserid());
			if (u != null) {
				u.setName(user.getName());
				u.setLoginname(user.getLoginname());
				u.setEmail(user.getEmail());
				u.setMobilephone(user.getMobilephone());
				// u.setPwd(user.getPwd());
				userMapper.updateUser(u);
				r = true;
			} else {
				r = false;
			}
		} catch (Exception e) {
			logger.error("UserService.updateUser() --> " + user + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 删除用户（假删除）
	 * 
	 * @param userid
	 * @return
	 */
	public boolean deleteUserById(int userid) {

		boolean r = false;

		try {
			userMapper.deleteUserById(userid);
			r = true;
		} catch (Exception e) {
			logger.error("UserService.deleteUserById() --> " + userid + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 登录（验证登录名、密码）
	 * 
	 * @param user
	 * @return
	 */
	public DemoUser signin(DemoUser user) {

		DemoUser u = null;

		try {
			u = userMapper.signin(user);
		} catch (Exception e) {
			logger.error("UserService.sighin() --> " + user + "-->" + e.getMessage());
			u = null;
		}

		return u;
	}

}
