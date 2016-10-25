package com.lieying.user.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	
	public T save(T t) ;
	
	public T update(T t);
	
	public void delete(T t);
	
	public T findById(Class<T> c, Serializable id);
	
	public List<T> list(String hql);
	
	public List<T> list(String hql,int first, int max);
	
	public Long count(String hql);
	
	public int executeUpdate(String sql);

}
