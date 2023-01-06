package com.socialnotes.dao;

import com.socialnotes.model.Commento;

import java.util.List;

public interface CommentoDao {
    List<Commento> getCommentiPost (String idPost);
    boolean setCommento (Commento commento);
    boolean deleteCommento (String idCommento);
    boolean deleteCommentiPost (String idPost);
}
