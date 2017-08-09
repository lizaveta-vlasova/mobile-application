package com.mobileapplication.service.ServiceImpl;


import com.mobileapplication.dao.OptionDao;
import com.mobileapplication.dao.TariffDao;
import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;
import com.mobileapplication.repository.TariffRepository;
import com.mobileapplication.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {

    @Autowired
    private TariffRepository tariffRepository;

    @Autowired
    private OptionDao optionDao;

    @Autowired
    private TariffDao tariffDao;

    @Override
    public List<Tariff> tariffList() {
        return tariffDao.findAll();
    }

    @Override
    public Tariff changeTariff(Tariff tariff){
        return  tariffRepository.save(tariff);
    }

    @Override
    public Tariff getTariffById(Integer id) {
        return  tariffDao.getTariffById(id);
    }

    @Override
    public Tariff addNewTariff(Tariff tariff) {
        return tariffRepository.save(tariff);
    }

    @Override
    public void removeTariff(Tariff tariff) {
     tariffRepository.delete(tariff);
    }

    @Override
    public void addOptionByTariffId(Integer tariffId, Integer optionId) {
        Tariff tariff = tariffRepository.findOne(tariffId);
        Option option = optionDao.findOptionById(optionId);
        tariff.getAvailableOptions().add(option);
        tariffRepository.save(tariff);
    }

    @Override
    public void removeOptionByTariffId(Integer tariffId, Integer optionId) {
        Tariff tariff = tariffRepository.findOne(tariffId);
        Option option = optionDao.findOptionById(optionId);
        tariff.getAvailableOptions().remove(option);
        tariffRepository.save(tariff);
    }

}
