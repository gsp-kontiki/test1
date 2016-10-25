package com.lieying.user.dao.impl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lieying.user.dao.BaseDao;
import com.lieying.user.dao.UserDao;
import com.lieying.user.entity.SysUser;
import com.lieying.user.global.RequestParameterConstant;
import com.lieying.user.util.CommonUtil;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Repository(value="userDao")
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Resource(name="baseDao")	
	private BaseDao<SysUser> baseDao;

	private static final String findByUsername = 
			"from SysUser where userName=:username";
	@Override
	public SysUser findByUsername(String username) {
		Query query = this.getSession().createQuery(findByUsername);
		query.setParameter("username", username);
		@SuppressWarnings("unchecked")
		List<SysUser> userList = query.list();
		if(userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}

	 private static final String selectUserCount = "select count(a.id) from SysUser a where"
				+ " (:name is null or a.userName like :name)";
		@Override
		public Long selectUserCount(Map<String, Object> message) {
			Query query = this.getSession().createQuery(selectUserCount);
			String name = CommonUtil.emptyToNull(message.get(RequestParameterConstant.NAME));
			query.setParameter("name", CommonUtil.getLikeQueryStr(name));
			Long count = (Long)query.uniqueResult();
			if(count == null){
				return 0L;
			}
			return count;
		}


		private static final String selectUserList = "from SysUser where"
				+ " (:name is null or userName like :name) order by id desc ";
		
		@Override
		@SuppressWarnings("unchecked")
		public List<SysUser> selectUserList(Map<String, Object> message, int first, int max) {
			Query query = this.getSession().createQuery(selectUserList);
			String name = CommonUtil.emptyToNull(message.get(RequestParameterConstant.NAME));
			query.setParameter("name", CommonUtil.getLikeQueryStr(name));
			List<SysUser> userList = (List<SysUser>)query.list();
			return userList;
		}


	private static final String deleteUserByIds = "delete from SysUser where id in (:idLi)";
	@Override
	public int deleteUserByIds(List<Long> idLi) {
		Query query= this.getSession().createQuery(deleteUserByIds);
		query.setParameterList("idLi", idLi);
		return query.executeUpdate();
	}

	@Override
	public SysUser getUser(Long userId) {
		SysUser user = baseDao.findById(SysUser.class, userId);
		return user;
	}

	private static final String findByTelephone = 
			"from SysUser where telephone=:telephone";
	@Override
	public SysUser findByTelephone(String telephone) {
		Query query = this.getSession().createQuery(findByTelephone);
		query.setParameter("telephone", telephone);
		@SuppressWarnings("unchecked")
		List<SysUser> userList = query.list();
		if(userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}

	private static final String findByMail = 
			"from SysUser where email=:mail";
	@Override
	public SysUser findByMail(String mail) {
		Query query = this.getSession().createQuery(findByMail);
		query.setParameter("mail", mail);
		@SuppressWarnings("unchecked")
		List<SysUser> userList = query.list();
		if(userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}

}
