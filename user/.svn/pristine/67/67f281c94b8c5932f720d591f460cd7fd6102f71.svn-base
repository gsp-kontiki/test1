package com.lieying.user.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.lieying.user.dao.BaseDao;

@Repository(value="baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
	
private static final Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public T save(T t) {
		if(t != null) {
			this.getSession().save(t);
		}
		return t;
	}

	@Override
	public T update(T t) {
		if(t != null) {
			this.getSession().update(t);
			logger.info("update success");
			return t;
		}
		return null;
	}

	@Override
	public void delete(T t) {
		if(t != null) {
			this.getSession().delete(t);
		}
	}

	@Override
	public T findById(Class<T> c, Serializable id) {
		 return this.getSession().get(c, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String hql) {
		Query query = this.getSession().createQuery(hql);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String hql, int first, int max) {
		Query query = this.getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}

	@Override
	public Long count(String hql) {
		Query query = this.getSession().createQuery(hql);
		Long count = (Long)query.uniqueResult();
		if(count == null) {
			return 0L;
		}
		return count;
	}

	

	@Override
	public int executeUpdate(String sql) {
		Query query = this.getSession().createSQLQuery(sql);
		int count = query.executeUpdate();
		getSession().clear();
		return count;
	}
	

}
