package com.socialnotes.model;

public class Segnalazione {
    private String idSegnalazione;
    private String testo;
    private String idPost;
    private String idUtente;

    public Segnalazione (String idSegnalazione, String testo, String idPost, String idUtente) {
        this.idSegnalazione = idSegnalazione;
        this.testo = testo;
        this.idPost = idPost;
        this.idUtente = idUtente;
    }

    public Segnalazione (String testo, String idPost, String idUtente) {
        this.testo = testo;
        this.idPost = idPost;
        this.idUtente = idUtente;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(String idUtente) {
        this.idUtente = idUtente;
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
                + ", idUtente=" + idUtente + "]";
    }

}
