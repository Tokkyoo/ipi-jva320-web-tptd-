package com.ipi.jva320.controller;

import com.ipi.jva320.model.SalarieAideADomicile;
import com.ipi.jva320.repository.SalarieAideADomicileRepository;
import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {

    @Autowired
    private SalarieAideADomicileService salarie;

    @GetMapping(value = "/")
    public String home(final ModelMap model){

        model.put("title", "Bienvenue dans l'interface d'administration RH !   "+ salarie.countSalaries() + " (salariés)");
        model.put("countSalaries", salarie.countSalaries());
        return "home";
    }




}

