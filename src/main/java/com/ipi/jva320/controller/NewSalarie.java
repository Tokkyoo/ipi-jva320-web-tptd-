package com.ipi.jva320.controller;

import com.ipi.jva320.exception.SalarieException;
import com.ipi.jva320.model.SalarieAideADomicile;
import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
public class NewSalarie {

    @Autowired
    private SalarieAideADomicileService salarieAideADomicileService;

    @GetMapping(value  = "salaries/aide/new")
    public String afficherSalarie(final ModelMap model)
    {
        model.put("countSalaries", salarieAideADomicileService.countSalaries());
        return "formulaire_creation_salarie";
    }

    @PostMapping("/salaries/aide/")
    public String traitementFormulaire(

            @RequestParam String nom,
                                       @RequestParam String moisEnCours,
                                       @RequestParam String moisDebutContrat,
                                       @RequestParam String joursTravaillesAnneeN,
                                       @RequestParam String congesPayesAcquisAnneeN,
                                       @RequestParam String joursTravaillesAnneeNMoins1,
                                       @RequestParam String congesPayesAcquisAnneeNMoins1,
                                       @RequestParam String congesPayesPrisAnneeNMoins1) throws SalarieException
    {
        SalarieAideADomicile s1 = this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile(nom, LocalDate.parse(moisEnCours), LocalDate.parse(moisDebutContrat),
                        Integer.parseInt(joursTravaillesAnneeN), Integer.parseInt(congesPayesAcquisAnneeN),
                        Integer.parseInt(joursTravaillesAnneeNMoins1), Integer.parseInt(congesPayesAcquisAnneeNMoins1), Integer.parseInt(congesPayesPrisAnneeNMoins1)));


        return "redirect:/salaries/";
    }

    @PostMapping (value="/salaries/aide/modifier")
    public String updateEmploye(SalarieAideADomicile salarieService) throws SalarieException {

        salarieAideADomicileService.updateSalarieAideADomicile(salarieService);
        return "redirect:/salaries/";

    }


    @GetMapping (value="/salaries/{idsSalarie}/delete")
    public String deleteEmploye(@PathVariable Long idsSalarie) throws SalarieException {

        salarieAideADomicileService.deleteSalarieAideADomicile(idsSalarie);
        return "redirect:/salaries/";

    }




}






