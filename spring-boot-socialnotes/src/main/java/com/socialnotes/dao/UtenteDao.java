    package com.socialnotes.dao;

    import com.socialnotes.model.*;
    import java.util.List;

    /**
     * CLASSE PER LA DEFINIZIONE DEI METODI DI ACCESSO AL DB PER LA COLLEZIONE UTENTE
     */
    public interface UtenteDao {
        Utente getUtente (String nomeUtente);
        List<Utente> getAllUtenti ();
        boolean setUtente(Utente utente);
        boolean deleteUtente(String nomeUtente);

        //boolean updatePasswordUtente(String password);

    }
