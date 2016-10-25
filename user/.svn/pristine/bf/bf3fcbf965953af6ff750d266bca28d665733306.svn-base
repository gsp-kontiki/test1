package com.lieying.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lieying.user.bean.DataTable;
import com.lieying.user.bean.UserBean;
import com.lieying.user.dao.BaseDao;
import com.lieying.user.dao.UserDao;
import com.lieying.user.entity.SysUser;
import com.lieying.user.global.RequestParameterConstant;
import com.lieying.user.service.UserService;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource(name="baseDao")	
	private BaseDao<SysUser> baseDao;

	@Resource(name="userDao")
	private UserDao userDao;

	@Resource(name="passwordHelper")
	private PasswordHelper passwordHelper;


	public SysUser insertUser(SysUser user) {
		//加密密码
		passwordHelper.encryptPassword(user);
		return baseDao.save(user);
	}

	public SysUser saveUser(SysUser user) {
		//加密密码
		passwordHelper.encryptPasswordTest(user);
		return baseDao.save(user);
	}

	@Override
	public SysUser updateUser(SysUser user) {
		return baseDao.update(user);
	}

	@Override
	public void deleteUser(Long userId) {
		SysUser user = baseDao.findById(SysUser.class, userId);
		baseDao.delete(user);
	}

	/**
	 * 修改密码
	 * @param userId
	 * @param newPassword
	 */
	public SysUser updatePassword(Long userId, String newPassword) {
		SysUser user = baseDao.findById(SysUser.class, userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		return baseDao.update(user);
	}

	/**
	 * 添加用户-角色关系
	 * @param userId
	 * @param roleIds
	 */
	public void correlationRoles(Long userId, Long... roleIds) {
		//userDao.correlationRoles(userId, roleIds);
	}


	/**
	 * 移除用户-角色关系
	 * @param userId
	 * @param roleIds
	 */
	public void uncorrelationRoles(Long userId, Long... roleIds) {
		//userDao.uncorrelationRoles(userId, roleIds);
	}

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public SysUser findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public SysUser findOne(Long userId) {
		return baseDao.findById(SysUser.class, userId);
	}

	@Override
	public DataTable<SysUser> getDataTable(Map<String, Object> message) {
		int count = userDao.selectUserCount(message).intValue();
		int page = Integer.parseInt((String)message.get("page"));
		int pageSize = Integer.parseInt((String)message.get("rows"));
		DataTable<SysUser> dataTable = new DataTable<SysUser>(page,pageSize,count);
		List<SysUser> userList = userDao.selectUserList(message,dataTable.getFirst(),dataTable.getMax());
		dataTable.setRows(userList);
		return dataTable;
	}

	@Override
	public void saveUserBean(UserBean userBean) {
		SysUser user = userBean.getUser();
		insertUser(user);
	}

	@Override
	public SysUser updateUserBean(UserBean userBean) {
		SysUser user = userBean.getUser();
		return user;
				//baseDao.update(user);

	}
	
	
	

	@Override
	public String updatePassword(UserBean userBean) {
		String result = null;
		Subject subject = SecurityUtils.getSubject();
		String userName = (String)subject.getPrincipal();
		SysUser user= userDao.findByUsername(userName);
		if(user == null) {
			result = "密码修改失败,用户不存在!";
			return result;
		}
		
		String entryPassword = passwordHelper.getPassword(user.getSalt(), user.getUserName(), userBean.getOldPassword());
		if(!entryPassword.equals(user.getPassword())){
			result = "原密码输入不正确!";
			return result;
		}
		user.setPassword(userBean.getPassword());
		passwordHelper.encryptPassword(user);
		baseDao.update(user);
		return result;
	}
	
	

	@Override
	public void deleteUserByIds(Map<String, Object> message) {
		String idList = (String)message.get(RequestParameterConstant.ID);
		if(idList != null){
			String[] idArr = idList.split(",");
			List<Long> userIdList = new ArrayList<Long>();
			for(String id:idArr){
				userIdList.add(Long.parseLong(id));
			}
			if(userIdList.size()>0){
				userDao.deleteUserByIds(userIdList);
			}
		}
	}
	@Override
	public SysUser getUser(Long userId) {
		return userDao.getUser(userId);
	}

	@Override
	public SysUser findByTelephone(String telephone) {
		return userDao.findByTelephone(telephone);
	}

	@Override
	public SysUser findByMail(String mail) {
		return userDao.findByMail(mail);
	}
	
	

}
