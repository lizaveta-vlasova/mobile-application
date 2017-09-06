package com.mobileapplication.controller;

import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Contract;
import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;
import com.mobileapplication.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Controller
//@RequestMapping("/clientAccount")
public class ClientController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private TariffService tariffService;

    @RequestMapping(path = "/clientAccount/chooseContract", method = RequestMethod.GET)
    public String clientAccountChooseContract(Model model) {
        Client currentClient = loginService.getCurrentClient();
        List<Contract> contractsByClientId = contractService.findContractsByClient(currentClient);
        model.addAttribute("contractsList", contractsByClientId);
        model.addAttribute("client", currentClient);
       // return "client/clientAccountChooseContract";
        return "client/clientAccountChooseContracr";
    }
    @RequestMapping (path = "/clientAccount/userInfo/{clientId}")
    public String userInfo(Model model, @PathVariable("clientId") Integer clientId){
        model.addAttribute("client", clientService.getClientById(clientId));
        return "client/partials/clientProfile";
    }

    @RequestMapping(path = "/clientAccount/{contractId}", method = RequestMethod.GET)
    public String clientAccount(Model model, @PathVariable("contractId") Integer contractId) {
        Contract currentContract = contractService.findContractById(contractId);
        boolean isContractBlocked = contractService.isContractBlocked(contractId);

        model.addAttribute("contractId", contractId);
        model.addAttribute("isContractBlocked", isContractBlocked);
        model.addAttribute("contract", currentContract);
        return "client/newClientAccount";
    }

    @RequestMapping(path = "/clientAccount/tariff/{contractId}", method = RequestMethod.GET)
    public String clientAccountTariff(Model model, @PathVariable("contractId") Integer contractId) {
        Contract contract = contractService.findContractById(contractId);
        Integer currentTariffId = contract.getTariff().getId();
        model.addAttribute("currentTariffId", currentTariffId);
        model.addAttribute("tariffList", tariffService.tariffList());
        return "client/partials/tariff";
    }

    @RequestMapping(path = "/clientAccount/tariff/{contractId}/newTariff/{tariffId}", method = RequestMethod.GET)
    public String changeContractTariff(
            @PathVariable("contractId") Integer contractId,
            @PathVariable("tariffId") Integer tariffId
    ) {
        Tariff tariff = tariffService.getTariffById(tariffId);
        Contract contract = contractService.findContractById(contractId);
        contract.setTariff(tariff);
        contractService.updateContract(contract);
        return "redirect:/clientAccount/chooseContract";
    }

    @RequestMapping(path = "/clientAccount/options/{contractId}", method = RequestMethod.GET)
    public String clientAccountOptions(Model model, @PathVariable("contractId") Integer contractId) {
        Contract contract = contractService.findContractById(contractId);
        Tariff tariff = contract.getTariff();
        Set<Option> currentOptions = contract.getOptions();
        Set<Option> availableOptions = tariff.getAvailableOptions();
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(availableOptions);
        model.addAttribute("contractId", contractId);
        model.addAttribute("tariffOptions", myTreeSet);
        model.addAttribute("currentOptions", currentOptions);
        return "client/partials/options";
    }

    @RequestMapping(path = "/clientAccount/options/{contractId}/add/{optionId}", method = RequestMethod.GET)
    public String addOptionByContractId(Model model,
                                        @PathVariable("optionId") Integer optionId,
                                        @PathVariable("contractId") Integer contractId) {
        contractService.addOptionByContractId(optionId, contractId);
        return "redirect:/clientAccount/options/" + contractId;
    }

    @RequestMapping(path = "/clientAccount/options/{contractId}/remove/{optionId}", method = RequestMethod.GET)
    public String removeOptionByContractId(Model model,
                                           @PathVariable("optionId") Integer optionId,
                                           @PathVariable("contractId") Integer contractId) {
        contractService.removeOptionByContractId(optionId, contractId);
        return "redirect:/clientAccount/options/" + contractId;
    }


    //попадаем на страницу блокировки номера
    @RequestMapping(path = "/clientAccount/block/{contractId}", method = RequestMethod.GET)
    public String pageToBlockNumber(Model model, @PathVariable("contractId") Integer contractId) {
        Contract contract = contractService.findContractById(contractId);
        model.addAttribute("currentContract", contract);
        return "client/partials/block";
    }

    @RequestMapping(path = "/clientAccount/block/{contractId}/blocked", method = RequestMethod.GET)
    public String getBlock(Model model, @PathVariable("contractId") Integer contractId) {
        Contract currentContract = contractService.findContractById(contractId);
        contractService.userBlocked(currentContract);
        return "redirect:/clientAccount/" + contractId;
    }


    @RequestMapping(path = "/clientAccount/block/{contractId}/unblocked", method = RequestMethod.GET)
    public String getUnblock(Model model, @PathVariable("contractId") Integer contractId) {
        Contract currentContract = contractService.findContractById(contractId);
        contractService.userUnblocked(currentContract);
        return "redirect:/clientAccount/" + contractId;
    }
}

