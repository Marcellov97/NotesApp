package com.socialnotes.dao;

import com.socialnotes.model.Utente;
import java.util.UUID;

/*
INTERFACCIA PER DEFINIRE QUELLE CHE SONO I METODI DI ACCESSO DATABASE
 */

public interface UtenteDao {

    //INSERIMENTO UTENTE

    boolean insertUtente(UUID id, Utente utente);

    default boolean addUtente(Utente utente){
        UUID id = UUID.randomUUID();
        return insertUtente(id, utente);
    }

    //PRELIEVO UTENTE
    Utente prelevaUtente();



}
