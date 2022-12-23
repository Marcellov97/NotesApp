package com.socialnotes.dao;

import com.socialnotes.model.Utente;
import java.util.UUID;

/*
INTERFACCIA PER DEFINIRE QUELLE CHE SONO I METODI DI ACCESSO DATABASE
 */

public interface UtenteDao {

    //TODO trovare una convenzione per i nomi dei metodi di accesso al database

    //METODI INSERIMENTO UTENTE
    boolean insertUtente(UUID id, Utente utente);   //serve per inserire nel database l'utente con l'id

    default boolean addUtente(Utente utente){       //serve per aggiungere un utente al database ma creando un id random
        UUID id = UUID.randomUUID();
        return insertUtente(id, utente);
    }


    //METODI PRELIEVO UTENTE
    Utente prelevaUtente(); //serve per prelevare un utente



}
