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



    public List<Client> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM Client e");
        List <Client> clients = query.getResultList();
        return (List<Client>) clients;
    }

    public Object getClientById(Integer id) {
        Query query = entityManager.createQuery("FROM Client where id = :id");
        query.setParameter("id", id);
        Client client = (Client) query.getSingleResult();
        return client;
    }
    public void saveClient (Client client){
        Query query = entityManager.createNativeQuery("INSERT into client (first_name, second_name, date_of_birth, passport_number, adress, email, password)" +
                "VALUES (?,?,?,?,?,?,?)");
        query.setParameter(1, client.getFirst_name());
        query.setParameter(2,client.getSecond_name());
        query.setParameter(3, client.getDate_of_birth());
        query.setParameter(4, client.getPassport_number());
        query.setParameter(5, client.getAddress());
        query.setParameter(6, client.getEmail());
        query.setParameter(7, client.getPassword());
    }
}
