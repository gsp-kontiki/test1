package com.lieying.user.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lieying.user.dao.BaseDao;
import com.lieying.user.dao.ClientDao;
import com.lieying.user.entity.Client;
import java.util.List;
import javax.annotation.Resource;

@Repository(value="clientDao")
public class ClientDaoImpl implements ClientDao {

	private SessionFactory sessionFactory;
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Resource(name="baseDao")	
	private BaseDao<Client> baseDao;

	public Client createClient( Client client) {
		return this.baseDao.save(client);
	}

	public Client updateClient(Client client) {
		return this.baseDao.update(client);
	}

	private static final String deleteClient = "delete from Client where id=:id";
	public void deleteClient(Long clientId) {
		Query query= this.getSession().createQuery(deleteClient);
		query.setParameter("id", clientId);
		query.executeUpdate();
	}

	@Override
	public Client findOne(Long clientId) {
		return this.baseDao.findById(Client.class, clientId);
	}

	private static final String findAll = " from Client";
	@Override
	public List<Client> findAll() {
		Query query= this.getSession().createQuery(findAll);
		@SuppressWarnings("unchecked")
		List<Client> clientList = query.list();
		return clientList;
	}

	private static final String findByClientId = " from Client where clientId=:clientId";
	@Override
	public Client findByClientId(String clientId) {
		Query query= this.getSession().createQuery(findByClientId);
		query.setParameter("clientId", clientId);
		@SuppressWarnings("unchecked")
		List<Client> clientList = query.list();
		if(clientList.size() == 0) {
			return null;
		}
		return clientList.get(0);
	}

	private static final String findByClientSecret = " from Client where clientSecret=:clientSecret";
	@Override
	public Client findByClientSecret(String clientSecret) {
		Query query= this.getSession().createQuery(findByClientSecret);
		query.setParameter("clientSecret", clientSecret);
		@SuppressWarnings("unchecked")
		List<Client> clientList = query.list();
		
		if(clientList.size() == 0) {
			return null;
		}
		return clientList.get(0);
	}
}
