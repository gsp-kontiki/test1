package com.lieying.user.dao;

import java.util.List;
import java.util.Map;

import com.lieying.user.entity.SysUser;

public interface UserDao {

	public SysUser findByUsername(String username);

	public Long selectUserCount(Map<String, Object> message);

	public List<SysUser> selectUserList(Map<String, Object> message, int first, int max);
	
	public int deleteUserByIds(List<Long> idLi);

	public SysUser getUser(Long userId);

	public SysUser findByTelephone(String telephone);

	public SysUser findByMail(String mail);
	
}
