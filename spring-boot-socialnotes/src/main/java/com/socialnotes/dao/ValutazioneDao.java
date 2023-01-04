package com.socialnotes.dao;

import com.socialnotes.model.Valutazione;

import java.util.List;

public interface ValutazioneDao {

    boolean setValutazione (Valutazione valutazione);
    void deleteValutazione (String idValutazione);
    List<Valutazione> getValutazioniPost (String idPost);
    void deleteValutazioniPost (String idPost);

}
