package com.mobileapplication.dao.impl;


import com.mobileapplication.dao.OptionDao;
import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class OptionDaoImpl implements OptionDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Option> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM Option e");
        List optionList = query.getResultList();
        return (List<Option>) optionList;
    }

    @Override
    public Option findOptionById(Integer id) {
        Query query = entityManager.createQuery(" FROM Option e WHERE e.optionId= :id");
        query.setParameter("id", id);
        Option option = (Option) query.getSingleResult();
        return option;

    }



}
