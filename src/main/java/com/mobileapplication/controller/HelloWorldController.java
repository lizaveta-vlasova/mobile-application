package com.mobileapplication.controller;

import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Tariff;
import com.mobileapplication.service.ClientService;
import com.mobileapplication.service.ContractService;
import com.mobileapplication.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    ClientService clientService;

    @Autowired
    TariffService tariffService;

    @Autowired
    ContractService contractService;

   /* @RequestMapping(value = "/hello/client", method = RequestMethod.GET)
    public List<Client> getClientList(Client client){
         clientService.clientList();
         return "HelloWorldPage";
    }*/
   @RequestMapping(value = "/client", method = RequestMethod.GET)
   public String getClientList(Model model){
        model.addAttribute("client", new Client());
        model.addAttribute("clientList", clientService.clientList());
        return "Client";
   }

   /*@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
   public String getClientById(Model model, Integer id){
       model.addAttribute("client", clientService.getClientById(id));
       return "Client";
   }*/

   @RequestMapping(value = "/tariff", method = RequestMethod.GET)
   public String getTariffList(Model model){
       model.addAttribute("tariff", new Tariff());
       model.addAttribute("tariffList", tariffService.tariffList());
       return "Tariff";
   }



    /*@RequestMapping(path = "/helloWorld", method = RequestMethod.GET)
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "index";
    }*/

    //что в данном случае должно быть в requestmapping, ведь пароль и логин мы вводим на странице hello world
    //а возвращать должны аккаунт






}
