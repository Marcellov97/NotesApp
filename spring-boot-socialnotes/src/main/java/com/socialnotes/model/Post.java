package com.socialnotes.model;

import java.util.UUID;

public class Post {
    private String id;
    private String descrizione;
    private int valutazione;
    private boolean segnalato;
    private String nomeUtente;

    public Post (String id, String descrizione, int valutazione, boolean segnalato, String nomeUtente) {
        this.id = id;
        this.descrizione = descrizione;
        this.valutazione = valutazione;
        this.segnalato = segnalato;
        this.nomeUtente = nomeUtente;
    }

    public Post (String descrizione, int valutazione, boolean segnalato, String nomeUtente) {
        this.descrizione = descrizione;
        this.valutazione = valutazione;
        this.segnalato = segnalato;
        this.nomeUtente = nomeUtente;
    }

    public Post() {
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getDescrizione () {
        return descrizione;
    }

    public void setDescrizione (String descrizione) {
        this.descrizione = descrizione;
    }

    public int getValutazione () {
        return valutazione;
    }

    public void setValutazione (int valutazione) {
        this.valutazione = valutazione;
    }

    public boolean getSegnalato () {
        return segnalato;
    }

    public void setSegnalato (boolean segnalato) {
        this.segnalato = segnalato;
    }

    public String getNomeUtente () {
        return nomeUtente;
    }

    public void setNomeUtente (String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", descrizione=" + descrizione + ", valutazione=" + valutazione
                + ", segnalato=" + segnalato + ", nomeUtente=" + nomeUtente + "]";
    }
}
