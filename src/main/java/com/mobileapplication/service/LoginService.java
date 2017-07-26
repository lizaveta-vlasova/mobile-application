package com.mobileapplication.service;


import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Contract;
import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;
import com.mobileapplication.repository.ClientRepository;
import com.mobileapplication.repository.ContractRepository;
import com.mobileapplication.repository.OptionRepository;
import com.sun.org.apache.bcel.internal.generic.InstructionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    OptionRepository optionRepository;

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    ClientRepository clientRepository;

    Client currentClient;

    Contract currentContract;

    public Client login(Integer id) {
        currentClient = clientRepository.findOne(id);
        return currentClient;
    }

    public Contract contractLogin(Integer idClient) {
        Contract currentContract = contractRepository.findOne(idClient);
        return currentContract;
    }

    public Option optionLogin(Integer idClient) {
        Option currentoption = optionRepository.findOne(idClient);
        return currentoption;
    }

    public Client getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
    }

    // метод должке находить тариф по действующему контракту
    public Contract tariffLoginContract(Integer id){
        Contract currentContract = contractRepository.findOne(id);
        return currentContract;
    }


    public Contract getCurrentContract() {
        return currentContract;
    }

    public void setCurrentContract(Contract currentContract) {
        this.currentContract = currentContract;
    }


}
