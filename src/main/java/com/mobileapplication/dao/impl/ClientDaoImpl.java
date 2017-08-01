package com.mobileapplication.dao.impl;

import com.mobileapplication.dao.ClientDao;
import com.mobileapplication.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private EntityManager entityManager;
//    private SessionFactory sessionFactory;


    public List<Client> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM Client e");
        List clients = query.getResultList();
        return (List<Client>) clients;
    }

    public Object getClientById(Integer id) {
        Query query = entityManager.createQuery("FROM Client where id = id");
        Client client = (Client) query.getSingleResult();
        return client;
    }
}
