package com.mobileapplication.service.impl;

import com.mobileapplication.dao.ClientDao;
import com.mobileapplication.domain.Client;
import com.mobileapplication.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientDao clientDao;

    private static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);


    @Override
    public List<Client> clientList() {
        LOGGER.info("Get full client list");
        return clientDao.findAll();
    }

    @Override
    public Client getClientById (Integer id){
        LOGGER.info("Get client by ID");
        return (Client) clientDao.getClientById(id);
    }

    @Override
    public void saveClient(Client client) {
        LOGGER.info("New client add");
        //clientRepository.save(client);
         clientDao.saveClient(client);
    }



}


