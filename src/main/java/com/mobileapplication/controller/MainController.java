package com.mobileapplication.controller;

import com.mobileapplication.domain.Tariff;
import com.mobileapplication.service.TariffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class MainController {
    TariffService tariffService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String start() {
        return "index";
    }

    /*@RequestMapping(value = "/tariff", method = RequestMethod.GET)
    public String getTariffList(Model model){
        model.addAttribute("tariff", new Tariff());
        model.addAttribute("tariffList", tariffService.tariffList());
        return "Tariff";
    }*/
}
