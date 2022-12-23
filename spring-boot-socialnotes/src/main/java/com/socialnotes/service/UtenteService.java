package com.socialnotes.service;

import com.socialnotes.dao.UtenteDao;
import com.socialnotes.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
CLASSE CHE DEFINISCE I SERVIZI MESSI A DISPOSIZIONE PER LA CLASSE UTENTE
 */

@Service
public class UtenteService {

    //VARIABILI
    private final UtenteDao utenteDao;  //variabile che mette a disposizione i metodi di accesso al DB


    //COSTRUTTORI
    @Autowired
    public UtenteService(@Qualifier("MongoDao") UtenteDao utenteDao) {
        this.utenteDao = utenteDao;
    }


    //METODI
    public boolean addUtente(Utente utente){return utenteDao.addUtente(utente);}

    public Utente getUtente(){
        return utenteDao.prelevaUtente();
    }
}
