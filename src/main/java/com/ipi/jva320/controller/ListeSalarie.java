package com.ipi.jva320.controller;

import com.ipi.jva320.model.SalarieAideADomicile;
import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListeSalarie {

    @Autowired

    private SalarieAideADomicileService salarieService;
    @GetMapping("/salaries")
    public String search(@RequestParam(required = false) String nom, ModelMap model) {
        List<SalarieAideADomicile> salaries;

        if(nom != null && !nom.isEmpty()) {
            salaries = salarieService.getSalaries(nom);
        } else {
            salaries = salarieService.getSalaries();
        }
        model.put("countSalaries", salarieService.countSalaries());
        model.put("salaries", salaries);
        return "list";
    }










}
