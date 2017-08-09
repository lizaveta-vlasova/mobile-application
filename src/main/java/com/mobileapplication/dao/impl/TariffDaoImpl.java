package com.mobileapplication.dao.impl;


import com.mobileapplication.dao.TariffDao;
import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class TariffDaoImpl implements TariffDao {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Tariff> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM Tariff e");
        List tariff = query.getResultList();
        return (List<Tariff>) tariff;
    }
    @Override
    public Tariff getTariffById(Integer id) {
        Query query = entityManager.createQuery(" FROM Tariff e WHERE e.id= :id");
        query.setParameter("id", id);
        Tariff tariff = (Tariff) query.getSingleResult();
        return tariff;

    }

}
