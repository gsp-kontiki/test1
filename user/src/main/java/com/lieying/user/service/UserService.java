package com.lieying.user.service;

import java.util.Map;

import com.lieying.user.bean.DataTable;
import com.lieying.user.bean.UserBean;
import com.lieying.user.entity.SysUser;


public interface UserService {

    /**
     * 创建用户
     * @param user
     */
    public SysUser insertUser(SysUser user);
    
    public SysUser saveUser(SysUser user) ;
    
    /**
     * 修改用户
     * @param user
     */
    public SysUser updateUser(SysUser user);

    /**
     * 删除用户
     * @param user
     */
    public void deleteUser(Long userId);

    
    /**
     * 根据ID查找用户
     * @param userId
     */
    SysUser findOne(Long userId);
    
    /**
     * 查询用户列表
     * @param message
     */
    public DataTable<SysUser> getDataTable(Map<String, Object> message) ;


    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public SysUser findByUsername(String username);

	public void saveUserBean(UserBean userBean);

	public SysUser updateUserBean(UserBean userBean);

	public String updatePassword(UserBean userBean);

	public void deleteUserByIds(Map<String, Object> message);

	public SysUser getUser(Long userId);

	public SysUser findByTelephone(String telephone);

	public SysUser findByMail(String mail);
	

}
