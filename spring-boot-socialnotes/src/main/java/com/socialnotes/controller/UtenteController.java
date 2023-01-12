    package com.socialnotes.controller;

    import com.socialnotes.model.Utente;
    import com.socialnotes.service.UtenteService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    import java.util.List;



    @RestController
    @RequestMapping(path= "/utente")
    @CrossOrigin //annotazione per il cross domain tra client e server
    public class UtenteController {
        private final UtenteService utenteService;

        @Autowired
        public UtenteController(UtenteService utenteService) {  //COSTRUTTORE
            this.utenteService = utenteService;
        }

        @GetMapping("getUtente/{nomeUtente}")
        public Utente getUtente (@PathVariable String nomeUtente){
            return utenteService.getUtente(nomeUtente);
        }

        @GetMapping("getAllUtenti")
        public List<Utente> getAllUtenti() { return utenteService.getAllUtenti(); }

        @PostMapping
        public void setUtente(@RequestBody Utente utente) { utenteService.setUtente(utente); }

        @DeleteMapping("deleteUtente/{nomeUtente}")
        public void deleteUtente(@PathVariable String nomeUtente) { utenteService.deleteUtente(nomeUtente); }

    }
