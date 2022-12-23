package com.socialnotes.model;

import java.util.Objects;
import java.util.UUID;

public class Segnalazione {

    private UUID id;
    private String testo;

    public Segnalazione(UUID id, String testo) {
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
        Segnalazione that = (Segnalazione) o;
        return Objects.equals(id, that.id) && Objects.equals(testo, that.testo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testo);
    }

    @Override
    public String toString() {
        return "Segnalazione{" +
                "id=" + id +
                ", testo='" + testo + '\'' +
                '}';
    }
}
