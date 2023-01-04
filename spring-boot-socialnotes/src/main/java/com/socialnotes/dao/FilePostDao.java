package com.socialnotes.dao;

import com.socialnotes.model.FilePost;

public interface FilePostDao {

    boolean setFile (FilePost filePost);
    void deleteFile (String idFilePost);

}
