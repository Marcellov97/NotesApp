package com.socialnotes.controller;

import com.socialnotes.model.Segnalazione;
import com.socialnotes.service.SegnalazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/segnalazione")
@CrossOrigin //annotazione per il cross domain tra client e server
public class SegnalazioneController {
    private final SegnalazioneService segnalazioneService;
    @Autowired
    public SegnalazioneController(SegnalazioneService segnalazioneService) { this.segnalazioneService = segnalazioneService; }
    @PostMapping
    public boolean setSegnalazione (@RequestBody Segnalazione segnalazione){ return segnalazioneService.setSegnalazione(segnalazione); }

}
