package com.socialnotes.service;

import com.socialnotes.dao.SegnalazioneDao;
import com.socialnotes.model.Segnalazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SegnalazioneService {

    private final SegnalazioneDao segnalazioneDao;
    @Autowired
    public SegnalazioneService(SegnalazioneDao segnalazioneDao) { this.segnalazioneDao = segnalazioneDao; }

    public boolean setSegnalazione (Segnalazione segnalazione){ return segnalazioneDao.setSegnalazione(segnalazione); }

}
