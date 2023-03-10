package com.socialnotes.controller;

import com.socialnotes.model.Valutazione;
import com.socialnotes.service.ValutazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/valutazione")
@CrossOrigin //annotazione per il cross domain tra client e server
public class ValutazioneController {

    private final ValutazioneService valutazioneService;
    @Autowired
    public ValutazioneController(ValutazioneService valutazioneService) { this.valutazioneService = valutazioneService; }
    @GetMapping("getValutazioniPost/{idPost}")
    public List<Valutazione> getValutazioniPost (@PathVariable String idPost) { return valutazioneService.getValutazioniPost(idPost); }
    @GetMapping("getValutazioneUtentePost/{nomeUtente}/{idPost}")
    public boolean getValutazioneUtentePost(@PathVariable String nomeUtente, @PathVariable String idPost) { return valutazioneService.getValutazioneUtentePost(nomeUtente, idPost); }
    @PostMapping
    public boolean setValutazione (@RequestBody Valutazione valutazione) { return valutazioneService.setValutazione(valutazione); }

    @DeleteMapping("deleteValutazione/{idValutazione}")
    public boolean deleteValutazione (@PathVariable String idValutazione) { return valutazioneService.deleteValutazione(idValutazione); }

    @DeleteMapping("deleteValutazioniPost/{idPost}")
    public boolean deleteValutazioniPost (@PathVariable String idPost) { return valutazioneService.deleteValutazioniPost(idPost); }

    }
