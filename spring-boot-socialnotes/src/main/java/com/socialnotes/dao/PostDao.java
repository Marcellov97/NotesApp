package com.socialnotes.dao;

import com.socialnotes.model.Post;

public interface PostDao {

    boolean addPost(Post post);

    boolean prelevaPost(); 
}
