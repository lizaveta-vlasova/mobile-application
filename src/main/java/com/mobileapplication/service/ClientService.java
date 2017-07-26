package com.mobileapplication.service;

import com.mobileapplication.domain.Client;

import java.util.List;

public interface ClientService {
     List<Client>clientList();

     Client getClientById(Integer id);
}
