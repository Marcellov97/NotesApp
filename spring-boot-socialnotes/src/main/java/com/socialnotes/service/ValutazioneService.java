package com.socialnotes.service;

import com.socialnotes.dao.ValutazioneDao;
import com.socialnotes.model.Valutazione;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValutazioneService {

    private final ValutazioneDao valutazioneDao;

    public ValutazioneService(ValutazioneDao valutazioneDao) { this.valutazioneDao = valutazioneDao; }

    public boolean setValutazione (Valutazione valutazione) { return valutazioneDao.setValutazione(valutazione); }
    public void deleteValutazione (String idValutazione) { valutazioneDao.deleteValutazione(idValutazione); }
    public List<Valutazione> getValutazioniPost (String idPost) { return valutazioneDao.getValutazioniPost(idPost); }
    public void deleteValutazioniPost (String idPost) { valutazioneDao.deleteValutazioniPost(idPost); }

}
