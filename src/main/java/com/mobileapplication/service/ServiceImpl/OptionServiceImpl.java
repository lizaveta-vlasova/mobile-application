package com.mobileapplication.service.ServiceImpl;

import com.mobileapplication.dao.OptionDao;
import com.mobileapplication.domain.Option;
import com.mobileapplication.repository.OptionRepository;
import com.mobileapplication.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionDao optionDao;

    @Autowired
    private OptionRepository optionRepository;

    @Override
    public List<Option> optionList() {
        return  optionDao.findAll();
    }

    @Override
    public Option getOptionById(Integer contractId) {
        return optionRepository.findOne(contractId);
    }

    @Override
    public Option findOptionById(Integer optionId) {
        return optionDao.findOptionById(optionId);
    }

    @Override
    public void removeOption(Option option) {
        optionRepository.delete(option);
    }

    @Override
    public void saveOption(Option option) {
        optionRepository.save(option);
    }
}
