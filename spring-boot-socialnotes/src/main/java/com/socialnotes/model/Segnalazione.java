package com.socialnotes.model;

public class Segnalazione {
    private String idSegnalazione;
    private String testo;
    private String idPost;
    private String nomeUtente;

    public Segnalazione (String idSegnalazione, String testo, String idPost, String nomeUtente) {
        this.idSegnalazione = idSegnalazione;
        this.testo = testo;
        this.idPost = idPost;
        this.nomeUtente = nomeUtente;
    }

    public Segnalazione (String testo, String idPost, String nomeUtente) {
        this.testo = testo;
        this.idPost = idPost;
        this.nomeUtente = nomeUtente;
    }

    public Segnalazione() {
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getIdSegnalazione() {
        return idSegnalazione;
    }

    public void setIdSegnalazione(String idSegnalazione) {
        this.idSegnalazione = idSegnalazione;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    @Override
    public String toString() {
        return "Segnalazione [idSegnalazione=" + idSegnalazione + ", testo=" + testo + ", idPost=" + idPost
                + ", nomeUtente=" + nomeUtente + "]";
    }

}
