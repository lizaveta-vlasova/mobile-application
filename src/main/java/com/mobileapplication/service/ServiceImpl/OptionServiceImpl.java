package com.mobileapplication.service.ServiceImpl;

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
    private OptionRepository optionRepository;

    @Override
    public List<Option> optionList() {
        return optionRepository.findAll();
    }

    @Override
    public Option getOptionById(Integer contractId) {
        return optionRepository.findOne(contractId);
    }
}
