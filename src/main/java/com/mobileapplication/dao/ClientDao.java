package com.mobileapplication.dao;


import com.mobileapplication.domain.Client;

import java.util.List;

public interface ClientDao {
    List<Client> findAll();
    Object getClientById(Integer id);
    void saveClient(Client client);
}
