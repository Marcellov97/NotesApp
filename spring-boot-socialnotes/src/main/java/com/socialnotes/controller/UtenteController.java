package com.socialnotes.controller;

import com.socialnotes.model.Utente;
import com.socialnotes.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "api/utente")
public class UtenteController {

    //PROPRIETA' DEL CONTROLLER
    private final UtenteService utenteService;


    //FUNZIONI
    @Autowired
    public UtenteController(UtenteService utenteService) {  //COSTRUTTORE
        this.utenteService = utenteService;
    }

    @GetMapping
    public Utente getUtente (){
        return utenteService.getUtente();
    }

    @PostMapping
    public void addUtente(@RequestBody Utente utente){
        utenteService.addUtente(utente);
    }



}
