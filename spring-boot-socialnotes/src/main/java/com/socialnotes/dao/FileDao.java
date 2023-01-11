package com.socialnotes.dao;

import com.socialnotes.model.FilePost;

public interface FileDao {

    boolean setFile (FilePost file);
    boolean deleteFile (String idFilePost);

}
