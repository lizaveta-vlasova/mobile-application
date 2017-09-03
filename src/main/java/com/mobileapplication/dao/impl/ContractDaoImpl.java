package com.mobileapplication.dao.impl;

import com.mobileapplication.dao.ContractDao;
import com.mobileapplication.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
@EnableTransactionManagement
public class ContractDaoImpl implements ContractDao {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Contract findContractByNumber(String number) {
        Query query = entityManager.createQuery("from Contract where number = :number");
        query.setParameter("number", number);
        Contract contract = (Contract) query.getSingleResult();
        return contract;
    }

    @Override
    public void deleteContractById(Integer id) {
        /*Query query = entityManager.createNativeQuery("DELETE FROM contract WHERE id = " + id);
        query.executeUpdate();*/
        Contract contract = entityManager.find(Contract.class, id);
        if (id != 0){
            entityManager.remove(contract);
        }
    }
}
