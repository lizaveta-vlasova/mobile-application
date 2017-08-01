package com.mobileapplication.repository;


import com.mobileapplication.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Integer>{
        List<Contract> findContractsByClient_Id(Integer idClient);
        Contract findContractsByNumber(Integer number);
}
