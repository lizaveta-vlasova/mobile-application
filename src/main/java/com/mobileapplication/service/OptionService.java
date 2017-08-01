package com.mobileapplication.service;

import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Option;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OptionService {
    List<Option> optionList();
    Option getOptionById(Integer contractId);
    Option findOptionById(Integer optionId);
    void removeOption(Option option);
    void saveOption(Option option);
}
