package com.socialnotes.service;

import com.socialnotes.dao.UtenteDao;
import com.socialnotes.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.UUID;

/*
CLASSE CHE DEFINISCE I SERVIZI MESSI A DISPOSIZIONE PER LA CLASSE UTENTE
 */

@Service
public class UtenteService {

    //VARIABILI
    private final UtenteDao utenteDao;

    @Autowired
    public UtenteService(@Qualifier("MongoDao") UtenteDao utenteDao) {
        this.utenteDao = utenteDao;
    }

    public boolean addUtente(Utente utente){
        utenteDao.addUtente(utente);
        return false;
    }

    public Utente getUtente(){
        return utenteDao.getUtente();
    }
}
