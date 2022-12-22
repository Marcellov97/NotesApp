package com.socialnotes.controller;

import com.socialnotes.model.Utente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "api/utente")
public class UtenteController {
    @GetMapping
    public Utente getUtente (){
        return new Utente(1,"marcello","Vestri","marcelloV97","ma.vestri@sscnapoli.it","fozzanapoli",false);

    }

}
