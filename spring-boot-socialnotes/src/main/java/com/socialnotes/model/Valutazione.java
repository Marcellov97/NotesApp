package com.socialnotes.model;

public class Valutazione {
    private String idValutazione;
    private Integer valutazione;
    private String idPost;
    private String nomeUtente;

    public Valutazione (String idValutazione, Integer valutazione, String idPost, String nomeUtente) {
        this.idValutazione = idValutazione;
        this.valutazione = valutazione;
        this.idPost = idPost;
        this.nomeUtente = nomeUtente;
    }

    public Valutazione (Integer valutazione, String idPost, String nomeUtente) {
        this.valutazione = valutazione;
        this.idPost = idPost;
        this.nomeUtente = nomeUtente;
    }

    public Valutazione() {
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

    public Valutazione (Integer valutazione) {
        this.valutazione = valutazione;
    }

    public String getIdValutazione() {
        return idValutazione;
    }

    public void setIdValutazione(String idValutazione) {
        this.idValutazione = idValutazione;
    }

    public Integer getValutazione() {
        return valutazione;
    }

    public void setValutazione(Integer valutazione) {
        this.valutazione = valutazione;
    }

    @Override
    public String toString() {
        return "Valutazione [idValutazione=" + idValutazione + ", valutazione=" + valutazione + ", idPost=" + idPost
                + ", nomeUtente=" + nomeUtente + "]";
    }

}
