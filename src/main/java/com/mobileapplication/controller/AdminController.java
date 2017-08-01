package com.mobileapplication.controller;

import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Contract;
import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;
import com.mobileapplication.service.ClientService;
import com.mobileapplication.service.ContractService;
import com.mobileapplication.service.OptionService;
import com.mobileapplication.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller

public class AdminController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private TariffService tariffService;

    @RequestMapping(path = "/adminAccount")
    public String adminAccount(){
        return "admin/adminAccount";
    }


    @RequestMapping(path = "/adminAccount/clientList")
    public String clientList(Model model){
        model.addAttribute("clientList",clientService.clientList());
       return  "admin/partials/clientList";
    }

    //страница на которой мы можем добавить тариф
    @RequestMapping(path = "/adminAccount/addTariff")
    public String pageToAddTariff(Model model){
        List<Option> options =  optionService.optionList();
        model.addAttribute("options", options);
        return  "admin/partials/addTariff";
    }

    //добавляем тариф
    @RequestMapping(path = "/adminAccount/addTariff/add" , method = RequestMethod.POST)
    public String addNewTariff(Model model,@ModelAttribute ("tariff") Tariff tariff){
        tariffService.addNewTariff(tariff);
        Integer tariffId = tariff.getId();
        model.addAttribute("tariff", tariffService.getTariffById(tariffId));
        return  "redirect:/adminAccount/addTariff" + tariffId;
    }




//переходим на страницу со списком всех опций
    @RequestMapping(path = "/adminAccount/optionList")
    public String getPageToEditOptions(Model model){
        List<Option> optionList = optionService.optionList();
        model.addAttribute("optionsList", optionList );
        return "admin/partials/optionList";
    }
//удаляем опции
    @RequestMapping(path = "/adminAccount/optionList/{optionId}/remove", method = RequestMethod.GET)
    public String removeOption(@PathVariable ("optionId") Integer optionId){
        Option currentOption = optionService.findOptionById(optionId);
        optionService.removeOption(currentOption);
        return "redirect:/adminAccount/optionList";
    }
    //добавляе опции
    @RequestMapping(path = "/adminAccount/optionList/add", method = RequestMethod.GET)
    public String addOption(@ModelAttribute ("option") Option option){
        optionService.saveOption(option);
        return "redirect:/adminAccount/optionList";
    }

    //идем на страницу поиска контракта по номеру
    @RequestMapping(path = "/adminAccount/findContractPage")
    public String getToFindContractPage(){

        return "admin/partials/findContractPage";
    }

    //ищем контракт по номеру
    @RequestMapping(path = "/adminAccount/findContractPage{number}")
    public String findContract (Model model, Integer number){
        Contract currentContract = contractService.findContractByNumber(number);
        model.addAttribute("currectContract", currentContract);
        return "admin/partials/getFoundContract";
    }


    //на странице контракта блокируем его
    @RequestMapping(path = "/adminAccount/findContractPage/{contractId}/block")
    public String blockContract(Model model, @PathVariable("contractId") Integer contractId){
            Contract contract = contractService.findContractById(contractId);
            contractService.userBlockedByAdmin(contract);
            return "redirect:/adminAccount/findContractPage";
    }

    @RequestMapping (path = "/adminAccount/addNewClient")
    public String addNewClientPage(){
        return "admin/partials/addNewClient";
    }

    @RequestMapping(path = "/adminAccount/addNewClient/add", method = RequestMethod.GET)
    public String addClient(@ModelAttribute ("client")Client client){
        clientService.saveClient(client);
        return "redirect:/adminAccount/clientList";
    }

}
