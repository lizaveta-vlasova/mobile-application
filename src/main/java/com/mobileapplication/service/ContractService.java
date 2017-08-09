package com.mobileapplication.service;

import com.mobileapplication.domain.Contract;

import java.util.List;


public interface ContractService {
    List<Contract> contractList();

    List<Contract> findContractsByClient_Id(Integer idClient);

    Contract findContractById(Integer id);
    
    Contract updateContract(Contract contract);

    void addOptionByContractId(Integer optionId, Integer contractId);
    void removeOptionByContractId(Integer optionId, Integer contractId);
    void userBlocked (Contract contract);
    void userUnblocked(Contract contract);
    boolean isContractBlocked (Integer contractId);
    void userBlockedByAdmin(Contract contract);
    void userUnblockedByAdmin(Contract contract);
    Contract saveContract(Contract contract);

    Contract findContractByNumber(Integer number);
}

