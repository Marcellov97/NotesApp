package com.socialnotes.dao;

import com.socialnotes.model.Commento;

import java.util.List;

public interface CommentoDao {
    boolean setCommento (Commento commento);
    boolean deleteCommento (String idCommento);
    List<Commento> getCommentiPost (String idPost);
    void deleteCommentiPost (String idPost);
}
