package com.socialnotes.dao;

import com.socialnotes.model.Segnalazione;

public interface SegnalazioneDao {

    boolean addSegnalazione(Segnalazione segnalazione);

    Segnalazione prelevaSegnalazione();
}
