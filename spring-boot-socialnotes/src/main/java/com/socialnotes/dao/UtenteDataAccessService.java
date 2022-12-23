package com.socialnotes.dao;

import com.socialnotes.model.Utente;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/*

CLASSE PER L'ACCESSO AL DATABASE,
QUA DENTRO CI VANNO TUTTI I METODI CHE ACCEDONO AL DATABASE SOTTOSTANTE
 */

@Repository("MongoDao")
public class UtenteDataAccessService  implements UtenteDao{

    @Override
    public boolean insertUtente(UUID id, Utente utente) {
        return false;   //TODO deve essere implmentato l'accesso al database
    }

    @Override
    public Utente getUtente() { //TODO adesso ritorna un oggetto creato sul momento, collegarlo veramente ad un database
        return new Utente(UUID.randomUUID(),"Chiara","Paventa","chiarapav","c.paventa@sscnapoli.it","fozzanapoli",false);

    }
}
