package com.socialnotes.service;

import com.socialnotes.dao.PostDao;
import com.socialnotes.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {
    private final PostDao postDao;
    @Autowired
    public PostService(@Qualifier("PostDao") PostDao postDao) { this.postDao = postDao; }

    public List<Post> getAllPost () { return postDao.getAllPost(); }
    public List<Post> getPostsString(String string) { return postDao.getPostsString(string); }
    public List<Post> getPostsValutazione (String valutazione) { return postDao.getPostsValutazione(valutazione); }
    public List<Post> getPostsCategoria (String categoria) { return postDao.getPostsCategoria(categoria); }
    public List<Post> getPostsUtente (String nomeUtente) { return postDao.getPostsUtente(nomeUtente); }
    public boolean setPost(Post post) { return postDao.setPost(post); }
    public boolean updatePostValutazione(String idPost, int valutazione, String nomeUtente) {
        return postDao.updatePostValutazione(idPost, valutazione, nomeUtente);
    }
    public boolean updatePostSegnalazione (String idPost){ return postDao.updatePostSegnalazione(idPost); }
    public boolean deletePost (String idPost) { return postDao.deletePost(idPost); }

}
