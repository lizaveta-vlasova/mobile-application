package com.mobileapplication.dao;


import com.mobileapplication.domain.Tariff;

import java.util.List;

public interface TariffDao {

    List<Tariff> findAll();
    Tariff getTariffById(Integer id);
}
