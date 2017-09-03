package com.mobileapplication.service.ServiceImpl;


import com.mobileapplication.dao.OptionDao;
import com.mobileapplication.dao.TariffDao;
import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;
import com.mobileapplication.mq.Sender;
import com.mobileapplication.repository.TariffRepository;
import com.mobileapplication.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TariffServiceImpl implements TariffService {

    @Autowired
    private TariffRepository tariffRepository;

    @Autowired
    private OptionDao optionDao;

    @Autowired
    private TariffDao tariffDao;

    @Autowired
    private Sender sender;

    @Override
    public List<Tariff> tariffList() {
        return tariffDao.findAll();
    }

    @Override
    public Tariff changeTariff(Tariff tariff) {
        return tariffRepository.save(tariff);
    }


    @Override
    public Tariff getTariffById(Integer id) {
        return tariffDao.getTariffById(id);
    }

    @Override
    public Tariff addNewTariff(Tariff tariff) {
        tariffRepository.save(tariff);
        try {
            sender.send();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return tariff;
    }


    @Override
    public void removeTariff(Tariff tariff) {
        tariffRepository.delete(tariff);
        try {
            sender.send();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOptionByTariffId(Integer tariffId, Integer optionId) {
        Tariff tariff = tariffRepository.findOne(tariffId);
        Option option = optionDao.findOptionById(optionId);
        Set<Option> uncompatibleOptions = option.getIncompatibleOptions();
        Set<Option> availableOptions = tariff.getAvailableOptions();
        tariff.getAvailableOptions().add(option);
        tariffRepository.save(tariff);
        try {
            sender.send();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeOptionByTariffId(Integer tariffId, Integer optionId) {
        Tariff tariff = tariffRepository.findOne(tariffId);
        Option option = optionDao.findOptionById(optionId);
        tariff.getAvailableOptions().remove(option);
        tariffRepository.save(tariff);
        try {
            sender.send();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }}

    @Override
    public boolean isOptionsCompatible(Set<Option>uncompatibleOption, Set<Option> optionSet) {
        if (uncompatibleOption.stream().anyMatch(optionSet::contains)){return true;}
        else return false;
    }
}

