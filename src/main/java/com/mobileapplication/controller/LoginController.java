package com.mobileapplication.controller;

import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Contract;
import com.mobileapplication.domain.Option;
import com.mobileapplication.service.ClientService;
import com.mobileapplication.service.ContractService;
import com.mobileapplication.service.LoginService;
import com.mobileapplication.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;


    @RequestMapping(path = "/loginForm")
    public String loginForm(Model model) {
        return "loginFormNew";
    }

    @RequestMapping(path = "/loginForm{idClient}", params = "idClient")
    public String getClientAccount(Model model, Integer idClient) {
        if (idClient == 454) {
            return "redirect:/adminAccount";
        }

        else {
            Client currentClient = loginService.login(idClient);
            return "redirect:/clientAccount/chooseContract";}
    }


}

