package com.mobileapplication.service;


import com.mobileapplication.domain.Tariff;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface TariffService {
    List<Tariff>tariffList();

    Tariff changeTariff(Tariff tariff);

    Tariff getTariffById(Integer id);

    Tariff addNewTariff(Tariff tariff);

    void removeTariff(Tariff tariff);

    void addOptionByTariffId(Integer tariffId, Integer optionId);
    void removeOptionByTariffId(Integer tariffId, Integer optionId);
}
