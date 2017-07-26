package com.mobileapplication.service.ServiceImpl;

import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Contract;
import com.mobileapplication.repository.ClientRepository;
import com.mobileapplication.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> clientList() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById (Integer id){
        return clientRepository.findOne(id);
    }

}


