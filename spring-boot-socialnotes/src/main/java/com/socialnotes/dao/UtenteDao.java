package com.socialnotes.dao;

import com.socialnotes.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/*
INTERFACCIA PER DEFINIRE QUELLE CHE SONO I METODI DI ACCESSO DATABASE
 */

public interface UtenteDao {

    boolean insertUtente(UUID id, Utente utente);

    default boolean addUtente(Utente utente){
        UUID id = UUID.randomUUID();
        return insertUtente(id, utente);
    }

    Utente getUtente();


}
