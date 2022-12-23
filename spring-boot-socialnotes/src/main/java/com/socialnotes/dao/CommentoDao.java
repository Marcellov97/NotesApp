package com.socialnotes.dao;

import com.socialnotes.model.Commento;

public interface CommentoDao {

    boolean addCommento(Commento commento);

    Commento prelevaCommento();
}
