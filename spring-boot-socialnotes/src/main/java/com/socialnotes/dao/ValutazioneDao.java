package com.socialnotes.dao;

import com.socialnotes.model.Valutazione;

public interface ValutazioneDao {

    boolean addValutazione(Valutazione valutazione);

    Valutazione prelevaValutazione();
}
