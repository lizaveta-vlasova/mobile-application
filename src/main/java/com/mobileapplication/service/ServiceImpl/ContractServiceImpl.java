package com.mobileapplication.service.ServiceImpl;

import com.mobileapplication.dao.ClientDao;
import com.mobileapplication.dao.ContractDao;
import com.mobileapplication.domain.Contract;
import com.mobileapplication.domain.Option;
import com.mobileapplication.repository.ContractRepository;
import com.mobileapplication.repository.OptionRepository;
import com.mobileapplication.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Override
    public List<Contract> contractList() {
        return contractRepository.findAll();
    }

    @Override
    public List<Contract> findContractsByClient_Id(Integer idClient) {
        return contractRepository.findContractsByClient_Id(idClient);
    }

    public Contract findContractById(Integer id) {
        
        return contractRepository.findOne(id);
    }

    @Override
    public Contract updateContract(Contract contract){
        return contractRepository.save(contract);
    }

    @Override
    public void addOptionByContractId(Integer optionId, Integer contractId) {
        Contract contract = contractRepository.findOne(contractId);
        Option option = optionRepository.findOne(optionId);
        contract.getOptions().add(option);
        contractRepository.save(contract);
    }

    @Override
    public void removeOptionByContractId(Integer optionId, Integer contractId) {
        Contract contract = contractRepository.findOne(contractId);
        Option option = optionRepository.findOne(optionId);
        contract.getOptions().remove(option);
        contractRepository.save(contract);
    }
    @Override
    public void userBlocked (Contract contract){
        contract.setIsBlockedByUser(1);
        contractRepository.save(contract);
    }
    public void userUnblocked(Contract contract){
        contract.setIsBlockedByUser(0);
        contractRepository.save(contract);
    }
    public boolean isContractBlocked (Integer contractId){
        Contract contract = contractRepository.findOne(contractId);
        if (contract.getIsBlockedByUser() > 0 || contract.getIsBlockedByAdmin() > 0) return true;
        else return false;
    }

    @Override
    public void userBlockedByAdmin(Contract contract) {
        contract.setIsBlockedByAdmin(1);
        contractRepository.save(contract);
    }

    @Override
    public void userUnblockedByAdmin(Contract contract) {
        contract.setIsBlockedByAdmin(0);
        contractRepository.save(contract);
    }

    @Override
    public Contract saveContract(Contract contract) {
        contractRepository.save(contract);
        return contract;
    }

    @Override
    public Contract findContractByNumber(String number) {
        return  contractDao.findContractByNumber(number);
    }

    @Override
    public void removeContract(Integer contractId) {
       Contract contract = contractRepository.findOne(contractId);
       //contractRepository.delete(contract);
        contractDao.deleteContractById(contractId);
    }

}
