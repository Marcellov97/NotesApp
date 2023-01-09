package com.socialnotes.dao;

import com.socialnotes.model.File;

public interface FileDao {

    boolean setFile (File file);
    boolean deleteFile (String idFilePost);

}
