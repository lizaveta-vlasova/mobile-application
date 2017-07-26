package com.mobileapplication.repository;

import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;

public interface OptionRepository extends JpaRepository <Option, Integer>{

}
