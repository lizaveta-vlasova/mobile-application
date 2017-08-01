package com.mobileapplication.dao;


import com.mobileapplication.domain.Option;

import java.util.List;

public interface OptionDao {
    List<Option> findAll();
    Option getOptionById(Integer contractId);
}
