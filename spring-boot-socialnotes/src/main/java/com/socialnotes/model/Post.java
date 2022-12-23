package com.socialnotes.model;

import java.util.Objects;
import java.util.UUID;

public class Post {

    //VARIABILI
    private UUID id;
    private String descrizione;
    private int valutazione;
    private boolean segnalato;

    public Post(UUID id, String descrizione, int valutazione, boolean segnalato) {
        this.id = id;
        this.descrizione = descrizione;
        this.valutazione = valutazione;
        this.segnalato = segnalato;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public boolean isSegnalato() {
        return segnalato;
    }

    public void setSegnalato(boolean segnalato) {
        this.segnalato = segnalato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return valutazione == post.valutazione && segnalato == post.segnalato && Objects.equals(id, post.id) && Objects.equals(descrizione, post.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descrizione, valutazione, segnalato);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", valutazione=" + valutazione +
                ", segnalato=" + segnalato +
                '}';
    }
}
