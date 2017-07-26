package com.mobileapplication.service.ServiceImpl;


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

    @Override
    public List<Tariff> tariffList() {
        return tariffRepository.findAll();
    }

    @Override
    public Tariff changeTariff(Tariff tariff){
        return  tariffRepository.save(tariff);
    }

    @Override
    public Tariff getTariffById(Integer id) {
        return tariffRepository.findOne(id);
    }

}
