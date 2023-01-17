package com.socialnotes.dao;

import com.socialnotes.model.*;

import java.util.List;

public interface PostDao {
    List<Post> getAllPost ();
    List<Post> getPostsString(String string);
    List<Post> getPostsValutazione (String valutazione);
    List<Post> getPostsCategoria (String categoria);
    List<Post> getPostsUtente (String nomeUtente);
    //List<Post> getPostsCategoria (Categoria categoria;
    boolean setPost(Post post);
    boolean updatePostValutazione(String idPost, int valutazione, String nomeUtente);
    boolean updatePostSegnalazione (String idPost);
    boolean deletePost (String idPost);

}
