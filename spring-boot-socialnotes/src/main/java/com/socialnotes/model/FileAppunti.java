package com.socialnotes.model;

import java.util.Objects;
import java.util.UUID;

public class FileAppunti {

    private UUID id;
    private String nome;
    private String estensione;

    public FileAppunti(UUID id, String nome, String estensione) {
        this.id = id;
        this.nome = nome;
        this.estensione = estensione;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileAppunti file = (FileAppunti) o;
        return Objects.equals(id, file.id) && Objects.equals(nome, file.nome) && Objects.equals(estensione, file.estensione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, estensione);
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estensione='" + estensione + '\'' +
                '}';
    }
}
