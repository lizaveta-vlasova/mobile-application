package com.mobileapplication.service.ServiceImpl;

import com.mobileapplication.dao.OptionDao;
import com.mobileapplication.domain.Option;
import com.mobileapplication.repository.OptionRepository;
import com.mobileapplication.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Service
@Transactional
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
        //optionRepository.delete(option);
       optionDao.removeOption(option);
    }

    @Override
    public void saveOption(Option option) {
        optionRepository.save(option);
    }

    @Override
    public void removeUncompotibleOption( Integer optionId, Integer currentOptionId) {
        Option option = optionDao.findOptionById(optionId);
        Option currentOption = optionDao.findOptionById(currentOptionId);
        Set<Option> uncompatibleOptions = currentOption.getIncompatibleOptions();
        Set<Option> uncompatibleOptionsForEditOption = option.getIncompatibleOptions();
        uncompatibleOptionsForEditOption.remove(currentOption);
        uncompatibleOptions.remove(option);
        optionRepository.save(currentOption);
        optionRepository.save(option);

    }

    @Override
    public void addUncompatibleOption(Integer editOptionId, Integer optionId) {
        Option option = optionDao.findOptionById(editOptionId);
        Option currentOption = optionDao.findOptionById(optionId);
        Set<Option> uncompatibleOptions = currentOption.getIncompatibleOptions();
        Set<Option> uncompatibleOptionsForEditOption = option.getIncompatibleOptions();
        uncompatibleOptions.add(option);
        uncompatibleOptionsForEditOption.add(currentOption);
        optionRepository.save(option);
        optionRepository.save(currentOption);

    }
}
