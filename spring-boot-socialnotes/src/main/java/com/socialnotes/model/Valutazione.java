package com.socialnotes.model;

import java.util.Objects;
import java.util.UUID;

public class Valutazione {

    private UUID id;
    private int valutazione;

    public Valutazione(UUID id, int valutazione) {
        this.id = id;
        this.valutazione = valutazione;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Valutazione that = (Valutazione) o;
        return valutazione == that.valutazione && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valutazione);
    }

    @Override
    public String toString() {
        return "Valutazione{" +
                "id=" + id +
                ", valutazione=" + valutazione +
                '}';
    }
}
