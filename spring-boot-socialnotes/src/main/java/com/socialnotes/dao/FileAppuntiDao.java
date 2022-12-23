package com.socialnotes.dao;

import com.socialnotes.model.FileAppunti;

public interface FileAppuntiDao {

    boolean addFile(FileAppunti file);

    FileAppunti prelevaFile();
}
