package com.mobileapplication.dao;


import com.mobileapplication.domain.Contract;

public interface ContractDao {
 Contract findContractByNumber(Integer number);
}
