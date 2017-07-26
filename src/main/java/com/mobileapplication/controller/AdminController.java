package com.mobileapplication.controller;

import com.mobileapplication.domain.Contract;
import com.mobileapplication.domain.Option;
import com.mobileapplication.service.ClientService;
import com.mobileapplication.service.ContractService;
import com.mobileapplication.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class AdminController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private ContractService contractService;

    @RequestMapping(path = "/adminAccount")
    public String adminAccount(){
        return "admin/adminAccount";
    }


    @RequestMapping(path = "/adminAccount/clientList")
    public String clientList(Model model){
        model.addAttribute("clientList",clientService.clientList());
       return  "admin/partials/clientList";
    }

    @RequestMapping(path = "/adminAccount/addTariff")
    public String addTariff(Model model){
        List<Option> options =  optionService.optionList();
        model.addAttribute("options", options);
        return  "admin/partials/addTariff";
    }
    //переходим с раздел блокировки, и выбираем контакт по ID
    @RequestMapping(path = "/adminAccount/blockedContract")
    public String chooseContract(Model model){
        model.addAttribute("contracts",  contractService.contractList());
        return "admin/partials/blockedChooseContract";
    }

    @RequestMapping (path = "/adminAccount/blockedClient/{contract.id}")
    public String blockContract (Model model, Integer contractId){
        Contract currentContract = contractService.findContractById(contractId);
        model.addAttribute("currentContract", currentContract);
        return "admin/partials/blockedContract";
    }


}
