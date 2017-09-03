package com.mobileapplication.dao;


import com.mobileapplication.domain.Contract;

public interface ContractDao {
 Contract findContractByNumber(String number);
 void deleteContractById(Integer id);
}
