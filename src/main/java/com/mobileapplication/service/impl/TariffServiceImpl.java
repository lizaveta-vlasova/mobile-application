package com.mobileapplication.service.impl;


import com.mobileapplication.dao.OptionDao;
import com.mobileapplication.dao.TariffDao;
import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;
import com.mobileapplication.mq.Sender;
import com.mobileapplication.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.naming.NamingException;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class TariffServiceImpl implements TariffService {


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
    public void changeTariff(Tariff tariff) {
        tariffDao.update(tariff);
        try {
            sender.send();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }


    @Override
    public Tariff getTariffById(Integer id) {
        return tariffDao.getTariffById(id);
    }

    @Override
    public Tariff addNewTariff(Tariff tariff) {
        tariffDao.save(tariff);
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
        tariffDao.delete(tariff);
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
        Tariff tariff = tariffDao.getTariffById(tariffId);
        Option option = optionDao.findOptionById(optionId);
       /* Set<Option> uncompatibleOptions = option.getIncompatibleOptions();
        Set<Option> availableOptions = tariff.getAvailableOptions();*/
        tariff.getAvailableOptions().add(option);
        tariffDao.save(tariff);
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
        Tariff tariff = tariffDao.getTariffById(tariffId);
        Option option = optionDao.findOptionById(optionId);
        tariff.getAvailableOptions().remove(option);
        tariffDao.save(tariff);
        try {
            sender.send();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isOptionsCompatible(Set<Option> uncompatibleOption, Set<Option> optionSet) {
        if (uncompatibleOption.stream().anyMatch(optionSet::contains)) {
            return true;
        } else return false;
    }
}

