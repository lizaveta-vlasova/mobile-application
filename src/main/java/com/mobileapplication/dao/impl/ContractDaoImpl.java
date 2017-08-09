package com.mobileapplication.dao.impl;

import com.mobileapplication.dao.ContractDao;
import com.mobileapplication.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Component
public class ContractDaoImpl implements ContractDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public Contract findContractByNumber(Integer number) {
        Query query = entityManager.createQuery("from Contract where number = :number");
        query.setParameter("number", number);
        Contract contract = (Contract) query.getSingleResult();
        return contract;
    }
}
