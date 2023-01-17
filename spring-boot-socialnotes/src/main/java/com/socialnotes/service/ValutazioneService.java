package com.socialnotes.service;

import com.socialnotes.dao.ValutazioneDao;
import com.socialnotes.model.Valutazione;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValutazioneService {

    private final ValutazioneDao valutazioneDao;

    public ValutazioneService(ValutazioneDao valutazioneDao) { this.valutazioneDao = valutazioneDao; }

    public List<Valutazione> getValutazioniPost (String idPost) { return valutazioneDao.getValutazioniPost(idPost); }
    public boolean getValutazioneUtentePost (String nomeUtente, String idPost) { return valutazioneDao.getValutazioneUtentePost(nomeUtente, idPost); }
    public boolean setValutazione (Valutazione valutazione) { return valutazioneDao.setValutazione(valutazione); }
    public boolean deleteValutazione (String idValutazione) { return valutazioneDao.deleteValutazione(idValutazione); }
    public boolean deleteValutazioniPost (String idPost) { return valutazioneDao.deleteValutazioniPost(idPost); }

}
