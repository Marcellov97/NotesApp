package com.socialnotes.service;

import com.socialnotes.dao.CommentoDao;
import com.socialnotes.model.Commento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentoService {

    private final CommentoDao commentoDao;

    @Autowired
    public CommentoService(CommentoDao commentoDao) { this.commentoDao = commentoDao; }

    public boolean setCommento (Commento commento) { return commentoDao.setCommento(commento); }
    public boolean deleteCommento (String idCommento) { return commentoDao.deleteCommento(idCommento);}
    public List<Commento> getCommentiPost (String idPost){ return commentoDao.getCommentiPost(idPost);}
    public void deleteCommentiPost (String idPost){ commentoDao.deleteCommentiPost(idPost);}

}
