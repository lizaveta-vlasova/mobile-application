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
import java.util.Set;
import java.util.TreeSet;

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
        return "newAdminAccount/newAdminAccount";
        //return "admin/adminAccount";
    }


    @RequestMapping(path = "/adminAccount/clientList")
    public String clientList(Model model){
        model.addAttribute("clientList",clientService.clientList());
       return  "admin/partials/clientList";
    }

    @RequestMapping(path = "/adminAccount/addTariff")
    public String pageToAddTariff(Model model) {
        model.addAttribute("tariffList", tariffService.tariffList());
        return  "admin/partials/addTariff";
    }
    @RequestMapping(path = "/adminAccount/editTariff/{tariffId}")
    public String editTariff(Model model, @PathVariable ("tariffId") Integer tariffId) {
        model.addAttribute("tariff", tariffService.getTariffById(tariffId));
        model.addAttribute("optionList", optionService.optionList());
        return  "newAdminAccount/partials/editTariff";
    }

    @RequestMapping("/adminAccount/editTariff/updateTariff/{tariffId}")
    public String saveEditTariff(@ModelAttribute ("tariff") Tariff tariff,
                                 @PathVariable ("tariffId") Integer tariffId,
                                 Model model){
        Tariff currentTariff = tariffService.getTariffById(tariffId);
        currentTariff.setName(tariff.getName());
        currentTariff.setPrice(tariff.getPrice());
        tariffService.addNewTariff(currentTariff);
        model.addAttribute("tariffId", currentTariff.getId());
        return "redirect:/adminAccount/editTariff/"+tariffId;
    }
    @RequestMapping("/adminAccount/editTariff/{tariffId}/add/{optionId}")
    public String editTariffAddOption(@PathVariable ("tariffId") Integer tariffId,
                                      @PathVariable("optionId") Integer optionId,
                                      Model model){
        tariffService.addOptionByTariffId(tariffId, optionId);
        model.addAttribute("tariffId", tariffId);
        return "redirect:/adminAccount/editTariff/"+tariffId;
    }
    @RequestMapping("/adminAccount/editTariff/{tariffId}/remove/{optionId}")
    public String editTariffRemoveOption(@PathVariable ("tariffId") Integer tariffId,
                                      @PathVariable("optionId") Integer optionId,
                                      Model model){
        tariffService.removeOptionByTariffId(tariffId, optionId);
        model.addAttribute("tariffId", tariffId);
        return "redirect:/adminAccount/editTariff/"+tariffId;
    }


    @RequestMapping(path = "/adminAccount/addTariff/add" , method = RequestMethod.POST)
    public String addNewTariff(Model model,@ModelAttribute ("tariff") Tariff tariff){
        Tariff newTariff = tariffService.addNewTariff(tariff);
        model.addAttribute("tariffId", newTariff.getId());
        return "redirect:/adminAccount/addOptionsForTariff/" + newTariff.getId();
    }

    @RequestMapping(path = "/adminAccount/addTariff/{tariffId}/remove")
    public String removeTariff(Model model, @PathVariable ("tariffId") Integer tariffId ){
        Tariff currentTariff = tariffService.getTariffById(tariffId);
        tariffService.removeTariff(currentTariff);
        return "redirect:/adminAccount/addTariff";
    }
    @RequestMapping (path = "/adminAccount/addOptionsForTariff/{tariffId}")
    public String addOptionsForNewTariff (@PathVariable ("tariffId") Integer tariffId, Model model){
        List<Option> optionList = optionService.optionList();
        Tariff currentTariff = tariffService.getTariffById(tariffId);
        model.addAttribute("currentTariff", currentTariff);
        model.addAttribute("options", optionList);
        model.addAttribute("tariffId", tariffId);
        return "admin/partials/addOptionsForTariff";
    }
    @RequestMapping(path = "/adminAccount/addOptionsForTariff/{tariffId}/add/{optionId}",
            method = RequestMethod.POST )
    public String saveOptionsForNewTariff(@PathVariable("tariffId") Integer tariffId,
                                          @PathVariable ("optionId") Integer optionId){
        tariffService.addOptionByTariffId(tariffId, optionId);
        return "redirect:/adminAccount/addOptionsForTariff/" + tariffId;
    }
    @RequestMapping(path = "/adminAccount/addOptionsForTariff/{tariffId}/remove/{optionId}",
            method = RequestMethod.POST )
    public String removeOptionsForNewTariff(@PathVariable("tariffId") Integer tariffId,
                                          @PathVariable ("optionId") Integer optionId){
        tariffService.removeOptionByTariffId(tariffId, optionId);
        return "redirect:/adminAccount/addOptionsForTariff/" + tariffId;
    }





    @RequestMapping(path = "/adminAccount/optionList")
    public String getPageToEditOptions(Model model){
        List<Option> optionList = optionService.optionList();
        model.addAttribute("optionsList", optionList );
        return "admin/partials/optionList";
    }
    @RequestMapping(path = "/adminAccount/optionList/{optionId}/remove", method = RequestMethod.GET)
    public String removeOption(@PathVariable ("optionId") Integer optionId){
        Option currentOption = optionService.findOptionById(optionId);
        optionService.removeOption(currentOption);
        return "redirect:/adminAccount/optionList";
    }

    @RequestMapping(path = "/adminAccount/optionList/add", method = RequestMethod.POST)
    public String addOption(@ModelAttribute ("option") Option option){
        optionService.saveOption(option);
        return "redirect:/adminAccount/optionList";
    }

    //идем на страницу поиска контракта по номеру
    @RequestMapping(path = "/adminAccount/findContractPage")
    public String getToFindContractPage(){

        return "admin/partials/findContractPage";
    }

    //find contract by number
    @RequestMapping(path = "/adminAccount/getFoundContract/{number}")
    public String findContract (Model model, Integer number){
        Contract currentContract = contractService.findContractByNumber(number);
        model.addAttribute("currectContract", currentContract);
        model.addAttribute("tariffList", tariffService.tariffList());
        Set<Option> currentOptions = currentContract.getOptions();
        Set<Option> availableOptions = currentContract.getTariff().getAvailableOptions();
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(availableOptions);
        model.addAttribute("tariffOptions", myTreeSet);
        return "admin/partials/getFoundContract";
    }

    //change tariff
    @RequestMapping(path = "/adminAccount/getFoundContract/{contractId}/change/{tariffId}")
    public String changeTariffInClientContract(Model model,
                                             @PathVariable ("contractId") Integer contractId,
                                               @PathVariable ("tariffId") Integer tariffId){
        Contract currentContract = contractService.findContractById(contractId);
        Tariff tariff = tariffService.getTariffById(tariffId);
        currentContract.setTariff(tariff);
        contractService.updateContract(currentContract);
        Integer number = currentContract.getNumber();
        model.addAttribute("number", number);
        return "redirect:/adminAccount/getFoundContract/" + number;
    }
    @RequestMapping(path = "/adminAccount/getFoundContract/{optionId}/add/{contractId}")
    public String addOptionsForClientContract(@PathVariable ("optionId") Integer optionId ,
                                             @PathVariable ("contractId") Integer contractId,
                                              Model model){
        contractService.addOptionByContractId(optionId, contractId);
        Contract contract = contractService.findContractById(contractId);
        Integer number = contract.getNumber();
        model.addAttribute("number", number);
        return "redirect:/adminAccount/getFoundContract/" + number;
    }

    @RequestMapping(path = "/adminAccount/getFoundContract/{optionId}/remove/{contractId}")
    public String removeOptionsForClientContract(@PathVariable ("optionId") Integer optionId ,
                                              @PathVariable ("contractId") Integer contractId,
                                              Model model){
        contractService.removeOptionByContractId(optionId, contractId);
        Contract contract = contractService.findContractById(contractId);
        Integer number = contract.getNumber();
        model.addAttribute("number", number);
        return "redirect:/adminAccount/getFoundContract/" + number;
    }


    //на странице контракта блокируем его
    @RequestMapping(path = "/adminAccount/getFoundContract/{contractId}/block")
    public String blockContract(Model model, @PathVariable("contractId") Integer contractId){
            Contract contract = contractService.findContractById(contractId);
            Integer number = contract.getNumber();
            model.addAttribute("number", number);
            contractService.userBlockedByAdmin(contract);
            return "redirect:/adminAccount/getFoundContract/" + number;
    }

    //разблокируем
    @RequestMapping(path = "/adminAccount/getFoundContract/{contractId}/unblock")
    public String unblockContract(Model model, @PathVariable("contractId") Integer contractId){
        Contract contract = contractService.findContractById(contractId);
        Integer number = contract.getNumber();
        model.addAttribute("number", number);
        contractService.userUnblockedByAdmin(contract);
        return "redirect:/adminAccount/getFoundContract/" + number;
    }

    @RequestMapping (path = "/adminAccount/addNewClient")
    public String addNewClientPage(){
        return "admin/partials/addNewClient";
    }

    @RequestMapping(path = "/adminAccount/addNewClient/save", method = RequestMethod.POST)
    public String addClient(@ModelAttribute ("client")Client client){
        clientService.saveClient(client);
        return "redirect:/adminAccount/clientList";
    }

    @RequestMapping (path = "/adminAccount/addNewContract")
    public String addNewContractPage(Model model){
        model.addAttribute("tariffList", tariffService.tariffList());
        model.addAttribute("clientList", clientService.clientList());
        return "admin/partials/addNewContract";
    }
    @RequestMapping(path = "adminAccount/addNewContract/add" , method = RequestMethod.POST)
    public String saveNewContract(
            @ModelAttribute("tariffId") Integer tariffId,
                                  @ModelAttribute ("clientId") Integer clientId,
                                  @ModelAttribute("number") Integer number){
        Contract contract = new Contract();
        contract.setTariff(tariffService.getTariffById(tariffId));
        contract.setClient(clientService.getClientById(clientId));
        contract.setNumber(number);
        contractService.saveContract(contract);
        return "redirect:/adminAccount/clientList";

    }

}
