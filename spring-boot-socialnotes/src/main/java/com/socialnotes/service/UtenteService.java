package com.socialnotes.service;

import com.socialnotes.model.Utente;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    public Utente getUtente(){
        return new Utente(1,"marcello","Vestri","marcelloV97","ma.vestri@sscnapoli.it","fozzanapoli",false);

    }
}
