package com.socialnotes.service;

import com.socialnotes.dao.FilePostDao;
import com.socialnotes.model.FilePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilePostService {

    private final FilePostDao filePostDao;
    @Autowired
    public FilePostService(FilePostDao filePostDao) { this.filePostDao = filePostDao; }

    boolean setFile (FilePost filePost) { return filePostDao.setFile(filePost);}
    void deleteFile (String idFilePost) { filePostDao.deleteFile(idFilePost);}

}
