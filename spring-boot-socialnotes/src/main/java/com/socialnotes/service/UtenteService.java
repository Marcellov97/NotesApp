    package com.socialnotes.service;

    import com.socialnotes.dao.UtenteDao;
    import com.socialnotes.model.Utente;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Qualifier;
    import org.springframework.stereotype.Service;

    import java.util.List;

    /**
     * CLASSE CHE DEFINISCE I SERVIZI MESSI A DISPOSIZIONE PER LA CLASSE UTENTE
     */

    @Service
    public class UtenteService {
        private final UtenteDao utenteDao; // mette a disposizione i metodi di accesso al DB
        @Autowired
        public UtenteService(@Qualifier("UtenteDao") UtenteDao utenteDao) { this.utenteDao = utenteDao; }
        public Utente getUtente(String nomeUtente) { return utenteDao.getUtente(nomeUtente); }
        public List<Utente> getAllUtenti() { return utenteDao.getAllUtenti(); }
        public boolean setUtente(Utente utente) { return utenteDao.setUtente(utente); }
        public boolean deleteUtente(String nomeUtente) { return utenteDao.deleteUtente(nomeUtente); }

        }
