package com.socialnotes.model;

import java.util.Objects;

public class Commento {

    private String id;
    private String testo;
    private String idPost;
    private String nomeUtente;

    public Commento(String id, String testo, String idPost, String nomeUtente) {
        this.id = id;
        this.testo = testo;
        this.idPost = idPost;
        this.nomeUtente = nomeUtente;
    }

    public Commento (String testo, String idPost, String idUtente) {
        this.testo = testo;
        this.idPost = idPost;
        this.nomeUtente = idUtente;
    }

    public Commento() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getIdPost() { return idPost; }

    public void setIdPost(String idPost) { this.idPost = idPost; }

    public String getNomeUtente() { return nomeUtente; }

    public void setNomeUtente(String nomeUtente) { this.nomeUtente = nomeUtente; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commento commento = (Commento) o;
        return Objects.equals(id, commento.id) && Objects.equals(testo, commento.testo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testo);
    }

    @Override
    public String toString() {
        return "Commento [id=" + id + ", testo=" + testo + ", idPost=" + idPost + ", idUtente="
                + nomeUtente + "]";
    }
}
