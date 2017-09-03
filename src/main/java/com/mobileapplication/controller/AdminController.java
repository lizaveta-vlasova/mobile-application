package com.mobileapplication.controller;

import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Contract;
import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;
import com.mobileapplication.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
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

    @Autowired
    private PhoneNumberService phoneNumberService;

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

    @RequestMapping(path = "/adminAccount/createNewTariff")
    public String createNewTariff() {
        return  "admin/partials/createNewTariff";
    }

    @RequestMapping("/adminAccount/changeDataTariff/{tariffId}")
    public String changeDataTariff(@PathVariable ("tariffId") Integer tariffId,
                                   Model model){
        model.addAttribute("tariff", tariffService.getTariffById(tariffId));
        model.addAttribute("optionList", optionService.optionList());
        return "admin/partials/changeDataTariff";
    }

    /**
     * @param tariffId
     * @param model
     * @return
     */
    @RequestMapping("/adminAccount/addAndRemoveOptionsForTariff/{tariffId}")
    public String addAndRemoveOptionsForTariff(@PathVariable ("tariffId") Integer tariffId,
                                   Model model){
        Tariff currentTariff = tariffService.getTariffById(tariffId);

        model.addAttribute("tariff", currentTariff);
        model.addAttribute("optionList", optionService.optionList());
        return "admin/partials/addAndRemoveOptionsForTariff";
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
        Set<Option> option = optionService.findOptionById(optionId).getIncompatibleOptions();
        Tariff currentTariff = tariffService.getTariffById(tariffId);
        Set<Option>availableOptions = currentTariff.getAvailableOptions();
        if(tariffService.isOptionsCompatible(option, availableOptions)){
        return "Вы пытаетесь добавить несовместимые опции";}
        else {tariffService.addOptionByTariffId(tariffId, optionId);
        model.addAttribute("tariffId", tariffId);
        return "redirect:/adminAccount/addAndRemoveOptionsForTariff/"+tariffId;}

    }
    @RequestMapping("/adminAccount/editTariff/{tariffId}/remove/{optionId}")
    public String editTariffRemoveOption(@PathVariable ("tariffId") Integer tariffId,
                                      @PathVariable("optionId") Integer optionId,
                                      Model model){
        tariffService.removeOptionByTariffId(tariffId, optionId);
        model.addAttribute("tariffId", tariffId);
        return "redirect:/adminAccount/addAndRemoveOptionsForTariff/"+tariffId;
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
    @RequestMapping(path = "/adminAccount/addOption")
    public String getPageToAddOption(){
        return "admin/partials/addOption";
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

    @RequestMapping(path = "/adminAccount/compatibilityManagement")
    public String compatibilityManagement(Model model){
        model.addAttribute("optionList", optionService.optionList());
        return "admin/partials/compatibilityManagement";
    }
    @RequestMapping(path = "/adminAccount/compatibilityManagement/{optionId}")
    public String compatibilityManagementChooseOption(@PathVariable ("optionId")
                                                              Integer optionId, Model model){
        model.addAttribute("optionList", optionService.optionList());
        model.addAttribute("currentOption", optionService.getOptionById(optionId));
        return "admin/partials/compatibilityManagementOption";
    }
    @RequestMapping(path = "/adminAccount/getCompatible/{optionId}/{currentOptionId}")
    public String getCompatible(@PathVariable ("optionId") Integer editOptionId,@PathVariable("currentOptionId")
            Integer optionId, Model model){
        Option currentOption = optionService.findOptionById(optionId);
        optionService.removeUncompotibleOption(editOptionId, optionId);
        model.addAttribute("currentOption", optionService.getOptionById(optionId));
        return "redirect:/adminAccount/compatibilityManagement/" +optionId;
    }

    @RequestMapping(path = "/adminAccount/getUncompatible/{optionId}/{currentOptionId}")
    public String getUncompatible(@PathVariable ("optionId") Integer editOptionId,@PathVariable("currentOptionId")
            Integer optionId, Model model){
        Option currentOption = optionService.findOptionById(optionId);
        optionService.addUncompatibleOption(editOptionId, optionId);
        model.addAttribute("currentOption", optionService.getOptionById(optionId));
        return "redirect:/adminAccount/compatibilityManagement/" +optionId;
    }





    //идем на страницу поиска контракта по номеру
    @RequestMapping(path = "/adminAccount/findContractPage")
    public String getToFindContractPage(){

        return "admin/partials/findContractPage";
    }

    //find contract by number
    @RequestMapping(path = "/adminAccount/getFoundContract/{number}")
    public String findContract (Model model, String number) throws IOException {
        try {
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
        catch (Exception e){
            return "admin/partials/errors/failedNumberToFindContractPage";
        }
    }

    @RequestMapping(path = "/adminAccount/contractInfo/{contractId}")
    public String getFoundContractSecondPart(@PathVariable ("contractId") Integer contractId,
                                             Model model){
        model.addAttribute("currentContract", contractService.findContractById(contractId));
        return "admin/partials/secondPartOfFoundContractPage";
    }



    @RequestMapping(path = "/adminAccount/blockAndUnblockContract/{contractId}")
    public String blockAndUnblockClientContract(@PathVariable ("contractId") Integer contractId,
                                                Model model){
        model.addAttribute("currentContract", contractService.findContractById(contractId));
        return "admin/partials/blockAndUnblock";
    }

    @RequestMapping(path = "/adminAccount/pageToRemoveContract/{contractId}")
    public String pageToRemoveContract(@PathVariable ("contractId") Integer contractId,
                                                Model model){

        model.addAttribute("contractId", contractId);
        return "admin/partials/pageToRemoveContract";
    }
    @RequestMapping(path = "/adminAccount/removeContract/{contractId}")
    public String removeContract(@PathVariable ("contractId") Integer contractId,
                                       Model model){

        contractService.removeContract(contractId);
        return "redirect:/adminAccount/findContractPage";
    }

    @RequestMapping(path = "/adminAccount/changeTariffInContract/{contractId}")
    public String getPageToChangeTariff(@PathVariable ("contractId") Integer contractId,
                                                Model model){
        Contract currentContract = contractService.findContractById(contractId);
        model.addAttribute("currentContract", contractService.findContractById(contractId));
        model.addAttribute("tariffList", tariffService.tariffList());
        model.addAttribute("number", currentContract.getNumber());
        return "admin/partials/pageToChangeTariffForContract";
    }
    @RequestMapping(path = "/adminAccount/editOptionsForContract/{contractId}")
    public String editOptionsForContract(@PathVariable ("contractId") Integer contractId,
                                        Model model){
        Contract currentContract = contractService.findContractById(contractId);
        Set<Option> availableOptions = currentContract.getTariff().getAvailableOptions();
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(availableOptions);
        model.addAttribute("currentContract", contractService.findContractById(contractId));
        model.addAttribute("tariffList", tariffService.tariffList());
        model.addAttribute("tariffOptions", myTreeSet);
        model.addAttribute("number", contractService.findContractById(contractId).getNumber());
        return "admin/partials/editOptionsForContract";
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
        model.addAttribute("contractId", contractId);
        return "redirect:/adminAccount/changeTariffInContract/"+ contractId;
    }
    @RequestMapping(path = "/adminAccount/getFoundContract/{optionId}/add/{contractId}")
    public String addOptionsForClientContract(@PathVariable ("optionId") Integer optionId ,
                                             @PathVariable ("contractId") Integer contractId,
                                              Model model){
        contractService.addOptionByContractId(optionId, contractId);
        Contract contract = contractService.findContractById(contractId);
        //Integer number = contract.getNumber();
        model.addAttribute("contractId", contractId);
        return "redirect:/adminAccount/editOptionsForContract/" + contractId;
    }

    @RequestMapping(path = "/adminAccount/getFoundContract/{optionId}/remove/{contractId}")
    public String removeOptionsForClientContract(@PathVariable ("optionId") Integer optionId ,
                                              @PathVariable ("contractId") Integer contractId,
                                              Model model){
        contractService.removeOptionByContractId(optionId, contractId);
        Contract contract = contractService.findContractById(contractId);
       // Integer number = contract.getNumber();
        model.addAttribute("contractId", contractId);
        return "redirect:/adminAccount/editOptionsForContract/" + contractId;
    }


    //на странице контракта блокируем его
    @RequestMapping(path = "/adminAccount/getFoundContract/{contractId}/block")
    public String blockContract(Model model, @PathVariable("contractId") Integer contractId){
            Contract contract = contractService.findContractById(contractId);
            model.addAttribute("contractId", contractId);
            contractService.userBlockedByAdmin(contract);
            return "redirect:/adminAccount/blockAndUnblockContract/"+contractId;
    }

    //разблокируем
    @RequestMapping(path = "/adminAccount/getFoundContract/{contractId}/unblock")
    public String unblockContract(Model model, @PathVariable("contractId") Integer contractId){
        Contract contract = contractService.findContractById(contractId);
        model.addAttribute("contractId", contractId);
        contractService.userUnblockedByAdmin(contract);
        return "redirect:/adminAccount/blockAndUnblockContract/"+contractId;
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
        model.addAttribute("numbers", phoneNumberService.numberList());
        return "admin/partials/addNewContract";
    }
    @RequestMapping(path = "adminAccount/addNewContract/add" , method = RequestMethod.POST)
    public String saveNewContract(
            @ModelAttribute("tariffId") Integer tariffId,
                                  @ModelAttribute ("clientId") Integer clientId,
                                  @ModelAttribute("number") String number){
        Contract contract = new Contract();
        contract.setTariff(tariffService.getTariffById(tariffId));
        contract.setClient(clientService.getClientById(clientId));
        contract.setNumber(number);
        contractService.saveContract(contract);
        return "redirect:/adminAccount/clientList";

    }

}
