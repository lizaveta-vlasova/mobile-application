package com.mobileapplication.service.ServiceImpl;

import com.mobileapplication.domain.Client;
import com.mobileapplication.repository.ClientRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;
import static org.mockito.Mockito.when;


public class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        List<Client> clientList = new ArrayList<>();
        Client client = new Client();
        client.setId(1);
        clientList.add(client);

        when(this.clientRepository.findAll()).thenReturn(clientList);

    }

    @Test
    public void testClientList() throws Exception {
        List<Client> expected = new ArrayList<>();
        Client client = new Client();
        client.setId(1);
        expected.add(client);

        List<Client> actual = clientService.clientList();

        assertEquals(actual.get(0).getId(), expected.get(0).getId());
    }

    @Test
    public void testGetClientById() throws Exception {
    }

}