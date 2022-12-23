package com.socialnotes.model;

import java.util.Objects;
import java.util.UUID;

public class Commento {

    private UUID id;
    private String testo;

    public Commento(UUID id, String testo) {
        this.id = id;
        this.testo = testo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

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
        return "Commento{" +
                "id=" + id +
                ", testo='" + testo + '\'' +
                '}';
    }
}
