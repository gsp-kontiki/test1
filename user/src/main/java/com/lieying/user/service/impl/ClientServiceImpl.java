package com.lieying.user.service.impl;

import com.lieying.user.dao.ClientDao;
import com.lieying.user.entity.Client;
import com.lieying.user.service.ClientService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.annotation.Resource;

@Transactional
@Service(value="clientService")
public class ClientServiceImpl implements ClientService {
	
	 @Resource(name="clientDao")
    private ClientDao clientDao;

    @Override
    public Client createClient(Client client) {
        return clientDao.createClient(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientDao.updateClient(client);
    }

    @Override
    public void deleteClient(Long clientId) {
        clientDao.deleteClient(clientId);
    }

    @Override
    public Client findOne(Long clientId) {
        return clientDao.findOne(clientId);
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Client findByClientId(String clientId) {
        return clientDao.findByClientId(clientId);
    }

    @Override
    public Client findByClientSecret(String clientSecret) {
        return clientDao.findByClientSecret(clientSecret);
    }
}
