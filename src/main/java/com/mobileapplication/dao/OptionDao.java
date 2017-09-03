package com.mobileapplication.dao;


import com.mobileapplication.domain.Option;

import java.util.List;
import java.util.Set;

public interface OptionDao {
    List<Option> findAll();
    Option findOptionById(Integer id);
   // Option getOptionById(Integer contractId);
    void removeOption(Option option);
}
