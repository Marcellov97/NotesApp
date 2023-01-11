package com.socialnotes.model;

public class File {
    private String idFile;
    private String nome;
    private String estensione;
    private String idPost;

    public File(String idFile, String nome, String estensione, String idPost) {
        this.idFile = idFile;
        this.nome = nome;
        this.estensione = estensione;
        this.idPost = idPost;
    }

    public File(String nome, String estensione, String idPost) {
        this.nome = nome;
        this.estensione = estensione;
        this.idPost = idPost;
    }

    public File() {
    }

    public String getIdFile() {
        return idFile;
    }

    public void setIdFile(String idFile) {
        this.idFile = idFile;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstensione() {
        return estensione;
    }

    public void setEstensione(String estensione) {
        this.estensione = estensione;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    @Override
    public String toString() {
        return "File [idFile=" + idFile + ", nome=" + nome + ", estensione=" + estensione + ", idPost=" + idPost
                + "]";
    }

}
