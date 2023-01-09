package com.socialnotes.dao;

import com.socialnotes.model.Valutazione;

import java.util.List;

public interface ValutazioneDao {

    List<Valutazione> getValutazioniPost (String idPost);
    boolean setValutazione (Valutazione valutazione);
    boolean deleteValutazione (String idValutazione);
    boolean deleteValutazioniPost (String idPost);

}
