package com.mobileapplication.service.ServiceImpl;


import com.mobileapplication.dao.TariffDao;
import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;
import com.mobileapplication.repository.TariffRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TariffServiceImplTest {

    @Mock
    private TariffRepository tariffRepository;

    @Mock
    TariffDao tariffDao;

    @InjectMocks
    private TariffServiceImpl tariffService;

    @BeforeMethod
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);

        List<Tariff> tariffList = new ArrayList<>();
        Tariff tariff = new Tariff();
        tariff.setId(1);
        tariffList.add(tariff);
        tariffList.remove(tariff);

        when(this.tariffDao.findAll()).thenReturn(tariffList);
        when(this.tariffRepository.findOne(1)).thenReturn(tariff);
        when(this.tariffRepository.save(tariff)).thenReturn(tariff);
    }

    @Test
    public void testTariffList() throws Exception{
        List<Tariff> expected = new ArrayList<>();
        Tariff tariff = new Tariff();
        tariff.setId(1);
        expected.add(tariff);

        tariffService.tariffList();

        verify(tariffDao).findAll();

    }
    @Test
    public void testGetTariffById() throws Exception{
        Tariff expectedTariff = new Tariff();
        expectedTariff.setId(1);

        tariffService.getTariffById(expectedTariff.getId());

        verify(tariffDao).getTariffById(expectedTariff.getId());
    }

    @Test
    public void testAddNewTariff() throws Exception{
        Tariff expectedTariff = new Tariff();
        tariffService.addNewTariff(expectedTariff);
        verify(tariffRepository).save(expectedTariff);
    }

}
